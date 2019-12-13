function logout() {
    localStorage.clear();
    window.location.replace(ROOT_PATH + "/login.html")
}