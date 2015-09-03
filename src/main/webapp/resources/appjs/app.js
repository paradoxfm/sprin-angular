var zloApp = angular.module("zloApp", ['ngRoute']);

zloApp.controller("homeController", function ($scope) {
    $scope.clickAlert = function () {
        alert('aasdasd');
    }
});