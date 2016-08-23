package com.sigmatrix.sc.web.util;



import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.sigmatrix.sc.service.impl.AppDefineInitServiceImpl;
import com.sigmatrix.sc.utils.HttpClientUtil;
import com.sigmatrix.sc.utils.MD5Utils;
import com.sigmatrix.sc.web.global.UserCenterPortConstants;
import com.sigmatrix.sc.web.vo.AccountSearch;



/**
 * 使用HttpClient请求页面并返回json格式数据.
 * 对方接收的也是json格式数据。
 * 因此使用HttpGet。
 * */
public class json {
	
	public static void main(String[] args) throws JSONException {
		List<NameValuePair> headerParams=new ArrayList<NameValuePair>();
		headerParams.add(new BasicNameValuePair("Content-Type", "application/json;charset=utf8"));
		headerParams.add(new BasicNameValuePair("Client-Type", "jmeter-2.11"));
		headerParams.add(new BasicNameValuePair("appKey","ef361e29e49a4c199a5ea88f6d5d84cc"));
		headerParams.add(new BasicNameValuePair("enterpriseCode", "scld01"));
		headerParams.add(new BasicNameValuePair("userId", "1"));	
		String User_url="http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/authcToAuthority";		
		JSONObject json=new JSONObject();
		json.put("userName","admin");
		json.put("passWord", "e10adc3949ba59abbe56e057f20f883e");
		String UserInfo=HttpClientUtil.post(User_url,json.toString(),headerParams);
		System.out.println(UserInfo);//{"resultState":"00000","resultMsg":"用户登录成功","resultList":{"roleList":"*","securityCode":"074ae177a347d7c3d59259c651cb01a9a8655f301c7cde4f00e9265a1c934384","token":"ac6ff581ce5a793db2cb858a60e3500c","nickname":"四川蓝带管理员","tokenTimeout":1469120845877,"userId":1,"menuList":[],"authList":"*"}}		
		 JSONObject json2=new JSONObject(UserInfo);
		 System.out.println(json2.get("resultMsg"));
		 JSONObject json3=(JSONObject) json2.get("resultList");
		// System.out.println(json3.get("securityCode"));
		 String securityCode=(String) json3.get("securityCode");
		 String token=(String)json3.get("token");
		 String appKey="ef361e29e49a4c199a5ea88f6d5d84cc";
		 String enterpriseCode="scld01";
		 String userId="1";
		 String strs=securityCode+appKey+enterpriseCode+userId+token;
		 String signInfo=MD5Utils.GetMD5Code(strs);
		 headerParams.add(new BasicNameValuePair("token",token));
		 headerParams.add(new BasicNameValuePair("signInfo",signInfo));
//		 //查询我的信息
//		 String account_url="http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/account/profile";
//		 String accountInfo=HttpClientUtil.getForInterBody(account_url,headerParams);	
//		 System.out.println(accountInfo);
//		 JSONObject json4=new JSONObject(accountInfo);
//		 JSONObject json5=(JSONObject) json4.get("resultList");
//		 AccountSearch account = new AccountSearch();
//		 account.setMobilePhoneNumber((String.valueOf(json5.get("mobilePhoneNumber"))));
//		 System.out.println("accountInfo="+account.getMobilePhoneNumber());
//根据用户id查询　角色
//			String ACCOUNT_GETROLES_URL="http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/account/getRoles";
//			String accountRoleInfo=HttpClientUtil.sendget(ACCOUNT_GETROLES_URL,Integer.valueOf(userId), headerParams);
//			System.out.println(accountRoleInfo);
		 //查询用户信息
//		 String account_search="http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/account/search";
//		 JSONObject sendbodys=new JSONObject();
//		 sendbodys.put("pageNum","1");
//		 sendbodys.put("pageSize",5);
//		 String account_searchInfo=HttpClientUtil.post(account_search,sendbodys.toString() , headerParams);
//		 
//		 System.out.println("account_searchInfo"+account_searchInfo);
		 //根据域名获得企业信息
//		 String enterprise_search="http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/enterprise/search";
//		 JSONObject sendbody1=new JSONObject();
//		 sendbody1.put("word","localhost:8188/sigmatrix-system-admin");
//		 sendbody1.put("type", 0);
//		 String enterprise_searchInfo=HttpClientUtil.post(enterprise_search, sendbody1.toString(),null);
//		 System.out.println("enterprise_searchInfo===="+enterprise_searchInfo);
//		 String str="http://localhost:8188/sigmatrix-system-admin/login/beginLogin";
//		 String s=str.substring(str.indexOf("http://")+7,str.indexOf("/login/beginLogin"));
//		 System.out.println(s);
//		 sendbody1.put("type",1);
//		 sendbody1.put("word","sss");
//		 String enterprise_searchInfos=HttpClientUtil.post(enterprise_search, sendbody1.toString(),null);
//		 System.out.println("enterprise_searchInfo===="+enterprise_searchInfos);
		 //增加角色
//		 String role_url="http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/role/add";
//		 JSONObject sendbody=new JSONObject();
//		 JSONObject json_role=new JSONObject();
//		 json_role.put("role","2");	
//		 json_role.put("name","测试角色");
//		 json_role.put("role","ghust_group12");
//		 json_role.put("description","描述");		 
//		 json_role.put("status","1");
//		 sendbody.put("role",json_role);
//		 JSONObject authListjson1=new JSONObject();
//		 authListjson1.put("resourceId","1");
//		 authListjson1.put("permissionIds","");
//		 JSONObject authListjson2=new JSONObject();
//		 authListjson2.put("resourceId","2");
//		 authListjson2.put("permissionIds","1,2,3");
//		 List authList=new ArrayList<JSONObject>();
//		 authList.add(0, authListjson1);
//		 authList.add(1,authListjson2);
//		 sendbody.put("authList",authList);
//		 System.out.println(" sendbody=="+ sendbody.toString());
//		 String role_add=HttpClientUtil.post(role_url,sendbody.toString(), headerParams);
//		 System.out.println("role_add"+role_add);	
		 //查询资源
//		 String resource_list="http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/resource/search";
//		 JSONObject sendbody4=new JSONObject();
//		 System.out.println("sendbody=="+ sendbody4.toString());
//		 String resourceInfo=HttpClientUtil.postForInter(resource_list,sendbody4.toString(),headerParams);
//		 System.out.println(resourceInfo);
		//增加资源
//		 JSONObject sendbody5=new JSONObject();
//		 sendbody5.put("name","用户管理");
//		 sendbody5.put("identity","account");
//		 sendbody5.put("url","");
//		 sendbody5.put("parentId","6");
//		 sendbody5.put("icon","");
//		 sendbody5.put("isShow","true");
//		 sendbody5.put("status",1);		
//		 System.out.println("sendbody=="+ sendbody5.toString());
//		 String resource_add="http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/resource/add";
//		 String resourceInfos=HttpClientUtil.postForInter(resource_add,sendbody5.toString(),headerParams);
//		 System.out.println(resourceInfos);
	//根据资源id获取资源的父id 
			String resource_url="http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/resource/getResource";
			String ResourceInfo = HttpClientUtil.sendget(resource_url,20, headerParams);
			System.out.println(ResourceInfo);
//			JSONObject jsons = JSONObject.(ResourceInfo);
//			if (null != jsons.get("resultState") && "00000".equals(jsons.get("resultState"))) {
//				
//			}
		 //删除资源
//		 String resource_url = "http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/resource/delete";
//         String resource = HttpClientUtil.sendget(resource_url,6,headerParams);
//         System.out.println(resource);
		 //删除角色
//		 String Role_url = "http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/role/delete";
//         String roleInfo = HttpClientUtil.sendget(Role_url,1,headerParams);
//         System.out.println(roleInfo);
		 
		 //获取权限列表
//			String Permission_url ="http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/permission/list";
//			String PermissionInfo = HttpClientUtil.getForInter(Permission_url,null,headerParams);
//			System.out.println(PermissionInfo);
	}
	
}

