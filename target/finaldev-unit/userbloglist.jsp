<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/12
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>your blogs</title>
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
        $(document).ready(function () {
            $("#options").focus();
            $("#options").click(function () {
                if ($("#options").is(".active"))
                    $(".show_option").css("display","table-cell");
                else
                    $(".show_option").css("display","none");
            })
        })
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
                    <caption>Blogs Table</caption>
                    <button id="options" data-toggle="button" class="btn btn-primary pull-right">Edit</button>
                    <thead>
                        <tr>
                            <th>&nbsp;&nbsp;Title</th>
                            <th>&nbsp;&nbsp;Date Pushed</th>
                            <th>&nbsp;&nbsp;Click Times</th>
                            <th class="show_option" colspan="2" style="display: none;">&nbsp;&nbsp;Option</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="blogBean" items="${blogBeanList}">
                            <tr>
                                <td>
                                    <a href=
                                       "<c:url value="/blog/ShowBlogDetails">
                                            <c:param name="operateBlogID" value="${blogBean.blogID}"/>
                                        </c:url>">
                                        <c:out value="${blogBean.blogTitle}"/>
                                    </a>
                                </td>
                                <td><c:out value="${blogBean.blogDate}"/></td>
                                <td><c:out value="${blogBean.blogClickTimes}"/></td>
                                <%--<td><c:out value="${blogBean.blogContent}"/></td>--%>
                                <%--<td><c:out value="${blogBean.blogID}"/><!--display:none--></td>--%>
                                <td class="show_option" style="display: none;">
                                    <i class="glyphicon glyphicon-cog"></i>
                                    <a href=
                                       "<c:url value="/blog/ChangeBlogDetails">
                                            <c:param name="operateBlogID" value="${blogBean.blogID}"/>
                                        </c:url>">edit
                                    </a>
                                </td>
                                <td class="show_option" style="display: none;">
                                    <i class="glyphicon glyphicon-trash"></i>
                                    <a href=
                                       "<c:url value="/blog/DeleteBlog">
                                            <c:param name="operateBlogId" value="${blogBean.blogID}"/>
                                        </c:url>">delete
                                    </a>
                                </td>
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
