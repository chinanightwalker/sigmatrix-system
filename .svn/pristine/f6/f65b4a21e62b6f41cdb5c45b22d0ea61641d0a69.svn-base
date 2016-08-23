<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript" src="${ctx}js/ajaxfileupload.js"></script>
  	<script type="text/javascript" src="${ctx}js/scancodeTransition/scancodeTransition.js"></script>
  	<script type="text/javascript">
		function navTabAjaxDone(json){
			if(json.statusCode == DWZ.statusCode.error){
				alertMsg.error(json.message);
				return;
			}
			if (json.statusCode == DWZ.statusCode.ok){
	            alertMsg.correct(json.message);
	            navTab.openTab(json.navTabId,'${ctx}'+json.forwardUrl,"过渡页管理");
	      	}
		}
		function jump(){
			 navTab.openTabLs("system",'${ctx}'+"productTransitionage/list","过渡页管理");
		}
  </script>
  </head>
  
  <body>
	<div class="pageContent">
		<form method="post" action="${ctx}productTransitionage/saveOrUpdate" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<input type="hidden" name="transitionId" value="${transition.transitionId}" />
			<div class="pageFormContent" layoutH="56">
				<p style="width: 100%;">
					<label>产品名称：</label>
					<select name="productId" class="required">
						<option value="">-请选择-</option>
						<c:forEach var="obj" items="${productList}">
							<option value="${obj.productId}" <c:if test="${transition.productId == obj.productId}">selected="selected"</c:if> >${obj.productName}</option>
						</c:forEach>
					</select><span style="color: #B70000;">*</span>
				</p>
				<dl class="nowrap">
					<dt>开始时间：</dt>
						<dd>
							<input type="text" name="startTime" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${transition.startTime}"/>" class="date"  />
						</dd>
				</dl>
				<dl class="nowrap">
					<dt>结束时间：</dt>
						<dd>
							<input type="text" name="endTime" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${transition.endTime}"/>" class="date"  />
						</dd>
				</dl>
				<dl class="nowrap">
					<dt>是否启用：</dt>
						<dd>
						  <input type="radio" name="isOpen" value="1" <c:if test="${empty transition.isOpen||transition.isOpen==1}">checked="checked"</c:if> />是
						  <input type="radio" name="isOpen" value="0" <c:if test="${transition.isOpen==0}">checked="checked"</c:if> />否<span style="color: #B70000;">*</span>
						</dd>
				</dl>
				<dl class="nowrap">
					<dt>图片地址：</dt>
						<dd>
						  <input type="file" id="file" name="file" onchange="ajaxFileUpload('${ctx}')"/><span style="color: #B70000;">*</span>
						  <!-- 隐藏表单域 -->
						  <input type="hidden" id="picUrl" name="picUrl" value="${transition.picUrl}" class="required" />
						  <input type="hidden" id="picPath" name="picPath" value="${transition.picPath}" />
						</dd>
				</dl>
				<dl class="nowrap">
					<dt></dt>
					<dd>
					<!-- 用于显示上传的图片 -->
					<img id="transitionImg" alt="" src="${transition.picUrl}">
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
