/**
 * Created by WIN on 5/17/2017.
 */

'use strict';

/*login.controller('FormSubmitController', function($scope, $http) {

    $scope.vm = {

    };
});*/


    app.controller('FormSubmitController', function($scope,$http){
        $scope.submitform = submitform;


        function submitform()
        {
            console.log("submit")

               var formData={
                        accountname: $scope.accountname,
                        username : $scope.username,
                        password : $scope.password
                };

        console.log(formData);

            var response = $http.post("submitform",formData);
            response.success(function (data,status,headers,config) {
                console.log(data+""+status);
            });
            response.error(function (data,status,headers,config) {
                console.log("error");
            })

        }

    });

