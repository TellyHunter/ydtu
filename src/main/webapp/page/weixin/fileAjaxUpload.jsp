<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width" />

<title>一道通</title>
  <script src="<%=basePath%>resource/js/jquery-1.8.0.min.js"></script>

 <script src="<%=basePath%>resource/js/ajaxfileupload.js"></script>
</head>
<body>

<form action="#" name="myform" method="post">
<input type='file'  id="uploada" name="uploada" size='50'/>
<input type="button" style="width: 5em"  onclick="uploadImages('uploada')" value='上传'/>
<input type='file'  id="uploadb" name="uploadb" size='50'/>
<input type="button" style="width: 5em"  onclick="uploadImages('uploadb')" value='上传'/>
<input type='file'  id="uploadc" name="uploadc" size='50'/>
<input type="button" style="width: 5em"  onclick="uploadImages('uploadc')" value='上传'/>
</form>

<script type="text/javascript">
function uploadImages(type) {
	$.ajaxFileUpload({
			//跟具updateP得到不同的上传文本的ID
	                 url:'<%=basePath%>/activity/uploadImg.htm?updateP='+type,             //需要链接到服务器地址
	                 secureuri:false,
	                 fileElementId:''+type+'',                         //文件选择框的id属性（必须）
	                 dataType: 'text',  
	                 success: function (data, status){  
	                 var data = eval("("+data+")");
						if(data.updateP=='uploada'){
							document.getElementById("显示文件访问路径文本的IDA").value=baseurl+"/upload/"+data.fileName;
						}else if(data.updateP=='uploadb'){
							document.getElementById("显示文件访问路径文本的IDB").value=baseurl+"/upload/"+data.fileName;
						}else if(data.updateP=='uploadc'){
							document.getElementById("显示文件访问路径文本的IDC").value=baseurl+"/upload/"+data.fileName;
						}
				alert('上传失败');				
	                 },
	                 error: function (data, status, e){  
	                     alert('上传失败');
	                 }
	               }
	            );

	}
</script>
</body>
</html>