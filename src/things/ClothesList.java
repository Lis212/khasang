package things;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Администратор on 14.01.2018.
 */
public class ClothesList {
    ArrayList<Clothes> clothesList;

    ClothesList(){
        clothesList = new ArrayList<Clothes>();
    }

    void addClothesList(Clothes clothes){
        clothesList.add(clothes);
    }
    void showClothes(){
        for (Clothes clothes : clothesList) {
            System.out.println(clothes);
        }
    }
    //поиск одежды
    void searchClothes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер");
        int size = 0;
        while (sc.hasNext()){
            size = sc.nextInt();
            if (size < 0)
            {
                continue;
            } else {
                sc.nextLine();
                break;
            }
        }
        for (Clothes clothes : clothesList) {
            if (clothes.getSize() == size){
                System.out.println(clothes.toString());
            }
        }
    }
}
