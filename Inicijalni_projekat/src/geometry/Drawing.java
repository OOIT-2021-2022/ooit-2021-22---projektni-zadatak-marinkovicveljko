package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing panelDrawing = new Drawing();
		frame.getContentPane().add(panelDrawing);
		frame.setVisible(true);

	}
	
	public void paint(Graphics g) {
		Point p = new Point(200,200);
		p.draw(g);
		g.setColor(Color.red);
		Point startPoint = new Point(300,400);
		Line line = new Line(startPoint, new Point(800,900));
		line.draw(g);
		g.setColor(Color.black);
		Donut donut = new Donut(new Point(350,450), 50, 25, true);
		donut.draw(g);
		
		Point p1 = new Point(20, 30);
		Line l1 = new Line(new Point(200,300), new Point(400,500));
		Circle c1 = new Circle(new Point(50,50), 22);
		Donut d1 = new Donut(new Point(70,70), 22, 15, true);
		Rectangle r1 = new Rectangle(new Point(100,100), 20, 12);
		
		
		// 1. zadatak 
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p1);
		shapes.add(l1);
		shapes.add(c1);
		shapes.add(d1);
		shapes.add(r1);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext())
		{
			Shape sh = it.next();
			sh.moveBy(10,0);
			System.out.println(sh);
		}
		
		
		
		// Exception
		try
		{
		c1.setRadius(-10);
		System.out.println("try"); // nece se ispisati.
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	
	

	
}
