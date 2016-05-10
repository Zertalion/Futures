var app = angular.module('FutureApp', ['ngMaterial', 'ngTouch', 'ui.grid', 'ui.grid.pagination', 'ui.grid.selection', 'ngAnimate']);
 
app.controller('salesCtrl', function ($scope, $http, $mdDialog, $mdMedia, $interval) {
  $scope.gridOptions = {
    paginationPageSizes: [25, 50, 75],
    paginationPageSize: 25,
     enableRowSelection: true,
     enableRowHeaderSelection: false,
     multiSelect : false,
     modifierKeysToMultiSelect : false,
     noUnselect : false,
     enableFiltering: true,

    columnDefs: [
      { name: 'id' , headerCellClass: $scope.highlightFilteredHeader},
      { name: 'lastName' , headerCellClass: $scope.highlightFilteredHeader},
      { name: 'firstName' , headerCellClass: $scope.highlightFilteredHeader},
      { name: 'department', headerCellClass: $scope.highlightFilteredHeader},
      { name: 'dateOfBirth', headerCellClass: $scope.highlightFilteredHeader, cellFilter: 'date:"MM/dd/yyyy"'}
    ]
  };

    $scope.gridOptions.onRegisterApi = function( gridApi ) {
    $scope.gridApi = gridApi;
    gridApi.selection.on.rowSelectionChanged($scope,function(row){
    console.log("Get selected rows", gridApi.selection.getSelectedRows())
    $scope.sales = {} ;
        $scope.sales.department = gridApi.selection.getSelectedRows()[0].department;
        console.log("rowSelectionChanged $scope", $scope)
     });
  };

  $scope.highlightFilteredHeader = function( row, rowRenderIndex, col, colRenderIndex ) {
      if( col.filters[0].term ){
        return 'header-filtered';
      } else {
        return '';
      }
    };
 
  $http.get('/sales/all')
  .success(function (data) {
    $scope.gridOptions.data = data;

  });


  $scope.salesAdd = function(ev) {
           console.log('Clicked');
            console.log(JSON.stringify($scope.gridApi.selection.getSelectedRows()[0]));
              var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
              $mdDialog.show({
                controller: DialogController,
                templateUrl: 'salesAdd.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: useFullScreen
              })
              };

              $scope.salesDelete = function(ev) {
                         console.log('Clicked');

                            var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
                            $mdDialog.show({
                              controller: DialogController,
                              templateUrl: 'salesDelete.html',
                              parent: angular.element(document.body),
                              targetEvent: ev,
                              scope: $scope.$new(),
                              clickOutsideToClose:true,
                              fullscreen: useFullScreen
                            })
                            };

                             $scope.salesUpdate = function(ev) {

                                  console.log('Clicked scope', $scope);

                               var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
                                   $mdDialog.show({
                                   controller: DialogController,
                                   templateUrl: 'salesUpdate.html',
                                   parent: angular.element(document.body),
                                   targetEvent: ev,
                                   scope: $scope,
                                   preserveScope: true,
                                   clickOutsideToClose:true,
                                   fullscreen: useFullScreen
                                   })
                                   };

                   $scope.sendAdd = function() {
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

                   $scope.sendDel = function() {
                   console.log('DELETE---- '+$scope.gridApi.selection.getSelectedRows()[0].id);
                            var dataObj = {
                                id:$scope.gridApi.selection.getSelectedRows()[0].id
                            };
                             var config = {
                                headers : {
                                    'Content-Type': 'application/json;'
                                }
                            }

                            console.log(dataObj);
                             $http.post('http://localhost:8080/sales/del?id='+$scope.gridApi.selection.getSelectedRows()[0].id, dataObj, config)
                            .success(function (data, status, headers, config) {
                                $scope.PostDataResponse = data;
                            })
                            };

                                  $scope.sendUpdate = function() {

                                           console.log("Sending update scope", $scope)

                                          var dataObj = {
                                              id:$scope.gridApi.selection.getSelectedRows()[0].id,
                                             department: $scope.sales.department,
                                             dateOfBirth: $scope.sales.dateOfBirth
                                          };
                                           var config = {
                                              headers : {
                                                  'Content-Type': 'application/json;'
                                              }
                                          }
                                          console.log(dataObj);
                                           $http.post('http://localhost:8080/sales/up', dataObj, config)
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

app.controller('clientsCtrl',  function ($scope, $http, $mdDialog, $mdMedia, $interval) {
  $scope.gridOptions = {
    paginationPageSizes: [25, 50, 75],
    paginationPageSize: 25,
        enableRowSelection: true,
         enableRowHeaderSelection: false,
         multiSelect : false,
         modifierKeysToMultiSelect : false,
         noUnselect : false,
         enableFiltering: true,
    columnDefs: [
      { name: 'id' , headerCellClass: $scope.highlightFilteredHeader},
      { name: 'lastName' , headerCellClass: $scope.highlightFilteredHeader},
      { name: 'firstName' , headerCellClass: $scope.highlightFilteredHeader},
      { name: 'nationality' , headerCellClass: $scope.highlightFilteredHeader},
      { name: 'dateOfBirth' , headerCellClass: $scope.highlightFilteredHeader ,cellFilter: 'date:"MM/dd/yyyy"'}
    ]
  };

  $http.get('/clients/all')
  .success(function (data) {
    $scope.gridOptions.data = data;

  });
 $scope.gridOptions.onRegisterApi = function( gridApi ) {
    $scope.gridApi = gridApi;
    $scope.clients = {} ;
  };

  $scope.highlightFilteredHeader = function( row, rowRenderIndex, col, colRenderIndex ) {
      if( col.filters[0].term ){
        return 'header-filtered';
      } else {
        return '';
      }
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

 $scope.clientsAdd = function(ev) {
           console.log('Clicked');
            console.log(JSON.stringify($scope.gridApi.selection.getSelectedRows()[0]));
              var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
              $mdDialog.show({
                controller: DialogController,
                templateUrl: 'clientsAdd.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: useFullScreen
              })
              };
     $scope.sendClAdd = function() {
              var dataObj = {
                  firstName: $scope.firstName,
                  lastName: $scope.lastName,
                  nationality: $scope.nationality,
                  dateOfBirth: $scope.dateOfBirth
              };
               var config = {
                  headers : {
                      'Content-Type': 'application/json;'
                  }
              }
              console.log(dataObj);
               $http.post('http://localhost:8080/clients/add', dataObj, config)
              .success(function (data, status, headers, config) {
                  $scope.PostDataResponse = data;
              })
              };

                 $scope.clientsDelete = function(ev) {
                                       console.log('Clicked');

                                          var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
                                          $mdDialog.show({
                                            controller: DialogController,
                                            templateUrl: 'clientsDelete.html',
                                            parent: angular.element(document.body),
                                            targetEvent: ev,
                                            scope: $scope.$new(),
                                            clickOutsideToClose:true,
                                            fullscreen: useFullScreen
                                          })
                                          };

               $scope.sendClDel = function() {
                                 console.log('DELETE---- '+$scope.gridApi.selection.getSelectedRows()[0].id);
                                          var dataObj = {
                                              id:$scope.gridApi.selection.getSelectedRows()[0].id
                                          };
                                           var config = {
                                              headers : {
                                                  'Content-Type': 'application/json;'
                                              }
                                          }

                                          console.log(dataObj);
                                           $http.post('http://localhost:8080/clients/del?id='+$scope.gridApi.selection.getSelectedRows()[0].id, dataObj, config)
                                          .success(function (data, status, headers, config) {
                                              $scope.PostDataResponse = data;
                                          })
                                          };
                $scope.clientsUpdate = function(ev) {

                                                 console.log('Clicked');

                                              var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
                                                  $mdDialog.show({
                                                  controller: DialogController,
                                                  templateUrl: 'clientsUpdate.html',
                                                  parent: angular.element(document.body),
                                                  targetEvent: ev,
                                                  scope: $scope,
                                                  preserveScope: true,
                                                  clickOutsideToClose:true,
                                                  fullscreen: useFullScreen
                                                  })
                                                  };
                $scope.sendClUpdate = function() {

                                                          var dataObj = {
                                                              id:$scope.gridApi.selection.getSelectedRows()[0].id,
                                                              dateOfBirth: $scope.clients.dateOfBirth
                                                          };
                                                           var config = {
                                                              headers : {
                                                                  'Content-Type': 'application/json;'
                                                              }
                                                          }
                                                          console.log(dataObj);
                                                           $http.post('http://localhost:8080/clients/up', dataObj, config)
                                                          .success(function (data, status, headers, config) {
                                                              $scope.PostDataResponse = data;
                                                          })
                                                          };
});

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
