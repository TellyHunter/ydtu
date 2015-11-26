/*var formId = "form1";
		var rules = {
			"username": {
				"required": "true,用户名不能为空",
				"minlength": "5,最少5个字符",
				"maxlength": "10,最多10个字符"
			},
			"password": {
				"required": "true,密码不能为空"
			}
		}*/
		var defaultPrompt={
				"required":"必填项",  
				"remote":"Please fix this field.",  
				"email":"邮箱非法,请确认",  
				"url":"URL地址格式错误，请确认",  
				"date":"日期格式错误，请确认",  
				"dateISO":"日期格式(ISO)错误，请确认.",  
				"number":"请输入数字",  
				"digits":"请输入整数",  
				"creditcard":"信用卡号码格式错误",  
				"equalTo":"两次输入不一致",  
				"accept":"后缀名错误",  
				"mobile":"手机号码格式错误",  
				"tel":"电话号码格式错误",  
				"mobileOrTel":"手机或电话号码格式错误",  
				"qq":"QQ号码格式错误",  
				"chinese":"请输入中文",  
				"idcard":"身份证号码格式错误",  
				"letter":"请输入字母",  
				"ip":"IP地址格式错误",  
				"zipcode":"邮政编码格式错误",  
				//"maxlength":"最多输入 {0} 个字符",  
				"maxlength":"输入字符超过长度限制",  
				//"minlength":"最少输入 {0} 个字符",  
				"minlength":"输入字符未达到最小长度要求",  
				"rangelength":"字符长度介于 {0} 到 {1} 之间",  
				"range":"值大小介于 {0} 到 {1}之间",  
				"max":"最大值不超过 {0}",  
				"min":"最小值不小于 {0}",
				"phoneCheck":"手机号码格式有误",
				"passRule":"密码只能由英文字母和数字组成"
		};
		
		function validate_objTO(validate_formId, validate_key, validate_obj) {
			var validate_result = true;
			for (var i in validate_obj) {
				validate_result = rule_check(validate_formId, validate_key, i,getPre(validate_obj[i]));
				if (!validate_result) {
					var msg=getLast(validate_obj[i]) ;
					if(msg== ""){
						if(isExitsFunction("validate_false")){
							validate_false(defaultPrompt[i]);
						}
						else{
							alert(defaultPrompt[i]);
						}
					}
					else{
						if(isExitsFunction("validate_false")){
							validate_false(msg);
						}
						else{
							alert(msg);
							
						}
					}
					break;
				}
			}
			return validate_result;
		}
		
		function rule_check(validate_formId, validate_key, validate_str,validate_value) {
			if (validate_str == "required"&&validate_value=="true") {
				return required(validate_formId,validate_key);
			} 
			else if (validate_str == "minlength") {
				return minlength(validate_formId,validate_key,validate_value);
			} 
			else if (validate_str == "maxlength") {
				return maxlength(validate_formId,validate_key,validate_value);
			} else {
				return true;
			}
		}

		function required(validate_formId, validate_key) {
			if (document.getElementById(validate_formId).elements[validate_key].value == "") {
				return false;
			} else {
				return true;
			}
		}
		function minlength(validate_formId, validate_key,validate_value) {
			var cc=document.getElementById("form1").elements["username"].value;
			var ddd=document.getElementById(validate_formId).elements[validate_key].value;
			if (document.getElementById(validate_formId).elements[validate_key].value.length>validate_value) {
				return true;
			} else {
				return false;
			}
		}
		function maxlength(validate_formId, validate_key,validate_value) {
			if (document.getElementById(validate_formId).elements[validate_key].value.length<validate_value) {
				return true;
			} else {
				return false;
			}
		}
		function validate(validate_formId,validate_rules) {
			/*var validate_formId=formId;
			var validate_rules=rules;*/
			var validate_result=true;
			var validate_obj = eval(validate_rules);
			for (var i in validate_obj) { 
				validate_result=validate_objTO(validate_formId, i, validate_obj[i]);
				if(!validate_result){
					break;
				}
			}
			return validate_result;
		}
		//是否存在指定函数 
		function isExitsFunction(funcName) {
		    try {
		        if (typeof(eval(funcName)) == "function") {
		            return true;
		        }
		    } catch(e) {}
		    return false;
		}
		function getPre(str){
			 var s = str.indexOf(","); 
			 if(s<0){
				 return str;
			 }
			 else{
				 return str.substring(0,s);
			 }
		}
		function getLast(str){
			 var s = str.indexOf(","); 
			 if(s<0){
				 return "";
			 }
			 else{
				 return str.substring(s+1,str.length);
			 }
		}