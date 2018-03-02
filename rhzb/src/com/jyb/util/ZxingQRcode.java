package com.jyb.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZxingQRcode {
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;
	// 图片宽度的一般 
	private static final int IMAGE_WIDTH = 60; 
	private static final int IMAGE_HEIGHT = 60; 
	private static final int IMAGE_HALF_WIDTH = IMAGE_WIDTH / 2; 
	private static final int FRAME_WIDTH = 2; 
	  
	 // 二维码写码器 
	private static MultiFormatWriter mutiWriter = new MultiFormatWriter(); 
	// content二维码内容		pathe二维码中间小图标		codepath二维码保存路径
	public void createQRcode(String content,String path,String codepath) {
		try {
			BufferedImage image = genBarcode(content, 200, 200, path);
			//返回二维码路径
			codepath = codepath + ".png";
			if (!ImageIO.write(image, "jpg", new File(codepath))) {
				throw new IOException("Could not write an image of format ");
			}
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private BufferedImage toBufferedImage(BitMatrix matrix) {
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
	private static BufferedImage genBarcode(String content, int width, 
	     int height, String srcImagePath) throws WriterException, 
	     IOException { 
	   // 读取源图像 
	   BufferedImage scaleImage = scale(srcImagePath, IMAGE_WIDTH, 
	       IMAGE_HEIGHT, true); 
	   int[][] srcPixels = new int[IMAGE_WIDTH][IMAGE_HEIGHT]; 
	   for (int i = 0; i < scaleImage.getWidth(); i++) { 
	     for (int j = 0; j < scaleImage.getHeight(); j++) { 
	       srcPixels[i][j] = scaleImage.getRGB(i, j); 
	     } 
	   } 
	  
	   Map<EncodeHintType, Object> hint = new HashMap<EncodeHintType, Object>(); 
	   hint.put(EncodeHintType.CHARACTER_SET, "utf-8"); //内容编码
	   hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);//错误等级
	   hint.put(EncodeHintType.MARGIN, 1); //设置二维码外边框的空白区域的宽度
	   // 生成二维码 
	   BitMatrix matrix = mutiWriter.encode(content, BarcodeFormat.QR_CODE, 
	       width, height, hint); 
	  
	   // 二维矩阵转为一维像素数组 
	   int halfW = matrix.getWidth() / 2; 
	   int halfH = matrix.getHeight() / 2; 
	   int[] pixels = new int[width * height]; 
	  
	   for (int y = 0; y < matrix.getHeight(); y++) { 
	     for (int x = 0; x < matrix.getWidth(); x++) { 
	       // 读取图片 
	       if (x > halfW - IMAGE_HALF_WIDTH 
	           && x < halfW + IMAGE_HALF_WIDTH 
	           && y > halfH - IMAGE_HALF_WIDTH 
	           && y < halfH + IMAGE_HALF_WIDTH) { 
	         pixels[y * width + x] = srcPixels[x - halfW 
	             + IMAGE_HALF_WIDTH][y - halfH + IMAGE_HALF_WIDTH]; 
	       }  
	       // 在图片四周形成边框 
	       else if ((x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH 
	           && x < halfW - IMAGE_HALF_WIDTH + FRAME_WIDTH 
	           && y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH 
	           + IMAGE_HALF_WIDTH + FRAME_WIDTH) 
	           || (x > halfW + IMAGE_HALF_WIDTH - FRAME_WIDTH 
	               && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH 
	               && y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH 
	               + IMAGE_HALF_WIDTH + FRAME_WIDTH) 
	           || (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH 
	               && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH 
	               && y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH 
	               - IMAGE_HALF_WIDTH + FRAME_WIDTH) 
	           || (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH 
	               && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH 
	               && y > halfH + IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH 
	               + IMAGE_HALF_WIDTH + FRAME_WIDTH)) { 
	         pixels[y * width + x] = 0xfffffff; 
	       } else { 
	         // 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色； 
	         pixels[y * width + x] = matrix.get(x, y) ? 0xff000000
	             : 0xfffffff; 
	       } 
	     } 
	   } 
	  
	   BufferedImage image = new BufferedImage(width, height, 
	       BufferedImage.TYPE_INT_RGB); 
	   image.getRaster().setDataElements(0, 0, width, height, pixels); 
	  
	   return image; 
	 } 
	  
	 /** 
	  * 把传入的原始图像按高度和宽度进行缩放，生成符合要求的图标 
	  * 
	  * @param srcImageFile 
	  *      源文件地址 
	  * @param height 
	  *      目标高度 
	  * @param width 
	  *      目标宽度 
	  * @param hasFiller 
	  *      比例不对时是否需要补白：true为补白; false为不补白; 
	  * @throws IOException 
	  */
	 private static BufferedImage scale(String srcImageFile, int height, 
	     int width, boolean hasFiller) throws IOException { 
	   double ratio = 0.0; // 缩放比例 
	   File file = new File(srcImageFile); 
	   BufferedImage srcImage = ImageIO.read(file); 
	   Image destImage = srcImage.getScaledInstance(width, height, 
	       BufferedImage.SCALE_SMOOTH); 
	   // 计算比例 
	   if ((srcImage.getHeight() > height) || (srcImage.getWidth() > width)) { 
	     if (srcImage.getHeight() > srcImage.getWidth()) { 
	       ratio = (new Integer(height)).doubleValue() 
	           / srcImage.getHeight(); 
	     } else { 
	       ratio = (new Integer(width)).doubleValue() 
	           / srcImage.getWidth(); 
	     } 
	     AffineTransformOp op = new AffineTransformOp( 
	         AffineTransform.getScaleInstance(ratio, ratio), null); 
	     destImage = op.filter(srcImage, null); 
	   } 
	   if (hasFiller) {// 补白 
	     BufferedImage image = new BufferedImage(width, height, 
	         BufferedImage.TYPE_INT_RGB); 
	     Graphics2D graphic = image.createGraphics(); 
	     graphic.setColor(Color.PINK); 
	     graphic.fillRect(10, 10, width, height); 
	     graphic.drawRect(100, 360, width, height);
	     if (width == destImage.getWidth(null)) { 
	       graphic.drawImage(destImage, 0, 
	           (height - destImage.getHeight(null)) / 2, 
	           destImage.getWidth(null), destImage.getHeight(null), 
	           Color.white, null); 
	       Shape shape = new RoundRectangle2D.Float(0, (height - destImage.getHeight(null)) / 2, width, width, 20, 20);
	       graphic.setStroke(new BasicStroke(5f));
	       graphic.draw(shape);
	     }
	     else {
	       graphic.drawImage(destImage, 
	           (width - destImage.getWidth(null)) / 2, 0, 
	           destImage.getWidth(null), destImage.getHeight(null), 
	           Color.white, null);
	       Shape shape = new RoundRectangle2D.Float((width - destImage.getWidth(null)) / 2, 0, width, width, 20, 20);
	       graphic.setStroke(new BasicStroke(5f));
	       graphic.draw(shape);
	     }
	     graphic.dispose(); 
	     destImage = image; 
	   } 
	   return (BufferedImage) destImage; 
	 } 
}