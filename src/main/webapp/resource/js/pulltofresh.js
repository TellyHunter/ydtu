
var myScroll,
	pullDownEl, pullDownOffset,
	pullUpEl, pullUpOffset,
	generatedCount = 0;
var pageContent; //页面内容

function pullDownAction () {
	setTimeout(function () {	// <-- Simulate network congestion, remove setTimeout from production!
		currentPage = 1;
		$("#loadContent").html(getList());
		myScroll.refresh();		// Remember to refresh when contents are loaded (ie: on ajax completion)
	}, 100);	// <-- Simulate network congestion, remove setTimeout from production!
}

function pullUpAction () {
	setTimeout(function () {	// <-- Simulate network congestion, remove setTimeout from production!
		//每次下拉，将pageContent内容重置一下
		pageContent = getList();
		var sHtml = setPage(3);
		pageContent+=sHtml;
		if(sHtml == ""){
//			$("#pullUp").removeAttr("style");
//			pullUpEl.className = '';
//			pullUpEl.querySelector('.pullUpLabel').innerHTML = '已经是最新内容';	
//			setTimeout(function(){
//				$("#pullUp").css("display", "none;");
//			}, 800);
		}else{
			$("#loadContent").html(pageContent);
		}
		myScroll.refresh();		// Remember to refresh when contents are loaded (ie: on ajax completion)
	}, 100);	// <-- Simulate network congestion, remove setTimeout from production!
}

function loaded() {
	
	pullDownEl = document.getElementById('pullDown');
	pullDownOffset = pullDownEl.offsetHeight;
	pullUpEl = document.getElementById('pullUp');	
	pullUpOffset = pullUpEl.offsetHeight;
	
	myScroll = new iScroll('wrapper', {
		useTransition: true,
		topOffset: pullDownOffset,
		onRefresh: function () {
			if (pullDownEl.className.match('loading')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉可以刷新';
			} 
// 			else if (pullUpEl.className.match('loading')) {
// 				pullUpEl.className = '';
// 				pullUpEl.querySelector('.pullUpLabel').innerHTML = 'Pull up to load more...';
// 			}
		},
		onScrollMove: function () {
			if (this.y > 5 && !pullDownEl.className.match('flip')) {
				pullDownEl.className = 'flip';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '松开立即刷新';
				this.minScrollY = 0;
				
				setCookie("refreshTime",new Date(),365);
				$("#refreshTime").html("最后更新：" +getCookie("refreshTime"));
			} else if (this.y < 5 && pullDownEl.className.match('flip')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉可以刷新';
				this.minScrollY = -pullDownOffset;
			}
 			else if (this.y < (this.maxScrollY - 5) && !pullUpEl.className.match('flip')) {
 				//如果是上拉，才进入此方法
 				if(this.y < -90){
 					pullUpEl.className = 'flip';
 				}
// 				pullUpEl.querySelector('.pullUpLabel').innerHTML = 'Release to refresh...';
 				this.maxScrollY = this.maxScrollY;
 			} else if (this.y > (this.maxScrollY + 5) && pullUpEl.className.match('flip')) {
 				pullUpEl.className = '';
// 				pullUpEl.querySelector('.pullUpLabel').innerHTML = 'Pull up to load more...';
 				this.maxScrollY = pullUpOffset;
 			}
		},
		onScrollEnd: function () {
			if (pullDownEl.className.match('flip')) {
				pullDownEl.className = 'loading';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '正在刷新数据...';				
				pullDownAction();	// Execute custom function (ajax call?)
			} 
 			else if (pullUpEl.className.match('flip')) {
 				pullUpEl.className = 'loading';
// 				pullUpEl.querySelector('.pullUpLabel').innerHTML = 'Loading...';				
  				pullUpAction();	// Execute custom function (ajax call?)
 			}
		}
	});
	pageContent = getList();
	$("#loadContent").html(pageContent);
	setTimeout(function () { document.getElementById('wrapper').style.left = '0'; }, 200);
}

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

document.addEventListener('DOMContentLoaded', function () { setTimeout(loaded, 200); }, false);