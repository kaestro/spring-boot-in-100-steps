# CAUTIOUS

To test the performance of this project,

* for step 10 - 12:
  1. go /testAuto
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

* From the browser, **requests goes to the servlet**
* Servlet
  - talks to the business logic
  - finalize the model
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