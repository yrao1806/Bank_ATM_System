
package bank.management.system;
import javax.swing.*;   //JFarame
import java.awt.*;  //Image 
import java.awt.event.*;
import java.util.*;
public class Transaction extends JFrame implements ActionListener{
JButton  deposit,withdrawl,   fastcash,ministatement,pinchange,balanceenquery,exit;
String pinnumber;
    Transaction(String pinnumber)
    {    
        this.pinnumber=pinnumber;
        setLayout(null);       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(10,0,850,730);
        add(image);
        
        JLabel text=new JLabel("Please select your Transaction");
        text.setForeground(Color.WHITE);
        text.setBounds(180,190,300,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposite");
        deposit.setBounds(130,338,100,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(360,338,130,20);
         withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(130,370,100,20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(360,370,130,20);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(130,405,100,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquery=new JButton("Balance Enquery");
        balanceenquery.setBounds(360,405,130,20);
        balanceenquery.addActionListener(this);
        image.add(balanceenquery);
        
        exit=new JButton("Exit");
        exit.setBounds(360,437,130,20);
        exit.addActionListener(this);
        image.add(exit);
       
        
        
         setSize(850,950);
         setLocation(300,0);
         setUndecorated(true); //Upar me cut minimize ya bada karne wala nahi dikhega
         setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
           System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
         }
        else if(ae.getSource()==pinchange)
        {
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquery)
        {
            setVisible(false);
            new BalanceEnquery(pinnumber).setVisible(true);
        }
         else if(ae.getSource()==ministatement)
        {
           // setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    
    
    }
    public static void main(String args[]) {
       new Transaction("");
    }
}
