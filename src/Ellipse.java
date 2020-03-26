
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Ellipse extends Shape {

	protected int cX, cY, cWidth, cHight;

	public Ellipse() {
		super();
		cX = 0;
		cY = 0;
		cWidth = 0;
		cHight = 0;
	}

	public int getcX() {
		return cX;
	}

	public void setcX(int cX) {
		this.cX = cX;
	}

	public int getcY() {
		return cY;
	}

	public void setcY(int cY) {
		this.cY = cY;
	}

	public int getcWidth() {
		return cWidth;
	}

	public void setcWidth(int cWidth) {
		this.cWidth = cWidth;
	}

	public int getcHight() {
		return cHight;
	}

	public void setcHight(int cHight) {
		this.cHight = cHight;
	}

	@Override
	Shape select(MouseEvent e, ArrayList<Shape> currentShapes, int i) {
		int x = e.getX();
		int y = e.getY();
		int cX = ((Ellipse) currentShapes.get(i)).getcX();
		int cY = ((Ellipse) currentShapes.get(i)).getcY();
		int cWidth = ((Ellipse) currentShapes.get(i)).getcWidth();
		int cHight = ((Ellipse) currentShapes.get(i)).getcHight();
		if ((x >= cX && x <= (cX + cWidth)) && (y >= cY && y <= (cY + cHight))) {
			return currentShapes.get(i);
		}
		return null;
	}

	@Override
	void move(MouseEvent e, Shape selectedShape) {
		int x = e.getX();
		int y = e.getY();
		int width = ((Ellipse) selectedShape).getcWidth();
		int hight = ((Ellipse) selectedShape).getcHight();
		((Ellipse) selectedShape).setcX(x - (width / 2));
		((Ellipse) selectedShape).setcY(y - (hight / 2));
	}

	@Override
	void resize(MouseEvent e, Shape selectedShape) {
		int x = e.getX();
		int y = e.getY();
		int cX = ((Ellipse) selectedShape).getcX();
		int cY = ((Ellipse) selectedShape).getcY();
		if (x >= cX && y >= cY) {
			((Ellipse) selectedShape).setcWidth(x - cX);
			((Ellipse) selectedShape).setcHight(y - cY);
		}
	}

	//@Override
//	public void draw(Graphics g, ArrayList<Shape> shapes, int i) {
//		// TODO Auto-generated method stub
//		g.setColor(shapes.get(i).getColor());
//		if (shapes.get(i).isFilled())
//			g.fillOval(((Ellipse) shapes.get(i)).getcX(),
//					((Ellipse) shapes.get(i)).getcY(),
//					((Ellipse) shapes.get(i)).getcWidth(),
//					((Ellipse) shapes.get(i)).getcHight());
//		
//		else
//			g.drawOval(((Ellipse) shapes.get(i)).getcX(),
//					((Ellipse) shapes.get(i)).getcY(),
//					((Ellipse) shapes.get(i)).getcWidth(),
//					((Ellipse) shapes.get(i)).getcHight());
//		
//	}

}
