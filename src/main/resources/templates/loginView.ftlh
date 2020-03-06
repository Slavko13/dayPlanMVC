<#include "includers/main_template.ftlh">

<#macro content>


    <div class="container" >
<form method="post" action="/login/process">

    <#if error?? >
        <div class="alert alert-danger" role="alert">
            <p>Ошибка ввода логина или пароля</p>
            </div>
    </#if>
    <div class="form-group">
        <label for="login">Логин:</label>
        <input type="text" class="form-control" id="login" placeholder="Логин" name="login">
    </div>

    <div class="form-group">
        <label for="password">Введите ваш пароль</label>
        <input type="text" class="form-control" id="password" placeholder="Пароль" name="password">
    </div>
    <input type="submit" value="Отправить" class="btn btn-primary" />
    <p> Если ты у тебя нету логин, сделай  <a href="/registration">регистер</a></p>
    <p id="recoverPass"> Или же ты мог забыть пароль,<a href="#"> то восстанови же его </a></p>
</form>

<div id="recoverForm" style="display: none">
    <form action="/recoverPass" method="get">

        <div class="form-group">
            <label for="email">email</label>
            <input type="text" class="form-control" id="password" placeholder="Пароль" name="email">
        </div>

        <div class="form-group">
            <label for="password">Введите ваш новый пароль</label>
            <input type="text" class="form-control" id="password" placeholder="Пароль" name="password">
        </div>
        <div class="form-group">
            <label for="password">Повторите ваш пароль</label>
            <input type="text" class="form-control" id="password" placeholder="Пароль" name="repeatPass">
        </div>
        <input class="btn btn-primary" type="submit" value="Восстановить"/>
    </form>

</div>
    </div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $("#recoverPass").click(function() {
        $("#recoverForm").slideToggle(1);
        return false;
    })
</script>
</#macro>

<@main title="login page"/>