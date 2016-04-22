function getJuekeState() {
    $.ajax({
        type: 'GET',
        url: '/jueke/status/',
        success: function (json) {
            updateGui(json);
        }
    });
}

function updateGui(json) {
    for (var i = 1; i <= 8; i++) {
        $('#valve' + i + 'State').removeClass('glyphicon glyphicon-ok-circle');
        $('#valve' + i + 'State').removeClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus1 === true) {
        $('#valve1State').addClass('glyphicon glyphicon-ok-circle');
    }
    else{
        $('#valve1State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus2 === true) {
        $('#valve2State').addClass('glyphicon glyphicon-ok-circle');
    }
    else{
        $('#valve2State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus3 === true) {
        $('#valve3State').addClass('glyphicon glyphicon-ok-circle');
    }
    else{
        $('#valve3State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus4 === true) {
        $('#valve4State').addClass('glyphicon glyphicon-ok-circle');
    }
    else{
        $('#valve4State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus5 === true) {
        $('#valve5State').addClass('glyphicon glyphicon-ok-circle');
    }
    else{
        $('#valve5State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus6 === true) {
        $('#valve6State').addClass('glyphicon glyphicon-ok-circle');
    }
    else{
        $('#valve6State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus7 === true) {
        $('#valve7State').addClass('glyphicon glyphicon-ok-circle');;
    }
    else{
        $('#valve17State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus8 === true) {
        $('#valve8State').addClass('glyphicon glyphicon-ok-circle');
    }
    else{
        $('#valve8State').addClass('glyphicon glyphicon-ban-circle');
    }
    $('#pumpState').removeClass('glyphicon glyphicon-ok-circle');
    $('#pumpState').removeClass('glyphicon glyphicon-ban-circle');
    if(json.statusOfPump === true){
        $('#pumpState').addClass('glyphicon glyphicon-ok-circle');
    }
    else{
        $('#pumpState').addClass('glyphicon glyphicon-ban-circle');
    }
    $('#pumpSpeedState').text(json.pumpPower);
    $('#pressureState').text(json.actualPressureCell);
    $('#temperatureState').text(json.actualTempHeater);
}

$(function () {
    $('#disablePump').on("click", function () {
        $.post("/jueke/disablePump");
    });
});