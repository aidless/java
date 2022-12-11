package com.hpf.web;

import com.hpf.service.UserService;
import com.hpf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/batchDelete")
public class BatchDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有的用户id
        String ids = request.getParameter("ids");       //该ids是字符串数组(内部使用,隔开)
        System.out.println("ids = " + ids);
        String[] split = ids.split(",");
        UserService userService=new UserServiceImpl();
        for (String id : split) {
            userService.deleteUser(id);
        }
        //返回到列表页面
        response.sendRedirect(request.getContextPath()+"/findAll");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}