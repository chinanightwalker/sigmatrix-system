<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	
	function navTabAjaxDone(json) {
		if (json.statusCode == DWZ.statusCode.error) {
			alertMsg.error(json.message);
			return;
		}
		if (json.statusCode == DWZ.statusCode.ok) {
			navTab.closeCurrentTab();
			navTab.openTabLs(json.navTabId, '${ctx}' + json.forwardUrl, "账户管理");
		}
	}

	function jump() {
		navTab.openTabLs("system", "${ctx}account/list", "账户管理");
	}

	function showRole() {
		$("#role_p").show();
	}
	function hideRole() {
		$("#role_p").hide();
	}
	$(function() {
		if ('${account.admin}' != '' && '${account.admin}' == 'true') {
			$("#role_p").hide();
		}
	});
</script>
</head>

<body>
	<script type="text/javascript">
		function check(id) {
			var obj = document.getElementById(id);
			if (!/^[a-zA-Z\u4e00-\u9fa5]+$/.test(obj.value)) {
				alertMsg.warn("请输入汉字或英文字母!");
				$("#userName").val("");
			}
		}
		function showRole() {
			$("#role_p").show();
			$("[name = roles]:checkbox").attr("checked", false);//全不选
		}
		function hideRole() {
			$("#role_p").hide();
			$("[name = roles]:checkbox").attr("checked", true);//全选
		}
		$(function() {
			if ('${account.admin}' != '' && '${account.admin}' == 'true') {
				$("#role_p").hide();
			}
		});
	</script>
	<div class="pageContent">
		<form method="post" name="form1" action="${ctx}account/saveUpdate"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone);">
			<input type="hidden" value="${account.id}" name="id" /> <input
				type="hidden" value="${account.password}" name="passwordMd5" />
			<div class="pageFormContent" layoutH="56">
				<p style="width: 400px;">
					<label>用户名称：</label> ${account.userName } <input type="hidden"
						name="userName" value="${account.userName }" />
				</p>
				<p>
					<label>手机号：</label> <input id="mobilePhoneNumber"
						name="mobilePhoneNumber" class="required  alphanumeric textInput"
						maxlength="20" value="${account.mobilePhoneNumber }" />
				</p>
				<br>
				<p style="width: 400px">
					<label>登录密码：</label> <input type="hidden" name="oldPwd"
						value="${account.password }" /> <input id="password"
						name="password" type="password" class="alphanumeric textInput"
						minlength="6" maxlength="20" />
				</p>
				<p>
					<label>确认密码：</label> <input id="confirmPwd" name="confirmPwd"
						type="password" class="textInput" equalto="#password" />
				</p>
				<br>
				<p style="width: 400px;">
					<label>昵称：</label> <input id="nickname" name="nickname"
						class="required textInput" maxlength="20"
						value="${account.nickname}" />
				</p>
				<p>
					<label>Email：</label> <input id="email" name="email"
						class="email textInput" maxlength="250" value="${account.email }" />
				</p>
				<p style="width: 400px;">
					<label>状态：</label> <input type="radio" name="status" value="1"
						<c:if test="${account.status==1 or account.status==null}">checked="checked"</c:if>>正常
					<input type="radio" name="status" value="0"
						<c:if test="${account.status==0}">checked="checked"</c:if>>冻结
				</p>
				<br>
				<p style="">
					<label>管理员：</label>
					<c:choose>
						<c:when test="${account.admin==true}">
							<input type="hidden" name="admin" value=true checked="checked" />是
						</c:when>
						<c:otherwise>
							<input type="hidden" name="admin" value=false />否
						</c:otherwise>
					</c:choose>
				</p>
				<p id="role_p" style="width: 100%;">
					<label>角色：</label> ${roleBox }
					<%-- <c:forEach items="${rolesList}" var="role">
					<c:forEach items="${rolesListAccount}" var="roleAccount">
						<c:choose>
							<c:when test="${roleAccount.id eq role.id}">
								<input type='checkbox' name='roles' value='${role.id}' checked="checked"> ${ role.name}
							</c:when>
							<c:otherwise>
								<input type='checkbox' name='roles' value='${role.id}'> ${ role.name}
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:forEach> --%>


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
