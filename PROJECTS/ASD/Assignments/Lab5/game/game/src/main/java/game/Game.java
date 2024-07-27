package game;

import java.util.Random;

public class Game {
	private int totalPoints = 0;

	private IGameLevel currentLevel;

	public void setLevel(IGameLevel lvl){
		this.currentLevel = lvl;
	}

	public IGameLevel getCurrentLevel(){
		return this.currentLevel;
	}


	public void play() {
		currentLevel.play();
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}


}
