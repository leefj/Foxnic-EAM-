layui.define([],
    function (exports) {
        function parseInspectPointItemConfig(field,value,r){
            if(field=="config"){
                var res=""
                if(r.type=="number_range"){
                    var obj= eval("("+value+")");
                    res="最小值:"+obj.min+" 最大值:"+obj.max;
                }else if (r.type=="input"){
                    res=res+"无"
                    console.log("none");
                }else if(r.type=="radiobox"){
                    var arr= eval("("+value+")");
                    for(var i=0;i<arr.length;i++){
                        var obj=arr[i];
                        if(obj.label){
                            res=res+" "+obj.label
                        }
                    }
                }
                return res;
            }else if(field=="defValue"){
                var res=value;
                if(r.type=="radiobox"){
                    if(value){
                        var arr= eval("("+r.config+")");
                        for(var i=0;i<arr.length;i++){
                            if(value==arr[i].code){
                                res=arr[i].label;
                                break;
                            }
                        }
                    }else{
                        res="";
                    }
                }
                return res;
            }
        }
        var eamCommonFunc = {
            parseInspectPointItemConfig:parseInspectPointItemConfig,
        }
        exports('eamCommonFunc', eamCommonFunc);
    });