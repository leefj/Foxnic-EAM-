      38, ${l(i)-11} 41, ${l(i)-8} 73, ${l(i)-8} 75, ${l(i)-10} 81, ${l(i)-10}
      85, ${l(i)-6} ${l(n)-85}, ${l(i)-6} ${l(n)-81}, ${l(i)-10} ${l(n)-75}, ${l(i)-10}
      ${l(n)-73}, ${l(i)-8} ${l(n)-41}, ${l(i)-8} ${l(n)-38}, ${l(i)-11}
      ${l(n)-24}, ${l(i)-11} ${l(n)-13}, ${l(i)-21} ${l(n)-13}, ${l(i)-24}
      ${l(n)-10}, ${l(i)-27} ${l(n)-10}, 27 ${l(n)-13}, 25 ${l(n)-13}, 21
      ${l(n)-24}, 11 ${l(n)-38}, 11 ${l(n)-41}, 8 ${l(n)-73}, 8 ${l(n)-75}, 10
      ${l(n)-81}, 10 ${l(n)-85}, 6 85, 6 81, 10 75, 10 73, 8 41, 8 38, 11 24, 11 13, 21 13, 24`},null,8,gm)],8,mm)),(P(),n1(x1,null,J1(t,d=>j("svg",{width:l(n),height:l(i),key:d,class:z5(`border-item ${d}`)},[j("polygon",{fill:l(a)[0],points:"6,66 6,18 12,12 18,12 24,6 27,6 30,9 36,9 39,6 84,6 81,9 75,9 73.2,7 40.8,7 37.8,10.2 24,10.2 12,21 12,24 9,27 9,51 7.8,54 7.8,63"},[j("animate",{attributeName:"fill",values:`${l(a)[0]};${l(a)[1]};${l(a)[0]}`,dur:`${l(r)}s`,begin:"0s",repeatCount:"indefinite"},null,8,ym)],8,vm),j("polygon",{fill:l(a)[1],points:"27.599999999999998,4.8 38.4,4.8 35.4,7.8 30.599999999999998,7.8"},[j("animate",{attributeName:"fill",values:`${l(a)[1]};${l(a)[0]};${l(a)[1]}`,dur:`${l(r)}s`,begin:"0s",repeatCount:"indefinite"},null,8,xm)],8,bm),j("polygon",{fill:l(a)[0],points:"9,54 9,63 7.199999999999999,66 7.199999999999999,75 7.8,78 7.8,110 8.4,110 8.4,66 9.6,66 9.6,54"},[j("animate",{attributeName:"fill",values:`${l(a)[0]};${l(a)[1]};transparent`,dur:`${l(r)+1}s`,begin:"0s",repeatCount:"indefinite"},null,8,Mm)],8,Sm)],10,_m)),64))]))}});const wm=c2(Am,[["__scopeId","data-v-708ac670"]]),Cm=Object.freeze(Object.defineProperty({__proto__:null,default:wm},Symbol.toStringTag,{value:"Module"})),Tm={class:"go-border-box"},Em=["width","height"],Dm=["fill","stroke","d"],Im=["stroke"],Rm=["stroke"],Om=["stroke","d"],Pm=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,backgroundColor:a}=E1(e.chartConfig.option);return(r,s)=>(P(),n1("div",Tm,[(P(),n1("svg",{width:l(t),height:l(n)},[j("path",{fill:l(a),stroke:l(i)[0],d:`
          M 5 20 L 5 10 L 12 3  L 60 3 L 68 10
          L ${l(t)-20} 10 L ${l(t)-5} 25
          L ${l(t)-5} ${l(n)-5} L 20 ${l(n)-5}
          L 5 ${l(n)-20} L 5 20
        `},null,8,Dm),j("path",{fill:"transparent","stroke-w":"3","stroke-linecap":"round","stroke-dasharray":"10, 5",stroke:l(i)[0],d:"M 16 9 L 61 9"},null,8,Im),j("path",{fill:"transparent",stroke:l(i)[1],d:"M 5 20 L 5 10 L 12 3  L 60 3 L 68 10"},null,8,Rm),j("path",{fill:"transparent",stroke:l(i)[1],d:`M ${l(t)-5} ${l(n)-30} L ${l(t)-5} ${l(n)-5} L ${l(t)-30} ${l(n)-5}`},null,8,Om)],8,Em))]))}});const Lm=c2(Pm,[["__scopeId","data-v-fc7dd111"]]),zm=Object.freeze(Object.defineProperty({__proto__:null,default:Lm},Symbol.toStringTag,{value:"Module"})),t6=o=>(d0("data-v-b07bae32"),o=o(),f0(),o),km={class:"go-border-box"},Nm=["width","height"],Um=t6(()=>j("feMorphology",{operator:"dilate",radius:"1",in:"SourceAlpha",result:"thicken"},null,-1)),Fm=t6(()=>j("feGaussianBlur",{in:"thicken",stdDeviation:"2",result:"blurred"},null,-1)),Bm=["flood-color"],Gm=["values"],Vm=t6(()=>j("feComposite",{in:"glowColor",in2:"blurred",operator:"in",result:"softGlowColored"},null,-1)),jm=t6(()=>j("feMerge",null,[j("feMergeNode",{in:"softGlowColored"}),j("feMergeNode",{in:"SourceGraphic"})],-1)),Wm=["fill","stroke","d"],Hm=["filter","stroke"],Ym=["filter","stroke","d"],$m=["filter","stroke","d"],Jm=["filter","stroke","d"],Zm=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=`border-box-03-filterId-${L4()}`,{w:n,h:i}=E1(e.chartConfig.attr),{colors:a,backgroundColor:r}=E1(e.chartConfig.option);return(s,u)=>(P(),n1("div",km,[(P(),n1("svg",{width:l(n),height:l(i)},[j("defs",null,[j("filter",{id:t,height:"150%",width:"150%",x:"-25%",y:"-25%"},[Um,Fm,j("feFlood",{"flood-color":l(H5)(l(a)[1],.7),result:"glowColor"},[j("animate",{attributeName:"flood-color",values:`
                ${l(H5)(l(a)[1],.7)};
                ${l(H5)(l(a)[1],.3)};
                ${l(H5)(l(a)[1],.7)};
              `,dur:"3s",begin:"0s",repeatCount:"indefinite"},null,8,Gm)],8,Bm),Vm,jm])]),l(n)&&l(i)?(P(),n1("path",{key:0,fill:l(r),"stroke-width":"2",stroke:l(a)[0],d:`
          M15 5 L ${l(n)-15} 5 Q ${l(n)-5} 5, ${l(n)-5} 15
          L ${l(n)-5} ${l(i)-15} Q ${l(n)-5} ${l(i)-5}, ${l(n)-15} ${l(i)-5}
          L 15, ${l(i)-5} Q 5 ${l(i)-5} 5 ${l(i)-15} L 5 15
          Q 5 5 15 5
        `},null,8,Wm)):V2("",!0),j("path",{"stroke-width":"2",fill:"transparent","stroke-linecap":"round",filter:`url(#${t})`,stroke:l(a)[1],d:"M 20 5 L 15 5 Q 5 5 5 15 L 5 20"},null,8,Hm),j("path",{"stroke-width":"2",fill:"transparent","stroke-linecap":"round",filter:`url(#${t})`,stroke:l(a)[1],d:`M ${l(n)-20} 5 L ${l(n)-15} 5 Q ${l(n)-5} 5 ${l(n)-5} 15 L ${l(n)-5} 20`},null,8,Ym),j("path",{"stroke-width":"2",fill:"transparent","stroke-linecap":"round",filter:`url(#${t})`,stroke:l(a)[1],d:`
          M ${l(n)-20} ${l(i)-5} L ${l(n)-15} ${l(i)-5}
          Q ${l(n)-5} ${l(i)-5} ${l(n)-5} ${l(i)-15}
          L ${l(n)-5} ${l(i)-20}
        `},null,8,$m),j("path",{"stroke-width":"2",fill:"transparent","stroke-linecap":"round",filter:`url(#${t})`,stroke:l(a)[1],d:`
          M 20 ${l(i)-5} L 15 ${l(i)-5}
          Q 5 ${l(i)-5} 5 ${l(i)-15}
          L 5 ${l(i)-20}
        `},null,8,Jm)],8,Nm))]))}});const Xm=c2(Zm,[["__scopeId","data-v-b07bae32"]]),Qm=Object.freeze(Object.defineProperty({__proto__:null,default:Xm},Symbol.toStringTag,{value:"Module"})),x4=o=>(d0("data-v-4dd6360b"),o=o(),f0(),o),qm={class:"go-border-box"},Km=["width","height"],eg=x4(()=>j("feMorphology",{operator:"dilate",radius:"2",in:"SourceAlpha",result:"thicken"},null,-1)),tg=x4(()=>j("feGaussianBlur",{in:"thicken",stdDeviation:"3",result:"blurred"},null,-1)),ng=["flood-color"],ig=x4(()=>j("feComposite",{in:"glowColor",in2:"blurred",operator:"in",result:"softGlowColored"},null,-1)),og=x4(()=>j("feMerge",null,[j("feMergeNode",{in:"softGlowColored"}),j("feMergeNode",{in:"SourceGraphic"})],-1)),ag=["fill","points"],rg=["fill","stroke","filter","points"],sg=["stroke","points"],lg=["stroke","points"],ug=["stroke","fill","filter","points"],cg=["filter","fill","points"],dg=x4(()=>j("animate",{attributeName:"opacity",values:"1;0.7;1",dur:"2s",begin:"0s",repeatCount:"indefinite"},null,-1)),fg=[dg],hg=["filter","fill","points"],pg=x4(()=>j("animate",{attributeName:"opacity",values:"0.7;0.4;0.7",dur:"2s",begin:"0s",repeatCount:"indefinite"},null,-1)),mg=[pg],gg=["filter","fill","points"],_g=x4(()=>j("animate",{attributeName:"opacity",values:"0.5;0.2;0.5",dur:"2s",begin:"0s",repeatCount:"indefinite"},null,-1)),vg=[_g],yg=["filter","fill","points"],bg=x4(()=>j("animate",{attributeName:"opacity",values:"1;0.7;1",dur:"2s",begin:"0s",repeatCount:"indefinite"},null,-1)),xg=[bg],Sg=["filter","fill","points"],Mg=x4(()=>j("animate",{attributeName:"opacity",values:"0.7;0.4;0.7",dur:"2s",begin:"0s",repeatCount:"indefinite"},null,-1)),Ag=[Mg],wg=["filter","fill","points"],Cg=x4(()=>j("animate",{attributeName:"opacity",values:"0.5;0.2;0.5",dur:"2s",begin:"0s",repeatCount:"indefinite"},null,-1)),Tg=[Cg],Eg=["x","y","fill","font-size"],Dg=["fill","filter","points"],Ig=["fill","filter","points"],Rg=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=`border-box-04-filterId-${L4()}`,{w:n,h:i}=E1(e.chartConfig.attr),{colors:a,borderTitle:r,borderTitleColor:s,borderTitleSize:u,borderTitleHeight:c,borderTitleWidth:d,backgroundColor:h}=E1(e.chartConfig.option);return(p,g)=>(P(),n1("div",qm,[(P(),n1("svg",{width:l(n),height:l(i)},[j("defs",null,[j("filter",{id:t,height:"150%",width:"150%",x:"-25%",y:"-25%"},[eg,tg,j("feFlood",{"flood-color":l(a)[1],result:"glowColor"},null,8,ng),ig,og])]),j("polygon",{fill:l(h),points:`
        20, 32 ${l(n)*.5-l(d)/2}, 32 ${l(n)*.5-l(d)/2+20}, 53
        ${l(n)*.5+l(d)/2-20}, 53 ${l(n)*.5+l(d)/2}, 32
        ${l(n)-20}, 32 ${l(n)-8}, 48 ${l(n)-8}, ${l(i)-25} ${l(n)-20}, ${l(i)-8}
        20, ${l(i)-8} 8, ${l(i)-25} 8, 50
      `},null,8,ag),j("polyline",{fill:l(h),stroke:l(a)[0],filter:`url(#${t})`,points:`
          ${(l(n)-l(d))/2}, 30
          20, 30 7, 50 7, ${50+(l(i)-167)/2}
          13, ${55+(l(i)-167)/2} 13, ${135+(l(i)-167)/2}
          7, ${140+(l(i)-167)/2} 7, ${l(i)-27}
          20, ${l(i)-7} ${l(n)-20}, ${l(i)-7} ${l(n)-7}, ${l(i)-27}
          ${l(n)-7}, ${140+(l(i)-167)/2} ${l(n)-13}, ${135+(l(i)-167)/2}
          ${l(n)-13}, ${55+(l(i)-167)/2} ${l(n)-7}, ${50+(l(i)-167)/2}
          ${l(n)-7}, 50 ${l(n)-20}, 30 ${(l(n)+l(d))/2}, 30
          ${(l(n)+l(d))/2-20}, 7 ${(l(n)-l(d))/2+20}, 7
          ${(l(n)-l(d))/2}, 30 ${(l(n)-l(d))/2+20}, 52
          ${(l(n)+l(d))/2-20}, 52 ${(l(n)+l(d))/2}, 30
        `},null,8,rg),j("polygon",{stroke:l(a)[0],fill:"transparent",points:`
          ${(l(n)+l(d))/2-5}, 30 ${(l(n)+l(d))/2-21}, 11
          ${(l(n)+l(d))/2-27}, 11 ${(l(n)+l(d))/2-8}, 34
        `},null,8,sg),j("polygon",{stroke:l(a)[0],fill:"transparent",points:`
          ${(l(n)-l(d))/2+5}, 30 ${(l(n)-l(d))/2+22}, 49
          ${(l(n)-l(d))/2+28}, 49 ${(l(n)-l(d))/2+8}, 26
        `},null,8,lg),j("polygon",{stroke:l(a)[0],fill:l(a)[1],filter:`url(#${t})`,points:`
          ${(l(n)+l(d))/2-11}, 37 ${(l(n)+l(d))/2-32}, 11
          ${(l(n)-l(d))/2+23}, 11 ${(l(n)-l(d))/2+11}, 23
          ${(l(n)-l(d))/2+33}, 49 ${(l(n)+l(d))/2-22}, 49
        `},null,8,ug),j("polygon",{filter:`url(#${t})`,fill:l(a)[0],opacity:"1",points:`
          ${(l(n)-l(d))/2-10}, 37 ${(l(n)-l(d))/2-31}, 37
          ${(l(n)-l(d))/2-25}, 46 ${(l(n)-l(d))/2-4}, 46
        `},fg,8,cg),j("polygon",{filter:`url(#${t})`,fill:l(a)[0],opacity:"0.7",points:`
          ${(l(n)-l(d))/2-40}, 37 ${(l(n)-l(d))/2-61}, 37
          ${(l(n)-l(d))/2-55}, 46 ${(l(n)-l(d))/2-34}, 46
        `},mg,8,hg),j("polygon",{filter:`url(#${t})`,fill:l(a)[0],opacity:"0.5",points:`
          ${(l(n)-l(d))/2-70}, 37 ${(l(n)-l(d))/2-91}, 37
          ${(l(n)-l(d))/2-85}, 46 ${(l(n)-l(d))/2-64}, 46
        `},vg,8,gg),j("polygon",{filter:`url(#${t})`,fill:l(a)[0],opacity:"1",points:`
          ${(l(n)+l(d))/2+30}, 37 ${(l(n)+l(d))/2+9}, 37
          ${(l(n)+l(d))/2+3}, 46 ${(l(n)+l(d))/2+24}, 46
        `},xg,8,yg),j("polygon",{filter:`url(#${t})`,fill:l(a)[0],opacity:"0.7",points:`
          ${(l(n)+l(d))/2+60}, 37 ${(l(n)+l(d))/2+39}, 37
          ${(l(n)+l(d))/2+33}, 46 ${(l(n)+l(d))/2+54}, 46
        `},Ag,8,Sg),j("polygon",{filter:`url(#${t})`,fill:l(a)[0],opacity:"0.5",points:`
          ${(l(n)+l(d))/2+90}, 37 ${(l(n)+l(d))/2+69}, 37
          ${(l(n)+l(d))/2+63}, 46 ${(l(n)+l(d))/2+84}, 46
        `},Tg,8,wg),j("text",{x:`${l(n)/2}`,y:l(c),fill:l(s),"font-size":l(u),"text-anchor":"middle","dominant-baseline":"middle"},N2(l(r)),9,Eg),j("polygon",{fill:l(a)[0],filter:`url(#${t})`,points:`
          7, ${53+(l(i)-167)/2} 11, ${57+(l(i)-167)/2}
          11, ${133+(l(i)-167)/2} 7, ${137+(l(i)-167)/2}
        `},null,8,Dg),j("polygon",{fill:l(a)[0],filter:`url(#${t})`,points:`
          ${l(n)-7}, ${53+(l(i)-167)/2} ${l(n)-11}, ${57+(l(i)-167)/2}
          ${l(n)-11}, ${133+(l(i)-167)/2} ${l(n)-7}, ${137+(l(i)-167)/2}
        `},null,8,Ig)],8,Km))]))}});const Og=c2(Rg,[["__scopeId","data-v-4dd6360b"]]),Pg=Object.freeze(Object.defineProperty({__proto__:null,default:Og},Symbol.toStringTag,{value:"Module"})),Lg=["width","height"],zg=["fill","points"],kg=["width","height"],Ng=["fill"],Ug=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=["left-top","right-top","left-bottom","right-bottom"],{w:n,h:i}=E1(e.chartConfig.attr),{colors:a,backgroundColor:r}=E1(e.chartConfig.option);return(s,u)=>(P(),n1("div",{class:"go-border-box",style:g2(`box-shadow: inset 0 0 25px 3px ${l(a)[0]}`)},[(P(),n1("svg",{width:l(n),height:l(i)},[j("polygon",{fill:l(r),points:`
        4, 0 ${l(n)-4}, 0 ${l(n)}, 4 ${l(n)}, ${l(i)-4} ${l(n)-4}, ${l(i)}
        4, ${l(i)} 0, ${l(i)-4} 0, 4
      `},null,8,zg)],8,Lg)),(P(),n1(x1,null,J1(t,c=>j("svg",{width:l(n),height:l(i),key:c,class:z5(`border-item ${c}`)},[j("polygon",{fill:l(a)[1],points:"40, 0 5, 0 0, 5 0, 16 3, 19 3, 7 7, 3 35, 3"},null,8,Ng)],10,kg)),64))],4))}});const Fg=c2(Ug,[["__scopeId","data-v-37a601de"]]),Bg=Object.freeze(Object.defineProperty({__proto__:null,default:Fg},Symbol.toStringTag,{value:"Module"})),Gg=["width","height"],Vg=["stroke"],jg=["stroke","points"],Wg=["stroke","points"],Hg=["stroke","points"],Yg=["stroke"],$g=["stroke","points"],Jg=["stroke","points"],Zg=["stroke","points"],Xg=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,backgroundColor:a}=E1(e.chartConfig.option);return(r,s)=>(P(),n1("div",{class:"go-border-box",style:g2(`
      box-shadow: inset 0 0 40px ${l(i)[0]}; 
      border: 1px solid ${l(i)[1]};
      background-color: ${l(a)};
    `)},[(P(),n1("svg",{width:l(t),height:l(n)},[j("polyline",{class:"go-border-line-w-2",stroke:l(i)[0],points:"0, 25 0, 0 25, 0"},null,8,Vg),j("polyline",{class:"go-border-line-w-2",stroke:l(i)[0],points:`${l(t)-25}, 0 ${l(t)}, 0 ${l(t)}, 25`},null,8,jg),j("polyline",{class:"go-border-line-w-2",stroke:l(i)[0],points:`${l(t)-25}, ${l(n)} ${l(t)}, ${l(n)} ${l(t)}, ${l(n)-25}`},null,8,Wg),j("polyline",{class:"go-border-line-w-2",stroke:l(i)[0],points:`0, ${l(n)-25} 0, ${l(n)} 25, ${l(n)}`},null,8,Hg),j("polyline",{class:"go-border-line-w-5",stroke:l(i)[1],points:"0, 10 0, 0 10, 0"},null,8,Yg),j("polyline",{class:"go-border-line-w-5",stroke:l(i)[1],points:`${l(t)-10}, 0 ${l(t)}, 0 ${l(t)}, 10`},null,8,$g),j("polyline",{class:"go-border-line-w-5",stroke:l(i)[1],points:`${l(t)-10}, ${l(n)} ${l(t)}, ${l(n)} ${l(t)}, ${l(n)-10}`},null,8,Jg),j("polyline",{class:"go-border-line-w-5",stroke:l(i)[1],points:`0, ${l(n)-10} 0, ${l(n)} 10, ${l(n)}`},null,8,Zg)],8,Gg))],4))}});const Qg=c2(Xg,[["__scopeId","data-v-9d777740"]]),qg=Object.freeze(Object.defineProperty({__proto__:null,default:Qg},Symbol.toStringTag,{value:"Module"})),Xr=o=>(d0("data-v-1e74db59"),o=o(),f0(),o),Kg={class:"go-border-box"},e_=["width","height"],t_=Xr(()=>j("animate",{attributeName:"x1",values:"0%;100%;0%",dur:"10s",begin:"0s",repeatCount:"indefinite"},null,-1)),n_=Xr(()=>j("animate",{attributeName:"x2",values:"100%;0%;100%",dur:"10s",begin:"0s",repeatCount:"indefinite"},null,-1)),i_=["stop-color"],o_=["values"],a_=["stop-color"],r_=["values"],s_=["points"],l_=["points"],u_=["points"],c_=["points"],d_=["points"],f_=["points"],h_=["points"],p_=["points"],m_=["points"],g_=["fill","points"],__=["width","height","fill","mask"],v_=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=`border-box-07-filter-${L4()}`,n=`border-box-07-mask-${L4()}`,{w:i,h:a}=E1(e.chartConfig.attr),{colors:r,backgroundColor:s}=E1(e.chartConfig.option);return(u,c)=>(P(),n1("div",Kg,[(P(),n1("svg",{width:l(i),height:l(a)},[j("defs",null,[j("linearGradient",{id:t,x1:"0%",y1:"0%",x2:"100%",y2:"100%"},[t_,n_,j("stop",{offset:"0%","stop-color":l(r)[0]},[j("animate",{attributeName:"stop-color",values:`${l(r)[0]};${l(r)[1]};${l(r)[0]}`,dur:"10s",begin:"0s",repeatCount:"indefinite"},null,8,o_)],8,i_),j("stop",{offset:"100%","stop-color":l(r)[1]},[j("animate",{attributeName:"stop-color",values:`${l(r)[1]};${l(r)[0]};${l(r)[1]}`,dur:"10s",begin:"0s",repeatCount:"indefinite"},null,8,r_)],8,a_)]),j("mask",{id:n},[j("polyline",{stroke:"#fff","stroke-width":"3",fill:"transparent",points:`8, ${l(a)*.4} 8, 3, ${l(i)*.4+7}, 3`},null,8,s_),j("polyline",{fill:"#fff",points:`8, ${l(a)*.15} 8, 3, ${l(i)*.1+7}, 3
              ${l(i)*.1}, 8 14, 8 14, ${l(a)*.15-7}
            `},null,8,l_),j("polyline",{stroke:"#fff","stroke-width":"3",fill:"transparent",points:`${l(i)*.5}, 3 ${l(i)-3}, 3, ${l(i)-3}, ${l(a)*.25}`},null,8,u_),j("polyline",{fill:"#fff",points:`
              ${l(i)*.52}, 3 ${l(i)*.58}, 3
              ${l(i)*.58-7}, 9 ${l(i)*.52+7}, 9
            `},null,8,c_),j("polyline",{fill:"#fff",points:`
              ${l(i)*.9}, 3 ${l(i)-3}, 3 ${l(i)-3}, ${l(a)*.1}
              ${l(i)-9}, ${l(a)*.1-7} ${l(i)-9}, 9 ${l(i)*.9+7}, 9
            `},null,8,d_),j("polyline",{stroke:"#fff","stroke-width":"3",fill:"transparent",points:`8, ${l(a)*.5} 8, ${l(a)-3} ${l(i)*.3+7}, ${l(a)-3}`},null,8,f_),j("polyline",{fill:"#fff",points:`
              8, ${l(a)*.55} 8, ${l(a)*.7}
              2, ${l(a)*.7-7} 2, ${l(a)*.55+7}
            `},null,8,h_),j("polyline",{stroke:"#fff","stroke-width":"3",fill:"transparent",points:`${l(i)*.35}, ${l(a)-3} ${l(i)-3}, ${l(a)-3} ${l(i)-3}, ${l(a)*.35}`},null,8,p_),j("polyline",{fill:"#fff",points:`
              ${l(i)*.92}, ${l(a)-3} ${l(i)-3}, ${l(a)-3} ${l(i)-3}, ${l(a)*.8}
              ${l(i)-9}, ${l(a)*.8+7} ${l(i)-9}, ${l(a)-9} ${l(i)*.92+7}, ${l(a)-9}
            `},null,8,m_)])]),j("polygon",{fill:l(s),points:`
        15, 9 ${l(i)*.1+1}, 9 ${l(i)*.1+4}, 6 ${l(i)*.52+2}, 6
        ${l(i)*.52+6}, 10 ${l(i)*.58-7}, 10 ${l(i)*.58-2}, 6
        ${l(i)*.9+2}, 6 ${l(i)*.9+6}, 10 ${l(i)-10}, 10 ${l(i)-10}, ${l(a)*.1-6}
        ${l(i)-6}, ${l(a)*.1-1} ${l(i)-6}, ${l(a)*.8+1} ${l(i)-10}, ${l(a)*.8+6}
        ${l(i)-10}, ${l(a)-10} ${l(i)*.92+7}, ${l(a)-10}  ${l(i)*.92+2}, ${l(a)-6}
        11, ${l(a)-6} 11, ${l(a)*.15-2} 15, ${l(a)*.15-7}
      `},null,8,g_),j("rect",{x:"0",y:"0",width:l(i),height:l(a),fill:`url(#${t})`,mask:`url(#${n})`},null,8,__)],8,e_))]))}});const y_=c2(v_,[["__scopeId","data-v-1e74db59"]]),b_=Object.freeze(Object.defineProperty({__proto__:null,default:y_},Symbol.toStringTag,{value:"Module"})),Qr=o=>(d0("data-v-966367ac"),o=o(),f0(),o),x_={class:"go-border-box"},S_=["width","height"],M_=["d"],A_=Qr(()=>j("stop",{offset:"0%","stop-color":"#fff","stop-opacity":"1"},null,-1)),w_=Qr(()=>j("stop",{offset:"100%","stop-color":"#fff","stop-opacity":"0"},null,-1)),C_=[A_,w_],T_=["fill"],E_=["dur","path"],D_=["fill","points"],I_=["stroke","xlink:href"],R_=["stroke","xlink:href","mask"],O_=["from","to","dur"],P_=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=`border-box-08-path-${L4()}`,n=`border-box-08-gradient-${L4()}`,i=`border-box-08-mask-${L4()}`,{w:a,h:r}=E1(e.chartConfig.attr),{colors:s,dur:u,backgroundColor:c,reverse:d}=E1(e.chartConfig.option),h=a2(()=>(a.value+r.value-5)*2),p=a2(()=>d.value?`M 2.5, 2.5 L 2.5, ${r.value-2.5} L ${a.value-2.5}, ${r.value-2.5} L ${a.value-2.5}, 2.5 L 2.5, 2.5`:`M2.5, 2.5 L${a.value-2.5}, 2.5 L${a.value-2.5}, ${r.value-2.5} L2.5, ${r.value-2.5} L2.5, 2.5`);return(g,y)=>(P(),n1("div",x_,[(P(),n1("svg",{width:l(a),height:l(r)},[j("defs",null,[j("path",{id:t,d:p.value,fill:"transparent"},null,8,M_),j("radialGradient",{id:n,cx:"50%",cy:"50%",r:"50%"},C_),j("mask",{id:i},[j("circle",{cx:"0",cy:"0",r:"150",fill:`url(#${n})`},[j("animateMotion",{dur:`${l(u)}s`,path:p.value,rotate:"auto",repeatCount:"indefinite"},null,8,E_)],8,T_)])]),j("polygon",{fill:l(c),points:`5, 5 ${l(a)-5}, 5 ${l(a)-5} ${l(r)-5} 5, ${l(r)-5}`},null,8,D_),j("use",{stroke:l(s)[0],"stroke-width":"1","xlink:href":`#${t}`},null,8,I_),j("use",{stroke:l(s)[1],"stroke-width":"3","xlink:href":`#${t}`,mask:`url(#${i})`},[j("animate",{attributeName:"stroke-dasharray",from:`0, ${h.value}`,to:`${h.value}, 0`,dur:`${l(u)}s`,repeatCount:"indefinite"},null,8,O_)],8,R_)],8,S_))]))}});const L_=c2(P_,[["__scopeId","data-v-966367ac"]]),z_=Object.freeze(Object.defineProperty({__proto__:null,default:L_},Symbol.toStringTag,{value:"Module"})),k_={class:"go-border-box"},N_=["width","height"],U_=["fill","points"],F_=["fill"],B_=["fill","cx"],G_=["fill","cx","cy"],V_=["fill","cy"],j_=["stroke","points"],W_=["stroke","points"],H_=["stroke","points"],Y_=["stroke","points"],$_=["stroke"],J_=["stroke"],Z_=["stroke","points"],X_=["stroke","points"],Q_=["stroke","points"],q_=["stroke","points"],K_=["stroke","points"],ev=["stroke","points"],tv=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,backgroundColor:a}=E1(e.chartConfig.option);return(r,s)=>(P(),n1("div",k_,[(P(),n1("svg",{width:l(t),height:l(n)},[j("polygon",{fill:l(a),points:` 9, 7 ${l(t)-9}, 7 ${l(t)-9}, ${l(n)-7} 9, ${l(n)-7}`},null,8,U_),j("circle",{fill:l(i)[1],cx:"5",cy:"5",r:"2"},null,8,F_),j("circle",{fill:l(i)[1],cx:l(t)-5,cy:"5",r:"2"},null,8,B_),j("circle",{fill:l(i)[1],cx:l(t)-5,cy:l(n)-5,r:"2"},null,8,G_),j("circle",{fill:l(i)[1],cx:"5",cy:l(n)-5,r:"2"},null,8,V_),j("polyline",{stroke:l(i)[0],points:`10, 4 ${l(t)-10}, 4`},null,8,j_),j("polyline",{stroke:l(i)[0],points:`10, ${l(n)-4} ${l(t)-10}, ${l(n)-4}`},null,8,W_),j("polyline",{stroke:l(i)[0],points:`5, 70 5, ${l(n)-70}`},null,8,H_),j("polyline",{stroke:l(i)[0],points:`${l(t)-5}, 70 ${l(t)-5}, ${l(n)-70}`},null,8,Y_),j("polyline",{stroke:l(i)[0],points:"3, 10, 3, 50"},null,8,$_),j("polyline",{stroke:l(i)[0],points:"7, 30 7, 80"},null,8,J_),j("polyline",{stroke:l(i)[0],points:`${l(t)-3}, 10 ${l(t)-3}, 50`},null,8,Z_),j("polyline",{stroke:l(i)[0],points:`${l(t)-7}, 30 ${l(t)-7}, 80`},null,8,X_),j("polyline",{stroke:l(i)[0],points:`3, ${l(n)-10} 3, ${l(n)-50}`},null,8,Q_),j("polyline",{stroke:l(i)[0],points:`7, ${l(n)-30} 7, ${l(n)-80}`},null,8,q_),j("polyline",{stroke:l(i)[0],points:`${l(t)-3}, ${l(n)-10} ${l(t)-3}, ${l(n)-50}`},null,8,K_),j("polyline",{stroke:l(i)[0],points:`${l(t)-7}, ${l(n)-30} ${l(t)-7}, ${l(n)-80}`},null,8,ev)],8,N_))]))}});const nv=c2(tv,[["__scopeId","data-v-a43eb02e"]]),iv=Object.freeze(Object.defineProperty({__proto__:null,default:nv},Symbol.toStringTag,{value:"Module"})),ov={class:"go-border-box"},av=["width","height"],rv=["fill","points"],sv=["stroke","points"],lv=["stroke","points"],uv=["stroke","points"],cv=["stroke"],dv=["stroke"],fv=["stroke"],hv=["stroke"],pv=["stroke"],mv=["stroke","points"],gv=["stroke","points"],_v=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,backgroundColor:a}=E1(e.chartConfig.option);return(r,s)=>(P(),n1("div",ov,[(P(),n1("svg",{width:l(t),height:l(n)},[j("polygon",{fill:l(a),points:`
        ${l(t)-15}, 22 170, 22 150, 7 40, 7 28, 21 32, 24
        16, 42 16, ${l(n)-32} 41, ${l(n)-7} ${l(t)-15}, ${l(n)-7}
      `},null,8,rv),j("polyline",{class:"go-border-line-1",stroke:l(i)[0],points:`145, ${l(n)-5} 40, ${l(n)-5} 10, ${l(n)-35}
          10, 40 40, 5 150, 5 170, 20 ${l(t)-15}, 20`},null,8,sv),j("polyline",{stroke:l(i)[1],class:"go-border-line-2",points:`245, ${l(n)-1} 36, ${l(n)-1} 14, ${l(n)-23}
          14, ${l(n)-100}`},null,8,lv),j("polyline",{class:"go-border-line-3",stroke:l(i)[0],points:`7, ${l(n)-40} 7, ${l(n)-75}`},null,8,uv),j("polyline",{class:"go-border-line-4",stroke:l(i)[0],points:"28, 24 13, 41 13, 64"},null,8,cv),j("polyline",{class:"go-border-line-5",stroke:l(i)[0],points:"5, 45 5, 140"},null,8,dv),j("polyline",{class:"go-border-line-6",stroke:l(i)[1],points:"14, 75 14, 180"},null,8,fv),j("polyline",{class:"go-border-line-7",stroke:l(i)[1],points:"55, 11 147, 11 167, 26 250, 26"},null,8,hv),j("polyline",{class:"go-border-line-8",stroke:l(i)[1],points:"158, 5 173, 16"},null,8,pv),j("polyline",{class:"go-border-line-9",stroke:l(i)[0],points:`200, 17 ${l(t)-10}, 17`},null,8,mv),j("polyline",{class:"go-border-line-10",stroke:l(i)[1],points:`385, 17 ${l(t)-10}, 17`},null,8,gv)],8,av))]))}});const vv=c2(_v,[["__scopeId","data-v-03a8a229"]]),yv=Object.freeze(Object.defineProperty({__proto__:null,default:vv},Symbol.toStringTag,{value:"Module"})),bv={class:"go-border-box"},xv=["width","height"],Sv=["fill","points"],Mv=["stroke","points"],Av=["stroke","points"],wv=["stroke","points"],Cv=["stroke","points"],Tv=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,backgroundColor:a}=E1(e.chartConfig.option);return(r,s)=>(P(),n1("div",bv,[(P(),n1("svg",{class:"bv-border-svg-container",width:l(t),height:l(n)},[j("polygon",{fill:l(a),points:`
        23, 23 ${l(t)-24}, 23 ${l(t)-24}, ${l(n)-24} 23, ${l(n)-24}
      `},null,8,Sv),j("polyline",{class:"go-border-line-1",stroke:l(i)[0],points:`4, 4 ${l(t)-22} ,4 ${l(t)-22}, ${l(n)-22} 4, ${l(n)-22} 4, 4`},null,8,Mv),j("polyline",{class:"go-border-line-3",stroke:l(i)[1],points:`10, 10 ${l(t)-16}, 10 ${l(t)-16}, ${l(n)-16} 10, ${l(n)-16} 10, 10`},null,8,Av),j("polyline",{class:"go-border-line-3",stroke:l(i)[1],points:`16, 16 ${l(t)-10}, 16 ${l(t)-10}, ${l(n)-10} 16, ${l(n)-10} 16, 16`},null,8,wv),j("polyline",{class:"go-border-line-3",stroke:l(i)[1],points:`22, 22 ${l(t)-4}, 22 ${l(t)-4}, ${l(n)-4} 22, ${l(n)-4} 22, 22`},null,8,Cv)],8,xv))]))}});const Ev=c2(Tv,[["__scopeId","data-v-454ad1b3"]]),Dv=Object.freeze(Object.defineProperty({__proto__:null,default:Ev},Symbol.toStringTag,{value:"Module"})),Iv={class:"go-border-box"},Rv=["width","height"],Ov=["fill","points"],Pv=["stroke","points"],Lv=["stroke","points"],zv=["stroke","points"],kv=["stroke","points"],Nv=["stroke","points"],Uv=["stroke","points"],Fv=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,backgroundColor:a}=E1(e.chartConfig.option);return(r,s)=>(P(),n1("div",Iv,[(P(),n1("svg",{width:l(t),height:l(n)},[j("polygon",{fill:l(a),points:`
        10, 22 ${l(t)-22}, 22 ${l(t)-22}, ${l(n)-86} ${l(t)-84}, ${l(n)-24} 10, ${l(n)-24}
      `},null,8,Ov),j("polyline",{class:"bv-bb5-line-1",stroke:l(i)[0],points:`8, 5 ${l(t)-5}, 5 ${l(t)-5}, ${l(n)-100}
          ${l(t)-100}, ${l(n)-5} 8, ${l(n)-5} 8, 5`},null,8,Pv),j("polyline",{class:"bv-bb5-line-2",stroke:l(i)[1],points:`3, 5 ${l(t)-20}, 5 ${l(t)-20}, ${l(n)-60}
          ${l(t)-74}, ${l(n)-5} 3, ${l(n)-5} 3, 5`},null,8,Lv),j("polyline",{class:"bv-bb5-line-3",stroke:l(i)[1],points:`50, 13 ${l(t)-35}, 13`},null,8,zv),j("polyline",{class:"bv-bb5-line-4",stroke:l(i)[1],points:`15, 20 ${l(t)-35}, 20`},null,8,kv),j("polyline",{class:"bv-bb5-line-5",stroke:l(i)[1],points:`15, ${l(n)-20} ${l(t)-110}, ${l(n)-20}`},null,8,Nv),j("polyline",{class:"bv-bb5-line-6",stroke:l(i)[1],points:`15, ${l(n)-13} ${l(t)-110}, ${l(n)-13}`},null,8,Uv)],8,Rv))]))}});const Bv=c2(Fv,[["__scopeId","data-v-80c70916"]]),Gv=Object.freeze(Object.defineProperty({__proto__:null,default:Bv},Symbol.toStringTag,{value:"Module"})),Vv={class:"go-border-box"},jv=["width","height"],Wv=["fill","points"],Hv=["stroke","points"],Yv=["stroke","points"],$v=["fill"],Jv=["fill","cx"],Zv=["fill","cx","cy"],Xv=["fill","cy"],Qv=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,backgroundColor:a}=E1(e.chartConfig.option);return(r,s)=>(P(),n1("div",Vv,[(P(),n1("svg",{width:l(t),height:l(n)},[j("polygon",{fill:l(a),points:`
        7, 7 ${l(t)-7}, 7 ${l(t)-7}, ${l(n)-7} 7, ${l(n)-7}
      `},null,8,Wv),j("polyline",{stroke:l(i)[0],points:`2, 2 ${l(t)-2} ,2 ${l(t)-2}, ${l(n)-2} 2, ${l(n)-2} 2, 2`},null,8,Hv),j("polyline",{stroke:l(i)[1],points:`6, 6 ${l(t)-6}, 6 ${l(t)-6}, ${l(n)-6} 6, ${l(n)-6} 6, 6`},null,8,Yv),j("circle",{fill:l(i)[0],cx:"11",cy:"11",r:"1"},null,8,$v),j("circle",{fill:l(i)[0],cx:l(t)-11,cy:"11",r:"1"},null,8,Jv),j("circle",{fill:l(i)[0],cx:l(t)-11,cy:l(n)-11,r:"1"},null,8,Zv),j("circle",{fill:l(i)[0],cx:"11",cy:l(n)-11,r:"1"},null,8,Xv)],8,jv))]))}});const qv=c2(Qv,[["__scopeId","data-v-e5e18ea8"]]),Kv=Object.freeze(Object.defineProperty({__proto__:null,default:qv},Symbol.toStringTag,{value:"Module"})),ey=["width","height"],ty=["x","y","width","height","fill"],ny=["to","dur"],iy=["x","y","width","height","fill"],oy=["to","dur"],ay=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,dur:a,endWidth:r,lineHeight:s}=E1(e.chartConfig.option),u=a2(()=>0),c=a2(()=>n.value/2);return(d,h)=>(P(),n1("svg",{width:l(t),height:l(n)},[j("rect",{x:u.value,y:c.value,width:l(t),height:l(s),fill:l(i)[0]},[j("animate",{attributeName:"width",from:"0",to:l(t),dur:`${l(a)}s`,calcMode:"spline",keyTimes:"0;1",keySplines:".42,0,.58,1",repeatCount:"indefinite"},null,8,ny)],8,ty),j("rect",{x:u.value,y:c.value,width:l(r),height:l(s),fill:l(i)[1]},[j("animate",{attributeName:"x",from:"0",to:l(t),dur:`${l(a)}s`,calcMode:"spline",keyTimes:"0;1",keySplines:"0.42,0,0.58,1",repeatCount:"indefinite"},null,8,oy)],8,iy)],8,ey))}}),ry=Object.freeze(Object.defineProperty({__proto__:null,default:ay},Symbol.toStringTag,{value:"Module"})),sy=["width"],ly=["stroke","points"],uy=["stroke","points"],cy=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,dur:a,lineHeight:r}=E1(e.chartConfig.option);return(s,u)=>(P(),n1("div",{class:"go-decorates-2",style:g2(`width:${l(t)}px; height: ${l(r)}px animation-duration:${l(a)}s`)},[(P(),n1("svg",{width:l(t),height:3},[j("polyline",{stroke:l(i)[0],points:`0, 2.5 ${l(t)}, 2.5`},null,8,ly),j("polyline",{stroke:l(i)[1],"stroke-width":"3","stroke-dasharray":"20, 80","stroke-dashoffset":"-30",points:`0, 2.5 ${l(t)}, 2.5`},null,8,uy)],8,sy))],4))}});const dy=c2(cy,[["__scopeId","data-v-bf54f1e3"]]),fy=Object.freeze(Object.defineProperty({__proto__:null,default:dy},Symbol.toStringTag,{value:"Module"})),hy={width:20,height:20},py=["stroke"],my=["stroke"],gy={width:20,height:20},_y=["stroke"],vy=["stroke"],yy=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,dataset:a,textSize:r,textColor:s}=E1(e.chartConfig.option);return(u,c)=>(P(),n1("div",{class:"go-border-03",style:g2(`width: ${l(t)}px; height: ${l(n)}px`)},[(P(),n1("svg",hy,[j("polyline",{"stroke-width":"4",fill:"transparent",stroke:l(i)[0],points:"10, 0 19, 10 10, 20"},null,8,py),j("polyline",{"stroke-width":"2",fill:"transparent",stroke:l(i)[1],points:"2, 0 11, 10 2, 20"},null,8,my)])),j("span",{style:g2(`color: ${l(s)};font-size: ${l(r)}px`)},N2(l(a)),5),(P(),n1("svg",gy,[j("polyline",{"stroke-width":"4",fill:"transparent",stroke:l(i)[0],points:"11, 0 2, 10 11, 20"},null,8,_y),j("polyline",{"stroke-width":"2",fill:"transparent",stroke:l(i)[1],points:"19, 0 10, 10 19, 20"},null,8,vy)]))],4))}});const by=c2(yy,[["__scopeId","data-v-a4359992"]]),xy=Object.freeze(Object.defineProperty({__proto__:null,default:by},Symbol.toStringTag,{value:"Module"})),Sy={class:"go-border-04"},My=["width","height"],Ay=["stroke","points"],wy=["stroke","points"],Cy=["stroke","points"],Ty=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,reverse:a}=E1(e.chartConfig.option),r=s=>a.value?t.value-s:s;return(s,u)=>(P(),n1("div",Sy,[(P(),n1("svg",{width:l(t),height:l(n)},[j("polyline",{stroke:l(i)[0],"stroke-width":"2",fill:"transparent",points:`${r(0)}, 0 ${r(30)}, ${l(n)/2}`},null,8,Ay),j("polyline",{stroke:l(i)[0],"stroke-width":"2",fill:"transparent",points:`${r(20)}, 0 ${r(50)}, ${l(n)/2} ${r(l(t))}, ${l(n)/2}`},null,8,wy),j("polyline",{stroke:l(i)[1],fill:"transparent","stroke-width":"3",points:`${r(0)}, ${l(n)-3}, ${r(200)}, ${l(n)-3}`},null,8,Cy)],8,My))]))}});const Ey=c2(Ty,[["__scopeId","data-v-8a13a421"]]),Dy=Object.freeze(Object.defineProperty({__proto__:null,default:Ey},Symbol.toStringTag,{value:"Module"})),Iy={class:"go-border-05"},Ry=["width","height"],Oy=["stroke","points"],Py=["stroke","points","stroke-dasharray"],Ly=["values","dur","begin"],zy=["values","begin"],ky=["stroke","points","stroke-dasharray"],Ny=["values","dur","begin"],Uy=["values","begin"],Fy=["stroke","points","stroke-dasharray"],By=["values","dur","begin"],Gy=["values","begin"],Vy=["cy","fill"],jy=["values","begin"],Wy=["cx","cy","fill"],Hy=["values","begin"],Yy=["values","begin"],$y=["cx","cy","fill"],Jy=["values","begin"],Zy=["values","begin"],Xy=["cx","cy","fill"],Qy=["values","begin"],qy=["values","begin"],Ky=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=L4(),{w:n,h:i}=E1(e.chartConfig.attr),{colors:a,dur:r}=E1(e.chartConfig.option),s=`d10ani1${t}`,u=`d10ani2${t}`,c=`d10ani3${t}`,d=`d10ani4${t}`,h=`d10ani5${t}`,p=`d10ani6${t}`,g=`d10ani7${t}`;return(y,m)=>(P(),n1("div",Iy,[(P(),n1("svg",{width:l(n),height:l(i)},[j("polyline",{stroke:l(a)[1],"stroke-width":"2",points:`0, ${l(i)/2} ${l(n)}, ${l(i)/2}`},null,8,Oy),j("polyline",{stroke:l(a)[0],"stroke-width":"2",points:`5, ${l(i)/2} ${l(n)*.2-3}, ${l(i)/2}`,"stroke-dasharray":`0, ${l(n)*.2}`,fill:"freeze"},[j("animate",{id:u,attributeName:"stroke-dasharray",values:`0, ${l(n)*.2};${l(n)*.2}, 0;`,dur:l(r),begin:`${s}.end`,fill:"freeze"},null,8,Ly),j("animate",{attributeName:"stroke-dasharray",values:`${l(n)*.2}, 0;0, ${l(n)*.2}`,dur:"0.01s",begin:`${g}.end`,fill:"freeze"},null,8,zy)],8,Py),j("polyline",{stroke:l(a)[0],"stroke-width":"2",points:`${l(n)*.2+3}, ${l(i)/2} ${l(n)*.8-3}, ${l(i)/2}`,"stroke-dasharray":`0, ${l(n)*.6}`},[j("animate",{id:d,attributeName:"stroke-dasharray",values:`0, ${l(n)*.6};${l(n)*.6}, 0`,dur:l(r),begin:`${c}.end + 1s`,fill:"freeze"},null,8,Ny),j("animate",{attributeName:"stroke-dasharray",values:`${l(n)*.6}, 0;0, ${l(n)*.6}`,dur:"0.01s",begin:`${g}.end`,fill:"freeze"},null,8,Uy)],8,ky),j("polyline",{stroke:l(a)[0],"stroke-width":"2",points:`${l(n)*.8+3}, ${l(i)/2} ${l(n)-5}, ${l(i)/2}`,"stroke-dasharray":`0, ${l(n)*.2}`},[j("animate",{id:p,attributeName:"stroke-dasharray",values:`0, ${l(n)*.2};${l(n)*.2}, 0`,dur:l(r),begin:`${h}.end + 1s`,fill:"freeze"},null,8,By),j("animate",{attributeName:"stroke-dasharray",values:`${l(n)*.2}, 0;0, ${l(n)*.3}`,dur:"0.01s",begin:`${g}.end`,fill:"freeze"},null,8,Gy)],8,Fy),j("circle",{cx:"2",cy:l(i)/2,r:"2",fill:l(a)[1]},[j("animate",{id:s,attributeName:"fill",values:`${l(a)[1]};${l(a)[0]}`,begin:`0s;${g}.end`,dur:"0.3s",fill:"freeze"},null,8,jy)],8,Vy),j("circle",{cx:l(n)*.2,cy:l(i)/2,r:"2",fill:l(a)[1]},[j("animate",{id:c,attributeName:"fill",values:`${l(a)[1]};${l(a)[0]}`,begin:`${u}.end`,dur:"0.3s",fill:"freeze"},null,8,Hy),j("animate",{attributeName:"fill",values:`${l(a)[1]};${l(a)[1]}`,dur:"0.01s",begin:`${g}.end`,fill:"freeze"},null,8,Yy)],8,Wy),j("circle",{cx:l(n)*.8,cy:l(i)/2,r:"2",fill:l(a)[1]},[j("animate",{id:h,attributeName:"fill",values:`${l(a)[1]};${l(a)[0]}`,begin:`${d}.end`,dur:"0.3s",fill:"freeze"},null,8,Jy),j("animate",{attributeName:"fill",values:`${l(a)[1]};${l(a)[1]}`,dur:"0.01s",begin:`${g}.end`,fill:"freeze"},null,8,Zy)],8,$y),j("circle",{cx:l(n)-2,cy:l(i)/2,r:"2",fill:l(a)[1]},[j("animate",{id:g,attributeName:"fill",values:`${l(a)[1]};${l(a)[0]}`,begin:`${p}.end`,dur:"0.3s",fill:"freeze"},null,8,Qy),j("animate",{attributeName:"fill",values:`${l(a)[1]};${l(a)[1]}`,dur:"0.01s",begin:`${g}.end`,fill:"freeze"},null,8,qy)],8,Xy)],8,Ry))]))}});const eb=c2(Ky,[["__scopeId","data-v-33f0e0ac"]]),tb=Object.freeze(Object.defineProperty({__proto__:null,default:eb},Symbol.toStringTag,{value:"Module"})),nb=o=>(d0("data-v-db506cc9"),o=o(),f0(),o),ib={class:"go-border-06"},ob=["width","height"],ab=nb(()=>j("polygon",{class:"stroke fill",points:"15.5 6.5 20.5 0.5 50.5 0.5 55.5 6.5 15.5 6.5"},null,-1)),rb=["points"],sb=["points"],lb=["points"],ub=["points"],cb=["points"],db=["points"],fb={class:"text"},hb=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;u4(u=>({"30f2c0b4":l(i)[0],"30f2c076":l(i)[1],32016584:l(s),f68b5eba:l(r)+"px"})),L4();const{w:t,h:n}=E1(e.chartConfig.attr),{colors:i,dataset:a,textSize:r,textColor:s}=E1(e.chartConfig.option);return(u,c)=>(P(),n1("div",ib,[(P(),n1("svg",{xmlns:"http://www.w3.org/2000/svg",width:l(t),height:l(n)},[ab,j("polygon",{class:"stroke fill",points:`15.5 ${l(n)-6.5} 20.5 ${l(n)-.5} 50.5 ${l(n)-.5} 55.5 ${l(n)-6.5} 15.5 ${l(n)-6.5}`},null,8,rb),j("polygon",{class:"stroke fill",points:`${l(t)-15.5} 6.5 ${l(t)-20.5} 0.5 ${l(t)-50.5} 0.5 ${l(t)-55.5} 6.5 ${l(t)-15.5} 6.5`},null,8,sb),j("polygon",{class:"stroke fill",points:`${l(t)-15.5} ${l(n)-6.5} ${l(t)-20.5} ${l(n)-.5} ${l(t)-50.5} ${l(n)-.5} ${l(t)-55.5} ${l(n)-6.5} ${l(t)-15.5} ${l(n)-6.5}`},null,8,lb),j("polygon",{class:"stroke fill",points:`15.5 6.5 0.5 ${l(n)/2} 15.5 ${l(n)-6.5} ${l(t)-15.5} ${l(n)-6.5} ${l(t)-.5} ${l(n)/2} ${l(t)-15.5} 6.5 15.5 6.5`},null,8,ub),j("polyline",{class:"stroke fill-none",points:`20.5 14.5 8.5 ${l(n)/2} 20.5 ${l(n)-14.5}`},null,8,cb),j("polyline",{class:"stroke fill-none",points:`${l(t)-20.5} 14.5 ${l(t)-8.5} ${l(n)/2} ${l(t)-20.5} ${l(n)-14.5}`},null,8,db)],8,ob)),j("span",fb,N2(l(a)),1)]))}});const pb=c2(hb,[["__scopeId","data-v-db506cc9"]]),mb=Object.freeze(Object.defineProperty({__proto__:null,default:pb},Symbol.toStringTag,{value:"Module"})),gb=o=>(d0("data-v-b4d0ec68"),o=o(),f0(),o),_b={xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 200 200"},vb=Eu('<filter id="innerShadow" x="-20%" y="-20%" width="140%" height="140%" data-v-b4d0ec68><feGaussianBlur in="SourceGraphic" stdDeviation="3" result="blur" data-v-b4d0ec68></feGaussianBlur><feOffset in="blur" dx="2.5" dy="2.5" data-v-b4d0ec68></feOffset></filter><g data-v-b4d0ec68><circle id="shadow" style="fill:rgba(0, 0, 0, 0.1);" cx="100" cy="100" r="87" filter="url(#innerShadow)" data-v-b4d0ec68></circle><circle id="circle" class="clock-border" cx="100" cy="100" r="80" data-v-b4d0ec68></circle></g>',2),yb={x1:"100",y1:"100",x2:"100",y2:"55",style:{"stroke-width":"3px"},class:"clock-line"},bb=["from","to"],xb={x1:"100",y1:"100",x2:"100",y2:"40",style:{"stroke-width":"4px"},class:"clock-line"},Sb=["from","to"],Mb={x1:"100",y1:"100",x2:"100",y2:"30",style:{"stroke-width":"2px"},class:"clock-line"},Ab=["from","to"],wb=gb(()=>j("circle",{id:"center",style:{fill:"#128a86",stroke:"#c1efed","stroke-width":"2px"},cx:"100",cy:"100",r:"3"},null,-1)),Cb=["transform"],Tb=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;u4(d=>({"47fe3763":l(a),46891283:l(t)+"px","7239e62c":l(i),"67e7692f":l(n)}));let{border:t,color:n,bgColor:i,borderColor:a}=E1(e.chartConfig.option);const r=new Date,s=360*r.getHours()/12+r.getMinutes()/2,u=360*r.getMinutes()/60,c=360*r.getSeconds()/60;return(d,h)=>(P(),n1("svg",_b,[vb,j("g",null,[j("line",yb,[j("animateTransform",{attributeName:"transform",attributeType:"XML",type:"rotate",dur:"43200s",repeatCount:"indefinite",from:`${s} 100 100`,to:`${s+360} 100 100`},null,8,bb)]),j("line",xb,[j("animateTransform",{attributeName:"transform",attributeType:"XML",type:"rotate",dur:"3600s",repeatCount:"indefinite",from:`${u} 100 100`,to:`${u+360} 100 100`},null,8,Sb)]),j("line",Mb,[j("animateTransform",{attributeName:"transform",attributeType:"XML",type:"rotate",dur:"60s",repeatCount:"indefinite",from:`${c} 100 100`,to:`${c+360} 100 100`},null,8,Ab)])]),wb,(P(),n1(x1,null,J1(12,p=>j("line",{x1:"100",y1:"30",x2:"100",y2:"40",class:"clock-line",transform:`rotate(${(p+1)*360/12} 100 100)`,key:`line_${p+1}`},null,8,Cb)),64))]))}});const Eb=c2(Tb,[["__scopeId","data-v-b4d0ec68"]]),Db=Object.freeze(Object.defineProperty({__proto__:null,default:Eb},Symbol.toStringTag,{value:"Module"})),Ib=["data-front"],Rb=["data-back"],Ob=c1({__name:"index",props:{flipType:{type:String,default:()=>"down"},count:{type:[Number,String],default:0},duration:{type:Number,default:600},width:{type:Number,default:60},height:{type:Number,default:100},radius:{type:Number,default:10},frontColor:{type:String,default:"#ffffff"},backColor:{type:String,default:"#000000"},borderWidth:{type:Number,default:2}},setup(o){const e=o;u4(s=>({"06b40856":e.frontColor,"39840b7e":e.backColor,ddd97676:`${e.radius}px`,43622609:`${e.width}px`,"4281d24c":`${e.height}px`,"45eb2214":`${e.height*2}px`,"6026284e":`${e.borderWidth*2}px`,"76a98bc6":`${e.duration/1e3}s`}));const t=K1(!1),n=K1(e.count||0),i=K1(e.count||0);let a=0;const r=(s,u)=>E2(this,null,function*(){if(t.value){t.value=!1,clearTimeout(a),yield $9(),yield r(s,u);return}i.value=u,n.value=s,t.value=!0,a=setTimeout(()=>{t.value=!1,n.value=u},e.duration)});return B1(()=>e.count,(s,u)=>{r(u,s)},{immediate:!0}),(s,u)=>(P(),n1("div",{class:z5(["go-flipper",[o.flipType,{go:t.value}]])},[j("div",{class:"digital front","data-front":n.value},null,8,Ib),j("div",{class:"digital back","data-back":i.value},null,8,Rb)],2))}});const u5=c2(Ob,[["__scopeId","data-v-ce6b5020"]]),Pb={key:0},Lb={key:1},zb={key:1},kb={key:2},Nb={key:3},Ub={key:4},Fb={key:5},Bb=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;u4(X=>({a0c42b24:`${l(t)}px`,a26aec42:`${l(n)}px`,"225bc0d6":`${l(h)}px`,bd636264:`${l(p)}px`,"48414a19":l(d)}));const{w:t,h:n}=E1(e.chartConfig.attr),{dataset:i,useEndDate:a,endDate:r,style:s,showDay:u,flipperBgColor:c,flipperTextColor:d,flipperWidth:h,flipperHeight:p,flipperRadius:g,flipperGap:y,flipperType:m,flipperSpeed:v}=E1(e.chartConfig.option),b=K1(),x=K1(!1),w=K1(i.value*1e3),M=K1([]),A=K1([]),S=K1([]),D=K1([]),C=X=>{const F=Math.max(X.toString().length,2);return X.toString().padStart(F,"0").split("")},E=(X,F,R)=>{const U=Math.floor(X/24);M.value=C(U),A.value=C(u.value?X%24:X),S.value=C(F),D.value=C(R)},k=({hours:X,minutes:F,seconds:R})=>{E(X,F,R)},$=()=>{var X,F;try{x.value=!1,w.value=a.value?r.value-new Date().getTime():i.value*1e3,(X=b.value)!=null&&X.reset&&((F=b.value)==null||F.reset()),x.value=!0}catch(R){console.log(R)}};return B1(()=>e.chartConfig.option.dataset,()=>{$()},{immediate:!0}),B1(()=>e.chartConfig.option.endDate,()=>{$()},{immediate:!0}),B1(()=>e.chartConfig.option.useEndDate,()=>{$()},{immediate:!0}),W0(()=>{$()}),(X,F)=>{const R=B("n-countdown"),U=B("n-space");return P(),n1("div",null,[Du(f(R,{ref_key:"countdownRef",ref:b,duration:w.value,render:k,active:x.value},null,8,["duration","active"]),[[Iu,!1]]),f(U,{class:"go-decorates-more-countdown",size:l(y),align:"center",justify:"center"},{default:_(()=>[l(u)?(P(),n1(x1,{key:0},[(P(!0),n1(x1,null,J1(M.value,(H,V)=>(P(),v1(l(u5),{count:H,width:l(h),height:l(p),"front-color":l(d),"back-color":l(c),radius:l(g),"flip-type":l(m),duration:l(v),key:V,class:"go-d-block"},null,8,["count","width","height","front-color","back-color","radius","flip-type","duration"]))),128)),l(s)==="时分秒"?(P(),n1("div",Pb,"天")):(P(),n1("div",Lb,":"))],64)):V2("",!0),(P(!0),n1(x1,null,J1(A.value,(H,V)=>(P(),v1(l(u5),{count:H,width:l(h),height:l(p),"front-color":l(d),"back-color":l(c),radius:l(g),"flip-type":l(m),duration:l(v),key:V,class:"go-d-block"},null,8,["count","width","height","front-color","back-color","radius","flip-type","duration"]))),128)),l(s)==="时分秒"?(P(),n1("div",zb,"时")):(P(),n1("div",kb,":")),(P(!0),n1(x1,null,J1(S.value,(H,V)=>(P(),v1(l(u5),{count:H,width:l(h),height:l(p),"front-color":l(d),"back-color":l(c),radius:l(g),"flip-type":l(m),duration:l(v),key:V,class:"go-d-block"},null,8,["count","width","height","front-color","back-color","radius","flip-type","duration"]))),128)),l(s)==="时分秒"?(P(),n1("div",Nb,"分")):(P(),n1("div",Ub,":")),(P(!0),n1(x1,null,J1(D.value,(H,V)=>(P(),v1(l(u5),{count:H,width:l(h),height:l(p),"front-color":l(d),"back-color":l(c),radius:l(g),"flip-type":l(m),duration:l(v),key:V,class:"go-d-block"},null,8,["count","width","height","front-color","back-color","radius","flip-type","duration"]))),128)),l(s)==="时分秒"?(P(),n1("div",Fb,"秒")):V2("",!0)]),_:1},8,["size"])])}}});const Gb=c2(Bb,[["__scopeId","data-v-c49213a2"]]),Vb=Object.freeze(Object.defineProperty({__proto__:null,default:Gb},Symbol.toStringTag,{value:"Module"})),jb=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;u4(b=>({13724922:`${l(t)}px`,"15190a40":`${l(n)}px`}));const{w:t,h:n}=E1(e.chartConfig.attr),{flipperLength:i,flipperBgColor:a,flipperTextColor:r,flipperWidth:s,flipperHeight:u,flipperRadius:c,flipperGap:d,flipperType:h,flipperSpeed:p,flipperBorderWidth:g}=E1(e.chartConfig.option),y=K1([]),m=b=>b.toString().padStart(i.value,"0").split("").slice(i.value*-1),v=b=>{y.value=m(b)};return B1(()=>e.chartConfig.option,b=>{try{v(b.dataset)}catch(x){console.log(x)}},{immediate:!0,deep:!0}),d2(e.chartConfig,e2,b=>{v(b)}),(b,x)=>{const w=B("n-space");return P(),v1(w,{class:"go-decorates-flipper-number",size:l(d),align:"center",justify:"center"},{default:_(()=>[(P(!0),n1(x1,null,J1(y.value,(M,A)=>(P(),v1(l(u5),{count:M,width:l(s),height:l(u),"front-color":l(r),"back-color":l(a),radius:l(c),"flip-type":l(h),duration:l(p),"border-width":l(g),key:A,class:"go-d-block"},null,8,["count","width","height","front-color","back-color","radius","flip-type","duration","border-width"]))),128))]),_:1},8,["size"])}}});const Wb=c2(jb,[["__scopeId","data-v-756fa012"]]),Hb=Object.freeze(Object.defineProperty({__proto__:null,default:Wb},Symbol.toStringTag,{value:"Module"})),Yb=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=K3({from:0,dataset:0});E1(e.chartConfig.attr);let{dur:n,showSeparator:i,prefixText:a,prefixColor:r,suffixText:s,suffixColor:u,precision:c,numberSize:d,numberColor:h}=E1(e.chartConfig.option);const p=g=>{t.from=t.dataset,t.dataset=g};return B1(()=>e.chartConfig.option.from,()=>{t.from=e.chartConfig.option.from},{immediate:!0}),B1(()=>e.chartConfig.option.dataset,()=>{t.dataset=e.chartConfig.option.dataset},{immediate:!0,deep:!1}),d2(e.chartConfig,e2,p),(g,y)=>{const m=B("n-number-animation"),v=B("n-statistic");return P(),v1(v,{"tabular-nums":"",class:"go-decorates-number"},{prefix:_(()=>[j("span",{style:g2(`color:${l(r)};font-size:${l(d)}px`)},N2(l(a)),5)]),suffix:_(()=>[j("span",{style:g2(`color:${l(u)};font-size:${l(d)}px`)},N2(l(s)),5)]),default:_(()=>[j("span",{style:g2(`color:${l(h)};font-size:${l(d)}px`)},[f(m,{from:t.from,to:t.dataset,duration:l(n)*1e3,"show-separator":l(i),precision:l(c)},null,8,["from","to","duration","show-separator","precision"])],4)]),_:1})}}});const $b=c2(Yb,[["__scopeId","data-v-58b96eba"]]),Jb=Object.freeze(Object.defineProperty({__proto__:null,default:$b},Symbol.toStringTag,{value:"Module"})),Zb={class:"go-decorates-line"},Xb=["width","height"],Qb=["y1","x2","y2","stroke","stroke-width"],qb=["y1","x2","y2","stroke","stroke-width"],Kb=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{o_color:i,i_color:a,line_class:r}=E1(e.chartConfig.option);return(s,u)=>(P(),n1("div",Zb,[(P(),n1("svg",{width:l(t),height:l(n)},[j("line",{x1:0,y1:l(n)/2,x2:l(t),y2:l(n)/2,stroke:l(i),"stroke-width":l(n)},null,8,Qb),j("line",{x1:0,y1:l(n)/2,x2:l(t),y2:l(n)/2,stroke:l(a),"stroke-width":l(n)/2,class:z5(l(r))},null,10,qb)],8,Xb))]))}});const ex=c2(Kb,[["__scopeId","data-v-08b081bc"]]),tx=Object.freeze(Object.defineProperty({__proto__:null,default:ex},Symbol.toStringTag,{value:"Module"})),nx={class:"go-decorates-line"},ix=["width","height"],ox=["x1","x2","y2","stroke","stroke-width"],ax=["x1","x2","y2","stroke","stroke-width"],rx=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{o_color:i,i_color:a,line_class:r}=E1(e.chartConfig.option);return(s,u)=>(P(),n1("div",nx,[(P(),n1("svg",{width:l(t),height:l(n)},[j("line",{x1:l(t)/2,y1:0,x2:l(t)/2,y2:l(n),stroke:l(i),"stroke-width":l(t)},null,8,ox),j("line",{x1:l(t)/2,y1:0,x2:l(t)/2,y2:l(n),stroke:l(a),"stroke-width":l(t)/2,class:z5(l(r))},null,10,ax)],8,ix))]))}});const sx=c2(rx,[["__scopeId","data-v-8d16a9c4"]]),lx=Object.freeze(Object.defineProperty({__proto__:null,default:sx},Symbol.toStringTag,{value:"Module"})),ux=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;let t=K1("2021-2-3"),n=K1("08:00:00"),i=K1("2021-2-3 08:00:00"),a=K1("none"),r=null;const{w:s,h:u}=E1(e.chartConfig.attr);let{timeColor:c,timeSize:d,timeLineHeight:h,timeTextIndent:p,fontWeight:g,showShadow:y,hShadow:m,vShadow:v,blurShadow:b,colorShadow:x}=E1(e.chartConfig.option);return B1(e.chartConfig.option,()=>{try{e.chartConfig.option.showShadow?a.value=`${e.chartConfig.option.hShadow}px ${e.chartConfig.option.vShadow}px ${e.chartConfig.option.blurShadow}px ${e.chartConfig.option.colorShadow}`:a.value="none"}catch(w){console.log(w)}},{immediate:!0}),W0(()=>{r=setInterval(()=>{var w=new Date,M=w.getFullYear(),A=w.getMonth()+1<10?"0"+(w.getMonth()+1):w.getMonth()+1,S=w.getDate()<10?"0"+w.getDate():w.getDate(),D=w.getHours(),C=w.getMinutes(),E=w.getSeconds();let k="";D<10&&(k+="0"),k+=D+":",C<10&&(k+="0"),k+=C+":",E<10&&(k+="0"),k+=E,t.value=`${M}-${A}-${S}`,n.value=k,i.value=t.value+" "+n.value},500)}),C0(()=>{clearInterval(r)}),d2(e.chartConfig,e2),(w,M)=>(P(),n1("div",{class:"go-decorates-number",style:g2(`width:${l(s)}px;height:${l(u)}px;`)},[j("div",{style:g2(`color:${l(c)};font-size:${l(d)}px;line-height:${l(h)}px;
      letter-spacing:${l(p)}px;font-weight:${l(g)};
      text-shadow: ${l(a)}`)},N2(l(i)),5)],4))}});const cx=c2(ux,[["__scopeId","data-v-c7a246c7"]]),dx=Object.freeze(Object.defineProperty({__proto__:null,default:cx},Symbol.toStringTag,{value:"Module"}));/**
 * @license
 * Copyright 2010-2022 Three.js Authors
 * SPDX-License-Identifier: MIT
 */const Qt="145",Q0={LEFT:0,MIDDLE:1,RIGHT:2,ROTATE:0,DOLLY:1,PAN:2},q0={ROTATE:0,PAN:1,DOLLY_PAN:2,DOLLY_ROTATE:3},fx=0,Wi=1,hx=2,qr=1,px=2,c5=3,z9=0,X3=1,m4=2,i0=0,O0=1,Hi=2,Yi=3,$i=4,mx=5,b9=100,gx=101,_x=102,Ji=103,Zi=104,vx=200,yx=201,bx=202,xx=203,Kr=204,es=205,Sx=206,Mx=207,Ax=208,wx=209,Cx=210,Tx=0,Ex=1,Dx=2,me=3,Ix=4,Rx=5,Ox=6,Px=7,ts=0,Lx=1,zx=2,z4=0,kx=1,Nx=2,Ux=3,Fx=4,Bx=5,ns=300,k9=301,N9=302,ge=303,_e=304,n6=306,ve=1e3,r4=1001,ye=1002,x3=1003,Xi=1004,Qi=1005,j3=1006,Gx=1007,i6=1008,F0=1009,Vx=1010,jx=1011,is=1012,Wx=1013,T0=1014,E0=1015,S5=1016,Hx=1017,Yx=1018,R9=1020,$x=1021,Jx=1022,g4=1023,Zx=1024,Xx=1025,P0=1026,U9=1027,Qx=1028,qx=1029,Kx=1030,eS=1031,tS=1033,x6=33776,S6=33777,M6=33778,A6=33779,qi=35840,Ki=35841,eo=35842,to=35843,nS=36196,no=37492,io=37496,oo=37808,ao=37809,ro=37810,so=37811,lo=37812,uo=37813,co=37814,fo=37815,ho=37816,po=37817,mo=37818,go=37819,_o=37820,vo=37821,yo=36492,B0=3e3,k2=3001,iS=3200,oS=3201,aS=0,rS=1,D4="srgb",D0="srgb-linear",w6=7680,sS=519,be=35044,bo="300 es",xe=1035;class H0{addEventListener(e,t){this._listeners===void 0&&(this._listeners={});const n=this._listeners;n[e]===void 0&&(n[e]=[]),n[e].indexOf(t)===-1&&n[e].push(t)}hasEventListener(e,t){if(this._listeners===void 0)return!1;const n=this._listeners;return n[e]!==void 0&&n[e].indexOf(t)!==-1}removeEventListener(e,t){if(this._listeners===void 0)return;const i=this._listeners[e];if(i!==void 0){const a=i.indexOf(t);a!==-1&&i.splice(a,1)}}dispatchEvent(e){if(this._listeners===void 0)return;const n=this._listeners[e.type];if(n!==void 0){e.target=this;const i=n.slice(0);for(let a=0,r=i.length;a<r;a++)i[a].call(this,e);e.target=null}}}const u3=["00","01","02","03","04","05","06","07","08","09","0a","0b","0c","0d","0e","0f","10","11","12","13","14","15","16","17","18","19","1a","1b","1c","1d","1e","1f","20","21","22","23","24","25","26","27","28","29","2a","2b","2c","2d","2e","2f","30","31","32","33","34","35","36","37","38","39","3a","3b","3c","3d","3e","3f","40","41","42","43","44","45","46","47","48","49","4a","4b","4c","4d","4e","4f","50","51","52","53","54","55","56","57","58","59","5a","5b","5c","5d","5e","5f","60","61","62","63","64","65","66","67","68","69","6a","6b","6c","6d","6e","6f","70","71","72","73","74","75","76","77","78","79","7a","7b","7c","7d","7e","7f","80","81","82","83","84","85","86","87","88","89","8a","8b","8c","8d","8e","8f","90","91","92","93","94","95","96","97","98","99","9a","9b","9c","9d","9e","9f","a0","a1","a2","a3","a4","a5","a6","a7","a8","a9","aa","ab","ac","ad","ae","af","b0","b1","b2","b3","b4","b5","b6","b7","b8","b9","ba","bb","bc","bd","be","bf","c0","c1","c2","c3","c4","c5","c6","c7","c8","c9","ca","cb","cc","cd","ce","cf","d0","d1","d2","d3","d4","d5","d6","d7","d8","d9","da","db","dc","dd","de","df","e0","e1","e2","e3","e4","e5","e6","e7","e8","e9","ea","eb","ec","ed","ee","ef","f0","f1","f2","f3","f4","f5","f6","f7","f8","f9","fa","fb","fc","fd","fe","ff"],C6=Math.PI/180,xo=180/Math.PI;function o0(){const o=Math.random()*4294967295|0,e=Math.random()*4294967295|0,t=Math.random()*4294967295|0,n=Math.random()*4294967295|0;return(u3[o&255]+u3[o>>8&255]+u3[o>>16&255]+u3[o>>24&255]+"-"+u3[e&255]+u3[e>>8&255]+"-"+u3[e>>16&15|64]+u3[e>>24&255]+"-"+u3[t&63|128]+u3[t>>8&255]+"-"+u3[t>>16&255]+u3[t>>24&255]+u3[n&255]+u3[n>>8&255]+u3[n>>16&255]+u3[n>>24&255]).toLowerCase()}function d3(o,e,t){return Math.max(e,Math.min(t,o))}function lS(o,e){return(o%e+e)%e}function T6(o,e,t){return(1-t)*o+t*e}function So(o){return(o&o-1)===0&&o!==0}function Se(o){return Math.pow(2,Math.floor(Math.log(o)/Math.LN2))}function K4(o,e){switch(e.constructor){case Float32Array:return o;case Uint16Array:return o/65535;case Uint8Array:return o/255;case Int16Array:return Math.max(o/32767,-1);case Int8Array:return Math.max(o/127,-1);default:throw new Error("Invalid component type.")}}function C2(o,e){switch(e.constructor){case Float32Array:return o;case Uint16Array:return Math.round(o*65535);case Uint8Array:return Math.round(o*255);case Int16Array:return Math.round(o*32767);case Int8Array:return Math.round(o*127);default:throw new Error("Invalid component type.")}}class G1{constructor(e=0,t=0){G1.prototype.isVector2=!0,this.x=e,this.y=t}get width(){return this.x}set width(e){this.x=e}get height(){return this.y}set height(e){this.y=e}set(e,t){return this.x=e,this.y=t,this}setScalar(e){return this.x=e,this.y=e,this}setX(e){return this.x=e,this}setY(e){return this.y=e,this}setComponent(e,t){switch(e){case 0:this.x=t;break;case 1:this.y=t;break;default:throw new Error("index is out of range: "+e)}return this}getComponent(e){switch(e){case 0:return this.x;case 1:return this.y;default:throw new Error("index is out of range: "+e)}}clone(){return new this.constructor(this.x,this.y)}copy(e){return this.x=e.x,this.y=e.y,this}add(e){return this.x+=e.x,this.y+=e.y,this}addScalar(e){return this.x+=e,this.y+=e,this}addVectors(e,t){return this.x=e.x+t.x,this.y=e.y+t.y,this}addScaledVector(e,t){return this.x+=e.x*t,this.y+=e.y*t,this}sub(e){return this.x-=e.x,this.y-=e.y,this}subScalar(e){return this.x-=e,this.y-=e,this}subVectors(e,t){return this.x=e.x-t.x,this.y=e.y-t.y,this}multiply(e){return this.x*=e.x,this.y*=e.y,this}multiplyScalar(e){return this.x*=e,this.y*=e,this}divide(e){return this.x/=e.x,this.y/=e.y,this}divideScalar(e){return this.multiplyScalar(1/e)}applyMatrix3(e){const t=this.x,n=this.y,i=e.elements;return this.x=i[0]*t+i[3]*n+i[6],this.y=i[1]*t+i[4]*n+i[7],this}min(e){return this.x=Math.min(this.x,e.x),this.y=Math.min(this.y,e.y),this}max(e){return this.x=Math.max(this.x,e.x),this.y=Math.max(this.y,e.y),this}clamp(e,t){return this.x=Math.max(e.x,Math.min(t.x,this.x)),this.y=Math.max(e.y,Math.min(t.y,this.y)),this}clampScalar(e,t){return this.x=Math.max(e,Math.min(t,this.x)),this.y=Math.max(e,Math.min(t,this.y)),this}clampLength(e,t){const n=this.length();return this.divideScalar(n||1).multiplyScalar(Math.max(e,Math.min(t,n)))}floor(){return this.x=Math.floor(this.x),this.y=Math.floor(this.y),this}ceil(){return this.x=Math.ceil(this.x),this.y=Math.ceil(this.y),this}round(){return this.x=Math.round(this.x),this.y=Math.round(this.y),this}roundToZero(){return this.x=this.x<0?Math.ceil(this.x):Math.floor(this.x),this.y=this.y<0?Math.ceil(this.y):Math.floor(this.y),this}negate(){return this.x=-this.x,this.y=-this.y,this}dot(e){return this.x*e.x+this.y*e.y}cross(e){return this.x*e.y-this.y*e.x}lengthSq(){return this.x*this.x+this.y*this.y}length(){return Math.sqrt(this.x*this.x+this.y*this.y)}manhattanLength(){return Math.abs(this.x)+Math.abs(this.y)}normalize(){return this.divideScalar(this.length()||1)}angle(){return Math.atan2(-this.y,-this.x)+Math.PI}distanceTo(e){return Math.sqrt(this.distanceToSquared(e))}distanceToSquared(e){const t=this.x-e.x,n=this.y-e.y;return t*t+n*n}manhattanDistanceTo(e){return Math.abs(this.x-e.x)+Math.abs(this.y-e.y)}setLength(e){return this.normalize().multiplyScalar(e)}lerp(e,t){return this.x+=(e.x-this.x)*t,this.y+=(e.y-this.y)*t,this}lerpVectors(e,t,n){return this.x=e.x+(t.x-e.x)*n,this.y=e.y+(t.y-e.y)*n,this}equals(e){return e.x===this.x&&e.y===this.y}fromArray(e,t=0){return this.x=e[t],this.y=e[t+1],this}toArray(e=[],t=0){return e[t]=this.x,e[t+1]=this.y,e}fromBufferAttribute(e,t){return this.x=e.getX(t),this.y=e.getY(t),this}rotateAround(e,t){const n=Math.cos(t),i=Math.sin(t),a=this.x-e.x,r=this.y-e.y;return this.x=a*n-r*i+e.x,this.y=a*i+r*n+e.y,this}random(){return this.x=Math.random(),this.y=Math.random(),this}*[Symbol.iterator](){yield this.x,yield this.y}}class H3{constructor(){H3.prototype.isMatrix3=!0,this.elements=[1,0,0,0,1,0,0,0,1]}set(e,t,n,i,a,r,s,u,c){const d=this.elements;return d[0]=e,d[1]=i,d[2]=s,d[3]=t,d[4]=a,d[5]=u,d[6]=n,d[7]=r,d[8]=c,this}identity(){return this.set(1,0,0,0,1,0,0,0,1),this}copy(e){const t=this.elements,n=e.elements;return t[0]=n[0],t[1]=n[1],t[2]=n[2],t[3]=n[3],t[4]=n[4],t[5]=n[5],t[6]=n[6],t[7]=n[7],t[8]=n[8],this}extractBasis(e,t,n){return e.setFromMatrix3Column(this,0),t.setFromMatrix3Column(this,1),n.setFromMatrix3Column(this,2),this}setFromMatrix4(e){const t=e.elements;return this.set(t[0],t[4],t[8],t[1],t[5],t[9],t[2],t[6],t[10]),this}multiply(e){return this.multiplyMatrices(this,e)}premultiply(e){return this.multiplyMatrices(e,this)}multiplyMatrices(e,t){const n=e.elements,i=t.elements,a=this.elements,r=n[0],s=n[3],u=n[6],c=n[1],d=n[4],h=n[7],p=n[2],g=n[5],y=n[8],m=i[0],v=i[3],b=i[6],x=i[1],w=i[4],M=i[7],A=i[2],S=i[5],D=i[8];return a[0]=r*m+s*x+u*A,a[3]=r*v+s*w+u*S,a[6]=r*b+s*M+u*D,a[1]=c*m+d*x+h*A,a[4]=c*v+d*w+h*S,a[7]=c*b+d*M+h*D,a[2]=p*m+g*x+y*A,a[5]=p*v+g*w+y*S,a[8]=p*b+g*M+y*D,this}multiplyScalar(e){const t=this.elements;return t[0]*=e,t[3]*=e,t[6]*=e,t[1]*=e,t[4]*=e,t[7]*=e,t[2]*=e,t[5]*=e,t[8]*=e,this}determinant(){const e=this.elements,t=e[0],n=e[1],i=e[2],a=e[3],r=e[4],s=e[5],u=e[6],c=e[7],d=e[8];return t*r*d-t*s*c-n*a*d+n*s*u+i*a*c-i*r*u}invert(){const e=this.elements,t=e[0],n=e[1],i=e[2],a=e[3],r=e[4],s=e[5],u=e[6],c=e[7],d=e[8],h=d*r-s*c,p=s*u-d*a,g=c*a-r*u,y=t*h+n*p+i*g;if(y===0)return this.set(0,0,0,0,0,0,0,0,0);const m=1/y;return e[0]=h*m,e[1]=(i*c-d*n)*m,e[2]=(s*n-i*r)*m,e[3]=p*m,e[4]=(d*t-i*u)*m,e[5]=(i*a-s*t)*m,e[6]=g*m,e[7]=(n*u-c*t)*m,e[8]=(r*t-n*a)*m,this}transpose(){let e;const t=this.elements;return e=t[1],t[1]=t[3],t[3]=e,e=t[2],t[2]=t[6],t[6]=e,e=t[5],t[5]=t[7],t[7]=e,this}getNormalMatrix(e){return this.setFromMatrix4(e).invert().transpose()}transposeIntoArray(e){const t=this.elements;return e[0]=t[0],e[1]=t[3],e[2]=t[6],e[3]=t[1],e[4]=t[4],e[5]=t[7],e[6]=t[2],e[7]=t[5],e[8]=t[8],this}setUvTransform(e,t,n,i,a,r,s){const u=Math.cos(a),c=Math.sin(a);return this.set(n*u,n*c,-n*(u*r+c*s)+r+e,-i*c,i*u,-i*(-c*r+u*s)+s+t,0,0,1),this}scale(e,t){const n=this.elements;return n[0]*=e,n[3]*=e,n[6]*=e,n[1]*=t,n[4]*=t,n[7]*=t,this}rotate(e){const t=Math.cos(e),n=Math.sin(e),i=this.elements,a=i[0],r=i[3],s=i[6],u=i[1],c=i[4],d=i[7];return i[0]=t*a+n*u,i[3]=t*r+n*c,i[6]=t*s+n*d,i[1]=-n*a+t*u,i[4]=-n*r+t*c,i[7]=-n*s+t*d,this}translate(e,t){const n=this.elements;return n[0]+=e*n[2],n[3]+=e*n[5],n[6]+=e*n[8],n[1]+=t*n[2],n[4]+=t*n[5],n[7]+=t*n[8],this}equals(e){const t=this.elements,n=e.elements;for(let i=0;i<9;i++)if(t[i]!==n[i])return!1;return!0}fromArray(e,t=0){for(let n=0;n<9;n++)this.elements[n]=e[n+t];return this}toArray(e=[],t=0){const n=this.elements;return e[t]=n[0],e[t+1]=n[1],e[t+2]=n[2],e[t+3]=n[3],e[t+4]=n[4],e[t+5]=n[5],e[t+6]=n[6],e[t+7]=n[7],e[t+8]=n[8],e}clone(){return new this.constructor().fromArray(this.elements)}}function os(o){for(let e=o.length-1;e>=0;--e)if(o[e]>=65535)return!0;return!1}function M5(o){return document.createElementNS("http://www.w3.org/1999/xhtml",o)}function L0(o){return o<.04045?o*.0773993808:Math.pow(o*.9478672986+.0521327014,2.4)}function E8(o){return o<.0031308?o*12.92:1.055*Math.pow(o,.41666)-.055}const E6={[D4]:{[D0]:L0},[D0]:{[D4]:E8}},n4={legacyMode:!0,get workingColorSpace(){return D0},set workingColorSpace(o){console.warn("THREE.ColorManagement: .workingColorSpace is readonly.")},convert:function(o,e,t){if(this.legacyMode||e===t||!e||!t)return o;if(E6[e]&&E6[e][t]!==void 0){const n=E6[e][t];return o.r=n(o.r),o.g=n(o.g),o.b=n(o.b),o}throw new Error("Unsupported color space conversion.")},fromWorkingColorSpace:function(o,e){return this.convert(o,this.workingColorSpace,e)},toWorkingColorSpace:function(o,e){return this.convert(o,e,this.workingColorSpace)}},as={aliceblue:15792383,antiquewhite:16444375,aqua:65535,aquamarine:8388564,azure:15794175,beige:16119260,bisque:16770244,black:0,blanchedalmond:16772045,blue:255,blueviolet:9055202,brown:10824234,burlywood:14596231,cadetblue:6266528,chartreuse:8388352,chocolate:13789470,coral:16744272,cornflowerblue:6591981,cornsilk:16775388,crimson:14423100,cyan:65535,darkblue:139,darkcyan:35723,darkgoldenrod:12092939,darkgray:11119017,darkgreen:25600,darkgrey:11119017,darkkhaki:12433259,darkmagenta:9109643,darkolivegreen:5597999,darkorange:16747520,darkorchid:10040012,darkred:9109504,darksalmon:15308410,darkseagreen:9419919,darkslateblue:4734347,darkslategray:3100495,darkslategrey:3100495,darkturquoise:52945,darkviolet:9699539,deeppink:16716947,deepskyblue:49151,dimgray:6908265,dimgrey:6908265,dodgerblue:2003199,firebrick:11674146,floralwhite:16775920,forestgreen:2263842,fuchsia:16711935,gainsboro:14474460,ghostwhite:16316671,gold:16766720,goldenrod:14329120,gray:8421504,green:32768,greenyellow:11403055,grey:8421504,honeydew:15794160,hotpink:16738740,indianred:13458524,indigo:4915330,ivory:16777200,khaki:15787660,lavender:15132410,lavenderblush:16773365,lawngreen:8190976,lemonchiffon:16775885,lightblue:11393254,lightcoral:15761536,lightcyan:14745599,lightgoldenrodyellow:16448210,lightgray:13882323,lightgreen:9498256,lightgrey:13882323,lightpink:16758465,lightsalmon:16752762,lightseagreen:2142890,lightskyblue:8900346,lightslategray:7833753,lightslategrey:7833753,lightsteelblue:11584734,lightyellow:16777184,lime:65280,limegreen:3329330,linen:16445670,magenta:16711935,maroon:8388608,mediumaquamarine:6737322,mediumblue:205,mediumorchid:12211667,mediumpurple:9662683,mediumseagreen:3978097,mediumslateblue:8087790,mediumspringgreen:64154,mediumturquoise:4772300,mediumvioletred:13047173,midnightblue:1644912,mintcream:16121850,mistyrose:16770273,moccasin:16770229,navajowhite:16768685,navy:128,oldlace:16643558,olive:8421376,olivedrab:7048739,orange:16753920,orangered:16729344,orchid:14315734,palegoldenrod:15657130,palegreen:10025880,paleturquoise:11529966,palevioletred:14381203,papayawhip:16773077,peachpuff:16767673,peru:13468991,pink:16761035,plum:14524637,powderblue:11591910,purple:8388736,rebeccapurple:6697881,red:16711680,rosybrown:12357519,royalblue:4286945,saddlebrown:9127187,salmon:16416882,sandybrown:16032864,seagreen:3050327,seashell:16774638,sienna:10506797,silver:12632256,skyblue:8900331,slateblue:6970061,slategray:7372944,slategrey:7372944,snow:16775930,springgreen:65407,steelblue:4620980,tan:13808780,teal:32896,thistle:14204888,tomato:16737095,turquoise:4251856,violet:15631086,wheat:16113331,white:16777215,whitesmoke:16119285,yellow:16776960,yellowgreen:10145074},X2={r:0,g:0,b:0},i4={h:0,s:0,l:0},Q5={h:0,s:0,l:0};function D6(o,e,t){return t<0&&(t+=1),t>1&&(t-=1),t<1/6?o+(e-o)*6*t:t<1/2?e:t<2/3?o+(e-o)*6*(2/3-t):o}function q5(o,e){return e.r=o.r,e.g=o.g,e.b=o.b,e}class _2{constructor(e,t,n){return this.isColor=!0,this.r=1,this.g=1,this.b=1,t===void 0&&n===void 0?this.set(e):this.setRGB(e,t,n)}set(e){return e&&e.isColor?this.copy(e):typeof e=="number"?this.setHex(e):typeof e=="string"&&this.setStyle(e),this}setScalar(e){return this.r=e,this.g=e,this.b=e,this}setHex(e,t=D4){return e=Math.floor(e),this.r=(e>>16&255)/255,this.g=(e>>8&255)/255,this.b=(e&255)/255,n4.toWorkingColorSpace(this,t),this}setRGB(e,t,n,i=D0){return this.r=e,this.g=t,this.b=n,n4.toWorkingColorSpace(this,i),this}setHSL(e,t,n,i=D0){if(e=lS(e,1),t=d3(t,0,1),n=d3(n,0,1),t===0)this.r=this.g=this.b=n;else{const a=n<=.5?n*(1+t):n+t-n*t,r=2*n-a;this.r=D6(r,a,e+1/3),this.g=D6(r,a,e),this.b=D6(r,a,e-1/3)}return n4.toWorkingColorSpace(this,i),this}setStyle(e,t=D4){function n(a){a!==void 0&&parseFloat(a)<1&&console.warn("THREE.Color: Alpha component of "+e+" will be ignored.")}let i;if(i=/^((?:rgb|hsl)a?)\(([^\)]*)\)/.exec(e)){let a;const r=i[1],s=i[2];switch(r){case"rgb":case"rgba":if(a=/^\s*(\d+)\s*,\s*(\d+)\s*,\s*(\d+)\s*(?:,\s*(\d*\.?\d+)\s*)?$/.exec(s))return this.r=Math.min(255,parseInt(a[1],10))/255,this.g=Math.min(255,parseInt(a[2],10))/255,this.b=Math.min(255,parseInt(a[3],10))/255,n4.toWorkingColorSpace(this,t),n(a[4]),this;if(a=/^\s*(\d+)\%\s*,\s*(\d+)\%\s*,\s*(\d+)\%\s*(?:,\s*(\d*\.?\d+)\s*)?$/.exec(s))return this.r=Math.min(100,parseInt(a[1],10))/100,this.g=Math.min(100,parseInt(a[2],10))/100,this.b=Math.min(100,parseInt(a[3],10))/100,n4.toWorkingColorSpace(this,t),n(a[4]),this;break;case"hsl":case"hsla":if(a=/^\s*(\d*\.?\d+)\s*,\s*(\d*\.?\d+)\%\s*,\s*(\d*\.?\d+)\%\s*(?:,\s*(\d*\.?\d+)\s*)?$/.exec(s)){const u=parseFloat(a[1])/360,c=parseFloat(a[2])/100,d=parseFloat(a[3])/100;return n(a[4]),this.setHSL(u,c,d,t)}break}}else if(i=/^\#([A-Fa-f\d]+)$/.exec(e)){const a=i[1],r=a.length;if(r===3)return this.r=parseInt(a.charAt(0)+a.charAt(0),16)/255,this.g=parseInt(a.charAt(1)+a.charAt(1),16)/255,this.b=parseInt(a.charAt(2)+a.charAt(2),16)/255,n4.toWorkingColorSpace(this,t),this;if(r===6)return this.r=parseInt(a.charAt(0)+a.charAt(1),16)/255,this.g=parseInt(a.charAt(2)+a.charAt(3),16)/255,this.b=parseInt(a.charAt(4)+a.charAt(5),16)/255,n4.toWorkingColorSpace(this,t),this}return e&&e.length>0?this.setColorName(e,t):this}setColorName(e,t=D4){const n=as[e.toLowerCase()];return n!==void 0?this.setHex(n,t):console.warn("THREE.Color: Unknown color "+e),this}clone(){return new this.constructor(this.r,this.g,this.b)}copy(e){return this.r=e.r,this.g=e.g,this.b=e.b,this}copySRGBToLinear(e){return this.r=L0(e.r),this.g=L0(e.g),this.b=L0(e.b),this}copyLinearToSRGB(e){return this.r=E8(e.r),this.g=E8(e.g),this.b=E8(e.b),this}convertSRGBToLinear(){return this.copySRGBToLinear(this),this}convertLinearToSRGB(){return this.copyLinearToSRGB(this),this}getHex(e=D4){return n4.fromWorkingColorSpace(q5(this,X2),e),d3(X2.r*255,0,255)<<16^d3(X2.g*255,0,255)<<8^d3(X2.b*255,0,255)<<0}getHexString(e=D4){return("000000"+this.getHex(e).toString(16)).slice(-6)}getHSL(e,t=D0){n4.fromWorkingColorSpace(q5(this,X2),t);const n=X2.r,i=X2.g,a=X2.b,r=Math.max(n,i,a),s=Math.min(n,i,a);let u,c;const d=(s+r)/2;if(s===r)u=0,c=0;else{const h=r-s;switch(c=d<=.5?h/(r+s):h/(2-r-s),r){case n:u=(i-a)/h+(i<a?6:0);break;case i:u=(a-n)/h+2;break;case a:u=(n-i)/h+4;break}u/=6}return e.h=u,e.s=c,e.l=d,e}getRGB(e,t=D0){return n4.fromWorkingColorSpace(q5(this,X2),t),e.r=X2.r,e.g=X2.g,e.b=X2.b,e}getStyle(e=D4){return n4.fromWorkingColorSpace(q5(this,X2),e),e!==D4?`color(${e} ${X2.r} ${X2.g} ${X2.b})`:`rgb(${X2.r*255|0},${X2.g*255|0},${X2.b*255|0})`}offsetHSL(e,t,n){return this.getHSL(i4),i4.h+=e,i4.s+=t,i4.l+=n,this.setHSL(i4.h,i4.s,i4.l),this}add(e){return this.r+=e.r,this.g+=e.g,this.b+=e.b,this}addColors(e,t){return this.r=e.r+t.r,this.g=e.g+t.g,this.b=e.b+t.b,this}addScalar(e){return this.r+=e,this.g+=e,this.b+=e,this}sub(e){return this.r=Math.max(0,this.r-e.r),this.g=Math.max(0,this.g-e.g),this.b=Math.max(0,this.b-e.b),this}multiply(e){return this.r*=e.r,this.g*=e.g,this.b*=e.b,this}multiplyScalar(e){return this.r*=e,this.g*=e,this.b*=e,this}lerp(e,t){return this.r+=(e.r-this.r)*t,this.g+=(e.g-this.g)*t,this.b+=(e.b-this.b)*t,this}lerpColors(e,t,n){return this.r=e.r+(t.r-e.r)*n,this.g=e.g+(t.g-e.g)*n,this.b=e.b+(t.b-e.b)*n,this}lerpHSL(e,t){this.getHSL(i4),e.getHSL(Q5);const n=T6(i4.h,Q5.h,t),i=T6(i4.s,Q5.s,t),a=T6(i4.l,Q5.l,t);return this.setHSL(n,i,a),this}equals(e){return e.r===this.r&&e.g===this.g&&e.b===this.b}fromArray(e,t=0){return this.r=e[t],this.g=e[t+1],this.b=e[t+2],this}toArray(e=[],t=0){return e[t]=this.r,e[t+1]=this.g,e[t+2]=this.b,e}fromBufferAttribute(e,t){return this.r=e.getX(t),this.g=e.getY(t),this.b=e.getZ(t),this}toJSON(){return this.getHex()}*[Symbol.iterator](){yield this.r,yield this.g,yield this.b}}_2.NAMES=as;let K0;class rs{static getDataURL(e){if(/^data:/i.test(e.src)||typeof HTMLCanvasElement=="undefined")return e.src;let t;if(e instanceof HTMLCanvasElement)t=e;else{K0===void 0&&(K0=M5("canvas")),K0.width=e.width,K0.height=e.height;const n=K0.getContext("2d");e instanceof ImageData?n.putImageData(e,0,0):n.drawImage(e,0,0,e.width,e.height),t=K0}return t.width>2048||t.height>2048?(console.warn("THREE.ImageUtils.getDataURL: Image converted to jpg for performance reasons",e),t.toDataURL("image/jpeg",.6)):t.toDataURL("image/png")}static sRGBToLinear(e){if(typeof HTMLImageElement!="undefined"&&e instanceof HTMLImageElement||typeof HTMLCanvasElement!="undefined"&&e instanceof HTMLCanvasElement||typeof ImageBitmap!="undefined"&&e instanceof ImageBitmap){const t=M5("canvas");t.width=e.width,t.height=e.height;const n=t.getContext("2d");n.drawImage(e,0,0,e.width,e.height);const i=n.getImageData(0,0,e.width,e.height),a=i.data;for(let r=0;r<a.length;r++)a[r]=L0(a[r]/255)*255;return n.putImageData(i,0,0),t}else if(e.data){const t=e.data.slice(0);for(let n=0;n<t.length;n++)t instanceof Uint8Array||t instanceof Uint8ClampedArray?t[n]=Math.floor(L0(t[n]/255)*255):t[n]=L0(t[n]);return{data:t,width:e.width,height:e.height}}else return console.warn("THREE.ImageUtils.sRGBToLinear(): Unsupported image type. No color space conversion applied."),e}}class ss{constructor(e=null){this.isSource=!0,this.uuid=o0(),this.data=e,this.version=0}set needsUpdate(e){e===!0&&this.version++}toJSON(e){const t=e===void 0||typeof e=="string";if(!t&&e.images[this.uuid]!==void 0)return e.images[this.uuid];const n={uuid:this.uuid,url:""},i=this.data;if(i!==null){let a;if(Array.isArray(i)){a=[];for(let r=0,s=i.length;r<s;r++)i[r].isDataTexture?a.push(I6(i[r].image)):a.push(I6(i[r]))}else a=I6(i);n.url=a}return t||(e.images[this.uuid]=n),n}}function I6(o){return typeof HTMLImageElement!="undefined"&&o instanceof HTMLImageElement||typeof HTMLCanvasElement!="undefined"&&o instanceof HTMLCanvasElement||typeof ImageBitmap!="undefined"&&o instanceof ImageBitmap?rs.getDataURL(o):o.data?{data:Array.from(o.data),width:o.width,height:o.height,type:o.data.constructor.name}:(console.warn("THREE.Texture: Unable to serialize Texture."),{})}let uS=0;class Q3 extends H0{constructor(e=Q3.DEFAULT_IMAGE,t=Q3.DEFAULT_MAPPING,n=r4,i=r4,a=j3,r=i6,s=g4,u=F0,c=1,d=B0){super(),this.isTexture=!0,Object.defineProperty(this,"id",{value:uS++}),this.uuid=o0(),this.name="",this.source=new ss(e),this.mipmaps=[],this.mapping=t,this.wrapS=n,this.wrapT=i,this.magFilter=a,this.minFilter=r,this.anisotropy=c,this.format=s,this.internalFormat=null,this.type=u,this.offset=new G1(0,0),this.repeat=new G1(1,1),this.center=new G1(0,0),this.rotation=0,this.matrixAutoUpdate=!0,this.matrix=new H3,this.generateMipmaps=!0,this.premultiplyAlpha=!1,this.flipY=!0,this.unpackAlignment=4,this.encoding=d,this.userData={},this.version=0,this.onUpdate=null,this.isRenderTargetTexture=!1,this.needsPMREMUpdate=!1}get image(){return this.source.data}set image(e){this.source.data=e}updateMatrix(){this.matrix.setUvTransform(this.offset.x,this.offset.y,this.repeat.x,this.repeat.y,this.rotation,this.center.x,this.center.y)}clone(){return new this.constructor().copy(this)}copy(e){return this.name=e.name,this.source=e.source,this.mipmaps=e.mipmaps.slice(0),this.mapping=e.mapping,this.wrapS=e.wrapS,this.wrapT=e.wrapT,this.magFilter=e.magFilter,this.minFilter=e.minFilter,this.anisotropy=e.anisotropy,this.format=e.format,this.internalFormat=e.internalFormat,this.type=e.type,this.offset.copy(e.offset),this.repeat.copy(e.repeat),this.center.copy(e.center),this.rotation=e.rotation,this.matrixAutoUpdate=e.matrixAutoUpdate,this.matrix.copy(e.matrix),this.generateMipmaps=e.generateMipmaps,this.premultiplyAlpha=e.premultiplyAlpha,this.flipY=e.flipY,this.unpackAlignment=e.unpackAlignment,this.encoding=e.encoding,this.userData=JSON.parse(JSON.stringify(e.userData)),this.needsUpdate=!0,this}toJSON(e){const t=e===void 0||typeof e=="string";if(!t&&e.textures[this.uuid]!==void 0)return e.textures[this.uuid];const n={metadata:{version:4.5,type:"Texture",generator:"Texture.toJSON"},uuid:this.uuid,name:this.name,image:this.source.toJSON(e).uuid,mapping:this.mapping,repeat:[this.repeat.x,this.repeat.y],offset:[this.offset.x,this.offset.y],center:[this.center.x,this.center.y],rotation:this.rotation,wrap:[this.wrapS,this.wrapT],format:this.format,type:this.type,encoding:this.encoding,minFilter:this.minFilter,magFilter:this.magFilter,anisotropy:this.anisotropy,flipY:this.flipY,premultiplyAlpha:this.premultiplyAlpha,unpackAlignment:this.unpackAlignment};return JSON.stringify(this.userData)!=="{}"&&(n.userData=this.userData),t||(e.textures[this.uuid]=n),n}dispose(){this.dispatchEvent({type:"dispose"})}transformUv(e){if(this.mapping!==ns)return e;if(e.applyMatrix3(this.matrix),e.x<0||e.x>1)switch(this.wrapS){case ve:e.x=e.x-Math.floor(e.x);break;case r4:e.x=e.x<0?0:1;break;case ye:Math.abs(Math.floor(e.x)%2)===1?e.x=Math.ceil(e.x)-e.x:e.x=e.x-Math.floor(e.x);break}if(e.y<0||e.y>1)switch(this.wrapT){case ve:e.y=e.y-Math.floor(e.y);break;case r4:e.y=e.y<0?0:1;break;case ye:Math.abs(Math.floor(e.y)%2)===1?e.y=Math.ceil(e.y)-e.y:e.y=e.y-Math.floor(e.y);break}return this.flipY&&(e.y=1-e.y),e}set needsUpdate(e){e===!0&&(this.version++,this.source.needsUpdate=!0)}}Q3.DEFAULT_IMAGE=null;Q3.DEFAULT_MAPPING=ns;class l3{constructor(e=0,t=0,n=0,i=1){l3.prototype.isVector4=!0,this.x=e,this.y=t,this.z=n,this.w=i}get width(){return this.z}set width(e){this.z=e}get height(){return this.w}set height(e){this.w=e}set(e,t,n,i){return this.x=e,this.y=t,this.z=n,this.w=i,this}setScalar(e){return this.x=e,this.y=e,this.z=e,this.w=e,this}setX(e){return this.x=e,this}setY(e){return this.y=e,this}setZ(e){return this.z=e,this}setW(e){return this.w=e,this}setComponent(e,t){switch(e){case 0:this.x=t;break;case 1:this.y=t;break;case 2:this.z=t;break;case 3:this.w=t;break;default:throw new Error("index is out of range: "+e)}return this}getComponent(e){switch(e){case 0:return this.x;case 1:return this.y;case 2:return this.z;case 3:return this.w;default:throw new Error("index is out of range: "+e)}}clone(){return new this.constructor(this.x,this.y,this.z,this.w)}copy(e){return this.x=e.x,this.y=e.y,this.z=e.z,this.w=e.w!==void 0?e.w:1,this}add(e){return this.x+=e.x,this.y+=e.y,this.z+=e.z,this.w+=e.w,this}addScalar(e){return this.x+=e,this.y+=e,this.z+=e,this.w+=e,this}addVectors(e,t){return this.x=e.x+t.x,this.y=e.y+t.y,this.z=e.z+t.z,this.w=e.w+t.w,this}addScaledVector(e,t){return this.x+=e.x*t,this.y+=e.y*t,this.z+=e.z*t,this.w+=e.w*t,this}sub(e){return this.x-=e.x,this.y-=e.y,this.z-=e.z,this.w-=e.w,this}subScalar(e){return this.x-=e,this.y-=e,this.z-=e,this.w-=e,this}subVectors(e,t){return this.x=e.x-t.x,this.y=e.y-t.y,this.z=e.z-t.z,this.w=e.w-t.w,this}multiply(e){return this.x*=e.x,this.y*=e.y,this.z*=e.z,this.w*=e.w,this}multiplyScalar(e){return this.x*=e,this.y*=e,this.z*=e,this.w*=e,this}applyMatrix4(e){const t=this.x,n=this.y,i=this.z,a=this.w,r=e.elements;return this.x=r[0]*t+r[4]*n+r[8]*i+r[12]*a,this.y=r[1]*t+r[5]*n+r[9]*i+r[13]*a,this.z=r[2]*t+r[6]*n+r[10]*i+r[14]*a,this.w=r[3]*t+r[7]*n+r[11]*i+r[15]*a,this}divideScalar(e){return this.multiplyScalar(1/e)}setAxisAngleFromQuaternion(e){this.w=2*Math.acos(e.w);const t=Math.sqrt(1-e.w*e.w);return t<1e-4?(this.x=1,this.y=0,this.z=0):(this.x=e.x/t,this.y=e.y/t,this.z=e.z/t),this}setAxisAngleFromRotationMatrix(e){let t,n,i,a;const u=e.elements,c=u[0],d=u[4],h=u[8],p=u[1],g=u[5],y=u[9],m=u[2],v=u[6],b=u[10];if(Math.abs(d-p)<.01&&Math.abs(h-m)<.01&&Math.abs(y-v)<.01){if(Math.abs(d+p)<.1&&Math.abs(h+m)<.1&&Math.abs(y+v)<.1&&Math.abs(c+g+b-3)<.1)return this.set(1,0,0,0),this;t=Math.PI;const w=(c+1)/2,M=(g+1)/2,A=(b+1)/2,S=(d+p)/4,D=(h+m)/4,C=(y+v)/4;return w>M&&w>A?w<.01?(n=0,i=.707106781,a=.707106781):(n=Math.sqrt(w),i=S/n,a=D/n):M>A?M<.01?(n=.707106781,i=0,a=.707106781):(i=Math.sqrt(M),n=S/i,a=C/i):A<.01?(n=.707106781,i=.707106781,a=0):(a=Math.sqrt(A),n=D/a,i=C/a),this.set(n,i,a,t),this}let x=Math.sqrt((v-y)*(v-y)+(h-m)*(h-m)+(p-d)*(p-d));return Math.abs(x)<.001&&(x=1),this.x=(v-y)/x,this.y=(h-m)/x,this.z=(p-d)/x,this.w=Math.acos((c+g+b-1)/2),this}min(e){return this.x=Math.min(this.x,e.x),this.y=Math.min(this.y,e.y),this.z=Math.min(this.z,e.z),this.w=Math.min(this.w,e.w),this}max(e){return this.x=Math.max(this.x,e.x),this.y=Math.max(this.y,e.y),this.z=Math.max(this.z,e.z),this.w=Math.max(this.w,e.w),this}clamp(e,t){return this.x=Math.max(e.x,Math.min(t.x,this.x)),this.y=Math.max(e.y,Math.min(t.y,this.y)),this.z=Math.max(e.z,Math.min(t.z,this.z)),this.w=Math.max(e.w,Math.min(t.w,this.w)),this}clampScalar(e,t){return this.x=Math.max(e,Math.min(t,this.x)),this.y=Math.max(e,Math.min(t,this.y)),this.z=Math.max(e,Math.min(t,this.z)),this.w=Math.max(e,Math.min(t,this.w)),this}clampLength(e,t){const n=this.length();return this.divideScalar(n||1).multiplyScalar(Math.max(e,Math.min(t,n)))}floor(){return this.x=Math.floor(this.x),this.y=Math.floor(this.y),this.z=Math.floor(this.z),this.w=Math.floor(this.w),this}ceil(){return this.x=Math.ceil(this.x),this.y=Math.ceil(this.y),this.z=Math.ceil(this.z),this.w=Math.ceil(this.w),this}round(){return this.x=Math.round(this.x),this.y=Math.round(this.y),this.z=Math.round(this.z),this.w=Math.round(this.w),this}roundToZero(){return this.x=this.x<0?Math.ceil(this.x):Math.floor(this.x),this.y=this.y<0?Math.ceil(this.y):Math.floor(this.y),this.z=this.z<0?Math.ceil(this.z):Math.floor(this.z),this.w=this.w<0?Math.ceil(this.w):Math.floor(this.w),this}negate(){return this.x=-this.x,this.y=-this.y,this.z=-this.z,this.w=-this.w,this}dot(e){return this.x*e.x+this.y*e.y+this.z*e.z+this.w*e.w}lengthSq(){return this.x*this.x+this.y*this.y+this.z*this.z+this.w*this.w}length(){return Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z+this.w*this.w)}manhattanLength(){return Math.abs(this.x)+Math.abs(this.y)+Math.abs(this.z)+Math.abs(this.w)}normalize(){return this.divideScalar(this.length()||1)}setLength(e){return this.normalize().multiplyScalar(e)}lerp(e,t){return this.x+=(e.x-this.x)*t,this.y+=(e.y-this.y)*t,this.z+=(e.z-this.z)*t,this.w+=(e.w-this.w)*t,this}lerpVectors(e,t,n){return this.x=e.x+(t.x-e.x)*n,this.y=e.y+(t.y-e.y)*n,this.z=e.z+(t.z-e.z)*n,this.w=e.w+(t.w-e.w)*n,this}equals(e){return e.x===this.x&&e.y===this.y&&e.z===this.z&&e.w===this.w}fromArray(e,t=0){return this.x=e[t],this.y=e[t+1],this.z=e[t+2],this.w=e[t+3],this}toArray(e=[],t=0){return e[t]=this.x,e[t+1]=this.y,e[t+2]=this.z,e[t+3]=this.w,e}fromBufferAttribute(e,t){return this.x=e.getX(t),this.y=e.getY(t),this.z=e.getZ(t),this.w=e.getW(t),this}random(){return this.x=Math.random(),this.y=Math.random(),this.z=Math.random(),this.w=Math.random(),this}*[Symbol.iterator](){yield this.x,yield this.y,yield this.z,yield this.w}}class G0 extends H0{constructor(e,t,n={}){super(),this.isWebGLRenderTarget=!0,this.width=e,this.height=t,this.depth=1,this.scissor=new l3(0,0,e,t),this.scissorTest=!1,this.viewport=new l3(0,0,e,t);const i={width:e,height:t,depth:1};this.texture=new Q3(i,n.mapping,n.wrapS,n.wrapT,n.magFilter,n.minFilter,n.format,n.type,n.anisotropy,n.encoding),this.texture.isRenderTargetTexture=!0,this.texture.flipY=!1,this.texture.generateMipmaps=n.generateMipmaps!==void 0?n.generateMipmaps:!1,this.texture.internalFormat=n.internalFormat!==void 0?n.internalFormat:null,this.texture.minFilter=n.minFilter!==void 0?n.minFilter:j3,this.depthBuffer=n.depthBuffer!==void 0?n.depthBuffer:!0,this.stencilBuffer=n.stencilBuffer!==void 0?n.stencilBuffer:!1,this.depthTexture=n.depthTexture!==void 0?n.depthTexture:null,this.samples=n.samples!==void 0?n.samples:0}setSize(e,t,n=1){(this.width!==e||this.height!==t||this.depth!==n)&&(this.width=e,this.height=t,this.depth=n,this.texture.image.width=e,this.texture.image.height=t,this.texture.image.depth=n,this.dispose()),this.viewport.set(0,0,e,t),this.scissor.set(0,0,e,t)}clone(){return new this.constructor().copy(this)}copy(e){this.width=e.width,this.height=e.height,this.depth=e.depth,this.viewport.copy(e.viewport),this.texture=e.texture.clone(),this.texture.isRenderTargetTexture=!0;const t=Object.assign({},e.texture.image);return this.texture.source=new ss(t),this.depthBuffer=e.depthBuffer,this.stencilBuffer=e.stencilBuffer,e.depthTexture!==null&&(this.depthTexture=e.depthTexture.clone()),this.samples=e.samples,this}dispose(){this.dispatchEvent({type:"dispose"})}}class ls extends Q3{constructor(e=null,t=1,n=1,i=1){super(null),this.isDataArrayTexture=!0,this.image={data:e,width:t,height:n,depth:i},this.magFilter=x3,this.minFilter=x3,this.wrapR=r4,this.generateMipmaps=!1,this.flipY=!1,this.unpackAlignment=1}}class cS extends Q3{constructor(e=null,t=1,n=1,i=1){super(null),this.isData3DTexture=!0,this.image={data:e,width:t,height:n,depth:i},this.magFilter=x3,this.minFilter=x3,this.wrapR=r4,this.generateMipmaps=!1,this.flipY=!1,this.unpackAlignment=1}}class k4{constructor(e=0,t=0,n=0,i=1){this.isQuaternion=!0,this._x=e,this._y=t,this._z=n,this._w=i}static slerpFlat(e,t,n,i,a,r,s){let u=n[i+0],c=n[i+1],d=n[i+2],h=n[i+3];const p=a[r+0],g=a[r+1],y=a[r+2],m=a[r+3];if(s===0){e[t+0]=u,e[t+1]=c,e[t+2]=d,e[t+3]=h;return}if(s===1){e[t+0]=p,e[t+1]=g,e[t+2]=y,e[t+3]=m;return}if(h!==m||u!==p||c!==g||d!==y){let v=1-s;const b=u*p+c*g+d*y+h*m,x=b>=0?1:-1,w=1-b*b;if(w>Number.EPSILON){const A=Math.sqrt(w),S=Math.atan2(A,b*x);v=Math.sin(v*S)/A,s=Math.sin(s*S)/A}const M=s*x;if(u=u*v+p*M,c=c*v+g*M,d=d*v+y*M,h=h*v+m*M,v===1-s){const A=1/Math.sqrt(u*u+c*c+d*d+h*h);u*=A,c*=A,d*=A,h*=A}}e[t]=u,e[t+1]=c,e[t+2]=d,e[t+3]=h}static multiplyQuaternionsFlat(e,t,n,i,a,r){const s=n[i],u=n[i+1],c=n[i+2],d=n[i+3],h=a[r],p=a[r+1],g=a[r+2],y=a[r+3];return e[t]=s*y+d*h+u*g-c*p,e[t+1]=u*y+d*p+c*h-s*g,e[t+2]=c*y+d*g+s*p-u*h,e[t+3]=d*y-s*h-u*p-c*g,e}get x(){return this._x}set x(e){this._x=e,this._onChangeCallback()}get y(){return this._y}set y(e){this._y=e,this._onChangeCallback()}get z(){return this._z}set z(e){this._z=e,this._onChangeCallback()}get w(){return this._w}set w(e){this._w=e,this._onChangeCallback()}set(e,t,n,i){return this._x=e,this._y=t,this._z=n,this._w=i,this._onChangeCallback(),this}clone(){return new this.constructor(this._x,this._y,this._z,this._w)}copy(e){return this._x=e.x,this._y=e.y,this._z=e.z,this._w=e.w,this._onChangeCallback(),this}setFromEuler(e,t){const n=e._x,i=e._y,a=e._z,r=e._order,s=Math.cos,u=Math.sin,c=s(n/2),d=s(i/2),h=s(a/2),p=u(n/2),g=u(i/2),y=u(a/2);switch(r){case"XYZ":this._x=p*d*h+c*g*y,this._y=c*g*h-p*d*y,this._z=c*d*y+p*g*h,this._w=c*d*h-p*g*y;break;case"YXZ":this._x=p*d*h+c*g*y,this._y=c*g*h-p*d*y,this._z=c*d*y-p*g*h,this._w=c*d*h+p*g*y;break;case"ZXY":this._x=p*d*h-c*g*y,this._y=c*g*h+p*d*y,this._z=c*d*y+p*g*h,this._w=c*d*h-p*g*y;break;case"ZYX":this._x=p*d*h-c*g*y,this._y=c*g*h+p*d*y,this._z=c*d*y-p*g*h,this._w=c*d*h+p*g*y;break;case"YZX":this._x=p*d*h+c*g*y,this._y=c*g*h+p*d*y,this._z=c*d*y-p*g*h,this._w=c*d*h-p*g*y;break;case"XZY":this._x=p*d*h-c*g*y,this._y=c*g*h-p*d*y,this._z=c*d*y+p*g*h,this._w=c*d*h+p*g*y;break;default:console.warn("THREE.Quaternion: .setFromEuler() encountered an unknown order: "+r)}return t!==!1&&this._onChangeCallback(),this}setFromAxisAngle(e,t){const n=t/2,i=Math.sin(n);return this._x=e.x*i,this._y=e.y*i,this._z=e.z*i,this._w=Math.cos(n),this._onChangeCallback(),this}setFromRotationMatrix(e){const t=e.elements,n=t[0],i=t[4],a=t[8],r=t[1],s=t[5],u=t[9],c=t[2],d=t[6],h=t[10],p=n+s+h;if(p>0){const g=.5/Math.sqrt(p+1);this._w=.25/g,this._x=(d-u)*g,this._y=(a-c)*g,this._z=(r-i)*g}else if(n>s&&n>h){const g=2*Math.sqrt(1+n-s-h);this._w=(d-u)/g,this._x=.25*g,this._y=(i+r)/g,this._z=(a+c)/g}else if(s>h){const g=2*Math.sqrt(1+s-n-h);this._w=(a-c)/g,this._x=(i+r)/g,this._y=.25*g,this._z=(u+d)/g}else{const g=2*Math.sqrt(1+h-n-s);this._w=(r-i)/g,this._x=(a+c)/g,this._y=(u+d)/g,this._z=.25*g}return this._onChangeCallback(),this}setFromUnitVectors(e,t){let n=e.dot(t)+1;return n<Number.EPSILON?(n=0,Math.abs(e.x)>Math.abs(e.z)?(this._x=-e.y,this._y=e.x,this._z=0,this._w=n):(this._x=0,this._y=-e.z,this._z=e.y,this._w=n)):(this._x=e.y*t.z-e.z*t.y,this._y=e.z*t.x-e.x*t.z,this._z=e.x*t.y-e.y*t.x,this._w=n),this.normalize()}angleTo(e){return 2*Math.acos(Math.abs(d3(this.dot(e),-1,1)))}rotateTowards(e,t){const n=this.angleTo(e);if(n===0)return this;const i=Math.min(1,t/n);return this.slerp(e,i),this}identity(){return this.set(0,0,0,1)}invert(){return this.conjugate()}conjugate(){return this._x*=-1,this._y*=-1,this._z*=-1,this._onChangeCallback(),this}dot(e){return this._x*e._x+this._y*e._y+this._z*e._z+this._w*e._w}lengthSq(){return this._x*this._x+this._y*this._y+this._z*this._z+this._w*this._w}length(){return Math.sqrt(this._x*this._x+this._y*this._y+this._z*this._z+this._w*this._w)}normalize(){let e=this.length();return e===0?(this._x=0,this._y=0,this._z=0,this._w=1):(e=1/e,this._x=this._x*e,this._y=this._y*e,this._z=this._z*e,this._w=this._w*e),this._onChangeCallback(),this}multiply(e){return this.multiplyQuaternions(this,e)}premultiply(e){return this.multiplyQuaternions(e,this)}multiplyQuaternions(e,t){const n=e._x,i=e._y,a=e._z,r=e._w,s=t._x,u=t._y,c=t._z,d=t._w;return this._x=n*d+r*s+i*c-a*u,this._y=i*d+r*u+a*s-n*c,this._z=a*d+r*c+n*u-i*s,this._w=r*d-n*s-i*u-a*c,this._onChangeCallback(),this}slerp(e,t){if(t===0)return this;if(t===1)return this.copy(e);const n=this._x,i=this._y,a=this._z,r=this._w;let s=r*e._w+n*e._x+i*e._y+a*e._z;if(s<0?(this._w=-e._w,this._x=-e._x,this._y=-e._y,this._z=-e._z,s=-s):this.copy(e),s>=1)return this._w=r,this._x=n,this._y=i,this._z=a,this;const u=1-s*s;if(u<=Number.EPSILON){const g=1-t;return this._w=g*r+t*this._w,this._x=g*n+t*this._x,this._y=g*i+t*this._y,this._z=g*a+t*this._z,this.normalize(),this._onChangeCallback(),this}const c=Math.sqrt(u),d=Math.atan2(c,s),h=Math.sin((1-t)*d)/c,p=Math.sin(t*d)/c;return this._w=r*h+this._w*p,this._x=n*h+this._x*p,this._y=i*h+this._y*p,this._z=a*h+this._z*p,this._onChangeCallback(),this}slerpQuaternions(e,t,n){return this.copy(e).slerp(t,n)}random(){const e=Math.random(),t=Math.sqrt(1-e),n=Math.sqrt(e),i=2*Math.PI*Math.random(),a=2*Math.PI*Math.random();return this.set(t*Math.cos(i),n*Math.sin(a),n*Math.cos(a),t*Math.sin(i))}equals(e){return e._x===this._x&&e._y===this._y&&e._z===this._z&&e._w===this._w}fromArray(e,t=0){return this._x=e[t],this._y=e[t+1],this._z=e[t+2],this._w=e[t+3],this._onChangeCallback(),this}toArray(e=[],t=0){return e[t]=this._x,e[t+1]=this._y,e[t+2]=this._z,e[t+3]=this._w,e}fromBufferAttribute(e,t){return this._x=e.getX(t),this._y=e.getY(t),this._z=e.getZ(t),this._w=e.getW(t),this}_onChange(e){return this._onChangeCallback=e,this}_onChangeCallback(){}*[Symbol.iterator](){yield this._x,yield this._y,yield this._z,yield this._w}}class Y{constructor(e=0,t=0,n=0){Y.prototype.isVector3=!0,this.x=e,this.y=t,this.z=n}set(e,t,n){return n===void 0&&(n=this.z),this.x=e,this.y=t,this.z=n,this}setScalar(e){return this.x=e,this.y=e,this.z=e,this}setX(e){return this.x=e,this}setY(e){return this.y=e,this}setZ(e){return this.z=e,this}setComponent(e,t){switch(e){case 0:this.x=t;break;case 1:this.y=t;break;case 2:this.z=t;break;default:throw new Error("index is out of range: "+e)}return this}getComponent(e){switch(e){case 0:return this.x;case 1:return this.y;case 2:return this.z;default:throw new Error("index is out of range: "+e)}}clone(){return new this.constructor(this.x,this.y,this.z)}copy(e){return this.x=e.x,this.y=e.y,this.z=e.z,this}add(e){return this.x+=e.x,this.y+=e.y,this.z+=e.z,this}addScalar(e){return this.x+=e,this.y+=e,this.z+=e,this}addVectors(e,t){return this.x=e.x+t.x,this.y=e.y+t.y,this.z=e.z+t.z,this}addScaledVector(e,t){return this.x+=e.x*t,this.y+=e.y*t,this.z+=e.z*t,this}sub(e){return this.x-=e.x,this.y-=e.y,this.z-=e.z,this}subScalar(e){return this.x-=e,this.y-=e,this.z-=e,this}subVectors(e,t){return this.x=e.x-t.x,this.y=e.y-t.y,this.z=e.z-t.z,this}multiply(e){return this.x*=e.x,this.y*=e.y,this.z*=e.z,this}multiplyScalar(e){return this.x*=e,this.y*=e,this.z*=e,this}multiplyVectors(e,t){return this.x=e.x*t.x,this.y=e.y*t.y,this.z=e.z*t.z,this}applyEuler(e){return this.applyQuaternion(Mo.setFromEuler(e))}applyAxisAngle(e,t){return this.applyQuaternion(Mo.setFromAxisAngle(e,t))}applyMatrix3(e){const t=this.x,n=this.y,i=this.z,a=e.elements;return this.x=a[0]*t+a[3]*n+a[6]*i,this.y=a[1]*t+a[4]*n+a[7]*i,this.z=a[2]*t+a[5]*n+a[8]*i,this}applyNormalMatrix(e){return this.applyMatrix3(e).normalize()}applyMatrix4(e){const t=this.x,n=this.y,i=this.z,a=e.elements,r=1/(a[3]*t+a[7]*n+a[11]*i+a[15]);return this.x=(a[0]*t+a[4]*n+a[8]*i+a[12])*r,this.y=(a[1]*t+a[5]*n+a[9]*i+a[13])*r,this.z=(a[2]*t+a[6]*n+a[10]*i+a[14])*r,this}applyQuaternion(e){const t=this.x,n=this.y,i=this.z,a=e.x,r=e.y,s=e.z,u=e.w,c=u*t+r*i-s*n,d=u*n+s*t-a*i,h=u*i+a*n-r*t,p=-a*t-r*n-s*i;return this.x=c*u+p*-a+d*-s-h*-r,this.y=d*u+p*-r+h*-a-c*-s,this.z=h*u+p*-s+c*-r-d*-a,this}project(e){return this.applyMatrix4(e.matrixWorldInverse).applyMatrix4(e.projectionMatrix)}unproject(e){return this.applyMatrix4(e.projectionMatrixInverse).applyMatrix4(e.matrixWorld)}transformDirection(e){const t=this.x,n=this.y,i=this.z,a=e.elements;return this.x=a[0]*t+a[4]*n+a[8]*i,this.y=a[1]*t+a[5]*n+a[9]*i,this.z=a[2]*t+a[6]*n+a[10]*i,this.normalize()}divide(e){return this.x/=e.x,this.y/=e.y,this.z/=e.z,this}divideScalar(e){return this.multiplyScalar(1/e)}min(e){return this.x=Math.min(this.x,e.x),this.y=Math.min(this.y,e.y),this.z=Math.min(this.z,e.z),this}max(e){return this.x=Math.max(this.x,e.x),this.y=Math.max(this.y,e.y),this.z=Math.max(this.z,e.z),this}clamp(e,t){return this.x=Math.max(e.x,Math.min(t.x,this.x)),this.y=Math.max(e.y,Math.min(t.y,this.y)),this.z=Math.max(e.z,Math.min(t.z,this.z)),this}clampScalar(e,t){return this.x=Math.max(e,Math.min(t,this.x)),this.y=Math.max(e,Math.min(t,this.y)),this.z=Math.max(e,Math.min(t,this.z)),this}clampLength(e,t){const n=this.length();return this.divideScalar(n||1).multiplyScalar(Math.max(e,Math.min(t,n)))}floor(){return this.x=Math.floor(this.x),this.y=Math.floor(this.y),this.z=Math.floor(this.z),this}ceil(){return this.x=Math.ceil(this.x),this.y=Math.ceil(this.y),this.z=Math.ceil(this.z),this}round(){return this.x=Math.round(this.x),this.y=Math.round(this.y),this.z=Math.round(this.z),this}roundToZero(){return this.x=this.x<0?Math.ceil(this.x):Math.floor(this.x),this.y=this.y<0?Math.ceil(this.y):Math.floor(this.y),this.z=this.z<0?Math.ceil(this.z):Math.floor(this.z),this}negate(){return this.x=-this.x,this.y=-this.y,this.z=-this.z,this}dot(e){return this.x*e.x+this.y*e.y+this.z*e.z}lengthSq(){return this.x*this.x+this.y*this.y+this.z*this.z}length(){return Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z)}manhattanLength(){return Math.abs(this.x)+Math.abs(this.y)+Math.abs(this.z)}normalize(){return this.divideScalar(this.length()||1)}setLength(e){return this.normalize().multiplyScalar(e)}lerp(e,t){return this.x+=(e.x-this.x)*t,this.y+=(e.y-this.y)*t,this.z+=(e.z-this.z)*t,this}lerpVectors(e,t,n){return this.x=e.x+(t.x-e.x)*n,this.y=e.y+(t.y-e.y)*n,this.z=e.z+(t.z-e.z)*n,this}cross(e){return this.crossVectors(this,e)}crossVectors(e,t){const n=e.x,i=e.y,a=e.z,r=t.x,s=t.y,u=t.z;return this.x=i*u-a*s,this.y=a*r-n*u,this.z=n*s-i*r,this}projectOnVector(e){const t=e.lengthSq();if(t===0)return this.set(0,0,0);const n=e.dot(this)/t;return this.copy(e).multiplyScalar(n)}projectOnPlane(e){return R6.copy(this).projectOnVector(e),this.sub(R6)}reflect(e){return this.sub(R6.copy(e).multiplyScalar(2*this.dot(e)))}angleTo(e){const t=Math.sqrt(this.lengthSq()*e.lengthSq());if(t===0)return Math.PI/2;const n=this.dot(e)/t;return Math.acos(d3(n,-1,1))}distanceTo(e){return Math.sqrt(this.distanceToSquared(e))}distanceToSquared(e){const t=this.x-e.x,n=this.y-e.y,i=this.z-e.z;return t*t+n*n+i*i}manhattanDistanceTo(e){return Math.abs(this.x-e.x)+Math.abs(this.y-e.y)+Math.abs(this.z-e.z)}setFromSpherical(e){return this.setFromSphericalCoords(e.radius,e.phi,e.theta)}setFromSphericalCoords(e,t,n){const i=Math.sin(t)*e;return this.x=i*Math.sin(n),this.y=Math.cos(t)*e,this.z=i*Math.cos(n),this}setFromCylindrical(e){return this.setFromCylindricalCoords(e.radius,e.theta,e.y)}setFromCylindricalCoords(e,t,n){return this.x=e*Math.sin(t),this.y=n,this.z=e*Math.cos(t),this}setFromMatrixPosition(e){const t=e.elements;return this.x=t[12],this.y=t[13],this.z=t[14],this}setFromMatrixScale(e){const t=this.setFromMatrixColumn(e,0).length(),n=this.setFromMatrixColumn(e,1).length(),i=this.setFromMatrixColumn(e,2).length();return this.x=t,this.y=n,this.z=i,this}setFromMatrixColumn(e,t){return this.fromArray(e.elements,t*4)}setFromMatrix3Column(e,t){return this.fromArray(e.elements,t*3)}setFromEuler(e){return this.x=e._x,this.y=e._y,this.z=e._z,this}equals(e){return e.x===this.x&&e.y===this.y&&e.z===this.z}fromArray(e,t=0){return this.x=e[t],this.y=e[t+1],this.z=e[t+2],this}toArray(e=[],t=0){return e[t]=this.x,e[t+1]=this.y,e[t+2]=this.z,e}fromBufferAttribute(e,t){return this.x=e.getX(t),this.y=e.getY(t),this.z=e.getZ(t),this}random(){return this.x=Math.random(),this.y=Math.random(),this.z=Math.random(),this}randomDirection(){const e=(Math.random()-.5)*2,t=Math.random()*Math.PI*2,n=Math.sqrt(1-Nn(e,2));return this.x=n*Math.cos(t),this.y=n*Math.sin(t),this.z=e,this}*[Symbol.iterator](){yield this.x,yield this.y,yield this.z}}const R6=new Y,Mo=new k4;class k5{constructor(e=new Y(1/0,1/0,1/0),t=new Y(-1/0,-1/0,-1/0)){this.isBox3=!0,this.min=e,this.max=t}set(e,t){return this.min.copy(e),this.max.copy(t),this}setFromArray(e){let t=1/0,n=1/0,i=1/0,a=-1/0,r=-1/0,s=-1/0;for(let u=0,c=e.length;u<c;u+=3){const d=e[u],h=e[u+1],p=e[u+2];d<t&&(t=d),h<n&&(n=h),p<i&&(i=p),d>a&&(a=d),h>r&&(r=h),p>s&&(s=p)}return this.min.set(t,n,i),this.max.set(a,r,s),this}setFromBufferAttribute(e){let t=1/0,n=1/0,i=1/0,a=-1/0,r=-1/0,s=-1/0;for(let u=0,c=e.count;u<c;u++){const d=e.getX(u),h=e.getY(u),p=e.getZ(u);d<t&&(t=d),h<n&&(n=h),p<i&&(i=p),d>a&&(a=d),h>r&&(r=h),p>s&&(s=p)}return this.min.set(t,n,i),this.max.set(a,r,s),this}setFromPoints(e){this.makeEmpty();for(let t=0,n=e.length;t<n;t++)this.expandByPoint(e[t]);return this}setFromCenterAndSize(e,t){const n=_0.copy(t).multiplyScalar(.5);return this.min.copy(e).sub(n),this.max.copy(e).add(n),this}setFromObject(e,t=!1){return this.makeEmpty(),this.expandByObject(e,t)}clone(){return new this.constructor().copy(this)}copy(e){return this.min.copy(e.min),this.max.copy(e.max),this}makeEmpty(){return this.min.x=this.min.y=this.min.z=1/0,this.max.x=this.max.y=this.max.z=-1/0,this}isEmpty(){return this.max.x<this.min.x||this.max.y<this.min.y||this.max.z<this.min.z}getCenter(e){return this.isEmpty()?e.set(0,0,0):e.addVectors(this.min,this.max).multiplyScalar(.5)}getSize(e){return this.isEmpty()?e.set(0,0,0):e.subVectors(this.max,this.min)}expandByPoint(e){return this.min.min(e),this.max.max(e),this}expandByVector(e){return this.min.sub(e),this.max.add(e),this}expandByScalar(e){return this.min.addScalar(-e),this.max.addScalar(e),this}expandByObject(e,t=!1){e.updateWorldMatrix(!1,!1);const n=e.geometry;if(n!==void 0)if(t&&n.attributes!=null&&n.attributes.position!==void 0){const a=n.attributes.position;for(let r=0,s=a.count;r<s;r++)_0.fromBufferAttribute(a,r).applyMatrix4(e.matrixWorld),this.expandByPoint(_0)}else n.boundingBox===null&&n.computeBoundingBox(),O6.copy(n.boundingBox),O6.applyMatrix4(e.matrixWorld),this.union(O6);const i=e.children;for(let a=0,r=i.length;a<r;a++)this.expandByObject(i[a],t);return this}containsPoint(e){return!(e.x<this.min.x||e.x>this.max.x||e.y<this.min.y||e.y>this.max.y||e.z<this.min.z||e.z>this.max.z)}containsBox(e){return this.min.x<=e.min.x&&e.max.x<=this.max.x&&this.min.y<=e.min.y&&e.max.y<=this.max.y&&this.min.z<=e.min.z&&e.max.z<=this.max.z}getParameter(e,t){return t.set((e.x-this.min.x)/(this.max.x-this.min.x),(e.y-this.min.y)/(this.max.y-this.min.y),(e.z-this.min.z)/(this.max.z-this.min.z))}intersectsBox(e){return!(e.max.x<this.min.x||e.min.x>this.max.x||e.max.y<this.min.y||e.min.y>this.max.y||e.max.z<this.min.z||e.min.z>this.max.z)}intersectsSphere(e){return this.clampPoint(e.center,_0),_0.distanceToSquared(e.center)<=e.radius*e.radius}intersectsPlane(e){let t,n;return e.normal.x>0?(t=e.normal.x*this.min.x,n=e.normal.x*this.max.x):(t=e.normal.x*this.max.x,n=e.normal.x*this.min.x),e.normal.y>0?(t+=e.normal.y*this.min.y,n+=e.normal.y*this.max.y):(t+=e.normal.y*this.max.y,n+=e.normal.y*this.min.y),e.normal.z>0?(t+=e.normal.z*this.min.z,n+=e.normal.z*this.max.z):(t+=e.normal.z*this.max.z,n+=e.normal.z*this.min.z),t<=-e.constant&&n>=-e.constant}intersectsTriangle(e){if(this.isEmpty())return!1;this.getCenter(e5),K5.subVectors(this.max,e5),e9.subVectors(e.a,e5),t9.subVectors(e.b,e5),n9.subVectors(e.c,e5),j4.subVectors(t9,e9),W4.subVectors(n9,t9),v0.subVectors(e9,n9);let t=[0,-j4.z,j4.y,0,-W4.z,W4.y,0,-v0.z,v0.y,j4.z,0,-j4.x,W4.z,0,-W4.x,v0.z,0,-v0.x,-j4.y,j4.x,0,-W4.y,W4.x,0,-v0.y,v0.x,0];return!P6(t,e9,t9,n9,K5)||(t=[1,0,0,0,1,0,0,0,1],!P6(t,e9,t9,n9,K5))?!1:(e8.crossVectors(j4,W4),t=[e8.x,e8.y,e8.z],P6(t,e9,t9,n9,K5))}clampPoint(e,t){return t.copy(e).clamp(this.min,this.max)}distanceToPoint(e){return _0.copy(e).clamp(this.min,this.max).sub(e).length()}getBoundingSphere(e){return this.getCenter(e.center),e.radius=this.getSize(_0).length()*.5,e}intersect(e){return this.min.max(e.min),this.max.min(e.max),this.isEmpty()&&this.makeEmpty(),this}union(e){return this.min.min(e.min),this.max.max(e.max),this}applyMatrix4(e){return this.isEmpty()?this:(A4[0].set(this.min.x,this.min.y,this.min.z).applyMatrix4(e),A4[1].set(this.min.x,this.min.y,this.max.z).applyMatrix4(e),A4[2].set(this.min.x,this.max.y,this.min.z).applyMatrix4(e),A4[3].set(this.min.x,this.max.y,this.max.z).applyMatrix4(e),A4[4].set(this.max.x,this.min.y,this.min.z).applyMatrix4(e),A4[5].set(this.max.x,this.min.y,this.max.z).applyMatrix4(e),A4[6].set(this.max.x,this.max.y,this.min.z).applyMatrix4(e),A4[7].set(this.max.x,this.max.y,this.max.z).applyMatrix4(e),this.setFromPoints(A4),this)}translate(e){return this.min.add(e),this.max.add(e),this}equals(e){return e.min.equals(this.min)&&e.max.equals(this.max)}}const A4=[new Y,new Y,new Y,new Y,new Y,new Y,new Y,new Y],_0=new Y,O6=new k5,e9=new Y,t9=new Y,n9=new Y,j4=new Y,W4=new Y,v0=new Y,e5=new Y,K5=new Y,e8=new Y,y0=new Y;function P6(o,e,t,n,i){for(let a=0,r=o.length-3;a<=r;a+=3){y0.fromArray(o,a);const s=i.x*Math.abs(y0.x)+i.y*Math.abs(y0.y)+i.z*Math.abs(y0.z),u=e.dot(y0),c=t.dot(y0),d=n.dot(y0);if(Math.max(-Math.max(u,c,d),Math.min(u,c,d))>s)return!1}return!0}const dS=new k5,Ao=new Y,t8=new Y,L6=new Y;class N5{constructor(e=new Y,t=-1){this.center=e,this.radius=t}set(e,t){return this.center.copy(e),this.radius=t,this}setFromPoints(e,t){const n=this.center;t!==void 0?n.copy(t):dS.setFromPoints(e).getCenter(n);let i=0;for(let a=0,r=e.length;a<r;a++)i=Math.max(i,n.distanceToSquared(e[a]));return this.radius=Math.sqrt(i),this}copy(e){return this.center.copy(e.center),this.radius=e.radius,this}isEmpty(){return this.radius<0}makeEmpty(){return this.center.set(0,0,0),this.radius=-1,this}containsPoint(e){return e.distanceToSquared(this.center)<=this.radius*this.radius}distanceToPoint(e){return e.distanceTo(this.center)-this.radius}intersectsSphere(e){const t=this.radius+e.radius;return e.center.distanceToSquared(this.center)<=t*t}intersectsBox(e){return e.intersectsSphere(this)}intersectsPlane(e){return Math.abs(e.distanceToPoint(this.center))<=this.radius}clampPoint(e,t){const n=this.center.distanceToSquared(e);return t.copy(e),n>this.radius*this.radius&&(t.sub(this.center).normalize(),t.multiplyScalar(this.radius).add(this.center)),t}getBoundingBox(e){return this.isEmpty()?(e.makeEmpty(),e):(e.set(this.center,this.center),e.expandByScalar(this.radius),e)}applyMatrix4(e){return this.center.applyMatrix4(e),this.radius=this.radius*e.getMaxScaleOnAxis(),this}translate(e){return this.center.add(e),this}expandByPoint(e){if(this.isEmpty())return this.center.copy(e),this.radius=0,this;L6.subVectors(e,this.center);const t=L6.lengthSq();if(t>this.radius*this.radius){const n=Math.sqrt(t),i=(n-this.radius)*.5;this.center.add(L6.multiplyScalar(i/n)),this.radius+=i}return this}union(e){return e.isEmpty()?this:this.isEmpty()?(this.copy(e),this):(this.center.equals(e.center)===!0?t8.set(0,0,1).multiplyScalar(e.radius):t8.subVectors(e.center,this.center).normalize().multiplyScalar(e.radius),this.expandByPoint(Ao.copy(e.center).add(t8)),this.expandByPoint(Ao.copy(e.center).sub(t8)),this)}equals(e){return e.center.equals(this.center)&&e.radius===this.radius}clone(){return new this.constructor().copy(this)}}const w4=new Y,z6=new Y,n8=new Y,H4=new Y,k6=new Y,i8=new Y,N6=new Y;class qt{constructor(e=new Y,t=new Y(0,0,-1)){this.origin=e,this.direction=t}set(e,t){return this.origin.copy(e),this.direction.copy(t),this}copy(e){return this.origin.copy(e.origin),this.direction.copy(e.direction),this}at(e,t){return t.copy(this.direction).multiplyScalar(e).add(this.origin)}lookAt(e){return this.direction.copy(e).sub(this.origin).normalize(),this}recast(e){return this.origin.copy(this.at(e,w4)),this}closestPointToPoint(e,t){t.subVectors(e,this.origin);const n=t.dot(this.direction);return n<0?t.copy(this.origin):t.copy(this.direction).multiplyScalar(n).add(this.origin)}distanceToPoint(e){return Math.sqrt(this.distanceSqToPoint(e))}distanceSqToPoint(e){const t=w4.subVectors(e,this.origin).dot(this.direction);return t<0?this.origin.distanceToSquared(e):(w4.copy(this.direction).multiplyScalar(t).add(this.origin),w4.distanceToSquared(e))}distanceSqToSegment(e,t,n,i){z6.copy(e).add(t).multiplyScalar(.5),n8.copy(t).sub(e).normalize(),H4.copy(this.origin).sub(z6);const a=e.distanceTo(t)*.5,r=-this.direction.dot(n8),s=H4.dot(this.direction),u=-H4.dot(n8),c=H4.lengthSq(),d=Math.abs(1-r*r);let h,p,g,y;if(d>0)if(h=r*u-s,p=r*s-u,y=a*d,h>=0)if(p>=-y)if(p<=y){const m=1/d;h*=m,p*=m,g=h*(h+r*p+2*s)+p*(r*h+p+2*u)+c}else p=a,h=Math.max(0,-(r*p+s)),g=-h*h+p*(p+2*u)+c;else p=-a,h=Math.max(0,-(r*p+s)),g=-h*h+p*(p+2*u)+c;else p<=-y?(h=Math.max(0,-(-r*a+s)),p=h>0?-a:Math.min(Math.max(-a,-u),a),g=-h*h+p*(p+2*u)+c):p<=y?(h=0,p=Math.min(Math.max(-a,-u),a),g=p*(p+2*u)+c):(h=Math.max(0,-(r*a+s)),p=h>0?a:Math.min(Math.max(-a,-u),a),g=-h*h+p*(p+2*u)+c);else p=r>0?-a:a,h=Math.max(0,-(r*p+s)),g=-h*h+p*(p+2*u)+c;return n&&n.copy(this.direction).multiplyScalar(h).add(this.origin),i&&i.copy(n8).multiplyScalar(p).add(z6),g}intersectSphere(e,t){w4.subVectors(e.center,this.origin);const n=w4.dot(this.direction),i=w4.dot(w4)-n*n,a=e.radius*e.radius;if(i>a)return null;const r=Math.sqrt(a-i),s=n-r,u=n+r;return s<0&&u<0?null:s<0?this.at(u,t):this.at(s,t)}intersectsSphere(e){return this.distanceSqToPoint(e.center)<=e.radius*e.radius}distanceToPlane(e){const t=e.normal.dot(this.direction);if(t===0)return e.distanceToPoint(this.origin)===0?0:null;const n=-(this.origin.dot(e.normal)+e.constant)/t;return n>=0?n:null}intersectPlane(e,t){const n=this.distanceToPlane(e);return n===null?null:this.at(n,t)}intersectsPlane(e){const t=e.distanceToPoint(this.origin);return t===0||e.normal.dot(this.direction)*t<0}intersectBox(e,t){let n,i,a,r,s,u;const c=1/this.direction.x,d=1/this.direction.y,h=1/this.direction.z,p=this.origin;return c>=0?(n=(e.min.x-p.x)*c,i=(e.max.x-p.x)*c):(n=(e.max.x-p.x)*c,i=(e.min.x-p.x)*c),d>=0?(a=(e.min.y-p.y)*d,r=(e.max.y-p.y)*d):(a=(e.max.y-p.y)*d,r=(e.min.y-p.y)*d),n>r||a>i||((a>n||n!==n)&&(n=a),(r<i||i!==i)&&(i=r),h>=0?(s=(e.min.z-p.z)*h,u=(e.max.z-p.z)*h):(s=(e.max.z-p.z)*h,u=(e.min.z-p.z)*h),n>u||s>i)||((s>n||n!==n)&&(n=s),(u<i||i!==i)&&(i=u),i<0)?null:this.at(n>=0?n:i,t)}intersectsBox(e){return this.intersectBox(e,w4)!==null}intersectTriangle(e,t,n,i,a){k6.subVectors(t,e),i8.subVectors(n,e),N6.crossVectors(k6,i8);let r=this.direction.dot(N6),s;if(r>0){if(i)return null;s=1}else if(r<0)s=-1,r=-r;else return null;H4.subVectors(this.origin,e);const u=s*this.direction.dot(i8.crossVectors(H4,i8));if(u<0)return null;const c=s*this.direction.dot(k6.cross(H4));if(c<0||u+c>r)return null;const d=-s*H4.dot(N6);return d<0?null:this.at(d/r,a)}applyMatrix4(e){return this.origin.applyMatrix4(e),this.direction.transformDirection(e),this}equals(e){return e.origin.equals(this.origin)&&e.direction.equals(this.direction)}clone(){return new this.constructor().copy(this)}}class j2{constructor(){j2.prototype.isMatrix4=!0,this.elements=[1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1]}set(e,t,n,i,a,r,s,u,c,d,h,p,g,y,m,v){const b=this.elements;return b[0]=e,b[4]=t,b[8]=n,b[12]=i,b[1]=a,b[5]=r,b[9]=s,b[13]=u,b[2]=c,b[6]=d,b[10]=h,b[14]=p,b[3]=g,b[7]=y,b[11]=m,b[15]=v,this}identity(){return this.set(1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1),this}clone(){return new j2().fromArray(this.elements)}copy(e){const t=this.elements,n=e.elements;return t[0]=n[0],t[1]=n[1],t[2]=n[2],t[3]=n[3],t[4]=n[4],t[5]=n[5],t[6]=n[6],t[7]=n[7],t[8]=n[8],t[9]=n[9],t[10]=n[10],t[11]=n[11],t[12]=n[12],t[13]=n[13],t[14]=n[14],t[15]=n[15],this}copyPosition(e){const t=this.elements,n=e.elements;return t[12]=n[12],t[13]=n[13],t[14]=n[14],this}setFromMatrix3(e){const t=e.elements;return this.set(t[0],t[3],t[6],0,t[1],t[4],t[7],0,t[2],t[5],t[8],0,0,0,0,1),this}extractBasis(e,t,n){return e.setFromMatrixColumn(this,0),t.setFromMatrixColumn(this,1),n.setFromMatrixColumn(this,2),this}makeBasis(e,t,n){return this.set(e.x,t.x,n.x,0,e.y,t.y,n.y,0,e.z,t.z,n.z,0,0,0,0,1),this}extractRotation(e){const t=this.elements,n=e.elements,i=1/i9.setFromMatrixColumn(e,0).length(),a=1/i9.setFromMatrixColumn(e,1).length(),r=1/i9.setFromMatrixColumn(e,2).length();return t[0]=n[0]*i,t[1]=n[1]*i,t[2]=n[2]*i,t[3]=0,t[4]=n[4]*a,t[5]=n[5]*a,t[6]=n[6]*a,t[7]=0,t[8]=n[8]*r,t[9]=n[9]*r,t[10]=n[10]*r,t[11]=0,t[12]=0,t[13]=0,t[14]=0,t[15]=1,this}makeRotationFromEuler(e){const t=this.elements,n=e.x,i=e.y,a=e.z,r=Math.cos(n),s=Math.sin(n),u=Math.cos(i),c=Math.sin(i),d=Math.cos(a),h=Math.sin(a);if(e.order==="XYZ"){const p=r*d,g=r*h,y=s*d,m=s*h;t[0]=u*d,t[4]=-u*h,t[8]=c,t[1]=g+y*c,t[5]=p-m*c,t[9]=-s*u,t[2]=m-p*c,t[6]=y+g*c,t[10]=r*u}else if(e.order==="YXZ"){const p=u*d,g=u*h,y=c*d,m=c*h;t[0]=p+m*s,t[4]=y*s-g,t[8]=r*c,t[1]=r*h,t[5]=r*d,t[9]=-s,t[2]=g*s-y,t[6]=m+p*s,t[10]=r*u}else if(e.order==="ZXY"){const p=u*d,g=u*h,y=c*d,m=c*h;t[0]=p-m*s,t[4]=-r*h,t[8]=y+g*s,t[1]=g+y*s,t[5]=r*d,t[9]=m-p*s,t[2]=-r*c,t[6]=s,t[10]=r*u}else if(e.order==="ZYX"){const p=r*d,g=r*h,y=s*d,m=s*h;t[0]=u*d,t[4]=y*c-g,t[8]=p*c+m,t[1]=u*h,t[5]=m*c+p,t[9]=g*c-y,t[2]=-c,t[6]=s*u,t[10]=r*u}else if(e.order==="YZX"){const p=r*u,g=r*c,y=s*u,m=s*c;t[0]=u*d,t[4]=m-p*h,t[8]=y*h+g,t[1]=h,t[5]=r*d,t[9]=-s*d,t[2]=-c*d,t[6]=g*h+y,t[10]=p-m*h}else if(e.order==="XZY"){const p=r*u,g=r*c,y=s*u,m=s*c;t[0]=u*d,t[4]=-h,t[8]=c*d,t[1]=p*h+m,t[5]=r*d,t[9]=g*h-y,t[2]=y*h-g,t[6]=s*d,t[10]=m*h+p}return t[3]=0,t[7]=0,t[11]=0,t[12]=0,t[13]=0,t[14]=0,t[15]=1,this}makeRotationFromQuaternion(e){return this.compose(fS,e,hS)}lookAt(e,t,n){const i=this.elements;return I3.subVectors(e,t),I3.lengthSq()===0&&(I3.z=1),I3.normalize(),Y4.crossVectors(n,I3),Y4.lengthSq()===0&&(Math.abs(n.z)===1?I3.x+=1e-4:I3.z+=1e-4,I3.normalize(),Y4.crossVectors(n,I3)),Y4.normalize(),o8.crossVectors(I3,Y4),i[0]=Y4.x,i[4]=o8.x,i[8]=I3.x,i[1]=Y4.y,i[5]=o8.y,i[9]=I3.y,i[2]=Y4.z,i[6]=o8.z,i[10]=I3.z,this}multiply(e){return this.multiplyMatrices(this,e)}premultiply(e){return this.multiplyMatrices(e,this)}multiplyMatrices(e,t){const n=e.elements,i=t.elements,a=this.elements,r=n[0],s=n[4],u=n[8],c=n[12],d=n[1],h=n[5],p=n[9],g=n[13],y=n[2],m=n[6],v=n[10],b=n[14],x=n[3],w=n[7],M=n[11],A=n[15],S=i[0],D=i[4],C=i[8],E=i[12],k=i[1],$=i[5],X=i[9],F=i[13],R=i[2],U=i[6],H=i[10],V=i[14],N=i[3],z=i[7],G=i[11],t1=i[15];return a[0]=r*S+s*k+u*R+c*N,a[4]=r*D+s*$+u*U+c*z,a[8]=r*C+s*X+u*H+c*G,a[12]=r*E+s*F+u*V+c*t1,a[1]=d*S+h*k+p*R+g*N,a[5]=d*D+h*$+p*U+g*z,a[9]=d*C+h*X+p*H+g*G,a[13]=d*E+h*F+p*V+g*t1,a[2]=y*S+m*k+v*R+b*N,a[6]=y*D+m*$+v*U+b*z,a[10]=y*C+m*X+v*H+b*G,a[14]=y*E+m*F+v*V+b*t1,a[3]=x*S+w*k+M*R+A*N,a[7]=x*D+w*$+M*U+A*z,a[11]=x*C+w*X+M*H+A*G,a[15]=x*E+w*F+M*V+A*t1,this}multiplyScalar(e){const t=this.elements;return t[0]*=e,t[4]*=e,t[8]*=e,t[12]*=e,t[1]*=e,t[5]*=e,t[9]*=e,t[13]*=e,t[2]*=e,t[6]*=e,t[10]*=e,t[14]*=e,t[3]*=e,t[7]*=e,t[11]*=e,t[15]*=e,this}determinant(){const e=this.elements,t=e[0],n=e[4],i=e[8],a=e[12],r=e[1],s=e[5],u=e[9],c=e[13],d=e[2],h=e[6],p=e[10],g=e[14],y=e[3],m=e[7],v=e[11],b=e[15];return y*(+a*u*h-i*c*h-a*s*p+n*c*p+i*s*g-n*u*g)+m*(+t*u*g-t*c*p+a*r*p-i*r*g+i*c*d-a*u*d)+v*(+t*c*h-t*s*g-a*r*h+n*r*g+a*s*d-n*c*d)+b*(-i*s*d-t*u*h+t*s*p+i*r*h-n*r*p+n*u*d)}transpose(){const e=this.elements;let t;return t=e[1],e[1]=e[4],e[4]=t,t=e[2],e[2]=e[8],e[8]=t,t=e[6],e[6]=e[9],e[9]=t,t=e[3],e[3]=e[12],e[12]=t,t=e[7],e[7]=e[13],e[13]=t,t=e[11],e[11]=e[14],e[14]=t,this}setPosition(e,t,n){const i=this.elements;return e.isVector3?(i[12]=e.x,i[13]=e.y,i[14]=e.z):(i[12]=e,i[13]=t,i[14]=n),this}invert(){const e=this.elements,t=e[0],n=e[1],i=e[2],a=e[3],r=e[4],s=e[5],u=e[6],c=e[7],d=e[8],h=e[9],p=e[10],g=e[11],y=e[12],m=e[13],v=e[14],b=e[15],x=h*v*c-m*p*c+m*u*g-s*v*g-h*u*b+s*p*b,w=y*p*c-d*v*c-y*u*g+r*v*g+d*u*b-r*p*b,M=d*m*c-y*h*c+y*s*g-r*m*g-d*s*b+r*h*b,A=y*h*u-d*m*u-y*s*p+r*m*p+d*s*v-r*h*v,S=t*x+n*w+i*M+a*A;if(S===0)return this.set(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);const D=1/S;return e[0]=x*D,e[1]=(m*p*a-h*v*a-m*i*g+n*v*g+h*i*b-n*p*b)*D,e[2]=(s*v*a-m*u*a+m*i*c-n*v*c-s*i*b+n*u*b)*D,e[3]=(h*u*a-s*p*a-h*i*c+n*p*c+s*i*g-n*u*g)*D,e[4]=w*D,e[5]=(d*v*a-y*p*a+y*i*g-t*v*g-d*i*b+t*p*b)*D,e[6]=(y*u*a-r*v*a-y*i*c+t*v*c+r*i*b-t*u*b)*D,e[7]=(r*p*a-d*u*a+d*i*c-t*p*c-r*i*g+t*u*g)*D,e[8]=M*D,e[9]=(y*h*a-d*m*a-y*n*g+t*m*g+d*n*b-t*h*b)*D,e[10]=(r*m*a-y*s*a+y*n*c-t*m*c-r*n*b+t*s*b)*D,e[11]=(d*s*a-r*h*a-d*n*c+t*h*c+r*n*g-t*s*g)*D,e[12]=A*D,e[13]=(d*m*i-y*h*i+y*n*p-t*m*p-d*n*v+t*h*v)*D,e[14]=(y*s*i-r*m*i-y*n*u+t*m*u+r*n*v-t*s*v)*D,e[15]=(r*h*i-d*s*i+d*n*u-t*h*u-r*n*p+t*s*p)*D,this}scale(e){const t=this.elements,n=e.x,i=e.y,a=e.z;return t[0]*=n,t[4]*=i,t[8]*=a,t[1]*=n,t[5]*=i,t[9]*=a,t[2]*=n,t[6]*=i,t[10]*=a,t[3]*=n,t[7]*=i,t[11]*=a,this}getMaxScaleOnAxis(){const e=this.elements,t=e[0]*e[0]+e[1]*e[1]+e[2]*e[2],n=e[4]*e[4]+e[5]*e[5]+e[6]*e[6],i=e[8]*e[8]+e[9]*e[9]+e[10]*e[10];return Math.sqrt(Math.max(t,n,i))}makeTranslation(e,t,n){return this.set(1,0,0,e,0,1,0,t,0,0,1,n,0,0,0,1),this}makeRotationX(e){const t=Math.cos(e),n=Math.sin(e);return this.set(1,0,0,0,0,t,-n,0,0,n,t,0,0,0,0,1),this}makeRotationY(e){const t=Math.cos(e),n=Math.sin(e);return this.set(t,0,n,0,0,1,0,0,-n,0,t,0,0,0,0,1),this}makeRotationZ(e){const t=Math.cos(e),n=Math.sin(e);return this.set(t,-n,0,0,n,t,0,0,0,0,1,0,0,0,0,1),this}makeRotationAxis(e,t){const n=Math.cos(t),i=Math.sin(t),a=1-n,r=e.x,s=e.y,u=e.z,c=a*r,d=a*s;return this.set(c*r+n,c*s-i*u,c*u+i*s,0,c*s+i*u,d*s+n,d*u-i*r,0,c*u-i*s,d*u+i*r,a*u*u+n,0,0,0,0,1),this}makeScale(e,t,n){return this.set(e,0,0,0,0,t,0,0,0,0,n,0,0,0,0,1),this}makeShear(e,t,n,i,a,r){return this.set(1,n,a,0,e,1,r,0,t,i,1,0,0,0,0,1),this}compose(e,t,n){const i=this.elements,a=t._x,r=t._y,s=t._z,u=t._w,c=a+a,d=r+r,h=s+s,p=a*c,g=a*d,y=a*h,m=r*d,v=r*h,b=s*h,x=u*c,w=u*d,M=u*h,A=n.x,S=n.y,D=n.z;return i[0]=(1-(m+b))*A,i[1]=(g+M)*A,i[2]=(y-w)*A,i[3]=0,i[4]=(g-M)*S,i[5]=(1-(p+b))*S,i[6]=(v+x)*S,i[7]=0,i[8]=(y+w)*D,i[9]=(v-x)*D,i[10]=(1-(p+m))*D,i[11]=0,i[12]=e.x,i[13]=e.y,i[14]=e.z,i[15]=1,this}decompose(e,t,n){const i=this.elements;let a=i9.set(i[0],i[1],i[2]).length();const r=i9.set(i[4],i[5],i[6]).length(),s=i9.set(i[8],i[9],i[10]).length();this.determinant()<0&&(a=-a),e.x=i[12],e.y=i[13],e.z=i[14],o4.copy(this);const c=1/a,d=1/r,h=1/s;return o4.elements[0]*=c,o4.elements[1]*=c,o4.elements[2]*=c,o4.elements[4]*=d,o4.elements[5]*=d,o4.elements[6]*=d,o4.elements[8]*=h,o4.elements[9]*=h,o4.elements[10]*=h,t.setFromRotationMatrix(o4),n.x=a,n.y=r,n.z=s,this}makePerspective(e,t,n,i,a,r){const s=this.elements,u=2*a/(t-e),c=2*a/(n-i),d=(t+e)/(t-e),h=(n+i)/(n-i),p=-(r+a)/(r-a),g=-2*r*a/(r-a);return s[0]=u,s[4]=0,s[8]=d,s[12]=0,s[1]=0,s[5]=c,s[9]=h,s[13]=0,s[2]=0,s[6]=0,s[10]=p,s[14]=g,s[3]=0,s[7]=0,s[11]=-1,s[15]=0,this}makeOrthographic(e,t,n,i,a,r){const s=this.elements,u=1/(t-e),c=1/(n-i),d=1/(r-a),h=(t+e)*u,p=(n+i)*c,g=(r+a)*d;return s[0]=2*u,s[4]=0,s[8]=0,s[12]=-h,s[1]=0,s[5]=2*c,s[9]=0,s[13]=-p,s[2]=0,s[6]=0,s[10]=-2*d,s[14]=-g,s[3]=0,s[7]=0,s[11]=0,s[15]=1,this}equals(e){const t=this.elements,n=e.elements;for(let i=0;i<16;i++)if(t[i]!==n[i])return!1;return!0}fromArray(e,t=0){for(let n=0;n<16;n++)this.elements[n]=e[n+t];return this}toArray(e=[],t=0){const n=this.elements;return e[t]=n[0],e[t+1]=n[1],e[t+2]=n[2],e[t+3]=n[3],e[t+4]=n[4],e[t+5]=n[5],e[t+6]=n[6],e[t+7]=n[7],e[t+8]=n[8],e[t+9]=n[9],e[t+10]=n[10],e[t+11]=n[11],e[t+12]=n[12],e[t+13]=n[13],e[t+14]=n[14],e[t+15]=n[15],e}}const i9=new Y,o4=new j2,fS=new Y(0,0,0),hS=new Y(1,1,1),Y4=new Y,o8=new Y,I3=new Y,wo=new j2,Co=new k4;class U5{constructor(e=0,t=0,n=0,i=U5.DefaultOrder){this.isEuler=!0,this._x=e,this._y=t,this._z=n,this._order=i}get x(){return this._x}set x(e){this._x=e,this._onChangeCallback()}get y(){return this._y}set y(e){this._y=e,this._onChangeCallback()}get z(){return this._z}set z(e){this._z=e,this._onChangeCallback()}get order(){return this._order}set order(e){this._order=e,this._onChangeCallback()}set(e,t,n,i=this._order){return this._x=e,this._y=t,this._z=n,this._order=i,this._onChangeCallback(),this}clone(){return new this.constructor(this._x,this._y,this._z,this._order)}copy(e){return this._x=e._x,this._y=e._y,this._z=e._z,this._order=e._order,this._onChangeCallback(),this}setFromRotationMatrix(e,t=this._order,n=!0){const i=e.elements,a=i[0],r=i[4],s=i[8],u=i[1],c=i[5],d=i[9],h=i[2],p=i[6],g=i[10];switch(t){case"XYZ":this._y=Math.asin(d3(s,-1,1)),Math.abs(s)<.9999999?(this._x=Math.atan2(-d,g),this._z=Math.atan2(-r,a)):(this._x=Math.atan2(p,c),this._z=0);break;case"YXZ":this._x=Math.asin(-d3(d,-1,1)),Math.abs(d)<.9999999?(this._y=Math.atan2(s,g),this._z=Math.atan2(u,c)):(this._y=Math.atan2(-h,a),this._z=0);break;case"ZXY":this._x=Math.asin(d3(p,-1,1)),Math.abs(p)<.9999999?(this._y=Math.atan2(-h,g),this._z=Math.atan2(-r,c)):(this._y=0,this._z=Math.atan2(u,a));break;case"ZYX":this._y=Math.asin(-d3(h,-1,1)),Math.abs(h)<.9999999?(this._x=Math.atan2(p,g),this._z=Math.atan2(u,a)):(this._x=0,this._z=Math.atan2(-r,c));break;case"YZX":this._z=Math.asin(d3(u,-1,1)),Math.abs(u)<.9999999?(this._x=Math.atan2(-d,c),this._y=Math.atan2(-h,a)):(this._x=0,this._y=Math.atan2(s,g));break;case"XZY":this._z=Math.asin(-d3(r,-1,1)),Math.abs(r)<.9999999?(this._x=Math.atan2(p,c),this._y=Math.atan2(s,a)):(this._x=Math.atan2(-d,g),this._y=0);break;default:console.warn("THREE.Euler: .setFromRotationMatrix() encountered an unknown order: "+t)}return this._order=t,n===!0&&this._onChangeCallback(),this}setFromQuaternion(e,t,n){return wo.makeRotationFromQuaternion(e),this.setFromRotationMatrix(wo,t,n)}setFromVector3(e,t=this._order){return this.set(e.x,e.y,e.z,t)}reorder(e){return Co.setFromEuler(this),this.setFromQuaternion(Co,e)}equals(e){return e._x===this._x&&e._y===this._y&&e._z===this._z&&e._order===this._order}fromArray(e){return this._x=e[0],this._y=e[1],this._z=e[2],e[3]!==void 0&&(this._order=e[3]),this._onChangeCallback(),this}toArray(e=[],t=0){return e[t]=this._x,e[t+1]=this._y,e[t+2]=this._z,e[t+3]=this._order,e}_onChange(e){return this._onChangeCallback=e,this}_onChangeCallback(){}*[Symbol.iterator](){yield this._x,yield this._y,yield this._z,yield this._order}toVector3(){console.error("THREE.Euler: .toVector3() has been removed. Use Vector3.setFromEuler() instead")}}U5.DefaultOrder="XYZ";U5.RotationOrders=["XYZ","YZX","ZXY","XZY","YXZ","ZYX"];class us{constructor(){this.mask=1}set(e){this.mask=(1<<e|0)>>>0}enable(e){this.mask|=1<<e|0}enableAll(){this.mask=-1}toggle(e){this.mask^=1<<e|0}disable(e){this.mask&=~(1<<e|0)}disableAll(){this.mask=0}test(e){return(this.mask&e.mask)!==0}isEnabled(e){return(this.mask&(1<<e|0))!==0}}let pS=0;const To=new Y,o9=new k4,C4=new j2,a8=new Y,t5=new Y,mS=new Y,gS=new k4,Eo=new Y(1,0,0),Do=new Y(0,1,0),Io=new Y(0,0,1),_S={type:"added"},Ro={type:"removed"};class h3 extends H0{constructor(){super(),this.isObject3D=!0,Object.defineProperty(this,"id",{value:pS++}),this.uuid=o0(),this.name="",this.type="Object3D",this.parent=null,this.children=[],this.up=h3.DefaultUp.clone();const e=new Y,t=new U5,n=new k4,i=new Y(1,1,1);function a(){n.setFromEuler(t,!1)}function r(){t.setFromQuaternion(n,void 0,!1)}t._onChange(a),n._onChange(r),Object.defineProperties(this,{position:{configurable:!0,enumerable:!0,value:e},rotation:{configurable:!0,enumerable:!0,value:t},quaternion:{configurable:!0,enumerable:!0,value:n},scale:{configurable:!0,enumerable:!0,value:i},modelViewMatrix:{value:new j2},normalMatrix:{value:new H3}}),this.matrix=new j2,this.matrixWorld=new j2,this.matrixAutoUpdate=h3.DefaultMatrixAutoUpdate,this.matrixWorldNeedsUpdate=!1,this.matrixWorldAutoUpdate=h3.DefaultMatrixWorldAutoUpdate,this.layers=new us,this.visible=!0,this.castShadow=!1,this.receiveShadow=!1,this.frustumCulled=!0,this.renderOrder=0,this.animations=[],this.userData={}}onBeforeRender(){}onAfterRender(){}applyMatrix4(e){this.matrixAutoUpdate&&this.updateMatrix(),this.matrix.premultiply(e),this.matrix.decompose(this.position,this.quaternion,this.scale)}applyQuaternion(e){return this.quaternion.premultiply(e),this}setRotationFromAxisAngle(e,t){this.quaternion.setFromAxisAngle(e,t)}setRotationFromEuler(e){this.quaternion.setFromEuler(e,!0)}setRotationFromMatrix(e){this.quaternion.setFromRotationMatrix(e)}setRotationFromQuaternion(e){this.quaternion.copy(e)}rotateOnAxis(e,t){return o9.setFromAxisAngle(e,t),this.quaternion.multiply(o9),this}rotateOnWorldAxis(e,t){return o9.setFromAxisAngle(e,t),this.quaternion.premultiply(o9),this}rotateX(e){return this.rotateOnAxis(Eo,e)}rotateY(e){return this.rotateOnAxis(Do,e)}rotateZ(e){return this.rotateOnAxis(Io,e)}translateOnAxis(e,t){return To.copy(e).applyQuaternion(this.quaternion),this.position.add(To.multiplyScalar(t)),this}translateX(e){return this.translateOnAxis(Eo,e)}translateY(e){return this.translateOnAxis(Do,e)}translateZ(e){return this.translateOnAxis(Io,e)}localToWorld(e){return e.applyMatrix4(this.matrixWorld)}worldToLocal(e){return e.applyMatrix4(C4.copy(this.matrixWorld).invert())}lookAt(e,t,n){e.isVector3?a8.copy(e):a8.set(e,t,n);const i=this.parent;this.updateWorldMatrix(!0,!1),t5.setFromMatrixPosition(this.matrixWorld),this.isCamera||this.isLight?C4.lookAt(t5,a8,this.up):C4.lookAt(a8,t5,this.up),this.quaternion.setFromRotationMatrix(C4),i&&(C4.extractRotation(i.matrixWorld),o9.setFromRotationMatrix(C4),this.quaternion.premultiply(o9.invert()))}add(e){if(arguments.length>1){for(let t=0;t<arguments.length;t++)this.add(arguments[t]);return this}return e===this?(console.error("THREE.Object3D.add: object can't be added as a child of itself.",e),this):(e&&e.isObject3D?(e.parent!==null&&e.parent.remove(e),e.parent=this,this.children.push(e),e.dispatchEvent(_S)):console.error("THREE.Object3D.add: object not an instance of THREE.Object3D.",e),this)}remove(e){if(arguments.length>1){for(let n=0;n<arguments.length;n++)this.remove(arguments[n]);return this}const t=this.children.indexOf(e);return t!==-1&&(e.parent=null,this.children.splice(t,1),e.dispatchEvent(Ro)),this}removeFromParent(){const e=this.parent;return e!==null&&e.remove(this),this}clear(){for(let e=0;e<this.children.length;e++){const t=this.children[e];t.parent=null,t.dispatchEvent(Ro)}return this.children.length=0,this}attach(e){return this.updateWorldMatrix(!0,!1),C4.copy(this.matrixWorld).invert(),e.parent!==null&&(e.parent.updateWorldMatrix(!0,!1),C4.multiply(e.parent.matrixWorld)),e.applyMatrix4(C4),this.add(e),e.updateWorldMatrix(!1,!0),this}getObjectById(e){return this.getObjectByProperty("id",e)}getObjectByName(e){return this.getObjectByProperty("name",e)}getObjectByProperty(e,t){if(this[e]===t)return this;for(let n=0,i=this.children.length;n<i;n++){const r=this.children[n].getObjectByProperty(e,t);if(r!==void 0)return r}}getWorldPosition(e){return this.updateWorldMatrix(!0,!1),e.setFromMatrixPosition(this.matrixWorld)}getWorldQuaternion(e){return this.updateWorldMatrix(!0,!1),this.matrixWorld.decompose(t5,e,mS),e}getWorldScale(e){return this.updateWorldMatrix(!0,!1),this.matrixWorld.decompose(t5,gS,e),e}getWorldDirection(e){this.updateWorldMatrix(!0,!1);const t=this.matrixWorld.elements;return e.set(t[8],t[9],t[10]).normalize()}raycast(){}traverse(e){e(this);const t=this.children;for(let n=0,i=t.length;n<i;n++)t[n].traverse(e)}traverseVisible(e){if(this.visible===!1)return;e(this);const t=this.children;for(let n=0,i=t.length;n<i;n++)t[n].traverseVisible(e)}traverseAncestors(e){const t=this.parent;t!==null&&(e(t),t.traverseAncestors(e))}updateMatrix(){this.matrix.compose(this.position,this.quaternion,this.scale),this.matrixWorldNeedsUpdate=!0}updateMatrixWorld(e){this.matrixAutoUpdate&&this.updateMatrix(),(this.matrixWorldNeedsUpdate||e)&&(this.parent===null?this.matrixWorld.copy(this.matrix):this.matrixWorld.multiplyMatrices(this.parent.matrixWorld,this.matrix),this.matrixWorldNeedsUpdate=!1,e=!0);const t=this.children;for(let n=0,i=t.length;n<i;n++){const a=t[n];(a.matrixWorldAutoUpdate===!0||e===!0)&&a.updateMatrixWorld(e)}}updateWorldMatrix(e,t){const n=this.parent;if(e===!0&&n!==null&&n.matrixWorldAutoUpdate===!0&&n.updateWorldMatrix(!0,!1),this.matrixAutoUpdate&&this.updateMatrix(),this.parent===null?this.matrixWorld.copy(this.matrix):this.matrixWorld.multiplyMatrices(this.parent.matrixWorld,this.matrix),t===!0){const i=this.children;for(let a=0,r=i.length;a<r;a++){const s=i[a];s.matrixWorldAutoUpdate===!0&&s.updateWorldMatrix(!1,!0)}}}toJSON(e){const t=e===void 0||typeof e=="string",n={};t&&(e={geometries:{},materials:{},textures:{},images:{},shapes:{},skeletons:{},animations:{},nodes:{}},n.metadata={version:4.5,type:"Object",generator:"Object3D.toJSON"});const i={};i.uuid=this.uuid,i.type=this.type,this.name!==""&&(i.name=this.name),this.castShadow===!0&&(i.castShadow=!0),this.receiveShadow===!0&&(i.receiveShadow=!0),this.visible===!1&&(i.visible=!1),this.frustumCulled===!1&&(i.frustumCulled=!1),this.renderOrder!==0&&(i.renderOrder=this.renderOrder),JSON.stringify(this.userData)!=="{}"&&(i.userData=this.userData),i.layers=this.layers.mask,i.matrix=this.matrix.toArray(),this.matrixAutoUpdate===!1&&(i.matrixAutoUpdate=!1),this.isInstancedMesh&&(i.type="InstancedMesh",i.count=this.count,i.instanceMatrix=this.instanceMatrix.toJSON(),this.instanceColor!==null&&(i.instanceColor=this.instanceColor.toJSON()));function a(s,u){return s[u.uuid]===void 0&&(s[u.uuid]=u.toJSON(e)),u.uuid}if(this.isScene)this.background&&(this.background.isColor?i.background=this.background.toJSON():this.background.isTexture&&(i.background=this.background.toJSON(e).uuid)),this.environment&&this.environment.isTexture&&this.environment.isRenderTargetTexture!==!0&&(i.environment=this.environment.toJSON(e).uuid);else if(this.isMesh||this.isLine||this.isPoints){i.geometry=a(e.geometries,this.geometry);const s=this.geometry.parameters;if(s!==void 0&&s.shapes!==void 0){const u=s.shapes;if(Array.isArray(u))for(let c=0,d=u.length;c<d;c++){const h=u[c];a(e.shapes,h)}else a(e.shapes,u)}}if(this.isSkinnedMesh&&(i.bindMode=this.bindMode,i.bindMatrix=this.bindMatrix.toArray(),this.skeleton!==void 0&&(a(e.skeletons,this.skeleton),i.skeleton=this.skeleton.uuid)),this.material!==void 0)if(Array.isArray(this.material)){const s=[];for(let u=0,c=this.material.length;u<c;u++)s.push(a(e.materials,this.material[u]));i.material=s}else i.material=a(e.materials,this.material);if(this.children.length>0){i.children=[];for(let s=0;s<this.children.length;s++)i.children.push(this.children[s].toJSON(e).object)}if(this.animations.length>0){i.animations=[];for(let s=0;s<this.animations.length;s++){const u=this.animations[s];i.animations.push(a(e.animations,u))}}if(t){const s=r(e.geometries),u=r(e.materials),c=r(e.textures),d=r(e.images),h=r(e.shapes),p=r(e.skeletons),g=r(e.animations),y=r(e.nodes);s.length>0&&(n.geometries=s),u.length>0&&(n.materials=u),c.length>0&&(n.textures=c),d.length>0&&(n.images=d),h.length>0&&(n.shapes=h),p.length>0&&(n.skeletons=p),g.length>0&&(n.animations=g),y.length>0&&(n.nodes=y)}return n.object=i,n;function r(s){const u=[];for(const c in s){const d=s[c];delete d.metadata,u.push(d)}return u}}clone(e){return new this.constructor().copy(this,e)}copy(e,t=!0){if(this.name=e.name,this.up.copy(e.up),this.position.copy(e.position),this.rotation.order=e.rotation.order,this.quaternion.copy(e.quaternion),this.scale.copy(e.scale),this.matrix.copy(e.matrix),this.matrixWorld.copy(e.matrixWorld),this.matrixAutoUpdate=e.matrixAutoUpdate,this.matrixWorldNeedsUpdate=e.matrixWorldNeedsUpdate,this.matrixWorldAutoUpdate=e.matrixWorldAutoUpdate,this.layers.mask=e.layers.mask,this.visible=e.visible,this.castShadow=e.castShadow,this.receiveShadow=e.receiveShadow,this.frustumCulled=e.frustumCulled,this.renderOrder=e.renderOrder,this.userData=JSON.parse(JSON.stringify(e.userData)),t===!0)for(let n=0;n<e.children.length;n++){const i=e.children[n];this.add(i.clone())}return this}}h3.DefaultUp=new Y(0,1,0);h3.DefaultMatrixAutoUpdate=!0;h3.DefaultMatrixWorldAutoUpdate=!0;const a4=new Y,T4=new Y,U6=new Y,E4=new Y,a9=new Y,r9=new Y,Oo=new Y,F6=new Y,B6=new Y,G6=new Y;class h4{constructor(e=new Y,t=new Y,n=new Y){this.a=e,this.b=t,this.c=n}static getNormal(e,t,n,i){i.subVectors(n,t),a4.subVectors(e,t),i.cross(a4);const a=i.lengthSq();return a>0?i.multiplyScalar(1/Math.sqrt(a)):i.set(0,0,0)}static getBarycoord(e,t,n,i,a){a4.subVectors(i,t),T4.subVectors(n,t),U6.subVectors(e,t);const r=a4.dot(a4),s=a4.dot(T4),u=a4.dot(U6),c=T4.dot(T4),d=T4.dot(U6),h=r*c-s*s;if(h===0)return a.set(-2,-1,-1);const p=1/h,g=(c*u-s*d)*p,y=(r*d-s*u)*p;return a.set(1-g-y,y,g)}static containsPoint(e,t,n,i){return this.getBarycoord(e,t,n,i,E4),E4.x>=0&&E4.y>=0&&E4.x+E4.y<=1}static getUV(e,t,n,i,a,r,s,u){return this.getBarycoord(e,t,n,i,E4),u.set(0,0),u.addScaledVector(a,E4.x),u.addScaledVector(r,E4.y),u.addScaledVector(s,E4.z),u}static isFrontFacing(e,t,n,i){return a4.subVectors(n,t),T4.subVectors(e,t),a4.cross(T4).dot(i)<0}set(e,t,n){return this.a.copy(e),this.b.copy(t),this.c.copy(n),this}setFromPointsAndIndices(e,t,n,i){return this.a.copy(e[t]),this.b.copy(e[n]),this.c.copy(e[i]),this}setFromAttributeAndIndices(e,t,n,i){return this.a.fromBufferAttribute(e,t),this.b.fromBufferAttribute(e,n),this.c.fromBufferAttribute(e,i),this}clone(){return new this.constructor().copy(this)}copy(e){return this.a.copy(e.a),this.b.copy(e.b),this.c.copy(e.c),this}getArea(){return a4.subVectors(this.c,this.b),T4.subVectors(this.a,this.b),a4.cross(T4).length()*.5}getMidpoint(e){return e.addVectors(this.a,this.b).add(this.c).multiplyScalar(1/3)}getNormal(e){return h4.getNormal(this.a,this.b,this.c,e)}getPlane(e){return e.setFromCoplanarPoints(this.a,this.b,this.c)}getBarycoord(e,t){return h4.getBarycoord(e,this.a,this.b,this.c,t)}getUV(e,t,n,i,a){return h4.getUV(e,this.a,this.b,this.c,t,n,i,a)}containsPoint(e){return h4.containsPoint(e,this.a,this.b,this.c)}isFrontFacing(e){return h4.isFrontFacing(this.a,this.b,this.c,e)}intersectsBox(e){return e.intersectsTriangle(this)}closestPointToPoint(e,t){const n=this.a,i=this.b,a=this.c;let r,s;a9.subVectors(i,n),r9.subVectors(a,n),F6.subVectors(e,n);const u=a9.dot(F6),c=r9.dot(F6);if(u<=0&&c<=0)return t.copy(n);B6.subVectors(e,i);const d=a9.dot(B6),h=r9.dot(B6);if(d>=0&&h<=d)return t.copy(i);const p=u*h-d*c;if(p<=0&&u>=0&&d<=0)return r=u/(u-d),t.copy(n).addScaledVector(a9,r);G6.subVectors(e,a);const g=a9.dot(G6),y=r9.dot(G6);if(y>=0&&g<=y)return t.copy(a);const m=g*c-u*y;if(m<=0&&c>=0&&y<=0)return s=c/(c-y),t.copy(n).addScaledVector(r9,s);const v=d*y-g*h;if(v<=0&&h-d>=0&&g-y>=0)return Oo.subVectors(a,i),s=(h-d)/(h-d+(g-y)),t.copy(i).addScaledVector(Oo,s);const b=1/(v+m+p);return r=m*b,s=p*b,t.copy(n).addScaledVector(a9,r).addScaledVector(r9,s)}equals(e){return e.a.equals(this.a)&&e.b.equals(this.b)&&e.c.equals(this.c)}}let vS=0;class Y0 extends H0{constructor(){super(),this.isMaterial=!0,Object.defineProperty(this,"id",{value:vS++}),this.uuid=o0(),this.name="",this.type="Material",this.blending=O0,this.side=z9,this.vertexColors=!1,this.opacity=1,this.transparent=!1,this.blendSrc=Kr,this.blendDst=es,this.blendEquation=b9,this.blendSrcAlpha=null,this.blendDstAlpha=null,this.blendEquationAlpha=null,this.depthFunc=me,this.depthTest=!0,this.depthWrite=!0,this.stencilWriteMask=255,this.stencilFunc=sS,this.stencilRef=0,this.stencilFuncMask=255,this.stencilFail=w6,this.stencilZFail=w6,this.stencilZPass=w6,this.stencilWrite=!1,this.clippingPlanes=null,this.clipIntersection=!1,this.clipShadows=!1,this.shadowSide=null,this.colorWrite=!0,this.precision=null,this.polygonOffset=!1,this.polygonOffsetFactor=0,this.polygonOffsetUnits=0,this.dithering=!1,this.alphaToCoverage=!1,this.premultipliedAlpha=!1,this.visible=!0,this.toneMapped=!0,this.userData={},this.version=0,this._alphaTest=0}get alphaTest(){return this._alphaTest}set alphaTest(e){this._alphaTest>0!=e>0&&this.version++,this._alphaTest=e}onBuild(){}onBeforeRender(){}onBeforeCompile(){}customProgramCacheKey(){return this.onBeforeCompile.toString()}setValues(e){if(e!==void 0)for(const t in e){const n=e[t];if(n===void 0){console.warn("THREE.Material: '"+t+"' parameter is undefined.");continue}const i=this[t];if(i===void 0){console.warn("THREE."+this.type+": '"+t+"' is not a property of this material.");continue}i&&i.isColor?i.set(n):i&&i.isVector3&&n&&n.isVector3?i.copy(n):this[t]=n}}toJSON(e){const t=e===void 0||typeof e=="string";t&&(e={textures:{},images:{}});const n={metadata:{version:4.5,type:"Material",generator:"Material.toJSON"}};n.uuid=this.uuid,n.type=this.type,this.name!==""&&(n.name=this.name),this.color&&this.color.isColor&&(n.color=this.color.getHex()),this.roughness!==void 0&&(n.roughness=this.roughness),this.metalness!==void 0&&(n.metalness=this.metalness),this.sheen!==void 0&&(n.sheen=this.sheen),this.sheenColor&&this.sheenColor.isColor&&(n.sheenColor=this.sheenColor.getHex()),this.sheenRoughness!==void 0&&(n.sheenRoughness=this.sheenRoughness),this.emissive&&this.emissive.isColor&&(n.emissive=this.emissive.getHex()),this.emissiveIntensity&&this.emissiveIntensity!==1&&(n.emissiveIntensity=this.emissiveIntensity),this.specular&&this.specular.isColor&&(n.specular=this.specular.getHex()),this.specularIntensity!==void 0&&(n.specularIntensity=this.specularIntensity),this.specularColor&&this.specularColor.isColor&&(n.specularColor=this.specularColor.getHex()),this.shininess!==void 0&&(n.shininess=this.shininess),this.clearcoat!==void 0&&(n.clearcoat=this.clearcoat),this.clearcoatRoughness!==void 0&&(n.clearcoatRoughness=this.clearcoatRoughness),this.clearcoatMap&&this.clearcoatMap.isTexture&&(n.clearcoatMap=this.clearcoatMap.toJSON(e).uuid),this.clearcoatRoughnessMap&&this.clearcoatRoughnessMap.isTexture&&(n.clearcoatRoughnessMap=this.clearcoatRoughnessMap.toJSON(e).uuid),this.clearcoatNormalMap&&this.clearcoatNormalMap.isTexture&&(n.clearcoatNormalMap=this.clearcoatNormalMap.toJSON(e).uuid,n.clearcoatNormalScale=this.clearcoatNormalScale.toArray()),this.iridescence!==void 0&&(n.iridescence=this.iridescence),this.iridescenceIOR!==void 0&&(n.iridescenceIOR=this.iridescenceIOR),this.iridescenceThicknessRange!==void 0&&(n.iridescenceThicknessRange=this.iridescenceThicknessRange),this.iridescenceMap&&this.iridescenceMap.isTexture&&(n.iridescenceMap=this.iridescenceMap.toJSON(e).uuid),this.iridescenceThicknessMap&&this.iridescenceThicknessMap.isTexture&&(n.iridescenceThicknessMap=this.iridescenceThicknessMap.toJSON(e).uuid),this.map&&this.map.isTexture&&(n.map=this.map.toJSON(e).uuid),this.matcap&&this.matcap.isTexture&&(n.matcap=this.matcap.toJSON(e).uuid),this.alphaMap&&this.alphaMap.isTexture&&(n.alphaMap=this.alphaMap.toJSON(e).uuid),this.lightMap&&this.lightMap.isTexture&&(n.lightMap=this.lightMap.toJSON(e).uuid,n.lightMapIntensity=this.lightMapIntensity),this.aoMap&&this.aoMap.isTexture&&(n.aoMap=this.aoMap.toJSON(e).uuid,n.aoMapIntensity=this.aoMapIntensity),this.bumpMap&&this.bumpMap.isTexture&&(n.bumpMap=this.bumpMap.toJSON(e).uuid,n.bumpScale=this.bumpScale),this.normalMap&&this.normalMap.isTexture&&(n.normalMap=this.normalMap.toJSON(e).uuid,n.normalMapType=this.normalMapType,n.normalScale=this.normalScale.toArray()),this.displacementMap&&this.displacementMap.isTexture&&(n.displacementMap=this.displacementMap.toJSON(e).uuid,n.displacementScale=this.displacementScale,n.displacementBias=this.displacementBias),this.roughnessMap&&this.roughnessMap.isTexture&&(n.roughnessMap=this.roughnessMap.toJSON(e).uuid),this.metalnessMap&&this.metalnessMap.isTexture&&(n.metalnessMap=this.metalnessMap.toJSON(e).uuid),this.emissiveMap&&this.emissiveMap.isTexture&&(n.emissiveMap=this.emissiveMap.toJSON(e).uuid),this.specularMap&&this.specularMap.isTexture&&(n.specularMap=this.specularMap.toJSON(e).uuid),this.specularIntensityMap&&this.specularIntensityMap.isTexture&&(n.specularIntensityMap=this.specularIntensityMap.toJSON(e).uuid),this.specularColorMap&&this.specularColorMap.isTexture&&(n.specularColorMap=this.specularColorMap.toJSON(e).uuid),this.envMap&&this.envMap.isTexture&&(n.envMap=this.envMap.toJSON(e).uuid,this.combine!==void 0&&(n.combine=this.combine)),this.envMapIntensity!==void 0&&(n.envMapIntensity=this.envMapIntensity),this.reflectivity!==void 0&&(n.reflectivity=this.reflectivity),this.refractionRatio!==void 0&&(n.refractionRatio=this.refractionRatio),this.gradientMap&&this.gradientMap.isTexture&&(n.gradientMap=this.gradientMap.toJSON(e).uuid),this.transmission!==void 0&&(n.transmission=this.transmission),this.transmissionMap&&this.transmissionMap.isTexture&&(n.transmissionMap=this.transmissionMap.toJSON(e).uuid),this.thickness!==void 0&&(n.thickness=this.thickness),this.thicknessMap&&this.thicknessMap.isTexture&&(n.thicknessMap=this.thicknessMap.toJSON(e).uuid),this.attenuationDistance!==void 0&&(n.attenuationDistance=this.attenuationDistance),this.attenuationColor!==void 0&&(n.attenuationColor=this.attenuationColor.getHex()),this.size!==void 0&&(n.size=this.size),this.shadowSide!==null&&(n.shadowSide=this.shadowSide),this.sizeAttenuation!==void 0&&(n.sizeAttenuation=this.sizeAttenuation),this.blending!==O0&&(n.blending=this.blending),this.side!==z9&&(n.side=this.side),this.vertexColors&&(n.vertexColors=!0),this.opacity<1&&(n.opacity=this.opacity),this.transparent===!0&&(n.transparent=this.transparent),n.depthFunc=this.depthFunc,n.depthTest=this.depthTest,n.depthWrite=this.depthWrite,n.colorWrite=this.colorWrite,n.stencilWrite=this.stencilWrite,n.stencilWriteMask=this.stencilWriteMask,n.stencilFunc=this.stencilFunc,n.stencilRef=this.stencilRef,n.stencilFuncMask=this.stencilFuncMask,n.stencilFail=this.stencilFail,n.stencilZFail=this.stencilZFail,n.stencilZPass=this.stencilZPass,this.rotation!==void 0&&this.rotation!==0&&(n.rotation=this.rotation),this.polygonOffset===!0&&(n.polygonOffset=!0),this.polygonOffsetFactor!==0&&(n.polygonOffsetFactor=this.polygonOffsetFactor),this.polygonOffsetUnits!==0&&(n.polygonOffsetUnits=this.polygonOffsetUnits),this.linewidth!==void 0&&this.linewidth!==1&&(n.linewidth=this.linewidth),this.dashSize!==void 0&&(n.dashSize=this.dashSize),this.gapSize!==void 0&&(n.gapSize=this.gapSize),this.scale!==void 0&&(n.scale=this.scale),this.dithering===!0&&(n.dithering=!0),this.alphaTest>0&&(n.alphaTest=this.alphaTest),this.alphaToCoverage===!0&&(n.alphaToCoverage=this.alphaToCoverage),this.premultipliedAlpha===!0&&(n.premultipliedAlpha=this.premultipliedAlpha),this.wireframe===!0&&(n.wireframe=this.wireframe),this.wireframeLinewidth>1&&(n.wireframeLinewidth=this.wireframeLinewidth),this.wireframeLinecap!=="round"&&(n.wireframeLinecap=this.wireframeLinecap),this.wireframeLinejoin!=="round"&&(n.wireframeLinejoin=this.wireframeLinejoin),this.flatShading===!0&&(n.flatShading=this.flatShading),this.visible===!1&&(n.visible=!1),this.toneMapped===!1&&(n.toneMapped=!1),this.fog===!1&&(n.fog=!1),JSON.stringify(this.userData)!=="{}"&&(n.userData=this.userData);function i(a){const r=[];for(const s in a){const u=a[s];delete u.metadata,r.push(u)}return r}if(t){const a=i(e.textures),r=i(e.images);a.length>0&&(n.textures=a),r.length>0&&(n.images=r)}return n}clone(){return new this.constructor().copy(this)}copy(e){this.name=e.name,this.blending=e.blending,this.side=e.side,this.vertexColors=e.vertexColors,this.opacity=e.opacity,this.transparent=e.transparent,this.blendSrc=e.blendSrc,this.blendDst=e.blendDst,this.blendEquation=e.blendEquation,this.blendSrcAlpha=e.blendSrcAlpha,this.blendDstAlpha=e.blendDstAlpha,this.blendEquationAlpha=e.blendEquationAlpha,this.depthFunc=e.depthFunc,this.depthTest=e.depthTest,this.depthWrite=e.depthWrite,this.stencilWriteMask=e.stencilWriteMask,this.stencilFunc=e.stencilFunc,this.stencilRef=e.stencilRef,this.stencilFuncMask=e.stencilFuncMask,this.stencilFail=e.stencilFail,this.stencilZFail=e.stencilZFail,this.stencilZPass=e.stencilZPass,this.stencilWrite=e.stencilWrite;const t=e.clippingPlanes;let n=null;if(t!==null){const i=t.length;n=new Array(i);for(let a=0;a!==i;++a)n[a]=t[a].clone()}return this.clippingPlanes=n,this.clipIntersection=e.clipIntersection,this.clipShadows=e.clipShadows,this.shadowSide=e.shadowSide,this.colorWrite=e.colorWrite,this.precision=e.precision,this.polygonOffset=e.polygonOffset,this.polygonOffsetFactor=e.polygonOffsetFactor,this.polygonOffsetUnits=e.polygonOffsetUnits,this.dithering=e.dithering,this.alphaTest=e.alphaTest,this.alphaToCoverage=e.alphaToCoverage,this.premultipliedAlpha=e.premultipliedAlpha,this.visible=e.visible,this.toneMapped=e.toneMapped,this.userData=JSON.parse(JSON.stringify(e.userData)),this}dispose(){this.dispatchEvent({type:"dispose"})}set needsUpdate(e){e===!0&&this.version++}}class O4 extends Y0{constructor(e){super(),this.isMeshBasicMaterial=!0,this.type="MeshBasicMaterial",this.color=new _2(16777215),this.map=null,this.lightMap=null,this.lightMapIntensity=1,this.aoMap=null,this.aoMapIntensity=1,this.specularMap=null,this.alphaMap=null,this.envMap=null,this.combine=ts,this.reflectivity=1,this.refractionRatio=.98,this.wireframe=!1,this.wireframeLinewidth=1,this.wireframeLinecap="round",this.wireframeLinejoin="round",this.fog=!0,this.setValues(e)}copy(e){return super.copy(e),this.color.copy(e.color),this.map=e.map,this.lightMap=e.lightMap,this.lightMapIntensity=e.lightMapIntensity,this.aoMap=e.aoMap,this.aoMapIntensity=e.aoMapIntensity,this.specularMap=e.specularMap,this.alphaMap=e.alphaMap,this.envMap=e.envMap,this.combine=e.combine,this.reflectivity=e.reflectivity,this.refractionRatio=e.refractionRatio,this.wireframe=e.wireframe,this.wireframeLinewidth=e.wireframeLinewidth,this.wireframeLinecap=e.wireframeLinecap,this.wireframeLinejoin=e.wireframeLinejoin,this.fog=e.fog,this}}const H2=new Y,r8=new G1;class z3{constructor(e,t,n){if(Array.isArray(e))throw new TypeError("THREE.BufferAttribute: array should be a Typed Array.");this.isBufferAttribute=!0,this.name="",this.array=e,this.itemSize=t,this.count=e!==void 0?e.length/t:0,this.normalized=n===!0,this.usage=be,this.updateRange={offset:0,count:-1},this.version=0}onUploadCallback(){}set needsUpdate(e){e===!0&&this.version++}setUsage(e){return this.usage=e,this}copy(e){return this.name=e.name,this.array=new e.array.constructor(e.array),this.itemSize=e.itemSize,this.count=e.count,this.normalized=e.normalized,this.usage=e.usage,this}copyAt(e,t,n){e*=this.itemSize,n*=t.itemSize;for(let i=0,a=this.itemSize;i<a;i++)this.array[e+i]=t.array[n+i];return this}copyArray(e){return this.array.set(e),this}applyMatrix3(e){if(this.itemSize===2)for(let t=0,n=this.count;t<n;t++)r8.fromBufferAttribute(this,t),r8.applyMatrix3(e),this.setXY(t,r8.x,r8.y);else if(this.itemSize===3)for(let t=0,n=this.count;t<n;t++)H2.fromBufferAttribute(this,t),H2.applyMatrix3(e),this.setXYZ(t,H2.x,H2.y,H2.z);return this}applyMatrix4(e){for(let t=0,n=this.count;t<n;t++)H2.fromBufferAttribute(this,t),H2.applyMatrix4(e),this.setXYZ(t,H2.x,H2.y,H2.z);return this}applyNormalMatrix(e){for(let t=0,n=this.count;t<n;t++)H2.fromBufferAttribute(this,t),H2.applyNormalMatrix(e),this.setXYZ(t,H2.x,H2.y,H2.z);return this}transformDirection(e){for(let t=0,n=this.count;t<n;t++)H2.fromBufferAttribute(this,t),H2.transformDirection(e),this.setXYZ(t,H2.x,H2.y,H2.z);return this}set(e,t=0){return this.array.set(e,t),this}getX(e){let t=this.array[e*this.itemSize];return this.normalized&&(t=K4(t,this.array)),t}setX(e,t){return this.normalized&&(t=C2(t,this.array)),this.array[e*this.itemSize]=t,this}getY(e){let t=this.array[e*this.itemSize+1];return this.normalized&&(t=K4(t,this.array)),t}setY(e,t){return this.normalized&&(t=C2(t,this.array)),this.array[e*this.itemSize+1]=t,this}getZ(e){let t=this.array[e*this.itemSize+2];return this.normalized&&(t=K4(t,this.array)),t}setZ(e,t){return this.normalized&&(t=C2(t,this.array)),this.array[e*this.itemSize+2]=t,this}getW(e){let t=this.array[e*this.itemSize+3];return this.normalized&&(t=K4(t,this.array)),t}setW(e,t){return this.normalized&&(t=C2(t,this.array)),this.array[e*this.itemSize+3]=t,this}setXY(e,t,n){return e*=this.itemSize,this.normalized&&(t=C2(t,this.array),n=C2(n,this.array)),this.array[e+0]=t,this.array[e+1]=n,this}setXYZ(e,t,n,i){return e*=this.itemSize,this.normalized&&(t=C2(t,this.array),n=C2(n,this.array),i=C2(i,this.array)),this.array[e+0]=t,this.array[e+1]=n,this.array[e+2]=i,this}setXYZW(e,t,n,i,a){return e*=this.itemSize,this.normalized&&(t=C2(t,this.array),n=C2(n,this.array),i=C2(i,this.array),a=C2(a,this.array)),this.array[e+0]=t,this.array[e+1]=n,this.array[e+2]=i,this.array[e+3]=a,this}onUpload(e){return this.onUploadCallback=e,this}clone(){return new this.constructor(this.array,this.itemSize).copy(this)}toJSON(){const e={itemSize:this.itemSize,type:this.array.constructor.name,array:Array.from(this.array),normalized:this.normalized};return this.name!==""&&(e.name=this.name),this.usage!==be&&(e.usage=this.usage),(this.updateRange.offset!==0||this.updateRange.count!==-1)&&(e.updateRange=this.updateRange),e}copyColorsArray(){console.error("THREE.BufferAttribute: copyColorsArray() was removed in r144.")}copyVector2sArray(){console.error("THREE.BufferAttribute: copyVector2sArray() was removed in r144.")}copyVector3sArray(){console.error("THREE.BufferAttribute: copyVector3sArray() was removed in r144.")}copyVector4sArray(){console.error("THREE.BufferAttribute: copyVector4sArray() was removed in r144.")}}class cs extends z3{constructor(e,t,n){super(new Uint16Array(e),t,n)}}class ds extends z3{constructor(e,t,n){super(new Uint32Array(e),t,n)}}class M3 extends z3{constructor(e,t,n){super(new Float32Array(e),t,n)}}let yS=0;const B3=new j2,V6=new h3,s9=new Y,R3=new k5,n5=new k5,n3=new Y;class E3 extends H0{constructor(){super(),this.isBufferGeometry=!0,Object.defineProperty(this,"id",{value:yS++}),this.uuid=o0(),this.name="",this.type="BufferGeometry",this.index=null,this.attributes={},this.morphAttributes={},this.morphTargetsRelative=!1,this.groups=[],this.boundingBox=null,this.boundingSphere=null,this.drawRange={start:0,count:1/0},this.userData={}}getIndex(){return this.index}setIndex(e){return Array.isArray(e)?this.index=new(os(e)?ds:cs)(e,1):this.index=e,this}getAttribute(e){return this.attributes[e]}setAttribute(e,t){return this.attributes[e]=t,this}deleteAttribute(e){return delete this.attributes[e],this}hasAttribute(e){return this.attributes[e]!==void 0}addGroup(e,t,n=0){this.groups.push({start:e,count:t,materialIndex:n})}clearGroups(){this.groups=[]}setDrawRange(e,t){this.drawRange.start=e,this.drawRange.count=t}applyMatrix4(e){const t=this.attributes.position;t!==void 0&&(t.applyMatrix4(e),t.needsUpdate=!0);const n=this.attributes.normal;if(n!==void 0){const a=new H3().getNormalMatrix(e);n.applyNormalMatrix(a),n.needsUpdate=!0}const i=this.attributes.tangent;return i!==void 0&&(i.transformDirection(e),i.needsUpdate=!0),this.boundingBox!==null&&this.computeBoundingBox(),this.boundingSphere!==null&&this.computeBoundingSphere(),this}applyQuaternion(e){return B3.makeRotationFromQuaternion(e),this.applyMatrix4(B3),this}rotateX(e){return B3.makeRotationX(e),this.applyMatrix4(B3),this}rotateY(e){return B3.makeRotationY(e),this.applyMatrix4(B3),this}rotateZ(e){return B3.makeRotationZ(e),this.applyMatrix4(B3),this}translate(e,t,n){return B3.makeTranslation(e,t,n),this.applyMatrix4(B3),this}scale(e,t,n){return B3.makeScale(e,t,n),this.applyMatrix4(B3),this}lookAt(e){return V6.lookAt(e),V6.updateMatrix(),this.applyMatrix4(V6.matrix),this}center(){return this.computeBoundingBox(),this.boundingBox.getCenter(s9).negate(),this.translate(s9.x,s9.y,s9.z),this}setFromPoints(e){const t=[];for(let n=0,i=e.length;n<i;n++){const a=e[n];t.push(a.x,a.y,a.z||0)}return this.setAttribute("position",new M3(t,3)),this}computeBoundingBox(){this.boundingBox===null&&(this.boundingBox=new k5);const e=this.attributes.position,t=this.morphAttributes.position;if(e&&e.isGLBufferAttribute){console.error('THREE.BufferGeometry.computeBoundingBox(): GLBufferAttribute requires a manual bounding box. Alternatively set "mesh.frustumCulled" to "false".',this),this.boundingBox.set(new Y(-1/0,-1/0,-1/0),new Y(1/0,1/0,1/0));return}if(e!==void 0){if(this.boundingBox.setFromBufferAttribute(e),t)for(let n=0,i=t.length;n<i;n++){const a=t[n];R3.setFromBufferAttribute(a),this.morphTargetsRelative?(n3.addVectors(this.boundingBox.min,R3.min),this.boundingBox.expandByPoint(n3),n3.addVectors(this.boundingBox.max,R3.max),this.boundingBox.expandByPoint(n3)):(this.boundingBox.expandByPoint(R3.min),this.boundingBox.expandByPoint(R3.max))}}else this.boundingBox.makeEmpty();(isNaN(this.boundingBox.min.x)||isNaN(this.boundingBox.min.y)||isNaN(this.boundingBox.min.z))&&console.error('THREE.BufferGeometry.computeBoundingBox(): Computed min/max have NaN values. The "position" attribute is likely to have NaN values.',this)}computeBoundingSphere(){this.boundingSphere===null&&(this.boundingSphere=new N5);const e=this.attributes.position,t=this.morphAttributes.position;if(e&&e.isGLBufferAttribute){console.error('THREE.BufferGeometry.computeBoundingSphere(): GLBufferAttribute requires a manual bounding sphere. Alternatively set "mesh.frustumCulled" to "false".',this),this.boundingSphere.set(new Y,1/0);return}if(e){const n=this.boundingSphere.center;if(R3.setFromBufferAttribute(e),t)for(let a=0,r=t.length;a<r;a++){const s=t[a];n5.setFromBufferAttribute(s),this.morphTargetsRelative?(n3.addVectors(R3.min,n5.min),R3.expandByPoint(n3),n3.addVectors(R3.max,n5.max),R3.expandByPoint(n3)):(R3.expandByPoint(n5.min),R3.expandByPoint(n5.max))}R3.getCenter(n);let i=0;for(let a=0,r=e.count;a<r;a++)n3.fromBufferAttribute(e,a),i=Math.max(i,n.distanceToSquared(n3));if(t)for(let a=0,r=t.length;a<r;a++){const s=t[a],u=this.morphTargetsRelative;for(let c=0,d=s.count;c<d;c++)n3.fromBufferAttribute(s,c),u&&(s9.fromBufferAttribute(e,c),n3.add(s9)),i=Math.max(i,n.distanceToSquared(n3))}this.boundingSphere.radius=Math.sqrt(i),isNaN(this.boundingSphere.radius)&&console.error('THREE.BufferGeometry.computeBoundingSphere(): Computed radius is NaN. The "position" attribute is likely to have NaN values.',this)}}computeTangents(){const e=this.index,t=this.attributes;if(e===null||t.position===void 0||t.normal===void 0||t.uv===void 0){console.error("THREE.BufferGeometry: .computeTangents() failed. Missing required attributes (index, position, normal or uv)");return}const n=e.array,i=t.position.array,a=t.normal.array,r=t.uv.array,s=i.length/3;this.hasAttribute("tangent")===!1&&this.setAttribute("tangent",new z3(new Float32Array(4*s),4));const u=this.getAttribute("tangent").array,c=[],d=[];for(let k=0;k<s;k++)c[k]=new Y,d[k]=new Y;const h=new Y,p=new Y,g=new Y,y=new G1,m=new G1,v=new G1,b=new Y,x=new Y;function w(k,$,X){h.fromArray(i,k*3),p.fromArray(i,$*3),g.fromArray(i,X*3),y.fromArray(r,k*2),m.fromArray(r,$*2),v.fromArray(r,X*2),p.sub(h),g.sub(h),m.sub(y),v.sub(y);const F=1/(m.x*v.y-v.x*m.y);isFinite(F)&&(b.copy(p).multiplyScalar(v.y).addScaledVector(g,-m.y).multiplyScalar(F),x.copy(g).multiplyScalar(m.x).addScaledVector(p,-v.x).multiplyScalar(F),c[k].add(b),c[$].add(b),c[X].add(b),d[k].add(x),d[$].add(x),d[X].add(x))}let M=this.groups;M.length===0&&(M=[{start:0,count:n.length}]);for(let k=0,$=M.length;k<$;++k){const X=M[k],F=X.start,R=X.count;for(let U=F,H=F+R;U<H;U+=3)w(n[U+0],n[U+1],n[U+2])}const A=new Y,S=new Y,D=new Y,C=new Y;function E(k){D.fromArray(a,k*3),C.copy(D);const $=c[k];A.copy($),A.sub(D.multiplyScalar(D.dot($))).normalize(),S.crossVectors(C,$);const F=S.dot(d[k])<0?-1:1;u[k*4]=A.x,u[k*4+1]=A.y,u[k*4+2]=A.z,u[k*4+3]=F}for(let k=0,$=M.length;k<$;++k){const X=M[k],F=X.start,R=X.count;for(let U=F,H=F+R;U<H;U+=3)E(n[U+0]),E(n[U+1]),E(n[U+2])}}computeVertexNormals(){const e=this.index,t=this.getAttribute("position");if(t!==void 0){let n=this.getAttribute("normal");if(n===void 0)n=new z3(new Float32Array(t.count*3),3),this.setAttribute("normal",n);else for(let p=0,g=n.count;p<g;p++)n.setXYZ(p,0,0,0);const i=new Y,a=new Y,r=new Y,s=new Y,u=new Y,c=new Y,d=new Y,h=new Y;if(e)for(let p=0,g=e.count;p<g;p+=3){const y=e.getX(p+0),m=e.getX(p+1),v=e.getX(p+2);i.fromBufferAttribute(t,y),a.fromBufferAttribute(t,m),r.fromBufferAttribute(t,v),d.subVectors(r,a),h.subVectors(i,a),d.cross(h),s.fromBufferAttribute(n,y),u.fromBufferAttribute(n,m),c.fromBufferAttribute(n,v),s.add(d),u.add(d),c.add(d),n.setXYZ(y,s.x,s.y,s.z),n.setXYZ(m,u.x,u.y,u.z),n.setXYZ(v,c.x,c.y,c.z)}else for(let p=0,g=t.count;p<g;p+=3)i.fromBufferAttribute(t,p+0),a.fromBufferAttribute(t,p+1),r.fromBufferAttribute(t,p+2),d.subVectors(r,a),h.subVectors(i,a),d.cross(h),n.setXYZ(p+0,d.x,d.y,d.z),n.setXYZ(p+1,d.x,d.y,d.z),n.setXYZ(p+2,d.x,d.y,d.z);this.normalizeNormals(),n.needsUpdate=!0}}merge(){return console.error("THREE.BufferGeometry.merge() has been removed. Use THREE.BufferGeometryUtils.mergeBufferGeometries() instead."),this}normalizeNormals(){const e=this.attributes.normal;for(let t=0,n=e.count;t<n;t++)n3.fromBufferAttribute(e,t),n3.normalize(),e.setXYZ(t,n3.x,n3.y,n3.z)}toNonIndexed(){function e(s,u){const c=s.array,d=s.itemSize,h=s.normalized,p=new c.constructor(u.length*d);let g=0,y=0;for(let m=0,v=u.length;m<v;m++){s.isInterleavedBufferAttribute?g=u[m]*s.data.stride+s.offset:g=u[m]*d;for(let b=0;b<d;b++)p[y++]=c[g++]}return new z3(p,d,h)}if(this.index===null)return console.warn("THREE.BufferGeometry.toNonIndexed(): BufferGeometry is already non-indexed."),this;const t=new E3,n=this.index.array,i=this.attributes;for(const s in i){const u=i[s],c=e(u,n);t.setAttribute(s,c)}const a=this.morphAttributes;for(const s in a){const u=[],c=a[s];for(let d=0,h=c.length;d<h;d++){const p=c[d],g=e(p,n);u.push(g)}t.morphAttributes[s]=u}t.morphTargetsRelative=this.morphTargetsRelative;const r=this.groups;for(let s=0,u=r.length;s<u;s++){const c=r[s];t.addGroup(c.start,c.count,c.materialIndex)}return t}toJSON(){const e={metadata:{version:4.5,type:"BufferGeometry",generator:"BufferGeometry.toJSON"}};if(e.uuid=this.uuid,e.type=this.type,this.name!==""&&(e.name=this.name),Object.keys(this.userData).length>0&&(e.userData=this.userData),this.parameters!==void 0){const u=this.parameters;for(const c in u)u[c]!==void 0&&(e[c]=u[c]);return e}e.data={attributes:{}};const t=this.index;t!==null&&(e.data.index={type:t.array.constructor.name,array:Array.prototype.slice.call(t.array)});const n=this.attributes;for(const u in n){const c=n[u];e.data.attributes[u]=c.toJSON(e.data)}const i={};let a=!1;for(const u in this.morphAttributes){const c=this.morphAttributes[u],d=[];for(let h=0,p=c.length;h<p;h++){const g=c[h];d.push(g.toJSON(e.data))}d.length>0&&(i[u]=d,a=!0)}a&&(e.data.morphAttributes=i,e.data.morphTargetsRelative=this.morphTargetsRelative);const r=this.groups;r.length>0&&(e.data.groups=JSON.parse(JSON.stringify(r)));const s=this.boundingSphere;return s!==null&&(e.data.boundingSphere={center:s.center.toArray(),radius:s.radius}),e}clone(){return new this.constructor().copy(this)}copy(e){this.index=null,this.attributes={},this.morphAttributes={},this.groups=[],this.boundingBox=null,this.boundingSphere=null;const t={};this.name=e.name;const n=e.index;n!==null&&this.setIndex(n.clone(t));const i=e.attributes;for(const c in i){const d=i[c];this.setAttribute(c,d.clone(t))}const a=e.morphAttributes;for(const c in a){const d=[],h=a[c];for(let p=0,g=h.length;p<g;p++)d.push(h[p].clone(t));this.morphAttributes[c]=d}this.morphTargetsRelative=e.morphTargetsRelative;const r=e.groups;for(let c=0,d=r.length;c<d;c++){const h=r[c];this.addGroup(h.start,h.count,h.materialIndex)}const s=e.boundingBox;s!==null&&(this.boundingBox=s.clone());const u=e.boundingSphere;return u!==null&&(this.boundingSphere=u.clone()),this.drawRange.start=e.drawRange.start,this.drawRange.count=e.drawRange.count,this.userData=e.userData,e.parameters!==void 0&&(this.parameters=Object.assign({},e.parameters)),this}dispose(){this.dispatchEvent({type:"dispose"})}}const Po=new j2,l9=new qt,j6=new N5,$4=new Y,J4=new Y,Z4=new Y,W6=new Y,H6=new Y,Y6=new Y,s8=new Y,l8=new Y,u8=new Y,c8=new G1,d8=new G1,f8=new G1,$6=new Y,h8=new Y;class s3 extends h3{constructor(e=new E3,t=new O4){super(),this.isMesh=!0,this.type="Mesh",this.geometry=e,this.material=t,this.updateMorphTargets()}copy(e,t){return super.copy(e,t),e.morphTargetInfluences!==void 0&&(this.morphTargetInfluences=e.morphTargetInfluences.slice()),e.morphTargetDictionary!==void 0&&(this.morphTargetDictionary=Object.assign({},e.morphTargetDictionary)),this.material=e.material,this.geometry=e.geometry,this}updateMorphTargets(){const t=this.geometry.morphAttributes,n=Object.keys(t);if(n.length>0){const i=t[n[0]];if(i!==void 0){this.morphTargetInfluences=[],this.morphTargetDictionary={};for(let a=0,r=i.length;a<r;a++){const s=i[a].name||String(a);this.morphTargetInfluences.push(0),this.morphTargetDictionary[s]=a}}}}raycast(e,t){const n=this.geometry,i=this.material,a=this.matrixWorld;if(i===void 0||(n.boundingSphere===null&&n.computeBoundingSphere(),j6.copy(n.boundingSphere),j6.applyMatrix4(a),e.ray.intersectsSphere(j6)===!1)||(Po.copy(a).invert(),l9.copy(e.ray).applyMatrix4(Po),n.boundingBox!==null&&l9.intersectsBox(n.boundingBox)===!1))return;let r;const s=n.index,u=n.attributes.position,c=n.morphAttributes.position,d=n.morphTargetsRelative,h=n.attributes.uv,p=n.attributes.uv2,g=n.groups,y=n.drawRange;if(s!==null)if(Array.isArray(i))for(let m=0,v=g.length;m<v;m++){const b=g[m],x=i[b.materialIndex],w=Math.max(b.start,y.start),M=Math.min(s.count,Math.min(b.start+b.count,y.start+y.count));for(let A=w,S=M;A<S;A+=3){const D=s.getX(A),C=s.getX(A+1),E=s.getX(A+2);r=p8(this,x,e,l9,u,c,d,h,p,D,C,E),r&&(r.faceIndex=Math.floor(A/3),r.face.materialIndex=b.materialIndex,t.push(r))}}else{const m=Math.max(0,y.start),v=Math.min(s.count,y.start+y.count);for(let b=m,x=v;b<x;b+=3){const w=s.getX(b),M=s.getX(b+1),A=s.getX(b+2);r=p8(this,i,e,l9,u,c,d,h,p,w,M,A),r&&(r.faceIndex=Math.floor(b/3),t.push(r))}}else if(u!==void 0)if(Array.isArray(i))for(let m=0,v=g.length;m<v;m++){const b=g[m],x=i[b.materialIndex],w=Math.max(b.start,y.start),M=Math.min(u.count,Math.min(b.start+b.count,y.start+y.count));for(let A=w,S=M;A<S;A+=3){const D=A,C=A+1,E=A+2;r=p8(this,x,e,l9,u,c,d,h,p,D,C,E),r&&(r.faceIndex=Math.floor(A/3),r.face.materialIndex=b.materialIndex,t.push(r))}}else{const m=Math.max(0,y.start),v=Math.min(u.count,y.start+y.count);for(let b=m,x=v;b<x;b+=3){const w=b,M=b+1,A=b+2;r=p8(this,i,e,l9,u,c,d,h,p,w,M,A),r&&(r.faceIndex=Math.floor(b/3),t.push(r))}}}}function bS(o,e,t,n,i,a,r,s){let u;if(e.side===X3?u=n.intersectTriangle(r,a,i,!0,s):u=n.intersectTriangle(i,a,r,e.side!==m4,s),u===null)return null;h8.copy(s),h8.applyMatrix4(o.matrixWorld);const c=t.ray.origin.distanceTo(h8);return c<t.near||c>t.far?null:{distance:c,point:h8.clone(),object:o}}function p8(o,e,t,n,i,a,r,s,u,c,d,h){$4.fromBufferAttribute(i,c),J4.fromBufferAttribute(i,d),Z4.fromBufferAttribute(i,h);const p=o.morphTargetInfluences;if(a&&p){s8.set(0,0,0),l8.set(0,0,0),u8.set(0,0,0);for(let y=0,m=a.length;y<m;y++){const v=p[y],b=a[y];v!==0&&(W6.fromBufferAttribute(b,c),H6.fromBufferAttribute(b,d),Y6.fromBufferAttribute(b,h),r?(s8.addScaledVector(W6,v),l8.addScaledVector(H6,v),u8.addScaledVector(Y6,v)):(s8.addScaledVector(W6.sub($4),v),l8.addScaledVector(H6.sub(J4),v),u8.addScaledVector(Y6.sub(Z4),v)))}$4.add(s8),J4.add(l8),Z4.add(u8)}o.isSkinnedMesh&&(o.boneTransform(c,$4),o.boneTransform(d,J4),o.boneTransform(h,Z4));const g=bS(o,e,t,n,$4,J4,Z4,$6);if(g){s&&(c8.fromBufferAttribute(s,c),d8.fromBufferAttribute(s,d),f8.fromBufferAttribute(s,h),g.uv=h4.getUV($6,$4,J4,Z4,c8,d8,f8,new G1)),u&&(c8.fromBufferAttribute(u,c),d8.fromBufferAttribute(u,d),f8.fromBufferAttribute(u,h),g.uv2=h4.getUV($6,$4,J4,Z4,c8,d8,f8,new G1));const y={a:c,b:d,c:h,normal:new Y,materialIndex:0};h4.getNormal($4,J4,Z4,y.normal),g.face=y}return g}class F5 extends E3{constructor(e=1,t=1,n=1,i=1,a=1,r=1){super(),this.type="BoxGeometry",this.parameters={width:e,height:t,depth:n,widthSegments:i,heightSegments:a,depthSegments:r};const s=this;i=Math.floor(i),a=Math.floor(a),r=Math.floor(r);const u=[],c=[],d=[],h=[];let p=0,g=0;y("z","y","x",-1,-1,n,t,e,r,a,0),y("z","y","x",1,-1,n,t,-e,r,a,1),y("x","z","y",1,1,e,n,t,i,r,2),y("x","z","y",1,-1,e,n,-t,i,r,3),y("x","y","z",1,-1,e,t,n,i,a,4),y("x","y","z",-1,-1,e,t,-n,i,a,5),this.setIndex(u),this.setAttribute("position",new M3(c,3)),this.setAttribute("normal",new M3(d,3)),this.setAttribute("uv",new M3(h,2));function y(m,v,b,x,w,M,A,S,D,C,E){const k=M/D,$=A/C,X=M/2,F=A/2,R=S/2,U=D+1,H=C+1;let V=0,N=0;const z=new Y;for(let G=0;G<H;G++){const t1=G*$-F;for(let e1=0;e1<U;e1++){const u1=e1*k-X;z[m]=u1*x,z[v]=t1*w,z[b]=R,c.push(z.x,z.y,z.z),z[m]=0,z[v]=0,z[b]=S>0?1:-1,d.push(z.x,z.y,z.z),h.push(e1/D),h.push(1-G/C),V+=1}}for(let G=0;G<C;G++)for(let t1=0;t1<D;t1++){const e1=p+t1+U*G,u1=p+t1+U*(G+1),s1=p+(t1+1)+U*(G+1),q=p+(t1+1)+U*G;u.push(e1,u1,q),u.push(u1,s1,q),N+=6}s.addGroup(g,N,E),g+=N,p+=V}}static fromJSON(e){return new F5(e.width,e.height,e.depth,e.widthSegments,e.heightSegments,e.depthSegments)}}function F9(o){const e={};for(const t in o){e[t]={};for(const n in o[t]){const i=o[t][n];i&&(i.isColor||i.isMatrix3||i.isMatrix4||i.isVector2||i.isVector3||i.isVector4||i.isTexture||i.isQuaternion)?e[t][n]=i.clone():Array.isArray(i)?e[t][n]=i.slice():e[t][n]=i}}return e}function c3(o){const e={};for(let t=0;t<o.length;t++){const n=F9(o[t]);for(const i in n)e[i]=n[i]}return e}function xS(o){const e=[];for(let t=0;t<o.length;t++)e.push(o[t].clone());return e}const SS={clone:F9,merge:c3};var MS=`void main() {
	gl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );
}`,AS=`void main() {
	gl_FragColor = vec4( 1.0, 0.0, 0.0, 1.0 );
}`;class N4 extends Y0{constructor(e){super(),this.isShaderMaterial=!0,this.type="ShaderMaterial",this.defines={},this.uniforms={},this.uniformsGroups=[],this.vertexShader=MS,this.fragmentShader=AS,this.linewidth=1,this.wireframe=!1,this.wireframeLinewidth=1,this.fog=!1,this.lights=!1,this.clipping=!1,this.extensions={derivatives:!1,fragDepth:!1,drawBuffers:!1,shaderTextureLOD:!1},this.defaultAttributeValues={color:[1,1,1],uv:[0,0],uv2:[0,0]},this.index0AttributeName=void 0,this.uniformsNeedUpdate=!1,this.glslVersion=null,e!==void 0&&this.setValues(e)}copy(e){return super.copy(e),this.fragmentShader=e.fragmentShader,this.vertexShader=e.vertexShader,this.uniforms=F9(e.uniforms),this.uniformsGroups=xS(e.uniformsGroups),this.defines=Object.assign({},e.defines),this.wireframe=e.wireframe,this.wireframeLinewidth=e.wireframeLinewidth,this.fog=e.fog,this.lights=e.lights,this.clipping=e.clipping,this.extensions=Object.assign({},e.extensions),this.glslVersion=e.glslVersion,this}toJSON(e){const t=super.toJSON(e);t.glslVersion=this.glslVersion,t.uniforms={};for(const i in this.uniforms){const r=this.uniforms[i].value;r&&r.isTexture?t.uniforms[i]={type:"t",value:r.toJSON(e).uuid}:r&&r.isColor?t.uniforms[i]={type:"c",value:r.getHex()}:r&&r.isVector2?t.uniforms[i]={type:"v2",value:r.toArray()}:r&&r.isVector3?t.uniforms[i]={type:"v3",value:r.toArray()}:r&&r.isVector4?t.uniforms[i]={type:"v4",value:r.toArray()}:r&&r.isMatrix3?t.uniforms[i]={type:"m3",value:r.toArray()}:r&&r.isMatrix4?t.uniforms[i]={type:"m4",value:r.toArray()}:t.uniforms[i]={value:r}}Object.keys(this.defines).length>0&&(t.defines=this.defines),t.vertexShader=this.vertexShader,t.fragmentShader=this.fragmentShader;const n={};for(const i in this.extensions)this.extensions[i]===!0&&(n[i]=!0);return Object.keys(n).length>0&&(t.extensions=n),t}}class fs extends h3{constructor(){super(),this.isCamera=!0,this.type="Camera",this.matrixWorldInverse=new j2,this.projectionMatrix=new j2,this.projectionMatrixInverse=new j2}copy(e,t){return super.copy(e,t),this.matrixWorldInverse.copy(e.matrixWorldInverse),this.projectionMatrix.copy(e.projectionMatrix),this.projectionMatrixInverse.copy(e.projectionMatrixInverse),this}getWorldDirection(e){this.updateWorldMatrix(!0,!1);const t=this.matrixWorld.elements;return e.set(-t[8],-t[9],-t[10]).normalize()}updateMatrixWorld(e){super.updateMatrixWorld(e),this.matrixWorldInverse.copy(this.matrixWorld).invert()}updateWorldMatrix(e,t){super.updateWorldMatrix(e,t),this.matrixWorldInverse.copy(this.matrixWorld).invert()}clone(){return new this.constructor().copy(this)}}class W3 extends fs{constructor(e=50,t=1,n=.1,i=2e3){super(),this.isPerspectiveCamera=!0,this.type="PerspectiveCamera",this.fov=e,this.zoom=1,this.near=n,this.far=i,this.focus=10,this.aspect=t,this.view=null,this.filmGauge=35,this.filmOffset=0,this.updateProjectionMatrix()}copy(e,t){return super.copy(e,t),this.fov=e.fov,this.zoom=e.zoom,this.near=e.near,this.far=e.far,this.focus=e.focus,this.aspect=e.aspect,this.view=e.view===null?null:Object.assign({},e.view),this.filmGauge=e.filmGauge,this.filmOffset=e.filmOffset,this}setFocalLength(e){const t=.5*this.getFilmHeight()/e;this.fov=xo*2*Math.atan(t),this.updateProjectionMatrix()}getFocalLength(){const e=Math.tan(C6*.5*this.fov);return .5*this.getFilmHeight()/e}getEffectiveFOV(){return xo*2*Math.atan(Math.tan(C6*.5*this.fov)/this.zoom)}getFilmWidth(){return this.filmGauge*Math.min(this.aspect,1)}getFilmHeight(){return this.filmGauge/Math.max(this.aspect,1)}setViewOffset(e,t,n,i,a,r){this.aspect=e/t,this.view===null&&(this.view={enabled:!0,fullWidth:1,fullHeight:1,offsetX:0,offsetY:0,width:1,height:1}),this.view.enabled=!0,this.view.fullWidth=e,this.view.fullHeight=t,this.view.offsetX=n,this.view.offsetY=i,this.view.width=a,this.view.height=r,this.updateProjectionMatrix()}clearViewOffset(){this.view!==null&&(this.view.enabled=!1),this.updateProjectionMatrix()}updateProjectionMatrix(){const e=this.near;let t=e*Math.tan(C6*.5*this.fov)/this.zoom,n=2*t,i=this.aspect*n,a=-.5*i;const r=this.view;if(this.view!==null&&this.view.enabled){const u=r.fullWidth,c=r.fullHeight;a+=r.offsetX*i/u,t-=r.offsetY*n/c,i*=r.width/u,n*=r.height/c}const s=this.filmOffset;s!==0&&(a+=e*s/this.getFilmWidth()),this.projectionMatrix.makePerspective(a,a+i,t,t-n,e,this.far),this.projectionMatrixInverse.copy(this.projectionMatrix).invert()}toJSON(e){const t=super.toJSON(e);return t.object.fov=this.fov,t.object.zoom=this.zoom,t.object.near=this.near,t.object.far=this.far,t.object.focus=this.focus,t.object.aspect=this.aspect,this.view!==null&&(t.object.view=Object.assign({},this.view)),t.object.filmGauge=this.filmGauge,t.object.filmOffset=this.filmOffset,t}}const u9=90,c9=1;class wS extends h3{constructor(e,t,n){super(),this.type="CubeCamera",this.renderTarget=n;const i=new W3(u9,c9,e,t);i.layers=this.layers,i.up.set(0,-1,0),i.lookAt(new Y(1,0,0)),this.add(i);const a=new W3(u9,c9,e,t);a.layers=this.layers,a.up.set(0,-1,0),a.lookAt(new Y(-1,0,0)),this.add(a);const r=new W3(u9,c9,e,t);r.layers=this.layers,r.up.set(0,0,1),r.lookAt(new Y(0,1,0)),this.add(r);const s=new W3(u9,c9,e,t);s.layers=this.layers,s.up.set(0,0,-1),s.lookAt(new Y(0,-1,0)),this.add(s);const u=new W3(u9,c9,e,t);u.layers=this.layers,u.up.set(0,-1,0),u.lookAt(new Y(0,0,1)),this.add(u);const c=new W3(u9,c9,e,t);c.layers=this.layers,c.up.set(0,-1,0),c.lookAt(new Y(0,0,-1)),this.add(c)}update(e,t){this.parent===null&&this.updateMatrixWorld();const n=this.renderTarget,[i,a,r,s,u,c]=this.children,d=e.getRenderTarget(),h=e.toneMapping,p=e.xr.enabled;e.toneMapping=z4,e.xr.enabled=!1;const g=n.texture.generateMipmaps;n.texture.generateMipmaps=!1,e.setRenderTarget(n,0),e.render(t,i),e.setRenderTarget(n,1),e.render(t,a),e.setRenderTarget(n,2),e.render(t,r),e.setRenderTarget(n,3),e.render(t,s),e.setRenderTarget(n,4),e.render(t,u),n.texture.generateMipmaps=g,e.setRenderTarget(n,5),e.render(t,c),e.setRenderTarget(d),e.toneMapping=h,e.xr.enabled=p,n.texture.needsPMREMUpdate=!0}}class hs extends Q3{constructor(e,t,n,i,a,r,s,u,c,d){e=e!==void 0?e:[],t=t!==void 0?t:k9,super(e,t,n,i,a,r,s,u,c,d),this.isCubeTexture=!0,this.flipY=!1}get images(){return this.image}set images(e){this.image=e}}class CS extends G0{constructor(e,t={}){super(e,e,t),this.isWebGLCubeRenderTarget=!0;const n={width:e,height:e,depth:1},i=[n,n,n,n,n,n];this.texture=new hs(i,t.mapping,t.wrapS,t.wrapT,t.magFilter,t.minFilter,t.format,t.type,t.anisotropy,t.encoding),this.texture.isRenderTargetTexture=!0,this.texture.generateMipmaps=t.generateMipmaps!==void 0?t.generateMipmaps:!1,this.texture.minFilter=t.minFilter!==void 0?t.minFilter:j3}fromEquirectangularTexture(e,t){this.texture.type=t.type,this.texture.encoding=t.encoding,this.texture.generateMipmaps=t.generateMipmaps,this.texture.minFilter=t.minFilter,this.texture.magFilter=t.magFilter;const n={uniforms:{tEquirect:{value:null}},vertexShader:`

				varying vec3 vWorldDirection;

				vec3 transformDirection( in vec3 dir, in mat4 matrix ) {

					return normalize( ( matrix * vec4( dir, 0.0 ) ).xyz );

				}

				void main() {

					vWorldDirection = transformDirection( position, modelMatrix );

					#include <begin_vertex>
					#include <project_vertex>

				}
			`,fragmentShader:`

				uniform sampler2D tEquirect;

				varying vec3 vWorldDirection;

				#include <common>

				void main() {

					vec3 direction = normalize( vWorldDirection );

					vec2 sampleUV = equirectUv( direction );

					gl_FragColor = texture2D( tEquirect, sampleUV );

				}
			`},i=new F5(5,5,5),a=new N4({name:"CubemapFromEquirect",uniforms:F9(n.uniforms),vertexShader:n.vertexShader,fragmentShader:n.fragmentShader,side:X3,blending:i0});a.uniforms.tEquirect.value=t;const r=new s3(i,a),s=t.minFilter;return t.minFilter===i6&&(t.minFilter=j3),new wS(1,10,this).update(e,r),t.minFilter=s,r.geometry.dispose(),r.material.dispose(),this}clear(e,t,n,i){const a=e.getRenderTarget();for(let r=0;r<6;r++)e.setRenderTarget(this,r),e.clear(t,n,i);e.setRenderTarget(a)}}const J6=new Y,TS=new Y,ES=new H3;class S0{constructor(e=new Y(1,0,0),t=0){this.isPlane=!0,this.normal=e,this.constant=t}set(e,t){return this.normal.copy(e),this.constant=t,this}setComponents(e,t,n,i){return this.normal.set(e,t,n),this.constant=i,this}setFromNormalAndCoplanarPoint(e,t){return this.normal.copy(e),this.constant=-t.dot(this.normal),this}setFromCoplanarPoints(e,t,n){const i=J6.subVectors(n,t).cross(TS.subVectors(e,t)).normalize();return this.setFromNormalAndCoplanarPoint(i,e),this}copy(e){return this.normal.copy(e.normal),this.constant=e.constant,this}normalize(){const e=1/this.normal.length();return this.normal.multiplyScalar(e),this.constant*=e,this}negate(){return this.constant*=-1,this.normal.negate(),this}distanceToPoint(e){return this.normal.dot(e)+this.constant}distanceToSphere(e){return this.distanceToPoint(e.center)-e.radius}projectPoint(e,t){return t.copy(this.normal).multiplyScalar(-this.distanceToPoint(e)).add(e)}intersectLine(e,t){const n=e.delta(J6),i=this.normal.dot(n);if(i===0)return this.distanceToPoint(e.start)===0?t.copy(e.start):null;const a=-(e.start.dot(this.normal)+this.constant)/i;return a<0||a>1?null:t.copy(n).multiplyScalar(a).add(e.start)}intersectsLine(e){const t=this.distanceToPoint(e.start),n=this.distanceToPoint(e.end);return t<0&&n>0||n<0&&t>0}intersectsBox(e){return e.intersectsPlane(this)}intersectsSphere(e){return e.intersectsPlane(this)}coplanarPoint(e){return e.copy(this.normal).multiplyScalar(-this.constant)}applyMatrix4(e,t){const n=t||ES.getNormalMatrix(e),i=this.coplanarPoint(J6).applyMatrix4(e),a=this.normal.applyMatrix3(n).normalize();return this.constant=-i.dot(a),this}translate(e){return this.constant-=e.dot(this.normal),this}equals(e){return e.normal.equals(this.normal)&&e.constant===this.constant}clone(){return new this.constructor().copy(this)}}const d9=new N5,m8=new Y;class ps{constructor(e=new S0,t=new S0,n=new S0,i=new S0,a=new S0,r=new S0){this.planes=[e,t,n,i,a,r]}set(e,t,n,i,a,r){const s=this.planes;return s[0].copy(e),s[1].copy(t),s[2].copy(n),s[3].copy(i),s[4].copy(a),s[5].copy(r),this}copy(e){const t=this.planes;for(let n=0;n<6;n++)t[n].copy(e.planes[n]);return this}setFromProjectionMatrix(e){const t=this.planes,n=e.elements,i=n[0],a=n[1],r=n[2],s=n[3],u=n[4],c=n[5],d=n[6],h=n[7],p=n[8],g=n[9],y=n[10],m=n[11],v=n[12],b=n[13],x=n[14],w=n[15];return t[0].setComponents(s-i,h-u,m-p,w-v).normalize(),t[1].setComponents(s+i,h+u,m+p,w+v).normalize(),t[2].setComponents(s+a,h+c,m+g,w+b).normalize(),t[3].setComponents(s-a,h-c,m-g,w-b).normalize(),t[4].setComponents(s-r,h-d,m-y,w-x).normalize(),t[5].setComponents(s+r,h+d,m+y,w+x).normalize(),this}intersectsObject(e){const t=e.geometry;return t.boundingSphere===null&&t.computeBoundingSphere(),d9.copy(t.boundingSphere).applyMatrix4(e.matrixWorld),this.intersectsSphere(d9)}intersectsSprite(e){return d9.center.set(0,0,0),d9.radius=.7071067811865476,d9.applyMatrix4(e.matrixWorld),this.intersectsSphere(d9)}intersectsSphere(e){const t=this.planes,n=e.center,i=-e.radius;for(let a=0;a<6;a++)if(t[a].distanceToPoint(n)<i)return!1;return!0}intersectsBox(e){const t=this.planes;for(let n=0;n<6;n++){const i=t[n];if(m8.x=i.normal.x>0?e.max.x:e.min.x,m8.y=i.normal.y>0?e.max.y:e.min.y,m8.z=i.normal.z>0?e.max.z:e.min.z,i.distanceToPoint(m8)<0)return!1}return!0}containsPoint(e){const t=this.planes;for(let n=0;n<6;n++)if(t[n].distanceToPoint(e)<0)return!1;return!0}clone(){return new this.constructor().copy(this)}}function ms(){let o=null,e=!1,t=null,n=null;function i(a,r){t(a,r),n=o.requestAnimationFrame(i)}return{start:function(){e!==!0&&t!==null&&(n=o.requestAnimationFrame(i),e=!0)},stop:function(){o.cancelAnimationFrame(n),e=!1},setAnimationLoop:function(a){t=a},setContext:function(a){o=a}}}function DS(o,e){const t=e.isWebGL2,n=new WeakMap;function i(c,d){const h=c.array,p=c.usage,g=o.createBuffer();o.bindBuffer(d,g),o.bufferData(d,h,p),c.onUploadCallback();let y;if(h instanceof Float32Array)y=5126;else if(h instanceof Uint16Array)if(c.isFloat16BufferAttribute)if(t)y=5131;else throw new Error("THREE.WebGLAttributes: Usage of Float16BufferAttribute requires WebGL2.");else y=5123;else if(h instanceof Int16Array)y=5122;else if(h instanceof Uint32Array)y=5125;else if(h instanceof Int32Array)y=5124;else if(h instanceof Int8Array)y=5120;else if(h instanceof Uint8Array)y=5121;else if(h instanceof Uint8ClampedArray)y=5121;else throw new Error("THREE.WebGLAttributes: Unsupported buffer data format: "+h);return{buffer:g,type:y,bytesPerElement:h.BYTES_PER_ELEMENT,version:c.version}}function a(c,d,h){const p=d.array,g=d.updateRange;o.bindBuffer(h,c),g.count===-1?o.bufferSubData(h,0,p):(t?o.bufferSubData(h,g.offset*p.BYTES_PER_ELEMENT,p,g.offset,g.count):o.bufferSubData(h,g.offset*p.BYTES_PER_ELEMENT,p.subarray(g.offset,g.offset+g.count)),g.count=-1)}function r(c){return c.isInterleavedBufferAttribute&&(c=c.data),n.get(c)}function s(c){c.isInterleavedBufferAttribute&&(c=c.data);const d=n.get(c);d&&(o.deleteBuffer(d.buffer),n.delete(c))}function u(c,d){if(c.isGLBufferAttribute){const p=n.get(c);(!p||p.version<c.version)&&n.set(c,{buffer:c.buffer,type:c.type,bytesPerElement:c.elementSize,version:c.version});return}c.isInterleavedBufferAttribute&&(c=c.data);const h=n.get(c);h===void 0?n.set(c,i(c,d)):h.version<c.version&&(a(h.buffer,c,d),h.version=c.version)}return{get:r,remove:s,update:u}}class J9 extends E3{constructor(e=1,t=1,n=1,i=1){super(),this.type="PlaneGeometry",this.parameters={width:e,height:t,widthSegments:n,heightSegments:i};const a=e/2,r=t/2,s=Math.floor(n),u=Math.floor(i),c=s+1,d=u+1,h=e/s,p=t/u,g=[],y=[],m=[],v=[];for(let b=0;b<d;b++){const x=b*p-r;for(let w=0;w<c;w++){const M=w*h-a;y.push(M,-x,0),m.push(0,0,1),v.push(w/s),v.push(1-b/u)}}for(let b=0;b<u;b++)for(let x=0;x<s;x++){const w=x+c*b,M=x+c*(b+1),A=x+1+c*(b+1),S=x+1+c*b;g.push(w,M,S),g.push(M,A,S)}this.setIndex(g),this.setAttribute("position",new M3(y,3)),this.setAttribute("normal",new M3(m,3)),this.setAttribute("uv",new M3(v,2))}static fromJSON(e){return new J9(e.width,e.height,e.widthSegments,e.heightSegments)}}var IS=`#ifdef USE_ALPHAMAP
	diffuseColor.a *= texture2D( alphaMap, vUv ).g;
#endif`,RS=`#ifdef USE_ALPHAMAP
	uniform sampler2D alphaMap;
#endif`,OS=`#ifdef USE_ALPHATEST
	if ( diffuseColor.a < alphaTest ) discard;
#endif`,PS=`#ifdef USE_ALPHATEST
	uniform float alphaTest;
#endif`,LS=`#ifdef USE_AOMAP
	float ambientOcclusion = ( texture2D( aoMap, vUv2 ).r - 1.0 ) * aoMapIntensity + 1.0;
	reflectedLight.indirectDiffuse *= ambientOcclusion;
	#if defined( USE_ENVMAP ) && defined( STANDARD )
		float dotNV = saturate( dot( geometry.normal, geometry.viewDir ) );
		reflectedLight.indirectSpecular *= computeSpecularOcclusion( dotNV, ambientOcclusion, material.roughness );
	#endif
#endif`,zS=`#ifdef USE_AOMAP
	uniform sampler2D aoMap;
	uniform float aoMapIntensity;
#endif`,kS="vec3 transformed = vec3( position );",NS=`vec3 objectNormal = vec3( normal );
#ifdef USE_TANGENT
	vec3 objectTangent = vec3( tangent.xyz );
#endif`,US=`vec3 BRDF_Lambert( const in vec3 diffuseColor ) {
	return RECIPROCAL_PI * diffuseColor;
}
vec3 F_Schlick( const in vec3 f0, const in float f90, const in float dotVH ) {
	float fresnel = exp2( ( - 5.55473 * dotVH - 6.98316 ) * dotVH );
	return f0 * ( 1.0 - fresnel ) + ( f90 * fresnel );
}
float F_Schlick( const in float f0, const in float f90, const in float dotVH ) {
	float fresnel = exp2( ( - 5.55473 * dotVH - 6.98316 ) * dotVH );
	return f0 * ( 1.0 - fresnel ) + ( f90 * fresnel );
}
vec3 Schlick_to_F0( const in vec3 f, const in float f90, const in float dotVH ) {
    float x = clamp( 1.0 - dotVH, 0.0, 1.0 );
    float x2 = x * x;
    float x5 = clamp( x * x2 * x2, 0.0, 0.9999 );
    return ( f - vec3( f90 ) * x5 ) / ( 1.0 - x5 );
}
float V_GGX_SmithCorrelated( const in float alpha, const in float dotNL, const in float dotNV ) {
	float a2 = pow2( alpha );
	float gv = dotNL * sqrt( a2 + ( 1.0 - a2 ) * pow2( dotNV ) );
	float gl = dotNV * sqrt( a2 + ( 1.0 - a2 ) * pow2( dotNL ) );
	return 0.5 / max( gv + gl, EPSILON );
}
float D_GGX( const in float alpha, const in float dotNH ) {
	float a2 = pow2( alpha );
	float denom = pow2( dotNH ) * ( a2 - 1.0 ) + 1.0;
	return RECIPROCAL_PI * a2 / pow2( denom );
}
vec3 BRDF_GGX( const in vec3 lightDir, const in vec3 viewDir, const in vec3 normal, const in vec3 f0, const in float f90, const in float roughness ) {
	float alpha = pow2( roughness );
	vec3 halfDir = normalize( lightDir + viewDir );
	float dotNL = saturate( dot( normal, lightDir ) );
	float dotNV = saturate( dot( normal, viewDir ) );
	float dotNH = saturate( dot( normal, halfDir ) );
	float dotVH = saturate( dot( viewDir, halfDir ) );
	vec3 F = F_Schlick( f0, f90, dotVH );
	float V = V_GGX_SmithCorrelated( alpha, dotNL, dotNV );
	float D = D_GGX( alpha, dotNH );
	return F * ( V * D );
}
#ifdef USE_IRIDESCENCE
	vec3 BRDF_GGX_Iridescence( const in vec3 lightDir, const in vec3 viewDir, const in vec3 normal, const in vec3 f0, const in float f90, const in float iridescence, const in vec3 iridescenceFresnel, const in float roughness ) {
		float alpha = pow2( roughness );
		vec3 halfDir = normalize( lightDir + viewDir );
		float dotNL = saturate( dot( normal, lightDir ) );
		float dotNV = saturate( dot( normal, viewDir ) );
		float dotNH = saturate( dot( normal, halfDir ) );
		float dotVH = saturate( dot( viewDir, halfDir ) );
		vec3 F = mix( F_Schlick( f0, f90, dotVH ), iridescenceFresnel, iridescence );
		float V = V_GGX_SmithCorrelated( alpha, dotNL, dotNV );
		float D = D_GGX( alpha, dotNH );
		return F * ( V * D );
	}
#endif
vec2 LTC_Uv( const in vec3 N, const in vec3 V, const in float roughness ) {
	const float LUT_SIZE = 64.0;
	const float LUT_SCALE = ( LUT_SIZE - 1.0 ) / LUT_SIZE;
	const float LUT_BIAS = 0.5 / LUT_SIZE;
	float dotNV = saturate( dot( N, V ) );
	vec2 uv = vec2( roughness, sqrt( 1.0 - dotNV ) );
	uv = uv * LUT_SCALE + LUT_BIAS;
	return uv;
}
float LTC_ClippedSphereFormFactor( const in vec3 f ) {
	float l = length( f );
	return max( ( l * l + f.z ) / ( l + 1.0 ), 0.0 );
}
vec3 LTC_EdgeVectorFormFactor( const in vec3 v1, const in vec3 v2 ) {
	float x = dot( v1, v2 );
	float y = abs( x );
	float a = 0.8543985 + ( 0.4965155 + 0.0145206 * y ) * y;
	float b = 3.4175940 + ( 4.1616724 + y ) * y;
	float v = a / b;
	float theta_sintheta = ( x > 0.0 ) ? v : 0.5 * inversesqrt( max( 1.0 - x * x, 1e-7 ) ) - v;
	return cross( v1, v2 ) * theta_sintheta;
}
vec3 LTC_Evaluate( const in vec3 N, const in vec3 V, const in vec3 P, const in mat3 mInv, const in vec3 rectCoords[ 4 ] ) {
	vec3 v1 = rectCoords[ 1 ] - rectCoords[ 0 ];
	vec3 v2 = rectCoords[ 3 ] - rectCoords[ 0 ];
	vec3 lightNormal = cross( v1, v2 );
	if( dot( lightNormal, P - rectCoords[ 0 ] ) < 0.0 ) return vec3( 0.0 );
	vec3 T1, T2;
	T1 = normalize( V - N * dot( V, N ) );
	T2 = - cross( N, T1 );
	mat3 mat = mInv * transposeMat3( mat3( T1, T2, N ) );
	vec3 coords[ 4 ];
	coords[ 0 ] = mat * ( rectCoords[ 0 ] - P );
	coords[ 1 ] = mat * ( rectCoords[ 1 ] - P );
	coords[ 2 ] = mat * ( rectCoords[ 2 ] - P );
	coords[ 3 ] = mat * ( rectCoords[ 3 ] - P );
	coords[ 0 ] = normalize( coords[ 0 ] );
	coords[ 1 ] = normalize( coords[ 1 ] );
	coords[ 2 ] = normalize( coords[ 2 ] );
	coords[ 3 ] = normalize( coords[ 3 ] );
	vec3 vectorFormFactor = vec3( 0.0 );
	vectorFormFactor += LTC_EdgeVectorFormFactor( coords[ 0 ], coords[ 1 ] );
	vectorFormFactor += LTC_EdgeVectorFormFactor( coords[ 1 ], coords[ 2 ] );
	vectorFormFactor += LTC_EdgeVectorFormFactor( coords[ 2 ], coords[ 3 ] );
	vectorFormFactor += LTC_EdgeVectorFormFactor( coords[ 3 ], coords[ 0 ] );
	float result = LTC_ClippedSphereFormFactor( vectorFormFactor );
	return vec3( result );
}
float G_BlinnPhong_Implicit( ) {
	return 0.25;
}
float D_BlinnPhong( const in float shininess, const in float dotNH ) {
	return RECIPROCAL_PI * ( shininess * 0.5 + 1.0 ) * pow( dotNH, shininess );
}
vec3 BRDF_BlinnPhong( const in vec3 lightDir, const in vec3 viewDir, const in vec3 normal, const in vec3 specularColor, const in float shininess ) {
	vec3 halfDir = normalize( lightDir + viewDir );
	float dotNH = saturate( dot( normal, halfDir ) );
	float dotVH = saturate( dot( viewDir, halfDir ) );
	vec3 F = F_Schlick( specularColor, 1.0, dotVH );
	float G = G_BlinnPhong_Implicit( );
	float D = D_BlinnPhong( shininess, dotNH );
	return F * ( G * D );
}
#if defined( USE_SHEEN )
float D_Charlie( float roughness, float dotNH ) {
	float alpha = pow2( roughness );
	float invAlpha = 1.0 / alpha;
	float cos2h = dotNH * dotNH;
	float sin2h = max( 1.0 - cos2h, 0.0078125 );
	return ( 2.0 + invAlpha ) * pow( sin2h, invAlpha * 0.5 ) / ( 2.0 * PI );
}
float V_Neubelt( float dotNV, float dotNL ) {
	return saturate( 1.0 / ( 4.0 * ( dotNL + dotNV - dotNL * dotNV ) ) );
}
vec3 BRDF_Sheen( const in vec3 lightDir, const in vec3 viewDir, const in vec3 normal, vec3 sheenColor, const in float sheenRoughness ) {
	vec3 halfDir = normalize( lightDir + viewDir );
	float dotNL = saturate( dot( normal, lightDir ) );
	float dotNV = saturate( dot( normal, viewDir ) );
	float dotNH = saturate( dot( normal, halfDir ) );
	float D = D_Charlie( sheenRoughness, dotNH );
	float V = V_Neubelt( dotNV, dotNL );
	return sheenColor * ( D * V );
}
#endif`,FS=`#ifdef USE_IRIDESCENCE
	const mat3 XYZ_TO_REC709 = mat3(
		 3.2404542, -0.9692660,  0.0556434,
		-1.5371385,  1.8760108, -0.2040259,
		-0.4985314,  0.0415560,  1.0572252
	);
	vec3 Fresnel0ToIor( vec3 fresnel0 ) {
		vec3 sqrtF0 = sqrt( fresnel0 );
		return ( vec3( 1.0 ) + sqrtF0 ) / ( vec3( 1.0 ) - sqrtF0 );
	}
	vec3 IorToFresnel0( vec3 transmittedIor, float incidentIor ) {
		return pow2( ( transmittedIor - vec3( incidentIor ) ) / ( transmittedIor + vec3( incidentIor ) ) );
	}
	float IorToFresnel0( float transmittedIor, float incidentIor ) {
		return pow2( ( transmittedIor - incidentIor ) / ( transmittedIor + incidentIor ));
	}
	vec3 evalSensitivity( float OPD, vec3 shift ) {
		float phase = 2.0 * PI * OPD * 1.0e-9;
		vec3 val = vec3( 5.4856e-13, 4.4201e-13, 5.2481e-13 );
		vec3 pos = vec3( 1.6810e+06, 1.7953e+06, 2.2084e+06 );
		vec3 var = vec3( 4.3278e+09, 9.3046e+09, 6.6121e+09 );
		vec3 xyz = val * sqrt( 2.0 * PI * var ) * cos( pos * phase + shift ) * exp( - pow2( phase ) * var );
		xyz.x += 9.7470e-14 * sqrt( 2.0 * PI * 4.5282e+09 ) * cos( 2.2399e+06 * phase + shift[ 0 ] ) * exp( - 4.5282e+09 * pow2( phase ) );
		xyz /= 1.0685e-7;
		vec3 rgb = XYZ_TO_REC709 * xyz;
		return rgb;
	}
	vec3 evalIridescence( float outsideIOR, float eta2, float cosTheta1, float thinFilmThickness, vec3 baseF0 ) {
		vec3 I;
		float iridescenceIOR = mix( outsideIOR, eta2, smoothstep( 0.0, 0.03, thinFilmThickness ) );
		float sinTheta2Sq = pow2( outsideIOR / iridescenceIOR ) * ( 1.0 - pow2( cosTheta1 ) );
		float cosTheta2Sq = 1.0 - sinTheta2Sq;
		if ( cosTheta2Sq < 0.0 ) {
			 return vec3( 1.0 );
		}
		float cosTheta2 = sqrt( cosTheta2Sq );
		float R0 = IorToFresnel0( iridescenceIOR, outsideIOR );
		float R12 = F_Schlick( R0, 1.0, cosTheta1 );
		float R21 = R12;
		float T121 = 1.0 - R12;
		float phi12 = 0.0;
		if ( iridescenceIOR < outsideIOR ) phi12 = PI;
		float phi21 = PI - phi12;
		vec3 baseIOR = Fresnel0ToIor( clamp( baseF0, 0.0, 0.9999 ) );		vec3 R1 = IorToFresnel0( baseIOR, iridescenceIOR );
		vec3 R23 = F_Schlick( R1, 1.0, cosTheta2 );
		vec3 phi23 = vec3( 0.0 );
		if ( baseIOR[ 0 ] < iridescenceIOR ) phi23[ 0 ] = PI;
		if ( baseIOR[ 1 ] < iridescenceIOR ) phi23[ 1 ] = PI;
		if ( baseIOR[ 2 ] < iridescenceIOR ) phi23[ 2 ] = PI;
		float OPD = 2.0 * iridescenceIOR * thinFilmThickness * cosTheta2;
		vec3 phi = vec3( phi21 ) + phi23;
		vec3 R123 = clamp( R12 * R23, 1e-5, 0.9999 );
		vec3 r123 = sqrt( R123 );
		vec3 Rs = pow2( T121 ) * R23 / ( vec3( 1.0 ) - R123 );
		vec3 C0 = R12 + Rs;
		I = C0;
		vec3 Cm = Rs - T121;
		for ( int m = 1; m <= 2; ++ m ) {
			Cm *= r123;
			vec3 Sm = 2.0 * evalSensitivity( float( m ) * OPD, float( m ) * phi );
			I += Cm * Sm;
		}
		return max( I, vec3( 0.0 ) );
	}
#endif`,BS=`#ifdef USE_BUMPMAP
	uniform sampler2D bumpMap;
	uniform float bumpScale;
	vec2 dHdxy_fwd() {
		vec2 dSTdx = dFdx( vUv );
		vec2 dSTdy = dFdy( vUv );
		float Hll = bumpScale * texture2D( bumpMap, vUv ).x;
		float dBx = bumpScale * texture2D( bumpMap, vUv + dSTdx ).x - Hll;
		float dBy = bumpScale * texture2D( bumpMap, vUv + dSTdy ).x - Hll;
		return vec2( dBx, dBy );
	}
	vec3 perturbNormalArb( vec3 surf_pos, vec3 surf_norm, vec2 dHdxy, float faceDirection ) {
		vec3 vSigmaX = dFdx( surf_pos.xyz );
		vec3 vSigmaY = dFdy( surf_pos.xyz );
		vec3 vN = surf_norm;
		vec3 R1 = cross( vSigmaY, vN );
		vec3 R2 = cross( vN, vSigmaX );
		float fDet = dot( vSigmaX, R1 ) * faceDirection;
		vec3 vGrad = sign( fDet ) * ( dHdxy.x * R1 + dHdxy.y * R2 );
		return normalize( abs( fDet ) * surf_norm - vGrad );
	}
#endif`,GS=`#if NUM_CLIPPING_PLANES > 0
	vec4 plane;
	#pragma unroll_loop_start
	for ( int i = 0; i < UNION_CLIPPING_PLANES; i ++ ) {
		plane = clippingPlanes[ i ];
		if ( dot( vClipPosition, plane.xyz ) > plane.w ) discard;
	}
	#pragma unroll_loop_end
	#if UNION_CLIPPING_PLANES < NUM_CLIPPING_PLANES
		bool clipped = true;
		#pragma unroll_loop_start
		for ( int i = UNION_CLIPPING_PLANES; i < NUM_CLIPPING_PLANES; i ++ ) {
			plane = clippingPlanes[ i ];
			clipped = ( dot( vClipPosition, plane.xyz ) > plane.w ) && clipped;
		}
		#pragma unroll_loop_end
		if ( clipped ) discard;
	#endif
#endif`,VS=`#if NUM_CLIPPING_PLANES > 0
	varying vec3 vClipPosition;
	uniform vec4 clippingPlanes[ NUM_CLIPPING_PLANES ];
#endif`,jS=`#if NUM_CLIPPING_PLANES > 0
	varying vec3 vClipPosition;
#endif`,WS=`#if NUM_CLIPPING_PLANES > 0
	vClipPosition = - mvPosition.xyz;
#endif`,HS=`#if defined( USE_COLOR_ALPHA )
	diffuseColor *= vColor;
#elif defined( USE_COLOR )
	diffuseColor.rgb *= vColor;
#endif`,YS=`#if defined( USE_COLOR_ALPHA )
	varying vec4 vColor;
#elif defined( USE_COLOR )
	varying vec3 vColor;
#endif`,$S=`#if defined( USE_COLOR_ALPHA )
	varying vec4 vColor;
#elif defined( USE_COLOR ) || defined( USE_INSTANCING_COLOR )
	varying vec3 vColor;
#endif`,JS=`#if defined( USE_COLOR_ALPHA )
	vColor = vec4( 1.0 );
#elif defined( USE_COLOR ) || defined( USE_INSTANCING_COLOR )
	vColor = vec3( 1.0 );
#endif
#ifdef USE_COLOR
	vColor *= color;
#endif
#ifdef USE_INSTANCING_COLOR
	vColor.xyz *= instanceColor.xyz;
#endif`,ZS=`#define PI 3.141592653589793
#define PI2 6.283185307179586
#define PI_HALF 1.5707963267948966
#define RECIPROCAL_PI 0.3183098861837907
#define RECIPROCAL_PI2 0.15915494309189535
#define EPSILON 1e-6
#ifndef saturate
#define saturate( a ) clamp( a, 0.0, 1.0 )
#endif
#define whiteComplement( a ) ( 1.0 - saturate( a ) )
float pow2( const in float x ) { return x*x; }
vec3 pow2( const in vec3 x ) { return x*x; }
float pow3( const in float x ) { return x*x*x; }
float pow4( const in float x ) { float x2 = x*x; return x2*x2; }
float max3( const in vec3 v ) { return max( max( v.x, v.y ), v.z ); }
float average( const in vec3 v ) { return dot( v, vec3( 0.3333333 ) ); }
highp float rand( const in vec2 uv ) {
	const highp float a = 12.9898, b = 78.233, c = 43758.5453;
	highp float dt = dot( uv.xy, vec2( a,b ) ), sn = mod( dt, PI );
	return fract( sin( sn ) * c );
}
#ifdef HIGH_PRECISION
	float precisionSafeLength( vec3 v ) { return length( v ); }
#else
	float precisionSafeLength( vec3 v ) {
		float maxComponent = max3( abs( v ) );
		return length( v / maxComponent ) * maxComponent;
	}
#endif
struct IncidentLight {
	vec3 color;
	vec3 direction;
	bool visible;
};
struct ReflectedLight {
	vec3 directDiffuse;
	vec3 directSpecular;
	vec3 indirectDiffuse;
	vec3 indirectSpecular;
};
struct GeometricContext {
	vec3 position;
	vec3 normal;
	vec3 viewDir;
#ifdef USE_CLEARCOAT
	vec3 clearcoatNormal;
#endif
};
vec3 transformDirection( in vec3 dir, in mat4 matrix ) {
	return normalize( ( matrix * vec4( dir, 0.0 ) ).xyz );
}
vec3 inverseTransformDirection( in vec3 dir, in mat4 matrix ) {
	return normalize( ( vec4( dir, 0.0 ) * matrix ).xyz );
}
mat3 transposeMat3( const in mat3 m ) {
	mat3 tmp;
	tmp[ 0 ] = vec3( m[ 0 ].x, m[ 1 ].x, m[ 2 ].x );
	tmp[ 1 ] = vec3( m[ 0 ].y, m[ 1 ].y, m[ 2 ].y );
	tmp[ 2 ] = vec3( m[ 0 ].z, m[ 1 ].z, m[ 2 ].z );
	return tmp;
}
float luminance( const in vec3 rgb ) {
	const vec3 weights = vec3( 0.2126729, 0.7151522, 0.0721750 );
	return dot( weights, rgb );
}
bool isPerspectiveMatrix( mat4 m ) {
	return m[ 2 ][ 3 ] == - 1.0;
}
vec2 equirectUv( in vec3 dir ) {
	float u = atan( dir.z, dir.x ) * RECIPROCAL_PI2 + 0.5;
	float v = asin( clamp( dir.y, - 1.0, 1.0 ) ) * RECIPROCAL_PI + 0.5;
	return vec2( u, v );
}`,XS=`#ifdef ENVMAP_TYPE_CUBE_UV
	#define cubeUV_minMipLevel 4.0
	#define cubeUV_minTileSize 16.0
	float getFace( vec3 direction ) {
		vec3 absDirection = abs( direction );
		float face = - 1.0;
		if ( absDirection.x > absDirection.z ) {
			if ( absDirection.x > absDirection.y )
				face = direction.x > 0.0 ? 0.0 : 3.0;
			else
				face = direction.y > 0.0 ? 1.0 : 4.0;
		} else {
			if ( absDirection.z > absDirection.y )
				face = direction.z > 0.0 ? 2.0 : 5.0;
			else
				face = direction.y > 0.0 ? 1.0 : 4.0;
		}
		return face;
	}
	vec2 getUV( vec3 direction, float face ) {
		vec2 uv;
		if ( face == 0.0 ) {
			uv = vec2( direction.z, direction.y ) / abs( direction.x );
		} else if ( face == 1.0 ) {
			uv = vec2( - direction.x, - direction.z ) / abs( direction.y );
		} else if ( face == 2.0 ) {
			uv = vec2( - direction.x, direction.y ) / abs( direction.z );
		} else if ( face == 3.0 ) {
			uv = vec2( - direction.z, direction.y ) / abs( direction.x );
		} else if ( face == 4.0 ) {
			uv = vec2( - direction.x, direction.z ) / abs( direction.y );
		} else {
			uv = vec2( direction.x, direction.y ) / abs( direction.z );
		}
		return 0.5 * ( uv + 1.0 );
	}
	vec3 bilinearCubeUV( sampler2D envMap, vec3 direction, float mipInt ) {
		float face = getFace( direction );
		float filterInt = max( cubeUV_minMipLevel - mipInt, 0.0 );
		mipInt = max( mipInt, cubeUV_minMipLevel );
		float faceSize = exp2( mipInt );
		vec2 uv = getUV( direction, face ) * ( faceSize - 2.0 ) + 1.0;
		if ( face > 2.0 ) {
			uv.y += faceSize;
			face -= 3.0;
		}
		uv.x += face * faceSize;
		uv.x += filterInt * 3.0 * cubeUV_minTileSize;
		uv.y += 4.0 * ( exp2( CUBEUV_MAX_MIP ) - faceSize );
		uv.x *= CUBEUV_TEXEL_WIDTH;
		uv.y *= CUBEUV_TEXEL_HEIGHT;
		#ifdef texture2DGradEXT
			return texture2DGradEXT( envMap, uv, vec2( 0.0 ), vec2( 0.0 ) ).rgb;
		#else
			return texture2D( envMap, uv ).rgb;
		#endif
	}
	#define cubeUV_r0 1.0
	#define cubeUV_v0 0.339
	#define cubeUV_m0 - 2.0
	#define cubeUV_r1 0.8
	#define cubeUV_v1 0.276
	#define cubeUV_m1 - 1.0
	#define cubeUV_r4 0.4
	#define cubeUV_v4 0.046
	#define cubeUV_m4 2.0
	#define cubeUV_r5 0.305
	#define cubeUV_v5 0.016
	#define cubeUV_m5 3.0
	#define cubeUV_r6 0.21
	#define cubeUV_v6 0.0038
	#define cubeUV_m6 4.0
	float roughnessToMip( float roughness ) {
		float mip = 0.0;
		if ( roughness >= cubeUV_r1 ) {
			mip = ( cubeUV_r0 - roughness ) * ( cubeUV_m1 - cubeUV_m0 ) / ( cubeUV_r0 - cubeUV_r1 ) + cubeUV_m0;
		} else if ( roughness >= cubeUV_r4 ) {
			mip = ( cubeUV_r1 - roughness ) * ( cubeUV_m4 - cubeUV_m1 ) / ( cubeUV_r1 - cubeUV_r4 ) + cubeUV_m1;
		} else if ( roughness >= cubeUV_r5 ) {
			mip = ( cubeUV_r4 - roughness ) * ( cubeUV_m5 - cubeUV_m4 ) / ( cubeUV_r4 - cubeUV_r5 ) + cubeUV_m4;
		} else if ( roughness >= cubeUV_r6 ) {
			mip = ( cubeUV_r5 - roughness ) * ( cubeUV_m6 - cubeUV_m5 ) / ( cubeUV_r5 - cubeUV_r6 ) + cubeUV_m5;
		} else {
			mip = - 2.0 * log2( 1.16 * roughness );		}
		return mip;
	}
	vec4 textureCubeUV( sampler2D envMap, vec3 sampleDir, float roughness ) {
		float mip = clamp( roughnessToMip( roughness ), cubeUV_m0, CUBEUV_MAX_MIP );
		float mipF = fract( mip );
		float mipInt = floor( mip );
		vec3 color0 = bilinearCubeUV( envMap, sampleDir, mipInt );
		if ( mipF == 0.0 ) {
			return vec4( color0, 1.0 );
		} else {
			vec3 color1 = bilinearCubeUV( envMap, sampleDir, mipInt + 1.0 );
			return vec4( mix( color0, color1, mipF ), 1.0 );
		}
	}
#endif`,QS=`vec3 transformedNormal = objectNormal;
#ifdef USE_INSTANCING
	mat3 m = mat3( instanceMatrix );
	transformedNormal /= vec3( dot( m[ 0 ], m[ 0 ] ), dot( m[ 1 ], m[ 1 ] ), dot( m[ 2 ], m[ 2 ] ) );
	transformedNormal = m * transformedNormal;
#endif
transformedNormal = normalMatrix * transformedNormal;
#ifdef FLIP_SIDED
	transformedNormal = - transformedNormal;
#endif
#ifdef USE_TANGENT
	vec3 transformedTangent = ( modelViewMatrix * vec4( objectTangent, 0.0 ) ).xyz;
	#ifdef FLIP_SIDED
		transformedTangent = - transformedTangent;
	#endif
#endif`,qS=`#ifdef USE_DISPLACEMENTMAP
	uniform sampler2D displacementMap;
	uniform float displacementScale;
	uniform float displacementBias;
#endif`,KS=`#ifdef USE_DISPLACEMENTMAP
	transformed += normalize( objectNormal ) * ( texture2D( displacementMap, vUv ).x * displacementScale + displacementBias );
#endif`,eM=`#ifdef USE_EMISSIVEMAP
	vec4 emissiveColor = texture2D( emissiveMap, vUv );
	totalEmissiveRadiance *= emissiveColor.rgb;
#endif`,tM=`#ifdef USE_EMISSIVEMAP
	uniform sampler2D emissiveMap;
#endif`,nM="gl_FragColor = linearToOutputTexel( gl_FragColor );",iM=`vec4 LinearToLinear( in vec4 value ) {
	return value;
}
vec4 LinearTosRGB( in vec4 value ) {
	return vec4( mix( pow( value.rgb, vec3( 0.41666 ) ) * 1.055 - vec3( 0.055 ), value.rgb * 12.92, vec3( lessThanEqual( value.rgb, vec3( 0.0031308 ) ) ) ), value.a );
}`,oM=`#ifdef USE_ENVMAP
	#ifdef ENV_WORLDPOS
		vec3 cameraToFrag;
		if ( isOrthographic ) {
			cameraToFrag = normalize( vec3( - viewMatrix[ 0 ][ 2 ], - viewMatrix[ 1 ][ 2 ], - viewMatrix[ 2 ][ 2 ] ) );
		} else {
			cameraToFrag = normalize( vWorldPosition - cameraPosition );
		}
		vec3 worldNormal = inverseTransformDirection( normal, viewMatrix );
		#ifdef ENVMAP_MODE_REFLECTION
			vec3 reflectVec = reflect( cameraToFrag, worldNormal );
		#else
			vec3 reflectVec = refract( cameraToFrag, worldNormal, refractionRatio );
		#endif
	#else
		vec3 reflectVec = vReflect;
	#endif
	#ifdef ENVMAP_TYPE_CUBE
		vec4 envColor = textureCube( envMap, vec3( flipEnvMap * reflectVec.x, reflectVec.yz ) );
	#elif defined( ENVMAP_TYPE_CUBE_UV )
		vec4 envColor = textureCubeUV( envMap, reflectVec, 0.0 );
	#else
		vec4 envColor = vec4( 0.0 );
	#endif
	#ifdef ENVMAP_BLENDING_MULTIPLY
		outgoingLight = mix( outgoingLight, outgoingLight * envColor.xyz, specularStrength * reflectivity );
	#elif defined( ENVMAP_BLENDING_MIX )
		outgoingLight = mix( outgoingLight, envColor.xyz, specularStrength * reflectivity );
	#elif defined( ENVMAP_BLENDING_ADD )
		outgoingLight += envColor.xyz * specularStrength * reflectivity;
	#endif
#endif`,aM=`#ifdef USE_ENVMAP
	uniform float envMapIntensity;
	uniform float flipEnvMap;
	#ifdef ENVMAP_TYPE_CUBE
		uniform samplerCube envMap;
	#else
		uniform sampler2D envMap;
	#endif
	
#endif`,rM=`#ifdef USE_ENVMAP
	uniform float reflectivity;
	#if defined( USE_BUMPMAP ) || defined( USE_NORMALMAP ) || defined( PHONG ) || defined( LAMBERT )
		#define ENV_WORLDPOS
	#endif
	#ifdef ENV_WORLDPOS
		varying vec3 vWorldPosition;
		uniform float refractionRatio;
	#else
		varying vec3 vReflect;
	#endif
#endif`,sM=`#ifdef USE_ENVMAP
	#if defined( USE_BUMPMAP ) || defined( USE_NORMALMAP ) || defined( PHONG ) || defined( LAMBERT )
		#define ENV_WORLDPOS
	#endif
	#ifdef ENV_WORLDPOS
		
		varying vec3 vWorldPosition;
	#else
		varying vec3 vReflect;
		uniform float refractionRatio;
	#endif
#endif`,lM=`#ifdef USE_ENVMAP
	#ifdef ENV_WORLDPOS
		vWorldPosition = worldPosition.xyz;
	#else
		vec3 cameraToVertex;
		if ( isOrthographic ) {
			cameraToVertex = normalize( vec3( - viewMatrix[ 0 ][ 2 ], - viewMatrix[ 1 ][ 2 ], - viewMatrix[ 2 ][ 2 ] ) );
		} else {
			cameraToVertex = normalize( worldPosition.xyz - cameraPosition );
		}
		vec3 worldNormal = inverseTransformDirection( transformedNormal, viewMatrix );
		#ifdef ENVMAP_MODE_REFLECTION
			vReflect = reflect( cameraToVertex, worldNormal );
		#else
			vReflect = refract( cameraToVertex, worldNormal, refractionRatio );
		#endif
	#endif
#endif`,uM=`#ifdef USE_FOG
	vFogDepth = - mvPosition.z;
#endif`,cM=`#ifdef USE_FOG
	varying float vFogDepth;
#endif`,dM=`#ifdef USE_FOG
	#ifdef FOG_EXP2
		float fogFactor = 1.0 - exp( - fogDensity * fogDensity * vFogDepth * vFogDepth );
	#else
		float fogFactor = smoothstep( fogNear, fogFar, vFogDepth );
	#endif
	gl_FragColor.rgb = mix( gl_FragColor.rgb, fogColor, fogFactor );
#endif`,fM=`#ifdef USE_FOG
	uniform vec3 fogColor;
	varying float vFogDepth;
	#ifdef FOG_EXP2
		uniform float fogDensity;
	#else
		uniform float fogNear;
		uniform float fogFar;
	#endif
#endif`,hM=`#ifdef USE_GRADIENTMAP
	uniform sampler2D gradientMap;
#endif
vec3 getGradientIrradiance( vec3 normal, vec3 lightDirection ) {
	float dotNL = dot( normal, lightDirection );
	vec2 coord = vec2( dotNL * 0.5 + 0.5, 0.0 );
	#ifdef USE_GRADIENTMAP
		return vec3( texture2D( gradientMap, coord ).r );
	#else
		vec2 fw = fwidth( coord ) * 0.5;
		return mix( vec3( 0.7 ), vec3( 1.0 ), smoothstep( 0.7 - fw.x, 0.7 + fw.x, coord.x ) );
	#endif
}`,pM=`#ifdef USE_LIGHTMAP
	vec4 lightMapTexel = texture2D( lightMap, vUv2 );
	vec3 lightMapIrradiance = lightMapTexel.rgb * lightMapIntensity;
	reflectedLight.indirectDiffuse += lightMapIrradiance;
#endif`,mM=`#ifdef USE_LIGHTMAP
	uniform sampler2D lightMap;
	uniform float lightMapIntensity;
#endif`,gM=`LambertMaterial material;
material.diffuseColor = diffuseColor.rgb;
material.specularStrength = specularStrength;`,_M=`varying vec3 vViewPosition;
struct LambertMaterial {
	vec3 diffuseColor;
	float specularStrength;
};
void RE_Direct_Lambert( const in IncidentLight directLight, const in GeometricContext geometry, const in LambertMaterial material, inout ReflectedLight reflectedLight ) {
	float dotNL = saturate( dot( geometry.normal, directLight.direction ) );
	vec3 irradiance = dotNL * directLight.color;
	reflectedLight.directDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
void RE_IndirectDiffuse_Lambert( const in vec3 irradiance, const in GeometricContext geometry, const in LambertMaterial material, inout ReflectedLight reflectedLight ) {
	reflectedLight.indirectDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
#define RE_Direct				RE_Direct_Lambert
#define RE_IndirectDiffuse		RE_IndirectDiffuse_Lambert
#define Material_LightProbeLOD( material )	(0)`,vM=`uniform bool receiveShadow;
uniform vec3 ambientLightColor;
uniform vec3 lightProbe[ 9 ];
vec3 shGetIrradianceAt( in vec3 normal, in vec3 shCoefficients[ 9 ] ) {
	float x = normal.x, y = normal.y, z = normal.z;
	vec3 result = shCoefficients[ 0 ] * 0.886227;
	result += shCoefficients[ 1 ] * 2.0 * 0.511664 * y;
	result += shCoefficients[ 2 ] * 2.0 * 0.511664 * z;
	result += shCoefficients[ 3 ] * 2.0 * 0.511664 * x;
	result += shCoefficients[ 4 ] * 2.0 * 0.429043 * x * y;
	result += shCoefficients[ 5 ] * 2.0 * 0.429043 * y * z;
	result += shCoefficients[ 6 ] * ( 0.743125 * z * z - 0.247708 );
	result += shCoefficients[ 7 ] * 2.0 * 0.429043 * x * z;
	result += shCoefficients[ 8 ] * 0.429043 * ( x * x - y * y );
	return result;
}
vec3 getLightProbeIrradiance( const in vec3 lightProbe[ 9 ], const in vec3 normal ) {
	vec3 worldNormal = inverseTransformDirection( normal, viewMatrix );
	vec3 irradiance = shGetIrradianceAt( worldNormal, lightProbe );
	return irradiance;
}
vec3 getAmbientLightIrradiance( const in vec3 ambientLightColor ) {
	vec3 irradiance = ambientLightColor;
	return irradiance;
}
float getDistanceAttenuation( const in float lightDistance, const in float cutoffDistance, const in float decayExponent ) {
	#if defined ( PHYSICALLY_CORRECT_LIGHTS )
		float distanceFalloff = 1.0 / max( pow( lightDistance, decayExponent ), 0.01 );
		if ( cutoffDistance > 0.0 ) {
			distanceFalloff *= pow2( saturate( 1.0 - pow4( lightDistance / cutoffDistance ) ) );
		}
		return distanceFalloff;
	#else
		if ( cutoffDistance > 0.0 && decayExponent > 0.0 ) {
			return pow( saturate( - lightDistance / cutoffDistance + 1.0 ), decayExponent );
		}
		return 1.0;
	#endif
}
float getSpotAttenuation( const in float coneCosine, const in float penumbraCosine, const in float angleCosine ) {
	return smoothstep( coneCosine, penumbraCosine, angleCosine );
}
#if NUM_DIR_LIGHTS > 0
	struct DirectionalLight {
		vec3 direction;
		vec3 color;
	};
	uniform DirectionalLight directionalLights[ NUM_DIR_LIGHTS ];
	void getDirectionalLightInfo( const in DirectionalLight directionalLight, const in GeometricContext geometry, out IncidentLight light ) {
		light.color = directionalLight.color;
		light.direction = directionalLight.direction;
		light.visible = true;
	}
#endif
#if NUM_POINT_LIGHTS > 0
	struct PointLight {
		vec3 position;
		vec3 color;
		float distance;
		float decay;
	};
	uniform PointLight pointLights[ NUM_POINT_LIGHTS ];
	void getPointLightInfo( const in PointLight pointLight, const in GeometricContext geometry, out IncidentLight light ) {
		vec3 lVector = pointLight.position - geometry.position;
		light.direction = normalize( lVector );
		float lightDistance = length( lVector );
		light.color = pointLight.color;
		light.color *= getDistanceAttenuation( lightDistance, pointLight.distance, pointLight.decay );
		light.visible = ( light.color != vec3( 0.0 ) );
	}
#endif
#if NUM_SPOT_LIGHTS > 0
	struct SpotLight {
		vec3 position;
		vec3 direction;
		vec3 color;
		float distance;
		float decay;
		float coneCos;
		float penumbraCos;
	};
	uniform SpotLight spotLights[ NUM_SPOT_LIGHTS ];
	void getSpotLightInfo( const in SpotLight spotLight, const in GeometricContext geometry, out IncidentLight light ) {
		vec3 lVector = spotLight.position - geometry.position;
		light.direction = normalize( lVector );
		float angleCos = dot( light.direction, spotLight.direction );
		float spotAttenuation = getSpotAttenuation( spotLight.coneCos, spotLight.penumbraCos, angleCos );
		if ( spotAttenuation > 0.0 ) {
			float lightDistance = length( lVector );
			light.color = spotLight.color * spotAttenuation;
			light.color *= getDistanceAttenuation( lightDistance, spotLight.distance, spotLight.decay );
			light.visible = ( light.color != vec3( 0.0 ) );
		} else {
			light.color = vec3( 0.0 );
			light.visible = false;
		}
	}
#endif
#if NUM_RECT_AREA_LIGHTS > 0
	struct RectAreaLight {
		vec3 color;
		vec3 position;
		vec3 halfWidth;
		vec3 halfHeight;
	};
	uniform sampler2D ltc_1;	uniform sampler2D ltc_2;
	uniform RectAreaLight rectAreaLights[ NUM_RECT_AREA_LIGHTS ];
#endif
#if NUM_HEMI_LIGHTS > 0
	struct HemisphereLight {
		vec3 direction;
		vec3 skyColor;
		vec3 groundColor;
	};
	uniform HemisphereLight hemisphereLights[ NUM_HEMI_LIGHTS ];
	vec3 getHemisphereLightIrradiance( const in HemisphereLight hemiLight, const in vec3 normal ) {
		float dotNL = dot( normal, hemiLight.direction );
		float hemiDiffuseWeight = 0.5 * dotNL + 0.5;
		vec3 irradiance = mix( hemiLight.groundColor, hemiLight.skyColor, hemiDiffuseWeight );
		return irradiance;
	}
#endif`,yM=`#if defined( USE_ENVMAP )
	vec3 getIBLIrradiance( const in vec3 normal ) {
		#if defined( ENVMAP_TYPE_CUBE_UV )
			vec3 worldNormal = inverseTransformDirection( normal, viewMatrix );
			vec4 envMapColor = textureCubeUV( envMap, worldNormal, 1.0 );
			return PI * envMapColor.rgb * envMapIntensity;
		#else
			return vec3( 0.0 );
		#endif
	}
	vec3 getIBLRadiance( const in vec3 viewDir, const in vec3 normal, const in float roughness ) {
		#if defined( ENVMAP_TYPE_CUBE_UV )
			vec3 reflectVec = reflect( - viewDir, normal );
			reflectVec = normalize( mix( reflectVec, normal, roughness * roughness) );
			reflectVec = inverseTransformDirection( reflectVec, viewMatrix );
			vec4 envMapColor = textureCubeUV( envMap, reflectVec, roughness );
			return envMapColor.rgb * envMapIntensity;
		#else
			return vec3( 0.0 );
		#endif
	}
#endif`,bM=`ToonMaterial material;
material.diffuseColor = diffuseColor.rgb;`,xM=`varying vec3 vViewPosition;
struct ToonMaterial {
	vec3 diffuseColor;
};
void RE_Direct_Toon( const in IncidentLight directLight, const in GeometricContext geometry, const in ToonMaterial material, inout ReflectedLight reflectedLight ) {
	vec3 irradiance = getGradientIrradiance( geometry.normal, directLight.direction ) * directLight.color;
	reflectedLight.directDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
void RE_IndirectDiffuse_Toon( const in vec3 irradiance, const in GeometricContext geometry, const in ToonMaterial material, inout ReflectedLight reflectedLight ) {
	reflectedLight.indirectDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
#define RE_Direct				RE_Direct_Toon
#define RE_IndirectDiffuse		RE_IndirectDiffuse_Toon
#define Material_LightProbeLOD( material )	(0)`,SM=`BlinnPhongMaterial material;
material.diffuseColor = diffuseColor.rgb;
material.specularColor = specular;
material.specularShininess = shininess;
material.specularStrength = specularStrength;`,MM=`varying vec3 vViewPosition;
struct BlinnPhongMaterial {
	vec3 diffuseColor;
	vec3 specularColor;
	float specularShininess;
	float specularStrength;
};
void RE_Direct_BlinnPhong( const in IncidentLight directLight, const in GeometricContext geometry, const in BlinnPhongMaterial material, inout ReflectedLight reflectedLight ) {
	float dotNL = saturate( dot( geometry.normal, directLight.direction ) );
	vec3 irradiance = dotNL * directLight.color;
	reflectedLight.directDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
	reflectedLight.directSpecular += irradiance * BRDF_BlinnPhong( directLight.direction, geometry.viewDir, geometry.normal, material.specularColor, material.specularShininess ) * material.specularStrength;
}
void RE_IndirectDiffuse_BlinnPhong( const in vec3 irradiance, const in GeometricContext geometry, const in BlinnPhongMaterial material, inout ReflectedLight reflectedLight ) {
	reflectedLight.indirectDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
#define RE_Direct				RE_Direct_BlinnPhong
#define RE_IndirectDiffuse		RE_IndirectDiffuse_BlinnPhong
#define Material_LightProbeLOD( material )	(0)`,AM=`PhysicalMaterial material;
material.diffuseColor = diffuseColor.rgb * ( 1.0 - metalnessFactor );
vec3 dxy = max( abs( dFdx( geometryNormal ) ), abs( dFdy( geometryNormal ) ) );
float geometryRoughness = max( max( dxy.x, dxy.y ), dxy.z );
material.roughness = max( roughnessFactor, 0.0525 );material.roughness += geometryRoughness;
material.roughness = min( material.roughness, 1.0 );
#ifdef IOR
	material.ior = ior;
	#ifdef SPECULAR
		float specularIntensityFactor = specularIntensity;
		vec3 specularColorFactor = specularColor;
		#ifdef USE_SPECULARINTENSITYMAP
			specularIntensityFactor *= texture2D( specularIntensityMap, vUv ).a;
		#endif
		#ifdef USE_SPECULARCOLORMAP
			specularColorFactor *= texture2D( specularColorMap, vUv ).rgb;
		#endif
		material.specularF90 = mix( specularIntensityFactor, 1.0, metalnessFactor );
	#else
		float specularIntensityFactor = 1.0;
		vec3 specularColorFactor = vec3( 1.0 );
		material.specularF90 = 1.0;
	#endif
	material.specularColor = mix( min( pow2( ( material.ior - 1.0 ) / ( material.ior + 1.0 ) ) * specularColorFactor, vec3( 1.0 ) ) * specularIntensityFactor, diffuseColor.rgb, metalnessFactor );
#else
	material.specularColor = mix( vec3( 0.04 ), diffuseColor.rgb, metalnessFactor );
	material.specularF90 = 1.0;
#endif
#ifdef USE_CLEARCOAT
	material.clearcoat = clearcoat;
	material.clearcoatRoughness = clearcoatRoughness;
	material.clearcoatF0 = vec3( 0.04 );
	material.clearcoatF90 = 1.0;
	#ifdef USE_CLEARCOATMAP
		material.clearcoat *= texture2D( clearcoatMap, vUv ).x;
	#endif
	#ifdef USE_CLEARCOAT_ROUGHNESSMAP
		material.clearcoatRoughness *= texture2D( clearcoatRoughnessMap, vUv ).y;
	#endif
	material.clearcoat = saturate( material.clearcoat );	material.clearcoatRoughness = max( material.clearcoatRoughness, 0.0525 );
	material.clearcoatRoughness += geometryRoughness;
	material.clearcoatRoughness = min( material.clearcoatRoughness, 1.0 );
#endif
#ifdef USE_IRIDESCENCE
	material.iridescence = iridescence;
	material.iridescenceIOR = iridescenceIOR;
	#ifdef USE_IRIDESCENCEMAP
		material.iridescence *= texture2D( iridescenceMap, vUv ).r;
	#endif
	#ifdef USE_IRIDESCENCE_THICKNESSMAP
		material.iridescenceThickness = (iridescenceThicknessMaximum - iridescenceThicknessMinimum) * texture2D( iridescenceThicknessMap, vUv ).g + iridescenceThicknessMinimum;
	#else
		material.iridescenceThickness = iridescenceThicknessMaximum;
	#endif
#endif
#ifdef USE_SHEEN
	material.sheenColor = sheenColor;
	#ifdef USE_SHEENCOLORMAP
		material.sheenColor *= texture2D( sheenColorMap, vUv ).rgb;
	#endif
	material.sheenRoughness = clamp( sheenRoughness, 0.07, 1.0 );
	#ifdef USE_SHEENROUGHNESSMAP
		material.sheenRoughness *= texture2D( sheenRoughnessMap, vUv ).a;
	#endif
#endif`,wM=`struct PhysicalMaterial {
	vec3 diffuseColor;
	float roughness;
	vec3 specularColor;
	float specularF90;
	#ifdef USE_CLEARCOAT
		float clearcoat;
		float clearcoatRoughness;
		vec3 clearcoatF0;
		float clearcoatF90;
	#endif
	#ifdef USE_IRIDESCENCE
		float iridescence;
		float iridescenceIOR;
		float iridescenceThickness;
		vec3 iridescenceFresnel;
		vec3 iridescenceF0;
	#endif
	#ifdef USE_SHEEN
		vec3 sheenColor;
		float sheenRoughness;
	#endif
	#ifdef IOR
		float ior;
	#endif
	#ifdef USE_TRANSMISSION
		float transmission;
		float transmissionAlpha;
		float thickness;
		float attenuationDistance;
		vec3 attenuationColor;
	#endif
};
vec3 clearcoatSpecular = vec3( 0.0 );
vec3 sheenSpecular = vec3( 0.0 );
float IBLSheenBRDF( const in vec3 normal, const in vec3 viewDir, const in float roughness ) {
	float dotNV = saturate( dot( normal, viewDir ) );
	float r2 = roughness * roughness;
	float a = roughness < 0.25 ? -339.2 * r2 + 161.4 * roughness - 25.9 : -8.48 * r2 + 14.3 * roughness - 9.95;
	float b = roughness < 0.25 ? 44.0 * r2 - 23.7 * roughness + 3.26 : 1.97 * r2 - 3.27 * roughness + 0.72;
	float DG = exp( a * dotNV + b ) + ( roughness < 0.25 ? 0.0 : 0.1 * ( roughness - 0.25 ) );
	return saturate( DG * RECIPROCAL_PI );
}
vec2 DFGApprox( const in vec3 normal, const in vec3 viewDir, const in float roughness ) {
	float dotNV = saturate( dot( normal, viewDir ) );
	const vec4 c0 = vec4( - 1, - 0.0275, - 0.572, 0.022 );
	const vec4 c1 = vec4( 1, 0.0425, 1.04, - 0.04 );
	vec4 r = roughness * c0 + c1;
	float a004 = min( r.x * r.x, exp2( - 9.28 * dotNV ) ) * r.x + r.y;
	vec2 fab = vec2( - 1.04, 1.04 ) * a004 + r.zw;
	return fab;
}
vec3 EnvironmentBRDF( const in vec3 normal, const in vec3 viewDir, const in vec3 specularColor, const in float specularF90, const in float roughness ) {
	vec2 fab = DFGApprox( normal, viewDir, roughness );
	return specularColor * fab.x + specularF90 * fab.y;
}
#ifdef USE_IRIDESCENCE
void computeMultiscatteringIridescence( const in vec3 normal, const in vec3 viewDir, const in vec3 specularColor, const in float specularF90, const in float iridescence, const in vec3 iridescenceF0, const in float roughness, inout vec3 singleScatter, inout vec3 multiScatter ) {
#else
void computeMultiscattering( const in vec3 normal, const in vec3 viewDir, const in vec3 specularColor, const in float specularF90, const in float roughness, inout vec3 singleScatter, inout vec3 multiScatter ) {
#endif
	vec2 fab = DFGApprox( normal, viewDir, roughness );
	#ifdef USE_IRIDESCENCE
		vec3 Fr = mix( specularColor, iridescenceF0, iridescence );
	#else
		vec3 Fr = specularColor;
	#endif
	vec3 FssEss = Fr * fab.x + specularF90 * fab.y;
	float Ess = fab.x + fab.y;
	float Ems = 1.0 - Ess;
	vec3 Favg = Fr + ( 1.0 - Fr ) * 0.047619;	vec3 Fms = FssEss * Favg / ( 1.0 - Ems * Favg );
	singleScatter += FssEss;
	multiScatter += Fms * Ems;
}
#if NUM_RECT_AREA_LIGHTS > 0
	void RE_Direct_RectArea_Physical( const in RectAreaLight rectAreaLight, const in GeometricContext geometry, const in PhysicalMaterial material, inout ReflectedLight reflectedLight ) {
		vec3 normal = geometry.normal;
		vec3 viewDir = geometry.viewDir;
		vec3 position = geometry.position;
		vec3 lightPos = rectAreaLight.position;
		vec3 halfWidth = rectAreaLight.halfWidth;
		vec3 halfHeight = rectAreaLight.halfHeight;
		vec3 lightColor = rectAreaLight.color;
		float roughness = material.roughness;
		vec3 rectCoords[ 4 ];
		rectCoords[ 0 ] = lightPos + halfWidth - halfHeight;		rectCoords[ 1 ] = lightPos - halfWidth - halfHeight;
		rectCoords[ 2 ] = lightPos - halfWidth + halfHeight;
		rectCoords[ 3 ] = lightPos + halfWidth + halfHeight;
		vec2 uv = LTC_Uv( normal, viewDir, roughness );
		vec4 t1 = texture2D( ltc_1, uv );
		vec4 t2 = texture2D( ltc_2, uv );
		mat3 mInv = mat3(
			vec3( t1.x, 0, t1.y ),
			vec3(    0, 1,    0 ),
			vec3( t1.z, 0, t1.w )
		);
		vec3 fresnel = ( material.specularColor * t2.x + ( vec3( 1.0 ) - material.specularColor ) * t2.y );
		reflectedLight.directSpecular += lightColor * fresnel * LTC_Evaluate( normal, viewDir, position, mInv, rectCoords );
		reflectedLight.directDiffuse += lightColor * material.diffuseColor * LTC_Evaluate( normal, viewDir, position, mat3( 1.0 ), rectCoords );
	}
#endif
void RE_Direct_Physical( const in IncidentLight directLight, const in GeometricContext geometry, const in PhysicalMaterial material, inout ReflectedLight reflectedLight ) {
	float dotNL = saturate( dot( geometry.normal, directLight.direction ) );
	vec3 irradiance = dotNL * directLight.color;
	#ifdef USE_CLEARCOAT
		float dotNLcc = saturate( dot( geometry.clearcoatNormal, directLight.direction ) );
		vec3 ccIrradiance = dotNLcc * directLight.color;
		clearcoatSpecular += ccIrradiance * BRDF_GGX( directLight.direction, geometry.viewDir, geometry.clearcoatNormal, material.clearcoatF0, material.clearcoatF90, material.clearcoatRoughness );
	#endif
	#ifdef USE_SHEEN
		sheenSpecular += irradiance * BRDF_Sheen( directLight.direction, geometry.viewDir, geometry.normal, material.sheenColor, material.sheenRoughness );
	#endif
	#ifdef USE_IRIDESCENCE
		reflectedLight.directSpecular += irradiance * BRDF_GGX_Iridescence( directLight.direction, geometry.viewDir, geometry.normal, material.specularColor, material.specularF90, material.iridescence, material.iridescenceFresnel, material.roughness );
	#else
		reflectedLight.directSpecular += irradiance * BRDF_GGX( directLight.direction, geometry.viewDir, geometry.normal, material.specularColor, material.specularF90, material.roughness );
	#endif
	reflectedLight.directDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
void RE_IndirectDiffuse_Physical( const in vec3 irradiance, const in GeometricContext geometry, const in PhysicalMaterial material, inout ReflectedLight reflectedLight ) {
	reflectedLight.indirectDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
void RE_IndirectSpecular_Physical( const in vec3 radiance, const in vec3 irradiance, const in vec3 clearcoatRadiance, const in GeometricContext geometry, const in PhysicalMaterial material, inout ReflectedLight reflectedLight) {
	#ifdef USE_CLEARCOAT
		clearcoatSpecular += clearcoatRadiance * EnvironmentBRDF( geometry.clearcoatNormal, geometry.viewDir, material.clearcoatF0, material.clearcoatF90, material.clearcoatRoughness );
	#endif
	#ifdef USE_SHEEN
		sheenSpecular += irradiance * material.sheenColor * IBLSheenBRDF( geometry.normal, geometry.viewDir, material.sheenRoughness );
	#endif
	vec3 singleScattering = vec3( 0.0 );
	vec3 multiScattering = vec3( 0.0 );
	vec3 cosineWeightedIrradiance = irradiance * RECIPROCAL_PI;
	#ifdef USE_IRIDESCENCE
		computeMultiscatteringIridescence( geometry.normal, geometry.viewDir, material.specularColor, material.specularF90, material.iridescence, material.iridescenceFresnel, material.roughness, singleScattering, multiScattering );
	#else
		computeMultiscattering( geometry.normal, geometry.viewDir, material.specularColor, material.specularF90, material.roughness, singleScattering, multiScattering );
	#endif
	vec3 totalScattering = singleScattering + multiScattering;
	vec3 diffuse = material.diffuseColor * ( 1.0 - max( max( totalScattering.r, totalScattering.g ), totalScattering.b ) );
	reflectedLight.indirectSpecular += radiance * singleScattering;
	reflectedLight.indirectSpecular += multiScattering * cosineWeightedIrradiance;
	reflectedLight.indirectDiffuse += diffuse * cosineWeightedIrradiance;
}
#define RE_Direct				RE_Direct_Physical
#define RE_Direct_RectArea		RE_Direct_RectArea_Physical
#define RE_IndirectDiffuse		RE_IndirectDiffuse_Physical
#define RE_IndirectSpecular		RE_IndirectSpecular_Physical
float computeSpecularOcclusion( const in float dotNV, const in float ambientOcclusion, const in float roughness ) {
	return saturate( pow( dotNV + ambientOcclusion, exp2( - 16.0 * roughness - 1.0 ) ) - 1.0 + ambientOcclusion );
}`,CM=`
GeometricContext geometry;
geometry.position = - vViewPosition;
geometry.normal = normal;
geometry.viewDir = ( isOrthographic ) ? vec3( 0, 0, 1 ) : normalize( vViewPosition );
#ifdef USE_CLEARCOAT
	geometry.clearcoatNormal = clearcoatNormal;
#endif
#ifdef USE_IRIDESCENCE
	float dotNVi = saturate( dot( normal, geometry.viewDir ) );
	if ( material.iridescenceThickness == 0.0 ) {
		material.iridescence = 0.0;
	} else {
		material.iridescence = saturate( material.iridescence );
	}
	if ( material.iridescence > 0.0 ) {
		material.iridescenceFresnel = evalIridescence( 1.0, material.iridescenceIOR, dotNVi, material.iridescenceThickness, material.specularColor );
		material.iridescenceF0 = Schlick_to_F0( material.iridescenceFresnel, 1.0, dotNVi );
	}
#endif
IncidentLight directLight;
#if ( NUM_POINT_LIGHTS > 0 ) && defined( RE_Direct )
	PointLight pointLight;
	#if defined( USE_SHADOWMAP ) && NUM_POINT_LIGHT_SHADOWS > 0
	PointLightShadow pointLightShadow;
	#endif
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_POINT_LIGHTS; i ++ ) {
		pointLight = pointLights[ i ];
		getPointLightInfo( pointLight, geometry, directLight );
		#if defined( USE_SHADOWMAP ) && ( UNROLLED_LOOP_INDEX < NUM_POINT_LIGHT_SHADOWS )
		pointLightShadow = pointLightShadows[ i ];
		directLight.color *= all( bvec2( directLight.visible, receiveShadow ) ) ? getPointShadow( pointShadowMap[ i ], pointLightShadow.shadowMapSize, pointLightShadow.shadowBias, pointLightShadow.shadowRadius, vPointShadowCoord[ i ], pointLightShadow.shadowCameraNear, pointLightShadow.shadowCameraFar ) : 1.0;
		#endif
		RE_Direct( directLight, geometry, material, reflectedLight );
	}
	#pragma unroll_loop_end
#endif
#if ( NUM_SPOT_LIGHTS > 0 ) && defined( RE_Direct )
	SpotLight spotLight;
	vec4 spotColor;
	vec3 spotLightCoord;
	bool inSpotLightMap;
	#if defined( USE_SHADOWMAP ) && NUM_SPOT_LIGHT_SHADOWS > 0
	SpotLightShadow spotLightShadow;
	#endif
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_SPOT_LIGHTS; i ++ ) {
		spotLight = spotLights[ i ];
		getSpotLightInfo( spotLight, geometry, directLight );
		#if ( UNROLLED_LOOP_INDEX < NUM_SPOT_LIGHT_SHADOWS_WITH_MAPS )
		#define SPOT_LIGHT_MAP_INDEX UNROLLED_LOOP_INDEX
		#elif ( UNROLLED_LOOP_INDEX < NUM_SPOT_LIGHT_SHADOWS )
		#define SPOT_LIGHT_MAP_INDEX NUM_SPOT_LIGHT_MAPS
		#else
		#define SPOT_LIGHT_MAP_INDEX ( UNROLLED_LOOP_INDEX - NUM_SPOT_LIGHT_SHADOWS + NUM_SPOT_LIGHT_SHADOWS_WITH_MAPS )
		#endif
		#if ( SPOT_LIGHT_MAP_INDEX < NUM_SPOT_LIGHT_MAPS )
			spotLightCoord = vSpotLightCoord[ i ].xyz / vSpotLightCoord[ i ].w;
			inSpotLightMap = all( lessThan( abs( spotLightCoord * 2. - 1. ), vec3( 1.0 ) ) );
			spotColor = texture2D( spotLightMap[ SPOT_LIGHT_MAP_INDEX ], spotLightCoord.xy );
			directLight.color = inSpotLightMap ? directLight.color * spotColor.rgb : directLight.color;
		#endif
		#undef SPOT_LIGHT_MAP_INDEX
		#if defined( USE_SHADOWMAP ) && ( UNROLLED_LOOP_INDEX < NUM_SPOT_LIGHT_SHADOWS )
		spotLightShadow = spotLightShadows[ i ];
		directLight.color *= all( bvec2( directLight.visible, receiveShadow ) ) ? getShadow( spotShadowMap[ i ], spotLightShadow.shadowMapSize, spotLightShadow.shadowBias, spotLightShadow.shadowRadius, vSpotLightCoord[ i ] ) : 1.0;
		#endif
		RE_Direct( directLight, geometry, material, reflectedLight );
	}
	#pragma unroll_loop_end
#endif
#if ( NUM_DIR_LIGHTS > 0 ) && defined( RE_Direct )
	DirectionalLight directionalLight;
	#if defined( USE_SHADOWMAP ) && NUM_DIR_LIGHT_SHADOWS > 0
	DirectionalLightShadow directionalLightShadow;
	#endif
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_DIR_LIGHTS; i ++ ) {
		directionalLight = directionalLights[ i ];
		getDirectionalLightInfo( directionalLight, geometry, directLight );
		#if defined( USE_SHADOWMAP ) && ( UNROLLED_LOOP_INDEX < NUM_DIR_LIGHT_SHADOWS )
		directionalLightShadow = directionalLightShadows[ i ];
		directLight.color *= all( bvec2( directLight.visible, receiveShadow ) ) ? getShadow( directionalShadowMap[ i ], directionalLightShadow.shadowMapSize, directionalLightShadow.shadowBias, directionalLightShadow.shadowRadius, vDirectionalShadowCoord[ i ] ) : 1.0;
		#endif
		RE_Direct( directLight, geometry, material, reflectedLight );
	}
	#pragma unroll_loop_end
#endif
#if ( NUM_RECT_AREA_LIGHTS > 0 ) && defined( RE_Direct_RectArea )
	RectAreaLight rectAreaLight;
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_RECT_AREA_LIGHTS; i ++ ) {
		rectAreaLight = rectAreaLights[ i ];
		RE_Direct_RectArea( rectAreaLight, geometry, material, reflectedLight );
	}
	#pragma unroll_loop_end
#endif
#if defined( RE_IndirectDiffuse )
	vec3 iblIrradiance = vec3( 0.0 );
	vec3 irradiance = getAmbientLightIrradiance( ambientLightColor );
	irradiance += getLightProbeIrradiance( lightProbe, geometry.normal );
	#if ( NUM_HEMI_LIGHTS > 0 )
		#pragma unroll_loop_start
		for ( int i = 0; i < NUM_HEMI_LIGHTS; i ++ ) {
			irradiance += getHemisphereLightIrradiance( hemisphereLights[ i ], geometry.normal );
		}
		#pragma unroll_loop_end
	#endif
#endif
#if defined( RE_IndirectSpecular )
	vec3 radiance = vec3( 0.0 );
	vec3 clearcoatRadiance = vec3( 0.0 );
#endif`,TM=`#if defined( RE_IndirectDiffuse )
	#ifdef USE_LIGHTMAP
		vec4 lightMapTexel = texture2D( lightMap, vUv2 );
		vec3 lightMapIrradiance = lightMapTexel.rgb * lightMapIntensity;
		irradiance += lightMapIrradiance;
	#endif
	#if defined( USE_ENVMAP ) && defined( STANDARD ) && defined( ENVMAP_TYPE_CUBE_UV )
		iblIrradiance += getIBLIrradiance( geometry.normal );
	#endif
#endif
#if defined( USE_ENVMAP ) && defined( RE_IndirectSpecular )
	radiance += getIBLRadiance( geometry.viewDir, geometry.normal, material.roughness );
	#ifdef USE_CLEARCOAT
		clearcoatRadiance += getIBLRadiance( geometry.viewDir, geometry.clearcoatNormal, material.clearcoatRoughness );
	#endif
#endif`,EM=`#if defined( RE_IndirectDiffuse )
	RE_IndirectDiffuse( irradiance, geometry, material, reflectedLight );
#endif
#if defined( RE_IndirectSpecular )
	RE_IndirectSpecular( radiance, iblIrradiance, clearcoatRadiance, geometry, material, reflectedLight );
#endif`,DM=`#if defined( USE_LOGDEPTHBUF ) && defined( USE_LOGDEPTHBUF_EXT )
	gl_FragDepthEXT = vIsPerspective == 0.0 ? gl_FragCoord.z : log2( vFragDepth ) * logDepthBufFC * 0.5;
#endif`,IM=`#if defined( USE_LOGDEPTHBUF ) && defined( USE_LOGDEPTHBUF_EXT )
	uniform float logDepthBufFC;
	varying float vFragDepth;
	varying float vIsPerspective;
#endif`,RM=`#ifdef USE_LOGDEPTHBUF
	#ifdef USE_LOGDEPTHBUF_EXT
		varying float vFragDepth;
		varying float vIsPerspective;
	#else
		uniform float logDepthBufFC;
	#endif
#endif`,OM=`#ifdef USE_LOGDEPTHBUF
	#ifdef USE_LOGDEPTHBUF_EXT
		vFragDepth = 1.0 + gl_Position.w;
		vIsPerspective = float( isPerspectiveMatrix( projectionMatrix ) );
	#else
		if ( isPerspectiveMatrix( projectionMatrix ) ) {
			gl_Position.z = log2( max( EPSILON, gl_Position.w + 1.0 ) ) * logDepthBufFC - 1.0;
			gl_Position.z *= gl_Position.w;
		}
	#endif
#endif`,PM=`#ifdef USE_MAP
	vec4 sampledDiffuseColor = texture2D( map, vUv );
	#ifdef DECODE_VIDEO_TEXTURE
		sampledDiffuseColor = vec4( mix( pow( sampledDiffuseColor.rgb * 0.9478672986 + vec3( 0.0521327014 ), vec3( 2.4 ) ), sampledDiffuseColor.rgb * 0.0773993808, vec3( lessThanEqual( sampledDiffuseColor.rgb, vec3( 0.04045 ) ) ) ), sampledDiffuseColor.w );
	#endif
	diffuseColor *= sampledDiffuseColor;
#endif`,LM=`#ifdef USE_MAP
	uniform sampler2D map;
#endif`,zM=`#if defined( USE_MAP ) || defined( USE_ALPHAMAP )
	vec2 uv = ( uvTransform * vec3( gl_PointCoord.x, 1.0 - gl_PointCoord.y, 1 ) ).xy;
#endif
#ifdef USE_MAP
	diffuseColor *= texture2D( map, uv );
#endif
#ifdef USE_ALPHAMAP
	diffuseColor.a *= texture2D( alphaMap, uv ).g;
#endif`,kM=`#if defined( USE_MAP ) || defined( USE_ALPHAMAP )
	uniform mat3 uvTransform;
#endif
#ifdef USE_MAP
	uniform sampler2D map;
#endif
#ifdef USE_ALPHAMAP
	uniform sampler2D alphaMap;
#endif`,NM=`float metalnessFactor = metalness;
#ifdef USE_METALNESSMAP
	vec4 texelMetalness = texture2D( metalnessMap, vUv );
	metalnessFactor *= texelMetalness.b;
#endif`,UM=`#ifdef USE_METALNESSMAP
	uniform sampler2D metalnessMap;
#endif`,FM=`#if defined( USE_MORPHCOLORS ) && defined( MORPHTARGETS_TEXTURE )
	vColor *= morphTargetBaseInfluence;
	for ( int i = 0; i < MORPHTARGETS_COUNT; i ++ ) {
		#if defined( USE_COLOR_ALPHA )
			if ( morphTargetInfluences[ i ] != 0.0 ) vColor += getMorph( gl_VertexID, i, 2 ) * morphTargetInfluences[ i ];
		#elif defined( USE_COLOR )
			if ( morphTargetInfluences[ i ] != 0.0 ) vColor += getMorph( gl_VertexID, i, 2 ).rgb * morphTargetInfluences[ i ];
		#endif
	}
#endif`,BM=`#ifdef USE_MORPHNORMALS
	objectNormal *= morphTargetBaseInfluence;
	#ifdef MORPHTARGETS_TEXTURE
		for ( int i = 0; i < MORPHTARGETS_COUNT; i ++ ) {
			if ( morphTargetInfluences[ i ] != 0.0 ) objectNormal += getMorph( gl_VertexID, i, 1 ).xyz * morphTargetInfluences[ i ];
		}
	#else
		objectNormal += morphNormal0 * morphTargetInfluences[ 0 ];
		objectNormal += morphNormal1 * morphTargetInfluences[ 1 ];
		objectNormal += morphNormal2 * morphTargetInfluences[ 2 ];
		objectNormal += morphNormal3 * morphTargetInfluences[ 3 ];
	#endif
#endif`,GM=`#ifdef USE_MORPHTARGETS
	uniform float morphTargetBaseInfluence;
	#ifdef MORPHTARGETS_TEXTURE
		uniform float morphTargetInfluences[ MORPHTARGETS_COUNT ];
		uniform sampler2DArray morphTargetsTexture;
		uniform ivec2 morphTargetsTextureSize;
		vec4 getMorph( const in int vertexIndex, const in int morphTargetIndex, const in int offset ) {
			int texelIndex = vertexIndex * MORPHTARGETS_TEXTURE_STRIDE + offset;
			int y = texelIndex / morphTargetsTextureSize.x;
			int x = texelIndex - y * morphTargetsTextureSize.x;
			ivec3 morphUV = ivec3( x, y, morphTargetIndex );
			return texelFetch( morphTargetsTexture, morphUV, 0 );
		}
	#else
		#ifndef USE_MORPHNORMALS
			uniform float morphTargetInfluences[ 8 ];
		#else
			uniform float morphTargetInfluences[ 4 ];
		#endif
	#endif
#endif`,VM=`#ifdef USE_MORPHTARGETS
	transformed *= morphTargetBaseInfluence;
	#ifdef MORPHTARGETS_TEXTURE
		for ( int i = 0; i < MORPHTARGETS_COUNT; i ++ ) {
			if ( morphTargetInfluences[ i ] != 0.0 ) transformed += getMorph( gl_VertexID, i, 0 ).xyz * morphTargetInfluences[ i ];
		}
	#else
		transformed += morphTarget0 * morphTargetInfluences[ 0 ];
		transformed += morphTarget1 * morphTargetInfluences[ 1 ];
		transformed += morphTarget2 * morphTargetInfluences[ 2 ];
		transformed += morphTarget3 * morphTargetInfluences[ 3 ];
		#ifndef USE_MORPHNORMALS
			transformed += morphTarget4 * morphTargetInfluences[ 4 ];
			transformed += morphTarget5 * morphTargetInfluences[ 5 ];
			transformed += morphTarget6 * morphTargetInfluences[ 6 ];
			transformed += morphTarget7 * morphTargetInfluences[ 7 ];
		#endif
	#endif
#endif`,jM=`float faceDirection = gl_FrontFacing ? 1.0 : - 1.0;
#ifdef FLAT_SHADED
	vec3 fdx = dFdx( vViewPosition );
	vec3 fdy = dFdy( vViewPosition );
	vec3 normal = normalize( cross( fdx, fdy ) );
#else
	vec3 normal = normalize( vNormal );
	#ifdef DOUBLE_SIDED
		normal = normal * faceDirection;
	#endif
	#ifdef USE_TANGENT
		vec3 tangent = normalize( vTangent );
		vec3 bitangent = normalize( vBitangent );
		#ifdef DOUBLE_SIDED
			tangent = tangent * faceDirection;
			bitangent = bitangent * faceDirection;
		#endif
		#if defined( TANGENTSPACE_NORMALMAP ) || defined( USE_CLEARCOAT_NORMALMAP )
			mat3 vTBN = mat3( tangent, bitangent, normal );
		#endif
	#endif
#endif
vec3 geometryNormal = normal;`,WM=`#ifdef OBJECTSPACE_NORMALMAP
	normal = texture2D( normalMap, vUv ).xyz * 2.0 - 1.0;
	#ifdef FLIP_SIDED
		normal = - normal;
	#endif
	#ifdef DOUBLE_SIDED
		normal = normal * faceDirection;
	#endif
	normal = normalize( normalMatrix * normal );
#elif defined( TANGENTSPACE_NORMALMAP )
	vec3 mapN = texture2D( normalMap, vUv ).xyz * 2.0 - 1.0;
	mapN.xy *= normalScale;
	#ifdef USE_TANGENT
		normal = normalize( vTBN * mapN );
	#else
		normal = perturbNormal2Arb( - vViewPosition, normal, mapN, faceDirection );
	#endif
#elif defined( USE_BUMPMAP )
	normal = perturbNormalArb( - vViewPosition, normal, dHdxy_fwd(), faceDirection );
#endif`,HM=`#ifndef FLAT_SHADED
	varying vec3 vNormal;
	#ifdef USE_TANGENT
		varying vec3 vTangent;
		varying vec3 vBitangent;
	#endif
#endif`,YM=`#ifndef FLAT_SHADED
	varying vec3 vNormal;
	#ifdef USE_TANGENT
		varying vec3 vTangent;
		varying vec3 vBitangent;
	#endif
#endif`,$M=`#ifndef FLAT_SHADED
	vNormal = normalize( transformedNormal );
	#ifdef USE_TANGENT
		vTangent = normalize( transformedTangent );
		vBitangent = normalize( cross( vNormal, vTangent ) * tangent.w );
	#endif
#endif`,JM=`#ifdef USE_NORMALMAP
	uniform sampler2D normalMap;
	uniform vec2 normalScale;
#endif
#ifdef OBJECTSPACE_NORMALMAP
	uniform mat3 normalMatrix;
#endif
#if ! defined ( USE_TANGENT ) && ( defined ( TANGENTSPACE_NORMALMAP ) || defined ( USE_CLEARCOAT_NORMALMAP ) )
	vec3 perturbNormal2Arb( vec3 eye_pos, vec3 surf_norm, vec3 mapN, float faceDirection ) {
		vec3 q0 = dFdx( eye_pos.xyz );
		vec3 q1 = dFdy( eye_pos.xyz );
		vec2 st0 = dFdx( vUv.st );
		vec2 st1 = dFdy( vUv.st );
		vec3 N = surf_norm;
		vec3 q1perp = cross( q1, N );
		vec3 q0perp = cross( N, q0 );
		vec3 T = q1perp * st0.x + q0perp * st1.x;
		vec3 B = q1perp * st0.y + q0perp * st1.y;
		float det = max( dot( T, T ), dot( B, B ) );
		float scale = ( det == 0.0 ) ? 0.0 : faceDirection * inversesqrt( det );
		return normalize( T * ( mapN.x * scale ) + B * ( mapN.y * scale ) + N * mapN.z );
	}
#endif`,ZM=`#ifdef USE_CLEARCOAT
	vec3 clearcoatNormal = geometryNormal;
#endif`,XM=`#ifdef USE_CLEARCOAT_NORMALMAP
	vec3 clearcoatMapN = texture2D( clearcoatNormalMap, vUv ).xyz * 2.0 - 1.0;
	clearcoatMapN.xy *= clearcoatNormalScale;
	#ifdef USE_TANGENT
		clearcoatNormal = normalize( vTBN * clearcoatMapN );
	#else
		clearcoatNormal = perturbNormal2Arb( - vViewPosition, clearcoatNormal, clearcoatMapN, faceDirection );
	#endif
#endif`,QM=`#ifdef USE_CLEARCOATMAP
	uniform sampler2D clearcoatMap;
#endif
#ifdef USE_CLEARCOAT_ROUGHNESSMAP
	uniform sampler2D clearcoatRoughnessMap;
#endif
#ifdef USE_CLEARCOAT_NORMALMAP
	uniform sampler2D clearcoatNormalMap;
	uniform vec2 clearcoatNormalScale;
#endif`,qM=`#ifdef USE_IRIDESCENCEMAP
	uniform sampler2D iridescenceMap;
#endif
#ifdef USE_IRIDESCENCE_THICKNESSMAP
	uniform sampler2D iridescenceThicknessMap;
#endif`,KM=`#ifdef OPAQUE
diffuseColor.a = 1.0;
#endif
#ifdef USE_TRANSMISSION
diffuseColor.a *= material.transmissionAlpha + 0.1;
#endif
gl_FragColor = vec4( outgoingLight, diffuseColor.a );`,eA=`vec3 packNormalToRGB( const in vec3 normal ) {
	return normalize( normal ) * 0.5 + 0.5;
}
vec3 unpackRGBToNormal( const in vec3 rgb ) {
	return 2.0 * rgb.xyz - 1.0;
}
const float PackUpscale = 256. / 255.;const float UnpackDownscale = 255. / 256.;
const vec3 PackFactors = vec3( 256. * 256. * 256., 256. * 256., 256. );
const vec4 UnpackFactors = UnpackDownscale / vec4( PackFactors, 1. );
const float ShiftRight8 = 1. / 256.;
vec4 packDepthToRGBA( const in float v ) {
	vec4 r = vec4( fract( v * PackFactors ), v );
	r.yzw -= r.xyz * ShiftRight8;	return r * PackUpscale;
}
float unpackRGBAToDepth( const in vec4 v ) {
	return dot( v, UnpackFactors );
}
vec4 pack2HalfToRGBA( vec2 v ) {
	vec4 r = vec4( v.x, fract( v.x * 255.0 ), v.y, fract( v.y * 255.0 ) );
	return vec4( r.x - r.y / 255.0, r.y, r.z - r.w / 255.0, r.w );
}
vec2 unpackRGBATo2Half( vec4 v ) {
	return vec2( v.x + ( v.y / 255.0 ), v.z + ( v.w / 255.0 ) );
}
float viewZToOrthographicDepth( const in float viewZ, const in float near, const in float far ) {
	return ( viewZ + near ) / ( near - far );
}
float orthographicDepthToViewZ( const in float linearClipZ, const in float near, const in float far ) {
	return linearClipZ * ( near - far ) - near;
}
float viewZToPerspectiveDepth( const in float viewZ, const in float near, const in float far ) {
	return ( ( near + viewZ ) * far ) / ( ( far - near ) * viewZ );
}
float perspectiveDepthToViewZ( const in float invClipZ, const in float near, const in float far ) {
	return ( near * far ) / ( ( far - near ) * invClipZ - far );
}`,tA=`#ifdef PREMULTIPLIED_ALPHA
	gl_FragColor.rgb *= gl_FragColor.a;
#endif`,nA=`vec4 mvPosition = vec4( transformed, 1.0 );
#ifdef USE_INSTANCING
	mvPosition = instanceMatrix * mvPosition;
#endif
mvPosition = modelViewMatrix * mvPosition;
gl_Position = projectionMatrix * mvPosition;`,iA=`#ifdef DITHERING
	gl_FragColor.rgb = dithering( gl_FragColor.rgb );
#endif`,oA=`#ifdef DITHERING
	vec3 dithering( vec3 color ) {
		float grid_position = rand( gl_FragCoord.xy );
		vec3 dither_shift_RGB = vec3( 0.25 / 255.0, -0.25 / 255.0, 0.25 / 255.0 );
		dither_shift_RGB = mix( 2.0 * dither_shift_RGB, -2.0 * dither_shift_RGB, grid_position );
		return color + dither_shift_RGB;
	}
#endif`,aA=`float roughnessFactor = roughness;
#ifdef USE_ROUGHNESSMAP
	vec4 texelRoughness = texture2D( roughnessMap, vUv );
	roughnessFactor *= texelRoughness.g;
#endif`,rA=`#ifdef USE_ROUGHNESSMAP
	uniform sampler2D roughnessMap;
#endif`,sA=`#if NUM_SPOT_LIGHT_COORDS > 0
  varying vec4 vSpotLightCoord[ NUM_SPOT_LIGHT_COORDS ];
#endif
#if NUM_SPOT_LIGHT_MAPS > 0
  uniform sampler2D spotLightMap[ NUM_SPOT_LIGHT_MAPS ];
#endif
#ifdef USE_SHADOWMAP
	#if NUM_DIR_LIGHT_SHADOWS > 0
		uniform sampler2D directionalShadowMap[ NUM_DIR_LIGHT_SHADOWS ];
		varying vec4 vDirectionalShadowCoord[ NUM_DIR_LIGHT_SHADOWS ];
		struct DirectionalLightShadow {
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
		};
		uniform DirectionalLightShadow directionalLightShadows[ NUM_DIR_LIGHT_SHADOWS ];
	#endif
	#if NUM_SPOT_LIGHT_SHADOWS > 0
		uniform sampler2D spotShadowMap[ NUM_SPOT_LIGHT_SHADOWS ];
		struct SpotLightShadow {
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
		};
		uniform SpotLightShadow spotLightShadows[ NUM_SPOT_LIGHT_SHADOWS ];
	#endif
	#if NUM_POINT_LIGHT_SHADOWS > 0
		uniform sampler2D pointShadowMap[ NUM_POINT_LIGHT_SHADOWS ];
		varying vec4 vPointShadowCoord[ NUM_POINT_LIGHT_SHADOWS ];
		struct PointLightShadow {
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
			float shadowCameraNear;
			float shadowCameraFar;
		};
		uniform PointLightShadow pointLightShadows[ NUM_POINT_LIGHT_SHADOWS ];
	#endif
	float texture2DCompare( sampler2D depths, vec2 uv, float compare ) {
		return step( compare, unpackRGBAToDepth( texture2D( depths, uv ) ) );
	}
	vec2 texture2DDistribution( sampler2D shadow, vec2 uv ) {
		return unpackRGBATo2Half( texture2D( shadow, uv ) );
	}
	float VSMShadow (sampler2D shadow, vec2 uv, float compare ){
		float occlusion = 1.0;
		vec2 distribution = texture2DDistribution( shadow, uv );
		float hard_shadow = step( compare , distribution.x );
		if (hard_shadow != 1.0 ) {
			float distance = compare - distribution.x ;
			float variance = max( 0.00000, distribution.y * distribution.y );
			float softness_probability = variance / (variance + distance * distance );			softness_probability = clamp( ( softness_probability - 0.3 ) / ( 0.95 - 0.3 ), 0.0, 1.0 );			occlusion = clamp( max( hard_shadow, softness_probability ), 0.0, 1.0 );
		}
		return occlusion;
	}
	float getShadow( sampler2D shadowMap, vec2 shadowMapSize, float shadowBias, float shadowRadius, vec4 shadowCoord ) {
		float shadow = 1.0;
		shadowCoord.xyz /= shadowCoord.w;
		shadowCoord.z += shadowBias;
		bvec4 inFrustumVec = bvec4 ( shadowCoord.x >= 0.0, shadowCoord.x <= 1.0, shadowCoord.y >= 0.0, shadowCoord.y <= 1.0 );
		bool inFrustum = all( inFrustumVec );
		bvec2 frustumTestVec = bvec2( inFrustum, shadowCoord.z <= 1.0 );
		bool frustumTest = all( frustumTestVec );
		if ( frustumTest ) {
		#if defined( SHADOWMAP_TYPE_PCF )
			vec2 texelSize = vec2( 1.0 ) / shadowMapSize;
			float dx0 = - texelSize.x * shadowRadius;
			float dy0 = - texelSize.y * shadowRadius;
			float dx1 = + texelSize.x * shadowRadius;
			float dy1 = + texelSize.y * shadowRadius;
			float dx2 = dx0 / 2.0;
			float dy2 = dy0 / 2.0;
			float dx3 = dx1 / 2.0;
			float dy3 = dy1 / 2.0;
			shadow = (
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx0, dy0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( 0.0, dy0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx1, dy0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx2, dy2 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( 0.0, dy2 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx3, dy2 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx0, 0.0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx2, 0.0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy, shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx3, 0.0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx1, 0.0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx2, dy3 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( 0.0, dy3 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx3, dy3 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx0, dy1 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( 0.0, dy1 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx1, dy1 ), shadowCoord.z )
			) * ( 1.0 / 17.0 );
		#elif defined( SHADOWMAP_TYPE_PCF_SOFT )
			vec2 texelSize = vec2( 1.0 ) / shadowMapSize;
			float dx = texelSize.x;
			float dy = texelSize.y;
			vec2 uv = shadowCoord.xy;
			vec2 f = fract( uv * shadowMapSize + 0.5 );
			uv -= f * texelSize;
			shadow = (
				texture2DCompare( shadowMap, uv, shadowCoord.z ) +
				texture2DCompare( shadowMap, uv + vec2( dx, 0.0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, uv + vec2( 0.0, dy ), shadowCoord.z ) +
				texture2DCompare( shadowMap, uv + texelSize, shadowCoord.z ) +
				mix( texture2DCompare( shadowMap, uv + vec2( -dx, 0.0 ), shadowCoord.z ),
					 texture2DCompare( shadowMap, uv + vec2( 2.0 * dx, 0.0 ), shadowCoord.z ),
					 f.x ) +
				mix( texture2DCompare( shadowMap, uv + vec2( -dx, dy ), shadowCoord.z ),
					 texture2DCompare( shadowMap, uv + vec2( 2.0 * dx, dy ), shadowCoord.z ),
					 f.x ) +
				mix( texture2DCompare( shadowMap, uv + vec2( 0.0, -dy ), shadowCoord.z ),
					 texture2DCompare( shadowMap, uv + vec2( 0.0, 2.0 * dy ), shadowCoord.z ),
					 f.y ) +
				mix( texture2DCompare( shadowMap, uv + vec2( dx, -dy ), shadowCoord.z ),
					 texture2DCompare( shadowMap, uv + vec2( dx, 2.0 * dy ), shadowCoord.z ),
					 f.y ) +
				mix( mix( texture2DCompare( shadowMap, uv + vec2( -dx, -dy ), shadowCoord.z ),
						  texture2DCompare( shadowMap, uv + vec2( 2.0 * dx, -dy ), shadowCoord.z ),
						  f.x ),
					 mix( texture2DCompare( shadowMap, uv + vec2( -dx, 2.0 * dy ), shadowCoord.z ),
						  texture2DCompare( shadowMap, uv + vec2( 2.0 * dx, 2.0 * dy ), shadowCoord.z ),
						  f.x ),
					 f.y )
			) * ( 1.0 / 9.0 );
		#elif defined( SHADOWMAP_TYPE_VSM )
			shadow = VSMShadow( shadowMap, shadowCoord.xy, shadowCoord.z );
		#else
			shadow = texture2DCompare( shadowMap, shadowCoord.xy, shadowCoord.z );
		#endif
		}
		return shadow;
	}
	vec2 cubeToUV( vec3 v, float texelSizeY ) {
		vec3 absV = abs( v );
		float scaleToCube = 1.0 / max( absV.x, max( absV.y, absV.z ) );
		absV *= scaleToCube;
		v *= scaleToCube * ( 1.0 - 2.0 * texelSizeY );
		vec2 planar = v.xy;
		float almostATexel = 1.5 * texelSizeY;
		float almostOne = 1.0 - almostATexel;
		if ( absV.z >= almostOne ) {
			if ( v.z > 0.0 )
				planar.x = 4.0 - v.x;
		} else if ( absV.x >= almostOne ) {
			float signX = sign( v.x );
			planar.x = v.z * signX + 2.0 * signX;
		} else if ( absV.y >= almostOne ) {
			float signY = sign( v.y );
			planar.x = v.x + 2.0 * signY + 2.0;
			planar.y = v.z * signY - 2.0;
		}
		return vec2( 0.125, 0.25 ) * planar + vec2( 0.375, 0.75 );
	}
	float getPointShadow( sampler2D shadowMap, vec2 shadowMapSize, float shadowBias, float shadowRadius, vec4 shadowCoord, float shadowCameraNear, float shadowCameraFar ) {
		vec2 texelSize = vec2( 1.0 ) / ( shadowMapSize * vec2( 4.0, 2.0 ) );
		vec3 lightToPosition = shadowCoord.xyz;
		float dp = ( length( lightToPosition ) - shadowCameraNear ) / ( shadowCameraFar - shadowCameraNear );		dp += shadowBias;
		vec3 bd3D = normalize( lightToPosition );
		#if defined( SHADOWMAP_TYPE_PCF ) || defined( SHADOWMAP_TYPE_PCF_SOFT ) || defined( SHADOWMAP_TYPE_VSM )
			vec2 offset = vec2( - 1, 1 ) * shadowRadius * texelSize.y;
			return (
				texture2DCompare( shadowMap, cubeToUV( bd3D + offset.xyy, texelSize.y ), dp ) +
				texture2DCompare( shadowMap, cubeToUV( bd3D + offset.yyy, texelSize.y ), dp ) +
				texture2DCompare( shadowMap, cubeToUV( bd3D + offset.xyx, texelSize.y ), dp ) +
				texture2DCompare( shadowMap, cubeToUV( bd3D + offset.yyx, texelSize.y ), dp ) +
				texture2DCompare( shadowMap, cubeToUV( bd3D, texelSize.y ), dp ) +
				texture2DCompare( shadowMap, cubeToUV( bd3D + offset.xxy, texelSize.y ), dp ) +
				texture2DCompare( shadowMap, cubeToUV( bd3D + offset.yxy, texelSize.y ), dp ) +
				texture2DCompare( shadowMap, cubeToUV( bd3D + offset.xxx, texelSize.y ), dp ) +
				texture2DCompare( shadowMap, cubeToUV( bd3D + offset.yxx, texelSize.y ), dp )
			) * ( 1.0 / 9.0 );
		#else
			return texture2DCompare( shadowMap, cubeToUV( bd3D, texelSize.y ), dp );
		#endif
	}
#endif`,lA=`#if NUM_SPOT_LIGHT_COORDS > 0
  uniform mat4 spotLightMatrix[ NUM_SPOT_LIGHT_COORDS ];
  varying vec4 vSpotLightCoord[ NUM_SPOT_LIGHT_COORDS ];
#endif
#ifdef USE_SHADOWMAP
	#if NUM_DIR_LIGHT_SHADOWS > 0
		uniform mat4 directionalShadowMatrix[ NUM_DIR_LIGHT_SHADOWS ];
		varying vec4 vDirectionalShadowCoord[ NUM_DIR_LIGHT_SHADOWS ];
		struct DirectionalLightShadow {
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
		};
		uniform DirectionalLightShadow directionalLightShadows[ NUM_DIR_LIGHT_SHADOWS ];
	#endif
	#if NUM_SPOT_LIGHT_SHADOWS > 0
		struct SpotLightShadow {
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
		};
		uniform SpotLightShadow spotLightShadows[ NUM_SPOT_LIGHT_SHADOWS ];
	#endif
	#if NUM_POINT_LIGHT_SHADOWS > 0
		uniform mat4 pointShadowMatrix[ NUM_POINT_LIGHT_SHADOWS ];
		varying vec4 vPointShadowCoord[ NUM_POINT_LIGHT_SHADOWS ];
		struct PointLightShadow {
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
			float shadowCameraNear;
			float shadowCameraFar;
		};
		uniform PointLightShadow pointLightShadows[ NUM_POINT_LIGHT_SHADOWS ];
	#endif
#endif`,uA=`#if defined( USE_SHADOWMAP ) || ( NUM_SPOT_LIGHT_COORDS > 0 )
	#if NUM_DIR_LIGHT_SHADOWS > 0 || NUM_SPOT_LIGHT_COORDS > 0 || NUM_POINT_LIGHT_SHADOWS > 0
		vec3 shadowWorldNormal = inverseTransformDirection( transformedNormal, viewMatrix );
		vec4 shadowWorldPosition;
	#endif
	#if NUM_DIR_LIGHT_SHADOWS > 0
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_DIR_LIGHT_SHADOWS; i ++ ) {
		shadowWorldPosition = worldPosition + vec4( shadowWorldNormal * directionalLightShadows[ i ].shadowNormalBias, 0 );
		vDirectionalShadowCoord[ i ] = directionalShadowMatrix[ i ] * shadowWorldPosition;
	}
	#pragma unroll_loop_end
	#endif
	#if NUM_SPOT_LIGHT_COORDS > 0
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_SPOT_LIGHT_COORDS; i ++ ) {
		shadowWorldPosition = worldPosition;
		#if ( defined( USE_SHADOWMAP ) && UNROLLED_LOOP_INDEX < NUM_SPOT_LIGHT_SHADOWS )
			shadowWorldPosition.xyz += shadowWorldNormal * spotLightShadows[ i ].shadowNormalBias;
		#endif
		vSpotLightCoord[ i ] = spotLightMatrix[ i ] * shadowWorldPosition;
	}
	#pragma unroll_loop_end
	#endif
	#if NUM_POINT_LIGHT_SHADOWS > 0
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_POINT_LIGHT_SHADOWS; i ++ ) {
		shadowWorldPosition = worldPosition + vec4( shadowWorldNormal * pointLightShadows[ i ].shadowNormalBias, 0 );
		vPointShadowCoord[ i ] = pointShadowMatrix[ i ] * shadowWorldPosition;
	}
	#pragma unroll_loop_end
	#endif
#endif`,cA=`float getShadowMask() {
	float shadow = 1.0;
	#ifdef USE_SHADOWMAP
	#if NUM_DIR_LIGHT_SHADOWS > 0
	DirectionalLightShadow directionalLight;
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_DIR_LIGHT_SHADOWS; i ++ ) {
		directionalLight = directionalLightShadows[ i ];
		shadow *= receiveShadow ? getShadow( directionalShadowMap[ i ], directionalLight.shadowMapSize, directionalLight.shadowBias, directionalLight.shadowRadius, vDirectionalShadowCoord[ i ] ) : 1.0;
	}
	#pragma unroll_loop_end
	#endif
	#if NUM_SPOT_LIGHT_SHADOWS > 0
	SpotLightShadow spotLight;
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_SPOT_LIGHT_SHADOWS; i ++ ) {
		spotLight = spotLightShadows[ i ];
		shadow *= receiveShadow ? getShadow( spotShadowMap[ i ], spotLight.shadowMapSize, spotLight.shadowBias, spotLight.shadowRadius, vSpotLightCoord[ i ] ) : 1.0;
	}
	#pragma unroll_loop_end
	#endif
	#if NUM_POINT_LIGHT_SHADOWS > 0
	PointLightShadow pointLight;
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_POINT_LIGHT_SHADOWS; i ++ ) {
		pointLight = pointLightShadows[ i ];
		shadow *= receiveShadow ? getPointShadow( pointShadowMap[ i ], pointLight.shadowMapSize, pointLight.shadowBias, pointLight.shadowRadius, vPointShadowCoord[ i ], pointLight.shadowCameraNear, pointLight.shadowCameraFar ) : 1.0;
	}
	#pragma unroll_loop_end
	#endif
	#endif
	return shadow;
}`,dA=`#ifdef USE_SKINNING
	mat4 boneMatX = getBoneMatrix( skinIndex.x );
	mat4 boneMatY = getBoneMatrix( skinIndex.y );
	mat4 boneMatZ = getBoneMatrix( skinIndex.z );
	mat4 boneMatW = getBoneMatrix( skinIndex.w );
#endif`,fA=`#ifdef USE_SKINNING
	uniform mat4 bindMatrix;
	uniform mat4 bindMatrixInverse;
	uniform highp sampler2D boneTexture;
	uniform int boneTextureSize;
	mat4 getBoneMatrix( const in float i ) {
		float j = i * 4.0;
		float x = mod( j, float( boneTextureSize ) );
		float y = floor( j / float( boneTextureSize ) );
		float dx = 1.0 / float( boneTextureSize );
		float dy = 1.0 / float( boneTextureSize );
		y = dy * ( y + 0.5 );
		vec4 v1 = texture2D( boneTexture, vec2( dx * ( x + 0.5 ), y ) );
		vec4 v2 = texture2D( boneTexture, vec2( dx * ( x + 1.5 ), y ) );
		vec4 v3 = texture2D( boneTexture, vec2( dx * ( x + 2.5 ), y ) );
		vec4 v4 = texture2D( boneTexture, vec2( dx * ( x + 3.5 ), y ) );
		mat4 bone = mat4( v1, v2, v3, v4 );
		return bone;
	}
#endif`,hA=`#ifdef USE_SKINNING
	vec4 skinVertex = bindMatrix * vec4( transformed, 1.0 );
	vec4 skinned = vec4( 0.0 );
	skinned += boneMatX * skinVertex * skinWeight.x;
	skinned += boneMatY * skinVertex * skinWeight.y;
	skinned += boneMatZ * skinVertex * skinWeight.z;
	skinned += boneMatW * skinVertex * skinWeight.w;
	transformed = ( bindMatrixInverse * skinned ).xyz;
#endif`,pA=`#ifdef USE_SKINNING
	mat4 skinMatrix = mat4( 0.0 );
	skinMatrix += skinWeight.x * boneMatX;
	skinMatrix += skinWeight.y * boneMatY;
	skinMatrix += skinWeight.z * boneMatZ;
	skinMatrix += skinWeight.w * boneMatW;
	skinMatrix = bindMatrixInverse * skinMatrix * bindMatrix;
	objectNormal = vec4( skinMatrix * vec4( objectNormal, 0.0 ) ).xyz;
	#ifdef USE_TANGENT
		objectTangent = vec4( skinMatrix * vec4( objectTangent, 0.0 ) ).xyz;
	#endif
#endif`,mA=`float specularStrength;
#ifdef USE_SPECULARMAP
	vec4 texelSpecular = texture2D( specularMap, vUv );
	specularStrength = texelSpecular.r;
#else
	specularStrength = 1.0;
#endif`,gA=`#ifdef USE_SPECULARMAP
	uniform sampler2D specularMap;
#endif`,_A=`#if defined( TONE_MAPPING )
	gl_FragColor.rgb = toneMapping( gl_FragColor.rgb );
#endif`,vA=`#ifndef saturate
#define saturate( a ) clamp( a, 0.0, 1.0 )
#endif
uniform float toneMappingExposure;
vec3 LinearToneMapping( vec3 color ) {
	return toneMappingExposure * color;
}
vec3 ReinhardToneMapping( vec3 color ) {
	color *= toneMappingExposure;
	return saturate( color / ( vec3( 1.0 ) + color ) );
}
vec3 OptimizedCineonToneMapping( vec3 color ) {
	color *= toneMappingExposure;
	color = max( vec3( 0.0 ), color - 0.004 );
	return pow( ( color * ( 6.2 * color + 0.5 ) ) / ( color * ( 6.2 * color + 1.7 ) + 0.06 ), vec3( 2.2 ) );
}
vec3 RRTAndODTFit( vec3 v ) {
	vec3 a = v * ( v + 0.0245786 ) - 0.000090537;
	vec3 b = v * ( 0.983729 * v + 0.4329510 ) + 0.238081;
	return a / b;
}
vec3 ACESFilmicToneMapping( vec3 color ) {
	const mat3 ACESInputMat = mat3(
		vec3( 0.59719, 0.07600, 0.02840 ),		vec3( 0.35458, 0.90834, 0.13383 ),
		vec3( 0.04823, 0.01566, 0.83777 )
	);
	const mat3 ACESOutputMat = mat3(
		vec3(  1.60475, -0.10208, -0.00327 ),		vec3( -0.53108,  1.10813, -0.07276 ),
		vec3( -0.07367, -0.00605,  1.07602 )
	);
	color *= toneMappingExposure / 0.6;
	color = ACESInputMat * color;
	color = RRTAndODTFit( color );
	color = ACESOutputMat * color;
	return saturate( color );
}
vec3 CustomToneMapping( vec3 color ) { return color; }`,yA=`#ifdef USE_TRANSMISSION
	material.transmission = transmission;
	material.transmissionAlpha = 1.0;
	material.thickness = thickness;
	material.attenuationDistance = attenuationDistance;
	material.attenuationColor = attenuationColor;
	#ifdef USE_TRANSMISSIONMAP
		material.transmission *= texture2D( transmissionMap, vUv ).r;
	#endif
	#ifdef USE_THICKNESSMAP
		material.thickness *= texture2D( thicknessMap, vUv ).g;
	#endif
	vec3 pos = vWorldPosition;
	vec3 v = normalize( cameraPosition - pos );
	vec3 n = inverseTransformDirection( normal, viewMatrix );
	vec4 transmission = getIBLVolumeRefraction(
		n, v, material.roughness, material.diffuseColor, material.specularColor, material.specularF90,
		pos, modelMatrix, viewMatrix, projectionMatrix, material.ior, material.thickness,
		material.attenuationColor, material.attenuationDistance );
	material.transmissionAlpha = mix( material.transmissionAlpha, transmission.a, material.transmission );
	totalDiffuse = mix( totalDiffuse, transmission.rgb, material.transmission );
#endif`,bA=`#ifdef USE_TRANSMISSION
	uniform float transmission;
	uniform float thickness;
	uniform float attenuationDistance;
	uniform vec3 attenuationColor;
	#ifdef USE_TRANSMISSIONMAP
		uniform sampler2D transmissionMap;
	#endif
	#ifdef USE_THICKNESSMAP
		uniform sampler2D thicknessMap;
	#endif
	uniform vec2 transmissionSamplerSize;
	uniform sampler2D transmissionSamplerMap;
	uniform mat4 modelMatrix;
	uniform mat4 projectionMatrix;
	varying vec3 vWorldPosition;
	vec3 getVolumeTransmissionRay( const in vec3 n, const in vec3 v, const in float thickness, const in float ior, const in mat4 modelMatrix ) {
		vec3 refractionVector = refract( - v, normalize( n ), 1.0 / ior );
		vec3 modelScale;
		modelScale.x = length( vec3( modelMatrix[ 0 ].xyz ) );
		modelScale.y = length( vec3( modelMatrix[ 1 ].xyz ) );
		modelScale.z = length( vec3( modelMatrix[ 2 ].xyz ) );
		return normalize( refractionVector ) * thickness * modelScale;
	}
	float applyIorToRoughness( const in float roughness, const in float ior ) {
		return roughness * clamp( ior * 2.0 - 2.0, 0.0, 1.0 );
	}
	vec4 getTransmissionSample( const in vec2 fragCoord, const in float roughness, const in float ior ) {
		float framebufferLod = log2( transmissionSamplerSize.x ) * applyIorToRoughness( roughness, ior );
		#ifdef texture2DLodEXT
			return texture2DLodEXT( transmissionSamplerMap, fragCoord.xy, framebufferLod );
		#else
			return texture2D( transmissionSamplerMap, fragCoord.xy, framebufferLod );
		#endif
	}
	vec3 applyVolumeAttenuation( const in vec3 radiance, const in float transmissionDistance, const in vec3 attenuationColor, const in float attenuationDistance ) {
		if ( isinf( attenuationDistance ) ) {
			return radiance;
		} else {
			vec3 attenuationCoefficient = -log( attenuationColor ) / attenuationDistance;
			vec3 transmittance = exp( - attenuationCoefficient * transmissionDistance );			return transmittance * radiance;
		}
	}
	vec4 getIBLVolumeRefraction( const in vec3 n, const in vec3 v, const in float roughness, const in vec3 diffuseColor,
		const in vec3 specularColor, const in float specularF90, const in vec3 position, const in mat4 modelMatrix,
		const in mat4 viewMatrix, const in mat4 projMatrix, const in float ior, const in float thickness,
		const in vec3 attenuationColor, const in float attenuationDistance ) {
		vec3 transmissionRay = getVolumeTransmissionRay( n, v, thickness, ior, modelMatrix );
		vec3 refractedRayExit = position + transmissionRay;
		vec4 ndcPos = projMatrix * viewMatrix * vec4( refractedRayExit, 1.0 );
		vec2 refractionCoords = ndcPos.xy / ndcPos.w;
		refractionCoords += 1.0;
		refractionCoords /= 2.0;
		vec4 transmittedLight = getTransmissionSample( refractionCoords, roughness, ior );
		vec3 attenuatedColor = applyVolumeAttenuation( transmittedLight.rgb, length( transmissionRay ), attenuationColor, attenuationDistance );
		vec3 F = EnvironmentBRDF( n, v, specularColor, specularF90, roughness );
		return vec4( ( 1.0 - F ) * attenuatedColor * diffuseColor, transmittedLight.a );
	}
#endif`,xA=`#if ( defined( USE_UV ) && ! defined( UVS_VERTEX_ONLY ) )
	varying vec2 vUv;
#endif`,SA=`#ifdef USE_UV
	#ifdef UVS_VERTEX_ONLY
		vec2 vUv;
	#else
		varying vec2 vUv;
	#endif
	uniform mat3 uvTransform;
#endif`,MA=`#ifdef USE_UV
	vUv = ( uvTransform * vec3( uv, 1 ) ).xy;
#endif`,AA=`#if defined( USE_LIGHTMAP ) || defined( USE_AOMAP )
	varying vec2 vUv2;
#endif`,wA=`#if defined( USE_LIGHTMAP ) || defined( USE_AOMAP )
	attribute vec2 uv2;
	varying vec2 vUv2;
	uniform mat3 uv2Transform;
#endif`,CA=`#if defined( USE_LIGHTMAP ) || defined( USE_AOMAP )
	vUv2 = ( uv2Transform * vec3( uv2, 1 ) ).xy;
#endif`,TA=`#if defined( USE_ENVMAP ) || defined( DISTANCE ) || defined ( USE_SHADOWMAP ) || defined ( USE_TRANSMISSION ) || NUM_SPOT_LIGHT_COORDS > 0
	vec4 worldPosition = vec4( transformed, 1.0 );
	#ifdef USE_INSTANCING
		worldPosition = instanceMatrix * worldPosition;
	#endif
	worldPosition = modelMatrix * worldPosition;
#endif`;const EA=`varying vec2 vUv;
uniform mat3 uvTransform;
void main() {
	vUv = ( uvTransform * vec3( uv, 1 ) ).xy;
	gl_Position = vec4( position.xy, 1.0, 1.0 );
}`,DA=`uniform sampler2D t2D;
varying vec2 vUv;
void main() {
	gl_FragColor = texture2D( t2D, vUv );
	#ifdef DECODE_VIDEO_TEXTURE
		gl_FragColor = vec4( mix( pow( gl_FragColor.rgb * 0.9478672986 + vec3( 0.0521327014 ), vec3( 2.4 ) ), gl_FragColor.rgb * 0.0773993808, vec3( lessThanEqual( gl_FragColor.rgb, vec3( 0.04045 ) ) ) ), gl_FragColor.w );
	#endif
	#include <tonemapping_fragment>
	#include <encodings_fragment>
}`,IA=`varying vec3 vWorldDirection;
#include <common>
void main() {
	vWorldDirection = transformDirection( position, modelMatrix );
	#include <begin_vertex>
	#include <project_vertex>
	gl_Position.z = gl_Position.w;
}`,RA=`#include <envmap_common_pars_fragment>
uniform float opacity;
varying vec3 vWorldDirection;
#include <cube_uv_reflection_fragment>
void main() {
	vec3 vReflect = vWorldDirection;
	#include <envmap_fragment>
	gl_FragColor = envColor;
	gl_FragColor.a *= opacity;
	#include <tonemapping_fragment>
	#include <encodings_fragment>
}`,OA=`#include <common>
#include <uv_pars_vertex>
#include <displacementmap_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
varying vec2 vHighPrecisionZW;
void main() {
	#include <uv_vertex>
	#include <skinbase_vertex>
	#ifdef USE_DISPLACEMENTMAP
		#include <beginnormal_vertex>
		#include <morphnormal_vertex>
		#include <skinnormal_vertex>
	#endif
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	vHighPrecisionZW = gl_Position.zw;
}`,PA=`#if DEPTH_PACKING == 3200
	uniform float opacity;
#endif
#include <common>
#include <packing>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
varying vec2 vHighPrecisionZW;
void main() {
	#include <clipping_planes_fragment>
	vec4 diffuseColor = vec4( 1.0 );
	#if DEPTH_PACKING == 3200
		diffuseColor.a = opacity;
	#endif
	#include <map_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <logdepthbuf_fragment>
	float fragCoordZ = 0.5 * vHighPrecisionZW[0] / vHighPrecisionZW[1] + 0.5;
	#if DEPTH_PACKING == 3200
		gl_FragColor = vec4( vec3( 1.0 - fragCoordZ ), opacity );
	#elif DEPTH_PACKING == 3201
		gl_FragColor = packDepthToRGBA( fragCoordZ );
	#endif
}`,LA=`#define DISTANCE
varying vec3 vWorldPosition;
#include <common>
#include <uv_pars_vertex>
#include <displacementmap_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <skinbase_vertex>
	#ifdef USE_DISPLACEMENTMAP
		#include <beginnormal_vertex>
		#include <morphnormal_vertex>
		#include <skinnormal_vertex>
	#endif
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <worldpos_vertex>
	#include <clipping_planes_vertex>
	vWorldPosition = worldPosition.xyz;
}`,zA=`#define DISTANCE
uniform vec3 referencePosition;
uniform float nearDistance;
uniform float farDistance;
varying vec3 vWorldPosition;
#include <common>
#include <packing>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <clipping_planes_pars_fragment>
void main () {
	#include <clipping_planes_fragment>
	vec4 diffuseColor = vec4( 1.0 );
	#include <map_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	float dist = length( vWorldPosition - referencePosition );
	dist = ( dist - nearDistance ) / ( farDistance - nearDistance );
	dist = saturate( dist );
	gl_FragColor = packDepthToRGBA( dist );
}`,kA=`varying vec3 vWorldDirection;
#include <common>
void main() {
	vWorldDirection = transformDirection( position, modelMatrix );
	#include <begin_vertex>
	#include <project_vertex>
}`,NA=`uniform sampler2D tEquirect;
varying vec3 vWorldDirection;
#include <common>
void main() {
	vec3 direction = normalize( vWorldDirection );
	vec2 sampleUV = equirectUv( direction );
	gl_FragColor = texture2D( tEquirect, sampleUV );
	#include <tonemapping_fragment>
	#include <encodings_fragment>
}`,UA=`uniform float scale;
attribute float lineDistance;
varying float vLineDistance;
#include <common>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <morphtarget_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	vLineDistance = scale * lineDistance;
	#include <color_vertex>
	#include <morphcolor_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	#include <fog_vertex>
}`,FA=`uniform vec3 diffuse;
uniform float opacity;
uniform float dashSize;
uniform float totalSize;
varying float vLineDistance;
#include <common>
#include <color_pars_fragment>
#include <fog_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	#include <clipping_planes_fragment>
	if ( mod( vLineDistance, totalSize ) > dashSize ) {
		discard;
	}
	vec3 outgoingLight = vec3( 0.0 );
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <logdepthbuf_fragment>
	#include <color_fragment>
	outgoingLight = diffuseColor.rgb;
	#include <output_fragment>
	#include <tonemapping_fragment>
	#include <encodings_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
}`,BA=`#include <common>
#include <uv_pars_vertex>
#include <uv2_pars_vertex>
#include <envmap_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <uv2_vertex>
	#include <color_vertex>
	#include <morphcolor_vertex>
	#if defined ( USE_ENVMAP ) || defined ( USE_SKINNING )
		#include <beginnormal_vertex>
		#include <morphnormal_vertex>
		#include <skinbase_vertex>
		#include <skinnormal_vertex>
		#include <defaultnormal_vertex>
	#endif
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	#include <worldpos_vertex>
	#include <envmap_vertex>
	#include <fog_vertex>
}`,GA=`uniform vec3 diffuse;
uniform float opacity;
#ifndef FLAT_SHADED
	varying vec3 vNormal;
#endif
#include <common>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <uv2_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <aomap_pars_fragment>
#include <lightmap_pars_fragment>
#include <envmap_common_pars_fragment>
#include <envmap_pars_fragment>
#include <fog_pars_fragment>
#include <specularmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	#include <clipping_planes_fragment>
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <specularmap_fragment>
	ReflectedLight reflectedLight = ReflectedLight( vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ) );
	#ifdef USE_LIGHTMAP
		vec4 lightMapTexel = texture2D( lightMap, vUv2 );
		reflectedLight.indirectDiffuse += lightMapTexel.rgb * lightMapIntensity * RECIPROCAL_PI;
	#else
		reflectedLight.indirectDiffuse += vec3( 1.0 );
	#endif
	#include <aomap_fragment>
	reflectedLight.indirectDiffuse *= diffuseColor.rgb;
	vec3 outgoingLight = reflectedLight.indirectDiffuse;
	#include <envmap_fragment>
	#include <output_fragment>
	#include <tonemapping_fragment>
	#include <encodings_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,VA=`#define LAMBERT
varying vec3 vViewPosition;
#include <common>
#include <uv_pars_vertex>
#include <uv2_pars_vertex>
#include <displacementmap_pars_vertex>
#include <envmap_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <shadowmap_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <uv2_vertex>
	#include <color_vertex>
	#include <morphcolor_vertex>
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	vViewPosition = - mvPosition.xyz;
	#include <worldpos_vertex>
	#include <envmap_vertex>
	#include <shadowmap_vertex>
	#include <fog_vertex>
}`,jA=`#define LAMBERT
uniform vec3 diffuse;
uniform vec3 emissive;
uniform float opacity;
#include <common>
#include <packing>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <uv2_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <aomap_pars_fragment>
#include <lightmap_pars_fragment>
#include <emissivemap_pars_fragment>
#include <envmap_common_pars_fragment>
#include <envmap_pars_fragment>
#include <fog_pars_fragment>
#include <bsdfs>
#include <lights_pars_begin>
#include <normal_pars_fragment>
#include <lights_lambert_pars_fragment>
#include <shadowmap_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <specularmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	#include <clipping_planes_fragment>
	vec4 diffuseColor = vec4( diffuse, opacity );
	ReflectedLight reflectedLight = ReflectedLight( vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ) );
	vec3 totalEmissiveRadiance = emissive;
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <specularmap_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	#include <emissivemap_fragment>
	#include <lights_lambert_fragment>
	#include <lights_fragment_begin>
	#include <lights_fragment_maps>
	#include <lights_fragment_end>
	#include <aomap_fragment>
	vec3 outgoingLight = reflectedLight.directDiffuse + reflectedLight.indirectDiffuse + totalEmissiveRadiance;
	#include <envmap_fragment>
	#include <output_fragment>
	#include <tonemapping_fragment>
	#include <encodings_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,WA=`#define MATCAP
varying vec3 vViewPosition;
#include <common>
#include <uv_pars_vertex>
#include <color_pars_vertex>
#include <displacementmap_pars_vertex>
#include <fog_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <color_vertex>
	#include <morphcolor_vertex>
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	#include <fog_vertex>
	vViewPosition = - mvPosition.xyz;
}`,HA=`#define MATCAP
uniform vec3 diffuse;
uniform float opacity;
uniform sampler2D matcap;
varying vec3 vViewPosition;
#include <common>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <fog_pars_fragment>
#include <normal_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	#include <clipping_planes_fragment>
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	vec3 viewDir = normalize( vViewPosition );
	vec3 x = normalize( vec3( viewDir.z, 0.0, - viewDir.x ) );
	vec3 y = cross( viewDir, x );
	vec2 uv = vec2( dot( x, normal ), dot( y, normal ) ) * 0.495 + 0.5;
	#ifdef USE_MATCAP
		vec4 matcapColor = texture2D( matcap, uv );
	#else
		vec4 matcapColor = vec4( vec3( mix( 0.2, 0.8, uv.y ) ), 1.0 );
	#endif
	vec3 outgoingLight = diffuseColor.rgb * matcapColor.rgb;
	#include <output_fragment>
	#include <tonemapping_fragment>
	#include <encodings_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,YA=`#define NORMAL
#if defined( FLAT_SHADED ) || defined( USE_BUMPMAP ) || defined( TANGENTSPACE_NORMALMAP )
	varying vec3 vViewPosition;
#endif
#include <common>
#include <uv_pars_vertex>
#include <displacementmap_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
#if defined( FLAT_SHADED ) || defined( USE_BUMPMAP ) || defined( TANGENTSPACE_NORMALMAP )
	vViewPosition = - mvPosition.xyz;
#endif
}`,$A=`#define NORMAL
uniform float opacity;
#if defined( FLAT_SHADED ) || defined( USE_BUMPMAP ) || defined( TANGENTSPACE_NORMALMAP )
	varying vec3 vViewPosition;
#endif
#include <packing>
#include <uv_pars_fragment>
#include <normal_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	#include <clipping_planes_fragment>
	#include <logdepthbuf_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	gl_FragColor = vec4( packNormalToRGB( normal ), opacity );
	#ifdef OPAQUE
		gl_FragColor.a = 1.0;
	#endif
}`,JA=`#define PHONG
varying vec3 vViewPosition;
#include <common>
#include <uv_pars_vertex>
#include <uv2_pars_vertex>
#include <displacementmap_pars_vertex>
#include <envmap_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <shadowmap_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <uv2_vertex>
	#include <color_vertex>
	#include <morphcolor_vertex>
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	vViewPosition = - mvPosition.xyz;
	#include <worldpos_vertex>
	#include <envmap_vertex>
	#include <shadowmap_vertex>
	#include <fog_vertex>
}`,ZA=`#define PHONG
uniform vec3 diffuse;
uniform vec3 emissive;
uniform vec3 specular;
uniform float shininess;
uniform float opacity;
#include <common>
#include <packing>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <uv2_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <aomap_pars_fragment>
#include <lightmap_pars_fragment>
#include <emissivemap_pars_fragment>
#include <envmap_common_pars_fragment>
#include <envmap_pars_fragment>
#include <fog_pars_fragment>
#include <bsdfs>
#include <lights_pars_begin>
#include <normal_pars_fragment>
#include <lights_phong_pars_fragment>
#include <shadowmap_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <specularmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	#include <clipping_planes_fragment>
	vec4 diffuseColor = vec4( diffuse, opacity );
	ReflectedLight reflectedLight = ReflectedLight( vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ) );
	vec3 totalEmissiveRadiance = emissive;
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <specularmap_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	#include <emissivemap_fragment>
	#include <lights_phong_fragment>
	#include <lights_fragment_begin>
	#include <lights_fragment_maps>
	#include <lights_fragment_end>
	#include <aomap_fragment>
	vec3 outgoingLight = reflectedLight.directDiffuse + reflectedLight.indirectDiffuse + reflectedLight.directSpecular + reflectedLight.indirectSpecular + totalEmissiveRadiance;
	#include <envmap_fragment>
	#include <output_fragment>
	#include <tonemapping_fragment>
	#include <encodings_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,XA=`#define STANDARD
varying vec3 vViewPosition;
#ifdef USE_TRANSMISSION
	varying vec3 vWorldPosition;
#endif
#include <common>
#include <uv_pars_vertex>
#include <uv2_pars_vertex>
#include <displacementmap_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <shadowmap_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <uv2_vertex>
	#include <color_vertex>
	#include <morphcolor_vertex>
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	vViewPosition = - mvPosition.xyz;
	#include <worldpos_vertex>
	#include <shadowmap_vertex>
	#include <fog_vertex>
#ifdef USE_TRANSMISSION
	vWorldPosition = worldPosition.xyz;
#endif
}`,QA=`#define STANDARD
#ifdef PHYSICAL
	#define IOR
	#define SPECULAR
#endif
uniform vec3 diffuse;
uniform vec3 emissive;
uniform float roughness;
uniform float metalness;
uniform float opacity;
#ifdef IOR
	uniform float ior;
#endif
#ifdef SPECULAR
	uniform float specularIntensity;
	uniform vec3 specularColor;
	#ifdef USE_SPECULARINTENSITYMAP
		uniform sampler2D specularIntensityMap;
	#endif
	#ifdef USE_SPECULARCOLORMAP
		uniform sampler2D specularColorMap;
	#endif
#endif
#ifdef USE_CLEARCOAT
	uniform float clearcoat;
	uniform float clearcoatRoughness;
#endif
#ifdef USE_IRIDESCENCE
	uniform float iridescence;
	uniform float iridescenceIOR;
	uniform float iridescenceThicknessMinimum;
	uniform float iridescenceThicknessMaximum;
#endif
#ifdef USE_SHEEN
	uniform vec3 sheenColor;
	uniform float sheenRoughness;
	#ifdef USE_SHEENCOLORMAP
		uniform sampler2D sheenColorMap;
	#endif
	#ifdef USE_SHEENROUGHNESSMAP
		uniform sampler2D sheenRoughnessMap;
	#endif
#endif
varying vec3 vViewPosition;
#include <common>
#include <packing>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <uv2_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <aomap_pars_fragment>
#include <lightmap_pars_fragment>
#include <emissivemap_pars_fragment>
#include <bsdfs>
#include <iridescence_fragment>
#include <cube_uv_reflection_fragment>
#include <envmap_common_pars_fragment>
#include <envmap_physical_pars_fragment>
#include <fog_pars_fragment>
#include <lights_pars_begin>
#include <normal_pars_fragment>
#include <lights_physical_pars_fragment>
#include <transmission_pars_fragment>
#include <shadowmap_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <clearcoat_pars_fragment>
#include <iridescence_pars_fragment>
#include <roughnessmap_pars_fragment>
#include <metalnessmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	#include <clipping_planes_fragment>
	vec4 diffuseColor = vec4( diffuse, opacity );
	ReflectedLight reflectedLight = ReflectedLight( vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ) );
	vec3 totalEmissiveRadiance = emissive;
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <roughnessmap_fragment>
	#include <metalnessmap_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	#include <clearcoat_normal_fragment_begin>
	#include <clearcoat_normal_fragment_maps>
	#include <emissivemap_fragment>
	#include <lights_physical_fragment>
	#include <lights_fragment_begin>
	#include <lights_fragment_maps>
	#include <lights_fragment_end>
	#include <aomap_fragment>
	vec3 totalDiffuse = reflectedLight.directDiffuse + reflectedLight.indirectDiffuse;
	vec3 totalSpecular = reflectedLight.directSpecular + reflectedLight.indirectSpecular;
	#include <transmission_fragment>
	vec3 outgoingLight = totalDiffuse + totalSpecular + totalEmissiveRadiance;
	#ifdef USE_SHEEN
		float sheenEnergyComp = 1.0 - 0.157 * max3( material.sheenColor );
		outgoingLight = outgoingLight * sheenEnergyComp + sheenSpecular;
	#endif
	#ifdef USE_CLEARCOAT
		float dotNVcc = saturate( dot( geometry.clearcoatNormal, geometry.viewDir ) );
		vec3 Fcc = F_Schlick( material.clearcoatF0, material.clearcoatF90, dotNVcc );
		outgoingLight = outgoingLight * ( 1.0 - material.clearcoat * Fcc ) + clearcoatSpecular * material.clearcoat;
	#endif
	#include <output_fragment>
	#include <tonemapping_fragment>
	#include <encodings_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,qA=`#define TOON
varying vec3 vViewPosition;
#include <common>
#include <uv_pars_vertex>
#include <uv2_pars_vertex>
#include <displacementmap_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <shadowmap_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <uv2_vertex>
	#include <color_vertex>
	#include <morphcolor_vertex>
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	vViewPosition = - mvPosition.xyz;
	#include <worldpos_vertex>
	#include <shadowmap_vertex>
	#include <fog_vertex>
}`,KA=`#define TOON
uniform vec3 diffuse;
uniform vec3 emissive;
uniform float opacity;
#include <common>
#include <packing>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <uv2_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <aomap_pars_fragment>
#include <lightmap_pars_fragment>
#include <emissivemap_pars_fragment>
#include <gradientmap_pars_fragment>
#include <fog_pars_fragment>
#include <bsdfs>
#include <lights_pars_begin>
#include <normal_pars_fragment>
#include <lights_toon_pars_fragment>
#include <shadowmap_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	#include <clipping_planes_fragment>
	vec4 diffuseColor = vec4( diffuse, opacity );
	ReflectedLight reflectedLight = ReflectedLight( vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ) );
	vec3 totalEmissiveRadiance = emissive;
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	#include <emissivemap_fragment>
	#include <lights_toon_fragment>
	#include <lights_fragment_begin>
	#include <lights_fragment_maps>
	#include <lights_fragment_end>
	#include <aomap_fragment>
	vec3 outgoingLight = reflectedLight.directDiffuse + reflectedLight.indirectDiffuse + totalEmissiveRadiance;
	#include <output_fragment>
	#include <tonemapping_fragment>
	#include <encodings_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,ew=`uniform float size;
uniform float scale;
#include <common>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <morphtarget_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <color_vertex>
	#include <morphcolor_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <project_vertex>
	gl_PointSize = size;
	#ifdef USE_SIZEATTENUATION
		bool isPerspective = isPerspectiveMatrix( projectionMatrix );
		if ( isPerspective ) gl_PointSize *= ( scale / - mvPosition.z );
	#endif
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	#include <worldpos_vertex>
	#include <fog_vertex>
}`,tw=`uniform vec3 diffuse;
uniform float opacity;
#include <common>
#include <color_pars_fragment>
#include <map_particle_pars_fragment>
#include <alphatest_pars_fragment>
#include <fog_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	#include <clipping_planes_fragment>
	vec3 outgoingLight = vec3( 0.0 );
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <logdepthbuf_fragment>
	#include <map_particle_fragment>
	#include <color_fragment>
	#include <alphatest_fragment>
	outgoingLight = diffuseColor.rgb;
	#include <output_fragment>
	#include <tonemapping_fragment>
	#include <encodings_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
}`,nw=`#include <common>
#include <fog_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <shadowmap_pars_vertex>
void main() {
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <project_vertex>
	#include <worldpos_vertex>
	#include <shadowmap_vertex>
	#include <fog_vertex>
}`,iw=`uniform vec3 color;
uniform float opacity;
#include <common>
#include <packing>
#include <fog_pars_fragment>
#include <bsdfs>
#include <lights_pars_begin>
#include <shadowmap_pars_fragment>
#include <shadowmask_pars_fragment>
void main() {
	gl_FragColor = vec4( color, opacity * ( 1.0 - getShadowMask() ) );
	#include <tonemapping_fragment>
	#include <encodings_fragment>
	#include <fog_fragment>
}`,ow=`uniform float rotation;
uniform vec2 center;
#include <common>
#include <uv_pars_vertex>
#include <fog_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	vec4 mvPosition = modelViewMatrix * vec4( 0.0, 0.0, 0.0, 1.0 );
	vec2 scale;
	scale.x = length( vec3( modelMatrix[ 0 ].x, modelMatrix[ 0 ].y, modelMatrix[ 0 ].z ) );
	scale.y = length( vec3( modelMatrix[ 1 ].x, modelMatrix[ 1 ].y, modelMatrix[ 1 ].z ) );
	#ifndef USE_SIZEATTENUATION
		bool isPerspective = isPerspectiveMatrix( projectionMatrix );
		if ( isPerspective ) scale *= - mvPosition.z;
	#endif
	vec2 alignedPosition = ( position.xy - ( center - vec2( 0.5 ) ) ) * scale;
	vec2 rotatedPosition;
	rotatedPosition.x = cos( rotation ) * alignedPosition.x - sin( rotation ) * alignedPosition.y;
	rotatedPosition.y = sin( rotation ) * alignedPosition.x + cos( rotation ) * alignedPosition.y;
	mvPosition.xy += rotatedPosition;
	gl_Position = projectionMatrix * mvPosition;
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	#include <fog_vertex>
}`,aw=`uniform vec3 diffuse;
uniform float opacity;
#include <common>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <fog_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	#include <clipping_planes_fragment>
	vec3 outgoingLight = vec3( 0.0 );
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	outgoingLight = diffuseColor.rgb;
	#include <output_fragment>
	#include <tonemapping_fragment>
	#include <encodings_fragment>
	#include <fog_fragment>
}`,u2={alphamap_fragment:IS,alphamap_pars_fragment:RS,alphatest_fragment:OS,alphatest_pars_fragment:PS,aomap_fragment:LS,aomap_pars_fragment:zS,begin_vertex:kS,beginnormal_vertex:NS,bsdfs:US,iridescence_fragment:FS,bumpmap_pars_fragment:BS,clipping_planes_fragment:GS,clipping_planes_pars_fragment:VS,clipping_planes_pars_vertex:jS,clipping_planes_vertex:WS,color_fragment:HS,color_pars_fragment:YS,color_pars_vertex:$S,color_vertex:JS,common:ZS,cube_uv_reflection_fragment:XS,defaultnormal_vertex:QS,displacementmap_pars_vertex:qS,displacementmap_vertex:KS,emissivemap_fragment:eM,emissivemap_pars_fragment:tM,encodings_fragment:nM,encodings_pars_fragment:iM,envmap_fragment:oM,envmap_common_pars_fragment:aM,envmap_pars_fragment:rM,envmap_pars_vertex:sM,envmap_physical_pars_fragment:yM,envmap_vertex:lM,fog_vertex:uM,fog_pars_vertex:cM,fog_fragment:dM,fog_pars_fragment:fM,gradientmap_pars_fragment:hM,lightmap_fragment:pM,lightmap_pars_fragment:mM,lights_lambert_fragment:gM,lights_lambert_pars_fragment:_M,lights_pars_begin:vM,lights_toon_fragment:bM,lights_toon_pars_fragment:xM,lights_phong_fragment:SM,lights_phong_pars_fragment:MM,lights_physical_fragment:AM,lights_physical_pars_fragment:wM,lights_fragment_begin:CM,lights_fragment_maps:TM,lights_fragment_end:EM,logdepthbuf_fragment:DM,logdepthbuf_pars_fragment:IM,logdepthbuf_pars_vertex:RM,logdepthbuf_vertex:OM,map_fragment:PM,map_pars_fragment:LM,map_particle_fragment:zM,map_particle_pars_fragment:kM,metalnessmap_fragment:NM,metalnessmap_pars_fragment:UM,morphcolor_vertex:FM,morphnormal_vertex:BM,morphtarget_pars_vertex:GM,morphtarget_vertex:VM,normal_fragment_begin:jM,normal_fragment_maps:WM,normal_pars_fragment:HM,normal_pars_vertex:YM,normal_vertex:$M,normalmap_pars_fragment:JM,clearcoat_normal_fragment_begin:ZM,clearcoat_normal_fragment_maps:XM,clearcoat_pars_fragment:QM,iridescence_pars_fragment:qM,output_fragment:KM,packing:eA,premultiplied_alpha_fragment:tA,project_vertex:nA,dithering_fragment:iA,dithering_pars_fragment:oA,roughnessmap_fragment:aA,roughnessmap_pars_fragment:rA,shadowmap_pars_fragment:sA,shadowmap_pars_vertex:lA,shadowmap_vertex:uA,shadowmask_pars_fragment:cA,skinbase_vertex:dA,skinning_pars_vertex:fA,skinning_vertex:hA,skinnormal_vertex:pA,specularmap_fragment:mA,specularmap_pars_fragment:gA,tonemapping_fragment:_A,tonemapping_pars_fragment:vA,transmission_fragment:yA,transmission_pars_fragment:bA,uv_pars_fragment:xA,uv_pars_vertex:SA,uv_vertex:MA,uv2_pars_fragment:AA,uv2_pars_vertex:wA,uv2_vertex:CA,worldpos_vertex:TA,background_vert:EA,background_frag:DA,cube_vert:IA,cube_frag:RA,depth_vert:OA,depth_frag:PA,distanceRGBA_vert:LA,distanceRGBA_frag:zA,equirect_vert:kA,equirect_frag:NA,linedashed_vert:UA,linedashed_frag:FA,meshbasic_vert:BA,meshbasic_frag:GA,meshlambert_vert:VA,meshlambert_frag:jA,meshmatcap_vert:WA,meshmatcap_frag:HA,meshnormal_vert:YA,meshnormal_frag:$A,meshphong_vert:JA,meshphong_frag:ZA,meshphysical_vert:XA,meshphysical_frag:QA,meshtoon_vert:qA,meshtoon_frag:KA,points_vert:ew,points_frag:tw,shadow_vert:nw,shadow_frag:iw,sprite_vert:ow,sprite_frag:aw},T1={common:{diffuse:{value:new _2(16777215)},opacity:{value:1},map:{value:null},uvTransform:{value:new H3},uv2Transform:{value:new H3},alphaMap:{value:null},alphaTest:{value:0}},specularmap:{specularMap:{value:null}},envmap:{envMap:{value:null},flipEnvMap:{value:-1},reflectivity:{value:1},ior:{value:1.5},refractionRatio:{value:.98}},aomap:{aoMap:{value:null},aoMapIntensity:{value:1}},lightmap:{lightMap:{value:null},lightMapIntensity:{value:1}},emissivemap:{emissiveMap:{value:null}},bumpmap:{bumpMap:{value:null},bumpScale:{value:1}},normalmap:{normalMap:{value:null},normalScale:{value:new G1(1,1)}},displacementmap:{displacementMap:{value:null},displacementScale:{value:1},displacementBias:{value:0}},roughnessmap:{roughnessMap:{value:null}},metalnessmap:{metalnessMap:{value:null}},gradientmap:{gradientMap:{value:null}},fog:{fogDensity:{value:25e-5},fogNear:{value:1},fogFar:{value:2e3},fogColor:{value:new _2(16777215)}},lights:{ambientLightColor:{value:[]},lightProbe:{value:[]},directionalLights:{value:[],properties:{direction:{},color:{}}},directionalLightShadows:{value:[],properties:{shadowBias:{},shadowNormalBias:{},shadowRadius:{},shadowMapSize:{}}},directionalShadowMap:{value:[]},directionalShadowMatrix:{value:[]},spotLights:{value:[],properties:{color:{},position:{},direction:{},distance:{},coneCos:{},penumbraCos:{},decay:{}}},spotLightShadows:{value:[],properties:{shadowBias:{},shadowNormalBias:{},shadowRadius:{},shadowMapSize:{}}},spotLightMap:{value:[]},spotShadowMap:{value:[]},spotLightMatrix:{value:[]},pointLights:{value:[],properties:{color:{},position:{},decay:{},distance:{}}},pointLightShadows:{value:[],properties:{shadowBias:{},shadowNormalBias:{},shadowRadius:{},shadowMapSize:{},shadowCameraNear:{},shadowCameraFar:{}}},pointShadowMap:{value:[]},pointShadowMatrix:{value:[]},hemisphereLights:{value:[],properties:{direction:{},skyColor:{},groundColor:{}}},rectAreaLights:{value:[],properties:{color:{},position:{},width:{},height:{}}},ltc_1:{value:null},ltc_2:{value:null}},points:{diffuse:{value:new _2(16777215)},opacity:{value:1},size:{value:1},scale:{value:1},map:{value:null},alphaMap:{value:null},alphaTest:{value:0},uvTransform:{value:new H3}},sprite:{diffuse:{value:new _2(16777215)},opacity:{value:1},center:{value:new G1(.5,.5)},rotation:{value:0},map:{value:null},alphaMap:{value:null},alphaTest:{value:0},uvTransform:{value:new H3}}},f4={basic:{uniforms:c3([T1.common,T1.specularmap,T1.envmap,T1.aomap,T1.lightmap,T1.fog]),vertexShader:u2.meshbasic_vert,fragmentShader:u2.meshbasic_frag},lambert:{uniforms:c3([T1.common,T1.specularmap,T1.envmap,T1.aomap,T1.lightmap,T1.emissivemap,T1.bumpmap,T1.normalmap,T1.displacementmap,T1.fog,T1.lights,{emissive:{value:new _2(0)}}]),vertexShader:u2.meshlambert_vert,fragmentShader:u2.meshlambert_frag},phong:{uniforms:c3([T1.common,T1.specularmap,T1.envmap,T1.aomap,T1.lightmap,T1.emissivemap,T1.bumpmap,T1.normalmap,T1.displacementmap,T1.fog,T1.lights,{emissive:{value:new _2(0)},specular:{value:new _2(1118481)},shininess:{value:30}}]),vertexShader:u2.meshphong_vert,fragmentShader:u2.meshphong_frag},standard:{uniforms:c3([T1.common,T1.envmap,T1.aomap,T1.lightmap,T1.emissivemap,T1.bumpmap,T1.normalmap,T1.displacementmap,T1.roughnessmap,T1.metalnessmap,T1.fog,T1.lights,{emissive:{value:new _2(0)},roughness:{value:1},metalness:{value:0},envMapIntensity:{value:1}}]),vertexShader:u2.meshphysical_vert,fragmentShader:u2.meshphysical_frag},toon:{uniforms:c3([T1.common,T1.aomap,T1.lightmap,T1.emissivemap,T1.bumpmap,T1.normalmap,T1.displacementmap,T1.gradientmap,T1.fog,T1.lights,{emissive:{value:new _2(0)}}]),vertexShader:u2.meshtoon_vert,fragmentShader:u2.meshtoon_frag},matcap:{uniforms:c3([T1.common,T1.bumpmap,T1.normalmap,T1.displacementmap,T1.fog,{matcap:{value:null}}]),vertexShader:u2.meshmatcap_vert,fragmentShader:u2.meshmatcap_frag},points:{uniforms:c3([T1.points,T1.fog]),vertexShader:u2.points_vert,fragmentShader:u2.points_frag},dashed:{uniforms:c3([T1.common,T1.fog,{scale:{value:1},dashSize:{value:1},totalSize:{value:2}}]),vertexShader:u2.linedashed_vert,fragmentShader:u2.linedashed_frag},depth:{uniforms:c3([T1.common,T1.displacementmap]),vertexShader:u2.depth_vert,fragmentShader:u2.depth_frag},normal:{uniforms:c3([T1.common,T1.bumpmap,T1.normalmap,T1.displacementmap,{opacity:{value:1}}]),vertexShader:u2.meshnormal_vert,fragmentShader:u2.meshnormal_frag},sprite:{uniforms:c3([T1.sprite,T1.fog]),vertexShader:u2.sprite_vert,fragmentShader:u2.sprite_frag},background:{uniforms:{uvTransform:{value:new H3},t2D:{value:null}},vertexShader:u2.background_vert,fragmentShader:u2.background_frag},cube:{uniforms:c3([T1.envmap,{opacity:{value:1}}]),vertexShader:u2.cube_vert,fragmentShader:u2.cube_frag},equirect:{uniforms:{tEquirect:{value:null}},vertexShader:u2.equirect_vert,fragmentShader:u2.equirect_frag},distanceRGBA:{uniforms:c3([T1.common,T1.displacementmap,{referencePosition:{value:new Y},nearDistance:{value:1},farDistance:{value:1e3}}]),vertexShader:u2.distanceRGBA_vert,fragmentShader:u2.distanceRGBA_frag},shadow:{uniforms:c3([T1.lights,T1.fog,{color:{value:new _2(0)},opacity:{value:1}}]),vertexShader:u2.shadow_vert,fragmentShader:u2.shadow_frag}};f4.physical={uniforms:c3([f4.standard.uniforms,{clearcoat:{value:0},clearcoatMap:{value:null},clearcoatRoughness:{value:0},clearcoatRoughnessMap:{value:null},clearcoatNormalScale:{value:new G1(1,1)},clearcoatNormalMap:{value:null},iridescence:{value:0},iridescenceMap:{value:null},iridescenceIOR:{value:1.3},iridescenceThicknessMinimum:{value:100},iridescenceThicknessMaximum:{value:400},iridescenceThicknessMap:{value:null},sheen:{value:0},sheenColor:{value:new _2(0)},sheenColorMap:{value:null},sheenRoughness:{value:1},sheenRoughnessMap:{value:null},transmission:{value:0},transmissionMap:{value:null},transmissionSamplerSize:{value:new G1},transmissionSamplerMap:{value:null},thickness:{value:0},thicknessMap:{value:null},attenuationDistance:{value:0},attenuationColor:{value:new _2(0)},specularIntensity:{value:1},specularIntensityMap:{value:null},specularColor:{value:new _2(1,1,1)},specularColorMap:{value:null}}]),vertexShader:u2.meshphysical_vert,fragmentShader:u2.meshphysical_frag};function rw(o,e,t,n,i,a){const r=new _2(0);let s=i===!0?0:1,u,c,d=null,h=0,p=null;function g(m,v){let b=!1,x=v.isScene===!0?v.background:null;x&&x.isTexture&&(x=e.get(x));const w=o.xr,M=w.getSession&&w.getSession();M&&M.environmentBlendMode==="additive"&&(x=null),x===null?y(r,s):x&&x.isColor&&(y(x,1),b=!0),(o.autoClear||b)&&o.clear(o.autoClearColor,o.autoClearDepth,o.autoClearStencil),x&&(x.isCubeTexture||x.mapping===n6)?(c===void 0&&(c=new s3(new F5(1,1,1),new N4({name:"BackgroundCubeMaterial",uniforms:F9(f4.cube.uniforms),vertexShader:f4.cube.vertexShader,fragmentShader:f4.cube.fragmentShader,side:X3,depthTest:!1,depthWrite:!1,fog:!1})),c.geometry.deleteAttribute("normal"),c.geometry.deleteAttribute("uv"),c.onBeforeRender=function(A,S,D){this.matrixWorld.copyPosition(D.matrixWorld)},Object.defineProperty(c.material,"envMap",{get:function(){return this.uniforms.envMap.value}}),n.update(c)),c.material.uniforms.envMap.value=x,c.material.uniforms.flipEnvMap.value=x.isCubeTexture&&x.isRenderTargetTexture===!1?-1:1,(d!==x||h!==x.version||p!==o.toneMapping)&&(c.material.needsUpdate=!0,d=x,h=x.version,p=o.toneMapping),c.layers.enableAll(),m.unshift(c,c.geometry,c.material,0,0,null)):x&&x.isTexture&&(u===void 0&&(u=new s3(new J9(2,2),new N4({name:"BackgroundMaterial",uniforms:F9(f4.background.uniforms),vertexShader:f4.background.vertexShader,fragmentShader:f4.background.fragmentShader,side:z9,depthTest:!1,depthWrite:!1,fog:!1})),u.geometry.deleteAttribute("normal"),Object.defineProperty(u.material,"map",{get:function(){return this.uniforms.t2D.value}}),n.update(u)),u.material.uniforms.t2D.value=x,x.matrixAutoUpdate===!0&&x.updateMatrix(),u.material.uniforms.uvTransform.value.copy(x.matrix),(d!==x||h!==x.version||p!==o.toneMapping)&&(u.material.needsUpdate=!0,d=x,h=x.version,p=o.toneMapping),u.layers.enableAll(),m.unshift(u,u.geometry,u.material,0,0,null))}function y(m,v){t.buffers.color.setClear(m.r,m.g,m.b,v,a)}return{getClearColor:function(){return r},setClearColor:function(m,v=1){r.set(m),s=v,y(r,s)},getClearAlpha:function(){return s},setClearAlpha:function(m){s=m,y(r,s)},render:g}}function sw(o,e,t,n){const i=o.getParameter(34921),a=n.isWebGL2?null:e.get("OES_vertex_array_object"),r=n.isWebGL2||a!==null,s={},u=v(null);let c=u,d=!1;function h(R,U,H,V,N){let z=!1;if(r){const G=m(V,H,U);c!==G&&(c=G,g(c.object)),z=b(R,V,H,N),z&&x(R,V,H,N)}else{const G=U.wireframe===!0;(c.geometry!==V.id||c.program!==H.id||c.wireframe!==G)&&(c.geometry=V.id,c.program=H.id,c.wireframe=G,z=!0)}N!==null&&t.update(N,34963),(z||d)&&(d=!1,C(R,U,H,V),N!==null&&o.bindBuffer(34963,t.get(N).buffer))}function p(){return n.isWebGL2?o.createVertexArray():a.createVertexArrayOES()}function g(R){return n.isWebGL2?o.bindVertexArray(R):a.bindVertexArrayOES(R)}function y(R){return n.isWebGL2?o.deleteVertexArray(R):a.deleteVertexArrayOES(R)}function m(R,U,H){const V=H.wireframe===!0;let N=s[R.id];N===void 0&&(N={},s[R.id]=N);let z=N[U.id];z===void 0&&(z={},N[U.id]=z);let G=z[V];return G===void 0&&(G=v(p()),z[V]=G),G}function v(R){const U=[],H=[],V=[];for(let N=0;N<i;N++)U[N]=0,H[N]=0,V[N]=0;return{geometry:null,program:null,wireframe:!1,newAttributes:U,enabledAttributes:H,attributeDivisors:V,object:R,attributes:{},index:null}}function b(R,U,H,V){const N=c.attributes,z=U.attributes;let G=0;const t1=H.getAttributes();for(const e1 in t1)if(t1[e1].location>=0){const s1=N[e1];let q=z[e1];if(q===void 0&&(e1==="instanceMatrix"&&R.instanceMatrix&&(q=R.instanceMatrix),e1==="instanceColor"&&R.instanceColor&&(q=R.instanceColor)),s1===void 0||s1.attribute!==q||q&&s1.data!==q.data)return!0;G++}return c.attributesNum!==G||c.index!==V}function x(R,U,H,V){const N={},z=U.attributes;let G=0;const t1=H.getAttributes();for(const e1 in t1)if(t1[e1].location>=0){let s1=z[e1];s1===void 0&&(e1==="instanceMatrix"&&R.instanceMatrix&&(s1=R.instanceMatrix),e1==="instanceColor"&&R.instanceColor&&(s1=R.instanceColor));const q={};q.attribute=s1,s1&&s1.data&&(q.data=s1.data),N[e1]=q,G++}c.attributes=N,c.attributesNum=G,c.index=V}function w(){const R=c.newAttributes;for(let U=0,H=R.length;U<H;U++)R[U]=0}function M(R){A(R,0)}function A(R,U){const H=c.newAttributes,V=c.enabledAttributes,N=c.attributeDivisors;H[R]=1,V[R]===0&&(o.enableVertexAttribArray(R),V[R]=1),N[R]!==U&&((n.isWebGL2?o:e.get("ANGLE_instanced_arrays"))[n.isWebGL2?"vertexAttribDivisor":"vertexAttribDivisorANGLE"](R,U),N[R]=U)}function S(){const R=c.newAttributes,U=c.enabledAttributes;for(let H=0,V=U.length;H<V;H++)U[H]!==R[H]&&(o.disableVertexAttribArray(H),U[H]=0)}function D(R,U,H,V,N,z){n.isWebGL2===!0&&(H===5124||H===5125)?o.vertexAttribIPointer(R,U,H,N,z):o.vertexAttribPointer(R,U,H,V,N,z)}function C(R,U,H,V){if(n.isWebGL2===!1&&(R.isInstancedMesh||V.isInstancedBufferGeometry)&&e.get("ANGLE_instanced_arrays")===null)return;w();const N=V.attributes,z=H.getAttributes(),G=U.defaultAttributeValues;for(const t1 in z){const e1=z[t1];if(e1.location>=0){let u1=N[t1];if(u1===void 0&&(t1==="instanceMatrix"&&R.instanceMatrix&&(u1=R.instanceMatrix),t1==="instanceColor"&&R.instanceColor&&(u1=R.instanceColor)),u1!==void 0){const s1=u1.normalized,q=u1.itemSize,Z=t.get(u1);if(Z===void 0)continue;const p1=Z.buffer,m1=Z.type,f1=Z.bytesPerElement;if(u1.isInterleavedBufferAttribute){const d1=u1.data,N1=d1.stride,M1=u1.offset;if(d1.isInstancedInterleavedBuffer){for(let S1=0;S1<e1.locationSize;S1++)A(e1.location+S1,d1.meshPerAttribute);R.isInstancedMesh!==!0&&V._maxInstanceCount===void 0&&(V._maxInstanceCount=d1.meshPerAttribute*d1.count)}else for(let S1=0;S1<e1.locationSize;S1++)M(e1.location+S1);o.bindBuffer(34962,p1);for(let S1=0;S1<e1.locationSize;S1++)D(e1.location+S1,q/e1.locationSize,m1,s1,N1*f1,(M1+q/e1.locationSize*S1)*f1)}else{if(u1.isInstancedBufferAttribute){for(let d1=0;d1<e1.locationSize;d1++)A(e1.location+d1,u1.meshPerAttribute);R.isInstancedMesh!==!0&&V._maxInstanceCount===void 0&&(V._maxInstanceCount=u1.meshPerAttribute*u1.count)}else for(let d1=0;d1<e1.locationSize;d1++)M(e1.location+d1);o.bindBuffer(34962,p1);for(let d1=0;d1<e1.locationSize;d1++)D(e1.location+d1,q/e1.locationSize,m1,s1,q*f1,q/e1.locationSize*d1*f1)}}else if(G!==void 0){const s1=G[t1];if(s1!==void 0)switch(s1.length){case 2:o.vertexAttrib2fv(e1.location,s1);break;case 3:o.vertexAttrib3fv(e1.location,s1);break;case 4:o.vertexAttrib4fv(e1.location,s1);break;default:o.vertexAttrib1fv(e1.location,s1)}}}}S()}function E(){X();for(const R in s){const U=s[R];for(const H in U){const V=U[H];for(const N in V)y(V[N].object),delete V[N];delete U[H]}delete s[R]}}function k(R){if(s[R.id]===void 0)return;const U=s[R.id];for(const H in U){const V=U[H];for(const N in V)y(V[N].object),delete V[N];delete U[H]}delete s[R.id]}function $(R){for(const U in s){const H=s[U];if(H[R.id]===void 0)continue;const V=H[R.id];for(const N in V)y(V[N].object),delete V[N];delete H[R.id]}}function X(){F(),d=!0,c!==u&&(c=u,g(c.object))}function F(){u.geometry=null,u.program=null,u.wireframe=!1}return{setup:h,reset:X,resetDefaultState:F,dispose:E,releaseStatesOfGeometry:k,releaseStatesOfProgram:$,initAttributes:w,enableAttribute:M,disableUnusedAttributes:S}}function lw(o,e,t,n){const i=n.isWebGL2;let a;function r(c){a=c}function s(c,d){o.drawArrays(a,c,d),t.update(d,a,1)}function u(c,d,h){if(h===0)return;let p,g;if(i)p=o,g="drawArraysInstanced";else if(p=e.get("ANGLE_instanced_arrays"),g="drawArraysInstancedANGLE",p===null){console.error("THREE.WebGLBufferRenderer: using THREE.InstancedBufferGeometry but hardware does not support extension ANGLE_instanced_arrays.");return}p[g](a,c,d,h),t.update(d,a,h)}this.setMode=r,this.render=s,this.renderInstances=u}function uw(o,e,t){let n;function i(){if(n!==void 0)return n;if(e.has("EXT_texture_filter_anisotropic")===!0){const D=e.get("EXT_texture_filter_anisotropic");n=o.getParameter(D.MAX_TEXTURE_MAX_ANISOTROPY_EXT)}else n=0;return n}function a(D){if(D==="highp"){if(o.getShaderPrecisionFormat(35633,36338).precision>0&&o.getShaderPrecisionFormat(35632,36338).precision>0)return"highp";D="mediump"}return D==="mediump"&&o.getShaderPrecisionFormat(35633,36337).precision>0&&o.getShaderPrecisionFormat(35632,36337).precision>0?"mediump":"lowp"}const r=typeof WebGL2RenderingContext!="undefined"&&o instanceof WebGL2RenderingContext||typeof WebGL2ComputeRenderingContext!="undefined"&&o instanceof WebGL2ComputeRenderingContext;let s=t.precision!==void 0?t.precision:"highp";const u=a(s);u!==s&&(console.warn("THREE.WebGLRenderer:",s,"not supported, using",u,"instead."),s=u);const c=r||e.has("WEBGL_draw_buffers"),d=t.logarithmicDepthBuffer===!0,h=o.getParameter(34930),p=o.getParameter(35660),g=o.getParameter(3379),y=o.getParameter(34076),m=o.getParameter(34921),v=o.getParameter(36347),b=o.getParameter(36348),x=o.getParameter(36349),w=p>0,M=r||e.has("OES_texture_float"),A=w&&M,S=r?o.getParameter(36183):0;return{isWebGL2:r,drawBuffers:c,getMaxAnisotropy:i,getMaxPrecision:a,precision:s,logarithmicDepthBuffer:d,maxTextures:h,maxVertexTextures:p,maxTextureSize:g,maxCubemapSize:y,maxAttributes:m,maxVertexUniforms:v,maxVaryings:b,maxFragmentUniforms:x,vertexTextures:w,floatFragmentTextures:M,floatVertexTextures:A,maxSamples:S}}function cw(o){const e=this;let t=null,n=0,i=!1,a=!1;const r=new S0,s=new H3,u={value:null,needsUpdate:!1};this.uniform=u,this.numPlanes=0,this.numIntersection=0,this.init=function(h,p,g){const y=h.length!==0||p||n!==0||i;return i=p,t=d(h,g,0),n=h.length,y},this.beginShadows=function(){a=!0,d(null)},this.endShadows=function(){a=!1,c()},this.setState=function(h,p,g){const y=h.clippingPlanes,m=h.clipIntersection,v=h.clipShadows,b=o.get(h);if(!i||y===null||y.length===0||a&&!v)a?d(null):c();else{const x=a?0:n,w=x*4;let M=b.clippingState||null;u.value=M,M=d(y,p,w,g);for(let A=0;A!==w;++A)M[A]=t[A];b.clippingState=M,this.numIntersection=m?this.numPlanes:0,this.numPlanes+=x}};function c(){u.value!==t&&(u.value=t,u.needsUpdate=n>0),e.numPlanes=n,e.numIntersection=0}function d(h,p,g,y){const m=h!==null?h.length:0;let v=null;if(m!==0){if(v=u.value,y!==!0||v===null){const b=g+m*4,x=p.matrixWorldInverse;s.getNormalMatrix(x),(v===null||v.length<b)&&(v=new Float32Array(b));for(let w=0,M=g;w!==m;++w,M+=4)r.copy(h[w]).applyMatrix4(x,s),r.normal.toArray(v,M),v[M+3]=r.constant}u.value=v,u.needsUpdate=!0}return e.numPlanes=m,e.numIntersection=0,v}}function dw(o){let e=new WeakMap;function t(r,s){return s===ge?r.mapping=k9:s===_e&&(r.mapping=N9),r}function n(r){if(r&&r.isTexture&&r.isRenderTargetTexture===!1){const s=r.mapping;if(s===ge||s===_e)if(e.has(r)){const u=e.get(r).texture;return t(u,r.mapping)}else{const u=r.image;if(u&&u.height>0){const c=new CS(u.height/2);return c.fromEquirectangularTexture(o,r),e.set(r,c),r.addEventListener("dispose",i),t(c.texture,r.mapping)}else return null}}return r}function i(r){const s=r.target;s.removeEventListener("dispose",i);const u=e.get(s);u!==void 0&&(e.delete(s),u.dispose())}function a(){e=new WeakMap}return{get:n,dispose:a}}class fw extends fs{constructor(e=-1,t=1,n=1,i=-1,a=.1,r=2e3){super(),this.isOrthographicCamera=!0,this.type="OrthographicCamera",this.zoom=1,this.view=null,this.left=e,this.right=t,this.top=n,this.bottom=i,this.near=a,this.far=r,this.updateProjectionMatrix()}copy(e,t){return super.copy(e,t),this.left=e.left,this.right=e.right,this.top=e.top,this.bottom=e.bottom,this.near=e.near,this.far=e.far,this.zoom=e.zoom,this.view=e.view===null?null:Object.assign({},e.view),this}setViewOffset(e,t,n,i,a,r){this.view===null&&(this.view={enabled:!0,fullWidth:1,fullHeight:1,offsetX:0,offsetY:0,width:1,height:1}),this.view.enabled=!0,this.view.fullWidth=e,this.view.fullHeight=t,this.view.offsetX=n,this.view.offsetY=i,this.view.width=a,this.view.height=r,this.updateProjectionMatrix()}clearViewOffset(){this.view!==null&&(this.view.enabled=!1),this.updateProjectionMatrix()}updateProjectionMatrix(){const e=(this.right-this.left)/(2*this.zoom),t=(this.top-this.bottom)/(2*this.zoom),n=(this.right+this.left)/2,i=(this.top+this.bottom)/2;let a=n-e,r=n+e,s=i+t,u=i-t;if(this.view!==null&&this.view.enabled){const c=(this.right-this.left)/this.view.fullWidth/this.zoom,d=(this.top-this.bottom)/this.view.fullHeight/this.zoom;a+=c*this.view.offsetX,r=a+c*this.view.width,s-=d*this.view.offsetY,u=s-d*this.view.height}this.projectionMatrix.makeOrthographic(a,r,s,u,this.near,this.far),this.projectionMatrixInverse.copy(this.projectionMatrix).invert()}toJSON(e){const t=super.toJSON(e);return t.object.zoom=this.zoom,t.object.left=this.left,t.object.right=this.right,t.object.top=this.top,t.object.bottom=this.bottom,t.object.near=this.near,t.object.far=this.far,this.view!==null&&(t.object.view=Object.assign({},this.view)),t}}const T9=4,Lo=[.125,.215,.35,.446,.526,.582],w0=20,Z6=new fw,zo=new _2;let X6=null;const M0=(1+Math.sqrt(5))/2,f9=1/M0,ko=[new Y(1,1,1),new Y(-1,1,1),new Y(1,1,-1),new Y(-1,1,-1),new Y(0,M0,f9),new Y(0,M0,-f9),new Y(f9,0,M0),new Y(-f9,0,M0),new Y(M0,f9,0),new Y(-M0,f9,0)];class No{constructor(e){this._renderer=e,this._pingPongRenderTarget=null,this._lodMax=0,this._cubeSize=0,this._lodPlanes=[],this._sizeLods=[],this._sigmas=[],this._blurMaterial=null,this._cubemapMaterial=null,this._equirectMaterial=null,this._compileMaterial(this._blurMaterial)}fromScene(e,t=0,n=.1,i=100){X6=this._renderer.getRenderTarget(),this._setSize(256);const a=this._allocateTargets();return a.depthBuffer=!0,this._sceneToCubeUV(e,n,i,a),t>0&&this._blur(a,0,0,t),this._applyPMREM(a),this._cleanup(a),a}fromEquirectangular(e,t=null){return this._fromTexture(e,t)}fromCubemap(e,t=null){return this._fromTexture(e,t)}compileCubemapShader(){this._cubemapMaterial===null&&(this._cubemapMaterial=Bo(),this._compileMaterial(this._cubemapMaterial))}compileEquirectangularShader(){this._equirectMaterial===null&&(this._equirectMaterial=Fo(),this._compileMaterial(this._equirectMaterial))}dispose(){this._dispose(),this._cubemapMaterial!==null&&this._cubemapMaterial.dispose(),this._equirectMaterial!==null&&this._equirectMaterial.dispose()}_setSize(e){this._lodMax=Math.floor(Math.log2(e)),this._cubeSize=Math.pow(2,this._lodMax)}_dispose(){this._blurMaterial!==null&&this._blurMaterial.dispose(),this._pingPongRenderTarget!==null&&this._pingPongRenderTarget.dispose();for(let e=0;e<this._lodPlanes.length;e++)this._lodPlanes[e].dispose()}_cleanup(e){this._renderer.setRenderTarget(X6),e.scissorTest=!1,g8(e,0,0,e.width,e.height)}_fromTexture(e,t){e.mapping===k9||e.mapping===N9?this._setSize(e.image.length===0?16:e.image[0].width||e.image[0].image.width):this._setSize(e.image.width/4),X6=this._renderer.getRenderTarget();const n=t||this._allocateTargets();return this._textureToCubeUV(e,n),this._applyPMREM(n),this._cleanup(n),n}_allocateTargets(){const e=3*Math.max(this._cubeSize,112),t=4*this._cubeSize,n={magFilter:j3,minFilter:j3,generateMipmaps:!1,type:S5,format:g4,encoding:B0,depthBuffer:!1},i=Uo(e,t,n);if(this._pingPongRenderTarget===null||this._pingPongRenderTarget.width!==e){this._pingPongRenderTarget!==null&&this._dispose(),this._pingPongRenderTarget=Uo(e,t,n);const{_lodMax:a}=this;({sizeLods:this._sizeLods,lodPlanes:this._lodPlanes,sigmas:this._sigmas}=hw(a)),this._blurMaterial=pw(a,e,t)}return i}_compileMaterial(e){const t=new s3(this._lodPlanes[0],e);this._renderer.compile(t,Z6)}_sceneToCubeUV(e,t,n,i){const s=new W3(90,1,t,n),u=[1,-1,1,1,1,1],c=[1,1,1,-1,-1,-1],d=this._renderer,h=d.autoClear,p=d.toneMapping;d.getClearColor(zo),d.toneMapping=z4,d.autoClear=!1;const g=new O4({name:"PMREM.Background",side:X3,depthWrite:!1,depthTest:!1}),y=new s3(new F5,g);let m=!1;const v=e.background;v?v.isColor&&(g.color.copy(v),e.background=null,m=!0):(g.color.copy(zo),m=!0);for(let b=0;b<6;b++){const x=b%3;x===0?(s.up.set(0,u[b],0),s.lookAt(c[b],0,0)):x===1?(s.up.set(0,0,u[b]),s.lookAt(0,c[b],0)):(s.up.set(0,u[b],0),s.lookAt(0,0,c[b]));const w=this._cubeSize;g8(i,x*w,b>2?w:0,w,w),d.setRenderTarget(i),m&&d.render(y,s),d.render(e,s)}y.geometry.dispose(),y.material.dispose(),d.toneMapping=p,d.autoClear=h,e.background=v}_textureToCubeUV(e,t){const n=this._renderer,i=e.mapping===k9||e.mapping===N9;i?(this._cubemapMaterial===null&&(this._cubemapMaterial=Bo()),this._cubemapMaterial.uniforms.flipEnvMap.value=e.isRenderTargetTexture===!1?-1:1):this._equirectMaterial===null&&(this._equirectMaterial=Fo());const a=i?this._cubemapMaterial:this._equirectMaterial,r=new s3(this._lodPlanes[0],a),s=a.uniforms;s.envMap.value=e;const u=this._cubeSize;g8(t,0,0,3*u,2*u),n.setRenderTarget(t),n.render(r,Z6)}_applyPMREM(e){const t=this._renderer,n=t.autoClear;t.autoClear=!1;for(let i=1;i<this._lodPlanes.length;i++){const a=Math.sqrt(this._sigmas[i]*this._sigmas[i]-this._sigmas[i-1]*this._sigmas[i-1]),r=ko[(i-1)%ko.length];this._blur(e,i-1,i,a,r)}t.autoClear=n}_blur(e,t,n,i,a){const r=this._pingPongRenderTarget;this._halfBlur(e,r,t,n,i,"latitudinal",a),this._halfBlur(r,e,n,n,i,"longitudinal",a)}_halfBlur(e,t,n,i,a,r,s){const u=this._renderer,c=this._blurMaterial;r!=="latitudinal"&&r!=="longitudinal"&&console.error("blur direction must be either latitudinal or longitudinal!");const d=3,h=new s3(this._lodPlanes[i],c),p=c.uniforms,g=this._sizeLods[n]-1,y=isFinite(a)?Math.PI/(2*g):2*Math.PI/(2*w0-1),m=a/y,v=isFinite(a)?1+Math.floor(d*m):w0;v>w0&&console.warn(`sigmaRadians, ${a}, is too large and will clip, as it requested ${v} samples when the maximum is set to ${w0}`);const b=[];let x=0;for(let D=0;D<w0;++D){const C=D/m,E=Math.exp(-C*C/2);b.push(E),D===0?x+=E:D<v&&(x+=2*E)}for(let D=0;D<b.length;D++)b[D]=b[D]/x;p.envMap.value=e.texture,p.samples.value=v,p.weights.value=b,p.latitudinal.value=r==="latitudinal",s&&(p.poleAxis.value=s);const{_lodMax:w}=this;p.dTheta.value=y,p.mipInt.value=w-n;const M=this._sizeLods[i],A=3*M*(i>w-T9?i-w+T9:0),S=4*(this._cubeSize-M);g8(t,A,S,3*M,2*M),u.setRenderTarget(t),u.render(h,Z6)}}function hw(o){const e=[],t=[],n=[];let i=o;const a=o-T9+1+Lo.length;for(let r=0;r<a;r++){const s=Math.pow(2,i);t.push(s);let u=1/s;r>o-T9?u=Lo[r-o+T9-1]:r===0&&(u=0),n.push(u);const c=1/(s-2),d=-c,h=1+c,p=[d,d,h,d,h,h,d,d,h,h,d,h],g=6,y=6,m=3,v=2,b=1,x=new Float32Array(m*y*g),w=new Float32Array(v*y*g),M=new Float32Array(b*y*g);for(let S=0;S<g;S++){const D=S%3*2/3-1,C=S>2?0:-1,E=[D,C,0,D+2/3,C,0,D+2/3,C+1,0,D,C,0,D+2/3,C+1,0,D,C+1,0];x.set(E,m*y*S),w.set(p,v*y*S);const k=[S,S,S,S,S,S];M.set(k,b*y*S)}const A=new E3;A.setAttribute("position",new z3(x,m)),A.setAttribute("uv",new z3(w,v)),A.setAttribute("faceIndex",new z3(M,b)),e.push(A),i>T9&&i--}return{lodPlanes:e,sizeLods:t,sigmas:n}}function Uo(o,e,t){const n=new G0(o,e,t);return n.texture.mapping=n6,n.texture.name="PMREM.cubeUv",n.scissorTest=!0,n}function g8(o,e,t,n,i){o.viewport.set(e,t,n,i),o.scissor.set(e,t,n,i)}function pw(o,e,t){const n=new Float32Array(w0),i=new Y(0,1,0);return new N4({name:"SphericalGaussianBlur",defines:{n:w0,CUBEUV_TEXEL_WIDTH:1/e,CUBEUV_TEXEL_HEIGHT:1/t,CUBEUV_MAX_MIP:`${o}.0`},uniforms:{envMap:{value:null},samples:{value:1},weights:{value:n},latitudinal:{value:!1},dTheta:{value:0},mipInt:{value:0},poleAxis:{value:i}},vertexShader:Kt(),fragmentShader:`

			precision mediump float;
			precision mediump int;

			varying vec3 vOutputDirection;

			uniform sampler2D envMap;
			uniform int samples;
			uniform float weights[ n ];
			uniform bool latitudinal;
			uniform float dTheta;
			uniform float mipInt;
			uniform vec3 poleAxis;

			#define ENVMAP_TYPE_CUBE_UV
			#include <cube_uv_reflection_fragment>

			vec3 getSample( float theta, vec3 axis ) {

				float cosTheta = cos( theta );
				// Rodrigues' axis-angle rotation
				vec3 sampleDirection = vOutputDirection * cosTheta
					+ cross( axis, vOutputDirection ) * sin( theta )
					+ axis * dot( axis, vOutputDirection ) * ( 1.0 - cosTheta );

				return bilinearCubeUV( envMap, sampleDirection, mipInt );

			}

			void main() {

				vec3 axis = latitudinal ? poleAxis : cross( poleAxis, vOutputDirection );

				if ( all( equal( axis, vec3( 0.0 ) ) ) ) {

					axis = vec3( vOutputDirection.z, 0.0, - vOutputDirection.x );

				}

				axis = normalize( axis );

				gl_FragColor = vec4( 0.0, 0.0, 0.0, 1.0 );
				gl_FragColor.rgb += weights[ 0 ] * getSample( 0.0, axis );

				for ( int i = 1; i < n; i++ ) {

					if ( i >= samples ) {

						break;

					}

					float theta = dTheta * float( i );
					gl_FragColor.rgb += weights[ i ] * getSample( -1.0 * theta, axis );
					gl_FragColor.rgb += weights[ i ] * getSample( theta, axis );

				}

			}
		`,blending:i0,depthTest:!1,depthWrite:!1})}function Fo(){return new N4({name:"EquirectangularToCubeUV",uniforms:{envMap:{value:null}},vertexShader:Kt(),fragmentShader:`

			precision mediump float;
			precision mediump int;

			varying vec3 vOutputDirection;

			uniform sampler2D envMap;

			#include <common>

			void main() {

				vec3 outputDirection = normalize( vOutputDirection );
				vec2 uv = equirectUv( outputDirection );

				gl_FragColor = vec4( texture2D ( envMap, uv ).rgb, 1.0 );

			}
		`,blending:i0,depthTest:!1,depthWrite:!1})}function Bo(){return new N4({name:"CubemapToCubeUV",uniforms:{envMap:{value:null},flipEnvMap:{value:-1}},vertexShader:Kt(),fragmentShader:`

			precision mediump float;
			precision mediump int;

			uniform float flipEnvMap;

			varying vec3 vOutputDirection;

			uniform samplerCube envMap;

			void main() {

				gl_FragColor = textureCube( envMap, vec3( flipEnvMap * vOutputDirection.x, vOutputDirection.yz ) );

			}
		`,blending:i0,depthTest:!1,depthWrite:!1})}function Kt(){return`

		precision mediump float;
		precision mediump int;

		attribute float faceIndex;

		varying vec3 vOutputDirection;

		// RH coordinate system; PMREM face-indexing convention
		vec3 getDirection( vec2 uv, float face ) {

			uv = 2.0 * uv - 1.0;

			vec3 direction = vec3( uv, 1.0 );

			if ( face == 0.0 ) {

				direction = direction.zyx; // ( 1, v, u ) pos x

			} else if ( face == 1.0 ) {

				direction = direction.xzy;
				direction.xz *= -1.0; // ( -u, 1, -v ) pos y

			} else if ( face == 2.0 ) {

				direction.x *= -1.0; // ( -u, v, 1 ) pos z

			} else if ( face == 3.0 ) {

				direction = direction.zyx;
				direction.xz *= -1.0; // ( -1, v, -u ) neg x

			} else if ( face == 4.0 ) {

				direction = direction.xzy;
				direction.xy *= -1.0; // ( -u, -1, v ) neg y

			} else if ( face == 5.0 ) {

				direction.z *= -1.0; // ( u, v, -1 ) neg z

			}

			return direction;

		}

		void main() {

			vOutputDirection = getDirection( uv, faceIndex );
			gl_Position = vec4( position, 1.0 );

		}
	`}function mw(o){let e=new WeakMap,t=null;function n(s){if(s&&s.isTexture){const u=s.mapping,c=u===ge||u===_e,d=u===k9||u===N9;if(c||d)if(s.isRenderTargetTexture&&s.needsPMREMUpdate===!0){s.needsPMREMUpdate=!1;let h=e.get(s);return t===null&&(t=new No(o)),h=c?t.fromEquirectangular(s,h):t.fromCubemap(s,h),e.set(s,h),h.texture}else{if(e.has(s))return e.get(s).texture;{const h=s.image;if(c&&h&&h.height>0||d&&h&&i(h)){t===null&&(t=new No(o));const p=c?t.fromEquirectangular(s):t.fromCubemap(s);return e.set(s,p),s.addEventListener("dispose",a),p.texture}else return null}}}return s}function i(s){let u=0;const c=6;for(let d=0;d<c;d++)s[d]!==void 0&&u++;return u===c}function a(s){const u=s.target;u.removeEventListener("dispose",a);const c=e.get(u);c!==void 0&&(e.delete(u),c.dispose())}function r(){e=new WeakMap,t!==null&&(t.dispose(),t=null)}return{get:n,dispose:r}}function gw(o){const e={};function t(n){if(e[n]!==void 0)return e[n];let i;switch(n){case"WEBGL_depth_texture":i=o.getExtension("WEBGL_depth_texture")||o.getExtension("MOZ_WEBGL_depth_texture")||o.getExtension("WEBKIT_WEBGL_depth_texture");break;case"EXT_texture_filter_anisotropic":i=o.getExtension("EXT_texture_filter_anisotropic")||o.getExtension("MOZ_EXT_texture_filter_anisotropic")||o.getExtension("WEBKIT_EXT_texture_filter_anisotropic");break;case"WEBGL_compressed_texture_s3tc":i=o.getExtension("WEBGL_compressed_texture_s3tc")||o.getExtension("MOZ_WEBGL_compressed_texture_s3tc")||o.getExtension("WEBKIT_WEBGL_compressed_texture_s3tc");break;case"WEBGL_compressed_texture_pvrtc":i=o.getExtension("WEBGL_compressed_texture_pvrtc")||o.getExtension("WEBKIT_WEBGL_compressed_texture_pvrtc");break;default:i=o.getExtension(n)}return e[n]=i,i}return{has:function(n){return t(n)!==null},init:function(n){n.isWebGL2?t("EXT_color_buffer_float"):(t("WEBGL_depth_texture"),t("OES_texture_float"),t("OES_texture_half_float"),t("OES_texture_half_float_linear"),t("OES_standard_derivatives"),t("OES_element_index_uint"),t("OES_vertex_array_object"),t("ANGLE_instanced_arrays")),t("OES_texture_float_linear"),t("EXT_color_buffer_half_float"),t("WEBGL_multisampled_render_to_texture")},get:function(n){const i=t(n);return i===null&&console.warn("THREE.WebGLRenderer: "+n+" extension not supported."),i}}}function _w(o,e,t,n){const i={},a=new WeakMap;function r(h){const p=h.target;p.index!==null&&e.remove(p.index);for(const y in p.attributes)e.remove(p.attributes[y]);p.removeEventListener("dispose",r),delete i[p.id];const g=a.get(p);g&&(e.remove(g),a.delete(p)),n.releaseStatesOfGeometry(p),p.isInstancedBufferGeometry===!0&&delete p._maxInstanceCount,t.memory.geometries--}function s(h,p){return i[p.id]===!0||(p.addEventListener("dispose",r),i[p.id]=!0,t.memory.geometries++),p}function u(h){const p=h.attributes;for(const y in p)e.update(p[y],34962);const g=h.morphAttributes;for(const y in g){const m=g[y];for(let v=0,b=m.length;v<b;v++)e.update(m[v],34962)}}function c(h){const p=[],g=h.index,y=h.attributes.position;let m=0;if(g!==null){const x=g.array;m=g.version;for(let w=0,M=x.length;w<M;w+=3){const A=x[w+0],S=x[w+1],D=x[w+2];p.push(A,S,S,D,D,A)}}else{const x=y.array;m=y.version;for(let w=0,M=x.length/3-1;w<M;w+=3){const A=w+0,S=w+1,D=w+2;p.push(A,S,S,D,D,A)}}const v=new(os(p)?ds:cs)(p,1);v.version=m;const b=a.get(h);b&&e.remove(b),a.set(h,v)}function d(h){const p=a.get(h);if(p){const g=h.index;g!==null&&p.version<g.version&&c(h)}else c(h);return a.get(h)}return{get:s,update:u,getWireframeAttribute:d}}function vw(o,e,t,n){const i=n.isWebGL2;let a;function r(p){a=p}let s,u;function c(p){s=p.type,u=p.bytesPerElement}function d(p,g){o.drawElements(a,g,s,p*u),t.update(g,a,1)}function h(p,g,y){if(y===0)return;let m,v;if(i)m=o,v="drawElementsInstanced";else if(m=e.get("ANGLE_instanced_arrays"),v="drawElementsInstancedANGLE",m===null){console.error("THREE.WebGLIndexedBufferRenderer: using THREE.InstancedBufferGeometry but hardware does not support extension ANGLE_instanced_arrays.");return}m[v](a,g,s,p*u,y),t.update(g,a,y)}this.setMode=r,this.setIndex=c,this.render=d,this.renderInstances=h}function yw(o){const e={geometries:0,textures:0},t={frame:0,calls:0,triangles:0,points:0,lines:0};function n(a,r,s){switch(t.calls++,r){case 4:t.triangles+=s*(a/3);break;case 1:t.lines+=s*(a/2);break;case 3:t.lines+=s*(a-1);break;case 2:t.lines+=s*a;break;case 0:t.points+=s*a;break;default:console.error("THREE.WebGLInfo: Unknown draw mode:",r);break}}function i(){t.frame++,t.calls=0,t.triangles=0,t.points=0,t.lines=0}return{memory:e,render:t,programs:null,autoReset:!0,reset:i,update:n}}function bw(o,e){return o[0]-e[0]}function xw(o,e){return Math.abs(e[1])-Math.abs(o[1])}function Sw(o,e,t){const n={},i=new Float32Array(8),a=new WeakMap,r=new l3,s=[];for(let c=0;c<8;c++)s[c]=[c,0];function u(c,d,h,p){const g=c.morphTargetInfluences;if(e.isWebGL2===!0){const y=d.morphAttributes.position||d.morphAttributes.normal||d.morphAttributes.color,m=y!==void 0?y.length:0;let v=a.get(d);if(v===void 0||v.count!==m){let U=function(){F.dispose(),a.delete(d),d.removeEventListener("dispose",U)};v!==void 0&&v.texture.dispose();const w=d.morphAttributes.position!==void 0,M=d.morphAttributes.normal!==void 0,A=d.morphAttributes.color!==void 0,S=d.morphAttributes.position||[],D=d.morphAttributes.normal||[],C=d.morphAttributes.color||[];let E=0;w===!0&&(E=1),M===!0&&(E=2),A===!0&&(E=3);let k=d.attributes.position.count*E,$=1;k>e.maxTextureSize&&($=Math.ceil(k/e.maxTextureSize),k=e.maxTextureSize);const X=new Float32Array(k*$*4*m),F=new ls(X,k,$,m);F.type=E0,F.needsUpdate=!0;const R=E*4;for(let H=0;H<m;H++){const V=S[H],N=D[H],z=C[H],G=k*$*4*H;for(let t1=0;t1<V.count;t1++){const e1=t1*R;w===!0&&(r.fromBufferAttribute(V,t1),X[G+e1+0]=r.x,X[G+e1+1]=r.y,X[G+e1+2]=r.z,X[G+e1+3]=0),M===!0&&(r.fromBufferAttribute(N,t1),X[G+e1+4]=r.x,X[G+e1+5]=r.y,X[G+e1+6]=r.z,X[G+e1+7]=0),A===!0&&(r.fromBufferAttribute(z,t1),X[G+e1+8]=r.x,X[G+e1+9]=r.y,X[G+e1+10]=r.z,X[G+e1+11]=z.itemSize===4?r.w:1)}}v={count:m,texture:F,size:new G1(k,$)},a.set(d,v),d.addEventListener("dispose",U)}let b=0;for(let w=0;w<g.length;w++)b+=g[w];const x=d.morphTargetsRelative?1:1-b;p.getUniforms().setValue(o,"morphTargetBaseInfluence",x),p.getUniforms().setValue(o,"morphTargetInfluences",g),p.getUniforms().setValue(o,"morphTargetsTexture",v.texture,t),p.getUniforms().setValue(o,"morphTargetsTextureSize",v.size)}else{const y=g===void 0?0:g.length;let m=n[d.id];if(m===void 0||m.length!==y){m=[];for(let M=0;M<y;M++)m[M]=[M,0];n[d.id]=m}for(let M=0;M<y;M++){const A=m[M];A[0]=M,A[1]=g[M]}m.sort(xw);for(let M=0;M<8;M++)M<y&&m[M][1]?(s[M][0]=m[M][0],s[M][1]=m[M][1]):(s[M][0]=Number.MAX_SAFE_INTEGER,s[M][1]=0);s.sort(bw);const v=d.morphAttributes.position,b=d.morphAttributes.normal;let x=0;for(let M=0;M<8;M++){const A=s[M],S=A[0],D=A[1];S!==Number.MAX_SAFE_INTEGER&&D?(v&&d.getAttribute("morphTarget"+M)!==v[S]&&d.setAttribute("morphTarget"+M,v[S]),b&&d.getAttribute("morphNormal"+M)!==b[S]&&d.setAttribute("morphNormal"+M,b[S]),i[M]=D,x+=D):(v&&d.hasAttribute("morphTarget"+M)===!0&&d.deleteAttribute("morphTarget"+M),b&&d.hasAttribute("morphNormal"+M)===!0&&d.deleteAttribute("morphNormal"+M),i[M]=0)}const w=d.morphTargetsRelative?1:1-x;p.getUniforms().setValue(o,"morphTargetBaseInfluence",w),p.getUniforms().setValue(o,"morphTargetInfluences",i)}}return{update:u}}function Mw(o,e,t,n){let i=new WeakMap;function a(u){const c=n.render.frame,d=u.geometry,h=e.get(u,d);return i.get(h)!==c&&(e.update(h),i.set(h,c)),u.isInstancedMesh&&(u.hasEventListener("dispose",s)===!1&&u.addEventListener("dispose",s),t.update(u.instanceMatrix,34962),u.instanceColor!==null&&t.update(u.instanceColor,34962)),h}function r(){i=new WeakMap}function s(u){const c=u.target;c.removeEventListener("dispose",s),t.remove(c.instanceMatrix),c.instanceColor!==null&&t.remove(c.instanceColor)}return{update:a,dispose:r}}const gs=new Q3,_s=new ls,vs=new cS,ys=new hs,Go=[],Vo=[],jo=new Float32Array(16),Wo=new Float32Array(9),Ho=new Float32Array(4);function Z9(o,e,t){const n=o[0];if(n<=0||n>0)return o;const i=e*t;let a=Go[i];if(a===void 0&&(a=new Float32Array(i),Go[i]=a),e!==0){n.toArray(a,0);for(let r=1,s=0;r!==e;++r)s+=t,o[r].toArray(a,s)}return a}function q2(o,e){if(o.length!==e.length)return!1;for(let t=0,n=o.length;t<n;t++)if(o[t]!==e[t])return!1;return!0}function K2(o,e){for(let t=0,n=e.length;t<n;t++)o[t]=e[t]}function o6(o,e){let t=Vo[e];t===void 0&&(t=new Int32Array(e),Vo[e]=t);for(let n=0;n!==e;++n)t[n]=o.allocateTextureUnit();return t}function Aw(o,e){const t=this.cache;t[0]!==e&&(o.uniform1f(this.addr,e),t[0]=e)}function ww(o,e){const t=this.cache;if(e.x!==void 0)(t[0]!==e.x||t[1]!==e.y)&&(o.uniform2f(this.addr,e.x,e.y),t[0]=e.x,t[1]=e.y);else{if(q2(t,e))return;o.uniform2fv(this.addr,e),K2(t,e)}}function Cw(o,e){const t=this.cache;if(e.x!==void 0)(t[0]!==e.x||t[1]!==e.y||t[2]!==e.z)&&(o.uniform3f(this.addr,e.x,e.y,e.z),t[0]=e.x,t[1]=e.y,t[2]=e.z);else if(e.r!==void 0)(t[0]!==e.r||t[1]!==e.g||t[2]!==e.b)&&(o.uniform3f(this.addr,e.r,e.g,e.b),t[0]=e.r,t[1]=e.g,t[2]=e.b);else{if(q2(t,e))return;o.uniform3fv(this.addr,e),K2(t,e)}}function Tw(o,e){const t=this.cache;if(e.x!==void 0)(t[0]!==e.x||t[1]!==e.y||t[2]!==e.z||t[3]!==e.w)&&(o.uniform4f(this.addr,e.x,e.y,e.z,e.w),t[0]=e.x,t[1]=e.y,t[2]=e.z,t[3]=e.w);else{if(q2(t,e))return;o.uniform4fv(this.addr,e),K2(t,e)}}function Ew(o,e){const t=this.cache,n=e.elements;if(n===void 0){if(q2(t,e))return;o.uniformMatrix2fv(this.addr,!1,e),K2(t,e)}else{if(q2(t,n))return;Ho.set(n),o.uniformMatrix2fv(this.addr,!1,Ho),K2(t,n)}}function Dw(o,e){const t=this.cache,n=e.elements;if(n===void 0){if(q2(t,e))return;o.uniformMatrix3fv(this.addr,!1,e),K2(t,e)}else{if(q2(t,n))return;Wo.set(n),o.uniformMatrix3fv(this.addr,!1,Wo),K2(t,n)}}function Iw(o,e){const t=this.cache,n=e.elements;if(n===void 0){if(q2(t,e))return;o.uniformMatrix4fv(this.addr,!1,e),K2(t,e)}else{if(q2(t,n))return;jo.set(n),o.uniformMatrix4fv(this.addr,!1,jo),K2(t,n)}}function Rw(o,e){const t=this.cache;t[0]!==e&&(o.uniform1i(this.addr,e),t[0]=e)}function Ow(o,e){const t=this.cache;q2(t,e)||(o.uniform2iv(this.addr,e),K2(t,e))}function Pw(o,e){const t=this.cache;q2(t,e)||(o.uniform3iv(this.addr,e),K2(t,e))}function Lw(o,e){const t=this.cache;q2(t,e)||(o.uniform4iv(this.addr,e),K2(t,e))}function zw(o,e){const t=this.cache;t[0]!==e&&(o.uniform1ui(this.addr,e),t[0]=e)}function kw(o,e){const t=this.cache;q2(t,e)||(o.uniform2uiv(this.addr,e),K2(t,e))}function Nw(o,e){const t=this.cache;q2(t,e)||(o.uniform3uiv(this.addr,e),K2(t,e))}function Uw(o,e){const t=this.cache;q2(t,e)||(o.uniform4uiv(this.addr,e),K2(t,e))}function Fw(o,e,t){const n=this.cache,i=t.allocateTextureUnit();n[0]!==i&&(o.uniform1i(this.addr,i),n[0]=i),t.setTexture2D(e||gs,i)}function Bw(o,e,t){const n=this.cache,i=t.allocateTextureUnit();n[0]!==i&&(o.uniform1i(this.addr,i),n[0]=i),t.setTexture3D(e||vs,i)}function Gw(o,e,t){const n=this.cache,i=t.allocateTextureUnit();n[0]!==i&&(o.uniform1i(this.addr,i),n[0]=i),t.setTextureCube(e||ys,i)}function Vw(o,e,t){const n=this.cache,i=t.allocateTextureUnit();n[0]!==i&&(o.uniform1i(this.addr,i),n[0]=i),t.setTexture2DArray(e||_s,i)}function jw(o){switch(o){case 5126:return Aw;case 35664:return ww;case 35665:return Cw;case 35666:return Tw;case 35674:return Ew;case 35675:return Dw;case 35676:return Iw;case 5124:case 35670:return Rw;case 35667:case 35671:return Ow;case 35668:case 35672:return Pw;case 35669:case 35673:return Lw;case 5125:return zw;case 36294:return kw;case 36295:return Nw;case 36296:return Uw;case 35678:case 36198:case 36298:case 36306:case 35682:return Fw;case 35679:case 36299:case 36307:return Bw;case 35680:case 36300:case 36308:case 36293:return Gw;case 36289:case 36303:case 36311:case 36292:return Vw}}function Ww(o,e){o.uniform1fv(this.addr,e)}function Hw(o,e){const t=Z9(e,this.size,2);o.uniform2fv(this.addr,t)}function Yw(o,e){const t=Z9(e,this.size,3);o.uniform3fv(this.addr,t)}function $w(o,e){const t=Z9(e,this.size,4);o.uniform4fv(this.addr,t)}function Jw(o,e){const t=Z9(e,this.size,4);o.uniformMatrix2fv(this.addr,!1,t)}function Zw(o,e){const t=Z9(e,this.size,9);o.uniformMatrix3fv(this.addr,!1,t)}function Xw(o,e){const t=Z9(e,this.size,16);o.uniformMatrix4fv(this.addr,!1,t)}function Qw(o,e){o.uniform1iv(this.addr,e)}function qw(o,e){o.uniform2iv(this.addr,e)}function Kw(o,e){o.uniform3iv(this.addr,e)}function eC(o,e){o.uniform4iv(this.addr,e)}function tC(o,e){o.uniform1uiv(this.addr,e)}function nC(o,e){o.uniform2uiv(this.addr,e)}function iC(o,e){o.uniform3uiv(this.addr,e)}function oC(o,e){o.uniform4uiv(this.addr,e)}function aC(o,e,t){const n=this.cache,i=e.length,a=o6(t,i);q2(n,a)||(o.uniform1iv(this.addr,a),K2(n,a));for(let r=0;r!==i;++r)t.setTexture2D(e[r]||gs,a[r])}function rC(o,e,t){const n=this.cache,i=e.length,a=o6(t,i);q2(n,a)||(o.uniform1iv(this.addr,a),K2(n,a));for(let r=0;r!==i;++r)t.setTexture3D(e[r]||vs,a[r])}function sC(o,e,t){const n=this.cache,i=e.length,a=o6(t,i);q2(n,a)||(o.uniform1iv(this.addr,a),K2(n,a));for(let r=0;r!==i;++r)t.setTextureCube(e[r]||ys,a[r])}function lC(o,e,t){const n=this.cache,i=e.length,a=o6(t,i);q2(n,a)||(o.uniform1iv(this.addr,a),K2(n,a));for(let r=0;r!==i;++r)t.setTexture2DArray(e[r]||_s,a[r])}function uC(o){switch(o){case 5126:return Ww;case 35664:return Hw;case 35665:return Yw;case 35666:return $w;case 35674:return Jw;case 35675:return Zw;case 35676:return Xw;case 5124:case 35670:return Qw;case 35667:case 35671:return qw;case 35668:case 35672:return Kw;case 35669:case 35673:return eC;case 5125:return tC;case 36294:return nC;case 36295:return iC;case 36296:return oC;case 35678:case 36198:case 36298:case 36306:case 35682:return aC;case 35679:case 36299:case 36307:return rC;case 35680:case 36300:case 36308:case 36293:return sC;case 36289:case 36303:case 36311:case 36292:return lC}}class cC{constructor(e,t,n){this.id=e,this.addr=n,this.cache=[],this.setValue=jw(t.type)}}class dC{constructor(e,t,n){this.id=e,this.addr=n,this.cache=[],this.size=t.size,this.setValue=uC(t.type)}}class fC{constructor(e){this.id=e,this.seq=[],this.map={}}setValue(e,t,n){const i=this.seq;for(let a=0,r=i.length;a!==r;++a){const s=i[a];s.setValue(e,t[s.id],n)}}}const Q6=/(\w+)(\])?(\[|\.)?/g;function Yo(o,e){o.seq.push(e),o.map[e.id]=e}function hC(o,e,t){const n=o.name,i=n.length;for(Q6.lastIndex=0;;){const a=Q6.exec(n),r=Q6.lastIndex;let s=a[1];const u=a[2]==="]",c=a[3];if(u&&(s=s|0),c===void 0||c==="["&&r+2===i){Yo(t,c===void 0?new cC(s,o,e):new dC(s,o,e));break}else{let h=t.map[s];h===void 0&&(h=new fC(s),Yo(t,h)),t=h}}}class D8{constructor(e,t){this.seq=[],this.map={};const n=e.getProgramParameter(t,35718);for(let i=0;i<n;++i){const a=e.getActiveUniform(t,i),r=e.getUniformLocation(t,a.name);hC(a,r,this)}}setValue(e,t,n,i){const a=this.map[t];a!==void 0&&a.setValue(e,n,i)}setOptional(e,t,n){const i=t[n];i!==void 0&&this.setValue(e,n,i)}static upload(e,t,n,i){for(let a=0,r=t.length;a!==r;++a){const s=t[a],u=n[s.id];u.needsUpdate!==!1&&s.setValue(e,u.value,i)}}static seqWithValue(e,t){const n=[];for(let i=0,a=e.length;i!==a;++i){const r=e[i];r.id in t&&n.push(r)}return n}}function $o(o,e,t){const n=o.createShader(e);return o.shaderSource(n,t),o.compileShader(n),n}let pC=0;function mC(o,e){const t=o.split(`
`),n=[],i=Math.max(e-6,0),a=Math.min(e+6,t.length);for(let r=i;r<a;r++){const s=r+1;n.push(`${s===e?">":" "} ${s}: ${t[r]}`)}return n.join(`
`)}function gC(o){switch(o){case B0:return["Linear","( value )"];case k2:return["sRGB","( value )"];default:return console.warn("THREE.WebGLProgram: Unsupported encoding:",o),["Linear","( value )"]}}function Jo(o,e,t){const n=o.getShaderParameter(e,35713),i=o.getShaderInfoLog(e).trim();if(n&&i==="")return"";const a=/ERROR: 0:(\d+)/.exec(i);if(a){const r=parseInt(a[1]);return t.toUpperCase()+`

`+i+`

`+mC(o.getShaderSource(e),r)}else return i}function _C(o,e){const t=gC(e);return"vec4 "+o+"( vec4 value ) { return LinearTo"+t[0]+t[1]+"; }"}function vC(o,e){let t;switch(e){case kx:t="Linear";break;case Nx:t="Reinhard";break;case Ux:t="OptimizedCineon";break;case Fx:t="ACESFilmic";break;case Bx:t="Custom";break;default:console.warn("THREE.WebGLProgram: Unsupported toneMapping:",e),t="Linear"}return"vec3 "+o+"( vec3 color ) { return "+t+"ToneMapping( color ); }"}function yC(o){return[o.extensionDerivatives||o.envMapCubeUVHeight||o.bumpMap||o.tangentSpaceNormalMap||o.clearcoatNormalMap||o.flatShading||o.shaderID==="physical"?"#extension GL_OES_standard_derivatives : enable":"",(o.extensionFragDepth||o.logarithmicDepthBuffer)&&o.rendererExtensionFragDepth?"#extension GL_EXT_frag_depth : enable":"",o.extensionDrawBuffers&&o.rendererExtensionDrawBuffers?"#extension GL_EXT_draw_buffers : require":"",(o.extensionShaderTextureLOD||o.envMap||o.transmission)&&o.rendererExtensionShaderTextureLod?"#extension GL_EXT_shader_texture_lod : enable":""].filter(d5).join(`
`)}function bC(o){const e=[];for(const t in o){const n=o[t];n!==!1&&e.push("#define "+t+" "+n)}return e.join(`
`)}function xC(o,e){const t={},n=o.getProgramParameter(e,35721);for(let i=0;i<n;i++){const a=o.getActiveAttrib(e,i),r=a.name;let s=1;a.type===35674&&(s=2),a.type===35675&&(s=3),a.type===35676&&(s=4),t[r]={type:a.type,location:o.getAttribLocation(e,r),locationSize:s}}return t}function d5(o){return o!==""}function Zo(o,e){const t=e.numSpotLightShadows+e.numSpotLightMaps-e.numSpotLightShadowsWithMaps;return o.replace(/NUM_DIR_LIGHTS/g,e.numDirLights).replace(/NUM_SPOT_LIGHTS/g,e.numSpotLights).replace(/NUM_SPOT_LIGHT_MAPS/g,e.numSpotLightMaps).replace(/NUM_SPOT_LIGHT_COORDS/g,t).replace(/NUM_RECT_AREA_LIGHTS/g,e.numRectAreaLights).replace(/NUM_POINT_LIGHTS/g,e.numPointLights).replace(/NUM_HEMI_LIGHTS/g,e.numHemiLights).replace(/NUM_DIR_LIGHT_SHADOWS/g,e.numDirLightShadows).replace(/NUM_SPOT_LIGHT_SHADOWS_WITH_MAPS/g,e.numSpotLightShadowsWithMaps).replace(/NUM_SPOT_LIGHT_SHADOWS/g,e.numSpotLightShadows).replace(/NUM_POINT_LIGHT_SHADOWS/g,e.numPointLightShadows)}function Xo(o,e){return o.replace(/NUM_CLIPPING_PLANES/g,e.numClippingPlanes).replace(/UNION_CLIPPING_PLANES/g,e.numClippingPlanes-e.numClipIntersection)}const SC=/^[ \t]*#include +<([\w\d./]+)>/gm;function Me(o){return o.replace(SC,MC)}function MC(o,e){const t=u2[e];if(t===void 0)throw new Error("Can not resolve #include <"+e+">");return Me(t)}const AC=/#pragma unroll_loop_start\s+for\s*\(\s*int\s+i\s*=\s*(\d+)\s*;\s*i\s*<\s*(\d+)\s*;\s*i\s*\+\+\s*\)\s*{([\s\S]+?)}\s+#pragma unroll_loop_end/g;function Qo(o){return o.replace(AC,wC)}function wC(o,e,t,n){let i="";for(let a=parseInt(e);a<parseInt(t);a++)i+=n.replace(/\[\s*i\s*\]/g,"[ "+a+" ]").replace(/UNROLLED_LOOP_INDEX/g,a);return i}function qo(o){let e="precision "+o.precision+` float;
precision `+o.precision+" int;";return o.precision==="highp"?e+=`
#define HIGH_PRECISION`:o.precision==="mediump"?e+=`
#define MEDIUM_PRECISION`:o.precision==="lowp"&&(e+=`
#define LOW_PRECISION`),e}function CC(o){let e="SHADOWMAP_TYPE_BASIC";return o.shadowMapType===qr?e="SHADOWMAP_TYPE_PCF":o.shadowMapType===px?e="SHADOWMAP_TYPE_PCF_SOFT":o.shadowMapType===c5&&(e="SHADOWMAP_TYPE_VSM"),e}function TC(o){let e="ENVMAP_TYPE_CUBE";if(o.envMap)switch(o.envMapMode){case k9:case N9:e="ENVMAP_TYPE_CUBE";break;case n6:e="ENVMAP_TYPE_CUBE_UV";break}return e}function EC(o){let e="ENVMAP_MODE_REFLECTION";if(o.envMap)switch(o.envMapMode){case N9:e="ENVMAP_MODE_REFRACTION";break}return e}function DC(o){let e="ENVMAP_BLENDING_NONE";if(o.envMap)switch(o.combine){case ts:e="ENVMAP_BLENDING_MULTIPLY";break;case Lx:e="ENVMAP_BLENDING_MIX";break;case zx:e="ENVMAP_BLENDING_ADD";break}return e}function IC(o){const e=o.envMapCubeUVHeight;if(e===null)return null;const t=Math.log2(e)-2,n=1/e;return{texelWidth:1/(3*Math.max(Math.pow(2,t),7*16)),texelHeight:n,maxMip:t}}function RC(o,e,t,n){const i=o.getContext(),a=t.defines;let r=t.vertexShader,s=t.fragmentShader;const u=CC(t),c=TC(t),d=EC(t),h=DC(t),p=IC(t),g=t.isWebGL2?"":yC(t),y=bC(a),m=i.createProgram();let v,b,x=t.glslVersion?"#version "+t.glslVersion+`
`:"";t.isRawShaderMaterial?(v=[y].filter(d5).join(`
`),v.length>0&&(v+=`
`),b=[g,y].filter(d5).join(`
`),b.length>0&&(b+=`
`)):(v=[qo(t),"#define SHADER_NAME "+t.shaderName,y,t.instancing?"#define USE_INSTANCING":"",t.instancingColor?"#define USE_INSTANCING_COLOR":"",t.supportsVertexTextures?"#define VERTEX_TEXTURES":"",t.useFog&&t.fog?"#define USE_FOG":"",t.useFog&&t.fogExp2?"#define FOG_EXP2":"",t.map?"#define USE_MAP":"",t.envMap?"#define USE_ENVMAP":"",t.envMap?"#define "+d:"",t.lightMap?"#define USE_LIGHTMAP":"",t.aoMap?"#define USE_AOMAP":"",t.emissiveMap?"#define USE_EMISSIVEMAP":"",t.bumpMap?"#define USE_BUMPMAP":"",t.normalMap?"#define USE_NORMALMAP":"",t.normalMap&&t.objectSpaceNormalMap?"#define OBJECTSPACE_NORMALMAP":"",t.normalMap&&t.tangentSpaceNormalMap?"#define TANGENTSPACE_NORMALMAP":"",t.clearcoatMap?"#define USE_CLEARCOATMAP":"",t.clearcoatRoughnessMap?"#define USE_CLEARCOAT_ROUGHNESSMAP":"",t.clearcoatNormalMap?"#define USE_CLEARCOAT_NORMALMAP":"",t.iridescenceMap?"#define USE_IRIDESCENCEMAP":"",t.iridescenceThicknessMap?"#define USE_IRIDESCENCE_THICKNESSMAP":"",t.displacementMap&&t.supportsVertexTextures?"#define USE_DISPLACEMENTMAP":"",t.specularMap?"#define USE_SPECULARMAP":"",t.specularIntensityMap?"#define USE_SPECULARINTENSITYMAP":"",t.specularColorMap?"#define USE_SPECULARCOLORMAP":"",t.roughnessMap?"#define USE_ROUGHNESSMAP":"",t.metalnessMap?"#define USE_METALNESSMAP":"",t.alphaMap?"#define USE_ALPHAMAP":"",t.transmission?"#define USE_TRANSMISSION":"",t.transmissionMap?"#define USE_TRANSMISSIONMAP":"",t.thicknessMap?"#define USE_THICKNESSMAP":"",t.sheenColorMap?"#define USE_SHEENCOLORMAP":"",t.sheenRoughnessMap?"#define USE_SHEENROUGHNESSMAP":"",t.vertexTangents?"#define USE_TANGENT":"",t.vertexColors?"#define USE_COLOR":"",t.vertexAlphas?"#define USE_COLOR_ALPHA":"",t.vertexUvs?"#define USE_UV":"",t.uvsVertexOnly?"#define UVS_VERTEX_ONLY":"",t.flatShading?"#define FLAT_SHADED":"",t.skinning?"#define USE_SKINNING":"",t.morphTargets?"#define USE_MORPHTARGETS":"",t.morphNormals&&t.flatShading===!1?"#define USE_MORPHNORMALS":"",t.morphColors&&t.isWebGL2?"#define USE_MORPHCOLORS":"",t.morphTargetsCount>0&&t.isWebGL2?"#define MORPHTARGETS_TEXTURE":"",t.morphTargetsCount>0&&t.isWebGL2?"#define MORPHTARGETS_TEXTURE_STRIDE "+t.morphTextureStride:"",t.morphTargetsCount>0&&t.isWebGL2?"#define MORPHTARGETS_COUNT "+t.morphTargetsCount:"",t.doubleSided?"#define DOUBLE_SIDED":"",t.flipSided?"#define FLIP_SIDED":"",t.shadowMapEnabled?"#define USE_SHADOWMAP":"",t.shadowMapEnabled?"#define "+u:"",t.sizeAttenuation?"#define USE_SIZEATTENUATION":"",t.logarithmicDepthBuffer?"#define USE_LOGDEPTHBUF":"",t.logarithmicDepthBuffer&&t.rendererExtensionFragDepth?"#define USE_LOGDEPTHBUF_EXT":"","uniform mat4 modelMatrix;","uniform mat4 modelViewMatrix;","uniform mat4 projectionMatrix;","uniform mat4 viewMatrix;","uniform mat3 normalMatrix;","uniform vec3 cameraPosition;","uniform bool isOrthographic;","#ifdef USE_INSTANCING","	attribute mat4 instanceMatrix;","#endif","#ifdef USE_INSTANCING_COLOR","	attribute vec3 instanceColor;","#endif","attribute vec3 position;","attribute vec3 normal;","attribute vec2 uv;","#ifdef USE_TANGENT","	attribute vec4 tangent;","#endif","#if defined( USE_COLOR_ALPHA )","	attribute vec4 color;","#elif defined( USE_COLOR )","	attribute vec3 color;","#endif","#if ( defined( USE_MORPHTARGETS ) && ! defined( MORPHTARGETS_TEXTURE ) )","	attribute vec3 morphTarget0;","	attribute vec3 morphTarget1;","	attribute vec3 morphTarget2;","	attribute vec3 morphTarget3;","	#ifdef USE_MORPHNORMALS","		attribute vec3 morphNormal0;","		attribute vec3 morphNormal1;","		attribute vec3 morphNormal2;","		attribute vec3 morphNormal3;","	#else","		attribute vec3 morphTarget4;","		attribute vec3 morphTarget5;","		attribute vec3 morphTarget6;","		attribute vec3 morphTarget7;","	#endif","#endif","#ifdef USE_SKINNING","	attribute vec4 skinIndex;","	attribute vec4 skinWeight;","#endif",`
`].filter(d5).join(`
`),b=[g,qo(t),"#define SHADER_NAME "+t.shaderName,y,t.useFog&&t.fog?"#define USE_FOG":"",t.useFog&&t.fogExp2?"#define FOG_EXP2":"",t.map?"#define USE_MAP":"",t.matcap?"#define USE_MATCAP":"",t.envMap?"#define USE_ENVMAP":"",t.envMap?"#define "+c:"",t.envMap?"#define "+d:"",t.envMap?"#define "+h:"",p?"#define CUBEUV_TEXEL_WIDTH "+p.texelWidth:"",p?"#define CUBEUV_TEXEL_HEIGHT "+p.texelHeight:"",p?"#define CUBEUV_MAX_MIP "+p.maxMip+".0":"",t.lightMap?"#define USE_LIGHTMAP":"",t.aoMap?"#define USE_AOMAP":"",t.emissiveMap?"#define USE_EMISSIVEMAP":"",t.bumpMap?"#define USE_BUMPMAP":"",t.normalMap?"#define USE_NORMALMAP":"",t.normalMap&&t.objectSpaceNormalMap?"#define OBJECTSPACE_NORMALMAP":"",t.normalMap&&t.tangentSpaceNormalMap?"#define TANGENTSPACE_NORMALMAP":"",t.clearcoat?"#define USE_CLEARCOAT":"",t.clearcoatMap?"#define USE_CLEARCOATMAP":"",t.clearcoatRoughnessMap?"#define USE_CLEARCOAT_ROUGHNESSMAP":"",t.clearcoatNormalMap?"#define USE_CLEARCOAT_NORMALMAP":"",t.iridescence?"#define USE_IRIDESCENCE":"",t.iridescenceMap?"#define USE_IRIDESCENCEMAP":"",t.iridescenceThicknessMap?"#define USE_IRIDESCENCE_THICKNESSMAP":"",t.specularMap?"#define USE_SPECULARMAP":"",t.specularIntensityMap?"#define USE_SPECULARINTENSITYMAP":"",t.specularColorMap?"#define USE_SPECULARCOLORMAP":"",t.roughnessMap?"#define USE_ROUGHNESSMAP":"",t.metalnessMap?"#define USE_METALNESSMAP":"",t.alphaMap?"#define USE_ALPHAMAP":"",t.alphaTest?"#define USE_ALPHATEST":"",t.sheen?"#define USE_SHEEN":"",t.sheenColorMap?"#define USE_SHEENCOLORMAP":"",t.sheenRoughnessMap?"#define USE_SHEENROUGHNESSMAP":"",t.transmission?"#define USE_TRANSMISSION":"",t.transmissionMap?"#define USE_TRANSMISSIONMAP":"",t.thicknessMap?"#define USE_THICKNESSMAP":"",t.decodeVideoTexture?"#define DECODE_VIDEO_TEXTURE":"",t.vertexTangents?"#define USE_TANGENT":"",t.vertexColors||t.instancingColor?"#define USE_COLOR":"",t.vertexAlphas?"#define USE_COLOR_ALPHA":"",t.vertexUvs?"#define USE_UV":"",t.uvsVertexOnly?"#define UVS_VERTEX_ONLY":"",t.gradientMap?"#define USE_GRADIENTMAP":"",t.flatShading?"#define FLAT_SHADED":"",t.doubleSided?"#define DOUBLE_SIDED":"",t.flipSided?"#define FLIP_SIDED":"",t.shadowMapEnabled?"#define USE_SHADOWMAP":"",t.shadowMapEnabled?"#define "+u:"",t.premultipliedAlpha?"#define PREMULTIPLIED_ALPHA":"",t.physicallyCorrectLights?"#define PHYSICALLY_CORRECT_LIGHTS":"",t.logarithmicDepthBuffer?"#define USE_LOGDEPTHBUF":"",t.logarithmicDepthBuffer&&t.rendererExtensionFragDepth?"#define USE_LOGDEPTHBUF_EXT":"","uniform mat4 viewMatrix;","uniform vec3 cameraPosition;","uniform bool isOrthographic;",t.toneMapping!==z4?"#define TONE_MAPPING":"",t.toneMapping!==z4?u2.tonemapping_pars_fragment:"",t.toneMapping!==z4?vC("toneMapping",t.toneMapping):"",t.dithering?"#define DITHERING":"",t.opaque?"#define OPAQUE":"",u2.encodings_pars_fragment,_C("linearToOutputTexel",t.outputEncoding),t.useDepthPacking?"#define DEPTH_PACKING "+t.depthPacking:"",`
`].filter(d5).join(`
`)),r=Me(r),r=Zo(r,t),r=Xo(r,t),s=Me(s),s=Zo(s,t),s=Xo(s,t),r=Qo(r),s=Qo(s),t.isWebGL2&&t.isRawShaderMaterial!==!0&&(x=`#version 300 es
`,v=["precision mediump sampler2DArray;","#define attribute in","#define varying out","#define texture2D texture"].join(`
`)+`
`+v,b=["#define varying in",t.glslVersion===bo?"":"layout(location = 0) out highp vec4 pc_fragColor;",t.glslVersion===bo?"":"#define gl_FragColor pc_fragColor","#define gl_FragDepthEXT gl_FragDepth","#define texture2D texture","#define textureCube texture","#define texture2DProj textureProj","#define texture2DLodEXT textureLod","#define texture2DProjLodEXT textureProjLod","#define textureCubeLodEXT textureLod","#define texture2DGradEXT textureGrad","#define texture2DProjGradEXT textureProjGrad","#define textureCubeGradEXT textureGrad"].join(`
`)+`
`+b);const w=x+v+r,M=x+b+s,A=$o(i,35633,w),S=$o(i,35632,M);if(i.attachShader(m,A),i.attachShader(m,S),t.index0AttributeName!==void 0?i.bindAttribLocation(m,0,t.index0AttributeName):t.morphTargets===!0&&i.bindAttribLocation(m,0,"position"),i.linkProgram(m),o.debug.checkShaderErrors){const E=i.getProgramInfoLog(m).trim(),k=i.getShaderInfoLog(A).trim(),$=i.getShaderInfoLog(S).trim();let X=!0,F=!0;if(i.getProgramParameter(m,35714)===!1){X=!1;const R=Jo(i,A,"vertex"),U=Jo(i,S,"fragment");console.error("THREE.WebGLProgram: Shader Error "+i.getError()+" - VALIDATE_STATUS "+i.getProgramParameter(m,35715)+`

Program Info Log: `+E+`
`+R+`
`+U)}else E!==""?console.warn("THREE.WebGLProgram: Program Info Log:",E):(k===""||$==="")&&(F=!1);F&&(this.diagnostics={runnable:X,programLog:E,vertexShader:{log:k,prefix:v},fragmentShader:{log:$,prefix:b}})}i.deleteShader(A),i.deleteShader(S);let D;this.getUniforms=function(){return D===void 0&&(D=new D8(i,m)),D};let C;return this.getAttributes=function(){return C===void 0&&(C=xC(i,m)),C},this.destroy=function(){n.releaseStatesOfProgram(this),i.deleteProgram(m),this.program=void 0},this.name=t.shaderName,this.id=pC++,this.cacheKey=e,this.usedTimes=1,this.program=m,this.vertexShader=A,this.fragmentShader=S,this}let OC=0;class PC{constructor(){this.shaderCache=new Map,this.materialCache=new Map}update(e){const t=e.vertexShader,n=e.fragmentShader,i=this._getShaderStage(t),a=this._getShaderStage(n),r=this._getShaderCacheForMaterial(e);return r.has(i)===!1&&(r.add(i),i.usedTimes++),r.has(a)===!1&&(r.add(a),a.usedTimes++),this}remove(e){const t=this.materialCache.get(e);for(const n of t)n.usedTimes--,n.usedTimes===0&&this.shaderCache.delete(n.code);return this.materialCache.delete(e),this}getVertexShaderID(e){return this._getShaderStage(e.vertexShader).id}getFragmentShaderID(e){return this._getShaderStage(e.fragmentShader).id}dispose(){this.shaderCache.clear(),this.materialCache.clear()}_getShaderCacheForMaterial(e){const t=this.materialCache;let n=t.get(e);return n===void 0&&(n=new Set,t.set(e,n)),n}_getShaderStage(e){const t=this.shaderCache;let n=t.get(e);return n===void 0&&(n=new LC(e),t.set(e,n)),n}}class LC{constructor(e){this.id=OC++,this.code=e,this.usedTimes=0}}function zC(o,e,t,n,i,a,r){const s=new us,u=new PC,c=[],d=i.isWebGL2,h=i.logarithmicDepthBuffer,p=i.vertexTextures;let g=i.precision;const y={MeshDepthMaterial:"depth",MeshDistanceMaterial:"distanceRGBA",MeshNormalMaterial:"normal",MeshBasicMaterial:"basic",MeshLambertMaterial:"lambert",MeshPhongMaterial:"phong",MeshToonMaterial:"toon",MeshStandardMaterial:"physical",MeshPhysicalMaterial:"physical",MeshMatcapMaterial:"matcap",LineBasicMaterial:"basic",LineDashedMaterial:"dashed",PointsMaterial:"points",ShadowMaterial:"shadow",SpriteMaterial:"sprite"};function m(C,E,k,$,X){const F=$.fog,R=X.geometry,U=C.isMeshStandardMaterial?$.environment:null,H=(C.isMeshStandardMaterial?t:e).get(C.envMap||U),V=H&&H.mapping===n6?H.image.height:null,N=y[C.type];C.precision!==null&&(g=i.getMaxPrecision(C.precision),g!==C.precision&&console.warn("THREE.WebGLProgram.getParameters:",C.precision,"not supported, using",g,"instead."));const z=R.morphAttributes.position||R.morphAttributes.normal||R.morphAttributes.color,G=z!==void 0?z.length:0;let t1=0;R.morphAttributes.position!==void 0&&(t1=1),R.morphAttributes.normal!==void 0&&(t1=2),R.morphAttributes.color!==void 0&&(t1=3);let e1,u1,s1,q;if(N){const N1=f4[N];e1=N1.vertexShader,u1=N1.fragmentShader}else e1=C.vertexShader,u1=C.fragmentShader,u.update(C),s1=u.getVertexShaderID(C),q=u.getFragmentShaderID(C);const Z=o.getRenderTarget(),p1=C.alphaTest>0,m1=C.clearcoat>0,f1=C.iridescence>0;return{isWebGL2:d,shaderID:N,shaderName:C.type,vertexShader:e1,fragmentShader:u1,defines:C.defines,customVertexShaderID:s1,customFragmentShaderID:q,isRawShaderMaterial:C.isRawShaderMaterial===!0,glslVersion:C.glslVersion,precision:g,instancing:X.isInstancedMesh===!0,instancingColor:X.isInstancedMesh===!0&&X.instanceColor!==null,supportsVertexTextures:p,outputEncoding:Z===null?o.outputEncoding:Z.isXRRenderTarget===!0?Z.texture.encoding:B0,map:!!C.map,matcap:!!C.matcap,envMap:!!H,envMapMode:H&&H.mapping,envMapCubeUVHeight:V,lightMap:!!C.lightMap,aoMap:!!C.aoMap,emissiveMap:!!C.emissiveMap,bumpMap:!!C.bumpMap,normalMap:!!C.normalMap,objectSpaceNormalMap:C.normalMapType===rS,tangentSpaceNormalMap:C.normalMapType===aS,decodeVideoTexture:!!C.map&&C.map.isVideoTexture===!0&&C.map.encoding===k2,clearcoat:m1,clearcoatMap:m1&&!!C.clearcoatMap,clearcoatRoughnessMap:m1&&!!C.clearcoatRoughnessMap,clearcoatNormalMap:m1&&!!C.clearcoatNormalMap,iridescence:f1,iridescenceMap:f1&&!!C.iridescenceMap,iridescenceThicknessMap:f1&&!!C.iridescenceThicknessMap,displacementMap:!!C.displacementMap,roughnessMap:!!C.roughnessMap,metalnessMap:!!C.metalnessMap,specularMap:!!C.specularMap,specularIntensityMap:!!C.specularIntensityMap,specularColorMap:!!C.specularColorMap,opaque:C.transparent===!1&&C.blending===O0,alphaMap:!!C.alphaMap,alphaTest:p1,gradientMap:!!C.gradientMap,sheen:C.sheen>0,sheenColorMap:!!C.sheenColorMap,sheenRoughnessMap:!!C.sheenRoughnessMap,transmission:C.transmission>0,transmissionMap:!!C.transmissionMap,thicknessMap:!!C.thicknessMap,combine:C.combine,vertexTangents:!!C.normalMap&&!!R.attributes.tangent,vertexColors:C.vertexColors,vertexAlphas:C.vertexColors===!0&&!!R.attributes.color&&R.attributes.color.itemSize===4,vertexUvs:!!C.map||!!C.bumpMap||!!C.normalMap||!!C.specularMap||!!C.alphaMap||!!C.emissiveMap||!!C.roughnessMap||!!C.metalnessMap||!!C.clearcoatMap||!!C.clearcoatRoughnessMap||!!C.clearcoatNormalMap||!!C.iridescenceMap||!!C.iridescenceThicknessMap||!!C.displacementMap||!!C.transmissionMap||!!C.thicknessMap||!!C.specularIntensityMap||!!C.specularColorMap||!!C.sheenColorMap||!!C.sheenRoughnessMap,uvsVertexOnly:!(C.map||C.bumpMap||C.normalMap||C.specularMap||C.alphaMap||C.emissiveMap||C.roughnessMap||C.metalnessMap||C.clearcoatNormalMap||C.iridescenceMap||C.iridescenceThicknessMap||C.transmission>0||C.transmissionMap||C.thicknessMap||C.specularIntensityMap||C.specularColorMap||C.sheen>0||C.sheenColorMap||C.sheenRoughnessMap)&&!!C.displacementMap,fog:!!F,useFog:C.fog===!0,fogExp2:F&&F.isFogExp2,flatShading:!!C.flatShading,sizeAttenuation:C.sizeAttenuation,logarithmicDepthBuffer:h,skinning:X.isSkinnedMesh===!0,morphTargets:R.morphAttributes.position!==void 0,morphNormals:R.morphAttributes.normal!==void 0,morphColors:R.morphAttributes.color!==void 0,morphTargetsCount:G,morphTextureStride:t1,numDirLights:E.directional.length,numPointLights:E.point.length,numSpotLights:E.spot.length,numSpotLightMaps:E.spotLightMap.length,numRectAreaLights:E.rectArea.length,numHemiLights:E.hemi.length,numDirLightShadows:E.directionalShadowMap.length,numPointLightShadows:E.pointShadowMap.length,numSpotLightShadows:E.spotShadowMap.length,numSpotLightShadowsWithMaps:E.numSpotLightShadowsWithMaps,numClippingPlanes:r.numPlanes,numClipIntersection:r.numIntersection,dithering:C.dithering,shadowMapEnabled:o.shadowMap.enabled&&k.length>0,shadowMapType:o.shadowMap.type,toneMapping:C.toneMapped?o.toneMapping:z4,physicallyCorrectLights:o.physicallyCorrectLights,premultipliedAlpha:C.premultipliedAlpha,doubleSided:C.side===m4,flipSided:C.side===X3,useDepthPacking:!!C.depthPacking,depthPacking:C.depthPacking||0,index0AttributeName:C.index0AttributeName,extensionDerivatives:C.extensions&&C.extensions.derivatives,extensionFragDepth:C.extensions&&C.extensions.fragDepth,extensionDrawBuffers:C.extensions&&C.extensions.drawBuffers,extensionShaderTextureLOD:C.extensions&&C.extensions.shaderTextureLOD,rendererExtensionFragDepth:d||n.has("EXT_frag_depth"),rendererExtensionDrawBuffers:d||n.has("WEBGL_draw_buffers"),rendererExtensionShaderTextureLod:d||n.has("EXT_shader_texture_lod"),customProgramCacheKey:C.customProgramCacheKey()}}function v(C){const E=[];if(C.shaderID?E.push(C.shaderID):(E.push(C.customVertexShaderID),E.push(C.customFragmentShaderID)),C.defines!==void 0)for(const k in C.defines)E.push(k),E.push(C.defines[k]);return C.isRawShaderMaterial===!1&&(b(E,C),x(E,C),E.push(o.outputEncoding)),E.push(C.customProgramCacheKey),E.join()}function b(C,E){C.push(E.precision),C.push(E.outputEncoding),C.push(E.envMapMode),C.push(E.envMapCubeUVHeight),C.push(E.combine),C.push(E.vertexUvs),C.push(E.fogExp2),C.push(E.sizeAttenuation),C.push(E.morphTargetsCount),C.push(E.morphAttributeCount),C.push(E.numDirLights),C.push(E.numPointLights),C.push(E.numSpotLights),C.push(E.numSpotLightMaps),C.push(E.numHemiLights),C.push(E.numRectAreaLights),C.push(E.numDirLightShadows),C.push(E.numPointLightShadows),C.push(E.numSpotLightShadows),C.push(E.numSpotLightShadowsWithMaps),C.push(E.shadowMapType),C.push(E.toneMapping),C.push(E.numClippingPlanes),C.push(E.numClipIntersection),C.push(E.depthPacking)}function x(C,E){s.disableAll(),E.isWebGL2&&s.enable(0),E.supportsVertexTextures&&s.enable(1),E.instancing&&s.enable(2),E.instancingColor&&s.enable(3),E.map&&s.enable(4),E.matcap&&s.enable(5),E.envMap&&s.enable(6),E.lightMap&&s.enable(7),E.aoMap&&s.enable(8),E.emissiveMap&&s.enable(9),E.bumpMap&&s.enable(10),E.normalMap&&s.enable(11),E.objectSpaceNormalMap&&s.enable(12),E.tangentSpaceNormalMap&&s.enable(13),E.clearcoat&&s.enable(14),E.clearcoatMap&&s.enable(15),E.clearcoatRoughnessMap&&s.enable(16),E.clearcoatNormalMap&&s.enable(17),E.iridescence&&s.enable(18),E.iridescenceMap&&s.enable(19),E.iridescenceThicknessMap&&s.enable(20),E.displacementMap&&s.enable(21),E.specularMap&&s.enable(22),E.roughnessMap&&s.enable(23),E.metalnessMap&&s.enable(24),E.gradientMap&&s.enable(25),E.alphaMap&&s.enable(26),E.alphaTest&&s.enable(27),E.vertexColors&&s.enable(28),E.vertexAlphas&&s.enable(29),E.vertexUvs&&s.enable(30),E.vertexTangents&&s.enable(31),E.uvsVertexOnly&&s.enable(32),C.push(s.mask),s.disableAll(),E.fog&&s.enable(0),E.useFog&&s.enable(1),E.flatShading&&s.enable(2),E.logarithmicDepthBuffer&&s.enable(3),E.skinning&&s.enable(4),E.morphTargets&&s.enable(5),E.morphNormals&&s.enable(6),E.morphColors&&s.enable(7),E.premultipliedAlpha&&s.enable(8),E.shadowMapEnabled&&s.enable(9),E.physicallyCorrectLights&&s.enable(10),E.doubleSided&&s.enable(11),E.flipSided&&s.enable(12),E.useDepthPacking&&s.enable(13),E.dithering&&s.enable(14),E.specularIntensityMap&&s.enable(15),E.specularColorMap&&s.enable(16),E.transmission&&s.enable(17),E.transmissionMap&&s.enable(18),E.thicknessMap&&s.enable(19),E.sheen&&s.enable(20),E.sheenColorMap&&s.enable(21),E.sheenRoughnessMap&&s.enable(22),E.decodeVideoTexture&&s.enable(23),E.opaque&&s.enable(24),C.push(s.mask)}function w(C){const E=y[C.type];let k;if(E){const $=f4[E];k=SS.clone($.uniforms)}else k=C.uniforms;return k}function M(C,E){let k;for(let $=0,X=c.length;$<X;$++){const F=c[$];if(F.cacheKey===E){k=F,++k.usedTimes;break}}return k===void 0&&(k=new RC(o,E,C,a),c.push(k)),k}function A(C){if(--C.usedTimes===0){const E=c.indexOf(C);c[E]=c[c.length-1],c.pop(),C.destroy()}}function S(C){u.remove(C)}function D(){u.dispose()}return{getParameters:m,getProgramCacheKey:v,getUniforms:w,acquireProgram:M,releaseProgram:A,releaseShaderCache:S,programs:c,dispose:D}}function kC(){let o=new WeakMap;function e(a){let r=o.get(a);return r===void 0&&(r={},o.set(a,r)),r}function t(a){o.delete(a)}function n(a,r,s){o.get(a)[r]=s}function i(){o=new WeakMap}return{get:e,remove:t,update:n,dispose:i}}function NC(o,e){return o.groupOrder!==e.groupOrder?o.groupOrder-e.groupOrder:o.renderOrder!==e.renderOrder?o.renderOrder-e.renderOrder:o.material.id!==e.material.id?o.material.id-e.material.id:o.z!==e.z?o.z-e.z:o.id-e.id}function Ko(o,e){return o.groupOrder!==e.groupOrder?o.groupOrder-e.groupOrder:o.renderOrder!==e.renderOrder?o.renderOrder-e.renderOrder:o.z!==e.z?e.z-o.z:o.id-e.id}function ea(){const o=[];let e=0;const t=[],n=[],i=[];function a(){e=0,t.length=0,n.length=0,i.length=0}function r(h,p,g,y,m,v){let b=o[e];return b===void 0?(b={id:h.id,object:h,geometry:p,material:g,groupOrder:y,renderOrder:h.renderOrder,z:m,group:v},o[e]=b):(b.id=h.id,b.object=h,b.geometry=p,b.material=g,b.groupOrder=y,b.renderOrder=h.renderOrder,b.z=m,b.group=v),e++,b}function s(h,p,g,y,m,v){const b=r(h,p,g,y,m,v);g.transmission>0?n.push(b):g.transparent===!0?i.push(b):t.push(b)}function u(h,p,g,y,m,v){const b=r(h,p,g,y,m,v);g.transmission>0?n.unshift(b):g.transparent===!0?i.unshift(b):t.unshift(b)}function c(h,p){t.length>1&&t.sort(h||NC),n.length>1&&n.sort(p||Ko),i.length>1&&i.sort(p||Ko)}function d(){for(let h=e,p=o.length;h<p;h++){const g=o[h];if(g.id===null)break;g.id=null,g.object=null,g.geometry=null,g.material=null,g.group=null}}return{opaque:t,transmissive:n,transparent:i,init:a,push:s,unshift:u,finish:d,sort:c}}function UC(){let o=new WeakMap;function e(n,i){const a=o.get(n);let r;return a===void 0?(r=new ea,o.set(n,[r])):i>=a.length?(r=new ea,a.push(r)):r=a[i],r}function t(){o=new WeakMap}return{get:e,dispose:t}}function FC(){const o={};return{get:function(e){if(o[e.id]!==void 0)return o[e.id];let t;switch(e.type){case"DirectionalLight":t={direction:new Y,color:new _2};break;case"SpotLight":t={position:new Y,direction:new Y,color:new _2,distance:0,coneCos:0,penumbraCos:0,decay:0};break;case"PointLight":t={position:new Y,color:new _2,distance:0,decay:0};break;case"HemisphereLight":t={direction:new Y,skyColor:new _2,groundColor:new _2};break;case"RectAreaLight":t={color:new _2,position:new Y,halfWidth:new Y,halfHeight:new Y};break}return o[e.id]=t,t}}}function BC(){const o={};return{get:function(e){if(o[e.id]!==void 0)return o[e.id];let t;switch(e.type){case"DirectionalLight":t={shadowBias:0,shadowNormalBias:0,shadowRadius:1,shadowMapSize:new G1};break;case"SpotLight":t={shadowBias:0,shadowNormalBias:0,shadowRadius:1,shadowMapSize:new G1};break;case"PointLight":t={shadowBias:0,shadowNormalBias:0,shadowRadius:1,shadowMapSize:new G1,shadowCameraNear:1,shadowCameraFar:1e3};break}return o[e.id]=t,t}}}let GC=0;function VC(o,e){return(e.castShadow?2:0)-(o.castShadow?2:0)+(e.map?1:0)-(o.map?1:0)}function jC(o,e){const t=new FC,n=BC(),i={version:0,hash:{directionalLength:-1,pointLength:-1,spotLength:-1,rectAreaLength:-1,hemiLength:-1,numDirectionalShadows:-1,numPointShadows:-1,numSpotShadows:-1,numSpotMaps:-1},ambient:[0,0,0],probe:[],directional:[],directionalShadow:[],directionalShadowMap:[],directionalShadowMatrix:[],spot:[],spotLightMap:[],spotShadow:[],spotShadowMap:[],spotLightMatrix:[],rectArea:[],rectAreaLTC1:null,rectAreaLTC2:null,point:[],pointShadow:[],pointShadowMap:[],pointShadowMatrix:[],hemi:[],numSpotLightShadowsWithMaps:0};for(let d=0;d<9;d++)i.probe.push(new Y);const a=new Y,r=new j2,s=new j2;function u(d,h){let p=0,g=0,y=0;for(let $=0;$<9;$++)i.probe[$].set(0,0,0);let m=0,v=0,b=0,x=0,w=0,M=0,A=0,S=0,D=0,C=0;d.sort(VC);const E=h!==!0?Math.PI:1;for(let $=0,X=d.length;$<X;$++){const F=d[$],R=F.color,U=F.intensity,H=F.distance,V=F.shadow&&F.shadow.map?F.shadow.map.texture:null;if(F.isAmbientLight)p+=R.r*U*E,g+=R.g*U*E,y+=R.b*U*E;else if(F.isLightProbe)for(let N=0;N<9;N++)i.probe[N].addScaledVector(F.sh.coefficients[N],U);else if(F.isDirectionalLight){const N=t.get(F);if(N.color.copy(F.color).multiplyScalar(F.intensity*E),F.castShadow){const z=F.shadow,G=n.get(F);G.shadowBias=z.bias,G.shadowNormalBias=z.normalBias,G.shadowRadius=z.radius,G.shadowMapSize=z.mapSize,i.directionalShadow[m]=G,i.directionalShadowMap[m]=V,i.directionalShadowMatrix[m]=F.shadow.matrix,M++}i.directional[m]=N,m++}else if(F.isSpotLight){const N=t.get(F);N.position.setFromMatrixPosition(F.matrixWorld),N.color.copy(R).multiplyScalar(U*E),N.distance=H,N.coneCos=Math.cos(F.angle),N.penumbraCos=Math.cos(F.angle*(1-F.penumbra)),N.decay=F.decay,i.spot[b]=N;const z=F.shadow;if(F.map&&(i.spotLightMap[D]=F.map,D++,z.updateMatrices(F),F.castShadow&&C++),i.spotLightMatrix[b]=z.matrix,F.castShadow){const G=n.get(F);G.shadowBias=z.bias,G.shadowNormalBias=z.normalBias,G.shadowRadius=z.radius,G.shadowMapSize=z.mapSize,i.spotShadow[b]=G,i.spotShadowMap[b]=V,S++}b++}else if(F.isRectAreaLight){const N=t.get(F);N.color.copy(R).multiplyScalar(U),N.halfWidth.set(F.width*.5,0,0),N.halfHeight.set(0,F.height*.5,0),i.rectArea[x]=N,x++}else if(F.isPointLight){const N=t.get(F);if(N.color.copy(F.color).multiplyScalar(F.intensity*E),N.distance=F.distance,N.decay=F.decay,F.castShadow){const z=F.shadow,G=n.get(F);G.shadowBias=z.bias,G.shadowNormalBias=z.normalBias,G.shadowRadius=z.radius,G.shadowMapSize=z.mapSize,G.shadowCameraNear=z.camera.near,G.shadowCameraFar=z.camera.far,i.pointShadow[v]=G,i.pointShadowMap[v]=V,i.pointShadowMatrix[v]=F.shadow.matrix,A++}i.point[v]=N,v++}else if(F.isHemisphereLight){const N=t.get(F);N.skyColor.copy(F.color).multiplyScalar(U*E),N.groundColor.copy(F.groundColor).multiplyScalar(U*E),i.hemi[w]=N,w++}}x>0&&(e.isWebGL2||o.has("OES_texture_float_linear")===!0?(i.rectAreaLTC1=T1.LTC_FLOAT_1,i.rectAreaLTC2=T1.LTC_FLOAT_2):o.has("OES_texture_half_float_linear")===!0?(i.rectAreaLTC1=T1.LTC_HALF_1,i.rectAreaLTC2=T1.LTC_HALF_2):console.error("THREE.WebGLRenderer: Unable to use RectAreaLight. Missing WebGL extensions.")),i.ambient[0]=p,i.ambient[1]=g,i.ambient[2]=y;const k=i.hash;(k.directionalLength!==m||k.pointLength!==v||k.spotLength!==b||k.rectAreaLength!==x||k.hemiLength!==w||k.numDirectionalShadows!==M||k.numPointShadows!==A||k.numSpotShadows!==S||k.numSpotMaps!==D)&&(i.directional.length=m,i.spot.length=b,i.rectArea.length=x,i.point.length=v,i.hemi.length=w,i.directionalShadow.length=M,i.directionalShadowMap.length=M,i.pointShadow.length=A,i.pointShadowMap.length=A,i.spotShadow.length=S,i.spotShadowMap.length=S,i.directionalShadowMatrix.length=M,i.pointShadowMatrix.length=A,i.spotLightMatrix.length=S+D-C,i.spotLightMap.length=D,i.numSpotLightShadowsWithMaps=C,k.directionalLength=m,k.pointLength=v,k.spotLength=b,k.rectAreaLength=x,k.hemiLength=w,k.numDirectionalShadows=M,k.numPointShadows=A,k.numSpotShadows=S,k.numSpotMaps=D,i.version=GC++)}function c(d,h){let p=0,g=0,y=0,m=0,v=0;const b=h.matrixWorldInverse;for(let x=0,w=d.length;x<w;x++){const M=d[x];if(M.isDirectionalLight){const A=i.directional[p];A.direction.setFromMatrixPosition(M.matrixWorld),a.setFromMatrixPosition(M.target.matrixWorld),A.direction.sub(a),A.direction.transformDirection(b),p++}else if(M.isSpotLight){const A=i.spot[y];A.position.setFromMatrixPosition(M.matrixWorld),A.position.applyMatrix4(b),A.direction.setFromMatrixPosition(M.matrixWorld),a.setFromMatrixPosition(M.target.matrixWorld),A.direction.sub(a),A.direction.transformDirection(b),y++}else if(M.isRectAreaLight){const A=i.rectArea[m];A.position.setFromMatrixPosition(M.matrixWorld),A.position.applyMatrix4(b),s.identity(),r.copy(M.matrixWorld),r.premultiply(b),s.extractRotation(r),A.halfWidth.set(M.width*.5,0,0),A.halfHeight.set(0,M.height*.5,0),A.halfWidth.applyMatrix4(s),A.halfHeight.applyMatrix4(s),m++}else if(M.isPointLight){const A=i.point[g];A.position.setFromMatrixPosition(M.matrixWorld),A.position.applyMatrix4(b),g++}else if(M.isHemisphereLight){const A=i.hemi[v];A.direction.setFromMatrixPosition(M.matrixWorld),A.direction.transformDirection(b),v++}}}return{setup:u,setupView:c,state:i}}function ta(o,e){const t=new jC(o,e),n=[],i=[];function a(){n.length=0,i.length=0}function r(h){n.push(h)}function s(h){i.push(h)}function u(h){t.setup(n,h)}function c(h){t.setupView(n,h)}return{init:a,state:{lightsArray:n,shadowsArray:i,lights:t},setupLights:u,setupLightsView:c,pushLight:r,pushShadow:s}}function WC(o,e){let t=new WeakMap;function n(a,r=0){const s=t.get(a);let u;return s===void 0?(u=new ta(o,e),t.set(a,[u])):r>=s.length?(u=new ta(o,e),s.push(u)):u=s[r],u}function i(){t=new WeakMap}return{get:n,dispose:i}}class HC extends Y0{constructor(e){super(),this.isMeshDepthMaterial=!0,this.type="MeshDepthMaterial",this.depthPacking=iS,this.map=null,this.alphaMap=null,this.displacementMap=null,this.displacementScale=1,this.displacementBias=0,this.wireframe=!1,this.wireframeLinewidth=1,this.setValues(e)}copy(e){return super.copy(e),this.depthPacking=e.depthPacking,this.map=e.map,this.alphaMap=e.alphaMap,this.displacementMap=e.displacementMap,this.displacementScale=e.displacementScale,this.displacementBias=e.displacementBias,this.wireframe=e.wireframe,this.wireframeLinewidth=e.wireframeLinewidth,this}}class YC extends Y0{constructor(e){super(),this.isMeshDistanceMaterial=!0,this.type="MeshDistanceMaterial",this.referencePosition=new Y,this.nearDistance=1,this.farDistance=1e3,this.map=null,this.alphaMap=null,this.displacementMap=null,this.displacementScale=1,this.displacementBias=0,this.setValues(e)}copy(e){return super.copy(e),this.referencePosition.copy(e.referencePosition),this.nearDistance=e.nearDistance,this.farDistance=e.farDistance,this.map=e.map,this.alphaMap=e.alphaMap,this.displacementMap=e.displacementMap,this.displacementScale=e.displacementScale,this.displacementBias=e.displacementBias,this}}const $C=`void main() {
	gl_Position = vec4( position, 1.0 );
}`,JC=`uniform sampler2D shadow_pass;
uniform vec2 resolution;
uniform float radius;
#include <packing>
void main() {
	const float samples = float( VSM_SAMPLES );
	float mean = 0.0;
	float squared_mean = 0.0;
	float uvStride = samples <= 1.0 ? 0.0 : 2.0 / ( samples - 1.0 );
	float uvStart = samples <= 1.0 ? 0.0 : - 1.0;
	for ( float i = 0.0; i < samples; i ++ ) {
		float uvOffset = uvStart + i * uvStride;
		#ifdef HORIZONTAL_PASS
			vec2 distribution = unpackRGBATo2Half( texture2D( shadow_pass, ( gl_FragCoord.xy + vec2( uvOffset, 0.0 ) * radius ) / resolution ) );
			mean += distribution.x;
			squared_mean += distribution.y * distribution.y + distribution.x * distribution.x;
		#else
			float depth = unpackRGBAToDepth( texture2D( shadow_pass, ( gl_FragCoord.xy + vec2( 0.0, uvOffset ) * radius ) / resolution ) );
			mean += depth;
			squared_mean += depth * depth;
		#endif
	}
	mean = mean / samples;
	squared_mean = squared_mean / samples;
	float std_dev = sqrt( squared_mean - mean * mean );
	gl_FragColor = pack2HalfToRGBA( vec2( mean, std_dev ) );
}`;function ZC(o,e,t){let n=new ps;const i=new G1,a=new G1,r=new l3,s=new HC({depthPacking:oS}),u=new YC,c={},d=t.maxTextureSize,h={0:X3,1:z9,2:m4},p=new N4({defines:{VSM_SAMPLES:8},uniforms:{shadow_pass:{value:null},resolution:{value:new G1},radius:{value:4}},vertexShader:$C,fragmentShader:JC}),g=p.clone();g.defines.HORIZONTAL_PASS=1;const y=new E3;y.setAttribute("position",new z3(new Float32Array([-1,-1,.5,3,-1,.5,-1,3,.5]),3));const m=new s3(y,p),v=this;this.enabled=!1,this.autoUpdate=!0,this.needsUpdate=!1,this.type=qr,this.render=function(M,A,S){if(v.enabled===!1||v.autoUpdate===!1&&v.needsUpdate===!1||M.length===0)return;const D=o.getRenderTarget(),C=o.getActiveCubeFace(),E=o.getActiveMipmapLevel(),k=o.state;k.setBlending(i0),k.buffers.color.setClear(1,1,1,1),k.buffers.depth.setTest(!0),k.setScissorTest(!1);for(let $=0,X=M.length;$<X;$++){const F=M[$],R=F.shadow;if(R===void 0){console.warn("THREE.WebGLShadowMap:",F,"has no shadow.");continue}if(R.autoUpdate===!1&&R.needsUpdate===!1)continue;i.copy(R.mapSize);const U=R.getFrameExtents();if(i.multiply(U),a.copy(R.mapSize),(i.x>d||i.y>d)&&(i.x>d&&(a.x=Math.floor(d/U.x),i.x=a.x*U.x,R.mapSize.x=a.x),i.y>d&&(a.y=Math.floor(d/U.y),i.y=a.y*U.y,R.mapSize.y=a.y)),R.map===null){const V=this.type!==c5?{minFilter:x3,magFilter:x3}:{};R.map=new G0(i.x,i.y,V),R.map.texture.name=F.name+".shadowMap",R.camera.updateProjectionMatrix()}o.setRenderTarget(R.map),o.clear();const H=R.getViewportCount();for(let V=0;V<H;V++){const N=R.getViewport(V);r.set(a.x*N.x,a.y*N.y,a.x*N.z,a.y*N.w),k.viewport(r),R.updateMatrices(F,V),n=R.getFrustum(),w(A,S,R.camera,F,this.type)}R.isPointLightShadow!==!0&&this.type===c5&&b(R,S),R.needsUpdate=!1}v.needsUpdate=!1,o.setRenderTarget(D,C,E)};function b(M,A){const S=e.update(m);p.defines.VSM_SAMPLES!==M.blurSamples&&(p.defines.VSM_SAMPLES=M.blurSamples,g.defines.VSM_SAMPLES=M.blurSamples,p.needsUpdate=!0,g.needsUpdate=!0),M.mapPass===null&&(M.mapPass=new G0(i.x,i.y)),p.uniforms.shadow_pass.value=M.map.texture,p.uniforms.resolution.value=M.mapSize,p.uniforms.radius.value=M.radius,o.setRenderTarget(M.mapPass),o.clear(),o.renderBufferDirect(A,null,S,p,m,null),g.uniforms.shadow_pass.value=M.mapPass.texture,g.uniforms.resolution.value=M.mapSize,g.uniforms.radius.value=M.radius,o.setRenderTarget(M.map),o.clear(),o.renderBufferDirect(A,null,S,g,m,null)}function x(M,A,S,D,C,E){let k=null;const $=S.isPointLight===!0?M.customDistanceMaterial:M.customDepthMaterial;if($!==void 0?k=$:k=S.isPointLight===!0?u:s,o.localClippingEnabled&&A.clipShadows===!0&&Array.isArray(A.clippingPlanes)&&A.clippingPlanes.length!==0||A.displacementMap&&A.displacementScale!==0||A.alphaMap&&A.alphaTest>0){const X=k.uuid,F=A.uuid;let R=c[X];R===void 0&&(R={},c[X]=R);let U=R[F];U===void 0&&(U=k.clone(),R[F]=U),k=U}return k.visible=A.visible,k.wireframe=A.wireframe,E===c5?k.side=A.shadowSide!==null?A.shadowSide:A.side:k.side=A.shadowSide!==null?A.shadowSide:h[A.side],k.alphaMap=A.alphaMap,k.alphaTest=A.alphaTest,k.clipShadows=A.clipShadows,k.clippingPlanes=A.clippingPlanes,k.clipIntersection=A.clipIntersection,k.displacementMap=A.displacementMap,k.displacementScale=A.displacementScale,k.displacementBias=A.displacementBias,k.wireframeLinewidth=A.wireframeLinewidth,k.linewidth=A.linewidth,S.isPointLight===!0&&k.isMeshDistanceMaterial===!0&&(k.referencePosition.setFromMatrixPosition(S.matrixWorld),k.nearDistance=D,k.farDistance=C),k}function w(M,A,S,D,C){if(M.visible===!1)return;if(M.layers.test(A.layers)&&(M.isMesh||M.isLine||M.isPoints)&&(M.castShadow||M.receiveShadow&&C===c5)&&(!M.frustumCulled||n.intersectsObject(M))){M.modelViewMatrix.multiplyMatrices(S.matrixWorldInverse,M.matrixWorld);const $=e.update(M),X=M.material;if(Array.isArray(X)){const F=$.groups;for(let R=0,U=F.length;R<U;R++){const H=F[R],V=X[H.materialIndex];if(V&&V.visible){const N=x(M,V,D,S.near,S.far,C);o.renderBufferDirect(S,null,$,N,M,H)}}}else if(X.visible){const F=x(M,X,D,S.near,S.far,C);o.renderBufferDirect(S,null,$,F,M,null)}}const k=M.children;for(let $=0,X=k.length;$<X;$++)w(k[$],A,S,D,C)}}function XC(o,e,t){const n=t.isWebGL2;function i(){let K=!1;const z1=new l3;let C1=null;const _1=new l3(0,0,0,0);return{setMask:function(D1){C1!==D1&&!K&&(o.colorMask(D1,D1,D1,D1),C1=D1)},setLocked:function(D1){K=D1},setClear:function(D1,q1,T2,B2,G4){G4===!0&&(D1*=B2,q1*=B2,T2*=B2),z1.set(D1,q1,T2,B2),_1.equals(z1)===!1&&(o.clearColor(D1,q1,T2,B2),_1.copy(z1))},reset:function(){K=!1,C1=null,_1.set(-1,0,0,0)}}}function a(){let K=!1,z1=null,C1=null,_1=null;return{setTest:function(D1){D1?p1(2929):m1(2929)},setMask:function(D1){z1!==D1&&!K&&(o.depthMask(D1),z1=D1)},setFunc:function(D1){if(C1!==D1){switch(D1){case Tx:o.depthFunc(512);break;case Ex:o.depthFunc(519);break;case Dx:o.depthFunc(513);break;case me:o.depthFunc(515);break;case Ix:o.depthFunc(514);break;case Rx:o.depthFunc(518);break;case Ox:o.depthFunc(516);break;case Px:o.depthFunc(517);break;default:o.depthFunc(515)}C1=D1}},setLocked:function(D1){K=D1},setClear:function(D1){_1!==D1&&(o.clearDepth(D1),_1=D1)},reset:function(){K=!1,z1=null,C1=null,_1=null}}}function r(){let K=!1,z1=null,C1=null,_1=null,D1=null,q1=null,T2=null,B2=null,G4=null;return{setTest:function(L2){K||(L2?p1(2960):m1(2960))},setMask:function(L2){z1!==L2&&!K&&(o.stencilMask(L2),z1=L2)},setFunc:function(L2,S4,U3){(C1!==L2||_1!==S4||D1!==U3)&&(o.stencilFunc(L2,S4,U3),C1=L2,_1=S4,D1=U3)},setOp:function(L2,S4,U3){(q1!==L2||T2!==S4||B2!==U3)&&(o.stencilOp(L2,S4,U3),q1=L2,T2=S4,B2=U3)},setLocked:function(L2){K=L2},setClear:function(L2){G4!==L2&&(o.clearStencil(L2),G4=L2)},reset:function(){K=!1,z1=null,C1=null,_1=null,D1=null,q1=null,T2=null,B2=null,G4=null}}}const s=new i,u=new a,c=new r,d=new WeakMap,h=new WeakMap;let p={},g={},y=new WeakMap,m=[],v=null,b=!1,x=null,w=null,M=null,A=null,S=null,D=null,C=null,E=!1,k=null,$=null,X=null,F=null,R=null;const U=o.getParameter(35661);let H=!1,V=0;const N=o.getParameter(7938);N.indexOf("WebGL")!==-1?(V=parseFloat(/^WebGL (\d)/.exec(N)[1]),H=V>=1):N.indexOf("OpenGL ES")!==-1&&(V=parseFloat(/^OpenGL ES (\d)/.exec(N)[1]),H=V>=2);let z=null,G={};const t1=o.getParameter(3088),e1=o.getParameter(2978),u1=new l3().fromArray(t1),s1=new l3().fromArray(e1);function q(K,z1,C1){const _1=new Uint8Array(4),D1=o.createTexture();o.bindTexture(K,D1),o.texParameteri(K,10241,9728),o.texParameteri(K,10240,9728);for(let q1=0;q1<C1;q1++)o.texImage2D(z1+q1,0,6408,1,1,0,6408,5121,_1);return D1}const Z={};Z[3553]=q(3553,3553,1),Z[34067]=q(34067,34069,6),s.setClear(0,0,0,1),u.setClear(1),c.setClear(0),p1(2929),u.setFunc(me),Y1(!1),t2(Wi),p1(2884),X1(i0);function p1(K){p[K]!==!0&&(o.enable(K),p[K]=!0)}function m1(K){p[K]!==!1&&(o.disable(K),p[K]=!1)}function f1(K,z1){return g[K]!==z1?(o.bindFramebuffer(K,z1),g[K]=z1,n&&(K===36009&&(g[36160]=z1),K===36160&&(g[36009]=z1)),!0):!1}function d1(K,z1){let C1=m,_1=!1;if(K)if(C1=y.get(z1),C1===void 0&&(C1=[],y.set(z1,C1)),K.isWebGLMultipleRenderTargets){const D1=K.texture;if(C1.length!==D1.length||C1[0]!==36064){for(let q1=0,T2=D1.length;q1<T2;q1++)C1[q1]=36064+q1;C1.length=D1.length,_1=!0}}else C1[0]!==36064&&(C1[0]=36064,_1=!0);else C1[0]!==1029&&(C1[0]=1029,_1=!0);_1&&(t.isWebGL2?o.drawBuffers(C1):e.get("WEBGL_draw_buffers").drawBuffersWEBGL(C1))}function N1(K){return v!==K?(o.useProgram(K),v=K,!0):!1}const M1={[b9]:32774,[gx]:32778,[_x]:32779};if(n)M1[Ji]=32775,M1[Zi]=32776;else{const K=e.get("EXT_blend_minmax");K!==null&&(M1[Ji]=K.MIN_EXT,M1[Zi]=K.MAX_EXT)}const S1={[vx]:0,[yx]:1,[bx]:768,[Kr]:770,[Cx]:776,[Ax]:774,[Sx]:772,[xx]:769,[es]:771,[wx]:775,[Mx]:773};function X1(K,z1,C1,_1,D1,q1,T2,B2){if(K===i0){b===!0&&(m1(3042),b=!1);return}if(b===!1&&(p1(3042),b=!0),K!==mx){if(K!==x||B2!==E){if((w!==b9||S!==b9)&&(o.blendEquation(32774),w=b9,S=b9),B2)switch(K){case O0:o.blendFuncSeparate(1,771,1,771);break;case Hi:o.blendFunc(1,1);break;case Yi:o.blendFuncSeparate(0,769,0,1);break;case $i:o.blendFuncSeparate(0,768,0,770);break;default:console.error("THREE.WebGLState: Invalid blending: ",K);break}else switch(K){case O0:o.blendFuncSeparate(770,771,1,771);break;case Hi:o.blendFunc(770,1);break;case Yi:o.blendFuncSeparate(0,769,0,1);break;case $i:o.blendFunc(0,768);break;default:console.error("THREE.WebGLState: Invalid blending: ",K);break}M=null,A=null,D=null,C=null,x=K,E=B2}return}D1=D1||z1,q1=q1||C1,T2=T2||_1,(z1!==w||D1!==S)&&(o.blendEquationSeparate(M1[z1],M1[D1]),w=z1,S=D1),(C1!==M||_1!==A||q1!==D||T2!==C)&&(o.blendFuncSeparate(S1[C1],S1[_1],S1[q1],S1[T2]),M=C1,A=_1,D=q1,C=T2),x=K,E=null}function $1(K,z1){K.side===m4?m1(2884):p1(2884);let C1=K.side===X3;z1&&(C1=!C1),Y1(C1),K.blending===O0&&K.transparent===!1?X1(i0):X1(K.blending,K.blendEquation,K.blendSrc,K.blendDst,K.blendEquationAlpha,K.blendSrcAlpha,K.blendDstAlpha,K.premultipliedAlpha),u.setFunc(K.depthFunc),u.setTest(K.depthTest),u.setMask(K.depthWrite),s.setMask(K.colorWrite);const _1=K.stencilWrite;c.setTest(_1),_1&&(c.setMask(K.stencilWriteMask),c.setFunc(K.stencilFunc,K.stencilRef,K.stencilFuncMask),c.setOp(K.stencilFail,K.stencilZFail,K.stencilZPass)),V1(K.polygonOffset,K.polygonOffsetFactor,K.polygonOffsetUnits),K.alphaToCoverage===!0?p1(32926):m1(32926)}function Y1(K){k!==K&&(K?o.frontFace(2304):o.frontFace(2305),k=K)}function t2(K){K!==fx?(p1(2884),K!==$&&(K===Wi?o.cullFace(1029):K===hx?o.cullFace(1028):o.cullFace(1032))):m1(2884),$=K}function s2(K){K!==X&&(H&&o.lineWidth(K),X=K)}function V1(K,z1,C1){K?(p1(32823),(F!==z1||R!==C1)&&(o.polygonOffset(z1,C1),F=z1,R=C1)):m1(32823)}function n2(K){K?p1(3089):m1(3089)}function W1(K){K===void 0&&(K=33984+U-1),z!==K&&(o.activeTexture(K),z=K)}function O(K,z1,C1){C1===void 0&&(z===null?C1=33984+U-1:C1=z);let _1=G[C1];_1===void 0&&(_1={type:void 0,texture:void 0},G[C1]=_1),(_1.type!==K||_1.texture!==z1)&&(z!==C1&&(o.activeTexture(C1),z=C1),o.bindTexture(K,z1||Z[K]),_1.type=K,_1.texture=z1)}function I(){const K=G[z];K!==void 0&&K.type!==void 0&&(o.bindTexture(K.type,null),K.type=void 0,K.texture=void 0)}function l1(){try{o.compressedTexImage2D.apply(o,arguments)}catch(K){console.error("THREE.WebGLState:",K)}}function b1(){try{o.texSubImage2D.apply(o,arguments)}catch(K){console.error("THREE.WebGLState:",K)}}function A1(){try{o.texSubImage3D.apply(o,arguments)}catch(K){console.error("THREE.WebGLState:",K)}}function O1(){try{o.compressedTexSubImage2D.apply(o,arguments)}catch(K){console.error("THREE.WebGLState:",K)}}function H1(){try{o.texStorage2D.apply(o,arguments)}catch(K){console.error("THREE.WebGLState:",K)}}function W(){try{o.texStorage3D.apply(o,arguments)}catch(K){console.error("THREE.WebGLState:",K)}}function o1(){try{o.texImage2D.apply(o,arguments)}catch(K){console.error("THREE.WebGLState:",K)}}function P1(){try{o.texImage3D.apply(o,arguments)}catch(K){console.error("THREE.WebGLState:",K)}}function L1(K){u1.equals(K)===!1&&(o.scissor(K.x,K.y,K.z,K.w),u1.copy(K))}function k1(K){s1.equals(K)===!1&&(o.viewport(K.x,K.y,K.z,K.w),s1.copy(K))}function j1(K,z1){let C1=h.get(z1);C1===void 0&&(C1=new WeakMap,h.set(z1,C1));let _1=C1.get(K);_1===void 0&&(_1=o.getUniformBlockIndex(z1,K.name),C1.set(K,_1))}function i2(K,z1){const _1=h.get(z1).get(K);d.get(K)!==_1&&(o.uniformBlockBinding(z1,_1,K.__bindingPointIndex),d.set(K,_1))}function m2(){o.disable(3042),o.disable(2884),o.disable(2929),o.disable(32823),o.disable(3089),o.disable(2960),o.disable(32926),o.blendEquation(32774),o.blendFunc(1,0),o.blendFuncSeparate(1,0,1,0),o.colorMask(!0,!0,!0,!0),o.clearColor(0,0,0,0),o.depthMask(!0),o.depthFunc(513),o.clearDepth(1),o.stencilMask(4294967295),o.stencilFunc(519,0,4294967295),o.stencilOp(7680,7680,7680),o.clearStencil(0),o.cullFace(1029),o.frontFace(2305),o.polygonOffset(0,0),o.activeTexture(33984),o.bindFramebuffer(36160,null),n===!0&&(o.bindFramebuffer(36009,null),o.bindFramebuffer(36008,null)),o.useProgram(null),o.lineWidth(1),o.scissor(0,0,o.canvas.width,o.canvas.height),o.viewport(0,0,o.canvas.width,o.canvas.height),p={},z=null,G={},g={},y=new WeakMap,m=[],v=null,b=!1,x=null,w=null,M=null,A=null,S=null,D=null,C=null,E=!1,k=null,$=null,X=null,F=null,R=null,u1.set(0,0,o.canvas.width,o.canvas.height),s1.set(0,0,o.canvas.width,o.canvas.height),s.reset(),u.reset(),c.reset()}return{buffers:{color:s,depth:u,stencil:c},enable:p1,disable:m1,bindFramebuffer:f1,drawBuffers:d1,useProgram:N1,setBlending:X1,setMaterial:$1,setFlipSided:Y1,setCullFace:t2,setLineWidth:s2,setPolygonOffset:V1,setScissorTest:n2,activeTexture:W1,bindTexture:O,unbindTexture:I,compressedTexImage2D:l1,texImage2D:o1,texImage3D:P1,updateUBOMapping:j1,uniformBlockBinding:i2,texStorage2D:H1,texStorage3D:W,texSubImage2D:b1,texSubImage3D:A1,compressedTexSubImage2D:O1,scissor:L1,viewport:k1,reset:m2}}function QC(o,e,t,n,i,a,r){const s=i.isWebGL2,u=i.maxTextures,c=i.maxCubemapSize,d=i.maxTextureSize,h=i.maxSamples,p=e.has("WEBGL_multisampled_render_to_texture")?e.get("WEBGL_multisampled_render_to_texture"):null,g=/OculusBrowser/g.test(navigator.userAgent),y=new WeakMap;let m;const v=new WeakMap;let b=!1;try{b=typeof OffscreenCanvas!="undefined"&&new OffscreenCanvas(1,1).getContext("2d")!==null}catch(O){}function x(O,I){return b?new OffscreenCanvas(O,I):M5("canvas")}function w(O,I,l1,b1){let A1=1;if((O.width>b1||O.height>b1)&&(A1=b1/Math.max(O.width,O.height)),A1<1||I===!0)if(typeof HTMLImageElement!="undefined"&&O instanceof HTMLImageElement||typeof HTMLCanvasElement!="undefined"&&O instanceof HTMLCanvasElement||typeof ImageBitmap!="undefined"&&O instanceof ImageBitmap){const O1=I?Se:Math.floor,H1=O1(A1*O.width),W=O1(A1*O.height);m===void 0&&(m=x(H1,W));const o1=l1?x(H1,W):m;return o1.width=H1,o1.height=W,o1.getContext("2d").drawImage(O,0,0,H1,W),console.warn("THREE.WebGLRenderer: Texture has been resized from ("+O.width+"x"+O.height+") to ("+H1+"x"+W+")."),o1}else return"data"in O&&console.warn("THREE.WebGLRenderer: Image in DataTexture is too big ("+O.width+"x"+O.height+")."),O;return O}function M(O){return So(O.width)&&So(O.height)}function A(O){return s?!1:O.wrapS!==r4||O.wrapT!==r4||O.minFilter!==x3&&O.minFilter!==j3}function S(O,I){return O.generateMipmaps&&I&&O.minFilter!==x3&&O.minFilter!==j3}function D(O){o.generateMipmap(O)}function C(O,I,l1,b1,A1=!1){if(s===!1)return I;if(O!==null){if(o[O]!==void 0)return o[O];console.warn("THREE.WebGLRenderer: Attempt to use non-existing WebGL internal format '"+O+"'")}let O1=I;return I===6403&&(l1===5126&&(O1=33326),l1===5131&&(O1=33325),l1===5121&&(O1=33321)),I===33319&&(l1===5126&&(O1=33328),l1===5131&&(O1=33327),l1===5121&&(O1=33323)),I===6408&&(l1===5126&&(O1=34836),l1===5131&&(O1=34842),l1===5121&&(O1=b1===k2&&A1===!1?35907:32856),l1===32819&&(O1=32854),l1===32820&&(O1=32855)),(O1===33325||O1===33326||O1===33327||O1===33328||O1===34842||O1===34836)&&e.get("EXT_color_buffer_float"),O1}function E(O,I,l1){return S(O,l1)===!0||O.isFramebufferTexture&&O.minFilter!==x3&&O.minFilter!==j3?Math.log2(Math.max(I.width,I.height))+1:O.mipmaps!==void 0&&O.mipmaps.length>0?O.mipmaps.length:O.isCompressedTexture&&Array.isArray(O.image)?I.mipmaps.length:1}function k(O){return O===x3||O===Xi||O===Qi?9728:9729}function $(O){const I=O.target;I.removeEventListener("dispose",$),F(I),I.isVideoTexture&&y.delete(I)}function X(O){const I=O.target;I.removeEventListener("dispose",X),U(I)}function F(O){const I=n.get(O);if(I.__webglInit===void 0)return;const l1=O.source,b1=v.get(l1);if(b1){const A1=b1[I.__cacheKey];A1.usedTimes--,A1.usedTimes===0&&R(O),Object.keys(b1).length===0&&v.delete(l1)}n.remove(O)}function R(O){const I=n.get(O);o.deleteTexture(I.__webglTexture);const l1=O.source,b1=v.get(l1);delete b1[I.__cacheKey],r.memory.textures--}function U(O){const I=O.texture,l1=n.get(O),b1=n.get(I);if(b1.__webglTexture!==void 0&&(o.deleteTexture(b1.__webglTexture),r.memory.textures--),O.depthTexture&&O.depthTexture.dispose(),O.isWebGLCubeRenderTarget)for(let A1=0;A1<6;A1++)o.deleteFramebuffer(l1.__webglFramebuffer[A1]),l1.__webglDepthbuffer&&o.deleteRenderbuffer(l1.__webglDepthbuffer[A1]);else{if(o.deleteFramebuffer(l1.__webglFramebuffer),l1.__webglDepthbuffer&&o.deleteRenderbuffer(l1.__webglDepthbuffer),l1.__webglMultisampledFramebuffer&&o.deleteFramebuffer(l1.__webglMultisampledFramebuffer),l1.__webglColorRenderbuffer)for(let A1=0;A1<l1.__webglColorRenderbuffer.length;A1++)l1.__webglColorRenderbuffer[A1]&&o.deleteRenderbuffer(l1.__webglColorRenderbuffer[A1]);l1.__webglDepthRenderbuffer&&o.deleteRenderbuffer(l1.__webglDepthRenderbuffer)}if(O.isWebGLMultipleRenderTargets)for(let A1=0,O1=I.length;A1<O1;A1++){const H1=n.get(I[A1]);H1.__webglTexture&&(o.deleteTexture(H1.__webglTexture),r.memory.textures--),n.remove(I[A1])}n.remove(I),n.remove(O)}let H=0;function V(){H=0}function N(){const O=H;return O>=u&&console.warn("THREE.WebGLTextures: Trying to use "+O+" texture units while this GPU supports only "+u),H+=1,O}function z(O){const I=[];return I.push(O.wrapS),I.push(O.wrapT),I.push(O.magFilter),I.push(O.minFilter),I.push(O.anisotropy),I.push(O.internalFormat),I.push(O.format),I.push(O.type),I.push(O.generateMipmaps),I.push(O.premultiplyAlpha),I.push(O.flipY),I.push(O.unpackAlignment),I.push(O.encoding),I.join()}function G(O,I){const l1=n.get(O);if(O.isVideoTexture&&n2(O),O.isRenderTargetTexture===!1&&O.version>0&&l1.__version!==O.version){const b1=O.image;if(b1===null)console.warn("THREE.WebGLRenderer: Texture marked for update but no image data found.");else if(b1.complete===!1)console.warn("THREE.WebGLRenderer: Texture marked for update but image is incomplete");else{m1(l1,O,I);return}}t.bindTexture(3553,l1.__webglTexture,33984+I)}function t1(O,I){const l1=n.get(O);if(O.version>0&&l1.__version!==O.version){m1(l1,O,I);return}t.bindTexture(35866,l1.__webglTexture,33984+I)}function e1(O,I){const l1=n.get(O);if(O.version>0&&l1.__version!==O.version){m1(l1,O,I);return}t.bindTexture(32879,l1.__webglTexture,33984+I)}function u1(O,I){const l1=n.get(O);if(O.version>0&&l1.__version!==O.version){f1(l1,O,I);return}t.bindTexture(34067,l1.__webglTexture,33984+I)}const s1={[ve]:10497,[r4]:33071,[ye]:33648},q={[x3]:9728,[Xi]:9984,[Qi]:9986,[j3]:9729,[Gx]:9985,[i6]:9987};function Z(O,I,l1){if(l1?(o.texParameteri(O,10242,s1[I.wrapS]),o.texParameteri(O,10243,s1[I.wrapT]),(O===32879||O===35866)&&o.texParameteri(O,32882,s1[I.wrapR]),o.texParameteri(O,10240,q[I.magFilter]),o.texParameteri(O,10241,q[I.minFilter])):(o.texParameteri(O,10242,33071),o.texParameteri(O,10243,33071),(O===32879||O===35866)&&o.texParameteri(O,32882,33071),(I.wrapS!==r4||I.wrapT!==r4)&&console.warn("THREE.WebGLRenderer: Texture is not power of two. Texture.wrapS and Texture.wrapT should be set to THREE.ClampToEdgeWrapping."),o.texParameteri(O,10240,k(I.magFilter)),o.texParameteri(O,10241,k(I.minFilter)),I.minFilter!==x3&&I.minFilter!==j3&&console.warn("THREE.WebGLRenderer: Texture is not power of two. Texture.minFilter should be set to THREE.NearestFilter or THREE.LinearFilter.")),e.has("EXT_texture_filter_anisotropic")===!0){const b1=e.get("EXT_texture_filter_anisotropic");if(I.type===E0&&e.has("OES_texture_float_linear")===!1||s===!1&&I.type===S5&&e.has("OES_texture_half_float_linear")===!1)return;(I.anisotropy>1||n.get(I).__currentAnisotropy)&&(o.texParameterf(O,b1.TEXTURE_MAX_ANISOTROPY_EXT,Math.min(I.anisotropy,i.getMaxAnisotropy())),n.get(I).__currentAnisotropy=I.anisotropy)}}function p1(O,I){let l1=!1;O.__webglInit===void 0&&(O.__webglInit=!0,I.addEventListener("dispose",$));const b1=I.source;let A1=v.get(b1);A1===void 0&&(A1={},v.set(b1,A1));const O1=z(I);if(O1!==O.__cacheKey){A1[O1]===void 0&&(A1[O1]={texture:o.createTexture(),usedTimes:0},r.memory.textures++,l1=!0),A1[O1].usedTimes++;const H1=A1[O.__cacheKey];H1!==void 0&&(A1[O.__cacheKey].usedTimes--,H1.usedTimes===0&&R(I)),O.__cacheKey=O1,O.__webglTexture=A1[O1].texture}return l1}function m1(O,I,l1){let b1=3553;I.isDataArrayTexture&&(b1=35866),I.isData3DTexture&&(b1=32879);const A1=p1(O,I),O1=I.source;t.bindTexture(b1,O.__webglTexture,33984+l1);const H1=n.get(O1);if(O1.version!==H1.__version||A1===!0){t.activeTexture(33984+l1),o.pixelStorei(37440,I.flipY),o.pixelStorei(37441,I.premultiplyAlpha),o.pixelStorei(3317,I.unpackAlignment),o.pixelStorei(37443,0);const W=A(I)&&M(I.image)===!1;let o1=w(I.image,W,!1,d);o1=W1(I,o1);const P1=M(o1)||s,L1=a.convert(I.format,I.encoding);let k1=a.convert(I.type),j1=C(I.internalFormat,L1,k1,I.encoding,I.isVideoTexture);Z(b1,I,P1);let i2;const m2=I.mipmaps,K=s&&I.isVideoTexture!==!0,z1=H1.__version===void 0||A1===!0,C1=E(I,o1,P1);if(I.isDepthTexture)j1=6402,s?I.type===E0?j1=36012:I.type===T0?j1=33190:I.type===R9?j1=35056:j1=33189:I.type===E0&&console.error("WebGLRenderer: Floating point depth texture requires WebGL2."),I.format===P0&&j1===6402&&I.type!==is&&I.type!==T0&&(console.warn("THREE.WebGLRenderer: Use UnsignedShortType or UnsignedIntType for DepthFormat DepthTexture."),I.type=T0,k1=a.convert(I.type)),I.format===U9&&j1===6402&&(j1=34041,I.type!==R9&&(console.warn("THREE.WebGLRenderer: Use UnsignedInt248Type for DepthStencilFormat DepthTexture."),I.type=R9,k1=a.convert(I.type))),z1&&(K?t.texStorage2D(3553,1,j1,o1.width,o1.height):t.texImage2D(3553,0,j1,o1.width,o1.height,0,L1,k1,null));else if(I.isDataTexture)if(m2.length>0&&P1){K&&z1&&t.texStorage2D(3553,C1,j1,m2[0].width,m2[0].height);for(let _1=0,D1=m2.length;_1<D1;_1++)i2=m2[_1],K?t.texSubImage2D(3553,_1,0,0,i2.width,i2.height,L1,k1,i2.data):t.texImage2D(3553,_1,j1,i2.width,i2.height,0,L1,k1,i2.data);I.generateMipmaps=!1}else K?(z1&&t.texStorage2D(3553,C1,j1,o1.width,o1.height),t.texSubImage2D(3553,0,0,0,o1.width,o1.height,L1,k1,o1.data)):t.texImage2D(3553,0,j1,o1.width,o1.height,0,L1,k1,o1.data);else if(I.isCompressedTexture){K&&z1&&t.texStorage2D(3553,C1,j1,m2[0].width,m2[0].height);for(let _1=0,D1=m2.length;_1<D1;_1++)i2=m2[_1],I.format!==g4?L1!==null?K?t.compressedTexSubImage2D(3553,_1,0,0,i2.width,i2.height,L1,i2.data):t.compressedTexImage2D(3553,_1,j1,i2.width,i2.height,0,i2.data):console.warn("THREE.WebGLRenderer: Attempt to load unsupported compressed texture format in .uploadTexture()"):K?t.texSubImage2D(3553,_1,0,0,i2.width,i2.height,L1,k1,i2.data):t.texImage2D(3553,_1,j1,i2.width,i2.height,0,L1,k1,i2.data)}else if(I.isDataArrayTexture)K?(z1&&t.texStorage3D(35866,C1,j1,o1.width,o1.height,o1.depth),t.texSubImage3D(35866,0,0,0,0,o1.width,o1.height,o1.depth,L1,k1,o1.data)):t.texImage3D(35866,0,j1,o1.width,o1.height,o1.depth,0,L1,k1,o1.data);else if(I.isData3DTexture)K?(z1&&t.texStorage3D(32879,C1,j1,o1.width,o1.height,o1.depth),t.texSubImage3D(32879,0,0,0,0,o1.width,o1.height,o1.depth,L1,k1,o1.data)):t.texImage3D(32879,0,j1,o1.width,o1.height,o1.depth,0,L1,k1,o1.data);else if(I.isFramebufferTexture){if(z1)if(K)t.texStorage2D(3553,C1,j1,o1.width,o1.height);else{let _1=o1.width,D1=o1.height;for(let q1=0;q1<C1;q1++)t.texImage2D(3553,q1,j1,_1,D1,0,L1,k1,null),_1>>=1,D1>>=1}}else if(m2.length>0&&P1){K&&z1&&t.texStorage2D(3553,C1,j1,m2[0].width,m2[0].height);for(let _1=0,D1=m2.length;_1<D1;_1++)i2=m2[_1],K?t.texSubImage2D(3553,_1,0,0,L1,k1,i2):t.texImage2D(3553,_1,j1,L1,k1,i2);I.generateMipmaps=!1}else K?(z1&&t.texStorage2D(3553,C1,j1,o1.width,o1.height),t.texSubImage2D(3553,0,0,0,L1,k1,o1)):t.texImage2D(3553,0,j1,L1,k1,o1);S(I,P1)&&D(b1),H1.__version=O1.version,I.onUpdate&&I.onUpdate(I)}O.__version=I.version}function f1(O,I,l1){if(I.image.length!==6)return;const b1=p1(O,I),A1=I.source;t.bindTexture(34067,O.__webglTexture,33984+l1);const O1=n.get(A1);if(A1.version!==O1.__version||b1===!0){t.activeTexture(33984+l1),o.pixelStorei(37440,I.flipY),o.pixelStorei(37441,I.premultiplyAlpha),o.pixelStorei(3317,I.unpackAlignment),o.pixelStorei(37443,0);const H1=I.isCompressedTexture||I.image[0].isCompressedTexture,W=I.image[0]&&I.image[0].isDataTexture,o1=[];for(let _1=0;_1<6;_1++)!H1&&!W?o1[_1]=w(I.image[_1],!1,!0,c):o1[_1]=W?I.image[_1].image:I.image[_1],o1[_1]=W1(I,o1[_1]);const P1=o1[0],L1=M(P1)||s,k1=a.convert(I.format,I.encoding),j1=a.convert(I.type),i2=C(I.internalFormat,k1,j1,I.encoding),m2=s&&I.isVideoTexture!==!0,K=O1.__version===void 0||b1===!0;let z1=E(I,P1,L1);Z(34067,I,L1);let C1;if(H1){m2&&K&&t.texStorage2D(34067,z1,i2,P1.width,P1.height);for(let _1=0;_1<6;_1++){C1=o1[_1].mipmaps;for(let D1=0;D1<C1.length;D1++){const q1=C1[D1];I.format!==g4?k1!==null?m2?t.compressedTexSubImage2D(34069+_1,D1,0,0,q1.width,q1.height,k1,q1.data):t.compressedTexImage2D(34069+_1,D1,i2,q1.width,q1.height,0,q1.data):console.warn("THREE.WebGLRenderer: Attempt to load unsupported compressed texture format in .setTextureCube()"):m2?t.texSubImage2D(34069+_1,D1,0,0,q1.width,q1.height,k1,j1,q1.data):t.texImage2D(34069+_1,D1,i2,q1.width,q1.height,0,k1,j1,q1.data)}}}else{C1=I.mipmaps,m2&&K&&(C1.length>0&&z1++,t.texStorage2D(34067,z1,i2,o1[0].width,o1[0].height));for(let _1=0;_1<6;_1++)if(W){m2?t.texSubImage2D(34069+_1,0,0,0,o1[_1].width,o1[_1].height,k1,j1,o1[_1].data):t.texImage2D(34069+_1,0,i2,o1[_1].width,o1[_1].height,0,k1,j1,o1[_1].data);for(let D1=0;D1<C1.length;D1++){const T2=C1[D1].image[_1].image;m2?t.texSubImage2D(34069+_1,D1+1,0,0,T2.width,T2.height,k1,j1,T2.data):t.texImage2D(34069+_1,D1+1,i2,T2.width,T2.height,0,k1,j1,T2.data)}}else{m2?t.texSubImage2D(34069+_1,0,0,0,k1,j1,o1[_1]):t.texImage2D(34069+_1,0,i2,k1,j1,o1[_1]);for(let D1=0;D1<C1.length;D1++){const q1=C1[D1];m2?t.texSubImage2D(34069+_1,D1+1,0,0,k1,j1,q1.image[_1]):t.texImage2D(34069+_1,D1+1,i2,k1,j1,q1.image[_1])}}}S(I,L1)&&D(34067),O1.__version=A1.version,I.onUpdate&&I.onUpdate(I)}O.__version=I.version}function d1(O,I,l1,b1,A1){const O1=a.convert(l1.format,l1.encoding),H1=a.convert(l1.type),W=C(l1.internalFormat,O1,H1,l1.encoding);n.get(I).__hasExternalTextures||(A1===32879||A1===35866?t.texImage3D(A1,0,W,I.width,I.height,I.depth,0,O1,H1,null):t.texImage2D(A1,0,W,I.width,I.height,0,O1,H1,null)),t.bindFramebuffer(36160,O),V1(I)?p.framebufferTexture2DMultisampleEXT(36160,b1,A1,n.get(l1).__webglTexture,0,s2(I)):o.framebufferTexture2D(36160,b1,A1,n.get(l1).__webglTexture,0),t.bindFramebuffer(36160,null)}function N1(O,I,l1){if(o.bindRenderbuffer(36161,O),I.depthBuffer&&!I.stencilBuffer){let b1=33189;if(l1||V1(I)){const A1=I.depthTexture;A1&&A1.isDepthTexture&&(A1.type===E0?b1=36012:A1.type===T0&&(b1=33190));const O1=s2(I);V1(I)?p.renderbufferStorageMultisampleEXT(36161,O1,b1,I.width,I.height):o.renderbufferStorageMultisample(36161,O1,b1,I.width,I.height)}else o.renderbufferStorage(36161,b1,I.width,I.height);o.framebufferRenderbuffer(36160,36096,36161,O)}else if(I.depthBuffer&&I.stencilBuffer){const b1=s2(I);l1&&V1(I)===!1?o.renderbufferStorageMultisample(36161,b1,35056,I.width,I.height):V1(I)?p.renderbufferStorageMultisampleEXT(36161,b1,35056,I.width,I.height):o.renderbufferStorage(36161,34041,I.width,I.height),o.framebufferRenderbuffer(36160,33306,36161,O)}else{const b1=I.isWebGLMultipleRenderTargets===!0?I.texture:[I.texture];for(let A1=0;A1<b1.length;A1++){const O1=b1[A1],H1=a.convert(O1.format,O1.encoding),W=a.convert(O1.type),o1=C(O1.internalFormat,H1,W,O1.encoding),P1=s2(I);l1&&V1(I)===!1?o.renderbufferStorageMultisample(36161,P1,o1,I.width,I.height):V1(I)?p.renderbufferStorageMultisampleEXT(36161,P1,o1,I.width,I.height):o.renderbufferStorage(36161,o1,I.width,I.height)}}o.bindRenderbuffer(36161,null)}function M1(O,I){if(I&&I.isWebGLCubeRenderTarget)throw new Error("Depth Texture with cube render targets is not supported");if(t.bindFramebuffer(36160,O),!(I.depthTexture&&I.depthTexture.isDepthTexture))throw new Error("renderTarget.depthTexture must be an instance of THREE.DepthTexture");(!n.get(I.depthTexture).__webglTexture||I.depthTexture.image.width!==I.width||I.depthTexture.image.height!==I.height)&&(I.depthTexture.image.width=I.width,I.depthTexture.image.height=I.height,I.depthTexture.needsUpdate=!0),G(I.depthTexture,0);const b1=n.get(I.depthTexture).__webglTexture,A1=s2(I);if(I.depthTexture.format===P0)V1(I)?p.framebufferTexture2DMultisampleEXT(36160,36096,3553,b1,0,A1):o.framebufferTexture2D(36160,36096,3553,b1,0);else if(I.depthTexture.format===U9)V1(I)?p.framebufferTexture2DMultisampleEXT(36160,33306,3553,b1,0,A1):o.framebufferTexture2D(36160,33306,3553,b1,0);else throw new Error("Unknown depthTexture format")}function S1(O){const I=n.get(O),l1=O.isWebGLCubeRenderTarget===!0;if(O.depthTexture&&!I.__autoAllocateDepthBuffer){if(l1)throw new Error("target.depthTexture not supported in Cube render targets");M1(I.__webglFramebuffer,O)}else if(l1){I.__webglDepthbuffer=[];for(let b1=0;b1<6;b1++)t.bindFramebuffer(36160,I.__webglFramebuffer[b1]),I.__webglDepthbuffer[b1]=o.createRenderbuffer(),N1(I.__webglDepthbuffer[b1],O,!1)}else t.bindFramebuffer(36160,I.__webglFramebuffer),I.__webglDepthbuffer=o.createRenderbuffer(),N1(I.__webglDepthbuffer,O,!1);t.bindFramebuffer(36160,null)}function X1(O,I,l1){const b1=n.get(O);I!==void 0&&d1(b1.__webglFramebuffer,O,O.texture,36064,3553),l1!==void 0&&S1(O)}function $1(O){const I=O.texture,l1=n.get(O),b1=n.get(I);O.addEventListener("dispose",X),O.isWebGLMultipleRenderTargets!==!0&&(b1.__webglTexture===void 0&&(b1.__webglTexture=o.createTexture()),b1.__version=I.version,r.memory.textures++);const A1=O.isWebGLCubeRenderTarget===!0,O1=O.isWebGLMultipleRenderTargets===!0,H1=M(O)||s;if(A1){l1.__webglFramebuffer=[];for(let W=0;W<6;W++)l1.__webglFramebuffer[W]=o.createFramebuffer()}else{if(l1.__webglFramebuffer=o.createFramebuffer(),O1)if(i.drawBuffers){const W=O.texture;for(let o1=0,P1=W.length;o1<P1;o1++){const L1=n.get(W[o1]);L1.__webglTexture===void 0&&(L1.__webglTexture=o.createTexture(),r.memory.textures++)}}else console.warn("THREE.WebGLRenderer: WebGLMultipleRenderTargets can only be used with WebGL2 or WEBGL_draw_buffers extension.");if(s&&O.samples>0&&V1(O)===!1){const W=O1?I:[I];l1.__webglMultisampledFramebuffer=o.createFramebuffer(),l1.__webglColorRenderbuffer=[],t.bindFramebuffer(36160,l1.__webglMultisampledFramebuffer);for(let o1=0;o1<W.length;o1++){const P1=W[o1];l1.__webglColorRenderbuffer[o1]=o.createRenderbuffer(),o.bindRenderbuffer(36161,l1.__webglColorRenderbuffer[o1]);const L1=a.convert(P1.format,P1.encoding),k1=a.convert(P1.type),j1=C(P1.internalFormat,L1,k1,P1.encoding,O.isXRRenderTarget===!0),i2=s2(O);o.renderbufferStorageMultisample(36161,i2,j1,O.width,O.height),o.framebufferRenderbuffer(36160,36064+o1,36161,l1.__webglColorRenderbuffer[o1])}o.bindRenderbuffer(36161,null),O.depthBuffer&&(l1.__webglDepthRenderbuffer=o.createRenderbuffer(),N1(l1.__webglDepthRenderbuffer,O,!0)),t.bindFramebuffer(36160,null)}}if(A1){t.bindTexture(34067,b1.__webglTexture),Z(34067,I,H1);for(let W=0;W<6;W++)d1(l1.__webglFramebuffer[W],O,I,36064,34069+W);S(I,H1)&&D(34067),t.unbindTexture()}else if(O1){const W=O.texture;for(let o1=0,P1=W.length;o1<P1;o1++){const L1=W[o1],k1=n.get(L1);t.bindTexture(3553,k1.__webglTexture),Z(3553,L1,H1),d1(l1.__webglFramebuffer,O,L1,36064+o1,3553),S(L1,H1)&&D(3553)}t.unbindTexture()}else{let W=3553;(O.isWebGL3DRenderTarget||O.isWebGLArrayRenderTarget)&&(s?W=O.isWebGL3DRenderTarget?32879:35866:console.error("THREE.WebGLTextures: THREE.Data3DTexture and THREE.DataArrayTexture only supported with WebGL2.")),t.bindTexture(W,b1.__webglTexture),Z(W,I,H1),d1(l1.__webglFramebuffer,O,I,36064,W),S(I,H1)&&D(W),t.unbindTexture()}O.depthBuffer&&S1(O)}function Y1(O){const I=M(O)||s,l1=O.isWebGLMultipleRenderTargets===!0?O.texture:[O.texture];for(let b1=0,A1=l1.length;b1<A1;b1++){const O1=l1[b1];if(S(O1,I)){const H1=O.isWebGLCubeRenderTarget?34067:3553,W=n.get(O1).__webglTexture;t.bindTexture(H1,W),D(H1),t.unbindTexture()}}}function t2(O){if(s&&O.samples>0&&V1(O)===!1){const I=O.isWebGLMultipleRenderTargets?O.texture:[O.texture],l1=O.width,b1=O.height;let A1=16384;const O1=[],H1=O.stencilBuffer?33306:36096,W=n.get(O),o1=O.isWebGLMultipleRenderTargets===!0;if(o1)for(let P1=0;P1<I.length;P1++)t.bindFramebuffer(36160,W.__webglMultisampledFramebuffer),o.framebufferRenderbuffer(36160,36064+P1,36161,null),t.bindFramebuffer(36160,W.__webglFramebuffer),o.framebufferTexture2D(36009,36064+P1,3553,null,0);t.bindFramebuffer(36008,W.__webglMultisampledFramebuffer),t.bindFramebuffer(36009,W.__webglFramebuffer);for(let P1=0;P1<I.length;P1++){O1.push(36064+P1),O.depthBuffer&&O1.push(H1);const L1=W.__ignoreDepthValues!==void 0?W.__ignoreDepthValues:!1;if(L1===!1&&(O.depthBuffer&&(A1|=256),O.stencilBuffer&&(A1|=1024)),o1&&o.framebufferRenderbuffer(36008,36064,36161,W.__webglColorRenderbuffer[P1]),L1===!0&&(o.invalidateFramebuffer(36008,[H1]),o.invalidateFramebuffer(36009,[H1])),o1){const k1=n.get(I[P1]).__webglTexture;o.framebufferTexture2D(36009,36064,3553,k1,0)}o.blitFramebuffer(0,0,l1,b1,0,0,l1,b1,A1,9728),g&&o.invalidateFramebuffer(36008,O1)}if(t.bindFramebuffer(36008,null),t.bindFramebuffer(36009,null),o1)for(let P1=0;P1<I.length;P1++){t.bindFramebuffer(36160,W.__webglMultisampledFramebuffer),o.framebufferRenderbuffer(36160,36064+P1,36161,W.__webglColorRenderbuffer[P1]);const L1=n.get(I[P1]).__webglTexture;t.bindFramebuffer(36160,W.__webglFramebuffer),o.framebufferTexture2D(36009,36064+P1,3553,L1,0)}t.bindFramebuffer(36009,W.__webglMultisampledFramebuffer)}}function s2(O){return Math.min(h,O.samples)}function V1(O){const I=n.get(O);return s&&O.samples>0&&e.has("WEBGL_multisampled_render_to_texture")===!0&&I.__useRenderToTexture!==!1}function n2(O){const I=r.render.frame;y.get(O)!==I&&(y.set(O,I),O.update())}function W1(O,I){const l1=O.encoding,b1=O.format,A1=O.type;return O.isCompressedTexture===!0||O.isVideoTexture===!0||O.format===xe||l1!==B0&&(l1===k2?s===!1?e.has("EXT_sRGB")===!0&&b1===g4?(O.format=xe,O.minFilter=j3,O.generateMipmaps=!1):I=rs.sRGBToLinear(I):(b1!==g4||A1!==F0)&&console.warn("THREE.WebGLTextures: sRGB encoded textures have to use RGBAFormat and UnsignedByteType."):console.error("THREE.WebGLTextures: Unsupported texture encoding:",l1)),I}this.allocateTextureUnit=N,this.resetTextureUnits=V,this.setTexture2D=G,this.setTexture2DArray=t1,this.setTexture3D=e1,this.setTextureCube=u1,this.rebindTextures=X1,this.setupRenderTarget=$1,this.updateRenderTargetMipmap=Y1,this.updateMultisampleRenderTarget=t2,this.setupDepthRenderbuffer=S1,this.setupFrameBufferTexture=d1,this.useMultisampledRTT=V1}function qC(o,e,t){const n=t.isWebGL2;function i(a,r=null){let s;if(a===F0)return 5121;if(a===Hx)return 32819;if(a===Yx)return 32820;if(a===Vx)return 5120;if(a===jx)return 5122;if(a===is)return 5123;if(a===Wx)return 5124;if(a===T0)return 5125;if(a===E0)return 5126;if(a===S5)return n?5131:(s=e.get("OES_texture_half_float"),s!==null?s.HALF_FLOAT_OES:null);if(a===$x)return 6406;if(a===g4)return 6408;if(a===Zx)return 6409;if(a===Xx)return 6410;if(a===P0)return 6402;if(a===U9)return 34041;if(a===Qx)return 6403;if(a===Jx)return console.warn("THREE.WebGLRenderer: THREE.RGBFormat has been removed. Use THREE.RGBAFormat instead. https://github.com/mrdoob/three.js/pull/23228"),6408;if(a===xe)return s=e.get("EXT_sRGB"),s!==null?s.SRGB_ALPHA_EXT:null;if(a===qx)return 36244;if(a===Kx)return 33319;if(a===eS)return 33320;if(a===tS)return 36249;if(a===x6||a===S6||a===M6||a===A6)if(r===k2)if(s=e.get("WEBGL_compressed_texture_s3tc_srgb"),s!==null){if(a===x6)return s.COMPRESSED_SRGB_S3TC_DXT1_EXT;if(a===S6)return s.COMPRESSED_SRGB_ALPHA_S3TC_DXT1_EXT;if(a===M6)return s.COMPRESSED_SRGB_ALPHA_S3TC_DXT3_EXT;if(a===A6)return s.COMPRESSED_SRGB_ALPHA_S3TC_DXT5_EXT}else return null;else if(s=e.get("WEBGL_compressed_texture_s3tc"),s!==null){if(a===x6)return s.COMPRESSED_RGB_S3TC_DXT1_EXT;if(a===S6)return s.COMPRESSED_RGBA_S3TC_DXT1_EXT;if(a===M6)return s.COMPRESSED_RGBA_S3TC_DXT3_EXT;if(a===A6)return s.COMPRESSED_RGBA_S3TC_DXT5_EXT}else return null;if(a===qi||a===Ki||a===eo||a===to)if(s=e.get("WEBGL_compressed_texture_pvrtc"),s!==null){if(a===qi)return s.COMPRESSED_RGB_PVRTC_4BPPV1_IMG;if(a===Ki)return s.COMPRESSED_RGB_PVRTC_2BPPV1_IMG;if(a===eo)return s.COMPRESSED_RGBA_PVRTC_4BPPV1_IMG;if(a===to)return s.COMPRESSED_RGBA_PVRTC_2BPPV1_IMG}else return null;if(a===nS)return s=e.get("WEBGL_compressed_texture_etc1"),s!==null?s.COMPRESSED_RGB_ETC1_WEBGL:null;if(a===no||a===io)if(s=e.get("WEBGL_compressed_texture_etc"),s!==null){if(a===no)return r===k2?s.COMPRESSED_SRGB8_ETC2:s.COMPRESSED_RGB8_ETC2;if(a===io)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ETC2_EAC:s.COMPRESSED_RGBA8_ETC2_EAC}else return null;if(a===oo||a===ao||a===ro||a===so||a===lo||a===uo||a===co||a===fo||a===ho||a===po||a===mo||a===go||a===_o||a===vo)if(s=e.get("WEBGL_compressed_texture_astc"),s!==null){if(a===oo)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_4x4_KHR:s.COMPRESSED_RGBA_ASTC_4x4_KHR;if(a===ao)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_5x4_KHR:s.COMPRESSED_RGBA_ASTC_5x4_KHR;if(a===ro)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_5x5_KHR:s.COMPRESSED_RGBA_ASTC_5x5_KHR;if(a===so)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_6x5_KHR:s.COMPRESSED_RGBA_ASTC_6x5_KHR;if(a===lo)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_6x6_KHR:s.COMPRESSED_RGBA_ASTC_6x6_KHR;if(a===uo)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_8x5_KHR:s.COMPRESSED_RGBA_ASTC_8x5_KHR;if(a===co)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_8x6_KHR:s.COMPRESSED_RGBA_ASTC_8x6_KHR;if(a===fo)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_8x8_KHR:s.COMPRESSED_RGBA_ASTC_8x8_KHR;if(a===ho)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_10x5_KHR:s.COMPRESSED_RGBA_ASTC_10x5_KHR;if(a===po)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_10x6_KHR:s.COMPRESSED_RGBA_ASTC_10x6_KHR;if(a===mo)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_10x8_KHR:s.COMPRESSED_RGBA_ASTC_10x8_KHR;if(a===go)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_10x10_KHR:s.COMPRESSED_RGBA_ASTC_10x10_KHR;if(a===_o)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_12x10_KHR:s.COMPRESSED_RGBA_ASTC_12x10_KHR;if(a===vo)return r===k2?s.COMPRESSED_SRGB8_ALPHA8_ASTC_12x12_KHR:s.COMPRESSED_RGBA_ASTC_12x12_KHR}else return null;if(a===yo)if(s=e.get("EXT_texture_compression_bptc"),s!==null){if(a===yo)return r===k2?s.COMPRESSED_SRGB_ALPHA_BPTC_UNORM_EXT:s.COMPRESSED_RGBA_BPTC_UNORM_EXT}else return null;return a===R9?n?34042:(s=e.get("WEBGL_depth_texture"),s!==null?s.UNSIGNED_INT_24_8_WEBGL:null):o[a]!==void 0?o[a]:null}return{convert:i}}class KC extends W3{constructor(e=[]){super(),this.isArrayCamera=!0,this.cameras=e}}class P4 extends h3{constructor(){super(),this.isGroup=!0,this.type="Group"}}const eT={type:"move"};class q6{constructor(){this._targetRay=null,this._grip=null,this._hand=null}getHandSpace(){return this._hand===null&&(this._hand=new P4,this._hand.matrixAutoUpdate=!1,this._hand.visible=!1,this._hand.joints={},this._hand.inputState={pinching:!1}),this._hand}getTargetRaySpace(){return this._targetRay===null&&(this._targetRay=new P4,this._targetRay.matrixAutoUpdate=!1,this._targetRay.visible=!1,this._targetRay.hasLinearVelocity=!1,this._targetRay.linearVelocity=new Y,this._targetRay.hasAngularVelocity=!1,this._targetRay.angularVelocity=new Y),this._targetRay}getGripSpace(){return this._grip===null&&(this._grip=new P4,this._grip.matrixAutoUpdate=!1,this._grip.visible=!1,this._grip.hasLinearVelocity=!1,this._grip.linearVelocity=new Y,this._grip.hasAngularVelocity=!1,this._grip.angularVelocity=new Y),this._grip}dispatchEvent(e){return this._targetRay!==null&&this._targetRay.dispatchEvent(e),this._grip!==null&&this._grip.dispatchEvent(e),this._hand!==null&&this._hand.dispatchEvent(e),this}disconnect(e){return this.dispatchEvent({type:"disconnected",data:e}),this._targetRay!==null&&(this._targetRay.visible=!1),this._grip!==null&&(this._grip.visible=!1),this._hand!==null&&(this._hand.visible=!1),this}update(e,t,n){let i=null,a=null,r=null;const s=this._targetRay,u=this._grip,c=this._hand;if(e&&t.session.visibilityState!=="visible-blurred"){if(c&&e.hand){r=!0;for(const m of e.hand.values()){const v=t.getJointPose(m,n);if(c.joints[m.jointName]===void 0){const x=new P4;x.matrixAutoUpdate=!1,x.visible=!1,c.joints[m.jointName]=x,c.add(x)}const b=c.joints[m.jointName];v!==null&&(b.matrix.fromArray(v.transform.matrix),b.matrix.decompose(b.position,b.rotation,b.scale),b.jointRadius=v.radius),b.visible=v!==null}const d=c.joints["index-finger-tip"],h=c.joints["thumb-tip"],p=d.position.distanceTo(h.position),g=.02,y=.005;c.inputState.pinching&&p>g+y?(c.inputState.pinching=!1,this.dispatchEvent({type:"pinchend",handedness:e.handedness,target:this})):!c.inputState.pinching&&p<=g-y&&(c.inputState.pinching=!0,this.dispatchEvent({type:"pinchstart",handedness:e.handedness,target:this}))}else u!==null&&e.gripSpace&&(a=t.getPose(e.gripSpace,n),a!==null&&(u.matrix.fromArray(a.transform.matrix),u.matrix.decompose(u.position,u.rotation,u.scale),a.linearVelocity?(u.hasLinearVelocity=!0,u.linearVelocity.copy(a.linearVelocity)):u.hasLinearVelocity=!1,a.angularVelocity?(u.hasAngularVelocity=!0,u.angularVelocity.copy(a.angularVelocity)):u.hasAngularVelocity=!1));s!==null&&(i=t.getPose(e.targetRaySpace,n),i===null&&a!==null&&(i=a),i!==null&&(s.matrix.fromArray(i.transform.matrix),s.matrix.decompose(s.position,s.rotation,s.scale),i.linearVelocity?(s.hasLinearVelocity=!0,s.linearVelocity.copy(i.linearVelocity)):s.hasLinearVelocity=!1,i.angularVelocity?(s.hasAngularVelocity=!0,s.angularVelocity.copy(i.angularVelocity)):s.hasAngularVelocity=!1,this.dispatchEvent(eT)))}return s!==null&&(s.visible=i!==null),u!==null&&(u.visible=a!==null),c!==null&&(c.visible=r!==null),this}}class tT extends Q3{constructor(e,t,n,i,a,r,s,u,c,d){if(d=d!==void 0?d:P0,d!==P0&&d!==U9)throw new Error("DepthTexture format must be either THREE.DepthFormat or THREE.DepthStencilFormat");n===void 0&&d===P0&&(n=T0),n===void 0&&d===U9&&(n=R9),super(null,i,a,r,s,u,d,n,c),this.isDepthTexture=!0,this.image={width:e,height:t},this.magFilter=s!==void 0?s:x3,this.minFilter=u!==void 0?u:x3,this.flipY=!1,this.generateMipmaps=!1}}class nT extends H0{constructor(e,t){super();const n=this;let i=null,a=1,r=null,s="local-floor",u=null,c=null,d=null,h=null,p=null,g=null;const y=t.getContextAttributes();let m=null,v=null;const b=[],x=[],w=new W3;w.layers.enable(1),w.viewport=new l3;const M=new W3;M.layers.enable(2),M.viewport=new l3;const A=[w,M],S=new KC;S.layers.enable(1),S.layers.enable(2);let D=null,C=null;this.cameraAutoUpdate=!0,this.enabled=!1,this.isPresenting=!1,this.getController=function(z){let G=b[z];return G===void 0&&(G=new q6,b[z]=G),G.getTargetRaySpace()},this.getControllerGrip=function(z){let G=b[z];return G===void 0&&(G=new q6,b[z]=G),G.getGripSpace()},this.getHand=function(z){let G=b[z];return G===void 0&&(G=new q6,b[z]=G),G.getHandSpace()};function E(z){const G=x.indexOf(z.inputSource);if(G===-1)return;const t1=b[G];t1!==void 0&&t1.dispatchEvent({type:z.type,data:z.inputSource})}function k(){i.removeEventListener("select",E),i.removeEventListener("selectstart",E),i.removeEventListener("selectend",E),i.removeEventListener("squeeze",E),i.removeEventListener("squeezestart",E),i.removeEventListener("squeezeend",E),i.removeEventListener("end",k),i.removeEventListener("inputsourceschange",$);for(let z=0;z<b.length;z++){const G=x[z];G!==null&&(x[z]=null,b[z].disconnect(G))}D=null,C=null,e.setRenderTarget(m),p=null,h=null,d=null,i=null,v=null,N.stop(),n.isPresenting=!1,n.dispatchEvent({type:"sessionend"})}this.setFramebufferScaleFactor=function(z){a=z,n.isPresenting===!0&&console.warn("THREE.WebXRManager: Cannot change framebuffer scale while presenting.")},this.setReferenceSpaceType=function(z){s=z,n.isPresenting===!0&&console.warn("THREE.WebXRManager: Cannot change reference space type while presenting.")},this.getReferenceSpace=function(){return u||r},this.setReferenceSpace=function(z){u=z},this.getBaseLayer=function(){return h!==null?h:p},this.getBinding=function(){return d},this.getFrame=function(){return g},this.getSession=function(){return i},this.setSession=function(z){return E2(this,null,function*(){if(i=z,i!==null){if(m=e.getRenderTarget(),i.addEventListener("select",E),i.addEventListener("selectstart",E),i.addEventListener("selectend",E),i.addEventListener("squeeze",E),i.addEventListener("squeezestart",E),i.addEventListener("squeezeend",E),i.addEventListener("end",k),i.addEventListener("inputsourceschange",$),y.xrCompatible!==!0&&(yield t.makeXRCompatible()),i.renderState.layers===void 0||e.capabilities.isWebGL2===!1){const G={antialias:i.renderState.layers===void 0?y.antialias:!0,alpha:y.alpha,depth:y.depth,stencil:y.stencil,framebufferScaleFactor:a};p=new XRWebGLLayer(i,t,G),i.updateRenderState({baseLayer:p}),v=new G0(p.framebufferWidth,p.framebufferHeight,{format:g4,type:F0,encoding:e.outputEncoding,stencilBuffer:y.stencil})}else{let G=null,t1=null,e1=null;y.depth&&(e1=y.stencil?35056:33190,G=y.stencil?U9:P0,t1=y.stencil?R9:T0);const u1={colorFormat:32856,depthFormat:e1,scaleFactor:a};d=new XRWebGLBinding(i,t),h=d.createProjectionLayer(u1),i.updateRenderState({layers:[h]}),v=new G0(h.textureWidth,h.textureHeight,{format:g4,type:F0,depthTexture:new tT(h.textureWidth,h.textureHeight,t1,void 0,void 0,void 0,void 0,void 0,void 0,G),stencilBuffer:y.stencil,encoding:e.outputEncoding,samples:y.antialias?4:0});const s1=e.properties.get(v);s1.__ignoreDepthValues=h.ignoreDepthValues}v.isXRRenderTarget=!0,this.setFoveation(1),u=null,r=yield i.requestReferenceSpace(s),N.setContext(i),N.start(),n.isPresenting=!0,n.dispatchEvent({type:"sessionstart"})}})};function $(z){for(let G=0;G<z.removed.length;G++){const t1=z.removed[G],e1=x.indexOf(t1);e1>=0&&(x[e1]=null,b[e1].dispatchEvent({type:"disconnected",data:t1}))}for(let G=0;G<z.added.length;G++){const t1=z.added[G];let e1=x.indexOf(t1);if(e1===-1){for(let s1=0;s1<b.length;s1++)if(s1>=x.length){x.push(t1),e1=s1;break}else if(x[s1]===null){x[s1]=t1,e1=s1;break}if(e1===-1)break}const u1=b[e1];u1&&u1.dispatchEvent({type:"connected",data:t1})}}const X=new Y,F=new Y;function R(z,G,t1){X.setFromMatrixPosition(G.matrixWorld),F.setFromMatrixPosition(t1.matrixWorld);const e1=X.distanceTo(F),u1=G.projectionMatrix.elements,s1=t1.projectionMatrix.elements,q=u1[14]/(u1[10]-1),Z=u1[14]/(u1[10]+1),p1=(u1[9]+1)/u1[5],m1=(u1[9]-1)/u1[5],f1=(u1[8]-1)/u1[0],d1=(s1[8]+1)/s1[0],N1=q*f1,M1=q*d1,S1=e1/(-f1+d1),X1=S1*-f1;G.matrixWorld.decompose(z.position,z.quaternion,z.scale),z.translateX(X1),z.translateZ(S1),z.matrixWorld.compose(z.position,z.quaternion,z.scale),z.matrixWorldInverse.copy(z.matrixWorld).invert();const $1=q+S1,Y1=Z+S1,t2=N1-X1,s2=M1+(e1-X1),V1=p1*Z/Y1*$1,n2=m1*Z/Y1*$1;z.projectionMatrix.makePerspective(t2,s2,V1,n2,$1,Y1)}function U(z,G){G===null?z.matrixWorld.copy(z.matrix):z.matrixWorld.multiplyMatrices(G.matrixWorld,z.matrix),z.matrixWorldInverse.copy(z.matrixWorld).invert()}this.updateCamera=function(z){if(i===null)return;S.near=M.near=w.near=z.near,S.far=M.far=w.far=z.far,(D!==S.near||C!==S.far)&&(i.updateRenderState({depthNear:S.near,depthFar:S.far}),D=S.near,C=S.far);const G=z.parent,t1=S.cameras;U(S,G);for(let u1=0;u1<t1.length;u1++)U(t1[u1],G);S.matrixWorld.decompose(S.position,S.quaternion,S.scale),z.matrix.copy(S.matrix),z.matrix.decompose(z.position,z.quaternion,z.scale);const e1=z.children;for(let u1=0,s1=e1.length;u1<s1;u1++)e1[u1].updateMatrixWorld(!0);t1.length===2?R(S,w,M):S.projectionMatrix.copy(w.projectionMatrix)},this.getCamera=function(){return S},this.getFoveation=function(){if(h!==null)return h.fixedFoveation;if(p!==null)return p.fixedFoveation},this.setFoveation=function(z){h!==null&&(h.fixedFoveation=z),p!==null&&p.fixedFoveation!==void 0&&(p.fixedFoveation=z)};let H=null;function V(z,G){if(c=G.getViewerPose(u||r),g=G,c!==null){const t1=c.views;p!==null&&(e.setRenderTargetFramebuffer(v,p.framebuffer),e.setRenderTarget(v));let e1=!1;t1.length!==S.cameras.length&&(S.cameras.length=0,e1=!0);for(let u1=0;u1<t1.length;u1++){const s1=t1[u1];let q=null;if(p!==null)q=p.getViewport(s1);else{const p1=d.getViewSubImage(h,s1);q=p1.viewport,u1===0&&(e.setRenderTargetTextures(v,p1.colorTexture,h.ignoreDepthValues?void 0:p1.depthStencilTexture),e.setRenderTarget(v))}let Z=A[u1];Z===void 0&&(Z=new W3,Z.layers.enable(u1),Z.viewport=new l3,A[u1]=Z),Z.matrix.fromArray(s1.transform.matrix),Z.projectionMatrix.fromArray(s1.projectionMatrix),Z.viewport.set(q.x,q.y,q.width,q.height),u1===0&&S.matrix.copy(Z.matrix),e1===!0&&S.cameras.push(Z)}}for(let t1=0;t1<b.length;t1++){const e1=x[t1],u1=b[t1];e1!==null&&u1!==void 0&&u1.update(e1,G,u||r)}H&&H(z,G),g=null}const N=new ms;N.setAnimationLoop(V),this.setAnimationLoop=function(z){H=z},this.dispose=function(){}}}function iT(o,e){function t(m,v){m.fogColor.value.copy(v.color),v.isFog?(m.fogNear.value=v.near,m.fogFar.value=v.far):v.isFogExp2&&(m.fogDensity.value=v.density)}function n(m,v,b,x,w){v.isMeshBasicMaterial||v.isMeshLambertMaterial?i(m,v):v.isMeshToonMaterial?(i(m,v),d(m,v)):v.isMeshPhongMaterial?(i(m,v),c(m,v)):v.isMeshStandardMaterial?(i(m,v),h(m,v),v.isMeshPhysicalMaterial&&p(m,v,w)):v.isMeshMatcapMaterial?(i(m,v),g(m,v)):v.isMeshDepthMaterial?i(m,v):v.isMeshDistanceMaterial?(i(m,v),y(m,v)):v.isMeshNormalMaterial?i(m,v):v.isLineBasicMaterial?(a(m,v),v.isLineDashedMaterial&&r(m,v)):v.isPointsMaterial?s(m,v,b,x):v.isSpriteMaterial?u(m,v):v.isShadowMaterial?(m.color.value.copy(v.color),m.opacity.value=v.opacity):v.isShaderMaterial&&(v.uniformsNeedUpdate=!1)}function i(m,v){m.opacity.value=v.opacity,v.color&&m.diffuse.value.copy(v.color),v.emissive&&m.emissive.value.copy(v.emissive).multiplyScalar(v.emissiveIntensity),v.map&&(m.map.value=v.map),v.alphaMap&&(m.alphaMap.value=v.alphaMap),v.bumpMap&&(m.bumpMap.value=v.bumpMap,m.bumpScale.value=v.bumpScale,v.side===X3&&(m.bumpScale.value*=-1)),v.displacementMap&&(m.displacementMap.value=v.displacementMap,m.displacementScale.value=v.displacementScale,m.displacementBias.value=v.displacementBias),v.emissiveMap&&(m.emissiveMap.value=v.emissiveMap),v.normalMap&&(m.normalMap.value=v.normalMap,m.normalScale.value.copy(v.normalScale),v.side===X3&&m.normalScale.value.negate()),v.specularMap&&(m.specularMap.value=v.specularMap),v.alphaTest>0&&(m.alphaTest.value=v.alphaTest);const b=e.get(v).envMap;if(b&&(m.envMap.value=b,m.flipEnvMap.value=b.isCubeTexture&&b.isRenderTargetTexture===!1?-1:1,m.reflectivity.value=v.reflectivity,m.ior.value=v.ior,m.refractionRatio.value=v.refractionRatio),v.lightMap){m.lightMap.value=v.lightMap;const M=o.physicallyCorrectLights!==!0?Math.PI:1;m.lightMapIntensity.value=v.lightMapIntensity*M}v.aoMap&&(m.aoMap.value=v.aoMap,m.aoMapIntensity.value=v.aoMapIntensity);let x;v.map?x=v.map:v.specularMap?x=v.specularMap:v.displacementMap?x=v.displacementMap:v.normalMap?x=v.normalMap:v.bumpMap?x=v.bumpMap:v.roughnessMap?x=v.roughnessMap:v.metalnessMap?x=v.metalnessMap:v.alphaMap?x=v.alphaMap:v.emissiveMap?x=v.emissiveMap:v.clearcoatMap?x=v.clearcoatMap:v.clearcoatNormalMap?x=v.clearcoatNormalMap:v.clearcoatRoughnessMap?x=v.clearcoatRoughnessMap:v.iridescenceMap?x=v.iridescenceMap:v.iridescenceThicknessMap?x=v.iridescenceThicknessMap:v.specularIntensityMap?x=v.specularIntensityMap:v.specularColorMap?x=v.specularColorMap:v.transmissionMap?x=v.transmissionMap:v.thicknessMap?x=v.thicknessMap:v.sheenColorMap?x=v.sheenColorMap:v.sheenRoughnessMap&&(x=v.sheenRoughnessMap),x!==void 0&&(x.isWebGLRenderTarget&&(x=x.texture),x.matrixAutoUpdate===!0&&x.updateMatrix(),m.uvTransform.value.copy(x.matrix));let w;v.aoMap?w=v.aoMap:v.lightMap&&(w=v.lightMap),w!==void 0&&(w.isWebGLRenderTarget&&(w=w.texture),w.matrixAutoUpdate===!0&&w.updateMatrix(),m.uv2Transform.value.copy(w.matrix))}function a(m,v){m.diffuse.value.copy(v.color),m.opacity.value=v.opacity}function r(m,v){m.dashSize.value=v.dashSize,m.totalSize.value=v.dashSize+v.gapSize,m.scale.value=v.scale}function s(m,v,b,x){m.diffuse.value.copy(v.color),m.opacity.value=v.opacity,m.size.value=v.size*b,m.scale.value=x*.5,v.map&&(m.map.value=v.map),v.alphaMap&&(m.alphaMap.value=v.alphaMap),v.alphaTest>0&&(m.alphaTest.value=v.alphaTest);let w;v.map?w=v.map:v.alphaMap&&(w=v.alphaMap),w!==void 0&&(w.matrixAutoUpdate===!0&&w.updateMatrix(),m.uvTransform.value.copy(w.matrix))}function u(m,v){m.diffuse.value.copy(v.color),m.opacity.value=v.opacity,m.rotation.value=v.rotation,v.map&&(m.map.value=v.map),v.alphaMap&&(m.alphaMap.value=v.alphaMap),v.alphaTest>0&&(m.alphaTest.value=v.alphaTest);let b;v.map?b=v.map:v.alphaMap&&(b=v.alphaMap),b!==void 0&&(b.matrixAutoUpdate===!0&&b.updateMatrix(),m.uvTransform.value.copy(b.matrix))}function c(m,v){m.specular.value.copy(v.specular),m.shininess.value=Math.max(v.shininess,1e-4)}function d(m,v){v.gradientMap&&(m.gradientMap.value=v.gradientMap)}function h(m,v){m.roughness.value=v.roughness,m.metalness.value=v.metalness,v.roughnessMap&&(m.roughnessMap.value=v.roughnessMap),v.metalnessMap&&(m.metalnessMap.value=v.metalnessMap),e.get(v).envMap&&(m.envMapIntensity.value=v.envMapIntensity)}function p(m,v,b){m.ior.value=v.ior,v.sheen>0&&(m.sheenColor.value.copy(v.sheenColor).multiplyScalar(v.sheen),m.sheenRoughness.value=v.sheenRoughness,v.sheenColorMap&&(m.sheenColorMap.value=v.sheenColorMap),v.sheenRoughnessMap&&(m.sheenRoughnessMap.value=v.sheenRoughnessMap)),v.clearcoat>0&&(m.clearcoat.value=v.clearcoat,m.clearcoatRoughness.value=v.clearcoatRoughness,v.clearcoatMap&&(m.clearcoatMap.value=v.clearcoatMap),v.clearcoatRoughnessMap&&(m.clearcoatRoughnessMap.value=v.clearcoatRoughnessMap),v.clearcoatNormalMap&&(m.clearcoatNormalScale.value.copy(v.clearcoatNormalScale),m.clearcoatNormalMap.value=v.clearcoatNormalMap,v.side===X3&&m.clearcoatNormalScale.value.negate())),v.iridescence>0&&(m.iridescence.value=v.iridescence,m.iridescenceIOR.value=v.iridescenceIOR,m.iridescenceThicknessMinimum.value=v.iridescenceThicknessRange[0],m.iridescenceThicknessMaximum.value=v.iridescenceThicknessRange[1],v.iridescenceMap&&(m.iridescenceMap.value=v.iridescenceMap),v.iridescenceThicknessMap&&(m.iridescenceThicknessMap.value=v.iridescenceThicknessMap)),v.transmission>0&&(m.transmission.value=v.transmission,m.transmissionSamplerMap.value=b.texture,m.transmissionSamplerSize.value.set(b.width,b.height),v.transmissionMap&&(m.transmissionMap.value=v.transmissionMap),m.thickness.value=v.thickness,v.thicknessMap&&(m.thicknessMap.value=v.thicknessMap),m.attenuationDistance.value=v.attenuationDistance,m.attenuationColor.value.copy(v.attenuationColor)),m.specularIntensity.value=v.specularIntensity,m.specularColor.value.copy(v.specularColor),v.specularIntensityMap&&(m.specularIntensityMap.value=v.specularIntensityMap),v.specularColorMap&&(m.specularColorMap.value=v.specularColorMap)}function g(m,v){v.matcap&&(m.matcap.value=v.matcap)}function y(m,v){m.referencePosition.value.copy(v.referencePosition),m.nearDistance.value=v.nearDistance,m.farDistance.value=v.farDistance}return{refreshFogUniforms:t,refreshMaterialUniforms:n}}function oT(o,e,t,n){let i={},a={},r=[];const s=t.isWebGL2?o.getParameter(35375):0;function u(x,w){const M=w.program;n.uniformBlockBinding(x,M)}function c(x,w){let M=i[x.id];M===void 0&&(y(x),M=d(x),i[x.id]=M,x.addEventListener("dispose",v));const A=w.program;n.updateUBOMapping(x,A);const S=e.render.frame;a[x.id]!==S&&(p(x),a[x.id]=S)}function d(x){const w=h();x.__bindingPointIndex=w;const M=o.createBuffer(),A=x.__size,S=x.usage;return o.bindBuffer(35345,M),o.bufferData(35345,A,S),o.bindBuffer(35345,null),o.bindBufferBase(35345,w,M),M}function h(){for(let x=0;x<s;x++)if(r.indexOf(x)===-1)return r.push(x),x;return console.error("THREE.WebGLRenderer: Maximum number of simultaneously usable uniforms groups reached."),0}function p(x){const w=i[x.id],M=x.uniforms,A=x.__cache;o.bindBuffer(35345,w);for(let S=0,D=M.length;S<D;S++){const C=M[S];if(g(C,S,A)===!0){const E=C.value,k=C.__offset;typeof E=="number"?(C.__data[0]=E,o.bufferSubData(35345,k,C.__data)):(C.value.isMatrix3?(C.__data[0]=C.value.elements[0],C.__data[1]=C.value.elements[1],C.__data[2]=C.value.elements[2],C.__data[3]=C.value.elements[0],C.__data[4]=C.value.elements[3],C.__data[5]=C.value.elements[4],C.__data[6]=C.value.elements[5],C.__data[7]=C.value.elements[0],C.__data[8]=C.value.elements[6],C.__data[9]=C.value.elements[7],C.__data[10]=C.value.elements[8],C.__data[11]=C.value.elements[0]):E.toArray(C.__data),o.bufferSubData(35345,k,C.__data))}}o.bindBuffer(35345,null)}function g(x,w,M){const A=x.value;if(M[w]===void 0)return typeof A=="number"?M[w]=A:M[w]=A.clone(),!0;if(typeof A=="number"){if(M[w]!==A)return M[w]=A,!0}else{const S=M[w];if(S.equals(A)===!1)return S.copy(A),!0}return!1}function y(x){const w=x.uniforms;let M=0;const A=16;let S=0;for(let D=0,C=w.length;D<C;D++){const E=w[D],k=m(E);if(E.__data=new Float32Array(k.storage/Float32Array.BYTES_PER_ELEMENT),E.__offset=M,D>0){S=M%A;const $=A-S;S!==0&&$-k.boundary<0&&(M+=A-S,E.__offset=M)}M+=k.storage}return S=M%A,S>0&&(M+=A-S),x.__size=M,x.__cache={},this}function m(x){const w=x.value,M={boundary:0,storage:0};return typeof w=="number"?(M.boundary=4,M.storage=4):w.isVector2?(M.boundary=8,M.storage=8):w.isVector3||w.isColor?(M.boundary=16,M.storage=12):w.isVector4?(M.boundary=16,M.storage=16):w.isMatrix3?(M.boundary=48,M.storage=48):w.isMatrix4?(M.boundary=64,M.storage=64):w.isTexture?console.warn("THREE.WebGLRenderer: Texture samplers can not be part of an uniforms group."):console.warn("THREE.WebGLRenderer: Unsupported uniform value type.",w),M}function v(x){const w=x.target;w.removeEventListener("dispose",v);const M=r.indexOf(w.__bindingPointIndex);r.splice(M,1),o.deleteBuffer(i[w.id]),delete i[w.id],delete a[w.id]}function b(){for(const x in i)o.deleteBuffer(i[x]);r=[],i={},a={}}return{bind:u,update:c,dispose:b}}function aT(){const o=M5("canvas");return o.style.display="block",o}function bs(o={}){this.isWebGLRenderer=!0;const e=o.canvas!==void 0?o.canvas:aT(),t=o.context!==void 0?o.context:null,n=o.depth!==void 0?o.depth:!0,i=o.stencil!==void 0?o.stencil:!0,a=o.antialias!==void 0?o.antialias:!1,r=o.premultipliedAlpha!==void 0?o.premultipliedAlpha:!0,s=o.preserveDrawingBuffer!==void 0?o.preserveDrawingBuffer:!1,u=o.powerPreference!==void 0?o.powerPreference:"default",c=o.failIfMajorPerformanceCaveat!==void 0?o.failIfMajorPerformanceCaveat:!1;let d;t!==null?d=t.getContextAttributes().alpha:d=o.alpha!==void 0?o.alpha:!1;let h=null,p=null;const g=[],y=[];this.domElement=e,this.debug={checkShaderErrors:!0},this.autoClear=!0,this.autoClearColor=!0,this.autoClearDepth=!0,this.autoClearStencil=!0,this.sortObjects=!0,this.clippingPlanes=[],this.localClippingEnabled=!1,this.outputEncoding=B0,this.physicallyCorrectLights=!1,this.toneMapping=z4,this.toneMappingExposure=1,Object.defineProperties(this,{gammaFactor:{get:function(){return console.warn("THREE.WebGLRenderer: .gammaFactor has been removed."),2},set:function(){console.warn("THREE.WebGLRenderer: .gammaFactor has been removed.")}}});const m=this;let v=!1,b=0,x=0,w=null,M=-1,A=null;const S=new l3,D=new l3;let C=null,E=e.width,k=e.height,$=1,X=null,F=null;const R=new l3(0,0,E,k),U=new l3(0,0,E,k);let H=!1;const V=new ps;let N=!1,z=!1,G=null;const t1=new j2,e1=new G1,u1=new Y,s1={background:null,fog:null,environment:null,overrideMaterial:null,isScene:!0};function q(){return w===null?$:1}let Z=t;function p1(L,r1){for(let h1=0;h1<L.length;h1++){const a1=L[h1],g1=e.getContext(a1,r1);if(g1!==null)return g1}return null}try{const L={alpha:!0,depth:n,stencil:i,antialias:a,premultipliedAlpha:r,preserveDrawingBuffer:s,powerPreference:u,failIfMajorPerformanceCaveat:c};if("setAttribute"in e&&e.setAttribute("data-engine",`three.js r${Qt}`),e.addEventListener("webglcontextlost",j1,!1),e.addEventListener("webglcontextrestored",i2,!1),e.addEventListener("webglcontextcreationerror",m2,!1),Z===null){const r1=["webgl2","webgl","experimental-webgl"];if(m.isWebGL1Renderer===!0&&r1.shift(),Z=p1(r1,L),Z===null)throw p1(r1)?new Error("Error creating WebGL context with your selected attributes."):new Error("Error creating WebGL context.")}Z.getShaderPrecisionFormat===void 0&&(Z.getShaderPrecisionFormat=function(){return{rangeMin:1,rangeMax:1,precision:1}})}catch(L){throw console.error("THREE.WebGLRenderer: "+L.message),L}let m1,f1,d1,N1,M1,S1,X1,$1,Y1,t2,s2,V1,n2,W1,O,I,l1,b1,A1,O1,H1,W,o1,P1;function L1(){m1=new gw(Z),f1=new uw(Z,m1,o),m1.init(f1),W=new qC(Z,m1,f1),d1=new XC(Z,m1,f1),N1=new yw,M1=new kC,S1=new QC(Z,m1,d1,M1,f1,W,N1),X1=new dw(m),$1=new mw(m),Y1=new DS(Z,f1),o1=new sw(Z,m1,Y1,f1),t2=new _w(Z,Y1,N1,o1),s2=new Mw(Z,t2,Y1,N1),A1=new Sw(Z,f1,S1),I=new cw(M1),V1=new zC(m,X1,$1,m1,f1,o1,I),n2=new iT(m,M1),W1=new UC,O=new WC(m1,f1),b1=new rw(m,X1,d1,s2,d,r),l1=new ZC(m,s2,f1),P1=new oT(Z,N1,f1,d1),O1=new lw(Z,m1,N1,f1),H1=new vw(Z,m1,N1,f1),N1.programs=V1.programs,m.capabilities=f1,m.extensions=m1,m.properties=M1,m.renderLists=W1,m.shadowMap=l1,m.state=d1,m.info=N1}L1();const k1=new nT(m,Z);this.xr=k1,this.getContext=function(){return Z},this.getContextAttributes=function(){return Z.getContextAttributes()},this.forceContextLoss=function(){const L=m1.get("WEBGL_lose_context");L&&L.loseContext()},this.forceContextRestore=function(){const L=m1.get("WEBGL_lose_context");L&&L.restoreContext()},this.getPixelRatio=function(){return $},this.setPixelRatio=function(L){L!==void 0&&($=L,this.setSize(E,k,!1))},this.getSize=function(L){return L.set(E,k)},this.setSize=function(L,r1,h1){if(k1.isPresenting){console.warn("THREE.WebGLRenderer: Can't change size while VR device is presenting.");return}E=L,k=r1,e.width=Math.floor(L*$),e.height=Math.floor(r1*$),h1!==!1&&(e.style.width=L+"px",e.style.height=r1+"px"),this.setViewport(0,0,L,r1)},this.getDrawingBufferSize=function(L){return L.set(E*$,k*$).floor()},this.setDrawingBufferSize=function(L,r1,h1){E=L,k=r1,$=h1,e.width=Math.floor(L*h1),e.height=Math.floor(r1*h1),this.setViewport(0,0,L,r1)},this.getCurrentViewport=function(L){return L.copy(S)},this.getViewport=function(L){return L.copy(R)},this.setViewport=function(L,r1,h1,a1){L.isVector4?R.set(L.x,L.y,L.z,L.w):R.set(L,r1,h1,a1),d1.viewport(S.copy(R).multiplyScalar($).floor())},this.getScissor=function(L){return L.copy(U)},this.setScissor=function(L,r1,h1,a1){L.isVector4?U.set(L.x,L.y,L.z,L.w):U.set(L,r1,h1,a1),d1.scissor(D.copy(U).multiplyScalar($).floor())},this.getScissorTest=function(){return H},this.setScissorTest=function(L){d1.setScissorTest(H=L)},this.setOpaqueSort=function(L){X=L},this.setTransparentSort=function(L){F=L},this.getClearColor=function(L){return L.copy(b1.getClearColor())},this.setClearColor=function(){b1.setClearColor.apply(b1,arguments)},this.getClearAlpha=function(){return b1.getClearAlpha()},this.setClearAlpha=function(){b1.setClearAlpha.apply(b1,arguments)},this.clear=function(L=!0,r1=!0,h1=!0){let a1=0;L&&(a1|=16384),r1&&(a1|=256),h1&&(a1|=1024),Z.clear(a1)},this.clearColor=function(){this.clear(!0,!1,!1)},this.clearDepth=function(){this.clear(!1,!0,!1)},this.clearStencil=function(){this.clear(!1,!1,!0)},this.dispose=function(){e.removeEventListener("webglcontextlost",j1,!1),e.removeEventListener("webglcontextrestored",i2,!1),e.removeEventListener("webglcontextcreationerror",m2,!1),W1.dispose(),O.dispose(),M1.dispose(),X1.dispose(),$1.dispose(),s2.dispose(),o1.dispose(),P1.dispose(),V1.dispose(),k1.dispose(),k1.removeEventListener("sessionstart",q1),k1.removeEventListener("sessionend",T2),G&&(G.dispose(),G=null),B2.stop()};function j1(L){L.preventDefault(),console.log("THREE.WebGLRenderer: Context Lost."),v=!0}function i2(){console.log("THREE.WebGLRenderer: Context Restored."),v=!1;const L=N1.autoReset,r1=l1.enabled,h1=l1.autoUpdate,a1=l1.needsUpdate,g1=l1.type;L1(),N1.autoReset=L,l1.enabled=r1,l1.autoUpdate=h1,l1.needsUpdate=a1,l1.type=g1}function m2(L){console.error("THREE.WebGLRenderer: A WebGL context could not be created. Reason: ",L.statusMessage)}function K(L){const r1=L.target;r1.removeEventListener("dispose",K),z1(r1)}function z1(L){C1(L),M1.remove(L)}function C1(L){const r1=M1.get(L).programs;r1!==void 0&&(r1.forEach(function(h1){V1.releaseProgram(h1)}),L.isShaderMaterial&&V1.releaseShaderCache(L))}this.renderBufferDirect=function(L,r1,h1,a1,g1,Z1){r1===null&&(r1=s1);const o2=g1.isMesh&&g1.matrixWorld.determinant()<0,l2=ql(L,r1,h1,a1,g1);d1.setMaterial(a1,o2);let r2=h1.index;const y2=h1.attributes.position;if(r2===null){if(y2===void 0||y2.count===0)return}else if(r2.count===0)return;let h2=1;a1.wireframe===!0&&(r2=t2.getWireframeAttribute(h1),h2=2),o1.setup(g1,a1,l2,h1,r2);let p2,z2=O1;r2!==null&&(p2=Y1.get(r2),z2=H1,z2.setIndex(p2));const m0=r2!==null?r2.count:y2.count,J0=h1.drawRange.start*h2,Z0=h1.drawRange.count*h2,c4=Z1!==null?Z1.start*h2:0,v2=Z1!==null?Z1.count*h2:1/0,X0=Math.max(J0,c4),W2=Math.min(m0,J0+Z0,c4+v2)-1,F3=Math.max(0,W2-X0+1);if(F3!==0){if(g1.isMesh)a1.wireframe===!0?(d1.setLineWidth(a1.wireframeLinewidth*q()),z2.setMode(1)):z2.setMode(4);else if(g1.isLine){let V4=a1.linewidth;V4===void 0&&(V4=1),d1.setLineWidth(V4*q()),g1.isLineSegments?z2.setMode(1):g1.isLineLoop?z2.setMode(2):z2.setMode(3)}else g1.isPoints?z2.setMode(0):g1.isSprite&&z2.setMode(4);if(g1.isInstancedMesh)z2.renderInstances(X0,F3,g1.count);else if(h1.isInstancedBufferGeometry){const V4=Math.min(h1.instanceCount,h1._maxInstanceCount);z2.renderInstances(X0,F3,V4)}else z2.render(X0,F3)}},this.compile=function(L,r1){function h1(a1,g1,Z1){a1.transparent===!0&&a1.side===m4?(a1.side=X3,a1.needsUpdate=!0,j5(a1,g1,Z1),a1.side=z9,a1.needsUpdate=!0,j5(a1,g1,Z1),a1.side=m4):j5(a1,g1,Z1)}p=O.get(L),p.init(),y.push(p),L.traverseVisible(function(a1){a1.isLight&&a1.layers.test(r1.layers)&&(p.pushLight(a1),a1.castShadow&&p.pushShadow(a1))}),p.setupLights(m.physicallyCorrectLights),L.traverse(function(a1){const g1=a1.material;if(g1)if(Array.isArray(g1))for(let Z1=0;Z1<g1.length;Z1++){const o2=g1[Z1];h1(o2,L,a1)}else h1(g1,L,a1)}),y.pop(),p=null};let _1=null;function D1(L){_1&&_1(L)}function q1(){B2.stop()}function T2(){B2.start()}const B2=new ms;B2.setAnimationLoop(D1),typeof self!="undefined"&&B2.setContext(self),this.setAnimationLoop=function(L){_1=L,k1.setAnimationLoop(L),L===null?B2.stop():B2.start()},k1.addEventListener("sessionstart",q1),k1.addEventListener("sessionend",T2),this.render=function(L,r1){if(r1!==void 0&&r1.isCamera!==!0){console.error("THREE.WebGLRenderer.render: camera is not an instance of THREE.Camera.");return}if(v===!0)return;L.matrixWorldAutoUpdate===!0&&L.updateMatrixWorld(),r1.parent===null&&r1.matrixWorldAutoUpdate===!0&&r1.updateMatrixWorld(),k1.enabled===!0&&k1.isPresenting===!0&&(k1.cameraAutoUpdate===!0&&k1.updateCamera(r1),r1=k1.getCamera()),L.isScene===!0&&L.onBeforeRender(m,L,r1,w),p=O.get(L,y.length),p.init(),y.push(p),t1.multiplyMatrices(r1.projectionMatrix,r1.matrixWorldInverse),V.setFromProjectionMatrix(t1),z=this.localClippingEnabled,N=I.init(this.clippingPlanes,z,r1),h=W1.get(L,g.length),h.init(),g.push(h),G4(L,r1,0,m.sortObjects),h.finish(),m.sortObjects===!0&&h.sort(X,F),N===!0&&I.beginShadows();const h1=p.state.shadowsArray;if(l1.render(h1,L,r1),N===!0&&I.endShadows(),this.info.autoReset===!0&&this.info.reset(),b1.render(h,L),p.setupLights(m.physicallyCorrectLights),r1.isArrayCamera){const a1=r1.cameras;for(let g1=0,Z1=a1.length;g1<Z1;g1++){const o2=a1[g1];L2(h,L,o2,o2.viewport)}}else L2(h,L,r1);w!==null&&(S1.updateMultisampleRenderTarget(w),S1.updateRenderTargetMipmap(w)),L.isScene===!0&&L.onAfterRender(m,L,r1),o1.resetDefaultState(),M=-1,A=null,y.pop(),y.length>0?p=y[y.length-1]:p=null,g.pop(),g.length>0?h=g[g.length-1]:h=null};function G4(L,r1,h1,a1){if(L.visible===!1)return;if(L.layers.test(r1.layers)){if(L.isGroup)h1=L.renderOrder;else if(L.isLOD)L.autoUpdate===!0&&L.update(r1);else if(L.isLight)p.pushLight(L),L.castShadow&&p.pushShadow(L);else if(L.isSprite){if(!L.frustumCulled||V.intersectsSprite(L)){a1&&u1.setFromMatrixPosition(L.matrixWorld).applyMatrix4(t1);const o2=s2.update(L),l2=L.material;l2.visible&&h.push(L,o2,l2,h1,u1.z,null)}}else if((L.isMesh||L.isLine||L.isPoints)&&(L.isSkinnedMesh&&L.skeleton.frame!==N1.render.frame&&(L.skeleton.update(),L.skeleton.frame=N1.render.frame),!L.frustumCulled||V.intersectsObject(L))){a1&&u1.setFromMatrixPosition(L.matrixWorld).applyMatrix4(t1);const o2=s2.update(L),l2=L.material;if(Array.isArray(l2)){const r2=o2.groups;for(let y2=0,h2=r2.length;y2<h2;y2++){const p2=r2[y2],z2=l2[p2.materialIndex];z2&&z2.visible&&h.push(L,o2,z2,h1,u1.z,p2)}}else l2.visible&&h.push(L,o2,l2,h1,u1.z,null)}}const Z1=L.children;for(let o2=0,l2=Z1.length;o2<l2;o2++)G4(Z1[o2],r1,h1,a1)}function L2(L,r1,h1,a1){const g1=L.opaque,Z1=L.transmissive,o2=L.transparent;p.setupLightsView(h1),Z1.length>0&&S4(g1,r1,h1),a1&&d1.viewport(S.copy(a1)),g1.length>0&&U3(g1,r1,h1),Z1.length>0&&U3(Z1,r1,h1),o2.length>0&&U3(o2,r1,h1),d1.buffers.depth.setTest(!0),d1.buffers.depth.setMask(!0),d1.buffers.color.setMask(!0),d1.setPolygonOffset(!1)}function S4(L,r1,h1){const a1=f1.isWebGL2;G===null&&(G=new G0(1,1,{generateMipmaps:!0,type:m1.has("EXT_color_buffer_half_float")?S5:F0,minFilter:i6,samples:a1&&a===!0?4:0})),m.getDrawingBufferSize(e1),a1?G.setSize(e1.x,e1.y):G.setSize(Se(e1.x),Se(e1.y));const g1=m.getRenderTarget();m.setRenderTarget(G),m.clear();const Z1=m.toneMapping;m.toneMapping=z4,U3(L,r1,h1),m.toneMapping=Z1,S1.updateMultisampleRenderTarget(G),S1.updateRenderTargetMipmap(G),m.setRenderTarget(g1)}function U3(L,r1,h1){const a1=r1.isScene===!0?r1.overrideMaterial:null;for(let g1=0,Z1=L.length;g1<Z1;g1++){const o2=L[g1],l2=o2.object,r2=o2.geometry,y2=a1===null?o2.material:a1,h2=o2.group;l2.layers.test(h1.layers)&&Ql(l2,r1,h1,r2,y2,h2)}}function Ql(L,r1,h1,a1,g1,Z1){L.onBeforeRender(m,r1,h1,a1,g1,Z1),L.modelViewMatrix.multiplyMatrices(h1.matrixWorldInverse,L.matrixWorld),L.normalMatrix.getNormalMatrix(L.modelViewMatrix),g1.onBeforeRender(m,r1,h1,a1,L,Z1),g1.transparent===!0&&g1.side===m4?(g1.side=X3,g1.needsUpdate=!0,m.renderBufferDirect(h1,r1,a1,g1,L,Z1),g1.side=z9,g1.needsUpdate=!0,m.renderBufferDirect(h1,r1,a1,g1,L,Z1),g1.side=m4):m.renderBufferDirect(h1,r1,a1,g1,L,Z1),L.onAfterRender(m,r1,h1,a1,g1,Z1)}function j5(L,r1,h1){r1.isScene!==!0&&(r1=s1);const a1=M1.get(L),g1=p.state.lights,Z1=p.state.shadowsArray,o2=g1.state.version,l2=V1.getParameters(L,g1.state,Z1,r1,h1),r2=V1.getProgramCacheKey(l2);let y2=a1.programs;a1.environment=L.isMeshStandardMaterial?r1.environment:null,a1.fog=r1.fog,a1.envMap=(L.isMeshStandardMaterial?$1:X1).get(L.envMap||a1.environment),y2===void 0&&(L.addEventListener("dispose",K),y2=new Map,a1.programs=y2);let h2=y2.get(r2);if(h2!==void 0){if(a1.currentProgram===h2&&a1.lightsStateVersion===o2)return Ln(L,l2),h2}else l2.uniforms=V1.getUniforms(L),L.onBuild(h1,l2,m),L.onBeforeCompile(l2,m),h2=V1.acquireProgram(l2,r2),y2.set(r2,h2),a1.uniforms=l2.uniforms;const p2=a1.uniforms;(!L.isShaderMaterial&&!L.isRawShaderMaterial||L.clipping===!0)&&(p2.clippingPlanes=I.uniform),Ln(L,l2),a1.needsLights=eu(L),a1.lightsStateVersion=o2,a1.needsLights&&(p2.ambientLightColor.value=g1.state.ambient,p2.lightProbe.value=g1.state.probe,p2.directionalLights.value=g1.state.directional,p2.directionalLightShadows.value=g1.state.directionalShadow,p2.spotLights.value=g1.state.spot,p2.spotLightShadows.value=g1.state.spotShadow,p2.rectAreaLights.value=g1.state.rectArea,p2.ltc_1.value=g1.state.rectAreaLTC1,p2.ltc_2.value=g1.state.rectAreaLTC2,p2.pointLights.value=g1.state.point,p2.pointLightShadows.value=g1.state.pointShadow,p2.hemisphereLights.value=g1.state.hemi,p2.directionalShadowMap.value=g1.state.directionalShadowMap,p2.directionalShadowMatrix.value=g1.state.directionalShadowMatrix,p2.spotShadowMap.value=g1.state.spotShadowMap,p2.spotLightMatrix.value=g1.state.spotLightMatrix,p2.spotLightMap.value=g1.state.spotLightMap,p2.pointShadowMap.value=g1.state.pointShadowMap,p2.pointShadowMatrix.value=g1.state.pointShadowMatrix);const z2=h2.getUniforms(),m0=D8.seqWithValue(z2.seq,p2);return a1.currentProgram=h2,a1.uniformsList=m0,h2}function Ln(L,r1){const h1=M1.get(L);h1.outputEncoding=r1.outputEncoding,h1.instancing=r1.instancing,h1.skinning=r1.skinning,h1.morphTargets=r1.morphTargets,h1.morphNormals=r1.morphNormals,h1.morphColors=r1.morphColors,h1.morphTargetsCount=r1.morphTargetsCount,h1.numClippingPlanes=r1.numClippingPlanes,h1.numIntersection=r1.numClipIntersection,h1.vertexAlphas=r1.vertexAlphas,h1.vertexTangents=r1.vertexTangents,h1.toneMapping=r1.toneMapping}function ql(L,r1,h1,a1,g1){r1.isScene!==!0&&(r1=s1),S1.resetTextureUnits();const Z1=r1.fog,o2=a1.isMeshStandardMaterial?r1.environment:null,l2=w===null?m.outputEncoding:w.isXRRenderTarget===!0?w.texture.encoding:B0,r2=(a1.isMeshStandardMaterial?$1:X1).get(a1.envMap||o2),y2=a1.vertexColors===!0&&!!h1.attributes.color&&h1.attributes.color.itemSize===4,h2=!!a1.normalMap&&!!h1.attributes.tangent,p2=!!h1.morphAttributes.position,z2=!!h1.morphAttributes.normal,m0=!!h1.morphAttributes.color,J0=a1.toneMapped?m.toneMapping:z4,Z0=h1.morphAttributes.position||h1.morphAttributes.normal||h1.morphAttributes.color,c4=Z0!==void 0?Z0.length:0,v2=M1.get(a1),X0=p.state.lights;if(N===!0&&(z===!0||L!==A)){const D3=L===A&&a1.id===M;I.setState(a1,L,D3)}let W2=!1;a1.version===v2.__version?(v2.needsLights&&v2.lightsStateVersion!==X0.state.version||v2.outputEncoding!==l2||g1.isInstancedMesh&&v2.instancing===!1||!g1.isInstancedMesh&&v2.instancing===!0||g1.isSkinnedMesh&&v2.skinning===!1||!g1.isSkinnedMesh&&v2.skinning===!0||v2.envMap!==r2||a1.fog===!0&&v2.fog!==Z1||v2.numClippingPlanes!==void 0&&(v2.numClippingPlanes!==I.numPlanes||v2.numIntersection!==I.numIntersection)||v2.vertexAlphas!==y2||v2.vertexTangents!==h2||v2.morphTargets!==p2||v2.morphNormals!==z2||v2.morphColors!==m0||v2.toneMapping!==J0||f1.isWebGL2===!0&&v2.morphTargetsCount!==c4)&&(W2=!0):(W2=!0,v2.__version=a1.version);let F3=v2.currentProgram;W2===!0&&(F3=j5(a1,r1,g1));let V4=!1,X9=!1,f6=!1;const v3=F3.getUniforms(),g0=v2.uniforms;if(d1.useProgram(F3.program)&&(V4=!0,X9=!0,f6=!0),a1.id!==M&&(M=a1.id,X9=!0),V4||A!==L){if(v3.setValue(Z,"projectionMatrix",L.projectionMatrix),f1.logarithmicDepthBuffer&&v3.setValue(Z,"logDepthBufFC",2/(Math.log(L.far+1)/Math.LN2)),A!==L&&(A=L,X9=!0,f6=!0),a1.isShaderMaterial||a1.isMeshPhongMaterial||a1.isMeshToonMaterial||a1.isMeshStandardMaterial||a1.envMap){const D3=v3.map.cameraPosition;D3!==void 0&&D3.setValue(Z,u1.setFromMatrixPosition(L.matrixWorld))}(a1.isMeshPhongMaterial||a1.isMeshToonMaterial||a1.isMeshLambertMaterial||a1.isMeshBasicMaterial||a1.isMeshStandardMaterial||a1.isShaderMaterial)&&v3.setValue(Z,"isOrthographic",L.isOrthographicCamera===!0),(a1.isMeshPhongMaterial||a1.isMeshToonMaterial||a1.isMeshLambertMaterial||a1.isMeshBasicMaterial||a1.isMeshStandardMaterial||a1.isShaderMaterial||a1.isShadowMaterial||g1.isSkinnedMesh)&&v3.setValue(Z,"viewMatrix",L.matrixWorldInverse)}if(g1.isSkinnedMesh){v3.setOptional(Z,g1,"bindMatrix"),v3.setOptional(Z,g1,"bindMatrixInverse");const D3=g1.skeleton;D3&&(f1.floatVertexTextures?(D3.boneTexture===null&&D3.computeBoneTexture(),v3.setValue(Z,"boneTexture",D3.boneTexture,S1),v3.setValue(Z,"boneTextureSize",D3.boneTextureSize)):console.warn("THREE.WebGLRenderer: SkinnedMesh can only be used with WebGL 2. With WebGL 1 OES_texture_float and vertex textures support is required."))}const h6=h1.morphAttributes;if((h6.position!==void 0||h6.normal!==void 0||h6.color!==void 0&&f1.isWebGL2===!0)&&A1.update(g1,h1,a1,F3),(X9||v2.receiveShadow!==g1.receiveShadow)&&(v2.receiveShadow=g1.receiveShadow,v3.setValue(Z,"receiveShadow",g1.receiveShadow)),a1.isMeshGouraudMaterial&&a1.envMap!==null&&(g0.envMap.value=r2,g0.flipEnvMap.value=r2.isCubeTexture&&r2.isRenderTargetTexture===!1?-1:1),X9&&(v3.setValue(Z,"toneMappingExposure",m.toneMappingExposure),v2.needsLights&&Kl(g0,f6),Z1&&a1.fog===!0&&n2.refreshFogUniforms(g0,Z1),n2.refreshMaterialUniforms(g0,a1,$,k,G),D8.upload(Z,v2.uniformsList,g0,S1)),a1.isShaderMaterial&&a1.uniformsNeedUpdate===!0&&(D8.upload(Z,v2.uniformsList,g0,S1),a1.uniformsNeedUpdate=!1),a1.isSpriteMaterial&&v3.setValue(Z,"center",g1.center),v3.setValue(Z,"modelViewMatrix",g1.modelViewMatrix),v3.setValue(Z,"normalMatrix",g1.normalMatrix),v3.setValue(Z,"modelMatrix",g1.matrixWorld),a1.isShaderMaterial||a1.isRawShaderMaterial){const D3=a1.uniformsGroups;for(let p6=0,tu=D3.length;p6<tu;p6++)if(f1.isWebGL2){const zn=D3[p6];P1.update(zn,F3),P1.bind(zn,F3)}else console.warn("THREE.WebGLRenderer: Uniform Buffer Objects can only be used with WebGL 2.")}return F3}function Kl(L,r1){L.ambientLightColor.needsUpdate=r1,L.lightProbe.needsUpdate=r1,L.directionalLights.needsUpdate=r1,L.directionalLightShadows.needsUpdate=r1,L.pointLights.needsUpdate=r1,L.pointLightShadows.needsUpdate=r1,L.spotLights.needsUpdate=r1,L.spotLightShadows.needsUpdate=r1,L.rectAreaLights.needsUpdate=r1,L.hemisphereLights.needsUpdate=r1}function eu(L){return L.isMeshLambertMaterial||L.isMeshToonMaterial||L.isMeshPhongMaterial||L.isMeshStandardMaterial||L.isShadowMaterial||L.isShaderMaterial&&L.lights===!0}this.getActiveCubeFace=function(){return b},this.getActiveMipmapLevel=function(){return x},this.getRenderTarget=function(){return w},this.setRenderTargetTextures=function(L,r1,h1){M1.get(L.texture).__webglTexture=r1,M1.get(L.depthTexture).__webglTexture=h1;const a1=M1.get(L);a1.__hasExternalTextures=!0,a1.__hasExternalTextures&&(a1.__autoAllocateDepthBuffer=h1===void 0,a1.__autoAllocateDepthBuffer||m1.has("WEBGL_multisampled_render_to_texture")===!0&&(console.warn("THREE.WebGLRenderer: Render-to-texture extension was disabled because an external texture was provided"),a1.__useRenderToTexture=!1))},this.setRenderTargetFramebuffer=function(L,r1){const h1=M1.get(L);h1.__webglFramebuffer=r1,h1.__useDefaultFramebuffer=r1===void 0},this.setRenderTarget=function(L,r1=0,h1=0){w=L,b=r1,x=h1;let a1=!0;if(L){const r2=M1.get(L);r2.__useDefaultFramebuffer!==void 0?(d1.bindFramebuffer(36160,null),a1=!1):r2.__webglFramebuffer===void 0?S1.setupRenderTarget(L):r2.__hasExternalTextures&&S1.rebindTextures(L,M1.get(L.texture).__webglTexture,M1.get(L.depthTexture).__webglTexture)}let g1=null,Z1=!1,o2=!1;if(L){const r2=L.texture;(r2.isData3DTexture||r2.isDataArrayTexture)&&(o2=!0);const y2=M1.get(L).__webglFramebuffer;L.isWebGLCubeRenderTarget?(g1=y2[r1],Z1=!0):f1.isWebGL2&&L.samples>0&&S1.useMultisampledRTT(L)===!1?g1=M1.get(L).__webglMultisampledFramebuffer:g1=y2,S.copy(L.viewport),D.copy(L.scissor),C=L.scissorTest}else S.copy(R).multiplyScalar($).floor(),D.copy(U).multiplyScalar($).floor(),C=H;if(d1.bindFramebuffer(36160,g1)&&f1.drawBuffers&&a1&&d1.drawBuffers(L,g1),d1.viewport(S),d1.scissor(D),d1.setScissorTest(C),Z1){const r2=M1.get(L.texture);Z.framebufferTexture2D(36160,36064,34069+r1,r2.__webglTexture,h1)}else if(o2){const r2=M1.get(L.texture),y2=r1||0;Z.framebufferTextureLayer(36160,36064,r2.__webglTexture,h1||0,y2)}M=-1},this.readRenderTargetPixels=function(L,r1,h1,a1,g1,Z1,o2){if(!(L&&L.isWebGLRenderTarget)){console.error("THREE.WebGLRenderer.readRenderTargetPixels: renderTarget is not THREE.WebGLRenderTarget.");return}let l2=M1.get(L).__webglFramebuffer;if(L.isWebGLCubeRenderTarget&&o2!==void 0&&(l2=l2[o2]),l2){d1.bindFramebuffer(36160,l2);try{const r2=L.texture,y2=r2.format,h2=r2.type;if(y2!==g4&&W.convert(y2)!==Z.getParameter(35739)){console.error("THREE.WebGLRenderer.readRenderTargetPixels: renderTarget is not in RGBA or implementation defined format.");return}const p2=h2===S5&&(m1.has("EXT_color_buffer_half_float")||f1.isWebGL2&&m1.has("EXT_color_buffer_float"));if(h2!==F0&&W.convert(h2)!==Z.getParameter(35738)&&!(h2===E0&&(f1.isWebGL2||m1.has("OES_texture_float")||m1.has("WEBGL_color_buffer_float")))&&!p2){console.error("THREE.WebGLRenderer.readRenderTargetPixels: renderTarget is not in UnsignedByteType or implementation defined type.");return}r1>=0&&r1<=L.width-a1&&h1>=0&&h1<=L.height-g1&&Z.readPixels(r1,h1,a1,g1,W.convert(y2),W.convert(h2),Z1)}finally{const r2=w!==null?M1.get(w).__webglFramebuffer:null;d1.bindFramebuffer(36160,r2)}}},this.copyFramebufferToTexture=function(L,r1,h1=0){const a1=Math.pow(2,-h1),g1=Math.floor(r1.image.width*a1),Z1=Math.floor(r1.image.height*a1);S1.setTexture2D(r1,0),Z.copyTexSubImage2D(3553,h1,0,0,L.x,L.y,g1,Z1),d1.unbindTexture()},this.copyTextureToTexture=function(L,r1,h1,a1=0){const g1=r1.image.width,Z1=r1.image.height,o2=W.convert(h1.format),l2=W.convert(h1.type);S1.setTexture2D(h1,0),Z.pixelStorei(37440,h1.flipY),Z.pixelStorei(37441,h1.premultiplyAlpha),Z.pixelStorei(3317,h1.unpackAlignment),r1.isDataTexture?Z.texSubImage2D(3553,a1,L.x,L.y,g1,Z1,o2,l2,r1.image.data):r1.isCompressedTexture?Z.compressedTexSubImage2D(3553,a1,L.x,L.y,r1.mipmaps[0].width,r1.mipmaps[0].height,o2,r1.mipmaps[0].data):Z.texSubImage2D(3553,a1,L.x,L.y,o2,l2,r1.image),a1===0&&h1.generateMipmaps&&Z.generateMipmap(3553),d1.unbindTexture()},this.copyTextureToTexture3D=function(L,r1,h1,a1,g1=0){if(m.isWebGL1Renderer){console.warn("THREE.WebGLRenderer.copyTextureToTexture3D: can only be used with WebGL2.");return}const Z1=L.max.x-L.min.x+1,o2=L.max.y-L.min.y+1,l2=L.max.z-L.min.z+1,r2=W.convert(a1.format),y2=W.convert(a1.type);let h2;if(a1.isData3DTexture)S1.setTexture3D(a1,0),h2=32879;else if(a1.isDataArrayTexture)S1.setTexture2DArray(a1,0),h2=35866;else{console.warn("THREE.WebGLRenderer.copyTextureToTexture3D: only supports THREE.DataTexture3D and THREE.DataTexture2DArray.");return}Z.pixelStorei(37440,a1.flipY),Z.pixelStorei(37441,a1.premultiplyAlpha),Z.pixelStorei(3317,a1.unpackAlignment);const p2=Z.getParameter(3314),z2=Z.getParameter(32878),m0=Z.getParameter(3316),J0=Z.getParameter(3315),Z0=Z.getParameter(32877),c4=h1.isCompressedTexture?h1.mipmaps[0]:h1.image;Z.pixelStorei(3314,c4.width),Z.pixelStorei(32878,c4.height),Z.pixelStorei(3316,L.min.x),Z.pixelStorei(3315,L.min.y),Z.pixelStorei(32877,L.min.z),h1.isDataTexture||h1.isData3DTexture?Z.texSubImage3D(h2,g1,r1.x,r1.y,r1.z,Z1,o2,l2,r2,y2,c4.data):h1.isCompressedTexture?(console.warn("THREE.WebGLRenderer.copyTextureToTexture3D: untested support for compressed srcTexture."),Z.compressedTexSubImage3D(h2,g1,r1.x,r1.y,r1.z,Z1,o2,l2,r2,c4.data)):Z.texSubImage3D(h2,g1,r1.x,r1.y,r1.z,Z1,o2,l2,r2,y2,c4),Z.pixelStorei(3314,p2),Z.pixelStorei(32878,z2),Z.pixelStorei(3316,m0),Z.pixelStorei(3315,J0),Z.pixelStorei(32877,Z0),g1===0&&a1.generateMipmaps&&Z.generateMipmap(h2),d1.unbindTexture()},this.initTexture=function(L){L.isCubeTexture?S1.setTextureCube(L,0):L.isData3DTexture?S1.setTexture3D(L,0):L.isDataArrayTexture?S1.setTexture2DArray(L,0):S1.setTexture2D(L,0),d1.unbindTexture()},this.resetState=function(){b=0,x=0,w=null,d1.reset(),o1.reset()},typeof __THREE_DEVTOOLS__!="undefined"&&__THREE_DEVTOOLS__.dispatchEvent(new CustomEvent("observe",{detail:this}))}class rT extends bs{}rT.prototype.isWebGL1Renderer=!0;class sT extends h3{constructor(){super(),this.isScene=!0,this.type="Scene",this.background=null,this.environment=null,this.fog=null,this.overrideMaterial=null,typeof __THREE_DEVTOOLS__!="undefined"&&__THREE_DEVTOOLS__.dispatchEvent(new CustomEvent("observe",{detail:this}))}copy(e,t){return super.copy(e,t),e.background!==null&&(this.background=e.background.clone()),e.environment!==null&&(this.environment=e.environment.clone()),e.fog!==null&&(this.fog=e.fog.clone()),e.overrideMaterial!==null&&(this.overrideMaterial=e.overrideMaterial.clone()),this.matrixAutoUpdate=e.matrixAutoUpdate,this}toJSON(e){const t=super.toJSON(e);return this.fog!==null&&(t.object.fog=this.fog.toJSON()),t}get autoUpdate(){return console.warn("THREE.Scene: autoUpdate was renamed to matrixWorldAutoUpdate in r144."),this.matrixWorldAutoUpdate}set autoUpdate(e){console.warn("THREE.Scene: autoUpdate was renamed to matrixWorldAutoUpdate in r144."),this.matrixWorldAutoUpdate=e}}class lT{constructor(e,t){this.isInterleavedBuffer=!0,this.array=e,this.stride=t,this.count=e!==void 0?e.length/t:0,this.usage=be,this.updateRange={offset:0,count:-1},this.version=0,this.uuid=o0()}onUploadCallback(){}set needsUpdate(e){e===!0&&this.version++}setUsage(e){return this.usage=e,this}copy(e){return this.array=new e.array.constructor(e.array),this.count=e.count,this.stride=e.stride,this.usage=e.usage,this}copyAt(e,t,n){e*=this.stride,n*=t.stride;for(let i=0,a=this.stride;i<a;i++)this.array[e+i]=t.array[n+i];return this}set(e,t=0){return this.array.set(e,t),this}clone(e){e.arrayBuffers===void 0&&(e.arrayBuffers={}),this.array.buffer._uuid===void 0&&(this.array.buffer._uuid=o0()),e.arrayBuffers[this.array.buffer._uuid]===void 0&&(e.arrayBuffers[this.array.buffer._uuid]=this.array.slice(0).buffer);const t=new this.array.constructor(e.arrayBuffers[this.array.buffer._uuid]),n=new this.constructor(t,this.stride);return n.setUsage(this.usage),n}onUpload(e){return this.onUploadCallback=e,this}toJSON(e){return e.arrayBuffers===void 0&&(e.arrayBuffers={}),this.array.buffer._uuid===void 0&&(this.array.buffer._uuid=o0()),e.arrayBuffers[this.array.buffer._uuid]===void 0&&(e.arrayBuffers[this.array.buffer._uuid]=Array.from(new Uint32Array(this.array.buffer))),{uuid:this.uuid,buffer:this.array.buffer._uuid,type:this.array.constructor.name,stride:this.stride}}}const y3=new Y;class V8{constructor(e,t,n,i=!1){this.isInterleavedBufferAttribute=!0,this.name="",this.data=e,this.itemSize=t,this.offset=n,this.normalized=i===!0}get count(){return this.data.count}get array(){return this.data.array}set needsUpdate(e){this.data.needsUpdate=e}applyMatrix4(e){for(let t=0,n=this.data.count;t<n;t++)y3.fromBufferAttribute(this,t),y3.applyMatrix4(e),this.setXYZ(t,y3.x,y3.y,y3.z);return this}applyNormalMatrix(e){for(let t=0,n=this.count;t<n;t++)y3.fromBufferAttribute(this,t),y3.applyNormalMatrix(e),this.setXYZ(t,y3.x,y3.y,y3.z);return this}transformDirection(e){for(let t=0,n=this.count;t<n;t++)y3.fromBufferAttribute(this,t),y3.transformDirection(e),this.setXYZ(t,y3.x,y3.y,y3.z);return this}setX(e,t){return this.normalized&&(t=C2(t,this.array)),this.data.array[e*this.data.stride+this.offset]=t,this}setY(e,t){return this.normalized&&(t=C2(t,this.array)),this.data.array[e*this.data.stride+this.offset+1]=t,this}setZ(e,t){return this.normalized&&(t=C2(t,this.array)),this.data.array[e*this.data.stride+this.offset+2]=t,this}setW(e,t){return this.normalized&&(t=C2(t,this.array)),this.data.array[e*this.data.stride+this.offset+3]=t,this}getX(e){let t=this.data.array[e*this.data.stride+this.offset];return this.normalized&&(t=K4(t,this.array)),t}getY(e){let t=this.data.array[e*this.data.stride+this.offset+1];return this.normalized&&(t=K4(t,this.array)),t}getZ(e){let t=this.data.array[e*this.data.stride+this.offset+2];return this.normalized&&(t=K4(t,this.array)),t}getW(e){let t=this.data.array[e*this.data.stride+this.offset+3];return this.normalized&&(t=K4(t,this.array)),t}setXY(e,t,n){return e=e*this.data.stride+this.offset,this.normalized&&(t=C2(t,this.array),n=C2(n,this.array)),this.data.array[e+0]=t,this.data.array[e+1]=n,this}setXYZ(e,t,n,i){return e=e*this.data.stride+this.offset,this.normalized&&(t=C2(t,this.array),n=C2(n,this.array),i=C2(i,this.array)),this.data.array[e+0]=t,this.data.array[e+1]=n,this.data.array[e+2]=i,this}setXYZW(e,t,n,i,a){return e=e*this.data.stride+this.offset,this.normalized&&(t=C2(t,this.array),n=C2(n,this.array),i=C2(i,this.array),a=C2(a,this.array)),this.data.array[e+0]=t,this.data.array[e+1]=n,this.data.array[e+2]=i,this.data.array[e+3]=a,this}clone(e){if(e===void 0){console.log("THREE.InterleavedBufferAttribute.clone(): Cloning an interleaved buffer attribute will deinterleave buffer data.");const t=[];for(let n=0;n<this.count;n++){const i=n*this.data.stride+this.offset;for(let a=0;a<this.itemSize;a++)t.push(this.data.array[i+a])}return new z3(new this.array.constructor(t),this.itemSize,this.normalized)}else return e.interleavedBuffers===void 0&&(e.interleavedBuffers={}),e.interleavedBuffers[this.data.uuid]===void 0&&(e.interleavedBuffers[this.data.uuid]=this.data.clone(e)),new V8(e.interleavedBuffers[this.data.uuid],this.itemSize,this.offset,this.normalized)}toJSON(e){if(e===void 0){console.log("THREE.InterleavedBufferAttribute.toJSON(): Serializing an interleaved buffer attribute will deinterleave buffer data.");const t=[];for(let n=0;n<this.count;n++){const i=n*this.data.stride+this.offset;for(let a=0;a<this.itemSize;a++)t.push(this.data.array[i+a])}return{itemSize:this.itemSize,type:this.array.constructor.name,array:t,normalized:this.normalized}}else return e.interleavedBuffers===void 0&&(e.interleavedBuffers={}),e.interleavedBuffers[this.data.uuid]===void 0&&(e.interleavedBuffers[this.data.uuid]=this.data.toJSON(e)),{isInterleavedBufferAttribute:!0,itemSize:this.itemSize,data:this.data.uuid,offset:this.offset,normalized:this.normalized}}}class xs extends Y0{constructor(e){super(),this.isSpriteMaterial=!0,this.type="SpriteMaterial",this.color=new _2(16777215),this.map=null,this.alphaMap=null,this.rotation=0,this.sizeAttenuation=!0,this.transparent=!0,this.fog=!0,this.setValues(e)}copy(e){return super.copy(e),this.color.copy(e.color),this.map=e.map,this.alphaMap=e.alphaMap,this.rotation=e.rotation,this.sizeAttenuation=e.sizeAttenuation,this.fog=e.fog,this}}let h9;const i5=new Y,p9=new Y,m9=new Y,g9=new G1,o5=new G1,Ss=new j2,_8=new Y,a5=new Y,v8=new Y,na=new G1,K6=new G1,ia=new G1;class uT extends h3{constructor(e){if(super(),this.isSprite=!0,this.type="Sprite",h9===void 0){h9=new E3;const t=new Float32Array([-.5,-.5,0,0,0,.5,-.5,0,1,0,.5,.5,0,1,1,-.5,.5,0,0,1]),n=new lT(t,5);h9.setIndex([0,1,2,0,2,3]),h9.setAttribute("position",new V8(n,3,0,!1)),h9.setAttribute("uv",new V8(n,2,3,!1))}this.geometry=h9,this.material=e!==void 0?e:new xs,this.center=new G1(.5,.5)}raycast(e,t){e.camera===null&&console.error('THREE.Sprite: "Raycaster.camera" needs to be set in order to raycast against sprites.'),p9.setFromMatrixScale(this.matrixWorld),Ss.copy(e.camera.matrixWorld),this.modelViewMatrix.multiplyMatrices(e.camera.matrixWorldInverse,this.matrixWorld),m9.setFromMatrixPosition(this.modelViewMatrix),e.camera.isPerspectiveCamera&&this.material.sizeAttenuation===!1&&p9.multiplyScalar(-m9.z);const n=this.material.rotation;let i,a;n!==0&&(a=Math.cos(n),i=Math.sin(n));const r=this.center;y8(_8.set(-.5,-.5,0),m9,r,p9,i,a),y8(a5.set(.5,-.5,0),m9,r,p9,i,a),y8(v8.set(.5,.5,0),m9,r,p9,i,a),na.set(0,0),K6.set(1,0),ia.set(1,1);let s=e.ray.intersectTriangle(_8,a5,v8,!1,i5);if(s===null&&(y8(a5.set(-.5,.5,0),m9,r,p9,i,a),K6.set(0,1),s=e.ray.intersectTriangle(_8,v8,a5,!1,i5),s===null))return;const u=e.ray.origin.distanceTo(i5);u<e.near||u>e.far||t.push({distance:u,point:i5.clone(),uv:h4.getUV(i5,_8,a5,v8,na,K6,ia,new G1),face:null,object:this})}copy(e,t){return super.copy(e,t),e.center!==void 0&&this.center.copy(e.center),this.material=e.material,this}}function y8(o,e,t,n,i,a){g9.subVectors(o,t).addScalar(.5).multiply(n),i!==void 0?(o5.x=a*g9.x-i*g9.y,o5.y=i*g9.x+a*g9.y):o5.copy(g9),o.copy(e),o.x+=o5.x,o.y+=o5.y,o.applyMatrix4(Ss)}class Ms extends Y0{constructor(e){super(),this.isLineBasicMaterial=!0,this.type="LineBasicMaterial",this.color=new _2(16777215),this.linewidth=1,this.linecap="round",this.linejoin="round",this.fog=!0,this.setValues(e)}copy(e){return super.copy(e),this.color.copy(e.color),this.linewidth=e.linewidth,this.linecap=e.linecap,this.linejoin=e.linejoin,this.fog=e.fog,this}}const oa=new Y,aa=new Y,ra=new j2,e7=new qt,b8=new N5;class cT extends h3{constructor(e=new E3,t=new Ms){super(),this.isLine=!0,this.type="Line",this.geometry=e,this.material=t,this.updateMorphTargets()}copy(e,t){return super.copy(e,t),this.material=e.material,this.geometry=e.geometry,this}computeLineDistances(){const e=this.geometry;if(e.index===null){const t=e.attributes.position,n=[0];for(let i=1,a=t.count;i<a;i++)oa.fromBufferAttribute(t,i-1),aa.fromBufferAttribute(t,i),n[i]=n[i-1],n[i]+=oa.distanceTo(aa);e.setAttribute("lineDistance",new M3(n,1))}else console.warn("THREE.Line.computeLineDistances(): Computation only possible with non-indexed BufferGeometry.");return this}raycast(e,t){const n=this.geometry,i=this.matrixWorld,a=e.params.Line.threshold,r=n.drawRange;if(n.boundingSphere===null&&n.computeBoundingSphere(),b8.copy(n.boundingSphere),b8.applyMatrix4(i),b8.radius+=a,e.ray.intersectsSphere(b8)===!1)return;ra.copy(i).invert(),e7.copy(e.ray).applyMatrix4(ra);const s=a/((this.scale.x+this.scale.y+this.scale.z)/3),u=s*s,c=new Y,d=new Y,h=new Y,p=new Y,g=this.isLineSegments?2:1,y=n.index,v=n.attributes.position;if(y!==null){const b=Math.max(0,r.start),x=Math.min(y.count,r.start+r.count);for(let w=b,M=x-1;w<M;w+=g){const A=y.getX(w),S=y.getX(w+1);if(c.fromBufferAttribute(v,A),d.fromBufferAttribute(v,S),e7.distanceSqToSegment(c,d,p,h)>u)continue;p.applyMatrix4(this.matrixWorld);const C=e.ray.origin.distanceTo(p);C<e.near||C>e.far||t.push({distance:C,point:h.clone().applyMatrix4(this.matrixWorld),index:w,face:null,faceIndex:null,object:this})}}else{const b=Math.max(0,r.start),x=Math.min(v.count,r.start+r.count);for(let w=b,M=x-1;w<M;w+=g){if(c.fromBufferAttribute(v,w),d.fromBufferAttribute(v,w+1),e7.distanceSqToSegment(c,d,p,h)>u)continue;p.applyMatrix4(this.matrixWorld);const S=e.ray.origin.distanceTo(p);S<e.near||S>e.far||t.push({distance:S,point:h.clone().applyMatrix4(this.matrixWorld),index:w,face:null,faceIndex:null,object:this})}}}updateMorphTargets(){const t=this.geometry.morphAttributes,n=Object.keys(t);if(n.length>0){const i=t[n[0]];if(i!==void 0){this.morphTargetInfluences=[],this.morphTargetDictionary={};for(let a=0,r=i.length;a<r;a++){const s=i[a].name||String(a);this.morphTargetInfluences.push(0),this.morphTargetDictionary[s]=a}}}}}class en extends Y0{constructor(e){super(),this.isPointsMaterial=!0,this.type="PointsMaterial",this.color=new _2(16777215),this.map=null,this.alphaMap=null,this.size=1,this.sizeAttenuation=!0,this.fog=!0,this.setValues(e)}copy(e){return super.copy(e),this.color.copy(e.color),this.map=e.map,this.alphaMap=e.alphaMap,this.size=e.size,this.sizeAttenuation=e.sizeAttenuation,this.fog=e.fog,this}}const sa=new j2,Ae=new qt,x8=new N5,S8=new Y;class As extends h3{constructor(e=new E3,t=new en){super(),this.isPoints=!0,this.type="Points",this.geometry=e,this.material=t,this.updateMorphTargets()}copy(e,t){return super.copy(e,t),this.material=e.material,this.geometry=e.geometry,this}raycast(e,t){const n=this.geometry,i=this.matrixWorld,a=e.params.Points.threshold,r=n.drawRange;if(n.boundingSphere===null&&n.computeBoundingSphere(),x8.copy(n.boundingSphere),x8.applyMatrix4(i),x8.radius+=a,e.ray.intersectsSphere(x8)===!1)return;sa.copy(i).invert(),Ae.copy(e.ray).applyMatrix4(sa);const s=a/((this.scale.x+this.scale.y+this.scale.z)/3),u=s*s,c=n.index,h=n.attributes.position;if(c!==null){const p=Math.max(0,r.start),g=Math.min(c.count,r.start+r.count);for(let y=p,m=g;y<m;y++){const v=c.getX(y);S8.fromBufferAttribute(h,v),la(S8,v,u,i,e,t,this)}}else{const p=Math.max(0,r.start),g=Math.min(h.count,r.start+r.count);for(let y=p,m=g;y<m;y++)S8.fromBufferAttribute(h,y),la(S8,y,u,i,e,t,this)}}updateMorphTargets(){const t=this.geometry.morphAttributes,n=Object.keys(t);if(n.length>0){const i=t[n[0]];if(i!==void 0){this.morphTargetInfluences=[],this.morphTargetDictionary={};for(let a=0,r=i.length;a<r;a++){const s=i[a].name||String(a);this.morphTargetInfluences.push(0),this.morphTargetDictionary[s]=a}}}}}function la(o,e,t,n,i,a,r){const s=Ae.distanceSqToPoint(o);if(s<t){const u=new Y;Ae.closestPointToPoint(o,u),u.applyMatrix4(n);const c=i.ray.origin.distanceTo(u);if(c<i.near||c>i.far)return;a.push({distance:c,distanceToRay:Math.sqrt(s),point:u,index:e,face:null,object:r})}}class B4{constructor(){this.type="Curve",this.arcLengthDivisions=200}getPoint(){return console.warn("THREE.Curve: .getPoint() not implemented."),null}getPointAt(e,t){const n=this.getUtoTmapping(e);return this.getPoint(n,t)}getPoints(e=5){const t=[];for(let n=0;n<=e;n++)t.push(this.getPoint(n/e));return t}getSpacedPoints(e=5){const t=[];for(let n=0;n<=e;n++)t.push(this.getPointAt(n/e));return t}getLength(){const e=this.getLengths();return e[e.length-1]}getLengths(e=this.arcLengthDivisions){if(this.cacheArcLengths&&this.cacheArcLengths.length===e+1&&!this.needsUpdate)return this.cacheArcLengths;this.needsUpdate=!1;const t=[];let n,i=this.getPoint(0),a=0;t.push(0);for(let r=1;r<=e;r++)n=this.getPoint(r/e),a+=n.distanceTo(i),t.push(a),i=n;return this.cacheArcLengths=t,t}updateArcLengths(){this.needsUpdate=!0,this.getLengths()}getUtoTmapping(e,t){const n=this.getLengths();let i=0;const a=n.length;let r;t?r=t:r=e*n[a-1];let s=0,u=a-1,c;for(;s<=u;)if(i=Math.floor(s+(u-s)/2),c=n[i]-r,c<0)s=i+1;else if(c>0)u=i-1;else{u=i;break}if(i=u,n[i]===r)return i/(a-1);const d=n[i],p=n[i+1]-d,g=(r-d)/p;return(i+g)/(a-1)}getTangent(e,t){let i=e-1e-4,a=e+1e-4;i<0&&(i=0),a>1&&(a=1);const r=this.getPoint(i),s=this.getPoint(a),u=t||(r.isVector2?new G1:new Y);return u.copy(s).sub(r).normalize(),u}getTangentAt(e,t){const n=this.getUtoTmapping(e);return this.getTangent(n,t)}computeFrenetFrames(e,t){const n=new Y,i=[],a=[],r=[],s=new Y,u=new j2;for(let g=0;g<=e;g++){const y=g/e;i[g]=this.getTangentAt(y,new Y)}a[0]=new Y,r[0]=new Y;let c=Number.MAX_VALUE;const d=Math.abs(i[0].x),h=Math.abs(i[0].y),p=Math.abs(i[0].z);d<=c&&(c=d,n.set(1,0,0)),h<=c&&(c=h,n.set(0,1,0)),p<=c&&n.set(0,0,1),s.crossVectors(i[0],n).normalize(),a[0].crossVectors(i[0],s),r[0].crossVectors(i[0],a[0]);for(let g=1;g<=e;g++){if(a[g]=a[g-1].clone(),r[g]=r[g-1].clone(),s.crossVectors(i[g-1],i[g]),s.length()>Number.EPSILON){s.normalize();const y=Math.acos(d3(i[g-1].dot(i[g]),-1,1));a[g].applyMatrix4(u.makeRotationAxis(s,y))}r[g].crossVectors(i[g],a[g])}if(t===!0){let g=Math.acos(d3(a[0].dot(a[e]),-1,1));g/=e,i[0].dot(s.crossVectors(a[0],a[e]))>0&&(g=-g);for(let y=1;y<=e;y++)a[y].applyMatrix4(u.makeRotationAxis(i[y],g*y)),r[y].crossVectors(i[y],a[y])}return{tangents:i,normals:a,binormals:r}}clone(){return new this.constructor().copy(this)}copy(e){return this.arcLengthDivisions=e.arcLengthDivisions,this}toJSON(){const e={metadata:{version:4.5,type:"Curve",generator:"Curve.toJSON"}};return e.arcLengthDivisions=this.arcLengthDivisions,e.type=this.type,e}fromJSON(e){return this.arcLengthDivisions=e.arcLengthDivisions,this}}class ws extends B4{constructor(e=0,t=0,n=1,i=1,a=0,r=Math.PI*2,s=!1,u=0){super(),this.isEllipseCurve=!0,this.type="EllipseCurve",this.aX=e,this.aY=t,this.xRadius=n,this.yRadius=i,this.aStartAngle=a,this.aEndAngle=r,this.aClockwise=s,this.aRotation=u}getPoint(e,t){const n=t||new G1,i=Math.PI*2;let a=this.aEndAngle-this.aStartAngle;const r=Math.abs(a)<Number.EPSILON;for(;a<0;)a+=i;for(;a>i;)a-=i;a<Number.EPSILON&&(r?a=0:a=i),this.aClockwise===!0&&!r&&(a===i?a=-i:a=a-i);const s=this.aStartAngle+e*a;let u=this.aX+this.xRadius*Math.cos(s),c=this.aY+this.yRadius*Math.sin(s);if(this.aRotation!==0){const d=Math.cos(this.aRotation),h=Math.sin(this.aRotation),p=u-this.aX,g=c-this.aY;u=p*d-g*h+this.aX,c=p*h+g*d+this.aY}return n.set(u,c)}copy(e){return super.copy(e),this.aX=e.aX,this.aY=e.aY,this.xRadius=e.xRadius,this.yRadius=e.yRadius,this.aStartAngle=e.aStartAngle,this.aEndAngle=e.aEndAngle,this.aClockwise=e.aClockwise,this.aRotation=e.aRotation,this}toJSON(){const e=super.toJSON();return e.aX=this.aX,e.aY=this.aY,e.xRadius=this.xRadius,e.yRadius=this.yRadius,e.aStartAngle=this.aStartAngle,e.aEndAngle=this.aEndAngle,e.aClockwise=this.aClockwise,e.aRotation=this.aRotation,e}fromJSON(e){return super.fromJSON(e),this.aX=e.aX,this.aY=e.aY,this.xRadius=e.xRadius,this.yRadius=e.yRadius,this.aStartAngle=e.aStartAngle,this.aEndAngle=e.aEndAngle,this.aClockwise=e.aClockwise,this.aRotation=e.aRotation,this}}class tn extends ws{constructor(e,t,n,i,a,r){super(e,t,n,n,i,a,r),this.isArcCurve=!0,this.type="ArcCurve"}}function nn(){let o=0,e=0,t=0,n=0;function i(a,r,s,u){o=a,e=s,t=-3*a+3*r-2*s-u,n=2*a-2*r+s+u}return{initCatmullRom:function(a,r,s,u,c){i(r,s,c*(s-a),c*(u-r))},initNonuniformCatmullRom:function(a,r,s,u,c,d,h){let p=(r-a)/c-(s-a)/(c+d)+(s-r)/d,g=(s-r)/d-(u-r)/(d+h)+(u-s)/h;p*=d,g*=d,i(r,s,p,g)},calc:function(a){const r=a*a,s=r*a;return o+e*a+t*r+n*s}}}const M8=new Y,t7=new nn,n7=new nn,i7=new nn;class Cs extends B4{constructor(e=[],t=!1,n="centripetal",i=.5){super(),this.isCatmullRomCurve3=!0,this.type="CatmullRomCurve3",this.points=e,this.closed=t,this.curveType=n,this.tension=i}getPoint(e,t=new Y){const n=t,i=this.points,a=i.length,r=(a-(this.closed?0:1))*e;let s=Math.floor(r),u=r-s;this.closed?s+=s>0?0:(Math.floor(Math.abs(s)/a)+1)*a:u===0&&s===a-1&&(s=a-2,u=1);let c,d;this.closed||s>0?c=i[(s-1)%a]:(M8.subVectors(i[0],i[1]).add(i[0]),c=M8);const h=i[s%a],p=i[(s+1)%a];if(this.closed||s+2<a?d=i[(s+2)%a]:(M8.subVectors(i[a-1],i[a-2]).add(i[a-1]),d=M8),this.curveType==="centripetal"||this.curveType==="chordal"){const g=this.curveType==="chordal"?.5:.25;let y=Math.pow(c.distanceToSquared(h),g),m=Math.pow(h.distanceToSquared(p),g),v=Math.pow(p.distanceToSquared(d),g);m<1e-4&&(m=1),y<1e-4&&(y=m),v<1e-4&&(v=m),t7.initNonuniformCatmullRom(c.x,h.x,p.x,d.x,y,m,v),n7.initNonuniformCatmullRom(c.y,h.y,p.y,d.y,y,m,v),i7.initNonuniformCatmullRom(c.z,h.z,p.z,d.z,y,m,v)}else this.curveType==="catmullrom"&&(t7.initCatmullRom(c.x,h.x,p.x,d.x,this.tension),n7.initCatmullRom(c.y,h.y,p.y,d.y,this.tension),i7.initCatmullRom(c.z,h.z,p.z,d.z,this.tension));return n.set(t7.calc(u),n7.calc(u),i7.calc(u)),n}copy(e){super.copy(e),this.points=[];for(let t=0,n=e.points.length;t<n;t++){const i=e.points[t];this.points.push(i.clone())}return this.closed=e.closed,this.curveType=e.curveType,this.tension=e.tension,this}toJSON(){const e=super.toJSON();e.points=[];for(let t=0,n=this.points.length;t<n;t++){const i=this.points[t];e.points.push(i.toArray())}return e.closed=this.closed,e.curveType=this.curveType,e.tension=this.tension,e}fromJSON(e){super.fromJSON(e),this.points=[];for(let t=0,n=e.points.length;t<n;t++){const i=e.points[t];this.points.push(new Y().fromArray(i))}return this.closed=e.closed,this.curveType=e.curveType,this.tension=e.tension,this}}function ua(o,e,t,n,i){const a=(n-e)*.5,r=(i-t)*.5,s=o*o,u=o*s;return(2*t-2*n+a+r)*u+(-3*t+3*n-2*a-r)*s+a*o+t}function dT(o,e){const t=1-o;return t*t*e}function fT(o,e){return 2*(1-o)*o*e}function hT(o,e){return o*o*e}function m5(o,e,t,n){return dT(o,e)+fT(o,t)+hT(o,n)}function pT(o,e){const t=1-o;return t*t*t*e}function mT(o,e){const t=1-o;return 3*t*t*o*e}function gT(o,e){return 3*(1-o)*o*o*e}function _T(o,e){return o*o*o*e}function g5(o,e,t,n,i){return pT(o,e)+mT(o,t)+gT(o,n)+_T(o,i)}class vT extends B4{constructor(e=new G1,t=new G1,n=new G1,i=new G1){super(),this.isCubicBezierCurve=!0,this.type="CubicBezierCurve",this.v0=e,this.v1=t,this.v2=n,this.v3=i}getPoint(e,t=new G1){const n=t,i=this.v0,a=this.v1,r=this.v2,s=this.v3;return n.set(g5(e,i.x,a.x,r.x,s.x),g5(e,i.y,a.y,r.y,s.y)),n}copy(e){return super.copy(e),this.v0.copy(e.v0),this.v1.copy(e.v1),this.v2.copy(e.v2),this.v3.copy(e.v3),this}toJSON(){const e=super.toJSON();return e.v0=this.v0.toArray(),e.v1=this.v1.toArray(),e.v2=this.v2.toArray(),e.v3=this.v3.toArray(),e}fromJSON(e){return super.fromJSON(e),this.v0.fromArray(e.v0),this.v1.fromArray(e.v1),this.v2.fromArray(e.v2),this.v3.fromArray(e.v3),this}}class yT extends B4{constructor(e=new Y,t=new Y,n=new Y,i=new Y){super(),this.isCubicBezierCurve3=!0,this.type="CubicBezierCurve3",this.v0=e,this.v1=t,this.v2=n,this.v3=i}getPoint(e,t=new Y){const n=t,i=this.v0,a=this.v1,r=this.v2,s=this.v3;return n.set(g5(e,i.x,a.x,r.x,s.x),g5(e,i.y,a.y,r.y,s.y),g5(e,i.z,a.z,r.z,s.z)),n}copy(e){return super.copy(e),this.v0.copy(e.v0),this.v1.copy(e.v1),this.v2.copy(e.v2),this.v3.copy(e.v3),this}toJSON(){const e=super.toJSON();return e.v0=this.v0.toArray(),e.v1=this.v1.toArray(),e.v2=this.v2.toArray(),e.v3=this.v3.toArray(),e}fromJSON(e){return super.fromJSON(e),this.v0.fromArray(e.v0),this.v1.fromArray(e.v1),this.v2.fromArray(e.v2),this.v3.fromArray(e.v3),this}}class bT extends B4{constructor(e=new G1,t=new G1){super(),this.isLineCurve=!0,this.type="LineCurve",this.v1=e,this.v2=t}getPoint(e,t=new G1){const n=t;return e===1?n.copy(this.v2):(n.copy(this.v2).sub(this.v1),n.multiplyScalar(e).add(this.v1)),n}getPointAt(e,t){return this.getPoint(e,t)}getTangent(e,t){const n=t||new G1;return n.copy(this.v2).sub(this.v1).normalize(),n}copy(e){return super.copy(e),this.v1.copy(e.v1),this.v2.copy(e.v2),this}toJSON(){const e=super.toJSON();return e.v1=this.v1.toArray(),e.v2=this.v2.toArray(),e}fromJSON(e){return super.fromJSON(e),this.v1.fromArray(e.v1),this.v2.fromArray(e.v2),this}}class xT extends B4{constructor(e=new Y,t=new Y){super(),this.isLineCurve3=!0,this.type="LineCurve3",this.v1=e,this.v2=t}getPoint(e,t=new Y){const n=t;return e===1?n.copy(this.v2):(n.copy(this.v2).sub(this.v1),n.multiplyScalar(e).add(this.v1)),n}getPointAt(e,t){return this.getPoint(e,t)}copy(e){return super.copy(e),this.v1.copy(e.v1),this.v2.copy(e.v2),this}toJSON(){const e=super.toJSON();return e.v1=this.v1.toArray(),e.v2=this.v2.toArray(),e}fromJSON(e){return super.fromJSON(e),this.v1.fromArray(e.v1),this.v2.fromArray(e.v2),this}}class ST extends B4{constructor(e=new G1,t=new G1,n=new G1){super(),this.isQuadraticBezierCurve=!0,this.type="QuadraticBezierCurve",this.v0=e,this.v1=t,this.v2=n}getPoint(e,t=new G1){const n=t,i=this.v0,a=this.v1,r=this.v2;return n.set(m5(e,i.x,a.x,r.x),m5(e,i.y,a.y,r.y)),n}copy(e){return super.copy(e),this.v0.copy(e.v0),this.v1.copy(e.v1),this.v2.copy(e.v2),this}toJSON(){const e=super.toJSON();return e.v0=this.v0.toArray(),e.v1=this.v1.toArray(),e.v2=this.v2.toArray(),e}fromJSON(e){return super.fromJSON(e),this.v0.fromArray(e.v0),this.v1.fromArray(e.v1),this.v2.fromArray(e.v2),this}}class Ts extends B4{constructor(e=new Y,t=new Y,n=new Y){super(),this.isQuadraticBezierCurve3=!0,this.type="QuadraticBezierCurve3",this.v0=e,this.v1=t,this.v2=n}getPoint(e,t=new Y){const n=t,i=this.v0,a=this.v1,r=this.v2;return n.set(m5(e,i.x,a.x,r.x),m5(e,i.y,a.y,r.y),m5(e,i.z,a.z,r.z)),n}copy(e){return super.copy(e),this.v0.copy(e.v0),this.v1.copy(e.v1),this.v2.copy(e.v2),this}toJSON(){const e=super.toJSON();return e.v0=this.v0.toArray(),e.v1=this.v1.toArray(),e.v2=this.v2.toArray(),e}fromJSON(e){return super.fromJSON(e),this.v0.fromArray(e.v0),this.v1.fromArray(e.v1),this.v2.fromArray(e.v2),this}}class MT extends B4{constructor(e=[]){super(),this.isSplineCurve=!0,this.type="SplineCurve",this.points=e}getPoint(e,t=new G1){const n=t,i=this.points,a=(i.length-1)*e,r=Math.floor(a),s=a-r,u=i[r===0?r:r-1],c=i[r],d=i[r>i.length-2?i.length-1:r+1],h=i[r>i.length-3?i.length-1:r+2];return n.set(ua(s,u.x,c.x,d.x,h.x),ua(s,u.y,c.y,d.y,h.y)),n}copy(e){super.copy(e),this.points=[];for(let t=0,n=e.points.length;t<n;t++){const i=e.points[t];this.points.push(i.clone())}return this}toJSON(){const e=super.toJSON();e.points=[];for(let t=0,n=this.points.length;t<n;t++){const i=this.points[t];e.points.push(i.toArray())}return e}fromJSON(e){super.fromJSON(e),this.points=[];for(let t=0,n=e.points.length;t<n;t++){const i=e.points[t];this.points.push(new G1().fromArray(i))}return this}}var AT=Object.freeze({__proto__:null,ArcCurve:tn,CatmullRomCurve3:Cs,CubicBezierCurve:vT,CubicBezierCurve3:yT,EllipseCurve:ws,LineCurve:bT,LineCurve3:xT,QuadraticBezierCurve:ST,QuadraticBezierCurve3:Ts,SplineCurve:MT});class q4 extends E3{constructor(e=1,t=32,n=16,i=0,a=Math.PI*2,r=0,s=Math.PI){super(),this.type="SphereGeometry",this.parameters={radius:e,widthSegments:t,heightSegments:n,phiStart:i,phiLength:a,thetaStart:r,thetaLength:s},t=Math.max(3,Math.floor(t)),n=Math.max(2,Math.floor(n));const u=Math.min(r+s,Math.PI);let c=0;const d=[],h=new Y,p=new Y,g=[],y=[],m=[],v=[];for(let b=0;b<=n;b++){const x=[],w=b/n;let M=0;b==0&&r==0?M=.5/t:b==n&&u==Math.PI&&(M=-.5/t);for(let A=0;A<=t;A++){const S=A/t;h.x=-e*Math.cos(i+S*a)*Math.sin(r+w*s),h.y=e*Math.cos(r+w*s),h.z=e*Math.sin(i+S*a)*Math.sin(r+w*s),y.push(h.x,h.y,h.z),p.copy(h).normalize(),m.push(p.x,p.y,p.z),v.push(S+M,1-w),x.push(c++)}d.push(x)}for(let b=0;b<n;b++)for(let x=0;x<t;x++){const w=d[b][x+1],M=d[b][x],A=d[b+1][x],S=d[b+1][x+1];(b!==0||r>0)&&g.push(w,M,S),(b!==n-1||u<Math.PI)&&g.push(M,A,S)}this.setIndex(g),this.setAttribute("position",new M3(y,3)),this.setAttribute("normal",new M3(m,3)),this.setAttribute("uv",new M3(v,2))}static fromJSON(e){return new q4(e.radius,e.widthSegments,e.heightSegments,e.phiStart,e.phiLength,e.thetaStart,e.thetaLength)}}class on extends E3{constructor(e=new Ts(new Y(-1,-1,0),new Y(-1,1,0),new Y(1,1,0)),t=64,n=1,i=8,a=!1){super(),this.type="TubeGeometry",this.parameters={path:e,tubularSegments:t,radius:n,radialSegments:i,closed:a};const r=e.computeFrenetFrames(t,a);this.tangents=r.tangents,this.normals=r.normals,this.binormals=r.binormals;const s=new Y,u=new Y,c=new G1;let d=new Y;const h=[],p=[],g=[],y=[];m(),this.setIndex(y),this.setAttribute("position",new M3(h,3)),this.setAttribute("normal",new M3(p,3)),this.setAttribute("uv",new M3(g,2));function m(){for(let w=0;w<t;w++)v(w);v(a===!1?t:0),x(),b()}function v(w){d=e.getPointAt(w/t,d);const M=r.normals[w],A=r.binormals[w];for(let S=0;S<=i;S++){const D=S/i*Math.PI*2,C=Math.sin(D),E=-Math.cos(D);u.x=E*M.x+C*A.x,u.y=E*M.y+C*A.y,u.z=E*M.z+C*A.z,u.normalize(),p.push(u.x,u.y,u.z),s.x=d.x+n*u.x,s.y=d.y+n*u.y,s.z=d.z+n*u.z,h.push(s.x,s.y,s.z)}}function b(){for(let w=1;w<=t;w++)for(let M=1;M<=i;M++){const A=(i+1)*(w-1)+(M-1),S=(i+1)*w+(M-1),D=(i+1)*w+M,C=(i+1)*(w-1)+M;y.push(A,S,C),y.push(S,D,C)}}function x(){for(let w=0;w<=t;w++)for(let M=0;M<=i;M++)c.x=w/t,c.y=M/i,g.push(c.x,c.y)}}toJSON(){const e=super.toJSON();return e.path=this.parameters.path.toJSON(),e}static fromJSON(e){return new on(new AT[e.path.type]().fromJSON(e.path),e.tubularSegments,e.radius,e.radialSegments,e.closed)}}const ca={enabled:!1,files:{},add:function(o,e){this.enabled!==!1&&(this.files[o]=e)},get:function(o){if(this.enabled!==!1)return this.files[o]},remove:function(o){delete this.files[o]},clear:function(){this.files={}}};class Es{constructor(e,t,n){const i=this;let a=!1,r=0,s=0,u;const c=[];this.onStart=void 0,this.onLoad=e,this.onProgress=t,this.onError=n,this.itemStart=function(d){s++,a===!1&&i.onStart!==void 0&&i.onStart(d,r,s),a=!0},this.itemEnd=function(d){r++,i.onProgress!==void 0&&i.onProgress(d,r,s),r===s&&(a=!1,i.onLoad!==void 0&&i.onLoad())},this.itemError=function(d){i.onError!==void 0&&i.onError(d)},this.resolveURL=function(d){return u?u(d):d},this.setURLModifier=function(d){return u=d,this},this.addHandler=function(d,h){return c.push(d,h),this},this.removeHandler=function(d){const h=c.indexOf(d);return h!==-1&&c.splice(h,2),this},this.getHandler=function(d){for(let h=0,p=c.length;h<p;h+=2){const g=c[h],y=c[h+1];if(g.global&&(g.lastIndex=0),g.test(d))return y}return null}}}const wT=new Es;class Ds{constructor(e){this.manager=e!==void 0?e:wT,this.crossOrigin="anonymous",this.withCredentials=!1,this.path="",this.resourcePath="",this.requestHeader={}}load(){}loadAsync(e,t){const n=this;return new Promise(function(i,a){n.load(e,i,t,a)})}parse(){}setCrossOrigin(e){return this.crossOrigin=e,this}setWithCredentials(e){return this.withCredentials=e,this}setPath(e){return this.path=e,this}setResourcePath(e){return this.resourcePath=e,this}setRequestHeader(e){return this.requestHeader=e,this}}class CT extends Ds{constructor(e){super(e)}load(e,t,n,i){this.path!==void 0&&(e=this.path+e),e=this.manager.resolveURL(e);const a=this,r=ca.get(e);if(r!==void 0)return a.manager.itemStart(e),setTimeout(function(){t&&t(r),a.manager.itemEnd(e)},0),r;const s=M5("img");function u(){d(),ca.add(e,this),t&&t(this),a.manager.itemEnd(e)}function c(h){d(),i&&i(h),a.manager.itemError(e),a.manager.itemEnd(e)}function d(){s.removeEventListener("load",u,!1),s.removeEventListener("error",c,!1)}return s.addEventListener("load",u,!1),s.addEventListener("error",c,!1),e.slice(0,5)!=="data:"&&this.crossOrigin!==void 0&&(s.crossOrigin=this.crossOrigin),a.manager.itemStart(e),s.src=e,s}}class TT extends Ds{constructor(e){super(e)}load(e,t,n,i){const a=new Q3,r=new CT(this.manager);return r.setCrossOrigin(this.crossOrigin),r.setPath(this.path),r.load(e,function(s){a.image=s,a.needsUpdate=!0,t!==void 0&&t(a)},n,i),a}}class da{constructor(e=1,t=0,n=0){return this.radius=e,this.phi=t,this.theta=n,this}set(e,t,n){return this.radius=e,this.phi=t,this.theta=n,this}copy(e){return this.radius=e.radius,this.phi=e.phi,this.theta=e.theta,this}makeSafe(){return this.phi=Math.max(1e-6,Math.min(Math.PI-1e-6,this.phi)),this}setFromVector3(e){return this.setFromCartesianCoords(e.x,e.y,e.z)}setFromCartesianCoords(e,t,n){return this.radius=Math.sqrt(e*e+t*t+n*n),this.radius===0?(this.theta=0,this.phi=0):(this.theta=Math.atan2(e,n),this.phi=Math.acos(d3(t/this.radius,-1,1))),this}clone(){return new this.constructor().copy(this)}}typeof __THREE_DEVTOOLS__!="undefined"&&__THREE_DEVTOOLS__.dispatchEvent(new CustomEvent("register",{detail:{revision:Qt}}));typeof window!="undefined"&&(window.__THREE__?console.warn("WARNING: Multiple instances of Three.js being imported."):window.__THREE__=Qt);const fa={type:"change"},o7={type:"start"},ha={type:"end"};class ET extends H0{constructor(e,t){super(),this.object=e,this.domElement=t,this.domElement.style.touchAction="none",this.enabled=!0,this.target=new Y,this.minDistance=0,this.maxDistance=1/0,this.minZoom=0,this.maxZoom=1/0,this.minPolarAngle=0,this.maxPolarAngle=Math.PI,this.minAzimuthAngle=-1/0,this.maxAzimuthAngle=1/0,this.enableDamping=!1,this.dampingFactor=.05,this.enableZoom=!0,this.zoomSpeed=1,this.enableRotate=!0,this.rotateSpeed=1,this.enablePan=!0,this.panSpeed=1,this.screenSpacePanning=!0,this.keyPanSpeed=7,this.autoRotate=!1,this.autoRotateSpeed=2,this.keys={LEFT:"ArrowLeft",UP:"ArrowUp",RIGHT:"ArrowRight",BOTTOM:"ArrowDown"},this.mouseButtons={LEFT:Q0.ROTATE,MIDDLE:Q0.DOLLY,RIGHT:Q0.PAN},this.touches={ONE:q0.ROTATE,TWO:q0.DOLLY_PAN},this.target0=this.target.clone(),this.position0=this.object.position.clone(),this.zoom0=this.object.zoom,this._domElementKeyEvents=null,this.getPolarAngle=function(){return s.phi},this.getAzimuthalAngle=function(){return s.theta},this.getDistance=function(){return this.object.position.distanceTo(this.target)},this.listenToKeyEvents=function(W){W.addEventListener("keydown",W1),this._domElementKeyEvents=W},this.saveState=function(){n.target0.copy(n.target),n.position0.copy(n.object.position),n.zoom0=n.object.zoom},this.reset=function(){n.target.copy(n.target0),n.object.position.copy(n.position0),n.object.zoom=n.zoom0,n.object.updateProjectionMatrix(),n.dispatchEvent(fa),n.update(),a=i.NONE},this.update=function(){const W=new Y,o1=new k4().setFromUnitVectors(e.up,new Y(0,1,0)),P1=o1.clone().invert(),L1=new Y,k1=new k4,j1=2*Math.PI;return function(){const m2=n.object.position;W.copy(m2).sub(n.target),W.applyQuaternion(o1),s.setFromVector3(W),n.autoRotate&&a===i.NONE&&E(D()),n.enableDamping?(s.theta+=u.theta*n.dampingFactor,s.phi+=u.phi*n.dampingFactor):(s.theta+=u.theta,s.phi+=u.phi);let K=n.minAzimuthAngle,z1=n.maxAzimuthAngle;return isFinite(K)&&isFinite(z1)&&(K<-Math.PI?K+=j1:K>Math.PI&&(K-=j1),z1<-Math.PI?z1+=j1:z1>Math.PI&&(z1-=j1),K<=z1?s.theta=Math.max(K,Math.min(z1,s.theta)):s.theta=s.theta>(K+z1)/2?Math.max(K,s.theta):Math.min(z1,s.theta)),s.phi=Math.max(n.minPolarAngle,Math.min(n.maxPolarAngle,s.phi)),s.makeSafe(),s.radius*=c,s.radius=Math.max(n.minDistance,Math.min(n.maxDistance,s.radius)),n.enableDamping===!0?n.target.addScaledVector(d,n.dampingFactor):n.target.add(d),W.setFromSpherical(s),W.applyQuaternion(P1),m2.copy(n.target).add(W),n.object.lookAt(n.target),n.enableDamping===!0?(u.theta*=1-n.dampingFactor,u.phi*=1-n.dampingFactor,d.multiplyScalar(1-n.dampingFactor)):(u.set(0,0,0),d.set(0,0,0)),c=1,h||L1.distanceToSquared(n.object.position)>r||8*(1-k1.dot(n.object.quaternion))>r?(n.dispatchEvent(fa),L1.copy(n.object.position),k1.copy(n.object.quaternion),h=!1,!0):!1}}(),this.dispose=function(){n.domElement.removeEventListener("contextmenu",l1),n.domElement.removeEventListener("pointerdown",X1),n.domElement.removeEventListener("pointercancel",t2),n.domElement.removeEventListener("wheel",n2),n.domElement.removeEventListener("pointermove",$1),n.domElement.removeEventListener("pointerup",Y1),n._domElementKeyEvents!==null&&n._domElementKeyEvents.removeEventListener("keydown",W1)};const n=this,i={NONE:-1,ROTATE:0,DOLLY:1,PAN:2,TOUCH_ROTATE:3,TOUCH_PAN:4,TOUCH_DOLLY_PAN:5,TOUCH_DOLLY_ROTATE:6};let a=i.NONE;const r=1e-6,s=new da,u=new da;let c=1;const d=new Y;let h=!1;const p=new G1,g=new G1,y=new G1,m=new G1,v=new G1,b=new G1,x=new G1,w=new G1,M=new G1,A=[],S={};function D(){return 2*Math.PI/60/60*n.autoRotateSpeed}function C(){return Math.pow(.95,n.zoomSpeed)}function E(W){u.theta-=W}function k(W){u.phi-=W}const $=function(){const W=new Y;return function(P1,L1){W.setFromMatrixColumn(L1,0),W.multiplyScalar(-P1),d.add(W)}}(),X=function(){const W=new Y;return function(P1,L1){n.screenSpacePanning===!0?W.setFromMatrixColumn(L1,1):(W.setFromMatrixColumn(L1,0),W.crossVectors(n.object.up,W)),W.multiplyScalar(P1),d.add(W)}}(),F=function(){const W=new Y;return function(P1,L1){const k1=n.domElement;if(n.object.isPerspectiveCamera){const j1=n.object.position;W.copy(j1).sub(n.target);let i2=W.length();i2*=Math.tan(n.object.fov/2*Math.PI/180),$(2*P1*i2/k1.clientHeight,n.object.matrix),X(2*L1*i2/k1.clientHeight,n.object.matrix)}else n.object.isOrthographicCamera?($(P1*(n.object.right-n.object.left)/n.object.zoom/k1.clientWidth,n.object.matrix),X(L1*(n.object.top-n.object.bottom)/n.object.zoom/k1.clientHeight,n.object.matrix)):(console.warn("WARNING: OrbitControls.js encountered an unknown camera type - pan disabled."),n.enablePan=!1)}}();function R(W){n.object.isPerspectiveCamera?c/=W:n.object.isOrthographicCamera?(n.object.zoom=Math.max(n.minZoom,Math.min(n.maxZoom,n.object.zoom*W)),n.object.updateProjectionMatrix(),h=!0):(console.warn("WARNING: OrbitControls.js encountered an unknown camera type - dolly/zoom disabled."),n.enableZoom=!1)}function U(W){n.object.isPerspectiveCamera?c*=W:n.object.isOrthographicCamera?(n.object.zoom=Math.max(n.minZoom,Math.min(n.maxZoom,n.object.zoom/W)),n.object.updateProjectionMatrix(),h=!0):(console.warn("WARNING: OrbitControls.js encountered an unknown camera type - dolly/zoom disabled."),n.enableZoom=!1)}function H(W){p.set(W.clientX,W.clientY)}function V(W){x.set(W.clientX,W.clientY)}function N(W){m.set(W.clientX,W.clientY)}function z(W){g.set(W.clientX,W.clientY),y.subVectors(g,p).multiplyScalar(n.rotateSpeed);const o1=n.domElement;E(2*Math.PI*y.x/o1.clientHeight),k(2*Math.PI*y.y/o1.clientHeight),p.copy(g),n.update()}function G(W){w.set(W.clientX,W.clientY),M.subVectors(w,x),M.y>0?R(C()):M.y<0&&U(C()),x.copy(w),n.update()}function t1(W){v.set(W.clientX,W.clientY),b.subVectors(v,m).multiplyScalar(n.panSpeed),F(b.x,b.y),m.copy(v),n.update()}function e1(W){W.deltaY<0?U(C()):W.deltaY>0&&R(C()),n.update()}function u1(W){let o1=!1;switch(W.code){case n.keys.UP:F(0,n.keyPanSpeed),o1=!0;break;case n.keys.BOTTOM:F(0,-n.keyPanSpeed),o1=!0;break;case n.keys.LEFT:F(n.keyPanSpeed,0),o1=!0;break;case n.keys.RIGHT:F(-n.keyPanSpeed,0),o1=!0;break}o1&&(W.preventDefault(),n.update())}function s1(){if(A.length===1)p.set(A[0].pageX,A[0].pageY);else{const W=.5*(A[0].pageX+A[1].pageX),o1=.5*(A[0].pageY+A[1].pageY);p.set(W,o1)}}function q(){if(A.length===1)m.set(A[0].pageX,A[0].pageY);else{const W=.5*(A[0].pageX+A[1].pageX),o1=.5*(A[0].pageY+A[1].pageY);m.set(W,o1)}}function Z(){const W=A[0].pageX-A[1].pageX,o1=A[0].pageY-A[1].pageY,P1=Math.sqrt(W*W+o1*o1);x.set(0,P1)}function p1(){n.enableZoom&&Z(),n.enablePan&&q()}function m1(){n.enableZoom&&Z(),n.enableRotate&&s1()}function f1(W){if(A.length==1)g.set(W.pageX,W.pageY);else{const P1=H1(W),L1=.5*(W.pageX+P1.x),k1=.5*(W.pageY+P1.y);g.set(L1,k1)}y.subVectors(g,p).multiplyScalar(n.rotateSpeed);const o1=n.domElement;E(2*Math.PI*y.x/o1.clientHeight),k(2*Math.PI*y.y/o1.clientHeight),p.copy(g)}function d1(W){if(A.length===1)v.set(W.pageX,W.pageY);else{const o1=H1(W),P1=.5*(W.pageX+o1.x),L1=.5*(W.pageY+o1.y);v.set(P1,L1)}b.subVectors(v,m).multiplyScalar(n.panSpeed),F(b.x,b.y),m.copy(v)}function N1(W){const o1=H1(W),P1=W.pageX-o1.x,L1=W.pageY-o1.y,k1=Math.sqrt(P1*P1+L1*L1);w.set(0,k1),M.set(0,Math.pow(w.y/x.y,n.zoomSpeed)),R(M.y),x.copy(w)}function M1(W){n.enableZoom&&N1(W),n.enablePan&&d1(W)}function S1(W){n.enableZoom&&N1(W),n.enableRotate&&f1(W)}function X1(W){n.enabled!==!1&&(A.length===0&&(n.domElement.setPointerCapture(W.pointerId),n.domElement.addEventListener("pointermove",$1),n.domElement.addEventListener("pointerup",Y1)),b1(W),W.pointerType==="touch"?O(W):s2(W))}function $1(W){n.enabled!==!1&&(W.pointerType==="touch"?I(W):V1(W))}function Y1(W){A1(W),A.length===0&&(n.domElement.releasePointerCapture(W.pointerId),n.domElement.removeEventListener("pointermove",$1),n.domElement.removeEventListener("pointerup",Y1)),n.dispatchEvent(ha),a=i.NONE}function t2(W){A1(W)}function s2(W){let o1;switch(W.button){case 0:o1=n.mouseButtons.LEFT;break;case 1:o1=n.mouseButtons.MIDDLE;break;case 2:o1=n.mouseButtons.RIGHT;break;default:o1=-1}switch(o1){case Q0.DOLLY:if(n.enableZoom===!1)return;V(W),a=i.DOLLY;break;case Q0.ROTATE:if(W.ctrlKey||W.metaKey||W.shiftKey){if(n.enablePan===!1)return;N(W),a=i.PAN}else{if(n.enableRotate===!1)return;H(W),a=i.ROTATE}break;case Q0.PAN:if(W.ctrlKey||W.metaKey||W.shiftKey){if(n.enableRotate===!1)return;H(W),a=i.ROTATE}else{if(n.enablePan===!1)return;N(W),a=i.PAN}break;default:a=i.NONE}a!==i.NONE&&n.dispatchEvent(o7)}function V1(W){switch(a){case i.ROTATE:if(n.enableRotate===!1)return;z(W);break;case i.DOLLY:if(n.enableZoom===!1)return;G(W);break;case i.PAN:if(n.enablePan===!1)return;t1(W);break}}function n2(W){n.enabled===!1||n.enableZoom===!1||a!==i.NONE||(W.preventDefault(),n.dispatchEvent(o7),e1(W),n.dispatchEvent(ha))}function W1(W){n.enabled===!1||n.enablePan===!1||u1(W)}function O(W){switch(O1(W),A.length){case 1:switch(n.touches.ONE){case q0.ROTATE:if(n.enableRotate===!1)return;s1(),a=i.TOUCH_ROTATE;break;case q0.PAN:if(n.enablePan===!1)return;q(),a=i.TOUCH_PAN;break;default:a=i.NONE}break;case 2:switch(n.touches.TWO){case q0.DOLLY_PAN:if(n.enableZoom===!1&&n.enablePan===!1)return;p1(),a=i.TOUCH_DOLLY_PAN;break;case q0.DOLLY_ROTATE:if(n.enableZoom===!1&&n.enableRotate===!1)return;m1(),a=i.TOUCH_DOLLY_ROTATE;break;default:a=i.NONE}break;default:a=i.NONE}a!==i.NONE&&n.dispatchEvent(o7)}function I(W){switch(O1(W),a){case i.TOUCH_ROTATE:if(n.enableRotate===!1)return;f1(W),n.update();break;case i.TOUCH_PAN:if(n.enablePan===!1)return;d1(W),n.update();break;case i.TOUCH_DOLLY_PAN:if(n.enableZoom===!1&&n.enablePan===!1)return;M1(W),n.update();break;case i.TOUCH_DOLLY_ROTATE:if(n.enableZoom===!1&&n.enableRotate===!1)return;S1(W),n.update();break;default:a=i.NONE}}function l1(W){n.enabled!==!1&&W.preventDefault()}function b1(W){A.push(W)}function A1(W){delete S[W.pointerId];for(let o1=0;o1<A.length;o1++)if(A[o1].pointerId==W.pointerId){A.splice(o1,1);return}}function O1(W){let o1=S[W.pointerId];o1===void 0&&(o1=new G1,S[W.pointerId]=o1),o1.set(W.pageX,W.pageY)}function H1(W){const o1=W.pointerId===A[0].pointerId?A[1]:A[0];return S[o1.pointerId]}n.domElement.addEventListener("contextmenu",l1),n.domElement.addEventListener("pointerdown",X1),n.domElement.addEventListener("pointercancel",t2),n.domElement.addEventListener("wheel",n2,{passive:!1}),this.update()}}class DT{constructor(e){Q(this,"scene");Q(this,"camera");Q(this,"renderer");Q(this,"controls");Q(this,"dom");this.dom=e,this.initScenes(),this.setControls()}initScenes(){this.scene=new sT,this.camera=new W3(45,window.innerWidth/window.innerHeight,1,1e5),this.camera.position.set(0,30,-250),this.renderer=new bs({alpha:!0,antialias:!0}),this.renderer.setPixelRatio(window.devicePixelRatio),this.renderer.setSize(window.innerWidth,window.innerHeight),this.dom.appendChild(this.renderer.domElement)}setControls(){this.controls=new ET(this.camera,this.renderer.domElement),this.controls.autoRotateSpeed=3,this.controls.enableDamping=!0,this.controls.dampingFactor=.05,this.controls.enableZoom=!0,this.controls.minDistance=100,this.controls.maxDistance=300,this.controls.enablePan=!1}}const IT="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA/CAYAAAC8aKvcAAAOHElEQVRogb2b268dVR3Hv3Pb+1zYqR7hGBCIgqg0LdbwgGJU5MEoMSQSfdEQJSbGBFFfjDz4D5AYDQneEh4wchENkcgDii8QUxBKEUpRaAqFFmlt6UG6z+m+zMwas37ru9asmT2zz96nhWmms8/ec1mf9fut322tCVAUeAe24Cze8qw2MD6Da2eF2gq8D9l2/ZY6YisSbmtA/ft20Ee9366Z2vD6b23nzgwxD3ATQND42QL1Gq5ZbPhuUGtw3/u72iFtn5t+b4GYDXia9MxnH9JCdbzzXp9BtS9kg8c82o6wHVDCz9MJtYZvDtwG2wyqIS1cl3/rLdkEOK3BjlBIB/jwVfAtQc8LPAlbB7WQGnCNR4h5NMd+A3iPjcxQCPgK/04FUjlwX+KT0p4Jeh7g6bAnEDrQPkIB1HAx94jXnW4AXkKB3INehKrAb0BVJG6lXYU+K8CTsFaFVwlopbqMUCS6iBADAmvIEUI56n3Aay28hVzkMRcg5TpgCCXwGrwHJbDn8bhF6GnAzbB1Fe4hFIkmAhRiAaFAdhBiTNiUx5C7vyk2TB8TKAHt8Kjhu1AOXEP70n4bagr0XMD1cTsJq1V4mbB10ByRQCYIkSEUyBghUgTyr74VAlsgg0Is6qwEXgN35LscI0IPCF4f21dCzSLpOnCTRa7CHkfoVLgvEBG6AhaJRJX8HckxF8mG7pgR2JeyEtxCrsjkqhLadJ3ZxwSvS9uq+HGoWdTbB54N1qqwHau6OYuuWQZU22SNoHcfOKe0rZQLNiQkdg6FgHdJ5exc5B7ys36Cht5Avgl0HdhBt8XSJXwbbCpgZt+QEWrsseLn2APXMoUbwWHlKQUNlIHO3TEWfcjlOnBgiIDYYbpD+tI+4AQg0D0RkPbTE6D2aVbCzb5WS9daYztmBzI+I1HhnHDgHrhjgpTQhbfrRhcO2OAqwipKN5SxmNFBZe6z3vVdR8ixjAwDSjxBXpF0acjsmPahi7qEJy1y3UCl0uAqrDZPEJkk/JwIbsbfIzomJchaOcsOjgTajFe43UKm0k0Fh1cq/wfYALAs0ZfpFr0toBCvsSr+v3AdWuObnh4uOtcTOAOVU4192EycUoJI+jsRncjlO3OOkqOVdFgzWlqyRro5YSMXdhiNyDlgQjlfx+gF3Vch3bnBqKwr3wU11a7Ax43Gypdul9FTJg80bmZIiYWeCofiSDpsRofRc8epOxiKFByLdrPqDFFno8a5dK3RCCVXGXnHDsCYO0XwBdEB5WKDUsqoSzqsgDZJt0PpDuhnc7oda6SyCmxXfjVpw4JWtINX49aHrsANn1jGqjiUAEsSTOo9kBhraVcPqw/uxFcOXo0fy3WBIJj7QEKPDiJ03LNGNI6KGjdi+/p0maWUJ3z+5BiuS9dY5cAZnCFVWnkSziVsMI0qCM5c6T0Rzv/yebjyunNxw/4NPH/XG3jq9sM4qMfiDy7Gpd88H1ftXMaOMEB0coyjMhqN9TfRWU6pFpQiOATsv658Zz1Am5SdpKeP4Q5H14BuBYIYMoqKZAQF4npiSjlxUoEZUfvW8eLnV3CBBrriHOz62Uew6ycfwpq+/UqCFf9x+zbwEoGtCwJNViGmzQLHMtojicJSOrUlIhspG9DJsVxRabiTrDontWwn5Rj2gws7hgMaKzN+u1bK1z6Dh395BA8qMwphQX3YvEB+xxH8+dq9+CuUAHedLSicAUwq9qAQ02baYpOUAWP6DveG6orvE0udt+oM5q/6hmPGxoXYYhM2+g3IKeEqvEDffAD7btyPe09lWK834FSO9Rv3475bDmC/gNrrAsLa+ykPWLfB+nircZEnHLRXWCYl7G9rvIFN8TIvRLQBBdxjSott8p2EDkSg7z2KN297FX+vP+K2Q9h933GcdGPfQvqwQU2yftgasnttZoZadaVWV5scw349SjGUy+h5lah1QEmHdCplA6pRV8JHW8l3xqaDKtvYXN9hyGhHrqLTySTIDOnHfV9uDZVi7q2vPM32DrzKS61A2CzhujpolKGXz2YCbx4WUNohpV3frZQKJKoBWJm7J57qxtSOqFGqNloLvfaMvcJC3KDKnnuartKxdyM/gbf/lJH0P6/Cd+7ejmu3L+EcRkdlNFaUDW8FVpWILPY6L7r8HPR+uwPX7L0K3yZswEA0ZBJh2hQ1j9lJpLYt8VS56s1sPuvAP7SEHbt6uO7r5yN/+TQOPHwS//75Ybx8aMDuMncJi2Kygwuwuca/iqpesoCl71+EHV96Hz522TIuDYDorbHoXfncQqKvZsjEq5bODDzH9t8hXtu2jIt1wz68hMtvWcLlN18I9a/TeO2hN/HKr47gP0cGKIp6eUcDG40ILlrEwnc/gEuvX8UHty/hojCods6xDK+6Dp+llD5uPkunh0HFLel00Oa+OttJGWCk6CAWn9hhcLCADAuIsKTLbvfsxBe/topvJNr71TZVQD23jqMnUoy+sIJL/F8fWcOhc2Ms7Orh/XVIvaUFBvccxf03vYBHxCyFUuQ5LSW+BENJGHWtJcFYYnCbaXWRN6SLxXTgIWH1rm+f0HUoxsq5lAIkHtYx8ue24YI7t+NbWspnQ3MODPDSTftx9+Nv4w2BVQQOcRrAUHbtNDOMERO4EDHlFWBT75KkY9JoDVgRtFvmZSSKhbaIJZnQpXb6b/XYW1i77An8+heH8cBI1xa3uOlrbz+CBz+6G3c+fgprrIIolzsX/Ke423Rxie1eaVd6H7h60pgZqQXORc5KHIyFtQ0JJGPNGern3zuAJz+zB3e8sI5X5kXev4FDn96D3/zwReyRlFG5aoiSCNqmk2Gt4LfINtpZjJE3TdMAXJ2s0ieOWPXvUYk77NvcA8xZobBHrySz5xTWdjyBe376Gv4y1DXHTbahwvi2V/G3nf/AH/b2JbnIK+Udv1P1nslTlcuJcwrHlg7s1t8s8PBPSL2b5HIjW5lQ8sCqZLNKacakGumPDuKZTz2Nu55fx+E25H3rOPzJp/C7Ww/iWXmKKdqlrvrRBB1RwiGj+LE3PTPmsKxPw7YGHgNvHsdCj1kcjydUuCy2hXJ2yupTah//7CmcvOJJ/PH+Y6Kmle33x/D0x5/En55bF6mOJW4yOmafnk4U9eyzQ5G00b6uVC2NVvrqXCvbhhMF67pa91j47rK+kLk4p1ThyGtYwMYGtV1hvG9dEvyqdPs4BmPgxuxWe33Ke6WuIyMPHmKbq9IdcB7KGt3+pIT9wKNwZR57or7wBKGP03BELKermhqHkorbINRWRAIXP+lqg1HTagPMdyMBNKAlfCntVFBCT8LV4rwxYtpwrUFhW8OqggbgctNS3sv+HdHsL9Iih5zcCpksKmlARkmUsLZWEbhyu4oxCRyZ8T7iuB8LvOmAMbXGSDeu1ajH4muNdG12pbz5pnKSrQJeBy4rfXUpp/TBxmCErGBmrG+lrEimXqoRsJ5s7htAxUGLhHXUVHA4WFhIFm4kXdqGdunGjKjGjcZqohBf1KqWhdSBHuXcrYlYTIpY0BEMpQKSy6i20LGrI5fJuC2nauAmlQ4o4cBBjd2YNuAppV+VbswJNivdrptCbZVum0pX4ctlBgorMseksMxxbBpgZiIsbOFmF+CSQVNFzpMGCXeMFIesSY+pLeX4DRgyBtwjWuvI8xQLMm5Viyq3+uH69KK5sE8VuZBLD+xcrZ0vLJhiGKMylt2qY87xCFHZYaNKG38tv3vjd+SptLlv7FnokNIdenPFk1OmTUyNY7hZtSGKFsgDhgIauNqDlXTBPo+oaFahI5F3nGAy4uJ3Q28uKXWQih1osyArWXj7Bg3V27Mtf5hW8SgmJL3KnuyxdweeL04o5Vjck2lo4CQsUt59Ci/WG7L7f1KLLjOfnBK2sMqZy9QBx96s4chb+oDK3iTlmdZ4wKWPexFiG0KZTVTMleHKMho5YWXYTrDFlXpygfDhXbj+s+/FV/VNH3sLD1z3HB4SQwgXtaWVYaLkrqkDXkIqE+KryLAmRzVlInwCbtZVPGC+HLbmy+AxJWDYUDi3RTh/nYc/N+yHqhY8qUVXTQm+l+9Og8UMJR5/Bs4EJI9CYRUQN2UjsGWO6dwMSrlu5M0FgXGXseYGLeAESsDz2hMRG75WrXLfCzBmWL0zK3BTb5lar/XNZs2FqTUtUjELzi4pzgkpzgVFTrpVYDB4yGrQoZsvNuM25NqODdqTQcVQbQo7D3C5GSmbgKQvbsGYG22qBvI9XHasGI4qNwFmgCNX/jXnRdIlilFTLnbZrgjwF7KYQq7t7CbpbrptZfnwpAHzlzCZWb1yrVaXk16xt2Yr9cZwwqJCIipqoFJvyVJXJGokuyALWVSLoZoJZB4JV310XxIK09snuJqm7+5qCgbLTCLhql9mGtQvx2dMTqz6Q2yCcXkxF6uUS5TK8LFs01zbVuvShRvLYP2oQ/+soTdY9Bvw+wXOPnYZj9e3gFJeZnAZsJqRcHarvh6reTXtTNtWgA2sHctgRvU6i7c9fhfTuQQiLZNIQlbwVYHtAtOI58YMYXtM6K1kR62Z0FzQ877z0L7gVI9nf720XXDatoy4Dm29b88dlatPNa+gndkVnQlwHXrzheJ9hq+JN7PnLxJvWhxuQdvXSNdB3zVgtEKD065NrwGsecD+6nd4tbT2VfBNkO8o8HRoNLzo4c83dxtUeuRVV1B7yaP5PYctweIsADd/rr/G4y8uaZrG9GcINn+TZcuwOANgzPRqD2ovZTW9x4SGcurs7yq9q8CY4eWttnOmbbO6nS01/EwnxKvZ1Bk0pOW+8/626fZOvF06r0Q3285eAwH8H5voqTrwCB3hAAAAAElFTkSuQmCC",RT=Object.freeze(Object.defineProperty({__proto__:null,default:IT},Symbol.toStringTag,{value:"Module"})),OT="/static/png/label.png",PT=Object.freeze(Object.defineProperty({__proto__:null,default:OT},Symbol.toStringTag,{value:"Module"})),LT="/static/png/earth.png",zT=Object.freeze(Object.defineProperty({__proto__:null,default:LT},Symbol.toStringTag,{value:"Module"})),kT="/static/png/glow.png",NT=Object.freeze(Object.defineProperty({__proto__:null,default:kT},Symbol.toStringTag,{value:"Module"})),UT="/static/png/gradient.png",FT=Object.freeze(Object.defineProperty({__proto__:null,default:UT},Symbol.toStringTag,{value:"Module"})),BT="/static/png/label-old.png",GT=Object.freeze(Object.defineProperty({__proto__:null,default:BT},Symbol.toStringTag,{value:"Module"})),VT="/static/png/label.png",jT=Object.freeze(Object.defineProperty({__proto__:null,default:VT},Symbol.toStringTag,{value:"Module"})),WT="/static/png/light_column.png",HT=Object.freeze(Object.defineProperty({__proto__:null,default:WT},Symbol.toStringTag,{value:"Module"})),YT="/static/png/redCircle.png",$T=Object.freeze(Object.defineProperty({__proto__:null,default:YT},Symbol.toStringTag,{value:"Module"})),Is=[],pa=Object.assign({"../../images/earth/aircraft.png":RT,"../../images/earth/aperture.png":PT,"../../images/earth/earth.png":zT,"../../images/earth/glow.png":NT,"../../images/earth/gradient.png":FT,"../../images/earth/label-old.png":GT,"../../images/earth/label.png":jT,"../../images/earth/light_column.png":HT,"../../images/earth/redCircle.png":$T});for(let o in pa){const e=o.split("/").pop();e&&Is.push({name:e.split(".")[0],url:pa[o].default})}const JT={textures:Is};class ZT{constructor(e){Q(this,"manager");Q(this,"callback");Q(this,"textureLoader");Q(this,"textures");this.callback=e,this.textures={},this.setLoadingManager(),this.loadResources()}setLoadingManager(){this.manager=new Es,this.manager.onStart=()=>{Fu()},this.manager.onLoad=()=>{this.callback()},this.manager.onProgress=e=>{Bu()},this.manager.onError=e=>{Gu(),window.$message.error("数据加载失败，请刷新重试！")}}loadResources(){var e;this.textureLoader=new TT(this.manager),(e=JT.textures)==null||e.forEach(t=>{this.textureLoader.load(t.url,n=>{this.textures[t.name]=n})})}}const A5=(o,e,t)=>{let n=e*Math.PI/180;const i=t*Math.PI/180;n=-n;const a=o*Math.cos(i)*Math.cos(n),r=o*Math.sin(i),s=o*Math.cos(i)*Math.sin(n);return new Y(a,r,s)},ma=o=>{const e=new J9(1,1),t=o.textures.aperture,n=new O4({color:15310696,map:t,transparent:!0,opacity:1,depthWrite:!1}),i=new s3(e,n),a=A5(o.radius*1.001,o.lon,o.lat),r=o.radius*.12;i.scale.set(r,r,r),i.userData.size=r,i.userData.scale=Math.random()*1,i.position.set(a.x,a.y,a.z);const s=new Y(a.x,a.y,a.z).normalize(),u=new Y(0,0,1);return i.quaternion.setFromUnitVectors(u,s),i},ga=o=>{const e=o.radius*.3,t=new J9(o.radius*.05,e);t.rotateX(Math.PI/2),t.translate(0,0,e/2);const n=new O4({map:o.textures.light_column,color:o.index==0?o.punctuation.lightColumn.startColor:o.punctuation.lightColumn.endColor,transparent:!0,side:m4,depthWrite:!1}),i=new s3(t,n),a=new P4;a.add(i,i.clone().rotateZ(Math.PI/2));const r=A5(o.radius,o.lon,o.lat);a.position.set(r.x,r.y,r.z);const s=new Y(r.x,r.y,r.z).normalize(),u=new Y(0,0,1);return a.quaternion.setFromUnitVectors(u,s),a},_a=o=>{const e=new J9(1,1),t=new s3(e,o.material),n=A5(o.radius*1.001,o.lon,o.lat),i=o.radius*.05;t.scale.set(i,i,i),t.position.set(n.x,n.y,n.z);const a=new Y(n.x,n.y,n.z).normalize(),r=new Y(0,0,1);return t.quaternion.setFromUnitVectors(r,a),t},XT=o=>{const e=[];for(let t=0;t<2*Math.PI-.1;t+=2*Math.PI/(o.number||100))e.push([parseFloat((Math.cos(t)*(o.radius||10)).toFixed(2)),0,parseFloat((Math.sin(t)*(o.radius||10)).toFixed(2))]);return o.closed&&e.push(e[0]),e},QT=o=>{const e=[];o.pointList.forEach(i=>e.push(new Y(i[0],i[1],i[2])));const t=new Cs(e),n=new on(t,o.number||50,o.radius||1,o.radialSegments);return new s3(n,o.material)};function I4(o){if(o===void 0)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return o}function Rs(o,e){o.prototype=Object.create(e.prototype),o.prototype.constructor=o,o.__proto__=e}/*!
 * GSAP 3.11.5
 * https://greensock.com
 *
 * @license Copyright 2008-2023, GreenSock. All rights reserved.
 * Subject to the terms at https://greensock.com/standard-license or for
 * Club GreenSock members, the agreement issued with that membership.
 * @author: Jack Doyle, jack@greensock.com
*/var k3={autoSleep:120,force3D:"auto",nullTargetWarn:1,units:{lineHeight:""}},B9={duration:.5,overwrite:!1,delay:0},an,p3,Y2,Y3=1e8,w2=1/Y3,we=Math.PI*2,qT=we/4,KT=0,Os=Math.sqrt,eE=Math.cos,tE=Math.sin,i3=function(e){return typeof e=="string"},U2=function(e){return typeof e=="function"},U4=function(e){return typeof e=="number"},rn=function(e){return typeof e=="undefined"},b4=function(e){return typeof e=="object"},A3=function(e){return e!==!1},sn=function(){return typeof window!="undefined"},A8=function(e){return U2(e)||i3(e)},Ps=typeof ArrayBuffer=="function"&&ArrayBuffer.isView||function(){},m3=Array.isArray,Ce=/(?:-?\.?\d|\.)+/gi,Ls=/[-+=.]*\d+[.e\-+]*\d*[e\-+]*\d*/g,E9=/[-+=.]*\d+[.e-]*\d*[a-z%]*/g,a7=/[-+=.]*\d+\.?\d*(?:e-|e\+)?\d*/gi,zs=/[+-]=-?[.\d]+/,ks=/[^,'"\[\]\s]+/gi,nE=/^[+\-=e\s\d]*\d+[.\d]*([a-z]*|%)\s*$/i,D2,V3,Te,ln,N3={},j8={},Ns,Us=function(e){return(j8=V0(e,N3))&&T3},un=function(e,t){return console.warn("Invalid property",e,"set to",t,"Missing plugin? gsap.registerPlugin()")},W8=function(e,t){return!t&&console.warn(e)},Fs=function(e,t){return e&&(N3[e]=t)&&j8&&(j8[e]=t)||N3},w5=function(){return 0},iE={suppressEvents:!0,isStart:!0,kill:!1},I8={suppressEvents:!0,kill:!1},oE={suppressEvents:!0},cn={},a0=[],Ee={},Bs,P3={},r7={},va=30,R8=[],dn="",fn=function(e){var t=e[0],n,i;if(b4(t)||U2(t)||(e=[e]),!(n=(t._gsap||{}).harness)){for(i=R8.length;i--&&!R8[i].targetTest(t););n=R8[i]}for(i=e.length;i--;)e[i]&&(e[i]._gsap||(e[i]._gsap=new cl(e[i],n)))||e.splice(i,1);return e},z0=function(e){return e._gsap||fn($3(e))[0]._gsap},Gs=function(e,t,n){return(n=e[t])&&U2(n)?e[t]():rn(n)&&e.getAttribute&&e.getAttribute(t)||n},w3=function(e,t){return(e=e.split(",")).forEach(t)||e},G2=function(e){return Math.round(e*1e5)/1e5||0},r3=function(e){return Math.round(e*1e7)/1e7||0},O9=function(e,t){var n=t.charAt(0),i=parseFloat(t.substr(2));return e=parseFloat(e),n==="+"?e+i:n==="-"?e-i:n==="*"?e*i:e/i},aE=function(e,t){for(var n=t.length,i=0;e.indexOf(t[i])<0&&++i<n;);return i<n},H8=function(){var e=a0.length,t=a0.slice(0),n,i;for(Ee={},a0.length=0,n=0;n<e;n++)i=t[n],i&&i._lazy&&(i.render(i._lazy[0],i._lazy[1],!0)._lazy=0)},Vs=function(e,t,n,i){a0.length&&!p3&&H8(),e.render(t,n,i||p3&&t<0&&(e._initted||e._startAt)),a0.length&&!p3&&H8()},js=function(e){var t=parseFloat(e);return(t||t===0)&&(e+"").match(ks).length<2?t:i3(e)?e.trim():e},Ws=function(e){return e},q3=function(e,t){for(var n in t)n in e||(e[n]=t[n]);return e},rE=function(e){return function(t,n){for(var i in n)i in t||i==="duration"&&e||i==="ease"||(t[i]=n[i])}},V0=function(e,t){for(var n in t)e[n]=t[n];return e},ya=function o(e,t){for(var n in t)n!=="__proto__"&&n!=="constructor"&&n!=="prototype"&&(e[n]=b4(t[n])?o(e[n]||(e[n]={}),t[n]):t[n]);return e},Y8=function(e,t){var n={},i;for(i in e)i in t||(n[i]=e[i]);return n},_5=function(e){var t=e.parent||D2,n=e.keyframes?rE(m3(e.keyframes)):q3;if(A3(e.inherit))for(;t;)n(e,t.vars.defaults),t=t.parent||t._dp;return e},sE=function(e,t){for(var n=e.length,i=n===t.length;i&&n--&&e[n]===t[n];);return n<0},Hs=function(e,t,n,i,a){n===void 0&&(n="_first"),i===void 0&&(i="_last");var r=e[i],s;if(a)for(s=t[a];r&&r[a]>s;)r=r._prev;return r?(t._next=r._next,r._next=t):(t._next=e[n],e[n]=t),t._next?t._next._prev=t:e[i]=t,t._prev=r,t.parent=t._dp=e,t},a6=function(e,t,n,i){n===void 0&&(n="_first"),i===void 0&&(i="_last");var a=t._prev,r=t._next;a?a._next=r:e[n]===t&&(e[n]=r),r?r._prev=a:e[i]===t&&(e[i]=a),t._next=t._prev=t.parent=null},l0=function(e,t){e.parent&&(!t||e.parent.autoRemoveChildren)&&e.parent.remove(e),e._act=0},k0=function(e,t){if(e&&(!t||t._end>e._dur||t._start<0))for(var n=e;n;)n._dirty=1,n=n.parent;return e},lE=function(e){for(var t=e.parent;t&&t.parent;)t._dirty=1,t.totalDuration(),t=t.parent;return e},De=function(e,t,n,i){return e._startAt&&(p3?e._startAt.revert(I8):e.vars.immediateRender&&!e.vars.autoRevert||e._startAt.render(t,!0,i))},uE=function o(e){return!e||e._ts&&o(e.parent)},ba=function(e){return e._repeat?G9(e._tTime,e=e.duration()+e._rDelay)*e:0},G9=function(e,t){var n=Math.floor(e/=t);return e&&n===e?n-1:n},$8=function(e,t){return(e-t._start)*t._ts+(t._ts>=0?0:t._dirty?t.totalDuration():t._tDur)},r6=function(e){return e._end=r3(e._start+(e._tDur/Math.abs(e._ts||e._rts||w2)||0))},s6=function(e,t){var n=e._dp;return n&&n.smoothChildTiming&&e._ts&&(e._start=r3(n._time-(e._ts>0?t/e._ts:((e._dirty?e.totalDuration():e._tDur)-t)/-e._ts)),r6(e),n._dirty||k0(n,e)),e},Ys=function(e,t){var n;if((t._time||t._initted&&!t._dur)&&(n=$8(e.rawTime(),t),(!t._dur||B5(0,t.totalDuration(),n)-t._tTime>w2)&&t.render(n,!0)),k0(e,t)._dp&&e._initted&&e._time>=e._dur&&e._ts){if(e._dur<e.duration())for(n=e;n._dp;)n.rawTime()>=0&&n.totalTime(n._tTime),n=n._dp;e._zTime=-w2}},p4=function(e,t,n,i){return t.parent&&l0(t),t._start=r3((U4(n)?n:n||e!==D2?G3(e,n,t):e._time)+t._delay),t._end=r3(t._start+(t.totalDuration()/Math.abs(t.timeScale())||0)),Hs(e,t,"_first","_last",e._sort?"_start":0),Ie(t)||(e._recent=t),i||Ys(e,t),e._ts<0&&s6(e,e._tTime),e},$s=function(e,t){return(N3.ScrollTrigger||un("scrollTrigger",t))&&N3.ScrollTrigger.create(t,e)},Js=function(e,t,n,i,a){if(pn(e,t,a),!e._initted)return 1;if(!n&&e._pt&&!p3&&(e._dur&&e.vars.lazy!==!1||!e._dur&&e.vars.lazy)&&Bs!==L3.frame)return a0.push(e),e._lazy=[a,i],1},cE=function o(e){var t=e.parent;return t&&t._ts&&t._initted&&!t._lock&&(t.rawTime()<0||o(t))},Ie=function(e){var t=e.data;return t==="isFromStart"||t==="isStart"},dE=function(e,t,n,i){var a=e.ratio,r=t<0||!t&&(!e._start&&cE(e)&&!(!e._initted&&Ie(e))||(e._ts<0||e._dp._ts<0)&&!Ie(e))?0:1,s=e._rDelay,u=0,c,d,h;if(s&&e._repeat&&(u=B5(0,e._tDur,t),d=G9(u,s),e._yoyo&&d&1&&(r=1-r),d!==G9(e._tTime,s)&&(a=1-r,e.vars.repeatRefresh&&e._initted&&e.invalidate())),r!==a||p3||i||e._zTime===w2||!t&&e._zTime){if(!e._initted&&Js(e,t,i,n,u))return;for(h=e._zTime,e._zTime=t||(n?w2:0),n||(n=t&&!h),e.ratio=r,e._from&&(r=1-r),e._time=0,e._tTime=u,c=e._pt;c;)c.r(r,c.d),c=c._next;t<0&&De(e,t,n,!0),e._onUpdate&&!n&&J3(e,"onUpdate"),u&&e._repeat&&!n&&e.parent&&J3(e,"onRepeat"),(t>=e._tDur||t<0)&&e.ratio===r&&(r&&l0(e,1),!n&&!p3&&(J3(e,r?"onComplete":"onReverseComplete",!0),e._prom&&e._prom()))}else e._zTime||(e._zTime=t)},fE=function(e,t,n){var i;if(n>t)for(i=e._first;i&&i._start<=n;){if(i.data==="isPause"&&i._start>t)return i;i=i._next}else for(i=e._last;i&&i._start>=n;){if(i.data==="isPause"&&i._start<t)return i;i=i._prev}},V9=function(e,t,n,i){var a=e._repeat,r=r3(t)||0,s=e._tTime/e._tDur;return s&&!i&&(e._time*=r/e._dur),e._dur=r,e._tDur=a?a<0?1e10:r3(r*(a+1)+e._rDelay*a):r,s>0&&!i&&s6(e,e._tTime=e._tDur*s),e.parent&&r6(e),n||k0(e.parent,e),e},xa=function(e){return e instanceof S3?k0(e):V9(e,e._dur)},hE={_start:0,endTime:w5,totalDuration:w5},G3=function o(e,t,n){var i=e.labels,a=e._recent||hE,r=e.duration()>=Y3?a.endTime(!1):e._dur,s,u,c;return i3(t)&&(isNaN(t)||t in i)?(u=t.charAt(0),c=t.substr(-1)==="%",s=t.indexOf("="),u==="<"||u===">"?(s>=0&&(t=t.replace(/=/,"")),(u==="<"?a._start:a.endTime(a._repeat>=0))+(parseFloat(t.substr(1))||0)*(c?(s<0?a:n).totalDuration()/100:1)):s<0?(t in i||(i[t]=r),i[t]):(u=parseFloat(t.charAt(s-1)+t.substr(s+1)),c&&n&&(u=u/100*(m3(n)?n[0]:n).totalDuration()),s>1?o(e,t.substr(0,s-1),n)+u:r+u)):t==null?r:+t},v5=function(e,t,n){var i=U4(t[1]),a=(i?2:1)+(e<2?0:1),r=t[a],s,u;if(i&&(r.duration=t[1]),r.parent=n,e){for(s=r,u=n;u&&!("immediateRender"in s);)s=u.vars.defaults||{},u=A3(u.vars.inherit)&&u.parent;r.immediateRender=A3(s.immediateRender),e<2?r.runBackwards=1:r.startAt=t[a-1]}return new Q2(t[0],r,t[a+1])},p0=function(e,t){return e||e===0?t(e):t},B5=function(e,t,n){return n<e?e:n>t?t:n},f3=function(e,t){return!i3(e)||!(t=nE.exec(e))?"":t[1]},pE=function(e,t,n){return p0(n,function(i){return B5(e,t,i)})},Re=[].slice,Zs=function(e,t){return e&&b4(e)&&"length"in e&&(!t&&!e.length||e.length-1 in e&&b4(e[0]))&&!e.nodeType&&e!==V3},mE=function(e,t,n){return n===void 0&&(n=[]),e.forEach(function(i){var a;return i3(i)&&!t||Zs(i,1)?(a=n).push.apply(a,$3(i)):n.push(i)})||n},$3=function(e,t,n){return Y2&&!t&&Y2.selector?Y2.selector(e):i3(e)&&!n&&(Te||!j9())?Re.call((t||ln).querySelectorAll(e),0):m3(e)?mE(e,n):Zs(e)?Re.call(e,0):e?[e]:[]},Oe=function(e){return e=$3(e)[0]||W8("Invalid scope")||{},function(t){var n=e.current||e.nativeElement||e;return $3(t,n.querySelectorAll?n:n===e?W8("Invalid scope")||ln.createElement("div"):e)}},Xs=function(e){return e.sort(function(){return .5-Math.random()})},Qs=function(e){if(U2(e))return e;var t=b4(e)?e:{each:e},n=N0(t.ease),i=t.from||0,a=parseFloat(t.base)||0,r={},s=i>0&&i<1,u=isNaN(i)||s,c=t.axis,d=i,h=i;return i3(i)?d=h={center:.5,edges:.5,end:1}[i]||0:!s&&u&&(d=i[0],h=i[1]),function(p,g,y){var m=(y||t).length,v=r[m],b,x,w,M,A,S,D,C,E;if(!v){if(E=t.grid==="auto"?0:(t.grid||[1,Y3])[1],!E){for(D=-Y3;D<(D=y[E++].getBoundingClientRect().left)&&E<m;);E--}for(v=r[m]=[],b=u?Math.min(E,m)*d-.5:i%E,x=E===Y3?0:u?m*h/E-.5:i/E|0,D=0,C=Y3,S=0;S<m;S++)w=S%E-b,M=x-(S/E|0),v[S]=A=c?Math.abs(c==="y"?M:w):Os(w*w+M*M),A>D&&(D=A),A<C&&(C=A);i==="random"&&Xs(v),v.max=D-C,v.min=C,v.v=m=(parseFloat(t.amount)||parseFloat(t.each)*(E>m?m-1:c?c==="y"?m/E:E:Math.max(E,m/E))||0)*(i==="edges"?-1:1),v.b=m<0?a-m:a,v.u=f3(t.amount||t.each)||0,n=n&&m<0?sl(n):n}return m=(v[p]-v.min)/v.max||0,r3(v.b+(n?n(m):m)*v.v)+v.u}},Pe=function(e){var t=Math.pow(10,((e+"").split(".")[1]||"").length);return function(n){var i=r3(Math.round(parseFloat(n)/e)*e*t);return(i-i%1)/t+(U4(n)?0:f3(n))}},qs=function(e,t){var n=m3(e),i,a;return!n&&b4(e)&&(i=n=e.radius||Y3,e.values?(e=$3(e.values),(a=!U4(e[0]))&&(i*=i)):e=Pe(e.increment)),p0(t,n?U2(e)?function(r){return a=e(r),Math.abs(a-r)<=i?a:r}:function(r){for(var s=parseFloat(a?r.x:r),u=parseFloat(a?r.y:0),c=Y3,d=0,h=e.length,p,g;h--;)a?(p=e[h].x-s,g=e[h].y-u,p=p*p+g*g):p=Math.abs(e[h]-s),p<c&&(c=p,d=h);return d=!i||c<=i?e[d]:r,a||d===r||U4(r)?d:d+f3(r)}:Pe(e))},Ks=function(e,t,n,i){return p0(m3(e)?!t:n===!0?!!(n=0):!i,function(){return m3(e)?e[~~(Math.random()*e.length)]:(n=n||1e-5)&&(i=n<1?Math.pow(10,(n+"").length-2):1)&&Math.floor(Math.round((e-n/2+Math.random()*(t-e+n*.99))/n)*n*i)/i})},gE=function(){for(var e=arguments.length,t=new Array(e),n=0;n<e;n++)t[n]=arguments[n];return function(i){return t.reduce(function(a,r){return r(a)},i)}},_E=function(e,t){return function(n){return e(parseFloat(n))+(t||f3(n))}},vE=function(e,t,n){return tl(e,t,0,1,n)},el=function(e,t,n){return p0(n,function(i){return e[~~t(i)]})},yE=function o(e,t,n){var i=t-e;return m3(e)?el(e,o(0,e.length),t):p0(n,function(a){return(i+(a-e)%i)%i+e})},bE=function o(e,t,n){var i=t-e,a=i*2;return m3(e)?el(e,o(0,e.length-1),t):p0(n,function(r){return r=(a+(r-e)%a)%a||0,e+(r>i?a-r:r)})},C5=function(e){for(var t=0,n="",i,a,r,s;~(i=e.indexOf("random(",t));)r=e.indexOf(")",i),s=e.charAt(i+7)==="[",a=e.substr(i+7,r-i-7).match(s?ks:Ce),n+=e.substr(t,i-t)+Ks(s?a:+a[0],s?0:+a[1],+a[2]||1e-5),t=r+1;return n+e.substr(t,e.length-t)},tl=function(e,t,n,i,a){var r=t-e,s=i-n;return p0(a,function(u){return n+((u-e)/r*s||0)})},xE=function o(e,t,n,i){var a=isNaN(e+t)?0:function(g){return(1-g)*e+g*t};if(!a){var r=i3(e),s={},u,c,d,h,p;if(n===!0&&(i=1)&&(n=null),r)e={p:e},t={p:t};else if(m3(e)&&!m3(t)){for(d=[],h=e.length,p=h-2,c=1;c<h;c++)d.push(o(e[c-1],e[c]));h--,a=function(y){y*=h;var m=Math.min(p,~~y);return d[m](y-m)},n=t}else i||(e=V0(m3(e)?[]:{},e));if(!d){for(u in t)hn.call(s,e,u,"get",t[u]);a=function(y){return _n(y,s)||(r?e.p:e)}}}return p0(n,a)},Sa=function(e,t,n){var i=e.labels,a=Y3,r,s,u;for(r in i)s=i[r]-t,s<0==!!n&&s&&a>(s=Math.abs(s))&&(u=r,a=s);return u},J3=function(e,t,n){var i=e.vars,a=i[t],r=Y2,s=e._ctx,u,c,d;if(a)return u=i[t+"Params"],c=i.callbackScope||e,n&&a0.length&&H8(),s&&(Y2=s),d=u?a.apply(c,u):a.call(c),Y2=r,d},f5=function(e){return l0(e),e.scrollTrigger&&e.scrollTrigger.kill(!!p3),e.progress()<1&&J3(e,"onInterrupt"),e},D9,nl=[],il=function(e){if(!sn()){nl.push(e);return}e=!e.name&&e.default||e;var t=e.name,n=U2(e),i=t&&!n&&e.init?function(){this._props=[]}:e,a={init:w5,render:_n,add:hn,kill:NE,modifier:kE,rawVars:0},r={targetTest:0,get:0,getSetter:gn,aliases:{},register:0};if(j9(),e!==i){if(P3[t])return;q3(i,q3(Y8(e,a),r)),V0(i.prototype,V0(a,Y8(e,r))),P3[i.prop=t]=i,e.targetTest&&(R8.push(i),cn[t]=1),t=(t==="css"?"CSS":t.charAt(0).toUpperCase()+t.substr(1))+"Plugin"}Fs(t,i),e.register&&e.register(T3,i,C3)},A2=255,h5={aqua:[0,A2,A2],lime:[0,A2,0],silver:[192,192,192],black:[0,0,0],maroon:[128,0,0],teal:[0,128,128],blue:[0,0,A2],navy:[0,0,128],white:[A2,A2,A2],olive:[128,128,0],yellow:[A2,A2,0],orange:[A2,165,0],gray:[128,128,128],purple:[128,0,128],green:[0,128,0],red:[A2,0,0],pink:[A2,192,203],cyan:[0,A2,A2],transparent:[A2,A2,A2,0]},s7=function(e,t,n){return e+=e<0?1:e>1?-1:0,(e*6<1?t+(n-t)*e*6:e<.5?n:e*3<2?t+(n-t)*(2/3-e)*6:t)*A2+.5|0},ol=function(e,t,n){var i=e?U4(e)?[e>>16,e>>8&A2,e&A2]:0:h5.black,a,r,s,u,c,d,h,p,g,y;if(!i){if(e.substr(-1)===","&&(e=e.substr(0,e.length-1)),h5[e])i=h5[e];else if(e.charAt(0)==="#"){if(e.length<6&&(a=e.charAt(1),r=e.charAt(2),s=e.charAt(3),e="#"+a+a+r+r+s+s+(e.length===5?e.charAt(4)+e.charAt(4):"")),e.length===9)return i=parseInt(e.substr(1,6),16),[i>>16,i>>8&A2,i&A2,parseInt(e.substr(7),16)/255];e=parseInt(e.substr(1),16),i=[e>>16,e>>8&A2,e&A2]}else if(e.substr(0,3)==="hsl"){if(i=y=e.match(Ce),!t)u=+i[0]%360/360,c=+i[1]/100,d=+i[2]/100,r=d<=.5?d*(c+1):d+c-d*c,a=d*2-r,i.length>3&&(i[3]*=1),i[0]=s7(u+1/3,a,r),i[1]=s7(u,a,r),i[2]=s7(u-1/3,a,r);else if(~e.indexOf("="))return i=e.match(Ls),n&&i.length<4&&(i[3]=1),i}else i=e.match(Ce)||h5.transparent;i=i.map(Number)}return t&&!y&&(a=i[0]/A2,r=i[1]/A2,s=i[2]/A2,h=Math.max(a,r,s),p=Math.min(a,r,s),d=(h+p)/2,h===p?u=c=0:(g=h-p,c=d>.5?g/(2-h-p):g/(h+p),u=h===a?(r-s)/g+(r<s?6:0):h===r?(s-a)/g+2:(a-r)/g+4,u*=60),i[0]=~~(u+.5),i[1]=~~(c*100+.5),i[2]=~~(d*100+.5)),n&&i.length<4&&(i[3]=1),i},al=function(e){var t=[],n=[],i=-1;return e.split(r0).forEach(function(a){var r=a.match(E9)||[];t.push.apply(t,r),n.push(i+=r.length+1)}),t.c=n,t},Ma=function(e,t,n){var i="",a=(e+i).match(r0),r=t?"hsla(":"rgba(",s=0,u,c,d,h;if(!a)return e;if(a=a.map(function(p){return(p=ol(p,t,1))&&r+(t?p[0]+","+p[1]+"%,"+p[2]+"%,"+p[3]:p.join(","))+")"}),n&&(d=al(e),u=n.c,u.join(i)!==d.c.join(i)))for(c=e.replace(r0,"1").split(E9),h=c.length-1;s<h;s++)i+=c[s]+(~u.indexOf(s)?a.shift()||r+"0,0,0,0)":(d.length?d:a.length?a:n).shift());if(!c)for(c=e.split(r0),h=c.length-1;s<h;s++)i+=c[s]+a[s];return i+c[h]},r0=function(){var o="(?:\\b(?:(?:rgb|rgba|hsl|hsla)\\(.+?\\))|\\B#(?:[0-9a-f]{3,4}){1,2}\\b",e;for(e in h5)o+="|"+e+"\\b";return new RegExp(o+")","gi")}(),SE=/hsl[a]?\(/,rl=function(e){var t=e.join(" "),n;if(r0.lastIndex=0,r0.test(t))return n=SE.test(t),e[1]=Ma(e[1],n),e[0]=Ma(e[0],n,al(e[1])),!0},T5,L3=function(){var o=Date.now,e=500,t=33,n=o(),i=n,a=1e3/240,r=a,s=[],u,c,d,h,p,g,y=function m(v){var b=o()-i,x=v===!0,w,M,A,S;if(b>e&&(n+=b-t),i+=b,A=i-n,w=A-r,(w>0||x)&&(S=++h.frame,p=A-h.time*1e3,h.time=A=A/1e3,r+=w+(w>=a?4:a-w),M=1),x||(u=c(m)),M)for(g=0;g<s.length;g++)s[g](A,p,S,v)};return h={time:0,frame:0,tick:function(){y(!0)},deltaRatio:function(v){return p/(1e3/(v||60))},wake:function(){Ns&&(!Te&&sn()&&(V3=Te=window,ln=V3.document||{},N3.gsap=T3,(V3.gsapVersions||(V3.gsapVersions=[])).push(T3.version),Us(j8||V3.GreenSockGlobals||!V3.gsap&&V3||{}),d=V3.requestAnimationFrame,nl.forEach(il)),u&&h.sleep(),c=d||function(v){return setTimeout(v,r-h.time*1e3+1|0)},T5=1,y(2))},sleep:function(){(d?V3.cancelAnimationFrame:clearTimeout)(u),T5=0,c=w5},lagSmoothing:function(v,b){e=v||1/0,t=Math.min(b||33,e)},fps:function(v){a=1e3/(v||240),r=h.time*1e3+a},add:function(v,b,x){var w=b?function(M,A,S,D){v(M,A,S,D),h.remove(w)}:v;return h.remove(v),s[x?"unshift":"push"](w),j9(),w},remove:function(v,b){~(b=s.indexOf(v))&&s.splice(b,1)&&g>=b&&g--},_listeners:s},h}(),j9=function(){return!T5&&L3.wake()},f2={},ME=/^[\d.\-M][\d.\-,\s]/,AE=/["']/g,wE=function(e){for(var t={},n=e.substr(1,e.length-3).split(":"),i=n[0],a=1,r=n.length,s,u,c;a<r;a++)u=n[a],s=a!==r-1?u.lastIndexOf(","):u.length,c=u.substr(0,s),t[i]=isNaN(c)?c.replace(AE,"").trim():+c,i=u.substr(s+1).trim();return t},CE=function(e){var t=e.indexOf("(")+1,n=e.indexOf(")"),i=e.indexOf("(",t);return e.substring(t,~i&&i<n?e.indexOf(")",n+1):n)},TE=function(e){var t=(e+"").split("("),n=f2[t[0]];return n&&t.length>1&&n.config?n.config.apply(null,~e.indexOf("{")?[wE(t[1])]:CE(e).split(",").map(js)):f2._CE&&ME.test(e)?f2._CE("",e):n},sl=function(e){return function(t){return 1-e(1-t)}},ll=function o(e,t){for(var n=e._first,i;n;)n instanceof S3?o(n,t):n.vars.yoyoEase&&(!n._yoyo||!n._repeat)&&n._yoyo!==t&&(n.timeline?o(n.timeline,t):(i=n._ease,n._ease=n._yEase,n._yEase=i,n._yoyo=t)),n=n._next},N0=function(e,t){return e&&(U2(e)?e:f2[e]||TE(e))||t},$0=function(e,t,n,i){n===void 0&&(n=function(u){return 1-t(1-u)}),i===void 0&&(i=function(u){return u<.5?t(u*2)/2:1-t((1-u)*2)/2});var a={easeIn:t,easeOut:n,easeInOut:i},r;return w3(e,function(s){f2[s]=N3[s]=a,f2[r=s.toLowerCase()]=n;for(var u in a)f2[r+(u==="easeIn"?".in":u==="easeOut"?".out":".inOut")]=f2[s+"."+u]=a[u]}),a},ul=function(e){return function(t){return t<.5?(1-e(1-t*2))/2:.5+e((t-.5)*2)/2}},l7=function o(e,t,n){var i=t>=1?t:1,a=(n||(e?.3:.45))/(t<1?t:1),r=a/we*(Math.asin(1/i)||0),s=function(d){return d===1?1:i*Math.pow(2,-10*d)*tE((d-r)*a)+1},u=e==="out"?s:e==="in"?function(c){return 1-s(1-c)}:ul(s);return a=we/a,u.config=function(c,d){return o(e,c,d)},u},u7=function o(e,t){t===void 0&&(t=1.70158);var n=function(r){return r?--r*r*((t+1)*r+t)+1:0},i=e==="out"?n:e==="in"?function(a){return 1-n(1-a)}:ul(n);return i.config=function(a){return o(e,a)},i};w3("Linear,Quad,Cubic,Quart,Quint,Strong",function(o,e){var t=e<5?e+1:e;$0(o+",Power"+(t-1),e?function(n){return Math.pow(n,t)}:function(n){return n},function(n){return 1-Math.pow(1-n,t)},function(n){return n<.5?Math.pow(n*2,t)/2:1-Math.pow((1-n)*2,t)/2})});f2.Linear.easeNone=f2.none=f2.Linear.easeIn;$0("Elastic",l7("in"),l7("out"),l7());(function(o,e){var t=1/e,n=2*t,i=2.5*t,a=function(s){return s<t?o*s*s:s<n?o*Math.pow(s-1.5/e,2)+.75:s<i?o*(s-=2.25/e)*s+.9375:o*Math.pow(s-2.625/e,2)+.984375};$0("Bounce",function(r){return 1-a(1-r)},a)})(7.5625,2.75);$0("Expo",function(o){return o?Math.pow(2,10*(o-1)):0});$0("Circ",function(o){return-(Os(1-o*o)-1)});$0("Sine",function(o){return o===1?1:-eE(o*qT)+1});$0("Back",u7("in"),u7("out"),u7());f2.SteppedEase=f2.steps=N3.SteppedEase={config:function(e,t){e===void 0&&(e=1);var n=1/e,i=e+(t?0:1),a=t?1:0,r=1-w2;return function(s){return((i*B5(0,r,s)|0)+a)*n}}};B9.ease=f2["quad.out"];w3("onComplete,onUpdate,onStart,onRepeat,onReverseComplete,onInterrupt",function(o){return dn+=o+","+o+"Params,"});var cl=function(e,t){this.id=KT++,e._gsap=this,this.target=e,this.harness=t,this.get=t?t.get:Gs,this.set=t?t.getSetter:gn},W9=function(){function o(t){this.vars=t,this._delay=+t.delay||0,(this._repeat=t.repeat===1/0?-2:t.repeat||0)&&(this._rDelay=t.repeatDelay||0,this._yoyo=!!t.yoyo||!!t.yoyoEase),this._ts=1,V9(this,+t.duration,1,1),this.data=t.data,Y2&&(this._ctx=Y2,Y2.data.push(this)),T5||L3.wake()}var e=o.prototype;return e.delay=function(n){return n||n===0?(this.parent&&this.parent.smoothChildTiming&&this.startTime(this._start+n-this._delay),this._delay=n,this):this._delay},e.duration=function(n){return arguments.length?this.totalDuration(this._repeat>0?n+(n+this._rDelay)*this._repeat:n):this.totalDuration()&&this._dur},e.totalDuration=function(n){return arguments.length?(this._dirty=0,V9(this,this._repeat<0?n:(n-this._repeat*this._rDelay)/(this._repeat+1))):this._tDur},e.totalTime=function(n,i){if(j9(),!arguments.length)return this._tTime;var a=this._dp;if(a&&a.smoothChildTiming&&this._ts){for(s6(this,n),!a._dp||a.parent||Ys(a,this);a&&a.parent;)a.parent._time!==a._start+(a._ts>=0?a._tTime/a._ts:(a.totalDuration()-a._tTime)/-a._ts)&&a.totalTime(a._tTime,!0),a=a.parent;!this.parent&&this._dp.autoRemoveChildren&&(this._ts>0&&n<this._tDur||this._ts<0&&n>0||!this._tDur&&!n)&&p4(this._dp,this,this._start-this._delay)}return(this._tTime!==n||!this._dur&&!i||this._initted&&Math.abs(this._zTime)===w2||!n&&!this._initted&&(this.add||this._ptLookup))&&(this._ts||(this._pTime=n),Vs(this,n,i)),this},e.time=function(n,i){return arguments.length?this.totalTime(Math.min(this.totalDuration(),n+ba(this))%(this._dur+this._rDelay)||(n?this._dur:0),i):this._time},e.totalProgress=function(n,i){return arguments.length?this.totalTime(this.totalDuration()*n,i):this.totalDuration()?Math.min(1,this._tTime/this._tDur):this.ratio},e.progress=function(n,i){return arguments.length?this.totalTime(this.duration()*(this._yoyo&&!(this.iteration()&1)?1-n:n)+ba(this),i):this.duration()?Math.min(1,this._time/this._dur):this.ratio},e.iteration=function(n,i){var a=this.duration()+this._rDelay;return arguments.length?this.totalTime(this._time+(n-1)*a,i):this._repeat?G9(this._tTime,a)+1:1},e.timeScale=function(n){if(!arguments.length)return this._rts===-w2?0:this._rts;if(this._rts===n)return this;var i=this.parent&&this._ts?$8(this.parent._time,this):this._tTime;return this._rts=+n||0,this._ts=this._ps||n===-w2?0:this._rts,this.totalTime(B5(-Math.abs(this._delay),this._tDur,i),!0),r6(this),lE(this)},e.paused=function(n){return arguments.length?(this._ps!==n&&(this._ps=n,n?(this._pTime=this._tTime||Math.max(-this._delay,this.rawTime()),this._ts=this._act=0):(j9(),this._ts=this._rts,this.totalTime(this.parent&&!this.parent.smoothChildTiming?this.rawTime():this._tTime||this._pTime,this.progress()===1&&Math.abs(this._zTime)!==w2&&(this._tTime-=w2)))),this):this._ps},e.startTime=function(n){if(arguments.length){this._start=n;var i=this.parent||this._dp;return i&&(i._sort||!this.parent)&&p4(i,this,n-this._delay),this}return this._start},e.endTime=function(n){return this._start+(A3(n)?this.totalDuration():this.duration())/Math.abs(this._ts||1)},e.rawTime=function(n){var i=this.parent||this._dp;return i?n&&(!this._ts||this._repeat&&this._time&&this.totalProgress()<1)?this._tTime%(this._dur+this._rDelay):this._ts?$8(i.rawTime(n),this):this._tTime:this._tTime},e.revert=function(n){n===void 0&&(n=oE);var i=p3;return p3=n,(this._initted||this._startAt)&&(this.timeline&&this.timeline.revert(n),this.totalTime(-.01,n.suppressEvents)),this.data!=="nested"&&n.kill!==!1&&this.kill(),p3=i,this},e.globalTime=function(n){for(var i=this,a=arguments.length?n:i.rawTime();i;)a=i._start+a/(i._ts||1),i=i._dp;return!this.parent&&this._sat?this._sat.vars.immediateRender?-1:this._sat.globalTime(n):a},e.repeat=function(n){return arguments.length?(this._repeat=n===1/0?-2:n,xa(this)):this._repeat===-2?1/0:this._repeat},e.repeatDelay=function(n){if(arguments.length){var i=this._time;return this._rDelay=n,xa(this),i?this.time(i):this}return this._rDelay},e.yoyo=function(n){return arguments.length?(this._yoyo=n,this):this._yoyo},e.seek=function(n,i){return this.totalTime(G3(this,n),A3(i))},e.restart=function(n,i){return this.play().totalTime(n?-this._delay:0,A3(i))},e.play=function(n,i){return n!=null&&this.seek(n,i),this.reversed(!1).paused(!1)},e.reverse=function(n,i){return n!=null&&this.seek(n||this.totalDuration(),i),this.reversed(!0).paused(!1)},e.pause=function(n,i){return n!=null&&this.seek(n,i),this.paused(!0)},e.resume=function(){return this.paused(!1)},e.reversed=function(n){return arguments.length?(!!n!==this.reversed()&&this.timeScale(-this._rts||(n?-w2:0)),this):this._rts<0},e.invalidate=function(){return this._initted=this._act=0,this._zTime=-w2,this},e.isActive=function(){var n=this.parent||this._dp,i=this._start,a;return!!(!n||this._ts&&this._initted&&n.isActive()&&(a=n.rawTime(!0))>=i&&a<this.endTime(!0)-w2)},e.eventCallback=function(n,i,a){var r=this.vars;return arguments.length>1?(i?(r[n]=i,a&&(r[n+"Params"]=a),n==="onUpdate"&&(this._onUpdate=i)):delete r[n],this):r[n]},e.then=function(n){var i=this;return new Promise(function(a){var r=U2(n)?n:Ws,s=function(){var c=i.then;i.then=null,U2(r)&&(r=r(i))&&(r.then||r===i)&&(i.then=c),a(r),i.then=c};i._initted&&i.totalProgress()===1&&i._ts>=0||!i._tTime&&i._ts<0?s():i._prom=s})},e.kill=function(){f5(this)},o}();q3(W9.prototype,{_time:0,_start:0,_end:0,_tTime:0,_tDur:0,_dirty:0,_repeat:0,_yoyo:!1,parent:null,_initted:!1,_rDelay:0,_ts:1,_dp:0,ratio:0,_zTime:-w2,_prom:0,_ps:!1,_rts:1});var S3=function(o){Rs(e,o);function e(n,i){var a;return n===void 0&&(n={}),a=o.call(this,n)||this,a.labels={},a.smoothChildTiming=!!n.smoothChildTiming,a.autoRemoveChildren=!!n.autoRemoveChildren,a._sort=A3(n.sortChildren),D2&&p4(n.parent||D2,I4(a),i),n.reversed&&a.reverse(),n.paused&&a.paused(!0),n.scrollTrigger&&$s(I4(a),n.scrollTrigger),a}var t=e.prototype;return t.to=function(i,a,r){return v5(0,arguments,this),this},t.from=function(i,a,r){return v5(1,arguments,this),this},t.fromTo=function(i,a,r,s){return v5(2,arguments,this),this},t.set=function(i,a,r){return a.duration=0,a.parent=this,_5(a).repeatDelay||(a.repeat=0),a.immediateRender=!!a.immediateRender,new Q2(i,a,G3(this,r),1),this},t.call=function(i,a,r){return p4(this,Q2.delayedCall(0,i,a),r)},t.staggerTo=function(i,a,r,s,u,c,d){return r.duration=a,r.stagger=r.stagger||s,r.onComplete=c,r.onCompleteParams=d,r.parent=this,new Q2(i,r,G3(this,u)),this},t.staggerFrom=function(i,a,r,s,u,c,d){return r.runBackwards=1,_5(r).immediateRender=A3(r.immediateRender),this.staggerTo(i,a,r,s,u,c,d)},t.staggerFromTo=function(i,a,r,s,u,c,d,h){return s.startAt=r,_5(s).immediateRender=A3(s.immediateRender),this.staggerTo(i,a,s,u,c,d,h)},t.render=function(i,a,r){var s=this._time,u=this._dirty?this.totalDuration():this._tDur,c=this._dur,d=i<=0?0:r3(i),h=this._zTime<0!=i<0&&(this._initted||!c),p,g,y,m,v,b,x,w,M,A,S,D;if(this!==D2&&d>u&&i>=0&&(d=u),d!==this._tTime||r||h){if(s!==this._time&&c&&(d+=this._time-s,i+=this._time-s),p=d,M=this._start,w=this._ts,b=!w,h&&(c||(s=this._zTime),(i||!a)&&(this._zTime=i)),this._repeat){if(S=this._yoyo,v=c+this._rDelay,this._repeat<-1&&i<0)return this.totalTime(v*100+i,a,r);if(p=r3(d%v),d===u?(m=this._repeat,p=c):(m=~~(d/v),m&&m===d/v&&(p=c,m--),p>c&&(p=c)),A=G9(this._tTime,v),!s&&this._tTime&&A!==m&&this._tTime-A*v-this._dur<=0&&(A=m),S&&m&1&&(p=c-p,D=1),m!==A&&!this._lock){var C=S&&A&1,E=C===(S&&m&1);if(m<A&&(C=!C),s=C?0:c,this._lock=1,this.render(s||(D?0:r3(m*v)),a,!c)._lock=0,this._tTime=d,!a&&this.parent&&J3(this,"onRepeat"),this.vars.repeatRefresh&&!D&&(this.invalidate()._lock=1),s&&s!==this._time||b!==!this._ts||this.vars.onRepeat&&!this.parent&&!this._act)return this;if(c=this._dur,u=this._tDur,E&&(this._lock=2,s=C?c:-1e-4,this.render(s,!0),this.vars.repeatRefresh&&!D&&this.invalidate()),this._lock=0,!this._ts&&!b)return this;ll(this,D)}}if(this._hasPause&&!this._forcing&&this._lock<2&&(x=fE(this,r3(s),r3(p)),x&&(d-=p-(p=x._start))),this._tTime=d,this._time=p,this._act=!w,this._initted||(this._onUpdate=this.vars.onUpdate,this._initted=1,this._zTime=i,s=0),!s&&p&&!a&&!m&&(J3(this,"onStart"),this._tTime!==d))return this;if(p>=s&&i>=0)for(g=this._first;g;){if(y=g._next,(g._act||p>=g._start)&&g._ts&&x!==g){if(g.parent!==this)return this.render(i,a,r);if(g.render(g._ts>0?(p-g._start)*g._ts:(g._dirty?g.totalDuration():g._tDur)+(p-g._start)*g._ts,a,r),p!==this._time||!this._ts&&!b){x=0,y&&(d+=this._zTime=-w2);break}}g=y}else{g=this._last;for(var k=i<0?i:p;g;){if(y=g._prev,(g._act||k<=g._end)&&g._ts&&x!==g){if(g.parent!==this)return this.render(i,a,r);if(g.render(g._ts>0?(k-g._start)*g._ts:(g._dirty?g.totalDuration():g._tDur)+(k-g._start)*g._ts,a,r||p3&&(g._initted||g._startAt)),p!==this._time||!this._ts&&!b){x=0,y&&(d+=this._zTime=k?-w2:w2);break}}g=y}}if(x&&!a&&(this.pause(),x.render(p>=s?0:-w2)._zTime=p>=s?1:-1,this._ts))return this._start=M,r6(this),this.render(i,a,r);this._onUpdate&&!a&&J3(this,"onUpdate",!0),(d===u&&this._tTime>=this.totalDuration()||!d&&s)&&(M===this._start||Math.abs(w)!==Math.abs(this._ts))&&(this._lock||((i||!c)&&(d===u&&this._ts>0||!d&&this._ts<0)&&l0(this,1),!a&&!(i<0&&!s)&&(d||s||!u)&&(J3(this,d===u&&i>=0?"onComplete":"onReverseComplete",!0),this._prom&&!(d<u&&this.timeScale()>0)&&this._prom())))}return this},t.add=function(i,a){var r=this;if(U4(a)||(a=G3(this,a,i)),!(i instanceof W9)){if(m3(i))return i.forEach(function(s){return r.add(s,a)}),this;if(i3(i))return this.addLabel(i,a);if(U2(i))i=Q2.delayedCall(0,i);else return this}return this!==i?p4(this,i,a):this},t.getChildren=function(i,a,r,s){i===void 0&&(i=!0),a===void 0&&(a=!0),r===void 0&&(r=!0),s===void 0&&(s=-Y3);for(var u=[],c=this._first;c;)c._start>=s&&(c instanceof Q2?a&&u.push(c):(r&&u.push(c),i&&u.push.apply(u,c.getChildren(!0,a,r)))),c=c._next;return u},t.getById=function(i){for(var a=this.getChildren(1,1,1),r=a.length;r--;)if(a[r].vars.id===i)return a[r]},t.remove=function(i){return i3(i)?this.removeLabel(i):U2(i)?this.killTweensOf(i):(a6(this,i),i===this._recent&&(this._recent=this._last),k0(this))},t.totalTime=function(i,a){return arguments.length?(this._forcing=1,!this._dp&&this._ts&&(this._start=r3(L3.time-(this._ts>0?i/this._ts:(this.totalDuration()-i)/-this._ts))),o.prototype.totalTime.call(this,i,a),this._forcing=0,this):this._tTime},t.addLabel=function(i,a){return this.labels[i]=G3(this,a),this},t.removeLabel=function(i){return delete this.labels[i],this},t.addPause=function(i,a,r){var s=Q2.delayedCall(0,a||w5,r);return s.data="isPause",this._hasPause=1,p4(this,s,G3(this,i))},t.removePause=function(i){var a=this._first;for(i=G3(this,i);a;)a._start===i&&a.data==="isPause"&&l0(a),a=a._next},t.killTweensOf=function(i,a,r){for(var s=this.getTweensOf(i,r),u=s.length;u--;)e0!==s[u]&&s[u].kill(i,a);return this},t.getTweensOf=function(i,a){for(var r=[],s=$3(i),u=this._first,c=U4(a),d;u;)u instanceof Q2?aE(u._targets,s)&&(c?(!e0||u._initted&&u._ts)&&u.globalTime(0)<=a&&u.globalTime(u.totalDuration())>a:!a||u.isActive())&&r.push(u):(d=u.getTweensOf(s,a)).length&&r.push.apply(r,d),u=u._next;return r},t.tweenTo=function(i,a){a=a||{};var r=this,s=G3(r,i),u=a,c=u.startAt,d=u.onStart,h=u.onStartParams,p=u.immediateRender,g,y=Q2.to(r,q3({ease:a.ease||"none",lazy:!1,immediateRender:!1,time:s,overwrite:"auto",duration:a.duration||Math.abs((s-(c&&"time"in c?c.time:r._time))/r.timeScale())||w2,onStart:function(){if(r.pause(),!g){var v=a.duration||Math.abs((s-(c&&"time"in c?c.time:r._time))/r.timeScale());y._dur!==v&&V9(y,v,0,1).render(y._time,!0,!0),g=1}d&&d.apply(y,h||[])}},a));return p?y.render(0):y},t.tweenFromTo=function(i,a,r){return this.tweenTo(a,q3({startAt:{time:G3(this,i)}},r))},t.recent=function(){return this._recent},t.nextLabel=function(i){return i===void 0&&(i=this._time),Sa(this,G3(this,i))},t.previousLabel=function(i){return i===void 0&&(i=this._time),Sa(this,G3(this,i),1)},t.currentLabel=function(i){return arguments.length?this.seek(i,!0):this.previousLabel(this._time+w2)},t.shiftChildren=function(i,a,r){r===void 0&&(r=0);for(var s=this._first,u=this.labels,c;s;)s._start>=r&&(s._start+=i,s._end+=i),s=s._next;if(a)for(c in u)u[c]>=r&&(u[c]+=i);return k0(this)},t.invalidate=function(i){var a=this._first;for(this._lock=0;a;)a.invalidate(i),a=a._next;return o.prototype.invalidate.call(this,i)},t.clear=function(i){i===void 0&&(i=!0);for(var a=this._first,r;a;)r=a._next,this.remove(a),a=r;return this._dp&&(this._time=this._tTime=this._pTime=0),i&&(this.labels={}),k0(this)},t.totalDuration=function(i){var a=0,r=this,s=r._last,u=Y3,c,d,h;if(arguments.length)return r.timeScale((r._repeat<0?r.duration():r.totalDuration())/(r.reversed()?-i:i));if(r._dirty){for(h=r.parent;s;)c=s._prev,s._dirty&&s.totalDuration(),d=s._start,d>u&&r._sort&&s._ts&&!r._lock?(r._lock=1,p4(r,s,d-s._delay,1)._lock=0):u=d,d<0&&s._ts&&(a-=d,(!h&&!r._dp||h&&h.smoothChildTiming)&&(r._start+=d/r._ts,r._time-=d,r._tTime-=d),r.shiftChildren(-d,!1,-1/0),u=0),s._end>a&&s._ts&&(a=s._end),s=c;V9(r,r===D2&&r._time>a?r._time:a,1,1),r._dirty=0}return r._tDur},e.updateRoot=function(i){if(D2._ts&&(Vs(D2,$8(i,D2)),Bs=L3.frame),L3.frame>=va){va+=k3.autoSleep||120;var a=D2._first;if((!a||!a._ts)&&k3.autoSleep&&L3._listeners.length<2){for(;a&&!a._ts;)a=a._next;a||L3.sleep()}}},e}(W9);q3(S3.prototype,{_lock:0,_hasPause:0,_forcing:0});var EE=function(e,t,n,i,a,r,s){var u=new C3(this._pt,e,t,0,1,gl,null,a),c=0,d=0,h,p,g,y,m,v,b,x;for(u.b=n,u.e=i,n+="",i+="",(b=~i.indexOf("random("))&&(i=C5(i)),r&&(x=[n,i],r(x,e,t),n=x[0],i=x[1]),p=n.match(a7)||[];h=a7.exec(i);)y=h[0],m=i.substring(c,h.index),g?g=(g+1)%5:m.substr(-5)==="rgba("&&(g=1),y!==p[d++]&&(v=parseFloat(p[d-1])||0,u._pt={_next:u._pt,p:m||d===1?m:",",s:v,c:y.charAt(1)==="="?O9(v,y)-v:parseFloat(y)-v,m:g&&g<4?Math.round:0},c=a7.lastIndex);return u.c=c<i.length?i.substring(c,i.length):"",u.fp=s,(zs.test(i)||b)&&(u.e=0),this._pt=u,u},hn=function(e,t,n,i,a,r,s,u,c,d){U2(i)&&(i=i(a||0,e,r));var h=e[t],p=n!=="get"?n:U2(h)?c?e[t.indexOf("set")||!U2(e["get"+t.substr(3)])?t:"get"+t.substr(3)](c):e[t]():h,g=U2(h)?c?PE:pl:mn,y;if(i3(i)&&(~i.indexOf("random(")&&(i=C5(i)),i.charAt(1)==="="&&(y=O9(p,i)+(f3(p)||0),(y||y===0)&&(i=y))),!d||p!==i||Le)return!isNaN(p*i)&&i!==""?(y=new C3(this._pt,e,t,+p||0,i-(p||0),typeof h=="boolean"?zE:ml,0,g),c&&(y.fp=c),s&&y.modifier(s,this,e),this._pt=y):(!h&&!(t in e)&&un(t,i),EE.call(this,e,t,p,i,g,u||k3.stringFilter,c))},DE=function(e,t,n,i,a){if(U2(e)&&(e=y5(e,a,t,n,i)),!b4(e)||e.style&&e.nodeType||m3(e)||Ps(e))return i3(e)?y5(e,a,t,n,i):e;var r={},s;for(s in e)r[s]=y5(e[s],a,t,n,i);return r},dl=function(e,t,n,i,a,r){var s,u,c,d;if(P3[e]&&(s=new P3[e]).init(a,s.rawVars?t[e]:DE(t[e],i,a,r,n),n,i,r)!==!1&&(n._pt=u=new C3(n._pt,a,e,0,1,s.render,s,0,s.priority),n!==D9))for(c=n._ptLookup[n._targets.indexOf(a)],d=s._props.length;d--;)c[s._props[d]]=u;return s},e0,Le,pn=function o(e,t,n){var i=e.vars,a=i.ease,r=i.startAt,s=i.immediateRender,u=i.lazy,c=i.onUpdate,d=i.onUpdateParams,h=i.callbackScope,p=i.runBackwards,g=i.yoyoEase,y=i.keyframes,m=i.autoRevert,v=e._dur,b=e._startAt,x=e._targets,w=e.parent,M=w&&w.data==="nested"?w.vars.targets:x,A=e._overwrite==="auto"&&!an,S=e.timeline,D,C,E,k,$,X,F,R,U,H,V,N,z;if(S&&(!y||!a)&&(a="none"),e._ease=N0(a,B9.ease),e._yEase=g?sl(N0(g===!0?a:g,B9.ease)):0,g&&e._yoyo&&!e._repeat&&(g=e._yEase,e._yEase=e._ease,e._ease=g),e._from=!S&&!!i.runBackwards,!S||y&&!i.stagger){if(R=x[0]?z0(x[0]).harness:0,N=R&&i[R.prop],D=Y8(i,cn),b&&(b._zTime<0&&b.progress(1),t<0&&p&&s&&!m?b.render(-1,!0):b.revert(p&&v?I8:iE),b._lazy=0),r){if(l0(e._startAt=Q2.set(x,q3({data:"isStart",overwrite:!1,parent:w,immediateRender:!0,lazy:!b&&A3(u),startAt:null,delay:0,onUpdate:c,onUpdateParams:d,callbackScope:h,stagger:0},r))),e._startAt._dp=0,e._startAt._sat=e,t<0&&(p3||!s&&!m)&&e._startAt.revert(I8),s&&v&&t<=0&&n<=0){t&&(e._zTime=t);return}}else if(p&&v&&!b){if(t&&(s=!1),E=q3({overwrite:!1,data:"isFromStart",lazy:s&&!b&&A3(u),immediateRender:s,stagger:0,parent:w},D),N&&(E[R.prop]=N),l0(e._startAt=Q2.set(x,E)),e._startAt._dp=0,e._startAt._sat=e,t<0&&(p3?e._startAt.revert(I8):e._startAt.render(-1,!0)),e._zTime=t,!s)o(e._startAt,w2,w2);else if(!t)return}for(e._pt=e._ptCache=0,u=v&&A3(u)||u&&!v,C=0;C<x.length;C++){if($=x[C],F=$._gsap||fn(x)[C]._gsap,e._ptLookup[C]=H={},Ee[F.id]&&a0.length&&H8(),V=M===x?C:M.indexOf($),R&&(U=new R).init($,N||D,e,V,M)!==!1&&(e._pt=k=new C3(e._pt,$,U.name,0,1,U.render,U,0,U.priority),U._props.forEach(function(G){H[G]=k}),U.priority&&(X=1)),!R||N)for(E in D)P3[E]&&(U=dl(E,D,e,V,$,M))?U.priority&&(X=1):H[E]=k=hn.call(e,$,E,"get",D[E],V,M,0,i.stringFilter);e._op&&e._op[C]&&e.kill($,e._op[C]),A&&e._pt&&(e0=e,D2.killTweensOf($,H,e.globalTime(t)),z=!e.parent,e0=0),e._pt&&u&&(Ee[F.id]=1)}X&&_l(e),e._onInit&&e._onInit(e)}e._onUpdate=c,e._initted=(!e._op||e._pt)&&!z,y&&t<=0&&S.render(Y3,!0,!0)},IE=function(e,t,n,i,a,r,s){var u=(e._pt&&e._ptCache||(e._ptCache={}))[t],c,d,h,p;if(!u)for(u=e._ptCache[t]=[],h=e._ptLookup,p=e._targets.length;p--;){if(c=h[p][t],c&&c.d&&c.d._pt)for(c=c.d._pt;c&&c.p!==t&&c.fp!==t;)c=c._next;if(!c)return Le=1,e.vars[t]="+=0",pn(e,s),Le=0,1;u.push(c)}for(p=u.length;p--;)d=u[p],c=d._pt||d,c.s=(i||i===0)&&!a?i:c.s+(i||0)+r*c.c,c.c=n-c.s,d.e&&(d.e=G2(n)+f3(d.e)),d.b&&(d.b=c.s+f3(d.b))},RE=function(e,t){var n=e[0]?z0(e[0]).harness:0,i=n&&n.aliases,a,r,s,u;if(!i)return t;a=V0({},t);for(r in i)if(r in a)for(u=i[r].split(","),s=u.length;s--;)a[u[s]]=a[r];return a},OE=function(e,t,n,i){var a=t.ease||i||"power1.inOut",r,s;if(m3(t))s=n[e]||(n[e]=[]),t.forEach(function(u,c){return s.push({t:c/(t.length-1)*100,v:u,e:a})});else for(r in t)s=n[r]||(n[r]=[]),r==="ease"||s.push({t:parseFloat(e),v:t[r],e:a})},y5=function(e,t,n,i,a){return U2(e)?e.call(t,n,i,a):i3(e)&&~e.indexOf("random(")?C5(e):e},fl=dn+"repeat,repeatDelay,yoyo,repeatRefresh,yoyoEase,autoRevert",hl={};w3(fl+",id,stagger,delay,duration,paused,scrollTrigger",function(o){return hl[o]=1});var Q2=function(o){Rs(e,o);function e(n,i,a,r){var s;typeof i=="number"&&(a.duration=i,i=a,a=null),s=o.call(this,r?i:_5(i))||this;var u=s.vars,c=u.duration,d=u.delay,h=u.immediateRender,p=u.stagger,g=u.overwrite,y=u.keyframes,m=u.defaults,v=u.scrollTrigger,b=u.yoyoEase,x=i.parent||D2,w=(m3(n)||Ps(n)?U4(n[0]):"length"in i)?[n]:$3(n),M,A,S,D,C,E,k,$;if(s._targets=w.length?fn(w):W8("GSAP target "+n+" not found. https://greensock.com",!k3.nullTargetWarn)||[],s._ptLookup=[],s._overwrite=g,y||p||A8(c)||A8(d)){if(i=s.vars,M=s.timeline=new S3({data:"nested",defaults:m||{},targets:x&&x.data==="nested"?x.vars.targets:w}),M.kill(),M.parent=M._dp=I4(s),M._start=0,p||A8(c)||A8(d)){if(D=w.length,k=p&&Qs(p),b4(p))for(C in p)~fl.indexOf(C)&&($||($={}),$[C]=p[C]);for(A=0;A<D;A++)S=Y8(i,hl),S.stagger=0,b&&(S.yoyoEase=b),$&&V0(S,$),E=w[A],S.duration=+y5(c,I4(s),A,E,w),S.delay=(+y5(d,I4(s),A,E,w)||0)-s._delay,!p&&D===1&&S.delay&&(s._delay=d=S.delay,s._start+=d,S.delay=0),M.to(E,S,k?k(A,E,w):0),M._ease=f2.none;M.duration()?c=d=0:s.timeline=0}else if(y){_5(q3(M.vars.defaults,{ease:"none"})),M._ease=N0(y.ease||i.ease||"none");var X=0,F,R,U;if(m3(y))y.forEach(function(H){return M.to(w,H,">")}),M.duration();else{S={};for(C in y)C==="ease"||C==="easeEach"||OE(C,y[C],S,y.easeEach);for(C in S)for(F=S[C].sort(function(H,V){return H.t-V.t}),X=0,A=0;A<F.length;A++)R=F[A],U={ease:R.e,duration:(R.t-(A?F[A-1].t:0))/100*c},U[C]=R.v,M.to(w,U,X),X+=U.duration;M.duration()<c&&M.to({},{duration:c-M.duration()})}}c||s.duration(c=M.duration())}else s.timeline=0;return g===!0&&!an&&(e0=I4(s),D2.killTweensOf(w),e0=0),p4(x,I4(s),a),i.reversed&&s.reverse(),i.paused&&s.paused(!0),(h||!c&&!y&&s._start===r3(x._time)&&A3(h)&&uE(I4(s))&&x.data!=="nested")&&(s._tTime=-w2,s.render(Math.max(0,-d)||0)),v&&$s(I4(s),v),s}var t=e.prototype;return t.render=function(i,a,r){var s=this._time,u=this._tDur,c=this._dur,d=i<0,h=i>u-w2&&!d?u:i<w2?0:i,p,g,y,m,v,b,x,w,M;if(!c)dE(this,i,a,r);else if(h!==this._tTime||!i||r||!this._initted&&this._tTime||this._startAt&&this._zTime<0!==d){if(p=h,w=this.timeline,this._repeat){if(m=c+this._rDelay,this._repeat<-1&&d)return this.totalTime(m*100+i,a,r);if(p=r3(h%m),h===u?(y=this._repeat,p=c):(y=~~(h/m),y&&y===h/m&&(p=c,y--),p>c&&(p=c)),b=this._yoyo&&y&1,b&&(M=this._yEase,p=c-p),v=G9(this._tTime,m),p===s&&!r&&this._initted)return this._tTime=h,this;y!==v&&(w&&this._yEase&&ll(w,b),this.vars.repeatRefresh&&!b&&!this._lock&&(this._lock=r=1,this.render(r3(m*y),!0).invalidate()._lock=0))}if(!this._initted){if(Js(this,d?i:p,r,a,h))return this._tTime=0,this;if(s!==this._time)return this;if(c!==this._dur)return this.render(i,a,r)}if(this._tTime=h,this._time=p,!this._act&&this._ts&&(this._act=1,this._lazy=0),this.ratio=x=(M||this._ease)(p/c),this._from&&(this.ratio=x=1-x),p&&!s&&!a&&!y&&(J3(this,"onStart"),this._tTime!==h))return this;for(g=this._pt;g;)g.r(x,g.d),g=g._next;w&&w.render(i<0?i:!p&&b?-w2:w._dur*w._ease(p/this._dur),a,r)||this._startAt&&(this._zTime=i),this._onUpdate&&!a&&(d&&De(this,i,a,r),J3(this,"onUpdate")),this._repeat&&y!==v&&this.vars.onRepeat&&!a&&this.parent&&J3(this,"onRepeat"),(h===this._tDur||!h)&&this._tTime===h&&(d&&!this._onUpdate&&De(this,i,!0,!0),(i||!c)&&(h===this._tDur&&this._ts>0||!h&&this._ts<0)&&l0(this,1),!a&&!(d&&!s)&&(h||s||b)&&(J3(this,h===u?"onComplete":"onReverseComplete",!0),this._prom&&!(h<u&&this.timeScale()>0)&&this._prom()))}return this},t.targets=function(){return this._targets},t.invalidate=function(i){return(!i||!this.vars.runBackwards)&&(this._startAt=0),this._pt=this._op=this._onUpdate=this._lazy=this.ratio=0,this._ptLookup=[],this.timeline&&this.timeline.invalidate(i),o.prototype.invalidate.call(this,i)},t.resetTo=function(i,a,r,s){T5||L3.wake(),this._ts||this.play();var u=Math.min(this._dur,(this._dp._time-this._start)*this._ts),c;return this._initted||pn(this,u),c=this._ease(u/this._dur),IE(this,i,a,r,s,c,u)?this.resetTo(i,a,r,s):(s6(this,0),this.parent||Hs(this._dp,this,"_first","_last",this._dp._sort?"_start":0),this.render(0))},t.kill=function(i,a){if(a===void 0&&(a="all"),!i&&(!a||a==="all"))return this._lazy=this._pt=0,this.parent?f5(this):this;if(this.timeline){var r=this.timeline.totalDuration();return this.timeline.killTweensOf(i,a,e0&&e0.vars.overwrite!==!0)._first||f5(this),this.parent&&r!==this.timeline.totalDuration()&&V9(this,this._dur*this.timeline._tDur/r,0,1),this}var s=this._targets,u=i?$3(i):s,c=this._ptLookup,d=this._pt,h,p,g,y,m,v,b;if((!a||a==="all")&&sE(s,u))return a==="all"&&(this._pt=0),f5(this);for(h=this._op=this._op||[],a!=="all"&&(i3(a)&&(m={},w3(a,function(x){return m[x]=1}),a=m),a=RE(s,a)),b=s.length;b--;)if(~u.indexOf(s[b])){p=c[b],a==="all"?(h[b]=a,y=p,g={}):(g=h[b]=h[b]||{},y=a);for(m in y)v=p&&p[m],v&&((!("kill"in v.d)||v.d.kill(m)===!0)&&a6(this,v,"_pt"),delete p[m]),g!=="all"&&(g[m]=1)}return this._initted&&!this._pt&&d&&f5(this),this},e.to=function(i,a){return new e(i,a,arguments[2])},e.from=function(i,a){return v5(1,arguments)},e.delayedCall=function(i,a,r,s){return new e(a,0,{immediateRender:!1,lazy:!1,overwrite:!1,delay:i,onComplete:a,onReverseComplete:a,onCompleteParams:r,onReverseCompleteParams:r,callbackScope:s})},e.fromTo=function(i,a,r){return v5(2,arguments)},e.set=function(i,a){return a.duration=0,a.repeatDelay||(a.repeat=0),new e(i,a)},e.killTweensOf=function(i,a,r){return D2.killTweensOf(i,a,r)},e}(W9);q3(Q2.prototype,{_targets:[],_lazy:0,_startAt:0,_op:0,_onInit:0});w3("staggerTo,staggerFrom,staggerFromTo",function(o){Q2[o]=function(){var e=new S3,t=Re.call(arguments,0);return t.splice(o==="staggerFromTo"?5:4,0,0),e[o].apply(e,t)}});var mn=function(e,t,n){return e[t]=n},pl=function(e,t,n){return e[t](n)},PE=function(e,t,n,i){return e[t](i.fp,n)},LE=function(e,t,n){return e.setAttribute(t,n)},gn=function(e,t){return U2(e[t])?pl:rn(e[t])&&e.setAttribute?LE:mn},ml=function(e,t){return t.set(t.t,t.p,Math.round((t.s+t.c*e)*1e6)/1e6,t)},zE=function(e,t){return t.set(t.t,t.p,!!(t.s+t.c*e),t)},gl=function(e,t){var n=t._pt,i="";if(!e&&t.b)i=t.b;else if(e===1&&t.e)i=t.e;else{for(;n;)i=n.p+(n.m?n.m(n.s+n.c*e):Math.round((n.s+n.c*e)*1e4)/1e4)+i,n=n._next;i+=t.c}t.set(t.t,t.p,i,t)},_n=function(e,t){for(var n=t._pt;n;)n.r(e,n.d),n=n._next},kE=function(e,t,n,i){for(var a=this._pt,r;a;)r=a._next,a.p===i&&a.modifier(e,t,n),a=r},NE=function(e){for(var t=this._pt,n,i;t;)i=t._next,t.p===e&&!t.op||t.op===e?a6(this,t,"_pt"):t.dep||(n=1),t=i;return!n},UE=function(e,t,n,i){i.mSet(e,t,i.m.call(i.tween,n,i.mt),i)},_l=function(e){for(var t=e._pt,n,i,a,r;t;){for(n=t._next,i=a;i&&i.pr>t.pr;)i=i._next;(t._prev=i?i._prev:r)?t._prev._next=t:a=t,(t._next=i)?i._prev=t:r=t,t=n}e._pt=a},C3=function(){function o(t,n,i,a,r,s,u,c,d){this.t=n,this.s=a,this.c=r,this.p=i,this.r=s||ml,this.d=u||this,this.set=c||mn,this.pr=d||0,this._next=t,t&&(t._prev=this)}var e=o.prototype;return e.modifier=function(n,i,a){this.mSet=this.mSet||this.set,this.set=UE,this.m=n,this.mt=a,this.tween=i},o}();w3(dn+"parent,duration,ease,delay,overwrite,runBackwards,startAt,yoyo,immediateRender,repeat,repeatDelay,data,paused,reversed,lazy,callbackScope,stringFilter,id,yoyoEase,stagger,inherit,repeatRefresh,keyframes,autoRevert,scrollTrigger",function(o){return cn[o]=1});N3.TweenMax=N3.TweenLite=Q2;N3.TimelineLite=N3.TimelineMax=S3;D2=new S3({sortChildren:!1,defaults:B9,autoRemoveChildren:!0,id:"root",smoothChildTiming:!0});k3.stringFilter=rl;var H9=[],O8={},FE=[],Aa=0,c7=function(e){return(O8[e]||FE).map(function(t){return t()})},ze=function(){var e=Date.now(),t=[];e-Aa>2&&(c7("matchMediaInit"),H9.forEach(function(n){var i=n.queries,a=n.conditions,r,s,u,c;for(s in i)r=V3.matchMedia(i[s]).matches,r&&(u=1),r!==a[s]&&(a[s]=r,c=1);c&&(n.revert(),u&&t.push(n))}),c7("matchMediaRevert"),t.forEach(function(n){return n.onMatch(n)}),Aa=e,c7("matchMedia"))},vl=function(){function o(t,n){this.selector=n&&Oe(n),this.data=[],this._r=[],this.isReverted=!1,t&&this.add(t)}var e=o.prototype;return e.add=function(n,i,a){U2(n)&&(a=i,i=n,n=U2);var r=this,s=function(){var c=Y2,d=r.selector,h;return c&&c!==r&&c.data.push(r),a&&(r.selector=Oe(a)),Y2=r,h=i.apply(r,arguments),U2(h)&&r._r.push(h),Y2=c,r.selector=d,r.isReverted=!1,h};return r.last=s,n===U2?s(r):n?r[n]=s:s},e.ignore=function(n){var i=Y2;Y2=null,n(this),Y2=i},e.getTweens=function(){var n=[];return this.data.forEach(function(i){return i instanceof o?n.push.apply(n,i.getTweens()):i instanceof Q2&&!(i.parent&&i.parent.data==="nested")&&n.push(i)}),n},e.clear=function(){this._r.length=this.data.length=0},e.kill=function(n,i){var a=this;if(n){var r=this.getTweens();this.data.forEach(function(u){u.data==="isFlip"&&(u.revert(),u.getChildren(!0,!0,!1).forEach(function(c){return r.splice(r.indexOf(c),1)}))}),r.map(function(u){return{g:u.globalTime(0),t:u}}).sort(function(u,c){return c.g-u.g||-1}).forEach(function(u){return u.t.revert(n)}),this.data.forEach(function(u){return!(u instanceof W9)&&u.revert&&u.revert(n)}),this._r.forEach(function(u){return u(n,a)}),this.isReverted=!0}else this.data.forEach(function(u){return u.kill&&u.kill()});if(this.clear(),i){var s=H9.indexOf(this);~s&&H9.splice(s,1)}},e.revert=function(n){this.kill(n||{})},o}(),BE=function(){function o(t){this.contexts=[],this.scope=t}var e=o.prototype;return e.add=function(n,i,a){b4(n)||(n={matches:n});var r=new vl(0,a||this.scope),s=r.conditions={},u,c,d;this.contexts.push(r),i=r.add("onMatch",i),r.queries=n;for(c in n)c==="all"?d=1:(u=V3.matchMedia(n[c]),u&&(H9.indexOf(r)<0&&H9.push(r),(s[c]=u.matches)&&(d=1),u.addListener?u.addListener(ze):u.addEventListener("change",ze)));return d&&i(r),this},e.revert=function(n){this.kill(n||{})},e.kill=function(n){this.contexts.forEach(function(i){return i.kill(n,!0)})},o}(),J8={registerPlugin:function(){for(var e=arguments.length,t=new Array(e),n=0;n<e;n++)t[n]=arguments[n];t.forEach(function(i){return il(i)})},timeline:function(e){return new S3(e)},getTweensOf:function(e,t){return D2.getTweensOf(e,t)},getProperty:function(e,t,n,i){i3(e)&&(e=$3(e)[0]);var a=z0(e||{}).get,r=n?Ws:js;return n==="native"&&(n=""),e&&(t?r((P3[t]&&P3[t].get||a)(e,t,n,i)):function(s,u,c){return r((P3[s]&&P3[s].get||a)(e,s,u,c))})},quickSetter:function(e,t,n){if(e=$3(e),e.length>1){var i=e.map(function(d){return T3.quickSetter(d,t,n)}),a=i.length;return function(d){for(var h=a;h--;)i[h](d)}}e=e[0]||{};var r=P3[t],s=z0(e),u=s.harness&&(s.harness.aliases||{})[t]||t,c=r?function(d){var h=new r;D9._pt=0,h.init(e,n?d+n:d,D9,0,[e]),h.render(1,h),D9._pt&&_n(1,D9)}:s.set(e,u);return r?c:function(d){return c(e,u,n?d+n:d,s,1)}},quickTo:function(e,t,n){var i,a=T3.to(e,V0((i={},i[t]="+=0.1",i.paused=!0,i),n||{})),r=function(u,c,d){return a.resetTo(t,u,c,d)};return r.tween=a,r},isTweening:function(e){return D2.getTweensOf(e,!0).length>0},defaults:function(e){return e&&e.ease&&(e.ease=N0(e.ease,B9.ease)),ya(B9,e||{})},config:function(e){return ya(k3,e||{})},registerEffect:function(e){var t=e.name,n=e.effect,i=e.plugins,a=e.defaults,r=e.extendTimeline;(i||"").split(",").forEach(function(s){return s&&!P3[s]&&!N3[s]&&W8(t+" effect requires "+s+" plugin.")}),r7[t]=function(s,u,c){return n($3(s),q3(u||{},a),c)},r&&(S3.prototype[t]=function(s,u,c){return this.add(r7[t](s,b4(u)?u:(c=u)&&{},this),c)})},registerEase:function(e,t){f2[e]=N0(t)},parseEase:function(e,t){return arguments.length?N0(e,t):f2},getById:function(e){return D2.getById(e)},exportRoot:function(e,t){e===void 0&&(e={});var n=new S3(e),i,a;for(n.smoothChildTiming=A3(e.smoothChildTiming),D2.remove(n),n._dp=0,n._time=n._tTime=D2._time,i=D2._first;i;)a=i._next,(t||!(!i._dur&&i instanceof Q2&&i.vars.onComplete===i._targets[0]))&&p4(n,i,i._start-i._delay),i=a;return p4(D2,n,0),n},context:function(e,t){return e?new vl(e,t):Y2},matchMedia:function(e){return new BE(e)},matchMediaRefresh:function(){return H9.forEach(function(e){var t=e.conditions,n,i;for(i in t)t[i]&&(t[i]=!1,n=1);n&&e.revert()})||ze()},addEventListener:function(e,t){var n=O8[e]||(O8[e]=[]);~n.indexOf(t)||n.push(t)},removeEventListener:function(e,t){var n=O8[e],i=n&&n.indexOf(t);i>=0&&n.splice(i,1)},utils:{wrap:yE,wrapYoyo:bE,distribute:Qs,random:Ks,snap:qs,normalize:vE,getUnit:f3,clamp:pE,splitColor:ol,toArray:$3,selector:Oe,mapRange:tl,pipe:gE,unitize:_E,interpolate:xE,shuffle:Xs},install:Us,effects:r7,ticker:L3,updateRoot:S3.updateRoot,plugins:P3,globalTimeline:D2,core:{PropTween:C3,globals:Fs,Tween:Q2,Timeline:S3,Animation:W9,getCache:z0,_removeLinkedListItem:a6,reverting:function(){return p3},context:function(e){return e&&Y2&&(Y2.data.push(e),e._ctx=Y2),Y2},suppressOverwrites:function(e){return an=e}}};w3("to,from,fromTo,delayedCall,set,killTweensOf",function(o){return J8[o]=Q2[o]});L3.add(S3.updateRoot);D9=J8.to({},{duration:0});var GE=function(e,t){for(var n=e._pt;n&&n.p!==t&&n.op!==t&&n.fp!==t;)n=n._next;return n},VE=function(e,t){var n=e._targets,i,a,r;for(i in t)for(a=n.length;a--;)r=e._ptLookup[a][i],r&&(r=r.d)&&(r._pt&&(r=GE(r,i)),r&&r.modifier&&r.modifier(t[i],e,n[a],i))},d7=function(e,t){return{name:e,rawVars:1,init:function(i,a,r){r._onInit=function(s){var u,c;if(i3(a)&&(u={},w3(a,function(d){return u[d]=1}),a=u),t){u={};for(c in a)u[c]=t(a[c]);a=u}VE(s,a)}}}},T3=J8.registerPlugin({name:"attr",init:function(e,t,n,i,a){var r,s,u;this.tween=n;for(r in t)u=e.getAttribute(r)||"",s=this.add(e,"setAttribute",(u||0)+"",t[r],i,a,0,0,r),s.op=r,s.b=u,this._props.push(r)},render:function(e,t){for(var n=t._pt;n;)p3?n.set(n.t,n.p,n.b,n):n.r(e,n.d),n=n._next}},{name:"endArray",init:function(e,t){for(var n=t.length;n--;)this.add(e,n,e[n]||0,t[n],0,0,0,0,0,1)}},d7("roundProps",Pe),d7("modifiers"),d7("snap",qs))||J8;Q2.version=S3.version=T3.version="3.11.5";Ns=1;sn()&&j9();f2.Power0;f2.Power1;f2.Power2;f2.Power3;f2.Power4;f2.Linear;f2.Quad;f2.Cubic;f2.Quart;f2.Quint;f2.Strong;f2.Elastic;f2.Back;f2.SteppedEase;f2.Bounce;f2.Sine;f2.Expo;f2.Circ;/*!
 * CSSPlugin 3.11.5
 * https://greensock.com
 *
 * Copyright 2008-2023, GreenSock. All rights reserved.
 * Subject to the terms at https://greensock.com/standard-license or for
 * Club GreenSock members, the agreement issued with that membership.
 * @author: Jack Doyle, jack@greensock.com
*/var wa,t0,P9,vn,I0,Ca,yn,jE=function(){return typeof window!="undefined"},F4={},A0=180/Math.PI,L9=Math.PI/180,_9=Math.atan2,Ta=1e8,bn=/([A-Z])/g,WE=/(left|right|width|margin|padding|x)/i,HE=/[\s,\(]\S/,_4={autoAlpha:"opacity,visibility",scale:"scaleX,scaleY",alpha:"opacity"},ke=function(e,t){return t.set(t.t,t.p,Math.round((t.s+t.c*e)*1e4)/1e4+t.u,t)},YE=function(e,t){return t.set(t.t,t.p,e===1?t.e:Math.round((t.s+t.c*e)*1e4)/1e4+t.u,t)},$E=function(e,t){return t.set(t.t,t.p,e?Math.round((t.s+t.c*e)*1e4)/1e4+t.u:t.b,t)},JE=function(e,t){var n=t.s+t.c*e;t.set(t.t,t.p,~~(n+(n<0?-.5:.5))+t.u,t)},yl=function(e,t){return t.set(t.t,t.p,e?t.e:t.b,t)},bl=function(e,t){return t.set(t.t,t.p,e!==1?t.b:t.e,t)},ZE=function(e,t,n){return e.style[t]=n},XE=function(e,t,n){return e.style.setProperty(t,n)},QE=function(e,t,n){return e._gsap[t]=n},qE=function(e,t,n){return e._gsap.scaleX=e._gsap.scaleY=n},KE=function(e,t,n,i,a){var r=e._gsap;r.scaleX=r.scaleY=n,r.renderTransform(a,r)},eD=function(e,t,n,i,a){var r=e._gsap;r[t]=n,r.renderTransform(a,r)},I2="transform",s4=I2+"Origin",tD=function o(e,t){var n=this,i=this.target,a=i.style;if(e in F4){if(this.tfm=this.tfm||{},e!=="transform")e=_4[e]||e,~e.indexOf(",")?e.split(",").forEach(function(r){return n.tfm[r]=R4(i,r)}):this.tfm[e]=i._gsap.x?i._gsap[e]:R4(i,e);else return _4.transform.split(",").forEach(function(r){return o.call(n,r,t)});if(this.props.indexOf(I2)>=0)return;i._gsap.svg&&(this.svgo=i.getAttribute("data-svg-origin"),this.props.push(s4,t,"")),e=I2}(a||t)&&this.props.push(e,t,a[e])},xl=function(e){e.translate&&(e.removeProperty("translate"),e.removeProperty("scale"),e.removeProperty("rotate"))},nD=function(){var e=this.props,t=this.target,n=t.style,i=t._gsap,a,r;for(a=0;a<e.length;a+=3)e[a+1]?t[e[a]]=e[a+2]:e[a+2]?n[e[a]]=e[a+2]:n.removeProperty(e[a].substr(0,2)==="--"?e[a]:e[a].replace(bn,"-$1").toLowerCase());if(this.tfm){for(r in this.tfm)i[r]=this.tfm[r];i.svg&&(i.renderTransform(),t.setAttribute("data-svg-origin",this.svgo||"")),a=yn(),(!a||!a.isStart)&&!n[I2]&&(xl(n),i.uncache=1)}},Sl=function(e,t){var n={target:e,props:[],revert:nD,save:tD};return e._gsap||T3.core.getCache(e),t&&t.split(",").forEach(function(i){return n.save(i)}),n},Ml,Ne=function(e,t){var n=t0.createElementNS?t0.createElementNS((t||"http://www.w3.org/1999/xhtml").replace(/^https/,"http"),e):t0.createElement(e);return n.style?n:t0.createElement(e)},y4=function o(e,t,n){var i=getComputedStyle(e);return i[t]||i.getPropertyValue(t.replace(bn,"-$1").toLowerCase())||i.getPropertyValue(t)||!n&&o(e,Y9(t)||t,1)||""},Ea="O,Moz,ms,Ms,Webkit".split(","),Y9=function(e,t,n){var i=t||I0,a=i.style,r=5;if(e in a&&!n)return e;for(e=e.charAt(0).toUpperCase()+e.substr(1);r--&&!(Ea[r]+e in a););return r<0?null:(r===3?"ms":r>=0?Ea[r]:"")+e},Ue=function(){jE()&&window.document&&(wa=window,t0=wa.document,P9=t0.documentElement,I0=Ne("div")||{style:{}},Ne("div"),I2=Y9(I2),s4=I2+"Origin",I0.style.cssText="border-width:0;line-height:0;position:absolute;padding:0",Ml=!!Y9("perspective"),yn=T3.core.reverting,vn=1)},f7=function o(e){var t=Ne("svg",this.ownerSVGElement&&this.ownerSVGElement.getAttribute("xmlns")||"http://www.w3.org/2000/svg"),n=this.parentNode,i=this.nextSibling,a=this.style.cssText,r;if(P9.appendChild(t),t.appendChild(this),this.style.display="block",e)try{r=this.getBBox(),this._gsapBBox=this.getBBox,this.getBBox=o}catch(s){}else this._gsapBBox&&(r=this._gsapBBox());return n&&(i?n.insertBefore(this,i):n.appendChild(this)),P9.removeChild(t),this.style.cssText=a,r},Da=function(e,t){for(var n=t.length;n--;)if(e.hasAttribute(t[n]))return e.getAttribute(t[n])},Al=function(e){var t;try{t=e.getBBox()}catch(n){t=f7.call(e,!0)}return t&&(t.width||t.height)||e.getBBox===f7||(t=f7.call(e,!0)),t&&!t.width&&!t.x&&!t.y?{x:+Da(e,["x","cx","x1"])||0,y:+Da(e,["y","cy","y1"])||0,width:0,height:0}:t},wl=function(e){return!!(e.getCTM&&(!e.parentNode||e.ownerSVGElement)&&Al(e))},E5=function(e,t){if(t){var n=e.style;t in F4&&t!==s4&&(t=I2),n.removeProperty?((t.substr(0,2)==="ms"||t.substr(0,6)==="webkit")&&(t="-"+t),n.removeProperty(t.replace(bn,"-$1").toLowerCase())):n.removeAttribute(t)}},n0=function(e,t,n,i,a,r){var s=new C3(e._pt,t,n,0,1,r?bl:yl);return e._pt=s,s.b=i,s.e=a,e._props.push(n),s},Ia={deg:1,rad:1,turn:1},iD={grid:1,flex:1},u0=function o(e,t,n,i){var a=parseFloat(n)||0,r=(n+"").trim().substr((a+"").length)||"px",s=I0.style,u=WE.test(t),c=e.tagName.toLowerCase()==="svg",d=(c?"client":"offset")+(u?"Width":"Height"),h=100,p=i==="px",g=i==="%",y,m,v,b;return i===r||!a||Ia[i]||Ia[r]?a:(r!=="px"&&!p&&(a=o(e,t,n,"px")),b=e.getCTM&&wl(e),(g||r==="%")&&(F4[t]||~t.indexOf("adius"))?(y=b?e.getBBox()[u?"width":"height"]:e[d],G2(g?a/y*h:a/100*y)):(s[u?"width":"height"]=h+(p?r:i),m=~t.indexOf("adius")||i==="em"&&e.appendChild&&!c?e:e.parentNode,b&&(m=(e.ownerSVGElement||{}).parentNode),(!m||m===t0||!m.appendChild)&&(m=t0.body),v=m._gsap,v&&g&&v.width&&u&&v.time===L3.time&&!v.uncache?G2(a/v.width*h):((g||r==="%")&&!iD[y4(m,"display")]&&(s.position=y4(e,"position")),m===e&&(s.position="static"),m.appendChild(I0),y=I0[d],m.removeChild(I0),s.position="absolute",u&&g&&(v=z0(m),v.time=L3.time,v.width=m[d]),G2(p?y*a/h:y&&a?h/y*a:0))))},R4=function(e,t,n,i){var a;return vn||Ue(),t in _4&&t!=="transform"&&(t=_4[t],~t.indexOf(",")&&(t=t.split(",")[0])),F4[t]&&t!=="transform"?(a=I5(e,i),a=t!=="transformOrigin"?a[t]:a.svg?a.origin:X8(y4(e,s4))+" "+a.zOrigin+"px"):(a=e.style[t],(!a||a==="auto"||i||~(a+"").indexOf("calc("))&&(a=Z8[t]&&Z8[t](e,t,n)||y4(e,t)||Gs(e,t)||(t==="opacity"?1:0))),n&&!~(a+"").trim().indexOf(" ")?u0(e,t,a,n)+n:a},oD=function(e,t,n,i){if(!n||n==="none"){var a=Y9(t,e,1),r=a&&y4(e,a,1);r&&r!==n?(t=a,n=r):t==="borderColor"&&(n=y4(e,"borderTopColor"))}var s=new C3(this._pt,e.style,t,0,1,gl),u=0,c=0,d,h,p,g,y,m,v,b,x,w,M,A;if(s.b=n,s.e=i,n+="",i+="",i==="auto"&&(e.style[t]=i,i=y4(e,t)||i,e.style[t]=n),d=[n,i],rl(d),n=d[0],i=d[1],p=n.match(E9)||[],A=i.match(E9)||[],A.length){for(;h=E9.exec(i);)v=h[0],x=i.substring(u,h.index),y?y=(y+1)%5:(x.substr(-5)==="rgba("||x.substr(-5)==="hsla(")&&(y=1),v!==(m=p[c++]||"")&&(g=parseFloat(m)||0,M=m.substr((g+"").length),v.charAt(1)==="="&&(v=O9(g,v)+M),b=parseFloat(v),w=v.substr((b+"").length),u=E9.lastIndex-w.length,w||(w=w||k3.units[t]||M,u===i.length&&(i+=w,s.e+=w)),M!==w&&(g=u0(e,t,m,w)||0),s._pt={_next:s._pt,p:x||c===1?x:",",s:g,c:b-g,m:y&&y<4||t==="zIndex"?Math.round:0});s.c=u<i.length?i.substring(u,i.length):""}else s.r=t==="display"&&i==="none"?bl:yl;return zs.test(i)&&(s.e=0),this._pt=s,s},Ra={top:"0%",bottom:"100%",left:"0%",right:"100%",center:"50%"},aD=function(e){var t=e.split(" "),n=t[0],i=t[1]||"50%";return(n==="top"||n==="bottom"||i==="left"||i==="right")&&(e=n,n=i,i=e),t[0]=Ra[n]||n,t[1]=Ra[i]||i,t.join(" ")},rD=function(e,t){if(t.tween&&t.tween._time===t.tween._dur){var n=t.t,i=n.style,a=t.u,r=n._gsap,s,u,c;if(a==="all"||a===!0)i.cssText="",u=1;else for(a=a.split(","),c=a.length;--c>-1;)s=a[c],F4[s]&&(u=1,s=s==="transformOrigin"?s4:I2),E5(n,s);u&&(E5(n,I2),r&&(r.svg&&n.removeAttribute("transform"),I5(n,1),r.uncache=1,xl(i)))}},Z8={clearProps:function(e,t,n,i,a){if(a.data!=="isFromStart"){var r=e._pt=new C3(e._pt,t,n,0,0,rD);return r.u=i,r.pr=-10,r.tween=a,e._props.push(n),1}}},D5=[1,0,0,1,0,0],Cl={},Tl=function(e){return e==="matrix(1, 0, 0, 1, 0, 0)"||e==="none"||!e},Oa=function(e){var t=y4(e,I2);return Tl(t)?D5:t.substr(7).match(Ls).map(G2)},xn=function(e,t){var n=e._gsap||z0(e),i=e.style,a=Oa(e),r,s,u,c;return n.svg&&e.getAttribute("transform")?(u=e.transform.baseVal.consolidate().matrix,a=[u.a,u.b,u.c,u.d,u.e,u.f],a.join(",")==="1,0,0,1,0,0"?D5:a):(a===D5&&!e.offsetParent&&e!==P9&&!n.svg&&(u=i.display,i.display="block",r=e.parentNode,(!r||!e.offsetParent)&&(c=1,s=e.nextElementSibling,P9.appendChild(e)),a=Oa(e),u?i.display=u:E5(e,"display"),c&&(s?r.insertBefore(e,s):r?r.appendChild(e):P9.removeChild(e))),t&&a.length>6?[a[0],a[1],a[4],a[5],a[12],a[13]]:a)},Fe=function(e,t,n,i,a,r){var s=e._gsap,u=a||xn(e,!0),c=s.xOrigin||0,d=s.yOrigin||0,h=s.xOffset||0,p=s.yOffset||0,g=u[0],y=u[1],m=u[2],v=u[3],b=u[4],x=u[5],w=t.split(" "),M=parseFloat(w[0])||0,A=parseFloat(w[1])||0,S,D,C,E;n?u!==D5&&(D=g*v-y*m)&&(C=M*(v/D)+A*(-m/D)+(m*x-v*b)/D,E=M*(-y/D)+A*(g/D)-(g*x-y*b)/D,M=C,A=E):(S=Al(e),M=S.x+(~w[0].indexOf("%")?M/100*S.width:M),A=S.y+(~(w[1]||w[0]).indexOf("%")?A/100*S.height:A)),i||i!==!1&&s.smooth?(b=M-c,x=A-d,s.xOffset=h+(b*g+x*m)-b,s.yOffset=p+(b*y+x*v)-x):s.xOffset=s.yOffset=0,s.xOrigin=M,s.yOrigin=A,s.smooth=!!i,s.origin=t,s.originIsAbsolute=!!n,e.style[s4]="0px 0px",r&&(n0(r,s,"xOrigin",c,M),n0(r,s,"yOrigin",d,A),n0(r,s,"xOffset",h,s.xOffset),n0(r,s,"yOffset",p,s.yOffset)),e.setAttribute("data-svg-origin",M+" "+A)},I5=function(e,t){var n=e._gsap||new cl(e);if("x"in n&&!t&&!n.uncache)return n;var i=e.style,a=n.scaleX<0,r="px",s="deg",u=getComputedStyle(e),c=y4(e,s4)||"0",d,h,p,g,y,m,v,b,x,w,M,A,S,D,C,E,k,$,X,F,R,U,H,V,N,z,G,t1,e1,u1,s1,q;return d=h=p=m=v=b=x=w=M=0,g=y=1,n.svg=!!(e.getCTM&&wl(e)),u.translate&&((u.translate!=="none"||u.scale!=="none"||u.rotate!=="none")&&(i[I2]=(u.translate!=="none"?"translate3d("+(u.translate+" 0 0").split(" ").slice(0,3).join(", ")+") ":"")+(u.rotate!=="none"?"rotate("+u.rotate+") ":"")+(u.scale!=="none"?"scale("+u.scale.split(" ").join(",")+") ":"")+(u[I2]!=="none"?u[I2]:"")),i.scale=i.rotate=i.translate="none"),D=xn(e,n.svg),n.svg&&(n.uncache?(N=e.getBBox(),c=n.xOrigin-N.x+"px "+(n.yOrigin-N.y)+"px",V=""):V=!t&&e.getAttribute("data-svg-origin"),Fe(e,V||c,!!V||n.originIsAbsolute,n.smooth!==!1,D)),A=n.xOrigin||0,S=n.yOrigin||0,D!==D5&&($=D[0],X=D[1],F=D[2],R=D[3],d=U=D[4],h=H=D[5],D.length===6?(g=Math.sqrt($*$+X*X),y=Math.sqrt(R*R+F*F),m=$||X?_9(X,$)*A0:0,x=F||R?_9(F,R)*A0+m:0,x&&(y*=Math.abs(Math.cos(x*L9))),n.svg&&(d-=A-(A*$+S*F),h-=S-(A*X+S*R))):(q=D[6],u1=D[7],G=D[8],t1=D[9],e1=D[10],s1=D[11],d=D[12],h=D[13],p=D[14],C=_9(q,e1),v=C*A0,C&&(E=Math.cos(-C),k=Math.sin(-C),V=U*E+G*k,N=H*E+t1*k,z=q*E+e1*k,G=U*-k+G*E,t1=H*-k+t1*E,e1=q*-k+e1*E,s1=u1*-k+s1*E,U=V,H=N,q=z),C=_9(-F,e1),b=C*A0,C&&(E=Math.cos(-C),k=Math.sin(-C),V=$*E-G*k,N=X*E-t1*k,z=F*E-e1*k,s1=R*k+s1*E,$=V,X=N,F=z),C=_9(X,$),m=C*A0,C&&(E=Math.cos(C),k=Math.sin(C),V=$*E+X*k,N=U*E+H*k,X=X*E-$*k,H=H*E-U*k,$=V,U=N),v&&Math.abs(v)+Math.abs(m)>359.9&&(v=m=0,b=180-b),g=G2(Math.sqrt($*$+X*X+F*F)),y=G2(Math.sqrt(H*H+q*q)),C=_9(U,H),x=Math.abs(C)>2e-4?C*A0:0,M=s1?1/(s1<0?-s1:s1):0),n.svg&&(V=e.getAttribute("transform"),n.forceCSS=e.setAttribute("transform","")||!Tl(y4(e,I2)),V&&e.setAttribute("transform",V))),Math.abs(x)>90&&Math.abs(x)<270&&(a?(g*=-1,x+=m<=0?180:-180,m+=m<=0?180:-180):(y*=-1,x+=x<=0?180:-180)),t=t||n.uncache,n.x=d-((n.xPercent=d&&(!t&&n.xPercent||(Math.round(e.offsetWidth/2)===Math.round(-d)?-50:0)))?e.offsetWidth*n.xPercent/100:0)+r,n.y=h-((n.yPercent=h&&(!t&&n.yPercent||(Math.round(e.offsetHeight/2)===Math.round(-h)?-50:0)))?e.offsetHeight*n.yPercent/100:0)+r,n.z=p+r,n.scaleX=G2(g),n.scaleY=G2(y),n.rotation=G2(m)+s,n.rotationX=G2(v)+s,n.rotationY=G2(b)+s,n.skewX=x+s,n.skewY=w+s,n.transformPerspective=M+r,(n.zOrigin=parseFloat(c.split(" ")[2])||0)&&(i[s4]=X8(c)),n.xOffset=n.yOffset=0,n.force3D=k3.force3D,n.renderTransform=n.svg?lD:Ml?El:sD,n.uncache=0,n},X8=function(e){return(e=e.split(" "))[0]+" "+e[1]},h7=function(e,t,n){var i=f3(t);return G2(parseFloat(t)+parseFloat(u0(e,"x",n+"px",i)))+i},sD=function(e,t){t.z="0px",t.rotationY=t.rotationX="0deg",t.force3D=0,El(e,t)},b0="0deg",r5="0px",x0=") ",El=function(e,t){var n=t||this,i=n.xPercent,a=n.yPercent,r=n.x,s=n.y,u=n.z,c=n.rotation,d=n.rotationY,h=n.rotationX,p=n.skewX,g=n.skewY,y=n.scaleX,m=n.scaleY,v=n.transformPerspective,b=n.force3D,x=n.target,w=n.zOrigin,M="",A=b==="auto"&&e&&e!==1||b===!0;if(w&&(h!==b0||d!==b0)){var S=parseFloat(d)*L9,D=Math.sin(S),C=Math.cos(S),E;S=parseFloat(h)*L9,E=Math.cos(S),r=h7(x,r,D*E*-w),s=h7(x,s,-Math.sin(S)*-w),u=h7(x,u,C*E*-w+w)}v!==r5&&(M+="perspective("+v+x0),(i||a)&&(M+="translate("+i+"%, "+a+"%) "),(A||r!==r5||s!==r5||u!==r5)&&(M+=u!==r5||A?"translate3d("+r+", "+s+", "+u+") ":"translate("+r+", "+s+x0),c!==b0&&(M+="rotate("+c+x0),d!==b0&&(M+="rotateY("+d+x0),h!==b0&&(M+="rotateX("+h+x0),(p!==b0||g!==b0)&&(M+="skew("+p+", "+g+x0),(y!==1||m!==1)&&(M+="scale("+y+", "+m+x0),x.style[I2]=M||"translate(0, 0)"},lD=function(e,t){var n=t||this,i=n.xPercent,a=n.yPercent,r=n.x,s=n.y,u=n.rotation,c=n.skewX,d=n.skewY,h=n.scaleX,p=n.scaleY,g=n.target,y=n.xOrigin,m=n.yOrigin,v=n.xOffset,b=n.yOffset,x=n.forceCSS,w=parseFloat(r),M=parseFloat(s),A,S,D,C,E;u=parseFloat(u),c=parseFloat(c),d=parseFloat(d),d&&(d=parseFloat(d),c+=d,u+=d),u||c?(u*=L9,c*=L9,A=Math.cos(u)*h,S=Math.sin(u)*h,D=Math.sin(u-c)*-p,C=Math.cos(u-c)*p,c&&(d*=L9,E=Math.tan(c-d),E=Math.sqrt(1+E*E),D*=E,C*=E,d&&(E=Math.tan(d),E=Math.sqrt(1+E*E),A*=E,S*=E)),A=G2(A),S=G2(S),D=G2(D),C=G2(C)):(A=h,C=p,S=D=0),(w&&!~(r+"").indexOf("px")||M&&!~(s+"").indexOf("px"))&&(w=u0(g,"x",r,"px"),M=u0(g,"y",s,"px")),(y||m||v||b)&&(w=G2(w+y-(y*A+m*D)+v),M=G2(M+m-(y*S+m*C)+b)),(i||a)&&(E=g.getBBox(),w=G2(w+i/100*E.width),M=G2(M+a/100*E.height)),E="matrix("+A+","+S+","+D+","+C+","+w+","+M+")",g.setAttribute("transform",E),x&&(g.style[I2]=E)},uD=function(e,t,n,i,a){var r=360,s=i3(a),u=parseFloat(a)*(s&&~a.indexOf("rad")?A0:1),c=u-i,d=i+c+"deg",h,p;return s&&(h=a.split("_")[1],h==="short"&&(c%=r,c!==c%(r/2)&&(c+=c<0?r:-r)),h==="cw"&&c<0?c=(c+r*Ta)%r-~~(c/r)*r:h==="ccw"&&c>0&&(c=(c-r*Ta)%r-~~(c/r)*r)),e._pt=p=new C3(e._pt,t,n,i,c,YE),p.e=d,p.u="deg",e._props.push(n),p},Pa=function(e,t){for(var n in t)e[n]=t[n];return e},cD=function(e,t,n){var i=Pa({},n._gsap),a="perspective,force3D,transformOrigin,svgOrigin",r=n.style,s,u,c,d,h,p,g,y;i.svg?(c=n.getAttribute("transform"),n.setAttribute("transform",""),r[I2]=t,s=I5(n,1),E5(n,I2),n.setAttribute("transform",c)):(c=getComputedStyle(n)[I2],r[I2]=t,s=I5(n,1),r[I2]=c);for(u in F4)c=i[u],d=s[u],c!==d&&a.indexOf(u)<0&&(g=f3(c),y=f3(d),h=g!==y?u0(n,u,c,y):parseFloat(c),p=parseFloat(d),e._pt=new C3(e._pt,s,u,h,p-h,ke),e._pt.u=y||0,e._props.push(u));Pa(s,i)};w3("padding,margin,Width,Radius",function(o,e){var t="Top",n="Right",i="Bottom",a="Left",r=(e<3?[t,n,i,a]:[t+a,t+n,i+n,i+a]).map(function(s){return e<2?o+s:"border"+s+o});Z8[e>1?"border"+o:o]=function(s,u,c,d,h){var p,g;if(arguments.length<4)return p=r.map(function(y){return R4(s,y,c)}),g=p.join(" "),g.split(p[0]).length===5?p[0]:g;p=(d+"").split(" "),g={},r.forEach(function(y,m){return g[y]=p[m]=p[m]||p[(m-1)/2|0]}),s.init(u,g,h)}});var Dl={name:"css",register:Ue,targetTest:function(e){return e.style&&e.nodeType},init:function(e,t,n,i,a){var r=this._props,s=e.style,u=n.vars.startAt,c,d,h,p,g,y,m,v,b,x,w,M,A,S,D,C;vn||Ue(),this.styles=this.styles||Sl(e),C=this.styles.props,this.tween=n;for(m in t)if(m!=="autoRound"&&(d=t[m],!(P3[m]&&dl(m,t,n,i,e,a)))){if(g=typeof d,y=Z8[m],g==="function"&&(d=d.call(n,i,e,a),g=typeof d),g==="string"&&~d.indexOf("random(")&&(d=C5(d)),y)y(this,e,m,d,n)&&(D=1);else if(m.substr(0,2)==="--")c=(getComputedStyle(e).getPropertyValue(m)+"").trim(),d+="",r0.lastIndex=0,r0.test(c)||(v=f3(c),b=f3(d)),b?v!==b&&(c=u0(e,m,c,b)+b):v&&(d+=v),this.add(s,"setProperty",c,d,i,a,0,0,m),r.push(m),C.push(m,0,s[m]);else if(g!=="undefined"){if(u&&m in u?(c=typeof u[m]=="function"?u[m].call(n,i,e,a):u[m],i3(c)&&~c.indexOf("random(")&&(c=C5(c)),f3(c+"")||(c+=k3.units[m]||f3(R4(e,m))||""),(c+"").charAt(1)==="="&&(c=R4(e,m))):c=R4(e,m),p=parseFloat(c),x=g==="string"&&d.charAt(1)==="="&&d.substr(0,2),x&&(d=d.substr(2)),h=parseFloat(d),m in _4&&(m==="autoAlpha"&&(p===1&&R4(e,"visibility")==="hidden"&&h&&(p=0),C.push("visibility",0,s.visibility),n0(this,s,"visibility",p?"inherit":"hidden",h?"inherit":"hidden",!h)),m!=="scale"&&m!=="transform"&&(m=_4[m],~m.indexOf(",")&&(m=m.split(",")[0]))),w=m in F4,w){if(this.styles.save(m),M||(A=e._gsap,A.renderTransform&&!t.parseTransform||I5(e,t.parseTransform),S=t.smoothOrigin!==!1&&A.smooth,M=this._pt=new C3(this._pt,s,I2,0,1,A.renderTransform,A,0,-1),M.dep=1),m==="scale")this._pt=new C3(this._pt,A,"scaleY",A.scaleY,(x?O9(A.scaleY,x+h):h)-A.scaleY||0,ke),this._pt.u=0,r.push("scaleY",m),m+="X";else if(m==="transformOrigin"){C.push(s4,0,s[s4]),d=aD(d),A.svg?Fe(e,d,0,S,0,this):(b=parseFloat(d.split(" ")[2])||0,b!==A.zOrigin&&n0(this,A,"zOrigin",A.zOrigin,b),n0(this,s,m,X8(c),X8(d)));continue}else if(m==="svgOrigin"){Fe(e,d,1,S,0,this);continue}else if(m in Cl){uD(this,A,m,p,x?O9(p,x+d):d);continue}else if(m==="smoothOrigin"){n0(this,A,"smooth",A.smooth,d);continue}else if(m==="force3D"){A[m]=d;continue}else if(m==="transform"){cD(this,d,e);continue}}else m in s||(m=Y9(m)||m);if(w||(h||h===0)&&(p||p===0)&&!HE.test(d)&&m in s)v=(c+"").substr((p+"").length),h||(h=0),b=f3(d)||(m in k3.units?k3.units[m]:v),v!==b&&(p=u0(e,m,c,b)),this._pt=new C3(this._pt,w?A:s,m,p,(x?O9(p,x+h):h)-p,!w&&(b==="px"||m==="zIndex")&&t.autoRound!==!1?JE:ke),this._pt.u=b||0,v!==b&&b!=="%"&&(this._pt.b=c,this._pt.r=$E);else if(m in s)oD.call(this,e,m,c,x?x+d:d);else if(m in e)this.add(e,m,c||e[m],x?x+d:d,i,a);else if(m!=="parseTransform"){un(m,d);continue}w||(m in s?C.push(m,0,s[m]):C.push(m,1,c||e[m])),r.push(m)}}D&&_l(this)},render:function(e,t){if(t.tween._time||!yn())for(var n=t._pt;n;)n.r(e,n.d),n=n._next;else t.styles.revert()},get:R4,aliases:_4,getSetter:function(e,t,n){var i=_4[t];return i&&i.indexOf(",")<0&&(t=i),t in F4&&t!==s4&&(e._gsap.x||R4(e,"x"))?n&&Ca===n?t==="scale"?qE:QE:(Ca=n||{})&&(t==="scale"?KE:eD):e.style&&!rn(e.style[t])?ZE:~t.indexOf("-")?XE:gn(e,t)},core:{_removeProperty:E5,_getMatrix:xn}};T3.utils.checkPrefix=Y9;T3.core.getStyleSaver=Sl;(function(o,e,t,n){var i=w3(o+","+e+","+t,function(a){F4[a]=1});w3(e,function(a){k3.units[a]="deg",Cl[a]=1}),_4[i[13]]=o+","+e,w3(n,function(a){var r=a.split(":");_4[r[1]]=i[r[0]]})})("x,y,z,scale,scaleX,scaleY,xPercent,yPercent","rotation,rotationX,rotationY,skewX,skewY","transform,transformOrigin,svgOrigin,force3D,smoothOrigin,transformPerspective","0:translateX,1:translateY,2:translateZ,8:rotate,8:rotationZ,8:rotateZ,9:rotateX,10:rotateY");w3("x,y,z,top,right,bottom,left,width,height,fontSize,padding,margin,perspective",function(o){k3.units[o]="px"});T3.registerPlugin(Dl);var Il=T3.registerPlugin(Dl)||T3;Il.core.Tween;function dD(o,e,t,n){const i=new E3,r=new tn(0,0,o,e,t,!1).getSpacedPoints(100);i.setFromPoints(r);const s=[];for(let g=0;g<r.length;g++)s.push(g/r.length);const u=new z3(new Float32Array(s),1);i.attributes.percent=u;const c=[];for(let g=0;g<r.length;g++){const y=new _2(15503171),m=new _2(15969910),v=y.lerp(m,g/r.length);c.push(v.r,v.g,v.b)}i.attributes.color=new z3(new Float32Array(c),3);const d=1.3,h=new en({size:d,transparent:!0,depthWrite:!1});h.onBeforeCompile=function(g){g.vertexShader=g.vertexShader.replace("void main() {",["attribute float percent;","void main() {"].join(`
`)),g.vertexShader=g.vertexShader.replace("gl_PointSize = size;",["gl_PointSize = percent * size;"].join(`
`))};const p=new As(i,h);return h.color=new _2(n),p.name="飞行线",p}function fD(o,e,t,n,i,a){const r=A5(o,e,t),s=new Y(r.x,r.y,r.z),u=A5(o,n,i),c=new Y(u.x,u.y,u.z),d=hD(s,c),h=pD(o,d.startPoint,d.endPoint,a);return h.quaternion.multiply(d.quaternion),h}function hD(o,e){const t=new Y(0,0,0),n=o.clone().sub(t),i=e.clone().sub(t),a=n.clone().cross(i).normalize(),r=new Y(0,0,1),s=new k4().setFromUnitVectors(a,r),u=o.clone().applyQuaternion(s),c=e.clone().applyQuaternion(s),h=u.clone().add(c).multiplyScalar(.5).clone().sub(t).normalize(),p=new Y(0,1,0),g=new k4().setFromUnitVectors(h,p),y=u.clone().applyQuaternion(g),m=c.clone().applyQuaternion(g);return{quaternion:s.clone().invert().multiply(g.clone().invert()),startPoint:y,endPoint:m}}function pD(o,e,t,n){const a=new Y().addVectors(e,t).multiplyScalar(.5).clone().normalize(),r=La(e,t,new Y(0,0,0)),s=a.multiplyScalar(o+r*o*.2),u=gD(e,t,s),c=Math.abs(u.y-s.y),d=La(e,new Y(0,-1,0),u),h=-Math.PI/2+d,p=Math.PI-h,g=mD(u.x,u.y,c,h,p,n.color);g.center=u,g.topCoord=s;const y=(p-h)/7,m=dD(c,h,h+y,n.flyLineColor);return m.position.y=u.y,g.add(m),m.flyEndAngle=p-h-y,m.startAngle=h,m.AngleZ=g.flyEndAngle*Math.random(),g.userData.flyLine=m,g}function La(o,e,t){const n=o.clone().sub(t).normalize(),i=e.clone().sub(t).normalize(),a=n.clone().dot(i);return Math.acos(a)}function mD(o,e,t,n,i,a){const r=new E3,u=new tn(o,e,t,n,i,!1).getSpacedPoints(80);r.setFromPoints(u);const c=new Ms({color:a||13731143});return new cT(r,c)}function gD(o,e,t){const n=o.lengthSq(),i=e.lengthSq(),a=t.lengthSq(),r=o.x,s=o.y,u=e.x,c=e.y,d=t.x,h=t.y,p=r*c+u*h+d*s-r*h-u*s-d*c,g=(i*h+n*c+a*s-i*s-a*c-n*h)/p/2,y=(a*u+i*r+n*d-n*u-i*d-a*r)/p/2;return new Y(g,y,0)}const _D=`
varying vec2 vUv;
varying vec3 vNormal;
varying vec3 vp;
varying vec3 vPositionNormal;
void main(void){
  vUv = uv;
  vNormal = normalize( normalMatrix * normal ); // 转换到视图空间
  vp = position;
  vPositionNormal = normalize(( modelViewMatrix * vec4(position, 1.0) ).xyz);
  gl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );
}`,vD=`uniform vec3 glowColor;
uniform float bias;
uniform float power;
uniform float time;
varying vec3 vp;
varying vec3 vNormal;
varying vec3 vPositionNormal;
uniform float scale;
// 获取纹理
uniform sampler2D map;
// 纹理坐标
varying vec2 vUv;

void main(void){
  float a = pow( bias + scale * abs(dot(vNormal, vPositionNormal)), power );
  if(vp.y > time && vp.y < time + 20.0) {
    float t =  smoothstep(0.0, 0.8,  (1.0 - abs(0.5 - (vp.y - time) / 20.0)) / 3.0  );
    gl_FragColor = mix(gl_FragColor, vec4(glowColor, 1.0), t * t );
  }
  gl_FragColor = mix(gl_FragColor, vec4( glowColor, 1.0 ), a);
  float b = 0.8;
  gl_FragColor = gl_FragColor + texture2D( map, vUv );
}`;class yD{constructor(e){Q(this,"group");Q(this,"earthGroup");Q(this,"around");Q(this,"aroundPoints");Q(this,"options");Q(this,"uniforms");Q(this,"timeValue");Q(this,"earth");Q(this,"punctuationMaterial");Q(this,"markupPoint");Q(this,"waveMeshArr");Q(this,"circleLineList");Q(this,"circleList");Q(this,"x");Q(this,"n");Q(this,"isRotation");Q(this,"flyLineArcGroup");this.options=e,this.group=new P4,this.group.name="group",this.group.scale.set(0,0,0),this.earthGroup=new P4,this.group.add(this.earthGroup),this.earthGroup.name="EarthGroup",this.markupPoint=new P4,this.markupPoint.name="markupPoint",this.waveMeshArr=[],this.circleLineList=[],this.circleList=[],this.x=0,this.n=0,this.isRotation=this.options.earth.isRotation,this.timeValue=200,this.uniforms={glowColor:{value:new _2(840171)},scale:{type:"f",value:-1},bias:{type:"f",value:1},power:{type:"f",value:3.3},time:{type:"f",value:this.timeValue},isHover:{value:!1},map:{value:void 0}}}init(){return E2(this,null,function*(){return new Promise(e=>{(()=>E2(this,null,function*(){this.createEarth(),this.createEarthGlow(),this.createEarthAperture(),yield this.createMarkupPoint(),this.createAnimateCircle(),this.createFlyLine(),this.show(),e()}))()})})}createEarth(){const e=new q4(this.options.earth.radius,50,50),t=new q4(this.options.earth.radius+10,60,60),n=new en({color:8519679,transparent:!0,sizeAttenuation:!0,opacity:.1,vertexColors:!1,size:.2}),i=new As(t,n);this.earthGroup.add(i),this.uniforms.map.value=this.options.textures.earth;const a=new N4({uniforms:this.uniforms,vertexShader:_D,fragmentShader:vD});a.needsUpdate=!0,this.earth=new s3(e,a),this.earth.name="earth",this.earthGroup.add(this.earth)}createEarthGlow(){const e=this.options.earth.radius,t=this.options.textures.glow,n=new xs({map:t,color:4427985,transparent:!0,opacity:.7,depthWrite:!1}),i=new uT(n);i.scale.set(e*3,e*3,1),this.earthGroup.add(i)}createEarthAperture(){const e=["varying vec3	vVertexWorldPosition;","varying vec3	vVertexNormal;","varying vec4	vFragColor;","void main(){","	vVertexNormal	= normalize(normalMatrix * normal);","	vVertexWorldPosition	= (modelMatrix * vec4(position, 1.0)).xyz;","	// set gl_Position","	gl_Position	= projectionMatrix * modelViewMatrix * vec4(position, 1.0);","}"].join(`
`),t={uniforms:{coeficient:{type:"f",value:1},power:{type:"f",value:3},glowColor:{type:"c",value:new _2(4427985)}},vertexShader:e,fragmentShader:["uniform vec3	glowColor;","uniform float	coeficient;","uniform float	power;","varying vec3	vVertexNormal;","varying vec3	vVertexWorldPosition;","varying vec4	vFragColor;","void main(){","	vec3 worldCameraToVertex = vVertexWorldPosition - cameraPosition;","	vec3 viewCameraToVertex	= (viewMatrix * vec4(worldCameraToVertex, 0.0)).xyz;","	viewCameraToVertex= normalize(viewCameraToVertex);","	float intensity	= pow(coeficient + dot(vVertexNormal, viewCameraToVertex), power);","	gl_FragColor = vec4(glowColor, intensity);","}"].join(`
`)},n=new N4({uniforms:t.uniforms,vertexShader:t.vertexShader,fragmentShader:t.fragmentShader,blending:O0,transparent:!0,depthWrite:!1}),i=new q4(this.options.earth.radius+0,50,50),a=new s3(i,n);this.earthGroup.add(a)}createMarkupPoint(){return E2(this,null,function*(){yield Promise.all(this.options.data.map(e=>E2(this,null,function*(){const t=this.options.earth.radius,n=e.startArray.E,i=e.startArray.N;this.punctuationMaterial=new O4({color:this.options.punctuation.circleColor,map:this.options.textures.label,transparent:!0,depthWrite:!1});const a=_a({radius:t,lon:n,lat:i,material:this.punctuationMaterial});this.markupPoint.add(a);const r=ga({radius:this.options.earth.radius,lon:n,lat:i,index:0,textures:this.options.textures,punctuation:this.options.punctuation});this.markupPoint.add(r);const s=ma({radius:t,lon:n,lat:i,textures:this.options.textures});this.markupPoint.add(s),this.waveMeshArr.push(s),yield Promise.all(e.endArray.map(u=>{const c=u.E,d=u.N,h=_a({radius:t,lon:c,lat:d,material:this.punctuationMaterial});this.markupPoint.add(h);const p=ga({radius:this.options.earth.radius,lon:c,lat:d,index:1,textures:this.options.textures,punctuation:this.options.punctuation});this.markupPoint.add(p);const g=ma({radius:t,lon:c,lat:d,textures:this.options.textures});this.markupPoint.add(g),this.waveMeshArr.push(g)})),this.earthGroup.add(this.markupPoint)})))})}createAnimateCircle(){const e=XT({radius:this.options.earth.radius+15,number:150,closed:!0}),t=new O4({color:"#0c3172",transparent:!0,opacity:.4,side:m4}),n=QT({pointList:e,material:t,number:100,radius:.1});this.earthGroup.add(n);const i=n.clone();i.scale.set(1.2,1.2,1.2),i.rotateZ(Math.PI/6),this.earthGroup.add(i);const a=n.clone();a.scale.set(.8,.8,.8),a.rotateZ(-Math.PI/6),this.earthGroup.add(a);const r=new s3(new q4(this.options.satellite.size,32,32),new O4({color:"#e0b187"})),s=new s3(new q4(this.options.satellite.size,32,32),new O4({color:"#628fbb"})),u=new s3(new q4(this.options.satellite.size,32,32),new O4({color:"#806bdf"}));this.circleLineList.push(n,i,a),r.name=s.name=u.name="卫星";for(let c=0;c<this.options.satellite.number;c++){const d=r.clone(),h=Math.floor(e.length/this.options.satellite.number);d.position.set(e[h*(c+1)][0]*1,e[h*(c+1)][1]*1,e[h*(c+1)][2]*1),n.add(d);const p=s.clone(),g=Math.floor(e.length/this.options.satellite.number);p.position.set(e[g*(c+1)][0]*1,e[g*(c+1)][1]*1,e[g*(c+1)][2]*1),i.add(p);const y=s.clone(),m=Math.floor(e.length/this.options.satellite.number);y.position.set(e[m*(c+1)][0]*1,e[m*(c+1)][1]*1,e[m*(c+1)][2]*1),a.add(y)}}createFlyLine(){this.flyLineArcGroup=new P4,this.flyLineArcGroup.userData.flyLineArray=[],this.earthGroup.add(this.flyLineArcGroup),this.options.data.forEach(e=>{e.endArray.forEach(t=>{const n=fD(this.options.earth.radius,e.startArray.E,e.startArray.N,t.E,t.N,this.options.flyLine);this.flyLineArcGroup.add(n),this.flyLineArcGroup.userData.flyLineArray.push(n.userData.flyLine)})})}show(){Il.to(this.group.scale,{x:1,y:1,z:1,duration:2,ease:"Quadratic"})}render(){var e,t;(t=(e=this.flyLineArcGroup)==null?void 0:e.userData.flyLineArray)==null||t.forEach(n=>{n.rotation.z+=this.options.flyLine.speed,n.rotation.z>=n.flyEndAngle&&(n.rotation.z=0)}),this.isRotation&&(this.earthGroup.rotation.y+=this.options.earth.rotateSpeed),this.circleLineList.forEach(n=>{n.rotateY(this.options.satellite.rotateSpeed)}),this.uniforms.time.value=this.uniforms.time.value<-this.timeValue?this.timeValue:this.uniforms.time.value-1,this.waveMeshArr.length&&this.waveMeshArr.forEach(n=>{n.userData.scale+=.007,n.scale.set(n.userData.size*n.userData.scale,n.userData.size*n.userData.scale,n.userData.size*n.userData.scale),n.userData.scale<=1.5?n.material.opacity=(n.userData.scale-1)*2:n.userData.scale>1.5&&n.userData.scale<=2?n.material.opacity=1-(n.userData.scale-1.5)*2:n.userData.scale=1})}}class bD{constructor(e){Q(this,"basic");Q(this,"scene");Q(this,"camera");Q(this,"renderer");Q(this,"controls");Q(this,"material");Q(this,"resources");Q(this,"option");Q(this,"earth");this.option=e,this.basic=new DT(e.dom),this.scene=this.basic.scene,this.renderer=this.basic.renderer,this.controls=this.basic.controls,this.camera=this.basic.camera,this.updateSize(),this.resources=new ZT(()=>E2(this,null,function*(){yield this.createEarth(),this.render()}))}createEarth(e){return E2(this,null,function*(){this.earth=new yD({data:e||this.option.data,dom:this.option.dom,textures:this.resources.textures,earth:{radius:50,rotateSpeed:.002,isRotation:!0},satellite:{show:!0,rotateSpeed:-.01,size:1,number:2},punctuation:{circleColor:3707647,lightColumn:{startColor:14942335,endColor:16777215}},flyLine:{color:15969910,flyLineColor:16742164,speed:.004}}),this.scene.add(this.earth.group),yield this.earth.init()})}render(){requestAnimationFrame(this.render.bind(this)),this.renderer.render(this.scene,this.camera),this.controls&&this.controls.update(),this.earth&&this.earth.render()}updateSize(e,t){let n=e||this.option.width,i=t||this.option.height;n<i?i=n:n=i,this.renderer.setSize(n,i),this.camera.aspect=n/i,this.camera.updateProjectionMatrix()}updateData(e){this.earth.group&&(this.scene.remove(this.earth.group),this.earth.group.traverse(t=>{t.type==="Mesh"&&(t.geometry.dispose(),t.material.dispose())}),this.createEarth(e))}}const xD=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=e2(),n=K1(),{w:i,h:a}=E1(e.chartConfig.attr);let r;const s=()=>{const c=n.value;c&&(r=new bD({dom:c,data:e.chartConfig.option.dataset,width:i.value,height:a.value}))},u=c=>{try{r.updateData(c)}catch(d){console.log(d)}};return B1(()=>[i.value,a.value],P5(([c],[d])=>{r.updateSize(c,d)},100)),B1(()=>e.chartConfig.option.dataset,c=>{u(c)},{deep:!1}),W0(()=>{try{if(navigator.userAgent.indexOf("Chrome")<-1||navigator.userAgent.indexOf("Edg")<-1){window.$message.error("三维地图组件仅在【谷歌】浏览器上能正常展示！"),t.removeComponentList(void 0,!1);return}s()}catch(c){console.log(c)}}),d2(e.chartConfig,e2,u),(c,d)=>(P(),n1("div",{ref_key:"chartRef",ref:n},null,512))}}),SD=Object.freeze(Object.defineProperty({__proto__:null,default:xD},Symbol.toStringTag,{value:"Module"})),b5=/^[a-z0-9]+(-[a-z0-9]+)*$/,l6=(o,e,t,n="")=>{const i=o.split(":");if(o.slice(0,1)==="@"){if(i.length<2||i.length>3)return null;n=i.shift().slice(1)}if(i.length>3||!i.length)return null;if(i.length>1){const s=i.pop(),u=i.pop(),c={provider:i.length>0?i[0]:n,prefix:u,name:s};return e&&!P8(c)?null:c}const a=i[0],r=a.split("-");if(r.length>1){const s={provider:n,prefix:r.shift(),name:r.join("-")};return e&&!P8(s)?null:s}if(t&&n===""){const s={provider:n,prefix:"",name:a};return e&&!P8(s,t)?null:s}return null},P8=(o,e)=>o?!!((o.provider===""||o.provider.match(b5))&&(e&&o.prefix===""||o.prefix.match(b5))&&o.name.match(b5)):!1,Rl=Object.freeze({left:0,top:0,width:16,height:16}),Q8=Object.freeze({rotate:0,vFlip:!1,hFlip:!1}),u6=Object.freeze(U1(U1({},Rl),Q8)),Be=Object.freeze(M2(U1({},u6),{body:"",hidden:!1}));function MD(o,e){const t={};!o.hFlip!=!e.hFlip&&(t.hFlip=!0),!o.vFlip!=!e.vFlip&&(t.vFlip=!0);const n=((o.rotate||0)+(e.rotate||0))%4;return n&&(t.rotate=n),t}function za(o,e){const t=MD(o,e);for(const n in Be)n in Q8?n in o&&!(n in t)&&(t[n]=Q8[n]):n in e?t[n]=e[n]:n in o&&(t[n]=o[n]);return t}function AD(o,e){const t=o.icons,n=o.aliases||Object.create(null),i=Object.create(null);function a(r){if(t[r])return i[r]=[];if(!(r in i)){i[r]=null;const s=n[r]&&n[r].parent,u=s&&a(s);u&&(i[r]=[s].concat(u))}return i[r]}return(e||Object.keys(t).concat(Object.keys(n))).forEach(a),i}function wD(o,e,t){const n=o.icons,i=o.aliases||Object.create(null);let a={};function r(s){a=za(n[s]||i[s],a)}return r(e),t.forEach(r),za(o,a)}function Ol(o,e){const t=[];if(typeof o!="object"||typeof o.icons!="object")return t;o.not_found instanceof Array&&o.not_found.forEach(i=>{e(i,null),t.push(i)});const n=AD(o);for(const i in n){const a=n[i];a&&(e(i,wD(o,i,a)),t.push(i))}return t}const CD=U1({provider:"",aliases:{},not_found:{}},Rl);function p7(o,e){for(const t in e)if(t in o&&typeof o[t]!=typeof e[t])return!1;return!0}function Pl(o){if(typeof o!="object"||o===null)return null;const e=o;if(typeof e.prefix!="string"||!o.icons||typeof o.icons!="object"||!p7(o,CD))return null;const t=e.icons;for(const i in t){const a=t[i];if(!i.match(b5)||typeof a.body!="string"||!p7(a,Be))return null}const n=e.aliases||Object.create(null);for(const i in n){const a=n[i],r=a.parent;if(!i.match(b5)||typeof r!="string"||!t[r]&&!n[r]||!p7(a,Be))return null}return e}const ka=Object.create(null);function TD(o,e){return{provider:o,prefix:e,icons:Object.create(null),missing:new Set}}function j0(o,e){const t=ka[o]||(ka[o]=Object.create(null));return t[e]||(t[e]=TD(o,e))}function Sn(o,e){return Pl(e)?Ol(e,(t,n)=>{n?o.icons[t]=n:o.missing.add(t)}):[]}function ED(o,e,t){try{if(typeof t.body=="string")return o.icons[e]=U1({},t),!0}catch(n){}return!1}let R5=!1;function Ll(o){return typeof o=="boolean"&&(R5=o),R5}function DD(o){const e=typeof o=="string"?l6(o,!0,R5):o;if(e){const t=j0(e.provider,e.prefix),n=e.name;return t.icons[n]||(t.missing.has(n)?null:void 0)}}function ID(o,e){const t=l6(o,!0,R5);if(!t)return!1;const n=j0(t.provider,t.prefix);return ED(n,t.name,e)}function RD(o,e){if(typeof o!="object")return!1;if(typeof e!="string"&&(e=o.provider||""),R5&&!e&&!o.prefix){let i=!1;return Pl(o)&&(o.prefix="",Ol(o,(a,r)=>{r&&ID(a,r)&&(i=!0)})),i}const t=o.prefix;if(!P8({provider:e,prefix:t,name:"a"}))return!1;const n=j0(e,t);return!!Sn(n,o)}const zl=Object.freeze({width:null,height:null}),kl=Object.freeze(U1(U1({},zl),Q8)),OD=/(-?[0-9.]*[0-9]+[0-9.]*)/g,PD=/^-?[0-9.]*[0-9]+[0-9.]*$/g;function Na(o,e,t){if(e===1)return o;if(t=t||100,typeof o=="number")return Math.ceil(o*e*t)/t;if(typeof o!="string")return o;const n=o.split(OD);if(n===null||!n.length)return o;const i=[];let a=n.shift(),r=PD.test(a);for(;;){if(r){const s=parseFloat(a);isNaN(s)?i.push(a):i.push(Math.ceil(s*e*t)/t)}else i.push(a);if(a=n.shift(),a===void 0)return i.join("");r=!r}}const LD=o=>o==="unset"||o==="undefined"||o==="none";function zD(o,e){const t=U1(U1({},u6),o),n=U1(U1({},kl),e),i={left:t.left,top:t.top,width:t.width,height:t.height};let a=t.body;[t,n].forEach(y=>{const m=[],v=y.hFlip,b=y.vFlip;let x=y.rotate;v?b?x+=2:(m.push("translate("+(i.width+i.left).toString()+" "+(0-i.top).toString()+")"),m.push("scale(-1 1)"),i.top=i.left=0):b&&(m.push("translate("+(0-i.left).toString()+" "+(i.height+i.top).toString()+")"),m.push("scale(1 -1)"),i.top=i.left=0);let w;switch(x<0&&(x-=Math.floor(x/4)*4),x=x%4,x){case 1:w=i.height/2+i.top,m.unshift("rotate(90 "+w.toString()+" "+w.toString()+")");break;case 2:m.unshift("rotate(180 "+(i.width/2+i.left).toString()+" "+(i.height/2+i.top).toString()+")");break;case 3:w=i.width/2+i.left,m.unshift("rotate(-90 "+w.toString()+" "+w.toString()+")");break}x%2===1&&(i.left!==i.top&&(w=i.left,i.left=i.top,i.top=w),i.width!==i.height&&(w=i.width,i.width=i.height,i.height=w)),m.length&&(a='<g transform="'+m.join(" ")+'">'+a+"</g>")});const r=n.width,s=n.height,u=i.width,c=i.height;let d,h;r===null?(h=s===null?"1em":s==="auto"?c:s,d=Na(h,u/c)):(d=r==="auto"?u:r,h=s===null?Na(d,c/u):s==="auto"?c:s);const p={},g=(y,m)=>{LD(m)||(p[y]=m.toString())};return g("width",d),g("height",h),p.viewBox=i.left.toString()+" "+i.top.toString()+" "+u.toString()+" "+c.toString(),{attributes:p,body:a}}const kD=/\sid="(\S+)"/g,ND="IconifyId"+Date.now().toString(16)+(Math.random()*16777216|0).toString(16);let UD=0;function FD(o,e=ND){const t=[];let n;for(;n=kD.exec(o);)t.push(n[1]);if(!t.length)return o;const i="suffix"+(Math.random()*16777216|Date.now()).toString(16);return t.forEach(a=>{const r=typeof e=="function"?e(a):e+(UD++).toString(),s=a.replace(/[.*+?^${}()|[\]\\]/g,"\\$&");o=o.replace(new RegExp('([#;"])('+s+')([")]|\\.[a-z])',"g"),"$1"+r+i+"$3")}),o=o.replace(new RegExp(i,"g"),""),o}const Ge=Object.create(null);function BD(o,e){Ge[o]=e}function Ve(o){return Ge[o]||Ge[""]}function Mn(o){let e;if(typeof o.resources=="string")e=[o.resources];else if(e=o.resources,!(e instanceof Array)||!e.length)return null;return{resources:e,path:o.path||"/",maxURL:o.maxURL||500,rotate:o.rotate||750,timeout:o.timeout||5e3,random:o.random===!0,index:o.index||0,dataAfterTimeout:o.dataAfterTimeout!==!1}}const An=Object.create(null),s5=["https://api.simplesvg.com","https://api.unisvg.com"],L8=[];for(;s5.length>0;)s5.length===1||Math.random()>.5?L8.push(s5.shift()):L8.push(s5.pop());An[""]=Mn({resources:["https://api.iconify.design"].concat(L8)});function GD(o,e){const t=Mn(e);return t===null?!1:(An[o]=t,!0)}function wn(o){return An[o]}const VD=()=>{let o;try{if(o=fetch,typeof o=="function")return o}catch(e){}};let Ua=VD();function jD(o,e){const t=wn(o);if(!t)return 0;let n;if(!t.maxURL)n=0;else{let i=0;t.resources.forEach(r=>{i=Math.max(i,r.length)});const a=e+".json?icons=";n=t.maxURL-i-t.path.length-a.length}return n}function WD(o){return o===404}const HD=(o,e,t)=>{const n=[],i=jD(o,e),a="icons";let r={type:a,provider:o,prefix:e,icons:[]},s=0;return t.forEach((u,c)=>{s+=u.length+1,s>=i&&c>0&&(n.push(r),r={type:a,provider:o,prefix:e,icons:[]},s=u.length),r.icons.push(u)}),n.push(r),n};function YD(o){if(typeof o=="string"){const e=wn(o);if(e)return e.path}return"/"}const $D=(o,e,t)=>{if(!Ua){t("abort",424);return}let n=YD(e.provider);switch(e.type){case"icons":{const a=e.prefix,s=e.icons.join(","),u=new URLSearchParams({icons:s});n+=a+".json?"+u.toString();break}case"custom":{const a=e.uri;n+=a.slice(0,1)==="/"?a.slice(1):a;break}default:t("abort",400);return}let i=503;Ua(o+n).then(a=>{const r=a.status;if(r!==200){setTimeout(()=>{t(WD(r)?"abort":"next",r)});return}return i=501,a.json()}).then(a=>{if(typeof a!="object"||a===null){setTimeout(()=>{a===404?t("abort",a):t("next",i)});return}setTimeout(()=>{t("success",a)})}).catch(()=>{t("next",i)})},JD={prepare:HD,send:$D};function ZD(o){const e={loaded:[],missing:[],pending:[]},t=Object.create(null);o.sort((i,a)=>i.provider!==a.provider?i.provider.localeCompare(a.provider):i.prefix!==a.prefix?i.prefix.localeCompare(a.prefix):i.name.localeCompare(a.name));let n={provider:"",prefix:"",name:""};return o.forEach(i=>{if(n.name===i.name&&n.prefix===i.prefix&&n.provider===i.provider)return;n=i;const a=i.provider,r=i.prefix,s=i.name,u=t[a]||(t[a]=Object.create(null)),c=u[r]||(u[r]=j0(a,r));let d;s in c.icons?d=e.loaded:r===""||c.missing.has(s)?d=e.missing:d=e.pending;const h={provider:a,prefix:r,name:s};d.push(h)}),e}function Nl(o,e){o.forEach(t=>{const n=t.loaderCallbacks;n&&(t.loaderCallbacks=n.filter(i=>i.id!==e))})}function XD(o){o.pendingCallbacksFlag||(o.pendingCallbacksFlag=!0,setTimeout(()=>{o.pendingCallbacksFlag=!1;const e=o.loaderCallbacks?o.loaderCallbacks.slice(0):[];if(!e.length)return;let t=!1;const n=o.provider,i=o.prefix;e.forEach(a=>{const r=a.icons,s=r.pending.length;r.pending=r.pending.filter(u=>{if(u.prefix!==i)return!0;const c=u.name;if(o.icons[c])r.loaded.push({provider:n,prefix:i,name:c});else if(o.missing.has(c))r.missing.push({provider:n,prefix:i,name:c});else return t=!0,!0;return!1}),r.pending.length!==s&&(t||Nl([o],a.id),a.callback(r.loaded.slice(0),r.missing.slice(0),r.pending.slice(0),a.abort))})}))}let QD=0;function qD(o,e,t){const n=QD++,i=Nl.bind(null,t,n);if(!e.pending.length)return i;const a={id:n,icons:e,callback:o,abort:i};return t.forEach(r=>{(r.loaderCallbacks||(r.loaderCallbacks=[])).push(a)}),i}function KD(o,e=!0,t=!1){const n=[];return o.forEach(i=>{const a=typeof i=="string"?l6(i,e,t):i;a&&n.push(a)}),n}var eI={resources:[],index:0,timeout:2e3,rotate:750,random:!1,dataAfterTimeout:!1};function tI(o,e,t,n){const i=o.resources.length,a=o.random?Math.floor(Math.random()*i):o.index;let r;if(o.random){let S=o.resources.slice(0);for(r=[];S.length>1;){const D=Math.floor(Math.random()*S.length);r.push(S[D]),S=S.slice(0,D).concat(S.slice(D+1))}r=r.concat(S)}else r=o.resources.slice(a).concat(o.resources.slice(0,a));const s=Date.now();let u="pending",c=0,d,h=null,p=[],g=[];typeof n=="function"&&g.push(n);function y(){h&&(clearTimeout(h),h=null)}function m(){u==="pending"&&(u="aborted"),y(),p.forEach(S=>{S.status==="pending"&&(S.status="aborted")}),p=[]}function v(S,D){D&&(g=[]),typeof S=="function"&&g.push(S)}function b(){return{startTime:s,payload:e,status:u,queriesSent:c,queriesPending:p.length,subscribe:v,abort:m}}function x(){u="failed",g.forEach(S=>{S(void 0,d)})}function w(){p.forEach(S=>{S.status==="pending"&&(S.status="aborted")}),p=[]}function M(S,D,C){const E=D!=="success";switch(p=p.filter(k=>k!==S),u){case"pending":break;case"failed":if(E||!o.dataAfterTimeout)return;break;default:return}if(D==="abort"){d=C,x();return}if(E){d=C,p.length||(r.length?A():x());return}if(y(),w(),!o.random){const k=o.resources.indexOf(S.resource);k!==-1&&k!==o.index&&(o.index=k)}u="completed",g.forEach(k=>{k(C)})}function A(){if(u!=="pending")return;y();const S=r.shift();if(S===void 0){if(p.length){h=setTimeout(()=>{y(),u==="pending"&&(w(),x())},o.timeout);return}x();return}const D={status:"pending",resource:S,callback:(C,E)=>{M(D,C,E)}};p.push(D),c++,h=setTimeout(A,o.rotate),t(S,e,D.callback)}return setTimeout(A),b}function Ul(o){const e=U1(U1({},eI),o);let t=[];function n(){t=t.filter(s=>s().status==="pending")}function i(s,u,c){const d=tI(e,s,u,(h,p)=>{n(),c&&c(h,p)});return t.push(d),d}function a(s){return t.find(u=>s(u))||null}return{query:i,find:a,setIndex:s=>{e.index=s},getIndex:()=>e.index,cleanup:n}}function Fa(){}const m7=Object.create(null);function nI(o){if(!m7[o]){const e=wn(o);if(!e)return;const t=Ul(e),n={config:e,redundancy:t};m7[o]=n}return m7[o]}function iI(o,e,t){let n,i;if(typeof o=="string"){const a=Ve(o);if(!a)return t(void 0,424),Fa;i=a.send;const r=nI(o);r&&(n=r.redundancy)}else{const a=Mn(o);if(a){n=Ul(a);const r=o.resources?o.resources[0]:"",s=Ve(r);s&&(i=s.send)}}return!n||!i?(t(void 0,424),Fa):n.query(e,i,t)().abort}const Ba="iconify2",O5="iconify",Fl=O5+"-count",Ga=O5+"-version",Bl=36e5,oI=168;function je(o,e){try{return o.getItem(e)}catch(t){}}function Cn(o,e,t){try{return o.setItem(e,t),!0}catch(n){}}function Va(o,e){try{o.removeItem(e)}catch(t){}}function We(o,e){return Cn(o,Fl,e.toString())}function He(o){return parseInt(je(o,Fl))||0}const c6={local:!0,session:!0},Gl={local:new Set,session:new Set};let Tn=!1;function aI(o){Tn=o}let w8=typeof window=="undefined"?{}:window;function Vl(o){const e=o+"Storage";try{if(w8&&w8[e]&&typeof w8[e].length=="number")return w8[e]}catch(t){}c6[o]=!1}function jl(o,e){const t=Vl(o);if(!t)return;const n=je(t,Ga);if(n!==Ba){if(n){const s=He(t);for(let u=0;u<s;u++)Va(t,O5+u.toString())}Cn(t,Ga,Ba),We(t,0);return}const i=Math.floor(Date.now()/Bl)-oI,a=s=>{const u=O5+s.toString(),c=je(t,u);if(typeof c=="string"){try{const d=JSON.parse(c);if(typeof d=="object"&&typeof d.cached=="number"&&d.cached>i&&typeof d.provider=="string"&&typeof d.data=="object"&&typeof d.data.prefix=="string"&&e(d,s))return!0}catch(d){}Va(t,u)}};let r=He(t);for(let s=r-1;s>=0;s--)a(s)||(s===r-1?(r--,We(t,r)):Gl[o].add(s))}function Wl(){if(!Tn){aI(!0);for(const o in c6)jl(o,e=>{const t=e.data,n=e.provider,i=t.prefix,a=j0(n,i);if(!Sn(a,t).length)return!1;const r=t.lastModified||-1;return a.lastModifiedCached=a.lastModifiedCached?Math.min(a.lastModifiedCached,r):r,!0})}}function rI(o,e){const t=o.lastModifiedCached;if(t&&t>=e)return t===e;if(o.lastModifiedCached=e,t)for(const n in c6)jl(n,i=>{const a=i.data;return i.provider!==o.provider||a.prefix!==o.prefix||a.lastModified===e});return!0}function sI(o,e){Tn||Wl();function t(n){let i;if(!c6[n]||!(i=Vl(n)))return;const a=Gl[n];let r;if(a.size)a.delete(r=Array.from(a).shift());else if(r=He(i),!We(i,r+1))return;const s={cached:Math.floor(Date.now()/Bl),provider:o.provider,data:e};return Cn(i,O5+r.toString(),JSON.stringify(s))}e.lastModified&&!rI(o,e.lastModified)||Object.keys(e.icons).length&&(e.not_found&&(e=Object.assign({},e),delete e.not_found),t("local")||t("session"))}function ja(){}function lI(o){o.iconsLoaderFlag||(o.iconsLoaderFlag=!0,setTimeout(()=>{o.iconsLoaderFlag=!1,XD(o)}))}function uI(o,e){o.iconsToLoad?o.iconsToLoad=o.iconsToLoad.concat(e).sort():o.iconsToLoad=e,o.iconsQueueFlag||(o.iconsQueueFlag=!0,setTimeout(()=>{o.iconsQueueFlag=!1;const{provider:t,prefix:n}=o,i=o.iconsToLoad;delete o.iconsToLoad;let a;if(!i||!(a=Ve(t)))return;a.prepare(t,n,i).forEach(s=>{iI(t,s,u=>{if(typeof u!="object")s.icons.forEach(c=>{o.missing.add(c)});else try{const c=Sn(o,u);if(!c.length)return;const d=o.pendingIcons;d&&c.forEach(h=>{d.delete(h)}),sI(o,u)}catch(c){console.error(c)}lI(o)})})}))}const cI=(o,e)=>{const t=KD(o,!0,Ll()),n=ZD(t);if(!n.pending.length){let u=!0;return e&&setTimeout(()=>{u&&e(n.loaded,n.missing,n.pending,ja)}),()=>{u=!1}}const i=Object.create(null),a=[];let r,s;return n.pending.forEach(u=>{const{provider:c,prefix:d}=u;if(d===s&&c===r)return;r=c,s=d,a.push(j0(c,d));const h=i[c]||(i[c]=Object.create(null));h[d]||(h[d]=[])}),n.pending.forEach(u=>{const{provider:c,prefix:d,name:h}=u,p=j0(c,d),g=p.pendingIcons||(p.pendingIcons=new Set);g.has(h)||(g.add(h),i[c][d].push(h))}),a.forEach(u=>{const{provider:c,prefix:d}=u;i[c][d].length&&uI(u,i[c][d])}),e?qD(e,n,a):ja};function dI(o,e){const t=U1({},o);for(const n in e){const i=e[n],a=typeof i;n in zl?(i===null||i&&(a==="string"||a==="number"))&&(t[n]=i):a===typeof t[n]&&(t[n]=n==="rotate"?i%4:i)}return t}const fI=/[\s,]+/;function hI(o,e){e.split(fI).forEach(t=>{switch(t.trim()){case"horizontal":o.hFlip=!0;break;case"vertical":o.vFlip=!0;break}})}function pI(o,e=0){const t=o.replace(/^-?[0-9.]*/,"");function n(i){for(;i<0;)i+=4;return i%4}if(t===""){const i=parseInt(o);return isNaN(i)?0:n(i)}else if(t!==o){let i=0;switch(t){case"%":i=25;break;case"deg":i=90}if(i){let a=parseFloat(o.slice(0,o.length-t.length));return isNaN(a)?0:(a=a/i,a%1===0?n(a):0)}}return e}function mI(o,e){let t=o.indexOf("xlink:")===-1?"":' xmlns:xlink="http://www.w3.org/1999/xlink"';for(const n in e)t+=" "+n+'="'+e[n]+'"';return'<svg xmlns="http://www.w3.org/2000/svg"'+t+">"+o+"</svg>"}function gI(o){return o.replace(/"/g,"'").replace(/%/g,"%25").replace(/#/g,"%23").replace(/</g,"%3C").replace(/>/g,"%3E").replace(/\s+/g," ")}function _I(o){return"data:image/svg+xml,"+gI(o)}function vI(o){return'url("'+_I(o)+'")'}const Wa=M2(U1({},kl),{inline:!1}),yI={xmlns:"http://www.w3.org/2000/svg","xmlns:xlink":"http://www.w3.org/1999/xlink","aria-hidden":!0,role:"img"},bI={display:"inline-block"},Ye={backgroundColor:"currentColor"},Hl={backgroundColor:"transparent"},Ha={Image:"var(--svg)",Repeat:"no-repeat",Size:"100% 100%"},Ya={webkitMask:Ye,mask:Ye,background:Hl};for(const o in Ya){const e=Ya[o];for(const t in Ha)e[o+t]=Ha[t]}const z8={};["horizontal","vertical"].forEach(o=>{const e=o.slice(0,1)+"Flip";z8[o+"-flip"]=e,z8[o.slice(0,1)+"-flip"]=e,z8[o+"Flip"]=e});function $a(o){return o+(o.match(/^[-0-9.]+$/)?"px":"")}const Ja=(o,e)=>{const t=dI(Wa,e),n=U1({},yI),i=e.mode||"svg",a={},r=e.style,s=typeof r=="object"&&!(r instanceof Array)?r:{};for(let m in e){const v=e[m];if(v!==void 0)switch(m){case"icon":case"style":case"onLoad":case"mode":break;case"inline":case"hFlip":case"vFlip":t[m]=v===!0||v==="true"||v===1;break;case"flip":typeof v=="string"&&hI(t,v);break;case"color":a.color=v;break;case"rotate":typeof v=="string"?t[m]=pI(v):typeof v=="number"&&(t[m]=v);break;case"ariaHidden":case"aria-hidden":v!==!0&&v!=="true"&&delete n["aria-hidden"];break;default:{const b=z8[m];b?(v===!0||v==="true"||v===1)&&(t[b]=!0):Wa[m]===void 0&&(n[m]=v)}}}const u=zD(o,t),c=u.attributes;if(t.inline&&(a.verticalAlign="-0.125em"),i==="svg"){n.style=U1(U1({},a),s),Object.assign(n,c);let m=0,v=e.id;return typeof v=="string"&&(v=v.replace(/-/g,"_")),n.innerHTML=FD(u.body,v?()=>v+"ID"+m++:"iconifyVue"),Hn("svg",n)}const{body:d,width:h,height:p}=o,g=i==="mask"||(i==="bg"?!1:d.indexOf("currentColor")!==-1),y=mI(d,M2(U1({},c),{width:h+"",height:p+""}));return n.style=U1(U1(U1(M2(U1({},a),{"--svg":vI(y),width:$a(c.width),height:$a(c.height)}),bI),g?Ye:Hl),s),Hn("span",n)};Ll(!0);BD("",JD);if(typeof document!="undefined"&&typeof window!="undefined"){Wl();const o=window;if(o.IconifyPreload!==void 0){const e=o.IconifyPreload,t="Invalid IconifyPreload syntax.";typeof e=="object"&&e!==null&&(e instanceof Array?e:[e]).forEach(n=>{try{(typeof n!="object"||n===null||n instanceof Array||typeof n.icons!="object"||typeof n.prefix!="string"||!RD(n))&&console.error(t)}catch(i){console.error(t)}})}if(o.IconifyProviders!==void 0){const e=o.IconifyProviders;if(typeof e=="object"&&e!==null)for(let t in e){const n="IconifyProviders["+t+"] is invalid.";try{const i=e[t];if(typeof i!="object"||!i||i.resources===void 0)continue;GD(t,i)||console.error(n)}catch(i){console.error(n)}}}}const xI=M2(U1({},u6),{body:""}),SI=c1({inheritAttrs:!1,data(){return{iconMounted:!1,counter:0}},mounted(){this._name="",this._loadingIcon=null,this.iconMounted=!0},unmounted(){this.abortLoading()},methods:{abortLoading(){this._loadingIcon&&(this._loadingIcon.abort(),this._loadingIcon=null)},getIcon(o,e){if(typeof o=="object"&&o!==null&&typeof o.body=="string")return this._name="",this.abortLoading(),{data:o};let t;if(typeof o!="string"||(t=l6(o,!1,!0))===null)return this.abortLoading(),null;const n=DD(t);if(!n)return(!this._loadingIcon||this._loadingIcon.name!==o)&&(this.abortLoading(),this._name="",n!==null&&(this._loadingIcon={name:o,abort:cI([t],()=>{this.counter++})})),null;this.abortLoading(),this._name!==o&&(this._name=o,e&&e(o));const i=["iconify"];return t.prefix!==""&&i.push("iconify--"+t.prefix),t.provider!==""&&i.push("iconify--"+t.provider),{data:n,classes:i}}},render(){this.counter;const o=this.$attrs,e=this.iconMounted?this.getIcon(o.icon,o.onLoad):null;if(!e)return Ja(xI,o);let t=o;return e.classes&&(t=M2(U1({},o),{class:(typeof o.class=="string"?o.class+" ":"")+e.classes.join(" ")})),Ja(U1(U1({},u6),e.data),t)}}),MI={class:"go-icon-box"},AI=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;u4(u=>({"41d5a0df":`${l(t)}px`,41024050:`${l(n)}px`}));const{w:t,h:n}=E1(e.chartConfig.attr),{dataset:i,color:a,size:r,rotate:s}=E1(e.chartConfig.option);return(u,c)=>(P(),n1("div",MI,[f(l(SI),{icon:l(i)||"",color:l(a),width:l(r),rotate:l(s)},null,8,["icon","color","width","rotate"])]))}});const wI=c2(AI,[["__scopeId","data-v-449236d6"]]),CI=Object.freeze(Object.defineProperty({__proto__:null,default:wI},Symbol.toStringTag,{value:"Module"}));var Yl={exports:{}};(function(o,e){(function(t,n){o.exports=n()})(Ke,function(){var t=1e3,n=6e4,i=36e5,a="millisecond",r="second",s="minute",u="hour",c="day",d="week",h="month",p="quarter",g="year",y="date",m="Invalid Date",v=/^(\d{4})[-/]?(\d{1,2})?[-/]?(\d{0,2})[Tt\s]*(\d{1,2})?:?(\d{1,2})?:?(\d{1,2})?[.:]?(\d+)?$/,b=/\[([^\]]+)]|Y{1,4}|M{1,4}|D{1,2}|d{1,4}|H{1,2}|h{1,2}|a|A|m{1,2}|s{1,2}|Z{1,2}|SSS/g,x={name:"en",weekdays:"Sunday_Monday_Tuesday_Wednesday_Thursday_Friday_Saturday".split("_"),months:"January_February_March_April_May_June_July_August_September_October_November_December".split("_"),ordinal:function(F){var R=["th","st","nd","rd"],U=F%100;return"["+F+(R[(U-20)%10]||R[U]||R[0])+"]"}},w=function(F,R,U){var H=String(F);return!H||H.length>=R?F:""+Array(R+1-H.length).join(U)+F},M={s:w,z:function(F){var R=-F.utcOffset(),U=Math.abs(R),H=Math.floor(U/60),V=U%60;return(R<=0?"+":"-")+w(H,2,"0")+":"+w(V,2,"0")},m:function F(R,U){if(R.date()<U.date())return-F(U,R);var H=12*(U.year()-R.year())+(U.month()-R.month()),V=R.clone().add(H,h),N=U-V<0,z=R.clone().add(H+(N?-1:1),h);return+(-(H+(U-V)/(N?V-z:z-V))||0)},a:function(F){return F<0?Math.ceil(F)||0:Math.floor(F)},p:function(F){return{M:h,y:g,w:d,d:c,D:y,h:u,m:s,s:r,ms:a,Q:p}[F]||String(F||"").toLowerCase().replace(/s$/,"")},u:function(F){return F===void 0}},A="en",S={};S[A]=x;var D=function(F){return F instanceof $},C=function F(R,U,H){var V;if(!R)return A;if(typeof R=="string"){var N=R.toLowerCase();S[N]&&(V=N),U&&(S[N]=U,V=N);var z=R.split("-");if(!V&&z.length>1)return F(z[0])}else{var G=R.name;S[G]=R,V=G}return!H&&V&&(A=V),V||!H&&A},E=function(F,R){if(D(F))return F.clone();var U=typeof R=="object"?R:{};return U.date=F,U.args=arguments,new $(U)},k=M;k.l=C,k.i=D,k.w=function(F,R){return E(F,{locale:R.$L,utc:R.$u,x:R.$x,$offset:R.$offset})};var $=function(){function F(U){this.$L=C(U.locale,null,!0),this.parse(U)}var R=F.prototype;return R.parse=function(U){this.$d=function(H){var V=H.date,N=H.utc;if(V===null)return new Date(NaN);if(k.u(V))return new Date;if(V instanceof Date)return new Date(V);if(typeof V=="string"&&!/Z$/i.test(V)){var z=V.match(v);if(z){var G=z[2]-1||0,t1=(z[7]||"0").substring(0,3);return N?new Date(Date.UTC(z[1],G,z[3]||1,z[4]||0,z[5]||0,z[6]||0,t1)):new Date(z[1],G,z[3]||1,z[4]||0,z[5]||0,z[6]||0,t1)}}return new Date(V)}(U),this.$x=U.x||{},this.init()},R.init=function(){var U=this.$d;this.$y=U.getFullYear(),this.$M=U.getMonth(),this.$D=U.getDate(),this.$W=U.getDay(),this.$H=U.getHours(),this.$m=U.getMinutes(),this.$s=U.getSeconds(),this.$ms=U.getMilliseconds()},R.$utils=function(){return k},R.isValid=function(){return this.$d.toString()!==m},R.isSame=function(U,H){var V=E(U);return this.startOf(H)<=V&&V<=this.endOf(H)},R.isAfter=function(U,H){return E(U)<this.startOf(H)},R.isBefore=function(U,H){return this.endOf(H)<E(U)},R.$g=function(U,H,V){return k.u(U)?this[H]:this.set(V,U)},R.unix=function(){return Math.floor(this.valueOf()/1e3)},R.valueOf=function(){return this.$d.getTime()},R.startOf=function(U,H){var V=this,N=!!k.u(H)||H,z=k.p(U),G=function(m1,f1){var d1=k.w(V.$u?Date.UTC(V.$y,f1,m1):new Date(V.$y,f1,m1),V);return N?d1:d1.endOf(c)},t1=function(m1,f1){return k.w(V.toDate()[m1].apply(V.toDate("s"),(N?[0,0,0,0]:[23,59,59,999]).slice(f1)),V)},e1=this.$W,u1=this.$M,s1=this.$D,q="set"+(this.$u?"UTC":"");switch(z){case g:return N?G(1,0):G(31,11);case h:return N?G(1,u1):G(0,u1+1);case d:var Z=this.$locale().weekStart||0,p1=(e1<Z?e1+7:e1)-Z;return G(N?s1-p1:s1+(6-p1),u1);case c:case y:return t1(q+"Hours",0);case u:return t1(q+"Minutes",1);case s:return t1(q+"Seconds",2);case r:return t1(q+"Milliseconds",3);default:return this.clone()}},R.endOf=function(U){return this.startOf(U,!1)},R.$set=function(U,H){var V,N=k.p(U),z="set"+(this.$u?"UTC":""),G=(V={},V[c]=z+"Date",V[y]=z+"Date",V[h]=z+"Month",V[g]=z+"FullYear",V[u]=z+"Hours",V[s]=z+"Minutes",V[r]=z+"Seconds",V[a]=z+"Milliseconds",V)[N],t1=N===c?this.$D+(H-this.$W):H;if(N===h||N===g){var e1=this.clone().set(y,1);e1.$d[G](t1),e1.init(),this.$d=e1.set(y,Math.min(this.$D,e1.daysInMonth())).$d}else G&&this.$d[G](t1);return this.init(),this},R.set=function(U,H){return this.clone().$set(U,H)},R.get=function(U){return this[k.p(U)]()},R.add=function(U,H){var V,N=this;U=Number(U);var z=k.p(H),G=function(u1){var s1=E(N);return k.w(s1.date(s1.date()+Math.round(u1*U)),N)};if(z===h)return this.set(h,this.$M+U);if(z===g)return this.set(g,this.$y+U);if(z===c)return G(1);if(z===d)return G(7);var t1=(V={},V[s]=n,V[u]=i,V[r]=t,V)[z]||1,e1=this.$d.getTime()+U*t1;return k.w(e1,this)},R.subtract=function(U,H){return this.add(-1*U,H)},R.format=function(U){var H=this,V=this.$locale();if(!this.isValid())return V.invalidDate||m;var N=U||"YYYY-MM-DDTHH:mm:ssZ",z=k.z(this),G=this.$H,t1=this.$m,e1=this.$M,u1=V.weekdays,s1=V.months,q=function(f1,d1,N1,M1){return f1&&(f1[d1]||f1(H,N))||N1[d1].slice(0,M1)},Z=function(f1){return k.s(G%12||12,f1,"0")},p1=V.meridiem||function(f1,d1,N1){var M1=f1<12?"AM":"PM";return N1?M1.toLowerCase():M1},m1={YY:String(this.$y).slice(-2),YYYY:this.$y,M:e1+1,MM:k.s(e1+1,2,"0"),MMM:q(V.monthsShort,e1,s1,3),MMMM:q(s1,e1),D:this.$D,DD:k.s(this.$D,2,"0"),d:String(this.$W),dd:q(V.weekdaysMin,this.$W,u1,2),ddd:q(V.weekdaysShort,this.$W,u1,3),dddd:u1[this.$W],H:String(G),HH:k.s(G,2,"0"),h:Z(1),hh:Z(2),a:p1(G,t1,!0),A:p1(G,t1,!1),m:String(t1),mm:k.s(t1,2,"0"),s:String(this.$s),ss:k.s(this.$s,2,"0"),SSS:k.s(this.$ms,3,"0"),Z:z};return N.replace(b,function(f1,d1){return d1||m1[f1]||z.replace(":","")})},R.utcOffset=function(){return 15*-Math.round(this.$d.getTimezoneOffset()/15)},R.diff=function(U,H,V){var N,z=k.p(H),G=E(U),t1=(G.utcOffset()-this.utcOffset())*n,e1=this-G,u1=k.m(this,G);return u1=(N={},N[g]=u1/12,N[h]=u1,N[p]=u1/3,N[d]=(e1-t1)/6048e5,N[c]=(e1-t1)/864e5,N[u]=e1/i,N[s]=e1/n,N[r]=e1/t,N)[z]||e1,V?u1:k.a(u1)},R.daysInMonth=function(){return this.endOf(h).$D},R.$locale=function(){return S[this.$L]},R.locale=function(U,H){if(!U)return this.$L;var V=this.clone(),N=C(U,H,!0);return N&&(V.$L=N),V},R.clone=function(){return k.w(this.$d,this)},R.toDate=function(){return new Date(this.valueOf())},R.toJSON=function(){return this.isValid()?this.toISOString():null},R.toISOString=function(){return this.$d.toISOString()},R.toString=function(){return this.$d.toUTCString()},F}(),X=$.prototype;return E.prototype=X,[["$ms",a],["$s",r],["$m",s],["$H",u],["$W",c],["$M",h],["$y",g],["$D",y]].forEach(function(F){X[F[1]]=function(R){return this.$g(R,F[0],F[1])}}),E.extend=function(F,R){return F.$i||(F(R,$,E),F.$i=!0),E},E.locale=C,E.isDayjs=D,E.unix=function(F){return E(1e3*F)},E.en=S[A],E.Ls=S,E.p={},E})})(Yl);var TI=Yl.exports;const X4=et(TI),EI=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;u4(r=>({"4725167e":l(n)+"px"}));const{w:t,h:n}=E1(e.chartConfig.attr);K1();const i=l4({dataset:e.chartConfig.option.dataset}),a=r=>{r instanceof Array?N8(e.chartConfig,e2,{[l5.DATE_START]:r[0]||X4().valueOf(),[l5.DATE_END]:r[1]||X4().valueOf(),[l5.DATE_RANGE]:`${r[0]||X4().valueOf()}-${r[1]||X4().valueOf()}`},U0.CHANGE):N8(e.chartConfig,e2,{[l5.DATE]:r||X4().valueOf()},U0.CHANGE)};return B1(()=>e.chartConfig.option.dataset,r=>{i.dataset=r,a(r)},{immediate:!0}),B1(()=>e.chartConfig.option.differValue,r=>{e.chartConfig.option.differValue!==0&&(typeof i.dataset=="object"?(i.dataset[0]=X4().add(r,"day").valueOf(),i.dataset[1]=X4().add(r,"day").valueOf()):i.dataset=X4().add(r,"day").valueOf(),a(r))},{immediate:!0}),(r,s)=>{const u=B("n-date-picker");return P(),v1(u,{value:l(i).dataset,"onUpdate:value":[s[0]||(s[0]=c=>l(i).dataset=c),a],panel:!!o.chartConfig.option.isPanel,type:o.chartConfig.option.componentInteractEventKey,style:g2(`width:${l(t)}px;`)},null,8,["value","panel","type","style"])}}});const DI=c2(EI,[["__scopeId","data-v-e8ed1b77"]]),II=Object.freeze(Object.defineProperty({__proto__:null,default:DI},Symbol.toStringTag,{value:"Module"}));var RI=(o=>(o.DATA="data",o))(RI||{}),$l=(o=>(o.DATA="data",o))($l||{});const ok=[{interactType:U0.CHANGE,interactName:"选择完成",componentEmitEvents:{data:[{value:"data",label:"选择项"}]}}],OI=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;u4(r=>({"15a61728":l(n)+"px"}));const{w:t,h:n}=E1(e.chartConfig.attr),i=l4({value:{selectValue:e.chartConfig.option.selectValue,dataset:e.chartConfig.option.dataset}}),a=r=>{N8(e.chartConfig,e2,{[$l.DATA]:r},U0.CHANGE)};return B1(()=>e.chartConfig.option,r=>{i.value=r,a(r.selectValue)},{immediate:!0,deep:!0}),(r,s)=>{const u=B("n-select");return P(),v1(u,{value:l(i).value.selectValue,"onUpdate:value":[s[0]||(s[0]=c=>l(i).value.selectValue=c),a],options:l(i).value.dataset,style:g2(`width:${l(t)}px;`)},null,8,["value","options","style"])}}});const PI=c2(OI,[["__scopeId","data-v-8b33eaf1"]]),LI=Object.freeze(Object.defineProperty({__proto__:null,default:PI},Symbol.toStringTag,{value:"Module"}));var zI=(o=>(o.DATA="data",o))(zI||{}),Jl=(o=>(o.DATA="data",o))(Jl||{});const ak=[{interactType:U0.CHANGE,interactName:"选择完成",componentEmitEvents:{data:[{value:"data",label:"选择项"}]}}],kI=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;E1(e.chartConfig.attr);const t=l4({value:w1(e.chartConfig.option)}),n=i=>{if(i===void 0)return;const a=t.value.dataset.find(r=>r.label===i);N8(e.chartConfig,e2,{[Jl.DATA]:a.value},U0.CHANGE)};return B1(()=>e.chartConfig.option,i=>{t.value=i,n(i.tabValue)},{immediate:!0,deep:!0}),(i,a)=>{const r=B("n-tab"),s=B("n-tabs");return P(),v1(s,{type:l(t).value.tabType,"onUpdate:value":n},{default:_(()=>[(P(!0),n1(x1,null,J1(l(t).value.dataset,(u,c)=>(P(),v1(r,{name:u.label,key:c},{default:_(()=>[I1(N2(u.label),1)]),_:2},1032,["name"]))),128))]),_:1},8,["type"])}}}),NI=Object.freeze(Object.defineProperty({__proto__:null,default:kI},Symbol.toStringTag,{value:"Module"})),UI=["src","width","height"],FI=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{borderRadius:i}=E1(e.chartConfig.option),a=l4({dataset:""}),r=s=>({borderRadius:`${s}px`,overflow:"hidden"});return B1(()=>e.chartConfig.option.dataset,s=>{a.dataset=s},{immediate:!0}),d2(e.chartConfig,e2,s=>{a.dataset=s}),(s,u)=>(P(),n1("div",{style:g2(r(l(i)))},[j("iframe",{src:l(a).dataset,width:l(t),height:l(n),style:{"border-width":"0"}},null,8,UI)],4))}}),BI=Object.freeze(Object.defineProperty({__proto__:null,default:FI},Symbol.toStringTag,{value:"Module"})),GI=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{dataset:i,fit:a,borderRadius:r}=E1(e.chartConfig.option),s=l4({dataset:""}),u=c=>({borderRadius:`${c}px`,overflow:"hidden"});return B1(()=>e.chartConfig.option.dataset,c=>{s.dataset=c},{immediate:!0}),d2(e.chartConfig,e2,c=>{s.dataset=c}),(c,d)=>{const h=B("n-image");return P(),n1("div",{style:g2(u(l(r)))},[f(h,{"object-fit":l(a),"preview-disabled":"",src:l(s).dataset,"fallback-src":l(cr)(),width:l(t),height:l(n),lazy:""},null,8,["object-fit","src","fallback-src","width","height"])],4)}}}),VI=Object.freeze(Object.defineProperty({__proto__:null,default:GI},Symbol.toStringTag,{value:"Module"})),$e={key:"ImageCarousel",chartKey:"VImageCarousel",conKey:"VCImageCarousel",title:"轮播图",category:e4.MORE,categoryName:t4.MORE,package:R1.INFORMATIONS,chartFrame:F1.NAIVE_UI,image:"photo_carousel.png"},En={dataset:["https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel1.jpeg","https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel2.jpeg","https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel3.jpeg"],autoplay:!0,interval:5e3,slidesPerview:1,direction:"horizontal",draggable:!0,centeredSlides:!1,effect:"slide",showDots:!0,dotType:"dot",dotPlacement:"bottom",showArrow:!1,fit:"contain"};let jI=class extends Q1{constructor(){super(...arguments);Q(this,"key",$e.key);Q(this,"chartConfig",w1($e));Q(this,"option",w1(En))}};const Za=Object.freeze(Object.defineProperty({__proto__:null,default:jI,option:En},Symbol.toStringTag,{value:"Module"})),WI=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=l4({dataset:En.dataset}),{w:n,h:i}=E1(e.chartConfig.attr),{autoplay:a,interval:r,slidesPerview:s,direction:u,draggable:c,centeredSlides:d,effect:h,dotType:p,dotPlacement:g,showArrow:y,showDots:m,fit:v}=E1(e.chartConfig.option);return B1(()=>e.chartConfig.option.dataset,b=>{t.dataset=b},{immediate:!0,deep:!1}),d2(e.chartConfig,e2,b=>{t.dataset=b}),(b,x)=>{const w=B("n-image"),M=B("n-carousel");return P(),n1("div",null,[f(M,{autoplay:l(a),interval:l(r),"centered-slides":l(d),direction:l(u),"dot-placement":l(g),"dot-type":l(p),draggable:l(c),effect:l(h),"slides-per-view":l(s),"show-arrow":l(y),"show-dots":l(m)},{default:_(()=>[(P(!0),n1(x1,null,J1(l(t).dataset,(A,S)=>(P(),v1(w,{"preview-disabled":"",key:S,"object-fit":l(v),src:A,"fallback-src":l(cr)(),width:l(n),height:l(i)},null,8,["object-fit","src","fallback-src","width","height"]))),128))]),_:1},8,["autoplay","interval","centered-slides","direction","dot-placement","dot-type","draggable","effect","slides-per-view","show-arrow","show-dots"])])}}}),HI=Object.freeze(Object.defineProperty({__proto__:null,default:WI},Symbol.toStringTag,{value:"Module"})),Je={key:"Video",chartKey:"VVideo",conKey:"VCVideo",title:"视频",category:e4.MORE,categoryName:t4.MORE,package:R1.INFORMATIONS,chartFrame:F1.COMMON,image:"video.png"},YI="/static/mp4/earth-1d58aa0e.mp4",Dn={dataset:YI,loop:!0,muted:!0,fit:"contain",borderRadius:10};let $I=class extends Q1{constructor(){super(...arguments);Q(this,"key",Je.key);Q(this,"chartConfig",w1(Je));Q(this,"option",w1(Dn))}};const Xa=Object.freeze(Object.defineProperty({__proto__:null,default:$I,option:Dn},Symbol.toStringTag,{value:"Module"})),JI=["loop","muted","width","height","src"],ZI=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;u4(r=>({"3a0578ea":l(i).fit}));const{w:t,h:n}=E1(e.chartConfig.attr);let i=l4(U1({},Dn));const a=K1(null);return d2(e.chartConfig,e2,r=>{i=r}),B1(()=>e.chartConfig.option,r=>{if(i=r,!a.value)return;const s=a.value;s.loop=i.loop,s.muted=i.muted,s.play()},{immediate:!0,deep:!0}),(r,s)=>(P(),n1("video",{ref_key:"vVideoRef",ref:a,class:"go-video",preload:"auto",crossOrigin:"anonymous",playsinline:"",autoplay:"",loop:l(i).loop,muted:l(i).muted,width:l(t),height:l(n),src:l(i).dataset},null,8,JI))}});const XI=c2(ZI,[["__scopeId","data-v-f66ad6f5"]]),QI=Object.freeze(Object.defineProperty({__proto__:null,default:XI},Symbol.toStringTag,{value:"Module"}));or({type:"series.wordCloud",visualStyleAccessPath:"textStyle",visualStyleMapper:function(o){return{fill:o.get("color")}},visualDrawType:"fill",optionUpdated:function(){var o=this.option;o.gridSize=Math.max(Math.floor(o.gridSize),4)},getInitialData:function(o,e){var t=ar(o.data,{coordDimensions:["value"]}),n=new rr(t,this);return n.initData(o.data),n},defaultOption:{maskImage:null,shape:"circle",keepAspect:!1,left:"center",top:"center",width:"70%",height:"80%",sizeRange:[12,60],rotationRange:[-90,90],rotationStep:45,gridSize:8,drawOutOfBound:!1,shrinkToFit:!1,textStyle:{fontWeight:"normal"}}});sr({type:"wordCloud",render:function(o,e,t){var n=this.group;n.removeAll();var i=o.getData(),a=o.get("gridSize");o.layoutInstance.ondraw=function(r,s,u,c){var d=i.getItemModel(u),h=d.getModel("textStyle"),p=new _7({style:C8(h),scaleX:1/c.info.mu,scaleY:1/c.info.mu,x:(c.gx+c.info.gw/2)*a,y:(c.gy+c.info.gh/2)*a,rotation:c.rot});p.setStyle({x:c.info.fillTextOffsetX,y:c.info.fillTextOffsetY+s*.5,text:r,verticalAlign:"middle",fill:i.getItemVisual(u,"style").fill,fontSize:s}),n.add(p),i.setItemGraphicEl(u,p),p.ensureState("emphasis").style=C8(d.getModel(["emphasis","textStyle"]),{state:"emphasis"}),p.ensureState("blur").style=C8(d.getModel(["blur","textStyle"]),{state:"blur"}),lr(p,d.get(["emphasis","focus"]),d.get(["emphasis","blurScope"])),p.stateTransition={duration:o.get("animation")?o.get(["stateAnimation","duration"]):0,easing:o.get(["stateAnimation","easing"])},p.__highDownDispatcher=!0},this._model=o},remove:function(){this.group.removeAll(),this._model.layoutInstance.dispose()},dispose:function(){this._model.layoutInstance.dispose()}});/*!
 * wordcloud2.js
 * http://timdream.org/wordcloud2.js/
 *
 * Copyright 2011 - 2019 Tim Guan-tin Chien and contributors.
 * Released under the MIT license
 */window.setImmediate||(window.setImmediate=function(){return window.msSetImmediate||window.webkitSetImmediate||window.mozSetImmediate||window.oSetImmediate||function(){if(!window.postMessage||!window.addEventListener)return null;var t=[void 0],n="zero-timeout-message",i=function(r){var s=t.length;return t.push(r),window.postMessage(n+s.toString(36),"*"),s};return window.addEventListener("message",function(r){if(!(typeof r.data!="string"||r.data.substr(0,n.length)!==n)){r.stopImmediatePropagation();var s=parseInt(r.data.substr(n.length),36);t[s]&&(t[s](),t[s]=void 0)}},!0),window.clearImmediate=function(r){t[r]&&(t[r]=void 0)},i}()||function(t){window.setTimeout(t,0)}}());window.clearImmediate||(window.clearImmediate=function(){return window.msClearImmediate||window.webkitClearImmediate||window.mozClearImmediate||window.oClearImmediate||function(t){window.clearTimeout(t)}}());var In=function(){var e=document.createElement("canvas");if(!e||!e.getContext)return!1;var t=e.getContext("2d");return!(!t||!t.getImageData||!t.fillText||!Array.prototype.some||!Array.prototype.push)}(),Ze=function(){if(In){for(var e=document.createElement("canvas").getContext("2d"),t=20,n,i;t;){if(e.font=t.toString(10)+"px sans-serif",e.measureText("Ｗ").width===n&&e.measureText("m").width===i)return t+1;n=e.measureText("Ｗ").width,i=e.measureText("m").width,t--}return 0}}(),qI=function(o){if(Array.isArray(o)){var e=o.slice();return e.splice(0,2),e}else return[]},KI=function(e){for(var t,n,i=e.length;i;)t=Math.floor(Math.random()*i),n=e[--i],e[i]=e[t],e[t]=n;return e},v9={},d6=function(e,t){if(!In)return;var n=Math.floor(Math.random()*Date.now());Array.isArray(e)||(e=[e]),e.forEach(function(s1,q){if(typeof s1=="string"){if(e[q]=document.getElementById(s1),!e[q])throw new Error("The element id specified is not found.")}else if(!s1.tagName&&!s1.appendChild)throw new Error("You must pass valid HTML elements, or ID of the element.")});var i={list:[],fontFamily:'"Trebuchet MS", "Heiti TC", "微軟正黑體", "Arial Unicode MS", "Droid Fallback Sans", sans-serif',fontWeight:"normal",color:"random-dark",minSize:0,weightFactor:1,clearCanvas:!0,backgroundColor:"#fff",gridSize:8,drawOutOfBound:!1,shrinkToFit:!1,origin:null,drawMask:!1,maskColor:"rgba(255,0,0,0.3)",maskGapWidth:.3,layoutAnimation:!0,wait:0,abortThreshold:0,abort:function(){},minRotation:-Math.PI/2,maxRotation:Math.PI/2,rotationStep:.1,shuffle:!0,rotateRatio:.1,shape:"circle",ellipticity:.65,classes:null,hover:null,click:null};if(t)for(var a in t)a in i&&(i[a]=t[a]);if(typeof i.weightFactor!="function"){var r=i.weightFactor;i.weightFactor=function(q){return q*r}}if(typeof i.shape!="function")switch(i.shape){case"circle":default:i.shape="circle";break;case"cardioid":i.shape=function(q){return 1-Math.sin(q)};break;case"diamond":i.shape=function(q){var Z=q%(2*Math.PI/4);return 1/(Math.cos(Z)+Math.sin(Z))};break;case"square":i.shape=function(q){return Math.min(1/Math.abs(Math.cos(q)),1/Math.abs(Math.sin(q)))};break;case"triangle-forward":i.shape=function(q){var Z=q%(2*Math.PI/3);return 1/(Math.cos(Z)+Math.sqrt(3)*Math.sin(Z))};break;case"triangle":case"triangle-upright":i.shape=function(q){var Z=(q+Math.PI*3/2)%(2*Math.PI/3);return 1/(Math.cos(Z)+Math.sqrt(3)*Math.sin(Z))};break;case"pentagon":i.shape=function(q){var Z=(q+.955)%(2*Math.PI/5);return 1/(Math.cos(Z)+.726543*Math.sin(Z))};break;case"star":i.shape=function(q){var Z=(q+.955)%(2*Math.PI/10);return(q+.955)%(2*Math.PI/5)-2*Math.PI/10>=0?1/(Math.cos(2*Math.PI/10-Z)+3.07768*Math.sin(2*Math.PI/10-Z)):1/(Math.cos(Z)+3.07768*Math.sin(Z))};break}i.gridSize=Math.max(Math.floor(i.gridSize),4);var s=i.gridSize,u=s-i.maskGapWidth,c=Math.abs(i.maxRotation-i.minRotation),d=Math.min(i.maxRotation,i.minRotation),h=i.rotationStep,p,g,y,m,v,b,x;function w(s1,q){return"hsl("+(Math.random()*360).toFixed()+","+(Math.random()*30+70).toFixed()+"%,"+(Math.random()*(q-s1)+s1).toFixed()+"%)"}switch(i.color){case"random-dark":x=function(){return w(10,50)};break;case"random-light":x=function(){return w(50,90)};break;default:typeof i.color=="function"&&(x=i.color);break}var M;typeof i.fontWeight=="function"&&(M=i.fontWeight);var A=null;typeof i.classes=="function"&&(A=i.classes);var S=!1,D=[],C,E=function(q){var Z=q.currentTarget,p1=Z.getBoundingClientRect(),m1,f1;q.touches?(m1=q.touches[0].clientX,f1=q.touches[0].clientY):(m1=q.clientX,f1=q.clientY);var d1=m1-p1.left,N1=f1-p1.top,M1=Math.floor(d1*(Z.width/p1.width||1)/s),S1=Math.floor(N1*(Z.height/p1.height||1)/s);return D[M1]?D[M1][S1]:null},k=function(q){var Z=E(q);if(C!==Z){if(C=Z,!Z){i.hover(void 0,void 0,q);return}i.hover(Z.item,Z.dimension,q)}},$=function(q){var Z=E(q);Z&&(i.click(Z.item,Z.dimension,q),q.preventDefault())},X=[],F=function(q){if(X[q])return X[q];var Z=q*8,p1=Z,m1=[];for(q===0&&m1.push([m[0],m[1],0]);p1--;){var f1=1;i.shape!=="circle"&&(f1=i.shape(p1/Z*2*Math.PI)),m1.push([m[0]+q*f1*Math.cos(-p1/Z*2*Math.PI),m[1]+q*f1*Math.sin(-p1/Z*2*Math.PI)*i.ellipticity,p1/Z*2*Math.PI])}return X[q]=m1,m1},R=function(){return i.abortThreshold>0&&new Date().getTime()-b>i.abortThreshold},U=function(){return i.rotateRatio===0||Math.random()>i.rotateRatio?0:c===0?d:d+Math.round(Math.random()*c/h)*h},H=function(q,Z,p1,m1){var f1=i.weightFactor(Z);if(f1<=i.minSize)return!1;var d1=1;f1<Ze&&(d1=function(){for(var j1=2;j1*f1<Ze;)j1+=2;return j1}());var N1;M?N1=M(q,Z,f1,m1):N1=i.fontWeight;var M1=document.createElement("canvas"),S1=M1.getContext("2d",{willReadFrequently:!0});S1.font=N1+" "+(f1*d1).toString(10)+"px "+i.fontFamily;var X1=S1.measureText(q).width/d1,$1=Math.max(f1*d1,S1.measureText("m").width,S1.measureText("Ｗ").width)/d1,Y1=X1+$1*2,t2=$1*3,s2=Math.ceil(Y1/s),V1=Math.ceil(t2/s);Y1=s2*s,t2=V1*s;var n2=-X1/2,W1=-$1*.4,O=Math.ceil((Y1*Math.abs(Math.sin(p1))+t2*Math.abs(Math.cos(p1)))/s),I=Math.ceil((Y1*Math.abs(Math.cos(p1))+t2*Math.abs(Math.sin(p1)))/s),l1=I*s,b1=O*s;M1.setAttribute("width",l1),M1.setAttribute("height",b1),S1.scale(1/d1,1/d1),S1.translate(l1*d1/2,b1*d1/2),S1.rotate(-p1),S1.font=N1+" "+(f1*d1).toString(10)+"px "+i.fontFamily,S1.fillStyle="#000",S1.textBaseline="middle",S1.fillText(q,n2*d1,(W1+f1*.5)*d1);var A1=S1.getImageData(0,0,l1,b1).data;if(R())return!1;for(var O1=[],H1=I,W,o1,P1,L1=[O/2,I/2,O/2,I/2];H1--;)for(W=O;W--;){P1=s;e:for(;P1--;)for(o1=s;o1--;)if(A1[((W*s+P1)*l1+(H1*s+o1))*4+3]){O1.push([H1,W]),H1<L1[3]&&(L1[3]=H1),H1>L1[1]&&(L1[1]=H1),W<L1[0]&&(L1[0]=W),W>L1[2]&&(L1[2]=W);break e}}return{mu:d1,occupied:O1,bounds:L1,gw:I,gh:O,fillTextOffsetX:n2,fillTextOffsetY:W1,fillTextWidth:X1,fillTextHeight:$1,fontSize:f1}},V=function(q,Z,p1,m1,f1){for(var d1=f1.length;d1--;){var N1=q+f1[d1][0],M1=Z+f1[d1][1];if(N1>=g||M1>=y||N1<0||M1<0){if(!i.drawOutOfBound)return!1;continue}if(!p[N1][M1])return!1}return!0},N=function(q,Z,p1,m1,f1,d1,N1,M1,S1,X1){var $1=p1.fontSize,Y1;x?Y1=x(m1,f1,$1,d1,N1,X1):Y1=i.color;var t2;M?t2=M(m1,f1,$1,X1):t2=i.fontWeight;var s2;A?s2=A(m1,f1,$1,X1):s2=i.classes,e.forEach(function(V1){if(V1.getContext){var n2=V1.getContext("2d"),W1=p1.mu;n2.save(),n2.scale(1/W1,1/W1),n2.font=t2+" "+($1*W1).toString(10)+"px "+i.fontFamily,n2.fillStyle=Y1,n2.translate((q+p1.gw/2)*s*W1,(Z+p1.gh/2)*s*W1),M1!==0&&n2.rotate(-M1),n2.textBaseline="middle",n2.fillText(m1,p1.fillTextOffsetX*W1,(p1.fillTextOffsetY+$1*.5)*W1),n2.restore()}else{var O=document.createElement("span"),I="";I="rotate("+-M1/Math.PI*180+"deg) ",p1.mu!==1&&(I+="translateX(-"+p1.fillTextWidth/4+"px) scale("+1/p1.mu+")");var l1={position:"absolute",display:"block",font:t2+" "+$1*p1.mu+"px "+i.fontFamily,left:(q+p1.gw/2)*s+p1.fillTextOffsetX+"px",top:(Z+p1.gh/2)*s+p1.fillTextOffsetY+"px",width:p1.fillTextWidth+"px",height:p1.fillTextHeight+"px",lineHeight:$1+"px",whiteSpace:"nowrap",transform:I,webkitTransform:I,msTransform:I,transformOrigin:"50% 40%",webkitTransformOrigin:"50% 40%",msTransformOrigin:"50% 40%"};Y1&&(l1.color=Y1),O.textContent=m1;for(var b1 in l1)O.style[b1]=l1[b1];if(S1)for(var A1 in S1)O.setAttribute(A1,S1[A1]);s2&&(O.className+=s2),V1.appendChild(O)}})},z=function(q,Z,p1,m1,f1){if(!(q>=g||Z>=y||q<0||Z<0)){if(p[q][Z]=!1,p1){var d1=e[0].getContext("2d");d1.fillRect(q*s,Z*s,u,u)}S&&(D[q][Z]={item:f1,dimension:m1})}},G=function(q,Z,p1,m1,f1,d1){var N1=f1.occupied,M1=i.drawMask,S1;M1&&(S1=e[0].getContext("2d"),S1.save(),S1.fillStyle=i.maskColor);var X1;if(S){var $1=f1.bounds;X1={x:(q+$1[3])*s,y:(Z+$1[0])*s,w:($1[1]-$1[3]+1)*s,h:($1[2]-$1[0]+1)*s}}for(var Y1=N1.length;Y1--;){var t2=q+N1[Y1][0],s2=Z+N1[Y1][1];t2>=g||s2>=y||t2<0||s2<0||z(t2,s2,M1,X1,d1)}M1&&S1.restore()},t1=function s1(q,Z){if(Z>20)return null;var p1,m1,f1;Array.isArray(q)?(p1=q[0],m1=q[1]):(p1=q.word,m1=q.weight,f1=q.attributes);var d1=U(),N1=qI(q),M1=H(p1,m1,d1,N1);if(!M1||R())return!1;if(!i.drawOutOfBound&&!i.shrinkToFit){var S1=M1.bounds;if(S1[1]-S1[3]+1>g||S1[2]-S1[0]+1>y)return!1}for(var X1=v+1,$1=function(V1){var n2=Math.floor(V1[0]-M1.gw/2),W1=Math.floor(V1[1]-M1.gh/2),O=M1.gw,I=M1.gh;return V(n2,W1,O,I,M1.occupied)?(N(n2,W1,M1,p1,m1,v-X1,V1[2],d1,f1,N1),G(n2,W1,O,I,M1,q),{gx:n2,gy:W1,rot:d1,info:M1}):!1};X1--;){var Y1=F(v-X1);i.shuffle&&(Y1=[].concat(Y1),KI(Y1));for(var t2=0;t2<Y1.length;t2++){var s2=$1(Y1[t2]);if(s2)return s2}}return i.shrinkToFit?(Array.isArray(q)?q[1]=q[1]*3/4:q.weight=q.weight*3/4,s1(q,Z+1)):null},e1=function(q,Z,p1){if(Z)return!e.some(function(m1){var f1=new CustomEvent(q,{detail:p1||{}});return!m1.dispatchEvent(f1)},this);e.forEach(function(m1){var f1=new CustomEvent(q,{detail:p1||{}});m1.dispatchEvent(f1)},this)},u1=function(){var q=e[0];if(q.getContext)g=Math.ceil(q.width/s),y=Math.ceil(q.height/s);else{var Z=q.getBoundingClientRect();g=Math.ceil(Z.width/s),y=Math.ceil(Z.height/s)}if(e1("wordcloudstart",!0)){m=i.origin?[i.origin[0]/s,i.origin[1]/s]:[g/2,y/2],v=Math.floor(Math.sqrt(g*g+y*y)),p=[];var p1,m1,f1;if(!q.getContext||i.clearCanvas)for(e.forEach(function(W1){if(W1.getContext){var O=W1.getContext("2d");O.fillStyle=i.backgroundColor,O.clearRect(0,0,g*(s+1),y*(s+1)),O.fillRect(0,0,g*(s+1),y*(s+1))}else W1.textContent="",W1.style.backgroundColor=i.backgroundColor,W1.style.position="relative"}),p1=g;p1--;)for(p[p1]=[],m1=y;m1--;)p[p1][m1]=!0;else{var d1=document.createElement("canvas").getContext("2d");d1.fillStyle=i.backgroundColor,d1.fillRect(0,0,1,1);var N1=d1.getImageData(0,0,1,1).data,M1=q.getContext("2d").getImageData(0,0,g*s,y*s).data;p1=g;for(var S1,X1;p1--;)for(p[p1]=[],m1=y;m1--;){X1=s;e:for(;X1--;)for(S1=s;S1--;)for(f1=4;f1--;)if(M1[((m1*s+X1)*g*s+(p1*s+S1))*4+f1]!==N1[f1]){p[p1][m1]=!1;break e}p[p1][m1]!==!1&&(p[p1][m1]=!0)}M1=d1=N1=void 0}if(i.hover||i.click){for(S=!0,p1=g+1;p1--;)D[p1]=[];i.hover&&q.addEventListener("mousemove",k),i.click&&(q.addEventListener("click",$),q.addEventListener("touchstart",$),q.addEventListener("touchend",function(W1){W1.preventDefault()}),q.style.webkitTapHighlightColor="rgba(0, 0, 0, 0)"),q.addEventListener("wordcloudstart",function W1(){q.removeEventListener("wordcloudstart",W1),q.removeEventListener("mousemove",k),q.removeEventListener("click",$),C=void 0})}f1=0;var $1,Y1,t2=!0;i.layoutAnimation?i.wait!==0?($1=window.setTimeout,Y1=window.clearTimeout):($1=window.setImmediate,Y1=window.clearImmediate):($1=function(W1){W1()},Y1=function(){t2=!1});var s2=function(O,I){e.forEach(function(l1){l1.addEventListener(O,I)},this)},V1=function(O,I){e.forEach(function(l1){l1.removeEventListener(O,I)},this)},n2=function W1(){V1("wordcloudstart",W1),Y1(v9[n])};s2("wordcloudstart",n2),v9[n]=(i.layoutAnimation?$1:setTimeout)(function W1(){if(t2){if(f1>=i.list.length){Y1(v9[n]),e1("wordcloudstop",!1),V1("wordcloudstart",n2),delete v9[n];return}b=new Date().getTime();var O=t1(i.list[f1],0),I=!e1("wordclouddrawn",!0,{item:i.list[f1],drawn:O});if(R()||I){Y1(v9[n]),i.abort(),e1("wordcloudabort",!1),e1("wordcloudstop",!1),V1("wordcloudstart",n2);return}f1++,v9[n]=$1(W1,i.wait)}},i.wait)}};u1()};d6.isSupported=In;d6.minFontSize=Ze;if(!d6.isSupported)throw new Error("Sorry your browser not support wordCloud");function eR(o){for(var e=o.getContext("2d"),t=e.getImageData(0,0,o.width,o.height),n=e.createImageData(t),i=0,a=0,r=0;r<t.data.length;r+=4){var s=t.data[r+3];if(s>128){var u=t.data[r]+t.data[r+1]+t.data[r+2];i+=u,++a}}for(var c=i/a,r=0;r<t.data.length;r+=4){var u=t.data[r]+t.data[r+1]+t.data[r+2],s=t.data[r+3];s<128||u>c?(n.data[r]=0,n.data[r+1]=0,n.data[r+2]=0,n.data[r+3]=0):(n.data[r]=255,n.data[r+1]=255,n.data[r+2]=255,n.data[r+3]=255)}e.putImageData(n,0,0)}Ru(function(o,e){o.eachSeriesByType("wordCloud",function(t){var n=zu(t.getBoxLayoutParams(),{width:e.getWidth(),height:e.getHeight()}),i=t.get("keepAspect"),a=t.get("maskImage"),r=a?a.width/a.height:1;i&&tR(n,r);var s=t.getData(),u=document.createElement("canvas");u.width=n.width,u.height=n.height;var c=u.getContext("2d");if(a)try{c.drawImage(a,0,0,u.width,u.height),eR(u)}catch(v){console.error("Invalid mask image"),console.error(v.toString())}var d=t.get("sizeRange"),h=t.get("rotationRange"),p=s.getDataExtent("value"),g=Math.PI/180,y=t.get("gridSize");d6(u,{list:s.mapArray("value",function(v,b){var x=s.getItemModel(b);return[s.getName(b),x.get("textStyle.fontSize",!0)||ku(v,p,d),b]}).sort(function(v,b){return b[1]-v[1]}),fontFamily:t.get("textStyle.fontFamily")||t.get("emphasis.textStyle.fontFamily")||o.get("textStyle.fontFamily"),fontWeight:t.get("textStyle.fontWeight")||t.get("emphasis.textStyle.fontWeight")||o.get("textStyle.fontWeight"),gridSize:y,ellipticity:n.height/n.width,minRotation:h[0]*g,maxRotation:h[1]*g,clearCanvas:!a,rotateRatio:1,rotationStep:t.get("rotationStep")*g,drawOutOfBound:t.get("drawOutOfBound"),shrinkToFit:t.get("shrinkToFit"),layoutAnimation:t.get("layoutAnimation"),shuffle:!1,shape:t.get("shape")});function m(v){var b=v.detail.item;v.detail.drawn&&t.layoutInstance.ondraw&&(v.detail.drawn.gx+=n.x/y,v.detail.drawn.gy+=n.y/y,t.layoutInstance.ondraw(b[0],b[1],b[2],v.detail.drawn))}u.addEventListener("wordclouddrawn",m),t.layoutInstance&&t.layoutInstance.dispose(),t.layoutInstance={ondraw:null,dispose:function(){u.removeEventListener("wordclouddrawn",m),u.addEventListener("wordclouddrawn",function(v){v.preventDefault()})}}})});Ou(function(o){var e=(o||{}).series;!Pu(e)&&(e=e?[e]:[]);var t=["shadowColor","shadowBlur","shadowOffsetX","shadowOffsetY"];Yn(e,function(i){if(i&&i.type==="wordCloud"){var a=i.textStyle||{};n(a.normal),n(a.emphasis)}});function n(i){i&&Yn(t,function(a){i.hasOwnProperty(a)&&(i["text"+Lu(a)]=i[a])})}});function tR(o,e){var t=o.width,n=o.height;t>n*e?(o.x+=(t-n*e)/2,o.width=n*e):(o.y+=(n-t/e)/2,o.height=t/e)}const nR=c1({__name:"index",props:{themeSetting:{type:Object,required:!0},themeColor:{type:Object,required:!0},chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=Z2(e.chartConfig.option,e.themeSetting);R2([F2,e3,a3]);const n=K1(),i=a2(()=>t3(e.chartConfig.option,e.themeSetting,Ot)),a=s=>{try{s&&(e.chartConfig.option.series[0].data=s),r.value&&b2()&&h0(r.value,e.chartConfig.option)}catch(u){console.log(u)}};B1(()=>e.chartConfig.option.dataset,s=>{a(s)},{deep:!1});const{vChartRef:r}=d2(e.chartConfig,e2,s=>{a(s)});return(s,u)=>(P(),v1(l(J2),{ref_key:"vChartRef",ref:r,"init-options":l(t),theme:o.themeColor,option:i.value,"manual-update":l(b2)(),"update-options":{replaceMerge:n.value},autoresize:""},null,8,["init-options","theme","option","manual-update","update-options"]))}}),iR=Object.freeze(Object.defineProperty({__proto__:null,default:nR},Symbol.toStringTag,{value:"Module"})),oR={class:"go-text-box"},aR={class:"content"},rR=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;u4(p=>({ad835132:l(n),"770576e0":l(i)+"px","686ae446":l(a)+"px",bfc1ca18:l(r),"32dde9de":l(c),"0b3a081c":h.value+"s","2bb5d1c0":l(s)+"s"}));const{w:t}=E1(e.chartConfig.attr),{fontColor:n,fontSize:i,letterSpacing:a,fontWeight:r,animationTime:s,animationSpeed:u,boxShadow:c}=E1(e.chartConfig.option),d=l4({dataset:Pt.dataset});B1(()=>e.chartConfig.option.dataset,p=>{d.dataset=p},{immediate:!0,deep:!1}),B1(e.chartConfig.option,()=>{try{e.chartConfig.option.showShadow?c.value=`${e.chartConfig.option.hShadow}px ${e.chartConfig.option.vShadow}px ${e.chartConfig.option.blurShadow}px ${e.chartConfig.option.colorShadow}`:c.value="none"}catch(p){console.log(p)}},{immediate:!0});const h=a2(()=>Math.floor(t.value/u.value));return d2(e.chartConfig,e2,p=>{d.dataset=p}),(p,g)=>(P(),n1("div",oR,[j("div",aR,[j("span",null,N2(l(d).dataset),1)])]))}});const sR=c2(rR,[["__scopeId","data-v-95986cc2"]]),lR=Object.freeze(Object.defineProperty({__proto__:null,default:sR},Symbol.toStringTag,{value:"Module"})),uR={class:"go-text-box"},cR={class:"content"},dR={key:1,style:{"white-space":"pre-wrap"}},fR=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o;u4(x=>({c9197918:l(c),"7da039f0":l(i),"1d9297af":`${l(s)}px ${l(u)}px`,c8b9474e:l(a)+"px","12d8ebb4":l(r)+"px","49518f3b":l(g),"57f9898b":l(m),b392db52:l(d)+"px","851868aa":l(p)+"px","1f563d33":l(h),"2e43ff71":l(y)}));const{linkHead:t,link:n,fontColor:i,fontSize:a,letterSpacing:r,paddingY:s,paddingX:u,textAlign:c,borderWidth:d,borderColor:h,borderRadius:p,writingMode:g,backgroundColor:y,fontWeight:m}=E1(e.chartConfig.option),v=l4({dataset:Lt.dataset});B1(()=>e.chartConfig.option.dataset,x=>{v.dataset=x},{immediate:!0,deep:!1}),d2(e.chartConfig,e2,x=>{v.dataset=x});const b=()=>{window.open(t.value+n.value)};return(x,w)=>(P(),n1("div",uR,[j("div",cR,[l(n)?(P(),n1("span",{key:0,style:{cursor:"pointer","white-space":"pre-wrap"},onClick:b})):(P(),n1("span",dR,N2(l(v).dataset),1))])]))}});const hR=c2(fR,[["__scopeId","data-v-dcbe478a"]]),pR=Object.freeze(Object.defineProperty({__proto__:null,default:hR},Symbol.toStringTag,{value:"Module"})),Xe={key:"TextGradient",chartKey:"VTextGradient",conKey:"VCTextGradient",title:"渐变文字",category:e4.TEXT,categoryName:t4.TEXT,package:R1.INFORMATIONS,chartFrame:F1.NAIVE_UI,image:"text_gradient.png"},Rn={dataset:"我是渐变文本",size:20,gradient:{from:"#0000FFFF",to:"#00FF00FF",deg:45}};class mR extends Q1{constructor(){super(...arguments);Q(this,"key",Xe.key);Q(this,"chartConfig",w1(Xe));Q(this,"option",w1(Rn))}}const Qa=Object.freeze(Object.defineProperty({__proto__:null,default:mR,option:Rn},Symbol.toStringTag,{value:"Module"})),gR={class:"go-text-box"},_R=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,t=l4({dataset:Rn.dataset});E1(e.chartConfig.attr);const{size:n,gradient:i}=E1(e.chartConfig.option);return B1(()=>e.chartConfig.option.dataset,a=>{t.dataset=a},{immediate:!0,deep:!1}),d2(e.chartConfig,e2,a=>{t.dataset=a}),(a,r)=>{const s=B("n-gradient-text");return P(),n1("div",gR,[f(s,{size:l(n),gradient:l(i)},{default:_(()=>[I1(N2(l(t).dataset),1)]),_:1},8,["size","gradient"])])}}});const vR=c2(_R,[["__scopeId","data-v-3835bf19"]]),yR=Object.freeze(Object.defineProperty({__proto__:null,default:vR},Symbol.toStringTag,{value:"Module"})),bR=o=>(d0("data-v-c881aae3"),o=o(),f0(),o),xR={class:"ranking-info"},SR=["innerHTML"],MR=bR(()=>j("div",{class:"shine"},null,-1)),AR=[MR],wR=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),{rowNum:i,unit:a,color:r,textColor:s,borderColor:u,indexFontSize:c,leftFontSize:d,rightFontSize:h}=E1(e.chartConfig.option),p=K3({mergedConfig:e.chartConfig.option,rowsData:[],rows:[{scroll:0,ranking:1,name:"",value:"",percent:0}],heights:[0],animationIndex:0,animationHandler:0,updater:0,avgHeight:0}),g=()=>{let{dataset:x,rowNum:w,sort:M}=p.mergedConfig;M&&x.sort(({value:$},{value:X})=>{if($>X)return-1;if($<X)return 1;if($===X)return 0});const A=x.map(({value:$})=>$),S=Math.min(...A)||0,D=Math.abs(S),E=(Math.max(...A)||0)+D;x=x.map(($,X)=>M2(U1({},$),{ranking:X+1,percent:($.value+D)/E*100}));const k=x.length;k>w&&k<2*w&&(x=[...x,...x]),x=x.map(($,X)=>M2(U1({},$),{scroll:X})),p.rowsData=x,p.rows=x},y=(x=!1)=>{const{rowNum:w,dataset:M}=p.mergedConfig,A=n.value/w;p.avgHeight=A,x||(p.heights=new Array(M.length).fill(A))},m=(x=!1)=>E2(this,null,function*(){let{avgHeight:w,animationIndex:M,mergedConfig:A,rowsData:S,updater:D}=p;const{waitTime:C,carousel:E,rowNum:k}=A,$=S.length;if(k>=$||x&&(yield new Promise(U=>setTimeout(U,C)),D!==p.updater))return;const X=E==="single"?1:k;let F=S.slice(M);if(F.push(...S.slice(0,M)),p.rows=F.slice(0,k+1),p.heights=new Array($).fill(w),yield new Promise(U=>setTimeout(U,300)),D!==p.updater)return;p.heights.splice(0,X,...new Array(X).fill(0)),M+=X;const R=M-$;R>=0&&(M=R),p.animationIndex=M,p.animationHandler=setTimeout(m,C*1e3-300)}),v=()=>{p.updater=(p.updater+1)%999999,p.animationHandler&&clearTimeout(p.animationHandler)},b=()=>E2(this,null,function*(){try{if(!p.mergedConfig)return;let{dataset:x,rowNum:w,sort:M}=p.mergedConfig;v(),g();let A=!0;x.length<=w&&(A=!1),y(A),m(A)}catch(x){console.error(x)}});return b(),B1(()=>t.value,()=>{b()}),B1(()=>n.value,()=>{b()}),B1(()=>i.value,()=>{b()}),B1(()=>e.chartConfig.option.dataset,()=>{b()},{deep:!1}),d2(e.chartConfig,e2,x=>{e.chartConfig.option.dataset=x,b()}),C0(()=>{v()}),(x,w)=>(P(),n1("div",{class:"go-tables-rank",style:g2(`color: ${l(s)}`)},[(P(!0),n1(x1,null,J1(p.rows,(M,A)=>(P(),n1("div",{class:"row-item",key:M.toString()+M.scroll,style:g2(`height: ${p.heights[A]}px;`)},[j("div",xR,[j("div",{class:"rank",style:g2(`color: ${l(r)};font-size: ${l(c)}px`)},"No."+N2(M.ranking),5),j("div",{class:"info-name",style:g2(`font-size: ${l(d)}px`),innerHTML:M.name},null,12,SR),j("div",{class:"ranking-value",style:g2(`color: ${l(s)};font-size: ${l(h)}px`)},N2(p.mergedConfig.valueFormatter?p.mergedConfig.valueFormatter(M):M.value)+" "+N2(l(a)),5)]),j("div",{class:"ranking-column",style:g2(`border-color: ${l(u)}`)},[j("div",{class:"inside-column",style:g2(`width: ${M.percent}%;background-color: ${l(r)}`)},AR,4)],4)],4))),128))],4))}});const CR=c2(wR,[["__scopeId","data-v-c881aae3"]]),TR=Object.freeze(Object.defineProperty({__proto__:null,default:CR},Symbol.toStringTag,{value:"Module"})),ER={class:"dv-scroll-board"},DR=["align","innerHTML"],IR=["align","innerHTML"],RR=c1({__name:"index",props:{chartConfig:{type:Object,required:!0}},setup(o){const e=o,{w:t,h:n}=E1(e.chartConfig.attr),i=K3({defaultConfig:{header:[],dataset:[],rowNum:5,headerBGC:"#00BAFF",oddRowBGC:"#003B51",evenRowBGC:"#0A2732",waitTime:2,headerHeight:35,columnWidth:[],align:[],index:!1,indexHeader:"#",carousel:"single",hoverPause:!0},mergedConfig:e.chartConfig.option,header:[],rowsData:[],rows:[{ceils:[],rowIndex:0,scroll:0}],widths:[],heights:[0],avgHeight:0,aligns:[],animationIndex:0,animationHandler:0,updater:0,needCalc:!1}),a=()=>{r(),s(),u(),c(),d(),h(),p(!0)};W0(()=>{a()});const r=()=>{i.mergedConfig=v6(w1(i.defaultConfig),e.chartConfig.option)},s=()=>{let{header:m,index:v,indexHeader:b}=i.mergedConfig;if(!m.length){i.header=[];return}m=[...m],v&&m.unshift(b),i.header=m},u=()=>{let{dataset:m,index:v,headerBGC:b,rowNum:x}=i.mergedConfig;v&&(m=m.map((M,A)=>{M=[...M];const S=`<span class="index" style="background-color: ${b};border-radius: 3px;padding: 0px 3px;">${A+1}</span>`;return M.unshift(S),M})),m=m.map((M,A)=>({ceils:M,rowIndex:A}));const w=m.length;w>x&&w<2*x&&(m=[...m,...m]),m=m.map((M,A)=>M2(U1({},M),{scroll:A})),i.rowsData=m,i.rows=m},c=()=>{const{mergedConfig:m,rowsData:v}=i,{columnWidth:b,header:x}=m,w=b.reduce((D,C)=>D+C,0);let M=0;v[0]?M=v[0].ceils.length:x.length&&(M=x.length);const A=(t.value-w)/(M-b.length),S=new Array(M).fill(A);i.widths=v6(S,b)},d=(m=!1)=>{const{mergedConfig:v,header:b}=i,{headerHeight:x,rowNum:w,dataset:M}=v;let A=n.value;b.length&&(A-=x);const S=A/w;i.avgHeight=S,m||(i.heights=new Array(M.length).fill(S))},h=()=>{const{header:m,mergedConfig:v}=i,b=m.length;let x=new Array(b).fill("left");const{align:w}=v;i.aligns=v6(x,w)},p=(m=!1)=>E2(this,null,function*(){const{needCalc:v}=i;v&&(u(),d(),i.needCalc=!1);let{avgHeight:b,animationIndex:x,mergedConfig:w,rowsData:M,updater:A}=i;const{waitTime:S,carousel:D,rowNum:C}=w,E=M.length;if(C>=E||m&&(yield new Promise(F=>setTimeout(F,S*1e3)),A!==i.updater))return;const k=D==="single"?1:C;let $=M.slice(x);if($.push(...M.slice(0,x)),i.rows=$.slice(0,D==="page"?C*2:C+1),i.heights=new Array(E).fill(b),yield new Promise(F=>setTimeout(F,300)),A!==i.updater)return;i.heights.splice(0,k,...new Array(k).fill(0)),x+=k;const X=x-E;X>=0&&(x=X),i.animationIndex=x,i.animationHandler=setTimeout(p,S*1e3-300)}),g=()=>{i.updater=(i.updater+1)%999999,i.animationHandler&&clearTimeout(i.animationHandler)},y=()=>E2(this,null,function*(){try{if(!i.mergedConfig)return;g(),a()}catch(m){console.log(m)}});return B1(()=>t.value,()=>{y()}),B1(()=>n.value,()=>{y()}),B1(()=>e.chartConfig.option,()=>{y()},{deep:!0}),d2(e.chartConfig,e2,m=>{e.chartConfig.option.dataset=m,y()}),C0(()=>{g()}),(m,v)=>(P(),n1("div",ER,[i.header.length&&i.mergedConfig?(P(),n1("div",{key:0,class:"header",style:g2(`background-color: ${i.mergedConfig.headerBGC};`)},[(P(!0),n1(x1,null,J1(i.header,(b,x)=>(P(),n1("div",{class:"header-item",key:`${b}${x}`,style:g2(`
        height: ${i.mergedConfig.headerHeight}px;
        line-height: ${i.mergedConfig.headerHeight}px;
        width: ${i.widths[x]}px;
      `),align:i.aligns[x],innerHTML:b},null,12,DR))),128))],4)):V2("",!0),i.mergedConfig?(P(),n1("div",{key:1,class:"rows",style:g2(`height: ${l(n)-(i.header.length?i.mergedConfig.headerHeight:0)}px;`)},[(P(!0),n1(x1,null,J1(i.rows,(b,x)=>(P(),n1("div",{class:"row-item",key:`${b.toString()}${b.scroll}`,style:g2(`
        height: ${i.heights[x]}px;
        line-height: ${i.heights[x]}px;
        background-color: ${i.mergedConfig[b.rowIndex%2===0?"evenRowBGC":"oddRowBGC"]};