<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/3
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>Register</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="description" content="This is Yang page">

    <link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap.min.css">
    <script src="JQuery/jquery-3.2.0.min.js"></script>
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
        body{
            padding-top: 100px;
        }
    </style>
    <script>
        $(document).ready(function(){
            $("#username_input input").focus();
            $("#submit").attr("disabled","disabled");
        });
    </script>

</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-4">
            <h2>Welcome to W-Search</h2>
        </div>
    </div>
    <div class="row" style="padding-top:50px">
        <div class="well col-md-6 col-md-offset-3">
            <form class="form-horizontal" method="post">
                <h2 class="">Register</h2>
                <table class="table table-bordered" style="positioning:center">
                    <tr>
                        <td>
                            <li class="label label-danger"><c:out value="${error_message}"/></li>
                        </td>
                    </tr>
                    <tr>
                        <!-- 用户名的表单域 -->
                        <td>
                            <div class="input-group input-group-md" id="username_input">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                                <input class="form-control" placeholder="input username" type="text" name="userBean.userName" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <!-- 密码的表单域 -->
                        <td>
                            <div class="input-group input-group-md" id="password_input">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input class="form-control" placeholder="input password" type="password" name="userBean.userPwd" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <!-- 密码的表单域 -->
                        <td>
                            <div class="input-group input-group-md" id="password_input2">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input class="form-control" placeholder="input password again" type="password" name="password2" />
                            </div>
                        </td>
                    </tr>
                    <tr align="center">
                        <td colspan="2" align="right">
                            <input id="backtologin" class="btn btn-primary" type="button" value="Sign In Now" onclick="window.location.href='login.jsp'"/>
                            <input class="btn btn-primary" type="submit" value="Register" id="submit"/>
                            <input class="btn btn-primary" type="reset" value="Reset"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<!-- 提交请求参数的表单 -->


<script type="text/javascript" color="0,0,255" opacity='1.0' zIndex="-2" count="99" src="CSS/canvas-nest.min.js"></script>
<script type="text/javascript">
    $("input:lt(2)").blur(function () {
        var $submit = $("#submit");
        $submit.removeAttr("disabled");
        if($("input[name='username']").val()==''||$("input[name='password']").val()==''||$("input[name='password2']").val()==''){
            $submit.attr("disabled","disabled");
        }
    });
    $("input:eq(2)").blur(function () {
        var $submit = $("#submit");
        $submit.removeAttr("disabled");
        if($(this).val()==''){
            $submit.attr("disabled","disabled");
        }
        else if($(this).val()!==$("input[name='password']").val()){
            $submit.attr("disabled","disabled");
            alert("the passwords you have input is not same" +
                "Try again!!!!");
        }
    })
</script>
</body>
</html>

