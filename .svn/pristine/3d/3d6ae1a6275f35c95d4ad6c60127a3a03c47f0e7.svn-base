<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<%@ page isELIgnored="false"%>
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
            navTab.openTabLs(json.navTabId,'${ctx}'+json.forwardUrl,"账户管理");
      	}
	}
	
	function jump(){
		navTab.openTabLs("system","${ctx}account/list","账户管理");
	}
	</script>
  </head>
  
  <body>
  <script type="text/javascript">
		
		function check(id){
		    var obj=document.getElementById(id);
		   	if(!/^[a-zA-Z\u4e00-\u9fa5]+$/.test(obj.value)){ 
		   		alertMsg.warn("请输入汉字或英文字母!");
		        $("#userName").val("");
		    }  
		}
		function showRole(){
				$("#role_p").show();
				$("[name = roles]:checkbox").attr("checked", false);//全不选
		}
		function hideRole(){
			$("#role_p").hide();
			$("[name = roles]:checkbox").attr("checked", true);//全选
		}
		$(function(){
			if('${user.admin}'!=''&&'${user.admin}'=='true'){
				$("#role_p").hide();
				 
			}
		});
	</script>
	<div class="pageContent">
		<form method="post" name="form1" action="${ctx}account/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
			<p style="width: 400px;">
				<label>用户名称：</label>				
				<input id="userName" name="userName"  onBlur="check('userName')"class="required  textInput"   maxlength="20" value=""/>								
			</p>
			<p>
				<label>手机号：</label>
					<input id="mobilePhoneNumber" name="mobilePhoneNumber" class="required  alphanumeric textInput"  maxlength="20" value=""/>
			</p>
			<br>
			<p style="width:400px">
				<label>登录密码：</label>
				<input id="password" name="password" type="password" class="required alphanumeric textInput" minlength="6" maxlength="20"/>
			</p>
			<p>
				<label>确认密码：</label>
				<input id="confirmPwd" name="confirmPwd" type="password"  class="required textInput" equalto="#password"/>
			</p>
			<br>
			<p style="width: 400px;">
				<label>昵称：</label>
				<input id="nickname" name="nickname" class="required textInput"  maxlength="20" value=""/>		
			</p>
			<p>
				<label>Email：</label>
				<input id="email" name="email" class="email textInput"  maxlength="250" value=""/>	
			</p>
			<p style="width: 400px;">
				<label>状态：</label>
				<input type="radio" name="status" value="1" <c:if test="${status==1 or status==null}">checked="checked"</c:if>>正常
           		<input type="radio" name="status" value="0" <c:if test="${status==0}">checked="checked"</c:if>>冻结
			</p>
			<br>
			<%--<p style="">
				<label>管理员：</label>
				 <input type="radio" name="admin" value=true onclick="hideRole()" <c:if test="${admin==true}">checked="checked"</c:if>>是 
           		<input type="radio" name="admin" value=false onclick="showRole()" <c:if test="${admin==false or admin==null}">checked="checked"</c:if>>否
			</p>
			--%>
			<p id="role_p" style="width: 100%;">
				<label>角色：</label>
				<c:forEach items="${rolesList}" var="role">
					<input type='checkbox' name='roles' id="roles" value='${role.id}'> ${ role.name}
				</c:forEach>
				
			</p>
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
