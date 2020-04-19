package shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiro.beans.User;
import shiro.dao.IUserDao;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserDao dao;

    @Override
    public User findByName(String name) {
        User user = dao.findByName(name);
        return user;
    }
}
