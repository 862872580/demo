package shiro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @RequestMapping("success")
    public String success(){
        return "success";
    }


}
