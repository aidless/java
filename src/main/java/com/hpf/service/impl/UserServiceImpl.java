package com.hpf.service.impl;

import com.hpf.dao.UserDao;
import com.hpf.dao.impl.UserDaoImpl;
import com.hpf.pojo.User;
import com.hpf.service.UserService;
import com.hpf.utils.PageBeanUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    //调用dao层的对象中的方法
    UserDao userDao=new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteById(id);
    }

    @Override
    public PageBeanUtils<User> findPage(String _pageNum, String _pageSize) {
        //从首页来到列表页面(没有携带参数,默认访问第一页并且显示10条数据)
        if (_pageNum==null){
            _pageNum="1";
        }
        if (_pageSize==null){
            _pageSize="10";
        }
        int pageNum=Integer.parseInt(_pageNum);
        int pageSize=Integer.parseInt(_pageSize);
        //需要将PageBeanUtils中的5个数据进行封装
        PageBeanUtils<User> pageBeanUtils=new PageBeanUtils<>();
        //设置当前页码数
        pageBeanUtils.setPageNum(pageNum);
        //bug修复
        //当pageNum=1时点击上一页会报错
        if (pageNum <= 0){
            pageNum =1;
        }
        //设置每页显示的条数
        pageBeanUtils.setPageSize(pageSize);
        //设置总数据量
        int totalCount=userDao.findCount();
        pageBeanUtils.setTotalCount(totalCount);
        //设置总页数
        int totalPage=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize)+1;
        pageBeanUtils.setTotalPage(totalPage);
        //设置每页显示的数据
        int start=(pageNum-1)*pageSize;
        List<User> list=userDao.page(start,pageSize);
        pageBeanUtils.setList(list);
        return pageBeanUtils;
    }
}
