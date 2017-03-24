<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<jsp:include page="top-nav.jsp"></jsp:include>

<div class="container-fluid">
    <div class="row">

        <jsp:include page="left-panel.jsp"></jsp:include>

        <jsp:include page="middle-panel.jsp"></jsp:include>

        <jsp:include page="right-panel.jsp"></jsp:include>

    </div>
</div>

<jsp:include page="popup.jsp"></jsp:include>

<jsp:include page="footer.jsp"></jsp:include>


<%--<div class="footer">--%>
    <%--<div class="footer-nav">--%>
        <%--<a href="/" target="_blank" hidefocus="true">RestFeel</a>--%>
        <%--|--%>
        <%--<a href="https://universsky.github.io/" target="_blank">光剑免费图书馆</a>--%>
        <%--|--%>
        <%--<a href="https://jason-chen-2017.github.io/Jason-Chen-2017/" target="_blank">博客</a>--%>
        <%--|--%>
        <%--<a href="#" target="_blank" hidefocus="true">微信公众号：ols-lightshadow</a>--%>
    <%--</div>--%>
    <%--<div class="copyright">RestFeel 2017-7017</div>--%>
<%--</div>--%>

</body>
</html>
