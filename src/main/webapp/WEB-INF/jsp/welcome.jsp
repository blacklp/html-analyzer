<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html lang="en">

<body>
    <form:form action="/html/analysis" method="get" modelAttribute="url">
        <div>
            <form:label path="url">URL:</form:label>
            <form:input path="url"/><br/><br/>
        </div>
	    <div>
	        <input type="submit" name="send" value="Submit"/>
	    </div>
	</form>
</body>

</html>