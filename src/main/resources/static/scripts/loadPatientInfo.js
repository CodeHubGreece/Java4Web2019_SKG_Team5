$(document).ready(function () {
    let url_string = window.location.href;
    let url1 = new URL(url_string);
    let id = url1.searchParams.get("appointmentid");
    //let specialityTitle = url1.searchParams.get("specialityTitle");
    //console.log(specialityTitle,id);

    $.ajax({
        url: ROOT_PATH + "/doctor/appointment/" + id
    }).then(function(data) {
        $("input[name=AMKA]").val(data.citizen.amka);
        $("input[name=FirstName]").val(data.citizen.user.firstname);
        $("input[name=LastName]").val(data.citizen.user.lastname);
        $("input[name=Email]").val(data.citizen.email);
        $("input[name=Phone]").val(data.citizen.mobile);
    });

});
