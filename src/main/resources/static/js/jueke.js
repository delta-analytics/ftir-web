function getJuekeState() {
    $.ajax({
        type: 'GET',
        url: '/jueke/status/',
        success: function (json) {
            updateGui(json);
        }
    });
}

function updateJuekeStateForSettingsGuiInitial() {
    $.ajax({
        type: 'GET',
        url: '/jueke/status/',
        success: function (json) {
            setSettingsGuiInitial(json);
        }
    });
}

function updateJuekeStateForSettingsGui() {
    $.ajax({
        type: 'GET',
        url: '/jueke/status/',
        success: function (json) {
            setSettingsGui(json);
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
    else {
        $('#valve1State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus2 === true) {
        $('#valve2State').addClass('glyphicon glyphicon-ok-circle');
    }
    else {
        $('#valve2State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus3 === true) {
        $('#valve3State').addClass('glyphicon glyphicon-ok-circle');
    }
    else {
        $('#valve3State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus4 === true) {
        $('#valve4State').addClass('glyphicon glyphicon-ok-circle');
    }
    else {
        $('#valve4State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus5 === true) {
        $('#valve5State').addClass('glyphicon glyphicon-ok-circle');
    }
    else {
        $('#valve5State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus6 === true) {
        $('#valve6State').addClass('glyphicon glyphicon-ok-circle');
    }
    else {
        $('#valve6State').addClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus7 === true) {
        $('#valve7State').addClass('glyphicon glyphicon-ok-circle');
    }
    else {
        $('#valve7State').addClass('glyphicon glyphicon-ban-circle');
    }

    $('#pumpState').removeClass('glyphicon glyphicon-ok-circle');
    $('#pumpState').removeClass('glyphicon glyphicon-ban-circle');

    if (json.statusOfPump === true) {
        $('#pumpState').addClass('glyphicon glyphicon-ok-circle');
    }
    else {
        $('#pumpState').addClass('glyphicon glyphicon-ban-circle');
    }
    $('#pumpSpeedState').text(json.pumpPower);
    $('#pressureState').text(json.actualPressureCell);
    $('#temperatureState').text(json.actualTempHeater);
}


function setSettingsGui(json) {

    $('#pumppowerActual').text("(" + json.pumpPower + ")");
    $('#pressureState').text(json.actualPressureCell);
    $('#temperatureState').text(json.actualTempHeater);

}

function setSettingsGuiInitial(json) {
    var v6 = $('#ventil6');
    if (json.valveStatus6 === true) {
        v6.bootstrapSwitch('state', true);
    }
    else {
        v6.bootstrapSwitch('state', false);
    }
    $('#pumppower').val(json.pumpPower);

    if (json.statusOfPump === true) {
        if (json.pumpPower > 0) {
            $('#pumpsymbol').addClass('greenpump');
        } else {
            $('#pumpsymbol').addClass('redpump');
        }
      } else {
        $('#pumpsymbol').addClass('redpump');

    }
   //-- /pump/speed/{speed}
}

$(function () {

    console.log("vor der Abfrage pumpe-disable");
    $('#pumpsymbol').on("click", function () {
        $('#pumpsymbol').removeClass('redpump');
        $('#pumpsymbol').removeClass('greenpump');

        $('#pumpsymbol').addClass('redpump');
        console.log("pump-disable");
        $.post("/jueke/pump/speed/" + 0);
       // $.post("/jueke/disablePump");
    });

    $('#disablePump').on("click", function () {
        $.post("/jueke/disablePump");
    });

    $('#setpumpspeed').on("click", function () {
        console.log("setpumpspeed: " );
        
        if ($('#pumppower').val() > 0) {
            var speed = $('#pumppower').val();
            var setspeed = "/jueke/pump/speed/" + speed;
            $.post(setspeed);
            $('#pumpsymbol').addClass('greenpump');
        }
    });

    var juekevalves = "/jueke/valves";
    var enable = "enable";
    var disable = "disable";
    var slash = "/";

    $("input[type=checkbox]").bootstrapSwitch();

    $("input[type=checkbox]").on('switchChange.bootstrapSwitch',
        function (event, state) {
            event.preventDefault();
            var targetId = juekevalves + slash + event.target.id.substring(6, 7);
            if (state == true) {
                $.post(targetId + slash + enable);
            } else {
                $.post(targetId + slash + disable);
            }
            console.log(targetId);
            console.log(event);
        });
});