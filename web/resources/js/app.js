
'use strict';

/*var App = angular.module("ppolApp",[]);*/

//var app = angular.module('LoginForm',['ngMaterial','ngAnimate','ngAria','ngMessages']);

var  loginApp =angular.module('LoginForm', ['ngRoute','ngMaterial','ngAnimate','ngAria','ngMessages']);



loginApp.config( function($routeProvider,$locationProvider) {
         $locationProvider.html5Mode(true);
        $routeProvider
            .when('/Login',{

                templateUrl: '/html/error.html'

            },function(){console.log("routes")})
        /*.otherwise({ redirectTo: '/html/error.html' });*/
   /* $locationProvider.html5Mode({
        enabled: true,

    });*/
        console.log("logins");
    });





