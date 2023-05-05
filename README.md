# Spring Todo App Tutorial

In this project, I developed a Todo app using Spring framework. I learned various aspects of Spring, such as working with MVC model annotations, passing data between JSP and web controllers, logging, and more.

## What I Learned

* How to work with the different annotations in the MVC model
* How to pass data between JSP and web controllers and to redirect to JSP using Spring
* How to use Logging with Spring
* How to use @SessionAttribute with Models to pass information between controllers
* How to add Bootstrap to a Spring project to format JSP pages
* How to add validations and implement them on my models
* How to add and configure Spring Security
* How to switch between H2 and MySQL databases

## Instructions to Run the App

### Prerequisites

1. Install [Docker](https://www.docker.com/products/docker-desktop)
2. Install [Java 20](https://www.oracle.com/java/technologies/javase-jdk20-downloads.html)
3. Install [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

### Steps

1. Run MySQL database using Docker with the following command:
```
docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle
```


2. Open the project in IntelliJ IDEA and ensure Java 20 is configured as the project SDK.

3. Run the application using the built-in IntelliJ IDEA tools.

4. Access the Todo app by navigating to `http://localhost:8080` in your web browser.

5. Use the following credentials to log in:

* user: `guest`, password: `dummy`
* user: `guest2`, password: `dummydummy`

6. Click manage your todos

7. Click Add-todo, the date is formatted yyy-mm-dd
