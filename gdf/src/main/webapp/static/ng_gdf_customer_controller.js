angular.module('gdf').controller('customerHomeController',
		function($scope, $http, $state, $rootScope, $document,$modal) {
	
			$scope.hasOrderInSession = false;
			
			
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