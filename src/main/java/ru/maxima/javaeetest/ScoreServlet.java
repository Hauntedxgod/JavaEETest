package ru.maxima.javaeetest;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
@WebServlet(name = "ScoreServlet", value = "/score-servlet")
public class ScoreServlet extends  HttpServlet {

    private String message;


    public void init() {
        message = "This is an attempt to make a calculator! ";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Double num1 = Double.valueOf(request.getParameter("num1"));
        Double num2 = Double.valueOf(request.getParameter("num2"));

        Double sum = 0.0;

        String action = request.getParameter("op");
        List<String> params = Arrays.asList(request.getQueryString().split("&"));
        for (String param : params) {
            if (param.contains("op=")) {
                action = param.split("=")[1];
            }
            if (action == null) {
                action = "SS";
            }
            switch (action) {
                case "+":
                    sum = num1 + num2;
                    break;
                case "-":
                    sum = num1 - num2;
                    break;
                case "*":
                    sum = num1 * num2;
                    break;
                case "/":
                    sum = num1 / num2;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }


            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + message + " " + sum + "</h1>");
            out.println("</body></html>");

        }
    }
}

//