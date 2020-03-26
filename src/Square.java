import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Square extends Shape{

	protected int posx,posy,l;
	
	public Square(){
		posx=posy=l=0;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	@Override
	Shape select(MouseEvent e, ArrayList<Shape> currentShapes, int i) {
		
		int x = e.getX();
		int y = e.getY();
		int rX = ((Square) currentShapes.get(i)).getPosx();
		int rY = ((Square) currentShapes.get(i)).getPosy();
		int L = ((Square) currentShapes.get(i)).getL();
		
		if ((x >= rX && x <= (rX + L)) && (y >= rY && y <= (rY + L))) {
			return currentShapes.get(i);
		}
		else{
		return null;}
	}

	@Override
	void move(MouseEvent e, Shape selectedShape) {
		// TODO Auto-generated method stub
		
		int x = e.getX();
		int y = e.getY();
		int L = ((Square) selectedShape).getL();
		((Square) selectedShape).setPosx(x - (L / 2));
		((Square) selectedShape).setPosy(y - (L / 2));
	}

	@Override
	void resize(MouseEvent e, Shape selectedShape) {
		
		int x = e.getX();
		int y = e.getY();
		int rX = ((Square) selectedShape).getPosx();
		int rY = ((Square) selectedShape).getPosy();
		if (x >= rX && y >= rY) {
			((Square) selectedShape).setL(x - rX);	
		}
		
	}

//	@Override
//	public void draw(Graphics g, ArrayList<Shape> shapes, int i) {
//		// TODO Auto-generated method stub
//		
//		g.setColor(shapes.get(i).getColor());
//		if (shapes.get(i).isFilled())
//			g.fillRect(((Square) shapes.get(i)).getPosx(),
//					((Square) shapes.get(i)).getPosy(),
//					((Square) shapes.get(i)).getL(),
//					((Square) shapes.get(i)).getL());
//		else
//			g.drawRect(((Square) shapes.get(i)).getPosx(),
//					((Square) shapes.get(i)).getPosy(),
//					((Square) shapes.get(i)).getL(),
//					((Square) shapes.get(i)).getL());
//	}
	
}
