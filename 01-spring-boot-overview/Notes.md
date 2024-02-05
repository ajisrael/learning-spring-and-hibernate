# Notes

## Spring Boot Dev Tools
To enable automatic builds on save for project navigate to the following:
```
Preferences -> Build, Execution, Deployment -> Compiler 
```
Then select the box next to `Build project automatically` and click `Apply`

Next navigate to the following:
```
Preferences -> Advandced Settings
```
Then select the box next to `Allow auto-make to start...` and click `Apply` then `OK`

## Running from Command Line
To run the application from command line we need to package then run it.
This is really simple with Maven using the maven wrapper.

Package:
```bash
./mvnw package
```

You should see an output indicating the path to the `.jar` file generated.
Using that path you can run the application with the following command:
```bash
java -jar <PATH_TO_JAR>
```

While the aforementioned method works, you can also run the following command to use the `spring-boot-maven-plugin`
```bash
./mvnw spring-boot:run
```

Additionally, if you have Maven installed on your machine you can replace `./mvnw` with `mvn`.

As a final note, you need to make sure you run these commands from the project's root directory.