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
		<script type="text/javascript" src="${ctx}js/business/activity/activityEdit01.js"></script>
	</head>
	<body style="width: 100%;background: #eee;">
		<div style="width: 90%;margin: 0px auto;padding: 15px 0px;">
			<table style="width: 90%;margin: 0px auto;">
				<tr>
					<td>
						<img src="${ctx}images/activity/am_1_y.png" style="vertical-align: middle;cursor: pointer;" onclick="toStep('','${activityId}');"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_line_h.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_2_h.png" style="vertical-align: middle;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_line_h.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_3_h.png" style="vertical-align: middle;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_line_h.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_4_2_h.png" style="vertical-align: middle;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_line_h.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_6_h.png" style="vertical-align: middle;"/>
					</td>
				</tr>
			</table>
		</div>
		<div style="width: 90%;margin: 0px auto;border: 1px #cecece solid;background: #fff;padding: 10px 0px 0px 0px;">
			<form id="activityFormForm" method="post">
				<input type="hidden" id="activityType" name="activity.type" value="${activity.type}"/>
				<input type="hidden" id="activityIsIntegral" name="activity.isIntegral" value="${activity.isIntegral}" />
				<input type="hidden" id="activityId" name="activity.activityId" value="${activity.activityId}"/>
			</form>
			<div style="width: 23%;float: left;margin-left: 10px;margin-bottom: 10px;border: 1px #E7E7E8 solid;position: relative;">
				<div style="width: 100%;background: #F3F0EE;padding-top: 5px;">
					<!-- 体验图标 -->
					<div style="width: 60%;margin: 0px auto;position: relative;">
						<img id="1" class="mychick" src="${ctx}images/activity/lunpan.png" style="width: 100%;cursor: pointer;"/>
						<!-- 选中图标 -->
						<img class="chick_flag"  src="${ctx}images/activity/isCheck_flag.png" style="position: absolute;top: 0;right: 0;width: 45px;display: none;"/>
					</div>
				</div>
				<div style="width: 100%;font-size: 16px;color: #2A2B2B;text-align: center;padding: 5px 0px;">扫码</div>
			</div>
			<div style="clear: both;"></div>
		</div>
		<div style="width: 90%;margin: 10px auto 0px auto;text-align: right;">
			<input onclick="saveActivityByStep();" type="button" value="下一步" style="width: 80px;text-align: center;height:28px;line-height: 28px;cursor: pointer;"/>
		</div>
		<div style="height: 20px;">&nbsp;</div>
	</body>
</html>
