
angular.module('gdf').controller('loginContainer',
		function($scope, $http, $state) {
			$scope.login = function() {
				console.log("in controller")
				$http({
					method : 'POST',
					url : 'loginAuthentication',
					data : $scope.credentials
				}).then(function(value) {
					console.log(value.data)
				}, function(reason) {
					console.log(reason + " 1");
				})
			}
		});
