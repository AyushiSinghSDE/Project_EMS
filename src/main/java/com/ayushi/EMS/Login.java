package com.ayushi.EMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.LongToIntFunction;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	JTextField usernameTextField, pswdTextField;
	
	public Login() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel labelusername= new JLabel("Username:");
		labelusername.setBounds(50, 50, 100, 40);
		add(labelusername);
		
		usernameTextField= new JTextField();
		usernameTextField.setBounds(150, 50, 170, 40);
		add(usernameTextField);
		
		JLabel labeluserpswd= new JLabel("Password:");
		labeluserpswd.setBounds(50, 100, 100, 40);
		add(labeluserpswd);
		
		pswdTextField= new JTextField();
		pswdTextField.setBounds(150, 100, 170, 40);
		add(pswdTextField);
		
		JButton login= new JButton("Login");
		login.setBounds(50, 170, 150, 40);
		login.addActionListener(this);
		add(login);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2= i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);
		
		setSize(600, 300);
		setVisible(true);
		setLocation(400, 150);
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
	}

	public static void main(String[] args ) {
		new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String username= usernameTextField.getText();
		String password= pswdTextField.getText();
		
		conn c= new conn();
		String query= "Select * from login where username ='"+username+"' and password='"+password+"'";
		
		try {
			ResultSet rs=c.statement.executeQuery(query);
			
			if(rs.next())
			{
				setVisible(false);
				new home();
			}
			else {
				//popup
				JOptionPane.showMessageDialog(null, "Invalid username or password");
				setVisible(false);
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	}
}
