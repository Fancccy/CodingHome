package ModuleModelJDBC;

import java.sql.*;
//采用模板   设计模式
public abstract class AbstractJdbcTemplate {
    /**
     * 1.加载驱动
     * 2.获取连接
     * 3.创建命令
     * 4.关闭
     *
     * 1.SQL
     * 2.执行命令
     * 3.处理结果
     * a.select
     * b.insert update delete*/

    public <T> T execute(String sql){
        this.loadDriver();
        this.createConnection();
        this.createStatement();
        //处理结果
        Object t;
        if(sql.trim().toUpperCase().startsWith("SELECT")){
            this.resultSet=this.executeQuery(sql);
            t=this.handlerResult(resultSet);
        }else{
            int effect=this.executeUpdate(sql);
            //处理结果
            t=this.handlerResult(effect);
        }
        this.close();
        return (T) t;
    }

    public abstract <T> T handlerResult(ResultSet resultSet);
    public abstract <T> T handlerResult(int effect);

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSet executeQuery(String sql){
        try {
            return this.statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private  int executeUpdate(String sql){
        try {
            return this.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private  void createStatement(){
        try {
            this.statement=this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createConnection(){
        String url="jdbc:mysql://127.0.0.1:3306/myku";
        try {
            this.connection=DriverManager.getConnection(url,"root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void close() {
        if (this.resultSet != null) {
            try {
                this.resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.statement != null) {
            try {
                this.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
