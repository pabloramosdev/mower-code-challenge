# Getting Started

### MOWERS CHALLENGE

Application to move mowers in a grid using a shell.

### How to run project:

    ./mvnw spring-boot:run
    
### Shell interaction

The "start" command read the file specified and moves the mowers through the grid.

    shell> start --f /path/to/file

Can be used the file in src/test/resources/mowers.txt

### Tech stack
    Kotlin
    Spring Boot
    Maven
    Junit5/Mockito
    Spring Shell

### TODO

    Add log traces
    Enhance Exception console messages
   

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/#build-image)
* [Spring Shell](https://spring.io/projects/spring-shell)
