    var app = angular.module("myApp",["ngRoute"])
    app.config(function($routeProvider){
        $routeProvider
        .when("/dienthoai",{
            templateUrl: "../templates/index.html",
        })

        .otherwise({
            redirectTo: "/dienthoai"
        })
    })