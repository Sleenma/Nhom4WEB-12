    var app = angular.module("myApp",["ngRoute"])
    app.config(function($routeProvider){
        $routeProvider
        .when("/dienthoai",{
            templateUrl: "views/index.html",
            // controller: "bookCtrl"
        })

        .otherwise({
            redirectTo: "/dienthoai"
        })
    })