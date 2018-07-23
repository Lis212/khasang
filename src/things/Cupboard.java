package things;

import java.util.ArrayList;


/**
 * Created by Администратор on 10.01.2018.
 */
public class Cupboard {
    public static void main(String[] args) {
//        ArrayList<Thing> things = new ArrayList<>();
//        Thing thing = new Thing();
        Things things = new Things();
        while (!things.getGameOver()) {
            things.start();
        }
    }
}
