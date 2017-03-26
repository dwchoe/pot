package com.sandbox.config;

import com.sandbox.service.BOMService;
import com.sandbox.service.BOMServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * author: Daewon Choe
 */

@Configuration
@ComponentScan(basePackages = {"com.sandbox.service"})
public class CoreConfig {

    @Bean
    public BOMService getBOMService() {
        return new BOMServiceImpl();
    }
}
