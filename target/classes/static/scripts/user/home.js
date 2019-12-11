function logout() {
    localStorage.clear();
    window.location.replace(ROOT_PATH + "/index.html")
}

function getBooks(){
    $.ajax({
        url:ROOT_PATH+'/books/1',
        type: 'GET',
        success: function(data){
            alert(data.isbn = ' - '+ data.title);
        },
    })
}