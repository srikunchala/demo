var app = angular.module('app', ['ngAnimate','ngTouch', 'ui.grid', 'ui.grid.pagination']);

app.controller('MainCtrl', [
'$scope', '$http', 'uiGridConstants', function($scope, $http, uiGridConstants) {
	  var today = new Date();
	  var nextWeek = new Date();
	  nextWeek.setDate(nextWeek.getDate() + 7);
	 
	  $scope.highlightFilteredHeader = function( row, rowRenderIndex, col, colRenderIndex ) {
	    if( col.filters[0].term ){
	      return 'header-filtered';
	    } else {
	      return '';
	    }
	  };
  var paginationOptions = {
    pageNumber: 1,
    pageSize: 25,
    sort: null
  };

  $scope.gridOptions = {
		  enableFiltering: true,
    paginationPageSizes: [25, 50, 75],
    paginationPageSize: 25,
    useExternalPagination: true,
//    enableRowSelection: true,
//    enableSelectAll: true,
//    selectionRowHeaderWidth: 35,
//    rowHeight: 35,
//    showGridFooter:true,
    columnDefs: [
                 // default
                 //{ name: 'id'  , headerCellClass: $scope.highlightFilteredHeader},
                 { name: 'studId'  , headerCellClass: $scope.highlightFilteredHeader},
                 { name: 'maths' , headerCellClass: $scope.highlightFilteredHeader },
                 { name: 'physics' },
                 {name: 'chemistry' },
                 {name: 'biology' },
                 {name: 'total' },
                 {name: 'rank' }
               
               ],

    onRegisterApi: function(gridApi) {
      $scope.gridApi = gridApi;
      $scope.gridApi.core.on.sortChanged($scope, function(grid, sortColumns) {
        if (sortColumns.length == 0) {
          paginationOptions.sort = null;
        } else {
          paginationOptions.sort = sortColumns[0].sort.direction;
        }
        getPage();
      });
      gridApi.pagination.on.paginationChanged($scope, function (newPage, pageSize) {
        paginationOptions.pageNumber = newPage;
        paginationOptions.pageSize = pageSize;
        getPage();
      });
    }
  };

  var getPage = function() {
    var url;
    switch(paginationOptions.sort) {
      case uiGridConstants.ASC:
        url = 'https://cdn.rawgit.com/angular-ui/ui-grid.info/gh-pages/data/100_ASC.json';
        break;
      case uiGridConstants.DESC:
        url = 'https://cdn.rawgit.com/angular-ui/ui-grid.info/gh-pages/data/100_DESC.json';
        break;
      default:
        url = 'https://cdn.rawgit.com/angular-ui/ui-grid.info/gh-pages/data/100.json';
        break;
    }

    $http.get("/employees")
    .success(function (data) {
      $scope.gridOptions.totalItems = 50;
      var firstRow = (paginationOptions.pageNumber - 1) * paginationOptions.pageSize;
      $scope.gridOptions.data = data.slice(firstRow, firstRow + paginationOptions.pageSize);
      
  
      });
 
    

    $scope.toggleFiltering = function(){
      $scope.gridOptions.enableFiltering = !$scope.gridOptions.enableFiltering;
      $scope.gridApi.core.notifyDataChange( uiGridConstants.dataChange.COLUMN );
    };
  };
  getPage();
}
]);
