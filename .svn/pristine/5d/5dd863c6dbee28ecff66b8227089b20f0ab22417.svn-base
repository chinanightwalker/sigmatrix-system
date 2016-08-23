<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- 	<script type="text/javascript" src="${ctx}js/jquery-1.7.2.min.js"></script> --%>
<script type="text/javascript">
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
	function jump() {
		navTab.openTabLs("system", "${ctx}userScanPrize/list", "奖项设置管理");
	}
	
	function zhibian(obj){
		//alert("aa");
		var regexTem = "/^-?\d+\.?\d{0,2}$/";
		if(!regexTem.test(obj.value)){
			alertMsg.error("请输入正确的奖项金额");
		} 
	}
</script>
</head>

<body>
	<div class="pageContent">
		<form method="post" action="${ctx}userScanPrize/saveAdd"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
				<dl style="width: 100%;">
					<dt>奖项名称：</dt>
					<dd>
						<input name="scanTimePrizeName" class="textInput required"
							maxlength="32" value="" />
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>奖项金额：</dt>
					<dd>
						<input name="scanTimePrizeAmount"
							class="textInput required" maxlength="" value="" />
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>奖项类型：</dt>
					<dd>
						<input type="radio" name="scanTimePrizeType" value="0" checked="checked" />现金红包
						<input type="radio" name="scanTimePrizeType" value="1" />实物奖
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>扫码次数：</dt>
					<dd>
						<input name="useScanTime"
							class="textInput required digits" maxlength="" value="" />
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
