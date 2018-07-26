package atm.v2_0.bank;


import atm.v2_0.database.DBController;
import atm.v2_0.database.Sqlitecontroller;
import atm.v2_0.users.Person;

import java.io.File;
import java.sql.*;
import java.util.List;
import java.util.Map;

public abstract class Bank {
    private Map<Person, List<Account>> persons;
    private String cardNumber;
    static int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        Bank.i = i;
    }

    public void init() throws ClassNotFoundException {
        //todo создаем базу данных, если нет backup файла xml
        DBController dbController = new Sqlitecontroller();
        dbController.init();
        dbController.addAccount(getI(),510, 0, this);
        for (int j = 0; j < 15; j++) {
            dbController.addAccount(getI(),510, 0, this);

        }

    }

    public void createAcc(Person person) {
        //todo создаем аккаунт и записываем его в БД
        //todo получаем его ID и заносим все в persons
        //todo создаем карту для аккаунта, записываем ее данные в БД в этот аккаунт
    }
}
