package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;

	public Donut() {

	}
	
	public Donut(Point center, int radius, int innerRadius){
		super(center, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		/*
		 * setCenter(center); // ovo je private pa mora ovako this.radius = radius; //
		 * ovo je protected pa moze ovako setSelected(selected); this.innerRadius =
		 * innerRadius;
		 */

		// drugi nacin
		super(center, radius, selected);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, Color border) {
		this(center, radius, innerRadius);
		setColor(border);
	}
	
	public Donut(Point center, int radius, int innerRadius, Color border, Color inner) {
		this(center, radius, innerRadius, border);
		setInnerColor(inner);
	}
	

	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocni = (Donut) obj;
			if (super.equals(pomocni) && innerRadius == pomocni.innerRadius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean contains(Point clickPoint) {
		return super.contains(clickPoint)
				&& this.getCenter().distance(clickPoint.getX(), clickPoint.getY()) >= innerRadius;
	}

	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(getColor());
		g.drawOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, 2 * innerRadius,
				2 * innerRadius);

		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() + innerRadius - 2, 4, 4);
			g.setColor(Color.black);
		}
	}
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		super.fill(g);
		g.setColor(Color.WHITE);
		g.fillOval(getCenter().getX()-innerRadius, getCenter().getY() - innerRadius , 2*innerRadius, 2*innerRadius);
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Donut) {
			Donut shapeToCompare = (Donut) obj;
			return (int) (this.area() - shapeToCompare.area());
		}
		return 0;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public String toString() {
		// Center=(x,y), radius= radius, innerRadius= innerRadius
		return super.toString() + ", innerRadius=" + innerRadius;
	}

}
