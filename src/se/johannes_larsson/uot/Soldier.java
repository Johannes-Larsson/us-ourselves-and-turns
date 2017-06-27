package se.johannes_larsson.uot;

import processing.core.PVector;

public class Soldier extends GameObject {

	/** position on grid **/
	private int x, y;
	
	/** which player this belongs to */
	private Player player;
	
	public Soldier(int x, int y, Player player, Scene scene) {
		super(new PVector(x, y).mult(Game.GRIDSIZE), new PVector(Game.GRIDSIZE, Game.GRIDSIZE), player.getColor(), scene);
		this.x = x;
		this.y = y;
		this.player = player;
		player.addSoldier(this);
	}
	
	
	
	public void draw(Game g) {
		position.set(x, y).add(0.5f, 0.5f).mult(g.GRIDSIZE);
		super.draw(g);
	}
	
	private boolean isMyTurn(Game g) {
		return ((GameScene)getScene()).getPlayersTurn() == player && player.getSoldiersTurn() == this;
	}
}
