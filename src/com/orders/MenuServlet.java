package com.orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class MenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        String chickenPizza = req.getParameter("chickenPizza");
        String chickenSandwich = req.getParameter("chickenSandwich");
        String pasta = req.getParameter("pasta");
        String breadSticks = req.getParameter("breadSticks");
        String desserts = req.getParameter("desserts");
        String drinks = req.getParameter("drinks");


        String orderName = req.getParameter("orderName");

        if (chickenPizza.isEmpty() && chickenSandwich.isEmpty() &&
                pasta.isEmpty() && breadSticks.isEmpty() &&
                desserts.isEmpty() && drinks.isEmpty()) {
            printWriter.print("Please add at least one item to your order");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Menu.html");
            requestDispatcher.include(req,resp);
        }else if (orderName.isEmpty()) {
            printWriter.print("Order name is mandatory to choose");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Menu.html");
            requestDispatcher.include(req,resp);
        }

        if (chickenPizza.isEmpty()) chickenPizza = "0";
        if (chickenSandwich.isEmpty()) chickenSandwich = "0";
        if (pasta.isEmpty()) pasta = "0";
        if (breadSticks.isEmpty()) breadSticks = "0";
        if (desserts.isEmpty()) desserts = "0";
        if (drinks.isEmpty()) drinks = "0";

        DataBaseConnection dataBaseConnection =
                new DataBaseConnection(orderName, chickenPizza, chickenSandwich, pasta, breadSticks, desserts, drinks);
        Connection connection = dataBaseConnection.createConnection();

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("connection", connection);

        dataBaseConnection.setOrder(connection);

        printWriter.print("Order placed");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Home.html");
        requestDispatcher.include(req, resp);







    }
}
