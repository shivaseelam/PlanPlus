
'use strict';

/*
angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.user={id:null,username:'',address:'',email:''};
    self.users=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllUsers();

    function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
                function(d) {
                    self.users = d;
                },
                function(errResponse){
                    console.error('Error while fetching Users');
                }
            );
    }

}]);*/
angular.module('ppolApp').controller('CustomerController', function($scope, CustomerService,$log) {
    var self = this;
    self.customer={customerId:null,customerNumber:'',displayName:'',customerCategory:'',firstName:''};
    self.customers=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.sortColumn ="name";
    self.reverseSort = false;
    self.sortData = sortData ;
    self.getSortClass = getSortClass;
    self.rowLimit = 15;


    fetchAllCustomers();

    function fetchAllCustomers(){
        CustomerService.fetchAllCustomers()
            .then(
                function(data) {
                    self.customers = data;
                    $log.info(data);
                },
                function(errResponse){
                    console.error('Error while fetching Users');
                }

            );
    }
    function createCustomer(customer){
        CustomerService.createCustomer(customer)
            .then(
                fetchAllCustomers,
                function(errResponse){
                    console.error('Error while creating customer');
                }
            );
    }
    function updateCustomer(customer, id){
        CustomerService.updateCustomer(customer,id)
            .then(
                fetchAllCustomers,
                function(errResponse){
                    console.error('Error while updating customer');
                }
            );
    }

    function deleteCustomer(id){
        CustomerService.deleteCustomer(id)
            .then(
                fetchAllCustomers,
                function(errResponse){
                    console.error('Error while deleting customer');
                }
            );
    }
    function submit() {
        if(self.customer.customerId===null){
            console.log('Saving New User', self.customer);
            createCustomer(self.customer);
        }else{
            updateCustomer(self.customer, self.customer.customerId);
            console.log('User updated with id ', self.customer.customerId);
        }
        reset();
    }
    function edit(id){
        console.log('id to be edited', id);
        /*for(var i = 0; i < self.customers.length; i++){
         if(self.customers[i].customerId === id) {
         self.customer = angular.copy(self.customers[i]);
         break;
         }
         }*/

        document.location.href = 'http://localhost:8080/edit_customers/id='+id;

    }

    function remove(id){
        console.log('id to be deleted', id);
        if(confirm('Do u Want to Delete a Record[Y/N]')){
        if(self.customer.customerId === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteCustomer(id);
        }
        else
        return false;

    }
    function reset(){
        self.customer={customerId:null,customerNumber:'',displayName:'',customerCategory:'',firstName:''};
        $scope.myForm.$setPristine(); //reset Form
    }

   function sortData (column) {
       console.log("sortData");
       $scope.reverseSort = ($scope.sortColumn == column) ? !$scope.reverseSort : false;
       $scope.sortColumn = column;

   }

    function getSortClass (column) {
        console.log("getSortClass");
        if($scope.sortColumn == column) {
            return $scope.reverseSort ? 'arrow-down' : 'arrow-up';
        }
        return '';

    }





});