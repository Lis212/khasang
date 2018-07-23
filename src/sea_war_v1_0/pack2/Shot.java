package sea_war_v1_0.pack2;

import sea_war_v1_0.pack1.Player;
import sea_war_v1_0.pack1.ShotStrategy;

import java.util.Random;

public class Shot implements ShotStrategy {
    Random random = new Random();

    @Override
    public StatusFight shoot(Player player) {
        player.target = new Target();
        target(player.target);
        int tmp = player.fire(player.target.getX(), player.target.getY());
        if (tmp == 1){
            player.setShotStrategy(new Wound());
            System.out.println("Popal in Shot");
            return StatusFight.WOUND;
        } else {
            return StatusFight.MISS;
        }
    }

    private void target(Target target){
        target.setX(1 + random.nextInt(10));
        target.setY(1 + random.nextInt(10));
    }
}
