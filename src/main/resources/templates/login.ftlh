<!DOCTYPE html>
<html>

<head>
    <title>Авторизаиция</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="container-fluid py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col col-md-8">
            <h2 class="text-center">Учёт посещаемости студентов</h2>
        </div>
    </div>
</div>
<div class="d-flex justify-content-center">
    <form action="/login" method="post">
        <div class="container col-sm-20 d-flex flex-column">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Логин</label>
                <input type="text" class="form-control" name="username">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Пароль</label>
                <input type="password" class="form-control" name="password">
            </div>
            <div class="d-flex justify-content-center">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" class="btn btn-outline-primary col-sm-12" value="Вход" />
            </div>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>

</html>