$(window).ready(function(){

    addActivityToButtons();
    refresh();
    addActivityToPanels();
});

var addActivityToButtons = function(){
}

var addActivityToPanels = function () {
    $('.nav-panel tbody tr').click(function(sender, arg){
        $(this).parent().find('tr.active').removeClass('active');
        $('.nav-panel ').removeClass('active');
        var np = $(this).parents('.nav-panel');
        if (np.length > 0){
            $(np).addClass('active');
        }
        $(this).addClass('active');
    });

    $('.nav-panel tbody tr').dblclick(function(sender, arg){

    });

}

var refresh = function(){
    var pans = $('.nav-panel');

    if ($('.nav-panel.active').length === 0){
        $(pans[0]).addClass('active');
    }

    for (var i = 0; i < pans.length; i++){
        var path = $(pans[i]).find('input.fs-path')[0].value;
        var selected = $(pans[i]).find('table tbody tr.active');

        var body = new Object();
        body.path = path;

        var resp = {};
        var setResp = function(response, context){
            $(context).find('table.file-table tbody').html(response);
            if (selected.length !== 0){
                var n = $(selected).find('td:nth-child(2)').text();
                var elem = $(context).find('table tr td:nth-child(2)[text="' + n + '"]').first();
                if (elem !== undefined ){
                    $(elem).parent().addClass('active');
                }
            }else{
                $(pans[i]).find('table tbody tr').first().addClass('active');
            }
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
    });
}



