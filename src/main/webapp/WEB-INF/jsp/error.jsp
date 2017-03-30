<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 2017/3/30
  Time: 02:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"
          prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<jsp:include page="top-nav.jsp"></jsp:include>
<div class="col-sm-12">
    <h1>系统异常统一处理</h1>
    <h3>${errorMessage}></h3>
    <h2>Debug</h2>
    <a href="https://www.google.com/webhp?hl=zh-CN#safe=strict&hl=zh-CN&q=${errorMessage}"
       class="btn btn-primary btn-lg" target="_blank" id="Google">Google</a>
    <a href="https://www.baidu.com/s?wd=${errorMessage}" class="btn btn-info btn-lg"  target="_blank" id="Baidu">Baidu</a>
    <a href="http://stackoverflow.com/search?q=${fn:substring(errorMessage,0,100)}"
       class="btn btn-default btn-lg"  target="_blank" id="StackOverFlow">StackOverFlow</a>

    <h2>异常堆栈跟踪日志StackTrace</h2>
    <code>
        <c:forEach items="${stackTrace}" var="line">
            ${line}
        </c:forEach>
    </code>
</div>


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

<!-- JavaScript -->
<script data-main="js/main" src="js/libs/require/require.js"></script>

<script type="text/javascript">
    $(function () {
        $('#Google').click()
        $('#Baidu').click()
        $('#StackOverFlow').click()
    })
</script>

</body>
</html>
