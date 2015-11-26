<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width" />
<title>一道通停车</title>
<script  type="text/javascript" src="<%=basePath%>resource/js/zepto.min.js"></script>
 <link rel="stylesheet" href="<%=basePath%>resource/frozen/css/frozen.css">
 <script src="<%=basePath%>resource/frozen/js/frozen.js"></script>
</head>
<body>
	<div class="ui-dialog">
			    <div class="ui-dialog-cnt">
				    <header class="ui-dialog-hd ui-border-b">
	                    <h3>提示</h3>
	                    <i class="ui-dialog-close" ></i>
	                </header>
			        <div class="ui-dialog-bd">
			            <div>${opt}</div>
			        </div>
			        <div class="ui-dialog-ft">
			           
			            <button type="button"  id="confirm">确定</button>
			        </div>
			    </div>        
			</div>
			<input type="hidden" id="url" value="${url}">
<script>
	/* 	(function (){
            $("#btn1").click(function(){
			    var dia=$.dialog({
			        title:'温馨提示',
			        content:'温馨提示内容',
			        button:["确认","取消"]
			    });

			    dia.on("dialog:action",function(e){
			        alert("ee");
			    });
			    dia.on("dialog:hide",function(e){
			    	 alert("ff");
			    });
			})
			$("#btn2").click(function(){
			    $(".ui-dialog").dialog("show");
			})
		})(); */
		 $(".ui-dialog").dialog("show");
		var url = $("#url").val();
		$("#confirm").click(function(){
			 $(".ui-dialog").dialog("hide");
			 location.href="<%=basePath%>"+url;
		});
</script>
</body>
</html>