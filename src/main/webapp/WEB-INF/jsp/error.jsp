<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 2017/3/30
  Time: 02:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>系统异常日志</title>
</head>
<body>
<h5>${errorMessage}></h5>
<code>
    <c:forEach items="${stackTrace}" var="line">
        ${line}
    </c:forEach>
</code>
</body>
</html>
