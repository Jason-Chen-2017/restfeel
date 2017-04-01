<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../header.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../top-nav.jsp"></jsp:include>
<div class="col-sm-10 blog">
    <h1 class="center">${blog.title}</h1>
    <h5 class="center">作者: ${blog.author} 日期: <fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${blog.gmtModified}"/></h5>
    <div id="blogContent" style="display: none">${blog.content}</div>
    <div class="markdown-body"></div>

</div>


<jsp:include page="../copyright.jsp"></jsp:include>

<script data-main="js/views/blog/config" src="js/libs/require/require.js"></script>
<script type="text/javascript">
    require(['blog-detail-view']);
</script>
</body>
</html>



