package com.javaminds.springbootiq.jpa;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private UserRepository userRepository = null;

    @Override
    public void run(String... args) throws Exception {
        log.info("*** In UserCommandLineRunner.run() ***");

//        userRepository.save(new User("User-1","ADMIN"));
//        userRepository.save(new User("User-2","NORMAL"));
//        userRepository.save(new User("User-3","ADMIN"));
//        userRepository.save(new User("User-4","NORMAL"));
    }

}
