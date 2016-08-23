package com.sigmatrix.sc.web.vo;

import java.io.Serializable;

/**
 * @author
 * @date 创建时间：2016年7月15日 下午1:34:13
 * @parameter 4.10查询角色接口
 * @return
 */
public class Role implements Serializable {
	/**
	 * 资源主键ID
	 */
	private Integer resourceId;

	/**
	 * 权限主键ID集合
	 */
	private String permissionIds;
	// 资源组名称
	private String resourceNames;
	private String permissionNames;
	// 权限组名称

	// 角色ID
	private String id;

	// 角色名称
	private String name;
	// 企业ID
	private String enterpriseId;
	// 角色标识
	private String role;
	// 角色描述
	private String description;
	// 状态：-1删除；0停用；1正常
	private String status;
	// 创建时间
	private String createTime;
	// 创建者用户主键ID
	private String createId;
	// 最后修改时间
	private String updateTime;
	// 最后修改者用户主键ID
	private String updateId;
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public String getPermissionIds() {
		return permissionIds;
	}
	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}
	public String getResourceNames() {
		return resourceNames;
	}
	public void setResourceNames(String resourceNames) {
		this.resourceNames = resourceNames;
	}
	public String getPermissionNames() {
		return permissionNames;
	}
	public void setPermissionNames(String permissionNames) {
		this.permissionNames = permissionNames;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public Role(Integer resourceId, String permissionIds, String resourceNames, String permissionNames, String id,
			String name, String enterpriseId, String role, String description, String status, String createTime,
			String createId, String updateTime, String updateId) {
		super();
		this.resourceId = resourceId;
		this.permissionIds = permissionIds;
		this.resourceNames = resourceNames;
		this.permissionNames = permissionNames;
		this.id = id;
		this.name = name;
		this.enterpriseId = enterpriseId;
		this.role = role;
		this.description = description;
		this.status = status;
		this.createTime = createTime;
		this.createId = createId;
		this.updateTime = updateTime;
		this.updateId = updateId;
	}
	public Role() {
		super();
	}
}
