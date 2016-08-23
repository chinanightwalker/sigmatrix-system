<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
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
	            navTab.openTab(json.navTabId,'${ctx}'+json.forwardUrl,"过渡页管理");
	      	}
		}
  </script>
</head>

<body>
	<form id="pagerForm" method="post"
		action="${ctx}productTransitionage/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" /> <input
			type="hidden" name="activityId" value="${transition.productId}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}productTransitionage/list" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">产品名称：</td>
						<td><select name="productId">
								<option value="">-请选择-</option>
								<c:forEach var="obj" items="${productList}">
									<option value="${obj.productId}"
										<c:if test="${transition.productId==obj.productId}">selected="selected"</c:if>>${obj.productName}</option>
								</c:forEach>
						</select></td>
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
				<shiro:hasPermission name="productTransitionage:insert">
					<li><a class="add" href="${ctx}productTransitionage/toEdit"
						title="新增产品过渡页" rel="system" target="navTab"><span>新增</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="productTransitionage:delete">
					<li><a class="delete"
						href="${ctx}productTransitionage/remove/{transitionId}"
						target="ajaxTodo" rel="system" title="确定要删除吗?"><span>删除</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="productTransitionage:update">
					<li><a class="edit"
						href="${ctx}productTransitionage/toUpdate/{transitionId}"
						title="修改产品过渡页" rel="system" target="navTab"><span>修改</span></a></li>
				</shiro:hasPermission>
				<li class="line">line</li>
			</ul>
		</div>
	</div>
	<div class="pageContent">
		<table class="table" width="100%" layoutH="140">
			<thead>
				<tr>
					<th width="20%" align="center">产品名称</th>
					<th width="20%" align="center">开始时间</th>
					<th width="20%" align="center">结束时间</th>
					<th width="20%" align="center">是否启用</th>
					<th width="20%" align="center">创建时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="scancodeTransition" items="${page.dataList}">
					<tr target="transitionId" rel="${scancodeTransition.transitionId}">
						<td align="center">${scancodeTransition.productName}</td>
						<td align="center"><fmt:formatDate
								value="${scancodeTransition.startTime}"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td align="center"><fmt:formatDate
								value="${scancodeTransition.endTime}"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td align="center"><c:choose>
								<c:when test="${scancodeTransition.isOpen eq 0}">停用</c:when>
								<c:when test="${scancodeTransition.isOpen eq 1}">启用</c:when>
								<c:otherwise>未定义</c:otherwise>
							</c:choose></td>
						<td align="center"><fmt:formatDate
								value="${scancodeTransition.createTime}"
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
