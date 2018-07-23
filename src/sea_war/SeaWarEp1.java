package sea_war;

import java.util.Scanner;

/**
 * Created by Администратор on 06.01.2018.
 */
public class SeaWarEp1 {
    final static int SIZE = 20;

    public static void main(String[] args) {
        System.out.println("Начинаем игру!");
        doGame();
        System.out.println("Игра окончена!");
    }

    static void doGame() {
        char[] field = new char[SIZE];//поле с расстановкой кораблей
        char[] fieldGame = new char[SIZE];//поле, видимое для игрока

        for (int i = 0; i < field.length; i++) {
            field[i] = '.';
            fieldGame[i] = '.';
        }
        int first = (int)(Math.random() * 8);
        field[first] = 'X';
        int second = 8 + (int)(Math.random() * 9);
        for (int i = second; i < second + 3; i++) {
            field[i] = 'X';
        }
//        System.out.println(field);
        System.out.println(fieldGame);

        Scanner sc = new Scanner(System.in);
        int count = 0;//счетчик попыток
        int shoot = 0;//координата выстрела
        do {
            while (true) {
                if (sc.hasNextInt()){
                    shoot = sc.nextInt();
                    //проверка на выход за границы поля
                    if (shoot >= field.length){
                        continue;
                    }
                    count++;
                    break;
                }
                else {
                    sc.nextLine();
                }
            }
            System.out.println("Попытка: " + count);
            System.out.println("Ваш выстрел: " + shoot);
            switch (field[shoot]){
                case '.':
                    System.out.println("Промах");
                    field[shoot] = '*';
                    fieldGame[shoot] = '*';
                    System.out.println(fieldGame);
                    break;
                case 'X':
                    System.out.println("Потопил");
                    field[shoot] = '#';
                    fieldGame[shoot] = '#';
                    System.out.println(fieldGame);
                    break;
                case '*':
                    System.out.println("Вы уже стреляли сюда");
                    System.out.println(fieldGame);
                    break;
            }
        }
        while (field[first] == 'X' || field[second] == 'X' || field[second + 1] == 'X');
    }


}
