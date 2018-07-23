package cats;

/**
 * Created by Администратор on 08.01.2018.
 */
public class Bowl {
    int bowl;

    Bowl(){
        bowl = 100;
    }

    int drunk(int quantity){ //пить
        if (bowl > 0 && quantity < bowl) {
            bowl = bowl - quantity;
            return quantity;
        }
        else {
            System.out.println("Вода закончилась!");
            quantity = quantity - (quantity - bowl);
            bowl = 0;
            return quantity;
        }
    }

    void balance(){ //остаток воды
        System.out.println("В миске осталось: " + bowl);
    }
}
