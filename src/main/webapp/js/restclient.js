// The root URL for the RESTful services
var rootURL = "http://localhost:8080/splashpage";

$('#btnSave').click(function() {
    addUser();
});

function addUser() {
    console.log('addUser');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + '/user',
        dataType: "json",
        data: formToJSON(),
        success: function(data, textStatus, jqXHR){
            alert('User insert successfully');
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('error: ' + textStatus);
        }
    });
}

function formToJSON() {
    var name = $('#cname').val();
    var email = $('#cemail').val();
    return JSON.stringify({
        "name": name,
        "email": email
    });
}