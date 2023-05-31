var fe=Object.defineProperty;var ce=Object.getOwnPropertySymbols;var ve=Object.prototype.hasOwnProperty,he=Object.prototype.propertyIsEnumerable;var re=(g,r,y)=>r in g?fe(g,r,{enumerable:!0,configurable:!0,writable:!0,value:y}):g[r]=y,H=(g,r)=>{for(var y in r||(r={}))ve.call(r,y)&&re(g,y,r[y]);if(ce)for(var y of ce(r))he.call(r,y)&&re(g,y,r[y]);return g};var ae=(g,r,y)=>new Promise((B,E)=>{var N=w=>{try{$(y.next(w))}catch(C){E(C)}},U=w=>{try{$(y.throw(w))}catch(C){E(C)}},$=w=>w.done?B(w.value):Promise.resolve(w.value).then(N,U);$((y=y.apply(g,r)).next())});import{d as Z,cQ as ie,Y as de,r as n,o as s,D as M,w as e,e as t,bc as oe,u as l,f as a,c as h,q as c,a2 as Y,F as k,s as I,t as b,O as ge,Q as ye,cw as be,h as se,aL as W,j as A,J as ue,z as pe,A as _e,aK as L}from"./index-c6cc3b14.js";import{S as xe}from"./SettingItem-ec2fd044.js";import{S as X}from"./SettingItemBox-cf908047.js";import{g as Ee}from"./plugin-0dcb0bd6.js";import{i as le}from"./icon-8314374d.js";import{c as we}from"./chartEditStore-3ee495ca.js";import{n as Oe}from"./noData-9e194391.js";import{u as ee}from"./useTargetData.hook-5f5f1f2c.js";import{M as me}from"./EditorWorker-df02f0e7.js";import"./editorWorker-43a98755.js";import{n as ke}from"./useLifeHandler.hook-e225f7c9.js";/* empty css                                                                       */const Ce={key:0,class:"no-data go-flex-center"},Se=["src"],Te=Z({__name:"index",setup(g){const{CloseIcon:r,AddIcon:y,HelpOutlineIcon:B}=le.ionicons5,{targetData:E,chartEditStore:N}=ee(),U=[ie.PARAMS,ie.HEADER],$=de(()=>{const f=E.value.interactActions;return f?f.map(d=>({label:d.interactName,value:d.interactType})):[]}),w=de(()=>E.value.option),C=(f,d)=>{var i;return f?(i=N.componentList[N.fetchTargetIndex(f)])==null?void 0:i.request.requestParams[d]:{}},D=f=>{if(!f||!E.value.interactActions)return[];const d=E.value.interactActions.find(i=>i.interactType===f);return(d==null?void 0:d.componentEmitEvents[w.value[be]])||[]},G=()=>{var S;const f=u=>u.reduce((_,m)=>(m.groupList&&m.groupList.length>0,_.push(m),m.groupList?[..._,...f(m.groupList)]:_),[]),i=f(N.componentList).filter(u=>{const _=u.id!==E.value.id,m=u.chartConfig.chartFrame!==we.STATIC,v=!u.isGroup;return _&&m&&v}).map(u=>({id:u.id,title:u.chartConfig.title,disabled:!1}));return(S=E.value.events.interactEvents)==null||S.forEach(u=>{i.forEach(_=>{_.id===u.interactComponentId&&(_.disabled=!0)})}),i},P=()=>{E.value.events.interactEvents.push({interactOn:void 0,interactComponentId:void 0,interactFn:{}})},J=f=>{Ee({message:"是否删除此关联交互模块?",onPositiveCallback:()=>{E.value.events.interactEvents.splice(f,1)}})};return(f,d)=>{const i=n("n-icon"),S=n("n-button"),u=n("n-text"),_=n("n-space"),m=n("n-divider"),v=n("n-tag"),O=n("n-select"),F=n("n-input-group"),j=n("n-tooltip"),q=n("n-table"),K=n("n-card"),R=n("n-collapse-item");return $.value.length?(s(),M(R,{key:0,title:"组件交互",name:"1"},{"header-extra":e(()=>[t(S,{type:"primary",tertiary:"",size:"small",onClick:oe(P,["stop"])},{icon:e(()=>[t(i,null,{default:e(()=>[t(l(y))]),_:1})]),default:e(()=>[a(" 新增 ")]),_:1},8,["onClick"])]),default:e(()=>[l(E).events.interactEvents.length?Y("",!0):(s(),h("div",Ce,[c("img",{src:l(Oe),alt:"暂无数据"},null,8,Se),t(u,{depth:3},{default:e(()=>[a("暂无内容")]),_:1})])),(s(!0),h(k,null,I(l(E).events.interactEvents,(T,V)=>(s(),M(K,{key:V,class:"n-card-shallow",size:"small"},{default:e(()=>[t(_,{justify:"space-between"},{default:e(()=>[t(u,null,{default:e(()=>[a("关联组件 - "+b(V+1),1)]),_:2},1024),t(S,{type:"error",text:"",size:"small",onClick:x=>J(V)},{icon:e(()=>[t(i,null,{default:e(()=>[t(l(r))]),_:1})]),_:2},1032,["onClick"])]),_:2},1024),t(m,{style:{margin:"10px 0"}}),t(v,{bordered:!1,type:"primary"},{default:e(()=>[a(" 选择目标组件 ")]),_:1}),t(l(X),{name:"触发事件",alone:!0},{default:e(()=>[$.value?(s(),M(F,{key:0},{default:e(()=>[t(O,{class:"select-type-options",value:T.interactOn,"onUpdate:value":x=>T.interactOn=x,size:"tiny",options:$.value},null,8,["value","onUpdate:value","options"])]),_:2},1024)):Y("",!0)]),_:2},1024),t(l(X),{alone:!0},{name:e(()=>[t(u,null,{default:e(()=>[a("绑定")]),_:1}),t(j,{trigger:"hover"},{trigger:e(()=>[t(i,{size:"21",depth:3},{default:e(()=>[t(l(B))]),_:1})]),default:e(()=>[t(u,null,{default:e(()=>[a("不支持「静态组件」")]),_:1})]),_:1})]),default:e(()=>[t(O,{class:"select-type-options","value-field":"id","label-field":"title",size:"tiny",filterable:"",placeholder:"仅展示符合条件的组件",value:T.interactComponentId,"onUpdate:value":x=>T.interactComponentId=x,options:G()},null,8,["value","onUpdate:value","options"])]),_:2},1024),D(T.interactOn).length?(s(),M(l(X),{key:0,name:"查询结果",alone:!0},{default:e(()=>[t(q,{size:"small",striped:""},{default:e(()=>[c("thead",null,[c("tr",null,[(s(),h(k,null,I(["参数","说明"],x=>c("th",{key:x},b(x),1)),64))])]),c("tbody",null,[(s(!0),h(k,null,I(D(T.interactOn),(x,p)=>(s(),h("tr",{key:p},[c("td",null,b(x.value),1),c("td",null,b(x.label),1)]))),128))])]),_:2},1024)]),_:2},1024)):Y("",!0),t(v,{bordered:!1,type:"primary"},{default:e(()=>[a(" 关联目标组件请求参数 ")]),_:1}),(s(),h(k,null,I(U,x=>t(l(X),{name:x,key:x},{default:e(()=>[(s(!0),h(k,null,I(C(T.interactComponentId,x),(p,o,z)=>(s(),M(l(xe),{key:z,name:`${o}`},{default:e(()=>[t(O,{size:"tiny",value:T.interactFn[o],"onUpdate:value":ne=>T.interactFn[o]=ne,options:D(T.interactOn),clearable:""},null,8,["value","onUpdate:value","options"])]),_:2},1032,["name"]))),128)),ge(t(u,{class:"go-pt-1",depth:"3"},{default:e(()=>[a(" 暂无数据 ")]),_:2},1536),[[ye,JSON.stringify(C(T.interactComponentId,x))==="{}"]])]),_:2},1032,["name"])),64))]),_:2},1024))),128))]),_:1})):Y("",!0)}}});const $e=se(Te,[["__scopeId","data-v-b2acbe2f"]]),Ie=`
console.log(e)
`,De=`
console.log(echarts)
`,Ne=`
console.log(components)
`,Le=`
console.log(node_modules)
`,Me=`
// 在渲染之后才能获取 dom 实例
e.el.addEventListener('click', () => {
  alert('我触发拉~');
}, false)
`,Ue=`
await import('https://lf3-cdn-tos.bytecdntp.com/cdn/expire-1-M/lodash.js/4.17.21/lodash.js')

// lodash 默认赋值给 "_"
console.log('isEqual', _.isEqual(['1'], ['1']))
`,Fe=`
// 获取echart实例
const chart = this.refs.vChartRef.chart

// 图表设置tooltip
chart.setOption({
  tooltip: {
    trigger: 'axis', //item
    enterable: true, 
    formatter (params) {
      return\`
        <div>
          <img src="https://portrait.gitee.com/uploads/avatars/user/1654/4964818_MTrun_1653229420.png!avatar30">
          <b><a href="https://gitee.com/dromara/go-view">《这是一个自定义的tooltip》</a></b>
        <div>
        <div style='border-radius:35px;color:#666'>
        \${Object.entries(params[0].value).map(kv => \`<div>\${kv[0]}:\${kv[1]}</div>\`).join('')}
        </div>
      \`;
    },
  }
})
`,je=`
// 组件样式作用域标识
const scoped = this.subTree.scopeId
function loadStyleString(css){
	let style = document.createElement('style')
	style.type = 'text/css'
	style.appendChild(document.createTextNode(css))
	let head = document.getElementsByTagName('head')[0]
	head.appendChild(style)
}
loadStyleString(\`
.dv-scroll-board[\${scoped}] {
  position: relative;
  overflow: hidden;
}
.dv-scroll-board[\${scoped}]::before {
  content: '';
  display: block;
  position: absolute;
  top: -20%;
  left: -100%;
  width: 550px;
  height: 60px;
  transform: rotate(-45deg);
  background-image: linear-gradient(rgba(0, 0, 0, 0), rgba(255, 255, 255, 0.3), rgba(0, 0, 0, 0));
  animation: cross 2s infinite;
}
@keyframes cross{
  to{
    top: 80%;
    left: 100%;
    transform: rotate(-45deg);
  }
}
\`)
`,Ve=`
const chart = this.refs.vChartRef.chart
// 定义地图原点大小 同理可自定义标签等等内容
this.props.chartConfig.option.series[0].symbolSize = (val) => {
  return Math.sqrt(val[2]) / 3;
}
this.setupState.vEchartsSetOption();
let i = 0; // 当前轮播索引
const len = 3; // 轮播部分提示
(function showTips() {
  const action = (type, dataIndex) => {
    chart.dispatchAction({
      type,
      dataIndex,
      seriesIndex: 0,
    });
  }
  setInterval(() => {
    action("downplay", i);
    action("hideTip", i);
    if (i === len) i = 0;
    i++;
    action("highlight", i);
    action("showTip", i);
  }, 2000);
})()
`,ze=[{description:"获取当前组件实例",code:Ie},{description:"获取全局 echarts 实例",code:De},{description:"获取组件图表集合",code:Ne},{description:"获取 nodeModules 实例",code:Le},{description:"获取远程 CDN 库",code:Ue},{description:"设置文字组件点击事件",code:Me},{description:"修改图表 tooltip",code:Fe},{description:"添加【轮播列表】样式",code:je},{description:"修改【地图】圆点，新增提示自动轮播",code:Ve}],Q=g=>(pe("data-v-53d5d409"),g=g(),_e(),g),Ae={class:"func-annotate"},Be=Q(()=>c("br",null,null,-1)),Re={class:"func-keyword"},Pe={class:"go-ml-4"},qe=Q(()=>c("p",null,[a("}"),c("span",null,",")],-1)),Ke={class:"go-pl-3"},He=Q(()=>c("span",{class:"func-keyword"},"async function   ",-1)),We={class:"func-keyNameWord"},Ge=Q(()=>c("p",{class:"go-pl-3 func-keyNameWord"},"}",-1)),Je=Q(()=>c("br",null,null,-1)),Qe=Q(()=>c("br",null,null,-1)),Ye={class:"go-flex-items-center"},Xe=Z({__name:"index",setup(g){const{targetData:r,chartEditStore:y}=ee(),{DocumentTextIcon:B,ChevronDownIcon:E,PencilIcon:N}=le.ionicons5,U={[W.VNODE_BEFORE_MOUNT]:"渲染之前",[W.VNODE_MOUNTED]:"渲染之后"},$={[W.VNODE_BEFORE_MOUNT]:"此时组件 DOM 还未存在",[W.VNODE_MOUNTED]:"此时组件 DOM 已经存在"},w=A(!1),C=A(W.VNODE_MOUNTED);let D=A(H({},r.value.events.advancedEvents));const G=A(!1),P=()=>{let d="",i="",S="";return G.value=Object.entries(D.value).every(([u,_])=>{try{const m=Object.getPrototypeOf(function(){return ae(this,null,function*(){})}).constructor;return new m(_),!0}catch(m){return i=m.message,S=m.name,d=u,!1}}),{errorFn:d,message:i,name:S}},J=()=>{w.value=!1},f=()=>{if(P().errorFn){window.$message.error("事件函数错误，无法进行保存");return}Object.values(D.value).join("").trim()===""?r.value.events.advancedEvents={vnodeBeforeMount:void 0,vnodeMounted:void 0}:r.value.events.advancedEvents=H({},D.value),J()};return ue(()=>w.value,d=>{d&&(D.value=H({},r.value.events.advancedEvents))}),(d,i)=>{const S=n("n-icon"),u=n("n-button"),_=n("n-code"),m=n("n-card"),v=n("n-collapse-item"),O=n("n-text"),F=n("n-space"),j=n("n-tab-pane"),q=n("n-tabs"),K=n("n-layout"),R=n("n-collapse"),T=n("n-scrollbar"),V=n("n-tag"),x=n("n-layout-sider"),p=n("n-modal");return s(),h(k,null,[t(v,{title:"高级事件配置",name:"3"},{"header-extra":e(()=>[t(u,{type:"primary",tertiary:"",size:"small",onClick:i[0]||(i[0]=oe(o=>w.value=!0,["stop"]))},{icon:e(()=>[t(S,null,{default:e(()=>[t(l(N))]),_:1})]),default:e(()=>[a(" 编辑 ")]),_:1})]),default:e(()=>[t(m,{class:"collapse-show-box"},{default:e(()=>[(s(!0),h(k,null,I(l(W),o=>(s(),h("div",{key:o},[c("p",null,[c("span",Ae,"// "+b(U[o]),1),Be,c("span",Re,"async "+b(o),1),a(" (e, components, echarts, node_modules) { ")]),c("p",Pe,[t(_,{code:(l(r).events.advancedEvents||{})[o]||"",language:"typescript"},null,8,["code"])]),qe]))),128))]),_:1})]),_:1}),t(p,{class:"go-chart-data-monaco-editor",show:w.value,"onUpdate:show":i[2]||(i[2]=o=>w.value=o),"mask-closable":!1},{default:e(()=>[t(m,{bordered:!1,role:"dialog",size:"small","aria-modal":"true",style:{width:"1200px",height:"700px"}},{header:e(()=>[t(F,null,{default:e(()=>[t(O,null,{default:e(()=>[a("高级事件编辑器（配合源码使用）")]),_:1})]),_:1})]),"header-extra":e(()=>[]),action:e(()=>[t(F,{justify:"space-between"},{default:e(()=>[c("div",Ye,[t(V,{bordered:!1,type:"primary"},{icon:e(()=>[t(S,{component:l(B)},null,8,["component"])]),default:e(()=>[a(" 说明 ")]),_:1}),t(O,{class:"go-ml-2",depth:"2"},{default:e(()=>[a("通过提供的参数可为图表增加定制化的tooltip、交互事件等等")]),_:1})]),t(F,null,{default:e(()=>[t(u,{size:"medium",onClick:J},{default:e(()=>[a("取消")]),_:1}),t(u,{size:"medium",type:"primary",onClick:f},{default:e(()=>[a("保存")]),_:1})]),_:1})]),_:1})]),default:e(()=>[t(K,{"has-sider":"","sider-placement":"right"},{default:e(()=>[t(K,{style:{height:"580px","padding-right":"20px"}},{default:e(()=>[t(q,{value:C.value,"onUpdate:value":i[1]||(i[1]=o=>C.value=o),type:"card","tab-style":"min-width: 100px;"},{suffix:e(()=>[t(O,{class:"tab-tip",type:"warning"},{default:e(()=>[a("提示: "+b($[C.value]),1)]),_:1})]),default:e(()=>[(s(!0),h(k,null,I(l(W),(o,z)=>(s(),M(j,{key:z,tab:`${U[o]}-${o}`,name:o},{default:e(()=>[c("p",Ke,[He,c("span",We,b(o)+"(e, components, echarts, node_modules)  {",1)]),t(l(me),{modelValue:l(D)[o],"onUpdate:modelValue":ne=>l(D)[o]=ne,height:"480px",language:"javascript"},null,8,["modelValue","onUpdate:modelValue"]),Ge]),_:2},1032,["tab","name"]))),128))]),_:1},8,["value"])]),_:1}),t(x,{"collapsed-width":14,width:340,"show-trigger":"bar","collapse-mode":"transform","content-style":"padding: 12px 12px 0px 12px;margin-left: 3px;"},{default:e(()=>[t(q,{"default-value":"1","justify-content":"space-evenly",type:"segment"},{default:e(()=>[t(j,{tab:"验证结果",name:"1",size:"small"},{default:e(()=>[t(T,{trigger:"none",style:{"max-height":"505px"}},{default:e(()=>[t(R,{class:"go-px-3","arrow-placement":"right","default-expanded-names":[1,2,3]},{default:e(()=>[(s(!0),h(k,null,I([P()],o=>(s(),h(k,{key:o},[t(v,{title:"错误函数",name:1},{default:e(()=>[t(O,{depth:"3"},{default:e(()=>[a(b(o.errorFn||"暂无"),1)]),_:2},1024)]),_:2},1024),t(v,{title:"错误信息",name:2},{default:e(()=>[t(O,{depth:"3"},{default:e(()=>[a(b(o.name||"暂无"),1)]),_:2},1024)]),_:2},1024),t(v,{title:"堆栈信息",name:3},{default:e(()=>[t(O,{depth:"3"},{default:e(()=>[a(b(o.message||"暂无"),1)]),_:2},1024)]),_:2},1024)],64))),128))]),_:1})]),_:1})]),_:1}),t(j,{tab:"变量说明",name:"2"},{default:e(()=>[t(T,{trigger:"none",style:{"max-height":"505px"}},{default:e(()=>[t(R,{class:"go-px-3","arrow-placement":"right","default-expanded-names":[1,2,3,4]},{default:e(()=>[t(v,{title:"e",name:1},{default:e(()=>[t(O,{depth:"3"},{default:e(()=>[a("触发对应生命周期事件时接收的参数")]),_:1})]),_:1}),t(v,{title:"this",name:2},{default:e(()=>[t(O,{depth:"3"},{default:e(()=>[a("图表组件实例")]),_:1}),Je,(s(!0),h(k,null,I(["refs","setupState","ctx","props","..."],o=>(s(),M(V,{class:"go-m-1",key:o},{default:e(()=>[a(b(o),1)]),_:2},1024))),128))]),_:1}),t(v,{title:"components",name:3},{default:e(()=>[t(O,{depth:"3"},{default:e(()=>[a("当前大屏内所有组件的集合id 图表组件中的配置id，可以获取其他图表组件进行控制")]),_:1}),t(_,{code:`{
  [id]: component
}`,language:"typescript"})]),_:1}),t(v,{title:"node_modules",name:4},{default:e(()=>[t(O,{depth:"3"},{default:e(()=>[a("以下是内置在代码环境中可用的包变量")]),_:1}),Qe,(s(!0),h(k,null,I(Object.keys(l(ke)||{}),o=>(s(),M(V,{class:"go-m-1",key:o},{default:e(()=>[a(b(o),1)]),_:2},1024))),128))]),_:1})]),_:1})]),_:1})]),_:1}),t(j,{tab:"介绍案例",name:"3"},{default:e(()=>[t(T,{trigger:"none",style:{"max-height":"505px"}},{default:e(()=>[t(R,{"arrow-placement":"right"},{default:e(()=>[(s(!0),h(k,null,I(l(ze),(o,z)=>(s(),M(v,{key:z,title:`案例${z+1}：${o.description}`,name:z},{default:e(()=>[t(_,{code:o.code,language:"typescript"},null,8,["code"])]),_:2},1032,["title","name"]))),128))]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1},8,["show"])],64)}}});const Ze=se(Xe,[["__scopeId","data-v-53d5d409"]]),te=g=>(pe("data-v-c7d70b76"),g=g(),_e(),g),et={class:"func-annotate"},tt=te(()=>c("br",null,null,-1)),nt={class:"func-keyword"},at={class:"go-ml-4"},ot=te(()=>c("p",null,[a("}"),c("span",null,",")],-1)),st={class:"go-pl-3"},lt=te(()=>c("span",{class:"func-keyword"},"async function   ",-1)),ct={class:"func-keyNameWord"},rt=te(()=>c("p",{class:"go-pl-3 func-keyNameWord"},"}",-1)),it={class:"go-flex-items-center"},dt=Z({__name:"index",setup(g){const{targetData:r,chartEditStore:y}=ee(),{DocumentTextIcon:B,ChevronDownIcon:E,PencilIcon:N}=le.ionicons5,U={[L.ON_CLICK]:"单击",[L.ON_DBL_CLICK]:"双击",[L.ON_MOUSE_ENTER]:"鼠标进入",[L.ON_MOUSE_LEAVE]:"鼠标移出"},$=A(!1),w=A(L.ON_CLICK);let C=A(H({},r.value.events.baseEvent));const D=A(!1),G=()=>{let f="",d="",i="";return D.value=Object.entries(C.value).every(([S,u])=>{try{const _=Object.getPrototypeOf(function(){return ae(this,null,function*(){})}).constructor;return new _(u),!0}catch(_){return d=_.message,i=_.name,f=S,!1}}),{errorFn:f,message:d,name:i}},P=()=>{$.value=!1},J=()=>{if(G().errorFn){window.$message.error("事件函数错误，无法进行保存");return}Object.values(C.value).join("").trim()===""?r.value.events.baseEvent={[L.ON_CLICK]:void 0,[L.ON_DBL_CLICK]:void 0,[L.ON_MOUSE_ENTER]:void 0,[L.ON_MOUSE_LEAVE]:void 0}:r.value.events.baseEvent=H({},C.value),P()};return ue(()=>$.value,f=>{f&&(C.value=H({},r.value.events.baseEvent))}),(f,d)=>{const i=n("n-icon"),S=n("n-button"),u=n("n-code"),_=n("n-card"),m=n("n-collapse-item"),v=n("n-text"),O=n("n-space"),F=n("n-tab-pane"),j=n("n-tabs"),q=n("n-layout"),K=n("n-collapse"),R=n("n-scrollbar"),T=n("n-layout-sider"),V=n("n-tag"),x=n("n-modal");return s(),h(k,null,[t(m,{title:"基础事件配置",name:"2"},{"header-extra":e(()=>[t(S,{type:"primary",tertiary:"",size:"small",onClick:d[0]||(d[0]=oe(p=>$.value=!0,["stop"]))},{icon:e(()=>[t(i,null,{default:e(()=>[t(l(N))]),_:1})]),default:e(()=>[a(" 编辑 ")]),_:1})]),default:e(()=>[t(_,{class:"collapse-show-box"},{default:e(()=>[(s(!0),h(k,null,I(l(L),p=>(s(),h("div",{key:p},[c("p",null,[c("span",et,"// "+b(U[p]),1),tt,c("span",nt,"async "+b(p),1),a(" (mouseEvent) { ")]),c("p",at,[t(u,{code:(l(r).events.baseEvent||{})[p]||"",language:"typescript"},null,8,["code"])]),ot]))),128))]),_:1})]),_:1}),t(x,{class:"go-chart-data-monaco-editor",show:$.value,"onUpdate:show":d[2]||(d[2]=p=>$.value=p),"mask-closable":!1},{default:e(()=>[t(_,{bordered:!1,role:"dialog",size:"small","aria-modal":"true",style:{width:"1200px",height:"700px"}},{header:e(()=>[t(O,null,{default:e(()=>[t(v,null,{default:e(()=>[a("基础事件编辑器")]),_:1})]),_:1})]),"header-extra":e(()=>[]),action:e(()=>[t(O,{justify:"space-between"},{default:e(()=>[c("div",it,[t(V,{bordered:!1,type:"primary"},{icon:e(()=>[t(i,{component:l(B)},null,8,["component"])]),default:e(()=>[a(" 说明 ")]),_:1}),t(v,{class:"go-ml-2",depth:"2"},{default:e(()=>[a("编写方式同正常 JavaScript 写法")]),_:1})]),t(O,null,{default:e(()=>[t(S,{size:"medium",onClick:P},{default:e(()=>[a("取消")]),_:1}),t(S,{size:"medium",type:"primary",onClick:J},{default:e(()=>[a("保存")]),_:1})]),_:1})]),_:1})]),default:e(()=>[t(q,{"has-sider":"","sider-placement":"right"},{default:e(()=>[t(q,{style:{height:"580px","padding-right":"20px"}},{default:e(()=>[t(j,{value:w.value,"onUpdate:value":d[1]||(d[1]=p=>w.value=p),type:"card","tab-style":"min-width: 100px;"},{suffix:e(()=>[t(v,{class:"tab-tip",type:"warning"},{default:e(()=>[a("提示: ECharts 组件会拦截鼠标事件")]),_:1})]),default:e(()=>[(s(!0),h(k,null,I(l(L),(p,o)=>(s(),M(F,{key:o,tab:`${U[p]}-${p}`,name:p},{default:e(()=>[c("p",st,[lt,c("span",ct,b(p)+"(mouseEvent)  {",1)]),t(l(me),{modelValue:l(C)[p],"onUpdate:modelValue":z=>l(C)[p]=z,height:"480px",language:"javascript"},null,8,["modelValue","onUpdate:modelValue"]),rt]),_:2},1032,["tab","name"]))),128))]),_:1},8,["value"])]),_:1}),t(T,{"collapsed-width":14,width:340,"show-trigger":"bar","collapse-mode":"transform","content-style":"padding: 12px 12px 0px 12px;margin-left: 3px;"},{default:e(()=>[t(j,{"default-value":"1","justify-content":"space-evenly",type:"segment"},{default:e(()=>[t(F,{tab:"验证结果",name:"1",size:"small"},{default:e(()=>[t(R,{trigger:"none",style:{"max-height":"505px"}},{default:e(()=>[t(K,{class:"go-px-3","arrow-placement":"right","default-expanded-names":[1,2,3]},{default:e(()=>[(s(!0),h(k,null,I([G()],p=>(s(),h(k,{key:p},[t(m,{title:"错误函数",name:1},{default:e(()=>[t(v,{depth:"3"},{default:e(()=>[a(b(p.errorFn||"暂无"),1)]),_:2},1024)]),_:2},1024),t(m,{title:"错误信息",name:2},{default:e(()=>[t(v,{depth:"3"},{default:e(()=>[a(b(p.name||"暂无"),1)]),_:2},1024)]),_:2},1024),t(m,{title:"堆栈信息",name:3},{default:e(()=>[t(v,{depth:"3"},{default:e(()=>[a(b(p.message||"暂无"),1)]),_:2},1024)]),_:2},1024)],64))),128))]),_:1})]),_:1})]),_:1}),t(F,{tab:"变量说明",name:"2"},{default:e(()=>[t(R,{trigger:"none",style:{"max-height":"505px"}},{default:e(()=>[t(K,{class:"go-px-3","arrow-placement":"right","default-expanded-names":[1,2]},{default:e(()=>[t(m,{title:"mouseEvent",name:1},{default:e(()=>[t(v,{depth:"3"},{default:e(()=>[a("鼠标事件对象")]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1},8,["show"])],64)}}});const ut=se(dt,[["__scopeId","data-v-c7d70b76"]]),kt=Z({__name:"index",setup(g){const{targetData:r}=ee();return A(!1),(y,B)=>{const E=n("n-text"),N=n("n-collapse");return s(),M(N,{class:"go-mt-3","arrow-placement":"right","default-expanded-names":["1","2"]},{default:e(()=>[t(E,{depth:"3"},{default:e(()=>[a(" 组件 id： "),t(E,null,{default:e(()=>[a(b(l(r).id),1)]),_:1})]),_:1}),t(l($e)),t(l(ut)),t(l(Ze))]),_:1})}}});export{kt as default};
