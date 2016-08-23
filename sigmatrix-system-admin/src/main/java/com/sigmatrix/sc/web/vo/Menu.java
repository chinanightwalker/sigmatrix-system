package com.sigmatrix.sc.web.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于系统菜单配置功能的页面数据封装,数据来源于SysMenu实体
 * 
 * @author youjun
 *
 */
public class Menu {

	private Integer sysMenuId;
	/** 菜单名称 */
	private String sysMenuName;
	/** 菜单url */
	private String sysMenuUrl;
	/** 是否有子菜单,1是0否 */
	private Integer isHaveChild;
	private List<Menu> childMenu = new ArrayList<Menu>();

	public Menu() {

	}
	/**
	 * 构建菜单
	 * @param sysMenuName 菜单名称
	 * @param sysMenuUrl 菜单url,父菜单为null
	 * @param isHaveChild 是否有子菜单,1是0否
	 */
	public Menu(String sysMenuName, String sysMenuUrl, Integer isHaveChild){
		this.sysMenuName = sysMenuName;
		this.sysMenuUrl = sysMenuUrl;
		this.isHaveChild = isHaveChild;
	}

	public List<Menu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<Menu> childMenu) {
		this.childMenu = childMenu;
	}

	/**
	 * 设置是否有子菜单,1是0否
	 * 
	 * @param isHaveChild
	 */
	public void setIsHaveChild(Integer isHaveChild) {
		this.isHaveChild = isHaveChild;
	}

	/**
	 * 获得是否有子菜单,1是0否
	 * 
	 * @return
	 */
	public Integer getIsHaveChild() {
		return isHaveChild;
	}

	public Integer getSysMenuId() {
		return sysMenuId;
	}

	public void setSysMenuId(Integer sysMenuId) {
		this.sysMenuId = sysMenuId;
	}

	public String getSysMenuName() {
		return sysMenuName;
	}

	public void setSysMenuName(String sysMenuName) {
		this.sysMenuName = sysMenuName;
	}

	public String getSysMenuUrl() {
		return sysMenuUrl;
	}

	public void setSysMenuUrl(String sysMenuUrl) {
		this.sysMenuUrl = sysMenuUrl;
	}

}
