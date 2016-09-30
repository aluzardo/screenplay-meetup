var express = require('express');
var app = express();

function Product(id, name, description, image, price) {
  this.id = id;
  this.name = name;
  this.description = description;
  this.image = image;
  this.price = price;
}

app.get('/products', function (req, res) {
  res.json([
    new Product(1, 'Programming for Testers by Alan Richardson', 'Get out of your comfort zone and improve your Test Automation and programming skills ...', 'logo.svg', 1495),
    new Product(2, 'Testing 3.0', 'Are you ready for testing 3.0?', 'logo.svg', 795),
    new Product(3, 'Testing in AngularJS', 'In this training you will learn about writing and maintainable tests for AngularJS applications.', 'logo.svg', 695),
    new Product(4, 'Behaviour Driven Development with Cucumber', 'This training will help teams understand the true meaning of BDD and how to use Cucumber properly.', 'logo.svg', 695),
    new Product(5, 'Advanced Selenium WebDriver', 'This training will help developers and testers become more advanced in using Selenium WebDriver.', 'logo.svg', 695),
    new Product(6, 'Specification by Example', 'This training helps teams to improve collaboration in all phases of software development.', 'logo.svg', 795),
    new Product(7, 'Test Driven Development (TDD)', 'If you don\'t know how to test it, you have no business building it.', 'logo.svg', 495),
    new Product(8, 'Unit Testing in Visual studio 2013', 'This training will learn you to effectively use Visual Studio 2013 to design, write, and run high-quality .NET unit tests.', 'logo.svg', 1250)
  ])
});

app.post('/checkout', function (req, res) {
  res.sendStatus(200);
});

var server = app.listen(3000, function () {
  console.log('Webshop app listening on port %s', server.address().port);
});
