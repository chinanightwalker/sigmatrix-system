<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.sigmatrix.sc.web.util.ExcelModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'excel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%
  		OutputStream os = response.getOutputStream();
  		ExcelModel model = (ExcelModel)request.getAttribute("model");
  		response.reset();//清空输出流
  		//中文文件名处理	
  		response.setCharacterEncoding("UTF-8");
//  		fname = URLEncoder.encode(fname,"UTF-8");
//  		response.setHeader("Content-Desposition", "attachment;filename="+ new String(fname.getBytes("UTF-8"),"GBK")+".xls");
  		response.setHeader("Content-disposition","attachment; filename="+model.getXlsName());
  		response.setContentType("application/ms-excel;");
  		model.createSerialExcel(os);
  	 %>
  
  </body>
</html>
