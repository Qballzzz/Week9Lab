<%-- 
    Document   : editnote
    Created on : 31-Jan-2023, 10:26:05 AM
    Author     : qball
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <form action="NoteServlet" method="post">
            <h1>Simple Note Keeper</h1>
            <h2>View Note</h2>
            <b>Title: </b><input type="text" value="${note.title}"><br><br>
            <b>Contents:</b><br><input type="text" value="${note.contents}"><br><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
