package com.ayushi.EMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateEmp extends JFrame implements ActionListener{
	
	JTextField salaryTextField, addressTextField, phoneTextField, 
	emailTextField, designationTextField, edu; 
	
	JButton updateDetails, back;
	
	JLabel employeeIdtext, fixname, fixfathersname, fixdob, fixaadhar, fixempId;
	String empId;
	
	public UpdateEmp(String empId) 
	{
		this.empId=empId;
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading= new JLabel("Update Employee Details");
		heading.setBounds(200, 10, 400, 50);
		heading.setFont(new Font("serif", Font.BOLD, 25));
		heading.setForeground(Color.black);
		add(heading);
		
		JLabel name= new JLabel("Name:");
		name.setBounds(50, 100, 50, 30);
		add(name);
		
		fixname= new JLabel();
		fixname.setBounds(120, 100, 150, 30);
		add(fixname);
		
		JLabel fname= new JLabel("Father's Name:");
		fname.setBounds(350, 100, 100, 30);
		add(fname);
		
		fixfathersname= new JLabel();
		fixfathersname.setBounds(470, 100, 150, 30);
		add(fixfathersname);
		
		JLabel dob= new JLabel("DOB:");
		dob.setBounds(50, 150, 50, 30);
		add(dob);
		
		fixdob= new JLabel();
		fixdob.setBounds(120, 150, 150, 30);
		add(fixdob);
		
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
		
		//String courses[]= {"Btech", "Mtech", "BCA","MCA","BSc","MSc"};
		//comboBox= new JComboBox<String>(courses);
		edu= new JTextField();
		edu.setBounds(470, 250, 150, 30);
		add(edu);
		
		JLabel designation= new JLabel("Designation:");
		designation.setBounds(50, 300, 50, 30);
		add(designation);
		
		designationTextField= new JTextField();
		designationTextField.setBounds(120, 300, 150, 30);
		add(designationTextField);
		
		JLabel AdharCard= new JLabel("Adhar Card No:");
		AdharCard.setBounds(350, 300, 100, 30);
		add(AdharCard);
		
		fixaadhar= new JLabel();
		fixaadhar.setBounds(470, 300, 150, 30);
		add(fixaadhar);
		
		JLabel employeeId= new JLabel("Emp Id:");
		employeeId.setBounds(50, 350, 100, 30);
		add(employeeId);
		
		fixempId= new JLabel();
		fixempId.setBounds(120, 350, 100, 30);
		add(fixempId);
		
		
		try 
		{
			String query="Select * from employee where EmpId='"+empId+"'";
			conn c= new conn();
			ResultSet rs=c.statement.executeQuery(query);
			while (rs.next()) 
			{
				fixname.setText(rs.getString("EmpName"));
				fixfathersname.setText(rs.getString("FathersName"));
				fixdob.setText(rs.getString("DateOfBirth"));
				salaryTextField.setText(rs.getString("Salary"));
				addressTextField.setText(rs.getString("Address"));
				phoneTextField.setText(rs.getString("PhoneNumber"));
				emailTextField.setText(rs.getString("Email"));
				edu.setText(rs.getString("HighestEducation"));
				designationTextField.setText(rs.getString("Designation"));
				fixaadhar.setText(rs.getString("AdharNumber"));
				fixempId.setText(rs.getString("EmpId"));
				
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		updateDetails= new JButton("Update Details");
		updateDetails.setBounds(180, 450, 150, 40);
		updateDetails.setBackground(Color.black);
		updateDetails.setForeground(Color.white);
		updateDetails.addActionListener(this);
		add(updateDetails);
		
		back= new JButton("Back");
		back.setBounds(350, 450, 150, 40);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		setSize(700, 550);
		setVisible(true);
		setLocation(300, 100);
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
	}

	public static void main(String args[])
	{
		new UpdateEmp("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==updateDetails)
		{
			//String name=nameTextField.getText();
			//String fathersName=fnameTextField.getText();
			//String dob= ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
			String salary= salaryTextField.getText();
			String address= addressTextField.getText();
			String phoneNo=phoneTextField.getText();
			String email= emailTextField.getText();
			String highestEdu= edu.getText();
			String designation= designationTextField.getText();
			//String adhar= AdharTextField.getText();
			//String empId= employeeIdtext.getText();
			
			try {
				
				String query="update employee set Salary='"+salary+"',Address='"+address+"',PhoneNumber='"+phoneNo+"',Email='"+email+"',HighestEducation='"+highestEdu+"',Designation='"+designation+"' where EmpId='"+empId+"'";
				conn c= new conn();
				c.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details updated successfully!!");
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
