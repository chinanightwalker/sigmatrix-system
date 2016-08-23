<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  	function navTabAjaxDone(json) {
		if (json.statusCode == DWZ.statusCode.error) {
			alertMsg.error(json.message);
			return;
		} else if (json.statusCode == DWZ.statusCode.ok) {
			alertMsg.correct(json.message);
			navTab.closeCurrentTab();
			navTab.openTabLs(json.navTabId, '${ctx}'+ json.forwardUrl, "我的信息");
		} else if (json.statusCode == '0000') {
			alertMsg.error(json.message);
			navTab.closeCurrentTab();
			navTab.openTabLs(json.navTabId, '${ctx}' + json.forwardUrl, "我的信息");
		}
	}
	function check(id){
	    var obj=document.getElementById(id);
	   	if(!/^[a-zA-Z\u4e00-\u9fa5]+$/.test(obj.value)){ 
	   		alertMsg.warn("修改用户姓名请输入汉字或英文字母!");
	        $("#userName").val("");
	    }  
	}
	</script>
  </head>
  
  <body>
	<div class="pageContent">
		<form method="post" action="${ctx}account/saveProfile" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<input type="hidden" name="id" value="${account.id}"/>
			<div class="pageFormContent" layoutH="56">
				<p style="width:700px">
					<label>登录名称：</label>
					<b id="userName" value=""/>${account.userName}
				</p> 
				<p  style="width:700px">
					<label>用户姓名：</label>
					<input id="nickname" name="nickname" onBlur="check('nickname')" class="required  textInput"  maxlength="20"  value="${account.nickname}"/>
				</p>
				<p  style="width:700px">
					<label>手机号码：</label>
					<input id="mobilePhoneNumber" name="mobilePhoneNumber"  class="digits" onkeyup="this.value=this.value.replace(' ','')"  maxlength="11" value="${account.mobilePhoneNumber}"/>
				</p>
				<p  style="width:700px">
					<label>Email：</label>
					<input id="email" name="email" class="email"  maxlength="250" value="${account.email}"/>
				</p>
				<p  style="width:700px">
					<label>所属角色信息：</label>
					<b id="roles" value=""/>${roles}
				</p>
				<dl class="nowrap">
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				</ul>
			</div>
		</form>
	</div>
  </body>
</html>
