package healthcare;
//import swing2.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.*;
import java.io.IOException;
class patient1 extends JFrame implements ActionListener
{
	Container container=getContentPane();
	JLabel l1=new JLabel("LOGIN PORTAL");
	 JLabel userLabel=new JLabel("USERNAME");
	 JLabel passwordLabel=new JLabel("PASSWORD");
     JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");
    public static String userText;
	patient1()
	{
		 setLayoutManager();
		 setLocationAndSize();
		 addComponentsToContainer();
                 addActionEvent();
		 setVisible(true);
	     setBounds(10,10,500,1000);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setResizable(false);
                 
	}
	public void setLocationAndSize()
   {
       //Setting location and Size of each components using setBounds() method.
   		l1.setBounds(75,10,500,60);
       userLabel.setBounds(50,150,100,30);
       passwordLabel.setBounds(50,220,100,30);
       userTextField.setBounds(150,150,150,30);
       passwordField.setBounds(150,220,150,30);
       showPassword.setBounds(150,260,150,30);
       loginButton.setBounds(50,350,100,30);
       resetButton.setBounds(300,350,100,30);
   }
   public void addActionEvent()
   {
      //adding Action listener to components
       loginButton.addActionListener(this);
       resetButton.addActionListener(this);
       showPassword.addActionListener(this);
   }
   public void addComponentsToContainer()
   {
      //Adding each components to the Container
   		container.add(l1);
   		l1.setFont(new Font("Courier New",Font.BOLD,25));
   		l1.setForeground(Color.cyan);
   		container.setBackground(Color.gray);
   		container.add(userLabel);
      // container.add(userLabel);
       container.add(passwordLabel);
       container.add(userTextField);
       container.add(passwordField);
       container.add(showPassword);
       container.add(loginButton);
       container.add(resetButton);
   }
	public void setLayoutManager()
   {
       
       container.setLayout(null);
   }
	public void actionPerformed(ActionEvent e)
	{
		 //Coding Part of LOGIN button
		int flag=0;
		//int a=5;
		//String bb[]={"Sri","Vidhya","Malathy","Rajavel","Priya"};
		//String pwd[]={"secret","vid05","M3456","7890","pr18"};
        if (e.getSource() == loginButton) 
        {
            //String userText;
            String pwdText;
            String u,p;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","srividhya");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select *from jdbc");
            while(rs.next())
            {
                u=rs.getString(1);
                p=rs.getString(2);
                if (userText.equalsIgnoreCase(u) && pwdText.equalsIgnoreCase(p)) 
             	{
                	
                	flag=1;
                	break;
            	}
            }
            if(flag==1)
            {
            	JOptionPane.showMessageDialog(this, "Login Successful" );
                new App();
                dispose();
                LogManager lm = LogManager.getLogManager();
					Logger l = Logger.getLogger("collections.class");
					FileHandler fh = new FileHandler("Report.txt");
					//ConsoleHandler ch = new ConsoleHandler();
					fh.setFormatter(new SimpleFormatter());
					//ch.setFormatter(new SimpleFormatter());
					l.addHandler(fh);
					//l.addHandler(ch);
					l.info("VALID PASSWORD");
					try
					{
						throw new Exception("LEGAL AUTHORIZATION");
					}catch(Exception xe)
					{
						l.log(Level.SEVERE,xe.getMessage(),xe);
					}
					//l.info("PASSWORD USED IS "+password.toUpperCase());
            }
            else 
            {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                LogManager lm = LogManager.getLogManager();
					Logger l = Logger.getLogger("patient1");
					FileHandler fh = new FileHandler("Report.txt");
					//ConsoleHandler ch = new ConsoleHandler();
					fh.setFormatter(new SimpleFormatter());
					//ch.setFormatter(new SimpleFormatter());
					l.addHandler(fh);
					//l.addHandler(ch);
					l.info("INVALID PASSWORD");
					try
					{
						throw new Exception("ILLEGAL AUTHORIZATION");
					}catch(Exception me)
					{
						l.log(Level.SEVERE,me.getMessage(),me);
					}
					//l.info("PASSWORD USED IS "+password.toUpperCase());
            }
            con.close();
        }
        catch(Exception se)
        {
            System.out.println(se);
        }
           /* for(int i=0;i<5;i++)
            {
             	if (userText.equalsIgnoreCase(bb[i]) && pwdText.equalsIgnoreCase(pwd[i])) 
             	{
                	
                	flag=1;
                	break;
            	}
            }*/
			
           /* if(flag==1)
            {
            	JOptionPane.showMessageDialog(this, "Login Successful" );
                
            }
            else 
            {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }*/
       	}
 
     
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
 	}
	}
}
public class login extends patient1{
	//public static void main(String args[])
	//{
		patient1 frame=new patient1();
                public static String us=userText;
		/*frame.setTitle("Patient Login");
		frame.setVisible(true);
		frame.setBounds(10,10,500,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);*/
	//}
}
