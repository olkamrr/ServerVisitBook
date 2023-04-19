<!DOCTYPE html>
<html>

<head>
    <title>Преподаватели</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="ms-3 d-grid gap-3 justify-content-center">
    <div class="card mt-3" style="background-color:rgb(171, 193, 249)">
        <div class="card-body">
            <div class="d-flex justify-content-between">
                <div>
                    <a href="/" class="link-dark link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"><h3 class="card-title">Преподаватели</h3></a>
                </div>
            </div>
        </div>
    </div>
    <#list teachers as teacher>
        <div class="card mt-1">
            <div class="card-body">
                <div class="d-flex justify-content-between">
                    <div class="mx-5">
                        <h5 class="card-title">${teacher.lastName}</h5>
                        <p class="card-text">${teacher.firstName} ${teacher.patronymic}</p>
                    </div>
                    <div class="d-flex justify-content-between">
                        <form method="get" action="/teacher/edit/${teacher.id}">
                            <button class="btn btn-outline-primary ms-2" type="submit" name="" value="">Изменить</button>
                        </form>
                        <form method="" action="">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <button class="btn btn-outline-danger ms-2" type="submit" onclick="return confirm('Вы действительно хотите удалить данного преподавателя?')">Удалить</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    <#else>
        <br><h3 style="text-align: center">Преподавателей нет</h3>
    </#list>
</div>
</body>

</html>