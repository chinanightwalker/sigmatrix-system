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
        navTab.openTabLs(json.navTabId,'${ctx}'+json.forwardUrl,"资源管理");
  	}
}

function jump(){
	navTab.openTabLs("system","${ctx}resource/list","资源管理");
}

//如果有checkBox有一个被选择触发事件（后台拼接的树a标签中要带onclick事件）
function selectResource(obj){
	var parentName=$(obj).attr("tname");
	var parentValue = $(obj).attr("tvalue");
	$("#resourceParentName").val(parentName);
	$("#resourceParentId").val(parentValue);
 }
 function selectResource2(obj){
	 
	 alertMsg.error("该资源不能作为父级资源");
	return;
 }
 function cleanParent(){
	 $("#resourceParentName").val("");
	$("#resourceParentId").val("");
 }
	/* //获取当前a标签相邻的input框对象
	alert(name);
	var nextInput = $(obj).prev().prev().children();;
	//获取当前选择子节点的name和value
	var parentName = nextInput.attr("name");
	//赋值给父节点显示框name和value */
</script>
</head>
<body>
	<!-- 基本信息 start-->
	<div class="pageContent">
		<form id="form" method="post" name="form" action="${ctx}resource/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="40" style="background: #eef4f5 none repeat scroll 0 0;border-color: #b8d0d6; border-style: solid;border-width: 0 1px;display: block;overflow: auto;padding: 5px 5px 1px;">
			<!-- 树形菜单 -->
			<div id="resourceTree"  layoutH="40" style="float:left; display:block; margin:10px; overflow:auto; width:200px; height:300px; border:solid 1px #CCC; line-height:21px; background:#FFF;">				
					<ul class="tree treeFolder expand">
						   <c:forEach var="menu" items="${list}">
						   		<!-- 一级菜单 -->
						   		<c:if test="${menu.parentId eq 0}">
						   			<li>
										<a tname="${menu.name}" tvalue="${menu.id}" href="javascript:void(0)" onclick="selectResource(this)">${menu.name}</a>
										<!-- 二级菜单 -->
										<c:forEach var="bMenu" items="${list}">
											<c:if test="${menu.id eq bMenu.parentId}">
												<ul>
													<li>
														<c:choose>
															<c:when test="${bMenu.name == '活动管理' || bMenu.name == '奖项管理'}">
																<a tname="${bMenu.name}" tvalue="${bMenu.id}" onclick="selectResource2(this)">${bMenu.name}</a>
															</c:when>
															<c:otherwise>
																<a tname="${bMenu.name}" tvalue="${bMenu.id}" onclick="selectResource2(this)">${bMenu.name}</a>
															</c:otherwise>
														</c:choose>
														<!-- 三级菜单 -->
<%-- 														<c:forEach var="cMenu" items="${list}">
															<c:if test="${bMenu.id eq cMenu.parentId}">
																<ul>
																	<li><a tname="${cMenu.name}" tvalue="${cMenu.id}"onclick="selectResource(this)">${cMenu.name}</a></li>
																</ul>
															</c:if>
														</c:forEach> --%>
													</li>
												</ul>
													
											</c:if>
										</c:forEach>
									</li>
						   		</c:if>								
						   </c:forEach>
						</ul>
				</div>

			<div style="float:right; width:72%;display: block;overflow: auto;">
					<table>
						<tr style="height:30px">
							<td width="20%" align="right">父级资源：</td>
							<td width="20%">
								<input id="resourceParentName" type="text" value="" readonly="readonly" />
								<input id="resourceParentId" name="parentId" type="hidden" value="">
							</td>
							<td align="right">资源名称：</td>
							<td>
								<input id="name" type="text" name="name" class="required  textInput" value=""/>
							</td>
							</tr>
						<tr style="height:30px">
							<td width="20%" align="right">资源身份标识：</td>
							<td  width="20%" >
								<input id="role" type="text" name="identity" class="required  textInput" value=""/> 
							</td>
							<td  width="40%" align="right">资源请求地址：</td>
							<td  width="20%">
								<input id="role" type="text" name="url" class="textInput" value=""/>  
							</td>
						</tr>
						<tr style="height:30px">
							<td width="20%" align="right">资源图标：</td>
							<td  width="20%" >
								<input id="role" type="text" name="icon" class="textInput" value=""/>  
							</td>
							<td  width="40%" align="right">是否显示：</td>
							<td  width="20%">
								<input type="radio" name="isShow" value=true <c:if test="${isShow==true or isShow ==null}">checked="checked"</c:if>>显示
								<input type="radio" name="isShow" value=false <c:if test="${isShow==false}">checked="checked"</c:if>>不显示  
							</td>
						</tr>
						<tr style="height:30px">
							<td width="20%" align="right">资源权重：</td>
							<td  width="20%" >
								<input id="weight" type="text" name="weight" class="required textInput digits" value=""/>  
							</td>
							<td width="20%" align="right">状态：</td>
							<td  width="20%">
								<input type="radio" name="status" value=1 <c:if test="${status==1 or status ==null}">checked="checked"</c:if>>正常
								<input type="radio" name="status" value=0 <c:if test="${status==0}">checked="checked"</c:if>>停用  				
							</td>
						</tr>
					</table>			
			</div>
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
