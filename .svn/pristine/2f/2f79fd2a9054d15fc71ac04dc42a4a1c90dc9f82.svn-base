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
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.service.impl.AppDefineInitServiceImpl;
import com.sigmatrix.sc.utils.HttpClientUtil;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.utils.MD5Utils;
import com.sigmatrix.sc.web.controller.common.BaseController;
import com.sigmatrix.sc.web.global.CommonConstants;
import com.sigmatrix.sc.web.global.UserCenterPortConstants;
import com.sigmatrix.sc.web.response.AccountResult;
import com.sigmatrix.sc.web.response.ResourceResult;
import com.sigmatrix.sc.web.response.ResourceSearchResult;
import com.sigmatrix.sc.web.vo.AccountSearch;
import com.sigmatrix.sc.web.vo.SysResource;
@Controller
@RequestMapping(value = "/resource")
public class ResourceController extends BaseController {
	private static Logger logger = Logger.getLogger(ResourceController.class);
	@RequestMapping(value="/list")
	public ModelAndView resourceList(HttpServletRequest request) {
	Map<String, Object> map = new HashMap<String, Object>();
	String userId = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
	String enterpriseCode = getEnterpriseCode(request);
	String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
	String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
	String url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.RESOURCE_SEARCH;
	List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
	headerParams.add(new BasicNameValuePair("appKey", UserCenterPortConstants.APPKEY));
	headerParams.add(new BasicNameValuePair("Content-Type", "application/json"));
	headerParams.add(new BasicNameValuePair("Client-Type", "web"));
	headerParams.add(new BasicNameValuePair("enterpriseCode", enterpriseCode));
	headerParams.add(new BasicNameValuePair("userId", userId));
	headerParams.add(new BasicNameValuePair("token", token));
	String signInfoTem = MD5Utils.GetMD5Code(securityCode + UserCenterPortConstants.APPKEY + enterpriseCode + userId + token);
	headerParams.add(new BasicNameValuePair("signInfo", signInfoTem));
	JSONObject sendBody= new JSONObject();
	String name = request.getParameter("name");
	sendBody.put("name",name);
	String roleInfo = HttpClientUtil.postForInter(url,sendBody.toString(), headerParams);
//	JSONObject json = JSONObject.fromString(roleInfo);
	JSONObject json = JSONObject.parseObject(roleInfo);
//	Map<String, Class> classMap = new HashMap<String, Class>();
//	classMap.put("resultList", SysResource.class);
	ResourceSearchResult rsr = new ResourceSearchResult();
//	rsr = (ResourceSearchResult) json.toBean(json, ResourceSearchResult.class,classMap);
	rsr = JSONObject.toJavaObject(json, ResourceSearchResult.class);
	map.put("list",rsr.getResultList());
	if (null != json.get("resultState") && "00000".equals(json.get("resultState"))) {
		
		return new ModelAndView(JSP_PREFIX + "resource/listResource", map);
	} else {
		
	}	
	return new ModelAndView();
}
	
	
	/*
	 * 添加资源信息
	 */
	@RequestMapping(value = "/add")
	@RequiresPermissions(value="resource:insert")
	public ModelAndView add(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();		
		String userId = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		String url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.RESOURCE_SEARCH;
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
		headerParams.add(new BasicNameValuePair("appKey", UserCenterPortConstants.APPKEY));
		headerParams.add(new BasicNameValuePair("Content-Type", "application/json"));
		headerParams.add(new BasicNameValuePair("Client-Type", "web"));
		headerParams.add(new BasicNameValuePair("enterpriseCode", enterpriseCode));
		headerParams.add(new BasicNameValuePair("userId", userId));
		headerParams.add(new BasicNameValuePair("token", token));
		String signInfoTem = MD5Utils.GetMD5Code(securityCode + UserCenterPortConstants.APPKEY + enterpriseCode + userId + token);
		headerParams.add(new BasicNameValuePair("signInfo", signInfoTem));
		JSONObject sendBody=new JSONObject();
		String name = request.getParameter("name");
		sendBody.put("name",name);
		String roleInfo = HttpClientUtil.postForInter(url,sendBody.toString(), headerParams);
//		JSONObject json = JSONObject.fromString(roleInfo);
		JSONObject json = JSONObject.parseObject(roleInfo);
//		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("resultList", SysResource.class);
		ResourceSearchResult rsr = new ResourceSearchResult();
//		rsr = (ResourceSearchResult) json.toBean(json, ResourceSearchResult.class,classMap);
		rsr = JSONObject.toJavaObject(json, ResourceSearchResult.class);
		map.put("list",rsr.getResultList());
		
		return new ModelAndView(JSP_PREFIX+"resource/addResource",map);
	}
	
