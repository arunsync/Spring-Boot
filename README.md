# Spring-Boot

Docs : https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/

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
        
Actuators
 	https://www.opencodez.com/java/spring-boot-actuators.htm
	https://spring.io/guides/gs/actuator-service/

Spring cloud
	http://frugalisminds.com/spring-cloud/

Is the Tomcat server embedded in Spring boot production ready?

	1. Embedding Tomcat rather than deploying war to a Tomcat server is really an operational choice. It's still a production grade HTTP server but with a different approach to maintenance and resource management
	2. Embedded tomcat/jetty/undertow etc is totally fine in production. Personally I prefer dealing with applications which run embedded application servers than those deployed into tomcat etc
	3. You always want to run the same software in dev/staging/prod, to reduce the risk of environment-specific deployment issues.
	4. The only thing that should change between environments is the configuration. This is called immutable infrastructure / deployment.
	5. There is effectively no difference between a standalone (i.e. installed by a package manager) Tomcat server vs. an embedded one, as long as you run the latter with similar privilege separation, etc
	6. Instead of War, you are going to deploy fat Jar.
	7. We ran our spring boot applications with embedded tomcat. You can also customize the ports for it as well while putting apache or nginx in front of it
	8. We don't deploy as a jar, but rather alter the pom.xml to ship a war and drop it in Tomcat / Jetty. As for the port thing, we use iptables to forward 80 to 8080 and 443 to 8443.
	9. java -jar it and setup some httpd to reverse proxy to it. In the past the httpd is where the ssl terminated so it was unencrypted from httpd to app. The app had a private ip and the httpd instances had both private and public IPs.
	10. Like many in this thread have pointed out, running java -jar and using Nginx as a reverse proxy in front is the way most people do it.
	11. We deploy a docker container with the full jar (including an embedded tomcat) to AWS, then use an ELB to load balance and send all port 443 traffic to port 8080 to the ec2 instance


Start/Stop/Restart Spring Boot app in Linux server:
	 
	1. If you are in a linux environment all you have to do is to create a symlink to your .jar file from inside /etc/init.d/
			sudo ln -s /path/to/your/myboot-app.jar /etc/init.d/myboot-app
		Then you can start the application like any other service
			sudo /etc/init.d/myboot-app start
		To close the application
			sudo /etc/init.d/myboot-app stop
		This way, application will not terminate when you exit the terminal. 
		And application will shutdown gracefully with stop command.
