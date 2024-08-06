package com.ayushi.EMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddEmp extends JFrame implements ActionListener{
	
	Random random= new Random();
	int number=random.nextInt(999999);
	
	JTextField nameTextField, fnameTextField, 
	salaryTextField, addressTextField, phoneTextField, 
	emailTextField, designationTextField, AdharTextField; 
	
	JButton addDetails, back;
	
	JDateChooser dcdob;
	
	JComboBox<String> comboBox;
	
	JLabel employeeIdtext;
	
	public AddEmp() 
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading= new JLabel("Add New Employee Details");
		heading.setBounds(200, 10, 400, 50);
		heading.setFont(new Font("serif", Font.BOLD, 25));
		heading.setForeground(Color.black);
		add(heading);
		
		JLabel name= new JLabel("Name:");
		name.setBounds(50, 100, 50, 30);
		add(name);
		
		nameTextField= new JTextField();
		nameTextField.setBounds(120, 100, 150, 30);
		add(nameTextField);
		
		JLabel fname= new JLabel("Father's Name:");
		fname.setBounds(350, 100, 100, 30);
		add(fname);
		
		fnameTextField= new JTextField();
		fnameTextField.setBounds(470, 100, 150, 30);
		add(fnameTextField);
		
		JLabel dob= new JLabel("DOB:");
		dob.setBounds(50, 150, 50, 30);
		add(dob);
		
		dcdob= new JDateChooser();
		dcdob.setBounds(120, 150, 150, 30);
		add(dcdob);
		
		JLabel salary= new JLabel("Salary:");
		salary.setBounds(350, 150, 100, 30);
		add(salary);
		
		salaryTextField= new JTextField();
		salaryTextField.setBounds(470, 150, 150, 30);
		add(salaryTextField);
		
		JLabel address= new JLabel("Address:");
		address.setBounds(50, 200, 100, 30);
		add(address);
		
		addressTextField= new JTextField();
		addressTextField.setBounds(120, 200, 150, 30);
		add(addressTextField);
		
		JLabel phone= new JLabel("Phone:");
		phone.setBounds(350, 200, 100, 30);
		add(phone);
		
		phoneTextField= new JTextField();
		phoneTextField.setBounds(470, 200, 150, 30);
		add(phoneTextField);
		
		JLabel email= new JLabel("Email:");
		email.setBounds(50, 250, 100, 30);
		add(email);
		
		emailTextField= new JTextField();
		emailTextField.setBounds(120, 250, 150, 30);
		add(emailTextField);
		
		JLabel highestEdu= new JLabel("Highest Education:");
		highestEdu.setBounds(350, 250, 100, 30);
		add(highestEdu);
		
		String courses[]= {"Btech", "Mtech", "BCA","MCA","BSc","MSc"};
		comboBox= new JComboBox<String>(courses);
		comboBox.setBackground(Color.white);
		comboBox.setBounds(470, 250, 150, 30);
		add(comboBox);
		
		JLabel designation= new JLabel("Designation:");
		designation.setBounds(50, 300, 50, 30);
		add(designation);
		
		designationTextField= new JTextField();
		designationTextField.setBounds(120, 300, 150, 30);
		add(designationTextField);
		
		JLabel AdharCard= new JLabel("Adhar Card No:");
		AdharCard.setBounds(350, 300, 100, 30);
		add(AdharCard);
		
		AdharTextField= new JTextField();
		AdharTextField.setBounds(470, 300, 150, 30);
		add(AdharTextField);
		
		JLabel employeeId= new JLabel("Emp Id:");
		employeeId.setBounds(50, 350, 100, 30);
		add(employeeId);
		
		employeeIdtext= new JLabel(""+number);
		employeeIdtext.setBounds(120, 350, 100, 30);
		add(employeeIdtext);
		
		addDetails= new JButton("Add Details");
		addDetails.setBounds(180, 450, 150, 40);
		addDetails.setBackground(Color.black);
		addDetails.setForeground(Color.white);
		addDetails.addActionListener(this);
		add(addDetails);
		
		back= new JButton("Back");
		back.setBounds(350, 450, 150, 40);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		setSize(700, 550);
		setVisible(true);
		setLocation(300, 100);
		setTitle("EMPLOYMENT MANAGEMENT SYSTEM");
	}

	public static void main(String args[])
	{
		new AddEmp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==addDetails)
		{
			String name=nameTextField.getText();
			String fathersName=fnameTextField.getText();
			String dob= ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
			String salary= salaryTextField.getText();
			String address= addressTextField.getText();
			String phoneNo=phoneTextField.getText();
			String email= emailTextField.getText();
			String highestEdu= (String) comboBox.getSelectedItem();
			String designation= designationTextField.getText();
			String adhar= AdharTextField.getText();
			String empId= employeeIdtext.getText();
			
			try {
				
				conn c= new conn();
				String query="insert into employee values('"+name+"','"+fathersName+"','"+dob+"','"+salary+"','"+address+"','"+phoneNo+"','"+email+"','"+highestEdu+"','"+designation+"','"+adhar+"','"+empId+"')";
				c.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details added successfully!!");
				setVisible(false);
				new home();
				
			} 
			catch (Exception e2) {
				
				e2.printStackTrace();
			}
			
		}
		else
		{
			setVisible(false);
			new home();
		}
		
		
	}
}
