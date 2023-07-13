<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1>
<#if user.email??>
<h3><i>${user.username}</i></h3>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Выйти"/>
</form>
<#else>
<a href="/login">Войти</a>
</#if>
<hr>
<h3>Панель администратора</h3>
<table>
    <tr>
        <th>Email</th>
        <th>Number</th>
        <th>Activity</th>
        <th>Roles</th>
        <th>Ban</th>
        <th>Edit</th>
        <th>Info</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th>${user.active}</th>
            <th><#list user.roles as role>${role}<#sep>, </#list></th>
            <th>
                <form action="/admin/user/ban/${user.id}">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" name="Ban">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Edit</a></th>
            <th><a href="/user/${user.id}">Info</a></th>
        </tr>
    <#else>
        <h3>No users</h3>
    </#list>
</table>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Название объявления: <input type="text" name="title"/><br><br>
    Описание объявления: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Первая фотография: <input type="file" name="file1"/><br><br>
    Вторая фотография: <input type="file" name="file2"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить товар"/>
</form>
</#if>
</body>
</html>