<!DOCTYPE html>
<html>

<head>
    <title>Главная</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="ms-3 d-grid gap-3">
    <div class="card mt-3" style="width: 30rem;">
        <div class="card-body">
            <h5 class="card-title">Аккаунты</h5>
            <p class="card-text">Создание, изменение и удаление учётных записей пользователей. Создание учебных групп. Создание преподавателей.</p>
            <form action="/user/index" method="get">
                <input type="submit" class="btn btn-primary" value="Перейти"/>
            </form>
        </div>
    </div>
    <div class="card" style="width: 30rem;">
        <div class="card-body">
            <h5 class="card-title">Группы</h5>
            <p class="card-text">Изменение и удаление учебных групп. Добавление, изменение, удаление и перевод студентов</p>
            <form action="/groups" method="get">
                <input type="submit" class="btn btn-primary" value="Перейти"/>
            </form>
        </div>
    </div>
    <div class="card" style="width: 30rem;">
        <div class="card-body">
            <h5 class="card-title">Преподаватели</h5>
            <p class="card-text">Изменение, удаление преподавателей</p>
            <a href="/teacher/" class="btn btn-primary">Перейти</a>
        </div>
    </div>
    <div class="card" style="width: 30rem;">
        <div class="card-body">
            <h5 class="card-title">Посещения</h5>
            <p class="card-text">Просмотр посещений студентов и составление отчётов</p>
            <a href="/visits/groups" class="btn btn-primary">Перейти</a>
        </div>
    </div>
</div>

</body>
</html>