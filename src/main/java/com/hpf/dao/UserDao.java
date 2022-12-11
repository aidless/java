package com.hpf.dao;

import com.hpf.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void add(User user);

    User findById(String id);

    void update(User user);

    void deleteById(String id);

    int findCount();

    List<User> page(int start, int pageSize);
}
