<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/6
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>do real search</title>
    <script src="/JQuery/jquery-3.2.0.min.js"></script>
    <script src="/Bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/Bootstrap/css/bootstrap.min.css">
</head>
<body>
    <center style="padding-top: 150px">
        <h1>Search First</h1>
        <hr>
        <form class="form-inline" role="form" style="padding-top: 50px" action="search/SearchVirusAction" method="post">
            <div class="form-group">
                <span class="input-group"><i class="glyphicon glyphicon-search"></i></span>
                <label class="sr-only" for="keyword">KeyWord</label>
                <input type=text class="form-control" id="keyword" placeholder="Key Words" name="searchDetail">
            </div>
            <div class="form-group">
                <span class="input-group"><i class="glyphicon glyphicon-pencil"></i></span>
                <select class="form-control" name="searchMode">
                    <option value="2">file</option>
                    <option value="0">ip</option>
                    <option value="1">domain</option>
                </select>
            </div>
            <div class="input-group input-group-md">
                <button type="submit" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-cloud" aria-hidden="true"></span>Search
                </button>
            </div>
        </form>
    </center>
</body>
</html>
