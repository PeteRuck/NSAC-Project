Testing Coverage: src/main/java: 96.6% (Overall: 99.1%)

# BAE15SPRING-NSACP1

The concept was to design an online Caniformia CyberPark with the capability to manipluate the database, i.e. Add animals, edit animals, delete animals, and have a general list available of the animals already in the database. subsequant pages will have pictures and information sheets on each of the animals stored. Caniformia is a suborder within the order Carnivora consisting of "dog-like" carnivorans. They include dogs (wolves, foxes, etc.), bears, raccoons, mustelids (ferrets, badgers, etc.), and Pinnipedia (seals, walruses and sea lions). 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Git bash on local machine alongside a github account - https://gitforwindows.org
- Java and Eclipse IDE 2022‑09 - https://www.eclipse.org/downloads
- MySQL - https://dev.mysql.com/downloads/workbench

### Installing

1. Fork this repository. `top right of screen`
2. Go into your forked repository and `copy the url` for it.
3. Create a folder on your desktop and name it *NSACProject*.
4. In the *NSACProject* folder open git bash.
5. Do the following command: git clone `paste url link`.
6. Press enter.

It should now be cloned into your *NSACProject* folder

1. Open up eclipse
2. Go to *File -> Open File -> Desktop -> NSACProject*
3. Open the *NSACProject* on your Desktop, 
4. right click and `open in a terminal`
5. Enter the command: `java –jar BAE15Spring-NSACP1-0.0.1-SNAPSHOT.jar`
6. In your browser now navigate to `http://localhost:8080/index.html`

* [Screenshot](https://github.com/PeteRuck/NSAC-Project/blob/main/Documentation/SiteScreenshot.pdf)

## Running the tests

Initial test are ran through Postman (https://www.postman.com).
Postman is an API platform for building and using APIs, it simplifies each step of the API lifecycle and using the same backend coding that has just been written into your API, allows you to test the code to check whether the information can pass to your MySQL database.

### Unit Tests 

Unit testing is a software testing method by which small testable parts of an application, called units, are individually and independently tested, together with associated control data, usage procedures, and operating procedures, to determine whether they are fit for use.

The main objective of unit testing is to isolate written code to test and determine if it works as intended, if done correctly, it can help detect early flaws in code which may be more difficult to find in later testing stages.

1. Navigate to the `AnimalControllerUnitTest.java` file.
2. Right click on the file and move down to `Run As`.
3. Slide across to `1 JUnit Test` then left click.
(As per visulisation in .pdf)

* [Unit tests](https://github.com/PeteRuck/NSAC-Project/blob/main/Documentation/AnimalControllerUnitTest.pdf)

### Integration Tests

This is the phase in software testing in which individual software modules are combined and tested as a group. Integration testing is conducted to evaluate the compliance of a system or component with specified functional requirements.

The purpose of integration testing is to expose faults in the interaction between integrated units. Once all the modules have been unit tested, integration testing is performed.

1. Navigate to the `AnimalControllerIntegrationTest.java` file.
2. Right click on the file and move down to `Run As`.
3. Slide across to `1 JUnit Test` then left click.
(As per visulisation in .pdf)

* [Integration test](https://github.com/PeteRuck/NSAC-Project/blob/main/Documentation/AnimalControllerIntegrationTest.pdf)

## Swagger API Endpoints

* [Swagger](https://github.com/PeteRuck/NSAC-Project/blob/main/Documentation/Swagger_API.pdf)

## Project Management Board

* [Jira](https://pruck.atlassian.net/jira/software/projects/NP1/boards/2/roadmap) 

## Built With

* [Eclipse](https://www.eclipse.org/ide/) - Java Integrated Development Environment (IDE)

    - which incorporates 

* [Maven](https://maven.apache.org/) - Dependency Management

    - Using 

* [Spring Boot App](https://spring.io/projects/spring-boot) - As the Platform

## Authors

* **Pete Ruck** - *Initial work* - [PeteRuck](https://github.com/peteruck)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments/References

* https://www.google.com

* My Inspiration for this came from trawling through Wikipedia for canidae information, and wanting an easier way to access it.
