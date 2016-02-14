$(window).ready(function(){

    addActivityToButtons();
    //addDataToFilePanels();
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
        var setResp = function(response){
            resp = response;
        }

        postRequest("/files", body, "application/json", setResp, pans[i]);

    }
}

var postRequest = function(recieveLink, body, dataType, callback, context){
    $.ajax({
        type: "POST",
        url: recieveLink,
        data: body,
        success: function(response){
            callback(response, context);
        },
        dataType: dataType,
        async: true
    });
}
