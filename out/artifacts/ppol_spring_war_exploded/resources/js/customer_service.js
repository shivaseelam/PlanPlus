
'use strict';

/*
angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/contact/listCustomers/';

    var factory = {
        fetchAllUsers: fetchAllUsers
    };

    return factory;

    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching Users');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }


}]);*/


angular.module('ppolApp').factory('CustomerService', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/contact/listCustomers';
    var CRUD_REST_SERVICE_URI = 'http://localhost:8080/customer/';


    var factory = {
        fetchAllCustomers: fetchAllCustomers,
        createCustomer: createCustomer,
        updateCustomer:updateCustomer,
        deleteCustomer:deleteCustomer
    };

    return factory;

    function fetchAllCustomers() {
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
    function createCustomer(customer) {
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

    function updateCustomer(customer,id) {
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

    function deleteCustomer(id) {
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

});
