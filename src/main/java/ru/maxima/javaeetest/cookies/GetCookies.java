package ru.maxima.javaeetest.cookies;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.maxima.javaeetest.HelloServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getServlet", value = "/get")
public class GetCookies extends HelloServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Cookie[] cookies = request.getCookies();


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (Cookie cookie : cookies) {
            out.println("<h1>" + cookie.getName() + " " + cookie.getValue() +   "</h1>");
        }
        out.println("</body></html>");
    }
}
