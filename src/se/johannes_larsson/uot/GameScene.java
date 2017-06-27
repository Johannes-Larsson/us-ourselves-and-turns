package se.johannes_larsson.uot;

public class GameScene extends Scene {	
	
	private Player[] players;
	
	/** which turn the game is on */
	private int turn;
	
	public GameScene() {
		super();
	}
	
	public void update(Game g) {
		
		
		super.update(g);
	}
	

	/** returns the player who's turn it is */
	public Player getPlayersTurn() {
		return players[turn % players.length];
	}
	
	public void draw(Game g) {
		g.backgroundColor = 0xff131113;
		
		for (int x = 0; x < g.width; x += g.GRIDSIZE) {
			g.line(x, 0, x, g.height);
		}
		for (int y = 0; y < g.width; y += g.GRIDSIZE) {
			g.line(0, y, g.width, y);
		}
		
		super.draw(g);
	}
}
