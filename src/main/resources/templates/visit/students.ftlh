<!DOCTYPE html>
<html>

<head>
    <title>Студенты</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="ms-3 d-grid gap-3 justify-content-center">
    <div class="card mt-3" style="background-color:rgb(171, 193, 249)">
        <div class="card-body">
            <div class="d-flex justify-content-between">
                <div>
                    <a href="/visits/groups"
                       class="link-dark link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                        <h3 class="card-title">Студенты группы</h3>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <div class="d-flex justify-content-between">
        <table class="table">
            <thead>
            <tr>
                <th scope="col"></th>
                <th scope="col">Фамилия</th>
                <th scope="col">Имя</th>
                <th scope="col">Отчество</th>
                <th scope="col">Посещения</th>
            </tr>
            </thead>
            <tbody>
            <#list students as student>
                <tr>
                    <th scope="row">${student_index + 1}</th>
                    <#if student.elder == true ??>
                        <td style="color: mediumseagreen">${student.lastName}</td>
                        <td style="color: mediumseagreen">${student.firstName}</td>
                        <td style="color: mediumseagreen">${student.patronymic}</td>
                    <#else>
                        <td>${student.lastName}</td>
                        <td>${student.firstName}</td>
                        <td>${student.patronymic}</td>
                    </#if>
                    <td><form action="/visit/report/${student.id}">
                            <input type="submit" class="btn btn-outline-primary" value="Посещения">
                        </form></td>
                </tr>
            <#else>
                <tr><td colspan="5">
                        <br><h3 style="text-align: center">Студентов нет</h3>
                    </td>
                </tr>

            </#list>
            </tbody>
        </table>
    </div>

</div>
</body>

</html>
