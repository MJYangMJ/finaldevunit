<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/12
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>here are the list you have searched</title>
</head>
<body>
    <c:forEach var="blogBean" items="${blogBeanList}">
        <a href=
                   "<c:url value="/blog/ShowBlogDetails">
                    <c:param name="operateBlogID" value="${blogBean.blogID}"/>
                </c:url>">
            <c:out value="${blogBean.blogTitle}"/>
        </a>
        <c:out value="${blogBean.blogDate}"/>
        <c:out value="${blogBean.blogClickTimes}"/>
        <c:out value="${blogBean.blogContent}"/>
        <c:out value="${blogBean.blogID}"/><!--display:none-->
    </c:forEach>
</body>
</html>
