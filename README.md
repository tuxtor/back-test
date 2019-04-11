## Roberto Eduardo Caseros Reynoso

# Nabenik's Java EE basic test

Hi and welcome to this test. As many technical interviews, main test objective is to determine your actual EE skill, being:

- General Java knowledge
- General toolkits, SDK's and other usages
- Java EE general skills

To complete this test, please create a fork of this repository, commit the solutions/answers to YOUR copy and finally do a pull request to the original repo.

The document is structured using [GitHub Markdown Flavor](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet#code).

## General questions

1. How should you answer these questions?

> Like this

Or maybe with code

```kotlin
fun hello() = "world"
```

2. Please enumerate al least 3 Java EE APIs being used at this project, also define it's main objective
```kotlin
Arquillian: this api is used to test the project, specifically Movie class; for this class Arquillian was used for a unit test, in this test was created a object Movie and inserted into to MovieRepository, i suppose MovieRepository generate a Id for each movie inserted.
Persistance: this is used for do a mapping object-relational. In the Project this api is usen for do a mapping of a object Actor whith a entity relational named Actor, the same form happend with object Movie.
Beans: api used for encapasulate objects and use them later, in this project the api encapsulate the object Movie and Actor implementing Serializable class and mapping each object with Persistance api.
```
3. Which of the following is not an application server?
```kotlin
Tomcat is a servlet’s container
```


4. This project defines two main profiles. Which one will be the default if -P argument is not used on Maven?
```kotlin
The profile with id: arquillian-payara-embedded
```

5. Could you guess if this project will be supported on many application servers? Which ones? Why is this possible?
```
Yes this application can be supported for all de application servers that can deploy JavaEE, for example Glasfish, Payara, Oracle Web Logic, etc.
```
6. If no database is configured? Will you be able to run this project? Why?
```
The project be able run without database configuration because this configuration is contained in Persistence.xml, this file is not a compilated file and I can configurate the database’s path once the project has ben executed.
```
## Development tasks

1. (easy) Please include a screenshot of this project building on a regular CLI
![](Dev1.png?raw=true)
2. (easy) Please include a screenshot of this project running on an IDE of your choice
```
Ide used: Netbeans 8.0.2
```
![](Dev2.png?raw=true)

3. (medium) Please deploy this project to a compatible application server, later include the screenshot of the list Movies endpoint
```
Application Server used: Glasfish 4.1
```
![](Dev3.png?raw=true)

3. (medium) Include a screenshot of each of the endpoint operations, if needed please also check/fix the code
![](Dev4a.png?raw=true)
![](Dev4b.png?raw=true)
![](Dev4c.png?raw=true)
![](Dev4d.png?raw=true)

4. (medium) Add support to Bean Validation for the entity Movie and validate nulls on REST layer
```
Validations of nulls in MovieController.java
```
5. (hard) Please identify the Integration Testing for `MovieRepository`, after that implement each of the non-included CRUD methods

6. (hard) This project includes support for [Oracle Weblogic](https://www.oracle.com/technetwork/middleware/weblogic/downloads/wls-main-097127.html), please include a screenshot with your modifications being tested with Weblogic 