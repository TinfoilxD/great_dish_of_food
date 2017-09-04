angular.module('gdf').controller('loginContainer',
		function($scope, $http, $state) {
	
		$scope.loginFail = false;
			$scope.login = function() {
				//console.log("in controller")
				$http({
					method : 'POST',
					url : 'loginAuthentication',
					data : $scope.credentials
				}).then(function(value) {
					loginSuccess(value.data);
				}, function(reason) {
					$scope.loginFail = true;
				})
			}

			loginSuccess = function(user) {
				type = user.type.type;
				if (type === 'Customer') {
					$state.go('customerHome');
				}
				if (type === 'Employee') {
					$state.go('employeeHome')
				}

			}

			loginFail = function() {
				console.log("failed");
			}
		});

angular.module('gdf').controller('registerController', function($scope, $state, $http){
	$scope.register = function(){
		console.log($scope.newUser);
		$http({
			url: 'user/register',
			method: 'post',
			data: $scope.newUser
		}).then(function(value) {
			$state.go('home');
		}, function(reason) {
			
		}, function(value) {
			
		});
	}
})