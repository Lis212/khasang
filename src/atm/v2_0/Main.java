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

    }
}
