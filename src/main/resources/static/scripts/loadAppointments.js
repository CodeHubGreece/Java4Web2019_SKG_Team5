function loadAppointments(){
	$.ajax({
    url: ROOT_PATH + "/citizen/appointments",
    type: "GET",
    dataType : "json",
    contentType:"application/json",
    success: function (data) {
        console.log(data);
		$("#appointmentsTable").append("<tbody>");
        for (let appointmentIndex in data) {
            $("#appointmentsTable").append("<tr id=" + appointmentIndex + "'><td>" + data[appointmentIndex].createdAt + "</td><td>" + data[appointmentIndex].doctor.user["lastname"] + "</td></tr>");
        }
		$("#appointmentsTable").append("<tbody>");
		
		$("#appointmentsTable tr").click(function() {
        //loadBook($(this).children("td").html());
		});
		
		//$('#appointmentsTable').DataTable();
    },
    error: function (xhr, resp, text) {
        alert("Error: " + text);
    }
	});
}


