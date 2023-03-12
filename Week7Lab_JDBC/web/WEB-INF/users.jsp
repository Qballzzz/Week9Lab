<%-- 
    Document   : users
    Created on : 9-Mar-2023, 3:29:36 PM
    Author     : qball
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        <form action="UserServlet" GET="post">
            <table value="${userinfo}">
                <tr><th>Email</th><th>First Name</th><th>Last Name</th><th>Role</th><th></th><th></th></tr>
            </table>
        </form>
    </body>
</html>
