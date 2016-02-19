$(window).ready(function(){

    addActivityToNavButtons();
    refresh();

});

var addActivityToNavButtons = function(){
    createFolderActivity();
}


var createFolderActivity = function(){
    $('.do-button.create-button').click(function(ev){
        $('splash-panel').show();
        $('.create-folder-form-panel').show();
    });

    $('.create-folder-form-panel .do-button.cancel').click(function(ev){
        $('splash-panel').hide();
        $('.create-folder-form-panel .fs-path.folder-name').val("");
        $('.create-folder-form-panel').hide();
    });

    $('.create-folder-form-panel .do-button.create-folder').click(function(ev){
        /*String pseudoPath = request.getParameter("path");
        String selected = request.getParameter("objectName");
        String crudDoName = request.getParameter("whatWeDo");




        if (crudDoName.equals("createFolder")){*/
        var newFolderName = $('.create-folder-form-panel .folder-name').val();

        var panel = $('.nav-panel.active')[0];
        var path = getPanelPath(panel);

        var body = {};

        body.path = path;
        body.objectName = newFolderName;
        body.whatWeDo = "createFolder";

        var respHandler = function(sender, args){
            refresh();
        }

        postRequest("/fileManagerServ", body, "application/json", respHandler, error, panel);

    });
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
    var path = getPanelPath(panel);

    var body = new Object();
    var selected = $(panel).find('table tbody tr.active');

    body.path = path;

    if (pathChanging){
        var selection = getPanelSelection(panel);
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



    postRequest("/files", body, "application/json", setResp, error, panel);
}

var getPanelPath = function(panel){
    var path = $(panel).find('input.fs-path')[0].value;
    return path;
}

var getPanelSelection = function (panel){
    var selection = $(panel).find('table tbody tr.active td:nth-child(2)').text();
    return selection;
}

var error = function(resp){
    alert(resp);
}

var postRequest = function(recieveLink, body, dataType, callback, err,  context){
    $.ajax({
        type: "POST",
        url: recieveLink,
        data: body,
        dataType:'text',
        success: function(data){
            callback(data, context);
        },
        error: function (data){
            err(data);
        },

        async: false
    });
}



