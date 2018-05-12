<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/9
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>All Users Show Here</title>

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

    <script type="text/javascript">

    </script>

</head>
<body>

    <div class="container">
        <div class="row">
            <div class="col-md-1 col-md-offset-2">
                <span class="label label-info"><strong>Current</strong></span>
            </div>
        </div>
        <div class="row">
            <div class="col-md-1 col-md-offset-3">
                <span class="glyphicon glyphicon-user"></span>:
                <h3><c:out value="${sessionScope.current_user}"/></h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <table class="table table-striped table-bordered table-hover">
                    <caption>User Tables</caption>
                    <thead>
                    <tr>
                        <th>&nbsp;&nbsp;UserId</th>
                        <th>&nbsp;&nbsp;UserName</th>
                        <th>&nbsp;&nbsp;Password</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="userBean" items="${userBeanList}">
                            <tr>
                                <td><c:out value="${userBean.userID}" default="noid"/></td>
                                <td><c:out value="${userBean.userName}" default="noname"/></td>
                                <td><c:out value="${userBean.userPwd}" default="nopwd"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <hr>
                <p><a href="/index.jsp">Back To Index</a></p>
            </div>
        </div>
    </div>
</body>
</html>