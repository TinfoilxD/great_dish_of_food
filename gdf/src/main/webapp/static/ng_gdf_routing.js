/**
 * 
 */

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
			}).state({
				name : 'orderTypeAll',
				url : '/orderTypeAll',
				templateUrl : 'orderTypeAll.html',
				controller : 'orderTypeContoller'
			})
		});