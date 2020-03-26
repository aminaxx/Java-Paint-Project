import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Shape implements Serializable {

	protected Color color = Color.BLACK;
	protected String name;
	protected boolean isFilled;
	protected boolean isDraw;

	public Shape() {
		color = null;
		name = null;
		isFilled = true;
		isDraw = true;
	}

	public boolean isDraw() {
		return isDraw;
	}

	public void setDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	public void setColor(Color c) {
		color = c;
	}

	public Color getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	abstract Shape select(MouseEvent e, ArrayList<Shape> currentShapes, int i);

	abstract void move(MouseEvent e, Shape selectedShape);

	abstract void resize(MouseEvent e, Shape selectedShape);

}
