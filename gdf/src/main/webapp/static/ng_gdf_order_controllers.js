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