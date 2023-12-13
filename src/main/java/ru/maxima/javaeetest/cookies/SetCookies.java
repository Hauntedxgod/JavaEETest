package ru.maxima.javaeetest.cookies;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.maxima.javaeetest.HelloServlet;

import java.io.IOException;

@WebServlet(name = "setServlet", value = "/set")
public class SetCookies extends HelloServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("some_cookie1" , "123456");
        Cookie cookie2 = new Cookie("some_cookie2" , "Victor");

        cookie.setMaxAge(86400);
        cookie2.setMaxAge(86400);


        response.addCookie(cookie);
        response.addCookie(cookie2);
    }
}
