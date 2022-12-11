package com.hpf.dao.impl;

import com.hpf.dao.UserDao;
import com.hpf.pojo.Admin;
import com.hpf.pojo.User;
import com.hpf.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql="SELECT * from user";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void add(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public User findById(String id) {
        try {
            String sql="select * from user where id=?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(User user) {
        String sql="update user set gender=?,age=?,address=?,qq=?,email=? where name=?";
        template.update(sql,user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getName());
    }

    @Override
    public void deleteById(String id) {
        String sql="delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public int findCount() {
        String sql="select count(*) from user";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<User> page(int start, int pageSize) {
        String sql="select * from user limit ?,?";
        return template.query(sql,new BeanPropertyRowMapper<>(User.class),start,pageSize);
    }
}
