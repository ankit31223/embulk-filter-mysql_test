package org.embulk.filter.mysql_test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection connection=null;

    private DatabaseConnection(MysqlTestFilterPlugin.PluginTask task) throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + task.getHost() + ":"+task.getPort()+"/"+task.getDatabase();
            connection= DriverManager.getConnection(url, task.getUserName(), task.getPassword());
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e);
        }

    }

    public static Connection getConnection(MysqlTestFilterPlugin.PluginTask task){
        if(connection==null){
            try {
                new DatabaseConnection(task);
                return connection;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        return connection;
    }
}
