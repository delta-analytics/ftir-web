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
        $('#valve' + i + 'State').removeClass('active');
    }
    if (json.valveStatus1 === true) {
        $('#valve1State').addClass('active');
    }
    if (json.valveStatus2 === true) {
        $('#valve2State').addClass('active');
    }
    if (json.valveStatus3 === true) {
        $('#valve3State').addClass('active');
    }
    if (json.valveStatus4 === true) {
        $('#valve4State').addClass('active');
    }
    if (json.valveStatus5 === true) {
        $('#valve5State').addClass('active');
    }
    if (json.valveStatus6 === true) {
        $('#valve6State').addClass('active');
    }
    if (json.valveStatus7 === true) {
        $('#valve7State').addClass('active');
    }
    if (json.valveStatus8 === true) {
        $('#valve8State').addClass('active');
    }
    $('#pumpState').val(json.statusOfPump);
    $('#pumpSpeedState').val(json.pumpPower);
    $('#pressureState').val(json.actualPressureCell);
    $('#temperatureState').val(json.actualTempHeater);
}

$(function () {
    $('#disablePump').on("click", function () {
        $.post("/jueke/disablePump");
    });
});