package com.hpf.service.impl;

import com.hpf.dao.AdminDao;
import com.hpf.dao.impl.AdminDaoImpl;
import com.hpf.pojo.Admin;
import com.hpf.service.AdminService;

public class AdminServiceImpl implements AdminService {

    //调用dao层操作数据库
    AdminDao adminDao=new AdminDaoImpl();

    @Override
    public Admin login(Admin admin) {
        //假设dao层有login方法
        return adminDao.login(admin);
    }
}
