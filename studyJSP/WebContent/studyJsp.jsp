<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Estudando JSP</title>
</head>
<body>

EM HTML FUNCIONA...<br>
Quanto é 56*123? <%=56*123 %><br>
Scriptlet: <% out.println(" funciona"); %><br>
Declaração: <%! public String teste = " funciona"; %>
<% out.println(teste); %><br>
<%= new String("desse jeito tb funciona") %><br>

<%
for (int i=0;i<=500;i++)
{
%>
<%= new java.util.Date().getSeconds() %><br>

<%}%>
<!-- include estático -->
<%@ include file="include1.txt"%>
<!-- include dinâmico -->
<jsp:include page="include2.txt"></jsp:include>
<%@ page import="java.util.Date" %>
<%= new Date() %>




</body>
</html>