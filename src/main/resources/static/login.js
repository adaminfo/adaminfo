// Controller Part
app.controller("LoginController", function($scope, $http) {


    $scope.loginForm = {
        username: "",
        password: ""
    };

    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitLogin = function() {

    	 $http({
             method: 'GET',
             url: '/employees'
         }).then(
             function(res) { // success
                 $scope.employees = res.data;
             },
             function(res) { // error
                 console.log("Error: " + res.status + " : " + res.data);
             }
         );
    };

    function _success(res) {
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.loginForm.username = "";
        $scope.loginForm.password = "";
    };
});