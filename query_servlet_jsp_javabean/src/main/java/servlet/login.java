package servlet;

import DB.DBmanager;

/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;

@WebServlet("/loginServlet")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String from_name = req.getParameter("username");
        String str = null;
            DBmanager db = new DBmanager();
            str = db.query(from_name);
        System.out.println(str);
            req.setAttribute("name", str);
            if (str != null) {
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            }
            if (str == null)
                req.getRequestDispatcher("failure.jsp").forward(req, resp);
    }
}*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryname = request.getParameter("username");
        DBmanager db = new DBmanager();
        String str = db.query(queryname);
        request.setAttribute("name", str);
        if (str != null) {
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("failure.jsp").forward(request, response);
        }
    }
}

