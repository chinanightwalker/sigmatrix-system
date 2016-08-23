<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function jump() {
		navTab.openTabLs("system", "${ctx}settings/list", "系统配置管理");
	}
	function navTabAjaxDone(json) {
		if (json.statusCode == DWZ.statusCode.error) {
			alertMsg.error(json.message);
			return;
		} else if (json.statusCode == DWZ.statusCode.ok) {
			alertMsg.correct(json.message);
			navTab.closeCurrentTab();
			navTab.openTabLs(json.navTabId, '${ctx}'+ json.forwardUrl, "系统配置管理");
		} else if (json.statusCode == '0000') {
			alertMsg.error(json.message);
			navTab.closeCurrentTab();
			navTab.openTabLs(json.navTabId, '${ctx}' + json.forwardUrl, "系统配置管理");
		}
	}
</script>
</head>
  
  <body>
	<div class="pageContent">
		<form method="post" action="${ctx}settings/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		
			<input type="hidden" name="id" value="${settings.id}" />
			<div class="pageFormContent" layoutH="56">
				<p style="width: 100%;">
					<label>键：</label>
					<input type="text" name="key" value="${settings.key}" class="required" />
				</p>
				<dl class="nowrap">
					<dt>值：</dt>
						<dd>
							<input type="text" name="value" value="${settings.value}"
									onkeyup="this.value=this.value.replace(/[\s]/g,'')" 
									onchange="this.value=this.value.replace(/[\s]/g,'')" 
							 		class="required" />
						</dd>
				</dl>
				<dl class="nowrap">
					<dt>名称：</dt>
						<dd>
							<input type="text" name="name" value="${settings.name}" class="required" />
						</dd>
				</dl>
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="button" onclick="jump();">返回</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
  </body>
</html>
