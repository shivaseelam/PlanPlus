<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <spring:url value="resources/js/jquery-1.12.1.min.js"     var="jqueryJs" />
    <script src="${jqueryJs}"></script>
    <spring:url value="resources/js/jquery.dataTables.js"     var="datatable" />
    <script src="${datatable}"></script>
    <spring:url value="resources/js/dataTables.scroller.min.js"     var="datatableSCMIN" />
    <script src="${datatableSCMIN}"></script>
    <spring:url value="resources/js/dataTables.scroller.js"     var="datatableSC" />
    <script src="${datatableSC}"></script>
    <spring:url value="resources/css/jquery.dataTables.css" var="jquerydataTables" />
    <link href="${jquerydataTables}" rel="stylesheet" />
    <spring:url value="resources/css/jquery.dataTables.min.css" var="jquerydataTablesMin" />
    <link href="${jquerydataTablesMin}" rel="stylesheet" />
    <spring:url value="resources/css/scroller.dataTables.min.css" var="jquerydataTablesScollerMin" />
    <link href="${jquerydataTablesScollerMin}" rel="stylesheet" />
    <spring:url value="resources/css/common.css" var="common" />
    <link href="${common}" rel="stylesheet" />
    <spring:url value="resources/images" var="images" />
    <link href="${common}" rel="stylesheet" />
