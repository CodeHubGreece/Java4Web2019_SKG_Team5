function logout() {
    localStorage.removeItem(LOCAL_STORAGE_LOGIN_TOKEN_ID);
    localStorage.removeItem(LOCAL_STORAGE_LOGIN_TOKEN_NAME);
    localStorage.removeItem(LOCAL_STORAGE_LOGIN_TOKEN_ROLE);
    window.location.replace(ROOT_PATH+"/login.html");

}