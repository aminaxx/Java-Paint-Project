import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Rectangle extends Shape {

	protected int rX, rY, rWidth, rHight;

	public Rectangle() {
		super();
		rX = 0;
		rY = 0;
		rWidth = 0;
		rHight = 0;
	}

	public int getrX() {
		return rX;
	}

	public void setrX(int rX) {
		this.rX = rX;
	}

	public int getrY() {
		return rY;
	}

	public void setrY(int rY) {
		this.rY = rY;
	}

	public int getrWidth() {
		return rWidth;
	}

	public void setrWidth(int rWidth) {
		this.rWidth = rWidth;
	}

	public int getrHight() {
		return rHight;
	}

	public void setrHight(int rHight) {
		this.rHight = rHight;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	Shape select(MouseEvent e, ArrayList<Shape> currentShapes, int i) {
		int x = e.getX();
		int y = e.getY();
		int rX = ((Rectangle) currentShapes.get(i)).getrX();
		int rY = ((Rectangle) currentShapes.get(i)).getrY();
		int rWidth = ((Rectangle) currentShapes.get(i)).getrWidth();
		int rHight = ((Rectangle) currentShapes.get(i)).getrHight();
		if ((x >= rX && x <= (rX + rWidth)) && (y >= rY && y <= (rY + rHight))) {
			return currentShapes.get(i);
		}
		return null;
	}

	@Override
	void move(MouseEvent e, Shape selectedShape) {
		int x = e.getX();
		int y = e.getY();
		int width = ((Rectangle) selectedShape).getrWidth();
		int hight = ((Rectangle) selectedShape).getrHight();
		((Rectangle) selectedShape).setrX(x - (width / 2));
		((Rectangle) selectedShape).setrY(y - (hight / 2));
	}

	@Override
	void resize(MouseEvent e, Shape selectedShape) {
		int x = e.getX();
		int y = e.getY();
		int rX = ((Rectangle) selectedShape).getrX();
		int rY = ((Rectangle) selectedShape).getrY();
		if (x >= rX && y >= rY) {
			((Rectangle) selectedShape).setrWidth(x - rX);
			((Rectangle) selectedShape).setrHight(y - rY);
		}
	
	}

//	@Override
//public	void draw(Graphics g, ArrayList<Shape> shapes, int i) {
//		// TODO Auto-generated method stub
//		g.setColor(shapes.get(i).getColor());
//		if (shapes.get(i).isFilled())
//			g.fillRect(((Rectangle) shapes.get(i)).getrX(),
//					((Rectangle) shapes.get(i)).getrY(),
//					((Rectangle) shapes.get(i)).getrWidth(),
//					((Rectangle) shapes.get(i)).getrHight());
//		else
//			g.drawRect(((Rectangle) shapes.get(i)).getrX(),
//					((Rectangle) shapes.get(i)).getrY(),
//					((Rectangle) shapes.get(i)).getrWidth(),
//					((Rectangle) shapes.get(i)).getrHight());
//	}
}