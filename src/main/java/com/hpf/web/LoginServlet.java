package com.hpf.web;

import com.hpf.pojo.Admin;
import com.hpf.service.AdminService;
import com.hpf.service.impl.AdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户输入的数据(用户名,密码,验证码)
        //使用BeanUtils工具类
        /**
         * Map<String,String[]>
         *  键就是name属性的名称
         *  值是输入的数据
         *  举例: username=张三
         *  有可能值有多个(复选框)
         */
        Map<String,String[]> map = req.getParameterMap();
        //将map集合中的数据封装到对象中
        Admin admin=new Admin();        //此时的admin对象是空的
        //调用BeanUtils工具类中的populate()
        try {
            BeanUtils.populate(admin,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("admin = " + admin);

        //登录操作需要去查询数据库(查询用户名和密码)
        //先判断验证码(如果验证码都错误,那么就不需要查询数据库)
        String verifycode = req.getParameter("verifycode");
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");    //服务器生成的验证码
        System.out.println("checkcode_server = " + checkcode_server);
        //防止用户反复输入(恶意攻击)清空指定属性
        session.removeAttribute("CHECKCODE_SERVER");

        if (checkcode_server==null||!checkcode_server.equalsIgnoreCase(verifycode)){
            //输入的验证码和服务器生成的验证码不一致
            req.setAttribute("msg","验证码错误!");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            //直接结束
            return;
        }

        //2.对输入的数据进行判断(业务逻辑) -> service层(解耦)
        //调用service层对象(使用多态) 接口 new 实现类
        AdminService adminService=new AdminServiceImpl();
        //2.1 假设service层有处理登录的操作 -> 方法
        Admin adm=adminService.login(admin);        //此时的admin对象中封装了用户名和密码

        //3.响应数据 -> 页面跳转
        if (adm==null){
            //3.2 如果登录失败 -> 返回到登录页面继续
            //给错误信息提示
            req.setAttribute("msg","用户名或密码错误!");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else {
            //3.1 如果登录成功 -> list.jsp
            //将登录成功的用户信息保存到域中
            req.getSession().setAttribute("admin",admin);
            req.getRequestDispatcher("/findPage?pageNum=1").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
