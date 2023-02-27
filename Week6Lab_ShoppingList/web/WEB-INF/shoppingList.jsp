<%-- 
    Document   : shoppingList
    Created on : 26-Feb-2023, 3:29:52 PM
    Author     : qball
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        Hello ${username}<br>
        <a href="ShoppingList?action=logout">Logout</a>
        <form action="" method="post">
            <h2>Add Item</h2>
            <input type="text" name="newItem">
            <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
        <form action="" method="post">
            <ul>
                <c:forEach items="${list}" var="item">
                    <li><input type="radio" name="itemList" value="${item}">${item}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
