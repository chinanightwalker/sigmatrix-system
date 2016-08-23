package com.sigmatrix.sc.utils;

import java.util.Date;

public class SerialNumberUtil {
	
	public static String GetSerialNumber(){
		StringBuilder sb = new StringBuilder();
		sb.append(DateUtil.getDateValue (new Date(),"yyyyMMddHHmmss"));
		int radomStr = (int)((Math.random()*9+1)*1000);
		sb.append(radomStr);
		return sb.toString();
		
	}

public static void main(String[] args) {
	System.out.println(GetSerialNumber());
}
}
