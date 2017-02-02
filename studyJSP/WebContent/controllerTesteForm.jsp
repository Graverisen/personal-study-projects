<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
NOME: <%=request.getParameter("nome") %><br>
EMAIL:<%=request.getParameter("email") %><br>
SEXO: <%=request.getParameter("sexo") %><br>
LÍNGUAS: <%=request.getParameter("lingua") %><br>
PAÍS: <%=request.getParameter("pais") %><br>
</body>
</html>