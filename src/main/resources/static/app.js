//Функция не используется, лежит на всякий
    $(document).ready(function  () {
        $.ajax({
            url: "/car",
            type: "GET",
            dataType: "JSON",
            success: function (data) { //  загружаем данные с сервера с помощью HTTP запроса методом GET
                //alert("Прибыли данные " + data[0].name + " ");

                let tr;
                for (let i = 0; i < data.length; i++) {
                    tr = $('<tr/>');
                    tr.append("<td>" + data[i].fio + "</td>");
                    tr.append("<td>" + data[i].telefon + "</td>");
                    tr.append("<td>" + data[i].adres + "</td>");
                    $('table').append(tr);
                }
            }
        })
    });




