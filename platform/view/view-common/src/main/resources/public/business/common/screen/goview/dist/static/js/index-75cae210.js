import{d as G,Z as M,p as y,X as a,a0 as g,r,o as s,E as c,w as t,e as n,u as X,c as f,F as C,s as S,G as h,q as b,t as v,a$ as Y,j as Z}from"./index-232a8936.js";import{g as J}from"./plugin-0e60a394.js";import{i as Q}from"./icon-b66964c1.js";import{u as U}from"./useKeyboard.hook-a7f84a08.js";import{u as ee,a as te,H as l}from"./chartEditStore-45e70a9f.js";import{u as A,C as i}from"./chartLayoutStore-b1ae0ff3.js";const oe=G({__name:"index",setup(se){const{LayersIcon:H,BarChartIcon:B,PrismIcon:I,HomeIcon:L,ArrowBackIcon:w,ArrowForwardIcon:E}=Q.ionicons5,{setItem:x}=A(),{getLayers:D,getCharts:F,getDetails:R}=M(A()),d=ee(),u=te(),K=y([{key:i.CHARTS,select:F,title:"图表组件",icon:a(B)},{key:i.LAYERS,select:D,title:"图层控制",icon:a(H)},{key:i.DETAILS,select:R,title:"详情设置",icon:a(I)}]),T=g(()=>u.getBackStack.length>1),z=g(()=>u.getForwardStack.length>0),$=y([{key:l.BACK_STACK,select:T,title:"后退",icon:a(w)},{key:l.FORWARD_STACK,select:z,title:"前进",icon:a(E)}]),q=o=>o.key===i.DETAILS?o.select?"":"primary":o.select?"primary":"",N=o=>{x(o.key,!o.select)},O=o=>{switch(o.key){case l.BACK_STACK:d.setBack();break;case l.FORWARD_STACK:d.setForward();break}},P=()=>{J({message:"返回将不会保存任何操作",isMaskClosable:!0,onPositiveCallback:()=>{Y(),U()}})};return(o,p)=>{const V=r("n-icon"),_=r("n-button"),k=r("n-tooltip"),W=r("n-divider"),m=r("n-space");return s(),c(m,{class:"header-left-btn",size:25},{default:t(()=>[n(_,{size:"small",quaternary:"",onClick:p[0]||(p[0]=e=>P())},{icon:t(()=>[n(V,{depth:3},{default:t(()=>[n(X(L))]),_:1})]),_:1}),n(m,null,{default:t(()=>[(s(!0),f(C,null,S(K,e=>(s(),c(k,{key:e.key,placement:"bottom",trigger:"hover"},{trigger:t(()=>[n(_,{size:"small",ghost:"",type:q(e),focusable:!1,onClick:j=>N(e)},{default:t(()=>[(s(),c(h(e.icon)))]),_:2},1032,["type","onClick"])]),default:t(()=>[b("span",null,v(e.title),1)]),_:2},1024))),128)),n(W,{vertical:""}),(s(!0),f(C,null,S($,e=>(s(),c(k,{key:e.key,placement:"bottom",trigger:"hover"},{trigger:t(()=>[n(_,{size:"small",ghost:"",type:"primary",disabled:!e.select,onClick:j=>O(e)},{default:t(()=>[(s(),c(h(e.icon)))]),_:2},1032,["disabled","onClick"])]),default:t(()=>[b("span",null,v(e.title),1)]),_:2},1024))),128))]),_:1})]),_:1})}}});const _e=Z(oe,[["__scopeId","data-v-9bd0a48f"]]);export{_e as default};