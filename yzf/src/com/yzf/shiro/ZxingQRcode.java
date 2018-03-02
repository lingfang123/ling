package com.yzf.shiro;

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
	// ͼƬ��ȵ�һ�� 
	private static final int IMAGE_WIDTH = 60; 
	private static final int IMAGE_HEIGHT = 60; 
	private static final int IMAGE_HALF_WIDTH = IMAGE_WIDTH / 2; 
	private static final int FRAME_WIDTH = 2; 
	  
	 // ��ά��д���� 
	private static MultiFormatWriter mutiWriter = new MultiFormatWriter(); 
	public void createQRcode(String content,String path,String codepath) {
		try {
			BufferedImage image = genBarcode(content, 160, 160, path);
			//���ض�ά��·��
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
	   // ��ȡԴͼ�� 
	   BufferedImage scaleImage = scale(srcImagePath, IMAGE_WIDTH, 
	       IMAGE_HEIGHT, true); 
	   int[][] srcPixels = new int[IMAGE_WIDTH][IMAGE_HEIGHT]; 
	   for (int i = 0; i < scaleImage.getWidth(); i++) { 
	     for (int j = 0; j < scaleImage.getHeight(); j++) { 
	       srcPixels[i][j] = scaleImage.getRGB(i, j); 
	     } 
	   } 
	  
	   Map<EncodeHintType, Object> hint = new HashMap<EncodeHintType, Object>(); 
	   hint.put(EncodeHintType.CHARACTER_SET, "utf-8"); //���ݱ���
	   hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);//����ȼ�
	   hint.put(EncodeHintType.MARGIN, 1); //���ö�ά����߿�Ŀհ�����Ŀ��
	   // ���ɶ�ά�� 
	   BitMatrix matrix = mutiWriter.encode(content, BarcodeFormat.QR_CODE, 
	       width, height, hint); 
	  
	   // ��ά����תΪһά�������� 
	   int halfW = matrix.getWidth() / 2; 
	   int halfH = matrix.getHeight() / 2; 
	   int[] pixels = new int[width * height]; 
	  
	   for (int y = 0; y < matrix.getHeight(); y++) { 
	     for (int x = 0; x < matrix.getWidth(); x++) { 
	       // ��ȡͼƬ 
	       if (x > halfW - IMAGE_HALF_WIDTH 
	           && x < halfW + IMAGE_HALF_WIDTH 
	           && y > halfH - IMAGE_HALF_WIDTH 
	           && y < halfH + IMAGE_HALF_WIDTH) { 
	         pixels[y * width + x] = srcPixels[x - halfW 
	             + IMAGE_HALF_WIDTH][y - halfH + IMAGE_HALF_WIDTH]; 
	       }  
	       // ��ͼƬ�����γɱ߿� 
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
	         // �˴������޸Ķ�ά�����ɫ�����Էֱ��ƶ���ά��ͱ�������ɫ�� 
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
	  * �Ѵ����ԭʼͼ�񰴸߶ȺͿ�Ƚ������ţ����ɷ���Ҫ���ͼ�� 
	  * 
	  * @param srcImageFile 
	  *      Դ�ļ���ַ 
	  * @param height 
	  *      Ŀ��߶� 
	  * @param width 
	  *      Ŀ���� 
	  * @param hasFiller 
	  *      ��������ʱ�Ƿ���Ҫ���ף�trueΪ����; falseΪ������; 
	  * @throws IOException 
	  */
	 private static BufferedImage scale(String srcImageFile, int height, 
	     int width, boolean hasFiller) throws IOException { 
	   double ratio = 0.0; // ���ű��� 
	   File file = new File(srcImageFile); 
	   BufferedImage srcImage = ImageIO.read(file); 
	   Image destImage = srcImage.getScaledInstance(width, height, 
	       BufferedImage.SCALE_SMOOTH); 
	   // ������� 
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
	   if (hasFiller) {// ���� 
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