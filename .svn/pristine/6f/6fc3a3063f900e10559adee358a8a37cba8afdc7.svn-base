<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  </script>
  <style>
  </style>
  </head>
  
  <body>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
			</ul>
		</div>
	<table class="table" width="100%" layoutH="75">
		<thead>
			<tr>
				<th width="15%" align="center">
					权限编号
				</th>
				<th width="15%" align="center">
					权限名称
				</th>
				<th width="15%" align="center">
					权限标识
				</th>
				<th width="15%" align="center">
					权限描述
				</th>
				<th width="15%" align="center">
					创建时间
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="obj">
				<tr  target="id_permission" rel="${obj.id }">
					<td align="center">
						${obj.id }
					</td>
					<td align="center">
						${obj.name }
					</td>
					<td align="center">
						${obj.permission }
					</td>
					<td align="center">
						${obj.description }
					</td>
					<td align="center">
						${obj.createTime }
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>

  </body>
</html>
