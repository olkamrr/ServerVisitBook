<!DOCTYPE html>
<html>

<head>
    <title>Группы</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="ms-3 d-grid gap-3 justify-content-center">
    <div class="card mt-3" style="background-color:rgb(171, 193, 249)">
        <div class="card-body">
            <div class="d-flex justify-content-between">
                <div>
                    <h3 class="card-title">Учебные группы</h3>
                </div>
                <div class="d-flex justify-content-between">
                    <a class="btn btn-primary ms-2" href="/group/create">Создать</a>
                </div>

            </div>

        </div>
    </div>
    <#list groups as group>
    <div class="card mt-1">
        <div class="card-body">
            <div class="d-flex justify-content-between">

                <div class="mx-5">

                        <h5 class="card-title">${group.code}</h5>
                        <p class="card-text">${group.name}</p>

                </div>
                <div class="d-flex justify-content-between">
                    <form method="" action="">
                        <button class="btn btn-outline-primary ms-2" type="submit" name="" value="">Список
                            студентов</button>
                    </form>
                    <form method="get" action="/group/edit/${group.id}">
                        <button class="btn btn-outline-primary ms-2" type="submit" name="" value="">Изменить</button>
                    </form>
                    <form method="post" action="/group/delete/${group.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="btn btn-outline-danger ms-2" type="submit" onclick="return confirm('Вы действительно хотите удалить данную группу?')">Удалить</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </#list>
</div>
</body>

</html>