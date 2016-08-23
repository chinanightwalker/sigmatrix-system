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
			navTab.openTabLs(json.navTabId, '${ctx}' + json.forwardUrl, "角色管理");
		}
	}

	function jump() {
		navTab.openTabLs("system", "${ctx}role/list", "角色管理");
	}
</script>
<script type="text/javascript">
	//添加已拥有的资源权限
	function addtable() {
		var resourceCheckTree = $("#t2 input:checked");
		if (resourceCheckTree.length == 0) {
			alertMsg.warn('请选择资源！');
			return;
		}
		var selectPermissionArray = $("#t1 input:checked");
		if (selectPermissionArray.length == 0) {
			alertMsg.warn('请选择权限！');
			return;
		}

		var permissList = $("input[name='permiss']");
		var permissArray = new Array();
		permissList.each(function(i, a) {
			var resIds = a.value.split(";");
			permissArray.push(resIds[0]);
		});
		var permissionId = "";
		var permissionValue = "";
		var permissionIdArray = new Array();
		var permissionValueArray = new Array();

		selectPermissionArray.each(function(i, a) {
			permissionIdArray.push(a.id);
			permissionValueArray.push(a.value);
		});
		permissionValue = permissionValueArray.join();
		permissionId = permissionIdArray.join();
		//jquery循环t2（菜单树）下的所有选中的复选框    
		resourceCheckTree
				.each(function(i, a) {
					var perName = "";
					var perValue = "";
					var isresource = "";
					isresource = $(a).attr('isresource');
					perName = $(a).attr('fullname');
					perValue = a.value;
					if ($.inArray(perValue, permissArray) != -1) {
						alertMsg.warn('资源已经授权！');
						return;
					}
					//拼接已拥有的权限列表
					var template = "<tr>"
							+ "<td align='center' style='width:45%'>"
							+ "<input type='hidden' name='permiss' value='"+perValue+";"+permissionValue+"'>"
							+ perName
							+ "</td>"
							+ "<td align='center'  style='width:45%'>"
							+ permissionId
							+ "</td>"
							+ "<td onClick='getDel(this)' align='center'  style='width:10%'>"
							+ "<a class='' href='javascript:;' style='color:blue;'>删除</a>"
							+ "</td>" + "</tr>";
					$(".pageContent table tbody").append(template);

				});
	}
	//删除选中标签
	function getDel(k) {
		$(k).parent().remove();
	}
	function click_permiss(op) {
		if (op.val() == 1) {
			if (op.is(":checked")) {
				$("input[name='permission']:checked").each(function() {
					if ($(this).val() != op.val()) {
						$(this).attr("checked", false);
					}
				});
			}
		} else {
			$("input[name='permission'][value=1]").attr("checked", false);
		}
	}
</script>
</head>

<body>
	<div layoutH="30"
		style="background: #eef4f5 none repeat scroll 0 0; border-color: #b8d0d6; border-style: solid; border-width: 0 1px; display: block; overflow: auto; padding: 5px 5px 1px;">
		<form method="post" action="${ctx}role/save"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone);">

			<!-- 基本信息 start-->
			<div class="panel"
				style="border-style: solid; border-width: 0 0px; display: block; overflow: auto; padding: 0px 5px 1px;">
				<h1>基本信息</h1>
				<div>
					<table>
						<tr style="height: 30px">
							<input type="hidden" name="id" value="${role.id }" />
							<td width="20%" align="right">角色名称：</td>
							<td width="20%"><input id="name" type="text" name="name"
								class="required  textInput" value="${role.name }" /></td>
							<td width="40%" align="right">角色标识：</td>
							<td width="20%"><input id="role" type="text" name="role"
								class="required  textInput" value="${role.role }" maxlength="12" /></td>
						</tr>
						<tr style="height: 30px; width: 400px">
							<td align="right">角色介绍：</td>
							<td><input id="description" type="text" name="description"
								value="${role.description }" /></td>
							<td align="right">是否显示：</td>
							<td><input type="radio" name="status" value=1
								<c:if test="${role.status==1 or role.status ==null}">checked="checked"</c:if>>显示
								<input type="radio" name="status" value=0
								<c:if test="${role.status==0}">checked="checked"</c:if>>不显示
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- 基本信息end -->

			<div class="panel">
				<!-- edit=1添加；edit=2修改 -->

				<!-- 资源、权限选择start -->
				<div class="panel" defH="180"
					style="border-style: solid; border-width: 0 0px; display: block; overflow: auto; padding: 5px 5px 1px;">
					<h1>资源权限列表</h1>
					<div>
						<div id="t2"
							style="height: 150px; float: left; display: block; margin: 10px; overflow: auto; width: 200px; overflow: auto; border: solid 1px #CCC; line-height: 21px; background: #FFF;">
							<p>资源列表</p>
							${resourceTree }
						</div>
						<!-- 权限列表-->
						<div
							style="height: 150px; float: left; display: block; margin: 10px; overflow: auto; width: 100px; overflow: auto; border: solid 1px #CCC; line-height: 21px; background: #FFF;">
							<dl id="t1">
								<dt>权限</dt>
								<c:forEach items="${permissionList}" var="per">
									<%-- 	<c:if test="${per.name!='查询'}"> --%>
									<dd>
										<input type="checkbox" name="permission"
											onclick="click_permiss($(this))" id="${per.name }"
											value="${per.id }">&nbsp;${per.name }&nbsp;&nbsp;
									</dd>
									<%-- 		</c:if> --%>
								</c:forEach>
							</dl>
						</div>
						<!-- 权限列表end -->
						<div align="left">
							<input id="add" type="button" onclick="addtable()" value="添加" />
						</div>
					</div>
				</div>
				<!-- 资源、权限选择end -->
				<!-- 已拥有的权限列表start -->
				<div class="pageContent"
					style="border-style: solid; border-width: 0 0px; display: block; overflow: auto; padding: 5px 5px 1px;">
					<div class="panelBar">
						<ul class="toolBar">
							<li><span style="text-align: left; padding-left: 0px;">已选择的资源和权限</span></li>
						</ul>
					</div>
					<table id="tableID" class="table" width="100%">
						<thead>
							<tr>
								<th align="center" width="45%">资源</th>
								<th align="center" width="45%">权限</th>
								<th align="center" width="10%">操作</th>
							</tr>
						</thead>
						<tbody>${permiss_html}
						</tbody>
					</table>
				</div>
			</div>

			<div class="formBar"
				style="width: 100%; position: absolute; bottom: 0;">
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
