/**
 * Created by WIN on 5/26/2017.
 */




angular.module('LoginForm').factory('AuthenticationService',['$http', '$rootScope' ,function AuthenticationService($http, $rootScope) {
        var service = {};

        service.Login = Login;
        service.SetCredentials = SetCredentials;
        service.ClearCredentials = ClearCredentials;

        return service;

        function Login(accountname,username, password, callback) {


            /* Use this for real authentication
             ----------------------------------------------*/
           $http.post('/html/submitform', { accountname:accountname,username: username, password: password })
                .success(function (response) {
                    console.log("success "+response);
                    callback(response);

                });

        }

        function SetCredentials(accountname,username, password) {

            console.log("set credentials");
            $rootScope.globals = {
                currentUser: {
                    accountname:accountname,
                    username: username,
                    password: password
                }
            };


            // store user details in globals cookie that keeps user logged in for 1 week (or until they logout)
            var cookieExp = new Date();
            cookieExp.setDate(cookieExp.getDate() + 7);
            /*$cookies.putObject('globals', $rootScope.globals, { expires: cookieExp });*/
        }

        function ClearCredentials() {
            $rootScope.globals = {};
            /*$cookies.remove('globals');*/
            $http.defaults.headers.common.Authorization = 'Basic';
        }




}]);
