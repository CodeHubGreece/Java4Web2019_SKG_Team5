$(document).ready(function () {
    let url_string = window.location.href;
    let url1 = new URL(url_string);
    let id = url1.searchParams.get("appointmentid");
    //let specialityTitle = url1.searchParams.get("specialityTitle");
    console.log(specialityTitle,id);
    // $.ajax({
    //     url: ROOT_PATH + "/getspeciality",
    //     type: "GET",
    //     data:{
    //         title:specialityTitle
    //     },
    //     dataType : "json",
    //     contentType:"application/json",
    //     success: function (data) {
    //         console.log(data);
    //         $("#specialty").append("<option value='" + data.specialityId + "'>" + data.title + "</option>")
    //     }
    // });
    // $.ajax({
    //     url: ROOT_PATH + "/citizen/appointment/"+id,
    //     type: "GET",
    //     dataType : "json",
    //     contentType:"application/json",
    // }).then(function(data) {
    //     console.log(data);
    //     let datetime = data.createdAt;
    //     let dateFor = [];
    //     let timeFor = [];
    //     for(var i=0;i<10; i++){
    //         dateFor[i] = datetime[i];
    //     }
    //     for(var j=11;j<16;j++){
    //         timeFor[j-11] = datetime[j];
    //     }
    //     let d = dateFor.join('');
    //     let t = timeFor.join('');
    //     console.log(d,t,data.doctor.user["lastname"],data.specialityTitle);
    //     // const myNode = document.getElementById("specialty");
    //     // myNode.innerHTML = '';
    //     $("#specialty").append("<option value='" + id + "'>" + specialityTitle + "</option>")
    //     //$("select[name=specialty]").val(data.specialityTitle);
    //     $("#doctor").append("<option value='" + data.doctor.doctorId + "'>" + data.doctor.user["lastname"] + "</option>")
    //     //$("select[name=doctor]").val(data.doctor.user["lastname"]);
    //
    //     $("input[name=Date]").val(d);
    //     $("input[name=usr_time]").val(t);
    //
    //     $("textarea[name=description]").val(data.symptoms);
    //     $("textarea[name=more_comments]").val(data.info);
    // });

    $.ajax({
        url: ROOT_PATH + "/doctor/appointments/" + id
    }).then(function(data) {
        $("input[name=Date]").val(data.date);
        $("input[name=usr_time]").val(data.time);

        $("textarea[name=description]").val(data.description);
        $("textarea[name=more_comments]").val(data.more_comments);
    });

});

function viewpatientinfo() {
    location.replace(ROOT_PATH + "/pages/doctor/citizen_info.html?appointmentid="+id);
};