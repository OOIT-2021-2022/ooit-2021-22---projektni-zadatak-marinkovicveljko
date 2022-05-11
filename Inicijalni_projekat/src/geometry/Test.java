package geometry;

import java.util.Arrays;

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
		
		
		// Vezbe 4
				/*
				 * 1.Postaviti koordinatu x centra ranije kreiranog kruga k na vrednost zbira
				 * vrednosti poluprecnika kruga k i vrednosti koja predstavlja udaljenost
				 * pocetne i krajnje tacke prethodno kreirane linije lin (NE duzine). Sve
				 * objekte kreirati samostalno.
				 */
				Circle c2 = new Circle();
				c2.setRadius(5);
				Line lin = new Line();
				Point t1 = new Point();
				Point t2 = new Point();
				t1.setX(3);
				t1.setY(4);
				t2.setX(5);
				t2.setY(6);
				lin.setStartPoint(t1);
				lin.setEndPoint(t2);

				c2.setCenter(t1);

				c2.getCenter().setX(c2.getRadius()
						+ (int) lin.getStartPoint().distance(lin.getEndPoint().getX(), lin.getEndPoint().getY()));

				// inicijalno postavljene vrednosti
				Point p4 = new Point(10, 15, true);
				// samo kad zelimo promenu
				p4.setX(20);

				// pre redefinisanja metode u Line, a posle redefinisanja u Point
				System.out.println(p4.toString());
				System.out.println(p4);
				System.out.println(lin);

				System.out.println(t1.equals(t2));

				// ZADATAK - testirati konstruktore, toString() i equals(...) metode

				// Vezbe 5

				Point clickPoint = new Point(20, 15);
				System.out.println(p4.contains(clickPoint));
				System.out.println(p4.contains(clickPoint.getX(), clickPoint.getY()));
				
				Donut donut = new Donut(clickPoint, 10, 5, true);
				System.out.println(donut.toString());
				System.out.println(donut.area());
				System.out.println(donut instanceof Circle);
				System.out.println(donut instanceof Donut);
				System.out.println(c2 instanceof Donut);

		     // Vezbe 7
				System.out.println("Vezbe 7");
				Point movedPoint = new Point (10,15);
				System.out.println(movedPoint);
				movedPoint.moveBy(5, 10);
				System.out.println(movedPoint);
				movedPoint.moveTo(5, 10);
				System.out.println(movedPoint);
				
				//Comparable
				movedPoint.compareTo(clickPoint);
				
				Line line1 = new Line(new Point(10,15),new Point(20,25));
				Line line2 = new Line(new Point(15,20),new Point(25,25));
				Line line3 = new Line(new Point(10,25),new Point(30,40));
				Line[] lines = {line1, line2, line3};	

				System.out.println("Niz linija pre sortiranja");
				for (int j = 0; j < lines.length; j++) {
					System.out.println(lines[j]);
				}

				Arrays.sort(lines);

				System.out.println("Niz linija posle sortiranja");
				for (int j = 0; j < lines.length; j++) {
					System.out.println(lines[j]);
				}


				Rectangle rectangle1 = new Rectangle(new Point(10,15), 10,15);
				Rectangle rectangle2 = new Rectangle(new Point(10,15), 30,40);
				Rectangle rectangle3 = new Rectangle(new Point(10,15), 10,10);
				Rectangle[] rectangles = {rectangle1, rectangle2, rectangle3};

				System.out.println("Niz pravougaonika pre sortiranja");
				for (int j = 0; j < rectangles.length; j++) {
					System.out.println(rectangles[j]);
				}

				Arrays.sort(rectangles);

				System.out.println("Niz pravougaonika posle sortiranja");
				for (int j = 0; j < rectangles.length; j++) {
					System.out.println(rectangles[j]);
				}
				
				//Svi oblici u jednoj listi
				Shape[] shapes = {rectangle1, rectangle2, line2, line3};
				for (int j = 0; j < shapes.length; j++) {
					shapes[j].moveBy(10, 15);
				}
		

	}

}
