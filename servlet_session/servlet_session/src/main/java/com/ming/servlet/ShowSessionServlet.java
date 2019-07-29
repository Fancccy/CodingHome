package com.ming.servlet;

import sun.font.TrueTypeFont;
import sun.plugin.viewer.context.IExplorerAppletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;


@WebServlet("/showSessionServlet")
public class ShowSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
      this.doPost(request,respone);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       //测试Session
        HttpSession httpSession = request.getSession(true);
        String message = null;//(first---> newer  Or  many times---> older)
        Integer accessCount = (Integer) httpSession.getAttribute("accessCount");

        if(accessCount == null){
            accessCount = new Integer(1);
            message = "newer";
            httpSession.setAttribute("accessCount",accessCount);
        }else{
            accessCount = new Integer(accessCount.intValue()+ 1);
            message = "older";
            httpSession.setAttribute("accessCount",accessCount);
        }
        out.append("<html>")
                .append("<head><title>CookieServletDemo</title></head>")
                .append("<body>")
                .append("<h1>'"+message+"'</h1></br>")
                .append("<table border='1' align='center'>")

                .append("<tr>")
                .append("<td>SessionID</td>")
                .append("<td>'"+httpSession.getId()+"'</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<td>Session Create Time</td>")
                .append("<td>'"+httpSession.getCreationTime()+"'</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<td>Session Access Last Time</td>")
                .append("<td>'"+httpSession.getLastAccessedTime()+"'</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<td>AccessCount</td>")
                .append("<td>'"+accessCount+"'</td>")
                .append("</tr>")



                .append("</table>")
                .append("</body>")
                .append("</html>");

    }
}
