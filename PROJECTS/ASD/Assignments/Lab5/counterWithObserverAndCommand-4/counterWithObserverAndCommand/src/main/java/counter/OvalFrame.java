package counter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


public class OvalFrame extends javax.swing.JFrame implements Observer
{
	private int count;

	public OvalFrame()
	{
		getContentPane().setLayout(null);
		setSize(300,200);
		setTitle("Oval Frame");
		setCount(0);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}


	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == OvalFrame.this)
				RectFrame_WindowClosing(event);
		}
	}

	void RectFrame_WindowClosing(java.awt.event.WindowEvent event)
	{
		dispose();		 // dispose of the Frame.
	}


	public void setCount (int cnt){
		count=cnt;
		repaint();
	}

	public  void  paint(  Graphics  display  )  {
		// clear display first
		Dimension sizes = getSize();
		display.clearRect(0,0,sizes.width,sizes.height);

		int x = 50;
		int y = 30;

		// Magnify value by 5 to get a bigger visual effect
		int height =  count*9;
		int width = count*9;

		display.setColor( Color.red );         
		display.fillOval(x, y, Math.abs(width), Math.abs( height ) );
	}


	@Override
	public void update(int countervalue) {
		setCount(countervalue);		
	}
}

