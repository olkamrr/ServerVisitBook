<!DOCTYPE html>
<html>

<head>
    <title>Создать преподавателя</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="ms-3 d-grid gap-3 justify-content-center">
    <div class="card mt-3" style="background-color:rgb(171, 193, 249)">
        <div class="card-body">

            <div class="d-flex justify-content-between">
                <div>
                    <h3 class="card-title">Преподаватели</h3>
                </div>
                <div class="d-flex justify-content-between">
                    <form method="" action="">
                        <button class="btn btn-primary ms-2" type="submit" name="" value="">Назад</button>
                    </form>
                </div>

            </div>

        </div>
    </div>
    <div class="card mt-1">
        <div class="card-body">
            <form method="post" action="/teacher/create/${user}">
                <div class="mb-3">
                    <label class="form-label">Фамилия</label>
                    <input type="text" name="lastName" class="form-control" id="exampleInputEmail1">
                </div>
                <div class="mb-3">
                    <label class="form-label">Имя</label>
                    <input type="text" name="firstName" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="mb-3">
                    <label class="form-label">Отчество</label>
                    <input type="text" name="patronymic" class="form-control" id="exampleInputPassword1">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" class="btn btn-primary" value="Сохранить">
            </form>
        </div>
    </div>
</div>

</body>

</html>