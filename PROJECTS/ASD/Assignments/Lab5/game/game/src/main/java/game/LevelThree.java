package game;


public class LevelThree extends AGameLevel{

    private Game game;

    public final int level = 3;

    LevelThree(Game game){
        super(game);
        this.game = game;

    }

    public void addPoints(int newPoints) {

        game.setTotalPoints(game.getTotalPoints() + 3 * newPoints);


    }

    @Override
    public int getLevel() {
        return this.level;
    }


}
