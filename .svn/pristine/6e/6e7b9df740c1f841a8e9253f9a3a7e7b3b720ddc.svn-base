<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<form id="pagerForm" method="post" action="${ctx}settings/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" /> <input
			type="hidden" name="key" value="${key}" /> <input type="hidden"
			name="name" value="${name}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}settings/list" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">键：</td>
						<td><input type="text" name="key" value="${settings.key}" />
						</td>
						<td class="searchContentTD">名称：</td>
						<td><input type="text" name="name" value="${settings.name}" />
						</td>
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
				<shiro:hasPermission name="settings:insert">
					<li><a class="add" href="${ctx}settings/add" title="新增系统设置项"
						rel="system" target="navTab"><span>新增</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="settings:delete">
					<li><a class="delete"
						href="${ctx}settings/delete?settingId={sid_user}"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="settings:update">
					<li><a class="edit"
						href="${ctx}settings/edit?settingId={sid_user}" title="修改系统设置项"
						rel="system" target="navTab"><span>修改</span></a></li>
				</shiro:hasPermission>
				<li class="line">line</li>
			</ul>
		</div>
	</div>
	<div class="pageContent">
		<table class="table" width="100%" layoutH="140">
			<thead>
				<tr>
					<th width="25%" align="center">键</th>
					<th width="25%" align="center">值</th>
					<th width="25%" align="center">名称</th>
					<th width="25%" align="center">创建时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="settings" items="${page.dataList}">
					<tr target="sid_user" rel="${settings.id}">
						<td align="center">${settings.key}</td>
						<td align="center">${settings.value}</td>
						<td align="center">${settings.name}</td>
						<td align="center"><fmt:formatDate
								value="${settings.createTime}" type="both"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="panelBar">
			<div class="pages">
				<span>显示${page.pageSize}</span> <span>条，共${page.total}条</span>
			</div>
			<div class="pagination" targetType="navTab"
				totalCount="${page.total}" numPerPage="${page.pageSize}"
				pageNumShown="10" currentPage="${page.pageNo}"></div>
		</div>
	</div>

</body>
</html>
