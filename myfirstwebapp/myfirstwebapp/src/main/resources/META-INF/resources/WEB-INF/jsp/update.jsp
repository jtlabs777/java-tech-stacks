<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    
    <title>Add Todo Page</title>



</head>
<body>
    <div class="container">    
        <h1>Modify Todo Details</h1>
        <form:form method="put" modelAttribute="todo">
            Description: <form:input type="text" path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning"/><br>
            <form:input type="hidden" path="id" />
            <form:input type="hidden" path="done" />
            <input type="submit" class="btn btn-success"/>
        </form:form>



    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
    </html>
