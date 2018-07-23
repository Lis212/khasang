package atm.v2_0;

import atm.v2_0.bank.Bank;
import atm.v2_0.bank.Sberbank;
import atm.v2_0.bank.db.driver.MyDriverDB;
import atm.v2_0.users.Person;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Bank bank = new Sberbank();
        Person person = new Person();
        try {
            bank.init();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        bank.createAcc(person);
        try {
            Class.forName("atm.v2_0.bank.db.driver.MyDriverDB");
        } catch (ClassNotFoundException e) {
            System.err.println("Sorry, class not found");
        }
        try {
            connection = DriverManager.getConnection("jdbc:newsql:bankdb");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM authors");
        } catch (SQLException e) {
            System.err.println("Connection is false");
        }
    }
}
