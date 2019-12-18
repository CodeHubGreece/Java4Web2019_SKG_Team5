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
        // let apind = $("#specialties").val();
        // let fullDateArr = Array.from(data[apind].createdAt);
        // let dateArr = [];
        // let timeArr = [];
        // for(var i=0;i<9;i++){
        //     dateArr[i] = fullDateArr[i];
        // }
        // for(var j=11;j<16;j++){
        //     timeArr[j-11] = fullDateArr[j];
        // }
        // let d = dateArr.join();
        // let t = timeArr.join();
        // console.log(d,t);
        // console.log(data);
        const myNode = document.getElementById("appointmentsTable");
        myNode.innerHTML = '';
		$("#appointmentsTable").append("<tbody>");

        for (let appointmentIndex in data) {
            $("#appointmentsTable").append("<tr id=" + appointmentIndex + "'><td>"+ data[appointmentIndex].createAt +"</td><td>"+data[appointmentIndex].doctor.user["firstname"]+"</td><td>" + data[appointmentIndex].doctor.user["lastname"] + "</td></tr>");
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
    $.ajax({
        url: ROOT_PATH + "/citizen/appointments/" + id
    }).then(function(data) {
        $("option[name=specialty]").val(data.id);
        $("option[name=doctor]").val(data.doctor);

        $("input[name=Date]").val(data.date);
        $("input[name=usr_time]").val(data.time);

        $("textarea[name=description]").val(data.description);
        $("textarea[name=more_comments]").val(data.more_comments);
    });
};


