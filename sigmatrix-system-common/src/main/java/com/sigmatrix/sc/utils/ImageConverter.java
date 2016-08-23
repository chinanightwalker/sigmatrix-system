package com.sigmatrix.sc.utils;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import net.sf.json.JSONObject;
/**
 * 图片缩放
 * 
 * <li>图片输出到本地.</li>
 * <li>gif 图片只输出第一帧图片.</li>
 * <li>为防止内存溢出，请增大jvm内存(推荐-Xmx1024m).</li>
 * <li>可处理20M左右大图片.</li>
 * 
 * @author lily200825
 * @date 2011-6-1
 */
public class ImageConverter {
	// 输出打印日志
	public static boolean IS_DEBUG = true;
	/*====================== 等比缩放，固定宽高 ======================*/
	/**
	 * 等比缩放图片
	 * 
	 * <li>按原图片等比缩放图片.</li>
	 * <li>缩放后的图片宽高小于固定宽高时，会有留白.</li>
	 * <li>缩放比例scale为空或scale<=0时，scale以固定宽高比例为准.</li>
	 * <li>缩放比例scale>0时，scale取最小缩放比例.</li>
	 * 
	 * @param imgSrc
	 *            原图片路径
	 * @param imgDest
	 *            输出图片路径
	 * @param scale
	 *            缩放比例
	 * @param fixed_width
	 *            固定宽
	 * @param fixed_height
	 *            固定高
	 * @throws Exception
	 */
	public static boolean zoomImage(String imgSrc, String imgDest, Float scale,
			Integer fixed_width, Integer fixed_height) throws Exception {
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return false;
		}
		File file = new File(imgSrc);
		if (file == null || file.exists() == false || file.isFile() == false) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：[" + imgSrc + "]文件不存在。。。");
			}
			return false;
		}
		return zoomImage(new FileInputStream(file), imgDest, scale,
				fixed_width, fixed_height);
	}

	/**
	 * 等比缩放图片
	 * 
	 * <li>按原图片等比缩放图片.</li>
	 * <li>缩放后的图片宽高小于固定宽高时，会有留白.</li>
	 * <li>缩放比例scale为空或scale<=0时，scale以固定宽高比例为准.</li>
	 * <li>缩放比例scale>0时，scale取最小缩放比例.</li>
	 * 
	 * @param input
	 *            原图片输入流
	 * @param imgDest
	 *            输出图片路径
	 * @param scale
	 *            缩放比例
	 * @param fixed_width
	 *            固定宽
	 * @param fixed_height
	 *            固定高
	 * @throws Exception
	 */
	public static boolean zoomImage(InputStream input, String imgDest,
			Float scale, Integer fixed_width, Integer fixed_height)
			throws Exception {
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return false;
		}
		if (input == null) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：输入流为空。。。");
			}
			return false;
		}
		return zoomImage(javax.imageio.ImageIO.read(input) ,imgDest, scale ,fixed_width, fixed_height);
	}
	
	public static JSONObject zoomImageNew(InputStream input, String imgDest,
			Float scale, Integer fixed_width, Integer fixed_height, String enterpriseDoc)
	throws Exception {
		JSONObject json = new JSONObject();
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return json;
		}
		if (input == null) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：输入流为空。。。");
			}
			return json;
		}
		return zoomImageNew(javax.imageio.ImageIO.read(input) ,imgDest, scale ,fixed_width, fixed_height, enterpriseDoc);
	}
	/**
	 * 等比缩放图片
	 * 
	 * <li>按原图片等比缩放图片.</li>
	 * <li>缩放后的图片宽高小于固定宽高时，会有留白.</li>
	 * <li>缩放比例scale为空或scale<=0时，scale以固定宽高比例为准.</li>
	 * <li>缩放比例scale>0时，scale取最小缩放比例.</li>
	 * 
	 * @param imginput
	 *            原图片输入流
	 * @param imgDest
	 *            输出图片路径
	 * @param scale
	 *            缩放比例
	 * @param fixed_width
	 *            固定宽
	 * @param fixed_height
	 *            固定高
	 * @throws Exception
	 */
	public static boolean zoomImage(ImageInputStream imginput, String imgDest,
			Float scale, Integer fixed_width, Integer fixed_height)
			throws Exception {
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return false;
		}
		if (imginput == null) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：图片输入流为空。。。");
			}
			return false;
		}
		return zoomImage(javax.imageio.ImageIO.read(imginput) ,imgDest, scale ,fixed_width, fixed_height);
	}

	public static boolean zoomImage(Image srcImage, String imgDest,
			Float scale, Integer fixed_width, Integer fixed_height)
			throws Exception {
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return false;
		}
		if (srcImage == null) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：不是有效的图片。。。");
			}
			return false;
		}
		int src_w = srcImage.getWidth(null); // 源图宽
		int src_h = srcImage.getHeight(null);// 源图高

		// ----------- 缩放比例 -----------
		// 缩放比例 为空时
		if (scale == null || scale <= 0) {
			if ((fixed_height == null||fixed_height==0) && fixed_width != null && fixed_width > 0) {
				// 以固定宽为准的缩放比例
				scale = fixed_width * 1.0F / src_w;
				// 输出图片-固定宽高
				fixed_width = (int) (src_w * scale);
				fixed_height = (int) (src_h * scale);
			} else if ((fixed_width == null || fixed_height == 0) && fixed_height != null
					&& fixed_height > 0) {
				// 以固定高为准的缩放比例
				scale = fixed_height * 1.0F / src_h;
				// 输出图片-固定宽高
				fixed_width = (int) (src_w * scale);
				fixed_height = (int) (src_h * scale);
			} else if (fixed_width != null && fixed_width != null
					&& fixed_width > 0 && fixed_height != null
					&& fixed_height != null && fixed_height > 0) {
				// 固定宽高时，取最小缩放比例
				scale = Math.min(fixed_width * 1.0F / src_w, fixed_height
						* 1.0F / src_h);
			} else {
				// 宽高为空或小于等于0时，默认缩放比例=1
				scale = 1F;
				fixed_width = (int) (src_w * scale);
				fixed_height = (int) (src_h * scale);
			}
		}
		// 缩放比例 不为空时
		else {
			if (fixed_height == null && fixed_width != null && fixed_width > 0) {
				// 以固定宽为准的缩放比例
				scale = Math.min(scale, fixed_width * 1.0F / src_w);
				// 输出图片-固定高
				fixed_height = (int) (src_h * fixed_width * 1.0F / src_w);
			} else if (fixed_width == null && fixed_height != null
					&& fixed_height > 0) {
				// 以固定高为准的缩放比例
				scale = Math.min(scale, fixed_height * 1.0F / src_h);
				// 输出图片-固定宽
				fixed_width = (int) (src_w * fixed_height * 1.0F / src_h);
			} else if (fixed_width != null && fixed_width != null
					&& fixed_width > 0 && fixed_height != null
					&& fixed_height != null && fixed_height > 0) {
				// 固定宽高时，取最小缩放比例
				scale = Math.min(fixed_width * 1.0F / src_w, fixed_height
						* 1.0F / src_h);
			} else {
				if ((long) (Math.max(src_w, src_h) * scale) > Integer.MAX_VALUE) {
					// 重置最大缩放比例
					scale = Integer.MAX_VALUE * 1.0F
							/ ((long) (Math.max(src_w, src_h) * scale));
				}
				// 输出图片-固定宽高
				fixed_width = (int) (src_w * scale);
				fixed_height = (int) (src_h * scale);
			}
		}
		// ----------- 输出图片的真实宽高 -----------
		int new_w = (int) (src_w * scale);
		int new_h = (int) (src_h * scale);
		// ----------- 图片根据长宽留白 -----------
		fixed_width = fixed_width <= 0 ? 1 : fixed_width;
		fixed_height = fixed_height <= 0 ? 1 : fixed_height;
		new_w = new_w <= 0 ? 1 : new_w;
		new_h = new_h <= 0 ? 1 : new_h;
		int imgType = BufferedImage.TYPE_INT_RGB;
		String extName = imgDest.substring(imgDest.lastIndexOf(".")+1);
		if ("png".equals(extName.toLowerCase())) {
			imgType = BufferedImage.TYPE_INT_ARGB;
		}
		BufferedImage destImage = new BufferedImage(fixed_width, fixed_height,
				imgType);
