'use strict';

function productComponent() {
  return {
    restrict: 'E',
    templateUrl: 'scripts/product-component/product-component.html',
    controller: 'ProductController',
    controllerAs: 'ctrl',
    bindToController: true
  };
}

function ProductController($scope, ProductService) {
  var ctrl = this;

  ctrl.products = [];
  ctrl.loadingProducts =  ProductService.getProducts()
      .then(function (products) {
        ctrl.products = products;
      })
      .catch(function () {
        ctrl.products = [];
      });

  ctrl.displayProductAddedAlert = false;
  $scope.$on('ngCart:itemAdded', function () {
    ctrl.displayProductAddedAlert = true;
    ctrl.checkoutSucceeded = false;
  });

  ctrl.checkoutSucceeded = false;
  $scope.$on('ngCart:itemRemoved', function () {
    ctrl.displayProductAddedAlert = false;
    ctrl.checkoutSucceeded = true;
  });
}

angular.module('myWebShop')
  .directive('productComponent', productComponent)
  .controller('ProductController', ProductController);
