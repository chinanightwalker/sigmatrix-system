<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>活动列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}css/pagination.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}css/business/activity/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${ctx}js/jquery.pagination.js"></script>
		<script type="text/javascript" src="${ctx}js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}js/common/general.js"></script>
		<script type="text/javascript" src="${ctx}js/business/activity/activityList.js"></script>
	</head>
	<body style="width: 100%; background: #eee;">
		<!-- 进行权限控制 -->
		<shiro:hasPermission name="activity:insert">
		<div
			style="width: 90%; border: 1px #d7d7d7 solid; background: #fff; margin: 20px auto 0px auto;">
			<div
				style="float: left; margin-left: 30px; height: 80px; line-height: 80px;">
			</div>
			<div
				style="float: right; margin-right: 30px; height: 80px; line-height: 80px;">
					<img src="${ctx}images/activity/am_001.png"
						style="vertical-align: middle; cursor: pointer;" onclick="toAdd('');" />
			</div>
			<div style="clear: both;"></div>
		</div>
		</shiro:hasPermission>
		<!-- 列表部分 -->
		<div style="width: 90%; margin: 20px auto 0px auto; background: #f5f5f5; border-left: 1px #d7d7d7 solid; border-right: 1px #d7d7d7 solid; border-top: 1px #d7d7d7 solid;">
			<div style="clear: both;"></div>
		</div>
		<div
			style="width: 90%; background: #fff; margin: 0px auto; border: 1px #d7d7d7 solid;">
			<table
				style="width: 100%; font-size: 12px; color: #666; text-align: center; table-layout: fixed;">
				<tr>
					<td style="color: #FF8D45; width: 15%; height: 45px;">
						活动标题
					</td>
					<td style="color: #FF8D45; width: 14%;">
						活动名称
					</td>
					<td style="color: #FF8D45; width: 14%;">
						活动角色
					</td>
					<td style="color: #FF8D45; width: 12%;">
						活动类型
					</td>
					
					
					<td style="color: #FF8D45; width: 12%;">
						未激活处理方式
					</td>
					
					
					<td style="color: #FF8D45; width: 8%;">
						扫码数量
					</td>
					<td style="color: #FF8D45; width: 10%;">
						开始时间
					</td>
					<td style="color: #FF8D45; width: 10%;">
						结束时间
					</td>
					<!-- 进行权限控制 -->
					<shiro:hasPermission name="activity:insert">
						<td style="color: #FF8D45; width: 8%;">
							开启状态
						</td>
					</shiro:hasPermission>
					<td style="color: #FF8D45; width: 15%;">
						操作
					</td>
				</tr>
				<c:forEach items="${activityList}" var="obj" varStatus="vstatus">
				<tr style="<c:if test="${vstatus.index%2==0}">background: #FBFBFA;</c:if><c:if test="${vstatus.index%2!=0}">background: #fff;</c:if>">
					<td
						style="height: 40px; border-top: 1px #e6e6e6 solid; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
						${obj.activityTitle }
					</td>
					<td
						style="height: 40px; border-top: 1px #e6e6e6 solid;">
						${obj.name }
					</td>
					<td style="height: 40px; border-top: 1px #e6e6e6 solid;">
						<c:choose>
							<c:when test="${obj.activityRole==0}">消费者</c:when>
							<c:when test="${obj.activityRole==1}">服务员</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</td>
					<td style="border-top: 1px #e6e6e6 solid;">
						<c:choose>
							<c:when test="${obj.type==1}">扫码</c:when>
							<c:when test="${obj.type==2}">轮盘</c:when>
							<c:when test="${obj.type==3}">即开即中</c:when>
							<c:when test="${obj.type==4}">九宫格</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</td>
					<td style="border-top: 1px #e6e6e6 solid;">
						${obj.firstPrizeIdName}
						<%-- <c:choose>
							<c:when test="${obj.unactiviteProcessType==0}">显示产品介绍</c:when>
							<c:when test="${obj.unactiviteProcessType==1}">选择最小的奖项</c:when>
						</c:choose> --%>
					</td>
					<td style="color: #333; border-top: 1px #e6e6e6 solid;">
						<c:choose>
							<c:when test="${not empty obj.scanCount}">${obj.scanCount }</c:when>
							<c:otherwise>0</c:otherwise>
						</c:choose>
					</td>
					<td style="border-top: 1px #e6e6e6 solid;">
						<fmt:formatDate pattern="yyyy-MM-dd" value="${obj.startDate}"/>
					</td>
					<td style="border-top: 1px #e6e6e6 solid;">
						<fmt:formatDate pattern="yyyy-MM-dd" value="${obj.endDate}"/>
					</td>
					<!-- 进行权限控制,true代表无权限,false才展示 -->
					<shiro:hasPermission name="activity:switch">
					<td style="border-top: 1px #e6e6e6 solid;">
						<button id="btn${obj.activityId }" class="mwui-switch-btn" onclick="changeStatus('${obj.activityId}','${obj.status }');" <c:if test="${obj.isOpen == 0}"> style='background:#bfbebe;'</c:if>>
							<span<c:if test="${obj.isOpen == 1}"> class='on'</c:if>></span>
						</button>
						<input type="hidden" name="show_icon" value="1" />
					</td>
					</shiro:hasPermission>
					<td style="border-top: 1px #e6e6e6 solid;">
						<shiro:hasPermission name="prize:search">
						<c:if test="${obj.step != null && obj.step > 2}">
							<img title="奖项配置"
								src="${ctx}images/activity/am_002.png"
								style="cursor: pointer; width: 22px; vertical-align: middle;"
								onclick="toEdit('${obj.activityId}','2');">
							&nbsp;
						</c:if>
						</shiro:hasPermission>
					<!-- 进行权限控制,true代表无权限,false才展示 -->
						<shiro:hasPermission name="activity:update">
						<c:if test="${obj.step == 5}">
						<img title="编辑"
							src="${ctx}images/activity/am_004.png"
							style="cursor: pointer; width: 22px; vertical-align: middle;"
							onclick="toEdit('${obj.activityId}','6');">
						</c:if>
						<c:if test="${obj.step != 5}">
						<img title="编辑"
							src="${ctx}images/activity/am_004.png"
							style="cursor: pointer; width: 22px; vertical-align: middle;"
							onclick="toEdit('${obj.activityId}','${obj.step }');">
						</c:if>
						</shiro:hasPermission>
						&nbsp;
						<shiro:hasPermission name="activity:delete">
						<img title="删除"
							src="${ctx}images/activity/am_005.png"
							style="cursor: pointer; width: 22px; vertical-align: middle;" onclick="deleteActivity('${obj.activityId}');">
						</shiro:hasPermission>
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
