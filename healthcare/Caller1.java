package healthcare;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.util.*;

public class Caller1 extends Thread {
    public static void main(String args[])
	{
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                x1 obj=new x1();
                Thread t=new Thread(obj);
                try
                {
                    t.start();
                    t.sleep(50);
                }
                catch(InterruptedException de)
                {
                    System.out.println(de);
                }
            }
        });
	}
}
class x1 extends JFrame implements ActionListener,Runnable{
   
    Container c=getContentPane();
    JLabel l1=new JLabel("HEALTHCARE ORGANISATION");
    JButton b1=new JButton("Patient Registration");
    JButton b2=new JButton("Fix Appointment");
   
    
	public void run()
	{
		addComponentsToContainer();
                addActionEvent();
            setLayout(null);
                 setVisible(true);
                 setBounds(10,10,500,1000);  
	}
        
        public void addComponentsToContainer()
        {
             l1.setBounds(200,10,500,60);
             l1.setForeground(Color.yellow);
             b1.setBounds(50,150,200,30);
             b2.setBounds(50,250,200,30);
            c.setBackground(Color.gray);
            c.add(l1);
            c.add(b1);
            c.add(b2);
        }
       
        public void addActionEvent()
        {
            b1.addActionListener(this);
            b2.addActionListener(this);
        }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {
                new Register1();
                dispose();
            }
            if(e.getSource()==b2)
            {
                new patient1();
                dispose();
            }
        }
}