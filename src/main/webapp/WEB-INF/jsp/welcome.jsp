<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head><title>HTML Analyzer</title></head>
    <body>
        <h1>Welcome to the HTML Analyzer</h1><br/><br/>
        <form:form method="GET" action="/html/analysis" modelAttribute="url">
            URL: <form:input path="url"/>
            <br/><br/>
            <input type="submit" name="send" value="Submit"/>
        </form:form>
    </body>
</html>