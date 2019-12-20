$(document).ready(function () {
    let url_string = window.location.href;
    let url1 = new URL(url_string);
    let id = url1.searchParams.get("appointmentid");

    $.ajax({
        url: ROOT_PATH + "/doctor/appointment/" + id
    }).then(function(data) {

        let date = data.createdAt;

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
        // let datetime = data.createdAt;
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
        $("input[name=Date]").val(d2);
        $("input[name=usr_time]").val(time);

        $("textarea[name=description]").val(data.symptoms);
        $("textarea[name=more_comments]").val(data.info);
    });

});

function viewpatientinfo() {
    let url_string = window.location.href;
    let url1 = new URL(url_string);
    let id = url1.searchParams.get("appointmentid");
    window.location.replace(ROOT_PATH + "/pages/doctor/citizen_info.html?appointmentid="+id);
}