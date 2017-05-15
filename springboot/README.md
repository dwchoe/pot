# poc_springboot_war

description: <br>
- creating a Spring Boot app without the embedded Tomcat, but a war

features: <br>
- lombok.jar: allows the use of @Slf4j, @Getter and @Setter
  - build.gradle: compile("org.projectlombok:lombok:1.16.0")
- create Groovy service and called from controller
- Kafka producer
  - KafkaProducer.java
  - build.grade.: compile("org.apache.kafka:kafka-clients:0.9.0.0")
- Kafka consumer
- servlet filter
- annotation
- aspect


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
