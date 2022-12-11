package com.hpf.web;

import com.hpf.pojo.User;
import com.hpf.service.UserService;
import com.hpf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAll")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service层的对象中的方法
        UserService userService=new UserServiceImpl();
        List<User> userList= userService.findAll();
        //保存查询的数据
        request.setAttribute("list",userList);
        //跳转到list.jsp
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}