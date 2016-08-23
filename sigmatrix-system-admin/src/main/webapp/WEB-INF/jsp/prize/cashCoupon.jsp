<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>现金券</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="${ctx}css/pagination.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}css/business/prize/cashCoupon.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${ctx}js/common/general.js"></script>
		<!-- 引入通用的JS处理金额 -->
		<script type="text/javascript" src="${ctx}js/common/generalNumber.js"></script>
		<script type="text/javascript" src="${ctx}js/business/prize/cashCoupon.js"></script>
		<script type="text/javascript" src="${ctx}js/My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>
	  <form action="${ctx}prize/saveOrUpdate" method="post" id="cash">
	  	<!-- 1代表新增,2代表修改 -->
	    <input type="hidden" value="${edit}" name="edit">
	    
	    <!-- 奖项实体默认值开始 -->
	    <input type="hidden" name="activityPrize.prizeId" value="${activityPrizeVo.activityPrize.prizeId}">
	    <input type="hidden" name="activityPrize.activityId" value="${activityPrizeVo.activityPrize.activityId}">
	    <input type="hidden" id="prizeTypeHid" name="activityPrize.prizeType" value="${activityPrizeVo.activityPrize.prizeType}">
	    <!-- 奖项实体默认值结束 -->
	    
	    
		<div id="huafei_mask" class="pro_mask">
			<div class="pro_mask_div" style="overflow: scroll; height: 100%;">
				<div style="width: 90%;margin: 0px auto;background: #f5f5f5;border: 1px #e2e2e2 solid;padding: 10px 0px;">
					<table style="width: 100%;font-size: 14px;">
						<tbody>
						<tr>
						    <td rowspan="4" style="width: 25%;text-align: center;">
						    	<c:if test="${activityPrizeVo.activityPrize.prizePicUrl==null||''==activityPrizeVo.activityPrize.prizePicUrl}">
							    	<img id="view_image" src="${ctx}images/activity/am_prize_007.png" style="vertical-align: middle;width: 80%;"/>
						    	</c:if>
						    	<c:if test="${activityPrizeVo.activityPrize.prizePicUrl!=null&&''!=activityPrizeVo.activityPrize.prizePicUrl}">
						    		<img id="view_image" src="${activityPrizeVo.activityPrize.prizePicPath }" style="vertical-align: middle;width: 80%;"/>
						    	</c:if>
						    </td>
						    <td style="padding: 5px 0px;">
						    	奖项名称：<input maxlength="20" name="activityPrize.prizeName" id="cash_prizeName" type="text" style="color: #ff9650;" value="${activityPrizeVo.activityPrize.prizeName}" ><span style="color: #f91142;">*</span>
						    </td>
						</tr>
						<tr>
						    <td style="padding: 5px 0px;">
						    	奖品：<span id="huafei_prizeName">现金券</span>
						    </td>
						</tr>
						<tr id="redPacketsPrice" style="">
						    <td style="padding: 5px 0px;">
						    <!-- 只能输入数字和.   失去焦点时再验证金额格式:0.00(最多两位小数) -->
						    	红包金额：
						    	<input id="timingRed" type="text" 
						    		onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" 
						    		onchange="this.value=this.value.replace(/[^\d\.]/g,'');syncRedPrizeAmount(this,'prizeAmountHid');" 
						    		onclick="clickClearData(this, '0', 'prizeAmountHid')" 
						    		value="${activityPrizeVo.activityPrize.prizeAmount/100 }" style="color: #ff9650;" />元<span style="color: #f91142;">*</span>
						    	<input type="hidden" id="prizeAmountHid" name="activityPrize.prizeAmount" value="${activityPrizeVo.activityPrize.prizeAmount}">
						    </td>
						</tr>
					</tbody>
					</table>
				</div>
				<div style="margin: 0px auto;width: 90%;border-bottom: 10px #dcdadb solid;padding: 5px 0px;">中奖设置</div>
				<div style="height: 15px;">&nbsp;</div>
				<!-- 固定中奖数层 -->
				<div class="gudingshu_div" style="width: 90%;margin: 0px auto;border: 1px #dcdadb solid;font-size: 12px;">
				    <div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;">
				       <!-- 目前只支持按产品 -->
						<%-- <input id="xiang" type="radio" name="activityPrize.isBoxPrize" value="1" <s:if test="${activityPrizeVo.activityPrize.isBoxPrize == 1 || activityPrizeVo.activityPrize.isBoxPrize != 2}"> checked="checked" </s:if>><label for="xiang">按箱</label> --%>
						<input id="pici" type="radio" name="activityPrize.isBoxPrize" value="2" checked="checked"><label for="pici">按产品</label>
					</div>
					<div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;">
						起始日期：
						<input type="text" id="beginDate" name="activityPrize.beginDate" value='<fmt:formatDate value="${activityPrizeVo.activityPrize.beginDate}" pattern="yyyy-MM-dd" />' onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}'})" class="Wdate" 
							style="height: 20px; line-height: 20px; font-size: 12px; width: 120px; vertical-align: middle;" />
						至 
						<input type="text" id="endDate" name="activityPrize.endDate" value='<fmt:formatDate value="${activityPrizeVo.activityPrize.endDate}" pattern="yyyy-MM-dd" />' onClick="WdatePicker({minDate:'#F{$dp.$D(\'beginDate\')}'})" class="Wdate" 
							style="height: 20px; line-height: 20px; font-size: 12px; width: 120px; vertical-align: middle;" /><span style="color: #f91142;">*</span>
					</div>
					<div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;">
						奖项模式：
						<!-- edit=1为新增，=2为修改，修改时不可改变定时红包的奖项模式 -->
						<c:if test="${edit eq 1}">
							<select id="prizePeriodMode" name="activityPrize.prizePeriodMode" onchange="changeMode(this)">
								<option value="1">按天</option>
								<option value="2">按周</option>
								<option value="3">按月</option>
								<option value="4">按时段</option>
							</select>
						</c:if>
						<c:if test="${edit eq 2}">
							<select id="prizePeriodMode" name="activityPrize.prizePeriodMode" onchange="changeMode(this)">
								<option value="1" <c:if test="${activityPrizeVo.activityPrize.prizePeriodMode==1}">selected="selected"</c:if> >按天</option>
								<option value="2" <c:if test="${activityPrizeVo.activityPrize.prizePeriodMode==2}">selected="selected"</c:if> >按周</option>
								<option value="3" <c:if test="${activityPrizeVo.activityPrize.prizePeriodMode==3}">selected="selected"</c:if> >按月</option>
								<option value="4" <c:if test="${activityPrizeVo.activityPrize.prizePeriodMode==4}">selected="selected"</c:if> >按时段</option>
							</select>
						</c:if>
					</div>
					<div id="timeslotInfoDev" style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;" <c:if test="${activityPrizeVo.activityPrize.prizePeriodMode!=4}">class="none"</c:if> >
						时间段：
						<table id="timeslotInfoTable">
							<!-- 不存在时 -->
							<c:if test="${empty activityPrizeVo.timeslotInfos}">
								<tr id="timeslotInfoTr0">
									<td>
										<input type="text" name="timeslotInfos[0].starttime" class="Wdate float_l" id="starttime0" onfocus="WdatePicker({dateFmt:'H:mm:ss'})"/>
										至<input type="text" name="timeslotInfos[0].endtime" class="Wdate" id="endtime0" onfocus="WdatePicker({dateFmt:'H:mm:ss'})"/>
										<span style="color: #f91142;">*</span>
										<a class="cursor_user" onclick="addTimeslotInfo(this,'timeslotInfoTr','0')">添加</a>
									</td>
								</tr>
							</c:if>
							<!-- 存在时 -->
							<c:if test="${not empty activityPrizeVo.timeslotInfos}">
								<c:forEach var="timeslotInfo" items="${activityPrizeVo.timeslotInfos}" varStatus="index">
									<tr id="timeslotInfoTr${index.index}">
										<td>
											<input type="text" name="timeslotInfos[${index.index}].starttime" value="${timeslotInfo.starttime}" class="Wdate float_l" id="starttime${index.index}" onfocus="WdatePicker({dateFmt:'H:mm:ss'})"/>
											至<input type="text" name="timeslotInfos[${index.index}].endtime" value="${timeslotInfo.endtime}" class="Wdate" id="endtime${index.index}" onfocus="WdatePicker({dateFmt:'H:mm:ss'})"/>
											<span style="color: #f91142;">*</span>
											<c:if test="${index.index==0}">
												<a class="cursor_user" onclick="addTimeslotInfo(this,'timeslotInfoTr','${fn:length(activityPrizeVo.timeslotInfos)}')">添加</a>
											</c:if>
											<c:if test="${index.index!=0}">
												<a class="cursor_user" onclick="removeTimeslotInfo(this,'timeslotInfoTr','${index.index}')">删除</a>
											</c:if>
											
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</table>
					</div>
					<div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;">
						奖项周期投放量：
						<input type="text" id="prizePeriodCount" name="activityPrize.prizePeriodCount" value="${activityPrizeVo.activityPrize.prizePeriodCount}" 
							onkeyup="this.value=this.value.replace(/[^\d]/g,'')" 
							onchange="this.value=this.value.replace(/[^\d]/g,'')" 
							maxlength="11" /><span style="color: #f91142;">*</span>
					</div>
					<div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;">
						中奖因子：
						<input type="text" id="prizeFactor" name="activityPrize.prizeFactor" value="${activityPrizeVo.activityPrize.prizeFactor}" 
							onkeyup="this.value=this.value.replace(/[^\d]/g,'')" 
							onchange="this.value=this.value.replace(/[^\d]/g,'')" 
							maxlength="11" /><span style="color: #f91142;">*</span>
					</div>
					<div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;">
						有效天数：
						<input type="text" id="validDaysId" name="activityPrize.validDays" value="${activityPrizeVo.activityPrize.validDays}" 
							onkeyup="this.value=this.value.replace(/[^\d]/g,'')" 
							onchange="this.value=this.value.replace(/[^\d]/g,'')" 
							maxlength="11" /><span style="color: #f91142;">*</span>
						<span style="color: red;">0代表无限制</span>
					</div>
					<div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;">
						获得现金券最大金额：
						<input type="text" id="cashGetMinAmountId" value="${activityPrizeVo.activityPrize.cashGetMinPrizeAmount/100}" 
							onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" 
						    onchange="this.value=this.value.replace(/[^\d\.]/g,'');syncRedPrizeAmount(this,'cashGetMinAmountHidId');" 
						    onclick="clickClearData(this, '0', 'cashGetMinAmountHidId')" 
							maxlength="11" /><span style="color: #f91142;">&nbsp;元*</span>
						<input type="hidden" id="cashGetMinAmountHidId" name="activityPrize.cashGetMinPrizeAmount" value="${activityPrizeVo.activityPrize.cashGetMinPrizeAmount}">
					</div>
					<div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;">
						奖项提示语：
						<input type="text" id="prizeRedHint" name="activityPrize.redbagHint" value="${activityPrizeVo.activityPrize.redbagHint}" 
							maxlength="30" /><span style="color: #f91142;">*</span>
					</div>
				    <div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;">
				      <div>奖项描述：</div>
				      <div style="clear: both;"></div>
				        <textarea rows="5" cols="60" id="cash_prizeDesc" name="activityPrize.prizeDesc">${activityPrizeVo.activityPrize.prizeDesc}</textarea>
				    </div>
				</div>
			   
				<div style="width: 90%;margin: 10px auto 30px;text-align: right;">
					<table style="width: 100%;">
						<tbody><tr>
							<td style="text-align: left;">
								<input type="button" value="取消" onclick="closePrizeEdit('${activityPrizeVo.activityPrize.activityId}');" style="width: 80px;text-align: center;height:28px;line-height: 28px;cursor: pointer;">
							</td>
							<td style="text-align: right;">
								<input id="timingRedBtn" type="button" value="确定" onclick="saveCashCoupon()" style="width: 80px;text-align: center;height:28px;line-height: 28px;cursor: pointer;">
							</td>
						</tr>
					</tbody></table>
				
				</div>
			</div>
		</div>
		 </form>
	</body>
</html>
