package com.sigmatrix.sc.web.vo;

import java.io.Serializable;

/** 
 * @author  
 * @date 创建时间：2016年7月15日 下午1:39:51 
 * @parameter 4.14查询资源接口 
 * @return 
 */
public class Resource implements Serializable {

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resource(String id, String name, String enterpriseId,
			String identity, String url, String parenId, String parentIds,
			String icon, String weight, String resourceType, String isResource,
			String isShow, String status, String createTime, String createId,
			String updateTime, String updateId) {
		super();
		this.id = id;
		this.name = name;
		this.enterpriseId = enterpriseId;
		this.identity = identity;
		this.url = url;
		this.parenId = parenId;
		this.parentIds = parentIds;
		this.icon = icon;
		this.weight = weight;
		this.resourceType = resourceType;
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
	public String getParenId() {
		return parenId;
	}
	public void setParenId(String parenId) {
		this.parenId = parenId;
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
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
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
	//资源ID
	private String id;
	//资源名称
	private String name;	
	//企业ID
	private String enterpriseId;
	//资源身份标识
	private String identity;
	//资源请求地址
	private String url;
	//父资源主键ID
	private String parenId;
	//父资源主键ID集合0\1\10
	private String parentIds;
	//资源图标
	private String icon;
	//权重
	private String weight;
	//资源类型1:用户中心，2：企业运营，3：其他资源
	private String resourceType;
	//是否是资源：0否；1是
	private String isResource;
	//是否显示：0不显示；1显示；
	private String isShow;
	//状态：-1删除；0停用；1正常；
	private String status;
	//创建时间
	private String createTime;	
	//创建者用户主键ID
	private String createId;	
	//最后修改时间
	private String updateTime;	
	//最后修改者用户主键ID
	private String updateId;
}
