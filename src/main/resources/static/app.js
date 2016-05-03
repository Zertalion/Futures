var app = angular.module('FutureApp', ['ngMaterial', 'ngTouch', 'ui.grid', 'ui.grid.pagination', 'ui.grid.selection']);
 
app.controller('salesCtrl', function ($scope, $http, $mdDialog, $mdMedia, $interval) {
  $scope.gridOptions = {
    paginationPageSizes: [25, 50, 75],
    paginationPageSize: 25,
     enableRowSelection: true,
     enableRowHeaderSelection: false,
//      enableRowSelection: true,
//        enableSelectAll: true,
//        selectionRowHeaderWidth: 35,
    columnDefs: [
      { name: 'id' },
      { name: 'lastName' },
      { name: 'firstName' },
      { name: 'department'},
      { name: 'dateOfBirth'}
    ]
  };
  $scope.gridOptions.multiSelect = false;
    $scope.gridOptions.onRegisterApi = function( gridApi ) {
    $scope.gridApi = gridApi;
  };
 
  $http.get('/sales/all')
  .success(function (data) {
    $scope.gridOptions.data = data;
//$timeout(function() {
//        if($scope.gridApi.selection.selectRow){
//          $scope.gridApi.selection.selectRow($scope.gridOptions.data[0]);
//        }
//      });
//$interval( function() {$scope.gridApi.selection.selectRow($scope.gridOptions.data[0]);}, 0, 1);
  });

//  $scope.toggleRowSelection = function() {
//    $scope.gridApi.selection.clearSelectedRows();
//    $scope.gridOptions.enableRowSelection = !$scope.gridOptions.enableRowSelection;
//    $scope.gridApi.core.notifyDataChange( uiGridConstants.dataChange.OPTIONS);
//  };
//      $scope.selectAll = function() {
//        $scope.gridApi.selection.selectAllRows();
//      };
//
//      $scope.clearAll = function() {
//        $scope.gridApi.selection.clearSelectedRows();
//      };
//$scope.info = {};

//   $scope.gridOptions.onRegisterApi = function(gridApi){
//        //set gridApi on scope
//        $scope.gridApi = gridApi;
////        gridApi.selection.on.rowSelectionChanged($scope,function(row){
////          var msg = 'row selected ' + row.isSelected;
////          $log.log(msg);
////        });
////
////        gridApi.selection.on.rowSelectionChangedBatch($scope,function(rows){
////          var msg = 'rows changed ' + rows.length;
////          $log.log(msg);
////        });
//      };


         $scope.gridOptions.multiSelect = false;
         $scope.gridOptions.modifierKeysToMultiSelect = false;
         $scope.gridOptions.noUnselect = true;


  $scope.showAdvanced = function(ev) {
           console.log('Clicked');
            console.log(JSON.stringify($scope.gridApi.selection.getSelectedRows()[0]));
              var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
              $mdDialog.show({
                controller: DialogController,
                templateUrl: 'dialog1.tmpl.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: useFullScreen
              })
              };

                   $scope.sendData = function() {
              var dataObj = {
                  firstName: $scope.firstName,
                  lastName: $scope.lastName,
                  department: $scope.department,
                  dateOfBirth: $scope.dateOfBirth
              };
               var config = {
                  headers : {
                      'Content-Type': 'application/json;'
                  }
              }
              console.log(dataObj);
               $http.post('http://localhost:8080/sales/add', dataObj, config)
              .success(function (data, status, headers, config) {
                  $scope.PostDataResponse = data;
              })
              };

                 function DialogController($scope, $mdDialog) {
    $scope.hide = function() {
      $mdDialog.hide();
    };
    $scope.cancel = function() {
      $mdDialog.cancel();
    };
    $scope.answer = function(answer) {
      $mdDialog.hide(answer);
    };
    }


});

app.controller('clientsCtrl', ['$scope', '$http', '$mdDialog', '$mdMedia' ,function ($scope, $http) {
  $scope.gridOptions = {
    paginationPageSizes: [25, 50, 75],
    paginationPageSize: 25,
    columnDefs: [
      { name: 'id' },
      { name: 'lastName' },
      { name: 'firstName' },
      { name: 'nationality'},
      { name: 'dateOfBirth'}
    ]
  };



  $http.get('/clients/all')
  .success(function (data) {
    $scope.gridOptions.data = data;

  });
}]);

 app.controller('contractCtrl', ['$scope', '$http', '$mdDialog', '$mdMedia' ,function ($scope, $http) {
   $scope.gridOptions = {
     paginationPageSizes: [25, 50, 75],
     paginationPageSize: 25,
     columnDefs: [
       { name: 'id' },
       { name: 'ClientID' },
       { name: 'SalesID' },
       { name: 'creationDate'},
       { name: 'settlementDate'},
       { name: 'usedCurrency'},
       { name: 'boughtCurrency'},
       { name: 'exchangeRate'},
       { name: 'amount'},
       { name: 'price'},
     ]
   };



   $http.get('/contract/all')
   .success(function (data) {
     $scope.gridOptions.data = data;

   });
 }]);
