package start;

/**
 * Created by z0019mz on 1/2/16.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

//look for Components define by groovy in "poc" package and java in "start"
@ComponentScan(basePackages = "poc,start")
public class DemoApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        System.out.println("DemoApplication - demo started");
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
//        application.
    }
}
