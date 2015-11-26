package com.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.AlipayDTO;
import com.bean.Charge;
import com.bean.ChargeExample;
import com.bean.TMember;
import com.bean.WxPayDto;
import com.google.zxing.WriterException;
import com.mapper.ChargeMapper;
import com.service.auth.Permission;
import com.util.AlipayBankUtil;
import com.util.AlipayUtil;
import com.util.AlipayWapUtil;
import com.util.MatrixToImageWriter;
import com.util.OutUtil;
import com.util.WeixinUtil;

@Controller
public class PaymentController {

	@Autowired
	private ChargeMapper chargeDAO;

	/**
	 * 
	 * @throws Exception 
	 * @描述: 余额充值微信二维码、支付宝支付页面
	 * @作者: john
	 */
	@Permission
	@RequestMapping("/custom/charge.htm")
	public void charge(String orderId, String payway, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TMember tMember = (TMember) request.getSession().getAttribute("user");
		ChargeExample chargeExample = new ChargeExample();
		chargeExample.createCriteria().andOrderIdEqualTo(orderId);
		List<Charge> charges=chargeDAO.selectByExample(chargeExample);
		Charge charge=charges.get(0);
		BigDecimal amount = charge.getAmount();
		
		
		if(charges!=null&&charges.size()>0){
			String codeurl = "";
			//生成存放二维码的路径
			if("0".equals(payway)){
				String openid=tMember.getOpenid();
				InetAddress netAddress = InetAddress.getLocalHost();
				String localHostString = netAddress.getHostAddress();
				System.out.println(localHostString);
				WxPayDto tpWxPay = new WxPayDto();
				tpWxPay.setOpenId(openid);
				tpWxPay.setBody("停车一道通");
				tpWxPay.setOrderId(orderId);
				tpWxPay.setSpbillCreateIp(localHostString);
				tpWxPay.setTotalFee(charge.getAmount()+"");
				tpWxPay.setAttach("1,"+ charge.getId());
				codeurl = WeixinUtil.getCodeurl(tpWxPay);
				System.out.println("codeurl"+codeurl);
				StringBuffer ssString=new StringBuffer("");
				String param="codeurl="+codeurl+"&amount="+amount+"&orderId="+orderId;
				Base64 base64=new Base64();  
		        byte[] b=base64.encode(param.getBytes());   
		        param=new String(b);
				String href=OutUtil.basePath+"/page/custom/payment_charge.html?"+param;
				ssString.append("<script>location.href='"+href+"';</script>");
				OutUtil.ajax_return(response, ssString.toString());
			}else if("1".equals(payway)){
				//支付包支付
				AlipayDTO alipayDTO=new AlipayDTO();
				alipayDTO.setWIDout_trade_no(orderId);
				alipayDTO.setWIDtotal_fee(String.valueOf(amount));
				alipayDTO.setWIDbody(new String("停车一道通".getBytes("utf-8"), "ISO-8859-1"));
				alipayDTO.setWIDsubject(new String("停车一道通".getBytes("utf-8"), "ISO-8859-1"));
				alipayDTO.setWIDshow_url("");
				String ssString=AlipayUtil.alipay_pc(alipayDTO, response);
				OutUtil.ajax_return(response, ssString);
			}
			else {
				//银行卡支付
				AlipayDTO alipayDTO=new AlipayDTO();
				alipayDTO.setWIDout_trade_no(orderId);
				alipayDTO.setWIDtotal_fee(amount+"");
				alipayDTO.setWIDbody(new String("停车一道通".getBytes("utf-8"), "ISO-8859-1"));
				alipayDTO.setWIDsubject(new String("停车一道通".getBytes("utf-8"), "ISO-8859-1"));
				alipayDTO.setWIDshow_url("");
				alipayDTO.setWIDdefaultbank(payway);
				String ssString=AlipayBankUtil.pay(alipayDTO, response);
				OutUtil.ajax_return(response, ssString);
			}
		}
	}
	@Permission
	@RequestMapping("/custom/getWeixinImg")
	public void getWeixinImg(HttpServletResponse resp,String codeurl) throws IOException, WriterException{
	     BufferedImage image = MatrixToImageWriter.ToMatrix(codeurl);
		  // 将图像输出到Servlet输出流中。  
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(image, "jpg", sos); 
        sos.flush();
        sos.close(); 
	}
	/**
	 * 手机端如果不是微信浏览器就会调用该方法执行支付宝支付 
	 * @param request
	 * @param response
	 * @param amount 支付金额
	 * @throws IOException
	 * @throws SQLException
	 */
	@RequestMapping("/phoneAlipayWapDemo.htm")
	public void alipayWapDemo(HttpServletRequest request,HttpServletResponse response,String orderId) throws IOException, SQLException{
		ChargeExample chargeExample = new ChargeExample();
		chargeExample.createCriteria().andOrderIdEqualTo(orderId);
		List<Charge> charges=chargeDAO.selectByExample(chargeExample);
		if(charges!=null&&charges.size()>0){
			AlipayDTO alipayDTO=new AlipayDTO();
			alipayDTO.setWIDout_trade_no(orderId);
			alipayDTO.setWIDtotal_fee(charges.get(0).getAmount()+"");
			alipayDTO.setWIDbody(new String("停车一道通".getBytes("utf-8"), "ISO-8859-1"));
			alipayDTO.setWIDsubject(new String("停车一道通".getBytes("utf-8"), "ISO-8859-1"));
			alipayDTO.setWIDshow_url("");
			String ssString=AlipayWapUtil.pay(alipayDTO, response);
			System.out.println("支付宝手机支付："+ssString);
			OutUtil.ajax_return(response, ssString);
		}
		else{
			OutUtil.ajax_return(response, "无此订单号");
		}
	}
}
