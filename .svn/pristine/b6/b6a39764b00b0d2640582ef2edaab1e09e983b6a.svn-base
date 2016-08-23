package com.sigmatrix.sc.utils;

import org.apache.log4j.Logger;

import com.sigmatrix.sc.utils.HttpClientUtil;

public class WXUtil {
	private static Logger logger1 = Logger.getLogger(WXUtil.class);
	
	/**
	 * @Method: isfollow
	 * @Description: 判断用户是否关注公众号
	 * @param wxAdd
	 * @param openId
	 * @return String
	 * @author zzw
	 * @date 2016年5月26日 下午5:59:18
	 */
	public static String isfollow(String wxAdd,String account,String openId){
		logger1.info("判断用户是否关注公众号 1关注 0 未关注:openId:"+openId);
		String follow = "0";
		try {
			follow = HttpClientUtil.getForInter(wxAdd+"/wxapi/isFollow?account="+account+"&openId="+openId);
			logger1.info("判断用户是否关注公众号返回  follow="+follow);
		} catch (Exception e) {
			logger1.error("判断用户是否关注公众号异常"+e.getMessage());
		}
		return follow;

	}

}
