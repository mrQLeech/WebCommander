$(window).ready(function(){

    addActivityToButtons();
    refresh();

});

var addActivityToButtons = function(){
}

var addActivityToPanel = function (panel) {
    $(panel).find('table tbody tr').click(function(sender, arg){
        $(this).parent().find('tr.active').removeClass('active');
        $('.nav-panel ').removeClass('active');
        var np = $(this).parents('.nav-panel');
        if (np.length > 0){
            $(np).addClass('active');
        }
        $(this).addClass('active');
    });

    $(panel).find('table tbody tr').dblclick(function(sender, arg){
        var panel = $(this).parents('.nav-panel')[0];
        refreshPanel(panel, true);
    });

}

var refresh = function(){
    var pans = $('.nav-panel');

    if ($('.nav-panel.active').length === 0){
        $(pans[0]).addClass('active');
    }

    for (var i = 0; i < pans.length; i++){
        refreshPanel(pans[i]);
    }
}

var refreshPanel = function(panel, pathChanging){
    var path = $(panel).find('input.fs-path')[0].value;

    var body = new Object();
    var selected = $(panel).find('table tbody tr.active');

    body.path = path;

    if (pathChanging){
        var selection = $(panel).find('table tbody tr.active td:nth-child(2)').text();
        body.selection = selection;
    }

    var setResp = function(response, context){
        var resObj = JSON.parse(response);
        var mark = resObj.markup;
        var path = resObj.path;


        $(context).find('table.file-table tbody').html(mark);
        if (selected.length !== 0){
            var n = $(selected).find('td:nth-child(2)').text();
            var elem = $(context).find('table tr td:nth-child(2)[text="' + n + '"]').first();
            if (elem !== undefined ){
                $(elem).parent().addClass('active');
            }
        }else{
            $(panel).find('table tbody tr').first().addClass('active');
        }

        $(context).find('input.fs-path').val(path);

        addActivityToPanel(panel);
    }

    postRequest("/files", body, "application/json", setResp, panel);
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



