package com.sigmatrix.sc.utils;

import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.validation.ObjectError;

import com.sigmatrix.sc.global.BaseResponse;
import com.sigmatrix.sc.global.Response;
import com.sigmatrix.sc.global.StateInfoEnum;

public class CommonUtils {

	/**
	 * 获得业务的订单ID，某些业务需要生成订单ID， 规则是小写的业务代码+yyyyMMddHHmmss+6位随机数，例如销售订单：xsdj_20160216173435678912 
	 */
	public static String getBusinessOrderID(String bussinessID){
		
		if(StringUtils.isEmpty(bussinessID)){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(bussinessID.toLowerCase());
		sb.append("_");
		sb.append(DateUtil.getDateValue (new Date(),"yyyyMMddHHmmss"));
		int radomStr = (int)((Math.random()*9+1)*100000);
		sb.append(radomStr);
		return sb.toString();
		
	}
	
	
	public static Response getRequestBodyErrorInfo(List<ObjectError> err){
		StringBuffer errInfo = new StringBuffer();
		for (ObjectError e : err) {
			errInfo.append(e.getDefaultMessage()).append(",");
		}
		return new BaseResponse(StateInfoEnum.PARAM_INVALID, errInfo.substring(0, errInfo.length() - 1));
	}
	
	/** 
	 * 计算地球上任意两点(经纬度)距离 
	 *  
	 * @param long1 
	 *            第一点经度 
	 * @param lat1 
	 *            第一点纬度 
	 * @param long2 
	 *            第二点经度 
	 * @param lat2 
	 *            第二点纬度 
	 * @return 返回距离 单位：米 
	 */  
	public static double Distance(double long1, double lat1, double long2,  
	        double lat2) {  
	    double a, b, R;  
	    R = 6378137; // 地球半径  
	    lat1 = lat1 * Math.PI / 180.0;  
	    lat2 = lat2 * Math.PI / 180.0;  
	    a = lat1 - lat2;  
	    b = (long1 - long2) * Math.PI / 180.0;  
	    double d;  
	    double sa2, sb2;  
	    sa2 = Math.sin(a / 2.0);  
	    sb2 = Math.sin(b / 2.0);  
	    d = 2  
	            * R  
	            * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)  
	                    * Math.cos(lat2) * sb2 * sb2));  
	    return d;  
	} 
}
