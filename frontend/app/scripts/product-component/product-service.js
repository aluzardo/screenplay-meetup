angular.module('myWebShop')
  .factory('ProductService', function ($http) {
    return {
      getProducts: getProducts,
      getProductDetail: getProductDetail
    };

    function getProducts() {
      return $http.get('/api/products').then(function (response) {
          return response.data;
      });
    }

    function getProductDetail(productId) {
      return $http.get('/api/products/' + productId + '/').then(function (response) {
        return response.data;
      })
      .catch(function () {
        return { errorMsg: 'Failed to load product details' }
      });
    }
  });