//		Graphics2D g = destImage.createGraphics();
//		g.setColor(Color.white);
//		g.fillRect(0, 0, fixed_width, fixed_height);
		if (imgType==BufferedImage.TYPE_INT_RGB) {//jpg
			Graphics2D g = destImage.createGraphics();
			g.setColor(Color.white);
			g.fillRect(0, 0, fixed_width, fixed_height);
			g.drawImage(srcImage, (fixed_width - new_w) / 2,
					(fixed_height - new_h) / 2, new_w, new_h,Color.WHITE, null);
		}else if (imgType==BufferedImage.TYPE_INT_ARGB) {
			Graphics g = destImage.getGraphics();
			g.drawImage(srcImage, (fixed_width - new_w) / 2,
					(fixed_height - new_h) / 2, new_w, new_h, null);
		}
		/**
		 * @author wjt
		 * 存储图片到S3服务器
		 * 在应用服务器上生成临时文件，保存到S3后，将临时文件删除
		 */
		//临时文件路径
		String tempFilePath = imgDest.replace(imgDest.split("/")[imgDest.split("/").length-1], "");
		File file=new File(tempFilePath);
		//创建临时文件
		String jpgName = imgDest.split("/")[imgDest.split("/").length-1];
		File tmpFile = File.createTempFile(jpgName.split("\\.")[0], ".jpg",file);
		FileWriter fout = new FileWriter(tmpFile);
        PrintWriter out = new PrintWriter(fout);
        out.close(); //注意：如无此关闭语句，文件将不能删除
		//将绘制后的图片写入临时文件
        ImageIO.write(destImage,extName , tmpFile);
		//保存到S3
