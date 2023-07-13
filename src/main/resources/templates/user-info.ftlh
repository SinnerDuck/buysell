<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1>
<hr>
<h3>Профиль пользователя ${user.username}</h3>
<b>Номер телефона: </b> ${user.phoneNumber} <br>
<h4>Товары пользователя ${user.username}</h4>
<#list product as product>
    <div>
        <p><b>${product.title}</b> ${product.price} tenge | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
</#list>
<a href="/registration">Зарегистрироваться</a>
</body>
</html>