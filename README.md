Coverage: 91.5%
# Cloud Native Hobby Project
&nbsp;&nbsp;&nbsp; This was a one week project, with the objective to create a CRUD application with the utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training.

## Overview of Project
### Chosen Project
&nbsp;&nbsp;&nbsp;I decided to create my project around storing data for books. This is because this is potentially useful information and it's got lots of areas to apply expansion into. This might be storing user opinions on books, and providing suggestions in the future.
### Jira
&nbsp;&nbsp;&nbsp;The first order of the week was to manage time effectively and make sure all tasks were completed during the week. I did this using [Jira](https://www.atlassian.com/software/jira). Within Jira I created epics and within those I created user stories and tasks. Below is an example story.

![Jira MoSCoW](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/jiraUserStory.png)

&nbsp;&nbsp;&nbsp;I created user stories using the following template 'As a ..., I want ..., So that ...' and then provided them with acceptance criteria in the form of 'Given, When, Then' so as to explain when the user story is considered completed.  
&nbsp;&nbsp;&nbsp;I assigned this user story a relative story point estimate of '10' as I thought the task was going to be fairly straightforward. I also assigned it a prioritisation of Highest or Must Have. My priorities were based on the MoSCoW methodology of 'Must have, Should have, Could have, Would have'. This example was Must Have because it was required by the Minimum Viable Product(MVP).  

&nbsp;&nbsp;&nbsp;After producing my backlog on Jira, I then created a sprint and moved all the backlog into it. The reason for only one sprint rather than multiple sprints is because the timescale of the project is only one week. 
![Sprint on jira](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/jiraSprint.png)

### GitHub
&nbsp;&nbsp;&nbsp; After finishing the Jira board. The next task was to set up my Version Control System. I used GitHub to do this using a Feature-Branch model. The below image is a few branches that were used.  
![Branches on source control](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/branches.png)

&nbsp;&nbsp;&nbsp;Once the feature-branch I was on I would push it to GitHub and then create a pull request on GitHub to merge with dev. Once this was complete then a pull down from GitHub to dev would be required to get the branch on my local machine up to date.  
![Pull Request](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/pullRequest.png)

### Documentation
&nbsp;&nbsp;&nbsp;Documentation needed for the project included a risk assessment and accompanying matrix, both of which are in the root. For the matrix I decided to do it in the form of likelihood by Impact level. This was important as it would inform me how to act if certain foreseen issues were to occur.

&nbsp;&nbsp;&nbsp;A UML of the application code was required. The attached UML in the root folder shows the layout of the classes and how they interact with each other. I generated this using [plantUML](https://plantuml.com/)

&nbsp;&nbsp;&nbsp;There was also a requirement to generate a README, and a .gitignore. The .gitignore stops unnecessary files being pushed to GitHub and you're reading the README now.

## Backend
&nbsp;&nbsp;&nbsp;For the backend the application was coded in Java using Eclipse with spring boot and maven. The required dependencies included springframework, h2database and mysql. The full list of dependencies is in the `pom.xml`

### Database
&nbsp;&nbsp;&nbsp;The database contains a single table, with columns id, title, author, genre and publication_year. The id is auto incremented and is the primary key, while the other entries are user input and hold useful information.  
![database ERD](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/database.png)

### Coding and class layout
&nbsp;&nbsp;&nbsp;As seen in my UML I created four classes to achieve the desired outcome. Book the entity class. BookController to handle incoming API request. BookService to provide the business logic for the requests. And BookRepo to talk to the database. As well as the usual read by one requests (by column titles). I also created a read random entry in the database. This is so that if a user needs inspiration about what to search then this might provide them with some. Below is the code needed in the repo to achieve this.  
![Repo Random](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/repoRandom.png)

### Testing
&nbsp;&nbsp;&nbsp;For testing we had to write unit tests, the aim was to reach a coverage of 80%. My coverage got to 91.5%.  
![91.5% Test Coverage](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/testingCoverage.png)

&nbsp;&nbsp;&nbsp;I did this using integration tests with MockMvc RequestBuilders and ResultMatchers. Below is an example test.  
![Integration test](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/integrationTestCreate.png)

&nbsp;&nbsp;&nbsp;And when we came to build all tests written were successful.  
![Test success](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/testSuccessInBuild.png)

## Frontend
&nbsp;&nbsp;&nbsp;The Frontend webpage was coded in HTML, CSS and JavaScript using Visual Studio Code. Bootstrap was used to help provide some extra CSS. And Axios was used to make requests easier to handle. I wanted to make the interface easy to use and simple to understand while only showing the user what was asked for. I did this by providing a customisable form depending on what selection the user makes. In which elements are shown and hidden from the user depending on the selection. Below is the first selection.  
![First Selection Page](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/firstSelection.png)

And then after selecting the 'Add a Book' (Create)  
![Create Form](https://github.com/G-J-Evans/Clound-Native-Hobby-Project/blob/main/documentation/createForm.png)

I'll let you explore the other functionalities. Hopefully it's very self explanatory.

## Getting Started

These instructions will get a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites
An internet search of 'How to install ...(Thing to be installed) for ...(OS your machine runs on)' will return detailed instructions and probably a video of how to install the below items.

- Either a ['Java Development Kit'(JDK) or a 'Java Runtime Enviroment'(JRE)](https://www.oracle.com/java/technologies/downloads/)   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A JDK contains a JRE. JDK is helpful if you wish to look at the code, add to it or rerun tests.
- [MySQL Workbench](https://www.mysql.com/products/workbench/)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Workbench or an alternative are required to create the initial database which will hold the data. 
- [Visual Studio Code](https://code.visualstudio.com/)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Or alternative to open the webpage on a live server.
### Installing
-Download the file `cloudnative-0.0.1.jar`  from the root.  
-Open a terminal from the folder containing `cloudnative-0.0.1.jar`.  
-Inside the terminal you'll need to write the line.  
`java -jar cloudnative-0.0.1.jar`.  
-Press return(enter) and the application will run.  

-Download the folder `frontend`from the root.  
-Open this folder in Visual Studio Code.  
-Open file index.html.  
-Right click on file and select 'open with live server' or press ALT+L+O.  

The webpage is now up and running and the application is ready to be interacted with. I have provided a MySQL schema to quickly populate the database inside of `quickDataPopulation.sql`. It also wipes the current entries so be careful!

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Framework and bean handler
* [Maven](https://maven.apache.org/) - Dependency Management and Build Tool
* [Eclipse](https://www.eclipse.org/) - Backend IDE
* [Visual Studio Code](https://code.visualstudio.com/) Frontend IDE
* [Jira](https://www.atlassian.com/software/jira) - Project Management
* [gitHub](https://github.com/) - Version Control 
* [MySQL Workbench](https://www.mysql.com/products/workbench/) - MySQL management and data verification(Human).

## Authors

* **Gregory Evans** -  [G-J-Evans](https://github.com/G-J-Evans)
