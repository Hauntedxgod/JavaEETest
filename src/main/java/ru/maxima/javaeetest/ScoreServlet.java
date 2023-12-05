package ru.maxima.javaeetest;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
@WebServlet(name = "ScoreServlet", value = "/score-servlet")
public class ScoreServlet extends  HttpServlet {

    private String message;

    public void init() {
        message = "This is an attempt to make a calculator! ";
    }


        public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
            int sum = 0;
            try {
                int num1 = Integer.parseInt(request.getParameter("num1"));
                int num2 = Integer.parseInt(request.getParameter("num2"));


                String action = request.getParameter("op") ;
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

            } catch (NumberFormatException e) {
                throw new RuntimeException(e);

            }


            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + message + " " + sum + "</h1>");
            out.println("</body></html>");

        }
    }



    //