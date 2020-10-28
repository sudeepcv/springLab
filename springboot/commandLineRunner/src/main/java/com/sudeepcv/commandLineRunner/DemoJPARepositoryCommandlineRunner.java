package com.sudeepcv.commandLineRunner;

import com.sudeepcv.commandLineRunner.entity.User;
import com.sudeepcv.commandLineRunner.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoJPARepositoryCommandlineRunner implements CommandLineRunner {
    private static  final Logger log= LoggerFactory.getLogger(DemoJPARepositoryCommandlineRunner.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        
        User user=new User();
        user.setName("anju");
        user.setRole("ADMIN");
        User savedUser = userRepository.save(user);
        log.info("saved user with jpa repository is:"+savedUser.toString());
        
        
    }
}
