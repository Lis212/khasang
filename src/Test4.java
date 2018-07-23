/**
 * Created by Администратор on 16.01.2018.
 */
public class Test4 {
    public static void main(String[] args) {

        mass();
    }

    static void arr(){

    }

    static void mass(){
            char[][] field = new char[11][11];
            System.out.println(field.length);
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
                    System.out.print(chars[j] + " ");
                }
            }

            for (int i = 1; i < field.length - 1; i++) {
                char[] chars = field[i];
                System.out.println();
                for (int j = 0; j < chars.length; j++) {
                    if (j == 0){
                        chars[j] = (char) ('0' + i);
                    } else {
                        chars[j] = '0';
                    }
                    System.out.print(chars[j] + " ");
                }
            }
            for (int i = 10; i < field.length; i++) {
                char[] chars = field[i];
                System.out.println();
                for (int j = 0; j < chars.length; j++) {
                    if (j == 0){
                        chars[j] = '1';
                    } else {
                        chars[j] = '0';
                    }
                    System.out.print(chars[j] + " ");
                }
            }
            System.out.println("----------------------------------");
            field[5][3] = 'S';
        System.out.println(field.length);
            for (int i = 0; i < field.length; i++) {
                char[] chars = field[i];
                System.out.println();
                for (int j = 0; j < chars.length; j++) {
                    System.out.print(chars[j] + " ");

                }
            }
        }
    }

