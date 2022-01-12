package de.workshops.bookdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

// @Configuration
// @EnableConfigurationProperties
@Component
@ConfigurationProperties(prefix = "myapp")
@Data
public class AppConfig {
    
    /**
     * Das ist ein int param.
     */
    private int intParam;
    
    
    private String stringParam;

}
