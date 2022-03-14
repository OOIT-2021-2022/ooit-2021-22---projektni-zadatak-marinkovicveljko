package geometry;

public class Point {

	/* public int x;
	public int y;
	public boolean selected; */
	
	private int x;
	private int y;
	private boolean selected;
	
	public void setX(int x)
	{
		this.x=x;
	}
	
	public int getX()
	{
		return this.x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
