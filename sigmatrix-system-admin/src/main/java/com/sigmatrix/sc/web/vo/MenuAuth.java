package com.sigmatrix.sc.web.vo;

import java.io.Serializable;

/** 
 * @author  zln:
 * @date 创建时间：2016年7月16日 下午4:09:22 
 * @parameter   
 * @return 
 */
public class MenuAuth implements Serializable {
	public MenuAuth(String menuId, String menuName, String menuUrl,
			String parentMenuId, String weight) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.parentMenuId = parentMenuId;
		this.weight = weight;
	}
	public MenuAuth() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	private String menuId;
	private String menuName;
	private String menuUrl;
	private String parentMenuId;
	private String weight;
}
