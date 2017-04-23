<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head><title>HTML Analysis Result</title></head>
    <body>
        <h1>HTML Analysis for Page: ${url}</h1><br/><br/>
        <table border="1">
            <tr>
                <th>HTML Version</th>
                <th>Page Title</th>
                <c:forEach begin="1" end="6" varStatus="loop">
                    <th>Num H${loop.index}</th>
                </c:forEach>
                <th>Num Internal Links</th>
                <th>Num External Links</th>
                <th>Has Login</th>
            </tr>

            <tr>
                <td>${htmlVersion}</td>
                <td>${title}</td>
                <c:forEach var="numH" items="${numHeadings}" >
                    <td>${numH}</td>
                </c:forEach>
                <td>${numInternalLinks}</td>
                <td>${numExternalLinks}</td>
                <td>${containsLoginForm}</td>
            </tr>
        </table>
    </body>
</html>