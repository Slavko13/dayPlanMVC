<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link  rel="stylesheet" type="text/css" href="/css/suggestions.min.css"  />
</head>


<body>
<p> This is ur login "${UserLogin}"</p>
<#list HomesTags as tag>
    <p>Дом №${tag.id} ${tag.homeName}</p>
</#list>

<form action="/tags" method="post" >
    <div>
    <label>
        Дайте кличку вашему дому:
        <input type="text" name="homeName"/>
    </label>
    </div>
    <div>
    <label>
        Добавьте адресс вашему дому:
        <input type="text" id="address" name="address" style="width: 600px"/>


    </label>
    </div>
    <input type="submit" value="sendBleat">
</form>




<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/suggestions-jquery@19.8.0/dist/css/suggestions.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/suggestions-jquery@19.8.0/dist/js/jquery.suggestions.min.js"></script>

<script>
    $("#address").suggestions({
        token: "e4cbe54853aeb6b91f133737f8392065339fd543",
        type: "ADDRESS",
        /* Вызывается, когда пользователь выбирает одну из подсказок */
        onSelect: function(suggestion) {
            console.log(suggestion);
        }
    });
</script>

</body>
</html>