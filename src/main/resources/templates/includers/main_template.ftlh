<#macro main title>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <title>${title}</title>
</head>
<body>
<header>
    <a href="/" > На главную</a>
    <a href="/tasks"> Создать задачу</a>
    <a href="/id${(id)!}"> Перейти в свой профиль</a>
    <a href="/login" >Войти</a>
    <a href="/registration">Зарегестрироваться</a>
</header>
<@content/>
</body>
</html>
</#macro>