package geometry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point p = new Point();
		// System.out.println(point1.x);
		// point1.x=10;
		// System.out.println(point1.x);

		p.setX(1);
		System.out.println("Koordinata x je jednaka: " + p.getX());
		p.setY(2);
		System.out.println("Koordinata y je jednaka: " + p.getY());

		// udaljenost
		p.setY(10);
		System.out.println(p.distance(15, 25));

		// Vezbe 3

		// point1-> x=20, y=10
		Point p1 = new Point();
		p1.setX(15);
		p1.setY(23);
		
		Line l1 = new Line();
		// System.out.println(l1.getStartPoint().getX());
		l1.setStartPoint(p);
		l1.setEndPoint(p1);
		// System.out.println(l1.getStartPoint());
		System.out.println(l1.getStartPoint().getX());
		System.out.println(l1.length());
		
		
		Rectangle r1= new Rectangle();
		Circle c1=new Circle();
		
		
		
		p.setX(p1.getY());
		l1.setStartPoint(p);
		
		l1.setEndPoint(p1);
		
		l1.getEndPoint().setY(23);
		
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		
		l1.getEndPoint().setX((int)(l1.length()-l1.getStartPoint().getX()-l1.getStartPoint().getY()));
		
		r1.setUpperLeftPoint(p);
		
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		
		c1.setCenter(r1.getUpperLeftPoint());
		
		c1.getCenter().setX(r1.area()-l1.getStartPoint().getY());
		
		

	}

}
