package sea_war_v1_0.pack1;

import sea_war_v1_0.pack2.Output;

/**
 * Created by Администратор on 15.01.2018.
 */
/*Время между ходами находится в Game.battle()
* Насчет интерфейса или абстрактного метода для полной замены вывода в консоль - я не понял как реализовать.
* Если интерфейс один со всеми методами,
* то придется в каждом реализующем классе писать дополнительные ненужные методы, согласно контракту*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру \"Морской бой: Версия 1.0\"!");
        Output output = Game.getInstance();
        Game game = Game.getInstance();
        game.init();
        output.printModeSelection();
        game.start();
    }
}
