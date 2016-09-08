package textures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import geometry.Point;


public class Texture {

	private BufferedImage originalImage;
	private BufferedImage image;
	private Point center = new Point(0, 0);
	private double rotation = 0;
	private double widthDiffO2, heightDiffO2;

	public Texture(int width, int height) {
		originalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
	}

	public Texture(BufferedImage image) {
		image = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		this.originalImage = image;
		update();
	}

	public void rotateToDegrees(double d) {
		rotateToRads(Math.toRadians(d));
	}

	public void rotateByDegrees(double delta) {
		rotateToRads(Math.toRadians(delta) + rotation);
	}

	public void rotateByRadians(double delta) {
		rotateToRads(rotation+delta);
	}

	public void rotateToRads(double newAngle) {
		image = ImageHelper.createTransformedImage(originalImage, newAngle, getX(), getY());

		rotation = newAngle;
	}

	public void setBaseImage(BufferedImage image) {
		this.originalImage = image;

		update();
	}

	public void setCenter(Point p) {
		this.center = p;
	}

	public void setCenter(double x, double y) {
		setCenter(new Point(x, y));
	}

	boolean fuckff = false;

	public void update() {
		image = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), originalImage.getType());
		((Graphics2D) image.getGraphics()).drawImage(image, null, 0, 0);
		this.rotateToRads(rotation);
		widthDiffO2 = (image.getWidth()) *center.getX();
		heightDiffO2 = (image.getHeight() ) *center.getY();
		boolean d = image.equals(originalImage);
		fuckff = true;

	}

	public double getX() {
		return center.getX();
	}

	public double getY() {
		return center.getY();
	}

	public void draw(Graphics2D g, double x, double y) {
		g.drawImage(image, (int) (x - widthDiffO2), (int) (y - heightDiffO2), null);
	}

	public void draw(Graphics2D graphics, Point pos) {
		draw(graphics, pos.getX(), pos.getY() );
	}

	public BufferedImage getBaseImage() {
		return originalImage;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	

	public double getAngle() {
		return rotation;
	}
}
