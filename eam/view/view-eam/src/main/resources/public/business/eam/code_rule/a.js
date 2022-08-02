
function transferRightSort(arr) {
    var data=$("ul.layui-transfer-data")[1];
    var item_list=$(data).children("li");
    var middle_list=[];
    for(var key in arr){
        middle_list.push("")
     }
    console.info(arr)
    for(var i=0;i<item_list.length;i++){
        var item=item_list[i];
        var value=$(item_list).children("input")[i].value;
        var index=arr.indexOf(parselnt(value))
        console.info(index);
        middle_list[index]=item
    }

    var innertHTML=""
    for(var y=0;y<middle_list.length;y++){
        console.info($(middle_list).children("input")[y].value)
        $($("ul.layui-transfer-data")[1]).html(innertHTML)
    }
}