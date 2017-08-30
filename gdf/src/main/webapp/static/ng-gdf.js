angular.module('gdf', [ 'ui.router', 'ui.bootstrap', 'ui.bootstrap.modal' ]);
angular.module('gdf').config(
		function($stateProvider, $urlRouterProvider, $locationProvider) {
			$locationProvider.hashPrefix(""); // don't use !# in URL
			
			// if not recognized url then do this
			$urlRouterProvider.otherwise("/")
			$stateProvider.state({
				name : 'home',
				url : '/',
				templateUrl : 'landing.html'
			}).state({
				name : 'dishTypeCreate',
				url : '/dishTypeCreate',
				templateUrl : 'dish_type_create.html',
				controller : 'dishTypeCreateController'
			}).state({
				name : 'dishTypeAll',
				url : '/dishTypeAll',
				templateUrl : 'dish_type_all.html',
				controller : 'dishTypeAllController'
			}).state({
				name : "dishAll",
				url : "/dishAll",
				templateUrl : "dish_all.html",
				controller : "dishAllController"
			}).state({
				name : 'dishCreate',
				url : '/dishCreate',
				templateUrl : 'dish_create.html',
				controller : 'dishCreateController'
			}).state({
				name : 'dishAddType',
				url : '/dishAddType',
				templateUrl : 'dish_add_type.html',
				controller : 'dishAddTypeController'
			}).state({
				name : 'loginContainer',
				url : '/loginAuthentication',
				templateUrl : 'login.html',
				controller : 'loginContainer'
			}).state({
				name : 'orderStatusAll',
				url : '/orderStatusAll',
				templateUrl : 'orderStatus.html',
				controller : 'orderStatusController'
			})
		});

angular.module('gdf').controller('loginContainer',
		function($scope, $http, $state) {
			$scope.login = function() {
				console.log("in controller")
				$http({
					method : 'POST',
					url : 'loginAuthentication',
					data : $scope.credentials
				}).then(function(value) {
					console.log('Success' + value.data)
				}, function(reason) {
					console.log(reason + " 1");
				})
			}
		});

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

angular.module('gdf').controller('dishTypeCreateController',
		function($scope, $http, $state, $rootScope) {
			$scope.createDishType = function() {
				console.log($scope.newDishType);
				$http({
					method : 'POST',
					url : 'dishType/create',
					data : $scope.newDishType
				}).then(function(value) {
					console.log('Success' + value.data)
				}, function(reason) {
					console.log(reason);
				}, function(value) {

				})
			}
		});
angular.module('gdf').controller('dishTypeAllController',
		function($scope, $http, $state, $document) {
			$document.ready(function() {
				$scope.getAllDishTypes();
			})
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
angular.module('gdf').controller('dishAllController',
		function($scope, $http, $state, $document) {
			$document.ready(function() {
				$scope.getAllDishes();
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
		});
angular.module('gdf').controller('dishCreateController',
		function($scope, $http, $state) {
			$scope.createDish = function() {
				console.log($scope.newDish);
				$http({
					method : 'POST',
					url : 'dish/create',
					data : $scope.newDish
				}).then(function(value) {
				}, function(reason) {

				}, function(value) {

				});
			}
		});
angular.module('gdf').controller('dishAddTypeController',
		function($scope, $http, $document) {
	
	$scope.newCat = {}
	
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
			$scope.newCat.dish = $scope.allDishes[0]; //default value
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
			$scope.newCat.type = $scope.allDishTypes[0]; //default value
		}, function(reason) {

		}, function(value) {

		})
	}
	
	$scope.addTypeToDish = function(){
		$http({
			method : 'POST',
			url : 'dish/addType',
			data : $scope.newCat
		}).then(function(value) {
			
		}, function(reason) {
			
		}, function(value) {
			
		})
	}
	
});