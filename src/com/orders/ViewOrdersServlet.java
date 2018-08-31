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
import java.util.Map;

public class ViewOrdersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        HttpSession httpSession = req.getSession();
        Connection connection = (Connection) httpSession.getAttribute("connection");

        String orderName = req.getParameter("orderName");

        if (orderName.isEmpty()) {
            resp.getWriter().print("Please enter order name");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewOrders.html");
            requestDispatcher.include(req, resp);

        }else {
            DataBaseConnection dataBaseConnection = new DataBaseConnection(orderName);
            Map orderMap = dataBaseConnection.getOrder(connection);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewOrders.html");
            resp.getWriter().print("Order Name : " + orderMap.get("orderName"));
            resp.getWriter().print("Chicken Pizza : " + orderMap.get("chickenPizza"));
            resp.getWriter().print("Chicken Sandwich : " + orderMap.get("chickenSandwich"));
            resp.getWriter().print("Pasta : " + orderMap.get("pasta"));
            resp.getWriter().print("Bread Sticks : " + orderMap.get("breadSticks"));
            resp.getWriter().print("Desserts : " + orderMap.get("desserts"));
            resp.getWriter().print("Drinks : " + orderMap.get("drinks"));
            requestDispatcher.include(req, resp);
        }

    }
}
