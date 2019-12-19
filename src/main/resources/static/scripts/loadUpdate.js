$( document ).ready(function() {
    let url_string = window.location.href;
    let url = new URL(url_string);
    let id = url.searchParams.get("appointmentid");
    let specialityTitle = url.searchParams.get("specialityTitle");

    console.log(specialityTitle);
    // $.ajax({
    //     url: ROOT_PATH + "/getspeciality",
    //     type: "GET",
    //     data:{
    //         specialityTitle:specialityTitle
    //     },
    //     dataType : "json",
    //     contentType:"application/json",
    //     success: function (data) {
    //         console.log(data);
    //         // const myNode = document.getElementById("specialty");
    //             // myNode.innerHTML = '';
    //         $("#specialty").append("<option value='" + data.specialityIdId + "'>" + data.title + "</option>")
    //     }
    // });
    $.ajax({
        url: ROOT_PATH + "/citizen/appointment/" + id
    }).then(function(data) {
        console.log(data)
        let datetime = data.createdAt;
        let dateFor = [];
        let timeFor = [];
        for(var i=0;i<10; i++){
            dateFor[i] = datetime[i];
        }
        for(var j=11;j<16;j++){
            timeFor[j-11] = datetime[j];
        }
        let d = dateFor.join('');
        let t = timeFor.join('');
        console.log(d,t,data.doctor.user["lastname"],data.specialityTitle);
        // const myNode = document.getElementById("specialty");
        // myNode.innerHTML = '';
        $("#specialty").append("<option value='" + id + "'>" + specialityTitle + "</option>")
        //$("select[name=specialty]").val(data.specialityTitle);
        $("#doctor").append("<option value='" + data.doctor.doctorId + "'>" + data.doctor.user["lastname"] + "</option>")
        //$("select[name=doctor]").val(data.doctor.user["lastname"]);

        $("input[name=Date]").val(d);
        $("input[name=usr_time]").val(t);

        $("textarea[name=description]").val(data.symptoms);
        $("textarea[name=more_comments]").val(data.info);
    });

});

function update(specialityElem, doctornameElem, dateElem, timeElem, descriptionElem, moreinfoElem){
    let speciality = $("#specialty").val() ? $("#specialty").val() : "";
    let doctorId = doctornameElem && $("#doctor").val() ? $("#doctor").val() : "";
    let date = dateElem && $("#dat").val() ? $("#dat").val() : "";
    let time = timeElem && $("#ti").val() ? $("#ti").val() : "";
    let symptoms = descriptionElem && $("#textarea1").val() ? $("#textarea1").val() : "";
    let info = moreinfoElem && $("#textarea2").val() ? $("#textarea2").val() : "";

    let url_string = window.location.href;
    let url = new URL(url_string);
    let newid = url.searchParams.get("appointmentid");
    $.ajax({
        url: ROOT_PATH + "/appointment/update/"+newid,
        type:"PUT",
        data: JSON.stringify({
            'specialityTitle': speciality,
            'doctorId': doctorId,
            'date': date,
            'time': time,
            'symptoms': symptoms,
            'info': info
        }),
        dataType : "json",
        contentType:"application/json",
        success:function(data){
            console.log("Updated "+data)
        }.then(
            window.location.replace(ROOT_PATH+"/pages/citizen/citizen_search.html")
        ),
        error: function () {
            alert("Could not execute update");
        }

    })

};

function deleteApp() {
    var confirmation = confirm("Are you sure you want to delete this appointment?");
    if (confirmation){
        let url_string = window.location.href;
        let url = new URL(url_string);
        let newId = url.searchParams.get("appointmentid");
        $.ajax({
            url: ROOT_PATH + "/appointment/delete/"+ newId,
            type: "GET",
            success:function (data) {
                alert("You have succesfully deleted the appointment")
                window.location.replace(ROOT_PATH+"/pages/citizen/citizen_search.html")
            },
            error:function () {
                alert("Could not Delete")

            }
        })
    }else{
        window.location.replace(ROOT_PATH+"/pages/citizen/citizen_search.html")
    }



}



