package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
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
	
	public void delete() {
		
		if(shapes.isEmpty()) {
			JOptionPane.showMessageDialog(null, "List of shapes is empty");
			setSelect(true);
		} else 
		{
			setSelect(false);
		}
			if(selectedShape != null)
			{
			setSelect(true);
			int option = JOptionPane.showInternalConfirmDialog(null, "Are you sure that you want to delete this shape", "Warning message", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION) {
				shapes.remove(selectedShape);
				repaint();
			}
			else {
			setSelect(true);
			selectedShape.setSelected(false);
			repaint();
			}
			
		}
	}
	
	public void modify()
	{
		if(shapes.isEmpty()) {
			JOptionPane.showMessageDialog(null, "List of shapes is empty");
			setSelect(true);
		}
		else
		{
			setSelect(false);
		}
		if(selectedShape != null) 
		{
			if(selectedShape instanceof Point)
			{
				Point p = (Point) selectedShape;
			    DlgPoint dialogPoint = new DlgPoint();
			    dialogPoint.getTxtXCoordinate().setText(Integer.toString(p.getX()));
			    dialogPoint.getTxtYCoordinate().setText(Integer.toString(p.getY()));
			    dialogPoint.getBtnBorderColor().setBackground(p.getColor());
			    dialogPoint.setVisible(true);
			    if(dialogPoint.isOkay())
			    {
			     p.setX(Integer.parseInt(dialogPoint.getTxtXCoordinate().getText()));
			     p.setY(Integer.parseInt(dialogPoint.getTxtYCoordinate().getText()));
			     p.setColor(dialogPoint.getBtnBorderColor().getBackground());
			     repaint();
			     selectedShape.setSelected(false);
			    }
			    else
			    { 
			    	selectedShape.setSelected(false);
			        repaint();
			    }
			}
			if(selectedShape instanceof Line) {
				Line l = (Line) selectedShape;
				DlgLine dialogLine = new DlgLine();
				dialogLine.getTxtXStart().setText(Integer.toString(l.getStartPoint().getX()));
				dialogLine.getTxtYStart().setText(Integer.toString(l.getStartPoint().getY()));
				dialogLine.getTxtXEnd().setText(Integer.toString(l.getEndPoint().getX()));
				dialogLine.getTxtYEnd().setText(Integer.toString(l.getEndPoint().getY()));
				dialogLine.getBtnBorderColor().setBackground(l.getColor());
				dialogLine.setVisible(true);
				if(dialogLine.isOkay()) {
					l.getStartPoint().setX(Integer.parseInt(dialogLine.getTxtXStart().getText()));
					l.getStartPoint().setY(Integer.parseInt(dialogLine.getTxtYStart().getText()));
					l.getEndPoint().setX(Integer.parseInt(dialogLine.getTxtXEnd().getText()));
					l.getEndPoint().setY(Integer.parseInt(dialogLine.getTxtXEnd().getText()));
					l.setColor(dialogLine.getBtnBorderColor().getBackground());
					repaint();
					selectedShape.setSelected(false);
				} else {
					selectedShape.setSelected(false);
					repaint();
				}
			}
				if(selectedShape instanceof Rectangle) {
					Rectangle r = (Rectangle) selectedShape;
					DlgRectangle dialogRectangle = new DlgRectangle();
					dialogRectangle.getTxtXCoordinate().setText(Integer.toString(r.getUpperLeftPoint().getX()));
					dialogRectangle.getTxtYCoordinate().setText(Integer.toString(r.getUpperLeftPoint().getY()));
					dialogRectangle.getTxtWidth().setText(Integer.toString(r.getWidth()));
					dialogRectangle.getTxtHeight().setText(Integer.toString(r.getHeight()));
					dialogRectangle.getBtnBorderColor().setBackground(r.getColor());
					dialogRectangle.getBtnInnerColor().setBackground(r.getInnerColor());
					dialogRectangle.setVisible(true);
					if(dialogRectangle.isOkay()) {
						r.getUpperLeftPoint().setX(Integer.parseInt(dialogRectangle.getTxtXCoordinate().getText()));
						r.getUpperLeftPoint().setY(Integer.parseInt(dialogRectangle.getTxtYCoordinate().getText()));
						r.setWidth(Integer.parseInt(dialogRectangle.getTxtWidth().getText()));
						r.setHeight(Integer.parseInt(dialogRectangle.getTxtHeight().getText()));
						r.setColor(dialogRectangle.getBtnBorderColor().getBackground());
						r.setInnerColor(dialogRectangle.getBtnInnerColor().getBackground());
						repaint();
						selectedShape.setSelected(false);
					} else {
						selectedShape.setSelected(false);
						repaint();
					}
					
				}
				
				if(selectedShape instanceof Circle && (selectedShape instanceof Donut) == false) {
					
					Circle c = (Circle) selectedShape;
					DlgCircle dialogCircle = new DlgCircle();
					dialogCircle.getTxtCenterX().setText(Integer.toString(c.getCenter().getX()));
					dialogCircle.getTxtCenterY().setText(Integer.toString(c.getCenter().getY()));
					dialogCircle.getTxtRadius().setText(Integer.toString(c.getRadius()));
					dialogCircle.getBtnBorderColor().setBackground(c.getColor());
					dialogCircle.getBtnInnerColor().setBackground(c.getInnerColor());
					dialogCircle.setVisible(true);
					if(dialogCircle.isOkay()) {
						c.getCenter().setX(Integer.parseInt(dialogCircle.getTxtCenterX().getText()));
						c.getCenter().setY(Integer.parseInt(dialogCircle.getTxtCenterY().getText()));
						c.setRadius(Integer.parseInt(dialogCircle.getTxtRadius().getText()));
						c.setColor(dialogCircle.getBtnBorderColor().getBackground());
						c.setInnerColor(dialogCircle.getBtnInnerColor().getBackground());
						repaint();
						selectedShape.setSelected(false);
					} else {
						selectedShape.setSelected(false);
						repaint();
					}
				}
				
				if(selectedShape instanceof Donut) {
					
					Donut d = (Donut) selectedShape;
					DlgDonut dialogDonut = new DlgDonut();
					dialogDonut.getTxtCenterX().setText(Integer.toString(d.getCenter().getX()));
					dialogDonut.getTxtYCentre().setText(Integer.toString(d.getCenter().getY()));
					dialogDonut.getTxtRadius().setText(Integer.toString(d.getRadius()));
					dialogDonut.getTxtInnerRadius().setText(Integer.toString(d.getInnerRadius()));
					dialogDonut.getBtnBorderColor().setBackground(d.getColor());
					dialogDonut.getBtnInnerColor().setBackground(d.getInnerColor());
					dialogDonut.setVisible(true);
					if(dialogDonut.isOkay()) {
						d.getCenter().setX(Integer.parseInt(dialogDonut.getTxtCenterX().getText()));
						d.getCenter().setY(Integer.parseInt(dialogDonut.getTxtYCentre().getText()));
						d.setRadius(Integer.parseInt(dialogDonut.getTxtRadius().getText()));
						d.setInnerRadius(Integer.parseInt(dialogDonut.getTxtInnerRadius().getText()));
						d.setInnerColor(dialogDonut.getBtnInnerColor().getBackground());
						d.setColor(dialogDonut.getBtnBorderColor().getBackground());
						repaint();
						selectedShape.setSelected(false);
					}
					else {
						selectedShape.setSelected(false);
						repaint();
					}
				}
			
			
			
			
		}
		
		
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
