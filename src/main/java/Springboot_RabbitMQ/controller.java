package Springboot_RabbitMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
    private RabbitHelper rabbitHelper;

    @RequestMapping("/rabbit")
    public String rabbit(){
        String msg = "hello";
        rabbitHelper.broadcast("test_springboot",msg);
        return "success";
    }
}
