package com.itmayiedu.service;

import com.itmayiedu.beans.Student;
import com.itmayiedu.dao.IStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentDao dao;

    @Override
    public Student selectStudent(int id) {
        Student student = dao.selectStudentById(id);
        return student;
    }

    @Async
    public void sedSms(){
        System.out.println("sedSms()开始执行... 2");
        for (int i = 0; i < 5; i ++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i = " + i);
        }
        System.out.println("sedSms()结束执行... 3");
    }
}
