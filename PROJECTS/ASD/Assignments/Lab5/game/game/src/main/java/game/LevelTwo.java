package game;


public class LevelTwo extends AGameLevel{

    private Game game;


    public final int level = 2;

    LevelTwo(Game game){
        super(game);
        this.game = game;

    }


    public void addPoints(int newPoints) {
        game.setTotalPoints(game.getTotalPoints() + 2 * newPoints);

        if (game.getTotalPoints() > 15) { // move to level 2

            game.setLevel(new Level2_5(game));
            game.setTotalPoints(game.getTotalPoints() + 1);

        }

    }

    @Override
    public int getLevel() {
        return this.level;
    }


}
