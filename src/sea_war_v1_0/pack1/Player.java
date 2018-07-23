package sea_war_v1_0.pack1;

import sea_war_v1_0.pack2.Target;

import java.util.ArrayList;

/**
 * Created by Администратор on 15.01.2018.
 */
public class Player {
    ShotStrategy shotStrategy;
    String name;
    public Target target;
    boolean isMan; //true - человек, false - компьютер
    GameField gameFieldPlayer;
    ShipFactory shipFactory;
    ArrayList<Ship> ships;
    public void setName(String name) {
        this.name = name;
    }

    Player(int mode){
        if (mode == 1) {
            autoInit();
        } else {
            manualInit();
        }
    }

    public void setShotStrategy(ShotStrategy shotStrategy) {
        this.shotStrategy = shotStrategy;
    }

    private void manualInit() {
        System.out.println("В разработке");
    }

    private void autoInit(){
        gameFieldPlayer = new GameField();
        shipFactory = new ShipFactory();
        ships = new ArrayList<Ship>(10);
        ships.add(shipFactory.createShip(4));
        gameFieldPlayer.autoLocation(ships.get(0));
        ships.add(shipFactory.createShip(3));
        gameFieldPlayer.autoLocation(ships.get(1));
        ships.add(shipFactory.createShip(3));
        gameFieldPlayer.autoLocation(ships.get(2));
        ships.add(shipFactory.createShip(2));
        gameFieldPlayer.autoLocation(ships.get(3));
        ships.add(shipFactory.createShip(2));
        gameFieldPlayer.autoLocation(ships.get(4));
        ships.add(shipFactory.createShip(2));
        gameFieldPlayer.autoLocation(ships.get(5));
        ships.add(shipFactory.createShip(1));
        gameFieldPlayer.autoLocation(ships.get(6));
        ships.add(shipFactory.createShip(1));
        gameFieldPlayer.autoLocation(ships.get(7));
        ships.add(shipFactory.createShip(1));
        gameFieldPlayer.autoLocation(ships.get(8));
        ships.add(shipFactory.createShip(1));
        gameFieldPlayer.autoLocation(ships.get(9));
    }


     public int fire(int x, int y){
         int result = 0;
         System.out.println(name + " выстрелил");
         if (gameFieldPlayer.field[y][x] == '*'){
             System.out.println("Акелла промахнулся...");
             gameFieldPlayer.field[y][x] = '-';
             result = 0;
         } else if (gameFieldPlayer.field[y][x] == 'H'){
             System.out.println(name + " разрушил вражеское судно");
             gameFieldPlayer.field[y][x] = 'X';
             result = 1;
         } else if (gameFieldPlayer.field[y][x] == 'X'){
             System.out.println("Опять на те же грабли...");
             result = 0;
         }
         else if (gameFieldPlayer.field[y][x] == '-'){
             System.out.println("Опять на те же грабли...");
             result = 0;
         }
         return result;
    }
}
