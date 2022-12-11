package com.hpf.service;

import com.hpf.pojo.User;
import com.hpf.utils.PageBeanUtils;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void addUser(User user);

    User findUserById(String id);

    void updateUser(User user);

    void deleteUser(String id);

    PageBeanUtils<User> findPage(String pageNum, String pageSize);
}
