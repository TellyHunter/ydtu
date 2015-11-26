<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" />
<title>一道通停车</title>
 <link rel="stylesheet" href="<%=basePath%>resource/frozen/css/frozen.css">
  <link rel="stylesheet" href="<%=basePath%>resource/frozen/css/demo.css">
  <script type="text/javascript">
  function closeWindow(){
		if (typeof WeixinJSBridge != "undefined"){
	    	WeixinJSBridge.invoke('closeWindow',{},function(res){});

		}
	}
  </script>
</head>
<body>
<header class="ui-header ui-header-positive ui-border-b">
            <i class="ui-icon-return" onclick="closeWindow()"></i><h1>首页</h1>
        </header>
               <section class="ui-container">
<section id="layout">

  <div class="demo-item">
        <div class="demo-block"> 
            <ul class="ui-row-flex ui-tiled">
                <li onclick="go(1)" class="ui-col ui-flex ui-flex-pack-start ui-flex  ui-flex-align-center"><div><i class="ui-icon-personal"></i></div><div style="font-size: 13px;">个人信息</div></li>
                <li onclick="go(2)" class="ui-col ui-flex ui-flex-pack-center ui-flex  ui-flex-align-center" style="border-left: 0"><div><i class="ui-icon-personal"></i></div><div style="font-size: 13px;">充值</div></li>
                <li onclick="go(3)" class="ui-col ui-flex ui-flex-pack-end ui-flex  ui-flex-align-center" style="border-left: 0"><div><i class="ui-icon-personal"></i></div><div style="font-size: 13px;">车辆管理</div></li>
				
            </ul>
		 <ul class="ui-row-flex ui-tiled">
                <li onclick="go(4)" class="ui-col ui-flex ui-flex-pack-start ui-flex  ui-flex-align-center" style="border-top: 0"><div><i class="ui-icon-personal"></i></div><div style="font-size: 13px;">消费记录</div></li>
                <li onclick="go(5)" class="ui-col ui-flex ui-flex-pack-center ui-flex  ui-flex-align-center" style="border-top: 0;border-left: 0"><div><i class="ui-icon-personal"></i></div><div style="font-size: 13px;">充值记录</div></li>
                <li onclick="go(6)" class="ui-col ui-flex ui-flex-pack-end ui-flex  ui-flex-align-center" style="border-top: 0;border-left: 0"><div><i class="ui-icon-personal"></i></div><div style="font-size: 13px;">云锁车</div></li>
         </ul>
         <ul class="ui-row-flex ui-tiled">
                <li onclick="go(7)" class="ui-col ui-flex ui-flex-pack-start ui-flex  ui-flex-align-center" style="border-top: 0"><div><i class="ui-icon-personal"></i></div><div style="font-size: 13px;">停车实况</div></li>
                <li onclick="go(8)" class="ui-col ui-flex ui-flex-pack-center ui-flex  ui-flex-align-center" style="border-top: 0;border-left: 0"><div><i class="ui-icon-personal"></i></div><div style="font-size: 13px;">停车缴费</div></li>
                <li onclick="go(9)" class="ui-col ui-flex ui-flex-pack-end ui-flex  ui-flex-align-center" style="border-top: 0;border-left: 0;"><div><i class="ui-icon-personal"></i></div><div style="font-size: 13px;">我的优惠券</div></li>
         </ul>
        </div>
		
    </div>
    </section>
    
    </section>
<script type="text/javascript">
	function go(type){
		if(type==1){
			location.href="<%=basePath%>/weixin/personInfo.htm";
		}
		else if(type==2){
			location.href="<%=basePath%>/weixin/readypay.htm";
		}
		else if(type==3){
			location.href="<%=basePath%>/weixin/tmembercar_select.htm";
		}
		else if(type==4){
			location.href="<%=basePath%>/weixin/consumptionRecords_select.htm";
		}
		else if(type==5){
			location.href="<%=basePath%>/weixin/charge_search.htm";
		}
		else if(type==6){
			location.href="<%=basePath%>/weixin/carPlates_search.htm";
		}
		else if(type==7){
			location.href="<%=basePath%>/weixin/tparkinoutlivecar_select.htm";
		}
		else if(type==8){
			alert("敬请期待");
			<%-- location.href="<%=basePath%>/weixin/carPlates_search.htm"; --%>
		}
		else if(type==9){
			location.href="/ydtu/page/weixin/couponList.html";
		}
	}


</script>
</body>
</html>