package com.hhh.study.Java并发编程的艺术.模拟连接池;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int capacity){
        for (int i = 0; i < capacity; i++){
            pool.add(ConnectionDriver.createConnection());
        }
    }

    //释放连接
    public void releaseConnection(Connection connection){
        if (connection != null){
            synchronized (pool){
                pool.add(connection);
                pool.notifyAll();
            }
        }
    }

    //获取连接
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            if (mills <= 0){
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                long future = System.currentTimeMillis() + mills;
                long temp = mills;

                while (pool.isEmpty() && temp > 0){
                    pool.wait(temp);
                    temp = future - System.currentTimeMillis();
                }
                Connection result = null;

                if (!pool.isEmpty()){
                    result = pool.removeFirst();
                }

                return result;
            }
        }
    }
}
