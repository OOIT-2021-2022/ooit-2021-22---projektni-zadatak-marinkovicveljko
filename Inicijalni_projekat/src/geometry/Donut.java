package geometry;

public class Donut extends Circle {
	
	private int innerRadius;

	public Donut() {

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
