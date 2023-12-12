package bank.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class BalanceEnquery extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    BalanceEnquery(String  pinnumber)
    {
        this. pinnumber= pinnumber;
        
        setLayout(null);       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(10,0,850,730);
        add(image);
        
        back=new JButton("Back");
        back.setBounds(360,437,130,20);
        back.addActionListener(this);
        image.add(back);
       
         
         int balance=0;
         try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                while(rs.next())     //bank se balance table (row) pe loop
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                    balance+=Integer.parseInt(rs.getString("ammount"));
                     }
                    else
                    {
                      balance-=Integer.parseInt(rs.getString("ammount"));
                      
                    }
                }
         }
         catch(Exception ae){
             System.out.println(ae);
         }
         
         JLabel text=new JLabel("Your Account Balance is Rs  "+balance);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         text.setBounds(160,280,300,30);
         image.add(text);
    
       
         setSize(850,950);
         setLocation(300,0);
         setUndecorated(true); //Upar me cut minimize ya bada karne wala nahi dikhega
         setVisible(true);
      }
    
     public void actionPerformed(ActionEvent ae)
      {      
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
        }
         
    public static void main(String args[]) {
        new BalanceEnquery("");
       
    }
}
