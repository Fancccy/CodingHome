import java.sql.*;

public class MyTest2JDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/mytest?user=root&password=612425";
            String sql="select department.departName from department where department.departId=(select employee.departNum from employee where employee.employeeName=\"arvin\")";
            try(Connection connection=DriverManager.getConnection(url);
                Statement statement=connection.createStatement();
                ResultSet resultSet=statement.executeQuery(sql);
            ) {
                while(resultSet.next()) {
                    String name=resultSet.getString("departName");
                    System.out.println(name);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
