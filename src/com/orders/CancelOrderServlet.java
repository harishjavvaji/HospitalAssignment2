package com.orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

public class CancelOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        HttpSession httpSession = req.getSession();
        Connection connection = (Connection) httpSession.getAttribute("connection");

        String orderName = req.getParameter("orderName");

        if (orderName.isEmpty()) {
            resp.getWriter().print("Please enter order name");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("CancelOrders.html");
            requestDispatcher.include(req, resp);

        }else {
            DataBaseConnection dataBaseConnection = new DataBaseConnection(orderName);
            dataBaseConnection.cancelOrder(connection);
            resp.getWriter().print("Order cancelled successfully!!! ");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("CancelOrders.html");
            requestDispatcher.include(req, resp);
        }


    }
}
