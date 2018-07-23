package horserace;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Администратор on 07.01.2018.
 */
public class Horserace {//скачки
    static int choose;
    public static void main(String[] args) throws InterruptedException{
        Racecourse.corral();
        System.out.println("Начинается забег");
        System.out.println("Лошади, участвующие в забеге:");
        for (int i = 0; i < Racecourse.horses.length; i++) {
            System.out.println((i + 1) + ". " + Racecourse.horses[i].name);
        }
        System.out.println("Введите номер лошади для ставки:");
        choose = choose();

        start();
    }

    public static int choose(){
        Scanner sc = new Scanner(System.in);
        while (true){
            if (sc.hasNextInt()){
                choose = sc.nextInt();
                if (choose >= Racecourse.member || choose <= 0){
                    System.out.println("Неправильный ввод. Повторите:");
                    continue;
                }
                break;
            }
            else {
                sc.nextLine();
                System.out.println("Неправильный ввод. Повторите:");
            }
        }
        return choose;
    }

    public static void start() throws InterruptedException {
        int trek = 1000;
        int distance = 0;
        int lap = 1;
        while (distance < trek){
            System.out.println("Начат " + lap + " круг.");
            System.out.println();
            Thread.sleep(2000);
                for (Horse horse : Racecourse.horses) {
                    horse.distance += horse.speedIndex * 6;
                    distance = horse.distance;
                    if (horse.distance >= trek){
                        System.out.println(horse.name + " победила");
                        horse.distance = trek;
                        if (choose == Arrays.asList(Racecourse.horses).indexOf(horse) - 1){
                            System.out.println("Ваша ставка выиграла");
                            System.out.println("Ваш выигрыш 1000$");
                        }
                        else {
                            System.out.println("Ваша ставка не сыграла");
                        }
                        break;
                    }
                    //ямка на треке
                    if (horse.distance == (int)(750 + Math.random() * 250)){
                        horse.distance = 0;
                        System.out.println(horse.name + " выбыла из гонки");
                    }
                }
            if (distance >= trek){
                System.out.println("Гонка окончена");
                System.out.println();
                for (Horse horse : Racecourse.horses) {
                    System.out.println(horse.name + " прошла " + horse.distance);
                }
                System.out.println();
                break;
            }
            System.out.println(lap + " круг пройден");
            System.out.println();
            for (Horse horse : Racecourse.horses) {
                System.out.println(horse.name + " прошла " + horse.distance);
            }
            System.out.println();
            lap++;
        }
    }
}
