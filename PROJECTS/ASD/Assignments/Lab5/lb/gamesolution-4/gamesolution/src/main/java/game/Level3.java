package game;

public class Level3 implements ILevel{


	public int computePoints(Game game, int newPoints) {
		int totalPoints = game.getTotalPoints();
		totalPoints = totalPoints + newPoints*3;
		return totalPoints;
	}

	public String getLevel(){
		return "level 3";
	}
}

