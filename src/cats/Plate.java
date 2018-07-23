package cats;

/**
 * Created by Администратор on 08.01.2018.
 */
public class Plate {
    int plate;

    Plate(){
        plate = 100;
    }

    int eat(int quantity){ //ест
        if (plate > 0 && quantity < plate) {
            plate = plate - quantity;
            return quantity;
        }
        else {
            System.out.println("Еда закончилась!");
            quantity = quantity - (quantity - plate);
            plate = 0;
            return quantity;
        }
    }

    void balance(){ //остаток еды
        System.out.println("В тарелке осталось: " + plate);
    }
}
