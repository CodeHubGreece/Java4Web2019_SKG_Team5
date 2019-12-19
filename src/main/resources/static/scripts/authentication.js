function login(usernameElement, passwordElement) {
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";

	let fd = new FormData();
	fd.append( 'username', username);
	fd.append( 'password', password);

	$.ajax({
	  url: ROOT_PATH + '/login',
	  data: fd,
	  processData: false,
	  contentType: false,
	  type: 'POST',
	  success: function(data){
	  	$.ajax({
			url:ROOT_PATH + "/user",
			success:function(data){
				if(data.property===1){
					localStorage.setItem(LOCAL_STORAGE_LOGIN_TOKEN_NAME, username);
					window.location.replace(ROOT_PATH +"/pages/doctor/doctor_search.html");
				}else{
					localStorage.setItem(LOCAL_STORAGE_LOGIN_TOKEN_NAME, username);
					window.location.replace(ROOT_PATH+"/pages/citizen/citizen_index.html");
				}
			}
		});
		 // localStorage.setItem(LOCAL_STORAGE_LOGIN_TOKEN_NAME, username);
		 // window.location.replace(ROOT_PATH + "/pages/citizen/citizen_index.html");
	  },
	  statusCode: {
		401 : function() {
				alert("Invalid username or password!");
			}
		}
	});
}

function send(){
	window.location.replace(ROOT_PATH+"/register.html");
}

function register(amkaElement,firstnameElement,lastnameElement,usernameElement,passwordElement,emailElement,mobileElement) {
	let amka = amkaElement && amkaElement.value ? amkaElement.value : "";
	let firstname = firstnameElement && firstnameElement.value ? firstnameElement.value : "";
	let lastname = lastnameElement && lastnameElement.value ? lastnameElement.value : "";
	let username = usernameElement && usernameElement.value ? usernameElement.value : "";
	let password = passwordElement && passwordElement.value ? passwordElement.value : "";
	let email = emailElement && emailElement.value ? emailElement.value : "";
	let mobile = mobileElement && mobileElement.value ? mobileElement.value : "";

	$.ajax({
		url: ROOT_PATH + '/register',
		dataType:'json',
		data: JSON.stringify({
			amka:amka,
			firstname:firstname,
			lastname:lastname,
			username:username,
			password:password,
			email:email,
			mobile:mobile
		}) ,
		contentType: 'application/json',
		type: 'POST',
		success: function(){
			window.location.replace(ROOT_PATH + "/login.html");
		},
		statusCode: {
			401 : function() {
				alert("Wrong Registration");
			}
		}
	});
}