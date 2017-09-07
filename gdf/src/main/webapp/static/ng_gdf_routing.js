
angular.module('gdf', [ 'ui.router', 'ui.bootstrap', 'ui.bootstrap.modal' ]);
angular.module('gdf').config(
		function($stateProvider, $urlRouterProvider, $locationProvider) {
			$locationProvider.hashPrefix(""); // don't use !# in URL
			
			// if not recognized url then do this
			$urlRouterProvider.otherwise("/")
			$stateProvider.state({
				name : 'home',
				url : '/',
				templateUrl : 'login.html',
				controller : 'loginContainer'
			}).state({
				name: 'register',
				url: '/register',
				templateUrl: 'register.html',
				controller: 'registerController'
			}).state({
				name : 'dishTypeCreate',
				parent: 'employeeHome',
				url : '/dishTypeCreate',
				templateUrl : 'dish_type_create.html',
				controller : 'dishTypeCreateController'
			}).state({
				name : 'dishTypeAll',
				url : '/dishTypeAll',
				parent: 'employeeHome',
				templateUrl : 'dish_type_all.html',
				controller : 'dishTypeAllController'
			}).state({
				name : "dishAll",
				parent: 'employeeHome',
				url : "/dishAll",
				templateUrl : "dish_all.html",
				controller : "dishAllController"
			}).state({
				name : 'dishCreate',
				parent: 'employeeHome',
				url : '/dishCreate',
				templateUrl : 'dish_create.html',
				controller : 'dishCreateController'
			}).state({
				name : 'dishAddType',
				parent: 'employeeHome',
				url : '/dishAddType',
				templateUrl : 'dish_add_type.html',
				controller : 'dishAddTypeController'
			}).state({
				name: 'dishRemoveType',
				parent: 'employeeHome',
				url: '/dishRemoveType',
				templateUrl: 'dish_remove_type.html',
				controller: 'dishRemoveTypeController'
			}).state({
				name : 'loginContainer',
				url : '/loginAuthentication',
				templateUrl : 'login.html',
				controller : 'loginContainer'
			}).state({
				name : 'ordersAllStatus',
				parent: 'employeeHome',
				url : '/ordersAllStatus',
				templateUrl : 'order_all.html'

			}).state({
				name : 'orderTypeAll',
				url : '/orderTypeAll',
				templateUrl : 'orderTypeAll.html',
				controller : 'orderTypeContoller'
			}).state({
				name: 'customer',
				url: '/customer',
				templateUrl: 'customer.html',
				controller: 'customerController'
			}).state({
				name: 'customerHome',
				parent: 'customer',
				url: '/home',
				templateUrl: 'customer_home.html',
				controller: 'customerHomeController'
			}).state({
				name: 'customerOrders',
				parent: 'customer',
				url: '/order',
				templateUrl: 'customer_orders.html',
				controller: 'customerOrdersController'
			}).state({
				name: 'employeeHome',
				url: '/employee_home',
				templateUrl: 'employee_home.html',
					controller: 'orderAllContoller'
			}).state({
				name: 'ordersAll',
				parent: 'employeeHome',
				url: '/ordersAll',
			    controller: 'orderAllContoller',
			    templateUrl: 'order_all.html'
			    	
			    }).state({
					name: 'updateOrder',
					//parent: 'employeeHome',
					url: '/updateOrder',
				    controller: 'updateOrderController',
				    templateUrl: 'order_update.html'
			    })
		
		});