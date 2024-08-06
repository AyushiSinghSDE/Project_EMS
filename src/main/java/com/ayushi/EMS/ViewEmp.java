package com.ayushi.EMS;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class ViewEmp extends JFrame implements ActionListener{

	JTable table;
	Choice choice;
	JButton search, print, update, back;
	
	public ViewEmp()
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel searchJLabel= new JLabel("Search by EmpID:");
		searchJLabel.setBounds(20, 20, 150, 25);
		add(searchJLabel);
		
		choice = new Choice();
		choice.setBounds(170, 20, 150, 50);
		add(choice);
		
		try 
		{
			conn c= new conn();
			String query="Select * from employee";
			ResultSet rs= c.statement.executeQuery(query);
			while(rs.next())
			{
				choice.add(rs.getString("EmpId"));
			}
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		search= new JButton("Search");
		search.setBounds(20, 70, 80, 20);
		search.addActionListener(this);
		add(search);
		
		print= new JButton("Print");
		print.setBounds(110, 70, 80, 20);
		print.addActionListener(this);
		add(print);
		
		update= new JButton("Update");
		update.setBounds(200, 70, 80, 20);
		update.addActionListener(this);
		add(update);
		
		back= new JButton("Back");
		back.setBounds(290, 70, 80, 20);
		back.addActionListener(this);
		add(back);
		
		
		table= new JTable();
		try 
		{
			conn c= new conn();
			String query="Select * from employee";
			ResultSet rs= c.statement.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		JScrollPane jScrollPane= new JScrollPane(table);
		jScrollPane.setBounds(0, 110, 700, 500);
		add(jScrollPane);
		
		setSize(700, 550);
		setVisible(true);
		setLocation(300, 100);
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
	}
	public static void main(String args[])
	{
		new ViewEmp();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search)
		{
			String query="Select * from employee where EmpId='"+choice.getSelectedItem()+"'";
			try {
				conn c= new conn();
				ResultSet rs=c.statement.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if(e.getSource()==print)
		{
			
			try {
				table.print();
			} catch (PrinterException e1) {
				
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==update)
		{
			setVisible(false);
			new UpdateEmp(choice.getSelectedItem());
		}
		else 
		{
			setVisible(false);
			new home();
		}
		
	}
}
