<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/9
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Personal Information Modify</title>

    <link rel="stylesheet" type="text/css" href="/Bootstrap/css/bootstrap.min.css">
    <script src="/JQuery/jquery-3.2.0.min.js"></script>
    <script src="/Bootstrap/js/bootstrap.min.js"></script>

    <style type="text/css">
        body{
            margin-top: 100px;
            background-color: #3c3c3c;
        }
    </style>

    <script type="text/javascript">
        $(document).ready(function () {
            var username = "${sessionScope.get('current_user')}";
            if(username=="null"){
                alert("Please Login First");
                window.location.href = "login.jsp";
            }
//            else alert(username);
        })
        function goBack(){
            window.history.back()
        }
    </script>
</head>
<body>

    <div class="container">
        <div class="row">
            <div class="col-md-5 col-md-offset-1">
                <div class="panel panel-default">
                    <div class="panel-heading">Old Information</div>
                    <div class="panel-body">
                        <p>These are the old<span class="label label-warning">OLD!</span> information you have input.</p>
                        <ul class="list-group">
                            <li class="list-group-item">user_id:<c:out value="${userBean.userID}"/></li>
                            <li class="list-group-item">username:<c:out value="${userBean.userName}"/></li>
                            <li class="list-group-item">password:<c:out value="${userBean.userPwd}"/></li>
                        </ul>
                    </div>
                    <div class="panel-footer">You can compare to modify.(user_id can't to be modified)</div>
                </div>
            </div>
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading">New Infomation</div>
                    <div class="panel-body">
                        <p>These are the new<span class="label label-warning">NEW!</span> information you have input.</p>
                        <form class="form-horizontal" action="user/UpdateInfoAction" method="post">
                            <ul class="list-group">
                                <li class="label label-danger"><c:out value="${error_message}"/></li>
                                <li class="list-group-item">user_id:<c:out value="${userBean.userID}"/></li>
                                <li class="list-group-item">
                                    <div class="input-group input-group-md">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input class="form-control" placeholder="input username" type="text" name="userBeanChanged.userName" />
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="input-group input-group-md">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input class="form-control" placeholder="input password" type="password" name="userBeanChanged.userPwd" />
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <button class="form-control btn btn-primary" type="submit" value="Submit">submit</button>
                                </li>
                            </ul>
                        </form>
                    </div>
                    <div class="panel-footer"><button class="btn btn-danger" onclick="goBack()">GoBack</button></div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
