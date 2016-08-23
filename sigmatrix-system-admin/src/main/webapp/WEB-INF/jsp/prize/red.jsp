<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>红包页面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}css/pagination.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}css/business/prize/red.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${ctx}js/common/general.js"></script>
		<!-- 引入通用的JS处理金额 -->
		<script type="text/javascript" src="${ctx}js/common/generalNumber.js"></script>
		<script type="text/javascript" src="${ctx}js/business/prize/red.js"></script>
	</head>

	<body>
	  <form action="${ctx}prize/saveOrUpdate" method="post" id="rp">
	  	<!-- 1代表新增,2代表修改 -->
	    <input type="hidden" value="${edit}" name="edit">
	    
	    <!-- 奖项实体默认值开始 -->
	    <input type="hidden" id="prizeIdHid" name="activityPrize.prizeId" value="${activityPrizeVo.activityPrize.prizeId}">
	    <input type="hidden" id="activityIdHid" name="activityPrize.activityId" value="${activityPrizeVo.activityPrize.activityId}">
	    <input type="hidden" id="prizeTypeHid" name="activityPrize.prizeType" value="${activityPrizeVo.activityPrize.prizeType}">
	    
	    <!-- 奖项实体默认值结束 -->
	    
	    
	    
	    <!-- 标识红包类型 -->
	    <input type="hidden" id="redBagTypeHid" value="${activityPrizeVo.activityPrize.redBagType}" />
	    
		<div id="huafei_mask" class="pro_mask">
			<div class="pro_mask_div" style="overflow: scroll;height:100%;">
				<div style="width: 90%;margin: 0px auto;background: #f5f5f5;border: 1px #e2e2e2 solid;padding: 10px 0px;">
					<table style="width: 100%;font-size: 14px;">
						<tbody>
						<tr>
						    <td rowspan="6" style="width: 25%;text-align: center;">
						    	<c:if test="${activityPrizeVo.activityPrize.prizePicUrl==null||''==activityPrizeVo.activityPrize.prizePicUrl}">
							    	<img id="view_image" src="<%=request.getContextPath() %>/images/activity/am_prize_002.png" style="vertical-align: middle;width: 80%;"/>
						    	</c:if>
						    	<c:if test="${activityPrizeVo.activityPrize.prizePicUrl!=null&&''!=activityPrizeVo.activityPrize.prizePicUrl}">
						    		<img id="view_image" src="${activityPrizeVo.activityPrize.prizePicPath }" style="vertical-align: middle;width: 80%;"/>
						    	</c:if>
						    </td>
						    <td style="padding: 5px 0px;">
						    	奖项名称：<input maxlength="10" name="activityPrize.prizeName" id="rp_prizeName" type="text" style="color: #ff9650;" value="${activityPrizeVo.activityPrize.prizeName}" ><span style="color: #f91142;">*</span>
						    </td>
						</tr>
						<tr>
						    <td style="padding: 5px 0px;">
						    	奖品：<span id="huafei_prizeName">微信红包</span>
						    </td>
						</tr>
						<tr id="redPacketsType" style="">
						    <td style="padding: 5px 0px;">
						    	红包类型：
						    	<!-- edit=1为新增，=2为修改，修改时不可改变红包类型 -->
						    	<c:if test="${edit eq 1}">
							    	<select id="redBagTypeSel" name="activityPrize.redBagType" onchange="changeRedType(this,'${edit}','${activityPrizeVo.activityPrize.redBagType}','true')">
							    		<option value="1" <c:if test="${activityPrizeVo.activityPrize.redBagType==1}">selected="selected"</c:if>>固定中奖金额</option>
							    		<option value="2" <c:if test="${activityPrizeVo.activityPrize.redBagType==2}">selected="selected"</c:if>>区间中奖金额</option>
							    		<option value="3" <c:if test="${activityPrizeVo.activityPrize.redBagType==3}">selected="selected"</c:if>>霸占型红包</option>
							    	</select>
						    		
						    	</c:if>
						    	<c:if test="${edit eq 2}">
						    		<select id="redBagTypeSel" name="activityPrize.redBagType">
						    			<c:choose>
						    				<c:when test="${activityPrizeVo.activityPrize.redBagType==1}"><option value="1">固定中奖金额</option></c:when>
						    				<c:when test="${activityPrizeVo.activityPrize.redBagType==2}"><option value="2">区间中奖金额</option></c:when>
						    				<c:when test="${activityPrizeVo.activityPrize.redBagType==3}"><option value="3">霸占型红包</option></c:when>
						    				<c:otherwise><option value="">未知红包类型</option></c:otherwise>
						    			</c:choose>
							    	</select>
						    	</c:if>
						    </td>
						</tr>
						<tr id="redPacketsPrice" style="" <c:if test="${(not empty activityPrizeVo.activityPrize.redBagType)&&activityPrizeVo.activityPrize.redBagType!=1}">class="none"</c:if> >
						    <td style="padding: 5px 0px;">
						    <!-- 只能输入数字和.   失去焦点时再验证金额格式:0.00(最多两位小数) -->
						    	红包金额：
						    	<input id="rp_red" type="text" 
						    		onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" 
						    		onchange="this.value=this.value.replace(/[^\d\.]/g,'');syncRedPrizeAmount(this);" 
						    		onclick="clickClearData(this, '0', 'red_prizeAmount')" 
						    		value="${activityPrizeVo.activityPrize.prizeAmount/100 }" style="color: #ff9650;" />元<span style="color: #f91142;">*</span>
						    	<input type="hidden" id="red_prizeAmount" name="activityPrize.prizeAmount" value="${activityPrizeVo.activityPrize.prizeAmount }" />
						    </td>
						</tr>
						
						<!-- 区间红包独有内容Start -->
					    <tr id="redIntervalDiv" <c:if test="${(not empty activityPrizeVo.activityPrize.redBagType)&&activityPrizeVo.activityPrize.redBagType!=2}">class="none"</c:if> style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;">
							<td>
							  <table>
								<tr style="margin-left: -15px;display: block;margin-bottom: 8px;">
									<td nowrap="nowrap">
										&nbsp;&nbsp;
										最小红包金额：
										<input id="rp_minAmount" value="${activityPrizeVo.activityPrize.minAmount/100}" onclick="clickClearData(this, '0', 'minAmountHid')" onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" onchange="this.value=this.value.replace(/[^\d\.]/g,'');changeHidMoney(this,'minAmountHid');" style="color: #ff9650;" type="text">元<span style="color: #f91142;">*</span>
										<input id="minAmountHid" name="activityPrize.minAmount" value="${activityPrizeVo.activityPrize.minAmount}" type="hidden">
									</td>
								</tr>
								<tr style="margin-left: -15px;display: block;margin-bottom:8px;">
									<td nowrap="nowrap">
									    &nbsp;&nbsp;
										最大红包金额：
										<input id="rp_maxAmount" value="${activityPrizeVo.activityPrize.maxAmount/100}" onclick="clickClearData(this, '0', 'maxAmountHid')" 
											onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" 
											onchange="this.value=this.value.replace(/[^\d\.]/g,'');changeHidMoney(this,'maxAmountHid');" style="color: #ff9650;" type="text">元<span style="color: #f91142;">*</span>
										<input id="maxAmountHid" name="activityPrize.maxAmount" value="${activityPrizeVo.activityPrize.maxAmount}" type="hidden">
									</td>
								</tr>
								<tr style="margin-left: -15px;display: block;margin-bottom: 8px;">
									<td nowrap="nowrap">
									    &nbsp;&nbsp;
										首次中奖最小金额：
									<input id="rp_firstMinAmount" 
											type="text" value="${activityPrizeVo.activityPrize.firstMinAmount/100}" 
											onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" 
							    			onchange="this.value=this.value.replace(/[^\d\.]/g,'');changeHidMoney(this,'firstMinAmountHid');" 
							    			onclick="clickClearData(this, '0', 'firstMinAmountHid')" 
											style="color: #ff9650;">元
									<input type="hidden" id="firstMinAmountHid" name="activityPrize.firstMinAmount" value="${activityPrizeVo.activityPrize.firstMinAmount}" />
									</td>
								</tr>
							</table>
						</td>
					 </tr>
					    <!-- 区间红包独有内容End -->
						
					</tbody></table>
				</div>
				<div style="margin: 0px auto;width: 90%;border-bottom: 10px #dcdadb solid;padding: 5px 0px;">中奖设置</div>
				<div style="height: 15px;">&nbsp;</div>
				<!-- 固定中奖数层 -->
				<div class="gudingshu_div" style="width: 90%;margin: 0px auto;border: 1px #dcdadb solid;font-size: 12px;">
				    <div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;">
				       	<!-- 
						<input id="xiang" type="radio" name="activityPrize.isBoxPrize" value="1" <c:if test="${activityPrizeVo.activityPrize.isBoxPrize == 1 || activityPrizeVo.activityPrize.isBoxPrize != 2}"> checked="checked" </c:if>><label for="xiang">按箱</label>
				       	 -->
						<input id="pici" type="radio" name="activityPrize.isBoxPrize" value="2" checked="checked" /><label for="pici">按产品</label>
					</div>
					<div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;">
						<table style="width: 100%;">
							<tr>
								<td width="35%">
								   <img src="<%=request.getContextPath() %>/images/activity/am_mask_001.png" style="vertical-align: middle;margin-left: 2%;">&nbsp;&nbsp;
							       <span id="huafei_numTypeName" style="color: black;">总投放量</span> &nbsp;&nbsp;
							       <input id="rp_prizeCount" name="activityPrize.prizeCount" type="text" value="${activityPrizeVo.activityPrize.prizeCount}" 
							       		onkeyup="this.value=this.value.replace(/[^\d]/g,'')" onchange="this.value=this.value.replace(/[^\d]/g,'')" 
							       		onclick="clickClearData(this, '0', '')" maxlength="9" 
							       		style="height: 20px; line-height: 20px; font-size: 12px; width: 60px; vertical-align: middle;"> 
							       <span id="huafei_countName" style="color: black;">份</span><span style="color: #f91142;">*</span>
								</td>
								<td>&nbsp;</td>
							</tr>
						</table>
					</div>
					<div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;">
						<table style="width: 100%;">
							<tr>
								<td width="35%">
									<img src="<%=request.getContextPath() %>/images/activity/am_mask_002.png" style="vertical-align: middle;margin-left: 2%;">&nbsp;&nbsp;
									中奖率 &nbsp;&nbsp;
									<input id="rp_prizeRate" name="activityPrize.prizeRate" type="text" maxlength="8" 
										value="<fmt:formatNumber value='${activityPrizeVo.activityPrize.prizeRate*100 }' pattern='#0.0000'/>" 
										onkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onchange="this.value=this.value.replace(/[^\d.]/g,'')" 
										onclick="clickClearData(this, '0', '')" 
										style="height: 20px; line-height: 20px; font-size: 12px; width: 60px; vertical-align: middle;"> %<span style="color: #f91142;">*</span>
								</td>
								<td width="35%">
								    <img src="<%=request.getContextPath() %>/images/activity/am_mask_002.png" style="vertical-align: middle;margin-left: 2%;">&nbsp;&nbsp;
									积分 &nbsp;&nbsp;
									<input id="rp_integration" name="activityPrize.integration"  type="text" 
										value="${activityPrizeVo.activityPrize.integration}" 
										onkeyup="this.value=this.value.replace(/[^\d]/g,'')" onchange="this.value=this.value.replace(/[^\d]/g,'')" 
										onclick="clickClearData(this, '0', '')"  
										style="height: 20px; line-height: 20px; font-size: 12px; width: 60px; vertical-align: middle;"> 
								</td>
							</tr>
						</table>
				    </div>
				    
				    
				    
				    <!-- 霸占型红包独有内容Start -->
				    <div id="redForciblyDiv" <c:if test="${(not empty activityPrizeVo.activityPrize.redBagType)&&activityPrizeVo.activityPrize.redBagType!=3}">class="none"</c:if> style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;">
						<table style="width: 100%;">
							<tr style="display: block;">
								<td width="25%" nowrap="nowrap" style="display:inline-block;margin-left:23px;">
									参与人数 &nbsp;&nbsp;
									<input id="rp_prizeForciblyCount" name="activityPrize.prizeForciblyCount" 
										type="text" value="${(empty activityPrizeVo.activityPrize.prizeForciblyCount)?0:activityPrizeVo.activityPrize.prizeForciblyCount}" 
										onkeyup="this.value=this.value.replace(/[^\d]/g,'')" onchange="this.value=this.value.replace(/[^\d]/g,'')" 
										onclick="clickClearData(this, '0', '')" 
										style="height: 20px; line-height: 20px; font-size: 12px; width: 60px; vertical-align: middle;"><span style="color: #f91142;">*</span>
								</td>
								<td width="25%" nowrap="nowrap"style="display:inline-block;margin-left:23px;">
									每人分到的金额
									<input id="rp_prizeForciblyAmount" 
										type="text" value="${activityPrizeVo.activityPrize.prizeForciblyAmount/100}" 
										onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" 
						    			onchange="this.value=this.value.replace(/[^\d\.]/g,'');changeHidMoney(this,'prizeForciblyAmountHid');" 
						    			onclick="clickClearData(this, '0', 'prizeForciblyAmountHid')"  
										style="height: 20px; line-height: 20px; font-size: 12px; width: 60px; vertical-align: middle;"><span style="color: #f91142;">*</span>
									<input type="hidden" id="prizeForciblyAmountHid" name="activityPrize.prizeForciblyAmount" value="${activityPrizeVo.activityPrize.prizeForciblyAmount}" />
								</td>
							</tr>
						</table>
				    </div>
				    <!-- 霸占型红包独有内容End -->
				    <!-- 区间红包和霸占型红包共有Start -->
				    <div id="redPubBalanceDiv" <c:if test="${(not empty activityPrizeVo.activityPrize.redBagType)&&activityPrizeVo.activityPrize.redBagType==1}">class="none"</c:if> style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;">
				    	<p style="display:inline-block;">已中此奖项的总金额<span style="display:inline-block;color:red;margin-left:5px;">${activityPrizeVo.activityPrize.prizeLuckyAmount/100}</span></p>元
				    	<p style="display:inline-block; margin-left:27px;">奖项的总金额<span style="display:inline-block;color:red;margin-left:5px;">${activityPrizeVo.activityPrize.prizeTotalAmount/100}</span></p>元
				    	<div>
							总剩余金额：
							<input id="rp_balance" maxlength="11" 
											type="text" value="${activityPrizeVo.balance/100}" 
											onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" 
							    			onchange="this.value=this.value.replace(/[^\d\.]/g,'');changeHidMoney(this,'balanceHid');" 
							    			onclick="clickClearData(this, '0', 'balanceHid')" 
											style="height: 20px; line-height: 20px; font-size: 12px; width: 60px; vertical-align: middle;">
							<input type="hidden" id="balanceHid" name="balance" value="${activityPrizeVo.balance}" />元<span style="color: #f91142;">*</span>
							<!-- 已中此奖项的总金额(单位分) -->
					    	<input type="hidden" name="activityPrize.prizeTotalAmount" value="${activityPrizeVo.activityPrize.prizeTotalAmount}" />
							<input type="hidden" id="prizeLuckyAmountHid" name="activityPrize.prizeLuckyAmount" value="${activityPrizeVo.activityPrize.prizeLuckyAmount}" />
					   </div>
					</div>
					<!-- 区间红包和霸占型红包共有End -->
				    
				    <%-- <div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;">
						中奖产品：
						<s:select name="activityPrize.productId" list="productList" listKey="productId" listValue="productName" headerKey="" headerValue="-请选择-" value="${activityPrizeVo.activityPrize.productId}" cssStyle="vertical-align: middle; height: 26px; color: black;width: 20%;border: 1px #B4D1D3 solid;"></s:select>
					</div> --%>
					<div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;padding-left: 10px;">
						奖项提示语：
						<input type="text" id="prizeRedHint" name="activityPrize.redbagHint" value="${activityPrizeVo.activityPrize.redbagHint}" 
							maxlength="30" /><span style="color: #f91142;">*</span>
					</div>
				    <div style="width: 100%;border-bottom: 1px #dcdadb solid;padding: 10px 0px;">
				      <div>奖项描述：</div>
				      <div style="clear: both;"></div>
				        <textarea rows="5" cols="60" id="rp_prizeDesc" name="activityPrize.prizeDesc">${activityPrizeVo.activityPrize.prizeDesc}</textarea>
				    </div>
				</div>
			   
				<div style="width: 90%;margin: 10px auto 30px;text-align: right;">
					<table style="width: 100%;">
						<tbody><tr>
							<td style="text-align: left;">
								<input type="button" value="取消" onclick="closePrizeEdit(${activityPrizeVo.activityPrize.activityId});" style="width: 80px;text-align: center;height:28px;line-height: 28px;cursor: pointer;">
							</td>
							<td style="text-align: right;">
								<input id="redSubmitBtn" type="button" value="确定" onclick="saveRedPrizeInfo();" style="width: 80px;text-align: center;height:28px;line-height: 28px;cursor: pointer;">
							</td>
						</tr>
					</tbody></table>
				
				</div>
			</div>
		</div>
		 </form>
	</body>
</html>
