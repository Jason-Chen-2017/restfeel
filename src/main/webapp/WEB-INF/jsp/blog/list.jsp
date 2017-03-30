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

<div class="container-fluid">
    <div class="row">

        <h2>Blog List</h2>
        <button class="btn btn-primary">写文章</button>
        <table id="blogsTable" class="table table-striped">
            <thead>
            <tr>
                <%--<th>Id</th>--%>
                <th>Title</th>
                <th>Content</th>
                <th>CreateTime</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${blogs}" var="blog">
                <tr>
                        <%--<td><a href="/blog/${blog.id}">${blog.id}</a></td>--%>
                    <td><a href="/blog/${blog.id}">${blog.title}</a></td>
                    <td>${blog.content}</td>
                    <td>${blog.gmtCreated}</td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>


<!-- JavaScript -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>

<script src="js/blog/blog.js"></script>
</body>
</html>



