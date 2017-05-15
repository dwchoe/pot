# poc_springboot_war

creating a Spring Boot app without the embedded Tomcat, but a war <br>
- create Groovy service and called from controller

dependencies<br>
- lombok.jar: allows the use of @Slf4j, @Getter and @Setter 
-- gradle



<b>Step 1:</b><br>
build.gradle <br>
<pre>
 apply plugin: 'war'
 
 war {
   baseName = 'demo'
 }
 
 buildscript {
   dependencies {
     classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
   }
 }

 dependencies {
   providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
 }
</pre>

<b>Step 2:</b><br>
<pre>
 @SpringBootApplication
 public class DemoApplication extends SpringBootServletInitializer {
  
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
 }
</pre>
