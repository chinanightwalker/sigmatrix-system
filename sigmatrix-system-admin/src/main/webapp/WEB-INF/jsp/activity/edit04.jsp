<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>新建活动</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}css/pagination.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}css/business/activity/edit.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${ctx}js/common/general.js"></script>
		<script type="text/javascript" src="${ctx}js/business/activity/activityEdit04.js"></script>
	</head>
	<body style="width: 100%;background: #eee;">
	<input type="hidden" id="activityId" name="activityId" value="${activity.activityId}">
	<input type="hidden" id="id" name="id" value="${id }">
		<div style="width: 90%;margin: 0px auto;padding: 15px 0px;">
			<table style="width: 90%;margin: 0px auto;">
				<tr>
					<td>
						<img src="${ctx}images/activity/am_1_y.png" style="vertical-align: middle;cursor: pointer;" onclick="toStep('','${activityId}');"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_line_y.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_2_y.png" style="vertical-align: middle;cursor: pointer;" onclick="toStep(1,'${activityId}');"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_line_y.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_3_y.png" style="vertical-align: middle;cursor: pointer;" onclick="toStep(2,'${activityId}');"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_line_y.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_4_2_y.png" style="vertical-align: middle;cursor: pointer;" onclick="toStep(3,'${activityId}');"/>
					</td>
					<!-- 原第五步:参与门店 去掉,第六步变成第五步 -->
					<%-- <td>
						<img src="${ctx}/images/activity/am_line_h.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}/images/activity/am_5_h.png" style="vertical-align: middle;"/>
					</td> --%>
					<td>
						<img src="${ctx}images/activity/am_line_h.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_6_h.png" style="vertical-align: middle;"/>
					</td>
				</tr>
			</table>
		</div>
			<div id="productJsp" style="width: 100%;background: #eee;">
			<div style="border: 1px #e1e1e1 solid;width: 90%;margin: 50px auto 20px auto;font-size: 14px;background: #fff;height: 450px;">
				<div style="width: 100%;background: #f5f5f5;border-bottom: 1px #e1e1e1 solid;color: #434343;padding: 15px 0px;">
					<span style="margin-left: 5%;">选择活动参与产品<font color="red">${isNotProduct==true?"(本活动已无产品可以绑定，无法参加营销活动)":""}</font></span>
				</div>
				<div style="width: 45%;padding: 10px 0px;float: left;margin-left: 3%;">
					<div style="width: 95%;margin: 0px auto;padding: 10px 0px;">可选产品列表：</div>
					<div  id="products" style="width: 95%;margin: 0px auto;height: 150px;overflow: auto;border: 1px #dad7d7 solid;padding: 5px 0px;">
						<c:forEach var="obj" items="${activityCanBindProduct}">
							<div style="width: 95%;margin: 0px auto;padding: 5px 0px;">
								<input type="checkbox" value="${obj.productId}" name="productId" />
			          			 ${obj.productName}
							</div>
						</c:forEach>
					</div>
				</div>
				<div style="width: 45%;padding: 10px 0px;float: right;margin-right: 3%;">
					<div style="width: 95%;margin: 0px auto;padding: 10px 0px;">活动已绑定产品：</div>
					<div style="width: 95%;margin: 0px auto;height: 150px;overflow: auto;border: 1px #dad7d7 solid;padding: 5px 0px;">
						<c:forEach var="obj2" items="${activityBindProduct}">
							<div id="unboundProductId${obj2.id }" style="width: 95%;margin: 0px auto;padding: 5px 0px;">
							<a href="javascript:void(0);"
							 onclick="UnboundProduct('${obj2.id }' , '${activity.activityId}');" 
							 style="color: #45a8da;font-size: 14px;">解绑定</a>
							${obj2.productBase.productName} 
							</div>
						</c:forEach>
					</div>
				</div>
				<div style="clear: both;"></div>
			</div>
			<div style="width: 90%;margin: 10px auto 0px auto;text-align: right;">
				<input type="button" onclick="saveActivityByStep();" value="下一步" style="width: 80px;text-align: center;height:28px;line-height: 28px;cursor: pointer;"/>
			</div>
			<div style="height: 20px;">&nbsp;</div>
		</div>
	</body>
</html>
