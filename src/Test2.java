

/**
 * Created by Администратор on 04.01.2018.
 */
public class Test2 {
    public static void main(String[] args) {
        char[][] cells = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '*';
            }
        }
        int count = 2;
        int a;
        int b;
        while (count < 11) {
            a = 0 + (int) (Math.random() * 3);
            b = 0 + (int) (Math.random() * 3);
            System.out.printf("Введены координаты по оси X: %d, по оси Y: %d.%n", a, b);

            if (cells[a][b] == '*' && (count%2) == 0){
                cells[a][b] = 'X';
                printCells(cells);
                count++;
                if (count == 11){
                    System.out.println("Игра окончена");
                    break;
                }
                continue;
            }
            if (cells[a][b] == '*'){
                cells[a][b] = '0';
                printCells(cells);
                count++;
                if (count == 11){
                    System.out.println("Игра окончена");
                    break;
                }
                continue;
            }
            else {
                System.out.println("Повторите ход");
                count = count;
            }
        }
    }

    static void printCells(char[][] cells) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                System.out.print(cells[column][row] + " ");
            }
            System.out.println();
        }
    }
}
