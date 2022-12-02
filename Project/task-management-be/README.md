# STARTER GUIDE TO GIT
* To Download Git https://git-scm.com/downloads 
* Download Git under recommended settings.
* Open Git as a Administrator
## CONFIGURE GIT
` ` `    git config --global user.name "[UserName]" ` ` `
` ` ` git config --global user.email "[Email]" ` ` `

* Add following command in git bash terminal to Clone repo
    ` ` ` git clone [repo link]
    ` ` `
> Now it may ask for git credentials, for Acess Token follow the below steps otherwise skip it to  
* Now git will ask for credentials Username and Password.
    >For that gitLab --> Settings --> Access Token --> Enter [ProjectName] and grant all permissions by checking all the checkboxes.
* It will generate the Access Token, Save that token in some txt file.
* Fill that [projectName] which we created before in [Username] and [token] in [password] in git credential dialogue box.
* Repo will be cloned in the folder where you started the Git bash.
> For studying Git commands refer the provided link https://www.freecodecamp.org/news/git-cheat-sheet/
## SPRING BOOT
### Project Intilization (Maven)
- To initialize Spring boot project got to link https://start.spring.io/ 
- Give suitable name for your project 
- Click on [Generate]
- Project will be downloaded in your directory
- Open that project through choice of your IDE Intellij or Eclipse 
> Intellije : https://www.jetbrains.com/idea/download/#section=windows
* Maven will install some dependencies according to the need.
* Add your runtime configurations.
* Main will be placed in 
        src 
------+main
------------+java
-----------------+com.example.[SpringProjectName]
----------------------+[SpringProjectName]Application.java
--------------------------+[SpringProjectName]Application (Main class)

* Before running the application you have to add 2 Things 
1) Open Target --> classes --> com --> application.properties
` ` `
    server.port = 0
` ` `
    > Zero port means it server will use any available port.
2) Add following dependencies in pom.xml 
    ` ` `
    <dependency> 
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
    ` ` `
    > It will enable the spring application to run its server (Tomcat).
* On running this file after setting configuration. Spring will launch its server. If server is launched successfully it will show following text in console.
 > INFO 13996 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 18.0.1.1 on ABDURREHMAN with PID 13996 (path)
>INFO 13996 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to 1 default profile: "default
>INFO 13996 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 0 (http)
>INFO 13996 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
>INFO 13996 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.64]
>INFO 13996 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
>INFO 13996 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2276 ms
>INFO 13996 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 54283 (http) with context path ''
>INFO 13996 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 4.586 seconds (JVM running for 5.583)

If this shows on console then it means tomcat server has been initiated successfully.


