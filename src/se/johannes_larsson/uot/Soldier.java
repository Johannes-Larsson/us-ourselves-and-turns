package se.johannes_larsson.uot;

import java.util.ArrayList;

import processing.core.PVector;

public class Soldier extends GameObject {

	/** position on grid **/
	private int x, y;
	
	/** which player this belongs to */
	private Player player;
	
	/** a list of moves performed by this soldier; one for each turn it has lived. */
	private ArrayList<Move> moves;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param player
	 * the soldier is added automatically to this player!
	 * @param scene
	 */
	public Soldier(int x, int y, Player player, Scene scene) {
		super(new PVector(x, y).mult(Game.GRIDSIZE), new PVector(Game.GRIDSIZE, Game.GRIDSIZE), player.getColor(), scene);
		this.x = x;
		this.y = y;
		this.player = player;
		moves = new ArrayList<Move>();
		player.addSoldier(this);
	}
	
	public boolean hasMove(int turn) {
		return moves.size() > turn;
	}
	
	public void draw(Game g) {
		position.set(x, y).add(0.5f, 0.5f).mult(Game.GRIDSIZE);
		if (player.isSoldiersTurn(this, ((GameScene)getScene()).getMove())) {
			g.fill(200);
			g.ellipse(position.x, position.y, Game.GRIDSIZE * 1.5f, Game.GRIDSIZE * 1.5f);
		}
		super.draw(g);
	}

	/** draws movement options. called by GameScene when its this soldiers turn to move
	 * 
	 * @param g the game
	 * @param x2 mouse tile x
	 * @param y2 mouse tile y
	 */
	public void drawMove(Game g, int x2, int y2) {
		int n = Game.abs(x2 - x) + Game.abs(y2 - y);
		if (n == 1) {
			g.fill(0, 255, 0);
			g.rect(x2 * Game.GRIDSIZE, y2 * Game.GRIDSIZE, Game.GRIDSIZE, Game.GRIDSIZE);
		} else if (n == 0) {
			g.fill(0);
		} else {
			g.fill(255, 255, 0);
			g.ellipse((x2 + .5f) * Game.GRIDSIZE, (y2 + .5f) * Game.GRIDSIZE, Game.GRIDSIZE, Game.GRIDSIZE);
		}
		
		
	}
}
