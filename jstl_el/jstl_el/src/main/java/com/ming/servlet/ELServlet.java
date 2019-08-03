package com.ming.servlet;

import com.ming.vo.Group;
import com.ming.vo.UserInfo;
import com.sun.org.apache.regexp.internal.REUtil;
import javafx.application.Application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/elServlet")
public class ELServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //测试EL表达式
        //普通字符串
        request.setAttribute("strKey","arvin w ming");

        //测试结构体
        Group group = new Group();
        group.setgName("RockClass");

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("arvin");
        userInfo.setGroup(group);
        request.setAttribute("userInfoKey",userInfo);

        //测试字符串数组
        String [] strArray = new String[]{"aa","bb","cc","dd"};
        request.setAttribute("strArrayKey",strArray);

        //测试自定义数组
        UserInfo [] userInfos = new UserInfo[5];
        for(int i = 0; i < userInfos.length; i++){
            UserInfo userinfo = new UserInfo();
            userinfo.setUsername("U_"+ i);
            userInfos[i] = userinfo;
        }
        request.setAttribute("userInfosKey",userInfos);


        //跳转
        request.getRequestDispatcher("jstl_el.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
