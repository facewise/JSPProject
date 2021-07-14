package com.main;

import java.sql.*;

public class MainDAO {
    protected Connection conn;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public MainDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:kr");
        } catch (SQLException e) {
            System.out.println("커넥션 실패");
        }
    }

    public int getNum(String table, Connection conn) {
        int num = 1;
        String sql = "select Max(num) as max from " + table;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                num = rs.getInt("max") + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
