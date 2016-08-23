<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>辅料箱码激活查询</title>
 <style type="text/css">
.total {
	display: block;
	overflow: hidden;
	height: 30px;
	line-height: 30px;
	border-style: solid;
	border-width: 1px 0;
	background-repeat: repeat-x;
	border-color: #b8d0d6;
	text-align: center;
}

.total span {
	display: inline-block;
	padding-left: 20px;
}
</style>
</head>
<body>
	<form id="pagerForm" method="post"
		action="${ctx}barcodeFlActiveInfo/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" /> 
		<input type="hidden" id="startDate" name="startDate" value="${startDate}" />
		<input type="hidden" id="endDate" name="endDate" value="${endDate}" />
		<input type="hidden" name="plancode" value="${barcodeFlActiveInfos.plancode}" /> 
		<input type="hidden" name="username" value="${barcodeFlActiveInfos.username}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="${ctx}barcodeFlActiveInfo/list">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">批次号：</td>
						<td><input id="" type="text" name="plancode"
							value="${barcodeFlActiveInfos.plancode}" /></td>
						<td class="searchContentTD">激活人员：</td>
						<td><input id="" type="text" name="username"
							value="${barcodeFlActiveInfos.username}" /></td>
						<td class="searchContentTD">激活时间：</td>
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
		<table class="table" width="100%" layoutH="136">
			<thead>
				<tr>
					<th width="10%" align="center">序号</th>
					<th width="20%" align="center">批次号</th>
					<th width="20%" align="center">激活人员</th>
					<th width="20%" align="center">箱码</th>
					<th width="10%" align="center">激活状态</th>
					<th width="20%" align="center">激活时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="barcodeFlActiveInfos" items="${page.dataList}">
					<tr target="sid_user" rel="${barcodeFlActiveInfos.barcodeFlActiveInfo}">
						<td align="center">${barcodeFlActiveInfos.barcodeFlActiveInfo}</td>
						<td align="center">${barcodeFlActiveInfos.plancode}</td>
						<td align="center">${barcodeFlActiveInfos.username}</td>
						<td align="center">${barcodeFlActiveInfos.barcodeBLevelFl}</td>
				        <td align="center">
						<c:choose>
						<c:when test="${barcodeFlActiveInfos.activateStatus == 1}">
						激活成功
						</c:when>
						<c:when test="${barcodeFlActiveInfos.activateStatus == 2}">
						激活失败
						</c:when>
						<c:when test="${barcodeFlActiveInfos.activateStatus == 3}">
						重复激活
						</c:when>
						</c:choose>
						</td>
						<td align="center">
						<fmt:formatDate value="${barcodeFlActiveInfos.avtivateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		
				<div class="total">
					<span style="display:inline-block;font-size: 13px;">激活成功总数：${totalSuccessNumber}</span>
					<span style="display:inline-block;font-size: 13px;">失败总数：${totalFailNumber}</span>
					<span style="display:inline-block;font-size: 13px;">重复激活总数：${totalRepeatNumber}</span>
				</div>
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
