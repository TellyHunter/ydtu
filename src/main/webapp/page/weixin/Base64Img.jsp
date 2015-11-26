<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>LocalResizeIMG</title>
</head>
<style>
    body {
        margin: 20px 20%;
        color:#777;
        text-align: center;
    }
</style>
<body>
    <h1 class="text-center">LocalResizeIMG-本地压缩 1.0</h1>
    <hr/>
    <input type="file" />
	<img id="img1">
    <hr/>

	<!-- javascript
		================================================== -->
	<script src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js" type="text/javascript"></script>
	<script src="<%=basePath %>resource/LocalResizeIMG/LocalResizeIMG.js" type="text/javascript"></script>
	
    <!-- mobileBUGFix.js 兼容修复移动设备 -->
	<script src="<%=basePath %>resource/LocalResizeIMG/mobileBUGFix.mini.js" type="text/javascript"></script>
	<script type="text/javascript">
        $('input:file').localResizeIMG({
             width: 800,
             quality: 1,
             success: function (result) {
             
			 
			 $("#img1").attr("src",result.base64);
			 $.ajax({
	                url: '<%=basePath %>ge_img.htm',
	                type: 'POST',
	                data: {formFile: result.clearBase64},
	                dataType: 'HTML',
	                timeout: 1000,
	                error: function () {
	                    
	                },
	                success: function (res) {
	                	alert(res);
	                }
	            });
             console.log(result);
             }
         });
	</script>
</body>
</html>