import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Stack;

public class File {

    /*
     * we save each shape as a root elements and its childs are the attributes
     * of the shape in loading file we use dom parser
     */

    Ellipse el;
    Triangle t;
    Rectangle r;
    Square s;
    Circle c;
    Line l;
    Color co;

    public void save(ArrayList<Shape> shapes,String pathname) throws Exception {

            FileOutputStream fos = new FileOutputStream(pathname);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (int i = 0; i < shapes.size(); i++) {
            if (((Shape) shapes.get(i)).getName().equals ("rectangle")) {
                 r=((Rectangle) shapes.get(i));

                oos.writeObject(r);
            } else if (((Shape) shapes.get(i)).getName().equals("square")) {
                 s=(Square)shapes.get(i);

                oos.writeObject(s);
            } else if (((Shape) shapes.get(i)).getName().equals("ellipse")) {

                el=(Ellipse)shapes.get(i);
                oos.writeObject(el);

            } else if (((Shape) shapes.get(i)).getName().equals("circle")) {

                c=(Circle)shapes.get(i);
                oos.writeObject(c);

            } else if (((Shape) shapes.get(i)).getName().equals("line")) {

                l=(Line)shapes.get(i);
                oos.writeObject(l);

            } else if (((Shape) shapes.get(i)).getName().equals("triangle")) {
                t=(Triangle) shapes.get(i);
                oos.writeObject(t);

            }
        }
        oos.flush();
        oos.close();
        fos.close();

    }
    public void load(ArrayList<Shape> shapes, ArrayList<Shape> Currentshapes,String pathname) throws Exception {
//        int shapeindex = 0;
        shapes.clear();
        Currentshapes.clear();

        FileInputStream fis = new FileInputStream(pathname);
        ObjectInputStream ois = new ObjectInputStream(fis);


        Shape shape=(Shape) ois.readObject();
        while(shape!=null) {


            if (shape.getName().equals("rectangle")) {
                Rectangle r = (Rectangle) shape;
                Currentshapes.add(r);
                shapes.add(r);
            }
            if (shape.getName().equals("triangle")) {
                Triangle t = (Triangle) shape;
                shapes.add(t);
                Currentshapes.add(t);

            }
            if (shape.getName().equals("square")) {
                Square s = (Square) shape;
                Currentshapes.add(s);
                shapes.add(s);
            }
            if (shape.getName().equals("ellipse")) {
                Ellipse c = (Ellipse) shape;
                Currentshapes.add(c);
                shapes.add(c);
            }
            if (shape.getName().equals("circle")) {
                Circle cir = (Circle) shape;
                Currentshapes.add(cir);
                shapes.add(cir);
            }
            if (shape.getName().equals("line")) {
                Line l = (Line) shape;
                Currentshapes.add(l);
                shapes.add(l);

            }
            System.out.println(shape.getName());
            shape=(Shape) ois.readObject();
//            ois.close();
//            fis.close();
//        repaint();
        }
        ois.close();
        fis.close();
    }

}
