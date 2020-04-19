package com.itmayiedu.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    private static Logger log = Logger.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/log")
    public String log(String name){
        log.info("test log");
        return "success";
    }

    @Value("${name}")
    private String name;

    @ResponseBody
    @RequestMapping("/name")
    public String getName(){
        System.out.println(name);
        return "success";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
