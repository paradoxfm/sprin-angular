var zloApp = angular.module("zloApp", ['ngRoute']);

zloApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/contacts', {
                templateUrl: 'views/contactsView',
                controller: 'homeController',
                resolve: function ($http) {
                    $http.get('').success(function (data) {

                    });
                }
            })/*.
         when('/route2', {
         templateUrl: 'angular-route-template-2.jsp',
         controller: 'homeController'
         })*/;
    }]);

zloApp.controller("homeController", function ($scope) {
    $scope.clickAlert = function () {
        alert('aasdasd');
    }
});
