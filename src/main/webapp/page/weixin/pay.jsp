<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width" />
<script src="<%=basePath %>resource/js/jquery-1.8.0.min.js"></script>

<title>一道通停车</title>
<script type="text/javascript">
	function onBridgeReady(appId,timeStamp,nonceStr,package2,paySign){
	  	  WeixinJSBridge.invoke(
	       'getBrandWCPayRequest', {
	           "appId" : appId,     //公众号名称，由商户传入     
	           "timeStamp":timeStamp,         //时间戳，自1970年以来的秒数     
	           "nonceStr" : nonceStr, //随机串     
	           "package" : package2,     
	           "signType" : "MD5",         //微信签名方式:     
	           "paySign" : paySign //微信签名 
	       },
	       function(res){    
	           if(res.err_msg == "get_brand_wcpay_request:ok" ) {
	        	   
	        	   
	           }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
	           else{
	        	   
	           }
	       }
	   );  
	}
	
	function pay(){
		$.ajax({
			url:"<%=basePath%>weixin/jsapi2.htm",
			type:"post",
			data:{},
			dataType:"json",
			success:function(data){
				onBridgeReady(data.appId,data.timeStamp,data.nonceStr,data.package2,data.paySign)
			}
		});
	}
	pay();
</script>
</head>
<body>

</body>
</html>