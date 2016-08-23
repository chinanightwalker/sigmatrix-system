package com.sigmatrix.sc.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.sigmatrix.sc.service.impl.AppDefineInitServiceImpl;
import com.sigmatrix.sc.utils.HttpClientUtil;
import com.sigmatrix.sc.utils.HttpRequestUtil;
import com.sigmatrix.sc.web.global.UserCenterPortConstants;
import com.sigmatrix.sc.web.response.EnterpriseResult;
import com.sigmatrix.sc.web.response.EnterpriseSearch;
import com.sigmatrix.sc.web.vo.Enterprise;
/**
 * 企业操作接口
 * @author youjun
 *
 */
public class EnterpriseUtils {
	private static Logger logger = Logger.getLogger(EnterpriseUtils.class);
	
	/**所有的企业信息缓存Map,key为企业唯一标识,value为企业信息对象,web应用启动时调用init方法初始化唯一的一次*/
	public static Map<String, Enterprise> enterpriseCacheMap = new HashMap<String, Enterprise>();
	@Value("${usercenter.base.domian}")
	private static String userCenterBaseUrl; // 用户中心接口主域名,形如:http://www.baidu.com
	
	@Value("${usercenter.base.domian}")
	private String userCenterBaseUrl2;
	
	/**
	 * 初始化所有的企业放入缓存中,并且只当系统启动的时候初始化唯一的一次
	 */
	@SuppressWarnings({ "static-access", "rawtypes" })
	public static void init(){
//		logger.error("调用用户中心接口查询所有企业信息开始...");
//		EnterpriseUtils item = new EnterpriseUtils();
//		// 查询所有企业信息接口
//		String enterprise_all_port = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ALL_ENTERPRISE_INFO_PORT;
//		String param = "";
//		Map<String, String> search = new HashMap<String, String>();
//		//String result = HttpRequestUtil.executeRequestToUser(enterprise_all_port, param, search);
//		List<NameValuePair> params = new ArrayList<NameValuePair>();
//		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
//		String result = HttpClientUtil.getForInter(enterprise_all_port, params, headerParams);
//		//result = "{\"resultState\": \"0000\",\"resultMsg\": \"信码\",\"resultList\": [{\"enterpriseId\": \"1\",\"enterpriseCode\": \"scld01\",\"enterpriseName\":\"四川蓝带\",\"areaId\":\"\",\"address\":\"\",\"enterpriseDesc\":\"\",\"enterprisezip\":\"\",\"enterpriseInfo\":\"\",\"enterprisePic\":\"scld01/scld01_login-logo.png\",\"otherPicUrl\":\"scld01/scld01_headerImg.png\",\"status\":\"1\",\"linkman\":\"\",\"linkmanPhone\":\"\",\"linkmanEmali\":\"\",\"businessLicenseRegistrationNumber\":\"\",\"businessLicenseRegistrationAddress\":\"\",\"scopeOfBusiness\":\"\",\"termOfOperation\":\"\",\"businessLicenceFileUrl\":\"\",\"registeredCapital\":\"\",\"organizationCode\":\"\",\"organizationPicUrl\":\"\",\"operatorIdNumber\":\"\",\"operatorPhotoUrl\":\"\",\"authorizedOperationBook\":\"\",\"legalPerson\":\"\",\"legalPersonPhone\":\"\",\"domainNames\":\"localhost:8188/sigmatrix-system-admin\",\"sysAppIds\":\"\",\"wxAppId\":\"\",\"wxAppSecret\":\"\",\"wxPayAppId\":\"\",\"wxPayAppSecret\":\"\",\"wxPayMchId\":\"\",\"wxPayMchKey\":\"\",\"wxPayCertificateUrl\":\"\",\"createTime\":\"\",\"createId\":\"\",\"updateTime\":\"\",\"updateId\":\"\"},{\"enterpriseId\": \"2\",\"enterpriseCode\": \"102223\",\"enterpriseName\":\"航运\",\"areaId\":\"\",\"address\":\"\",\"enterpriseDesc\":\"\",\"enterprisezip\":\"\",\"enterpriseInfo\":\"\",\"enterprisePic\":\"\",\"otherPicUrl\":\"\",\"status\":\"1\",\"linkman\":\"\",\"linkmanPhone\":\"\",\"linkmanEmali\":\"\",\"businessLicenseRegistrationNumber\":\"\",\"businessLicenseRegistrationAddress\":\"\",\"scopeOfBusiness\":\"\",\"termOfOperation\":\"\",\"businessLicenceFileUrl\":\"\",\"registeredCapital\":\"\",\"organizationCode\":\"\",\"organizationPicUrl\":\"\",\"operatorIdNumber\":\"\",\"operatorPhotoUrl\":\"\",\"authorizedOperationBook\":\"\",\"legalPerson\":\"\",\"legalPersonPhone\":\"\",\"domainNames\":\"\",\"sysAppIds\":\"\",\"wxAppId\":\"\",\"wxAppSecret\":\"\",\"wxPayAppId\":\"\",\"wxPayAppSecret\":\"\",\"wxPayMchId\":\"\",\"wxPayMchKey\":\"\",\"wxPayCertificateUrl\":\"\",\"createTime\":\"\",\"createId\":\"\",\"updateTime\":\"\",\"updateId\":\"\"}]}";
//		try {
//			JSONObject jsonObjL = JSONObject.fromString(result);
//			EnterpriseResult er = new EnterpriseResult();
//			List<Enterprise> resultList = new ArrayList<Enterprise>();
//			Map<String, Class> classMap = new HashMap<String, Class>();
//			classMap.put("resultList", Enterprise.class);
//			er = (EnterpriseResult) jsonObjL.toBean(jsonObjL, EnterpriseResult.class, classMap);
//			String resultState = er.getResultState();
//			if(StringUtils.isNotBlank(resultState)
//					&&"00000".equals(resultState)){
//				resultList = er.getResultList();
//				for(Enterprise eptem:resultList){
//					enterpriseCacheMap.put(eptem.getCode(), eptem);
//				}
//			}else{
//				logger.error("用户中心接口查询企业信息失败,返回信息："+result);
//			}
//		} catch (Exception e) {
//			logger.error("查询用户中心接口缓存所有企业信息失败",e);
//		}
//		logger.error("调用用户中心接口查询所有企业信息结束...");
		
		/*
		 * 4.2根据域名或code查询企业信息接口
		 */
//		List<NameValuePair> headerParamsSearch = new ArrayList<NameValuePair>();
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("word","scld01");
//		jsonObject.put("type","1");
//		String enterpriseInfo = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.SINGLE_ENTERPRISE_INFO_PORT;		
//		String resultSearch = HttpClientUtil.post(enterpriseInfo, jsonObject.toString(), headerParamsSearch);
//		JSONObject jsonObjL = JSONObject.fromString(resultSearch);
//		EnterpriseSearch er = new EnterpriseSearch();
//		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("resultList", EnterpriseSearch.class);
//		er = (EnterpriseSearch) jsonObjL.toBean(jsonObjL, EnterpriseSearch.class, classMap);
//		String resultState = er.getResultState();
//		Enterprise e = null;
//		if(StringUtils.isNotBlank(resultState)
//				&&"00000".equals(resultState)){			
//				enterpriseCacheMap.put(er.getResultList().getCode(), er.getResultList());
//			
//		}else{
//			logger.error("用户中心接口查询企业信息失败,返回信息："+result);
//		}
		
		/*
		 * 4.3用户登录接口
		 */
//		List<NameValuePair> headerParamsAuthcToAuthority = new ArrayList<NameValuePair>();
//		NameValuePair np1 = new BasicNameValuePair("Content-Type","application/json");
//		NameValuePair np2 = new BasicNameValuePair("Client-Type","web");
//		NameValuePair np3 = new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY);
//		NameValuePair np4 = new BasicNameValuePair("enterpriseCode","scld01");
//		NameValuePair np5 = new BasicNameValuePair("userId","");
//		NameValuePair np6 = new BasicNameValuePair("token","");
//		NameValuePair np7 = new BasicNameValuePair("signInfo","");
//		headerParamsAuthcToAuthority.add(np1);
//		headerParamsAuthcToAuthority.add(np2);
//		headerParamsAuthcToAuthority.add(np3);
//		headerParamsAuthcToAuthority.add(np4);
//		headerParamsAuthcToAuthority.add(np5);
//		headerParamsAuthcToAuthority.add(np6);
//		headerParamsAuthcToAuthority.add(np7);
//		JSONObject jsonObjectAuthcToAuthority = new JSONObject();
//		jsonObjectAuthcToAuthority.put("userName","admin");
//		jsonObjectAuthcToAuthority.put("passWord","e10adc3949ba59abbe56e057f20f883e");
//		String enterpriseLogin = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ACCOUNT_AUTHORITY_PORT;
//		String resultLoing = HttpClientUtil.post(enterpriseLogin, jsonObjectAuthcToAuthority.toString(), headerParamsSearch);
//		System.out.println(enterpriseLogin);
	}
}
