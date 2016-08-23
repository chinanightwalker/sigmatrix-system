package com.sigmatrix.sc.web.controller.product;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sigmatrix.sc.utils.ImageConverter;
import com.sigmatrix.sc.utils.RandomBuilder;
import com.sigmatrix.sc.web.controller.common.BaseController;

import net.sf.json.JSONObject;

/**
  * @author zyc 作者 E-mail: 
  * @date 创建时间：2016年7月20日 下午1:35:53
  * @version 1.0
  * @parameter
  * @since
  * @return
  */
@Controller
@RequestMapping(value="/uploadPic")
public class UploadPicController extends BaseController {

	private static Logger logger = Logger.getLogger(ScancodeTransitionController.class);
	@Value("${amazon.s3.url}")
	private String s3_prefix; // S3前缀
	@Value("${amazon.s3.bucket}")
	private String s3_suffix; // S3后缀
	@Value("${pic.path}")
	private String picPath;//resource中图片位置
	
	public static final String FILE_BMP = ".bmp";

	public static final String FILE_GIF = ".gif";

	public static final String FILE_PNG = ".png";

	public static final String FILE_JPG = ".jpg";

	public static final String FILE_JPEG = ".jpeg";
	
	
	private String fileFileName;
	protected String fileUrl;
	protected String error = null;
	protected String fileDir;
	private int width;
	private int height;
	private File file;
	private String enterpriseDoc;
	
	@RequestMapping(value="/upload")
	public void upload(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="file",required=false)MultipartFile multfile
){
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		this.fileFileName = multfile.getOriginalFilename();
		PrintWriter out = null;
		Map<String, String> res = new HashMap<String, String>();
		try {
			doUpLoadNew(multfile,request);
			out =response.getWriter();
			res.put("error", error);
			res.put("fileDir", fileDir);
			res.put("fileUrl", fileUrl);
		} catch (RuntimeException e) {
			res.put("error", "连接超时！");
			e.printStackTrace();
		} catch (Exception e) {
			res.put("error", "服务异常！");
			e.printStackTrace();
		}
		out.write(JSONObject.fromObject(res).toString());
		out.flush();
		out.close();
	}
	
	private void doUpLoadNew(MultipartFile file,HttpServletRequest request) throws Exception {
		if (!isImageFile(fileFileName)) {// 文件类型
			error = "文件类型错误，只能上传图片！";
			return;
		}
		fileFileName = getCurrentDateStr() + RandomBuilder.getRandomDigitalString(6)
				+ fileFileName.substring(fileFileName.lastIndexOf("."));
		
//		String dirPath = mkdir(Constants.pic_path);
//		String dirPath = s3_prefix + s3_suffix;
		String dirPath = picPath;
		
		if (dirPath == null) {
			error = "文件路径错误！";
			return;
		}
		ImageConverter ic = new ImageConverter();
		enterpriseDoc = getEnterpriseCode(request);
		String key = "";
		try {
			JSONObject json = ic.zoomImageNew(new ByteArrayInputStream(file.getBytes()), dirPath + fileFileName, null, width, height,enterpriseDoc);
			if (json.get("status")!=null&&!"".equals(json.get("status"))) {
				if (json.get("status")=="ok"||"ok".equals(json.get("status"))) {
					if (json.get("key")!=null&&!"".equals(json.get("key"))) {
						key = json.getString("key");
					}
				}
			}
		} catch (Exception e) {
			logger.error("上传失败",e);
			error = "文件不存在！";
			return;
		}
		//物理地址
//		fileDir = dirPath + fileFileName;
//		fileDir = s3_prefix + s3_suffix + key;
		fileDir = s3_prefix+s3_suffix+"/" + key;
		//url
//		fileUrl = Constants.pic_url +key;
		fileUrl = key;
		
	}
	
	
	
	/**
	 * 上传文件是否是图片
	 */
	public static final boolean isImageFile(String fileName) {
		if (fileName == null) {
			return false;
		} else if (fileName.trim().toLowerCase().endsWith(FILE_BMP)) {
			return true;
		} else if (fileName.trim().toLowerCase().endsWith(FILE_GIF)) {
			return true;
		} else if (fileName.trim().toLowerCase().endsWith(FILE_PNG)) {
			return true;
		} else if (fileName.trim().toLowerCase().endsWith(FILE_JPG)
				|| fileName.trim().toLowerCase().endsWith(FILE_JPEG)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 按年月建目录
	 */
	public static String mkdir(String path) {
		if (path == null) {
			return null;
		} else {
			if (!path.endsWith("\\") && !path.endsWith("/")) {
				path += "/";
			}
			File file = new File(path);
			if (file == null) {
				return null;
			} else if (!file.exists()) {
				if (!file.mkdir()) {
					return null;
				}
			}
			Calendar cal = Calendar.getInstance();
			int iyear = cal.get(Calendar.YEAR);
			int imonth = cal.get(Calendar.MONTH) + 1;
			String filePath = path + iyear + "/";
			file = new File(filePath);
			if (file == null) {
				return null;
			} else if (!file.exists()) {
				if (!file.mkdir()) {
					return null;
				}
			}
			if (imonth < 10) {
				filePath += "0";
			}
			filePath += imonth;
			filePath += "/";
			file = new File(filePath);
			if (file == null) {
				return null;
			} else if (!file.exists()) {
				if (!file.mkdir()) {
					return null;
				}
			}
			return filePath;
		}
	}

	private String getCurrentDateStr() {
		Date d = new Date();// 取当前时间
		SimpleDateFormat df = new SimpleDateFormat();// 时间格式化对象
		df.applyPattern("yyyyMMdd_HHmmss");// 设置时间格式
		return df.format(d);// 格式化成串,输出
	}

	public String getS3_prefix() {
		return s3_prefix;
	}

	public void setS3_prefix(String s3_prefix) {
		this.s3_prefix = s3_prefix;
	}

	public String getS3_suffix() {
		return s3_suffix;
	}

	public void setS3_suffix(String s3_suffix) {
		this.s3_suffix = s3_suffix;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getFileDir() {
		return fileDir;
	}

	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	
}
