
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            <label>Username: </label>
            <input type="text" name="username" >
            <br>
            <label>Password: </label>
            <input type="password" name="password">
            <br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
