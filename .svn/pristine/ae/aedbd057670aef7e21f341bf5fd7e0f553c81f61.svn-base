<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  function navTabAjaxDone(json){
			if(json.statusCode == DWZ.statusCode.error){
				alertMsg.error(json.message);
				return;
			}
			if (json.statusCode == DWZ.statusCode.ok){
	            navTab.closeCurrentTab();
	            navTab.openTabLs(json.navTabId,json.forwardUrl,"中奖信息查询");
	      	}
	}
	
	function jump(){
		var jsonStr = {					
				activityId:$("#activityId").val(),
				userId:$("#userId").val(),
				prizeType:$("#prizeType").val(),
				isType:$("#isType").val(),
				isStatus:$("#isStatus").val(),
				startDate:$("#startDate").val(),
				endDate:$("#endDate").val()					
				
			};
			navTab.openTabLs("system","${ctx}winningInformation/list","中奖信息查询",{data:jsonStr});
			
	}
	
	</script>
  </head>
  <body>
	<div class="pageContent">
	    <!-- 保存扫码记录查询列表的搜索条件,返回扫码记录列表时使用,请保持下面的id为scancodeLogForm的form中的name在页面中唯一 -->
		<form id="scancodeLogForm">
			<input type="hidden" id="userId" name="userId" value="${userId}" />
			<input type="hidden" id="prizeType" name="prizeType" value="${prizeType}" />
			<input type="hidden" id="isType" name="isType" value="${isType}" />
			<input type="hidden" id="activityId" name="activityId" value="${barcodePrizeConsumerVO.barcodePrizeConsumer.activityId}" />
			<input type="hidden" id="isStatus" name="isStatus" value="${isStatus}" />
			<input type="hidden" id="startDate" name="startDate" value="${startDate}" />
			<input type="hidden" id="endDate" name="endDate" value="${endDate}" />
		</form>
		<form id="editAccountForm" method="post" action="" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
			<p style="width: 450px;">
				<label>单品码内容：</label>
				${barcodePrizeConsumerVO.barcodePrizeConsumer.barcode}
			</p>
			<p>
				<label>活动名称：</label>
				${barcodePrizeConsumerVO.activityName }
			</p>
			<p style="width: 450px;">
				<label>奖项金额：</label>
				${barcodePrizeConsumerVO.prizeAmountStr }
			</p>
			<p>
				<label>产品名称：</label>
				${barcodePrizeConsumerVO.productName }
			</p>
			<p style="width: 450px;">
				<label>奖项类型：</label>
				
				<c:choose>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.prizeType eq  1}">再来一瓶</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.prizeType eq  2 and (barcodePrizeConsumerVO.barcodePrizeConsumer.prizeAmount eq barcodePrizeConsumerVO.barcodePrizeConsumer.totalAmount)}">红包</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.prizeType eq  2 and (barcodePrizeConsumerVO.barcodePrizeConsumer.prizeAmount ne barcodePrizeConsumerVO.barcodePrizeConsumer.totalAmount)}">红包+现金券</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.prizeType eq  3}">邮寄奖品</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.prizeType eq  4}">积分</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.prizeType eq  5}">到店领取奖品</c:when>
				</c:choose>
			</p>
			<p>
				<label>活动类型：</label>				
				<c:choose>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isType eq 1}">扫码抽奖</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isType eq 2}">积分抽奖</c:when>
				</c:choose>
			</p>
			<p style="width: 450px;">
				<label>中奖人姓名：</label>
				${barcodePrizeConsumerVO.userName }
			</p>
			<p>
				<label>中奖的openID：</label>
				${barcodePrizeConsumerVO.barcodePrizeConsumer.openId }
			</p>
			<p style="width: 450px;">
				<label>是否临时身份：</label>				
				<c:choose>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isTempId eq 0}">非临时身份证</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isTempId eq 1}">临时身份证</c:when>
				</c:choose>
			</p>
			<p>
				<label>状态：</label>				
				<c:choose>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isStatus eq 0}">已抽奖</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isStatus eq 1}">已领奖</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isStatus eq 2}">已兑奖</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isStatus eq 3}">放弃领奖</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isStatus eq 4}">红包领取失败</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isStatus eq 5}">霸占红包分享中</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isStatus eq 6}">所有人已参与</c:when>
				</c:choose>
			</p>
			<p style="width: 450px;">
				<label>是否中奖：</label>				
				<c:choose>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isPrize eq 0}">未中奖</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isPrize eq 1}">2</c:when>
				</c:choose>
			</p>
			
			<p >
				<label>奖项名称：</label>
				${barcodePrizeConsumerVO.barcodePrizeConsumer.prizeName }
			</p>
			<p style="width: 450px;">
				<label>抽奖时间：</label>
				<fmt:formatDate value="${barcodePrizeConsumerVO.barcodePrizeConsumer.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				
			</p>
			<p >
				<label>领奖时间：</label>
				<fmt:formatDate value="${barcodePrizeConsumerVO.barcodePrizeConsumer.acceptTime }" pattern="yyyy-MM-dd HH:mm:ss"/>		
			</p>
			<%-- <p style="width: 450px;">
				<label>店铺名称：</label>
				${barcodePrizeConsumer.shopId }
			</p> --%>
			<p style="width: 450px;">
				<label>兑奖时间：</label>
				<fmt:formatDate value="${barcodePrizeConsumerVO.barcodePrizeConsumer.getTime }" pattern="yyyy-HH-dd HH:mm:ss"/>
				
			</p>
			<p>
				<label>兑奖地点：</label>
				${barcodePrizeConsumerVO.barcodePrizeConsumer.getAddress }
				
			</p>
			<p  style="width: 450px;">
				<label>兑奖方式：</label>			
				<c:choose>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.getType eq 1}">微信</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.getType eq 2}">电脑</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.getType eq 3}">二维码</c:when>
				</c:choose>
			</p>
			<p>
				<label>是否首次获得：</label>				
				<c:choose>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isFirstGet eq 0}">非首次</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.isFirstGet eq 1}">首次</c:when>
				</c:choose>				
			</p>
			<p style="width: 450px;">
				<label>用户姓名：</label>
				${barcodePrizeConsumerVO.userName }
			</p>
			<p>
				<label>邮政编码：</label>
				${barcodePrizeConsumerVO.barcodePrizeConsumer.zipCode }
			</p>
			<p  style="width: 450px;">
				<label>联系电话：</label>
				${barcodePrizeConsumerVO.barcodePrizeConsumer.phone }
			</p>
			<p>
				<label>联系地址：</label>
				${barcodePrizeConsumerVO.barcodePrizeConsumer.address }
			</p>
			<p style="width: 450px;">
				<label>邮寄奖品状态：</label>				
				<c:choose>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.postStatus eq 0}">未填写资料</c:when>
					<c:when test="${barcodePrizeConsumerVO.barcodePrizeConsumer.postStatus eq 1}">已填写资料</c:when>
				</c:choose>
			</p>
			<p>
				<label>快递单号：</label>
				${barcodePrizeConsumerVO.barcodePrizeConsumer.courierNumber }
			</p>
			<c:if test="${not empty barcodePrizeConsumerVO.prizeAmountXianjinStr}">
			<p style="width: 450px;">
				<label>现金券金额：</label>
				${barcodePrizeConsumerVO.prizeAmountXianjinStr}
			</p>
			</c:if>
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="button" onclick="jump();">返回</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
  </body>
</html>
