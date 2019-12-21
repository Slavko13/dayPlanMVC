<!DOCTYPE html>
<html>
<head>
    <title>Hello World!</title>
</head>
<body>
<p> ${client.login}</p>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>

<form action="/upload/file" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="addFile"/>
</form>


</body>
</html>