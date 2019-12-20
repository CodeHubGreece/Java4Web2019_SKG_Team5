if (localStorage.getItem(LOCAL_STORAGE_LOGIN_TOKEN_ROLE)==="CITIZEN") {
    window.location.replace(ROOT_PATH + "/pages/citizen/citizen_index.html");
}else if(localStorage.getItem(LOCAL_STORAGE_LOGIN_TOKEN_ROLE)==="DOCTOR"){
    window.location.replace(ROOT_PATH+"/pages/doctor/doctor_search.html");
}
