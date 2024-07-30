package game;

public class Level2_5 implements ILevel{


	public int computePoints(Game game,int newPoints) {
		int totalPoints = game.getTotalPoints();
		totalPoints = totalPoints + newPoints*2;
		if (totalPoints> 20){
			game.setLevel(new Level3());
			totalPoints = totalPoints + 2;//add 2 bonus point
		}
		return totalPoints;
	}

	public String getLevel(){
		return "level 2_5";
	}
}
