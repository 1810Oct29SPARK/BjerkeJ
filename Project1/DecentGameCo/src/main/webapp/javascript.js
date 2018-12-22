let employee = {};

window.onload = function(){
	populateEmployee();
}

function populateUser(){
	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/DecentGameCo/session").then(function(response) {
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned 
		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/DecentGameCo/Home";
		} else {
			//define behavior for user returned
			employee = data;
			document.getElementById("employeeId").innerText = "Employee ID: "+employee.employeeId;
			document.getElementById("firstname").innerText = "First name: "+employee.firstname;
			document.getElementById("lastname").innerText = "Last name: "+employee.lastname;
			document.getElementById("email").innerText = "Email: "+employee.email;
		}
	});
	

	
	
}