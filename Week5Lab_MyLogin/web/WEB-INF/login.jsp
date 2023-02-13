<%-- 
    Document   : login
    Created on : 12-Feb-2023, 9:52:20 PM
    Author     : qball
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        Username: <input type="text" value="${username}"><br>
        Password: <input type="text" value="${password}"><br>
        <input type="submit" value="Log in">
    </body>
</html>
