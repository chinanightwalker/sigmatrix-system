<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<form id="pagerForm" method="post" action="${ctx}ActivityTemplate/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" " /> <input
			type="hidden" name="templateName" value="${map['templateName'][0]}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}ActivityTemplate/list" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">模板名称：</td>
						<td><input type="text" name="templateName"
							value="${activityTemplate.templateName}" /></td>
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
				<shiro:hasPermission name="activityTemplate:insert">
					<li><a class="add" href="${ctx}ActivityTemplate/add"
						title="活动模板管理" rel="system" target="navTab"><span>添加</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="activityTemplate:delete">
					<li><a class="delete"
						href="${ctx}ActivityTemplate/delete?templateId={sid_user}"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="activityTemplate:update">
					<li><a class="edit"
						href="${ctx}ActivityTemplate/edit?templateId={sid_user}"
						title="活动模板管理" rel="system" target="navTab"><span>修改</span></a></li>
				</shiro:hasPermission>
				<li class="line">line</li>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="136">
			<thead>
				<tr>
					<th width="20%" align="center">模板名称</th>
					<th width="20%" align="center">模板路径</th>
					<th width="20%" align="center">模板绝对路径</th>
					<th width="20%" align="center">创建时间</th>
					<th width="20%" align="center">修改时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="activityTemplate" items="${page.dataList}">
					<tr target="sid_user" rel="${activityTemplate.templateId}">
						<td align="center">${activityTemplate.templateName}</td>
						<td align="center">${activityTemplate.templatePath}</td>
						<td align="center">${activityTemplate.templateRealPath}</td>
						<td align="center"><fmt:formatDate
								value="${activityTemplate.createTime}" type="both"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td align="center"><fmt:formatDate
								value="${activityTemplate.updateTime}" type="both"
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
