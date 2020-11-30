function getIdSelectionsDelCarHands() {
    var arr;
    arr = $('#eventsTable3').find('[type="checkbox"]:checked').map(function(){
        return $(this).closest('tr').find('td:nth-child(2)').text();
    }).get();
    console.log(arr);
    arr.forEach(function(item, i, arr) {
        delCarHands(item);
    })
};

function delCarHands(rowid) {
    $.ajax({
        url: "/caronhand/"+rowid,
        type: "DELETE",
        contentType: "application/json",
        dataType: "json",
        //  window:location.reload(),
        //success:   $('#eventsTable3').bootstrapTable('refresh')
    })
};


//Добавить машину в зарезервированные
function addCarOnHands() {
    client= null;
    car = null;
    clientList = $('#eventsTable2').find('[type="checkbox"]:checked').map(function () {
        return $(this).closest('tr').find('td:nth-child(2)').text();
    }).get();
    if (clientList.length == 0 && clientList.length > 1) {
        alert("Выберите одну строку");
    } else {
        clientList.forEach(function (item, i, arr) {
            client = item;
        })
}
    carList = $('#eventsTable').find('[type="checkbox"]:checked').map(function () {
        return $(this).closest('tr').find('td:nth-child(2)').text();
    }).get();
    if (carList.length == 0 && carList.length > 1) {
        alert("Выберите одну строку");
    } else {
        carList.forEach(function (item, i, arr) {
            car = item;
        })};
    var jsonObjects = {
        "car": {
            "id_car": car
        },
        "client": {
            "client_id": client
        }
    }
    $.ajax({
        url: "/caronhand",
        type: "post",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(jsonObjects)
    })
    location.reload(); // перезагружаем страницу
}