let e = {};

window.onload = function(){
	ReimbursementInfo();
}

function ReimbursementInfo(){
	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/DecentGameCo/ReimbursementList").then(function(response) {
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
			for (i = 0; i < e.length; ++i){
				var id = e[i].reimbursementId;
				var employeeId = e[i].employeeId;
				var type = e[i].type;
				var description = e[i].description;
				var amount = e[i].amount;
				var status = e[i].status;
				console.log(e[i]);
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
											"<label for=\"employeeId\" class=\"col-4 col-form-label\">Employee ID</label>" +
											"<div class=\"col-8\">" +
												"<p name=\"employeeId\" id=\"employeeId\">" + employeeId + "</p>" +
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
										"<div class=\"form-group row\">" +
											"<div class=\"offset-4 col-8\">" +
												"<button name=\"approve\" type=\"submit\" class=\"btn btn-primary\">Approve</button>" +
												"<button name=\"deny\" type=\"submit\" class=\"btn btn-primary\">Deny</button>" +
											"</div>" +
										"</div>" +
									"</form>" +
									"</div>" +
								"</div>" +
							"</div>" +
						"</div>" +
					"</div>";
				var Reim = document.getElementById("Reimburse");
				$(Reim).prepend(htmlString);
			}
		}
	});
}