package com.itmayiedu.service;

import com.itmayiedu.beans.Student;

public interface IStudentService {
    Student selectStudent(int id);
    void sedSms();
}
