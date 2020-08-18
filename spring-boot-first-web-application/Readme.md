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
  * You need to add @ResponseBody on top of the method inside LoginController for the purpose


### How can you get the log message to be in a level of *debug* for certain package only?

- application.properties
- logging.level.org.springframework = DEBUG
  * only the logging level of the **package org.springframework** will be changed into DEBUG