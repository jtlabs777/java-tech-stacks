<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>

    <div class="container">

        <h1>Login</h1>
        <pre>${errorMessage}</pre>
        <form method="post">
            Name: <input type="text" name="name">
            <input type="password" name="password">
            <input type="submit">
        </form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
   
</body>
</html>
