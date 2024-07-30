package game;
import java.util.Random;

public class Game {
	private int totalPoints = 0;
	private ILevel level;

	public void play() {
		Random random = new Random();
		addPoints(random.nextInt(7));
		System.out.println("points="+totalPoints+" level="+level.getLevel());
	}
	
	public int getTotalPoints() {
		return totalPoints;
	}

	public void setLevel(ILevel level) {
		this.level = level;
	}

	public int addPoints(int newPoints) {
	    totalPoints = totalPoints + level.computePoints(this, newPoints);
		return totalPoints;

	}
}
