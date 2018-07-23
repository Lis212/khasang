package atm.v2_0.bank;


import atm.v2_0.users.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract class Bank {
    Map<Person, List<Account>> persons;

    public void init() throws ClassNotFoundException {
        //todo создаем базу данных, если нет backup файла xml
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/atm/v2_0/bank/bank.db")){
            System.out.println("It is OK");
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
