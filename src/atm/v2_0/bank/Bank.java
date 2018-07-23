package atm.v2_0.bank;


import atm.v2_0.users.Person;

import java.io.File;
import java.sql.*;
import java.util.List;
import java.util.Map;

public abstract class Bank {
    private Map<Person, List<Account>> persons;

    public void init() throws ClassNotFoundException {
        //todo создаем базу данных, если нет backup файла xml
        File file = new File("src/atm/v2_0/bank/bank.db");
        System.out.println(file.exists());
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/atm/v2_0/bank/bank.db")){
            System.out.println("It is OK");
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS Accounts;");
            System.out.println("OK");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Accounts (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name TEXT, Surname TEXT);");
            System.out.println("OK2");
            statement.executeUpdate("INSERT INTO Accounts (Name, Surname) VALUES ('Boris', 'Samoylov');");
            statement.executeUpdate("INSERT INTO Accounts (Name, Surname) VALUES ('Boris', 'Samoylov');");
            statement.executeUpdate("INSERT INTO Accounts (Name, Surname) VALUES ('Boris', 'Samoylov');");
            System.out.println("OK3");
        } catch (SQLException e) {
            System.err.println("Not connection");
        }
    }

    public void createAcc(Person person) {
        //todo создаем аккаунт и записываем его в БД
        //todo получаем его ID и заносим все в persons
        //todo создаем карту для аккаунта, записываем ее данные в БД в этот аккаунт
    }
}
