angular.module('gdf').controller('customerHomeController',
		function($scope, $http, $state, $rootScope, $document) {
	
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
				}, function(reason) {
					
				}, function(value) {
					
				})
			}
		});