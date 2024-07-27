package game;

import java.util.Random;

public abstract class AGameLevel implements IGameLevel{

    private Game game;

    AGameLevel(Game game){
        this.game = game;

    }
    public void play() {
        Random random = new Random();
        addPoints(random.nextInt(7));
        System.out.println("points="+this.game.getTotalPoints()+" level="+this.game.getCurrentLevel().getLevel());
    }

}
