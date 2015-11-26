var currentPage=parseInt(document.getElementById("currentPage").value);
var totalPage=document.getElementById("totalPage").value;
document.getElementById("homePage").innerHTML="<a href=javascript:void(0) onclick=pages('home')>"+document.getElementById("homePage").innerHTML+"</a>";
document.getElementById("prePage").innerHTML="<a href=javascript:void(0) onclick=pages('pre')>"+document.getElementById("prePage").innerHTML+"</a>";
document.getElementById("nextPage").innerHTML="<a href=javascript:void(0) onclick=pages('next')>"+document.getElementById("nextPage").innerHTML+"</a>";
document.getElementById("lastPage").innerHTML="<a href=javascript:void(0) onclick=pages('last')>"+document.getElementById("lastPage").innerHTML+"</a>";
if(isNaN(currentPage)){
	var obj = document.getElementsByTagName("div");
	for(var i=0;i<obj.length;i++)
	{
		if(obj[i].className == 'main_foot')
		{
			obj[i].style.display='none';
		}
	}
}
function pages(dir){
	if(dir=="home"&&currentPage!=1){
		currentPage=1;
	}
	else if(dir=="pre"&&currentPage>1){
		currentPage=currentPage-1;
	}
	else if(dir=="next"&&currentPage<totalPage){
		currentPage=currentPage+1;
	}
	else if(dir=="last"&&currentPage<totalPage){
		currentPage=totalPage;
	}
	else{
		return false;
	}
	if(typeof(document.getElementById("search_form")) == "undefined"){
		document.form[0].action=document.form[0].action+"?currentPage="+currentPage+"";
		document.getElementById("search_form").method="post";
		document.form[0].submit();
	}
	else{
		document.getElementById("search_form").action=document.getElementById("search_form").action+"?currentPage="+currentPage+"";
		document.getElementById("search_form").method="post";
		document.getElementById("search_form").submit();
	}
	
}
