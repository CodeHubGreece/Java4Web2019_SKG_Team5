$(document).ready(function () {
    let url_string = window.location.href;
    let url1 = new URL(url_string);
    let id = url1.searchParams.get("appointmentid");

    $.ajax({
        url: ROOT_PATH + "/doctor/appointment/" + id
    }).then(function(data) {
        let datetime = data.createdAt;
        let dateFor = [];
        let timeFor = [];
        for(var i=0;i<10; i++){
            dateFor[i] = datetime[i];
        }
        for(var j=11;j<16;j++){
            timeFor[j-11] = datetime[j];
        }
        //dateFor[4].replace('-','/');
        //dateFor[]
        let d = dateFor.join('');
        let t = timeFor.join('');
        $("input[name=Date]").val(d);
        $("input[name=usr_time]").val(t);

        $("textarea[name=description]").val(data.symptoms);
        $("textarea[name=more_comments]").val(data.info);
    });

});

function viewpatientinfo() {
    let url_string = window.location.href;
    let url1 = new URL(url_string);
    let id = url1.searchParams.get("appointmentid");
    location.replace(ROOT_PATH + "/pages/doctor/citizen_info.html?appointmentid="+id);
};