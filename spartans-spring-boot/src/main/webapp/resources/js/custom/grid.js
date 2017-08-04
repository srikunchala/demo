var app = angular.module('app', ['ngAnimate','ngTouch', 'ui.grid','ui.grid.selection', 'ui.grid.pagination']);
 
app.controller('MainCtrl', ['$scope','$http','$log','$timeout','uiGridConstants','$templateCache', '$interval', function ($scope,$http,$log,$timeout,$uiGridConstants,$templateCache,$interval) {
	 
	
 $templateCache.put('ui-grid/selectionRowHeaderButtons',
    "<div class=\"ui-grid-selection-row-header-buttons \" ng-class=\"{'ui-grid-row-selected': row.isSelected}\" ><input style=\"margin: 0; vertical-align: middle\" type=\"checkbox\" ng-model=\"row.isSelected\" ng-click=\"row.isSelected=!row.isSelected;selectButtonClick(row, $event)\">&nbsp;</div>"
  );


  $templateCache.put('ui-grid/selectionSelectAllButtons',
    "<div class=\"ui-grid-selection-row-header-buttons \" ng-class=\"{'ui-grid-all-selected': grid.selection.selectAll}\" ng-if=\"grid.options.enableSelectAll\"><input style=\"margin: 0; vertical-align: middle\" type=\"checkbox\" ng-model=\"grid.selection.selectAll\" ng-click=\"grid.selection.selectAll=!grid.selection.selectAll;headerButtonClick($event)\"></div>"
  ); 
  
  
  
 /*   Not required
 $scope.doingAjaxCall = false;

  // Function to be called "on-click"
  $scope.clickConditionHeader = function(checked) {
    // Check for any other conditions you need
	console.log("Checked passed: "+checked);
	
	 console.log("from Header ajax hi");
    return !$scope.doingAjaxCall;
	
  };
  
  // Function to be called "on-click"
  $scope.clickConditionRow = function(checked) {
   
	console.log("from Row ajax hi");
	console.log("Checked passed: "+checked);
    return !$scope.doingAjaxCall;
	
  };
  */
  
/* $scope.columns = [ { name:'Id', field: 'id' }, { name:'First Name', field: 'firstName' }, { name:'Last Name', field: 'lastName' }];  */
  $scope.columns = [ { name: 'studId'  , headerCellClass: $scope.highlightFilteredHeader},
                 { name: 'maths' , headerCellClass: $scope.highlightFilteredHeader },
                 { name: 'physics' },
                 {name: 'chemistry' },
                 {name: 'biology' },
                 {name: 'total' },
                 {name: 'rank' }];
 $scope.gridOptions = {
	enableFiltering: true,
	enableRowSelection: true,
    enableSorting: true,
	selectionRowHeaderWidth: 35,
    rowHeight: 35,
    paginationPageSizes: [5,10,20],
    paginationPageSize: 5,
    columnDefs: $scope.columns
    };
	

$scope.gridOptions.multiSelect = true;

$scope.gridOptions.onRegisterApi = function(gridApi){
      //set gridApi on scope
      $scope.gridApi = gridApi;
	  
	  gridApi.selection.on.rowSelectionChanged($scope, function(row) {
		
		console.log("Row " + row.entity.ID + " selected: " + row.isSelected);
		//Set the header here
       
		});//end single row

      // Multiple row selections
      gridApi.selection.on.rowSelectionChangedBatch($scope, function(rows) {  
	 
        $log.log('Multiples rows toggled');
        $log.log('  Simulating ajax call (batch)...');
        $scope.doingAjaxCall = true;
        $timeout(function() {
          $log.log('  ...done with ajax call (batch)');
          $scope.doingAjaxCall = false;
        }, 10);
      });//end batch selection
    }; //end gridApi register
	


	     
/*$scope.gridOptions.data = [
    {"id":"1","firstName":"John", "lastName":"Joe"},
    {"id":"2","firstName":"Anna", "lastName":"Joe"},
    {"id":"3","firstName":"Peter", "lastName":"Haines"},
     {"id":"4","firstName":"Robert", "lastName":"Jones"},
    {"id":"5","firstName":"Bob", "lastName":"Builder"},
    ];

}] */
    var paginationOptions = {
    	    pageNumber: 1,
    	    pageSize: 25,
    	    sort: null
    	  };
    
    var getPage = function() {
       
        

        $http.get("/employees")
        .success(function (data) {
         
          var firstRow = (paginationOptions.pageNumber - 1) * paginationOptions.pageSize;
          $scope.gridOptions.data = data.slice(firstRow, firstRow + paginationOptions.pageSize);
          
      
          });
     
        

        $scope.toggleFiltering = function(){
          $scope.gridOptions.enableFiltering = !$scope.gridOptions.enableFiltering;
          $scope.gridApi.core.notifyDataChange( uiGridConstants.dataChange.COLUMN );
        };
      };
      getPage();
    
}]);