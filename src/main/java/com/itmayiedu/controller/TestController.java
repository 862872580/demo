package com.itmayiedu.controller;

import com.itmayiedu.entity.Student;
import com.itmayiedu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private IStudentService service;

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/find")
    public Object doFind(){
        Student student = service.selectStudent(1);
        return student;
    }

    @RequestMapping("/remo ")
    public String remo(){
        cacheManager.getCache("vaseCache").clear();
        return "success";
    }

    @ResponseBody
    @RequestMapping("/sedSms")
    public String sedSms(){
        System.out.println("###indexController###  1");
        service.sedSms();
        System.out.println("###indexController###  4");
        return "success";
    }
}
