package com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberService {
    public MemberService() {
    }

    public String action(HttpServletRequest request, HttpServletResponse response, String cmd) {
        switch (cmd) {
            case "login.me":
                login(request, response);
                break;
            case "join.me":
                join(request, response);
                break;
            case "logout.me":
                logout(request, response);
                break;
            case "checkID.me":
                checkID(request, response);
                break;
            case "checkNickname.me":
                checkNickname(request, response);
                break;
        }
        return null;
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        MemberDAO memberDAO = new MemberDAO();

    }

    public void join(HttpServletRequest request, HttpServletResponse response) {

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {

    }

    public void checkID(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("query");
        MemberDAO memberDAO = new MemberDAO();
        if (memberDAO.isUnique(id, "id")) {
            request.setAttribute("IDChecked", "true");
        } else {
            request.setAttribute("IDChecked", "false");
        }
    }

    public void checkNickname(HttpServletRequest request, HttpServletResponse response) {
        String nickname = request.getParameter("query");
        MemberDAO memberDAO = new MemberDAO();
        if (memberDAO.isUnique(nickname, "nickname")) {
            request.setAttribute("nicknameChecked", "true");
        } else {
            request.setAttribute("nicknameChecked", "false");
        }
    }
}
