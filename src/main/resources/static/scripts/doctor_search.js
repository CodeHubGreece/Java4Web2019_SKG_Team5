function loadAppointments(fromElem,toElem,description){
    let descript = $("#textarea1").text() ? $("#textarea1").text() : "";
    let from = fromElem && fromElem.value ? fromElem.value: "";
    let to = toElem && toElem.value ? toElem.value: "";

    $.ajax({
        url: ROOT_PATH + "/doctor/appointments",
        data: {desc:descript,
            from:from,
            to:to},

        type: "GET",
        success: function (data) {
            // let apind = $("#specialties").val();
            // let fullDateArr = Array.from(data[apind].createdAt);
            // let dateArr = [];
            // let timeArr = [];
            // for(i=0;i<9;i++){
            //     dateArr[i] = fullDateArr[i];
            // }
            // for(i=11;i<16;i++){
            //     timeArr[i-11] = fullDateArr[i];
            // }
            // let d = dateArr.join();
            // let t = timeArr.join();
            // console.log(d,t);
            // console.log(data);

            const myNode = document.getElementById("appointmentsTable");
            myNode.innerHTML = '';
            $("#appointmentsTable").append("<thead><tr><th>Id</th><th>Date & Time</th><th>Firstname</th><th>Lastname</th></tr></thead>");
            $("#appointmentsTable").append("<tbody>");

            for (let appointmentIndex in data) {
                $("#appointmentsTable").append("<tr id=" + appointmentIndex + "'><td>"+ data[appointmentIndex].createdAt +"</td><td>"+data[appointmentIndex].doctor.user["firstname"]+"</td><td>" + data[appointmentIndex].doctor.user["lastname"] + "</td></tr>");
            }
            $("#appointmentsTable").append("<tbody>");

            $("#appointmentsTable tr").click(function() {
                loadAppointInfo($(this).children("td").html());
            });

        },
        error: function (xhr, resp, text) {
            alert("Error: " + text);
        }
    });
}

function loadAppointInfo(id) {
    location.replace(ROOT_PATH + "/pages/doctor/view_appointment.html?appointmentid="+id);
    // $.ajax({
    //     url: ROOT_PATH + "/doctor/appointments/" + id
    // }).then(function(data) {
    //     $("input[name=Date]").val(data.date);
    //     $("input[name=usr_time]").val(data.time);
    //
    //     $("textarea[name=description]").val(data.description);
    //     $("textarea[name=more_comments]").val(data.more_comments);
    // });
};


