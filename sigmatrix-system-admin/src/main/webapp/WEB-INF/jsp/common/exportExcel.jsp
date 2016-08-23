<%@page language="java" errorPage="/error.jsp" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/title.jsp"%>
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset=utf-8"/>
<meta name="robots" content="index,follow"/>
<meta name="author" content="sigmatrix"/>
<meta name="Copyright" content="Copyright 2010 中创 All Rights Reserved"/>
<meta name="description" content="中创"/>
<meta name="keywords" content="烟草"/>
<link rel="icon" href="/favicon.ico" type="image/x-icon"/>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
<link href="<%= request.getContextPath() %>/css/css.css" rel="stylesheet" type="text/css"/>
<script language="javascript" src="<%=request.getContextPath()%>/js/sharpDateBox.js" charset="utf-8"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/sharpValidator.js" charset="utf-8"></script>
</head>
<body class="mainbg">
  <table class="InputFrameMain" width="713" align="center">
    <tr> 
      <td align="center" class="TableSubject">
      	<s:if test="%{exportUrl!=null}">
      		<a href="<s:property value="%{exportUrl}"/>" target="_blank">点击下载数据导出文件</a>
      	</s:if>
      	<s:if test="%{exportUrl==null}">
      		没有数据可以导出！
      	</s:if>
      </td>
    </tr>    
    <tr>
   		<td align="center" class="TableSubject">
    		<input id="btnIns" type="button" class="button" value=" 返 回 " onclick="javascript:history.back()">
    	</td>
    </tr>
  </table>
</body>
</html>