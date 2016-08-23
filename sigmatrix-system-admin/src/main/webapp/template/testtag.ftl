<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="sx" uri="/struts-tags"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<String> list = new ArrayList<String>();   
list.add("a1");   
list.add("a2");   
String[] toBeStored = list.toArray(new String[list.size()]);   
for(String s : toBeStored) {   
     System.out.println(s);   
} 
out.print("ssssssssssssssssssssssssssssssss");
%>
<#list ["winter", "spring", "summer", "autumn"] as x>
${x}
</#list>
  <form action="login.action" method="post">
<table width="200" border="1">
  <tr>
    <td width="48" align="right">username:</td>
    <td width="136">
        <input type="text" name="userName" /></td>
  </tr>
  <tr>
    <td align="right">password</td>
    <td>
      <input type="text" name="userPassword" /></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="Submit" value="submit" /></td>
  </tr>
</table>
  </form>
</body>
</html>