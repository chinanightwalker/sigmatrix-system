package com.sigmatrix.sc.utils;

import java.util.UUID;

/**
 * 生成token令牌工具类
 * 
 * @author liushihao
 *
 */
public class TokenUtil {
	public static String getToken() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	/**
	 * 生成令牌，算法是 源字符串+当前毫秒数+密钥
	 * @param srcStr 源字符串
	 * @param key 密钥，各工程从resource中读取
	 */
	public static String genToken(String srcStr,String key){
			String str = srcStr+key;
			return MD5Utils.GetMD5Code(str);
	}
	public static void main(String[] args){
		
		for(int i=0;i<1000;i++){
		int rnd = (int) ( Math.random()*100) +1;
		
		System.out.println(rnd);
		}
	}
}
