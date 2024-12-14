package org.mgrm.fidelius.springbootprofiles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

//import javax.sql.DataSource;

@Configuration
@Profile("prod")
public class ProdConfig {

    @Bean
    public DataSource dataSource() {
        System.out.println("*** ProdConfig.myConfig() ");
        return null;
    }

}

