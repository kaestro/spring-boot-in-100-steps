<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
    <title>ADD TODO PAGE</title>
    <link href="webjars/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <h1>ADD Todo Page for ${welcomeName}</h1></br>

        <form:form method="post" modelAttribute="todo">
            <form:hidden path="id"/>
            <fieldset class="form-group">
                <form:label path="desc">Description</form:label>
                <form:input path="desc" type = "text" class="form-control" required="required"/>
                <form:errors path="desc" cssClass="text-warning"/>
            </fieldset>
             <fieldset class="form-group">
                 <form:label path="targetDate">Target Date</form:label>
                 <form:input path="targetDate" type = "text" class="form-control" required="required"/>
                 <form:errors path="targetDate" cssClass="text-warning"/>
             </fieldset>
             <button type="submit" class="btn btn-success">Add</button>
        </form:form>
    </div>

    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

    <script>
        $('#targetDate').datepicker({
            format : 'dd/mm/yyyy'
        });
    </script>
</body>

</html>