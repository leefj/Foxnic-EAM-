import{u as te}from"./chartEditStore-45e70a9f.js";import{b6 as re,g as ne,a6 as n,cv as D,cw as $,cx as U,bf as g,aY as P}from"./index-232a8936.js";var G={exports:{}};(function(a){(function(c){var o,s={},p={16:!1,18:!1,17:!1,91:!1},S="all",K={"⇧":16,shift:16,"⌥":18,alt:18,option:18,"⌃":17,ctrl:17,control:17,"⌘":91,command:91},W={backspace:8,tab:9,clear:12,enter:13,return:13,esc:27,escape:27,space:32,left:37,up:38,right:39,down:40,del:46,delete:46,home:36,end:35,pageup:33,pagedown:34,",":188,".":190,"/":191,"`":192,"-":189,"=":187,";":186,"'":222,"[":219,"]":221,"\\":220},A=function(e){return W[e]||e.toUpperCase().charCodeAt(0)},E=[];for(o=1;o<20;o++)W["f"+o]=111+o;function O(e,t){for(var r=e.length;r--;)if(e[r]===t)return r;return-1}function I(e,t){if(e.length!=t.length)return!1;for(var r=0;r<e.length;r++)if(e[r]!==t[r])return!1;return!0}var N={16:"shiftKey",18:"altKey",17:"ctrlKey",91:"metaKey"};function x(e){for(o in p)p[o]=e[N[o]]}function B(e){var t,r,i,R,m,v;if(t=e.keyCode,O(E,t)==-1&&E.push(t),(t==93||t==224)&&(t=91),t in p){p[t]=!0;for(i in K)K[i]==t&&(T[i]=!0);return}if(x(e),!!T.filter.call(this,e)&&t in s){for(v=C(),R=0;R<s[t].length;R++)if(r=s[t][R],r.scope==v||r.scope=="all"){m=r.mods.length>0;for(i in p)(!p[i]&&O(r.mods,+i)>-1||p[i]&&O(r.mods,+i)==-1)&&(m=!1);(r.mods.length==0&&!p[16]&&!p[18]&&!p[17]&&!p[91]||m)&&r.method(e,r)===!1&&(e.preventDefault?e.preventDefault():e.returnValue=!1,e.stopPropagation&&e.stopPropagation(),e.cancelBubble&&(e.cancelBubble=!0))}}}function z(e){var t=e.keyCode,r,i=O(E,t);if(i>=0&&E.splice(i,1),(t==93||t==224)&&(t=91),t in p){p[t]=!1;for(r in K)K[r]==t&&(T[r]=!1)}}function Y(){for(o in p)p[o]=!1;for(o in K)T[o]=!1}function T(e,t,r){var i,R;i=_(e),r===void 0&&(r=t,t="all");for(var m=0;m<i.length;m++)R=[],e=i[m].split("+"),e.length>1&&(R=M(e),e=[e[e.length-1]]),e=e[0],e=A(e),e in s||(s[e]=[]),s[e].push({shortcut:i[m],scope:t,method:r,key:i[m],mods:R})}function j(e,t){var r,i,R=[],m,v,L;for(r=_(e),v=0;v<r.length;v++){if(i=r[v].split("+"),i.length>1&&(R=M(i),e=i[i.length-1]),e=A(e),t===void 0&&(t=C()),!s[e])return;for(m=0;m<s[e].length;m++)L=s[e][m],L.scope===t&&I(L.mods,R)&&(s[e][m]={})}}function X(e){return typeof e=="string"&&(e=A(e)),O(E,e)!=-1}function q(){return E.slice(0)}function J(e){var t=(e.target||e.srcElement).tagName;return!(t=="INPUT"||t=="SELECT"||t=="TEXTAREA")}for(o in K)T[o]=!1;function Q(e){S=e||"all"}function C(){return S||"all"}function Z(e){var t,r,i;for(t in s)for(r=s[t],i=0;i<r.length;)r[i].scope===e?r.splice(i,1):i++}function _(e){var t;return e=e.replace(/\s/g,""),t=e.split(","),t[t.length-1]==""&&(t[t.length-2]+=","),t}function M(e){for(var t=e.slice(0,e.length-1),r=0;r<t.length;r++)t[r]=K[t[r]];return t}function b(e,t,r){e.addEventListener?e.addEventListener(t,r,!1):e.attachEvent&&e.attachEvent("on"+t,function(){r(window.event)})}b(document,"keydown",function(e){B(e)}),b(document,"keyup",z),b(window,"focus",Y);var V=c.key;function ee(){var e=c.key;return c.key=V,e}c.key=T,c.key.setScope=Q,c.key.getScope=C,c.key.deleteScope=Z,c.key.filter=J,c.key.isPressed=X,c.key.getPressedKeyCodes=q,c.key.noConflict=ee,c.key.unbind=j,a.exports=T})(re)})(G);var oe=G.exports;const f=ne(oe),d=te(),w=a=>`${D.CTRL}+${a}`,k=a=>`${D.SHIFT}+${a}`,l={[n.ARROW_UP]:w("up"),[n.ARROW_RIGHT]:w("right"),[n.ARROW_DOWN]:w("down"),[n.ARROW_LEFT]:w("left"),[n.COPY]:w("c"),[n.CUT]:w("x"),[n.PARSE]:w("v"),[n.DELETE]:"delete",[n.BACK]:w("z"),[n.FORWORD]:w(k("z")),[n.GROUP]:w("g"),[n.UN_GROUP]:w(k("g")),[n.LOCK]:w("l"),[n.UNLOCK]:w(k("l")),[n.HIDE]:w("h"),[n.SHOW]:w(k("h"))},h=a=>`${$.CTRL}+${a}`,y=a=>`${$.SHIFT}+${a}`,u={[n.ARROW_UP]:h("arrowup"),[n.ARROW_RIGHT]:h("arrowright"),[n.ARROW_DOWN]:h("arrowdown"),[n.ARROW_LEFT]:h("arrowleft"),[n.COPY]:h("c"),[n.CUT]:h("x"),[n.PARSE]:h("v"),[n.DELETE]:h("backspace"),[n.BACK]:h("z"),[n.FORWORD]:h(y("z")),[n.GROUP]:h("g"),[n.UN_GROUP]:h(y("g")),[n.LOCK]:h("l"),[n.UNLOCK]:h(y("l")),[n.HIDE]:h("h"),[n.SHOW]:h(y("h"))},H=[l.up,l.right,l.down,l.left,l.delete,l.copy,l.cut,l.parse,l.back,l.forward,l.group,l.unGroup,l.lock,l.unLock,l.hide,l.show],F=[u.up,u.right,u.down,u.left,u.delete,u.copy,u.cut,u.parse,u.back,u.forward,u.group,u.unGroup,u.lock,u.unLock,u.hide,u.show],se=()=>{window.$KeyboardActive={ctrl:!1,space:!1},document.onkeydown=a=>{const{keyCode:c}=a;if(c==32&&a.target==document.body&&a.preventDefault(),[17,32].includes(c)&&window.$KeyboardActive)switch(U(a.keyCode),c){case 17:window.$KeyboardActive.ctrl=!0;break;case 32:window.$KeyboardActive.space=!0;break}},document.onkeyup=a=>{const{keyCode:c}=a;if(c==32&&a.target==document.body&&a.preventDefault(),[17,32].includes(c)&&window.$KeyboardActive)switch(U(),c){case 17:window.$KeyboardActive.ctrl=!1;break;case 32:window.$KeyboardActive.space=!1;break}}},ce=()=>{const c=(o,s)=>{switch(s){case o.up:f(s,g(()=>(d.setMove(n.ARROW_UP),!1),50));break;case o.right:f(s,g(()=>(d.setMove(n.ARROW_RIGHT),!1),50));break;case o.down:f(s,g(()=>(d.setMove(n.ARROW_DOWN),!1),50));break;case o.left:f(s,g(()=>(d.setMove(n.ARROW_LEFT),!1),50));break;case o.delete:f(s,P(()=>(d.removeComponentList(),!1),50));break;case o.copy:f(s,P(()=>(d.setCopy(),!1),50));break;case o.cut:f(s,P(()=>(d.setCut(),!1),50));break;case o.parse:f(s,g(()=>(d.setParse(),!1),50));break;case o.back:f(s,g(()=>(d.setBack(),!1),50));break;case o.forward:f(s,g(()=>(d.setForward(),!1),50));break;case o.group:f(s,g(()=>(d.setGroup(),!1),50));break;case o.unGroup:f(s,g(()=>(d.setUnGroup(),!1),50));break;case o.lock:f(s,g(()=>(d.setLock(),!1),50));break;case o.unLock:f(s,g(()=>(d.setUnLock(),!1),50));break;case o.hide:f(s,g(()=>(d.setHide(),!1),50));break;case o.show:f(s,g(()=>(d.setShow(),!1),50));break}};H.forEach(o=>{c(l,o)}),F.forEach(o=>{c(u,o)}),se()},fe=()=>{document.onkeydown=()=>{},document.onkeyup=()=>{},H.forEach(a=>{f.unbind(a)}),F.forEach(a=>{f.unbind(a)})};export{ce as a,fe as u};