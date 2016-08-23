<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript" src="${ctx}js/common/general.js"></script>
  	<script type="text/javascript" src="${ctx}js/business/activity/activity.js"></script>
  	<script type="text/javascript">
  //查看详情
	function detail(scanTimePrizeId){	
		var jsonStr = {	
				scanTimePrizeName:$("#scanTimePrizeName").val(),
				scanTimePrizeId:scanTimePrizeId
				};
		 navTab.openTabLs("system","${ctx}userScanPrize/detail","奖项设置详情查询",{data:jsonStr});
	}
	
  	</script>
  </head>

<body>
	<form id="pagerForm" method="post" action="${ctx}userScanPrize/list">
		<input type="hidden" name="scanTimePrizeName" value="${scanTimePrizeName}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}userScanPrize/list" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">奖项名称：</td>
						<td><input type="text" id="scanTimePrizeName" name="scanTimePrizeName"
							value="${scanTimePrizeName}" /></td>
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
					<shiro:hasPermission name="userscancodetimeprize:insert">				
					<li><a class="add" href="${ctx}userScanPrize/add"
						title="新增奖项" rel="system" target="navTab"><span>新增</span></a></li>
						</shiro:hasPermission>
					<shiro:hasPermission name="userscancodetimeprize:delete">	
					<li><a class="delete" href="${ctx}userScanPrize/delete?scanTimePrizeId={sid_user}" rel="system" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="userscancodetimeprize:update">
					<li><a class="edit" href="${ctx}userScanPrize/edit?scanTimePrizeId={sid_user}" title="修改奖项" rel="system" target="navTab"><span>修改</span></a></li>
					</shiro:hasPermission>
					<li class="line">line</li>
				
		</div>
	</div>
	
	<div class="pageContent">
		<table class="table" width="100%" layoutH="136">
			<thead>
				<tr>
					<th align="center">奖项名称</th>
					<th align="center">扫码次数</th>
					<th align="center">奖项金额(元)</th>
					<th align="center">创建时间</th>
					<th align="center">操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="userScanCodeTimePrizeVo" items="${userScanCodeTimePrizeVOList}">
					<tr target="sid_user" rel="${userScanCodeTimePrizeVo.userScanCodeTimePrize.scanTimePrizeId}">
					    <td align="center">${userScanCodeTimePrizeVo.userScanCodeTimePrize.scanTimePrizeName}</td>
						<td align="center">${userScanCodeTimePrizeVo.userScanCodeTimePrize.useScanTime}</td>
						<td align="center">${userScanCodeTimePrizeVo.scanTimePrizeAmountStr}</td>
						<td align="center"><fmt:formatDate value="${userScanCodeTimePrizeVo.userScanCodeTimePrize.createTime}" type="both" pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td align="center">
						<a style="color: blue" href="javascript:void(0)" title="兑奖详情" onclick="detail('${userScanCodeTimePrizeVo.userScanCodeTimePrize.scanTimePrizeId}')">查看</a>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="panelBar">
			<div class="pages">
				<%-- <span>显示${page.pageSize}</span> <span>条，共${page.total}条</span> --%>
			</div>
			<div></div>
		</div>
	</div>

</body>
</html>
