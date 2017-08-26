angular.module('gdf', [ 'ui.router', 'ui.bootstrap', 'ui.bootstrap.modal' ]);
angular.module('gdf').config(
		function($stateProvider, $urlRouterProvider, $locationProvider) {
			$locationProvider.hashPrefix(""); // don't use !# in URL
			// if not recognized url then do this. might cause problems in the
			// future with ajax requests
			$urlRouterProvider.otherwise("/")
			$stateProvider.state({
				name : 'home',
				url : '/',
				templateUrl: 'landing.html'
			})
			.state({
				name : 'dishTypeCreate',
				url : '/dishTypeCreate',
				templateUrl : 'dish_type_create.html',
				controller : 'dishTypeCreateController'
			})
			.state({
				name : 'dishCreate',
				url : '/dishCreate',
				templateUrl : 'dish_create.html',
				controller : 'dishCreateController'
			})
		});
angular.module('gdf').controller('dishTypeCreateController',
		function($scope, $http, $state, $rootScope){
	$scope.createDishType = function(){
		console.log($scope.newDishType);
		$http({
			method: 'POST',
			url: 'dishType/create',
			data: $scope.newDishType
		}).then(function(value) {
			console.log('Success' + value.data)
		}, function(reason) {
			console.log(reason);
		}, function(value) {
			
		})
	}
});
angular.module('gdf').controller('dishCreateController',
		function($scope, $http, $state, $rootScope){
	$scope.createDish = function(){
		console.log($scope.newDish);
		$http({
			method: 'POST',
			url: 'dish/create',
			data: $scope.newDish
		}).then(function(value) {
		}, function(reason) {
			
		}, function(value) {
			
		})
	}
})