package bank.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener{
    JButton withdrwa,back;
    String pinnumber;
    JTextField amount;
      Withdrawl(String pinnumber)
    {
        this.pinnumber=pinnumber;
        
        setLayout(null);       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(10,0,850,730);
        add(image);
        
        JLabel text=new JLabel("Enter Amount You Want To Withdraw ");
        text.setForeground(Color.WHITE);
        text.setBounds(150,220,300,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(180,270,200,30);
        add( amount);
        
        withdrwa=new JButton("Withdraw");
        withdrwa.setBounds(360,405,130,20);
        withdrwa.addActionListener(this);
        image.add( withdrwa);
        
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
        if(ae.getSource()== withdrwa)
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
           String query = "insert into bank values('"+pinnumber+"','"+date+"',' Withdrawl','"+number+"')";
           conn.s.executeUpdate(query);
        
          JOptionPane.showMessageDialog(null,"Rs : "+number+" withdraw Successfully");//user can see
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
        new Withdrawl("");
       
    }
}
