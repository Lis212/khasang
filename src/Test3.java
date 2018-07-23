import java.util.Scanner;

/**
 * Created by Администратор on 04.01.2018.
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = sc.nextInt();
        System.out.println("Введите второе число");
        int b = sc.nextInt();
        if ((a < 0 && b >= 0) || (b < 0 && a >= 0)){
            System.out.println(a * b);
        }
        else if (a > b){
            System.out.println(a - b);
        }
        else if (a < 0 && b < 0){
            System.out.println(a + b);
        }
        else {
            System.out.println(a % b);
        }
    }
}
