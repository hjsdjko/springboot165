"use strict";(self["webpackChunkvue3_nb0"]=self["webpackChunkvue3_nb0"]||[]).push([[603],{12603:(e,t,r)=>{r.r(t),r.d(t,{default:()=>E});r(59532),r(14580),r(39120);var a=r(44401),n=r(28849),o=r(71066),d=r(94899),s={class:"home_view"},l={class:"projectTitle"},i={class:"count_list"},u={class:"index_card_head"},c=(0,a._)("div",{class:"card_head_title"}," 商品订单 ",-1),h={class:"card_head_right"},_={class:"count_item"},f=(0,a._)("div",{class:"count_title"},"商品订单总数",-1),v={class:"count_num"},p={class:"card_list"},m={class:"index_card_head"},w=(0,a._)("div",{class:"card_head_title"}," 商品订单 ",-1),y={class:"card_head_right"},C={class:"card_item"},g=(0,a._)("div",{id:"orderstotalEchart1",style:{width:"100%",height:"400px"}},null,-1),T=[g],W={class:"index_card_head"},k=(0,a._)("div",{class:"card_head_title"}," 商品订单 ",-1),x={class:"card_head_right"},b={class:"card_item"},F=(0,a._)("div",{id:"orderstotalEchart2",style:{width:"100%",height:"400px"}},null,-1),I=[F];const j={__name:"HomeView",setup:function(e){var t,r=null===(t=(0,a.FN)())||void 0===t?void 0:t.appContext.config.globalProperties,g=r.$project.projectName,F=(0,o.iH)({}),j=function(){F.value.closeordersCountType=!0,F.value.hiddenordersCountType=!0,B("orders","首页总数")&&E()},A=(0,o.iH)(0),E=function(){null===r||void 0===r||r.$http({url:"orders/count",method:"get"}).then((function(e){A.value=e.data.data}))},$=function(e){F.value[e]=!F.value[e]},z=function(){j(),L()},B=function(e,t){return null===r||void 0===r?void 0:r.$toolUtil.isAuth(e,t)},H=(0,a.f3)("echarts"),q=function(e){U.value[e]=!U.value[e],setTimeout((function(){L()}),1e3)},U=(0,o.iH)({closeordersChartType1:!0,hiddenordersChartType1:!0,closeordersChartType2:!0,hiddenordersChartType2:!0}),L=function(){B("orders","首页统计")&&N(),B("orders","首页统计")&&O()},N=function(){(0,a.Y3)((function(){var e=H.init(document.getElementById("orderstotalEchart1"),"macarons");null===r||void 0===r||r.$http({url:"orders/value/addtime/total/月",method:"get"}).then((function(t){for(var r=t.data.data,a=[],n=[],o=[],d=0;d<r.length;d++)a.push(r[d].addtime),n.push(parseFloat(r[d].total)),o.push({value:parseFloat(r[d].total),name:r[d].addtime});var s={};s={title:{text:"月营业额统计",left:"center"},tooltip:{trigger:"item",formatter:"{b} : {c}"},xAxis:{type:"category",data:a,axisLabel:{rotate:40}},yAxis:{type:"value"},series:[{data:n,type:"bar"}]},e.clear(),e.setOption(s),e.resize()}))}))},O=function(){(0,a.Y3)((function(){var e=H.init(document.getElementById("orderstotalEchart2"),"macarons");null===r||void 0===r||r.$http({url:"orders/value/addtime/total/年",method:"get"}).then((function(t){for(var r=t.data.data,a=[],n=[],o=[],d=0;d<r.length;d++)a.push(r[d].addtime),n.push(parseFloat(r[d].total)),o.push({value:parseFloat(r[d].total),name:r[d].addtime});var s={};s={title:{text:"年营业额统计",left:"center"},tooltip:{trigger:"item",formatter:"{b} : {c}"},xAxis:{type:"category",data:a,axisLabel:{rotate:40}},yAxis:{type:"value"},series:[{data:n,type:"bar"}]},e.clear(),e.setOption(s),e.resize()}))}))};return z(),function(e,t){var r=(0,a.up)("ArrowUpBold"),j=(0,a.up)("el-icon"),E=(0,a.up)("CloseBold"),z=(0,a.up)("el-collapse-transition"),H=(0,a.up)("el-card");return(0,a.wg)(),(0,a.iD)("div",s,[(0,a._)("div",l,"欢迎使用 "+(0,n.zw)((0,o.SU)(g)),1),(0,a._)("div",i,[B("orders","首页总数")?((0,a.wg)(),(0,a.j4)(z,{key:0},{default:(0,a.w5)((function(){return[(0,a.wy)((0,a.Wm)(H,{class:"card_view"},{header:(0,a.w5)((function(){return[(0,a._)("div",u,[c,(0,a._)("div",h,[(0,a.Wm)(j,{onClick:t[0]||(t[0]=function(e){return $("hiddenordersCountType")}),class:(0,n.C_)(["showIcons",F.value.hiddenordersCountType?"showIcons1":""])},{default:(0,a.w5)((function(){return[(0,a.Wm)(r)]})),_:1},8,["class"]),(0,a.Wm)(j,{onClick:t[1]||(t[1]=function(e){return $("closeordersCountType")}),class:"closeIcons"},{default:(0,a.w5)((function(){return[(0,a.Wm)(E)]})),_:1})])])]})),default:(0,a.w5)((function(){return[(0,a.Wm)(z,null,{default:(0,a.w5)((function(){return[(0,a.wy)((0,a._)("div",_,[f,(0,a._)("div",v,(0,n.zw)(A.value),1)],512),[[d.F8,F.value.hiddenordersCountType]])]})),_:1})]})),_:1},512),[[d.F8,F.value.closeordersCountType]])]})),_:1})):(0,a.kq)("",!0)]),(0,a._)("div",p,[B("orders","首页统计")?((0,a.wg)(),(0,a.j4)(z,{key:0},{default:(0,a.w5)((function(){return[(0,a.wy)((0,a.Wm)(H,{class:"card_view"},{header:(0,a.w5)((function(){return[(0,a._)("div",m,[w,(0,a._)("div",y,[(0,a.Wm)(j,{onClick:t[2]||(t[2]=function(e){return q("hiddenordersChartType1")}),class:(0,n.C_)(["showIcons",U.value.hiddenordersChartType1?"showIcons1":""])},{default:(0,a.w5)((function(){return[(0,a.Wm)(r)]})),_:1},8,["class"]),(0,a.Wm)(j,{onClick:t[3]||(t[3]=function(e){return q("closeordersChartType1")}),class:"closeIcons"},{default:(0,a.w5)((function(){return[(0,a.Wm)(E)]})),_:1})])])]})),default:(0,a.w5)((function(){return[(0,a.Wm)(z,null,{default:(0,a.w5)((function(){return[(0,a.wy)((0,a._)("div",C,T,512),[[d.F8,U.value.hiddenordersChartType1]])]})),_:1})]})),_:1},512),[[d.F8,U.value.closeordersChartType1]])]})),_:1})):(0,a.kq)("",!0),B("orders","首页统计")?((0,a.wg)(),(0,a.j4)(z,{key:1},{default:(0,a.w5)((function(){return[(0,a.wy)((0,a.Wm)(H,{class:"card_view"},{header:(0,a.w5)((function(){return[(0,a._)("div",W,[k,(0,a._)("div",x,[(0,a.Wm)(j,{onClick:t[4]||(t[4]=function(e){return q("hiddenordersChartType2")}),class:(0,n.C_)(["showIcons",U.value.hiddenordersChartType2?"showIcons1":""])},{default:(0,a.w5)((function(){return[(0,a.Wm)(r)]})),_:1},8,["class"]),(0,a.Wm)(j,{onClick:t[5]||(t[5]=function(e){return q("closeordersChartType2")}),class:"closeIcons"},{default:(0,a.w5)((function(){return[(0,a.Wm)(E)]})),_:1})])])]})),default:(0,a.w5)((function(){return[(0,a.Wm)(z,null,{default:(0,a.w5)((function(){return[(0,a.wy)((0,a._)("div",b,I,512),[[d.F8,U.value.hiddenordersChartType2]])]})),_:1})]})),_:1},512),[[d.F8,U.value.closeordersChartType2]])]})),_:1})):(0,a.kq)("",!0)])])}}},A=j,E=A}}]);
//# sourceMappingURL=603.efb00ecc.js.map