import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class frame extends JFrame  {

	private JButton Square, Circle, Ellipse, rectangle, triangle, line, delete,
			colorChooser, move, resize, changeC;
	private JRadioButton filled, border;
	protected static String url;
	MouseClass paint;
	private JFileChooser SLfile;
	private JMenuBar bar;
	private JMenu file;
	private JMenu edit;
	private JMenu save;
	private JMenu load;
//	private JMenuItem undo;
//	private JMenuItem redo;
	private JPanel Bshapes;
	String pathname="data.dat";

	public frame() {
//        url = "";
		paint = new MouseClass();
		setSize(850, 700 );
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		//managing the up bar
//		undo = new JMenuItem("Undo");
//		redo = new JMenuItem("Redo");
		edit = new JMenu("Edit");
//		edit.add(undo);
//		edit.add(redo);
		save = new JMenu("Save");
		load = new JMenu("load");
		file = new JMenu("File");
		file.add(save);
		file.add(load);
		bar = new JMenuBar();
		bar.add(file);
		bar.add(edit);
		bar.setBounds(0, 0, 850, 35); //menu panel (file, edit)

		add(bar);

		Square=new JButton(new ImageIcon("square.png"));
		Square.setBounds(110,40,40,40);
		triangle=new JButton(new ImageIcon("triangle.png"));
		triangle.setBounds( 180, 40, 40, 40);
		line=new JButton(new ImageIcon("line.png"));
		line.setBounds(250, 40, 40, 40);
		rectangle=new JButton(new ImageIcon("rectangle.png"));
		rectangle.setBounds(320, 40, 40, 40);
		Ellipse=new JButton(new ImageIcon("ellipse.png"));
		Ellipse.setBounds(390,40,40,40);
		Circle=new JButton(new ImageIcon("circle.png"));
		Circle.setBounds(460, 40, 40, 40);
		filled = new JRadioButton("filled");
		filled.setBounds(530, 57, 60, 20);
		border = new JRadioButton("border");
		border.setBounds(660, 57, 100, 20);

		Bshapes = new JPanel();
		Bshapes.setLayout(null);
		Bshapes.setBounds(0, 0, 850, 700);
		Bshapes.add(Square);
		Bshapes.add(triangle);
		Bshapes.add(line);
		Bshapes.add(rectangle);
		Bshapes.add(Ellipse);
		Bshapes.add(Circle);
		Bshapes.add(filled);
		Bshapes.add(border);
		add(Bshapes);

		move=new JButton(new ImageIcon("move.png"));
		move.setToolTipText("move");
		move.setBounds(200,610 ,45 ,45);
		resize=new JButton(new ImageIcon("resize.png"));
		resize.setToolTipText("resize");
		resize.setBounds(295, 610, 45, 45);
		delete=new JButton(new ImageIcon("delete.png"));
		delete.setToolTipText("delete");
		delete.setBounds(380,610,45,45);
		changeC=new JButton(new ImageIcon("colorChooser.png"));
		changeC.setBounds(465, 610, 45, 45);
		changeC.setToolTipText("change color");
		colorChooser=new JButton(new ImageIcon( "changeColor.png"));
		colorChooser.setBounds(550, 610, 45, 45);
		colorChooser.setToolTipText("choose color");
		Bshapes.add(move);
		Bshapes.add(resize);
		Bshapes.add(delete);
		Bshapes.add(changeC);
		Bshapes.add(colorChooser);


		paint.setBounds(20, 85, 810, 515); //paint panel
		add(paint);

		File f=new File();

		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int retval = 0;
				FileChooserSave(retval);
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
						f.save(paint.currentShapes,pathname);
					} catch (Exception e1) {
					}
				}
			}
		} );

		load.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					f.load(paint.shapes, paint.currentShapes, pathname);
					paint.repaint();
				} catch (Exception e1) {
					System.out.println("couldnot load");

				}
			}
		}

		);
		resize.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				paint.flag = 5;

			}
		});

		move.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				paint.flag = 6;
			}
		});
		
		Ellipse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 1;
			}
		});
		
		Circle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 7;
//				PressedUndo = false;
			}
		});

		rectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 2;
			}
		});
		
		Square.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 8;
			}
		});

		triangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 3;
			}
		});

		line.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 4;
			}
		});

		colorChooser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.color = JColorChooser.showDialog(paint, "Choose a color",
						paint.color);
			}
		});

		changeC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 9;
			}
		});

		filled.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.isFilled = true;
				border.setSelected(false);
			}
		});

		border.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.isFilled = false;
				filled.setSelected(false);
			}
		});

		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				paint.flag = 10;
			}
		});

	}

	private void OpenFile(int retval) {
		SLfile = new JFileChooser();
		retval = SLfile.showOpenDialog(null);
		SLfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		SLfile.setBackground(Color.white);
	}

	private void FileChooserSave(int retval) {
		SLfile = new JFileChooser();
		retval = SLfile.showSaveDialog(null);
		SLfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		SLfile.setBackground(Color.white);
	}

	public static void main(String[] args) {
		try {
			frame f = new frame();
			f.setVisible(true);
		} catch (Exception e) {
			System.out.println("unexpected error");
		}
	}

}
