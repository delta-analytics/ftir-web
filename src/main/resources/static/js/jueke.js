$(function () {
    $('#disablePump').on("click", function () {
        $.post("/jueke/disablePump");
    });
    function getStatus() {
        $.getJSON("/jueke/status", function (result) {
            console.info(result);
        });
    }

    setInterval(getStatus, 1000);
});