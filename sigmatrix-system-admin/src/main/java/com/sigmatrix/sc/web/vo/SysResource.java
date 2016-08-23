package com.sigmatrix.sc.web.vo;

import java.io.Serializable;

/** 
 * @author  
 * @date 创建时间：2016年7月15日 下午1:39:51 
 * @parameter 4.14查询资源接口 
 * @return 
 */
public class SysResource implements Serializable {

	public SysResource() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String id;
	public SysResource(String id, String name, String enterpriseId,
			String identity, String url, String parentId, String parentIds,
			String icon, String weight, String isResource, String isShow,
			String status, String createTime, String createId,
			String updateTime, String updateId) {
		super();
		this.id = id;
		this.name = name;
		this.enterpriseId = enterpriseId;
		this.identity = identity;
		this.url = url;
		this.parentId = parentId;
		this.parentIds = parentIds;
		this.icon = icon;
		this.weight = weight;
		this.isResource = isResource;
		this.isShow = isShow;
		this.status = status;
		this.createTime = createTime;
		this.createId = createId;
		this.updateTime = updateTime;
		this.updateId = updateId;
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
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentIds() {
		return parentIds;
	}
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getIsResource() {
		return isResource;
	}
	public void setIsResource(String isResource) {
		this.isResource = isResource;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
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
	private String name;
	private String enterpriseId;
	private String identity;
	private String url;
	private String parentId;
	private String parentIds;
	private String icon;
	private String weight;
	private String isResource;
	private String isShow;
	private String status;
	private String createTime;
	private String createId;
	private String updateTime;
	private String updateId;
}
