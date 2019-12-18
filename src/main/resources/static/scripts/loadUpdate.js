$( document ).ready(function() {
    // var url_string = ROOT_PATH + "/pages/citizen/update_appointment.html?appointmentid="+id; //window.location.href
    // var url = new URL(url_string);
    // var c = url.searchParams.get("appointmentid");
    // console.log(c);
    var url_string = window.location.href;
    var url = new URL(url_string);
    var id = url.searchParams.get("appointmentid");
    console.log(id);
    $.ajax({
        url: ROOT_PATH + "/citizen/appointments/" + id
    }).then(function(data) {
        $("option[name=specialty]").val(data.id);
        $("option[name=doctor]").val(data.doctor.user["firstname"] + " " + data.doctor.user["lastname"]);

        $("input[name=Date]").val(data.date);
        $("input[name=usr_time]").val(data.time);

        $("textarea[name=description]").val(data.symptoms);
        $("textarea[name=more_comments]").val(data.info);
    });
});

