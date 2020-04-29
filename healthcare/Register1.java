package healthcare;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class Register1 extends JFrame implements ActionListener
{
	Container c=getContentPane();
	JLabel heading_lbl;
	JLabel name_lbl;
	JLabel fname_lbl;
	JLabel gender_lbl;
	JLabel dob_lbl;
	JLabel add_lbl;
	JLabel phone_lbl;
	JLabel email_lbl;
	JTextField name_txt ;
	JTextField fname_txt;
	JRadioButton male;
	JRadioButton female;
	JComboBox day;
	JComboBox month;
	JComboBox year;
	JTextArea add_txtArea;
	JTextField phone_txt;
	JTextField email_txt;
	JCheckBox chkbox;
	JButton submit_btn;
	JTextArea output_txtArea;
	Register1()
	{
		 setLayoutManager();
		 setLocationAndSize();
		 addActionEvent();
                 setTitle("Patient Registration");
		setVisible(true);
		setBounds(10,10,500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setResizable(true);
	}
	public void setLocationAndSize()
   {
            c.setBackground(Color.pink);     
		 
		
            Font f=new Font("Arial",Font.BOLD,20);  
            JLabel heading_lbl=new JLabel();
            heading_lbl.setBounds(250,5,200,40);
            heading_lbl.setText("<html><font><u><b>Registration Form</b></u></html>");	
            heading_lbl.setFont(f);
		
            Font f1=new Font("Arial",Font.BOLD,14);
            JLabel name_lbl=new JLabel("Name : ");
            name_lbl.setBounds(50,80,100,30); 
            name_txt=new JTextField();
            name_txt.setBounds(180,80,180,30);  
				
				    
            JLabel fname_lbl=new JLabel("Password : ");
            fname_lbl.setBounds(50,120,150,30);  
					
							
            fname_txt=new JTextField();
            fname_txt.setBounds(180,120,180,30);
		 
				
            JLabel gender_lbl=new JLabel("Gender : ");
            gender_lbl.setBounds(50,160,150,30);   
		
							
            Cursor cur=new Cursor(Cursor.HAND_CURSOR);		
            male=new JRadioButton("Male");
            male.setBounds(180,160,70,30);
            male.setBackground(Color.pink);
            male.setCursor(cur);
		
            female=new JRadioButton("Female");
            female.setBounds(280,160,80,30);
            female.setBackground(Color.pink);
            female.setCursor(cur);
		
							
            ButtonGroup gender_grp=new ButtonGroup();
            gender_grp.add(male);    // adding male radio button in the ButtonGroup
            gender_grp.add(female);    // adding female radio button in the ButtonGroup

					
            JLabel dob_lbl=new JLabel("Date of Birth : ");
            dob_lbl.setBounds(50,200,100,30);	
					
							
            String day_arr[]=new String[31];
            for(int i=1;i<=31;i++)
            day_arr[i-1]=Integer.toString(i);		
            day=new JComboBox(day_arr);
            day.setBounds(180,200,40,30);
		
							
            String month_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" };	
            month=new JComboBox(month_arr);
            month.setBounds(230,200,60,30);
		
								
            String year_arr[]=new String[70];
            for(int i=1951;i<=2020;i++)
            year_arr[i-1951]=Integer.toString(i);
            year=new JComboBox(year_arr);
            year.setBounds(300,200,60,30);
		
					
            JLabel add_lbl=new JLabel("Address : ");
            add_lbl.setBounds(50,240,100,30);				
		
							
            add_txtArea= new JTextArea();
            add_txtArea.setBounds(180,240,180,100);
		
					
            JLabel phone_lbl=new JLabel("Phone No. : ");
            phone_lbl.setBounds(50,350,100,30);
		
							
            phone_txt=new JTextField();
            phone_txt.setBounds(180,350,180,30);
		
					
            JLabel email_lbl=new JLabel("Disease : ");
            email_lbl.setBounds(50,390,100,30);
							
							
            email_txt=new JTextField();
            email_txt.setBounds(180,390,180,30);					
				
				    		
            chkbox=new JCheckBox("The above given information are true to my knowledge");
            chkbox.setBounds(50,430,600,30);
            chkbox.setBackground(Color.yellow);
		
					
            submit_btn=new JButton("Submit");
            submit_btn.setBounds(180,500,120,40);
            submit_btn.setCursor(cur); 
							
					
								
							
					
            output_txtArea=new JTextArea();
            output_txtArea.setBounds(380,80,260,320);
		
            name_lbl.setFont(f1);
            fname_lbl.setFont(f1);
            gender_lbl.setFont(f1);
            dob_lbl.setFont(f1);
            add_lbl.setFont(f1);
            phone_lbl.setFont(f1);
            email_lbl.setFont(f1);
						
				 
            name_txt.setFont(f1);
            fname_txt.setFont(f1);
            male.setFont(f1);
            female.setFont(f1);
            add_txtArea.setFont(f1);
            phone_txt.setFont(f1);
            email_txt.setFont(f1);
            chkbox.setFont(f1);
            submit_btn.setFont(f1);
            output_txtArea.setFont(f1);
							
            c.add(heading_lbl);	
            c.add(name_lbl);			
            c.add(fname_lbl);
            c.add(gender_lbl);
            c.add(male);
            c.add(female);
            c.add(dob_lbl);
            c.add(add_lbl);
            c.add(phone_lbl);
            c.add(email_lbl);
		
            c.add(name_txt);
            c.add(name_txt);
            c.add(fname_txt);
            c.add(day);
            c.add(month);
            c.add(year);
            c.add(add_txtArea);
            c.add(phone_txt);
            c.add(email_txt);
            c.add(chkbox);
            c.add(submit_btn);
            c.add(output_txtArea);
		
   }
   public void addActionEvent()
   {
       submit_btn.addActionListener(this);
   }
 
	public void setLayoutManager()
   {
       
       c.setLayout(null);
   }
	public void actionPerformed(ActionEvent e)
	{
		 //Coding Part of LOGIN button
		if(e.getSource()==submit_btn)
		{
			if(chkbox.isSelected()==true)
			{
				String name=name_txt.getText();
				String fname=fname_txt.getText();
				String gender="Male";
				if(female.isSelected()==true)
					gender="Female";
				String day_name=(String)day.getSelectedItem();
				String month_name=(String)month.getSelectedItem();
				String year_name=(String)year.getSelectedItem();
				String add=add_txtArea.getText();
				String phone=phone_txt.getText();
				String email=email_txt.getText();
				
				
				// displaying value in the JTextArea
				output_txtArea.setText(" Name :   " +name + "\n Password :  " +fname + "\n Gender :   "+gender +
                                        				"\n Date of Birth :   "+day_name + "  "+month_name + " " +year_name +  
														"\n Address :  "+add + " \n Phone no :  "+phone + 
														"\n Email :  "+email + "\n ");
                         try
                        {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","srividhya");
                            Statement stmt=con.createStatement();
                            stmt.executeUpdate("INSERT INTO jdbc VALUES ('"+ name +"','"+fname+"','"+gender+"','"+day_name+"','"+month_name+"','"+year_name+"','"+add+"','"+phone+"','"+email+"')");
                            con.close();
                        }
                        catch(Exception ae)
                        {
                            System.out.println(ae);
                        }
			}
			else
			{
				output_txtArea.setText("Please accept the terms and condition");
	
                        }

	}
	}
}
