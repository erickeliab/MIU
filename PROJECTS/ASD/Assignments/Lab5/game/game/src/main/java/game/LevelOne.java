package game;


public class LevelOne extends AGameLevel{

    private Game game;


    public final int level = 1;

    LevelOne(Game game){
        super(game);
        this.game = game;

    }

    public void addPoints(int newPoints) {
            game.setTotalPoints(game.getTotalPoints() + newPoints);

            if (game.getTotalPoints() > 10) {
                game.setLevel(new LevelTwo(game));
                game.setTotalPoints(game.getTotalPoints() + 1);

            }

    }

    @Override
    public int getLevel() {
        return this.level;
    }

}
