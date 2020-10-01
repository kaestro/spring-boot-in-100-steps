<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <%-- <title>response to list-todos</title> --%>
    <title>Todos for ${welcomeName}</title>
</head>

<body>
    You're inside list-todos
    <br>
    <%--
    Here are the list of ${welcomeName}'s todos:
    ${todos}
    </br>
    --%>
    <table>
        <caption>Your Todos are</caption>
        <thead>
            <tr>
                <th>Description</th>
                <th>Date</th>
                <th>Is it Done?</th>
            </tr>
        </thead>
        <tbody>
            JSTL For Loop
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.desc}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    </br>
    <a href="/add-todo">Add a Todo</a>
</body>
</html>