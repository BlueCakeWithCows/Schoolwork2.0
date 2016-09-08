package textures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import geometry.Point;

public class ImageHelper {
	public static BufferedImage createTransformedImage(BufferedImage image, double angle, double x, double y) {
		double sin = Math.abs(Math.sin(angle));
		double cos = Math.abs(Math.cos(angle));
		int originalWidth = image.getWidth();
		int originalHeight = image.getHeight();
		int newWidth = (int) Math.floor(originalWidth * cos + originalHeight * sin);
		int newHeight = (int) Math.floor(originalHeight * cos + originalWidth * sin);
		BufferedImage rotatedBI = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = rotatedBI.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.translate((newWidth - originalWidth) / 2, (newHeight - originalHeight) / 2);
		g2d.rotate(angle, originalWidth / 2, originalHeight / 2);
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		return rotatedBI;
	}

	public static void fillCircleCenteredOn(Graphics2D graphics, Color color, Point center, double radius) {
		graphics.setColor(color);
		int x = (int) (center.x - radius / 2);
		int y = (int) (center.y - radius / 2);
		int radi = (int) radius;

		graphics.fillOval(x, y, radi, radi);

	}

	public static void drawPolygon(Graphics2D graphics, Color color, Polygon poly, double strokeWidth) {
		graphics.setColor(color);
		graphics.draw(poly);

	}
	public static void fillPolygon(Graphics2D graphics, Color color, Polygon poly) {
		graphics.setColor(color);
		graphics.fill(poly);

	}

	public static void drawCircleCenteredOn(Graphics2D graphics, Color color, Point center, double radius,
			double strokeWidth) {
		graphics.setColor(color);
		graphics.setStroke(new BasicStroke((float) strokeWidth));
		int x = (int) (center.x - radius / 2);
		int y = (int) (center.y - radius / 2);
		int radi = (int) radius;

		graphics.drawOval(x, y, radi, radi);

	}

	public static void DrawLine(Graphics2D graphics, Color color, Point p1, Point p2, double strokeWidth) {
		graphics.setColor(color);
		graphics.setStroke(new BasicStroke((float) strokeWidth));
		graphics.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);

	}
}
