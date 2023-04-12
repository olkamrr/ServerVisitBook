<!DOCTYPE html>
<html>
<head>
    <title>Создание пользователя</title>
</head>
<body>
<form action="/registration" method="post">
    <input type="text" name="login"><br>
    <input type="password" name="password"><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Создать"/>
</form>
<#if errorMessage??>
    <h4 style="color: red">${errorMessage}</h4>
</#if>
</body>
</html>