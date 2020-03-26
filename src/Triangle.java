import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Triangle extends Shape {

	protected int[] xPoints, yPoints;
	protected int tX, tY;

	public Triangle() {
		super();
		xPoints = null;
		yPoints = null;
		tX = 0;
		tY = 0;
	}

	public int[] getxPoints() {
		return xPoints;
	}

	public void setxPoints(int[] xPoints) {
		this.xPoints = xPoints;
	}

	public int[] getyPoints() {
		return yPoints;
	}

	public void setyPoints(int[] yPoints) {
		this.yPoints = yPoints;
	}

	public int gettX() {
		return tX;
	}

	public void settX(int tX) {
		this.tX = tX;
	}

	public int gettY() {
		return tY;
	}

	public void settY(int tY) {
		this.tY = tY;
	}

	@Override
	Shape select(MouseEvent e, ArrayList<Shape> currentShapes, int i) {
		int x = e.getX();
		int y = e.getY();
		int tX1 = ((Triangle) currentShapes.get(i)).gettX();
		int tY1 = ((Triangle) currentShapes.get(i)).gettY();
		int tX2 = ((Triangle) currentShapes.get(i)).getxPoints()[2];
		int tY2 = ((Triangle) currentShapes.get(i)).getyPoints()[2];
		if ((x >= tX1 && x <= tX2) && (y >= tY1 && y <= tY2)) {
			return currentShapes.get(i);
		} else if ((x <= tX1 && x >= tX2) && (y <= tY1 && y >= tY2)) {
			return currentShapes.get(i);
		} else if ((x >= tX1 && x <= tX2) && (y <= tY1 && y >= tY2)) {
			return currentShapes.get(i);
		} else if ((x <= tX1 && x >= tX2) && (y >= tY1 && y <= tY2)) {
			return currentShapes.get(i);
		}
		return null;
	}

	@Override
	void move(MouseEvent e, Shape selectedShape) {
		int x = e.getX();
		int y = e.getY();
		int tX1 = ((Triangle) selectedShape).gettX();
		int tY1 = ((Triangle) selectedShape).gettY();
		int tX2 = ((Triangle) selectedShape).getxPoints()[2];
		int tY2 = ((Triangle) selectedShape).getyPoints()[2];
		int width = tX2 - tX1;
		int hight = tY2 - tY1;
		((Triangle) selectedShape).settX(x - width / 2);
		((Triangle) selectedShape).settY(y - hight / 2);
		int[] xPoints = { (((Triangle) selectedShape).gettX() + width / 2),
				((Triangle) selectedShape).gettX(),
				(((Triangle) selectedShape).gettX() + width) };
		int[] yPoints = { ((Triangle) selectedShape).gettY(),
				(((Triangle) selectedShape).gettY() + hight),
				(((Triangle) selectedShape).gettY() + hight) };
		((Triangle) selectedShape).setxPoints(xPoints);
		((Triangle) selectedShape).setyPoints(yPoints);
	}

	@Override
	void resize(MouseEvent e, Shape selectedShape) {
		int x = e.getX();
		int y = e.getY();
		int tX1 = ((Triangle) selectedShape).gettX();
		int tY1 = ((Triangle) selectedShape).gettY();
		int width = x - tX1;
		int[] xPoints = { tX1 + (width / 2), tX1, x };
		int[] yPoints = { tY1, y, y };
		((Triangle) selectedShape).setxPoints(xPoints);
		((Triangle) selectedShape).setyPoints(yPoints);
	}



	//@Override
//	public void draw(Graphics g, ArrayList<Shape> shapes, int i) {
//		// TODO Auto-generated method stub
//		g.setColor(shapes.get(i).getColor());
//		if (shapes.get(i).isFilled())
//			g.fillPolygon(((Triangle) shapes.get(i)).getxPoints(),
//					((Triangle) shapes.get(i)).getyPoints(), 3);
//		else
//			g.drawPolygon(((Triangle) shapes.get(i)).getxPoints(),
//					((Triangle) shapes.get(i)).getyPoints(), 3);
//		
//	}
}
