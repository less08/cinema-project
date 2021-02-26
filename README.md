# Filarmonic app

Rest Api for booking tickets for concerts. The app is built via SpringFramework and SOLID principles.

### App architecture description
N-tier architecture with next layer separation: DB, DAO, Service, Controller.

### Technology stack:
 - Spring (Spring MVC, Spring Security)
 - Hibernate
 - MySQL
 - TomCat
 - Java
 - Maven
 - Maven checkstyle plugin

### App running guideline
1. Download and install the JDK

2. Download and install Apache Tomcat

3. Download and install MySQL. Setup connection properties in 

**db.properties** file
	
	user: "your username"
	password: "your password"
	db.url=jdbc:mysql://localhost/*your_db_name*?serverTimezone=EET

4. Run a project

### App usage guideline
Use endpoints described bellow in API Documentation section. Query params, request body and response examples for each endpoint described in separated files which are linked in the documentation.
For using endpoint with User role you should register first then login.
For using endpoint with Admin role you should login as admin first.
	
	username: admin
	password: admin
	
#### Login endpoint	
	
* Login `POST /login`

**Content example**

Form data:

    username=admin&password=admin

## API Documentation

### Open Endpoints

Open endpoints require no Authentication.

* [Register](doc/register.md) : `POST /register`

### Endpoints that require Authentication

Closed endpoints require Authorization (How to login described in  App usage guideline).

#### Endpoins for any role (user or admin)
* [Get list of all stages](doc/stages/get.md) : `GET /stages`
* [Get list of all concerts](doc/concerts/get.md) : `GET /concerts`
* [Get list of all available concerts sessions](doc/sessions/get.md) : `GET /concert-session/available`


 #### Endpoints for admin
* [Add  new stage](doc/stages/post.md) : `POST /stages`
* [Add new concert](doc/concerts/post.md) : `POST /concerts`
* [Add new concert session](doc/sessions/post.md) : `POST /concert-sessions`
* [Update concert session](doc/sessions/put.md) : `PUT /concert-sesions/{id}`
* [Delete concert session](doc/sessions/delete.md) : `DELETE /concert-sesions/{id}`
* [Get user with email](doc/users/get.md) : `GET /users/by-email`

### Endpoints for user
* [Get orders](doc/order/get.md) : `GET /orders`
* [Confirm order](doc/order/post.md) : `POST /orders/complete`
* [Add concert session to cart](doc/cart/post.md) : `POST /shopping-carts`
* [Get all concert tickets in user's cart](doc/cart/get.md) : `GET/shopping-carts/by-user`
