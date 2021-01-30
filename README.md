# FinServe
A Java based spring application to assist in financial services.

## Pre-requisites
- Java
- Maven
- Docker

## Deployment with Docker
```
mvn package
docker build -t finserv .
docker run -dp 8080:8080 finserv
```

Package file is created in `war` format, which can be used independently with mostly all Java Server such as Tomcat, Jboss and many more.


### Work In Progress
0. ~~Add Docker Support~~
1. ~~Add H2 DataStore~~
2. ~~Handle Exceptions~~
3. ~~Add Entities~~
4. Add Business Logic
5. Make forward compatible with Spring Boots
6. Make forward compatible with Google Guice
7. Add ELK
  
