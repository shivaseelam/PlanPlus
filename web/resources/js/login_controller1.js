/**
 * Created by WIN on 5/26/2017.
 */




    angular.module('LoginForm').controller('FormSubmitController', ['$scope','$location', 'AuthenticationService',
    function FormSubmitController($scope,$location, AuthenticationService) {
        $scope.login = login;
        $scope.addEventListener = addEventListener;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            //vm.dataLoading = true;
            console.log($scope.accountname);
            console.log($scope.username);
            console.log($scope.password);
            AuthenticationService.Login($scope.accountname, $scope.username,$scope.password, function (response) {
                if (response) {
                    console.log("login success");

                     $location.path('/Login');
                  //$scope.apply();
                    //AuthenticationService.SetCredentials($scope.accountname,$scope.username, $scope.password);

                   /* $window.addEventListener('message', function(e) {
                        $rootScope.$apply(function() {
                            $location.path('/Login');
                            console.log($location.path());
                            console.log("success");

                        });
                    });*/
                    /*$rootScope.$apply(function() {
                        $location.path("/abc");
                        console.log($location.path());
                        console.log("success");
                    });*/

                } else {

                    console.log("login failed");
                }
            });
        };


}]);
