package cats;

/**
 * Created by Администратор on 08.01.2018.
 */
public class Cat {
    static int count;
    static int bowl = 100;
    static int plate = 100;
    String name;
    int id; //id кошки
    int eaten; //съедено
    int drunk; //съедено

    Cat(){
        count++;
        id = count;
    }

    Cat(String name){
        this();
        this.name = name;
    }

    void eat(int quantity){ //ест
        System.out.println(name +  " съела " + quantity);
        plate = plate - quantity;
        eaten += quantity;
        System.out.println("В тарелке осталось " + plate);
    }

    void eatFromPlate(int quantity){ //ест из отдельной тарелки
        if (quantity == 0){
            System.out.println("Кошка " + name + " не поела, еды нет");
        }
        else {
            System.out.println(name + " съела " + quantity);
            eaten += quantity;
        }
    }

    void drink(int quantity){ //пьет
        System.out.println(name +  " выпила " + quantity);
        bowl = bowl - quantity;
        drunk += quantity;
        System.out.println("В миске осталось " + bowl);
    }

    void drinkFromBowl(int quantity){ //пьет из отдельной миски
        if (quantity == 0){
            System.out.println("Кошка " + name + " не попила, воды нет");
        }
        else {
            System.out.println(name + " выпила " + quantity);
            drunk += quantity;
        }
    }

    void drunk(){ //выпито
        System.out.println("Кошка " + name + " выпила всего: " + drunk);
    }

    void eaten(){ //съедено
        System.out.println("Кошка " + name + " съела всего: " + eaten);
    }
}
