package webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HelloController {
    @RequestMapping("/hello")
    public  String hello(){
        System.out.println("inside hello controller");
        return "index.jsp";
    }



}
