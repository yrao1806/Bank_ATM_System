package bank.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
    JButton deposit,back;
    String pinnumber;
    JTextField amount;
    Deposit(String pinnumber)
    {
        this.pinnumber=pinnumber;
        
        setLayout(null);       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(10,0,850,730);
        add(image);
        
        JLabel text=new JLabel("Enter Ammount ");
        text.setForeground(Color.WHITE);
        text.setBounds(180,300,300,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(180,335,200,30);
        add( amount);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(360,405,130,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("Back");
        back.setBounds(360,437,130,20);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        
        
         setSize(850,950);
         setLocation(300,0);
         setUndecorated(true); //Upar me cut minimize ya bada karne wala nahi dikhega
         setVisible(true);
    }
    
    
    
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==deposit)
        {
          String number=amount.getText();
          Date date=new Date();
          if(number.equals(""))
          {
              JOptionPane.showMessageDialog(null,"Plese Enter Amount");
          }
          else{
          try{
           Conn conn = new Conn();
           String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
           conn.s.executeUpdate(query);
        
          JOptionPane.showMessageDialog(null,"Rs : "+number+"  Deposited Successfully");//user can see
          System.out.println(number);
          setVisible(false);
          new Transaction(pinnumber).setVisible(true);
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
       }
       }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    
    
    }
    
    
    public static void main(String args[]) {
        new Deposit("");
       
    }
}
