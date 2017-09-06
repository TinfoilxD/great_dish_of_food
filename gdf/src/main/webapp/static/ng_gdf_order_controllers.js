/**
 * 
 */

angular.module('gdf').controller('orderStatusController',
		function($scope, $http, $state, $document,$rootScope) {
	$document.ready(function() {
		$scope.getAllOrderStatus();
	})
	$scope.getAllOrderStatus = function() {
		$http({
			method : 'GET',
			url : 'orderStatus/all'
		}).then(function(value) {
			$rootScope.allOrderStatus = value.data;
		}, function(reason) {

		}, function(value) {

		})
	}
});

angular.module('gdf').controller('orderTypeContoller',
		function($scope, $http, $state, $document,$rootScope) {
	$document.ready(function() {
		$scope.getAllOrderTypes();
	})
	$scope.getAllOrderTypes = function() {
		$http({
			method : 'GET',
			url : 'orderType/all'
		}).then(function(value) {
			$scope.orderTypeAll = value.data;
		}, function(reason) {

		}, function(value) {

		})
	}
});


angular.module('gdf').controller('updateOrderController',
		function($scope, $http,order,$state, $document,$location,$rootScope,$modalInstance) {

	$scope.orderUpdate = order;
	$scope.allOrderStatus = $rootScope.allOrderStatus;
	
	

	$scope.updateOrder = function(selectedStatus) {
		$scope.orderUpdate.status = selectedStatus;
		console.log("selected " + selectedStatus);
		$http({
			method : 'POST',
			url : 'order/update',
				data: $scope.orderUpdate
		}).then(function(value) {
			$scope.ordersAll = value.data;
			//$location.path('/ordersAll');
			$modalInstance.close();
		}, function(reason) {

		}, function(value) {

		})
	}
	
});

angular.module('gdf').controller('orderAllContoller',
		function($scope, $http, $state, $document,$location,$modal,$rootScope) {
	$document.ready(function() {
		$scope.getAllOrders();
		$scope.getAllOrderStatus();
	})
	console.log("in all controller");
	$scope.getAllOrderStatus = function() {
		$http({
			method : 'GET',
			url : 'orderStatus/all'
		}).then(function(value) {
			$scope.allOrderStatus = value.data;
			$rootScope.allOrderStatus = value.data;
			//console.log($scope.allOrderStatus);
			
		}, function(reason) {

		})
	}
	$scope.getAllOrders = function() {
		$http({
			method : 'GET',
			url : 'order/all'
		}).then(function(value) {
		
			$scope.ordersAll = value.data;
			//console.log("all" + $scope.ordersAll)
		}, function(reason) {

		}, function(value) {

		})
	}
	
	$scope.selectManageSection = function(selectedOrderStatus){
		$scope.selectedOrderStatus = selectedOrderStatus;
		if( $scope.selectedOrderStatus === "Manage Orders"){
			console.log("goin to orderAll");
			$scope.showStatusOrder("All Orders");
		}
		else if($scope.selectedOrderStatus ==="Manage Dishes"){
			console.log("goin to dishAll");
			$state.go("dishAll");
		}
	}
	
	$scope.showStatusDish= function(selectedDishStatus){
		$scope.selectedDishStatus = selectedDishStatus;
		console.log("DishManage: " + selectedDishStatus);
		if($scope.selectedDishStatus === "Create Dish"){
			$state.go("dishCreate");
		}
		else if($scope.selectedDishStatus === "All Dishes"){
			$state.go("dishAll");
		}
	}
	
	
	
	$scope.showStatusOrder = function(selectedOrderStatus){
		console.log(selectedOrderStatus);
		$scope.selectedOrderStatus = selectedOrderStatus;
		if($scope.selectedOrderStatus==="All Orders"){
			$state.go("ordersAll");
		}
		else{
			console.log("im else");
			$scope.status = selectedOrderStatus;
			
				$http({
					method : 'POST',
					url : 'order/allByStatus',
					data : $scope.status 
				}).then(function(value) {
				
					$scope.ordersAll = value.data;
					//console.log("im scoping" + $scope.ordersAll)
					$state.go("ordersAllStatus");
				}, function(reason) {

				}, function(value) {

				})
			
		}
	}
	
	
	$scope.clickOrder = function(order){
			var modelInstance = $modal.open({
				templateUrl : 'order_update.html',
				controller : 'updateOrderController',
				size : 'lg',
				resolve : {
					order : function() {
						return order;
					}
				
				}
			});
			modelInstance.result.then(function(value) {
				//console.log("in" + modelInstance.order.id)
			}, function(reason) {
				
			}, function(value) {
				
			})
		}
		
		
	
	
	//Format Date
	$rootScope.longToDate = function(number){
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
});