package atm.v2_0.database;

import atm.v2_0.bank.Bank;

public interface DBController {

    public void init() throws ClassNotFoundException;

    public boolean checkFile();

    public void addPerson();

    public void addAccount(int balance, int status, Bank bank);

    public void deleteAccount(String name);
}
