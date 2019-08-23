//需要layer.js
//需要jquery.js
$.myajax = function(opts,succfunc,errofunc){
    $.ajax({
        url: opts.url,
        type: opts.type,
        data: opts.data || {},
        dataType: "json",
        success: function(data){
            if(succfunc(data)){
                if(data.code == 404 && data.message == "请重新登录！"){
                    layer.msg(data.message,{icon: 2});
                    window.parent.location.href = "/";
                    return;
                }else if(data.code == 200){
                    layer.msg(data.message,{icon: 1});
                    return;
                }else if(data.code == 404){
                    layer.msg(data.message,{icon: 2});
                    return;
                }
            }
        },
        error: function(e){
            console.info(e);
            if(errofunc){
                errofunc(e);
            }
            if(e.message != null && e.message == "请重新登录！"){
                layer.msg(e.message,{icon: 2});
                window.parent.location.href = "/";
                return;
            }else{
                layer.msg("请重新登录",{icon: 2});
                window.parent.location.href = "/";
                return;
            }

        }
    })
}