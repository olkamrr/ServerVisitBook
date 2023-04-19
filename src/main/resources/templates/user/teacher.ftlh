<!DOCTYPE html>
<html>

<head>
    <title>Аккаунты</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="ms-3 d-grid gap-3 justify-content-center">
    <div class="card mt-3" style="background-color:rgb(171, 193, 249)">
        <div class="card-body">
            <div class="d-flex justify-content-between">
                <div>
                    <a href="/" class="link-dark link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"><h3 class="card-title">Пользователи</h3></a>

                </div>
                <div class="d-flex justify-content-between">
                    <a class="btn btn-primary ms-2" href="/registration">Создать</a>
                </div>
            </div>
        </div>
    </div>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" href="/user/index">Все пользователи</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/user/admin">Администраторы</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/user/student">Студенты</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/user/teacher">Преподаватели</a>
        </li>
    </ul>
    <#list users as user>
        <div class="card mt-1">
            <div class="card-body">
                <div class="d-flex justify-content-between">
                    <div class="mx-5">
                        <h5 class="card-title">${user.login}</h5>
                        <p class="card-text"><#list user.roles as role>${role}<br></#list></p>
                    </div>
                    <div class="d-flex justify-content-between">
                        <#if user.teacher??>
                            <form>
                                <button type="button" class="btn btn-outline-primary" disabled>Преподаватель создан</button>
                            </form>
                        <#else>
                            <form method="get" action="/teacher/create/${user.id}">
                                <button class="btn btn-outline-primary ms-2" type="submit" name="" value="">Создать преподавателя</button>
                            </form>
                        </#if>
                        <form method="get" action="/user/edit/${user.id}">
                            <button class="btn btn-outline-primary ms-2" type="submit" name="" value="">Изменить роль</button>
                        </form>
                        <#if user.active == true ??>
                            <form method="post" action="/user/disable/${user.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <button class="btn btn-outline-danger ms-2 px-3" type="submit">Заблокировать</button>
                            </form>
                        <#else>
                            <form method="post" action="/user/disable/${user.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <button class="btn btn-outline-success ms-2" type="submit">Разблокировать</button>
                            </form>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</div>
</body>

</html>