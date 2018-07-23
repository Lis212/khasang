package sea_war_v1_0.pack1;

import sea_war_v1_0.pack1.Ship;

/**
 * Created by Администратор on 16.01.2018.
 */
public class ShipFactory {
    private final int DECK1 = 4;
    private final int DECK2 = 3;
    private final int DECK3 = 2;
    private final int DECK4 = 1;
    private Ship ship;

    Ship createShip(int deck){
        switch (deck){
            case DECK1:
                ship = new Ship();
                ship.setDeck(DECK1);
                ship.autoX();
                ship.autoY();
                break;
            case DECK2:
                ship = new Ship();
                ship.setDeck(DECK2);
                ship.autoX();
                ship.autoY();
                break;
            case DECK3:
                ship = new Ship();
                ship.setDeck(DECK3);
                ship.autoX();
                ship.autoY();
                break;
            case DECK4:
                ship = new Ship();
                ship.setDeck(DECK4);
                ship.autoX();
                ship.autoY();
                break;
        }
        return ship;
    }
}
