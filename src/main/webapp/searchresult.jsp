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
    <title>search result page</title>
    <script src="/JQuery/jquery-3.2.0.min.js"></script>
    <script src="/Bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/Bootstrap/css/bootstrap.min.css">
    <script type="text/javascript">
        $(document).ready(function c() {
            <%--<c:set var="searchMode" value="${searchMode}" scope="request"/>--%>
            <%--var a = "${requestScope.searchMode}";--%>
            <%--alert("searchMode:"+a);--%>
            console.log($("#searchMode").html())
            if ($("#searchMode").html() == 1){
                $("#searchModeHeader").append("<h2>Your have select domain_address search mode</h2>")
                $("#domainSearchMode").removeAttr("hidden")
            }
            else if ($("#searchMode").html() == 0){
                $("#searchModeHeader").append("<h2>Your have select ip_address search mode</h2>")
                $("#ipSearchMode").removeAttr("hidden")
            }
            else {
                $("#searchModeHeader").append("<h2>Your have select file_SHA256 search mode</h2>")
                $("#fileSearchMode").removeAttr("hidden")
            }
            $("p").remove("#searchMode");
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

    </style>
</head>
<body>
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
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
                    <p>Create By YangMJ</p>                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div id="searchModeHeader" class="jumbotron">
                <p id="searchMode"><c:out value="${searchMode}" default="no_searchMode_value"/></p>
            </div>
            <div id="fileSearchMode" class="panel panel-default" hidden>
                <div class="page-header">File Details:</div>
                <div class="panel-body">
                    <p>Basic information of the file.</p>
                    <p class="panel-title">Here is the scan result!</p>
                        <div style="padding-top: 5px">
                        <ul class="list-group col-xs-10 col-xs-offset-1">
                            <li class="list-group-item">file SHA256:<c:out value="${fileResultType.fileBean.file}"/></li>
                            <li class="list-group-item">file name:<c:out value="${fileResultType.fileBean.fileName}"/></li>
                            <li class="list-group-item">file size:<c:out value="${fileResultType.fileBean.fileSize}"/></li>
                            <li class="list-group-item">file last analysis:<c:out value="${fileResultType.fileBean.fileLastAnalysis}"/></li>
                        </ul>
                    </div>
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><hr>
                    <p class="panel-title">Here is the scan result!</p>
                    <table class="table table-responsive table-bordered table-hover" style="margin-top: 5px">
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
                                        <td><c:out value="${fileDetectionlist}"/></td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="panel-footer">Supported by VirusTotal!!</div>
            </div>
            <div id="ipSearchMode" class="panel panel-default" hidden>
                <div class="page-header">IP Address Details:</div>
                <div class="panel-body">
                    <p>Basic information of the IP.</p>
                    <p class="panel-title">Here is the scan result!</p>
                    <div style="padding-top: 5px">
                        <ul class="list-group col-xs-10 col-xs-offset-1">
                            <li class="list-group-item">IP Address<c:out value="${ipResultType.ipBean.IPAddress}"/></li>
                            <li class="list-group-item">IP Country:<c:out value="${ipResultType.ipBean.IPCountry}"/></li>
                            <li class="list-group-item">IP Autonomous System:<c:out value="${ipResultType.ipBean.IPAutonomousSystem}"/></li>
                            <li class="list-group-item">IP Note:<c:out value="${ipResultType.ipBean.IPNotes}"/></li>
                        </ul>
                    </div>
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><hr>
                    <p class="panel-title">Here is the ip dns scan result!</p>
                    <table class="table table-responsive table-bordered table-hover" style="margin-top: 5px">
                        <thead>
                            <tr>
                                <td>Date Resolved</td>
                                <td>Web Domain</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ipDNS" items="${ipResultType.ipdnsBeanList}">
                                <tr>
                                    <td><c:out value="${ipDNS.IPDNSDateResolved}"/></td>
                                    <td><c:out value="${ipDNS.IPDNSWebDomain}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br/><hr>
                    <p class="panel-title">Here is the ip web domain scan result!</p>
                    <table class="table table-responsive table-bordered table-hover" style="margin-top: 5px">
                        <thead>
                            <tr>
                                <td>Date Scans</td>
                                <td>Detections</td>
                                <td>URL</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ipURL" items="${ipResultType.ipurlBeanList}">
                                <tr>
                                    <td><c:out value="${ipURL.IPURLDateScanned}"/></td>
                                    <td><span class="label label-warning"><span class="badge"><c:out value="${ipURL.IPURLDetection}"/></span></span></td>
                                    <td><c:out value="${ipURL.IPURLDetail}"></c:out></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="panel-footer">Supported by VirusTotal!!</div>
            </div>
            <div id="domainSearchMode" class="panel panel-default" hidden>
                <div class="page-header">Domain Details:</div>
                <div class="panel-body">
                    <p>Basic information of the domain.</p>
                    <p class="panel-title">Here is the domain scan result!</p>
                    <div style="padding-top: 5px">
                        <ul class="list-group col-xs-10 col-xs-offset-1">
                            <li class="list-group-item">domain name:<c:out value="${domainResultType.domainBean.domainDetial}"/></li>
                            <li class="list-group-item">detect like:<c:out value="${domainResultType.domainBean.domainFeature_1}"/></li>
                            <li class="list-group-item">detect like:<c:out value="${domainResultType.domainBean.domainFeature_2}"/></li>
                            <li class="list-group-item">detect like::<c:out value="${domainResultType.domainBean.domainFeature_3}"/></li>
                            <li class="list-group-item">detect like::<c:out value="${domainResultType.domainBean.domainFeature_4}"/></li>
                        </ul>
                    </div>
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><hr>
                    <p class="panel-title">Here is the scan result!</p>
                    <table class="table table-responsive table-bordered table-hover" style="margin-top: 5px">
                        <thead>
                            <tr>
                                <td>Date Resolved</td>
                                <td>IP address</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="domainDNS" items="${domainResultType.domainDNSBeanList}">
                                <tr>
                                    <td><c:out value="${domainDNS.domainDNSDateResolved}"/></td>
                                    <td><c:out value="${domainDNS.domainDNSIPAddress}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <table class="table table-responsive" style="margin-top: 5px">
                        <thead>
                            <tr>
                                <td>Know Subdmains</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="domainSubdmain" items="${domainResultType.domainSubdomainList}">
                                <tr>
                                    <td><c:out value="${domainSubdmain}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="panel panel-default">
                        <div class="panel-heading">Whois Details</div>
                        <div class="panel-body">
                            <p>
                                <c:forEach var="domainWhoisList" items="${domainResultType.domainWhoisList}">
                                    <c:out value="${domainWhoisList}"/><br/>
                                </c:forEach>
                            </p>
                        </div>
                    </div>
                    <div class="panel-footer">Supported by VirusTotal!!</div>
                </div>
            </div>
            <hr>
        </div>
    </div>
</body>
</html>
