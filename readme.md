# Mini Library Implementation in Java
This is the assignment that was handed out during atos recruitment. This
is not an optimal way of doing this but for the time alotted will hopefully
be sufficient.  

## Assumptions
1. Author and Client names are unique
2. Each book has one Author
3. An author can have many books
4. Clients can rent mulitiple books

## Requirements
1. Java1.8 - the project was written using java1.8.25
2. Apache maven 3.3.9
3. (optional) Use an IDE (I used netbeans), which simplifies the whole process


## Compilation
1. (Using Netbeans IDE)
   1. import project into workspace
   2. right-click the project "Library" in the projects menu section
   3. select "run maven" from options
   4. enter "clean compile package"
   5. Test results will be output to console frame of IDE
   6. right-click on "Library" project, select "run"(Select Main.main as main class for project)
2. (Using the command line)
   1. change directories to project Directory named "Library"
   2. run "mvn clean compile package", project should run tests and build
   3. run "java -cp target/Library-1.0-SNAPSHOT.jar com.otrebski.pawel.main.Main" to view test sessions results
## TODO
1. Refactor some code, find patterns etc
2. make sure that Database.java is put into new package, this is a controller, hence MVC like architecture

