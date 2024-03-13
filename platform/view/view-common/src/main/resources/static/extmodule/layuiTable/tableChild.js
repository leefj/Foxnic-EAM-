/**
 *
 * @name:  子表格扩展
 * @author: yelog
 * @link: https://github.com/yelog/layui-soul-table
 * @license: MIT
 * @version: v1.8.0
 */
layui.define(["table", "element", "form", "laytpl"], function(exports) {
    var $ = layui.jquery
        , table = layui.table
        , laytpl = layui.laytpl
        , tableChildren = {}
        , HIDE = "layui-hide"
        , ELEM_HOVER = "soul-table-hover"
        , mod = {
        render: function(f) {
            var t, y = this, l = $(f.elem), e = l.next().children(".layui-table-box"), i = f.id, p = e.children(".layui-table-header").children("table"), m = e.children(".layui-table-fixed").children(".layui-table-body").children("table"), v = e.children(".layui-table-body").children("table"), x = $.merge(e.children(".layui-table-body").children("table"), m), a = y.getCompleteCols(f.cols), n = [], d = void 0 === f.soulSort || f.soulSort;
            for (y.fixHoverStyle(f),
                     t = 0; t < a.length; t++)
                a[t].children && 0 < a[t].children.length && n.push(t);
            if (void 0 === l.attr("lay-filter") && l.attr("lay-filter", i),
            0 === l.parents(".childTr").length && ("function" == typeof f.rowEvent && table.on("row(" + l.attr("lay-filter") + ")", function(e) {
                f.rowEvent(y.commonMember.call(this, y, f, e))
            }),
            "function" == typeof f.rowDoubleEvent && table.on("rowDouble(" + l.attr("lay-filter") + ")", function(e) {
                f.rowDoubleEvent(y.commonMember.call(this, y, f, e))
            }),
            "function" == typeof f.checkboxEvent && table.on("checkbox(" + l.attr("lay-filter") + ")", function(e) {
                f.checkboxEvent(y.commonMember.call(this, y, f, e))
            }),
            "function" == typeof f.editEvent && table.on("edit(" + l.attr("lay-filter") + ")", function(e) {
                f.editEvent(y.commonMember.call(this, y, f, e))
            }),
            "function" == typeof f.toolEvent && table.on("tool(" + l.attr("lay-filter") + ")", function(e) {
                f.toolEvent(y.commonMember.call(this, y, f, e))
            }),
            "function" == typeof f.toolbarEvent && table.on("toolbar(" + l.attr("lay-filter") + ")", function(e) {
                f.toolbarEvent(y.commonMember.call(this, y, f, e))
            })),
            0 < n.length)
                for (t = 0; t < n.length; t++)
                    !function() {
                        var u = a[n[t]]
                            , e = n[t]
                            , b = u.icon || ["layui-icon layui-icon-right", "layui-icon layui-icon-down"];
                        !d || f.url && f.page || table.on("sort(" + l.attr("lay-filter") + ")", function() {
                            y.render(f)
                        }),
                            u.isChild && "function" == typeof u.isChild ? x.find("tr").find('td[data-key$="' + u.key + '"]>div').each(function() {
                                u.isChild(layui.table.cache[i][$(this).parents("tr:eq(0)").data("index")]) && (u.field ? $(this).prepend('<i style="cursor: pointer" class="childTable ' + b[0] + '"></i>') : $(this).html('<i style="cursor: pointer" class="childTable ' + b[0] + '"></i>'))
                            }) : u.field ? x.find("tr").find('td[data-key$="' + u.key + '"]>div').prepend('<i style="cursor: pointer" class="childTable ' + b[0] + '"></i>') : x.find("tr").find('td[data-key$="' + u.key + '"]>div').html('<i style="cursor: pointer" class="childTable ' + b[0] + '"></i>'),
                            x.children("tbody").children("tr").each(function() {
                                $(this).children("td:eq(" + e + ")").find(".childTable").on("click", function(e) {
                                    layui.stope(e);
                                    var t, l = $(this).parents("tr:eq(0)").data("index"), a = f.id, i = $(this).parents("td:eq(0)").data("key"), n = v.children("tbody").children("tr[data-index=" + l + "]").children('td[data-key="' + i + '"]').find(".childTable:eq(0)"), d = m.find("tr[data-index=" + l + "]").children('td[data-key="' + i + '"]').find(".childTable:eq(0)"), r = table.cache[a][l], o = u.children, c = !1, e = "", h = x.children("tbody").children('tr[data-index="' + l + '"]'), s = {
                                        data: r,
                                        tr: h,
                                        del: function() {
                                            table.cache[a][l] = [],
                                                y.destroyChildren(l, f, b),
                                                h.remove(),
                                                table.resize(a)
                                        },
                                        update: function(e) {
                                            e = e || {},
                                                layui.each(e, function(l, e) {
                                                    var i, t;
                                                    l in r && (t = h.children('td[data-field="' + l + '"]'),
                                                        r[l] = e,
                                                        table.eachCols(a, function(e, t) {
                                                            t.field == l && t.templet && (i = t.templet)
                                                        }),
                                                        t.children(".layui-table-cell").html(i ? "function" == typeof i ? i(r) : laytpl($(i).html() || e).render(r) : e),
                                                        t.data("content", e))
                                                })
                                        },
                                        close: function() {
                                            y.destroyChildren(l, f, b),
                                                table.resize(a)
                                        }
                                    };
                                    if (n.hasClass(b[1])) {
                                        if ("function" == typeof u.childClose && !1 === u.childClose(s))
                                            return
                                    } else if ("function" == typeof u.childOpen && !1 === u.childOpen(s))
                                        return;
                                    "string" == typeof (o = "function" == typeof o ? o(r) : o) && (c = !0,
                                        e = y.parseTempData(u, u.field ? r[u.field] : null, r)),
                                        2 === u.show ? (!u.layerOption || "function" == typeof u.layerOption.title && (u.layerOption.title = u.layerOption.title(r)),
                                            layer.open($.extend({
                                                type: 1,
                                                title: "子表",
                                                maxmin: !0,
                                                content: y.getTables(this, r, u, f, o, c, e),
                                                area: "1000px",
                                                offset: "100px",
                                                cancel: function() {
                                                    "function" == typeof u.childClose && u.childClose(s)
                                                }
                                            }, u.layerOption || {})),
                                        c || y.renderTable(this, r, u, f, o, b)) : (!n.hasClass(b[1]) && u.collapse && x.children("tbody").children("tr").children("td").find(".childTable").each(function() {
                                            $(this).hasClass(b[1]) && y.destroyChildren($(this).parents("tr:eq(0)").data("index"), f, b)
                                        }),
                                        n.hasClass(b[1]) || n.parents("tr:eq(0)").children("td").find(".childTable").each(function() {
                                            $(this).hasClass(b[1]) && ($(this).removeClass(b[1]).addClass(b[0]),
                                                y.destroyChildren($(this).parents("tr:eq(0)").data("index"), f, b))
                                        }),
                                            n.hasClass(b[1]) ? (n.removeClass(b[1]).addClass(b[0]),
                                                d.removeClass(b[1]).addClass(b[0])) : (n.removeClass(b[0]).addClass(b[1]),
                                                d.removeClass(b[0]).addClass(b[1])),
                                            i = n.parents("td:eq(0)").attr("rowspan"),
                                            n.hasClass(b[1]) ? ((d = []).push('<tr data-tpl="' + c + '" class="noHover childTr"><td colspan="' + p.find("th:visible").length + '"  style="cursor: inherit; padding: 0;">'),
                                                d.push(y.getTables(this, r, u, f, o, c, e)),
                                                d.push("</td></tr>"),
                                                i ? (i = parseInt(n.parents("tr:eq(0)").data("index")) + parseInt(i) - 1,
                                                    n.parents("table:eq(0)").children().children("[data-index='" + i + "']").after(d.join(""))) : n.parents("tr:eq(0)").after(d.join("")),
                                                layui.element.init("tab"),
                                            c || (y.renderTable(this, r, u, f, o, b),
                                                n.parents("tr:eq(0)").next().children("td").children(".layui-tab").children(".layui-tab-content").on("click", function(e) {
                                                    $(e.target.parentElement).hasClass("layui-tab-title") || e.stopPropagation()
                                                }).off("dblclick").on("dblclick", function(e) {
                                                    e.stopPropagation()
                                                }).on("mouseenter", "td", function(e) {
                                                    e.stopPropagation()
                                                }).on("change", function(e) {
                                                    layui.stope(e)
                                                })),
                                            0 < m.length && (o = n.parents("tr:eq(0)").next(),
                                                t = '<div class="soul-table-child-patch" style="height: ' + o.children("td").height() + 'px"></div>',
                                                o.children("td").children(".soul-table-child-wrapper").css({
                                                    position: "absolute",
                                                    top: 0,
                                                    width: "100%",
                                                    background: "white",
                                                    "z-index": 200
                                                }),
                                                o.children("td").append(t),
                                                m.find('tr[data-index="' + l + '"]').each(function() {
                                                    $(this).after('<tr><td style="padding: 0;" colspan="' + $(this).children("[data-key]").length + '">' + t + "</td></tr>")
                                                }),
                                                table.resize(a)),
                                            3 === u.show && (n.parents("tr:eq(0)").next().find(".layui-table-view").css({
                                                margin: 0,
                                                "border-width": 0
                                            }),
                                                n.parents("tr:eq(0)").next().find(".layui-table-header").css("display", "none"))) : (y.destroyChildren(l, f, b),
                                                table.resize(a)))
                                })
                            }),
                        u.spread && 2 !== u.show && x.children("tbody").children("tr").children("td").find(".childTable").trigger("click")
                    }()
        },
        getTables: function(e, t, l, i, a, n, d) {
            var r, o = [], c = $(i.elem), h = c.next().children(".layui-table-box"), s = i.id + $(e).parents("tr:eq(0)").data("index"), i = h.children(".layui-table-header").children("table"), e = c.next().children(".layui-table-box").children(".layui-table-body"), h = e.children("table"), c = 0;
            if (n ? o.push('<div class="soul-table-child-wrapper" style="margin: 0;border: 0;box-shadow: none;') : o.push('<div class="layui-tab layui-tab-card soul-table-child-wrapper" lay-filter="table-child-tab-' + s + '" style="margin: 0;border: 0;box-shadow: none;'),
                2 === l.show ? o.push("max-width: " + (h.width() - 2) + 'px">') : 3 === l.show || "full" === l.childWidth ? o.push('">') : (e.prop("scrollHeight") + (0 < a.length ? a[0].height : 0) > e.height() && (c = this.getScrollWidth()),
                    c = e.width() - 1 - c,
                    o.push("max-width: " + (c > i.width() ? i.width() : c) + 'px">')),
                n)
                o.push(d);
            else {
                if (3 !== l.show && (void 0 === l.childTitle || l.childTitle)) {
                    for (o.push('<ul class="layui-tab-title">'),
                             r = 0; r < a.length; r++)
                        o.push('<li class="' + (0 === r ? "layui-this" : "") + '">' + ("function" == typeof a[r].title ? a[r].title(t) : a[r].title) + "</li>");
                    o.push("</ul>")
                }
                for (3 === l.show ? o.push('<div class="layui-tab-content" style="padding: 0">') : o.push('<div class="layui-tab-content" style="padding: 0 10px">'),
                         r = 0; r < a.length; r++) {
                    var u = s + r;
                    o.push('<div class="layui-tab-item layui-show"><form action="" class="layui-form" ><table id="' + u + '" lay-filter="' + u + '"></table></form></div>')
                }
                o.push("</div>")
            }
            return o.push("</div>"),
                o.join("")
        },
        renderTable: function(a, n, d, r, o, e) {
            var t = []
                , c = this
                , h = r.id
                , s = h + $(a).parents("tr:eq(0)").data("index");
            if (d.lazy)
                t.push(b(c, a, n, d, r, 0, o, e));
            else
                for (var u = 0; u < o.length; u++)
                    t.push(b(c, a, n, d, r, u, o, e));
            function b(t, e, l, i, a, n, d, r) {
                var o = t.deepClone(d[n])
                    , c = a.id
                    , h = $(e).parents("tr:eq(0)").data("index")
                    , d = c + h + n
                    , e = $(a.elem).next().children(".layui-table-box")
                    , s = $.merge(e.children(".layui-table-body").children("table"), e.children(".layui-table-fixed").children(".layui-table-body").children("table")).children("tbody").children('tr[data-index="' + h + '"]')
                    , u = table.cache[c][h]
                    , b = {
                    data: u,
                    tr: s,
                    del: function() {
                        table.cache[c][h] = [],
                            t.destroyChildren(h, a, r),
                            s.remove(),
                            table.resize(c)
                    },
                    update: function(e) {
                        e = e || {},
                            layui.each(e, function(l, e) {
                                var i, t;
                                l in u && (t = s.children('td[data-field="' + l + '"]'),
                                    u[l] = e,
                                    table.eachCols(c, function(e, t) {
                                        t.field == l && t.templet && (i = t.templet)
                                    }),
                                    t.children(".layui-table-cell").html(i ? "function" == typeof i ? i(u) : laytpl($(i).html() || e).render(u) : e),
                                    t.data("content", e))
                            })
                    },
                    close: function() {
                        t.destroyChildren(h, a, r),
                            table.resize(c)
                    }
                };
                return o.id = d,
                    o.elem = "#" + d,
                "function" == typeof o.where && (o.where = o.where(l)),
                "function" == typeof o.data && (o.data = o.data(l)),
                "function" == typeof o.url && (o.url = o.url(l)),
                    l = table.render(o),
                i.lazy || 0 === n || $("#" + d).parents(".layui-tab-item:eq(0)").removeClass("layui-show"),
                "function" == typeof o.checkboxEvent && table.on("checkbox(" + d + ")", function(e) {
                    o.checkboxEvent(t.commonMember.call(this, t, o, e), b)
                }),
                "function" == typeof o.editEvent && table.on("edit(" + d + ")", function(e) {
                    o.editEvent(t.commonMember.call(this, t, o, e), b)
                }),
                "function" == typeof o.toolEvent && table.on("tool(" + d + ")", function(e) {
                    o.toolEvent(t.commonMember.call(this, t, o, e), b)
                }),
                "function" == typeof o.toolbarEvent && table.on("toolbar(" + d + ")", function(e) {
                    o.toolbarEvent(t.commonMember.call(this, t, o, e), b)
                }),
                "function" == typeof o.rowEvent && table.on("row(" + d + ")", function(e) {
                    o.rowEvent(t.commonMember.call(this, t, o, e), b)
                }),
                "function" == typeof o.rowDoubleEvent && table.on("rowDouble(" + d + ")", function(e) {
                    o.rowDoubleEvent(t.commonMember.call(this, t, o, e), b)
                }),
                    l
            }
            tableChildren[s] = t,
                layui.element.on("tab(table-child-tab-" + s + ")", function(e) {
                    if (d.lazy) {
                        var t = !1;
                        for (u = 0; u < tableChildren[s].length; u++)
                            if (tableChildren[s][u].config.id === s + e.index) {
                                t = !0;
                                break
                            }
                        t || tableChildren[s].push(b(c, a, n, d, r, e.index, o))
                    }
                    var l = $(a).parents("tr:eq(0)").data("index")
                        , i = $(e.elem).height();
                    $(a).parents(".layui-table-box:eq(0)").children(".layui-table-body").children("table").children("tbody").children("tr[data-index=" + l + "]").next().children().children(".soul-table-child-patch").css("height", i),
                        $(a).parents(".layui-table-box:eq(0)").children(".layui-table-fixed").children(".layui-table-body").children("table").children("tbody").children("tr[data-index=" + l + "]").next().children().children(".soul-table-child-patch").css("height", i),
                        table.resize(h)
                })
        },
        destroyChildren: function(e, t, l) {
            var i = t.id
                , a = $(t.elem).next().children(".layui-table-box")
                , t = a.children(".layui-table-fixed").children(".layui-table-body").children("table")
                , a = $.merge(a.children(".layui-table-body").children("table"), t).children("tbody").children('tr[data-index="' + e + '"]')
                , t = a.next().data("tpl");
            if (a.find(".childTable").removeClass(l[1]).addClass(l[0]),
                a.next().remove(),
            "false" === t) {
                t = tableChildren[i + e];
                if (layui.tableFilter && layui.tableFilter.destroy(t),
                    layui.soulTable)
                    for (var n = 0; n < tableChildren[i + e].length; n++)
                        layui.soulTable.clearOriginCols(tableChildren[i + e][n].config.id)
            }
            delete tableChildren[i + e]
        },
        cloneJSON: function(obj) {
            var JSON_SERIALIZE_FIX = {
                PREFIX: "[[JSON_FUN_PREFIX_",
                SUFFIX: "_JSON_FUN_SUFFIX]]"
            }
                , sobj = JSON.stringify(obj, function(e, t) {
                return "function" == typeof t ? JSON_SERIALIZE_FIX.PREFIX + t.toString() + JSON_SERIALIZE_FIX.SUFFIX : t
            });
            return JSON.parse(sobj, function(key, value) {
                return "string" == typeof value && 0 < value.indexOf(JSON_SERIALIZE_FIX.SUFFIX) && 0 === value.indexOf(JSON_SERIALIZE_FIX.PREFIX) ? eval("(" + value.replace(JSON_SERIALIZE_FIX.PREFIX, "").replace(JSON_SERIALIZE_FIX.SUFFIX, "") + ")") : value
            }) || {}
        },
        fixHoverStyle: function(e) {
            var e = $(e.elem)
                , l = e.next().children(".layui-table-box").children(".layui-table-body").children("table")
                , i = e.next().children(".layui-table-box").children(".layui-table-fixed").children(".layui-table-body").children("table")
                , e = e.next().find("style")[0]
                , e = e.sheet || e.styleSheet || {};
            this.addCSSRule(e, ".layui-table-hover", "background-color: inherit"),
                this.addCSSRule(e, ".layui-table-hover.soul-table-hover", "background-color: #F2F2F2"),
                $.merge(i.children("tbody").children("tr"), l.children("tbody").children("tr")).on("mouseenter", function() {
                    var e = $(this)
                        , t = $(this).data("index");
                    e.data("off") || (i.children("tbody").children("tr[data-index=" + t + "]").addClass(ELEM_HOVER),
                        l.children("tbody").children("tr[data-index=" + t + "]").addClass(ELEM_HOVER))
                }).on("mouseleave", function() {
                    var e = $(this)
                        , t = $(this).data("index");
                    e.data("off") || (i.children("tbody").children("tr[data-index=" + t + "]").removeClass(ELEM_HOVER),
                        l.children("tbody").children("tr[data-index=" + t + "]").removeClass(ELEM_HOVER))
                })
        },
        addCSSRule: function(e, t, l, i) {
            "insertRule"in e ? e.insertRule(t + "{" + l + "}", i) : "addRule"in e && e.addRule(t, l, i)
        },
        deepClone: function(e) {
            var t = Array.isArray(e) ? [] : {};
            if (e && "object" == typeof e)
                for (var l in e)
                    e.hasOwnProperty(l) && (t[l] = e && "object" == typeof e[l] ? this.deepClone(e[l]) : e[l]);
            return t
        },
        getCompleteCols: function(e) {
            for (var t, l, i, a = this.deepClone(e), n = 0; n < a.length; n++)
                for (t = 0; t < a[n].length; t++)
                    if (!a[n][t].exportHandled) {
                        if (1 < a[n][t].rowspan)
                            for ((i = this.deepClone(a[n][t])).exportHandled = !0,
                                     l = n + 1; l < a.length; )
                                a[l].splice(t, 0, i),
                                    l++;
                        if (1 < a[n][t].colspan) {
                            for ((i = this.deepClone(a[n][t])).exportHandled = !0,
                                     l = 1; l < a[n][t].colspan; l++)
                                a[n].splice(t, 0, i);
                            t = t + parseInt(a[n][t].colspan) - 1
                        }
                    }
            return a[a.length - 1]
        },
        getScrollWidth: function(e) {
            var t = 0;
            return e ? t = e.offsetWidth - e.clientWidth : ((e = document.createElement("div")).style.width = "100px",
                e.style.height = "100px",
                e.style.overflowY = "scroll",
                document.body.appendChild(e),
                t = e.offsetWidth - e.clientWidth,
                document.body.removeChild(e)),
                t
        },
        parseTempData: function(e, t, l, i) {
            t = e.children ? "function" == typeof e.children ? e.children(l) : laytpl($(e.children).html() || String(t)).render(l) : t;
            return i ? $("<div>" + t + "</div>").text() : t
        },
        commonMember: function(a, e, t) {
            var l = $(this)
                , n = e.id
                , i = $(e.elem).next().children(".layui-table-box")
                , d = i.children(".layui-table-fixed").children(".layui-table-body").children("table")
                , d = $.merge(i.children(".layui-table-body").children("table"), d)
                , r = ("TR" === l[0].tagName ? $(this) : l.parents("tr:eq(0)")).data("index")
                , o = d.children("tbody").children('tr[data-index="' + r + '"]')
                , c = (c = table.cache[n] || [])[r] || {};
            return $.extend(t, {
                tr: o,
                oldValue: l.prev() ? l.prev().text() : null,
                del: function() {
                    table.cache[n][r] = [],
                        o.remove(),
                        a.scrollPatch(e)
                },
                update: function(e) {
                    e = e || {},
                        layui.each(e, function(l, e) {
                            var i, t;
                            l in c && (t = o.children('td[data-field="' + l + '"]'),
                                c[l] = e,
                                table.eachCols(n, function(e, t) {
                                    t.field == l && t.templet && (i = t.templet)
                                }),
                                t.children(".layui-table-cell").html(a.parseTempData({
                                    templet: i
                                }, e, c)),
                                t.data("content", e))
                        })
                }
            })
        },
        scrollPatch: function(e) {
            var t = $(e.elem)
                , l = t.next().children(".layui-table-box").children(".layui-table-header")
                , i = t.next().children(".layui-table-total")
                , a = t.next().children(".layui-table-box").children(".layui-table-main")
                , n = t.next().children(".layui-table-box").children(".layui-table-fixed")
                , d = t.next().children(".layui-table-box").children(".layui-table-fixed-r")
                , r = a.children("table")
                , o = a.width() - a.prop("clientWidth")
                , c = a.height() - a.prop("clientHeight")
                , e = r.outerWidth() - a.width()
                , t = function(e) {
                var t;
                o && c ? (e = e.eq(0)).find(".layui-table-patch")[0] || ((t = $('<th class="layui-table-patch"><div class="layui-table-cell"></div></th>')).find("div").css({
                    width: o
                }),
                    e.find("tr").append(t)) : e.find(".layui-table-patch").remove()
            };
            t(l),
                t(i);
            a = a.height() - c;
            n.find(".layui-table-body").css("height", r.height() >= a ? a : "auto"),
                d[0 < e ? "removeClass" : "addClass"](HIDE),
                d.css("right", o - 1)
        }
    };
    exports("tableChild", mod)
});
