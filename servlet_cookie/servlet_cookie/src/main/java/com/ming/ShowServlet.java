package com.ming;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showServlet")
public class ShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //显示cookie的状态
        out.append("<html>")
                .append("<head><title>CookieServletDemo</title></head>")
                .append("<body>")
                .append("<table border='1' align='center'>")
                .append("<tr>")
                .append("<td>CookieName</td>")
                .append("<td>CookieValue</td>");

        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if(cookies != null){
            for(int i = 0; i < cookies.length; i++){
                cookie = cookies[i];
                out.append("<tr>")
                        .append("<td>'"+cookie.getName()+"'</td>")
                        .append("<td>'"+cookie.getValue()+"'</td>")
                        .append("</tr>");
            }
        }

                out.append("</tr>")
                .append("</table>")
                .append("</body>")
                .append("</html>");
    }
}
