package com.ayushi.EMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App extends JFrame implements ActionListener
{
	//constructor
	public App() 
	{
		//adding heading in JFrame
				getContentPane().setBackground(Color.white);
				JLabel heading= new JLabel("EMPLOYMENT MANAGEMENT SYSTEM");
				//to add on JFamr
				add(heading);
				//default layout off
				setLayout(null);
				//setting customised layout
				heading.setBounds(50, 30, 1500, 50);
				//customising the heading
				heading.setFont(new Font("serif", Font.BOLD, 30));
				heading.setForeground(Color.black);
				
		//adding image in JFrame
				ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
				Image i2= i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
				ImageIcon i3= new ImageIcon(i2);
				JLabel image= new JLabel(i3);
				image.setBounds(40, 100, 610, 340);
				add(image);
				
		//adding button
				JButton clickHere= new JButton("Click here to continue");
				clickHere.setBounds(100, 270, 400, 50);
				clickHere.addActionListener(this);
				image.add(clickHere);
				
		//frame
		setSize(700, 500);
		setVisible(true);
		setLocation(300, 50);
		setTitle("EMPLOYMENT MANAGEMENT SYSTEM");
		
		
	}
	
    public static void main( String[] args )
    {
    	//object creation
        new App();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		setVisible(false);
		new Login();
	}
}
