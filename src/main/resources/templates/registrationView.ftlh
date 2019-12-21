<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<h3>FreeMarker View</h3>
    Hello

<form method="post" action="/registration">



        <#if errorCounter != 0  >
    <p id="error"> ${error}</p>
        </#if>

    <div>
        <label>
        Введите логин:
        <input type="text" name="login" />
        </label>
    </div>
    <div>
        <label>
        Введите фамилию:
        <input type="text" name="first_name" />
        </label>
    </div>
    <div>
        <label>
        Введите фамилию:
        <input type="text" name="second_name" />
        </label>
    </div>
    <div>
        <label>
        Введите пароль:
        <input type="text" name="password" />
        </label>
    </div>
    <div>
        <label>
        Подтвердите пароль:
        <input type="text" name="repeatPass" />
        </label>
    </div>
    <div>
        <label>
        Введите email:
        <input type="text" name="email" />
        </label>
    </div>
    <div>
        <label>
        Введите ваш возраст:
        <input type="text" name="age" />
        </label>
    </div>
    <input type="submit" value="Отправить"/>


</form>


</body>
</html>