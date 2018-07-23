package sea_war_v1_0.pack1;



import sea_war_v1_0.pack2.Output;
import sea_war_v1_0.pack2.Shot;
import sea_war_v1_0.pack2.StatusFight;
import sea_war_v1_0.pack2.Wound;

import java.util.Scanner;

/**
 * Created by Администратор on 15.01.2018.
 */
public class Game implements Output {
    static Game instance;
    Player player1;
    Player player2;
    private GameField gameField;
    private int mode;

    public static Game getInstance() {
        if (instance == null){
            instance = new Game();
        }
        return instance;
    }

    private Game(){

    }

    void battle2(Player player1, Player player2){
        StatusFight statusFight = StatusFight.SHOT;
        while (true){
            player1.setShotStrategy(new Shot());
            switch (statusFight){
                case SHOT:
                    player1.shotStrategy.shoot(player2);
                    break;
                case WOUND:
                    player1.setShotStrategy(new Wound());
                    break;
                case MISS:
                    changePlayer(player1, player2);
                    break;
                case KILL:
                    changePlayer(player1, player2);
                    break;
            }
            break;
        }
    }

    private void changePlayer(Player player1, Player player2) {
        Player tmp = player1;
        player1 = player2;
        player2 = tmp;
    }

    void start(){
//        printModeSelection();
        mode = modeSelection(); //дальше выбор игры
        switch (mode){
            case 1:
                System.out.println("EVE");
                gameField.printField();
                gameEVE();
                break;
            case 2:
                System.out.println("PVE");
                gamePVE();
                break;
            case 3:
                System.out.println("PVP");
                gamePVP();
                break;
        }

    }

    private void gameEVE() {
        Scanner scanner = new Scanner(System.in);
        player1 = modeLocation(scanner);
        printSetNameGamer();
        player1.setName(scanner.nextLine());
        player1.gameFieldPlayer.printField();
        player2 = modeLocation(scanner);
        printSetNameGamer();
        player2.setName(scanner.nextLine());
        player2.gameFieldPlayer.printField();
//        battle();
        battle2(player1, player2);
        player1.gameFieldPlayer.printField();
        player2.gameFieldPlayer.printField();
    }

    private Player modeLocation(Scanner scanner) {
        Player player = null;
        System.out.println("Выберите режим установки кораблей");
        System.out.println("1. Автоматическая");
        System.out.println("2. Ручная");
        mode = scanner.nextInt();
        scanner.nextLine();
        switch (mode){
            case 1:
                System.out.println("Auto");
                player = new Player(1);
                break;
            case 2:
                System.out.println("Manual");
                player = new Player(2);
                break;
        }
        return player;
    }

    //бой кораблей в автоматическом режиме
    private void battle() {
        int i = 0;
        int i2 = 0;
        int x;
        int y;
        int selector = 0;
        int result = 0;
        while (i < gameField.getMAXDECK() || i2 < gameField.getMAXDECK()){
            if (selector == 0){
                x = 1 + (int) (Math.random() * (player2.gameFieldPlayer.getSIZEX() - 1));
                y = 1 + (int) (Math.random() * (player2.gameFieldPlayer.getSIZEY() - 1));
                result = player2.fire(x, y);
                if (result == 1) {
                    i += result;
                    selector = 0;
                } else {
                    selector = 1;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (selector == 1){
                x = 1 + (int) (Math.random() * (player1.gameFieldPlayer.getSIZEX() - 1));
                y = 1 + (int) (Math.random() * (player1.gameFieldPlayer.getSIZEY() - 1));
                result = player1.fire(x, y);
                if (result == 1) {
                    i2 += result;
                    selector = 1;
                } else {
                    selector = 0;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (i == gameField.getMAXDECK()){
            System.out.println("Адмирал " + player1.name + " выиграл сражение!");
            System.out.println("Поле поверженного игрока " + player2.name);
            player2.gameFieldPlayer.printField();
        } else if (i2 == gameField.getMAXDECK()){
            System.out.println("Адмирал " + player2.name + " выиграл сражение!");
            System.out.println("Поле поверженного игрока " + player1.name);
            player1.gameFieldPlayer.printField();
        }
    }

    private void gamePVE() {

    }

    private void gamePVP() {

    }

    private int modeSelection() {
        Scanner sc = new Scanner(System.in);
        mode = 1; //default mode
        while (true){
            if (sc.hasNextInt()){
                mode = sc.nextInt();
                if (mode < 1 && mode > 3) {
                    continue;
                }
                break;
            } else {
                sc.nextLine();
            }
        }
        return mode;
    }

    public void init() {
        gameField = new GameField();
        gameField.printPicture();
    }

    @Override
    public void printModeSelection() {
        System.out.println("Выберите режим игры:");
        System.out.println("1. EVE: игра компьютера против компьютера");
        System.out.println("2. PVE: игра человека против компьютера");
        System.out.println("3. PVP: игра между людьми");
    }

    @Override
    public void printChoiseModeSelection(int mode) {
        switch (mode){
            case 1:
                System.out.println("EVE");
                break;
            case 2:
                System.out.println("PVE");
                break;
            case 3:
                System.out.println("PVP");
                break;
        }
    }

    @Override
    public void printSetNameGamer() {
        System.out.println("Введите имя игрока");
    }

    @Override
    public void printPicture() {

    }

    @Override
    public void printField() {

    }
}
