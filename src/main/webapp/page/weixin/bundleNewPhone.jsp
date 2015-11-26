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
				<h1>手机验证</h1>
		</header>
<section class="ui-container">		
	<form id="form1" method="post" action="<%=basePath%>weixin/bundle_phone_page.htm">
		
		  <div class="ui-form-item ui-form-item-r ui-border-b">
			<div class="ui-whitespace">
                <p class="ui-txt-default">绑定的手机号码:${fn:substring(phone, 0, 3)}****${fn:substring(phone, 7, 11)}</p>
             </div>
           </div> 
             <div class="ui-form-item ui-form-item-r ui-border-b">
                        <input type="text" class="ui-input ui-border-radius" name="phone" id="phone" placeholder="请输入绑定的手机号">
                        <!-- 若按钮不可点击则添加 disabled 类 -->
                        <button type="button"  onclick="validPhone();" class="ui-border-l">验证</button>
                        
                    </div>
	</form>
</section>
<%-- <h5>绑定的手机号码</h5>
<form id="form1" method="post" action="<%=basePath%>weixin/bundle_phone_page.htm">


${fn:substring(phone, 0, 3)}****${fn:substring(phone, 7, 11)}<br>
<input type="text"  name="phone" id="phone">
<input type="button" value="验证" onclick="validPhone();"><br>

</form> --%>



</body>

<script>
$("#phone").blur(function(){
	phoneReg();
});
function phoneReg(){
	var val =$("#phone").val();
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

$("#phone").click(function(){
	
	var pf=phoneReg();
	if(pf==false){
		return false;
	}
	var phone = "${phone}";

});

function validPhone(){
	var val =$("#phone").val();
	var phone = "${phone}";
	if(val != phone){
		$.tips({
	        content:'已绑定手机号输入错误，请重新输入',
	        stayTime:1000,
	        type:"warn"
	    }) 	
	    return false;
	}else{
		$("#form1").submit();
	}
}
</script>


</html>