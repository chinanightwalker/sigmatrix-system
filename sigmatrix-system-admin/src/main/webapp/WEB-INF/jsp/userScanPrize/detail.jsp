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
	            navTab.openTabLs(json.navTabId,json.forwardUrl,"奖项设置管理");
	      	}
	}
	
	function jump(){
		var jsonStr = {					
				scanTimePrizeName:$("#scanTimePrizeName").val()								
			};
			navTab.openTabLs("system","${ctx}userScanPrize/list","奖项设置查询",{data:jsonStr});
			
	}
	
	</script>
  </head>
  <body>
	<div class="pageContent">
		<form id="scancodeLogForm">
			<%-- <input type="hidden" id="scanTimePrizeId" name="scanTimePrizeId" value="${userScanCodeTimePrize.scanTimePrizeId}" /> --%>
			<input type="hidden" id="scanTimePrizeName" name="scanTimePrizeName" value="${scanTimePrizeName}" />
		</form>
		<form id="editAccountForm" method="post" action="" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
			<p style="width: 400px;">
				<label>奖项编号：</label>
				${userScanCodeTimePrize.scanTimePrizeId}
			</p>
			<p>
				<label>奖项名称：</label>
				${userScanCodeTimePrize.scanTimePrizeName}
			</p>
			<p style="width: 400px;">
				<label>奖项金额：</label>
				${scanTimePrizeAmountStr}
			</p>
			<p >
				<label>扫码次数：</label>
				${userScanCodeTimePrize.useScanTime }
			</p>
			<p style="width: 400px;">
				<label>奖项类型：</label>
				<c:choose>
					<c:when test="${userScanCodeTimePrize.scanTimePrizeType eq 0 }">现金红包</c:when>
					<c:when test="${userScanCodeTimePrize.scanTimePrizeType eq 1 }">实物奖</c:when>
				</c:choose>
			</p>
			<p>
				<label>创建时间：</label>				
				<fmt:formatDate value="${userScanCodeTimePrize.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</p>

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
