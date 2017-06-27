package se.johannes_larsson.uot;

import java.util.ArrayList;

public abstract class Scene {
	private ArrayList<GameObject> objects, add, remove;
	
	public Scene() {
		objects = new ArrayList<GameObject>();
		add = new ArrayList<GameObject>();
		remove = new ArrayList<GameObject>();
	}
	
	/**
	 * called when this scene is switched to (including the start)
	 * @param g
	 * the game
	 */
	public void onResume(Game g) {
		
	}
	
	/**
	 * called when this scene is switched from
	 * @param g
	 * the game
	 */
	public void onLeave(Game g) {
		
	}
	
	/** run once every frame 
	 * handles added and removed objects
	 * @param g
	 * the game
	 */
	public void update(Game g) {

		for (GameObject go : add) {
			objects.add(go);
		}
		for (GameObject go : remove) {
			objects.remove(go);
		}
		add.clear();
		remove.clear();
		
		for (GameObject go : objects) {
			go.update(g);
		}
	}
	
	/**
	 * add a new {@link se.johannes_larsson.uot.GameObject} to the scene the next frame. Calls onAdd() on the object.
	 * @param g
	 * the object
	 */
	public void addObject(GameObject g) {
		g.onAdd(this);
		if (!add.contains(g)) add.add(g);
	}
	
	/**
	 * removes an object from the scene and calls onRemove() on it
	 * @param g
	 * the object
	 */
	public void removeObject(GameObject g) {
		g.onRemove(this);
		if (!remove.contains(g)) remove.add(g);
	}

	/**
	 * draws all game objects 
	 * @param g
	 * the game to draw to
	 */
	public void draw(Game g) {
		
		for (GameObject go : objects) {
			go.draw(g);
		}
	}
}
