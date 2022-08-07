package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	/*
	 * public int x; public int y; public boolean selected;
	 */

	private int x;
	private int y;
	

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.setY(y);
	}

	public Point(int x, int y, boolean selected) {
		/*
		 * this.x=x; this.setY(y);
		 */
		// mora biti prva naredba
		this(x, y);
		// this.selected = selected;
		setSelected(selected);
	}
	
	public Point(int x, int y, Color color) {
		this(x, y);
		setColor(color);
	}
	

	public boolean equals(Object obj) {

		if (obj instanceof Point) {
			Point pomocna = (Point) obj;

			if (this.x == pomocna.x && this.y == pomocna.y) {
				return true;
			}
		}
		return false;
	}

	public double distance(int xPoint2, int yPoint2) {
		double dx = this.x - xPoint2;
		double dy = this.y - yPoint2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}

	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}

	public boolean contains(Point clickPoint) {
		return this.distance(clickPoint.x, clickPoint.y) <= 2;
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(x-2, y-2, 4, 4);
			g.setColor(Color.black);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		setX(x);
		this.y = y;
	}

	@Override
	public void moveBy(int x, int y) {
		setX(this.x + x);
		this.y += y;
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Point) {
			Point shapeToCompare = (Point) obj;
			return (int) (this.distance(0, 0) - shapeToCompare.distance(0, 0));
		}
		return 0;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	

	public String toString() {

		// nije ispravno
		// return x.toString();

		// return x;
		// ispravno ali tako ne koristimo
		// return String.valueOf(x);

		return "(" + x + "," + y + ")";
	}

}
