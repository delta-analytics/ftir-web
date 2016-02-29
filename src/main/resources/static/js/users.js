$(function() {
    $("#createUserModal").on("show.bs.modal", function (e) {
        $(this).find(".modal-content").load("newUser");
    });
    $("#editUserBtn").on("click", function (e) {
        $("#editUserModal").modal();

    });
    $("#editUserModal").on("show.bs.modal", function (e) {
        $(this).find(".modal-content").load("editUser");
    });

    $('table').tablesorter();
});