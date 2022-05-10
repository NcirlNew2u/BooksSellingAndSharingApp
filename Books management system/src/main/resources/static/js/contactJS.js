//Creating the validation function which checks email.
function validate() {
	var form = document.getElementById("contact-form");
	var email = document.getElementById("email").value;
	var text = document.getElementById("text");
	var pattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
	
	if(email.value == "") {
		form.classList.remove ("valid");
		form.classList.remove ("invalid");
		text.innerHTML = "";
		text.style.color = "black";
	}
	
	if(email.match(pattern)) {
		form.classList.add ("valid");
		form.classList.remove ("invalid");
		text.innerHTML = "Your email address is valid";
		text.style.color = "#00ff00";
	}
	else {
		form.classList.remove ("valid");
		form.classList.add ("valid");
		text.innerHTML = "Please enter valid email address";
		text.style.color = "#ffffff";
		
	}	

}