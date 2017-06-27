package se.johannes_larsson.uot;

import java.util.ArrayList;

public class Player {
	GameScene scene;
	
	/** which color this players soldiers should have */
	private int color;
	
	/** where the players spawn is */
	private int spawnX, spawnY;
	
	private String name;
	
	/** all soldiers belonging to this player */
	private ArrayList<Soldier> soldiers;
	
	/**
	 * 
	 * @param turn 
	 * which turn the game is on
	 * @return 
	 * the next soldier to receive a move, or null if all have moved
	 */
	public Soldier getSoldiersTurn(int turn) {
		for (int i = 0; i < soldiers.size(); i++) {
			if (!soldiers.get(i).hasMove(turn)) return soldiers.get(i);
		}
		return null;
	}

	public Player(String name, int color, int spawnX, int spawnY, GameScene scene) {
		this.color = color;
		this.name = name;
		this.spawnX = spawnX;
		this.spawnY = spawnY;
		this.scene = scene;
		soldiers = new ArrayList<Soldier>();
	}

	public int getColor() {
		return color;
	}
	
	public void addSoldier(Soldier s) {
		soldiers.add(s);
	}
	
	public void removeSoldier(Soldier s) {
		soldiers.remove(s);
	}

	/** called on update when it's this players turn 
	 * @return whether the turn is done 
	 * */
	public boolean executeTurn() {
		return false;
	}

	/**
	 * should be called when a turn ends.
	 * TODO moves soldiers to next turn, spawn new soldier
	 */
	public void nextTurn(int turn) {
		scene.addObject(new Soldier(spawnX, spawnY, this, scene));
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param soldier
	 * @return whether it's this soldiers turn to move
	 * 
	 */
	public boolean isSoldiersTurn(Soldier soldier, int move) {
		return getSoldiersTurn(move) == soldier && scene.getPlayersTurn() == this;
	}
	
	public void drawNumSoldiers(Game g, int x, int y) {
		g.fill(color);
		g.text(name + ": " + soldiers.size() + " soldiers", x, y);
	}
}
