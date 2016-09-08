package game;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import geometry.Point;
import textures.Drawable;

public class Game {
	
	private List<Drawable> drawables = new ArrayList<Drawable>();
	private List<Updatable> updatables = new ArrayList<Updatable>();
	private List<Updatable> updatableToRemove = new ArrayList<Updatable>();
	private List<Updatable> updatableToAdd = new ArrayList<Updatable>();

	public Game() {

	}

	public void draw(Graphics2D graphics) {
		for (Drawable draw : drawables) {
			draw.draw(graphics);
		}
	}

	public void updateLoop(double dt) {

		synchronized (updatableToRemove) {
			updatables.removeAll(updatableToRemove);
			updatableToRemove.clear();
		}
		synchronized (updatableToAdd) {
			updatables.addAll(updatableToAdd);
			updatableToAdd.clear();
		}

		for (Updatable u : updatables) {
			u.update(dt);
		}

		this.update(dt);
	}

	/**
	 * Updates indiviudal game.
	 * 
	 * @param dt2
	 */
	protected void update(double dt){
		
	}

	public void addUpdatable(Updatable arg0) {
		synchronized (updatableToAdd) {
			updatableToAdd.add(arg0);
		}
	}

	public void removeDrawable(Drawable arg0) {
		synchronized (drawables) {
			drawables.remove(arg0);
		}
	}

	public void removeUpdatable(Updatable arg0) {
		synchronized (updatableToRemove) {
			updatableToRemove.add(arg0);
		}
	}

	public void addDrawable(Drawable arg0) {
		synchronized (drawables) {
			drawables.add(arg0);
		}
	}

	public List<Drawable> getDrawables() {
		return drawables;
	}

	public List<Updatable> getUpdatables() {
		return updatables;
	}
	
}
