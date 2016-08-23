<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
   <form id="pagerForm" method="post" action="${ctx}winningInformation/activelist">
		<input type="hidden" name="pageNum" value="${page.pageNo}" />
		<input type="hidden" name="activityTitle" value="${activity.activityTitle}" />
	</form>
	<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="${ctx}winningInformation/activelist" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td class="searchContentTD">
						活动标题：
					</td>
					<td>
						<input type="text" name="activityTitle" value="${activity.activityTitle}" />
					</td>
					<%-- <td class="searchContentTD">
						活动id：
					</td>
					<td>
						<input type="text" name="activityId" value="${activity.activityId}" />
					</td> --%>
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
			
			<li><a class="edit" href="${ctx}winningInformation/list?activityId={sid_user}" title="查询中奖记录" rel="system" target="navTab"><span>查看中奖信息</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
</div>
<div class="pageContent">
	<table class="table" width="100%" layoutH="136">
		<thead>
			<tr>
				<th width="15%" align="center">
					活动标题
				</th>
				
				<th width="15%" align="center">
					活动类型
				</th>
				<th width="15%" align="center">
					是否积分抽奖
				</th>
				<th width="15%" align="center">
					活动开始日期
				</th>
				
				<th width="15%" align="center">
					活动结束日期
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="activity" items="${page.dataList}">
				<tr  target="sid_user" rel="${activity.activityId}">
					<td align="center">
						${activity.activityTitle}
					</td>
					<td align="center">
						<c:choose>
							<c:when test="${activity.type eq 1}">扫码</c:when>
							<c:when test="${activity.type eq 2}">轮盘</c:when>
							<c:when test="${activity.type eq 3}">即开即中</c:when>
							<c:otherwise>九宫格</c:otherwise>							
						</c:choose>						
					</td>
					<td align="center">
						<c:choose>
							<c:when test="${activity.isIntegral eq 0}">是</c:when>
							<c:otherwise>否</c:otherwise>
						</c:choose>
					</td>
					<td align="center">			
						<fmt:formatDate value="${activity.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td align="center">						
						<fmt:formatDate value="${activity.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
