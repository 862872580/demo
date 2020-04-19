package shiro.service;

import shiro.beans.User;

public interface IUserService {
    public User findByName(String name);
}
