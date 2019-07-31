package DB;

import java.sql.*;

public class DBmanager {
    private Connection conn = null;
    private Statement state = null;
    private ResultSet rs = null;

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/mytest?user=root&password=612425&&serverTimezone=GMT";

    public Connection getConnection(){
        try {
            Class.forName(driver);
            System.out.println("loading driver success.......");
            conn = DriverManager.getConnection(url);
            System.out.println("connection db success.....");
            return conn;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  conn;
    }


    // insert update delete
    public int nonQueryMethod(String strSql){
        int flag = 0;
        try {
            conn = this.getConnection();
            state = conn.createStatement();
            flag = state.executeUpdate(strSql);
            return flag;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }
    //select
    public String query(String strSql){
            String name=null;
        try {
            conn = this.getConnection();
            state = conn.createStatement();
            String front="select department.departName from department " +
                    "where department.departId=(select employee.departNum " +
                    "from employee where employee.employeeName=\"";
            String mark="\")";
            strSql=front+strSql+mark;
            rs = state.executeQuery(strSql);
            if(rs==null){
                return null;
            }
            while(rs.next()){
               name=rs.getString("departName");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
       return name;
    }

    public void closeDb(){
        try {
            if(rs != null) rs.close();
            if(state!= null) state.close();
            if(conn != null) conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBmanager db=new DBmanager();
        String front=" insert into employee values(";
        String strSql=front+6+",\""+"sunny"+"\""+","+3+")";
        int num=db.nonQueryMethod(strSql);
        System.out.println(num);
    }
}
