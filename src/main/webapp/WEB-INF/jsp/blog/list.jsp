<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../header.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../top-nav.jsp"></jsp:include>

<div class="col-sm-12">
    <h2>文章列表</h2>
    <div class="pull-right">
        <a href="addBlog" class="btn btn-primary write-btn" target="_blank">写文章</a>
    </div>

    <table id="blogsTable" class="table table-hover">
        <thead>
        <tr>

            <th>No</th>
            <th>Title</th>
            <th>Author</th>
            <%--<th>Content</th>--%>
            <th>CreateTime</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${blogs}" var="blog" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td><a href="blog?id=${blog.id}" target="_blank">${blog.title}</a></td>
                <td>${blog.author}</td>
                    <%--<td>${fn: substring(blog.content,0,100)}</td>--%>
                <td>${blog.gmtCreated}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
<jsp:include page="../copyright.jsp"></jsp:include>
<script data-main="js/views/blog/config" src="js/libs/require/require.js"></script>
<script type="text/javascript">
    require(['blog-list-view']);
</script>
</body>
</html>



