package com.hpf.dao.impl;

import com.hpf.dao.AdminDao;
import com.hpf.pojo.Admin;
import com.hpf.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

public class AdminDaoImpl implements AdminDao {
    //dao层才是真正的操作数据库
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Admin login(Admin admin) {
        try {
            //编写sql语句
            String sql="select * from admin where username=? and password=?";
            /**
             *  第一个参数:sql对象
             *  第二个参数:查询的数据封装对象的类型
             *  第三个参数是可变参数:sql语句中的?
             */

            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Admin.class), admin.getUsername(), admin.getPassword());
        } catch (DataAccessException e) {
            //e.printStackTrace();在命令行打印异常信息在程序中出错的位置及原因。
            // 会导致内存池爆满 web服务卡死 建议使用 logger.error();
            return null;
        }
    }
}
