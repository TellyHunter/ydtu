package com.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.util.OutUtil; 
 
@RestController
public class CodeController { 
	
    private int width = 108;//定义图片的width  
    private int height = 24;//定义图片的height  
    private int codeCount = 4;//定义图片上显示验证码的个数  
    private int xx = 18; 
    private int fontHeight = 22; 
    private int codeY = 19; 
    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 
            'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' }; 
 
    @RequestMapping("/code") 
    public void getCode(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException { 
 
        // 定义图像buffer  
        BufferedImage buffImg = new BufferedImage(width, height, 
                BufferedImage.TYPE_INT_RGB); 
//      Graphics2D gd = buffImg.createGraphics();  
        //Graphics2D gd = (Graphics2D) buffImg.getGraphics();  
        Graphics gd = buffImg.getGraphics(); 
        // 创建一个随机数生成器类  
        Random random = new Random(); 
        // 将图像填充为白色  
        gd.setColor(Color.WHITE); 
        gd.fillRect(0, 0, width, height); 
 
        // 创建字体，字体的大小应该根据图片的高度来定。  
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight); 
        // 设置字体。  
        gd.setFont(font); 
 
        // 画边框。  
        gd.setColor(Color.white); 
        gd.drawRect(0, 0, width - 1, height - 1); 
 
        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。  
        gd.setColor(Color.BLACK); 
//        for (int i = 0; i < 40; i++) { 
//            int x = random.nextInt(width); 
//            int y = random.nextInt(height); 
//            int xl = random.nextInt(12); 
//            int yl = random.nextInt(12); 
//            gd.drawLine(x, y, x + xl, y + yl); 
//        } 
// 
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。  
        StringBuffer randomCode = new StringBuffer(); 
        int red = 0, green = 0, blue = 0; 
 
        // 随机产生codeCount数字的验证码。  
        for (int i = 0; i < codeCount; i++) { 
            // 得到随机产生的验证码数字。  
            String code = String.valueOf(codeSequence[random.nextInt(32)]); 
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。  
            /*red = random.nextInt(255); 
            green = random.nextInt(255); 
            blue = random.nextInt(255);*/ 
            red=51;
            green=52;
            blue=56;
            // 用随机产生的颜色将验证码绘制到图像中。  
            gd.setColor(new Color(red, green, blue)); 
            gd.drawString(code, (i + 1) * xx, codeY); 
 
            // 将产生的四个随机数组合在一起。  
            randomCode.append(code); 
        } 
        // 将四位数字的验证码保存到Session中。  
        HttpSession session = req.getSession(); 
//        System.out.print(randomCode); 
        session.setAttribute("code", randomCode.toString()); 
        // 禁止图像缓存。  
        resp.setHeader("pragma", "no-cache"); 
        resp.setHeader("Cache-Control", "no-cache"); 
        resp.setDateHeader("expires", 0); 
 
        resp.setContentType("image/jpeg"); 
 
        // 将图像输出到Servlet输出流中。  
        ServletOutputStream sos = resp.getOutputStream(); 
        ImageIO.write(buffImg, "jpeg", sos); 
        sos.flush();
        sos.close(); 
    } 
	@RequestMapping("/getValidateCode")
	public void getValidateCode(HttpServletRequest request,HttpServletResponse response){
		String code = (String) request.getSession().getAttribute("code");
		Gson gson = new Gson();
		String resutlString = gson.toJson(code);
		request.getSession().removeAttribute("code");
	    OutUtil.ajax_return(response, resutlString);
	}
} 