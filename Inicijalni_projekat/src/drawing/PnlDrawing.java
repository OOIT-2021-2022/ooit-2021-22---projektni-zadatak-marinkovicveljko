package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Shape shape;
	private Shape selectedShape;
	private boolean select;

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
	
	public Shape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public void selected(int coordinatex, int coordinatey)
	{
		selectedShape = null;
		if(shapes.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "There is no shapes");
		}
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext())
		{
			shape = it.next();
			shape.setSelected(false);
			if(shape.contains(coordinatex, coordinatey))
			{
				selectedShape = shape;
			}
		}
		if(selectedShape != null)
		{
			selectedShape.setSelected(true);
		}
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
