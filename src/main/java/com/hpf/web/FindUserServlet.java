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

@WebServlet("/findUser")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户的id
        String id = request.getParameter("id");
        //调用service层的对象中的方法
        UserService userService=new UserServiceImpl();
        User user=userService.findUserById(id);
        if (user!=null){
            //保存到域中
            request.setAttribute("user",user);
            //跳转到修改页面
            request.getRequestDispatcher("update.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}