let e = {};
let y = {};

window.onload = function(){
	AccountInfo();
	MyReimbursements();
}

function AccountInfo(){
	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/DecentGameCo/AccountInfo").then(function(response) {
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned 
		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/DecentGameCo/Home";
		} else {
			//define behavior for user returned
			e = data;
			document.getElementById("name").innerText = e.firstname + " " + e.lastname;
			document.getElementById("email").innerText = e.email;
			document.getElementById("address").innerText = e.address; 
			document.getElementById("zipcode").innerText = e.zipcode;
			document.getElementById("phone").innerText = e.phone;
			document.getElementById("birthdate").innerText = e.birthdate;
			document.getElementById("hello").innerText = "Hello " +  e.firstname + "!";
		}
	});
}

function MyReimbursements(){
	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/DecentGameCo/MyReimbursements").then(function(response) {
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned 
		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/DecentGameCo/Home";
		} else {
			//define behavior for user returned
			y = data;
			console.log(y);
			for (i = 0; i < y.length; ++i){
				var id = y[i].reimbursementId;
				var type = y[i].type;
				var description = y[i].description;
				var amount = y[i].amount;
				var status = y[i].status;
				var htmlString = "<div class=\"container\" style=\"padding-top: 10px\">" +
				"<div class=\"row\" style=\"padding-top: 5px\">" +
					"<div class=\"col-md-12\">" +
						"<div class=\"card\">" +
							"<div class=\"card-body\">" +
								"<div class=\"row\">" +
									"<div class=\"col-md-12\">" +
									"<form action=\"Approve\" method=\"get\">" +
										"<div class=\"form-group row\">" +
											"<label for=\"reimbursementId\" class=\"col-4 col-form-label\">Reimbursement ID</label>" +
											"<div class=\"col-8\">" +
												"<p name=\"reimbursementId\" id=\"ReimbursementId\">" + id + "</p>" +
											"</div>" +
										"</div>" +
										"<div class=\"form-group row\">" +
											"<label for=\"type\" class=\"col-4 col-form-label\">Type</label>" +
											"<div class=\"col-8\">" +
												"<p name=\"type\" id=\"type\">" + type + "</p>" +
											"</div>" +
										"</div>" +
										"<div class=\"form-group row\">" +
											"<label for=\"Description\" class=\"col-4 col-form-label\">Description</label>" +
											"<div class=\"col-8\">" +
												"<p name=\"description\" id=\"description\">" + description + "</p>" +
											"</div>" +
										"</div>" +
										"<div class=\"form-group row\">" +
											"<label for=\"amount\" class=\"col-4 col-form-label\">Amount</label>" +
											"<div class=\"col-8\">" +
												"<p name=\"amount\" id=\"amount\">" + amount + "</p>" +
											"</div>" +
										"</div>" +
										"<div class=\"form-group row\">" +
											"<label for=\"status\" class=\"col-4 col-form-label\">Status</label>" +
											"<div class=\"col-8\">" +
												"<p name=\"status\" id=\"status\">" + status + "</p>" +
											"</div>" +
										"</div>" +
									"</form>" +
									"</div>" +
								"</div>" +
							"</div>" +
						"</div>" +
					"</div>";
				var Reim = document.getElementById("list");
				$(Reim).prepend(htmlString);
			}
		}
	});
}