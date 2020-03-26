import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MouseClass extends JPanel implements MouseListener,
		MouseMotionListener {

	JPanel canvas;
//	UR ur;
	ArrayList<Shape> shapes;
	ArrayList<Shape> currentShapes;
	private Ellipse c;
	private Circle cir;
	private Rectangle r;
	private Square sq;
	private Triangle t;
	private Line l;
	int flag;
	private int startx, starty;
	Color color;
	boolean isFilled;
	private Shape selectedShape;
	Item item;
	String pos, helpp;
	int help;

	public MouseClass() {

		pos = "";
		helpp = "";
		canvas = new JPanel();
		canvas.setBackground(Color.white);
		setVisible(true);
		canvas.setVisible(true);
		flag = 0;
		color = Color.BLACK;
		shapes = new ArrayList<Shape>();
		currentShapes = new ArrayList<Shape>();

		addMouseListener(this);
		addMouseMotionListener(this);
//		ur = new UR();

	}

	@Override
	public void mousePressed(MouseEvent ev) { //which shape to draw
		try {
			startx = ev.getX();
			starty = ev.getY();
			if (flag == 5 || flag == 6) {//delete and remove
				select(ev);
			} else {
				if (flag == 1) {
					c = new Ellipse();
					c.setColor(color);
					c.setName("ellipse");
					c.setFilled(isFilled);
					c.setcX(ev.getX());
					c.setcY(ev.getY());
				} else if (flag == 2) {
					r = new Rectangle();
					r.setColor(color);
					r.setName("rectangle");
					r.setFilled(isFilled);
					r.setrX(ev.getX());
					r.setrY(ev.getY());
				} else if (flag == 3) {
					t = new Triangle();
					t.setColor(color);
					t.setName("triangle");
					t.setFilled(isFilled);
					t.settX(ev.getX());
					t.settY(ev.getY());
				} else if (flag == 4) {
					l = new Line();
					l.setColor(color);
					l.setName("line");
					l.setX1(ev.getX());
					l.setY1(ev.getY());
				} else if (flag == 7) {
					cir = new Circle();
					cir.setColor(color);
					cir.setName("circle");
					cir.setFilled(isFilled);
					cir.setX(ev.getX());
					cir.setY(ev.getY());
				} else if (flag == 8) {
					sq = new Square();
					sq.setColor(color);
					sq.setName("square");
					sq.setFilled(isFilled);
					sq.setPosx(ev.getX());
					sq.setPosy(ev.getY());

				}
				
			}
		} catch (Exception eee) {

		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		try {
			if (e.getX() > 990 || e.getY() >= 770) {

			} else {
				if (flag == 6) {
					move(e);
				} else if (flag == 5) {
					resize(e);
				} else {
					if (flag == 1) {
						c.setcX(Math.min(e.getX(), startx));
						c.setcY(Math.min(e.getY(), starty));
						c.setcWidth(Math.abs(e.getX() - startx));
						c.setcHight(Math.abs(e.getY() - starty));

						shapes.add(c);
					} else if (flag == 2) {
						r.setrX(Math.min(e.getX(), startx));
						r.setrY(Math.min(e.getY(), starty));
						r.setrWidth(Math.abs(e.getX() - startx));
						r.setrHight(Math.abs(e.getY() - starty));

						shapes.add(r);
					} else if (flag == 3) {
						int base = e.getX() - t.gettX();
						int hight = e.getY() - t.gettY();
						int[] xPoints = { (t.gettX() + base / 2), t.gettX(),
								e.getX() };
						int[] yPoints = { t.gettY(), (t.gettY() + hight),
								e.getY() };
						t.setxPoints(xPoints);
						t.setyPoints(yPoints);
						shapes.add(t);
					} else if (flag == 4) {
						l.setX2(e.getX());
						l.setY2(e.getY());
						shapes.add(l);
					} else if (flag == 7) {
						cir.setX(Math.min(e.getX(), startx));
						cir.setRadius(Math.abs(e.getX() - startx));
						shapes.add(cir);

					} else if (flag == 8) {
						sq.setPosx(Math.min(e.getX(), startx));

						sq.setL(Math.abs(e.getX() - startx));

						shapes.add(sq);

					}

					repaint();
				}
			}
		} catch (Exception eee) {

		}
	}

//	private void pushItem() {
//try{
//		item.setI(currentShapes.size() - 1);
//
//		item.setPositions(item.getPositions() + pos);
//
//		ur.undo.push(item);
//}catch (Exception w) {
//	// TODO: handle exception
//}
//}


	@Override
	public void mouseReleased(MouseEvent e) {
		try{
			
		
		selectedShape = null;
		item = new Item();
		if (flag != 5 && flag != 6) {//select and remove
			if (flag == 1) {
				currentShapes.add(c);

			} else if (flag == 2) {
				currentShapes.add(r);
			} else if (flag == 3) {
				currentShapes.add(t);
			} else if (flag == 4) {
				currentShapes.add(l);

			} else if (flag == 7) {
				currentShapes.add(cir);
			} else if (flag == 8) {
				currentShapes.add(sq);
			}
		}
		}catch (Exception ewe) {
			// TODO: handle exception
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try{
		if (flag == 9) {//change color
			select(e);
			if (selectedShape != null) {
				selectedShape.setColor(color);
				selectedShape.setFilled(isFilled);


			}
		} else if (flag == 10) {//delete
			select(e);
			delete();
		}
		repaint();
		}catch (Exception eas) {
			// TODO: handle exception
		}
	}

	private void delete() {
		try{
		if (selectedShape != null) {
			for (int i = shapes.size() - 1; i >= 0; i--) {
				if (shapes.get(i).toString().equals(selectedShape.toString())) {
					shapes.remove(i);
				}
			}
			for (int i = 0; i < currentShapes.size(); i++) {
				if (currentShapes.get(i).toString()
						.equals(selectedShape.toString()))
					currentShapes.remove(i);
			}
		}
		}catch (Exception edd) {
			// TODO: handle exception
		}
	}

	public void select(MouseEvent e) {
		for (int i = currentShapes.size() - 1; i >= 0; i--) {
			if (currentShapes.get(i).getName().equals("circle")) {
				cir = new Circle();
				if (cir.select(e, currentShapes, i) != null) {
					selectedShape = cir.select(e, currentShapes, i);
					break;
				}
			} else if (currentShapes.get(i).getName().equals("ellipse")) {
				c = new Ellipse();
				if (c.select(e, currentShapes, i) != null) {
					selectedShape = c.select(e, currentShapes, i);
					break;
				}
			} else if (currentShapes.get(i).getName().equals("square")) {
				sq = new Square();
				if (sq.select(e, currentShapes, i) != null) {
					selectedShape = sq.select(e, currentShapes, i);
					break;
				}
			} else if (currentShapes.get(i).getName().equals("rectangle")) {
				r = new Rectangle();
				if (r.select(e, currentShapes, i) != null) {
					selectedShape = r.select(e, currentShapes, i);
					break;
				}
			} else if (currentShapes.get(i).getName().equals("triangle")) {
				t = new Triangle();
				if (t.select(e, currentShapes, i) != null) {
					selectedShape = t.select(e, currentShapes, i);
					break;
				}
			} else if (currentShapes.get(i).getName().equals("line")) {
				l = new Line();
				if (l.select(e, currentShapes, i) != null) {
					selectedShape = l.select(e, currentShapes, i);
					break;
				}
			}
		}
	}

	private void move(MouseEvent e) {
		if (selectedShape != null) {
			if (selectedShape.getName().equals("circle")) {
				cir.move(e, selectedShape);
			} else if (selectedShape.getName().equals("square")) {
				sq.move(e, selectedShape);
			} else if (selectedShape.getName().equals("ellipse")) {
				c.move(e, selectedShape);
			} else if (selectedShape.getName().equals("rectangle")) {
				r.move(e, selectedShape);
			} else if (selectedShape.getName().equals("triangle")) {
				t.move(e, selectedShape);
			} else if (selectedShape.getName().equals("line")) {
				l.move(e, selectedShape);
			}
			repaint();
		}
	}

	public void resize(MouseEvent e) {
		if (selectedShape != null) {
			if (selectedShape.getName().equals("circle")) {
				cir.resize(e, selectedShape);
			} else if (selectedShape.getName().equals("square")) {
				sq.resize(e, selectedShape);
			} else if (selectedShape.getName().equals("ellipse")) {
				c.resize(e, selectedShape);
			} else if (selectedShape.getName().equals("rectangle")) {
				r.resize(e, selectedShape);
			} else if (selectedShape.getName().equals("triangle")) {
				t.resize(e, selectedShape);
			} else if (selectedShape.getName().equals("line")) {
				l.resize(e, selectedShape);
			}
			repaint();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 900, 900);
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i).isDraw()) {
				if (shapes.get(i).getName().equals("circle")) {

					g.setColor(shapes.get(i).getColor());
					if (shapes.get(i).isFilled())
						g.fillOval(((Circle) shapes.get(i)).getX(),
								((Circle) shapes.get(i)).getY(),
								((Circle) shapes.get(i)).getRadius(),
								((Circle) shapes.get(i)).getRadius());

					else
						g.drawOval(((Circle) shapes.get(i)).getX(),
								((Circle) shapes.get(i)).getY(),
								((Circle) shapes.get(i)).getRadius(),
								((Circle) shapes.get(i)).getRadius());

					// cir.draw(g, shapes, i);
				} else if (shapes.get(i).getName().equals("ellipse")) {

					g.setColor(shapes.get(i).getColor());
					if (shapes.get(i).isFilled())
						g.fillOval(((Ellipse) shapes.get(i)).getcX(),
								((Ellipse) shapes.get(i)).getcY(),
								((Ellipse) shapes.get(i)).getcWidth(),
								((Ellipse) shapes.get(i)).getcHight());

					else
						g.drawOval(((Ellipse) shapes.get(i)).getcX(),
								((Ellipse) shapes.get(i)).getcY(),
								((Ellipse) shapes.get(i)).getcWidth(),
								((Ellipse) shapes.get(i)).getcHight());
					// c.draw(g, shapes, i);
				} else if (shapes.get(i).getName().equals("square")) {
					g.setColor(shapes.get(i).getColor());
					if (shapes.get(i).isFilled())
						g.fillRect(((Square) shapes.get(i)).getPosx(),
								((Square) shapes.get(i)).getPosy(),
								((Square) shapes.get(i)).getL(),
								((Square) shapes.get(i)).getL());
					else
						g.drawRect(((Square) shapes.get(i)).getPosx(),
								((Square) shapes.get(i)).getPosy(),
								((Square) shapes.get(i)).getL(),
								((Square) shapes.get(i)).getL());
					// sq.draw(g, shapes, i);
				} else if (shapes.get(i).getName().equals("rectangle")) {
					g.setColor(shapes.get(i).getColor());
					if (shapes.get(i).isFilled())
						g.fillRect(((Rectangle) shapes.get(i)).getrX(),
								((Rectangle) shapes.get(i)).getrY(),
								((Rectangle) shapes.get(i)).getrWidth(),
								((Rectangle) shapes.get(i)).getrHight());
					else
						g.drawRect(((Rectangle) shapes.get(i)).getrX(),
								((Rectangle) shapes.get(i)).getrY(),
								((Rectangle) shapes.get(i)).getrWidth(),
								((Rectangle) shapes.get(i)).getrHight());
					// r.draw(g, shapes, i);
				} else if (shapes.get(i).getName().equals("triangle")) {
					// t.draw(g, shapes, i);
					g.setColor(shapes.get(i).getColor());
					if (shapes.get(i).isFilled())
						g.fillPolygon(((Triangle) shapes.get(i)).getxPoints(),
								((Triangle) shapes.get(i)).getyPoints(), 3);
					else
						g.drawPolygon(((Triangle) shapes.get(i)).getxPoints(),
								((Triangle) shapes.get(i)).getyPoints(), 3);

				} else if (shapes.get(i).getName().equals("line")) {
					// l.draw(g, shapes, i);
					g.setColor(shapes.get(i).getColor());
					g.drawLine(((Line) shapes.get(i)).getX1(),
							((Line) shapes.get(i)).getY1(),
							((Line) shapes.get(i)).getX2(),
							((Line) shapes.get(i)).getY2());

				}
			}
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
