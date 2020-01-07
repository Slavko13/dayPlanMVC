<#include "includers/main_template.ftlh">

<#macro content>
<form method="post" action="/login/process">

    <#if error?? >
        <p> Ошибка в вводе логина или пароля</p>
    </#if>
    <div>
        <label>
            Введите ваш логин:
            <input type="text" name="login" />
        </label>
    </div>
    <div>
        <label>
            Введите ваш пароль:
            <input type="text" name="password" />
        </label>
    </div>
    <input type="submit" value="Отправить" />
</form>
<p> Если ты у тебя нету логин, сделай  <a href="/registration">регистер</a></p>
<p id="recoverPass"> Или же ты мог забыть пароль,<a href="#"> то восстанови же его </a></p>
<div id="recoverForm" style="display: none">
    <form action="/recoverPass" method="get">

    <div>
        <label>
            Введите ваш email:
            <input type="text" name="email"/>
        </label>
    </div>

        <div>
            <label>
                Введите ваш новый пароль:
                <input type="text" name="password"/>
            </label>
        </div>
        <div>
            <label>
                Подтвердите ваш новый пароль:
                <input type="text" name="repeatPass"/>
            </label>
        </div>
        <input type="submit" value="Отправить форму"/>
    </form>

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