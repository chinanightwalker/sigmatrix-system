<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>成品箱码激活记录</title>
</head>
<body>
	<form id="pagerForm" method="post"
		action="${ctx}BarcodeBLevel/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" /> 
		<input type="hidden" id="startDate" name="startDate" value="${startDate}" />
		<input type="hidden" id="endDate" name="endDate" value="${endDate}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}BarcodeBLevel/list">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">更新时间：</td>
						<td>
						<input type="text" name="startDate" value="${startDate}" class="date" dateFmt="yyyy-MM-dd" readonly="true" /> 至 
						<input type="text" name="endDate" value="${endDate}" class="date" dateFmt="yyyy-MM-dd" readonly="true" /></td>
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
		<table class="table" width="100%" layoutH="112">
			<thead>
				<tr>
					<th width="20%" align="center">箱码</th>
					<th width="20%" align="center">激活状态</th>
					<th width="20%" align="center">码流转状态</th>
					<th width="20%" align="center">创建时间</th>
					<th width="20%" align="center">更新时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="barcodeBLevel" items="${page.dataList}">
					<tr target="sid_user" rel="${barcodeBLevel.encryptBarcodeBLevel}">
						<td align="center">${barcodeBLevel.encryptBarcodeBLevel}</td>
				        <td align="center">
						<c:choose>
						<c:when test="${barcodeBLevel.activateStatus == 1}">
						激活成功
						</c:when>
						<c:when test="${barcodeBLevel.activateStatus == 2}">
						未激活
						</c:when>
						</c:choose>
						</td>
						 <td align="center">
						<c:choose>
						<c:when test="${barcodeBLevel.isStatus == -1}">
						作废
						</c:when>
						<c:when test="${barcodeBLevel.isStatus == 0}">
						生产
						</c:when>
						<c:when test="${barcodeBLevel.isStatus == 1}">
						入库
						</c:when>
						<c:when test="${barcodeBLevel.isStatus == 2}">
						调拨入库
						</c:when>
						<c:when test="${barcodeBLevel.isStatus == 3}">
						调拨出库
						</c:when>
						<c:when test="${barcodeBLevel.isStatus == 4}">
						出库
						</c:when>
						<c:when test="${barcodeBLevel.isStatus == 5}">
						销售
						</c:when>
						</c:choose>						 
						 </td>
						
						<td align="center">
						<fmt:formatDate value="${barcodeBLevel.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                        <td align="center">
						<fmt:formatDate value="${barcodeBLevel.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
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
