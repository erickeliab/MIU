package game;

import java.util.Random;

public class Level2_5 extends AGameLevel{

    private Game game;


    public final int level = 2_5;

    Level2_5(Game game){
        super(game);
        this.game = game;

    }


    public void addPoints(int newPoints) {
        game.setTotalPoints(game.getTotalPoints() + 2 * newPoints);

        if (game.getTotalPoints() > 20) {

            game.setLevel(new LevelThree(game));
            game.setTotalPoints(game.getTotalPoints() + 2);


        }

    }

    @Override
    public int getLevel() {
        return this.level;
    }


}
