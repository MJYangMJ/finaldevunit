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
    <script src="/JQuery/jquery-3.2.0.min.js"></script>
    <script src="/Bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/Bootstrap/css/bootstrap.min.css">
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type:"GET",
                url:"IndexGetBlogAction?searchDetails=*",
                dataType:"json",
                success:function (data) {
                    var d = eval("("+data+")");
                    a(d);


                },
                error:function () {
                    alert("Something Wrong With The Connection!!");
                }

            })
        })

        function a(data) {
//            var html = '<ul>';
//            for (var i = 0; i < data.length; i++) {
//                html += '<li><ul>';
//                for (var j=0; j<data[i].length; j++){
//                    html += '<li>' + data[i][j] + '</li>';
//                }
//                html += '</ul></li>';
//            }
//            html += '</ul>';
            for (var i=0;i<data.length;i++){
                $('#mainPanels').append(getNewPanel(data[i],i));
            }

        }

        function getNewPanel(date,num) {
            <%--var href_val = "<c:url value='/blog/ShowBlogDetails'>+--%>
                                <%--<c:param name='operateBlogID' value='""'/>+--%>
                            <%--</c:url>";--%>
            var href_val = "/blog/ShowBlogDetails?operateBlogID="+date[0];
            var div_1 = "<div class='panel panel-default'>" +
                "<div class='panel-heading'>" +
                "<h4 class='panel-title'>"+
                "<a data-toggle='collapse' data-parent='#mainPanels' href='#collapse"+num+"'>"+
                "Blog: "+date[1]+"</a></h4></div>";
            var div_2 = "<div id='collapse"+num+"' class='panel-collapse collapse'>" +
                "<div class='panel-body'>" +
                "<a href='"+href_val+"'>"+
                date[2]+"</a></div>"+
                "<div class='panel-footer'>" +
                "<span style='margin-left:50px'><i class='glyphicon glyphicon-screenshot'></i>ClickTimes:"+date[3]+"</span>" +
                "<span style='margin-left:50px'><i class='glyphicon glyphicon-time'></i>PublishTime:"+date[4]+"</span>" +
                "<span style='margin-left:50px'><i class='glyphicon glyphicon-user'></i>Author:"+date[5]+"</span>" +
                "</div></div></div>"
            return div_1+div_2;
        }

        $(document).ready(function () {
            var str = "current_user";
            var current_user = "<%=session.getAttribute("current_user")%>";
            if (current_user != "null") {
                $("#logined").css({"color": "green","display":"inherit"});
                $("#commonOperate").after("<li><a href='/login.jsp' style='color: #ff0000' data-toggle='tooltip'" +
                    "data-placement='bottom' title='Click To Open Login Page'>Change Account</a></li>").
                after("<li><a href='GetUserInfoByName'>Modify Personal Info</a></li>")
            }
            else {
                $("#unlogined").css({"color": "red","display":"inherit"});
            }
        })
        $(function () { $("[data-toggle='tooltip']").tooltip(); });
        $(document).ready(function () {
            var today = new Date();
            $("hr:last").after("<p id='time_set' class='pull-right' style='margin-bottom: 100px;margin-top: 30px;'>Current Time:"+today+"</p>");
        })
        setInterval(function get_Date(){
            var today = new Date();
            $("#time_set").remove();
            $("hr:last").after("<p id='time_set' class='pull-right' style='margin-bottom: 100px;margin-top: 30px;'>Current Time:"+today+"</p>");
        },1000);
        function alertNoneFunction() {
            alert("This is not finished yet,be patient and wait!");
        }
        function showAllUsers() {
            var user = "<%=session.getAttribute("current_user")%>";
            if (user!="yang"){
                alert("NOT CERTIFIED!!DENIED");
            }
            else $("#showall").attr("href","ShowAllUsersAction");
        }
    </script>
    <style type="text/css">
        body {
            padding-top: 50px;
            padding-bottom: 40px;
            color: #5a5a5a;
        }

        .carousel {
            height: 500px;
            margin-bottom: 60px;
        }

        .carousel .item {
            height: 500px;
            background-color: #000;
        }

        .carousel .item img {
            width: 100%;
            height: 100%;
        }

        .carousel-caption {
            z-index: 10;
        }

        .carousel-caption p {
            margin-bottom: 20px;
            font-size: 20px;
            line-height: 1.8;
        }
    </style>
