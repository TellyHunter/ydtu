<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width" />

 <link rel="stylesheet" href="<%=basePath%>resource/frozen/css/frozen.css">
  <script type="text/javascript">
 function index(){
		location.href="<%=basePath%>weixin/index.htm";
 }
 </script>
<title>一道通停车 </title>
</head>
<body>
		<header class="ui-header ui-header-positive ui-border-b">
            <i class="ui-icon-return" onclick="history.back()"></i><h1>消费记录</h1><!-- <button class="ui-btn" onclick="index()">首页</button> -->
        </header>
		<section class="ui-container ui-center">
                尚无记录
            </section>
</body>
</html>