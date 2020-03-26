import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Line extends Shape {

	protected int x1, x2, y1, y2;

	public Line() {
		super();
		x1 = 0;
		x2 = 0;
		y1 = 0;
		y2 = 0;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	@Override
	Shape select(MouseEvent e, ArrayList<Shape> currentShapes, int i) {
		int x = e.getX();
		int y = e.getY();
		int x1 = ((Line) currentShapes.get(i)).getX1();
		int x2 = ((Line) currentShapes.get(i)).getX2();
		int y1 = ((Line) currentShapes.get(i)).getY1();
		int y2 = ((Line) currentShapes.get(i)).getY2();
		if ((x >= x1 && x <= x2) && (y >= y1 && y <= y2)) {
			return currentShapes.get(i);
		} else if ((x <= x1 && x >= x2) && (y <= y1 && y >= y2)) {
			return currentShapes.get(i);
		} else if ((x >= x1 && x <= x2) && (y <= y1 && y >= y2)) {
			return currentShapes.get(i);
		} else if ((x <= x1 && x >= x2) && (y >= y1 && y <= y2)) {
			return currentShapes.get(i);
		} else if ((x1 == x2) && (y >= y1 && y <= y2)) {
			return currentShapes.get(i);
		} else if ((x <= x1 && x >= x2) && (y1 == y2)) {
			return currentShapes.get(i);
		}
		return null;
	}

	@Override
	void move(MouseEvent e, Shape selectedShape) {
		int x = e.getX();
		int y = e.getY();
		int x1 = ((Line) selectedShape).getX1();
		int x2 = ((Line) selectedShape).getX2();
		int y1 = ((Line) selectedShape).getY1();
		int y2 = ((Line) selectedShape).getY2();
		int width = x2 - x1;
		int hight = y2 - y1;
		width = x1 - x2;
		hight = y1 - y2;
		((Line) selectedShape).setX1(x - width / 2);
		((Line) selectedShape).setY1(y - hight / 2);
		((Line) selectedShape).setX2(((Line) selectedShape).getX1() + width);
		((Line) selectedShape).setY2(((Line) selectedShape).getY1() + hight);
	}

	@Override
	void resize(MouseEvent e, Shape selectedShape) {
		int x = e.getX();
		int y = e.getY();
		((Line) selectedShape).setX2(x);
		((Line) selectedShape).setY2(y);
	}

	

	//@Override
//	public void draw(Graphics g, ArrayList<Shape> shapes, int i) {
//		// TODO Auto-generated method stub
//		g.setColor(shapes.get(i).getColor());
//		g.drawLine(((Line) shapes.get(i)).getX1(), ((Line) shapes
//				.get(i)).getY1(), ((Line) shapes.get(i)).getX2(),
//				((Line) shapes.get(i)).getY2());
//		
//		
//	}

}
