<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2018/5/4
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<head>
    <title>success</title>
    <script src="/JQuery/jquery-3.2.0.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function c() {
            <%--<c:set var="searchMode" value="${searchMode}" scope="request"/>--%>
            <%--var a = "${requestScope.searchMode}";--%>
            <%--alert("searchMode:"+a);--%>
            console.log($("#searchMode").html())
            if ($("#searchMode").html() == 1){
                $("#searchModeHeader").append("<p>Your have select domain_address search mode</p>")
                $("#domainSearchMode").removeAttr("hidden")
            }
            else if ($("#searchMode").html() == 0){
                $("#searchModeHeader").append("<p>Your have select ip_address search mode</p>")
                $("#ipSearchMode").removeAttr("hidden")
            }
            else {
                $("#searchModeHeader").append("<p>Your have select file_SHA256 search mode</p>")
                $("#fileSearchMode").removeAttr("hidden")
            }
            $("p").remove("#searchMode");
        })
    </script>
</head>
<body>
    <div id="searchModeHeader">
        <p id="searchMode"><c:out value="${searchMode}" default="no_searchMode_value"/></p>
    </div>
    <div id="fileSearchMode" hidden>
        <table border="1px">
            <thead>
            <tr>
                <td>Engine</td>
                <td>ToolTip</td>
                <td>Detection</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="fileDetectionLists" items="${fileResultType.fileDetectionLists}">
                <tr>
                    <c:forEach var="fileDetectionlist" items="${fileDetectionLists}">
                        <td><c:out value="name: ${fileDetectionlist}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="ipSearchMode" hidden>
        <c:out value="${ipResultType.ipBean}" default="no_ip_bean"/><br/>
        <c:forEach var="ipDNSList" items="${ipResultType.ipdnsBeanList}">
            <c:out value="${ipDNSList}"/><br/>
        </c:forEach>
        <c:forEach var="ipURLList" items="${ipResultType.ipurlBeanList}">
            <c:out value="${ipURLList}"/><br/>
        </c:forEach>
    </div>
    <div id="domainSearchMode" hidden>
        <c:out value="${domainResultType.domainBean}" default="no_domain_bean"/><br/>
        <c:forEach var="domainDNSList" items="${domainResultType.domainDNSBeanList}">
            <c:out value="${domainDNSList}"/><br/>
        </c:forEach>
        <c:forEach var="domainSubdomainList" items="${domainResultType.domainSubdomainList}">
            <c:out value="${domainSubdomainList}"/><br/>
        </c:forEach>
        <c:forEach var="domainWhoisList" items="${domainResultType.domainWhoisList}">
            <c:out value="${domainWhoisList}"/><br/>
        </c:forEach>
    </div>

</body>
</html>
