'use strict';

function ShoppingCartController($scope, ngCart) {
  var ctrl = this;

  ctrl.checkoutSucceeded = false;
  $scope.$on('ngCart:checkout_succeeded', function () {
    ngCart.empty();

    ctrl.checkoutSucceeded = true;
  });

  ctrl.hasItems = ngCart.getTotalUniqueItems();

  $scope.$on('ngCart:change', function () {
    ctrl.hasItems = ngCart.getTotalUniqueItems();
  });
}

angular.module('myWebShop')
  .controller('ShoppingCartController', ShoppingCartController);
