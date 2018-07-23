package horserace;

/**
 * Created by Администратор on 07.01.2018.
 */
public class Racecourse { //ипподром
    final static int member = 10;
    static Horse[] horses;

    public static void corral(){
        horses = new Horse[member];
        for (int i = 0; i < horses.length; i++) {
            horses[i] = new Horse(i);
        }
    }



}
