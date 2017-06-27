package se.johannes_larsson.uot;

public class GameScene extends Scene {	
	
	private Player[] players;
	
	/** which turn the game is on */
	private int turn;
	
	/** which round the game is on **/
	private int round;
	
	/** which move this round is on*/
	private int move;
	
	public GameScene() {
		super();
		
		players = new Player[] {
				new Player("red", 0xffff0000, 1, 1, this),
				new Player("blue", 0xff0000ff, 18, 13, this)
		};
	}
	
	public void onResume(Game g) {
		g.backgroundColor = 0xff333344;
	}
	
	public void update(Game g) {
		if (getPlayersTurn().executeTurn()) {
			move ++;
		}
		if (allPlayersDone()) {
			nextTurn();
		}
		
		super.update(g);
	}

	/**
	 * 
	 * @return whether all players are done with this turn
	 */
	private boolean allPlayersDone() {
		for (Player p : players) {
			if (p.getSoldiersTurn(turn) != null) return false;
		}
		return true;
	}

	/** returns the player who's turn it is */
	public Player getPlayersTurn() {
		return players[move % players.length];
	}
	
	/** called when a turn ends. 
	 * moves soldiers for next turn.
	 * advances turn and player counter. */
	public void nextTurn() {
		// move soldiers
		for (Player p : players) {
			p.nextTurn(turn);
		}
		
		turn++;
		move = 0;
	}
	
	public void draw(Game g) {
		g.stroke(0);
		for (int x = 0; x <= g.width; x += Game.GRIDSIZE) {
			g.line(x, 0, x, g.height);
		}
		for (int y = 0; y <= g.width; y += Game.GRIDSIZE) {
			g.line(0, y, g.width, y);
		}
		
		int x = g.mouseX / Game.GRIDSIZE;
		int y = g.mouseY / Game.GRIDSIZE; 
		g.fill(255);
		g.rect(x * Game.GRIDSIZE, y * Game.GRIDSIZE, Game.GRIDSIZE, Game.GRIDSIZE);
		
		
		super.draw(g);
		
		for (int i = 0; i < players.length; i++) {
			players[i].drawNumSoldiers(g, g.width - 100, 100 + i * 15);
		}
		
		g.fill(255);
		g.text("turn " + turn + "\nround " + round + "\nmove " + move, 10, 10);
		g.fill(getPlayersTurn().getColor());
		g.text("player " + getPlayersTurn().getName() + "s turn", 100, 10);
	}

	public int getMove() {
		return move;
	}
}
