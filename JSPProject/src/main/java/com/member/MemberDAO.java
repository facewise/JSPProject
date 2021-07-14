package com.member;

import com.main.MainDAO;

import java.sql.SQLException;

public class MemberDAO extends MainDAO{

    public void insertMember(String id, String pw, String nickname, String email, int age) {
        String sql = "insert into member values(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pw);
            ps.setString(3, nickname);
            ps.setString(4, email);
            ps.setInt(5, age);
            ps.executeUpdate();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUnique(String query, String condition) {
        boolean result = false;
        String sql = "select * from member where ?=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, condition);
            ps.setString(2, query);
            rs = ps.executeQuery();
            result = !rs.next();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
