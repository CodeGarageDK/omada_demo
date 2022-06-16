OMADA_DEMO

Preconditions:
    - Java JDK (eg. OpenJDK 17 - https://java.tutorials24x7.com/blog/how-to-install-openjdk-17-on-windows)
    - Maven (https://maven.apache.org/install.html)

Run - in terminal type, from root of project (Where your pom.xml is):

        mvn clean install

    OR

		mvn test
		
    OR

		mvn test -Dbrowser=edge -Dcucumber.filter.tags="@test1 or @test2" 