import java.util.Arrays;
import java.util.Scanner;

public class MagicField {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stop = null;
        char[] wordGame = {'k', 'h', 'a', 's', 'a', 'n', 'g'};
        char[] wordGuest = new char[wordGame.length];

        for (int i = 0; i < wordGuest.length; i++) {
            wordGuest[i] = '*';
        }

        System.out.println("Начинаем игру");
        System.out.printf("Отгадайте слово из %d букв. \n", wordGuest.length);

        while (!Arrays.equals(wordGame, wordGuest)) {
            System.out.println(wordGuest);
            System.out.println("Напишите букву или введите \"0\" для выхода.");
            stop = sc.nextLine();
            if (stop.equalsIgnoreCase("0")) {
                break;
            }
            char userLetter = stop.charAt(0);
            for (int i = 0; i < wordGame.length; i++) {
                if (userLetter == wordGame[i]) {
                    wordGuest[i] = userLetter;
                }
            }
        }
        if (Arrays.equals(wordGame, wordGuest)) {
            System.out.print("Игра окончена. Вы отгадали слово ");
            System.out.print(wordGuest);
        }
        else {
            System.out.println("Вы не отгадали слово.");
        }
    }
}
