var $=(p,i,d)=>new Promise((v,f)=>{var g=r=>{try{n(d.next(r))}catch(h){f(h)}},e=r=>{try{n(d.throw(r))}catch(h){f(h)}},n=r=>r.done?v(r.value):Promise.resolve(r.value).then(g,e);n((d=d.apply(p,i)).next())});import{d as N,a7 as he,X as ve,Y as fe,p as ye,j as y,J as R,r as _,o as C,c as w,O as T,Q as L,e as l,u as a,q as S,w as m,h as F,l as Ce,W as be,b7 as Oe,b5 as te,b8 as Se,Z as Ie,b9 as ke,F as q,s as K,D as H,f as Y,t as J,am as z,aT as xe,z as we,A as Te,U as I,ba as Ee,a2 as Le}from"./index-c6cc3b14.js";import{C as He}from"./index-6d528f21.js";import{l as Ne,c as Q}from"./index-af8cb105.js";import{c as oe,b as Ae,I as Pe,f as $e,d as Re,e as ze}from"./index-68969097.js";import{a as Be,b as Fe,l as De}from"./plugin-0dcb0bd6.js";import{i as D}from"./icon-8314374d.js";import{u as V,a as W,C as B}from"./chartLayoutStore-fa484834.js";import{u as Ve,P as k,b as x}from"./chartEditStore-3ee495ca.js";const Me={class:"go-chart-common"},Ue={class:"chart-content-list"},je=N({__name:"index",props:{selectOptions:{type:Object,default:()=>{}}},setup(p){const i=p,d=Ne(()=>he(()=>import("./index-b034c9ee.js"),["static/js/index-b034c9ee.js","static/js/index-1ec7cb3e.js","static/js/index-c6cc3b14.js","static/css/index-9c2eb289.css","static/js/icon-8314374d.js","static/css/index-247c99bc.css","static/js/chartEditStore-3ee495ca.js","static/js/plugin-0dcb0bd6.js","static/js/chartLayoutStore-fa484834.js","static/js/index-68969097.js","static/js/SettingItem-ec2fd044.js","static/css/SettingItemBox-462ae6ed.css","static/js/SettingItemBox-cf908047.js","static/js/CollapseItem.vue_vue_type_script_setup_true_lang-81d1b4a3.js","static/js/index.esm.min-4d91f069.js","static/js/http-abbaebe7.js","static/js/lodash-c32566df.js","static/js/fileTypeEnum-21359a08.js","static/css/index-51120298.css","static/js/index-af8cb105.js","static/css/index-83eadabc.css","static/js/index-6d528f21.js","static/css/index-366d23c6.css","static/css/index-8b040e82.css"])),v=oe(),f=ve(),g=fe(()=>e.categorysNum>2?!0:!f.getHidePackageOneCategory);let e=ye({menuOptions:[],selectOptions:{},categorys:{all:[]},categoryNames:{all:"所有"},categorysNum:0,saveSelectOptions:{}});const n=y("all"),r=s=>{for(const o in s){e.selectOptions=s[o];break}};R(()=>i.selectOptions,s=>{if(e.categorysNum=0,!!s){s.list.forEach(o=>{const b=e.categorys[o.category];e.categorys[o.category]=b&&b.length?[...b,o]:[o],e.categoryNames[o.category]=o.categoryName,e.categorys.all.push(o)});for(const o in e.categorys)e.categorysNum+=1,e.menuOptions.push({key:o,label:e.categoryNames[o]});r(e.categorys),n.value=e.menuOptions[0].key}},{immediate:!0}),R(()=>v.newPhoto,s=>{if(!s)return;const o=s.category;e.categorys[o].splice(1,0,s),e.categorys.all.splice(1,0,s)});const h=(s,o)=>{e.categorys[s.category].splice(o,1),e.categorys.all.splice(o,1)},O=s=>{e.selectOptions=e.categorys[s]};return(s,o)=>{const b=_("n-menu"),M=_("n-scrollbar");return C(),w("div",Me,[T(l(b,{class:"chart-menu-width",value:n.value,"onUpdate:value":[o[0]||(o[0]=A=>n.value=A),O],options:a(e).menuOptions,"icon-size":16,indent:18},null,8,["value","options"]),[[L,g.value]]),S("div",Ue,[l(M,{trigger:"none"},{default:m(()=>[l(a(d),{menuOptions:a(e).selectOptions,onDeletePhoto:h},null,8,["menuOptions"])]),_:1})])])}}});const Ge=F(je,[["__scopeId","data-v-7b1aa2ee"]]),qe=Ce(),ne=y(qe.getAppTheme),{setItem:X}=V(),{getCharts:Z}=be(V()),Ke={class:"list-img",alt:"图表图片"},Ye=N({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(p){const i=p,d=y(""),v=()=>$(this,null,function*(){d.value=yield Ae(i.chartConfig)});return R(()=>i.chartConfig.key,()=>v(),{immediate:!0}),(f,g)=>{const e=Oe("lazy");return T((C(),w("img",Ke,null,512)),[[e,d.value]])}}}),Je=p=>(we("data-v-74908e7a"),p=p(),Te(),p),Qe={class:"go-chart-search-box"},We={class:"search-list-box"},Xe=["title","onClick"],Ze=Je(()=>S("div",{class:"popover-modal"},null,-1)),et=N({__name:"index",props:{menuOptions:{type:Array,default:()=>[]}},setup(p){const i=p;te(t=>({"32bab10a":a(ne)}));const d=Ve(),v=V(),{SearchIcon:f,AlbumsIcon:g,GridIcon:e}=D.ionicons5,n=y(!1),r=y(!1),h=y(void 0),O=y(null),s=y([]),o=y(v.getChartType),b=[{label:"单列",icon:g,value:W.SINGLE},{label:"双列",icon:e,value:W.DOUBLE}],A=(t=>{const c=[];for(const E of t)c.push(...E.list);return c})(i.menuOptions),P=()=>{h.value=void 0,r.value=!1,O.value=null,s.value=[]},se=t=>{if(!xe(t)||!t.length){P();return}h.value=!0,r.value=!0,s.value=A.filter(c=>!c.disabled&&(!t||c.title.toLowerCase().includes(t.toLowerCase()))),setTimeout(()=>{h.value=void 0},500)},U=t=>{r.value&&t.target&&(t.target.closest(".go-chart-search")||P())},ae=t=>$(this,null,function*(){if(!t.disabled)try{Be(),Q(t.chartKey,$e(t)),Q(t.conKey,Re(t));let c=yield ze(t);t.redirectComponent&&(t.dataset&&(c.option.dataset=t.dataset),c.chartConfig.title=t.title,c.chartConfig.chartFrame=t.chartFrame),d.addComponentList(c,!1,!0),d.setTargetSelectChart(c.id),P(),Fe()}catch(c){De(),window.$message.warning("图表正在研发中, 敬请期待...")}}),j=t=>{n.value=t},ce=t=>{o.value=t,v.setItem(B.Chart_TYPE,t)};return Se(document,"click",t=>{U(t)}),Ie(()=>{ke(document,"click",U)}),(t,c)=>{const E=_("n-icon"),le=_("n-input"),re=_("n-input-group"),ie=_("n-empty"),ue=_("n-text"),pe=_("n-scrollbar"),de=_("n-popover"),_e=_("n-tooltip"),me=_("n-button"),ge=_("n-button-group");return C(),w("div",Qe,[S("div",{class:z(["chart-search go-transition",{"chart-search-focus":n.value}])},[l(de,{class:"chart-search-popover","show-arrow":!1,show:r.value,to:!1,trigger:"hover",placement:"bottom-start"},{trigger:m(()=>[l(re,null,{default:m(()=>[l(le,{size:"small",placeholder:"搜索组件",value:O.value,"onUpdate:value":[c[0]||(c[0]=u=>O.value=u),se],valueModifiers:{trim:!0},loading:h.value,onFocus:c[1]||(c[1]=u=>j(!0)),onBlur:c[2]||(c[2]=u=>j(!1))},{suffix:m(()=>[T(l(E,{component:a(f)},null,8,["component"]),[[L,!h.value]])]),_:1},8,["value","loading"])]),_:1})]),default:m(()=>[S("div",We,[l(pe,{style:{"max-height":"500px"}},{default:m(()=>[T(l(ie,{size:"small",description:"没有找到组件~"},null,512),[[L,!s.value.length]]),(C(!0),w(q,null,K(s.value,u=>(C(),w("div",{class:"list-item go-flex-items-center go-ellipsis-1",key:u.key,title:u.title,onClick:G=>ae(u)},[u.icon?(C(),H(a(Pe),{key:0,class:"list-img",icon:u.icon,color:"#999",width:"20"},null,8,["icon"])):(C(),H(a(Ye),{key:1,class:"list-item-img",chartConfig:u},null,8,["chartConfig"])),l(ue,{class:"list-item-fs",depth:"2"},{default:m(()=>[Y(J(u.title),1)]),_:2},1024)],8,Xe))),128))]),_:1}),Ze])]),_:1},8,["show"])],2),l(ge,{class:z(["btn-group go-transition",{"btn-group-focus":n.value}]),style:{display:"flex"}},{default:m(()=>[(C(),w(q,null,K(b,(u,G)=>l(me,{ghost:"",size:"small",key:G,type:o.value===u.value?"primary":"tertiary",onClick:mt=>ce(u.value)},{default:m(()=>[l(_e,{"show-arrow":!1,trigger:"hover"},{trigger:m(()=>[l(E,{size:"14",component:u.icon},null,8,["component"])]),default:m(()=>[Y(" "+J(u.label),1)]),_:2},1024)]),_:2},1032,["type","onClick"])),64))]),_:1},8,["class"])])}}});const tt=F(et,[["__scopeId","data-v-74908e7a"]]),{AirPlaneOutlineIcon:ot,ImageIcon:nt,BarChartIcon:st}=D.ionicons5,{TableSplitIcon:at,RoadmapIcon:ct,SpellCheckIcon:lt,GraphicalDataFlowIcon:rt}=D.carbon,ee={[k.CHARTS]:{icon:I(ct),label:x.CHARTS},[k.INFORMATIONS]:{icon:I(lt),label:x.INFORMATIONS},[k.TABLES]:{icon:I(at),label:x.TABLES},[k.DECORATES]:{icon:I(rt),label:x.DECORATES},[k.PHOTOS]:{icon:I(nt),label:x.PHOTOS},[k.ICONS]:{icon:I(ot),label:x.ICONS}},it=()=>{const p=oe(),i=[];(()=>{for(const n in p.getPackagesList)i.push({key:n,icon:ee[n].icon,label:ee[n].label,list:p.getPackagesList[n]})})();let v=i[0].key;const f=y(i[0].key),g=y(i[0]);return{getCharts:Z,BarChartIcon:st,themeColor:ne,selectOptions:g,selectValue:f,clickItemHandle:(n,r)=>{g.value=r,v===n?X(B.CHARTS,!Z.value,!1):X(B.CHARTS,!0,!1),v=n},menuOptions:i}},ut={class:"menu-width-box"},pt={class:"menu-component-box"},dt=N({__name:"index",setup(p){te(r=>({a65d33fe:a(v)}));const{getCharts:i,BarChartIcon:d,themeColor:v,selectOptions:f,selectValue:g,clickItemHandle:e,menuOptions:n}=it();return(r,h)=>{const O=_("n-icon"),s=_("n-menu"),o=_("go-skeleton");return C(),H(a(He),{class:z(["go-content-charts",{scoped:!a(i)}]),title:"组件",depth:1,backIcon:!1},{icon:m(()=>[l(O,{size:"14",depth:2},{default:m(()=>[l(a(d))]),_:1})]),"top-right":m(()=>[T(l(a(tt),{menuOptions:a(n)},null,8,["menuOptions"]),[[L,a(i)]])]),default:m(()=>[S("aside",null,[S("div",ut,[l(s,{class:"menu-width",value:a(g),"onUpdate:value":[h[0]||(h[0]=b=>Ee(g)?g.value=b:null),a(e)],options:a(n),"icon-size":16,indent:18},null,8,["value","options","onUpdate:value"]),S("div",pt,[l(o,{load:!a(f),round:"",text:"",repeat:2,style:{width:"90%"}},null,8,["load"]),a(f)?(C(),H(a(Ge),{selectOptions:a(f),key:a(g)},null,8,["selectOptions"])):Le("",!0)])])])]),_:1},8,["class"])}}});const _t=F(dt,[["__scopeId","data-v-f892928e"]]),It=Object.freeze(Object.defineProperty({__proto__:null,default:_t},Symbol.toStringTag,{value:"Module"}));export{Ye as _,It as i};