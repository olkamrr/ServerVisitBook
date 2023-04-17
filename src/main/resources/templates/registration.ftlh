<!DOCTYPE html>
<html>

<head>
    <title>Создание пользователя</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="ms-3 d-grid gap-3 justify-content-center">
    <div class="card mt-3" style="background-color:rgb(171, 193, 249)">
        <div class="card-body">
            <div class="d-flex justify-content-between">
                <h3 class="card-title">Создание учётной записи</h3>
                <div class="d-flex justify-content-between">
                    <form method="get" action="/user/index">
                        <button class="btn btn-primary ms-2">Назад</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="card mt-1">
        <div class="card-body">
            <form action="/registration" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Логин</label>
                    <input type="text" class="form-control" name="login">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Пароль</label>
                    <input type="password" class="form-control" name="password">
                </div>
                <div class="d-flex justify-content-center">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" class="btn btn-outline-primary col-sm-12" value="Создать" />
                </div>
            </form>
            <div class="d-flex justify-content-center">
                <#if errorMessage??>
                    <h4 style="color: red">${errorMessage}</h4>
                </#if>
            </div>
        </div>
    </div>
</div>
</div>
</body>

</html>