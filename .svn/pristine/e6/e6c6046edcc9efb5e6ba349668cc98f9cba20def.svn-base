<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	//查看详情
	function detail(prizeOrderId){
		
		var jsonStr = {					
					activityId:$("#activityId").val(),
					userId:$("#userId").val(),
					prizeType:$("#prizeType").val(),
					isType:$("#isType").val(),
					isStatus:$("#isStatus").val(),
					startDate:$("#startDate").val(),
					endDate:$("#endDate").val(),					
					prizeOrderId:prizeOrderId
				};
		 navTab.openTabLs("system","${ctx}winningInformation/detail","中奖信息查询",{data:jsonStr});
	}
	
	//导出excel
	function exportData(){						
			var	activityId = $("#activityIdTem").val();
			//alert(activityId);
			var	userId = $("#userIdTem").val();
			//alert(userId);
			var	prizeType = $("#prizeTypeTem").val();
			//alert(prizeType);
			var	isType = $("#isTypeTem").val();
			//alert(isType);
			var	isStatus = $("#isStatusTem").val();
			//alert(isStatus);
			var	startDate = $("#startDateTem").val();
			//alert(startDate);
			var	endDate = $("#endDateTem").val();
			//alert(endDate);
			//获取当前时间并判断是否符合格式要求
				var now = new Date();
				var nowDate = now.getFullYear()+"-"+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
				if(startDate > nowDate){
					alertMsg.error("更新时间不能大于当前时间!");
					return;
				}
				if(endDate != null && endDate != ""){
  				if(startDate > endDate){
  					alertMsg.error("请选择正确的时间区间!");
  					return;
  				}
				}
				location = "${ctx}winningInformation/exportData?activityId="+activityId
					+"&userId="+userId
					+"&prizeType="+prizeType
					+"&isType="+isType
					+"&isStatus="+isStatus
					+"&startDate="+startDate
					+"&endDate="+endDate;	 
				
	}
</script>
</head>

