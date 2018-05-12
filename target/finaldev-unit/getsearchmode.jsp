<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/7
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function a() {
            alert("${requestScope.results}")
        }
    </script>
</head>
<body>
    <form action="user/testSave" method="post">
        <c:set var="results" value="request result in page" scope="request"/>
    <%--<div class="btn-group" data-toggle="buttons">--%>
            <%--<label class="btn btn-primary">--%>
                <%--<input type="radio" name="searchMode" id="option1" value="1"> 选项 1--%>
            <%--</label>--%>
            <%--<label class="btn btn-primary">--%>
                <%--<input type="radio" name="searchMode" id="option2" value="2"> 选项 2--%>
            <%--</label>--%>
            <%--<label class="btn btn-primary">--%>
                <%--<input type="radio" name="searchMode" id="option3" value="3"> 选项 3--%>
            <%--</label>--%>
        <%--</div>--%>
            <%--<select class="form-control" name="searchMode">--%>
                <%--<option value="1">1</option>--%>
                <%--<option value="2">2</option>--%>
                <%--<option value="3">3</option>--%>
            <%--</select>--%>
            <%--</div>--%>
        <input type="submit" value="submit">
    </form>
    <c:set var="results" value="session results" scope="session"/>
    <h2>Hello World!</h2>
    <h5><c:out value="${requestScope.results}" default="request result disappeared"/></h5>
    <button type="button" onclick="a()">click</button>
</body>
</html>
