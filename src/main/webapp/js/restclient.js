// The root URL for the RESTful services
var rootURL = "http://localhost:8080/splashpage";

$('#btnSave').click(function() {
    if ($(".error").length) {
        addUser();
    }
});

$('#btnQtSave').click(function() {
    if ($(".error").length) {
        addQuestions();
    }
});

function addUser() {
    console.log('addUser');

    var name = $('#cname').val();
    var email = $('#cemail').val();
    var json = JSON.stringify({"name": name, "email": email});

    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + '/user',
        dataType: "json",
        data: json,
        // testar não passar nada como parametro
        success: function(data, textStatus, jqXHR){
            alert('User insert successfully');
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('error: ' + textStatus);
        }
    });
}

function addQuestions() {
    console.log('addQuestions');

    var question1 = $("#question1").val();
    var question2 = $("#question2").val().replace(/[^0-9\.]+/g, '');
    var question3 = $("#question3").val();
    var userId = $("#userId").val();

    var json = JSON.stringify({
            "question1": question1,
            "question2": question2,
            "question3": question3,
            "userId": userId,
        });

    $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: rootURL + '/question',
            dataType: "json",
            data: json,
            success: function(data, textStatus, jqXHR){
                alert('Question insert successfully');
            },
            error: function(jqXHR, textStatus, errorThrown){
                alert('error: ' + textStatus);
            }
        });
}