<body>
	<form id="pagerForm" method="post"
		action="${ctx}winningInformation/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" /> 
		<input type="hidden" id="activityId" name="activityId" value="${barcodePrizeConsumer.activityId}" />
		<input type="hidden" id="userId" name="userId" value="${barcodePrizeConsumer.userId}" />
		<input type="hidden" id="prizeType" name="prizeType" value="${barcodePrizeConsumer.prizeType}" />
		<input type="hidden" id="isType" name="isType" value="${barcodePrizeConsumer.isType}" />
		<input type="hidden" id="isStatus" name="isStatus" value="${barcodePrizeConsumer.isStatus}" />
		
		<input type="hidden" id="startDate" name="startDate" value="${startDate}" />		
		<input type="hidden" id="endDate" name="endDate" value="${endDate}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}winningInformation/list" method="post">
			<input type="hidden" id="activityIdTem" name="activityId" value="${barcodePrizeConsumer.activityId}" />
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">用户编号：</td>
						<td><input type="text" id="userIdTem" name="userId"
							value="${barcodePrizeConsumer.userId}" /></td>
						<td class="searchContentTD">更新时间：</td>
						<td><input type="text" id="startDateTem" name="startDate"
							value="${startDate}" class="date" dateFmt="yyyy-MM-dd"
							readonly="true" /> 至 <input type="text" id="endDateTem"
							name="endDate" value="${endDate}" class="date"
							dateFmt="yyyy-MM-dd" readonly="true" /></td>
						<td class="searchContentTD">奖项类型：</td>
						<td>	<select name="prizeType" id="prizeTypeTem" value="">
									<option value="">-请选择-</option>
									<option value="2" <c:if test="${barcodePrizeConsumer.prizeType eq 2}">selected="selected"</c:if> >红包</option>
									<option value="4" <c:if test="${barcodePrizeConsumer.prizeType eq 4}">selected="selected"</c:if> >积分</option>
									<option value="6" <c:if test="${barcodePrizeConsumer.prizeType eq 6}">selected="selected"</c:if> >定时红包</option>
								</select>
						</td>
						<td class="searchContentTD">活动类型：</td>
						<td>
								<select name="isType" id="isTypeTem" value="">
									<option value="">-请选择-</option>
									<option value="1" <c:if test="${barcodePrizeConsumer.isType eq 1}">selected="selected"</c:if> >扫码抽奖</option>
									<option value="2" <c:if test="${barcodePrizeConsumer.isType eq 2}">selected="selected"</c:if> >积分抽奖</option>
								</select>
						</td>
					</tr>
					<tr>
						<td class="searchContentTD">奖项状态：</td>
						<td>
						<select name="isStatus" id="isStatusTem" value="">
							<option value="">-请选择-</option>
							<option value="0" <c:if test="${barcodePrizeConsumer.isStatus eq 0}">selected="selected"</c:if> >已抽奖</option>
							<option value="1" <c:if test="${barcodePrizeConsumer.isStatus eq 1}">selected="selected" </c:if> >已领奖</option>
							<option value="2" <c:if test="${barcodePrizeConsumer.isStatus eq 2}">selected="selected" </c:if> >已兑奖</option>
							<option value="3" <c:if test="${barcodePrizeConsumer.isStatus eq 3}">selected="selected" </c:if> >放弃领奖</option>
							<option value="4" <c:if test="${barcodePrizeConsumer.isStatus eq 4}">selected="selected" </c:if> >领取失败</option>
							<option value="5" <c:if test="${barcodePrizeConsumer.isStatus eq 5}">selected="selected" </c:if> >分享中</option>
							<option value="6" <c:if test="${barcodePrizeConsumer.isStatus eq 6}">selected="selected" </c:if> >分享完毕</option>
						</select>
						</td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<li>
								<shiro:hasPermission name="winningInformation:export">	
								<a class="buttonActive" onclick="exportData()" href="javascript:void(0);">
									<span>导出(Excel)</span>
								</a>
								</shiro:hasPermission>
						</li>
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
				<li><a class="edit"
					href="${ctx}winningInformation/activelist"
					title="中奖信息查询" rel="system" target="navTab"><span>返回</span></a></li>
				<li class="line">line</li>
			</ul>
		</div>
	</div>
	<div class="pageContent">
		<table class="table" width="100%" layoutH="159">
			<thead>
				<tr>
					<th style="width: 7%;" align="center">用户编号</th>
					<th style="width: 19%;" align="center">单品码内容</th>
					<th style="width: 10%" align="center">活动</th>
					<th style="width: 10%" align="center">奖项金额(元)/积分</th>
					<th style="width: 8%" align="center">奖项类型</th>
					<th style="width: 9%" align="center">产品</th>
					<th style="width: 8%" align="center">奖项状态</th>
					<th style="width: 10%" align="center">活动类型</th>
					<th style="width: 12%" align="center">更新时间</th>
					<th style="width: 7%" align="center">详情</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="barcodePrizeConsumervo" items="${barcodePrizeConsumerList}">
					<tr target="sid_user" rel="${barcodePrizeConsumervo.barcodePrizeConsumer.prizeOrderId}">
						<td align="center">${barcodePrizeConsumervo.barcodePrizeConsumer.userId}</td>						
						<td align="center">${barcodePrizeConsumervo.barcodePrizeConsumer.barcode}</td>
						<td align="center">${barcodePrizeConsumervo.activityName}</td>
						<td align="center">
						<c:choose>
							<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.prizeType eq 4}">${barcodePrizeConsumervo.barcodePrizeConsumer.prizeIntegration }</c:when>
							<c:otherwise>${barcodePrizeConsumervo.prizeAmountStr}</c:otherwise>
						</c:choose>						
						</td>
						<td align="center">
							<c:choose>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.prizeType eq 2 and (barcodePrizeConsumervo.barcodePrizeConsumer.prizeAmount eq barcodePrizeConsumervo.barcodePrizeConsumer.totalAmount)}">红包</c:when>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.prizeType eq 2 and (barcodePrizeConsumervo.barcodePrizeConsumer.prizeAmount ne barcodePrizeConsumervo.barcodePrizeConsumer.totalAmount)}">红包+现金券</c:when>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.prizeType eq 4}">积分</c:when>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.prizeType eq 6}">定时红包</c:when>								
							</c:choose>
						</td>
						<td align="center">${barcodePrizeConsumervo.productName}</td>
						<td align="center">
							<c:choose>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.isStatus eq 0}">已抽奖</c:when>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.isStatus eq 1}">已领奖</c:when>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.isStatus eq 2}">已兑奖</c:when>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.isStatus eq 3}">放弃领奖</c:when>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.isStatus eq 4}">领取失败</c:when>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.isStatus eq 5}">分享中</c:when>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.isStatus eq 6}">分享完毕</c:when>
							</c:choose>
						</td>
						<td align="center">
							<c:choose>
								<c:when test="${barcodePrizeConsumervo.barcodePrizeConsumer.isType eq 1}">扫码</c:when>
								<c:otherwise>积分</c:otherwise>
							</c:choose>
						</td>
						<td align="center"><fmt:formatDate value="${barcodePrizeConsumervo.barcodePrizeConsumer.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td align="center"><a style="color: blue" href="javascript:void(0)" title="中奖详情" onclick="detail('${barcodePrizeConsumervo.barcodePrizeConsumer.prizeOrderId}')">查看</a></td>
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
