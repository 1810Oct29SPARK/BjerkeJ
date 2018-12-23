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
			document.getElementById("employeeId").innerText = e.employeeId;
			document.getElementById("type").innerText = e.type;
			document.getElementById("description").innerText = e.description 
			document.getElementById("amount").innerText = e.amount;
			document.getElementById("status").innerText = e.status;
		}
	});
}