//		AmazonUtil amazonUtil = new AmazonUtil();
//		String key = "system-marketing-platform/images/activity"+jpgName;
//		System.out.println(key);
//		amazonUtil.saveFile(key, file);
        //删除临时图片文件
        tmpFile.delete(); 
		if (IS_DEBUG) {
			System.out.println("等比缩放图片：原图片宽高为[" + src_w + " ¡Á　" + src_h
					+ "]，输出图片的固定宽高为[" + fixed_width + " ¡Á　" + fixed_height
					+ "]，输出图片的真实宽高为[" + new_w + " ¡Á　" + new_h 
					+ "]，缩放比例为[" + scale + "].");
		}
		return true;
	}
	
	
	public static JSONObject zoomImageNew(Image srcImage, String imgDest,
			Float scale, Integer fixed_width, Integer fixed_height, String enterpriseDoc)
	throws Exception {
		JSONObject json = new JSONObject();
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return json;
		}
		if (srcImage == null) {
			if (IS_DEBUG) {
				System.err.println("等比缩放图片：不是有效的图片。。。");
			}
			return json;
		}
		int src_w = srcImage.getWidth(null); // 源图宽
		int src_h = srcImage.getHeight(null);// 源图高
		
		// ----------- 缩放比例 -----------
		// 缩放比例 为空时
		if (scale == null || scale <= 0) {
			if ((fixed_height == null||fixed_height==0) && fixed_width != null && fixed_width > 0) {
				// 以固定宽为准的缩放比例
				scale = fixed_width * 1.0F / src_w;
				// 输出图片-固定宽高
				fixed_width = (int) (src_w * scale);
				fixed_height = (int) (src_h * scale);
			} else if ((fixed_width == null || fixed_height == 0) && fixed_height != null
					&& fixed_height > 0) {
				// 以固定高为准的缩放比例
				scale = fixed_height * 1.0F / src_h;
				// 输出图片-固定宽高
				fixed_width = (int) (src_w * scale);
				fixed_height = (int) (src_h * scale);
			} else if (fixed_width != null && fixed_width != null
					&& fixed_width > 0 && fixed_height != null
					&& fixed_height != null && fixed_height > 0) {
				// 固定宽高时，取最小缩放比例
				scale = Math.min(fixed_width * 1.0F / src_w, fixed_height
						* 1.0F / src_h);
			} else {
				// 宽高为空或小于等于0时，默认缩放比例=1
				scale = 1F;
				fixed_width = (int) (src_w * scale);
				fixed_height = (int) (src_h * scale);
			}
		}
		// 缩放比例 不为空时
		else {
			if (fixed_height == null && fixed_width != null && fixed_width > 0) {
				// 以固定宽为准的缩放比例
				scale = Math.min(scale, fixed_width * 1.0F / src_w);
				// 输出图片-固定高
				fixed_height = (int) (src_h * fixed_width * 1.0F / src_w);
			} else if (fixed_width == null && fixed_height != null
					&& fixed_height > 0) {
				// 以固定高为准的缩放比例
				scale = Math.min(scale, fixed_height * 1.0F / src_h);
				// 输出图片-固定宽
				fixed_width = (int) (src_w * fixed_height * 1.0F / src_h);
			} else if (fixed_width != null && fixed_width != null
					&& fixed_width > 0 && fixed_height != null
					&& fixed_height != null && fixed_height > 0) {
				// 固定宽高时，取最小缩放比例
				scale = Math.min(fixed_width * 1.0F / src_w, fixed_height
						* 1.0F / src_h);
			} else {
				if ((long) (Math.max(src_w, src_h) * scale) > Integer.MAX_VALUE) {
					// 重置最大缩放比例
					scale = Integer.MAX_VALUE * 1.0F
					/ ((long) (Math.max(src_w, src_h) * scale));
				}
				// 输出图片-固定宽高
				fixed_width = (int) (src_w * scale);
				fixed_height = (int) (src_h * scale);
			}
		}
		// ----------- 输出图片的真实宽高 -----------
		int new_w = (int) (src_w * scale);
		int new_h = (int) (src_h * scale);
		// ----------- 图片根据长宽留白 -----------
		fixed_width = fixed_width <= 0 ? 1 : fixed_width;
		fixed_height = fixed_height <= 0 ? 1 : fixed_height;
		new_w = new_w <= 0 ? 1 : new_w;
		new_h = new_h <= 0 ? 1 : new_h;
		int imgType = BufferedImage.TYPE_INT_RGB;
		String extName = imgDest.substring(imgDest.lastIndexOf(".")+1);
		if ("png".equals(extName.toLowerCase())) {
			imgType = BufferedImage.TYPE_INT_ARGB;
		}
		BufferedImage destImage = new BufferedImage(fixed_width, fixed_height,
				imgType);
