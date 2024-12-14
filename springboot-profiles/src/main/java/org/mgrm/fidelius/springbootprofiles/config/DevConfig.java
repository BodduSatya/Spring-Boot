package org.mgrm.fidelius.springbootprofiles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    public DataSource dataSource() {
        System.out.println("*** DevConfig.myConfig() ");
        return null;
    }

}

