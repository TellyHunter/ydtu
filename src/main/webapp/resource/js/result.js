var SUCCESS="SUCCESS";
var FAIL="FAIL";
var linkPre="";
if (typeof WeixinJSBridge == "undefined"){
	if(isPC()){
		
	}
	else{
		linkPre="http://www.dmzparking.com";	
	}
	
}
function checkResult(result){
	if(result=="NOAUTH"){
		alert("无此权限");
		return;
	}
	else if(result=="NOLOGIN"){
		location.href="login.html";
	}
}
function checkResultWithData(data){
	
}

function checkResult_weixin(result){
	if(result=="NOAUTH"){
		alert("无此权限");
		return;
	}
	else if(result=="NOLOGIN"){
		location.href="login.html";
	}
}

function isPC()  
{  
   var userAgentInfo = navigator.userAgent;  
   var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");  
   var flag = true;  
   for (var v = 0; v < Agents.length; v++) {  
       if (userAgentInfo.indexOf(Agents[v]) > 0) { flag = false; break; }  
   }  
   return flag;  
}            

  


function closeWindow(){
	if (isWeiXin()){
    	WeixinJSBridge.invoke('closeWindow',{},function(res){});
	}
	else{
		location.href="index.html"; 
	}
}

function isWeiXin(){
    var ua = window.navigator.userAgent.toLowerCase();
    if(ua.match(/MicroMessenger/i) == 'micromessenger'){
        return true;
    }else{
        return false;
    }
}