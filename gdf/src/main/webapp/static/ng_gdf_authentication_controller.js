angular.module('gdf').controller('loginContainer',
		function($scope, $http, $state) {
			$scope.login = function() {
				console.log("in controller")
				$http({
					method : 'POST',
					url : 'loginAuthentication',
					data : $scope.credentials
				}).then(function(value) {
					loginSuccess(value.data);
				}, function(reason) {
					loginFail();
				})
			}

			loginSuccess = function(user) {
				type = user.type.type;
				if (type === 'Customer') {
					$state.go('customer');
				}
				if (type === 'Employee') {
					$state.go('employeeHome')
				}

			}

			loginFail = function() {
				console.log("failed");
			}
		});
