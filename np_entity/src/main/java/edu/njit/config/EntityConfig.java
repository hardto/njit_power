package edu.njit.config;

import edu.njit.test.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.njit.test")
public class EntityConfig {
    @Bean
    public Test testBean(){
        return new Test();
    }
}
