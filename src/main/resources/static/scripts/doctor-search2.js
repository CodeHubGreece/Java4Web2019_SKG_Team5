function populateDataTable(appointments, id) {
    $("#appointments").append("<tbody>");
    jQuery.each(appointment, function(i,appointment){
        $("#appointments").append("<tr id='appRow" + appointment.id + "'><td>" + appointment.date + "</td> + <td>" + appointment.time + "</td> + <td>" + appointment.citizenName + "</td></tr>");
     });
     $("#appointments").append("</tbody>");

     $("#appointments tr").click(function() {
        loadAppointment($(this).children("td").html());
     });

    $('#appointments').DataTable();
}

function loadAppointment(id) {
    $.ajax({
        url: ROOT_PATH + "/appointments/" + id
    }).then(function(appointments) {
       $("input[name=date]").val(appointment.date);
       $("input[name=name]").val(appointment.citizenName);
       $("input[name=id]").val(appointment.id);
    });
};



    $.ajax({
        url: ROOT_PATH + "/appointments/" + id 
    }).then(function(appointments) {
        populateDataTable(appointments, id);
    });

    $("#saveButton").on('click', function(event){
        event.preventDefault();
        alert("To be done...");
    });



	/*
    $("#deleteButton").on('click', function(event){
        event.preventDefault();
        let bookId = $("input[name=id]").val();
        $.ajax({
            url: ROOT_PATH + "/books/" + bookId,
            type : "DELETE",
            dataType : 'json',
            contentType: 'application/json',
                success : function(result) {
                    $("#bookRow" + bookId).remove();
                    $("input[name=id]").val("");
                    $("input[name=title]").val("");
                    $("input[name=isbn]").val("");
                },
                error: function(xhr, resp, text) {
                    console.log(xhr, resp, text);
                    alert("Could not delete book!");
                 }
         })

	}); */

    
    
    // ----------------modal script-------------------------------------------------


    $('#detailsBtn').click(function(){  //the current appointment button
   
        var userid = $(this).data('id');
     
        // AJAX request
        $.ajax({
         url: ROOT_PATH + "/appointmentdetails/" + id,
         type: 'GET',
         dataType : "json",
         contentType:"application/json",
         success: function(response){ 
           // Add response in Modal body
           $('.modal-body').html(response);
     
           // Display Modal
           $('#myModal').modal('show'); 
         }
       });
      });




