package ru.maxima.javaeetest;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Homework_Servlet {
    @WebServlet(name = "ScoreServlet", value = "/score-servlet")
        public class  ScoreServlet extends HttpServlet {
            private String message;

            public void init() {
                message = "This is an attempt to make a calculator! ";
            }

            public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                response.setContentType("text/html");
                Scanner scanner = new Scanner(System.in);
                Integer num1 = Integer.valueOf(getInitParameter(String.valueOf(scanner.nextInt())));
                Integer num2 = Integer.valueOf(getInitParameter(String.valueOf(scanner.nextInt())));
                Integer sum = null;
                String action = scanner.nextLine();
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
                out.println("<h1>" + message +  num1 + " " + action + num2 + " = " + sum + "</h1>");
                out.println("</body></html>");

            }
        }
    }
    //