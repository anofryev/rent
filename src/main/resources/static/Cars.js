function add(manufacturer, style, name, statenumber ) {
    if (manufacturer == "" || style =="" || name==""||statenumber==""){
        alert("Заполните все поля");
    } else {
        var jsonObjects = {
            "style": {
                "nameStyle": style
            },
            "id_manufacturer": {
                "nameManufacturer": manufacturer
            },
            "name": name,
            "description": "Описание машины",
            "statenumber": statenumber,

        }

        $.ajax({
            url: "/car",
            type: "post",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(jsonObjects)
        })};
};

function getIdSelections() {
    var arr;

    arr = $('#eventsTable').find('[type="checkbox"]:checked').map(function(){
        return $(this).closest('tr').find('td:nth-child(2)').text();
    }).get();
    console.log(arr);

    arr.forEach(function(item, i, arr) {
        del(item);
    })
};

function del(rowid) {
    $('#eventsTable').bootstrapTable('refresh');
    $.ajax({
        url: "/contragents/"+rowid,
        type: "DELETE",
        contentType: "application/json",
        dataType: "json",
        //  window:location.reload(),
        success:   $('#eventsTable').bootstrapTable('refresh')

    })
};

function getIdSelectionsUpd(manufacturer, style, name, statenumber) {

    var arr;

    arr = $('#eventsTable').find('[type="checkbox"]:checked').map(function () {
        return $(this).closest('tr').find('td:nth-child(2)').text();
    }).get();
    console.log(arr);

    if (arr.length == 0) {
        alert("Не выбрана строка");
    } else {
        arr.forEach(function (item, i, arr) {
            upd(item, manufacturer, style, name, statenumber);
        })
    };
};

function upd(rowid,manufacturer, style, name, statenumber ) {
    if (manufacturer =="" || style =="" || name==""||statenumber==""){
        alert("Заполните все поля");
    } else {
        var jsonObjects = {
            "style": {
                "nameStyle": style
            },
            "id_manufacturer": {
                "nameManufacturer": manufacturer
            },
            "name": name,
            "description": "Описание машины",
            "statenumber": statenumber,
        }

        $.ajax({
            url: "/car/" + rowid,
            type: "put",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(jsonObjects)
        })
    };
};

// Code goes here
JSON.flatten = function(data) {
    var result = {};
    function recurse (cur, prop) {
        if (Object(cur) !== cur) {
            result[prop] = cur;
        } else if (Array.isArray(cur)) {
            for(var i=0, l=cur.length; i<l; i++)
                recurse(cur[i], prop + "[" + i + "]");
            if (l === 0)
                result[prop] = [];
        } else {
            var isEmpty = true;
            for (var p in cur) {
                isEmpty = false;
                recurse(cur[p], prop ? prop+"."+p : p);
            }
            if (isEmpty && prop)
                result[prop] = {};
        }
    }
    recurse(data, "");
    return result;
}
