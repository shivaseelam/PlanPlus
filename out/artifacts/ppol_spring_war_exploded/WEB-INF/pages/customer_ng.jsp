<%--
  Created by IntelliJ IDEA.
  User: shiva9
  Date: 5/8/2017
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AngularJS $http Example</title>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script>
        var App = angular.module('myApp',[]);
        angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q){

            var REST_SERVICE_URI = 'http://localhost:8080/contact/listCustomers';
            var CRUD_REST_SERVICE_URI = 'http://localhost:8080/customer/';


            var factory = {
                fetchAllUsers: fetchAllUsers,
                createUser: createUser,
                updateUser:updateUser,
                deleteUser:deleteUser
            };

            return factory;

            function fetchAllUsers() {
                var deferred = $q.defer();

                $http.get(REST_SERVICE_URI)
                        .then(
                                function (response) {
                                    deferred.resolve(response.data);
                                    console.log(response.data)
                                },
                                function(errResponse){
                                    console.error('Error while fetching Users');
                                    deferred.reject(errResponse);
                                }
                        );
                return deferred.promise;
            }
            function createUser(customer) {
                var deferred = $q.defer();
                $http.post(CRUD_REST_SERVICE_URI, customer)
                        .then(
                                function (response) {
                                    deferred.resolve(response.data);
                                },
                                function(errResponse){
                                    console.error('Error while creating customer');
                                    deferred.reject(errResponse);
                                }
                        );
                return deferred.promise;
            }

            function updateUser(customer,id) {
                var deferred = $q.defer();
                $http.put(CRUD_REST_SERVICE_URI+id, customer)
                //$http.put(CRUD_REST_SERVICE_URI, customer)
                        .then(
                                function (response) {
                                    deferred.resolve(response.data);
                                },
                                function(errResponse){
                                    console.error('Error while updating customer');
                                    deferred.reject(errResponse);
                                }
                        );
                return deferred.promise;
            }

            function deleteUser(id) {
                var deferred = $q.defer();
                $http.delete(CRUD_REST_SERVICE_URI+id)
                        .then(
                                function (response) {
                                    deferred.resolve(response.data);
                                },
                                function(errResponse){
                                    console.error('Error while deleting customer');
                                    deferred.reject(errResponse);
                                }
                        );
                return deferred.promise;
            }

        }]);

        angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
            var self = this;
            self.customer={customerId:null,customerNumber:'',displayName:'',customerCategory:'',firstName:''};
            self.customers=[];

            self.submit = submit;
            self.edit = edit;
            self.remove = remove;
            self.reset = reset;



            fetchAllUsers();

            function fetchAllUsers(){
                UserService.fetchAllUsers()
                        .then(
                                function(d) {
                                    self.customers = d;
                                },
                                function(errResponse){
                                    console.error('Error while fetching Users');
                                }
                        );
            }
            function createUser(customer){
                UserService.createUser(customer)
                        .then(
                                fetchAllUsers,
                                function(errResponse){
                                    console.error('Error while creating customer');
                                }
                        );
            }
            function updateUser(customer, id){
                UserService.updateUser(customer,id)
                        .then(
                                fetchAllUsers,
                                function(errResponse){
                                    console.error('Error while updating customer');
                                }
                        );
            }

            function deleteUser(id){
                UserService.deleteUser(id)
                        .then(
                                fetchAllUsers,
                                function(errResponse){
                                    console.error('Error while deleting customer');
                                }
                        );
            }
            function submit() {
                if(self.customer.customerId===null){
                    console.log('Saving New User', self.customer);
                    createUser(self.customer);
                }else{
                    updateUser(self.customer, self.customer.customerId);
                    console.log('User updated with id ', self.customer.customerId);
                }
                reset();
            }
            function edit(id){
                console.log('id to be edited', id);
                for(var i = 0; i < self.customers.length; i++){
                    if(self.customers[i].customerId === id) {
                        self.customer = angular.copy(self.customers[i]);
                        break;
                    }
                }
            }

            function remove(id){
                console.log('id to be deleted', id);
                if(self.customer.customerId === id) {//clean form if the user to be deleted is shown there.
                    reset();
                }
                deleteUser(id);
            }
            function reset(){
                self.customer={customerId:null,customerNumber:'',displayName:'',customerCategory:'',firstName:''};
                $scope.myForm.$setPristine(); //reset Form
            }
        }]);

    </script>
    <style>
        .username.ng-valid {
            background-color: lightgreen;
        }
        .username.ng-dirty.ng-invalid-required {
            background-color: red;
        }
        .username.ng-dirty.ng-invalid-minlength {
            background-color: yellow;
        }

        .email.ng-valid {
            background-color: lightgreen;
        }
        .email.ng-dirty.ng-invalid-required {
            background-color: red;
        }
        .email.ng-dirty.ng-invalid-email {
            background-color: yellow;
        }

    </style>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <spring:url value="resources/css/app.css" var="appCss" />
    <link href="${appCss}" rel="stylesheet" />
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="UserController as ctrl">
    <div class="generic-container" ng-controller="UserController as ctrl">
        <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">User Registration Form </span></div>
            <div class="formcontainer">
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.customer.customerId" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="displayName">DisplayName</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.customer.displayName" id="displayName" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                    <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                    <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="firstName">FirstName</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.customer.firstName" id="firstName" class="form-control input-sm" placeholder="Enter your FirstName. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="customerCategory">CustomerCategory</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.customer.customerCategory" id="customerCategory" class="form-control input-sm" placeholder="Enter your CustomerCategory. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="customerNumber">CustomerNumber</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.customer.customerNumber" id="customerNumber" class="email form-control input-sm" placeholder="Enter your CustomerNumber" required/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.email.$error.required">This is a required field</span>
                                    <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.customer.customerId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of customer </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>CustomerID</th>
                    <th>CustomerNumber</th>
                    <th>DisplayName</th>
                    <th>CustomerCategory</th>
                    <th>FirstName</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.customers">
                    <td><span ng-bind="u.customerId"></span></td>
                    <td><span ng-bind="u.customerNumber"></span></td>
                    <td><span ng-bind="u.displayName"></span></td>
                    <td><span ng-bind="u.customerCategory"></span></td>
                    <td><span ng-bind="u.firstName"></span></td>
                    <td>
                        <button type="button" ng-click="ctrl.edit(u.customerId)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.customerId)" class="btn btn-danger custom-width">Remove</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%--<spring:url value="resources/js/app.js"     var="appJs" />
<script src="${appJs}"></script>
<spring:url value="resources/js/user_service.js"     var="userserviceJs" />
<script src="${userserviceJs}"></script>
<spring:url value="resources/js/user_controller.js"     var="usercontrollerJs" />
<script src="${usercontrollerJs}"></script>--%>
</body>
</html>
