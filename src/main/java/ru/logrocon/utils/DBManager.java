package ru.logrocon.utils;

import java.sql.*;

public class DBManager {
    protected Connection conn;

    public DBManager(String url, String userName, String password, String database, String connectorType){
        try {
            Class.forName(connectorType);
            // Поскольку драйвер от microsoft по корявому требует указание, то построим его
            String connectionUrl = String.format("%s;databaseName=%s;user=%s;password=%s", url, database, userName, password);
            conn = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            // Выбросим ошибку
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return conn;
    }

    public void dispose(){
        if(conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public Statement getStatement() throws SQLException {
        return conn.createStatement();
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException{
        return conn.prepareStatement(sql);
    }
}