</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-responsive-collapse">
                <!--data-target's value must be nav's classname or idname,if not the nav will not show but icon-bar-->
                <span class="sr-only">Toggle Navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">V-are fine</a>
        </div>
        <div class="collapse navbar-collapse navbar-responsive-collapse" id="navbar-responsive-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown" id="logined" href="#" style="display: none" >
                    <a class="dropdown-toggle" data-toggle="dropdown">
                        <i class="glyphicon glyphicon-user"></i>
                        Current User:
                        <c:out value="${sessionScope.current_user}"/>
                        <b class="caret"></b>
                    </a>
                    <ul id="userDropDown" class="dropdown-menu dropdown-menu-left" role="menu" aria-labelledby="dropdownMenu2">
                        <li role="presentation" class="dropdown-header">Personal Pages</li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="/createblog.jsp">Push new blog</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value="/blog/ShowCurrentUserBlog"/>">Your profile</a></li>
                        <li role="presentation" class="divider"></li>
                        <li id="commonOperate" role="presentation" class="dropdown-header">Common Operate</li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" id="showall" href="javascript:void(0);" onclick="showAllUsers()">I'm Manager</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value='/user/LogoutAction'></c:url>" style="color: #0300f0;">Log Out</a></li>
                    </ul>
                </li>
                <li id="unlogined"  style="display: none">
                    <a href="/login.jsp">Please Login First.</a>
                </li>
                <li><a href="/index.jsp">index</a></li>
                <li><a href="/login.jsp">sign in</a></li>
                <li><a href="/register.jsp">sign up</a></li>
                <li><a href="/searchpage.jsp">search</a></li>
                <li><a href="#" data-toggle="modal" data-target="#mymodal">contact</a></li>
            </ul>
            <form action="search/SearchVirusAction" class="navbar-form navbar-right" role="search">
                <div class="input-group input-group-md">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                    <select class="form-control" name="searchMode">
                        <option value="2">file</option>
                        <option value="0">ip</option>
                        <option value="1">domain</option>
                    </select>
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-cloud" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" placeholder="keywords"/>
                </div>
                <div class="input-group input-group-md">
                    <button type="submit" class="btn btn-default" aria-label="Left Align">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>Search
                    </button>
                </div>
            </form>
        </div>
    </div>
    <div class="modal fade" id="mymodal" tabindex="-1" role="dialog" aria-labelledby="mymodal" aria-hidden="true" data-backdrop="static" data-keyboard="true" data-show="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">Following are the details of this program</h4>
                </div>
                <div class="modal-body">
                    <p>Create By YangMJ</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div id="ad-carousel" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#ad-carousel" data-slide-to="1"></li>
                    <li data-target="#ad-carousel" data-slide-to="2"></li>
                    <li data-target="#ad-carousel" data-slide-to="3"></li>
                    <li data-target="#ad-carousel" data-slide-to="4"></li>
                </ol>

                <div class="carousel-inner">
                    <div class="item active">
                        <img src="/imgs/20180401145847511.gif" alt="1 slide">

                        <div class="container">
                            <div class="carousel-caption">
                                <h1>Chrome</h1>

                                <p>Google Chrome，又称Google浏览器，是一个由Google（谷歌）公司开发的网页浏览器。</p>

                                <p><a class="btn btn-lg btn-primary" href="http://www.google.cn/intl/zh-CN/chrome/browser/"
                                      role="button" target="_blank">点我下载</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img src="/imgs/20180401145847511.gif" alt="2 slide">

                        <div class="container">
                            <div class="carousel-caption">
                                <h1>Firefox</h1>

                                <p>Mozilla Firefox，中文名通常称为“火狐”或“火狐浏览器”，是一个开源网页浏览器。</p>

                                <p><a class="btn btn-lg btn-primary" href="http://www.firefox.com.cn/download/" target="_blank"
                                      role="button">点我下载</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img src="/imgs/20180401145847511.gif" alt="3 slide">

                        <div class="container">
                            <div class="carousel-caption">
                                <h1>Safari</h1>

                                <p>Safari，是苹果计算机的最新操作系统Mac OS X中的浏览器。</p>

                                <p><a class="btn btn-lg btn-primary" href="http://www.apple.com/cn/safari/" target="_blank"
                                      role="button">点我下载</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img src="/imgs/20180401145847511.gif" alt="4 slide">

                        <div class="container">
                            <div class="carousel-caption">
                                <h1>Opera</h1>

                                <p>Opera浏览器，是一款挪威Opera Software ASA公司制作的支持多页面标签式浏览的网络浏览器。</p>

                                <p><a class="btn btn-lg btn-primary" href="http://www.opera.com/zh-cn" target="_blank"
                                      role="button">点我下载</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img src="/imgs/20180401145847511.gif" alt="5 slide">

                        <div class="container">
                            <div class="carousel-caption">
                                <h1>IE</h1>

                                <p>Internet Explorer，简称 IE，是微软公司推出的一款网页浏览器。</p>

                                <p><a class="btn btn-lg btn-primary" href="http://ie.microsoft.com/" target="_blank"
                                      role="button">点我下载</a></p>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="left carousel-control" href="#ad-carousel" data-slide="prev"><span
                        class="glyphicon glyphicon-chevron-left"></span></a>
                <a class="right carousel-control" href="#ad-carousel" data-slide="next"><span
                        class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
            <hr>
            <form class="form-inline" role="form" action="blog/SearchBlogAction" method="post" style="padding-top: 30px;padding-left: 250px">
                <div class="form-group">
                    <span class="input-group"><i class="glyphicon glyphicon-search"></i></span>
                    <label class="sr-only" for="keyword">KeyWord</label>
                    <input type=text class="form-control" id="keyword" placeholder="Key Words" name="searchDetail">
                </div>
                <div class="form-group">
                    <span class="input-group"><i class="glyphicon glyphicon-pencil"></i></span>
                    <input class="form-control" type="radio" name="searchMode" value="BlogName" checked/>title
                    <input class="form-control" type="radio" name="searchMode" value="OwnerName"/>owner
                </div>
                <div class="input-group input-group-md">
                    <button type="submit" class="btn btn-default" aria-label="Left Align">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>Search
                    </button>
                </div>
            </form>
        </div>
        <hr style="padding: 20px;">
        <div class="row">
            <div class="panel-group" id="mainPanels">

            </div>
        </div>
    </div>

    <hr>
</body>
</html>
