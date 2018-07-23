package sea_war_v1_0.pack1;

import sea_war_v1_0.pack1.GameField;

import java.util.Random;

/**
 * Created by Администратор on 15.01.2018.
 */
public class Ship {
    private int deck;
    private int x;
    private int y;
    private Random random;

    public Ship() {
    }

    public Ship(int deck, int x, int y) {

        this.deck = deck;
        this.x = x;
        this.y = y;
    }

    public int getDeck() {
        return deck;
    }

    public void setDeck(int deck) {
        this.deck = deck;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 1 && x > GameField.SIZEX){
            System.out.println("Error - the coordinate went beyond the field");
        } else {
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 1 && y > GameField.SIZEX){
            System.out.println("Error - the coordinate went beyond the field");
        } else {
            this.y = y;
        }
    }

    void autoX(){
        random = new Random();
        setX(1 + random.nextInt(10));
//        setX((int) (1 + Math.random() * 10));
    }

    void autoY() {
        setY((int)(1 + Math.random() * 10));
    }
}
