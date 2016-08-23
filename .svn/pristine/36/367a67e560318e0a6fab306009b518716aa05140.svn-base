/**
 * @ClassName
 * @Description
 * @Author
 * @Date
 * @Revision
 * 参数加密
 */
package com.sigmatrix.sc.utils;

import org.springframework.util.Base64Utils;

/**
 * @author user
 *
 */
public class ParamerEncodeUtil {
	public static String encode(String str) throws Exception{
		String desStr = DESUtils.encrypt(str);
		return new String(Base64Utils.encode(desStr.getBytes("utf-8")),"utf-8");
	}
	public static String decode(String str) throws Exception{
		byte b[] = str.getBytes("utf-8");
		String desStr = new String(Base64Utils.decode(b),"utf-8");
		return DESUtils.decrypt(desStr);
	}
}
