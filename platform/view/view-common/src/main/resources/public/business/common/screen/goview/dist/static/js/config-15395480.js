var s=Object.defineProperty,m=Object.defineProperties;var d=Object.getOwnPropertyDescriptors;var r=Object.getOwnPropertySymbols;var g=Object.prototype.hasOwnProperty,C=Object.prototype.propertyIsEnumerable;var i=(e,o,p)=>o in e?s(e,o,{enumerable:!0,configurable:!0,writable:!0,value:p}):e[o]=p,a=(e,o)=>{for(var p in o||(o={}))g.call(o,p)&&i(e,p,o[p]);if(r)for(var p of r(o))C.call(o,p)&&i(e,p,o[p]);return e},f=(e,o)=>m(e,d(o));var t=(e,o,p)=>(i(e,typeof o!="symbol"?o+"":o,p),p);import{aJ as c,a5 as l}from"./index-c6cc3b14.js";import{d as h}from"./chartEditStore-3ee495ca.js";import{g as n}from"./index-68969097.js";import"./plugin-0dcb0bd6.js";import"./icon-8314374d.js";import"./SettingItem-ec2fd044.js";/* empty css                                                                       */import"./SettingItemBox-cf908047.js";import"./CollapseItem.vue_vue_type_script_setup_true_lang-81d1b4a3.js";import"./index.esm.min-4d91f069.js";import"./http-abbaebe7.js";import"./lodash-c32566df.js";import"./fileTypeEnum-21359a08.js";const D={dataset:10*60,useEndDate:!1,endDate:new Date().getTime(),style:"时分秒",showDay:!1,flipperBgColor:"#16293E",flipperTextColor:"#4A9EF8FF",flipperWidth:30,flipperHeight:50,flipperRadius:5,flipperGap:10,flipperType:"down",flipperSpeed:450};class H extends h{constructor(){super(...arguments);t(this,"key",n.key);t(this,"attr",f(a({},c),{w:500,h:100,zIndex:-1}));t(this,"chartConfig",l(n));t(this,"option",l(D))}}export{H as default,D as option};