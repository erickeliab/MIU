package game;

public class Level2 implements ILevel{


	public int computePoints(Game game,int newPoints) {
		int totalPoints = game.getTotalPoints();
		totalPoints = totalPoints + newPoints*2;
		if (totalPoints> 15){
			game.setLevel(new Level2_5());
			totalPoints = totalPoints + 1;//add 1 bonus point
		}
		return totalPoints;
	}

	public String getLevel(){
		return "level 2";
	}
}
