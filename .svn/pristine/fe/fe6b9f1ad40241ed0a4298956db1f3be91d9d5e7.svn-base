<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript" src="${ctx}js/common/general.js"></script>
  	<script type="text/javascript" src="${ctx}js/business/activity/activity.js"></script>
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
      	else if(json.statusCode=='0001'){
      		alertMsg.error(json.message);
      		navTab.closeCurrentTab();
            navTab.openTabLs(json.navTabId,'${ctx}'+json.forwardUrl,"产品管理");
      	}
	}
  	</script>
  </head>

<body>
	<form id="pagerForm" method="post" action="${ctx}product/list">
		<input type="hidden" name="pageNum" value="${page.pageNo}'/>" />
		 <input type="hidden" name="productName" value="${productbase.productName}" />
		<input type="hidden" name="productCode" value="${productbase.productCode}" />
	</form>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${ctx}product/list" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td class="searchContentTD">产品名称：</td>
						<td><input type="text" name="productName"
							value="${productbase.productName}" /></td>
						<td class="searchContentTD">产品编号：</td>
						<td><input type="text" name="productCode"
							value="${productbase.productCode}" /></td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<li>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">检索</button>
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
				<shiro:hasPermission name="product:insert">
					<li><a class="add" href="${ctx}product/addProduct"
						title="新增产品" rel="system" target="navTab"><span>新增</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="product:delete">
					<li><a class="delete"
						href="${ctx}product/deleteProduct?productId={sid_user}"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="product:update ">
					<li><a class="edit"
						href="${ctx}product/editProduct?productId={sid_user}" title="修改产品"
						rel="system" target="navTab"><span>修改</span></a></li>
					<li class="line">line</li>
				</shiro:hasPermission>
		</div>
	</div>
	
	<div class="pageContent">
		<table class="table" width="100%" layoutH="140">
			<thead>
				<tr>
				    <th width="15%" align="center">产品ID</th>
					<th width="15%" align="center">产品名称</th>
					<th width="15%" align="center">产品编号</th>
					<th width="15%" align="center">产品积分</th>
					<th width="15%" align="center">创建时间</th>
					<th width="15%" align="center">产品介绍</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="productbase" items="${page.dataList}">
					<tr target="sid_user" rel="${productbase.productId}">
					    <td align="center">${productbase.productId}</td>
						<td align="center">${productbase.productName}</td>
						<td align="center">${productbase.productCode}</td>
						<td align="center">${productbase.productIntegrate}</td>
						<td align="center"><fmt:formatDate value="${productbase.createTime}" type="both" pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td align="center">${productbase.productInfo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="panelBar">
			<div class="pages">
				<span>显示${page.pageSize}</span> <span>条，共${page.total}条</span>
			</div>
			<div class="pagination" targetType="navTab"
				totalCount="${page.total}" numPerPage="${page.pageSize}"
				pageNumShown="10" currentPage="${page.pageNo}"></div>
		</div>
	</div>

</body>
</html>
