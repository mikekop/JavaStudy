package ru.logrocon.lesson5;

import java.sql.*;

public class Database {

    private Connection conn = null;

    public Database(String urlDb, String userDb, String passwordDb) {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(urlDb, userDb, passwordDb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public ResultSet execSql(String sql) throws SQLException {
        Statement sta = conn.createStatement();
        return sta.executeQuery(sql);
    }
}