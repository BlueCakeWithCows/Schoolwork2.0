package geometry;
import java.awt.geom.Point2D;

public class Point extends Point2D.Double {

	public Point(double x, double y) {
		super(x, y);
	}

	public void translate(double x, double y) {
		this.x += x;
		this.y += y;
	}

}
