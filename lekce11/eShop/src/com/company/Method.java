package com.company;

import java.math.BigDecimal;
import java.sql.*;


public class Method implements GoodsMethods {
    private static final String INSERT = "INSERT INTO eshop (id, partNo,serialNo,name,description,numberInStock,price ) VALUES (?,?,?,?,?,?,?)";

    @Override
//This method saves the given item - Tato metoda načte položku s daným ID
    public String loadItemById(Integer id) {

        String resultSetReturn = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop", "hotel_crud", "123danielakolarikova");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM eshop WHERE id = \"" + id + "\"");
            while (resultSet.next()) {
                resultSetReturn = "Název položky: " + resultSet.getString("name") + ", Číslo položky: " + resultSet.getString("partNo") + ", id položky: " + resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSetReturn;
    }

    @Override
//TThis method deletes all items that are not in stock -  metoda smaže všechny položky, které nejsou skladem
    public void deleteAllOutOfStockItems() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop", "hotel_crud", "123danielakolarikova");
            PreparedStatement deletePreparedStatement = connection.prepareStatement("DELETE FROM eshop WHERE numberInStock=0");
            deletePreparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
//This method loads all items that are in stock - Tato metoda načte všechny položky, které jsou skladem
    public String loadAllAvailableItems() {

        String resultSetReturnPrint = null;

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop", "hotel_crud", "123danielakolarikova");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  id, name,partNo, serialNo FROM eshop WHERE numberInStock>0");
            while (resultSet.next()) {
                String resultSetReturn = "Název položky: " + resultSet.getString("name") + ", Číslo položky: " + resultSet.getString("partNo") + ", id položky: " + resultSet.getInt("id") + "\n";
                resultSetReturnPrint += resultSetReturn;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSetReturnPrint;
    }


    @Override
//This method saves the given item - Tato metoda uloží danou položku
    public void saveItem(Item item) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop", "hotel_crud", "123danielakolarikova");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setString(2, item.getPartNo());
            preparedStatement.setString(3, item.getSerialNo());
            preparedStatement.setString(4, item.getName());
            preparedStatement.setString(5, item.getDescription());
            preparedStatement.setInt(6, item.getNumberInStock());
            preparedStatement.setBigDecimal(7, item.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException f) {
            f.printStackTrace();
        }
    }


    @Override
// This method updates a price of an item - Tato metoda aktualizuje cenu položky
    public void updatePrice(Integer id, BigDecimal newPrice) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop", "hotel_crud", "123danielakolarikova");
            Statement ubdateStatement = connection.createStatement();
            ubdateStatement.executeUpdate("UPDATE eshop SET price = \"" + newPrice + "\" WHERE id = \"" + id + "\"");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
