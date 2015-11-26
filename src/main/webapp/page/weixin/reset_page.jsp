<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>一道通停车</title>
<script  type="text/javascript" src="<%=basePath%>resource/js/zepto.min.js"></script>
 <link rel="stylesheet" href="<%=basePath%>resource/frozen/css/frozen.css">
 <script src="<%=basePath%>resource/frozen/js/frozen.js"></script>
</head>
<body>

   <header class="ui-header ui-header-positive ui-border-b">
            <i class="ui-icon-return" onclick="history.back()"></i><h1>重置密码</h1>
        </header>
<section class="ui-container">
<form action="<%=basePath%>weixin/resetPassword.htm" id="resetForm"  method="post" >
<input type="hidden" name="phone" value="${phone }">
 <div class="ui-form-item ui-form-item-pure ui-border-b">
                        <input type="text" placeholder="请输入密码" name="password" id="password">
                    </div>
                    
                     <div class="ui-form-item ui-form-item-pure ui-border-b">
                        <input type="text" placeholder="再次输入密码" name="rePassword" id="rePassword">
                    </div>
					 <button class="ui-btn-lg ui-btn-primary" id="sub">
                    确定
                </button>
</form>

</section>

	
	<script type="text/javascript">
	$("#password").blur(function(){
		pwd();
	});
	function pwd(){
		var val = $("#password").val();
		var reg = /^[A-Za-z0-9]+$/ ;
		if (val.length<6) {
			$.tips({
		        content:'密码必须大于6位',
		        stayTime:1000,
		        type:"warn"
		    }) 
		    return false;
		}
		else if (!reg.test(val)) {
			$.tips({
		        content:'密码只能输入英文和字母',
		        stayTime:1000,
		        type:"warn"
		    }) 
		    return false;
		}
		
		else
		{
			return true;
		}
	}
	$("#rePassword").blur(function(){
		rePwd();
	});
	function  rePwd(){
		if($("#password").val()!=$("#rePassword").val()){
			$.tips({
		        content:'两次密码输入不一致',
		        stayTime:1000,
		        type:"warn"
		    }) 
			return false;
		}
		return true;
	}
	$("#sub").click(function(){
		if(!pwd()||!rePwd()){
			return false;
		}
		return true;
	});
	</script>
</body>
</html>