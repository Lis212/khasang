package sea_war_v1_0.pack2;

import sea_war_v1_0.pack1.Player;
import sea_war_v1_0.pack1.ShotStrategy;
import sea_war_v1_0.pack2.StatusFight;

public class Wound implements ShotStrategy {
    @Override
    public StatusFight shoot(Player player) {
        StatusFight statusFight = StatusFight.WOUND;
        int x = player.target.getX();
        int y = player.target.getY();
        while (statusFight != StatusFight.KILL){
            int tmp = player.fire(x, y);
            if (tmp == 1){
                System.out.println("Popal in Wound");
                statusFight = StatusFight.WOUND;
                break;
            } else {
                System.out.println("Promah");
                statusFight = StatusFight.MISS;
                break;
            }
        }
        return statusFight;
    }
}
