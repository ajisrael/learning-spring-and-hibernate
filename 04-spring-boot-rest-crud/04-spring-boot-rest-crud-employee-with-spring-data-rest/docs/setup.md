# Setup
This document provides directions for how this project was setup

## Project Init
Project was initialized from spring intitializr. Packages can be seen in `pom.xml`

## Auto build and compile
Open preferences -> Build, Execution, Deployment -> Compiler -> Select "Build project automatically" -> Click Apply

Then at the top level of preferences go to Advanced Settings and verify that "Allow auto-make to start..." is selected then click OK

## Database setup
The following commands were used to configure the table in the DB running in docker:

```sql
CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');

```

Database config/integration can be seen in `application.properties`


## Spring Data Rest 

### Paths
Without changing the `base-path` the url is at localhost:8080/employees

Use the `spring.data.rest.base-path` property in `application.properties` to specify a base path

Replace `@Repository` with the below line if you want to change the name of the resource in the rest endpoint path in the repository class.
```java
@RepositoryRestResource(path="members")
```

### Pagination
By default, Spring Data Rest returns the first 20 elements (page size = 20)

You can navigate to different pages of data using the query params in the following requests as an example:
```
http://localhost:8080/employees?page=0
http://localhost:8080/employees?page=1
...
```

Use the `spring.data.rest.default-page-size` to set the default size of pages

Use the `spring.data.rest.max-page-size` to set the maximum size of pages

