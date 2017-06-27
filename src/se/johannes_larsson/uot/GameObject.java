package se.johannes_larsson.uot;

import processing.core.PVector;

public abstract class GameObject {
	/** fill color of default rectangle */
	private int color;
	/** position of the origin */
	protected PVector position;
	/** position of center of rectangle relative to position */
	protected PVector origin;
	/** size of default rectangle (width, height) */
	protected PVector size;
	
	private Scene scene;
	
	public GameObject(PVector position, PVector size, int color, Scene scene) {
		this.color = color;
		this.position = position;
		this.size = size;
		this.origin = new PVector();
		this.scene = scene;
	}
	
	public Scene getScene() {
		return scene;
	}
	
	/**
	 * for updating this object's state
	 * @param g
	 * the game in which it exists
	 */
	public void update(Game g) {
		
	}
	
	/**
	 * Called when the object is added to a scene
	 * @param scene 
	 * the scene
	 */
	public void onAdd(Scene scene) {
		
	}
	
	/**
	 * Called when the object is removed from a scene
	 * @param scene
	 * the scene
	 */
	public void onRemove(Scene scene) {
		
	}
	
	public void setOriginCenter() {
		origin.set(0, 0);
	}
	
	/**
	 * for drawing the object. Draws a rectangle by default.
	 * @param g
	 * the game to draw to
	 */
	public void draw(Game g) {
		g.fill(color);
		g.rect(position.x - origin.x - size.x / 2, position.y - origin.y - size.y / 2, size.x, size.y);
	}
}
