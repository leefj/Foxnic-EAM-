var be=Object.defineProperty,ke=Object.defineProperties;var xe=Object.getOwnPropertyDescriptors;var re=Object.getOwnPropertySymbols;var ye=Object.prototype.hasOwnProperty,we=Object.prototype.propertyIsEnumerable;var de=(r,i,v)=>i in r?be(r,i,{enumerable:!0,configurable:!0,writable:!0,value:v}):r[i]=v,Z=(r,i)=>{for(var v in i||(i={}))ye.call(i,v)&&de(r,v,i[v]);if(re)for(var v of re(i))we.call(i,v)&&de(r,v,i[v]);return r},ee=(r,i)=>ke(r,xe(i));import{d as ue,b5 as Ie,a7 as Ee,j as oe,p as te,J as _e,a5 as D,Y as le,cU as $e,cV as He,cW as Te,r as n,o as p,c as b,e,w as o,f as y,q as d,F as L,s as P,am as ne,O as Oe,u as w,Q as Se,al as q,a2 as se,a6 as z,cX as De,cY as ze,z as pe,A as ve,h as me,L as ie,D as F,t as Re}from"./index-c6cc3b14.js";import{n as Ae}from"./noData-9e194391.js";import{g as U}from"./plugin-0dcb0bd6.js";import{i as fe}from"./icon-8314374d.js";import{u as Ue,E as Y}from"./chartEditStore-3ee495ca.js";import{l as Le}from"./index-af8cb105.js";const ae=r=>(pe("data-v-04bb59e0"),r=r(),ve(),r),Pe={key:0,class:"create-color-setting"},Be={class:"color-list-box go-mt-3","x-gap":12,"y-gap":12,cols:4},Me={class:"go-flex-items-center"},je=ae(()=>d("span",{class:"go-mr-4"},"添加",-1)),Ne={class:"expend-color-box"},Ve=["onClick"],Fe=ae(()=>d("div",{class:"n-color-picker-checkboard"},null,-1)),Ye=["onClick"],qe=ae(()=>d("div",{class:"n-color-picker-checkboard"},null,-1)),Je=ue({__name:"index",props:{selectColor:Object},emits:["updateColor"],setup(r,{emit:i}){const v=r;Ie(l=>({"3d26029e":u.color}));const{AddIcon:J,TrashIcon:Q}=fe.ionicons5,W=Le(()=>Ee(()=>import("./index-cb0ddbc9.js"),["static/js/index-cb0ddbc9.js","static/js/index.esm.min-4d91f069.js","static/js/index-c6cc3b14.js","static/css/index-9c2eb289.css","static/js/chartEditStore-3ee495ca.js","static/js/plugin-0dcb0bd6.js","static/js/icon-8314374d.js"])),s=oe(),u=te({index:-1,color:""});_e(()=>{var l;return(l=v.selectColor)==null?void 0:l.id},()=>{var l;s.value=D(v.selectColor),u.index=0,u.color=(l=s.value)==null?void 0:l.color[0]},{immediate:!0,deep:!1});const T=le(()=>C(u.color)),C=l=>{if(!l)return{default:[],fade:[]};const a=36,m=[],I=[],t=[];for(let c=0;c<a;c++)I.unshift($e(l,1/100*(c+1))),m.push(He(l,3.5/100*(c+1)));return m.forEach((c,g)=>{t.unshift(Te(c,1/100*(g+1)))}),{default:[...I.reverse().splice(0,parseInt(`${a/2}`)-9),...m.splice(0,parseInt(`${a/2}`))],fade:t.reverse().splice(0,27)}},_=l=>({backgroundColor:l}),h=(l,a)=>{u.color=l,u.index=a},k=(l,a)=>{l&&(u.color=l),a&&(u.index=a),z(()=>{i("updateColor",s.value)})},B=(l,a)=>{const m=a?De(l):ze(l);s.value&&(s.value.color[u.index]=m),z(()=>{i("updateColor",s.value)})},R=()=>{var a,m,I;const l=((m=s.value)==null?void 0:m.color[((a=s.value)==null?void 0:a.color.length)-1])||"#2c2c31";(I=s.value)==null||I.color.push(l),z(()=>{i("updateColor",s.value)})},M=l=>{var a,m;(a=s.value)==null||a.color.splice(l,1),l===u.index&&k((m=s.value)==null?void 0:m.color[l-1],l-1)},X=()=>{z(()=>{i("updateColor",s.value)})};return(l,a)=>{const m=n("n-input-group-label"),I=n("n-input"),t=n("n-input-group"),c=n("n-tag"),g=n("n-space"),E=n("n-color-picker"),j=n("n-icon"),A=n("n-tooltip"),O=n("n-button"),G=n("n-scrollbar"),S=n("n-card"),N=n("n-text"),V=n("n-divider");return s.value?(p(),b("div",Pe,[e(S,{bordered:!1,role:"dialog",size:"small","aria-modal":"true"},{default:o(()=>[e(g,{justify:"space-between"},{default:o(()=>[e(t,null,{default:o(()=>[e(m,null,{default:o(()=>[y("名称:")]),_:1}),e(I,{class:"create-color-name",value:s.value.name,"onUpdate:value":a[0]||(a[0]=x=>s.value.name=x),valueModifiers:{trim:!0},maxlength:"8","show-count":"",clearable:"",onChange:X},null,8,["value"])]),_:1}),e(c,{type:"warning"},{default:o(()=>[y("底部图表仅展示 7 条数据")]),_:1})]),_:1}),e(G,{style:{"max-height":"132px"}},{default:o(()=>[d("div",Be,[(p(!0),b(L,null,P(s.value.color,(x,f)=>(p(),b("div",{class:"color-list-item",key:f},[d("div",{class:ne(["go-flex-items-center",{select:f===u.index}])},[e(E,{style:{width:"95px"},value:s.value.color[f],"onUpdate:value":$=>s.value.color[f]=$,"show-preview":!0,modes:["hex"],onComplete:$=>k($,f),"onUpdate:show":$=>h(x,f)},null,8,["value","onUpdate:value","onComplete","onUpdate:show"]),Oe(d("div",null,[e(A,{trigger:"hover"},{trigger:o(()=>[e(j,{class:"go-ml-1 go-cursor-pointer",size:"16",depth:3,onClick:$=>M(f)},{default:o(()=>[e(w(Q))]),_:2},1032,["onClick"])]),default:o(()=>[y(" 删除颜色 ")]),_:2},1024)],512),[[Se,f>5]])],2)]))),128)),d("div",null,[e(O,{type:"primary",secondary:"",onClick:R},{default:o(()=>[d("div",Me,[je,e(j,{size:"16"},{default:o(()=>[e(w(J))]),_:1})])]),_:1})])])]),_:1})]),_:1}),d("div",Ne,[e(S,{class:"go-mt-3 expend-color",bordered:!1,role:"dialog",size:"small","aria-modal":"true"},{default:o(()=>[e(N,null,{default:o(()=>[y("默认扩展色：")]),_:1}),e(V,{style:{margin:"10px 0"}}),e(g,{size:[4,0],justify:"center"},{default:o(()=>[(p(!0),b(L,null,P(T.value.default,(x,f)=>(p(),b("div",{class:"color-computed-item",key:f,onClick:$=>B(x,!1)},[Fe,d("div",{style:q(_(x))},null,4)],8,Ve))),128))]),_:1})]),_:1}),e(S,{class:"go-mt-3 expend-color",bordered:!1,role:"dialog",size:"small","aria-modal":"true"},{default:o(()=>[e(N,null,{default:o(()=>[y("透明扩展色：")]),_:1}),e(V,{style:{margin:"10px 0"}}),e(g,{size:[4,0],justify:"center"},{default:o(()=>[(p(!0),b(L,null,P(T.value.fade,(x,f)=>(p(),b("div",{class:"color-computed-item",key:f,onClick:$=>B(x,!0)},[qe,d("div",{style:q(_(x))},null,4)],8,Ye))),128))]),_:1})]),_:1})]),e(w(W),{color:w(D)(s.value.color).splice(0,7)},null,8,["color"])])):se("",!0)}}});const Qe=me(Je,[["__scopeId","data-v-04bb59e0"]]),Ce=r=>(pe("data-v-1aebdbd9"),r=r(),ve(),r),We={class:"create-content"},Xe={class:"create-color-setting-box"},Ge={key:1,class:"no-data go-flex-center"},Ke=["src"],Ze={class:"color-list-box"},eo={class:"color-list"},oo=Ce(()=>d("span",null," 创建 ",-1)),to=Ce(()=>d("span",null," 应用数据 ",-1)),lo={class:"go-flex-items-center"},no=ue({__name:"index",props:{modelShow:Boolean},emits:["update:modelShow","editSaveHandle"],setup(r,{emit:i}){const v=r,{DuplicateOutlineIcon:J,TrashIcon:Q,ArrowDownIcon:W}=fe.ionicons5,s={id:ie(),name:"未命名",color:["#6ae5bb","#69e3de","#5ac5ee","#5ac4ee","#4498ec","#3c7ddf"]},u=Ue(),T=oe(!1);let C=te(u.getEditCanvasConfig.chartCustomThemeColorInfo||[]);const _=oe(void 0),h=te({selectInfo:C[0]});_e(()=>v.modelShow,t=>{T.value=t,t&&C.length&&(h.selectInfo=C[0])});const k=le(()=>{var t;return(t=h==null?void 0:h.selectInfo)==null?void 0:t.id}),B=le(()=>u.getEditCanvasConfig.chartThemeColor),R=t=>{t.id!==k.value&&(_.value!==void 0?U({message:"当前有变动未保存，是否直接放弃修改？",onPositiveCallback:()=>{_.value=void 0,h.selectInfo=t}}):h.selectInfo=t)},M=()=>{const t=()=>{const c=ee(Z({},D(s)),{id:ie()});h.selectInfo=c,C.push(c),R(c),_.value=c,a(!1)};_.value!==void 0?U({message:"当前有变动未保存，是否直接放弃修改？",onPositiveCallback:()=>{_.value=void 0,t()}}):t()},X=t=>{const c=()=>{C.splice(t,1),u.setEditCanvasConfig(Y.CHART_CUSTOM_THEME_COLOR_INFO,D(C)),z(()=>{C.length?R(C[t-1>-1?t-1:t]):h.selectInfo=void 0})};_.value!==void 0?U({message:"当前有变动未保存，是否直接放弃修改？",onPositiveCallback:()=>{_.value=void 0,c()}}):U({message:"是否删除此颜色？",onPositiveCallback:()=>{c()}})},l=t=>{_.value=t},a=(t=!0)=>{if(!_.value)return;const c=C.findIndex(g=>{var E;return g.id===((E=_.value)==null?void 0:E.id)});if(c!==-1){t&&window.$message.success("数据应用成功！");const g=D(ee(Z({},_.value),{name:_.value.name||"未定义"}));C.splice(c,1,g),_.value=void 0;const E=u.getEditCanvasConfig.chartThemeColor;u.setEditCanvasConfig(Y.CHART_THEME_COLOR,"dark"),z(()=>{u.setEditCanvasConfig(Y.CHART_CUSTOM_THEME_COLOR_INFO,D(C)),u.setEditCanvasConfig(Y.CHART_THEME_COLOR,E)})}else window.$message.error("数据应用失败！")},m=()=>{const t=()=>{_.value=void 0,h.selectInfo=void 0,i("update:modelShow",!1)};_.value!==void 0?U({message:"当前有变动未保存，是否直接放弃修改？",onPositiveCallback:()=>{t()}}):t()},I=t=>`linear-gradient(to right, ${t.color[0]} 0%, ${t.color[5]} 100%)`;return(t,c)=>{const g=n("n-text"),E=n("n-timeline-item"),j=n("n-timeline"),A=n("n-icon"),O=n("n-button"),G=n("n-badge"),S=n("n-space"),N=n("n-divider"),V=n("n-a"),x=n("n-ellipsis"),f=n("n-card"),$=n("n-tooltip"),he=n("n-modal");return p(),F(he,{class:"go-chart-create-color",show:T.value,"onUpdate:show":c[0]||(c[0]=H=>T.value=H),"mask-closable":!1,closeOnEsc:!1},{default:o(()=>[e(f,{bordered:!1,role:"dialog",size:"small","aria-modal":"true",style:{width:"900px",height:"720px"}},{header:o(()=>[]),"header-extra":o(()=>[]),action:o(()=>[e(S,{justify:"end"},{default:o(()=>[e(O,{onClick:m},{default:o(()=>[y("操作完成")]),_:1})]),_:1})]),default:o(()=>[d("div",We,[d("div",Xe,[k.value?(p(),F(w(Qe),{key:0,selectColor:h.selectInfo,onUpdateColor:l},null,8,["selectColor"])):(p(),b("div",Ge,[d("img",{src:w(Ae),alt:"暂无数据"},null,8,Ke),e(g,{depth:3},{default:o(()=>[y("暂未选择自定义颜色")]),_:1})]))]),d("div",Ze,[e(j,{class:"pond-item-timeline",style:{width:"20px"}},{default:o(()=>[e(E,{type:"info"}),e(E,{type:"success"})]),_:1}),d("div",eo,[e(S,null,{default:o(()=>[e(O,{class:ne(["create-btn",{"is-full":!k.value}]),type:"primary",ghost:!k.value,secondary:!!k.value,onClick:M},{icon:o(()=>[e(A,null,{default:o(()=>[e(w(J))]),_:1})]),default:o(()=>[oo]),_:1},8,["class","ghost","secondary"]),k.value?(p(),F(G,{key:0,show:_.value!==void 0,dot:""},{default:o(()=>[e(O,{class:"create-btn",type:"info",secondary:"",onClick:a},{icon:o(()=>[e(A,null,{default:o(()=>[e(w(W))]),_:1})]),default:o(()=>[to]),_:1})]),_:1},8,["show"])):se("",!0)]),_:1}),e(N,{style:{margin:"10px 0"}}),k.value?se("",!0):(p(),F(g,{key:0,class:"not-data-text",depth:3},{default:o(()=>[y(" 暂无自定义颜色， "),e(V,{onClick:M},{default:o(()=>[y("立即创建")]),_:1})]),_:1})),(p(!0),b(L,null,P(w(C),(H,ce)=>(p(),b("div",{class:"color-card-box",key:ce},[e(f,{class:ne(["color-card",{selected:H.id===k.value}]),size:"small",hoverable:"",embedded:"",onClick:K=>R(H)},{default:o(()=>[d("div",lo,[e(x,{style:{"text-align":"left",width:"70px"}},{default:o(()=>[y(Re(H.name),1)]),_:2},1024),(p(!0),b(L,null,P(H.color,(K,ge)=>(p(),b("span",{class:"theme-color-item",key:ge,style:q({backgroundColor:K})},null,4))),128))]),d("div",{class:"theme-bottom",style:q({backgroundImage:I(H)})},null,4)]),_:2},1032,["class","onClick"]),e($,{trigger:"hover"},{trigger:o(()=>[e(O,{text:"",disabled:H.id===B.value,onClick:K=>X(ce)},{default:o(()=>[e(A,{class:"go-ml-1 go-cursor-pointer",size:"16",depth:3},{default:o(()=>[e(w(Q))]),_:1})]),_:2},1032,["disabled","onClick"])]),default:o(()=>[y(" 删除自定义颜色 ")]),_:2},1024)]))),128))])])])]),_:1})]),_:1},8,["show"])}}});const po=me(no,[["__scopeId","data-v-1aebdbd9"]]);export{po as default};
