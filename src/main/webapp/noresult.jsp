<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/9
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>no result returned</title>
    <script type="text/javascript">
        function goBack(){
            window.history.back()
        }
    </script>
</head>
<body>
    <center style="padding-top: 150px">
        <div class="alert alert-danger">
            error page
            error message:Sorry,I've found nothing for you.Please try some key words again;
            <button onclick="goBack()">GoBack</button>
        </div>
    </center>
</body>
</html>
