package com.itmayiedu.service.impl;

import com.itmayiedu.mapper.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private IUserDao iUserDao;
    public String register(String name, String pwd){
        //1.获取uuid
        iUserDao.insertUUID();
        Long userId = iUserDao.getUUID();

        //2.通过uuid判断存放到不同的表
        String tableName = "user" + userId % 3;

        //3.保存到数据库中
        iUserDao.InsertUser(tableName, userId, name, pwd);
        return "success";
    }

    public String get (Long userId){
        //通过uuid判断存放到不同的表
        String tableName = "user" + userId % 3;
        String name = iUserDao.getUserName(tableName, userId);
        return name;
    }
}
