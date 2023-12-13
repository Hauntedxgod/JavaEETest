package ru.maxima.javaeetest;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private int a = 10;

    public void init() {
        message = "Hello World from Servlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
//        String name = request.getParameter("name");
//        String surName = request.getParameter("surname");
//        if (name == null) {
//            name = "User";
//        }
//
//        if (surName == null) {
//            surName = "User";
//        }

        a += 10;

        HttpSession session = request.getSession();

        Integer count = (Integer) session.getAttribute("count");

        if (count == null){
            session.setAttribute("count" , 1 );
        } else {
            session.setAttribute("count" , count + 1);
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + count +  "</h1>");
        out.println("</body></html>");

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }


//        response.sendRedirect("https://ru.wikipedia.org/wiki/JavaServer_Pages");
    }

    public void destroy() {
    }
}