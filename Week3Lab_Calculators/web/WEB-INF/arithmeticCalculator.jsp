<%-- 
    Document   : arithmeticCalculator
    Created on : 26-Jan-2023, 4:40:17 PM
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
        <h1>Arithmetic Calculator</h1>
        First: <input type="text" name="first" value="${first}">
        Second: <input type="text" name="second" value="${second}">
        <input type="submit" name="submit" value="+">
        <input type="submit" name="submit" value="-">
        <input type="submit" name="submit" value="*">
        <input type="submit" name="submit" value="%"><br>
        Result<span ${result}> ---</span>
    </body>
</html>
