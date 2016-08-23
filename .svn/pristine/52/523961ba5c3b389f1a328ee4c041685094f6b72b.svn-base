<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="${ctx}js/common/general.js"></script>
<script type="text/javascript"
	src="${ctx}js/business/activity/activity.js"></script>
<script type="text/javascript">
	function navTabAjaxDone(json){
		if(json.statusCode == DWZ.statusCode.error){
			alertMsg.error(json.message);
			return;
		}else if (json.statusCode == DWZ.statusCode.ok){
			alertMsg.correct(json.message);
            navTab.closeCurrentTab();
            navTab.openTabLs(json.navTabId,'${ctx}'+json.forwardUrl,"产品管理");
      	}else if(json.statusCode=='0000'){
      	    alertMsg.error(json.message);
      		navTab.closeCurrentTab();
            navTab.openTabLs(json.navTabId,'${ctx}'+json.forwardUrl,"产品管理");          
      	}
	}
	function jump() {
		navTab.openTabLs("system", "${ctx}product/list", "产品管理");
	}
  	</script>
</head>

<body>
	<div class="pageContent">
		<form method="post" action="${ctx}product/saveProduct"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
				<p style="width: 100%;">
					<label>产品Id：</label> <input name="productId"
						class="textInput required digits" maxlength="32" value="${productBase.productId}" />
				</p>
				<p style="width: 100%;">
					<label>产品名称：</label> <input name="productBase.productName"
						class="textInput required" maxlength="32"
						value="${productBase.productName}" />
				</p>
				<dl class="nowrap">
					<dt>产品编号：</dt>
					<dd>
						<input name="productBase.productCode" class="textInput required"
							maxlength="32" value="${productBase.productCode}" />
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>产品积分：</dt>
					<dd>
						<input name="productBase.productIntegrate"
							class="textInput required digits" maxlength="8"
							value="${productBase.productIntegrate}" />
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>是否启用产品积分：</dt>
					<dd>
						<input type="radio" name="productBase.isUserIntegrate" value='1'
							<c:if test="${productBase.isUserIntegrate == 1 or recource.isShow ==null}">checked="checked"</c:if>>是
						<input type="radio" name="productBase.isUserIntegrate" value='0'
							<c:if test="${productBase.isUserIntegrate == 0}">checked="checked"</c:if>>否
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>有效期(天数)：</dt>
					<dd>
						<input name="productBase.shelfLife"
							class="textInput required digits" maxlength="8"
							value="${productBase.shelfLife}" />
					</dd>
				</dl>


				<dl class="nowrap">
					<dt>产品介绍：</dt>
					<dd>
						<textarea id="desc" name="productBase.productInfo" cols="60"
							rows="5" value="${productBase.productInfo}">${productBase.productInfo}</textarea>
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