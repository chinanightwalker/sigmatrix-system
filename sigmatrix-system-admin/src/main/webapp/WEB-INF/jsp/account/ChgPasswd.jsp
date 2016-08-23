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
            //navTab.closeCurrentTab();
            //alertMsg.correct('操作成功！');
            //navTab.openTabLs(json.navTabId,json.forwardUrl,"修改密码");
			alertMsg.correct('修改密码成功,请重新登录!', {okCall:function(){
            	window.location.replace("${ctx}login/logout");
			}});
      	}
	}

	</script>
  </head>
  
  <body>
  <script type="text/javascript">
	</script>
	<div class="pageContent">
		<form method="post" action="${ctx}account/savePasswd" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
			<P style="width: 800px;">
				<label>帐号原密码：</label>
				<input name="oldPasswd" type="password" autocomplete="off" class="required textInput" minlength="6" maxlength="20">
			</P>
			<P style="width: 800px;">
				<label>新密码：</label>
				<input id="password" name="password" type="password" autocomplete="off" class="required textInput" minlength="6" maxlength="20"/>
			</P>
			<P>
				<label>请再次输入：</label>
				<input id="confirmPwd" name="confirmPwd" type="password" autocomplete="off" class="required textInput" equalto="#password"/>
			</P>
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
