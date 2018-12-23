let e = {};

window.onload = function(){
	AccountInfo();
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
