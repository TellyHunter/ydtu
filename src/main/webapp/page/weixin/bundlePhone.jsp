<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
  <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
  
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
<script  type="text/javascript" src="<%=basePath%>resource/js/zepto.min.js"></script>
 <link rel="stylesheet" href="<%=basePath%>resource/frozen/css/frozen.css">
 <script src="<%=basePath%>resource/frozen/js/frozen.js"></script>
</head>
<body>
	
<header class="ui-header ui-header-positive ui-border-b"> <i
			class="ui-icon-return" onclick ="history.back()"></i>
				<h1>绑定手机号 </h1>
		</header>
		<section class="ui-container">
			<form action="<%=basePath %>weixin/bundle_phone.htm" id="form1" method="post">
				<input type="hidden" id="vcode_status" value="0">
				<div class="ui-form-item ui-form-item-r ui-border-b">
                        <input type="text" class="ui-input ui-border-radius" name="phone" id="phone" placeholder="请输入手机号">
                        <!-- 若按钮不可点击则添加 disabled 类 -->
                        <button type="button"  id="phone_code" class="ui-border-l">发送验证码</button>
                        
                    </div>
                         
			<div class="ui-form-item ui-form-item-pure ui-border-b">
                        <input type="text"  name="code" id="code" placeholder="请输入手机短信中的验证码" class="ui-input ui-border-radius">
                        
                    </div>   
                    
              <div class="ui-btn-wrap">
                <button class="ui-btn-lg ui-btn-primary" id="sub">
                   绑定手机号             
                 </button>   
                 </div>        
			</form>
	    </section>		

<%--< form action="<%=basePath %>weixin/bundle_phone.htm" id="form1" method="post">
<input type="hidden" id="vcode_status" value="0">
<input type="text" name="phone" id="phone" placeholder="请输入手机号">
<input type="button" value="发送验证码" id="phone_code"><br>
<input type="text" name="code" id="code" placeholder="请输入手机短信中的验证码"><br>
<input type="button" value="绑定手机号" onclick="sub();"><br>

</form> --%>

</body>

<script>

$("#phone").blur(function(){
	phoneReg();
});
function phoneReg(){
	
	var val = $("#phone").val();
	var re =/^[1-9]+[0-9]*]*$/; 
	if (!re.test(val)||val.length!=11) {
		$.tips({
	        content:'手机号输入有误',
	        stayTime:1000,
	        type:"warn"
	    }) 
	    return false;
	}else
	{
		return true;
	}
}

$("#phone_code").click(function(){
	
	var pf=phoneReg();
	if(pf==false){
		return false;
	}
	if($('#vcode_status').val()==0){
		$.ajax({ 
		    type : "post", 
		    url : "<%=basePath%>weixin/getCode.htm", 
		    data: {"phone":$("#phone").val()},
		    dataType : "json", 
		    success : function(data) { 
		    	if(data.result=="FAIL"){
		    		$.tips({
		    	        content:data.msg,
		    	        stayTime:1000,
		    	        type:"warn"
		    	    }) 
		    	}
		    	else if(data.result=="SUCCESS"){
					$("#err_msg").text("");
					$.tips({
				        content:'验证码已发送至手机',
				        stayTime:1000,
				        type:"success"
				    }) 
					time() ;
				}
			} 
		});
	}
	return false;
});

var s = 60, t;
function time() {
	s--;
    t = setTimeout(function () {
        time();
    },
    1000)
	if ( s <= 0 ){
		$('#msg_ag').html("");
		s = 60;
		clearTimeout(t);
		$('#vcode_status').val(0);
		$('#phone_code').html('获取验证码');
	}else {
		$('#vcode_status').val(1);
		$('#phone_code').html('获取验证码(' + s +')');
	}
}

function validCode(){
	var flag=false;
	$.ajax({ 
	    type : "post", 
	    url : "<%=basePath%>weixin/validate_code.htm", 
	    data: {"phone":$("#phone").val(),"code":$("#code").val()},
	    dataType : "json", 
	    async: false,
	    success : function(data) { 
	    	if(data.result=="FAIL"){
	    		$.tips({
	    	        content:data.msg,
	    	        stayTime:1000,
	    	        type:"warn"
	    	    }) 
	    	}
	    	else if(data.result=="SUCCESS"){
	    		flag=true;
			}
		} 
	});
	return flag;
}
$("#sub").click(function(){
	var flag=validCode();
	if(!flag){
		return false;
	}
	$("#form1").submit();
})
</script>


</html>