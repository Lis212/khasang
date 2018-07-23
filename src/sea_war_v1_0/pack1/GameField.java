package sea_war_v1_0.pack1;


import sea_war_v1_0.pack2.Output;

/**
 * Created by Администратор on 15.01.2018.
 */
public class GameField implements Output {
    char[][] field;
    public static final int SIZEX = 11;
    public static final int SIZEY = 11;
    private final int MAXDECK = 20; //общее число палуб на всех кораблях на поле
    private int selector = 0;

    GameField(){
        generateField();
    }

    public int getMAXDECK() {
        return MAXDECK;
    }

    /**
     * генерация поля
     */
    private void generateField() {
        field = new char[SIZEY][SIZEX];
        for (int i = 0; i < 1; i++) {
            char[] chars = field[i];
            for (int j = 0; j < chars.length; j++) {
                if (j == 0){
                    chars[j] = ' ';
                } else if(j == field.length - 1){
                    chars[j] = 'К';
                } else {
                    chars[j] = (char) ('Џ' + j);
                }
            }
        }

        for (int i = 1; i < field.length - 1; i++) {
            char[] chars = field[i];
            for (int j = 0; j < chars.length; j++) {
                if (j == 0){
                    chars[j] = (char) ('0' + i);
                } else {
                    chars[j] = '*';
                }
            }
        }
        for (int i = 10; i < field.length; i++) {
            char[] chars = field[i];
            System.out.println();
            for (int j = 0; j < chars.length; j++) {
                if (j == 0){
                    chars[j] = '1';
                } else {
                    chars[j] = '*';
                }
            }
        }
    }

    public int getSIZEX() {
        return SIZEX;
    }

    public int getSIZEY() {
        return SIZEY;
    }

    @Override
    public void printModeSelection() {

    }

    @Override
    public void printChoiseModeSelection(int mode) {

    }

    @Override
    public void printSetNameGamer() {

    }

