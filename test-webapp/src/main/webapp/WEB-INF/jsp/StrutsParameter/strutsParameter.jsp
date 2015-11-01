<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <base href="<%=basePath%>"/>
    <script type="text/javascript" src="js/jquery/jquery-2.1.3.min.js"></script>
    <title>Struts2 Parameter Test</title>
</head>
<body>
<h3 align="center">Struts2 Parameter Test</h3>
stringPara = ${stringPara}
stringList = ${stringList}

</body>
</html>