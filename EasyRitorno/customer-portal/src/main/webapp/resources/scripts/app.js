var app = angular.module('easyRitornoApp', [ ]);

//@author Anushri Srinath Aithal
app.controller("listorderCtrl", function($scope, $http) {
	var init = function() {
		$scope.customerId = sessionStorage.getItem('customer_id');
		if(!$scope.customerId) {
			window.location.href = '/customer/';
		}
		getOrderList();
	};
	var getOrderList = function() {
		var req = {
			params : {
				'customerId' : $scope.customerId
			},
			method : 'GET',
			url : "/customer/getOrders",
			headers : {
				'Content-Type' : "application/json"
			}
		}
		$http(req).then(function(response) {
			$scope.orders = response.data;
			$scope.isDataPresent = true;
		}, function(error) {
			$scope.isDataPresent = false;
		});
	};
	init();
});


//@author Anushri Srinath Aithal
app.controller("homeCtrl",['$scope', '$http',
	function($scope, $http, $location) {
	
	var init = function() {
		$scope.email = sessionStorage.getItem('userEmail');
		if(!$scope.email){
			window.location.href = '/customer/';
		}
		getCustomerDetails();
	};
	
	var getCustomerDetails = function() {
		var req = {
					params : {
						email : $scope.email
					},
					method : 'GET',
					url : "/customer/get/customer",
					headers : {
						'Content-Type' : "application/json"
					}
				}
		$http(req).then(function(response){
			if(response.data.id) {
				sessionStorage.setItem('customer_id',response.data.id);
				window.location.href = '/resources/views/listorder.jsp';
			}
		},function(error){
			$scope.showErrorAlert = true;
			$scope.errorTextAlert = error.data.message;
		});
	};
	
	$scope.switchBool = function (value) {
        $scope[value] = !$scope[value];
    };
    
		/**
	 * @author Anuradha Rajashekar
	 */
    $scope.createCustomer = function() {
		var req = {
					data : {
						'firstName' : $scope.firstname,
						'lastName' : $scope.lastname,
						'address' : $scope.address,
						'city' : $scope.city,
						'phone' : $scope.contactno,
						'email' : $scope.email
					},
					method : 'POST',
					url : "/customer/add/customer",
					headers : {
						'Content-Type' : "application/json"
					}
				}
		$http(req).then(function(response){
			sessionStorage.setItem('customer_id',response.data.id);
			window.location.href = '/resources/views/listorder.jsp';
		},function(error){
			$scope.showErrorAlert = true;
			$scope.errorTextAlert = error.data.message;
		});
    };
	init();
	
}]);

//@author Ashwini Shankar Narayan
//Create Orders 
app.controller("ordersCtrl", ['$scope', '$http',
	function($scope, $http) {
	

		var init = function() {
		$scope.customerId = sessionStorage.getItem('customer_id');
		if (!$scope.customerId) {
			window.location.href = '/customer/';
		}
	}

	$scope.items = [ {
		name : 'Customer Packaging',
		totalCost : 10
	}, {
		name : 'Letter',
		totalCost : 20
	}, {
		name : 'Box-Small',
		totalCost : 25
	}, {
		name : 'Box-Medium',
		totalCost : 30
	}, {
		name : 'Box-Large',
		totalCost : 45
	} ];

	$scope.selectedItem = $scope.items[1]

	$scope.submitOrder = function() {
		var req = {
			method : 'POST',
			url : "/customer/submitOrder",
			headers : {
				'Content-Type' : "application/json"
			},
			data : {
				// Customer ID
				custId : $scope.customerId,
				packType : $scope.selectedItem.name,
				declValue : $scope.declValue,
				custAdr : $scope.custAdr,
				pickTime : $scope.pickTime,
				shippingAdr : $scope.shippingAdr,
				shippingTime : $scope.shippingTime,
				totalCost : $scope.selectedItem.totalCost,
			// order status
			}
		}

		$http(req).then(function(response) {
			//$scope.customer1 = response.data;
			$scope.showSuccessAlert = true;
			$scope.successTextAlert = "Successfull";
		}, function(error) {
			$scope.showErrorAlert = true;
			$scope.errorTextAlert = "Failed";
		});
	};
	$scope.switchBool = function(value) {
		$scope[value] = !$scope[value];
	};

	init();
	} ]);

