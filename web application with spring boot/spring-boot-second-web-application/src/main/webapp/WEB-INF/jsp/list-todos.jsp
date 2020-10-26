<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <%-- <title>response to list-todos</title> --%>
    <title>Todos for ${welcomeName}</title>
    <link href="webjars/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        You're inside list-todos
        <br>
        <%--
        Here are the list of ${welcomeName}'s todos:
        ${todos}
        </br>
        --%>
        <table class="table table-striped">
            <caption>Your Todos are</caption>
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Date</th>
                    <th>Is it Done?</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                JSTL For Loop
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.desc}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a type="button" class="btn btn-danger" href="/update-todo?id=${todo.id}">Update</td>
                        <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        </br>
        <div><a class="button" href="/add-todo">Add a Todo with request parameter</a></div>
        <div><a class="button" href="/add-todo-commandBean">Add a Todo with commandBean(validation enabled)</a></div>

        <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </div>
</body>
</html>