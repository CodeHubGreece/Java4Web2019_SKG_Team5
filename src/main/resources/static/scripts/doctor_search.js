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
            const myNode = document.getElementById("appointmentsTable");
            myNode.innerHTML = '';
            $("#appointmentsTable").append("<thead><tr><th>Id</th><th>Date & Time</th><th>Firstname</th><th>Lastname</th></tr></thead>");
            $("#appointmentsTable").append("<tbody>");

            for (let appointmentIndex in data) {
                $("#appointmentsTable").append("<tr id=" + appointmentIndex + "'><td>"+ data[appointmentIndex].appointmentId +"</td><td>"+ data[appointmentIndex].createdAt +"</td><td>"+data[appointmentIndex].citizen.user["firstname"]+"</td><td>" + data[appointmentIndex].citizen.user["lastname"] + "</td></tr>");
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
};


