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

public class home extends JFrame implements ActionListener{
	
	JButton addEmp, viewEmp, updateEmp, deleteEmp;
	
	public home() {
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i2= i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(0, 0, 1000, 600);
		add(image);
		
		JLabel heading= new JLabel("EMPLOYMENT MANAGEMENT SYSTEM");
		heading.setBounds(500, 35, 400, 50);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		heading.setForeground(Color.black);
		image.add(heading);
		
		addEmp= new JButton("Add Employee");
		addEmp.setBounds(550, 100, 150, 30);
		addEmp.addActionListener(this);
		addEmp.setBackground(Color.lightGray);
		addEmp.setForeground(Color.black);
		image.add(addEmp);
		
		viewEmp= new JButton("View Employees");
		viewEmp.setBounds(750, 100, 150, 30);
		viewEmp.addActionListener(this);
		viewEmp.setBackground(Color.lightGray);
		viewEmp.setForeground(Color.black);
		image.add(viewEmp);
		
		updateEmp= new JButton("Update Employee");
		updateEmp.setBounds(550, 150, 150, 30);
		updateEmp.addActionListener(this);
		updateEmp.setBackground(Color.lightGray);
		updateEmp.setForeground(Color.black);
		image.add(updateEmp);
		
		deleteEmp= new JButton("Delete Employee");
		deleteEmp.setBounds(750, 150, 150, 30);
		deleteEmp.addActionListener(this);
		deleteEmp.setBackground(Color.lightGray);
		deleteEmp.setForeground(Color.black);
		image.add(deleteEmp);
		
		setSize(1000, 600);
		setVisible(true);
		setLocation(150, 50);
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
	}
	public static void main(String args[])
	{
		new home();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==addEmp)
		{
			setVisible(false);
			new AddEmp();
		}
		
		else if (e.getSource()==viewEmp) 
		{
			setVisible(false);
			new ViewEmp();
		}
		
		else if (e.getSource()==updateEmp) 
		{
			setVisible(false);
			new ViewEmp();
		}
		
		else 
		{
			setVisible(false);
			new DeleteEmp();
		}
	}
	

}
