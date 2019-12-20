function loadAppointments(specialElem,fromElem,toElem){
    let specialityTitle = $("#specialties option:selected").text() ? $("#specialties option:selected").text() : "";
    let from = fromElem && fromElem.value ? fromElem.value: "";
    let to = toElem && toElem.value ? toElem.value: "";

	$.ajax({
    url: ROOT_PATH + "/citizen/appointments",
    data: {specialityTitle:specialityTitle,
        from:from,
        to:to},
    type: "GET",
    success: function (data) {

        const myNode = document.getElementById("appointmentsTable");
        myNode.innerHTML = '';
        $("#appointmentsTable").append("<thead><th>Id</th><th>Date & Time</th><th>Firstname</th><th>Lastname</th></thead>");
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

             let d2 = [day, month, year].join('/');
             let time = [hours,minutes].join(':');

            // let datetime = date;
            // let dateFor = [];
            // let timeFor = [];
            // for(var i=0;i<10; i++){
            //     dateFor[i] = datetime[i];
            // }
            // for(var j=11;j<16;j++){
            //     timeFor[j-11] = datetime[j];
            // }
            //dateFor[4].replace('-','/');
            //dateFor[]
            //let d2 = dateFor.join('');
            //let t = timeFor.join('');
            //t = new Date(t).toTimeString();
            $("#appointmentsTable").append("<tr id=" + data[appointmentIndex].appointmentId + "'><td>"+data[appointmentIndex].appointmentId+"</td><td>"+ d2 +" "+ time +"</td><td>"+data[appointmentIndex].doctor.user["firstname"]+"</td><td>" + data[appointmentIndex].doctor.user["lastname"] + "</td></tr>");
        }
		$("#appointmentsTable").append("<tbody>");
		
		$("#appointmentsTable tr").click(function() {
           loadAppointInfo($(this).children("td").html(),specialityTitle);
		});
		
    },
    error: function (xhr, resp, text) {
        alert("Error: " + text);
    }
	});
}

function loadAppointInfo(id,specialityTitle) {
    location.replace(ROOT_PATH + "/pages/citizen/update_appointment.html?appointmentid="+id+"&specialityTitle="+specialityTitle);
}


