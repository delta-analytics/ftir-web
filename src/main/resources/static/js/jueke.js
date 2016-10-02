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

function updateJuekeStateForSettingsGui(vno) {
    $.ajax({
        type: 'GET',
        url: '/jueke/status/',
        success: function (json) {
            setSettingsGui(json,vno);  // ToDo FJ ajax call is GET, but on click in setSettingsGui makes POST
        }
    });
}




function updateGui(json) {  // ToDo FJ also check pressure and temperature regulation active and some time in future temperature/heater reached/ok
    
    for (var i = 1; i <= 7; i++) {
        $('#valve' + i + 'State').removeClass('glyphicon glyphicon-ok-circle');
        $('#valve' + i + 'State').removeClass('glyphicon glyphicon-ban-circle');
    }
    if (json.valveStatus1 === true) {
        $('#valve1State').addClass('glyphicon glyphicon-ok-circle');
        console.log("JSON:" + json.valveStatus1);
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

    // ToDo green and red for temperature / pressure active
    //$('#pressactive')
    //$('#tempactive')
    
}


function setSettingsGui(json,vno) {  //  ToDo FJ ajax call is GET, but on click makes POST
    var on  =   'enable';
    var off =   'disable';
    var vnumber = "#valve" + vno;
    var status_no   = "valveStatus" + vno;
    var val_boolean;


    
    console.log("function: " + vno + "  " + status_no);

    $(vnumber).on("click", function () {

        console.log("function: vor ventuil:" );
        val_boolean=valveStatus(json,vno);
        if (val_boolean === true) {
        $(vnumber).removeClass('greenlight');
        $.post("/jueke/valves/" + vno + "/disable");
        $(vnumber).addClass('redlight');
        console.log("function: true ");
         }
         else {
            console.log("function: false ");
            $.post("/jueke/valves/" + vno + "/enable");
            $(vnumber).addClass('greenlight');
        }
    });


    console.log("vor der Abfrage pumpe-disable");
    $('#pumpsymbol').on("click", function () {
        $('#pumpsymbol').removeClass('redlight');
        $('#pumpsymbol').removeClass('greenlight');

        $('#pumpsymbol').addClass('redlight');
        console.log("pump-disable");
        $.post("/jueke/pump/speed/" + 0);
        // $.post("/jueke/disablePump");
    });


    $('#setpumpspeed').on("click", function () {
        console.log("setpumpspeed: " );

        if ($('#pumppower').val() > 0) {
            var speed = $('#pumppower').val();
            var setspeed = "/jueke/pump/speed/" + speed;
            $.post(setspeed);
            $('#pumpsymbol').addClass('greenlight');
        }
    });


}

function setSettingsGuiInitial(json) {

    $('#pumppowerActual').text("(" + json.pumpPower + ")");
    $('#pressureState').text(json.actualPressureCell);
    $('#temperatureState').text(json.actualTempHeater);

    console.info("Pruefventile: " );
    var valve_max = 7;
    var vnumber;
    var status;
    for (var i = 1; i <= valve_max; i++) {

        vnumber = "#valve" + i;
        status = valveStatus(json, i);

        if (status === true) {
            $(vnumber).removeClass('redlight');
            $(vnumber).addClass('greenlight');
        } else {
            $(vnumber).removeClass('greenlight');
            $(vnumber).addClass('redlight');
        }
    }

    
    if (json.pressureRegulationActive === true) {
        $('#pressactive').addClass('greenlight');
    } else {
        $('#pressactive').addClass('redlight');
    }
    if (json.heaterRegulationActive === true) {
        $('#tempactive').addClass('greenlight');
    } else {
        $('#tempactive').addClass('redlight');
    }




  //  $('#pumppowerActual').val(json.pumpPower);

    if (json.statusOfPump === true) {
        if (json.pumpPower > 0) {
            $('#pumpsymbol').addClass('greenlight');
        } else {
            $('#pumpsymbol').addClass('redlight');
        }
      } else {
        $('#pumpsymbol').addClass('redlight');

    }
   //-- /pump/speed/{speed}
}

function valveStatus (json,vno) {
    var boolean;
    switch (vno) {
        case 1:
            boolean = json.valveStatus1;
            break;
        case 2:
            boolean = json.valveStatus2;
            break;
        case 3:
            boolean = json.valveStatus3;
            break;
        case 4:
            boolean = json.valveStatus4;
            break;
        case 5:
            boolean = json.valveStatus5;
            break;
        case 6:
            boolean = json.valveStatus6;
            break;
        case 7:
            boolean = json.valveStatus7;
            break;
        default:
            boolean = false;
    }
    return boolean
}

$(function () {
    console.info("Function fauncktion");
    var on  =   'enable';  // ToDo FJ not used ?
    var off =   'disable';  // ToDo FJ not used ?


    $('#tempera-start').on("click", function () {
        var temperatur = $('#tempera').val();
        $.post("/jueke/temperature/" + temperatur);
        $.post("/temperature/regulation/start");
        $('#tempactive').removeClass('redlight');
        $('#tempactive').addClass('greenlight');
        console.log("temperature regulation start T=" + temperatur);
    })
    $('#tempera-stop').on("click", function () {
        $.post("/temperature/regulation/stop");
        $('#tempactive').removeClass('greenlight');
        $('#tempactive').addClass('redlight');
        console.log("temperature regulation stop");
    })

    $('#pressure-start').on("click", function () {
        var pressure_mbar = $('#pressure').val();
        $.post("/jueke/pressure/" + pressure_mbar);
        $.post("/jueke/pressure/regulation/start");
        $('#pressactive').removeClass('redlight');
        $('#pressactive').addClass('greenlight');
        console.log("Pressure Regulation Start p=" + pressure_mbar);
    })

    $('#pressure-stop').on("click", function () {
        $.post("/jueke/pressure/regulation/stop");
        $('#pressactive').removeClass('greenlight');
        $('#pressactive').addClass('redlight');
        console.log("Pressure Regulation Stop");
    })




    var juekevalves = "/jueke/valves";
    var enable = "enable";
    var disable = "disable";
    var slash = "/";
    $( "#valve1" ).on("click", function(event, state) {    // ToDo FJ why only valve 1 ?
        event.preventDefault();
        console.info("input bei v1:" + $('input[type=button]').toString());
        console.info("event valve1:" + event.toString());
        console.info("state:" + state);
    });

    $('input[type=button]').on("click", function (event) {   // ToDo FJ for which button is that action, for all buttons, just console info ?
        var sevent = event;
        console.info("sevent:" + sevent);
    });

    $('input[type=button]').on('switchChange.bootstrapSwitch',  // ToDo FJ what happens to pump button and regulation buttons ?
        /*function (event, state) {
            event.preventDefault();   // FJ Cancel the default action (navigation) of the click
            var targetId = juekevalves + slash + event.target.id.substring(6, 7);
            if (state == true) {
                $.post(targetId + slash + enable);
            } else {
                $.post(targetId + slash + disable);
            }
            console.info("target:" + targetId);
            console.info("event:" + event);
        }); */
});