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
    <h2>写文章</h2>

    <form id="editBlogForm" class="form-horizontal">
        <input type="hidden" name="id" value="${blog.id}">
        <div class="form-group-lg">
            <label></label>
            <input type="text" name="title" class="form-control" placeholder="文章标题" value="${blog.title}">
        </div>

        <div class="form-group-lg">
            <label></label>
            <textarea id="blogContentEditor" type="text" name="content" class="form-control" rows="100"
                      placeholder=""><c:out value="${blog.content}" escapeXml='false'></c:out></textarea>
        </div>

        <div class="form-group-lg">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary rest-blog-submit-btn" id="editBlogBtn">保存并发表</button>
            </div>
        </div>
    </form>
</div>
<jsp:include page="../copyright.jsp"></jsp:include>
<script data-main="js/views/blog/config" src="js/libs/require/require.js"></script>
<script type="text/javascript">
    require(['blog-edit-view']);
</script>
</body>
</html>




