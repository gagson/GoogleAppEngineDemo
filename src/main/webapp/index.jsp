<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kic.HelloAppEngine" %>
<html>
    <head>
        <title>Google App Engine Test</title>
    </head>
    <body>
        <h1>Google App Engine Test</h1>
        <h5>Gagson Lee</h5>
        <form action="/login" method="post">
            <label for="name">Username:</label><br>
            <input type="text" id="name" name="name"><br>
            <label for="secret">Password:</label><br>
            <input type="password" id="secret" name="secret"><br><br>
            <input type="submit" value="Submit">
        </form> 
        
        <p>This is <%= HelloAppEngine.getInfo()%>.</p>
        <table>
            <tr>
                <td colspan="2" style="font-weight:bold;">Available Servlets:</td>
            </tr>
            <tr>
                <td><a href='/hello'>Hello App Engine</a></td>
            </tr>
        </table>


</body>
</html>
