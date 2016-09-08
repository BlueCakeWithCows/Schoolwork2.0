package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import textures.Texture;

public class Main {
	public static final double WIDTH = 800, HEIGHT = 600;

	public static Random random;
	public Game game;
	public boolean stopped;
	public BufferedImage visibleScreen;
	public Window window;

	public Main(Window window) {
		this.window = window;
	}

	public void initialize() {
		random.setSeed(1212);
		game = new Game();
		startGraphicsLoop();
		// Setup Initial Enviroment
		// Create Initial Creatures
		gameLoop();

	}

	public void startGraphicsLoop() {
		Runnable graphicsThread = (new Runnable() {
			@Override
			public void run() {
				try {
					while (!stopped) {
						game.draw((Graphics2D) visibleScreen.getGraphics());
						window.paint(visibleScreen);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
		});
		(new Thread(graphicsThread)).start();
	}

	public void gameLoop() {
		double dt = 0;
		long lastTime = System.currentTimeMillis();
		long time = 0;
		while (!stopped) {
			while (dt < 1 / 60d) {
				time = System.currentTimeMillis();
				dt = (time - lastTime) / 1000d;
			}
			lastTime = time;
			// Fixed timestep for predictable behavior in sim.
			game.update(1 / 60d);

		}
	}
}
