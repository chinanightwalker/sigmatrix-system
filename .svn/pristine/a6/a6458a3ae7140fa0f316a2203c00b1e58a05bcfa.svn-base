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
	            navTab.openTabLs(json.navTabId,'${ctx}'+json.forwardUrl,"累计扫码兑奖查询");
	      	}
	}
	
	function jump(){
		var jsonStr = {					
				tel:$("#tel").val(),
				duijiangStatus:$("#duijiangStatus").val(),
				scanCodeOrderId:$("#scanCodeOrderIdTem").val(),
				startDate:$("#startDate").val(),
				endDate:$("#endDate").val()					
				
			};
			navTab.openTabLs("system","${ctx}scanTimeOrder/list","累计扫码兑奖查询",{data:jsonStr});
			
	}
	
	function save(){
		var jsonStr = {					
				tel:$("#tel").val(),
				duijiangStatus:$("#duijiangStatus").val(),
				scanCodeOrderIdTem:$("#scanCodeOrderIdTem").val(),
				scanCodeOrderId:$("#scanCodeOrderId").val(),
				startDate:$("#startDate").val(),
				endDate:$("#endDate").val()					
				
			};
			navTab.openTabLs("system","${ctx}scanTimeOrder/save","累计扫码兑奖查询",{data:jsonStr});
			
	}
	
	</script>
  </head>
  <body>
	<div class="pageContent">
		<form id="scancodeLogForm">
			<%-- <input type="hidden" id="tel" name="tel" value="${tel}" />
			<input type="hidden" id="duijiangStatus" name="duijiangStatus" value="${duijiangStatus}" />
			<input type="hidden" id="scanCodeOrderIdTem" name="scanCodeOrderIdTem" value="${scanCodeOrderIdTem}" />
			<input type="hidden" id="scanCodeOrderId" name="scanCodeOrderId" value="${scanCodeOrderId}" />
			<input type="hidden" id="startDate" name="startDate" value="${startDate}" />
			<input type="hidden" id="endDate" name="endDate" value="${endDate}" /> --%>
		</form>
		<form id="editAccountForm" method="post" action="${ctx}scanTimeOrder/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<input type="hidden" id="tel" name="tel" value="${tel}" />
			<input type="hidden" id="duijiangStatus" name="duijiangStatus" value="${duijiangStatus}" />
			<input type="hidden" id="scanCodeOrderIdTem" name="scanCodeOrderIdTem" value="${scanCodeOrderIdTem}" />
			<input type="hidden" id="scanCodeOrderId" name="scanCodeOrderId" value="${scanCodeOrderId}" />
			<input type="hidden" id="startDate" name="startDate" value="${startDate}" />
			<input type="hidden" id="endDate" name="endDate" value="${endDate}" />
			<div class="pageFormContent" layoutH="56">
			<p width="50%">
				<label>用户编号：</label>
				${sto.userId}
			</p>
			<p>
				<label>用户姓名：</label>
				${sto.name}
			</p>
			<p width="50%">
				<label>兑奖的openID：</label>
				${stoVO.openId }
			</p>
			<p>
				<label>联系电话：</label>
				${sto.tel }
			</p>
			<p  width="50%">
				<label>兑奖状态：</label>
				<c:choose>
					<c:when test="${sto.duijiangStatus eq 0 }">未兑奖</c:when>
					<c:when test="${sto.duijiangStatus eq 1 }">已兑奖</c:when>
				</c:choose>
			</p>
			<p>
				<label>领奖时间：</label>				
				<fmt:formatDate value="${sto.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</p>
			<p width="50%">
				<label>订单号：</label>				
				${sto.scanCodeOrderId }
			</p>
			<p>
				<label>邮政地址：</label>
				${sto.address}
			</p>
			<p width="50%">
				<label>邮编：</label>
				${sto.postCode}
			</p>			
			<p >
				<label>奖项名称：</label>
				${stoVO.scanTimePrizeName}
			</p>
			<p width="50%">
				<label>发货状态：</label>
				<c:choose>
					<c:when test="${sto.status eq 0}">未发货</c:when>
					<c:when test="${sto.status eq 0}">已发货</c:when>
				</c:choose>		
			</p>		
			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="button"><div class="buttonContent"><button type="submit">发货</button></div></div>
					</li>
					<li>
						<div class="button"><div class="buttonContent"><button type="button" onclick="jump();">返回</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
  </body>
</html>
