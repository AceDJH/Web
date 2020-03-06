<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 竞豪
  Date: 2020/3/5
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--首先要把jstl的包导进去--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jftl</title>
</head>
<body>
    <c:if test="true">
        真的
    </c:if>

    <%
        List list = new ArrayList();
        list.add("aa");
        request.setAttribute("list", list);
    %>

    <c:if test="${not empty list}">
        遍历集合
    </c:if>
</body>
</html>
