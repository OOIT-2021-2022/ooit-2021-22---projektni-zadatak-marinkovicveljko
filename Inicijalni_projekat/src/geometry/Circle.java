package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends ShapeInner{
	
	private Point center;
	protected int radius;
	
	
	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		//this.selected = selected;
		setSelected(selected);
	}
	
	public Circle(Point center, int radius, Color color) {
		this(center, radius);
		setColor(color);
	}
	public Circle(Point center, int radius, Color color, Color innerColor) {
		this(center, radius, color);
		setInnerColor(innerColor);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocni = (Circle) obj;
			if (this.center.equals(pomocni.center) && this.radius == pomocni.radius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		return this.center.distance(x, y) <= radius;
	}
	
	public boolean contains(Point clickPoint) {
		return this.center.distance(clickPoint.getX(), clickPoint.getY()) <= radius;
	}

	public double area()
	{
		return radius*getRadius()*Math.PI;
	}
	
	public double circumference()
	{
		return 2*radius*Math.PI;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(center.getX()-radius, center.getY()-radius, 2*radius, 2*radius);
		fill(g);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			g.setColor(Color.black);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);		
	}

	@Override
	public void moveBy(int x, int y) {
		center.moveBy(x, y);		
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Circle) {
			Circle shapeToCompare = (Circle)obj;
			return (int)(this.area() - shapeToCompare.area());
		}
		return 0;
	}
	
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) throws Exception {
		this.center = center;
		
		if(radius < 0) {
			throw new Exception("Radius ne sme biti manji od 0");
		}
		this.radius = radius;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		// Center=(x,y), radius= radius
		return "Center=" + center + ", radius=" + radius;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(this.getCenter().getX()-radius, this.getCenter().getY()-radius , 2*radius, 2*radius);
		
	}
	
	
	

}
