package com.luo.study.mode.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luolingyan
 * @description
 * @create 2025-02-17 9:18
 */
public class JavaConnectionPool {
    /**
     *用来存放可用的连接
     */
    private Queue<Connection> connectionQueue = new LinkedList<>();
    public static final String DRIVER = "org.mariadb.jdbc.Driver";
    public static final String URL = "jdbc:mariadb://localhost:3306/test";
    public static final String USER = "root";
    public static final String PASSWORD = "Llycph900623";

    //1、构造方法私有化
    private JavaConnectionPool(){}

    //2、定义一个连接池私有对象属性
    private static JavaConnectionPool instance = null;

    //3、提供一个全局的访问方法
    public static JavaConnectionPool getInstance(){
        if(instance == null){
            instance = new JavaConnectionPool();
        }
        return instance;
    }

    //获取连接
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connectionQueue.isEmpty()){
            return createConnection();
        }else{
            return connectionQueue.poll();
        }
    }

    private Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        final Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connectionQueue.offer(connection);
        return connection;
    }

    //释放连接
    public void release(Connection connection){
        connectionQueue.offer(connection);
    }

    public static void main(String[] args) {
        JavaConnectionPool instance1 = JavaConnectionPool.getInstance();
        JavaConnectionPool instance2 = JavaConnectionPool.getInstance();
        System.out.println(instance1 == instance2);
    }
}
