var currentPage=1;
var pageSize=10;
var totalPage;
function getPage(){
	var size = $("#pageSize").val()
	if(size != undefined){
		pageSize = size;
	}
	return "&currentPage="+currentPage+"&pageSize="+pageSize+"";
}

function refreshPage(dir){
	totalPage=document.getElementById("totalPage").value;
	if(dir==1&&currentPage!=1){
		currentPage=1;
	}
	else if(dir==2&&currentPage>1){
		currentPage=currentPage-1;
	}
	else if(dir==3&&currentPage<totalPage){
		currentPage=currentPage+1;
	}
	else if(dir==4&&currentPage<totalPage){
		currentPage=totalPage;
	}
	else{
		return false;
	}
	return true;
}		