	/*
	 * 添加资源保存
	 */
	@RequestMapping(value = "/save")
	public @ResponseBody JsonEdit save(HttpServletRequest request){
//		List<NameValuePair> bodyParams = new ArrayList<NameValuePair>();
//		bodyParams.add(BasicNameValuePair("name",""));
		JSONObject jb = new JSONObject();
		jb.put("name", request.getParameter("name"));
		jb.put("identity",request.getParameter("identity"));
		jb.put("url",request.getParameter("url"));
		jb.put("weight",request.getParameter("weight"));
		String parentid = request.getParameter("parentId");
		if(parentid==null || parentid.equals("")){
			parentid = "0";
		}
		jb.put("parentId",parentid);
		jb.put("icon",request.getParameter("icon"));
		jb.put("isShow",request.getParameter("isShow"));
		jb.put("status",request.getParameter("status"));
		String url = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.RESOURCE_ADD;
		String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
	    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
	    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
	    headerParams.add(new BasicNameValuePair("Client-Type","web"));
	    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
	    headerParams.add(new BasicNameValuePair("userId",userid));
	    headerParams.add(new BasicNameValuePair("token",token));
	    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
		headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
		String info = HttpClientUtil.postForInter(url,jb.toString(),headerParams);
//		JSONObject bodyJson = JSONObject.fromString(info);
		JSONObject bodyJson = JSONObject.parseObject(info);
		
		if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))){		
			return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "resource/list");
		}else{
			return new JsonEdit("300",bodyJson.getString("resultMsg"),"","","","");
		}