    @Override
    public void printPicture() {
        System.out.println("________________________¶_________________________");
        System.out.println("________________________¶¶¶¶¶¶____________________");
        System.out.println("________________________¶¶¶¶¶¶______¶_____________");
        System.out.println("_______________________¶¶___________¶¶¶___________");
        System.out.println("_______________________¶¶___________¶¶¶¶¶¶¶¶¶¶____");
        System.out.println("_______________________¶¶__________¶¶¶¶¶¶¶¶¶¶_____");
        System.out.println("_______________________¶¶¶_________¶¶_____________");
        System.out.println("_____________________¶¶¶¶¶_________¶¶_____________");
        System.out.println("____________________¶¶_¶¶¶¶________¶¶¶____________");
        System.out.println("___________________¶¶__¶__¶________¶¶¶¶___________");
        System.out.println("__________________¶¶___¶__¶¶_______¶¶¶¶¶__________");
        System.out.println("_________________¶¶____¶___¶_______¶___¶__________");
        System.out.println("________________¶¶____¶¶___¶¶______¶____¶_________");
        System.out.println("_______________¶¶_____¶¶____¶_____¶¶____¶¶________");
        System.out.println("______________¶¶¶_____¶¶_____¶____¶¶_____¶¶_______");
        System.out.println("____________¶¶_¶______¶¶_____¶¶___¶¶______¶¶______");
        System.out.println("___________¶¶__¶_____¶¶¶______¶¶__¶¶_______¶¶_____");
        System.out.println("_________¶¶¶__¶¶_____¶¶_______¶¶__¶¶_________¶¶___");
        System.out.println("________¶¶____¶¶_____¶¶_______¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
        System.out.println("_______¶______¶¶_____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶______");
        System.out.println("_____¶¶¶______¶¶_____¶¶¶__¶¶¶¶¶¶¶_¶¶_¶¶¶__________");
        System.out.println("¶¶¶¶¶¶¶¶¶¶¶___¶¶_¶¶¶¶¶¶_¶¶¶_¶¶_¶¶_¶¶¶¶¶¶_______¶__");
        System.out.println("___¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_");
        System.out.println("_________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶___");
        System.out.println("___________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶_¶¶¶¶___");
        System.out.println("_____________¶¶¶¶¶¶_______________________________");
    }

    public void printField(){
        for (int y = 0; y < field.length; y++) {
            char[] chars = field[y];
            System.out.println();
            for (int x = 0; x < chars.length; x++) {
                System.out.print(chars[x] + " ");
            }
        }
        System.out.println();
    }

    // автоматическая расстановка кораблей
    void autoLocation(Ship ship){
        int i = 0;
        boolean previous = false;
        while (i < ship.getDeck())
        {
            if (i == 0){
                previous = previously(ship, selector);
            }
            if (selector == 0) {
                if ((ship.getX() + ship.getDeck()) <= SIZEX && (ship.getY() + ship.getDeck()) <= SIZEY
                        && previous){
                    field[ship.getY() + i][ship.getX()] = 'H';
                    i++;
                } else {
                    ship.autoX();
                    ship.autoY();
                    i = 0;
                }
            } else if (selector == 1){
                if ((ship.getX() + ship.getDeck()) <= SIZEX && (ship.getY() + ship.getDeck()) <= SIZEY
                        && previous) {
                    field[ship.getY()][ship.getX() + i] = 'H';
                    i++;
                } else {
                    ship.autoX();
                    ship.autoY();
                    i = 0;
                }
            }
        }
        selector();
}

    //предварительная установка корабля для понимания - будет ли он мешать другим или нет
    boolean previously(Ship ship, int selector){
        int i = 0;
        boolean result = false;
        //дубликат поля игрока для расставления кораблей
        char[][] temp = new char[field.length][];
        for (int j = 0; j < field.length; j++) {
            temp[j] = new char[field.length];
            for (int k = 0; k < field.length; k++) {
                char a = field[j][k];
                temp[j][k] = a;
            }
        }
        while (i < ship.getDeck()) {
            if (ship.getX() + i + 1 < SIZEX && ship.getY() + i + 1 < SIZEY) {
                if (selector == 0 && (ship.getY() + ship.getDeck()) < SIZEY) {
                    temp[ship.getY() + i][ship.getX()] = 'H';
                    if (i == 0) { // проверка на промежутки между кораблями
                        if (field[ship.getY()][ship.getX()] == 'H' || field[ship.getY()][ship.getX() + 1] == 'H'
                                || field[ship.getY() + 1][ship.getX()] == 'H' || field[ship.getY()][ship.getX() - 1] == 'H'
                                || field[ship.getY() + 1][ship.getX() + 1] == 'H' || field[ship.getY() + 1][ship.getX() - 1] == 'H'
                                || field[ship.getY() - 1][ship.getX() + 1] == 'H' || field[ship.getY() - 1][ship.getX() - 1] == 'H'
                                || field[ship.getY() - 1][ship.getX()] == 'H') {
                            result = false;
                            break;
                        } else {
                            result = true;
                            i++;
                        }
                    } else {
                        if (field[ship.getY() + i][ship.getX()] == 'H' || field[ship.getY() + i][ship.getX() + 1] == 'H'
                                || field[ship.getY() + i + 1][ship.getX()] == 'H'
                                || field[ship.getY() + i][ship.getX() - 1] == 'H'
                                || field[ship.getY() + i + 1][ship.getX() + 1] == 'H'
                                || field[ship.getY() + i + 1][ship.getX() - 1] == 'H') {
                            result = false;
                            break;
                        } else {
                            result = true;
                            i++;
                        }
                    }
                } else if (selector == 1 && (ship.getX() + ship.getDeck()) < SIZEX) {
                    temp[ship.getY()][ship.getX() + i] = 'H';
                    if (i == 0) {
                        if (field[ship.getY()][ship.getX()] == 'H' || field[ship.getY()][ship.getX() + 1] == 'H'
                                || field[ship.getY() + 1][ship.getX()] == 'H' || field[ship.getY()][ship.getX() - 1] == 'H'
                                || field[ship.getY() + 1][ship.getX() + 1] == 'H' || field[ship.getY() + 1][ship.getX() - 1] == 'H'
                                || field[ship.getY() - 1][ship.getX() + 1] == 'H' || field[ship.getY() - 1][ship.getX() - 1] == 'H'
                                || field[ship.getY() - 1][ship.getX()] == 'H') {
                            result = false;
                            break;
                        } else {
                            result = true;
                            i++;
                        }
                    } else {
                        if (field[ship.getY()][ship.getX() + i] == 'H' && field[ship.getY() + 1][ship.getX() + i] == 'H'
                                || field[ship.getY()][ship.getX() + i + 1] == 'H'
                                || field[ship.getY() - 1][ship.getX() + i] == 'H'
                                || field[ship.getY() + 1][ship.getX() + i + 1] == 'H'
                                || field[ship.getY() - 1][ship.getX() + i + 1] == 'H') {
                            result = false;
                            break;
                        } else {
                            result = true;
                            i++;
                        }
                    }
                } else {
                    result = false;
                    break;
                }
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    // переключение вертикального и горизонтального расположения
    void selector(){
        if(selector == 0){
            selector = 1;
        } else {
            selector = 0;
        }
    }
}
