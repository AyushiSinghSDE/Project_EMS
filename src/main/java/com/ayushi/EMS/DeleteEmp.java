package com.ayushi.EMS;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DeleteEmp extends JFrame implements ActionListener{

	Choice choice;
	JButton delete, back;
	
	public DeleteEmp()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading= new JLabel("Delete Employee");
		heading.setBounds(250, 10, 400, 50);
		heading.setFont(new Font("serif", Font.BOLD, 25));
		heading.setForeground(Color.black);
		add(heading);
		
		JLabel empidJLabel= new JLabel("Employee ID:");
		empidJLabel.setBounds(20, 70, 100, 50);
		add(empidJLabel);
		
		choice= new Choice();
		choice.setBounds(140, 85, 150, 50);
		add(choice);
		
		try {
			
			conn c= new conn();
			String query="Select * from employee";
			ResultSet rs= c.statement.executeQuery(query);
			while(rs.next())
			{
				choice.add(rs.getString("EmpId"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel empNameJLabel= new JLabel("Name");
		empNameJLabel.setBounds(20, 120, 100, 50);
		add(empNameJLabel);
		
		JLabel nameJLabel= new JLabel();
		nameJLabel.setBounds(140, 120, 150, 50);
		add(nameJLabel);
		
		JLabel empPhoneJLabel= new JLabel("Phone");
		empPhoneJLabel.setBounds(20, 170, 100, 50);
		add(empPhoneJLabel);
		
		JLabel phoneJLabel= new JLabel();
		phoneJLabel.setBounds(140, 170, 150, 50);
		add(phoneJLabel);
		
		JLabel empEmailJLabel= new JLabel("Email");
		empEmailJLabel.setBounds(20, 220, 100, 50);
		add(empEmailJLabel);
		
		JLabel emailJLabel= new JLabel();
		emailJLabel.setBounds(140, 220, 150, 50);
		add(emailJLabel);
		
		delete= new JButton("Delete");
		delete.setBounds(70, 300, 140, 30);
		delete.addActionListener(this);
		add(delete);
		
		back= new JButton("Back");
		back.setBounds(230, 300, 140, 30);
		back.addActionListener(this);
		add(back);
		
		try {
			
			String query="Select * from employee where EmpId='"+choice.getSelectedItem()+"'";
			conn c= new conn();
			ResultSet rs=c.statement.executeQuery(query);
			while(rs.next())
			{
				nameJLabel.setText(rs.getString("EmpName"));
				phoneJLabel.setText(rs.getString("PhoneNumber"));
				emailJLabel.setText(rs.getString("Email"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					
					String query="Select * from employee where EmpId='"+choice.getSelectedItem()+"'";
					conn c= new conn();
					ResultSet rs=c.statement.executeQuery(query);
					while(rs.next())
					{
						nameJLabel.setText(rs.getString("EmpName"));
						phoneJLabel.setText(rs.getString("PhoneNumber"));
						emailJLabel.setText(rs.getString("Email"));
					}
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		setSize(700, 400);
		setVisible(true);
		setLocation(300, 100);
setTitle("EMPLOYMENT MANAGEMENT SYSTEM");
	}
	
	public static void main(String args[])
	{
		new DeleteEmp();
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==back)
		{
			setVisible(false);
			new home();
		}
		
		else 
		{
			try {
				
				String query= "delete from employee where EmpId='"+choice.getSelectedItem()+"'";
				conn c= new conn();
				c.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee deleted successfully!!");
				setVisible(false);
				new home();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	

}
