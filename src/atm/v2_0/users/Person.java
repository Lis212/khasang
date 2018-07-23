package atm.v2_0.users;

import atm.v2_0.bank.Account;

import java.util.LinkedList;

public class Person {
    private String name;
    private LinkedList<Account> accounts;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
