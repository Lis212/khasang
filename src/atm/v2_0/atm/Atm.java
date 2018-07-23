package atm.v2_0.atm;

import atm.v2_0.bank.Card;

public interface Atm {
    public void insertCard(Card card);

    public void ejectCard();

    public void showBalance();

    public void addCash();

    public void withdraw();
}
