$(function () {
    $('.show-measurement').click(function () {
        var measurementId = this.getAttribute("id").split("_")[2];
        $('.modal-body').load("measureSamples/" + measurementId, function (result) {
            $('#myModal').modal({show: true});
        });
    });
});