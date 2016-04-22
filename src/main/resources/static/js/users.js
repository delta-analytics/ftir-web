$(function () {
    $("#createUserModal").on("show.bs.modal", function (e) {
        $(this).find(".modal-content").load("newUser");
    });
    $(".usereditbtn").on("click", function (e) {
        var userId = $(this).data('user-id');
        var editUserModal = $("#editUserModal");
        $(editUserModal).find(".modal-content").load("editUser/" + userId);
        editUserModal.modal();
    });

    $('table').tablesorter();
});