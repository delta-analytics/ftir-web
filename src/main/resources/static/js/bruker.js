$(function () {
    $('.show-measurement').click(function () {
        var measurementId = this.getAttribute("id").split("_")[2];
        $('.modal-body').load("measuresamples/" + measurementId, function (result) {
            $('#myModal').modal({show: true});
        });
    });
});