//		ResourceSearchResult rsr = new ResourceSearchResult();
//		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("resultList", Resource.class);
//		rsr = (ResourceSearchResult) bodyJson.toBean(bodyJson, ResourceSearchResult.class,classMap);
//		List<com.sigmatrix.sc.web.vo.Resource> resourceList = new ArrayList<com.sigmatrix.sc.web.vo.Resource>();
//		resourceList = rsr.getResultList();
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("resourceList",resourceList);
	}
	
	
	@RequestMapping(value="edit")
	@RequiresPermissions(value="resource:update")
	public ModelAndView edit(HttpServletRequest request){
		//根据id查询资源
		String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
	    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
	    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
	    headerParams.add(new BasicNameValuePair("Client-Type","web"));
	    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
	    headerParams.add(new BasicNameValuePair("userId",userid));
	    headerParams.add(new BasicNameValuePair("token",token));
	    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
		headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
		Map<String,Object> map = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String urlResourceSingle = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.RESOURCE_GETRESOURCE;
		String infoResourceSingle = HttpClientUtil.sendget(urlResourceSingle,Integer.parseInt(id),headerParams);
//		JSONObject jj = JSONObject.fromString(infoResourceSingle);
		JSONObject jj = JSONObject.parseObject(infoResourceSingle);
		ResourceResult rr = new ResourceResult();
//		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("resultList", SysResource.class);
//		rr = (ResourceResult) jj.toBean(jj, ResourceResult.class,classMap);
		rr = JSONObject.toJavaObject(jj, ResourceResult.class);
		map.put("recource",rr.getResultList());
		//查询所有菜单资源
		String url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.RESOURCE_SEARCH;
		JSONObject sendBody=new JSONObject();
		String name = request.getParameter("name");
		sendBody.put("name",name);
		String roleInfo = HttpClientUtil.postForInter(url,sendBody.toString(), headerParams);
//		JSONObject json = JSONObject.fromString(roleInfo);
		JSONObject json = JSONObject.parseObject(roleInfo);
//		Map<String, Class> recoureClassMap = new HashMap<String, Class>();
//		recoureClassMap.put("resultList", SysResource.class);
		ResourceSearchResult rsr = new ResourceSearchResult();
//		rsr = (ResourceSearchResult) json.toBean(json, ResourceSearchResult.class,recoureClassMap);
		rsr = JSONObject.toJavaObject(json, ResourceSearchResult.class);
		map.put("list",rsr.getResultList());
		//查询父菜单
		SysResource sr = new SysResource();
		sr = rr.getResultList();		
		String urlResourceSingleParent = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.RESOURCE_GETRESOURCE;
		String infoResourceSingleParent = HttpClientUtil.sendget(urlResourceSingleParent,Integer.parseInt(sr.getParentId()),headerParams);
//		JSONObject irsp = JSONObject.fromString(infoResourceSingleParent);
		JSONObject irsp = JSONObject.parseObject(infoResourceSingleParent);
		ResourceResult rrP = new ResourceResult();
//		Map<String, Class> classMapParent = new HashMap<String, Class>();
//		classMap.put("resultList", SysResource.class);
//		rrP = (ResourceResult) irsp.toBean(irsp, ResourceResult.class,classMap);
		rrP = JSONObject.toJavaObject(irsp, ResourceResult.class);
		SysResource srParent = new SysResource(); 
		srParent= rrP.getResultList();
		if(srParent!=null && srParent.getId()!=null && !srParent.getId().equals("")){
			map.put("parentId",srParent.getId());
			map.put("parentName",srParent.getName());
		}
		
		
		return new ModelAndView(JSP_PREFIX+"resource/updateResource",map);		
	}
	
	/*
	 * 修改资源保存
	 */
	@RequestMapping(value = "/updateSave")
	public @ResponseBody JsonEdit updateSave(HttpServletRequest request){
//		List<NameValuePair> bodyParams = new ArrayList<NameValuePair>();
//		bodyParams.add(BasicNameValuePair("name",""));
		JSONObject jb = new JSONObject();
		jb.put("id",request.getParameter("id"));
		jb.put("name", request.getParameter("name"));
		jb.put("identity",request.getParameter("identity"));
		jb.put("url",request.getParameter("url"));
		jb.put("weight",request.getParameter("weight"));
		jb.put("icon",request.getParameter("icon"));
		jb.put("isShow",request.getParameter("isShow"));
		jb.put("status",request.getParameter("status"));
		String url = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.RESOURCE_UPDATE;
		String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
	    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
	    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
	    headerParams.add(new BasicNameValuePair("Client-Type","web"));
	    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
	    headerParams.add(new BasicNameValuePair("userId",userid));
	    headerParams.add(new BasicNameValuePair("token",token));
	    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
		headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
		String info = HttpClientUtil.postForInter(url,jb.toString(),headerParams);
//		JSONObject bodyJson = JSONObject.fromString(info);
		JSONObject bodyJson = JSONObject.parseObject(info);
		
		if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))){		
			return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "resource/list");
		}else{
			return new JsonEdit("300",bodyJson.getString("resultMsg"),"","","","");
		}

	}
	/**
	 * 删除资源
	 */
	@RequestMapping(value="/remove")
	@RequiresPermissions(value="resource:delete")
	public @ResponseBody JsonEdit remove(HttpServletRequest request){
		String id = request.getParameter("id");
		JSONObject bodyJson = new JSONObject();
		if (id!= null) {
			List<NameValuePair> bodyParams = new ArrayList<NameValuePair>();
//			bodyParams.add(new BasicNameValuePair("resourceId",id));
			String url = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.RESOURCE_DELETE;
			String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
			String enterpriseCode = getEnterpriseCode(request);
			String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
			String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
			List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
		    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
		    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
		    headerParams.add(new BasicNameValuePair("Client-Type","web"));
		    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
		    headerParams.add(new BasicNameValuePair("userId",userid));
		    headerParams.add(new BasicNameValuePair("token",token));
		    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
			headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
			String info = HttpClientUtil.sendget(url,Integer.parseInt(id),headerParams);
//			bodyJson = JSONObject.fromString(info);
			bodyJson = JSONObject.parseObject(info);
			if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))){		
				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "resource/list");
			}
		}
		return new JsonEdit("300",bodyJson.getString("resultMsg"),"","","","");
		//return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "resource/list");
	}
	
}
