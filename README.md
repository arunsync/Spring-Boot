# Spring-Boot



Create new spring boot project. Following steps should be followed

A. Step-1

    1. STS
    2. File -> New -> Spring Starter Project
    3. Provide Group Id and Artifact Id, name of the project, packageing is Jar -> Next
    4. Select 1. Apache Derby(In Memory DB) 2. JPA(Spring Data JPA) 3. Web, dependencies
    5. Finish
    
B. Step-2

    1. Go to Spring Initiazr using "https://start.spring.io/"
    2. Provide Group Id, Artifact Id
    3. Select dependencies, Web, JPA, Apache Derby
    4. Generate Project - click the button
    5. Zip file will be downloaded
    6. Extract and import in to STS
    7. Done
        
    
    Bullet Points
    =============
     1. By default Spring boot has embedded web servers(Tomcat, Jetty, Undertow..). Tomcat is by default and it is part of the below        dependency
          		<dependency>
			     <groupId>org.springframework.boot</groupId>
			     <artifactId>spring-boot-starter-web</artifactId>
		      	</dependency>
     
     2. If we want to use Jetty(Inbuid) as a web server, here are the changes to be done in pom.xml
            <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
                <exclusions>
                  <!-- Exclude the Tomcat dependency -->
                  <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                  </exclusion>
                </exclusions>
            </dependency>
            <!-- Use Jetty instead -->
            <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-jetty</artifactId>
            </dependency>
     
     3. Deploying it to external Tomcat/JBoss servers
     		https://www.youtube.com/watch?v=92ceKwUZoA0
     
     4. Use the below link to configure other web servers:
          https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/html/howto-embedded-web-servers.html
          
     5. Website Links
        http://pretius.com/deploying-multiple-spring-boot-applications-to-single-application-server/
        https://stackoverflow.com/questions/34506712/how-to-deploy-spring-boot-web-application-on-tomcat-server
     
     6. Changing server default port
     	https://howtodoinjava.com/spring-boot/change-server-default-port/
        
      
