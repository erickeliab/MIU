package game;

public class Level1 implements ILevel {

	public int computePoints(Game game, int newPoints) {
		int totalPoints = game.getTotalPoints();
		totalPoints = totalPoints + newPoints;
		if (totalPoints > 10) {
			game.setLevel(new Level2());
			totalPoints = totalPoints + 1;//add 1 bonus point
		}
		return totalPoints;
	}

	public String getLevel(){
		return "level 1";
	}
}
