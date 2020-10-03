# CAUTIONS

To test the performance of this project,

* for step 10 - 12:
  1. go /testAuto
    * The id and passwords are
      - in28minutes
      - dummy
  2. go /list-todos


# Step10: Create TodoController and list-todos view. Make TodoService a @Service

Implementation of simple TodoController which renders the list of list<todos>
for "in28Minutes" hardcoded only

# Step 11: Architecture of Web Applications

## Model 1

* from the Browser you **send data requests directly to a jsp**
* JSP handles a request and **redirect to next JSP**

### problems)

* JSP becomes huge
  - has view logic
  - controller logic
  - business logic
* application becomes unmaintainable

## Model 2

* From the browser, **requests go to the servlet**
* Servlet
  - talks to the business logic
  - finalizes the model
  - make model available to view
  - Then view gets rendered to the browser
* **Next request** from the browser would go to **another servlet**
  - we always send a request to a single controller
    * friend controller
  - ex) strut

# Step 12: Session vs Model vs Request - @SessionAttributes

* Scope of the request parameter is just that particular request
  - If you've entered {id}, {password} in **login page(view)**,
    it won't be succeeded at the **welcome page**.
  - i.e) They **won't be available in the subsequent requests**.

## Session

* Something you open when
  - you want to **store values across multiple requests**.
* Use **@SessionAttributes**
  - specify **name of the attribute** you want to store in the session.
  - to retrieve session attributes, use **model.get("$name of model put value")
* for the amount of variables stored inside the session is the burden of
server, you must be cautious with what to add as a session variable

* suggesition:
  - in the end, you will be needing a list of strings, that will be received inside
    session attributes tag, somewhere to be imported
    * ex) have a sessionLists.java, which holds session attributes string names.


# Step 13: Add new Todo

Q. Why can't you see **updated list-todos** when you've posted description
from **add-todo**?

  - It's because **list-todos** haven't been put as model yet
  - You're calling another **list-todos.jsp view** from **TodoController**
  - **Solution**
    * put model to use again.
      - Means you have to do the duplicate logic again.
    * instead, redirect to specific url.
      - i.e.) a view that has already taken the model put before
      - in this example, redirect to **"/list-todos"**
      - **How?**
         - return **"redirect:/list-todos"**
         instead of
         - return "list-todos" which is a name of view
         
# Step 14: Display Todos(list) in a table using JSTL tag

1. add jstl dependency into the maven(pom.xml)
    - \<dependency>\<groupId>javax.servlet\</groupId>\<artifactId>jstl\</artifactId>\</dependency>
    - Java Standard Tags Library
2. TODO
    - Basically, ${Todos} inside todo-list.jsp is hard to read
    - using **JSTL for Loop**
      * import the tag using <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      * prefix="c" part means, tags starting with c: means it belongs to JSTL.
    - We want to **repeat multitple \<trs>** for we can't know how many rows will come in
      * <c:forEach items="${name of items from model}" var="$name of variable you want to put"
      * ex) <c:forEach items="${todos}" var="todo"> == for (auto todo : todos)


# Step 15: Bootstrap for Page Formatting using webjars

## Bootstrap

* a **css framework**
* going to use webjars for bootstrap and jquery
* requires jquery
* To use bootstrap classes, you need **div**
  - ex) container, button, table


## webjars

* **To use js or css**, you typically store it inside the **resources** directory and import it into the jsp.
* a **client-side web libraries** packaged into JAR files.
* you can explicitly **manage web dependencies** in you applications.
* bootstrap, jquery, ..., those which are webjars are under "webjars/jquery(or bootstrap)/version/..."

## scripts

### The \<script> tag at the bottom is processed as follows

  1. html is requested through GET(ex. /list-todos)
  2. The response contains the **urls of css/js**.
      - I need these js and csses
  3. Browser goes and creates additional requests for those.
  