<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="${ctx}js/common/general.js"></script>
  <script type="text/javascript">
		function navTabAjaxDone(json){
			if(json.statusCode == DWZ.statusCode.error){
				alertMsg.error(json.message);
				return;
			}
			if (json.statusCode == DWZ.statusCode.ok){
	            alertMsg.correct(json.message);
	            navTab.openTab(json.navTabId,'${ctx}'+json.forwardUrl,"资源管理");
	      	}
		}
  </script>
  </head>
  
  <body>
    <form id="pagerForm" method="post" action="${ctx}resource/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}" />
		<input type="hidden" name="name" value="${name}" />
		
	</form> 
	<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="${ctx}resource/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td class="searchContentTD">
						资源名称：
					</td>
					<td>
						<input type="text" name="name" value="${name}" />
					</td>					
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									检索
								</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<shiro:hasPermission name="resource:insert">
			<li><a class="add" href="${ctx}resource/add" title="资源管理" rel="system" target="navTab"><span>添加</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="resource:delete">
			<li><a class="delete" href="${ctx}resource/remove?id={sid_user}" rel="system" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="resource:update">
			<li><a class="edit" href="${ctx}resource/edit?id={sid_user}" title="资源管理" rel="system" target="navTab"><span>修改</span></a></li>
			</shiro:hasPermission>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="136">
		<thead>
			<tr>
				<th width="" align="center">
					资源编号
				</th>
				<th width="" align="center">
					资源名称
				</th>
				<th width="" align="center">
					资源标识
				</th>
				<th width="" align="center">
					资源URL
				</th>
				<th width="" align="center">
					资源权重
				</th>
				<th width="" align="center">
					创建时间
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${list}">
				<tr  target="sid_user" rel="${obj.id}">
					<td align="center">
						${obj.id}
					</td>
					<td align="center">
						${obj.name}
					</td>
					<td align="center">
						${obj.identity}
					</td>
					<td align="center">
						${obj.url}
					</td>
					<td align="center">
						${obj.weight}
					</td>
					<td align="center">
						${obj.createTime}
					</td>
				</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<div class="panelBar">
			<div class="">				
			</div>
			<div class="" ></div>
		</div>
	</div>

  </body>
</html>
