package healthcare;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import java.io.IOException;
import healthcare.*;
import java.sql.*;
class App extends JFrame implements ActionListener
{ 
    Container c=getContentPane();
    JLabel heading_lbl;
    JLabel name_lbl;
    JTextField name_txt ;
    JLabel date_lbl;
    JComboBox day;
    JComboBox month;
    JComboBox year;
    JLabel time_lbl;
    JComboBox time;
    JLabel doc_lbl;
    JComboBox doctor;
  JButton submit_bt;
    JTextArea output_txtArea;
    String t[] = new String[50];
    String d[]=new String[50];
    App()
    {
                setLayoutManager();
		setLocationAndSize1();
		addActionEvent();
                 setTitle("Appointment Form");
		setVisible(true);
		setBounds(10,10,500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setResizable(true);
    }
    public void setLocationAndSize1()
    {
        c.setBackground(Color.pink); 
        Font f=new Font("Arial",Font.BOLD,20);   // Creating font style and size for heading
		
					// step 3 : creating JLabel for Heading
	JLabel heading_lbl=new JLabel();
	heading_lbl.setBounds(250,5,200,40);
	heading_lbl.setText("<html><font><u><b>Registration Form</b></u></html>");	
		
							// applying font on  heading Label
	heading_lbl.setFont(f);
		
		/* ----------------------------------- Creating Global Font style for all components ------------------------------ */

	Font f1=new Font("Arial",Font.BOLD,14);
		 
		/* ----------------------------------- Creating components for Registration details ---------------------------------- */
					
					// Step 4 : Creating JLabel for Name
	JLabel name_lbl=new JLabel("Name : ");
	name_lbl.setBounds(50,80,100,30); 
	
							// Creating JTextField for Name
	name_txt=new JTextField();
	name_txt.setBounds(180,80,180,30);  
	JLabel date_lbl=new JLabel("Date : ");
	date_lbl.setBounds(50,120,150,30);  
        // Creating JComboBox for the day
	String day_arr[]=new String[31];
	for(int i=1;i<=31;i++)
	day_arr[i-1]=Integer.toString(i);		
	day=new JComboBox(day_arr);
	day.setBounds(180,120,40,30);
		
	// Creating JComboBox for the month
	String month_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" };	
	month=new JComboBox(month_arr);
	month.setBounds(230,120,60,30);
		
	// Creating JComboBox for the year	
	String year_arr[]=new String[70];
        for(int i=1951;i<=2020;i++)
	year_arr[i-1951]=Integer.toString(i);
	year=new JComboBox(year_arr);
	year.setBounds(300,120,60,30);
        
	JLabel time_lbl=new JLabel("Time : ");
	time_lbl.setBounds(50,160,150,30);  
        t[0]="9am";
        t[1]="11am";
        t[2]="1pm";
        t[3]="3pm";
        t[4]="5pm";
        t[5]="7pm";
        t[6]="9pm";
        time=new JComboBox(t);
        time.setBounds(180,160,60,30);
        /*for (int j= 0 ; j< 7; j++)
        { 
            time.addItem(t[j]);
        } */
        
        JLabel doc_lbl=new JLabel("Doctor: ");
	doc_lbl.setBounds(50,200,100,30);
        d[0]="Opthalmologist";
        d[1]="Paediatrician";
        d[2]="Gynaecologist";
        d[3]="Cardiologist";
        d[4]="Orthopedist";
        d[5]="Dermatologist";
        d[6]="Dentist";
        d[7]="General Physician";
        d[8]="Neurologist";
        d[9]="Oncologist";
        d[10]="Otolaryngologists";
        d[11]="Psychiatrists";
        doctor=new JComboBox(d);
        doctor.setBounds(180,200,130,30);
        /*for (int k= 0 ; k< 7; k++)
        { 
            doctor.addItem(d[k]);
        } */
       submit_bt=new JButton("SUBMIT");
	submit_bt.setBounds(180,240,120,30);
        //submit_bt.setCursor(cur);
        output_txtArea=new JTextArea();
	output_txtArea.setBounds(380,80,260,320);
        name_lbl.setFont(f1);
	date_lbl.setFont(f1);
	time_lbl.setFont(f1);
        doc_lbl.setFont(f1);
        name_txt.setFont(f1);
        name_txt.setText(login.us);
        submit_bt.setFont(f1);
	output_txtArea.setFont(f1);
        c.add(heading_lbl);	
	c.add(name_lbl);
        c.add(date_lbl);
        c.add(time_lbl);
        c.add(doc_lbl);
        c.add(name_txt);
        c.add(day);
	c.add(month);
	c.add(year);
        c.add(time);
        c.add(doctor);
       c.add(submit_bt);
        c.add(output_txtArea);
    }
    public void addActionEvent()
   {
      //adding Action listener to components
       submit_bt.addActionListener(this);
   }
 
	public void setLayoutManager()
   {
       
       c.setLayout(null);
   }
        //@Override
        public void actionPerformed(ActionEvent ce)
        {
            int flag=0;
            if(ce.getSource()==submit_bt)
            {
                String name=name_txt.getText();
                String day_name=(String)day.getSelectedItem();
		String month_name=(String)month.getSelectedItem();
                String year_name=(String)year.getSelectedItem();
                String tim=(String)time.getSelectedItem();
                String doct=(String)doctor.getSelectedItem();
                output_txtArea.setText("Name :   " +name +"\n Date of Appointment :   "+day_name + "  "+month_name + " " +year_name +"\n Time:  "+tim + " \n Doctor :  "+doct +"\n ");  													
                
                try
                        {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","srividhya");
                            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select *from fix");
            while(rs.next())
            {
                String u=rs.getString(1);
                String da=rs.getString(2);
                String m=rs.getString(3);
                String y=rs.getString(4);
                String ti=rs.getString(5);
                String doc=rs.getString(6);
                if (day_name.equals(da)&&month_name.equals(m)&&year_name.equals(y)&&tim.equals(ti)&&doct.equals(doc)) 
             	{
                	
                	flag=1;
                	break;
            	}
            }
            if(flag == 0){
                            Statement stmt2=con.createStatement();
                            stmt2.executeUpdate("INSERT INTO fix VALUES ('"+ name +"','"+day_name+"','"+month_name+"','"+year_name+"','"+tim+"','"+doct+"')");
                           JOptionPane.showMessageDialog(this, "Appointment fixed"); 
                           System.out.println("FIXED APPOINTMENT!!!");
					LogManager lm = LogManager.getLogManager();
					Logger l = Logger.getLogger("App");
					FileHandler fh = new FileHandler("Appointment.txt");
					ConsoleHandler ch = new ConsoleHandler();
					fh.setFormatter(new SimpleFormatter());
					ch.setFormatter(new SimpleFormatter());
					l.addHandler(fh);
					l.addHandler(ch);
					l.info("CONSULT THE DOCTOR WITHOUT FAIL");
					try
					{
						throw new Exception("FIXED APPOINTMENT");
					}catch(Exception e)
					{
						l.log(Level.SEVERE,e.getMessage(),e);
					}
            }
            if(flag==1)
            {
                JOptionPane.showMessageDialog(this, "Appointment cannot be fixed");
                System.out.println("FIX YOUR APPOINTMENT AT SOME OTHER TIME!!!");
					LogManager lm = LogManager.getLogManager();
					Logger l = Logger.getLogger("App");
					FileHandler fh = new FileHandler("ReportAppointment.txt");
					ConsoleHandler ch = new ConsoleHandler();
					fh.setFormatter(new SimpleFormatter());
					ch.setFormatter(new SimpleFormatter());
					l.addHandler(fh);
					l.addHandler(ch);
					l.info("APPOINTMENT NOT AVAILABLE");
					try
					{
						throw new Exception("CAN'T FIX APPOINTMENT");
					}catch(Exception e)
					{
						l.log(Level.SEVERE,e.getMessage(),e);
					}
					//l.info("PASSWORD USED IS "+password.toUpperCase());
            }
            con.close();
                        }
                        catch(Exception ae)
                        {
                            System.out.println(ae);
                        }
            }
            
        }
}

