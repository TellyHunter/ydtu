//支付方式
function Payment_Method(num)
{	

	$(".titlie_li").css("border-bottom","")
	$(".titlie_li").css("color","")	
	$(".title_a").css("border-bottom","")
	$(".title_a").css("color","#555")		
	
	$("#titlie_a_"+num).css("color","#e2740e");
	$("#titlie_li_"+num).css("border-bottom","1px solid #e2740e");
	$("#titlie_li_"+num).css("color","#e2740e");	
	
	
	$(".back_box").css("display","none")
	$("#back_box_"+num).css("display","block")	
}

function Choice_Quick(num)
{
	if(num!=0){
		Choice_Bank(0);
		Choice_Platform(0);
	}
	
	$("#back_box_1 img").css({"border-width":"2px","border-color":"#e8e8e8"});		
	$(".choiced").css("display","none");	
	$(".Quick_choiced").css("display","none");	
	
	try{
	$("#Quick_"+num).css({"border-width":"2px","border-color":"#e2740e"});		
	$("#Quick_choiced_"+num).css("display","block");
	
	$("#Quick_Method").val(num);	
	}
	catch(err)
	{		
	}
	
}

function Choice_Bank(num)
{
	if(num!=0){
		Choice_Platform(0);
		Choice_Quick(0);
	}
	$("#back_box_2 img").css({"border-width":"2px","border-color":"#e8e8e8"});	
	$(".choiced").css("display","none");
	$(".Quick_choiced").css("display","none");	
	
	try{
	$("#Bank_"+num).css({"border-width":"2px","border-color":"#e2740e"});		
	$("#choiced_"+num).css("display","block");
	
	$("#Bank_Method").val(num);
	}
	catch(err)
	{
		
	}
	
}

function Choice_Platform(num)
{
	if(num!=0){
		Choice_Bank(0);
		Choice_Quick(0);
	}
	$("#back_box_3 img").css({"border-width":"2px","border-color":"#e8e8e8"});	
	$(".choiced").css("display","none");
	$(".Quick_choiced").css("display","none");	
	
	try{
	$("#Platform_"+num).css({"border-width":"2px","border-color":"#e2740e"});		
	$("#Platform_choiced_"+num).css("display","block");
	
	$("#Platform_Method").val(num);
	
	}
	catch(err)
	{
		
	}
	
}

$(document).ready(function(){	

$("#Card_type").focus(function(){

   	 	$("#Card_type_Choice").css("display","block");
		$(this).css("border-radius","5px 5px 0px 0px");
		
		})
		
	$("#Card_type").blur(function(){

		setTimeout("$(\"#Card_type_Choice\").css(\"display\",\"none\");",300)
		
		$("#Card_type").css("border-radius","5px");
		})	

	
	$(".card_item").mousedown(function(){
	
		var this_val=$(this).html();		
		$("#Card_type").val(this_val);
		$("#Card_type_Choice").css("display","none");
		
		
		})	

});



$(document).ready(function(){		
	Payment_Method(3);
	Choice_Quick(0);
	Choice_Bank(0);
	Choice_Platform(0);
	
	$("#back_box_1 img").click(function(){		
	
		var this_id=$(this).attr("id");
		var num=this_id.replace("Quick_","");		
		Choice_Quick(num);
		$("#payTypeSelected").val($(this).attr("way"));
//		$("#paySelectedBankCard").val($(this).attr("cardId"));
		})
	
	
	$("#back_box_2 img").click(function(){		
	
		var this_id=$(this).attr("id");
		var num=this_id.replace("Bank_","");		
		Choice_Bank(num);
		$("#payTypeSelected").val($(this).attr("way"));
		
		})
				
				
	$("#back_box_3 img").click(function(){		
	
		var this_id=$(this).attr("id");
		var num=this_id.replace("Platform_","");		
		Choice_Platform(num);
		$("#payTypeSelected").val($(this).attr("way"));
		
		})
		
	
	$(".titlie_li").click(function(){
	
		var this_title=$(this).attr("id");
		var num=this_title.replace("titlie_li_","");			
		
		Payment_Method(num);
		
		
		})
		
		
	
	})
	

function open_this()
{	
	$("#Suspension").show(1000);
	$("#Open").hide(1000);	
	
}
function put_away()
{
	$("#Suspension").hide(1000);
	$("#Open").show(1000);
	
}	



$(document).ready(function(){		
		
	$(".WeiZhuang_checkbox").click(function()	{	

		var this_id=$(this).attr("id");		
			
		
		var  checkbox_id=this_id.replace("WeiZhuang_checkbox_","");			
	
		if ($("#" + checkbox_id).val()=="0")
		{
			$(this).attr("class","checkbox_checked");				
			$("#"+ checkbox_id).val("1");	
		}
		else
		{
			$(this).attr("class","checkbox");			
			$("#"+ checkbox_id).val("0");
		}	
		
	})


});

function list_getpage_fill(data){
	data=data.split('~@#$sp%^&*');
	//刷新分页内容
	$('#list_con').html(data[0]);
	//刷新分页导航
	$('#nav_con').html(data[1]);
}
function pwdSafeLevel(pwdId,thing,safeId){
	$('#'+pwdId).bind(thing,function(){
		var width=0;
		var len = $(this).val().length;
		len >= 6 ? width += 20 : width += len*3;
		if(/\d+/.test($(this).val()) && len >= 6){
			width=width+20;
		}
		if(/[a-zA-Z]/.test($(this).val()) && len >= 6){
			width=width+20;
		}		
		if($(this).val().length>8){
			width=width+20;
		}	
		if($(this).val().length>10){
			width=width+20;
		}
		width = width > 100 ? 100 : width;
		document.getElementById(safeId).style.width = width+'%';	
		$('#'+safeId).attr('level',width);
	})
}