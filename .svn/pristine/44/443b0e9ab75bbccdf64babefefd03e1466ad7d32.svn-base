<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	//查看详情
	function detail(scanCodeOrderId){		
		var jsonStr = {					
					tel:$("#tel").val(),
					duijiangStatus:$("#duijiangStatus").val(),
					scanCodeOrderIdTem:$("#scanCodeOrderId").val(),
					startDate:$("#startDate").val(),
					endDate:$("#endDate").val(),					
					scanCodeOrderId:scanCodeOrderId
				};
		 navTab.openTabLs("system","${ctx}scanTimeOrder/detail","累计扫码兑奖详情查询",{data:jsonStr});
	}
	
	//更改发货状态
	function sendDelivery(scanCodeOrderId){
		var jsonStr = {					
				tel:$("#tel").val(),
				duijiangStatus:$("#duijiangStatus").val(),
				scanCodeOrderIdTem:$("#scanCodeOrderId").val(),
				startDate:$("#startDate").val(),
				endDate:$("#endDate").val(),					
				scanCodeOrderId:scanCodeOrderId
			};
	 	navTab.openTabLs("system","${ctx}scanTimeOrder/sendDelivery","累计扫码兑奖发货状态查询",{data:jsonStr});
	}
</script>
</head>

<body>
	<form id="pagerForm" method="post"
		action="${ctx}scanTimeOrder/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" /> 
		<input type="hidden" id="scanCodeOrderId" name="scanCodeOrderId" value="${scanTimeOrder.scanCodeOrderId}" />		
		<input type="hidden" id="tel" name="tel" value="${scanTimeOrder.tel}" />
		<input type="hidden" id="duijiangStatus" name="duijiangStatus" value="${scanTimeOrder.duijiangStatus}" />
		
		<input type="hidden" id="startDate" name="startDate" value="${startDate}" />		
		<input type="hidden" id="endDate" name="endDate" value="${endDate}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}scanTimeOrder/list" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">订单号：</td>
						<td><input type="text" id="scanCodeOrderIdTem" name="scanCodeOrderId"
							value="${scanTimeOrder.scanCodeOrderId}" /></td>
						<td class="searchContentTD">电话号码：</td>
						<td><input type="text" id="telTem" name="tel"
							value="${scanTimeOrder.tel}" /></td>
						<td class="searchContentTD">领奖时间：</td>
						<td><input type="text" id="startDateTem" name="startDate"
							value="${startDate}" class="date" dateFmt="yyyy-MM-dd"
							readonly="true" /> 至 <input type="text" id="endDateTem"
							name="endDate" value="${endDate}" class="date"
							dateFmt="yyyy-MM-dd" readonly="true" /></td>
						<td class="searchContentTD">兑奖状态：</td>
						<td>	<select name="duijiangStatus" id="duijiangStatusTem" value="${scanTimeOrder.duijiangStatus}">
									<option value="">-请选择-</option>
									<option value="0" <c:if test="${scanTimeOrder.duijiangStatus eq 0}">selected="selected"</c:if> >未兑奖</option>
									<option value="1" <c:if test="${scanTimeOrder.duijiangStatus eq 1}">selected="selected"</c:if> >已兑奖</option>
								</select>
						</td>
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
					<th align="center">用户编号</th>
					<th align="center">用户姓名</th>
					<th align="center">订单号</th>
					<th align="center">联系电话</th>				
					<th align="center">创建时间</th>
					<th align="center">兑奖状态</th>
					<th align="center">发货状态</th>
					<th align="center">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="scanTimeOrder" items="${scanTimeOrderList}">
					<tr target="sid_user" rel="${scanTimeOrder.scanCodeOrderId}">
						<td align="center">${scanTimeOrder.userId}</td>
						<td align="center">${scanTimeOrder.name}</td>		
						<td align="center">${scanTimeOrder.scanCodeOrderId}</td>				
						<td align="center">${scanTimeOrder.tel}</td>	
						<td align="center"><fmt:formatDate value="${scanTimeOrder.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td align="center">
						<c:choose>
							<c:when test="${scanTimeOrder.duijiangStatus eq 0}">
								未兑奖
							</c:when>
							<c:when test="${scanTimeOrder.duijiangStatus eq 1}">
								已兑奖
							</c:when>						
						</c:choose>
						</td>
						<td>
							<c:choose>
							<c:when test="${scanTimeOrder.scanTimePrizeType eq 1}">
								<c:if test="${scanTimeOrder.status eq 0}">
									<c:if test="${scanTimeOrder.status eq 0}">
										<shiro:hasPermission name="scantimeorder:update">	
										<a style="color: blue" href="javascript:void(0)" title="确认发货" onclick="sendDelivery('${scanTimeOrder.scanCodeOrderId}')">未发货</a>
										</shiro:hasPermission>
									</c:if>
								</c:if>
								<c:if test="${scanTimeOrder.status eq 1}">
									已发货
								</c:if>	
							</c:when>
							<c:otherwise>
								无
							</c:otherwise>					
						</c:choose>
						</td>
						<td align="center">
							<a style="color: blue" href="javascript:void(0)" title="兑奖详情" onclick="detail('${scanTimeOrder.scanCodeOrderId}')">查看</a>
							
						</td>
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
