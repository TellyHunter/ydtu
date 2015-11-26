var base64EncodeChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
var base64DecodeChars = new Array(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1,
		63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1,
		0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
		20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31,
		32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
		50, 51, -1, -1, -1, -1, -1);

function base64encode(str) {
	var out, i, len;
	var c1, c2, c3;
	len = str.length;
	i = 0;
	out = "";

	while (i < len) {
		c1 = str.charCodeAt(i++) & 0xff;

		if (i == len) {
			out += base64EncodeChars.charAt(c1 >> 2);
			out += base64EncodeChars.charAt((c1 & 0x3) << 4);
			out += "==";
			break
		}

		c2 = str.charCodeAt(i++);

		if (i == len) {
			out += base64EncodeChars.charAt(c1 >> 2);
			out += base64EncodeChars.charAt(((c1 & 0x3) << 4)
					| ((c2 & 0xF0) >> 4));
			out += base64EncodeChars.charAt((c2 & 0xF) << 2);
			out += "=";
			break
		}

		c3 = str.charCodeAt(i++);
		out += base64EncodeChars.charAt(c1 >> 2);
		out += base64EncodeChars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xF0) >> 4));
		out += base64EncodeChars.charAt(((c2 & 0xF) << 2) | ((c3 & 0xC0) >> 6));
		out += base64EncodeChars.charAt(c3 & 0x3F)
	}

	return out
}

function base64decode(str) {
	var c1, c2, c3, c4;
	var i, len, out;
	len = str.length;
	i = 0;
	out = "";

	while (i < len) {
		do {
			c1 = base64DecodeChars[str.charCodeAt(i++) & 0xff]
		} while (i < len && c1 == -1);

		if (c1 == -1)
			break;

		do {
			c2 = base64DecodeChars[str.charCodeAt(i++) & 0xff]
		} while (i < len && c2 == -1);

		if (c2 == -1)
			break;

		out += String.fromCharCode((c1 << 2) | ((c2 & 0x30) >> 4));

		do {
			c3 = str.charCodeAt(i++) & 0xff;

			if (c3 == 61)
				return out;

			c3 = base64DecodeChars[c3]
		} while (i < len && c3 == -1);

		if (c3 == -1)
			break;

		out += String.fromCharCode(((c2 & 0XF) << 4) | ((c3 & 0x3C) >> 2));

		do {
			c4 = str.charCodeAt(i++) & 0xff;

			if (c4 == 61)
				return out;

			c4 = base64DecodeChars[c4]
		} while (i < len && c4 == -1);

		if (c4 == -1)
			break;

		out += String.fromCharCode(((c3 & 0x03) << 6) | c4)
	}

	return out
}

function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = base64decode(window.location.search.substr(1)).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

function getQueryString2(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}


// 得到当前日期 日期格式：yyyy-MM-dd
function getNowFormatDate() {
	var day = new Date();
	var Year = 0;
	var Month = 0;
	var Day = 0;
	var CurrentDate = "";
	// 初始化时间
	// Year= day.getYear();//有火狐下2008年显示108的bug
	Year = day.getFullYear();// ie火狐下都可以
	Month = day.getMonth() + 1;
	Day = day.getDate();
	// Hour = day.getHours();
	// Minute = day.getMinutes();
	// Second = day.getSeconds();
	CurrentDate += Year + "-";
	if (Month >= 10) {
		CurrentDate += Month + "-";
	} else {
		CurrentDate += "0" + Month + "-";
	}
	if (Day >= 10) {
		CurrentDate += Day;
	} else {
		CurrentDate += "0" + Day;
	}
	return CurrentDate;
} 




function getCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=")
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1
			c_end = document.cookie.indexOf(";", c_start)
			if (c_end == -1)
				c_end = document.cookie.length
				
			var str = unescape(document.cookie.substring(c_start, c_end));
			var ftimeDate = str.substring(0,10);
			var ftime= str.substring(11,16);
			var refresh;
			if(ftimeDate == today){
				refresh = "今天 "+ ftime;
			}else if(ftimeDate == yestoday){
				refresh = "昨天 "+ ftime;;
			}else{
				refresh = "前天 "+ ftime;;
			};
			return refresh;
//			return unescape(document.cookie.substring(c_start, c_end))
		}
	}
	
	return ""
}

function setCookie(c_name, value, expiredays) {
	var exdate = new Date()
	exdate.setDate(exdate.getDate() + expiredays)
	document.cookie = c_name
			+ "="
			+ escape(value.pattern("yyyy-MM-dd HH:mm:ss"))
			+ ((expiredays == null) ? "" : ";expires="
					+ exdate)
}

function checkCookie() {
	refreshTime = getCookie('refreshTime');
	if (refreshTime != null && refreshTime != "") {
		$("#refreshTime").html("最后更新：" + refreshTime);
	} else {
		refreshTime = new Date();
		setCookie('refreshTime', refreshTime, 365);
		$("#refreshTime").html("最后更新：" +getCookie("refreshTime"));
	}
}

Date.prototype.pattern=function(fmt) {          

    var o = {          

    "M+" : this.getMonth()+1, //月份          

    "d+" : this.getDate(), //日          

    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时          

    "H+" : this.getHours(), //小时          

    "m+" : this.getMinutes(), //分          

    "s+" : this.getSeconds(), //秒          

    "q+" : Math.floor((this.getMonth()+3)/3), //季度          

    "S" : this.getMilliseconds() //毫秒          

    };          

    var week = {          

    "0" : "\u65e5",          

    "1" : "\u4e00",          

    "2" : "\u4e8c",          

    "3" : "\u4e09",          

    "4" : "\u56db",          

    "5" : "\u4e94",          

    "6" : "\u516d"         

    };          

    if(/(y+)/.test(fmt)){          

        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));          

    }          

    if(/(E+)/.test(fmt)){          

        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);          

    }          

    for(var k in o){          

        if(new RegExp("("+ k +")").test(fmt)){          

            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));          

        }          

    }          

    return fmt;          

} 
