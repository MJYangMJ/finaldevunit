<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/12
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>do some change</title>
    <link rel="stylesheet" type="text/css" href="/Bootstrap/css/bootstrap.min.css">
    <script src="/JQuery/jquery-3.2.0.min.js"></script>
    <script src="/Bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
        body{
            padding-top: 100px;
        }
        .row{
            padding-top:5px;
            padding-bottom:5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="well col-md-6 col-md-offset-3">
                <form class="form-horizontal" action="<c:url value="/blog/UpdateBlogContent"/>" method="post">
                    <div class="form-group  has-success has-feedback">
                        <label class="control-label" for="idsuccess">Success Status</label>
                        <input disabled id="idsuccess" type="text" value="<c:out value="${blogBean.blogID}"/>"/>
                        <span class="help-block">This part cannot be changed</span>
                        <span class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                    <div class="form-group  has-success has-feedback">
                        <label class="control-label" for="titlesuccess">Success Status</label>
                        <input disabled id="titlesuccess" type="text" value="<c:out value="${blogBean.blogTitle}"/>"/>
                        <span class="help-block">This part cannot be changed</span>
                        <span class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                    <div class="form-group  has-success has-feedback">
                        <label class="control-label" for="contentsuccess">Success Status</label>
                        <textarea id="contentsuccess" value="<c:out value="${blogBean.blogContent}"/>" placeholder="<c:out value="${blogBean.blogContent}"/>" name="blogBean.blogContent"/></textarea>
                        <span class="help-block">This part can be changed whatever you want</span>
                        <span class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                    <input type="submit" class="btn btn-default" value="Commit Now!"/>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
