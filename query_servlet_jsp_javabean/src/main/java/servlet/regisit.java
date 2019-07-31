package servlet;

import DB.DBmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/regist")
public class regisit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String from_employeeName=req.getParameter("employeeName");
        String from_employeeId=req.getParameter("employeeId");
        String from_departName=req.getParameter("departName");
        DBmanager db=new DBmanager();
        String front=" insert into employee values(";
        String strSql=front+from_employeeId+",\""+from_employeeName+"\""+","+from_departName+")";
        int num=db.nonQueryMethod(strSql);
        if(num!=0){
            req.getRequestDispatcher("successful.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("fail.jsp").forward(req,resp);
        }
    }
}
