$(document).ready(function () {
    let url_string = window.location.href;
    let url1 = new URL(url_string);
    let id = url1.searchParams.get("appointmentid");
    //let specialityTitle = url1.searchParams.get("specialityTitle");
    console.log(specialityTitle,id);

    $.ajax({
        url: ROOT_PATH + "/doctor/appointments/" + id
    }).then(function(data) {
        $("input[name=AMKA]").val(data.date);
        $("input[name=Firstname]").val(data.time);
        $("input[name=Lastname]").val(data.time);
        $("input[name=Email]").val(data.time);
        $("input[name=Phone]").val(data.time);
    });

});
