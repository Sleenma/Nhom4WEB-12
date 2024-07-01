var app = angular.module("myApp",["ngRoute"])
app.config(function($routeProvider){
    $routeProvider
    .when("/dienthoai",{
        templateUrl: "views/index.html",
        controller: "bookCtrl"
    })
    .when("/dienthoai/add",{
        templateUrl: "./views/add.html",
        controller: "addCtrl"
    })
    .when("/dienthoai/edit/:id",{
        templateUrl: "views/update.html",
        controller: "updateCtrl"
    }
    )
    .otherwise({
        redirectTo: "/dienthoai"
    })
})