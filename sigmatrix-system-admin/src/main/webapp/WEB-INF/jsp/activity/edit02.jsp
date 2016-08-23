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
		<script type="text/javascript" src="${ctx}js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}js/ckeditor/ckeditor.js"></script>
		<script type="text/javascript">CKEDITOR.replace('activity.comments');</script>
		<script type="text/javascript" src="${ctx}js/ajaxfileupload.js"></script>
		<script type="text/javascript" src="${ctx}js/common/general.js"></script>
		<script type="text/javascript" src="${ctx}js/business/activity/activityEdit02.js"></script>
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
		<div style="width: 90%;margin: 0px auto;border: 1px #cecece solid;background: #fff;padding: 30px 0px;">
			<form id="activityForm" action="" method="post">
			<input type="hidden" id="activityId" name="activityId" value="${activity.activityId}"/>
			<input type="hidden" name="step" value="2"/>
				<table style="width: 80%;margin: 0px auto;font-size: 14px;">
					<tr>
						<td style="padding: 10px 0px;width: 18%;">活动名称:</td>
						<td style="padding: 10px 0px;">
							<input name="name" maxlength="20" value="${activity.name }" type="text" style="width: 40%;border: 1px #B4D1D3 solid;"/><span style="color: #B70000;">*</span>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px 0px;width: 18%;">活动标题:</td>
						<td style="padding: 10px 0px;">
							<input name="activityTitle" maxlength="20" value="${activity.activityTitle }" type="text" style="width: 40%;border: 1px #B4D1D3 solid;"/><span style="color: #B70000;">*</span>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px 0px;">活动时间:</td>
						<td style="padding: 10px 0px;">
							<input name="startDate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${activity.startDate}"/>" type="text" style="width: 20%;border: 1px #B4D1D3 solid;" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d %H:%m:%s'})"/><span style="color: #B70000;">*</span>
							 至 <input name="endDate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${activity.endDate}"/>" type="text" style="width: 20%;border: 1px #B4D1D3 solid;" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d %H:%m:%s'})"/><span style="color: #B70000;">*</span>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px 0px;">兑奖结束时间:</td>
						<td style="padding: 10px 0px;">
							<input name="awardEndDate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${activity.awardEndDate}"/>" type="text" style="width: 20%;border: 1px #B4D1D3 solid;" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d %H:%m:%s'})"/>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px 0px;">活动角色：</td>
						<td style="padding: 10px 0px;">
							<select name="activityRole">
								<option value="0" <c:if test="${activity.activityRole==0}">selected="selected"</c:if>>消费者</option>
								<option value="1" <c:if test="${activity.activityRole==1}">selected="selected"</c:if>>服务员</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px 0px;">是否强制关注:</td>
						<td style="padding: 10px 0px;">
							<input name="isForceCollect" value="0" type="radio" <c:if test='${activity.isForceCollect==0}'>checked="checked"</c:if> />否
							<input name="isForceCollect" value="1" type="radio" <c:if test='${activity.isForceCollect==1}'>checked="checked"</c:if> />是
						</td>
					</tr>
					<tr>
						<td style="padding: 10px 0px;">活动区域开关:</td>
						<td style="padding: 10px 0px;">
							<input name="isArea" value="0" type="radio" <c:if test='${activity.isArea==0}'>checked="checked"</c:if> />关闭
							<input name="isArea" value="1" type="radio" <c:if test='${activity.isArea==1}'>checked="checked"</c:if> />开启
						</td>
					</tr>
					<%-- <tr>
						<td style="padding: 10px 0px;">未激活处理方式:</td>
						<td style="padding: 10px 0px;">
							<select id="unactiviteProcessTypeSel" name="unactiviteProcessType">
								<option value="0" <c:if test="${activity.unactiviteProcessType==0}">selected="selected"</c:if>>显示产品介绍</option>
								<option value="1" <c:if test="${activity.unactiviteProcessType==1}">selected="selected"</c:if>>选择最小的奖项</option>
							</select>
						</td>
					</tr> --%>
					<c:if test="${activity.isIntegral==1}">
					<tr>
						<td style="padding: 10px 0px;">消耗积分:</td>
						<td style="padding: 10px 0px;">
							<input maxlength="6" name="useIntegral" value="${activity.useIntegral }" type="text" style="width: 20%;border: 1px #B4D1D3 solid;" /><span style="color: #B70000;">*</span>
						</td>
					</tr>
					</c:if>
					<tr>
						<td style="padding: 10px 0px;">活动模板:</td>
						<td style="padding: 10px 0px;">
							<select name="templateId" id="activityTemplate">
								<option value="">-请选择-</option>
								<c:forEach var="obj" items="${activityTemplateList}">
									<option value="${obj.templateId}" <c:if test="${activity.templateId==obj.templateId}">selected="selected"</c:if> >${obj.templateName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px 0px;">用户每天最大中奖数量:</td>
						<td style="padding: 10px 0px;">
							<input maxlength="4" id="userDayMaxPrizeCount" name="userDayMaxPrizeCount" 
								value="${activity.userDayMaxPrizeCount}" type="text" 
								onkeyup="this.value=this.value.replace(/[^\d]/g,'')" 
								onchange="this.value=this.value.replace(/[^\d]/g,'')" 
								style="width: 20%;border: 1px #B4D1D3 solid;"/>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px 0px;">用户达到中奖数量上限处理方式:</td>
						<td style="padding: 10px 0px;">
							<select id="userMaxPrizeProcessType" name="userMaxPrizeProcessType">
								<option value="">-请选择-</option>
								<option value="0" <c:if test="${activity.userMaxPrizeProcessType==0}">selected="selected"</c:if> >不参与抽奖</option>
								<option value="1" <c:if test="${activity.userMaxPrizeProcessType==1}">selected="selected"</c:if> >抽奖但不中奖</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px 0px;">活动有效期判断方式:</td>
						<td style="padding: 10px 0px;">
							<select id="validDateTypeId" name="validDateType">
								<option value="">-请选择-</option>
								<option value="1" <c:if test="${activity.validDateType==1}">selected="selected"</c:if> >按辅料箱码激活时间+产品有效期判断</option>
								<option value="2" <c:if test="${activity.validDateType==2}">selected="selected"</c:if> >按活动有效期抽奖</option>
								<option value="3" <c:if test="${activity.validDateType==3}">selected="selected"</c:if> >按成品箱码激活时间+产品有效期判断</option>
							</select><span style="color: #B70000;">*</span>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px 0px;vertical-align: top;">活动详情:</td>
						<td style="padding: 10px 0px;">
							<textarea id="comments" name="comments" style="height: 100px;width: 80%;border: 1px #B4D1D3 solid;">${ activity.comments}</textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div style="width: 90%;margin: 10px auto 0px auto;text-align: right;">
			<input onclick="saveActivityInfo();" type="button" value="下一步" style="width: 80px;text-align: center;height:28px;line-height: 28px;cursor: pointer;"/>
		</div>
		<div style="height: 20px;">&nbsp;</div>
	</body>
</html>
