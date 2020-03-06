<#include "includers/main_template.ftlh">

<#macro content>


    <div class="container">
<form method="post" action="/registration/process">



        <#if errorCounter != 0  >
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </#if>



        <div class="form-group">
            <label for="login">Логин:</label>
            <input type="text" class="form-control" id="login" placeholder="Логин" name="login">
        </div>

        <div class="form-group">
            <label for="first_name">Вашу фамилию:</label>
            <input type="text" class="form-control" id="name" placeholder="Ваше имя" name="first_name">
        </div>

        <div class="form-group">
            <label for="second_name">Вашу фамилию:</label>
            <input type="text" class="form-control" id="name" placeholder="Ваше имя" name="second_name">
        </div>

        <div class="form-group">
            <label for="password">Введите ваш пароль</label>
            <input type="text" class="form-control" id="password" placeholder="Пароль" name="password">
        </div>

        <div class="form-group">
            <label for="email">Введите ваш пароль</label>
            <input type="text" class="form-control" id="email" placeholder="Email" name="email">
        </div>

        <div class="form-group">
            <label for="age">Введите ваш возраст</label>
            <input type="text" class="form-control" id="age" placeholder="18" name="age">
        </div>

    <input type="submit" value="Отправить" class="btn btn-primary"/>

</form>

</div>
</#macro>

<@main title="registration"/>