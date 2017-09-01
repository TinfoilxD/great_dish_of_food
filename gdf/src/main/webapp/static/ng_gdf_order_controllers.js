/**
 * 
 */

angular.module('gdf').controller('orderStatusController',
		function($scope, $http, $state, $document) {
	$document.ready(function() {
		$scope.getAllOrderStatus();
	})
	$scope.getAllOrderStatus = function() {
		$http({
			method : 'GET',
			url : 'orderStatus/all'
		}).then(function(value) {
			$scope.allOrderStatus = value.data;
		}, function(reason) {

		}, function(value) {

		})
	}
});

angular.module('gdf').controller('orderTypeContoller',
		function($scope, $http, $state, $document) {
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

angular.module('gdf').controller('orderAllContoller',
		function($scope, $http, $state, $document) {
	$document.ready(function() {
		$scope.getAllOrders();
	})
	$scope.getAllOrders = function() {
		$http({
			method : 'GET',
			url : 'order/all'
		}).then(function(value) {
			$scope.ordersAll = value.data;
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
});