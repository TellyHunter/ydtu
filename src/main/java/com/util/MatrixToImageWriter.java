package com.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
 

 import javax.imageio.ImageIO;

import java.io.File;
import java.io.OutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;
 
 
 public final class MatrixToImageWriter {
 
   private static final int BLACK = 0xFF000000;
   private static final int WHITE = 0xFFFFFFFF;
   
   public static void main(String[] args) {
	//boolean aa=ToMatrix("http://www.baidu.com", "c:", "aa");
	//System.out.println(aa);
}
   /**
    * 生成二维码
    * @param content   二维码内容
    * @param path  存储路径
    * @param name 不带后缀名
    * @return
    */
   public static BufferedImage ToMatrix(String content){

		try {
		     MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		     Map hints = new HashMap();
		     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		     BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400,hints);
		     return writeToFile(bitMatrix, "jpg");
		 } catch (Exception e) {
		     e.printStackTrace();
		 }
		 return null;
   }
   
   
   private MatrixToImageWriter() {}
 
   
   public static BufferedImage toBufferedImage(BitMatrix matrix) {
     int width = matrix.getWidth();
     int height = matrix.getHeight();
     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
     for (int x = 0; x < width; x++) {
       for (int y = 0; y < height; y++) {
         image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
       }
     }
     return image;
   }
 
   
   public static BufferedImage writeToFile(BitMatrix matrix, String format)
       throws IOException {
     BufferedImage image = toBufferedImage(matrix);
     return image;
   }
 
   
   public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)
       throws IOException {
     BufferedImage image = toBufferedImage(matrix);
     if (!ImageIO.write(image, format, stream)) {
       throw new IOException("Could not write an image of format " + format);
     }
   }
 
 }