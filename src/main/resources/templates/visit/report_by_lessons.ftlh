<!DOCTYPE html>
<html>

<head>
    <title>Посещения</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="ms-3 d-grid gap-3 justify-content-center">
    <div class="card mt-3" style="background-color:rgb(171, 193, 249)">
        <div class="card-body">
            <div class="d-flex justify-content-between">
                <div>
                    <a href="/schedule/${groupId}"
                       class="link-dark link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                        <h3 class="card-title">Отчёт</h3>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <div class="d-flex justify-content-between">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Фамилия</th>
                <th scope="col">Имя</th>
                <th scope="col">Отчество</th>
                <th scope="col">Количество пропусков</th>
                <th scope="col">Количество пропусков по уважительной причине</th>
                <th scope="col">Количество посещений</th>
                <th scope="col">Общее количество пар</th>
            </tr>
            </thead>
            <tbody>
            <#list reports as report>
                <tr>
                    <td>${report.student.lastName}</td>
                    <td>${report.student.firstName}</td>
                    <td>${report.student.patronymic}</td>
                    <td>${report.n}</td>
                    <td>${report.nb}</td>
                    <td>${report.be}</td>
                    <td>${report.count}</td>
                </tr>
            <#else>
                <tr><td colspan="5">
                        <br><h3 style="text-align: center">Посещений нет</h3>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

</div>
</body>

</html>
