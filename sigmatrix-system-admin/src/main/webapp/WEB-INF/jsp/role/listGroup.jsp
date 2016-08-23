<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="${ctx}js/common/general.js"></script>
  	<script type="text/javascript" src="${ctx}js/business/activity/activity.js"></script>
  	<script type="text/javascript">
	function navTabAjaxDone(json){
		if(json.statusCode == DWZ.statusCode.error){
			alertMsg.error(json.message);
			return;
		}else if (json.statusCode == DWZ.statusCode.ok){
			alertMsg.correct(json.message);
            navTab.closeCurrentTab();
            navTab.openTabLs(json.navTabId,'${ctx}'+json.forwardUrl,"角色管理");
      	}else if(json.statusCode=='0000'){
      		alertMsg.error(json.message);
      		navTab.closeCurrentTab();
            navTab.openTabLs(json.navTabId,'${ctx}'+json.forwardUrl,"角色管理");
      	}
      	else if(json.statusCode=='0001'){
      		alertMsg.error(json.message);
      		navTab.closeCurrentTab();
            navTab.openTabLs(json.navTabId,'${ctx}'+json.forwardUrl,"角色管理");
      	}
	}
  	</script>
</head>

<body>
	<form id="pagerForm" method="post" action="${ctx}role/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" " /> <input
			type="hidden" name="name" value="${name}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}role/list"
			method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">角色名称：</td>
						<td><input type="text" name="name" value="${name}" /></td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<li>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">检索</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<shiro:hasPermission name="role:insert">
					<li><a class="add" href="${ctx}role/add" title="角色管理"
						rel="system" target="navTab"><span>添加</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="role:delete">
					<li><a class="delete"
						href="${ctx}role/delete?roleId={sid_role}" target="ajaxTodo"
						title="确定要删除吗?"><span>删除</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="role:update">
					<li><a class="edit" href="${ctx}role/edit?roleId={sid_role}"
						title="角色管理" rel="system" target="navTab"><span>修改</span></a></li>
				</shiro:hasPermission>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="137">
			<thead>
				<tr>
					<th width="15%" align="center">角色编号</th>
					<th width="15%" align="center">角色名称</th>
					<th width="15%" align="center">角色标识</th>
					<th width="15%" align="center">角色描述</th>
					<th width="15%" align="center">最后修改时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="role" items="${roleList}">
					<tr target="sid_role" rel="${role.id}">
						<td align="center">${role.id}</td>
						<td align="center">${role.name}</td>
						<td align="center">${role.role}</td>
						<td align="center">${role.description}</td>
						<td align="center">${role.updateTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>
