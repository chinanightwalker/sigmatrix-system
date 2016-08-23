<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <link rel="shortcut icon" href="" type="image/x-icon"  />
    <title>企业营销管理系统</title>
    

    <meta http-equiv="X-UA-Compatible" content="IE=7" />
	<meta http-equiv="content-Type" content="text/html; charset=utf-8"/>
	<link href="${ctx}dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="${ctx}dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="${ctx}dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
	<link href="${ctx}dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
	<!--[if IE]>
	<link href="${ctx}dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
	<![endif]-->
	
	<!--[if lte IE 9]>
	<script src="${ctx}dwz/js/speedup.js" type="text/javascript"></script>
	<![endif]-->
	
	<script src="${ctx}dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/jquery.cookie.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/jquery.validate.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
	<script src="${ctx}dwz/xheditor/xheditor-1.1.14-zh-cn.min.js" type="text/javascript"></script>
	<script src="${ctx}dwz/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>
	
	<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
	<script type="text/javascript" src="${ctx}dwz/chart/raphael.js"></script>
	<script type="text/javascript" src="${ctx}dwz/chart/g.raphael.js"></script>
	<script type="text/javascript" src="${ctx}dwz/chart/g.bar.js"></script>
	<script type="text/javascript" src="${ctx}dwz/chart/g.line.js"></script>
	<script type="text/javascript" src="${ctx}dwz/chart/g.pie.js"></script>
	<script type="text/javascript" src="${ctx}dwz/chart/g.dot.js"></script>
	
	<script src="${ctx}dwz/js/dwz.core.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.util.date.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.validate.method.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.barDrag.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.drag.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.tree.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.accordion.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.ui.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.theme.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.navTab.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.tab.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.resize.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.dialog.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.cssTable.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.stable.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.taskBar.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.ajax.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.pagination.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.database.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.datepicker.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.effects.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.panel.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.checkbox.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.history.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.combox.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/dwz.print.js" type="text/javascript"></script>
	<!--
	<script src="bin/dwz.min.js" type="text/javascript"></script>
	-->
	<script src="${ctx}dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
	<script src="${ctx}dwz/js/globalAjaxErr.js" type="text/javascript"></script>

	<script type="text/javascript">
	$(function(){
		DWZ.init("${ctx}dwz/dwz.frag.xml", {
			//loginUrl:"dwz/login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
			loginUrl:"login",	// 跳到登录页面
			statusCode:{ok:200, error:300, timeout:301}, //【可选】
			pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
			debug:false,	// 调试模式 【true|false】
			callback:function(){
				initEnv();
				//$("#themeList").theme({themeBase:"dwz/themes"}); // themeBase 相对于index页面的主题base路径
			}
		});
		$("#exitCcic").click(function(){
			location="logout";
		});
	});
	
	</script>
	</head>
	
	<body scroll="no">
	
		<div id="layout">
			<div id="header">
			<div id="header_logo" style="display:block;background-color:#e7eef0">
			<div class="headerNav"  style="background: url('<%=request.getContextPath() %>/images/enterpriseLogo/${enterprise.code}/${enterprise.otherPicUrl}');background-repeat: no-repeat;">
				<ul style="display:block; height:50px; position:absolute; top:0px; right:0; z-index:0;">
			        <li style="float:left; margin-left:-1px; padding:0 10px; line-height:50px; position:relative; color:#025cb4 ;">欢迎您</li>
					<li style="float:left; margin-left:-1px; padding:0 10px; line-height:50px; position:relative; color:#025cb4;">['${nickname}']</li>
					<li id="exitCcic" style="float:left; margin-left:-1px; padding:0 10px; line-height:50px; position:relative;color:#025cb4;cursor:pointer">退出</li>
				</ul>
			</div>
        
			<!-- navMenu -->
			
		</div>
			<div id="leftside">
				<div id="sidebar_s">
					<div class="collapse">
						<div class="toggleCollapse"><div></div></div>
					</div>
				</div>
				<div id="sidebar">
					<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
	
					<div class="accordion" fillSpace="sidebar">
						<div class="accordionHeader">
						   <h2><span>Folder</span>${enterprise.name}营销管理系统</h2>
						  </div>
						  <div class="accordionContent">
						   <ul class="tree treeFolder">
						   <c:forEach var="menu" items="${menuAuthList}">
						   		<!-- 一级菜单 -->
						   		<c:if test="${menu.parentMenuId eq 0}">
						   			<li>
										<a>${menu.menuName}</a>
										<!-- 二级菜单 -->
										<c:forEach var="bMenu" items="${menuAuthList}">
											<c:if test="${menu.menuId eq bMenu.parentMenuId}">
												<ul>
													<li>
														<c:choose>
															<c:when test="${bMenu.menuName == '活动管理' || bMenu.menuName == '奖项管理'}">
																<a href="${ctx}${bMenu.menuUrl}" target="navTab" external="true" rel="system">${bMenu.menuName}</a>
															</c:when>
															<c:otherwise>
																<a href="${ctx}${bMenu.menuUrl}" target="navTab" rel="system">${bMenu.menuName}</a>
															</c:otherwise>
														</c:choose>
														<!-- 三级菜单 -->
														<c:forEach var="cMenu" items="${menuAuthList}">
															<c:if test="${bMenu.menuId eq cMenu.parentMenuId}">
																<ul>
																	<li><a href="${ctx}${cMenu.menuUrl}" target="navTab" rel="system">${cMenu.menuName}</a></li>
																</ul>
															</c:if>
														</c:forEach>
													</li>
												</ul>
													
											</c:if>
										</c:forEach>
									</li>
						   		</c:if>
								
						   </c:forEach>
						</ul>
						</div>
					</div>
				</div>
			</div>
			<div id="container">
				<div id="navTab" class="tabsPage">
					<div class="tabsPageHeader">
						<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
							<ul class="navTab-tab">
								<li tabid="main" class="main"></li>
							</ul>
						</div>
						<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
						<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
						<div class="tabsMore">more</div>
					</div>
					<ul class="tabsMoreList">
					</ul>
					<div class="navTab-panel tabsPageContent layoutBox">
						<div class="page unitBox">
						</div>
						
					</div>
				</div>
			</div>
	
		</div>
	
		<div id="footer">Copyright &copy; 2015</div>
	
	</body>
	</html>
