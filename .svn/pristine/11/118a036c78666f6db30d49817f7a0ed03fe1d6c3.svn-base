package com.sigmatrix.sc.web.controller.usercenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.service.impl.AppDefineInitServiceImpl;
import com.sigmatrix.sc.utils.HttpClientUtil;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.utils.MD5Utils;
import com.sigmatrix.sc.web.controller.common.BaseController;
import com.sigmatrix.sc.web.global.CommonConstants;
import com.sigmatrix.sc.web.global.UserCenterPortConstants;
import com.sigmatrix.sc.web.vo.Permission;
import com.sigmatrix.sc.web.vo.Resource;
import com.sigmatrix.sc.web.vo.Role;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {
	private static Logger logger = Logger.getLogger(RoleController.class);

	@RequestMapping(value = "list")

	public ModelAndView roleList(HttpServletRequest request) {
		// 获得角色名称 进行查询
		String rolename = request.getParameter("name");
		// System.out.println(rolename+"*********");
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		String url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ROLE_SEARCH;
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
		headerParams.add(new BasicNameValuePair("appKey", UserCenterPortConstants.APPKEY));
		headerParams.add(new BasicNameValuePair("Content-Type", "application/json"));
		headerParams.add(new BasicNameValuePair("Client-Type", "web"));
		headerParams.add(new BasicNameValuePair("enterpriseCode", enterpriseCode));
		headerParams.add(new BasicNameValuePair("userId", userId));
		headerParams.add(new BasicNameValuePair("token", token));
		String signInfoTem = MD5Utils
				.GetMD5Code(securityCode + UserCenterPortConstants.APPKEY + enterpriseCode + userId + token);
		headerParams.add(new BasicNameValuePair("signInfo", signInfoTem));
		JSONObject sendBody = new JSONObject();
		sendBody.put("name", rolename);
		String roleInfo = HttpClientUtil.postForInter(url, sendBody.toString(), headerParams);
		// System.out.println(roleInfo);
		List<Role> roleList = new ArrayList<Role>();
		JSONObject json = JSONObject.parseObject(roleInfo);
		if (json.getJSONArray("resultList") != null) {
			if (null != json.get("resultState") && "00000".equals(json.get("resultState"))) {
				JSONArray RoleList = json.getJSONArray("resultList");
				for (int i = 0; i < RoleList.size(); i++) {
					JSONObject jsons = JSONObject.parseObject(String.valueOf(RoleList.get(i)));
					// System.out.println(jsons.getString("name")+"******"+RoleList.length());
					Role role = new Role();
					role.setId(jsons.getString("id"));
					role.setName(jsons.getString("name"));
					role.setRole(jsons.getString("role"));
					role.setDescription(jsons.getString("description"));
					role.setUpdateTime(jsons.getString("updateTime"));
					roleList.add(role);
				}
				logger.debug("获得角色信息成功");

			} else {
				logger.error("获得角色信息失败");
			}

		}
		map.put("roleList", roleList);
		map.put("name", rolename);

		return new ModelAndView(JSP_PREFIX + "role/listGroup", map);

	}

	/**
	 * 角色增加模块
	 */
	@RequestMapping(value = "/add")
	@RequiresPermissions("role:insert")
	public ModelAndView addView(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
		headerParams.add(new BasicNameValuePair("appKey", UserCenterPortConstants.APPKEY));
		headerParams.add(new BasicNameValuePair("Content-Type", "application/json"));
		headerParams.add(new BasicNameValuePair("Client-Type", "web"));
		headerParams.add(new BasicNameValuePair("enterpriseCode", enterpriseCode));
		headerParams.add(new BasicNameValuePair("userId", userId));
		headerParams.add(new BasicNameValuePair("token", token));
		String signInfoTem = MD5Utils
				.GetMD5Code(securityCode + UserCenterPortConstants.APPKEY + enterpriseCode + userId + token);
		headerParams.add(new BasicNameValuePair("signInfo", signInfoTem));
		String Resource_url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.RESOURCE_SEARCH;
		String ResourceInfo = HttpClientUtil.postForInter(Resource_url, new JSONObject().toString(), headerParams);
		// 获取资源信息
		List<Resource> resourceList = new ArrayList<Resource>();
		JSONObject json = JSONObject.parseObject(ResourceInfo);
		if (json.getJSONArray("resultList") != null) {
			if (null != json.get("resultState") && "00000".equals(json.get("resultState"))) {
				JSONArray ResourceList = json.getJSONArray("resultList");
				// System.out.println(ResourceList.toString());
				for (int i = 0; i < ResourceList.size(); i++) {
					JSONObject jsons = JSONObject.parseObject(String.valueOf(ResourceList.get(i)));
					Resource resource = new Resource();
					resource.setId(jsons.getString("id"));
					resource.setName(jsons.getString("name"));
					resource.setParenId(jsons.getString("parentId"));
					resourceList.add(resource);
				}
				logger.debug("获得资源信息成功");

			} else {
				logger.error("获得资源信息失败");
			}

		}
		// 获取权限信息
		String Permission_url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.PERMISSION_LIST;
		String PermissionInfo = HttpClientUtil.getForInter(Permission_url, null, headerParams);
		List<Permission> permissionList = new ArrayList<Permission>();
		JSONObject json2 = JSONObject.parseObject(PermissionInfo);
		if (json2.getJSONArray("resultList") != null) {
			if (null != json2.get("resultState") && "00000".equals(json2.get("resultState"))) {
				JSONArray PermissionList = json2.getJSONArray("resultList");
				System.out.println(PermissionList.toString());
				for (int i = 0; i < PermissionList.size(); i++) {
					JSONObject jsons = JSONObject.parseObject(String.valueOf(PermissionList.get(i)));
					Permission permission = new Permission();
					permission.setId(jsons.getString("id"));
					permission.setName(jsons.getString("name"));
					permissionList.add(permission);
				}
				logger.debug("获得权限信息成功");

			} else {
				logger.error("获得权限信息失败");
			}

		}

		map.put("resourceTree", getRoleResourceTree(resourceList));
		map.put("permissionList", permissionList);
		return new ModelAndView(JSP_PREFIX + "role/input", map);
	}

	/**
	 * 修改角色
	 */
	@RequestMapping(value = "/edit")
	@RequiresPermissions("role:update")
	public ModelAndView updateView(Integer roleId, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
		headerParams.add(new BasicNameValuePair("appKey", UserCenterPortConstants.APPKEY));
		headerParams.add(new BasicNameValuePair("Content-Type", "application/json"));
		headerParams.add(new BasicNameValuePair("Client-Type", "web"));
		headerParams.add(new BasicNameValuePair("enterpriseCode", enterpriseCode));
		headerParams.add(new BasicNameValuePair("userId", userId));
		headerParams.add(new BasicNameValuePair("token", token));
		String signInfoTem = MD5Utils
				.GetMD5Code(securityCode + UserCenterPortConstants.APPKEY + enterpriseCode + userId + token);
		headerParams.add(new BasicNameValuePair("signInfo", signInfoTem));
		String RoleAndPermiss_url = AppDefineInitServiceImpl.userCenterBaseUrl
				+ UserCenterPortConstants.ROLE_getResourcesAndPermissions;
		String RoleAndPermissInfo = HttpClientUtil.sendget(RoleAndPermiss_url, roleId, headerParams);
		System.out.println(RoleAndPermissInfo);
		String Roles_url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ROLE_getRoleById;
		String RolesInfo = HttpClientUtil.sendget(Roles_url, roleId, headerParams);
		System.out.println(RolesInfo);
		JSONObject json = JSONObject.parseObject(RolesInfo);
		if (json.get("resultList") != null) {
			if (null != json.get("resultState") && "00000".equals(json.get("resultState"))) {
				JSONObject jsons = json.getJSONObject("resultList");
				Role role = new Role();
				role.setId(jsons.getString("id"));
				role.setName(jsons.getString("name"));
				role.setRole(jsons.getString("role"));
				role.setDescription(jsons.getString("description"));
				role.setStatus(jsons.getString("status"));
				System.out.println(jsons.toString());
				map.put("role", role);
			}
		}
		// 获取资源信息
		String Resource_url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.RESOURCE_SEARCH;
		String ResourceInfo = HttpClientUtil.postForInter(Resource_url, new JSONObject().toString(), headerParams);
		List<Resource> resourceList = new ArrayList<Resource>();
		JSONObject json3 = JSONObject.parseObject(ResourceInfo);
		if (json3.getJSONArray("resultList") != null) {
			if (null != json3.get("resultState") && "00000".equals(json3.get("resultState"))) {
				JSONArray ResourceList = json3.getJSONArray("resultList");
				// System.out.println(ResourceList.toString());
				for (int i = 0; i < ResourceList.size(); i++) {
					JSONObject jsons = JSONObject.parseObject(String.valueOf(ResourceList.get(i)));
					Resource resource = new Resource();
					resource.setId(jsons.getString("id"));
					resource.setName(jsons.getString("name"));
					resource.setParenId(jsons.getString("parentId"));
					resourceList.add(resource);
				}
				logger.debug("获得资源信息成功");

			} else {
				logger.error("获得资源信息失败");
			}

		}
		// 获取权限信息
		String Permission_url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.PERMISSION_LIST;
		String PermissionInfo = HttpClientUtil.getForInter(Permission_url, null, headerParams);
		List<Permission> permissionList = new ArrayList<Permission>();
		JSONObject json2 = JSONObject.parseObject(PermissionInfo);
		if (json2.getJSONArray("resultList") != null) {
			if (null != json2.get("resultState") && "00000".equals(json2.get("resultState"))) {
				JSONArray PermissionList = json2.getJSONArray("resultList");
				System.out.println(PermissionList.toString());
				for (int i = 0; i < PermissionList.size(); i++) {
					JSONObject jsons = JSONObject.parseObject(String.valueOf(PermissionList.get(i)));
					Permission permission = new Permission();
					permission.setId(jsons.getString("id"));
					permission.setName(jsons.getString("name"));
					permissionList.add(permission);
				}
				logger.debug("获得权限信息成功");

			} else {
				logger.error("获得权限信息失败");
			}

		}
		// 查询已选择的资源权限
		String Role_resource_permiss_url = AppDefineInitServiceImpl.userCenterBaseUrl
				+ UserCenterPortConstants.ROLE_getResourcesAndPermissions;
		String permiss_url = HttpClientUtil.sendget(Role_resource_permiss_url, roleId, headerParams);
		String permiss_html = getPermissList(permiss_url, request);
		System.out.println(permiss_url);
		System.out.println(permiss_html);
		map.put("permiss_html", permiss_html);
		map.put("resourceTree", getRoleResourceTree(resourceList));
		map.put("permissionList", permissionList);

		return new ModelAndView(JSP_PREFIX + "role/input", map);
	}

	/**
	 * 保存角色
	 */
	@RequestMapping(value = "/save")
	public @ResponseBody JsonEdit saveView(HttpServletRequest request, Role role) {
		/** 链接用户中心需要的数据 */
		String userId = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
		headerParams.add(new BasicNameValuePair("appKey", UserCenterPortConstants.APPKEY));
		headerParams.add(new BasicNameValuePair("Content-Type", "application/json"));
		headerParams.add(new BasicNameValuePair("Client-Type", "web"));
		headerParams.add(new BasicNameValuePair("enterpriseCode", enterpriseCode));
		headerParams.add(new BasicNameValuePair("userId", userId));
		headerParams.add(new BasicNameValuePair("token", token));
		String signInfoTem = MD5Utils
				.GetMD5Code(securityCode + UserCenterPortConstants.APPKEY + enterpriseCode + userId + token);
		headerParams.add(new BasicNameValuePair("signInfo", signInfoTem));
		String[] permissionBox = request.getParameterValues("permiss");
		List<JSONObject> authList = new ArrayList<JSONObject>();
		Set<Integer> resourceIds = new HashSet<Integer>();
		String permissionId = "";
		Map<Integer, String> permissionIds = new HashMap<Integer, String>();
		if (null != permissionBox) {
			for (String str : permissionBox) {
				String[] res = str.split(";");
				resourceIds.add(Integer.valueOf(res[0]));
				if (StringUtils.isNotBlank(res[1])) {
					permissionId=res[1];
					permissionIds.put(Integer.valueOf(res[0]), res[1]);
		 } else {   permissionIds.put(Integer.valueOf(res[0]), "");}
				Set<Integer> tmpReids = new HashSet<Integer>();
				for (Integer in : resourceIds) {
					// 根据资源id获取资源的父id
					String resource_url = AppDefineInitServiceImpl.userCenterBaseUrl
							+ UserCenterPortConstants.RESOURCE_GETRESOURCE;
					String ResourceInfo = HttpClientUtil.sendget(resource_url, in, headerParams);
					JSONObject jsons = JSONObject.parseObject(ResourceInfo);
					System.out.println(ResourceInfo);
					if (null != jsons.get("resultState") && "00000".equals(jsons.get("resultState"))) {
						JSONObject json2 = (JSONObject)jsons.get("resultList");
						if(jsons.get("resultList")!=null){
							System.out.println(json2.get("parentId")+"==&*&*&*");
						if (json2.get("parentId")!="0"){
							tmpReids.add((Integer) json2.get("parentId"));						
						}
						}
					}
				}
				resourceIds.addAll(tmpReids);			
			}
		}
		// 遍历set集合
		System.out.println(resourceIds.toString()+"resourceIds.toString()");
		System.out.println(permissionId.toString()+"permissionId.toString()");
		for (Integer in : resourceIds) {
			JSONObject json = new JSONObject();
			System.out.println("in="+in);
			if(in!=0){		
			json.put("resourceId", in);			
			System.out.println("permissionIds.get(in)=="+permissionIds.get(in));
			if(permissionIds.get(in)==null){
				json.put("resourceId", in);
				System.out.println("permissionIds.get(in)=="+permissionIds.get(in));
				json.put("permissionIds",permissionId);
			}else{
			json.put("permissionIds",permissionIds.get(in));}
			authList.add(json);		
			}
			
		}
		System.out.println(authList.toString());
		// 保存角色信息

		JSONObject sendbody = new JSONObject();
		if (role != null) {
			String Role_url = "";
			JSONObject rolejson = new JSONObject();
			if (role.getId() == null || role.getId().equals("")) {
				System.out.println("增加");

				Role_url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ROLE_ADD;
			} else {
				rolejson.put("id", role.getId());
				Role_url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ROLE_UPDATE;
				System.out.println("修改");
			}

			rolejson.put("description", role.getDescription());
			rolejson.put("name", role.getName());
			rolejson.put("role", role.getRole());
			rolejson.put("status", role.getStatus());
			sendbody.put("authList", authList);
			sendbody.put("role", rolejson);
			// System.out.println(sendbody.toString());
			String RoleInfo = HttpClientUtil.postForInter(Role_url, sendbody.toString(), headerParams);
			System.out.println(RoleInfo);
			JSONObject json2 = JSONObject.parseObject(RoleInfo);
			if (null != json2.get("resultState") && "00000".equals(json2.get("resultState"))) {
				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "role/list");
			} else if (null != json2.get("resultState") && "1021016".equals(json2.get("resultState"))) {
				return new JsonEdit(StateInfoEnum.ROLE_BeUsed, "role/add");
			} else {
				return new JsonEdit(StateInfoEnum.DATA_FAILURE, "role/add");
			}

		}

		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "role/list");

	}

	/**
	 * 角色删除
	 *
	 */
	@RequestMapping(value = "/delete")
	@RequiresPermissions("role:delete")
	public @ResponseBody JsonEdit deleteView(Integer roleId, HttpServletRequest request) {
		System.out.println(roleId + "*&****");
		String userId = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
		headerParams.add(new BasicNameValuePair("appKey", UserCenterPortConstants.APPKEY));
		headerParams.add(new BasicNameValuePair("Content-Type", "application/json"));
		headerParams.add(new BasicNameValuePair("Client-Type", "web"));
		headerParams.add(new BasicNameValuePair("enterpriseCode", enterpriseCode));
		headerParams.add(new BasicNameValuePair("userId", userId));
		headerParams.add(new BasicNameValuePair("token", token));
		String signInfoTem = MD5Utils
				.GetMD5Code(securityCode + UserCenterPortConstants.APPKEY + enterpriseCode + userId + token);
		headerParams.add(new BasicNameValuePair("signInfo", signInfoTem));

		String Role_url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ROLE_DELETE;
		if (roleId != null) {
			String roleInfo = HttpClientUtil.sendget(Role_url, roleId, headerParams);
			JSONObject json = JSONObject.parseObject(roleInfo);

			if (null != json.get("resultState") && "00000".equals(json.get("resultState"))) {
				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "role/list");
			} else if (null != json.get("resultState") && "1021115".equals(json.get("resultState"))) {
				return new JsonEdit(StateInfoEnum.DATA_BeUsed, "role/list");
			}
		} else {
			return new JsonEdit(StateInfoEnum.DATA_FAILURE, "role/list");
		}

		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "role/list");

	}

	/**
	 * 获取资源树
	 */
	public String getRoleResourceTree(List<Resource> resourceList) {
		List<Resource> rootResources = new ArrayList<Resource>();
		// 放入根节点
		for (Resource res : resourceList) {
			if (res.getParenId().equals("0")) {
				rootResources.add(res);
			}
		}
		// 拼接资源树
		StringBuffer sb = new StringBuffer();
		sb.append("<ul id='resourceid" + "' class='tree treeFolder treeCheck expand'>");
		for (Resource rootResource : rootResources) {

			sb.append("<li><a tname='" + rootResource.getName() + "' tvalue='" + rootResource.getId() + "' fullName='"
					+ rootResource.getName() + "' isResource='" + rootResource.getIsResource() + "'>"
					+ rootResource.getName() + "</a>");
			createRoleResourceTree(getChildResources(rootResource.getId(), resourceList), resourceList, sb,
					rootResource.getName());
			sb.append("</li>");
		}
		sb.append("</ul>");

		return sb.toString();

	}

	/**
	 * 创建角色管理下的菜单树
	 */
	private void createRoleResourceTree(List<Resource> childResources, List<Resource> resourceList, StringBuffer sb,
			String fullName) {
		for (Resource res : childResources) {
			sb.append("<ul><li>");
			List<Resource> childs = getChildResources(res.getId(), resourceList);
			// String fName = fullName + "》" + res.getName();
			String fName = res.getName();
			sb.append("<a tname='" + res.getName() + "' tvalue='" + res.getId() + "' fullName='" + fName
					+ "' isResource='" + res.getIsResource() + "'>" + res.getName() + "</a>");
			if (!CollectionUtils.isEmpty(childs)) {
				createRoleResourceTree(childs, resourceList, sb, fName);
			}
			sb.append("</li></ul>");
		}
	}

	/**
	 * 获得节点的子资源
	 */
	public List<Resource> getChildResources(String resourceId, List<Resource> resourceList) {
		List<Resource> childResources = new ArrayList<Resource>();
		for (Resource res : resourceList) {
			if (res.getParenId().equals(resourceId)) {
				childResources.add(res);
			}
		}
		return childResources;
	}

	/**
	 * 已经分配的资源和权限
	 */
	public String getPermissList(String info, HttpServletRequest request) {
		String userId = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
		headerParams.add(new BasicNameValuePair("appKey", UserCenterPortConstants.APPKEY));
		headerParams.add(new BasicNameValuePair("Content-Type", "application/json"));
		headerParams.add(new BasicNameValuePair("Client-Type", "web"));
		headerParams.add(new BasicNameValuePair("enterpriseCode", enterpriseCode));
		headerParams.add(new BasicNameValuePair("userId", userId));
		headerParams.add(new BasicNameValuePair("token", token));
		String signInfoTem = MD5Utils
				.GetMD5Code(securityCode + UserCenterPortConstants.APPKEY + enterpriseCode + userId + token);
		headerParams.add(new BasicNameValuePair("signInfo", signInfoTem));
		JSONObject json = JSONObject.parseObject(info);
		StringBuilder sb = new StringBuilder();
		if (null != json.get("resultState") && "00000".equals(json.get("resultState"))) {
			if (json.getJSONArray("resultList") != null) {
				JSONArray list = json.getJSONArray("resultList");
				System.out.println(list.toString());

				for (int i = 0; i < list.size(); i++) {
					JSONObject jsons = (JSONObject) list.get(i);
					String template = "<tr>" + "<td align='center' style='width:45%'>"
							+ "<input type='hidden' name='permiss' value='" + jsons.getString("resourceId") + ";"
							+ jsons.getString("permissionIds") + "'>" + jsons.getString("resourceName") + "</td>"
							+ "<td align='center'  style='width:45%'>" + jsons.getString("permissionNames") + "</td>"
							+ "<td onClick='getDel(this)' align='center'  style='width:10%'>"
							+ "<a class='' href='javascript:;' style='color:blue;'>删除</a>" + "</td>" + "</tr>";
					sb.append(template);
				}
			}
		}
		return sb.toString();
	}

}
