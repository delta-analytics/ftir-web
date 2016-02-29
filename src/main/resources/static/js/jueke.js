$(function() {
    $('#disablePump').on("click", function(){
        $.post("/jueke/disablePump");
    });
});