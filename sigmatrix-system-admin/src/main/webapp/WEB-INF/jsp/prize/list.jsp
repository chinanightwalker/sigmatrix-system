<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>新建奖项</title> 
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}css/pagination.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}css/business/prize/prize.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${ctx}js/common/general.js"></script>
		<script type="text/javascript" src="${ctx}js/business/prize/prize.js"></script>
		<script type="text/javascript"> 
		
		</script>
	</head>
	<body style="width: 100%;background: #eee;">
		<shiro:hasPermission name="activity:insert">
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
						<img src="${ctx}images/activity/am_line_h.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_4_2_h.png" style="vertical-align: middle;"/>
					</td>
					<!-- 原第五步:参与门店 去掉,第六步变成第五步 -->
					<%-- <td>
						<img src="${ctx}images/activity/am_line_h.png" style="vertical-align: top;"/>
					</td>
					<td>
						<img src="${ctx}images/activity/am_5_h.png" style="vertical-align: middle;"/>
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
		</shiro:hasPermission>
		<div
			style="width: 90%; margin: 20px auto 0px auto; background: #f5f5f5; border-left: 1px #d7d7d7 solid; border-right: 1px #d7d7d7 solid; border-top: 1px #d7d7d7 solid;">
			<shiro:hasPermission name="prize:insert">
				<div
					style="float: left; font-size: 12px; color: #333; margin-left: 2%; height: 45px; line-height: 45px; vertical-align: middle;">
					<a href="javascript:void(0);" onclick="toAdd('${activityVo.activity.isOpen==null?0:activityVo.activity.isOpen}');"
						style="color: #45a8da; font-size: 12px; margin-left: 10px;">点击添加奖项</a>
				</div>
			</shiro:hasPermission>
			<shiro:hasPermission name="activity:insert">
			<!-- 未激活处理方式 -->
			<div
				style="float: right; font-size: 12px;height: 45px; line-height: 45px; vertical-align: middle; margin-right: 2%;">
				未激活处理方式：
				<select id="unactiviteId" name="activity.unactiviteProcessType">
					<option value="0" <c:if test="${activityVo.activity.unactiviteProcessType==0 || (empty activityVo.activity.unactiviteProcessType)}">selected="selected"</c:if> >显示产品介绍</option>
					<c:forEach items="${firstPrizeList}" var="obj">
						<option value="${obj.prizeId}" <c:if test="${activityVo.activity.unactiviteProcessType==obj.prizeId}">selected="selected"</c:if> >${obj.prizeName}</option>
					</c:forEach>
				</select>
				<!-- 当前活动的未激活处理方式 -->
				<input type="hidden" id="currentUnactiviteHidId" value="${activityVo.activity.unactiviteProcessType}" />
			</div>
			<!-- 设置活动首次中奖奖项start -->
			<div
				style="float: right; font-size: 12px;height: 45px; line-height: 45px; vertical-align: middle; margin-right: 2%;">
				<img src="${ctx}images/activity/am_006.png" style="vertical-align: middle;"/>&nbsp;&nbsp;
				设置首次中奖奖项：
				<select id="firstPrizeId" name="activity.firstPrizeId">
					<option value="">
						-请选择-
					</option>
					<c:forEach items="${firstPrizeList}" var="obj">
						<option value="${obj.prizeId}" <c:if test="${activityVo.activity.firstPrizeId==obj.prizeId}">selected="selected"</c:if> >${obj.prizeName}</option>
					</c:forEach>
				</select>
				<input type="button" style="margin-right: 10px;margin-left: 10px;" value="保存" onclick="saveFirstPrizeId('${activityVo.activity.activityId}','${activityVo.activity.isOpen==null?0:activityVo.activity.isOpen}')" />
			</div>
			</shiro:hasPermission>
			<div style="clear: both;"></div>
		</div>
		<div
			style="width: 90%; background: #fff; margin: 0px auto; border: 1px #d7d7d7 solid;">
			
			<input type="hidden" name="step" value="3"/>
			<table
				style="width: 100%; font-size: 12px; color: #666; text-align: center; table-layout: fixed;">
				<tr>
					<td style="color: #FF8D45; width: 5%; height: 45px;">
						编号
					</td>
					<td style="color: #FF8D45; width: 12%; height: 45px;">
						奖项名称
					</td>
					<td style="color: #FF8D45; width: 12%;">
						奖品类型
					</td>
					<td style="color: #FF8D45; width: 10%;">
						中奖概率
					</td>
					<td style="color: #FF8D45; width: 10%;">
						总投放量
					</td>
					
					<td style="color: #FF8D45; width: 10%;">
						总剩余量
					</td>
					<td style="color: #FF8D45; width: 10%;">
						总中奖量
					</td>
					<!-- 增加总金额和总剩余金额 -->
					<td style="color: #FF8D45; width: 10%;">
						总金额
					</td>
					<td style="color: #FF8D45; width: 10%;">
						总剩余金额
					</td>
					<td style="color: #FF8D45; width: 10%;">
						总中奖金额
					</td>
					<td style="color: #FF8D45; width: 6%;">
						编辑
					</td>
					<td style="color: #FF8D45; width: 6%;">
						删除
					</td>
				</tr>
				<c:forEach items="${voList}" var="obj" varStatus="vstatus">
				<tr style="<c:if test="${vstatus.index%2==0}">background: #FBFBFA;</c:if><c:if test="${vstatus.index%2!=0}">background: #fff;</c:if>">
					<td style="height: 40px; border-top: 1px #e6e6e6 solid; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
						${vstatus.count}
					</td>
					<td title="${obj.activityPrize.prizeName }"
						style="height: 40px; border-top: 1px #e6e6e6 solid; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
						${obj.activityPrize.prizeName }
					</td>
					<td
						style="height: 40px; border-top: 1px #e6e6e6 solid;">
						${obj.prizeTypeStr }
					</td>
					<td style="border-top: 1px #e6e6e6 solid;">
						<!-- 定额红包、现金券类型额外处理 -->
						<c:choose>
							<c:when test="${obj.activityPrize.prizeType==6||obj.activityPrize.prizeType==7}">
								${obj.timingRedPrizeRate}
							</c:when>
							<c:otherwise>
								<fmt:formatNumber value="${obj.activityPrize.prizeRate*100 }" pattern="#0.0000"/>%
							</c:otherwise>
						</c:choose>
					</td>
					<td style="color: #333; border-top: 1px #e6e6e6 solid;">
						<!-- 有对奖项修改的权限才能修改总投放量,否则只提供显示 -->
						<shiro:hasPermission name="prize:update">
							<input id="pCount${obj.activityPrize.prizeId}" type="text" value="${obj.activityPrize.prizeCount}" 
								onkeyup="this.value=this.value.replace(/[^\d]/g,'')" onchange="this.value=this.value.replace(/[^\d]/g,'')" 
								onblur="toAddCount(this,'${obj.activityPrize.activityId}','${obj.activityPrize.prizeId}','${obj.activityPrize.prizeType}','1','${obj.activityPrize.prizeCount}');" 
								style="height: 20px; line-height: 20px; font-size: 12px; width: 60px; vertical-align: middle;text-align: center;" />
						</shiro:hasPermission>
						<shiro:lacksPermission name="prize:update">
							${obj.activityPrize.prizeCount}
						</shiro:lacksPermission>
					</td>
					
					<td style="color: #333; border-top: 1px #e6e6e6 solid;">
						${obj.lessCount}
					</td>
					<td style="color: #333; border-top: 1px #e6e6e6 solid;">
						${(empty obj.activityPrize.luckyCount)?0:obj.activityPrize.luckyCount}
					</td>
					<!-- 增加总金额和总剩余金额 -->
					<td style="color: #333; border-top: 1px #e6e6e6 solid;">
						<!-- 积分奖项无金额一说 -->
						<c:if test="${obj.activityPrize.prizeType==4}">
							-
						</c:if>
						<c:if test="${obj.activityPrize.prizeType==2}">
							<fmt:formatNumber var="formatTotalAmount" value="${obj.activityPrize.prizeTotalAmount/100}" pattern="0.0#"></fmt:formatNumber>
								<!-- 固定红包总金额不可编辑 -->
								<c:if test="${obj.activityPrize.redBagType==1}">
									${formatTotalAmount}
								</c:if>
								<c:if test="${obj.activityPrize.redBagType!=1}">
									<!-- 具有更新奖项权限才能编辑总金额否则只显示 -->
									<shiro:hasPermission name="prize:update">
										<input id="pTotalAmount${obj.activityPrize.prizeId }" type="text" value="${formatTotalAmount}" 
											onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" 
											onchange="this.value=this.value.replace(/[^\d\.]/g,'')" 
											onblur="toAddCount(this,'${obj.activityPrize.activityId}','${obj.activityPrize.prizeId}','${obj.activityPrize.prizeType}','2','${formatTotalAmount}');" 
											maxlength="11" 
											style="height: 20px; line-height: 20px; font-size: 12px; width: 60px; vertical-align: middle;text-align: center;" />
									</shiro:hasPermission>
									<shiro:lacksPermission name="prize:update">
										${formatTotalAmount}
									</shiro:lacksPermission>
								</c:if>
						</c:if>
						<c:if test="${obj.activityPrize.prizeType==6||obj.activityPrize.prizeType==7}">
							<fmt:formatNumber var="formatTotalAmount" value="${obj.activityPrize.prizeTotalAmount/100}" pattern="0.0#"></fmt:formatNumber>
								<!-- 定时红包总金额不可编辑 -->
								${formatTotalAmount}
						</c:if>
					</td>
					
					<td style="color: #333; border-top: 1px #e6e6e6 solid;">
						<!-- 积分奖项无金额一说 -->
						<c:if test="${obj.activityPrize.prizeType==4}">
							-
						</c:if>
						<c:if test="${obj.activityPrize.prizeType!=4}">
							<fmt:formatNumber value="${obj.balance/100}" pattern="0.0#"></fmt:formatNumber>
						</c:if>
					</td>
					<td style="color: #333; border-top: 1px #e6e6e6 solid;">
						<c:if test="${obj.activityPrize.prizeType==4}">
							-
						</c:if>
						<c:if test="${obj.activityPrize.prizeType!=4}">
							<fmt:formatNumber value="${obj.activityPrize.prizeLuckyAmount/100}" pattern="0.0#"></fmt:formatNumber>
						</c:if>
					</td>
					<td style="border-top: 1px #e6e6e6 solid;">
						<shiro:hasPermission name="prize:update">
							<a href="javascript:void(0);" onclick="editPrize('${obj.activityPrize.prizeId}','${activityVo.activity.isOpen==null?0:activityVo.activity.isOpen}');"
								style="color: #45a8da; font-size: 12px;">编辑</a>
						</shiro:hasPermission>
					</td>
					<td style="border-top: 1px #e6e6e6 solid;">
						<shiro:hasPermission name="prize:delete">
							<a href="javascript:void(0);" onclick="deletePrize('${obj.activityPrize.activityId}','${obj.activityPrize.prizeId}','${activityVo.activity.isOpen==null?0:activityVo.activity.isOpen}');"
								style="color: #45a8da; font-size: 12px;">删除</a>
						</shiro:hasPermission>
					</td>
				</tr>
				</c:forEach>
				<!-- 汇总行:汇总活动的所有奖项的总投放量之和、总金额之和 -->
				<c:if test="${not empty voList}">
					<tr>
						<td colspan="12" style="color: #333; border-top: 1px #e6e6e6 solid;padding:10px 0px;">
							<span style="display:inline-block;font-size: 13px;">本次活动总投放量：${activityVo.prizeTotalCount}</span>&nbsp;&nbsp;
							<span style="display:inline-block;font-size: 13px; padding-left:25px;">总剩余量：${activityVo.prizeTotalLessCount}</span>&nbsp;&nbsp;
							<span style="display:inline-block;font-size: 13px; padding-left:25px;">总中奖量：${activityVo.prizeTotalLuckyCount}</span>&nbsp;&nbsp;
							<span style="display:inline-block;font-size: 13px; padding-left:25px;">总金额：<fmt:formatNumber value="${activityVo.prizeTotalAmount}" pattern="#,##0.0#"></fmt:formatNumber></span>
							<span style="display:inline-block;font-size: 13px; padding-left:25px;">总剩余金额：<fmt:formatNumber value="${activityVo.prizeTotalBalance}" pattern="#,##0.0#"></fmt:formatNumber></span>
							<span style="display:inline-block;font-size: 13px; padding-left:25px;">总中奖金额：<fmt:formatNumber value="${activityVo.prizeTotalLuckyAmount}" pattern="#,##0.0#"></fmt:formatNumber></span>
						</td>
					</tr>
				</c:if>
			</table>
		</div>
		<shiro:hasPermission name="activity:insert">
			<div style="width: 90%;margin: 10px auto 0px auto;text-align: right;">
				<input type="button" onclick="saveActivityByStep('${activityVo.activity.activityId}','3');" value="下一步" style="width: 80px;text-align: center;height:28px;cursor: pointer;" />
			</div>
		</shiro:hasPermission>
		<div style="height: 20px;">&nbsp;</div>
		<!-- 弹出提示层 -->
		<div id="mydiv1"
			style="position: absolute; display: none; border: 1px solid #187ab9; font-size: 12px; background: #fff; padding: 10px; width: 250px; color: #333;right: 5%;">
			企业应充分理解自身产品特点，选择与营销活动目标相匹配的活动类型。
		</div>
		<div id="mydiv2"
			style="position: absolute; display: none; border: 1px solid #187ab9; font-size: 12px; background: #fff; padding: 10px; width: 250px; color: #333;right: 5%;">
			消费者第一次参与活动本奖项的中奖率,为提高用户参与度,一般设置为比较大的数值。
		</div>
		<div id="mydiv3"
			style="position: absolute; display: none; border: 1px solid #187ab9; font-size: 12px; background: #fff; padding: 10px; width: 250px; color: #333;z-index: 202;">
			系统已为您自动计算中奖率，中奖率公式为：投奖数量÷预估参与人数=中奖比率
		</div>
		
		
		<!-- 添加奖项层 800*600 -->
		<div id="addPrize_mask" class="pro_mask" style="display: none;">
		<div class="zhezhaoceng">
			<div class="addPrize_mask">
				<div style="width: 95%;margin: 0px auto;font-size: 12px;background: #f5f5f5;border: 1px #e1e1e1 solid;">
					<div style="width: 90%;margin: 0px auto;">
						<%-- <div style="float: left;text-align: left;margin-left: 10px;width: 150px;">
							<div style="position: relative;padding: 10px;width: 50px;">
								<img type="1" class="myclick" src="${ctx}images/activity/am_prize_001.png" style="vertical-align: middle;width: 70px;height: 70px;cursor: pointer;" />
								<img class="myclick_g" src="${ctx}images/activity/am_prize_g.png" style="width: 25px;height: 25px;position: absolute;right: 0px;bottom: 0px;display: none;"/>
							</div>
							<div style="padding: 0px 10px;">
								再来一瓶
							</div>
						</div> --%>
