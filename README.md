This project implements the test suite of the OpenID organization (http://openid.net/) using the Java/JEE technology stack. 

# Prerequisites

- Java (1.8+)
- Maven (3.0.4+)
- Git (2.5.1+)
- Mongo (2.6.1+)
- Docker (18.0.0+)
- Docker Compose (1.18.0+)

# Setting up the project for development
Download or clone the project from github:

````
https://github.com/GluuFederation/oidctest-java.git   
````

Connect to the mongo shell and create a database with name OidcDB in mongodb. For example:

````
mongo
> use OidcDB
````

From inside the same mongo shell session, load and run ALL the scripts into the /db folder. For example:

````
load("/home/vnik/Projects/Gluu/oidctest-java/db/init_abbrs_mongo")
````

Open the application.properties file to configure the application:

````
sudo nano /src/main/resources/application.properties

````

Set the following properties (if needed) and then save your changes:

````
server.port=8081

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
````

# Running the Web app

Move to the root folder of the project and execute:

````
mvn clean install -DskipTests
mvn spring-boot:run
````

# Using the application

Open your browser and hit:

````
http://localhost:8081
````

If everything is correct you will see a list of certification profiles on your screen.

