package com.sigmatrix.sc.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: MD5加密
 * @Description:一级单品吗表中inputCode加密用此算法
 * @author zzw 
 * @date 2016年4月9日 上午11:11:45
 */
public class EncodeEncrypt {
	
	//inputCode 加密
	public static String encodeString(String str) {
		if(null == str || "".equals(str.trim())){
			return str;
		}
		MessageDigest messagedigest = null;
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if(null == messagedigest){
			return str;
		}
        messagedigest.update(str.getBytes());

        byte[] encodedPassword = messagedigest.digest();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < encodedPassword.length; i++) {
            if ((encodedPassword[i] & 0xff) < 0x10) {
                buf.append("0");
            }

            buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
        }
        return buf.toString();
    }


}
