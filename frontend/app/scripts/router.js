'use strict';

angular.module('myWebShop')
  .config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');

    $stateProvider
      .state('main', {
        url: '/',
        template: '<product-component></product-component>'
      })
      .state('cart', {
        url: '/cart',
        controller: 'ShoppingCartController',
        controllerAs: 'ctrl',
        templateUrl: 'scripts/shopping-cart/shopping-cart.html'
      });
  });
