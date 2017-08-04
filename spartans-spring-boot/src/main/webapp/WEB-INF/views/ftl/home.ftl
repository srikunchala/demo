<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">

<head>
<title>Admin Page123</title>
<link rel="stylesheet" type="text/css" th:href="@{/css/home.css}" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="resources/js/custom/barchart.js"></script>
<script src="resources/js/custom/linechart.js"></script>
<script src="resources/js/custom/drilldownchart.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<style>
.btn-block {
	display: block;
	width: 10%;
}
</style>
</head>

<body>
	<div id="xxx" class="container" ng-app="myApp"
		ng-controller="personCtrl">

		<form th:action="@{/logout}" method="get">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<center>
				<button class="btn btn-md btn-danger btn-block" name="registration"
					type="Submit">Logout</button>
			</center>
		</form>

		<div class="panel-group" style="margin-top: 40px">


			<div class="panel panel-primary">
				<div class="panel-heading">
					<span th:utext="${userName}"></span>
				</div>
				<div class="panel-body">
					<!--  <img src="../static/images/beer.jpg"   width="400" height="400"
						alt="Beer" />  -->
					<button ng-click="toggle()">Monthly Bar Chart</button>
					&nbsp; &nbsp; &nbsp; &nbsp;
					<button ng-click="linetoggle()">Monthly Line Chart</button>
					&nbsp; &nbsp; &nbsp;
					<button ng-click="drillDowntoggle()">Monthly Drill Down
						Column Chart</button>
					&nbsp; &nbsp;
				</div>

				<p class="admin-message-text text-center" th:utext="${adminMessage}"></p>


			</div>
		</div>


		<span>Show/hide charts</span>
		<div id="barcontainer" ng-show="myVar" style="height: 400px"></div>
		<div id="container1" ng-show="myVar1" style="height: 400px"></div>
		<div id="drillcontainer" ng-show="myVar2" style="height: 400px"></div>



		<!-- 
<p ng-show="myVar">
First Name: <input type=text ng-model="firstName"><br>
Last Name: <input type=text ng-model="lastName"><br><br>
Full Name: {{firstName + " " + lastName}}
</p> -->

	</div>

	<script>
		var app = angular.module('myApp', []);
		app.controller('personCtrl', function($scope) {
			$scope.firstName = "John", $scope.lastName = "Doe"
			$scope.myVar = false;
			$scope.myVar1 = false;
			$scope.myVar2 = false;
			$scope.toggle = function() {
				$scope.myVar1 = false;
				$scope.myVar2 = false;
				$scope.myVar = !$scope.myVar;
			};
			$scope.linetoggle = function() {
				$scope.myVar = false;
				$scope.myVar2 = false;
				$scope.myVar1 = !$scope.myVar1;

			};
			$scope.drillDowntoggle = function() {
				$scope.myVar1 = false;
				$scope.myVar = false;
				$scope.myVar2 = !$scope.myVar2;
			};
		});
	</script>

	 

	</div>




</body>
</html>