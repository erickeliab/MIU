package counter;
import java.awt.Font;


public class TextFrame extends javax.swing.JFrame implements Observer
{
	javax.swing.JLabel JLabelCount = new javax.swing.JLabel();

	public TextFrame()
	{
		getContentPane().setLayout(null);
		setSize(300,200);
		setVisible(false);
		getContentPane().add(JLabelCount);
		JLabelCount.setFont(new Font("Dialog", Font.BOLD, 36));
		JLabelCount.setBounds(48,48,170,86);
		setTitle("Text Frame");
		setCount(0);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}


	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
		Object object = event.getSource();
		if (object == TextFrame.this)
			TextFrame_WindowClosing(event);
		}
	}

	void TextFrame_WindowClosing(java.awt.event.WindowEvent event)
	{
		dispose();		 // dispose of the Frame.
	}

    public void setCount (int count){
        JLabelCount.setText(String.valueOf( count));
    }

	@Override
	public void update(int countervalue) {
		setCount(countervalue);		
	}
}                                                                                                                         
