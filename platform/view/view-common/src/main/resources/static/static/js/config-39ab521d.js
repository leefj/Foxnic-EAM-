var l=Object.defineProperty,c=Object.defineProperties;var f=Object.getOwnPropertyDescriptors;var r=Object.getOwnPropertySymbols;var C=Object.prototype.hasOwnProperty,u=Object.prototype.propertyIsEnumerable;var i=(a,t,o)=>t in a?l(a,t,{enumerable:!0,configurable:!0,writable:!0,value:o}):a[t]=o,n=(a,t)=>{for(var o in t||(t={}))C.call(t,o)&&i(a,o,t[o]);if(r)for(var o of r(t))u.call(t,o)&&i(a,o,t[o]);return a},p=(a,t)=>c(a,f(t));var e=(a,t,o)=>(i(a,typeof t!="symbol"?t+"":t,o),o);import{aM as E,a8 as s,cy as T}from"./index-bb2cbf17.js";import{d}from"./chartEditStore-55fbe93c.js";import{w as m,x as g,y as A}from"./index-0ec04aee.js";import"./plugin-3ef0fcec.js";import"./icon-f36697ff.js";import"./SettingItem-7fe1cfec.js";/* empty css                                                                      */import"./SettingItemBox-500aaf18.js";import"./CollapseItem.vue_vue_type_script_setup_true_lang-9b6d8958.js";import"./index.esm.min-f1367f57.js";import"./http-36f53bd1.js";import"./lodash-d17632fd.js";import"./fileTypeEnum-21359a08.js";const I={[T]:A.DATA,selectValue:"1",dataset:[{label:"选项1",value:"1"},{label:"选项2",value:"2"},{label:"选项3",value:"3"}]};class z extends d{constructor(){super(...arguments);e(this,"key",m.key);e(this,"attr",p(n({},E),{w:260,h:32,zIndex:-1}));e(this,"chartConfig",s(m));e(this,"interactActions",g);e(this,"option",s(I))}}export{z as default,I as option};