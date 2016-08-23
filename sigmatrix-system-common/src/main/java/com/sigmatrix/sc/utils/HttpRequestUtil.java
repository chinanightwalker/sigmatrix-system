package com.sigmatrix.sc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestUtil {

	
	
	/**
	 * 
	 * @Title:  
	 * @Description: TODO 
	 * @author: 
	 * @param url用户中心地址
	 * @param param报文体参数
	 * @param search报文头参数
	 * @return
	 */
	public static String executeRequestToUser(String url, String param,Map<String, String> search) {
		OutputStream out = null;
        BufferedReader in = null;
        InputStream is = null;
        String result = "";
        HttpURLConnection conn = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            conn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Encoding", "UTF-8");
            Iterator it = search.keySet().iterator();
    		while (it.hasNext()) {
    			String key = (String) it.next();
    			if (!search.get("appKey").equals("")&& search.get("appKey")!= null) {
					conn.setRequestProperty("appKey",search.get(key));
				}
				if (!search.get("enterpriseCode").equals("")&& search.get("enterpriseCode") != null) {
					conn.setRequestProperty("enterpriseCode",search.get(key));
				}
				if (!search.get("userId").equals("")&& search.get("userId") != null) {
					conn.setRequestProperty("userId",search.get(key));
				}
				if (!search.get("token").equals("")&& search.get("token") != null) {
					conn.setRequestProperty("token",search.get(key));
				}
				if (!search.get("signInfo").equals("")&& search.get("signInfo") != null) {
					conn.setRequestProperty("signInfo",search.get(key));
				}
    		}	
            
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = conn.getOutputStream();
            // 发送请求参数
            out.write(param.getBytes("UTF-8"));
            // flush输出流的缓冲
            out.flush();
            is = conn.getInputStream();
            byte[] b = new byte[is.available()];
            is.read(b);
            result = new String(b, "utf-8");
            
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
            	if(is!=null){
            		is.close();
            	}
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
                if(conn!=null){
                	conn.disconnect();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
	
	
	/**
	 * 
	 * @Title:  
	 * @Description: TODO 
	 * @author: TianNing
	 * @param url
	 * @param param
	 * @return
	 */
	public static String executeRequest(String url, String param) {
		OutputStream out = null;
        BufferedReader in = null;
        String result = "";
        HttpURLConnection conn = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            conn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Encoding", "UTF-8");
            //conn.setRequestProperty("serviceId", serviceId);
            //conn.setRequestProperty("serviceKey", serviceKey);		
            
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = conn.getOutputStream();
            // 发送请求参数
            out.write(param.getBytes("UTF-8"));
            // flush输出流的缓冲
            out.flush();
            InputStream is = conn.getInputStream();
            byte[] b = new byte[is.available()];
            is.read(b);
            result = new String(b, "utf-8");
            
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
                if(conn!=null){
                	conn.disconnect();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
	

	/**
	 * 
	 * @Title: tokenVerifyResponse 
	 * @Description: TODO 验证token接口
	 * @author: TianNing
	 * @param url
	 * @param param
	 * @return
	 */
	public static String tokenVerifyResponse(String url, String token) {
		OutputStream out = null;
        BufferedReader in = null;
        String result = "";
        HttpURLConnection conn = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            conn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Encoding", "UTF-8");
            conn.setRequestProperty("token", token);
            
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = conn.getOutputStream();
            // 发送请求参数
            //out.write(param.getBytes("UTF-8"));
            // flush输出流的缓冲
            out.flush();
            InputStream is = conn.getInputStream();
            byte[] b = new byte[is.available()];
            is.read(b);
            result = new String(b, "utf-8");
            
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
                if(conn!=null){
                	conn.disconnect();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
	/**
	 * 获取客户端IP
	 * @param request
	 * @return
	 */
	public static String getRemoteHost(HttpServletRequest request){
	    // x-forwarded-for 方式取到多个IP的处理
	    String ip = request.getHeader("x-forwarded-for");
	    if(!org.apache.commons.lang.StringUtils.isNotBlank(ip)){
	    	String[] ips = ip.split(",");
	    	if(ips!=null && ips.length>0){
	    		for(int n=0;n<ips.length;n++){
	    			if(org.apache.commons.lang.StringUtils.isNotBlank(ips[n].trim())){
			    		ip = ips[n].trim();
			    		break;
	    			}
	    		}
	    	}
	    }
	    if(org.apache.commons.lang.StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	        if(org.apache.commons.lang.StringUtils.isNotBlank(ip)){
		        // 如果获取多个ip，则只取第一条IP地址
		        String[] ips = ip.split(",");
		        if(ips!=null && ips.length>0){
		        	for(int n=0;n<ips.length;n++){
		    			if(org.apache.commons.lang.StringUtils.isNotBlank(ips[n].trim())){
				    		ip = ips[n].trim();
				    		break;
		    			}
		    		}
		        }
	        }
	    }
	    if(org.apache.commons.lang.StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	        if(org.apache.commons.lang.StringUtils.isNotBlank(ip)){
		        // 如果获取多个ip，则只取第一条IP地址
		        String[] ips = ip.split(",");
		        if(ips!=null && ips.length>0){
		        	for(int n=0;n<ips.length;n++){
		    			if(org.apache.commons.lang.StringUtils.isNotBlank(ips[n].trim())){
				    		ip = ips[n].trim();
				    		break;
		    			}
		    		}
		        }
	        }
	    }
	    if(org.apache.commons.lang.StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	        if(org.apache.commons.lang.StringUtils.isNotBlank(ip)){
		        // 如果获取多个ip，则只取第一条IP地址
		        String[] ips = ip.split(",");
		        if(ips!=null && ips.length>0){
		        	for(int n=0;n<ips.length;n++){
		    			if(org.apache.commons.lang.StringUtils.isNotBlank(ips[n].trim())){
				    		ip = ips[n].trim();
				    		break;
		    			}
		    		}
		        }
	        }
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	
	//获取客户端Ip
	public static String getClientIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip.trim())) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip.trim())) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip.trim())) {
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip.trim())) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip.trim())) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip.trim())) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		// 如果是多级代理，那么取第一个ip为客户ip
		if (ip != null && ip.trim().length() != 0){
			String[] ips = ip.split(",");
        	ip = ips[0].trim();
        	return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
		} 
		return "unknown";
	}
	
	//获取客户端类型
	public static String getClientType(HttpServletRequest request) {
		if(null == request){
			return "unknown";
		}
		String userAgent = request.getHeader("user-agent");
		if(null == userAgent){
			return "unknown";
		}
		userAgent = userAgent.toLowerCase();
		if(userAgent.contains("ipad")||userAgent.contains("ipod")
				||userAgent.contains("iphone")){
			return "ios";
		}
		if(userAgent.contains("android")||userAgent.contains("linux")
				||userAgent.contains("unix")){
			return "android";
		}
		if(userAgent.contains("win")||userAgent.contains("window")){
			return "window";
		}
		return "unknown";
	}
}
