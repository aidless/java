package com.hpf.web;

import com.hpf.pojo.User;
import com.hpf.service.UserService;
import com.hpf.service.impl.UserServiceImpl;
import com.hpf.utils.PageBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findPage")
public class FindPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页的数据
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        //调用service层中的方法
        UserService userService=new UserServiceImpl();
        PageBeanUtils<User> pb= userService.findPage(pageNum,pageSize);
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}