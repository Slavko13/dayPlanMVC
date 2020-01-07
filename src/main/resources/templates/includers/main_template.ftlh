<#macro main title>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <title>${title}</title>
</head>
<body>
<header>
    <div id="header-flex">
    <a href="/" > На главную</a>
    <a href="/tasks"> Создать задачу</a>
        <#if isAuth == true>
            <a href="/id${(id)!}"> Перейти в свой профиль</a>
            <form action="/logout" method="post">
                <input type="submit" value="Sign Out"/>
            </form>
        </#if>
    <#if isAuth == false>
    <a href="/login" >Войти</a>
    <a href="/registration">Зарегестрироваться</a>
    </#if>
    </div>
</header>
<@content/>
</body>
</html>
</#macro>