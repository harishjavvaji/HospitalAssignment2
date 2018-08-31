package com.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


public class DataBaseConnection {
     String orderName, chickenPizza, chickenSandwich, pasta,  breadSticks, desserts, drinks;

    public DataBaseConnection(String orderName) {
        this.orderName = orderName;
    }

    public DataBaseConnection(String orderName, String chickenPizza, String chickenSandwich, String pasta, String breadSticks, String desserts, String drinks) {
        this.orderName = orderName;
        this.chickenPizza = chickenPizza;
        this.chickenSandwich = chickenSandwich;
        this.pasta = pasta;
        this.breadSticks = breadSticks;
        this.desserts = desserts;
        this.drinks = drinks;
    }


    public Connection createConnection() {

        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","41437");

        }catch (Exception e){
            System.out.println(e);
            System.out.println("inside Create connection");
        }
        return connection;

    }


    public void setOrder(Connection connection) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Insert into orders(ordername, chickenpizza, chickensandwich, pasta, breadsticks, desserts, drinks) values (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, orderName );
            preparedStatement.setString(2, chickenPizza);
            preparedStatement.setString(3, chickenSandwich);
            preparedStatement.setString(4, pasta);
            preparedStatement.setString(5, breadSticks);
            preparedStatement.setString(6, desserts);
            preparedStatement.setString(7, drinks);

            preparedStatement.execute();
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("inside set value");
        }


    }

    public Map  getOrder(Connection connection) {

    try {

        PreparedStatement preparedStatement = connection.prepareStatement("select * FROM orders WHERE ordername = (?)");
        preparedStatement.setString(1, orderName);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()){
            orderName = resultSet.getString("orderName");
            chickenPizza = resultSet.getString("chickenPizza");
            chickenSandwich = resultSet.getString("chickenSandwich");
            breadSticks = resultSet.getString("breadSticks");
            desserts = resultSet.getString("desserts");
            drinks = resultSet.getString("drinks");

        }
    }catch (Exception e) {
        System.out.println(e);
        System.out.println("inside getvalue");
    }

        Map hashMap = new HashMap();
        hashMap.put("orderName", orderName);
        hashMap.put("chickenPizza", chickenPizza);
        hashMap.put("chickenSandwich", chickenSandwich);
        hashMap.put("pasta", pasta);
        hashMap.put("breadSticks", breadSticks);
        hashMap.put("desserts", desserts);
        hashMap.put("drinks", drinks);
        return hashMap;


    }

    public void cancelOrder(Connection connection) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders where ordername = (?)");

            preparedStatement.setString(1, orderName);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
