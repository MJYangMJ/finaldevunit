<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/12
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>New Blog Is Coming Soon</title>
</head>
<body>
    <form action="<c:url value="/blog/AddNewBlog"/>" method="post">
        <input type="text" name="blogBean.blogTitle"/>
        <input disabled type="text" name="blogBean.blogDate"/>
        <input type="text" name="blogBean.blogContent"/>
        <input type="submit" value="Commit Now!"/>
    </form>
</body>
</html>
