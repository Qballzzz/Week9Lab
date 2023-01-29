<%-- 
    Document   : ageCalculator
    Created on : 26-Jan-2023, 4:31:41 PM
    Author     : qball
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form action="Age" method="post">
            Enter your age:
            <input type="text" name="age" value="${age}">
            <br>
            <input type="submit" value="Age Next Birthday"><br>
            ${ageNext}
        </form>
        <a href="Arithmetic">Arithmetic Calculator</a>
    </body>
</html>
