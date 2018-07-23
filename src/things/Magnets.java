package things;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Администратор on 14.01.2018.
 */
public class Magnets {
    ArrayList<Magnet> magnets;

    Magnets(){
        magnets = new ArrayList<Magnet>();
    }

    void addMagnets(Magnet magnet){
        magnets.add(magnet);
    }

    void showMagnets(){
        for (Magnet magnet : magnets) {
            System.out.println(magnet);
        }
    }
    //поиск магнитов
    void searchMagnet() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите страну, откуда привезен магнит");
        String searchOrigin = null;
        while (sc.hasNext()){
            searchOrigin = sc.nextLine();
            if (searchOrigin.isEmpty() && isNumber(searchOrigin))
            {
                continue;
            } else {
                break;
            }
        }
        for (Magnet magnet : magnets) {
            if (magnet.getOrigin().toLowerCase().contains(searchOrigin.toLowerCase())){
                System.out.println(magnet.toString());
            }
        }
    }

    //вспомогательный метод для сравнения строк
    boolean isNumber(String str){
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
