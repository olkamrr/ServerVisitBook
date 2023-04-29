<!DOCTYPE html>
<html>

<head>
    <title>Перевод</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<div class="ms-3 d-grid gap-3 justify-content-center">
    <div class="card mt-3" style="background-color:rgb(171, 193, 249)">
        <div class="card-body">

            <div class="d-flex justify-content-between">
                <div>
                    <h3 class="card-title">Студенты</h3>
                </div>
                <div class="d-flex justify-content-between">
                    <form method="get" action="/student/${student.groupId.getId()}">
                        <button class="btn btn-primary ms-2" type="submit" name="" value="">Назад</button>
                    </form>
                </div>

            </div>

        </div>
    </div>
    <div class="card mt-1">
        <div class="card-body">
            <form method="post" action="/student/transfer/${student.id}">
                <div class="mb-3">
                    <label class="form-label">${student.lastName}</label>
                </div>
                <div class="mb-3">
                    <label class="form-label">${student.firstName}</label>
                </div>
                <div class="mb-3">
                    <label class="form-label">${student.patronymic}</label>
                </div>
                <div class="mb-3">
                    <label class="form-label">Группа</label>
                    <select class="form-select" name="groupId">
                        <#list groups as group>
                            <option name="groupId" value="${group.id}" <#if group.id == student.groupId.getId()>selected</#if>>${group.code}</option>
                        </#list>
                    </select>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" class="btn btn-primary" value="Сохранить">
            </form>
        </div>
    </div>
</div>

</body>

</html>