<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/12
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>details of the blog you wanna see</title>
    <link rel="stylesheet" type="text/css" href="/Bootstrap/css/bootstrap.min.css">
    <script src="/JQuery/jquery-3.2.0.min.js"></script>
    <script src="/Bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            var str = "current_user";
            var current_user = "<%=session.getAttribute("current_user")%>";
            if (current_user != "null") {
                $("#backToProflie").removeAttr("disabled");
            }
            else {
                $("#backToProflie").attr("disabled",true);
            }
        })
        $(document).ready(function () {
            var today = new Date();
            $("hr:last").after("<p id='time_set' class='pull-right' style='margin-bottom: 100px;margin-top: 30px;'>Current Time:"+today+"</p>");
        })
        setInterval(function get_Date(){
            var today = new Date();
            $("#time_set").remove();
            $("hr:last").after("<p id='time_set' class='pull-right' style='margin-bottom: 100px;margin-top: 30px;'>Current Time:"+today+"</p>");
        },1000);
    </script>

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
            <div class="jumbotron">
                <p>Welcome To See My Blog</p>
            </div>
            <div class="panel panel-default">
                <div class="page-header">
                    <h2><c:out value="${blogBean.blogTitle}" default="no_title"/></h2>
                    <p><i class="glyphicon glyphicon-star"></i>Blog Owner:<c:out value="${blogBean.userBean.userName}" default="no_user_found"/></p>
                </div>
                <div class="panel-body">
                    <h5 class="panel-title"><c:out value="${blogBean.blogDate}"/></h5>
                    <p style="color: gray"><i class="glyphicon glyphicon-thumbs-up"></i>View Counts:<c:out value="${blogBean.blogClickTimes}"/></p>
                    <hr>
                    <p><c:out value="${blogBean.blogContent}"/></p>
                </div>
                <div class="panel-footer">
                    <a id="backToProflie" href="<c:url value="/blog/ShowCurrentUserBlog"/>">Back To Your profile</a>
                    <hr>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
