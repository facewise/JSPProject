package com.api.main;

import com.api.search.SearchService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "Control", value = "/Control")
public class MainControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");

        String uri = request.getRequestURI();
        String path = request.getContextPath();
        String cmd = uri.substring(path.length()+1,uri.length());
        SearchService service = new SearchService();

        if(cmd.equals("search.do"))
            service.searchMovies(request, response);

    }
}
