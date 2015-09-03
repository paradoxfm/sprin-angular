<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<html>
<head>
    <link href="./resources/img/favicon.ico" type="image/x-icon" rel="shortcut icon">
    <link href="./resources/img/favicon.ico" type="image/x-icon" rel="icon">
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css"/>
</head>
<body ng-app="zloApp">
<h2>Hello World!</h2>


<div class="container" ng-controller="AppController">
    <div class="page-header">
        <h1>A checklist</h1>
    </div>
    <div class="alert alert-info" role="alert" ng-hide="items && items.length > 0">
        There are no items yet.
    </div>
    <form class="form-horizontal" role="form" ng-submit="addItem(newItem)">
        <div class="form-group" ng-repeat="item in items">
            <div class="checkbox col-xs-9">
                <label>
                    <input type="checkbox" ng-model="item.checked" ng-change="updateItem(item)"/> {{item.description}}
                </label>
            </div>
            <div class="col-xs-3">
                <button class="pull-right btn btn-danger" type="button" title="Delete" ng-click="deleteItem(item)">
                    <span class="glyphicon glyphicon-trash"></span>
                </button>
            </div>
        </div>
        <hr/>
        <div class="input-group">
            <input type="text" class="form-control" ng-model="newItem" placeholder="Enter the description..."/>
          <span class="input-group-btn">
            <button class="btn btn-default" type="submit" ng-disabled="!newItem" title="Add">
                <span class="glyphicon glyphicon-plus"></span>
            </button>
          </span>
        </div>
    </form>
</div>

<script type="text/javascript" src="./resources/js/angular.min.js"></script>
<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>

<script type="text/javascript" src="./resources/appjs/app.js"></script>
<script type="text/javascript" src="./resources/appjs/controllers.js"></script>
<script type="text/javascript" src="./resources/appjs/services.js"></script>
</body>
</html>
