angular.module('gdf', [ 'ui.router', 'ui.bootstrap', 'ui.bootstrap.modal' ]);
angular.module('gdf').config(
		function($stateProvider, $urlRouterProvider, $locationProvider) {
			$locationProvider.hashPrefix(""); // don't use !# in URL
			// if not recognized url then do this. might cause problems in the
			// future with ajax requests
			$urlRouterProvider.otherwise("/")
			$stateProvider.state({
				name : 'dishType',
				url : '/',
				templateUrl : 'dish_type.html',
				controller : 'dishTypeController'
			})
		});
angular.module('gdf').controller('dishTypeController',
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
})