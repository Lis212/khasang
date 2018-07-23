package atm.v2_0.atm;

import atm.v2_0.Monitor;
import atm.v2_0.bank.Card;

public class SberAtm implements Atm {
    private Card currentCard;
    private Monitor monitor;

    @Override
    public void insertCard(Card card) {
        if (currentCard == null){
            currentCard = card;
        } else {
            monitor.showMsg("Sorry, card in atm");
        }
    }

    @Override
    public void ejectCard() {
        currentCard = null;
    }

    @Override
    public void showBalance() {

    }

    @Override
    public void addCash() {

    }

    @Override
    public void withdraw() {

    }
}
