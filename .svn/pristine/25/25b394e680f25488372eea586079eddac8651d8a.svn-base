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
		<script type="text/javascript"> 
		//按步跳转
		function toStep(step,id){
			location = "${ctx}activity/toEdit?activityId="+id+"&step="+step;
		}
		</script>
	</head>
	<body style="width: 100%;background: #eee;">
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
						<img src="${ctx}images/activity/am_4_y.png" style="vertical-align: middle;cursor: pointer;" onclick="toStep(3,'${activityId}');"/>
					</td>
					<!-- 原第五步:参与门店 去掉,第六步变成第五步 -->
					<%-- <td>
						<img src="${ctx}images/activity/am_line_y.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_5_y.png" style="vertical-align: middle;cursor: pointer;" onclick="toStep(4,'${activityId}');"/>
					</td> --%>
					<td>
						<img src="${ctx}images/activity/am_line_y.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_6_y.png" style="vertical-align: middle;cursor: pointer;"/>
					</td>
				</tr>
			</table>
		</div>
		<div style="width: 90%;margin: 0px auto;border: 1px #cecece solid;background: #fff;padding: 30px 0px;height: 300px;">
			<div style="width: 90%;margin: 0px auto;font-size: 25px;color: #448a2f;padding: 20px 0px;">恭喜您，活动已经成功定义</div>
			<div style="width: 90%;margin: 0px auto;font-size: 16px;color: #448a2f;padding: 10px 0px;">活动需要您时时的维护，请您在活动投放以后建立维护活动数据的工作计划</div>
		</div>
		<div style="height: 20px;">&nbsp;</div>
	</body>
</html>
