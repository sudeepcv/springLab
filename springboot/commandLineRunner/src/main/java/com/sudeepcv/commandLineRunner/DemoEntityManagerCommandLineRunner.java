package com.sudeepcv.commandLineRunner;

import com.sudeepcv.commandLineRunner.entity.User;
import com.sudeepcv.commandLineRunner.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DemoEntityManagerCommandLineRunner implements CommandLineRunner {
    private static  final Logger log= LoggerFactory.getLogger(DemoEntityManagerCommandLineRunner.class);
    @Autowired
    private UserDAOService userDAOService;
    @Override
    public void run(String... args) throws Exception {

        User user=new User();
        user.setName("sudeep cv");
        user.setRole("ADMIN");
       Long savedUserId= userDAOService.save(user);
        log.info("saved user id:"+savedUserId);

    }
}
