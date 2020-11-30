
function addClients(firstName,lastName,middleName,phone) {
    if (firstName == "" || lastName =="" || middleName==""||phone==""){
        alert("Заполните все поля");
    } else {
        var jsonObjects = {
            "first_name_client": firstName,
            "last_name_client": lastName,
            "middle_name_client": middleName,
            "phone_client": phone
        }
        alert("Done?");
        $.ajax({
            url: "/client",
            type: "post",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(jsonObjects)
        })};};

function getIdSelectionsDelClients() {
    var arr;
    arr = $('#eventsTable2').find('[type="checkbox"]:checked').map(function(){
        return $(this).closest('tr').find('td:nth-child(2)').text();
    }).get();
    console.log(arr);
    arr.forEach(function(item, i, arr) {
        delClients(item);
    })
};

function delClients(rowid) {
    //$('#eventsTable2').bootstrapTable('refresh');
    $.ajax({
        url: "/clients/"+rowid,
        type: "DELETE",
        contentType: "application/json",
        dataType: "json",
        //  window:location.reload(),
        //success:   $('#eventsTable2').bootstrapTable('refresh')
    })
    location.reload(); // перезагружаем страницу
};

function getIdSelectionsUpdClients(firstName, lastName, middleName, phone) {

    var arr;

    arr = $('#eventsTable2').find('[type="checkbox"]:checked').map(function () {
        return $(this).closest('tr').find('td:nth-child(2)').text();
    }).get();
    console.log(arr);

    if (arr.length == 0) {
        alert("Не выбрана строка");
    } else {
        arr.forEach(function (item, i, arr) {
            updClients(item, firstName, lastName, middleName, phone);
        })
    };
};

function updClients(item, firstName, lastName, middleName, phone ) {
    if (firstName =="" || lastName =="" || middleName==""||phone==""){
        alert("Заполните все поля");
    } else {
        var jsonObjects = {
            "first_name_client": firstName,
            "last_name_client": lastName,
            "middle_name_client": middleName,
            "phone_client": phone
        }

        $.ajax({
            url: "/client/" + item,
            type: "put",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(jsonObjects),
            success:   $('#eventsTable2').bootstrapTable('refresh')
        })
    };
};
