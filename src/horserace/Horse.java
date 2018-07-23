package horserace;

/**
 * Created by Администратор on 07.01.2018.
 */
public class Horse { //лошадь
    String name;
    int weight; //400-450 вес
    int speed;//13-17 скорость м/с
    int speedIndex;
    int distance;//расстояние
    String[] names = {"Сухарь", "Секретариат", "Резвая", "Барбаро", "Милл Риф", "Эклипс", "Фар Лэп",
            "Зеньятта", "Абсент", "Анилин"};

    Horse(){

    }

    Horse(int position){
        this.name = names[position];
        this.weight = 400 + (int)(Math.random() * 50);
        this.speed = 13 + (int)(Math.random() * 4);
        this.speedIndex = weight / speed;
        this.distance = 0;
    }

}
