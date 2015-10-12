var zloApp = angular.module("zloApp", ['ngRoute']);

zloApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
        when('/contacts', {
            templateUrl: 'views/contactsView',
            controller: 'homeController'/*,
            resolve: function ($http) {
                $http.get('').success(function (data) {

                });
            }*/
        })
        .when('/about', {
            templateUrl: 'views/aboutView',
            controller: 'homeController'
        })
        .when('/', {
            templateUrl: 'views/homeView',
            controller: 'homeController'
        });
}]);

zloApp.config(['$locationProvider', function ($locationProvider) {
    //$locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');
}]);

zloApp.controller("homeController", function ($scope) {
    $scope.clickAlert = function () {
        alert('aasdasd');
    }
});
