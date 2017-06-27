package se.johannes_larsson.uot;

import java.util.ArrayList;

public class Player {
	private int color;
	
	/** all soldiers belonging to this player */
	private ArrayList<Soldier> soldiers;
	
	/** which soldiers turn it is */
	private int turn;
	
	public Soldier getSoldiersTurn() {
		return soldiers.get(turn);
	}

	public Player(int color) {
		this.color = color;
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
}
