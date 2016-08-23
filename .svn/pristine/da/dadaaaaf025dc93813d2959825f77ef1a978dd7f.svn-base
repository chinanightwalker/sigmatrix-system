<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="${ctx}js/common/general.js"></script>
<script type="text/javascript"
	src="${ctx}js/business/activity/activity.js"></script>
<script type="text/javascript">
	function jump() {
		navTab.openTabLs("system", "${ctx}userScanPrize/list", "奖项设置管理");
	}
	function navTabAjaxDone(json) {
		if (json.statusCode == DWZ.statusCode.error) {
			alertMsg.error(json.message);
			return;
		}
		if (json.statusCode == DWZ.statusCode.ok) {
			navTab.closeCurrentTab();
			navTab.openTabLs(json.navTabId, '${ctx}' + json.forwardUrl,
					"奖项设置管理");
		}
	}
</script>
</head>

<body>
	<div class="pageContent">
		<form method="post" action="${ctx}userScanPrize/saveEdit"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone);">
			<input name="scanTimePrizeId" type="hidden"
				value="${userScanCodeTimePrize.scanTimePrizeId}" />
			<div class="pageFormContent" layoutH="56">
				<dl class="nowrap">
					<dt>奖项名称：</dt> 
						<input name="scanTimePrizeName"
						class="textInput required" maxlength="32"
						value="${userScanCodeTimePrize.scanTimePrizeName }" />
				</dl>
				<dl class="nowrap">
					<dt>奖项金额：</dt>
					<dd>
						<input name="scanTimePrizeAmount" class="textInput required"
							maxlength="" value="${scanTimePrizeAmountStr}" />
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>奖项类型：</dt>
					<dd>
						<input type="radio" name="scanTimePrizeType" value="1"
							<c:if test="${userScanCodeTimePrize.scanTimePrizeType == 1 or userScanCodeTimePrize.scanTimePrizeType ==null}">checked="checked"</c:if>>实物奖
						<input type="radio" name="scanTimePrizeType" value="0"
							<c:if test="${userScanCodeTimePrize.scanTimePrizeType == 0}">checked="checked"</c:if>>现金红包
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>扫码次数：</dt>
					<dd>
						<input name="useScanTime"
							class="textInput required digits" maxlength="" value="${userScanCodeTimePrize.useScanTime}" />
					</dd>
				</dl>
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">保存</button>
							</div>
						</div></li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="button" onclick="jump();">返回</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</body>
</html>
