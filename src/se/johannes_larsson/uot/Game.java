package se.johannes_larsson.uot;

import processing.core.PApplet;

public class Game extends PApplet {

	public static final int GRIDSIZE = 30;

	/** the current scene */
	private Scene scene;
	
	/** the color to clear screen with */
	public int backgroundColor;
	
	public static void main(String[] args) {
		PApplet.main("se.johannes_larsson.uot.Game");
	}
	
	public void settings() {
		size(GRIDSIZE * 20 + 1, GRIDSIZE * 15 + 1);
		backgroundColor = 0xfff0f0ff;
	}
	
	public void setup() {
		scene = new GameScene();
		scene.onResume(this);
	}
	
	private boolean[] keys = new boolean[128];
	
	public void keyPressed() {
		keys[key] = true;
	}
	
	public void keyReleased() {
		keys[key] = false;
	}
	
	public boolean keyPressed(char key) {
		return keys[key];
	}
	
	/**
	 * makes a new scene the current one.
	 * calls {@link se.johannes_larsson.uot.Scene.onLeave} on old scene and {@link se.johannes_larsson.uot.Scene.onResume} on the new one
	 * @param scene
	 * the new scene
	 */
	public void setScene(Scene scene) {
		this.scene.onLeave(this);
		this.scene = scene;
		this.scene.onResume(this);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void draw() {
		scene.update(this);
		
		background(backgroundColor);
		scene.draw(this);
	}
}
