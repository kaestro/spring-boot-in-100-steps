### What does @SpringBootApplication do?

- It initializes SpringFramework.
- SpringBoot is on top of SpringFramework.


## Uniqueness of Spring Boot

- Spring boot enables you to run an Java microservice with .jar not .war
- Does Auto Configuration

## Step02) Part1 First Spring MVC Controller, @ResponseBody, @Controller

### What does localhost:8080/login show when you type it in your web browser?

- the default error page provided by spring.
- Whitelabel error page.
- Any url you type (e.g. localhost:8080/dummy) does same.

### How can you make url localhost:8080/login to show up "Hello world"?

- You need to map the "/login" to a **java class**
- OR you can say, map it to (Login)Controller.

### What does spring-boot-devtools do?

- You don't need to **restart the application** in order to pick up the changes.
- e.g) If you've created a LoginController, the server will automatically restart.

### Why does localhost:8080/login doesn't show up after @RequestMapping("/login") has been added to the public method loginMessage?

- Because the **java class LoginController** has to be picked up by spring.
- type @Controller on top of LoginController.
  * It still doesn't work.
  * It's because this springframework is trying to return a **view named "Hello world"** not the String.
    - ex) "Hello World.jsp"
  * You need to add @ResponseBody on top of the method inside LoginController for the purpose


### How can you get the log message to be in a level of *debug* for certain package only?

- application.properties
- logging.level.org.springframework = DEBUG
  * only the logging level of the **package org.springframework** will be changed into DEBUG


### What does dispatcher servlet do?

- It does the mapping
    * In this case, it maps "/login", redirect request to log in loginController.

---

# Step 03 Demystifying some of the Spring Boot Magic

Todo
* Spring boot Starter Parent
* Spring boot Starter Web
* Embedded Tomcat
* DevTools

## Spring Boot Starter Parent

Spring Boot Starter Parent is a child of Spring Boot Dependencies.
You can look at the details(pom.xml) of them by using ctrl|cmd + l_click from
most of the IDE.

It's like classes extending another classes.
We can know from those pom.xml information about dependencies 
such as what spring version we're using, plugins such as maven,
java version, etc.

## Spring Boot Starter web

2 Things Spring Boot Starter web provides

1. All the dependencies that we need to run web applications.
    * spring MVC, spring core, etc.
    * spring-boot-starter-tomcat


## DevTools

The server automatically restarts whenever we change
something.

Keeps monitoring source codes for changes. As soon as something 
changes, reload the application.

Only dynamic parts are reloaded again and again. The static parts
are things like maven.

---

# Step04: Redirect to JSP

## What is the steps to redirecting to JSP?

1. create .jsp in some directory
2. set a view resolver
    * if it's in jsp, and you're using embedded tomcat,
    you'll need to add the tomcat-embed-jasper dependency
3. return the string of the name of the file in the controller, 
which is handling the request.

### What is the best place to create jsp?

- /src/main/webapp/WEB-INF/
    * ex) ~/src/main/webapp/WEB-INF/jsp/login.jsp

### How can dispatcher servlet know where the jsp is?

ex) return "login" should return login.jsp inside WEB-INF 
whenever the request was given.

* Need to set View Resolver.
    - "login" => src/main/webapp/.../jsp/login.jsp
    - set application.properties
        * spring.mvc.view.prefix = /WEB-INF/jsp/
        * spring.mvc.view.suffix = .jsp
    - error again if you're using the **embedded tomcat**
        * tomcat-embed-jasper
        * maven resolving shortcut in Intellij
            - ctrl + shift + O


---

# Step 05: Show userid and password on welcome page

1. What is GET parameter?
2. How to pass GET parameter to our jsp?
3. Problem with using GET

## How can you make method to attain GET parameter?

* Use @RequestParam
    - GET is nothing but a **request parameter**.
    - But how do we **pass it to jsp**?
        * pass data into a **Model**.
        * use **ModelMap** class.
            - ex) ModelMap model
            - model.put("modelName", name)
                * this makes variable name, and stores the value
                inside variable name in the method
        * In jsp, use the **Expression Language**
            - ex) Welcome ${modelName}

### Brief explanation of MVC pattern

* Controller
    - controls the entire flow.
    - Once it has some data, puts it into a model.
    - redirect model to the view
* View
    - uses the model to render the data onto screen
