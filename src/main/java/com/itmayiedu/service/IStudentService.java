package com.itmayiedu.service;

import com.itmayiedu.entity.Student;

public interface IStudentService {
    Student selectStudent(int id);
    void sedSms();
}
