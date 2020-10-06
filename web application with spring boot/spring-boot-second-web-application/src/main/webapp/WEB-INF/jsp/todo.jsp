<html>

<head>
    <title>ADD TODO PAGE</title>
    <link href="webjars/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <h1>ADD Todo Page for ${welcomeName}</h1></br>

        <form method="post">
            <fieldset class="form-group">
                <label>Description</label>
                <input name = "desc" type = "text" class="form-control" required="required"/>
            </fieldset>
            <button type="submit" class="btn btn-success">Add</button>
        </form>
    </div>

    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>