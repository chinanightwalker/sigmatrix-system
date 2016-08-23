<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<!-- 		<title>扫码过滤页面 抽奖跳转用  空白页</title> -->
	<meta name="viewport"content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" />
	<meta name="format-detection"content="telephone=no,address=no,email=no" />
	<meta name="mobileOptimized" content="width" />
	<meta name="handheldFriendly" content="true" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<style type="text/css" media="screen">
    	.center{position:absolute;width:auto;height:auto;left:50%;top:50%;margin:-60px 0px 0px -60px;}
       </style>
	<script type="text/javascript"src="<%=path%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript"src="<%=path%>/js/browse.js"></script>
	<script type="text/javascript"src="<%=path%>/js/packageForm.js"></script>
</head>
<body>                 
<%-- 	<div class="center">
		<table>
			<tr>
				<td><img src="<%=path%>/images/common/loading001.gif"></td>
				<td>数据处理中......</td>
			</tr>
		</table>
	</div> --%>
</body>
<script type="text/javascript">
	//判断是否是微信浏览器 不是的话 跳错误页面
	function isWx(){
		if (!browser.versions.isMicroMessenger) {//不是微信浏览器
			window.location.href="<%=path%>/noWeChatBrowser";
		}else {
			//lotteryPrize();//抽奖
			window.onload = lotteryPrize;
		}
	}
	isWx();
	
// 	window.onload = lotteryPrize;

    function lotteryPrize(){ //抽奖
   		var url = "<%=path%>/consumer/lotteryPrize";
	   	console.log("抽奖 url="+url);
		var lpVo = new Object();
		lpVo.qrCode = '${qrCode}';//抽奖码
		lpVo.codeType = '${codeType}';//抽奖类型
		lpVo.status = '2';//抽奖
		jsonObjPackageForm(lpVo,url);
   	}
</script>
</html>