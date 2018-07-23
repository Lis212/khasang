import java.util.Arrays;
import java.util.Scanner;

public class MagicFieldNew {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int player = 1;
        while (true) {
            System.out.printf("%d игрок вводит слово. \n", player);
            char[] wordGame = sc.nextLine().toCharArray();
            game(wordGame);
            player = (player == 1) ? 2 : 1;
        }


    }
    static void game(char[] wordGame){
        Scanner sc = new Scanner(System.in);
        String stop = null;
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
            System.out.println(wordGuest);
        }
        else {
            System.out.println("Вы не отгадали слово.");
        }
    }
}
