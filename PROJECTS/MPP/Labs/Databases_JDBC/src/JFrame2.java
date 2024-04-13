/*
		A basic implementation of the JFrame class.
*/

import java.awt.*;
import javax.swing.*;

public class JFrame2 extends javax.swing.JFrame
{
	public JFrame2()
	{
		
		//{{INIT_CONTROLS
		setTitle("Selected ID");
		getContentPane().setLayout(null);
		setSize(403,125);
		setVisible(false);
		JLabel1.setText("You selected student ID");
		getContentPane().add(JLabel1);
		JLabel1.setBounds(48,24,143,22);
		Idtext.setEditable(false);
		getContentPane().add(Idtext);
		Idtext.setBounds(216,24,122,23);
		BClose.setText("Close");
		BClose.setActionCommand("Close");
		getContentPane().add(BClose);
		BClose.setBounds(156,72,93,25);
		//}}

		//{{INIT_MENUS
		//}}
	
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		BClose.addActionListener(lSymAction);
		//}}
	}


	public void setVisible(boolean b)
	{
		if (b)
			setLocation(50, 50);
		super.setVisible(b);
	}

	static public void main(String args[])
	{
		(new JFrame2()).setVisible(true);
	}


	//{{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JTextField Idtext = new javax.swing.JTextField();
	javax.swing.JButton BClose = new javax.swing.JButton();
	//}}

	//{{DECLARE_MENUS
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == BClose)
				BClose_actionPerformed(event);
		}
	}

	void BClose_actionPerformed(java.awt.event.ActionEvent event)
	{
		this.dispose();
			 
	}
	
	public void setid(String id){
	    Idtext.setText(id);
	}
}