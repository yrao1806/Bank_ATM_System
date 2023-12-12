package bank.management.system;
import javax.swing.*;              //JLabel JFrame
import java.awt.*;          //Font
import java.awt.event.*;  //ActionListener
import java.util.*;      //Random
public class signupthree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    signupthree(String formno)
    {
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page 3:Account details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400, 40);
        add(l1);
         
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200, 40);
        add(type);
        r1=new JRadioButton(" Saving Account");
        r1.setBounds(100,180,120,20);
        r1.setBackground(Color.WHITE);
        add(r1);
        r2=new JRadioButton(" Fixed Deposite Account");
        r2.setBounds(350,180,180,20);
        r2.setBackground(Color.WHITE);
        add(r2);
        r3=new JRadioButton(" Current Account");
        r3.setBounds(100,220,150,20);
        r3.setBackground(Color.WHITE);
        add(r3);
        r4=new JRadioButton(" Recurring Deposite Account");
        r4.setBounds(350,220,200,20);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,280,200, 40);
        add(card);
        JLabel cnumber=new JLabel("XXXX XXXX XXXX 4183");
        cnumber.setFont(new Font("Raleway",Font.BOLD,22));
        cnumber.setBounds(300,280,280, 40);
        add(cnumber);
        
        JLabel pin=new JLabel("Pin Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,360,200, 40);
        add(pin);
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(300,360,280, 40);
        add(pnumber);
        
        JLabel srequired=new JLabel("Services Required:");
        srequired.setFont(new Font("Raleway",Font.BOLD,22));
        srequired.setBounds(100,440,280, 40);
        add(srequired);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        c2=new JCheckBox("Net Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(100,530,200,30);
        add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,560,200,30);
        add(c3);
        c4=new JCheckBox("Email And SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,500,200,30);
        add(c4);
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(350,530,200,30);
        add(c5);
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Releway",Font.BOLD,16));
        c6.setBounds(350,560,200,30);
        add(c6);
        
        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge ");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,10));
        c7.setBounds(100,600,800,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Releway",Font.BOLD,14));
        submit.setBounds(100,650, 100,25);
        submit.addActionListener(this);
        add(submit);
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Releway",Font.BOLD,14));
        cancel.setBounds(700,650, 100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        
    setSize(850,730);
    setLocation(350,0);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==submit)
        {
            String accounttype=null;
            if(r1.isSelected())
            {
                accounttype="Saving Account";
            }
             else if(r2.isSelected())
            {
                accounttype="Fixed Deposite Account";
            }
             else if(r3.isSelected())
            {
                accounttype="Current Account";
            }
             else if(r4.isSelected())
            {
                accounttype="Recurring Deposite Account";
            }
             else if(r1.isSelected())
            {
                accounttype="Saving Account";
            }
       
      Random random=new Random();
      String cardnumber=""+ Math.abs ((random.nextLong() % 9000L ) + 443001000000000L);
      String pinnumber=""+ Math.abs ((random.nextLong() % 9000L ) + 10000L);
      
      String facility="";
      if(c1.isSelected())
      {
          facility=facility+"ATM CARD";
      }
      else if(c2.isSelected())
      {
          facility=facility+"Net Banking";
      }
       else if(c3.isSelected())
      {
          facility=facility+"Mobile Banking";
      }
        else if(c4.isSelected())
      {
          facility=facility+"Email And SMS Alert";
      }
         else if(c5.isSelected())
      {
          facility=facility+"Cheque Book";
      }
          else if(c6.isSelected())
      {
          facility=facility+"E-Statement";
      }
           else if(c1.isSelected())
      {
          facility=facility+"ATM CARD";
      }
       try{
        if(accounttype.equals(""))
        JOptionPane.showMessageDialog(null,"Account type is required");
        else
        {
            Conn conn = new Conn();
           String query = "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
           String query2 = "insert into login values('"+cardnumber+"','"+pinnumber+"')";

           conn.s.executeUpdate(query);
            conn.s.executeUpdate(query2);
           
           setVisible(false);
           new Deposit(pinnumber).setVisible(true);

        }
         JOptionPane.showMessageDialog(null,"Card Number : "+cardnumber+"\n Pin :"+pinnumber);//user can see
       }
       catch(Exception e)
       {
           System.out.println(e);
           
       }
     }
       
        else  if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
  }
  public static void main(String args[]) {
       new  signupthree("");
         
        
    }
}
