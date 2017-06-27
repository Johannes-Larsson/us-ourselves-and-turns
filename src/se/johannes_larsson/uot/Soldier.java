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
			g.ellipse(position.x, position.y, Game.GRIDSIZE * 1.5f, Game.GRIDSIZE * 1.5f);
		}
		super.draw(g);
	}
}
