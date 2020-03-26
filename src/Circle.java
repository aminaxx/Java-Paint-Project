
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Circle extends Shape {

	protected int x, y, radius;

	public Circle() {
		super();
		x = y = radius = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}



	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	Shape select(MouseEvent e, ArrayList<Shape> currentShapes, int i) {
		// TODO Auto-generated method stub
		
		int x = e.getX();
		int y = e.getY();
		int cX = ((Circle) currentShapes.get(i)).getX();
		int cY = ((Circle) currentShapes.get(i)).getY();
		int radius = ((Circle) currentShapes.get(i)).getRadius();
		if ((x >= cX && x <= (cX + radius)) && (y >= cY && y <= (cY +radius))) {
			return currentShapes.get(i);
		}
		return null;
	}

	

	@Override
	void move(MouseEvent e, Shape selectedShape) {
		// TODO Auto-generated method stub
		
		int x = e.getX();
		int y = e.getY();
		int radius = ((Circle) selectedShape).getRadius();
		((Circle) selectedShape).setX(x - (radius/2));
		((Circle) selectedShape).setY(y - (radius/2));

	}

	@Override
	void resize(MouseEvent e, Shape selectedShape) {
		// TODO Auto-generated method stub
		
		int x = e.getX();
		int y = e.getY();
		int cx = ((Circle) selectedShape).getX();
		int cY = ((Circle) selectedShape).getY();
		if (x >= cx && y >= cY) {
			((Circle) selectedShape).setRadius((x - cx));
		}

	}


}
