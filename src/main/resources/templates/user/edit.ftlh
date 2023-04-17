<!DOCTYPE html>
<html>

<head>
    <title>Редактирование</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="mt-2">
    <h1 style="text-align: center">Редактирование пользователя ${user.login}</h1>
    <hr>
    <div class="ms-3 d-grid gap-3 justify-content-center">
        <form action="/user/edit/${user.id}" method="post">
            <#list roles as role>
                <div>
                    <label><input type="checkbox" name="${role}"
                                ${user.roles?seq_contains(role)?string("checked", "" )}>${role}</label>
                </div>
            </#list>
            <input type="hidden" value="${user.id}" name="userId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <div class="mt-3 d-grid gap-3 justify-content-center">
                <button type="submit" class="btn btn-dark">Сохранить</button>
            </div>
        </form>
    </div>
</div>

</body>

</html>