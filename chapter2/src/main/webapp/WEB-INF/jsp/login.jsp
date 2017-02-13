
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小春论坛登录</title>
</head>
<body>
<c:if test="${!empty error}">
    <span style="color: red;"><c:out value="${error}"/> </span>
</c:if>

<form action="<c:url value="/ loginCheck.html"/>" method="post">
    用户名：
    <input type="text" name="userName"/>
    <br/>
    密码：
    <input type="text" name="password"/>
    <br/>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
