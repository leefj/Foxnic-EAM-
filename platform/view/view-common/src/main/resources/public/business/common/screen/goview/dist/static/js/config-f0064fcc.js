var n=Object.defineProperty,s=Object.defineProperties;var d=Object.getOwnPropertyDescriptors;var e=Object.getOwnPropertySymbols;var g=Object.prototype.hasOwnProperty,C=Object.prototype.propertyIsEnumerable;var t=(r,p,i)=>p in r?n(r,p,{enumerable:!0,configurable:!0,writable:!0,value:i}):r[p]=i,f=(r,p)=>{for(var i in p||(p={}))g.call(p,i)&&t(r,i,p[i]);if(e)for(var i of e(p))C.call(p,i)&&t(r,i,p[i]);return r},l=(r,p)=>s(r,d(p));var o=(r,p,i)=>(t(r,typeof p!="symbol"?p+"":p,i),i);import{aM as h,a8 as a}from"./index-ccbc2f92.js";import{d as c}from"./chartEditStore-45e1a76d.js";import{F as m}from"./index-717da49f.js";import"./plugin-a694cf20.js";import"./icon-821d6910.js";import"./SettingItem-abb1a26b.js";/* empty css                                                                      */import"./SettingItemBox-d2398725.js";import"./CollapseItem.vue_vue_type_script_setup_true_lang-08515eb0.js";import"./index.esm.min-ba907e3b.js";import"./http-2d25b213.js";import"./lodash-a46480a3.js";import"./fileTypeEnum-21359a08.js";const F={dataset:3234,flipperLength:6,flipperBgColor:"#16293E",flipperTextColor:"#4A9EF8FF",flipperWidth:30,flipperHeight:50,flipperRadius:5,flipperGap:10,flipperType:"down",flipperSpeed:450,flipperBorderWidth:0};class G extends c{constructor(){super(...arguments);o(this,"key",m.key);o(this,"attr",l(f({},h),{w:300,h:100,zIndex:-1}));o(this,"chartConfig",a(m));o(this,"option",a(F))}}export{G as default,F as option};