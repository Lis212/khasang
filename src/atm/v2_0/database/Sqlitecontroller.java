package atm.v2_0.database;

import atm.v2_0.bank.Bank;

import java.io.File;
import java.sql.*;

public class Sqlitecontroller implements DBController {
    private static final String URL = "jdbc:sqlite:src/atm/v2_0/database/persons.db";
    private Connection connection;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Not registered");
        }

    }

    private Sqlitecontroller() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
    }
    @Override
    public void init() throws ClassNotFoundException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/atm/v2_0/database/persons.db")){
            System.out.println("It is OK");
            Statement statement = connection.createStatement();
            System.out.println("OK2");

//            System.out.println("OK");
//            statement.executeUpdate("PRAGMA foreign keys = on;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Persons (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name TEXT, FOREIGN KEY (ID) REFERENCES Accounts(Number));");
            System.out.println("OK2-1");

            statement.executeUpdate("INSERT INTO Persons (Name) VALUES ('Boris Samoylov');");
            String name = "Luisa";
            String sName = "Conte";
            statement.executeUpdate("INSERT INTO Persons (Name) VALUES ('" + name + " " + sName + "');");
            statement.executeUpdate("INSERT INTO Persons (Name) VALUES ('Olga Samoylova');");
            System.out.println("OK3");
            statement.executeUpdate("DROP TABLE IF EXISTS Accounts;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Accounts (Number INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "CardNumber TEXT NOT NULL, Balance INTEGER, Status INTEGER, Bank TEXT);");
            System.out.println("OK4");
//            statement.executeUpdate("INSERT INTO Accounts (Number, CardNumber, Balance, Status, Bank) VALUES (1001, 100001, 0, 1, 'Sberbank');");
            System.out.println("OK5");

        } catch (SQLException e) {
            System.err.println("Not connection");
        }
    }

    @Override
    public boolean checkFile() {
        File file = new File("src/atm/v2_0/bank/bank.db");
        return file.exists();
    }

    @Override
    public void addPerson() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/atm/v2_0/database/persons.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAccount(int balance, int status, Bank bank) {

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/atm/v2_0/database/persons.db")){
            System.out.println("It is OK2");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CardNumber FROM Accounts;");
            long i = 0;
            while (resultSet.next()){
                i++;
            }
            int cardNumber = (int) i;
            String cardNumberForSql = "";
            if (cardNumber < 10){
                cardNumberForSql = "0000 0000 0000 000" + cardNumber;
            } else if (cardNumber >= 10 && cardNumber < 100){
                cardNumberForSql = "0000 0000 0000 00" + cardNumber;
            } else if (cardNumber >= 100 && cardNumber < 1000){
                cardNumberForSql = "0000 0000 0000 0" + cardNumber;
            }
            System.out.println("i = " + i);
            String sql = "INSERT INTO Accounts (CardNumber, Balance, Status, Bank) VALUES ('"+ cardNumberForSql + "', " + balance + ", " + status + ", '" + bank.getClass().getSimpleName() + "');";
            statement.executeUpdate(sql);
            System.out.println("It is OK3");
        } catch (SQLException e) {
            System.err.println("Not connection");
        }
    }

    @Override
    public void deleteAccount(String name) {

    }
}
