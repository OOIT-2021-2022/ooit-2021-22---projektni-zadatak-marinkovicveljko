package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Shape shape;

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {

	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
	public void addShape(Shape shape)
	{
		shapes.add(shape);
		repaint();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext())
		{
		it.next().draw(g);
		}
	}
	
	
	

}
