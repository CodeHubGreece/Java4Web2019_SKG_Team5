function loadAppointments(fromElem,toElem,description){
    let descript = $.trim($("#textarea1").val());
    let from = fromElem && fromElem.value ? fromElem.value: "";
    let to = toElem && toElem.value ? toElem.value: "";

    $.ajax({
        url: ROOT_PATH + "/doctor/appointments",
        data: {
            from: from,
            to: to,
            symptoms: descript,
        },
        type: "GET",
        success: function (data) {
            const myNode = document.getElementById("appointmentsTable");
            myNode.innerHTML = '';
            $("#appointmentsTable").append("<thead><tr><th>Id</th><th>Date & Time</th><th>Firstname</th><th>Lastname</th></tr></thead>");
            $("#appointmentsTable").append("<tbody>");

            for (let appointmentIndex in data) {
                let date = data[appointmentIndex].createdAt;

                var d = new Date(date),
                    month = '' + (d.getMonth() + 1),
                    day = '' + d.getDate(),
                    year = d.getFullYear(),
                    hours = d.getHours().toString(),
                    minutes = d.getMinutes().toString();

                if (hours.length < 2)
                    hours = '0' + hours;
                if (minutes.length < 2)
                    minutes = '0' + minutes;

                if (month.length < 2)
                    month = '0' + month;
                if (day.length < 2)
                    day = '0' + day;

                let d2 = [year, month, day].join('-');
                let time = [hours,minutes].join(':');
                // let datetime = data[appointmentIndex].createdAt;
                // let dateFor = [];
                // let timeFor = [];
                // for(var i=0;i<10; i++){
                //     dateFor[i] = datetime[i];
                // }
                // for(var j=11;j<16;j++){
                //     timeFor[j-11] = datetime[j];
                // }
                // let d = dateFor.join('');
                // let t = timeFor.join('');
                $("#appointmentsTable").append("<tr id=" + appointmentIndex + "'><td>"+ data[appointmentIndex].appointmentId +"</td><td>"+ d2 + " " + time +"</td><td>"+data[appointmentIndex].citizen.user["firstname"]+"</td><td>" + data[appointmentIndex].citizen.user["lastname"] + "</td></tr>");
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


