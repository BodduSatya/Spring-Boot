package org.satya.sbjenkinsdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest
class SpringbootJenkinsDemoApplicationTests {

    Logger logger = Logger.getLogger(SpringbootJenkinsDemoApplicationTests.class.getName());
    @Test
    void contextLoads() {
        logger.info("Inside contextLoads method in SpringbootJenkinsDemoApplicationTests");
    }

}
