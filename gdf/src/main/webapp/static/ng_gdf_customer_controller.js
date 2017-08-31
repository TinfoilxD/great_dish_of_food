angular.module('gdf').controller('customerHomeController',
		function($scope, $http, $state, $rootScope, $document) {
	
		
			
			$document.ready(function() {
				$scope.getAllDishes();
				$scope.getAllDishTypes();
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
			
		});