package de.workshops.bookdemo.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppConfigTest {

    @Autowired
    private AppConfig appConfig;

    @Test
    void test() {
        assertEquals(42, appConfig.getIntParam());
        assertEquals("test", appConfig.getStringParam());
    }
    
}
