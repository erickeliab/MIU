import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class DrawApplication extends JFrame implements ActionListener {
	Container c;
	JMenuBar menubar;
	JMenu shape, color, edit;
	JMenuItem circle, rectangle, line;
	JMenuItem red, green, blue, yellow;
	JMenuItem undo, redo;
	int col = 0;
	Graphics g;
	HistoryList historyList;

	DrawApplication() {
		historyList = new HistoryList();

		c = getContentPane();

		menubar = new JMenuBar();
		shape = new JMenu("Shape");
		color = new JMenu("Color");
		edit = new JMenu("Edit");
		circle = new JMenuItem("Circle");
		rectangle = new JMenuItem("Rectangle");
		line = new JMenuItem("Line");
		red = new JMenuItem("Red");
		green = new JMenuItem("Green");
		blue = new JMenuItem("Blue");
		yellow = new JMenuItem("Yellow");
		undo = new JMenuItem("Undo");
		redo = new JMenuItem("Redo");
		
		shape.add(circle);
		shape.add(rectangle);
		shape.add(line);
		color.add(red);
		color.add(green);
		color.add(blue);
		color.add(yellow);
		edit.add(undo);
		edit.add(redo);
		menubar.add(shape);
		menubar.add(color);
		menubar.add(edit);

		setJMenuBar(menubar);

		c.setLayout(new FlowLayout(0));
		setSize(600, 600);
		setTitle("Draw Shape");
		setVisible(true);

		circle.addActionListener(this);
		rectangle.addActionListener(this);
		line.addActionListener(this);

		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		yellow.addActionListener(this);
		
		undo.addActionListener(this);
		redo.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {
		g = getGraphics();
		if (col == 1)
			g.setColor(Color.red);
		if (col == 2)
			g.setColor(Color.green);
		if (col == 3)
			g.setColor(Color.blue);
		if (col == 4)
			g.setColor(Color.yellow);

		if (ae.getSource() == red)
			col = 1;
		if (ae.getSource() == green)
			col = 2;
		if (ae.getSource() == blue)
			col = 3;
		if (ae.getSource() == yellow)
			col = 4;

		Random rand = new Random();
		int k= rand.nextInt(500);
		if (k < 150)k=150;
		int l= rand.nextInt(500);
		if (l < 150)l=150;
		int m= rand.nextInt(500);
		if (m < 150)m=150;
		int n= rand.nextInt(500);
		if (n < 150)n=150;
		if (ae.getSource() == circle) {
			OvalCommand ovalCommand = new OvalCommand(g, k,l,m,n,historyList);
			ovalCommand.execute();
			historyList.addCommand(ovalCommand);
//			g.fillOval(k, l, m, n);
		}
		if (ae.getSource() == rectangle) {
			RectCommand rectCommand = new RectCommand(g, k,l,m,n,historyList);
			rectCommand.execute();
			historyList.addCommand(rectCommand);
//			g.fillRect(k, l, m, n);
		}
		if (ae.getSource() == line) {
			LineCommand lineCommand = new LineCommand(g, k,l,m,n,historyList);
			lineCommand.execute();
			historyList.addCommand(lineCommand);
//			g.drawLine(k, l, m, n);
		}
		
		if (ae.getSource() == undo) {
			System.out.println("perform undo");
			g.clearRect(150, 150, 500, 500);
			historyList.undo();
		}

		if (ae.getSource() == redo) {
			System.out.println("perform redo");
			historyList.redo();
		}

	}

	public static void main(String args[]) {
		new DrawApplication();
	}
}