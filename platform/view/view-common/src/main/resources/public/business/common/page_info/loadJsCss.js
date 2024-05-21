/**
 * 插件功能：使用localStorage缓存js和css文件，减少http请求和页面渲染时间，适用于Web移动端H5页面制作。
 * 使用方法：
 *   1.使用此插件前，需要给插件的pageVersion变量赋值，建议变量值由服务器后端输出，当需要更新客户端资源时，修改版本值即可。
 *   2.加载Js：由于js加载有顺序要求，所以需要将后加载的脚本作为前一个脚本的回调参数传入，如：
 *   whir.res.loadJs("jquery", "<%= BasePath %>Turntable/Script/jquery-1.8.3.min.js",
 *       function () {
 *            whir.res.loadJs("turntable", "Script/whir.turntable.js", null);
 *    });
 *   3.加载css，如：whir.res.loadCss("abc", "/Style/abc.css", null);
 */
var whir = window.whir || {};
whir.res = {
    pageVersion: "", //页面版本，由页面输出，用于刷新localStorage缓存
    //动态加载js文件并缓存
    loadJs: function (name, url, callback) {
        if (window.localStorage) {
            var xhr;  　　　　　　　 　　　　　　// 存储 获取　
            var js = localforage.getItem(name);  　　　　　　　　　　　　　　// 如果版本有更新, 或者js没读出来, 就用ajax获取最新的
            if (js == null || js.length == 0 || this.pageVersion != localforage.getItem("version")) {
                if (window.ActiveXObject) {
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                } else if (window.XMLHttpRequest) {
                    xhr = new XMLHttpRequest();
                }
                if (xhr != null) {
                    xhr.open("GET", url);
                    xhr.send(null);
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4 && xhr.status == 200) {
                            js = xhr.responseText;  　　　　　　　　　　　　　　　　//储存 更新
                            localforage.setItem(name, js);
                            localforage.setItem("version", whir.res.pageVersion);
                            js = js == null ? "" : js;  　　　　　　　　　　　　　　　　 //创建一个link标签
                            whir.res.writeJs(js);
                            if (callback != null) {
                                callback(); //回调，执行下一个引用
                            }
                        }
                    };
                }
            } else {
                whir.res.writeJs(js);
                if (callback != null) {
                    callback(); //回调，执行下一个引用
                }
            }
        } else {
            whir.res.linkJs(url);
        }
    },
    loadCss: function (name, url) {
        if (window.localStorage) {
            var xhr;
            var css = localforage.getItem(name);
            if (css == null || css.length == 0 || this.pageVersion != localforage.getItem("version")) {
                if (window.ActiveXObject) {
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                } else if (window.XMLHttpRequest) {
                    xhr = new XMLHttpRequest();
                }
                if (xhr != null) {
                    xhr.open("GET", url);
                    xhr.send(null);
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4 && xhr.status == 200) {
                            css = xhr.responseText;
                            localforage.setItem(name, css);
                            localforage.setItem("version", whir.res.pageVersion);
                            css = css == null ? "" : css;
                            css = css.replace(/images\//g, "style/images/"); //css里的图片路径需单独处理
                            whir.res.writeCss(css);
                        }
                    };
                }
            } else {
                css = css.replace(/images\//g, "style/images/"); //css里的图片路径需单独处理
                whir.res.writeCss(css);
            }
        } else {  　　　　　　 //不支持ls, 只能重新获取
            whir.res.linkCss(url);
        }
    },
    //往页面写入js脚本
    writeJs: function (text) {
        var head = document.getElementsByTagName('HEAD').item(0);
        var link = document.createElement("script");
        link.type = "text/javascript";
        link.innerHTML = text;
        head.appendChild(link);
    },
    //往页面写入css样式
    writeCss: function (text) {
        var head = document.getElementsByTagName('HEAD').item(0);
        var link = document.createElement("style");
        link.type = "text/css";
        link.innerHTML = text;
        head.appendChild(link);
    },
    //往页面引入js脚本
    linkJs: function (url) {
        var head = document.getElementsByTagName('HEAD').item(0);
        var link = document.createElement("script");
        link.type = "text/javascript";
        link.src = url;
        head.appendChild(link);
    },
    //往页面引入css样式
    linkCss: function (url) {
        var head = document.getElementsByTagName('HEAD').item(0);
        var link = document.createElement("link");
        link.type = "text/css";
        link.rel = "stylesheet";
        link.rev = "stylesheet";
        link.media = "screen";
        link.href = url;
        head.appendChild(link);
    }
}