<%--						<div style="float: left;text-align: left;margin-left: 10px;width: 100px;">--%>
<%--							<div style="position: relative;padding: 10px;width: 50px;">--%>
<%--								<img class="myclick" src="${ctx}images/activity/am_prize_2.png" style="vertical-align: middle;width: 50px;height: 50px;cursor: pointer;" />--%>
<%--								<img class="myclick_g" src="${ctx}images/activity/am_prize_g.png" style="width: 25px;height: 25px;position: absolute;right: 0px;bottom: 0px;display: none;"/>--%>
<%--							</div>--%>
<%--							<div style="padding: 0px 10px;">--%>
<%--								未中奖--%>
<%--							</div>--%>
<%--						</div>--%>
						<div style="float: left;text-align: left;margin-left: 10px;width: 150px;">
							<div style="position: relative;padding: 10px;width: 50px;">
								<img type="2" class="myclick" src="${ctx}images/activity/am_prize_002.png" style="vertical-align: middle;width: 70px;height: 70px;cursor: pointer;" />
								<img class="myclick_g" src="${ctx}images/activity/am_prize_g.png" style="width: 25px;height: 25px;position: absolute;right: 0px;bottom: 0px;display: none;"/>
							</div>
							<div style="padding: 0px 10px;">
								红包奖项
							</div>
						</div>
						<%-- <div style="float: left;text-align: left;margin-left: 10px;width: 150px;">
							<div style="position: relative;padding: 10px;width: 50px;">
								<img type="3" class="myclick" src="${ctx}images/activity/am_prize_003.png" style="vertical-align: middle;width: 70px;height: 70px;cursor: pointer;" />
								<img class="myclick_g" src="${ctx}images/activity/am_prize_g.png" style="width: 25px;height: 25px;position: absolute;right: 0px;bottom: 0px;display: none;"/>
							</div>
							<div style="padding: 0px 10px;">
								邮寄奖项
							</div>
						</div>
						--%>
						<%-- <div style="float: left;text-align: left;margin-left: 10px;width: 150px;">
							<div style="position: relative;padding: 10px;width: 50px;">
								<img type="4" class="myclick" src="${ctx}images/activity/am_prize_004.png" style="vertical-align: middle;width: 70px;height: 70px;cursor: pointer;" />
								<img class="myclick_g" src="${ctx}images/activity/am_prize_g.png" style="width: 25px;height: 25px;position: absolute;right: 0px;bottom: 0px;display: none;"/>
							</div>
							<div style="padding: 0px 10px;">
								积分奖项
							</div>
						</div> --%>
						<%-- 
						<div style="float: left;text-align: left;margin-left: 10px;width: 150px;">
							<div style="position: relative;padding: 10px;width: 50px;">
								<img type="5" class="myclick" src="${ctx}images/activity/am_prize_005.png" style="vertical-align: middle;width: 70px;height: 70px;cursor: pointer;" />
								<img class="myclick_g" src="${ctx}images/activity/am_prize_g.png" style="width: 25px;height: 25px;position: absolute;right: 0px;bottom: 0px;display: none;"/>
							</div>
							<div style="padding: 0px 10px;">
								到店领取奖项
							</div>
						</div> --%>
						<div style="float: left;text-align: left;margin-left: 10px;width: 150px;">
							<div style="position: relative;padding: 10px;width: 50px;">
								<img type="6" class="myclick" src="${ctx}images/activity/am_prize_006.png" style="vertical-align: middle;width: 70px;height: 70px;cursor: pointer;" />
								<img class="myclick_g" src="${ctx}images/activity/am_prize_g.png" style="width: 25px;height: 25px;position: absolute;right: 0px;bottom: 0px;display: none;"/>
							</div>
							<div style="padding: 0px 10px;">
								定时红包
							</div>
						</div>
						<div style="float: left;text-align: left;margin-left: 10px;width: 150px;">
							<div style="position: relative;padding: 10px;width: 50px;">
								<img type="7" class="myclick" src="${ctx}images/activity/am_prize_007.png" style="vertical-align: middle;width: 70px;height: 70px;cursor: pointer;" />
								<img class="myclick_g" src="${ctx}images/activity/am_prize_g.png" style="width: 25px;height: 25px;position: absolute;right: 0px;bottom: 0px;display: none;"/>
							</div>
							<div style="padding: 0px 10px;">
								现金券
							</div>
						</div>
						<div style="clear: both;"></div>
					</div>
					<div style="height:180px;"></div>
				</div>
				<div style="width: 90%;margin: 5% auto;">
					<table style="width: 100%;">
						<tr>
							<td style="text-align: left;">
								<input type="button" value="返回" onclick="closePrizeType('${activityVo.activity.activityId}')"
								 style="width: 80px;text-align: center;height:28px;cursor: pointer;"/>
							</td>
							<td style="text-align: right;">
								<input type="button" value="确定" onclick="subPrizeType('${activityVo.activity.activityId}');" 
								style="width: 80px;text-align: center;height:28px;cursor: pointer;"/>
							</td>
						</tr>
					</table>
				</div>
			</div>
			</div>
		</div>
	</body>
</html>