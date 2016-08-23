<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	
</script>
</head>

<body>
	<form id="pagerForm" method="post"
		action="${ctx}unactiveprizeinfo/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" " /> <input
			type="hidden" id="startDate" name="startDate" value="${startDate}" />
		<input type="hidden" id="endDate" name="endDate" value="${endDate}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}unactiveprizeinfo/list" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">创建时间：</td>
						<td><input type="text" id="startDateTem" name="startDate"
							value="${startDate}" class="date" dateFmt="yyyy-MM-dd"
							readonly="true" /> 至 <input type="text" id="endDateTem"
							name="endDate" value="${endDate}" class="date"
							dateFmt="yyyy-MM-dd" readonly="true" /></td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<!-- <li>
								<a class="buttonActive" onclick="exportData()" href="javascript:void(0);">
									<span>导出(Excel)</span>
								</a>
						</li> -->
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
				<%-- <li><a class="edit"
					href="${ctx}scanTimeOrder/list"
					title="累计扫码兑奖查询" rel="system" target="navTab"><span>返回</span></a></li>
				<li class="line">line</li> --%>
			</ul>
		</div>
	</div>
	<div class="pageContent">
		<table class="table" width="100%" layoutH="136">
			<thead>
				<tr>
					<th align="center">单品码</th>
					<th align="center">辅料箱码ID</th>
					<th align="center">userID</th>
					<th align="center">openID</th>
					<th align="center">活动名称</th>
					<th align="center">奖项名称</th>				
					<th align="center">奖项金额</th>
					<th align="center">创建时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="unactivePrizeInfoVO"
					items="${unactivePrizeInfoVOList}">
					<tr target="sid_user"
						rel="${unactivePrizeInfoVO.unactivePrizeInfo.id}">
						<td align="center">${unactivePrizeInfoVO.unactivePrizeInfo.barcode}</td>
						<td align="center">${unactivePrizeInfoVO.encryptBarcodeBLevelFl}</td>
						<td align="center">${unactivePrizeInfoVO.unactivePrizeInfo.userId}</td>
						<td align="center">${unactivePrizeInfoVO.unactivePrizeInfo.openId}</td>
						<td align="center">${unactivePrizeInfoVO.name}</td>
						<td align="center">${unactivePrizeInfoVO.unactivePrizeInfo.prizeName}</td>
						<td align="center">${unactivePrizeInfoVO.prizeAmountStr}</td>
						<td align="center"><fmt:formatDate
								value="${unactivePrizeInfoVO.unactivePrizeInfo.createTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>

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
