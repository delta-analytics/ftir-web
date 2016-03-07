$(function () {
    $("#createUserModal").on("show.bs.modal", function (e) {
        $(this).find(".modal-content").load("newUser");
    });
    $("#editUserBtn").on("click", function (e) {
        $("#editUserModal").modal();

    });
    $("#editUserModal").on("show.bs.modal", function (e) {
        var button = $(e.relatedTarget);
        var userId = button.data('user-id');
        $(this).find(".modal-content").load("editUser/" + userId);
    });

    $('table').tablesorter();
});