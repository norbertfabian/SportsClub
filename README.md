# PA165 - SportsClub
Team project for seminar PA165 at FI MUNI, Brno. For documentation, see below.

[1. Usage](#usage)  
[2. Description](#description)  
*[2.1 Project brief](#project-brief)*   
*[2.2 Class diagram](#class-diagram)*  
*[2.3 Use case diagram](#use-case-diagram)*    
[3. REST API](#rest-api)  
[4. Requirements](#requirements)  
*[4.1 1st Milestone Project Requirements](#milestone-1)*  
*[4.2 2nd Milestone Project Requirements](#milestone-2)*  
*[4.3 3d Milestone Project Requirements](#milestone-3)*  
*[4.4 Final Project Requirements](#final)*

## <a name="usage"></a>1. Usage:
Using command line, execute following commands to run the app.

```
git clone https://github.com/norbertfabian/SportsClub.git
cd SportsClub
mvn clean install && cd sports-club-mvc && mvn tomcat7:run
```

After the server was started and is running, open the app in browser at URL:
```
http://SERVER_ADDRESS/pa165/
```
For example, in this case, that would be:
```
http://localhost:8080/pa165/
```
--------------------------------

## <a name="description"></a>2. Description

Project Topic: __Sports Club__  
Course: __PA165 Vývoj programových systémů v jazyce Java__  
Location: __Faculty of Informatics, Masaryk University, Brno__  

### <a name="project-brief"></a>2.1 Project brief
Think of a sports club for a team sport (football, ice hockey etc.). 
Create a system managing teams and players. Each team is defined by its 
name and an age group (men, juniors etc.) given by an interval between 
two years of birth. Each player is described by his first name, last name, 
height, weight and date of birth. Each team has a roster of players listing 
their jersey numbers on the team. It is important that each player's age 
group matches the age group of the team, but a player is allowed to be on 
the roster of a team one level above (i.e. a younger player can be on the 
team of a higher age group). That implies a player can be listed on multiple team rosters.

### <a name="class-diagram"></a>2.2 Class diagram
<img src="https://github.com/norbertfabian/SportsClub/blob/master/wiki/Class_Diagram.png" alt="Class diagram SportsClub" width="600" >

### 2.3 <a name="use-case-diagram"></a>Use case diagram
<img src="https://www.lucidchart.com/publicSegments/view/1948accc-67ca-4532-af76-4deec784aaeb/image.jpeg" alt="Class diagram SportsClub" width="600" >

## 3. <a name="rest-api"></a>REST API

This project implements REST API for entity __Team__. Hereby, its useage is described.
Location:
```
http://SERVER_ADDRESS/pa165/rest/team/
```

| Title        | URL           | Method |  Params  | Data params (JSON) |
| ------------- |:-------------:| :-----:|:-----:| :-----:|
| Get all teams  | `/` | GET   |  |    |
| Get team      | `/{id}` |   GET   |  Team ID  |      |
| Create new team | `/` |  POST |    |  { "id": ID_NUMBER, "name": "TEAM_NAME"}  |
| Update team | `/{id}` |  PUT |  Team ID  |  |
| Create new team | `/{id}` |  DELETE |  Team ID  |   |

###Example usage:
Using external program, e.g. `curl`, you can test the API. Command
```
curl -i http://localhost:8080/pa165/rest/team/
```
will return JSON containing all the data about teams in application.

## 4. <a name="requirements"></a>Requirements

### 4.1 <a name="milestone-1"></a>1st Milestone Project Requirements

1st milestone project done: Mon 31.10. 23:59  
1st milestone evaluation submitted: Thur 3. 11. 15:59

#### 4.1.1 Project Requirements:

- create a project in a Github repository that is publicly accessible (for read) choose a short and descriptive name. Create some project wiki to publish other information for your project.
- on the project wiki there will be a project description, a use case diagram and a class diagram for entity classes. There will be at least two user roles in the use case diagram. Associations between entities will be present in the class diagram.
- create 4 entity classes for your project.
- create a DAO layer interface (with proper javadoc).
- create the JPA implementation of the DAO classes (CRUD operations are enough for the first checkpoint).
- create unit tests for DAO classes (use in-memory database).
- every team member should work with different entities on different parts of the project (e.g. member 1 will create implementation of DAO for entity A, but member 2 will create unit test for entity A). In every class there will  be javadoc @author with the name of the class author. Also you must commit into Git only the changes that you made yourself. If you commit on behalf of somebody else this will not be regarded as his work!
- the project will be built using maven, and make sure you have all dependencies correctly configured, so it is possible to build it using just the command line.

#### 4.1.2 Evaluation Checklist:

You can assign maximum 10 points to the project you are reviewing.
* -3 points if it is not possible to compile the project using “mvn clean install”. You must either make this work or ask the team to fix this ASAP because it’s hard to check the code without this.
* -1 point for each minor occurrence of a team member not contributing enough.
* -1 points for incorrectly implementing equals/hash code.
* -1 points for every minor occurrence of missing methods/tests (e.g. missing important method on a DAO object or a missing test for that method).
* If a team member was not contributing at all, or very little, you should explicitly say this in your evaluation report. Tutor will follow up on this information.

Note: 
From this milestone your tutor will also assign you maximum 5 points based on the quality of the review that was submitted.

### 4.2 <a name="milestone-2"></a>2nd Milestone Project Requirements

2nd milestone project done: Fri 25.11.2016 23:59  
2nd milestone evaluation submitted: Tue 29.11.2016 15:59

#### 4.2.1 Project Requirements:

* Implement Facade layer interfaces and implementations.
    * Everything that should happen in the system must be available through these interfaces (create entities, deleting them etc);
    * You must have at least 2 non-trivial business functions on Service Layer (the example project contains several of them). Service layer is not always just a place to delegate to DAO;
*Other points about the Facade and Service layers:
    * All the classes must be wired via dependency injection. Your service objects should obtain an instance of the EntityManager that way;
    * All the facade interfaces must not reference entities, but Transfer Objects only;
    * All service interfaces must reference only entities, not Data Transfer Objects;
    * You can use Dozer framework to map entity instances to transfer objects. The mapping may be done on Facade Layer;
    * Facade layer is used to drive transactions;
* Change layout of your project to Multimodule Maven project (tutorial here http://maven.apache.org/guides/getting-started/index.html) Your project should have 3 separate modules:
    * DAO layer
    * Service Layer and Facade Layer implementation
    * API layer - just DTOs and facade interfaces!
* Facade layer will use Service layer and Service layer will use DAO layer;
* Make sure that DataAccessException or its subclass is thrown in case of any exception on a the DAO layer;
* Implement simple unit tests for facade layer. Just one simple test per method is enough. This is mainly so that it’s easy to verify the Facade layer works;
* There must be extensive unit tests for the service layer (particularly for your 2 business functions) and all the tests of service layer must use Mock DAO objects;

#### 4.2.2 Evaluation Checklist:

* Maximum number of points for this milestone is 10 points;
* -2 points if it is not possible to compile the project and run tests using “mvn clean install”;
* -2 points if there are test failures;
* minimally -1 point for each of the unmet project requirements;
* -1 point for each occurrence of a team member not contributing enough;
* If a team member was not contributing at all, or very little, you should explicitly say this in your evaluation report. Tutor will follow up on this information;


### 4.3 <a name="milestone-3"></a>3d Milestone Project Requirements

3d milestone project done: Fri 16.12.2016 23:59  
3d milestone evaluation submitted: Tue 20.12.2016 23:59

#### 4.3.1 Project Requirements:

* User interface
    * To start the web application you have to configure maven plugin (tomcat7 or jetty). It is very important that it’s super easy to start the web application from command line. So for example using tomcat7 plugin, the following sequence of commands should start the web application: “mvn clean install &amp;&amp; cd web &amp;&amp; mvn tomcat7:run”     
    * The web application must be available on the following HTTP context http://localhost:8080/pa165     
    * Your application should use in-memory database. This means that after application restart (killing web container and starting it again with mvn tomcat7:run) the data may be reset.     
    * Implement the user interface using Spring MVC or Angular JS.&nbsp;     
    * The user interface should allow to carry out all business functions of your system.     
    * You should fill in all the necessary data automatically. So for example you can use Web Listener to load data during Web Application startup.     
    * Make sure there are validations implemented on user interface.     
    * Your user interface should use either Facade layer or REST layer to access the system. Do not directly access database and do not directly use Service layer.     
    * The web interface layer may reside in separate maven module (if this is helpful).     
    * Each member of the team must implement (mostly independently, without copy-pasting) part of user interface. Including controller and view.           
* REST layer
    * Your application should have a basic REST interface.     
    * At least one entity and operations on that entity must be exposed.     
    * This is mainly to demonstrate you can implement this, it’s not necessary to have all application functions accessible through this interface.     
    * The REST must be accessible at http://localhost:8080/pa165/rest     
    * it is not required to have the interface secured.     
    * You should include a README file with instructions how to test the REST interface (e.g. CURL commands for command line).           
* Security
    * There should be at least 2 roles in the system (e.g. Administrator, User). Each role should have some differences in user interface or in capabilities.     
    * There should be login form (not HTTP Basic)     
    * Registration is NOT required. You can prefill the users and their passwords in the database.     
    * Password should not be saved in the database in open form.
    
#### 4.3.2 Evaluation Checklist:
    
* The maximum number of points that you can assign for this milestone are 10 points
* Make sure to test the application mainly from the user perspective. Your evaluation report should list bugs in the system. This buglist will be used during final defense to make sure they are not present anymore
* -1 points if it is not possible to compile the project and run tests using “mvn clean install”
* -1 points if there are test failures
* minimally -1 point for each of the unmet project requirements
* -1 point for each occurrence of a team member not contributing enough
* If a team member was not contributing at all, or very little, you should explicitly say this in your evaluation report. Tutor will follow up on this information

### 4.4 <a name="final"></a>Final Project Requirements

Project done: __8. 1. 2017__  
In general, 72 hours before your defence, which takes place at __Wed 11. 1. 2017, 14:00 - 20:00 in room B130__.

*Available dates and times will be listed in Information System in “Packages and topics” application. Only the team leader will sign up for the defense in the IS and must sign up for the time slot where his/her assigned seminar tutor will be present. All team members must be present. Please come 15 minutes in advance and make sure you set up all HW and SW to be ready to present your application on time.*

#### 4.4.1 Requirements

* Fix all mistakes and bugs in your project that you ever had in your feedback
* This has to be completed 72 hours before start of your actual defense
* You will be asked to show some portions of your source code at the defense, be prepared to do so
* Refine the GUI so that the presented application looks good
* Dress code is casual


#### 4.4.2 Defence

* Prepare slides and present your project to the committee. Also prepare answers to possible questions that your seminar tutor sent you in advance (latest 24 hours before defense). 
* Your time limit for the defense is 15 minutes (no more, and this is strict), your presentation should be prepared for about 7 minutes and about 2 minutes should be live demo of your application.

__Presentation should cover following topics:__
* business logic (what is it for and what does it do)
* technologies used
* team cooperation (who did what)
* your feedback (what did you like and what not in PA165)
