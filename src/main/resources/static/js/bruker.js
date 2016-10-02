$(function () {
    $('.show-measurement').click(function () {
        var measurementId = this.getAttribute("id").split("_")[2];
        // FJ Argument in load: RequestMapping-String from BrukerController / brukerRestClient.getMeasuredSample() + ID
        $('.modal-body').load("getMeasuredSamples/" + measurementId, function (result) {
            $('#myModal').modal({show: true});  // FJ class with ID myModal is in measurements.html
        });
    });
});

$(function () {
    $('.claculate-measurement').click(function () {
        var measurementId = this.getAttribute("id").split("_")[2];
        $('.modal-body').load("calculation/start/" + measurementId, function()) {
            // FJ after calculation is ready show result
    });
});