//		Graphics2D g = destImage.createGraphics();
//		g.setColor(Color.white);
//		g.fillRect(0, 0, fixed_width, fixed_height);
		if (imgType==BufferedImage.TYPE_INT_RGB) {//jpg
			Graphics2D g = destImage.createGraphics();
			g.setColor(Color.white);
			g.fillRect(0, 0, fixed_width, fixed_height);
			g.drawImage(srcImage, (fixed_width - new_w) / 2,
					(fixed_height - new_h) / 2, new_w, new_h,Color.WHITE, null);
		}else if (imgType==BufferedImage.TYPE_INT_ARGB) {
			Graphics g = destImage.getGraphics();
			g.drawImage(srcImage, (fixed_width - new_w) / 2,
					(fixed_height - new_h) / 2, new_w, new_h, null);
		}
		/**
		 * @author wjt
		 * 存储图片到S3服务器
		 * 在应用服务器上生成临时文件，保存到S3后，将临时文件删除
		 */
		//临时文件路径
		String tempFilePath = imgDest.replace(imgDest.split("/")[imgDest.split("/").length-1], "");
		File file=new File(tempFilePath);
		//创建临时文件
		String jpgName = imgDest.split("/")[imgDest.split("/").length-1];
		File tmpFile = File.createTempFile(jpgName.split("\\.")[0], ".jpg",file);
		FileWriter fout = new FileWriter(tmpFile);
		PrintWriter out = new PrintWriter(fout);
		out.close(); //注意：如无此关闭语句，文件将不能删除
		//将绘制后的图片写入临时文件
		ImageIO.write(destImage,extName , tmpFile);
		//保存到S3
		AmazonUtil amazonUtil = new AmazonUtil();
		String key = enterpriseDoc+"/system-marketing-platform"+tempFilePath+jpgName;
		amazonUtil.savePublicFile(key, tmpFile);
		json.put("status", "ok");
		json.put("key", key);
		//删除临时图片文件
		tmpFile.delete(); 
		if (IS_DEBUG) {
			System.out.println("等比缩放图片：原图片宽高为[" + src_w + " ¡Á　" + src_h
					+ "]，输出图片的固定宽高为[" + fixed_width + " ¡Á　" + fixed_height
					+ "]，输出图片的真实宽高为[" + new_w + " ¡Á　" + new_h 
					+ "]，缩放比例为[" + scale + "].");
		}
		return json;
	}
	/*
	 * ====================== 非等比缩放 ======================
	 */
	/**
	 * 非等比缩放图片
	 * <li>读取文件</li>
	 * 
	 * @param imgSrc
	 *            原图片路径
	 * @param imgDest
	 *            输出图片路径
	 * @param fixed_width
	 *            固定宽(默认原图片宽)
	 * @param fixed_height
	 *            固定高(默认原图片高)
	 * @return
	 * @throws Exception
	 */
	public static boolean zoomImage(File file, String imgDest,
			Integer fixed_width, Integer fixed_height) throws Exception {
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("非等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return false;
		}
		return zoomImage(new FileInputStream(file), imgDest, fixed_width, fixed_height);
	}

	/**
	 * 非等比缩放图片
	 * <li>读取字节输入流</li>
	 * 
	 * @param input
	 *            字节输入流
	 * @param imgDest
	 *            输出图片路径
	 * @param fixed_width
	 *            固定宽(默认原图片宽)
	 * @param fixed_height
	 *            固定高(默认原图片高)
	 * @return
	 * @throws Exception
	 */
	public static boolean zoomImage(InputStream input, String imgDest,
			Integer fixed_width, Integer fixed_height) throws Exception {
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("非等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return false;
		}
		if (input == null) {
			if (IS_DEBUG) {
				System.err.println("非等比缩放图片：输入流为空。。。");
			}
			return false;
		}
		return zoomImage(javax.imageio.ImageIO.read(input) ,imgDest ,fixed_width ,fixed_height);
	}

	/**
	 * 非等比缩放图片
	 * <li>读取图片输入流</li>
	 * 
	 * @param imginput
	 *            图片输入流
	 * @param imgDest
	 *            输出图片路径
	 * @param fixed_width
	 *            固定宽(默认原图片宽)
	 * @param fixed_height
	 *            固定高(默认原图片高)
	 * @return
	 * @throws Exception
	 */
	public static boolean zoomImage(ImageInputStream imginput, String imgDest,
			Integer fixed_width, Integer fixed_height) throws Exception {
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("非等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return false;
		}
		if (imginput == null) {
			if (IS_DEBUG) {
				System.err.println("非等比缩放图片：图片输入流为空。。。");
			}
			return false;
		}
		return zoomImage(javax.imageio.ImageIO.read(imginput) ,imgDest ,fixed_width ,fixed_height);
	}
	
	public static boolean zoomImage(Image srcImage, String imgDest,
			Integer fixed_width, Integer fixed_height) throws Exception {
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("非等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return false;
		}
		if (srcImage == null) {
			if (IS_DEBUG) {
				System.err.println("非等比缩放图片：不是有效的图片。。。");
			}
			return false;
		}
		int src_w = srcImage.getWidth(null); // 源图宽
		int src_h = srcImage.getHeight(null);// 源图高

		// 固定输出图片的宽高
		if (fixed_width == null || fixed_width <= 0) {
			fixed_width = src_w;
		}
		if (fixed_height == null || fixed_height <= 0) {
			fixed_height = src_h;
		}
		// 重绘图片
		BufferedImage destImage = new BufferedImage(fixed_width, fixed_height,
				BufferedImage.TYPE_INT_RGB);
//		destImage.getGraphics().setColor(Color.WHITE);
		destImage.getGraphics().drawImage(srcImage, 0, 0, fixed_width,
				fixed_height,Color.WHITE, null);
		// 输出图片
		FileOutputStream out = new FileOutputStream(imgDest);
		ImageIO.write(destImage, "JPEG", out);
		out.close();
		if (IS_DEBUG) {
//			System.out.println("非等比缩放图片：原图片宽高为[" + src_w + " ¡Á　" + src_h
//					+ "]，输出图片的宽高为[" + fixed_width + " ¡Á　" + fixed_height +"].") ;
		}
		return true;
	}
	
	public static boolean zoomImageNew(File file, String imgDest,
			Integer fixed_width, Integer fixed_height) throws Exception {
		if (imgDest == null || imgDest.trim().length() == 0) {
			if (IS_DEBUG) {
				System.err.println("非等比缩放图片：输出图片路径[" + imgDest + "]错误。。。");
			}
			return false;
		}
		if (file == null) {
			if (IS_DEBUG) {
				System.err.println("非等比缩放图片：不是有效的图片。。。");
			}
			return false;
		}
		Image srcImage = ImageIO.read(new FileInputStream(file));
		int src_w = srcImage.getWidth(null); // 源图宽
		int src_h = srcImage.getHeight(null);// 源图高
		
		// 固定输出图片的宽高
		if (fixed_width == null || fixed_width <= 0) {
			fixed_width = src_w;
		}
		if (fixed_height == null || fixed_height <= 0) {
			fixed_height = src_h;
		}
		// 重绘图片
		String extName = imgDest.substring(imgDest.lastIndexOf(".")+1);
		int imageType = 1;
		if ("png".equals(extName)) {
			imageType = 2;
		}
		BufferedImage destImage = new BufferedImage(fixed_width, fixed_height,
				imageType);
//		destImage.getGraphics().setColor(Color.WHITE);
		destImage.getGraphics().drawImage(srcImage, 0, 0, fixed_width,
				fixed_height, null);
		// 输出图片
		ImageIO.write(destImage, extName, new File(imgDest));  
//		FileOutputStream out = new FileOutputStream(imgDest);
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//		encoder.encode(destImage);
//		out.close();
		if (IS_DEBUG) {
//			System.out.println("非等比缩放图片：原图片宽高为[" + src_w + " ¡Á　" + src_h
//					+ "]，输出图片的宽高为[" + fixed_width + " ¡Á　" + fixed_height +"].") ;
		}
		return true;
	}
}
