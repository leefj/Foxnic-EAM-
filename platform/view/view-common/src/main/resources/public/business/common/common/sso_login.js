layui.config({
    base: '/module/'
}).use(['form','settings'], function () {

    console.log("LANGUAGES",LANGUAGES)
    console.log("USER_LANGUAGE_PROP",USER_LANGUAGE_PROP)
    console.log("USER_LANGUAGE_CODE",USER_LANGUAGE_CODE)
    console.log("LANGUAGE_RANGE",LANGUAGE_RANGE)



    let $ = layui.jquery;
    let config = layui.settings;

    if(USER_LOGIN_JSON) {
        var user=USER_LOGIN_JSON;
        user.user.displayName=user.user.realName;
        config.putUser(user);
        config.putToken(user.token);
    }

    var localLangProp=config.getLang();
    var localLangCode=null;
    if(!localLangProp || localLangProp=='undefined') localLangProp="defaults";
    // 初始化
    if(localLangProp && localLangProp!=USER_LANGUAGE_PROP) {
        debugger
        for (var i=0;i<LANGUAGES.length;i++) {
            if(LANGUAGES[i].property==USER_LANGUAGE_PROP) {
                localLangCode=LANGUAGES[i].code;
                localLangProp=LANGUAGES[i].property;
            }
        }
        if(!localLangCode) {
            localLangCode="defaults";
            localLangProp="defaults";
        }
        switchLanguage(localLangCode,localLangProp);
    }

    config.setLang(USER_LANGUAGE_PROP);

    initLanguage(function (){});

    //
    function switchLanguage(code,prop) {
        $.ajax({
            async: true,
            type: 'POST',
            async: true,
            data:{code:code},
            url: config.base_server + '/service-system/sys-lang/switch-language',
            success:function (r) {
                config.setLang(r.data.property);
            }
        });
    }
    //
    function initLanguage(cb) {

        // 清除多语言数据
        localStorage.removeItem("language_codeLangs");
        localStorage.removeItem("language_defaultsLangs");
        localStorage.removeItem("language_timestamp");
        $.ajax({
            async: true,
            type: 'POST',
            async: true,
            url: config.base_server + '/service-system/sys-lang/query-list?lang='+USER_LANGUAGE_CODE,
            success:function (data) {
                data=data.data;
                console.dir(data);
                //debugger;
                var codeLangs={};
                var defaultsLangs={};
                for (var i = 0; i < data.length; i++) {
                    codeLangs[data[i].context+":"+data[i].code]=data[i];
                    defaultsLangs[data[i].context+":"+data[i].defaults]=data[i];
                }
                localStorage.setItem("language_codeLangs",JSON.stringify(codeLangs));
                localStorage.setItem("language_defaultsLangs",JSON.stringify(defaultsLangs));
                localStorage.setItem("language_timestamp",(new Date()).getTime());
                cb();
                logger.info("sso","language loaded")
                location.replace(REDIRECT);
                // alert("REDIRECT = "+REDIRECT)
            }
        });
    }



});
