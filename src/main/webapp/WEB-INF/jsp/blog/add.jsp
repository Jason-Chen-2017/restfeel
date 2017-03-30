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
<div class="col-sm-12">
    <h2>写文章</h2>

    <form id="writeBlogForm" class="form-horizontal">
        <div class="form-group-lg">
            <label>标题</label>
            <input type="text" name="title" class="form-control" placeholder="文章标题">
        </div>

        <div class="form-group-lg">
            <label>标题</label>
            <textarea type="text" name="content" class="form-control" rows="100" placeholder=""></textarea>
        </div>

        <div class="form-group-lg">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-lg btn-primary" id="writeBlogFormSubmitBtn">保存并发表</button>
            </div>
        </div>
    </form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
<footer class="panel-footer rest-footer">
    <div class="footer-nav">
        <a href="/" target="_blank" hidefocus="true">RestFeel</a>
        |
        <a href="https://universsky.github.io/" target="_blank">光剑免费图书馆</a>
        |
        <a href="https://jason-chen-2017.github.io/Jason-Chen-2017/" target="_blank">博客</a>
        |
        <a href="#" target="_blank" hidefocus="true">微信公众号：ols-lightshadow</a>
    </div>
    <div class="copyright">RestFeel 2017-7017</div>

</footer>
</body>
</html>



