


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
					$state.go('dishTypeAll');
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
		function($scope, $http, $state, $document,$modal) {
			$document.ready(function() {
				$scope.getAllDishes();
			})
			$scope.getAllDishes = function() {
				$http({
					method : 'GET',
					url : 'dish/all'
				}).then(function(value) {
					$scope.allDishes = value.data;
					console.log(value);
				}, function(reason) {

				}, function(value) {

				})
			}
			$scope.deleteDish = function(dish){
				$scope.dish= dish;
				$http({
					method : 'POST',
					url : 'dish/remove',
						data : $scope.dish
				}).then(function(value){
					$scope.getAllDishes();
				})
				
				
			}
			
			$scope.clickDish = function(dishType){
				console.log(dishType);
				$scope.dishType = dishType;
				var modelInstance = $modal.open({
					templateUrl : 'dish_type_for_dish.html',
					controller: 'dishTypesForDishModalController',
					size : 'lg',
					resolve : {
						dishType : function() {
							console.log("Resolve" + dishType);
							return dishType;
						}
					
					}
				});
				modelInstance.result.then(function(value) {
					//console.log("in" + modelInstance.order.id)
				}, function(reason) {
					
				}, function(value) {
					
				})
			}

			$scope.selectManageSection = function(selectedOrderStatus){
				$scope.selectedOrderStatus = selectedOrderStatus;
				console.log("Manage: " + selectedOrderStatus);
				if( $scope.selectedOrderStatus === "Manage Orders"){
					$state.go("ordersAll");
				}
				else if($scope.selectedOrderStatus ==="Manage Dishes"){
					console.log("going to dish all");
					$scope.getAllDishes();
				}
			}
			console.log("in dish all cont" );
			
			
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
					$state.go("dishAll");
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
angular.module('gdf').controller('dishRemoveTypeController',function($scope, $http, $document){
	
	$scope.selCat = {}
	
	$document.ready(function(){
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
	$scope.getTypesForDish = function(dish){
		$scope.selCat.dish = dish;
		$http({
			method: 'POST',
			url: 'dish/getTypes',
			data: dish
		}).then(function(value) {
			$scope.selectedDishTypes = value.data;
			console.log($scope.selectedDishTypes);
		}, function(reason) {
			
		}, function(value) {
			
		})
	}
	$scope.removeTypeFromDish = function(type){
		$scope.selCat.type = type;
		$http({
			method: 'POST',
			url: 'dish/removeType',
			data: $scope.selCat
		}).then(function(value) {
			
		}, function(reason) {
			
		}, function(value) {
			
		})
	}
});

angular.module('gdf').controller("dishTypesForDishModalController", function($scope,dishType){
	console.log(dishType);
	$scope.dishType = dishType;
})