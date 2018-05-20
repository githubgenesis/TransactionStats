This is solution for given N26 java assignment challenge.

Prerequisite

Preinstall Java8 
Maven 3

How to build :
	1.	Using Command line
           clone or download the project from
           Go to project directory and run command “mvn clean install”
    2.  Using IntelliJ
           Go to the file menu
           Click open option and brows cloned project folder and select pom file.
           After that project open into IntelliJ

How to Run :
    1.  Using Command line
            After build run following “java -jar target/transaction-1.0-SNAPSHOT.jar”
    2.  Using IntelliJ
            After open project into IDE open class Application.java and run main method

How to Use :
 open “http://localhost:8080/swagger-ui.html#/”. So access all api using swagger. Apart from that also you can 
generate transaction using this shell script “transcation_gen.sh”. This shell script generate transaction every 5
seconds.

Note: Project build can take more than 60 second because in one test I am simulating 60 Second use case. For faster build use following command “mvn clean install -DskipTests”. 