import{d as k,r as a,o as n,c as d,e as s,w as o,f as y,t as B,q as i,b as l,Q as x,u as C,R as S,a5 as u,E as f,ao as m,j as $}from"./index-bb2cbf17.js";import{i as N}from"./icon-f36697ff.js";const T={key:0,class:"top go-mt-0 go-flex-no-wrap"},I={class:"mt-1"},V={key:1,class:"bottom go-mt-0"},z={class:"aside"},D=k({__name:"index",props:{title:String,showTop:{type:Boolean,default:!0},showBottom:{type:Boolean,default:!1},flex:{type:Boolean,default:!1},backIcon:{type:Boolean,default:!0},depth:{type:Number,default:1},xScroll:{type:Boolean,default:!1},disabledScroll:{type:Boolean,default:!1}},emits:["back"],setup(e,{emit:h}){const{ChevronBackOutlineIcon:p}=N.ionicons5,_=h,v=()=>{_("back")};return(t,E)=>{const b=a("n-text"),g=a("n-ellipsis"),r=a("n-space"),w=a("n-icon"),c=a("n-scrollbar");return n(),d("div",{class:m(["go-content-box",[`bg-depth${e.depth}`,e.flex&&"flex"]])},[e.showTop?(n(),d("div",T,[s(r,{class:"go-flex-no-wrap",size:5},{default:o(()=>[s(g,null,{default:o(()=>[s(b,null,{default:o(()=>[y(B(e.title),1)]),_:1})]),_:1}),i("div",I,[l(t.$slots,"icon",{},void 0,!0)])]),_:3}),s(r,{class:"go-flex-no-wrap",align:"center",style:{gap:"4px"}},{default:o(()=>[l(t.$slots,"top-right",{},void 0,!0),x(s(w,{size:"20",class:"go-cursor-pointer go-d-block",onClick:v},{default:o(()=>[s(C(p))]),_:1},512),[[S,e.backIcon]])]),_:3})])):u("",!0),i("div",{class:m(["content",{"content-height-show-top-bottom":e.showBottom||e.showTop,"content-height-show-both":e.showBottom&&e.showTop}])},[e.disabledScroll?l(t.$slots,"default",{key:0},void 0,!0):e.xScroll?(n(),f(c,{key:1,"x-scrollable":""},{default:o(()=>[s(c,null,{default:o(()=>[l(t.$slots,"default",{},void 0,!0)]),_:3})]),_:3})):(n(),f(c,{key:2},{default:o(()=>[l(t.$slots,"default",{},void 0,!0)]),_:3}))],2),e.showBottom?(n(),d("div",V,[l(t.$slots,"bottom",{},void 0,!0)])):u("",!0),i("div",z,[l(t.$slots,"aside",{},void 0,!0)])],2)}}});const H=$(D,[["__scopeId","data-v-247d09d8"]]);export{H as C};