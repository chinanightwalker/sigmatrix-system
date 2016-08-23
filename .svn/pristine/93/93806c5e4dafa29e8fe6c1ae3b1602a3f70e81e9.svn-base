<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="${ctx}js/common/general.js"></script>
  <script type="text/javascript">
		function navTabAjaxDone(json){
			if(json.statusCode == DWZ.statusCode.error){
				alertMsg.error(json.message);
				return;
			}
			if (json.statusCode == DWZ.statusCode.ok){
	            alertMsg.correct(json.message);
	            navTab.openTab(json.navTabId,'${ctx}'+json.forwardUrl,"账户管理");
	      	}
		}
  </script>
  </head>
  
  <body>
   <form id="pagerForm" method="post" action="${ctx}account/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" />
		<input type="hidden" name="userName" value="${userName}" />
		<input type="hidden" name="roleId" value="${roleId}" />
		
	</form>
	<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="${ctx}account/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td class="searchContentTD">
						账户名称：
					</td>
					<td>
						<input type="text" name="userName" value="${userName}" />
					</td>
					<td class="searchContentTD">
						角色ID：
					</td>
					<td>
						<input type="text" name="roleId" value="${roleId}" />
					</td>
					
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									检索
								</button>
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
			<shiro:hasPermission name="account:insert">
			<li><a class="add" href="${ctx}account/add" title="账户管理" rel="system" target="navTab"><span>添加</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="account:delete">
			<li><a class="delete" href="${ctx}account/remove?id={sid_user}" rel="system" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="account:update">
			<li><a class="edit" href="${ctx}account/edit?id={sid_user}" title="账户管理" rel="system" target="navTab"><span>修改</span></a></li>
			</shiro:hasPermission>
	
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="136">
		<thead>
			<tr>
				<th width="" align="center">
					账户编号
				</th>
				<th width="" align="center">
					账户名称
				</th>
				<th width="" align="center">
					手机号码
				</th>
				<th width="" align="center">
					Email
				</th>
				<th width="" align="center">
					状态
				</th>
				<th width="" align="center">
					创建时间
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${list}">
				<tr  target="sid_user" rel="${obj.id}">
					<td align="center">
						${obj.id}
					</td>
					<td align="center">
						${obj.userName}
					</td>
					<td align="center">
						${obj.mobilePhoneNumber}
					</td>
					<td align="center">
						${obj.email}
					</td>
					<td align="center">
						
						<c:choose>
							<c:when test="${obj.status eq -1}">已删除</c:when>
							<c:when test="${obj.status eq 0}">未激活</c:when>
							<c:when test="${obj.status eq 1}">正常</c:when>
						</c:choose>
					</td>
					<td align="center">
						${obj.createTime}
					</td>
				</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<div class="panelBar">
			<div class="pages">
				<span>显示${page.pageSize}</span>
				<span>条，共${page.total}条</span>
			</div>
			<div class="pagination" targetType="navTab" totalCount="${page.total}" numPerPage="${page.pageSize}" pageNumShown="10" currentPage="${page.pageNo}"></div>
		</div>
	</div>

  </body>
</html>
