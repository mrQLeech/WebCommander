$(window).ready(function(){

    addActivityToButtons();
    addDataToFilePanels();
});

var addActivityToButtons = function(){
}

var addDataToFilePanels = function () {
    var pans = $('.nav-panel');

    for (var i = 0; i < pans.length; i++){
        var path = $(pans[i]).find('input.fs-path')[0].value;

        var body = new Object();
        body.path = path;
        var resp = {};
        var setResp = function(response, context){
            $(context).find('table.file-table tbody').html(response);

        }

        postRequest("/files", body, "application/json", setResp, pans[i]);

    }
}

var postRequest = function(recieveLink, body, dataType, callback, context){
    $.ajax({
        type: "POST",
        url: recieveLink,
        data: body,
        dataType:'text',
        success: function(data){
            callback(data, context);
        },

        async: false
    }).done(function( data ) {
        alert("Callback ran!" + data);
    });
}
