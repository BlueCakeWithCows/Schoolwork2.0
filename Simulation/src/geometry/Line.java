package geometry;

public class Line {
	public Point start, end;

	public Line(Point p1, Point p2) {
		this.start = p1;
		this.end = p2;
	}

	public Line(double i, double j, double k, double l) {
		this(new Point(i, j), new Point(k, l));
	}

	public boolean intersects(Line line) {
		return geometry.GeometryUtilities.getLineInteresection(line, this);

	}
}
