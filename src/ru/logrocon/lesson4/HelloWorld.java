package ru.logrocon.lesson4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        PrintWriter pw = resp.getWriter();
        pw.printf("<H1>Привет, %s</H1>", name);
        pw.printf("<a href=\"javascript:history.back()\">Назад</a>");
    }
}