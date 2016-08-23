package com.sigmatrix.sc.web.controller.usercenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;













import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.service.impl.AppDefineInitServiceImpl;
import com.sigmatrix.sc.utils.HttpClientUtil;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.web.controller.common.BaseController;
import com.sigmatrix.sc.web.global.CommonConstants;
import com.sigmatrix.sc.web.global.UserCenterPortConstants;
import com.sigmatrix.sc.web.response.EnterpriseSearch;
import com.sigmatrix.sc.web.response.PermissionRusult;
import com.sigmatrix.sc.web.vo.Permission;


/** 
 * @author  zln:
 * @date 创建时间：2016年7月23日 下午3:12:52 
 * @parameter   
 * @return 
 */
@Controller
@RequestMapping(value = "/permission")
public class PermissionController extends BaseController {
	 private static Logger logger = Logger.getLogger(PermissionController.class);
	
	/**
	   * 权限列表页面
	   * 
	   * @param request
	   * @return
	   */
	  @RequestMapping(value = "/list")
	  public ModelAndView list(Permission permission, HttpServletRequest request) {
		  String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		  String enterpriseCode = getEnterpriseCode(request);
		  String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		  String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);

		  String permissionUrl = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.PERMISSION_LIST;
		  List<NameValuePair> headerParams = new ArrayList<NameValuePair>();	
		  List<NameValuePair> bodyParams = new ArrayList<NameValuePair>();
		  headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
		  headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
		  headerParams.add(new BasicNameValuePair("Client-Type","web"));
		  headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
		  headerParams.add(new BasicNameValuePair("userId",userid));
		  headerParams.add(new BasicNameValuePair("token",token));
		  String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
		  headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
		  String permissionInfo = HttpClientUtil.getForInter(permissionUrl,bodyParams,headerParams);
//		  JSONObject bodyJson = JSONObject.fromString(permissionInfo);
		  JSONObject bodyJson = JSONObject.parseObject(permissionInfo);
		  Map <String,Object> map = new HashMap<String,Object>();
//		  Map<String, Class> classMap = new HashMap<String, Class>();
//		  classMap.put("resultList", Permission.class);
		  PermissionRusult pr = new PermissionRusult();
//		  pr = (PermissionRusult)bodyJson.toBean(bodyJson, PermissionRusult.class, classMap);
		  pr = JSONObject.toJavaObject(bodyJson, PermissionRusult.class);	
		    if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))){
		    	map.put("list",pr.getResultList());
		    }else {
		    	
		    }
		    
		    return new ModelAndView(JSP_PREFIX+"permission/list",map);
//	    ModelAndView mav = new ModelAndView("WEB-INF/pages/Permission/list");
//	    Map<String, Object> param = new HashMap<String, Object>();
//	    if (null != permission) {
//	      if (StringUtils.isNotBlank(permission.getName())) {
//	        param.put("name", permission.getName());
//	      }
//	    }
//	    List<Permission> list = service.selectSysPermissions(param);
//	    mav.addObject("list", list);
//	    mav.addObject("condition", param);
//	    return mav;
	  }
}
