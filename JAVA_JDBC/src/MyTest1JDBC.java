import java.sql.*;

public class MyTest1JDBC {
    /*
      1.加载数据库的JDBC驱动
      2.
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/myku?user=root&password=612425";
            String sql="insert into student values (id=4,name=\"豆豆\",age=2,ergnt=\"男\");";
            try( Connection connection=DriverManager.getConnection(url);
                 Statement statement=connection.createStatement();
                 ) {
                int eff=statement.executeUpdate(sql);
                System.out.println(eff);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
