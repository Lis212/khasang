package cats;

/**
 * Created by Администратор on 08.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        Cat masha = new Cat("Masha");
        System.out.println(masha.id);
        Cat murka = new Cat("Murka");
        System.out.println(murka.id);
        Cat cat = new Cat();
        System.out.println(cat.id);


        Bowl bowl = new Bowl();
        masha.drinkFromBowl(bowl.drunk(15));
        masha.drinkFromBowl(bowl.drunk(65));
        masha.drunk();
        masha.drinkFromBowl(bowl.drunk(46));
        murka.drinkFromBowl(bowl.drunk(20));
        masha.drinkFromBowl(bowl.drunk(46));
        masha.drunk();
        murka.drunk();
        bowl.balance();

        Plate plate = new Plate();
        masha.eatFromPlate(plate.eat(15));
        masha.eatFromPlate(plate.eat(78));
        masha.eaten();
        murka.eatFromPlate(plate.eat(38));
        murka.eatFromPlate(plate.eat(15));
        masha.eatFromPlate(plate.eat(15));
        masha.eaten();
        murka.eaten();
        plate.balance();
    }
}
