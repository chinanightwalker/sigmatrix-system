<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function jump() {
		navTab.openTabLs("system", "${ctx}ActivityTemplate/list", "活动模板管理");
	}
	function navTabAjaxDone(json) {
		if (json.statusCode == DWZ.statusCode.error) {
			alertMsg.error(json.message);
			return;
		} else if (json.statusCode == DWZ.statusCode.ok) {
			alertMsg.correct(json.message);
			navTab.closeCurrentTab();
			navTab.openTabLs(json.navTabId, '${ctx}'+ json.forwardUrl, "活动模板管理");
		} else if (json.statusCode == '0000') {
			alertMsg.error(json.message);
			navTab.closeCurrentTab();
			navTab.openTabLs(json.navTabId, '${ctx}' + json.forwardUrl, "活动模板管理");
		}
	}
</script>
</head>
<body>
	<div class="pageContent">
		<form method="post" action="${ctx}ActivityTemplate/save"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone);">
			<input type="hidden" name="templateId"  value='${activityTemplate.templateId}' />
			<div class="pageFormContent" layoutH="56">
				<p style="width: 100%;">
					<label>模板名称：</label> <input name="templateName" class="required"
						maxlength="64"
						value="${activityTemplate.templateName}" />
				</p>
				<p style="width: 100%;">
					<label>模板路径：</label> <input name="templatePath" class="required"
						maxlength="256"
						value="${activityTemplate.templatePath}" />
				</p>
				<p style="width: 100%;">
					<label>模板绝对路径：</label> <input name="templateRealPath"
						class="required" maxlength="256"
						value="${activityTemplate.templateRealPath}" />
				</p>
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">保存</button>
							</div>
						</div></li>
					<li>
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
