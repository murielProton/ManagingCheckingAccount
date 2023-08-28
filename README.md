# ManagingCheckingAccount
Usefull tools to manage my checking accounts, and loose less time checking my banc statements. Using Java, HTML and SQL.
# Help and tutorials
For the framework Spring Boot, and to work with the design pattern MVC : https://www.baeldung.com/spring-boot-start

# Dificulties
## Defining a simple application.properties
*** Where is the file I need to update ? ***
src/main/resources
*** How do I create it from scratch ? ***
1. With VS Code, right click in main folder
2. Create a new folder
3. name it 'resources'
4. right click in resources folder
5. Create a new file
6. Name it 'application.properties', do not forget te extention .properties
7. add the line ```server.port=8081``` along with other properties
*** Error "'applciation.title' is an unknown prperty" ***
This means you nead to create META-INF/additional-spring-configuration-metadata.json. 
- Click on the lightbold, the propriety will be added to the JSON file.
Unfortunatly it has been uncorectly coded. You need to pars it. I got help frome : https://jsonlint.com/
*** How do I make sure tha my pom.wml is correcty encoded ? ***
1. mvn install
2. tab PROBLEMS in VS Code "Malformed POM"
3. Sync when ever my IDE deams it necessairy.
4. run my main methode.

While executing thoese 4 commands, a few errors will appear. Do not fret. Keep calm, try to mend them.
Version problems -> https://mvnrepository.com/artifact/
There is always the option to see the code of Baeldung -> https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-bootstrap

# Specificities about the POM file
- SNPASHOT in a version means it is currently under developpement.
- RELEASE in a version means it is a stable version.
- You can use a parent version for a POM, but it has to be on your computer. At my stage of experience, it seams to me better to developp it myself to gain som perspective.
- If a parent is added in the pom.xml, the child, will inherit of the ```<modelVersion>```, ```<artifactId>```, ```<groupId>```. 
- With or without a parent the .pom, will need a ```<name>```.
- ```<properties>``` stands for variable instanciation, that you access with ```${variable.name}```.
- Minimal requirement for a pom.xml is :
```<project> ```
```     <modelVersion></modelVersion>``` -> the last pom format version
```     <groupId></groupId>```-> unique, identifies one and only package java
```     <artifactId></artifactId>```-> the project name
```     <version></version>``` -> the project version, maven manages it. Add SNAPSHOT to define it's developpement state.
```</project> ```
- usefull tutorial : https://gayerie.dev/epsi-b3-javaee/javaee_web/maven.html
# How to run the App
## Launch the server for the WEB application : 
1. command line : ``` & 'C:\Program Files\Java\jdk-20\bin\java.exe' '@C:\Users\<path for this file>\AppData\Local\Temp\cp_cmmf7wa8zzm4xwcel20luttw0.argfile' 'com.example.Application'
configurer le pom mvn install -f "c:\<path for my workspace>\workspace\account_management\pom.xml" ```
2. URL in WEB browther : localhost:8081
## End the server process
CTRL + C

# Git
- in a java project, .gitignore must contain ```target/``` folder

# How to file different classes
src
    |--> main
        |--> java/ com/ example
                    |--> config
                    |--> controller //Mapping for the HTML files URL -> file name
                    |--> models
                        |--> dto (Data Transfer Objects) //This holds the DTO classes
                        |--> dao (Data Access Object) //This holds the Database classes
                        |--> pojo (plain old java object)
                        |--> entities //This holds Data model classes
                        |--> enums // This holds Data enum Type classes 
                    |--> exception
                    |--> repository //This holds the classes that get data from HTML
        |--> resources
            |--> META-INF
            |--> static
                |--> css
                |--> javascript
            |--> templates //This holds HTML files
    |--> test/ java/ com/ example


cf : https://stackoverflow.com/questions/59965015/springboot-where-to-put-internal-container-classes

# Enum types
http://localhost:8081/enummapping/get?typeOfPayement=TIP
