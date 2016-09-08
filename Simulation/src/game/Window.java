package game;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

	private JFrame frame;
	private static Window window;
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 * @throws InvocationTargetException 
	 */
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		EventQueue.invokeAndWait(new Runnable() {
			public void run() {
				try {
					window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Main main = new Main(window);
		main.initialize();
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void paint(BufferedImage image){
		draw.setImage(image);
	}

	private DrawPanel draw;

	private void initialize() {

		draw = new DrawPanel();
		frame = new JFrame();
		frame.setBounds(100, 100, (int) Main.WIDTH, (int) Main.HEIGHT);
		frame.setTitle("Simulation of Life");
		frame.setContentPane(draw);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class DrawPanel extends JPanel {
		private BufferedImage image;

		public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, frame.getWidth(), frame.getHeight(), this);
		}

		public void setImage(BufferedImage i) {
			this.image = i;
		}
	}
}
