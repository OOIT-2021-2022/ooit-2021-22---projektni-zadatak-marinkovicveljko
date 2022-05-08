package geometry;

import java.awt.Color;
import java.awt.Graphics;

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
	}

}
