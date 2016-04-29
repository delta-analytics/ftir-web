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
        $('#valve7State').addClass('glyphicon glyphicon-ok-circle');
    }
    else{
        $('#valve7State').addClass('glyphicon glyphicon-ban-circle');
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
    var ventil;
    var juekevalves = "/jueke/valves";
    var enable = "enable";
    var disable = "disable";
    var slash   =   "/";
    var ventilno;
    var ventilsteuern;

    for (var i = 1; i <= 7; i++) {
         ventil  = "ventil";
        ventilno = i.toString();
        console.log("Nummer:" + ventilno + "integer:" + i.toString());
        $("input[name="+ventil+ventilno+"]").bootstrapSwitch();
        console.log("vor on:" + ventil+ventilno);

        $("input[name="+ventil+ventilno+"]").on('switchChange.bootstrapSwitch',
            function (event, state) {

            if (state == true) {
                ventilsteuern = juekevalves + slash + ventilno + slash + enable;
                $.post(ventilsteuern);

                console.log('Ventilpost an:' + ventilsteuern);
            } else {
                ventilsteuern = juekevalves + slash + ventilno + slash + disable;
                $.post(ventilsteuern);
                console.log('Ventilpost aus:' + ventilsteuern);
            }
        });
    }
});