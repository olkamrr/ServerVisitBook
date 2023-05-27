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
                    <a href="/student/visits/${student.groupId.id}"
                       class="link-dark link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                        <h3 class="card-title">Отчёт</h3>
                    </a>
                </div>
                <div>
                    <h6>${student.lastName} ${student.firstName} ${student.patronymic}</h6>
                    <h6>группа: ${student.groupId.code}</h6>
                </div>
            </div>
        </div>
    </div>

    <div class="d-flex justify-content-between">
        <table class="table">
            <thead>
            <tr>
                <th scope="col" class="align-middle" class="text-center">Название</th>
                <th scope="col" class="align-middle" class="text-center">Семестр</th>
                <th scope="col" class="align-middle" class="text-center">Преподаватель</th>
                <th scope="col" class="align-middle" class="text-center">Количество пропусков</th>
                <th scope="col" class="align-middle" class="text-center">%</th>
                <th scope="col" class="align-middle" class="text-center">Количество пропусков по уважительной причине</th>
                <th scope="col" class="align-middle" class="text-center">%</th>
                <th scope="col" class="align-middle" class="text-center">Количество посещений</th>
                <th scope="col" class="align-middle" class="text-center">%</th>
                <th scope="col" class="align-middle" class="text-center">Общее количество пар</th>
            </tr>
            </thead>
            <tbody>
            <#list reports as report>
                <tr>
                    <td>${report.lesson}</td>
                    <td class="text-center">${report.semester}</td>
                    <td>${report.teacher}</td>
                    <td class="text-center">${report.n}</td>
                    <td class="text-center">${report.percentN} %</td>
                    <td class="text-center">${report.nb}</td>
                    <td class="text-center">${report.percentNb} %</td>
                    <td class="text-center">${report.be}</td>
                    <td class="text-center">${report.percentBe} %</td>
                    <td class="text-center">${report.count}</td>
                </tr>
            <#else>
                <tr><td colspan="10">
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
