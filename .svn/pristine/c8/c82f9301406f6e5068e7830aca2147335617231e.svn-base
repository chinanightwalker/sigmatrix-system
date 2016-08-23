package com.sigmatrix.sc.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    /**
     * 根据名字获取cookie
     * @param request
     * @param name cookie名字
     * @return
     */
    public static String getCookieByName(HttpServletRequest request,String name){
        Map<String,String> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
        	return cookieMap.get(name);
        }else{
            return null;
        }   
    }

    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    private static Map<String,String> ReadCookieMap(HttpServletRequest request){  
        Map<String,String> cookieMap = new HashMap<String,String>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie.getValue());
                System.out.println("key:"+cookie.getName()+" value:"+cookie.getValue());
            }
        }
        return cookieMap;
    }
    
    /**
     * 根据key从cookie获取值
     * @param request
     * @param key cookie名字
     * @return
     */
	public static String getValueFromCookie(HttpServletRequest request, String key) {
		if (null == request || null == key) {
			return "";
		}
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equalsIgnoreCase(key)) {
					return cookies[i].getValue();
				}
			}
		}
		return "";
	}

    /**
     * 设置cookie
     * @param response
     * @param name  cookie名字
     * @param value cookie值
     * @param maxAge cookie生命周期  以秒为单位
     */
    public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
//        System.out.println("存储cookie:"+name+" value:"+value);
        Cookie cookie = new Cookie(name.trim(),value.trim());
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
//        System.out.println("已添加===============");
        response.addCookie(cookie);
    }
    
    // 删除 cookie  
    public static void delCookie(HttpServletResponse response, String cookieName) {  
    	Cookie cookie = new Cookie(cookieName,null); 
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
