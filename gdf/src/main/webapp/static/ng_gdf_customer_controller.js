angular.module('gdf').controller('customerController',function($scope, $http, $state){
	console.log('clicky');
	$scope.logout = function(){
		$http({
			url: 'logout',
			method: 'post'
		}).then(function(value) {
			$state.go('home');
		}, function(reason) {
			
		}, function(value) {
			
		});
	}
});

angular.module('gdf').controller('customerHomeController',
		function($scope, $http, $state, $rootScope, $document,$modal) {
	
			$scope.hasOrderInSession = false;
			$scope.filterDishType = {
					id: 0,
					type: 'Select All'
			}
			
			$document.ready(function() {
				$scope.getAllDishes();
				$scope.getAllDishTypes();
				$scope.getOrderInSession();
			})
			$scope.getAllDishes = function() {
				$http({
					method : 'GET',
					url : 'dish/all'
				}).then(function(value) {
					$scope.allDishes = value.data;
					console.log($scope.allDishes);
				}, function(reason) {

				}, function(value) {

				})
			}
			$scope.getAllDishTypes = function() {
				$http({
					method : 'GET',
					url : 'dishType/all'
				}).then(function(value) {
					$scope.allDishTypes = value.data;
					$scope.allDishTypes.unshift($scope.filterDishType);

				}, function(reason) {

				}, function(value) {

				})
			}
			$scope.getOrderInSession = function(){
				$http({
					method: 'GET',
					url: 'order/inSession'
				}).then(function(value) {
					if(value.data){
						$scope.hasOrderInSession = true;
					}else{
						$scope.hasOrderInSession = false;
					}
					$scope.orderLines = value.data.orderLines;
					console.log(value.data);
				}, function(reason) {
					
				}, function(value) {
					
				})
			}
			$scope.createOrderInSession = function(){
				$http({
					method: 'POST',
					url: 'order/putSession'
				}).then(function(value) {
					$scope.hasOrderInSession = true;
				}, function(reason) {
					
				}, function(value) {
					
				})
			}
			$scope.removeOrderFromSession = function(){
				$http({
					method: 'POST',
					url: 'order/removeSession'
				}).then(function(value) {
					$scope.hasOrderInSession = false;
					$scope.orderLines = null;
				}, function(reason) {
					
				}, function(value) {
					
				})
			}
			$scope.commitOrderInSession = function(){
				$http({
					method: 'POST',
					url: 'order/commitSession'
				}).then(function(value) {
					console.log(value);
					$scope.hasOrderInSession = false;
					$scope.orderLines = false;
				}, function(reason) {
					
				}, function(value) {
					
				})
			}
			
			$scope.openAddItem = function(dish) {
				var modalInstance = $modal.open({
					templateUrl : 'customer_add_item.html',
					controller : 'customerAddItemController',
					size : 'sm',
					resolve : {
						dish : function() {
							return dish;
						}
					}
				});
				modalInstance.result.then(function(value) {
					$scope.getOrderInSession();
				}, function(reason) {
					$scope.getOrderInSession();
				}, function(value) {
					
				})
			}
			
		$scope.filterDishByType = function(dish){
			if ($scope.filterDishType.type === 'Select All'){
				return true;
			}
			for(var i = 0; i< dish.types.length; i++){
				type = dish.types[i];
				if($scope.filterDishType.type === type.type){
					return true;
				}
			}
			return false;
		}
			
		});
angular.module('gdf').controller('customerAddItemController', function($scope, dish, $http, $modalInstance){
	
	$scope.modalDish = dish;
	$scope.newCartItem = {};
	
	$scope.addItemToCart = function(){
		
		$scope.newCartItem.dish = dish;
		$http({
			method: 'POST',
			url: 'order/addItem',
			data: $scope.newCartItem
		}).then(function(value) {
			$modalInstance.close();
		}, function(reason) {
			
		}, function(value) {
			
		})
	}
});

angular.module('gdf').controller('customerOrdersController',function($scope, $http, $document){
	$document.ready(function(){
		$scope.getAllOrders();
	});
	$scope.getAllOrders = function() {
		$http({
			method : 'GET',
			url : 'order/allOrdersWithItems'
		}).then(function(value) {
			$scope.allOrders = value.data;
			console.log(value.data);
		}, function(reason) {

		}, function(value) {

		})
	}
	//Format Date
	$scope.longToDate = function(number){
		if(number===null){
			return "Not Resolved"
		}
		else{
			var date = new Date(number)
			var year = date.getFullYear();
			var month = date.getMonth();
			var day = date.getDate();
			var hours = date.getHours() > 12 ? date.getHours() - 12 : date.getHours();
	        var am_pm = date.getHours() >= 12 ? "PM" : "AM";
	        hours = hours < 10 ? "0" + hours : hours;
	        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
	        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
			var date = month + "/" + day + "/" + year + " "+ hours + ":" + minutes + ":" +seconds+ " " +am_pm;
			
		return date;
		}
	}
})