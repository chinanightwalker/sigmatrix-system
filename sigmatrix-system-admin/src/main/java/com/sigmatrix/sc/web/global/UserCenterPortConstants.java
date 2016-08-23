package com.sigmatrix.sc.web.global;
/**
 * 用户中心接口常量,用户中心接口主域名定义在resources.properties中的key：usercenter.base.domain.name
 * <br>这里主要定义子接口的路径,例如：查询企业信息的接口：/enterprise/{enterpriseUrl}
 * @author youjun
 *
 */
public class UserCenterPortConstants {
	/**用户中心请求头APPKEY*/
	public static final String APPKEY = "ef361e29e49a4c199a5ea88f6d5d84cc";
	/**查询所有企业信息接口*/
	public static final String ALL_ENTERPRISE_INFO_PORT = "/enterprise/list";
	/**根据域名或code查询单个企业信息接口*/
	public static final String SINGLE_ENTERPRISE_INFO_PORT = "/enterprise/search";
	/**用户登录接口,业务系统用户登录时调用此接口，返回用户权限信息*/
	public static final String ACCOUNT_AUTHORITY_PORT = "/authcToAuthority";
	/**查询我的信息接口*/
	public static final String ACCOUNT_INFO_PORT = "/account/profile";
	/**修改我的信息接口*/
	public static final String ACCOUNT_MODIFY_PORT = "/account/modifyProfile";
	/**修改密码接口*/
	public static final String ACCOUNT_CHGPWD = "/account/chgPwd";
	/** 查询权限接口*/
	public static final String PERMISSION_LIST = "/permission/list";
	/**查询用户接口*/
	public static final String ACCOUNT_SEARCH = "/account/search";
	/**添加用户接口*/
	public static final String ACCOUNT_ADD = "/account/add";
	/**更新用户接口*/
	public static final String ACCOUNT_UPDATE = "/account/update";
	/**删除用户接口*/
	public static final String ACCOUNT_DELETE = "/account/delete/";
	/**角色查询接口*/
	public static final String ROLE_SEARCH="/role/search";
	/**根据角色id查询资源权限接口**/
    public static final String ROLE_getResourcesAndPermissions="/role/getResourcesAndPermissions";
    /**根据角色id 查询角色信息**/
    public static final String ROLE_getRoleById="/role/getRole";
	/**角色增加接口*/
	public static final String ROLE_ADD="/role/add";
	/**角色删除接口*/
	public static final String ROLE_DELETE="/role/delete";
	/**角色更新接口*/
	public static final String ROLE_UPDATE="/role/update";
	/**查询资源接口 */
	public static final String RESOURCE_SEARCH="/resource/search";
	/**添加资源接口 */
	public static final String RESOURCE_ADD="/resource/add";
	/**删除资源接口 */
	public static final String RESOURCE_DELETE="/resource/delete";
	/**更新资源接口 */
	public static final String RESOURCE_UPDATE="/resource/update";
	/**查询用户拥有的角色接口*/
	public static final String ACCOUNT_GETROLES="/account/getRoles/";
	/**根据用户id获取用户信息接口*/
	public static final String ACCOUNT_GETACCOUNT="/account/getAccount/";
	/**根据资源ID查询资源*/
	public static final String RESOURCE_GETRESOURCE ="/resource/getResource/";
	
	
}
