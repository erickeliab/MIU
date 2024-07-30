package game;

public class Application {
	public static void main(String[] args) {
		Game game = new Game();
		ILevel level1 =  new Level1();
		game.setLevel(level1);
		game.play();
		game.play();
		game.play();
		game.play();
		game.play();
	}
}
