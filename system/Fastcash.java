
package bank.management.system;
import javax.swing.*;   //JFarame
import java.awt.*;  //Image 
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class Fastcash extends JFrame implements ActionListener{
JButton  deposit,withdrawl,   fastcash,ministatement,pinchange,balanceenquery,exit;
String pinnumber;
    Fastcash(String pinnumber)
    {     
        this.pinnumber=pinnumber;
        setLayout(null);       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(10,0,850,730);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setForeground(Color.WHITE);
        text.setBounds(180,230,300,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("100");
        deposit.setBounds(130,338,100,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("500");
        withdrawl.setBounds(360,338,130,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("1000");
        fastcash.setBounds(130,370,100,20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("2000");
        ministatement.setBounds(360,370,130,20);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("5000");
        pinchange.setBounds(130,405,100,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquery=new JButton("10000");
        balanceenquery.setBounds(360,405,130,20);
        balanceenquery.addActionListener(this);
        image.add(balanceenquery);
        
        exit=new JButton("Back");
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
              setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else 
        {
            
            try{
                String ammount=((JButton)ae.getSource()).getText().substring(3);
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance=0;
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
                if(ae.getSource()!=exit && balance<Integer.parseInt(ammount) )
                {
                    JOptionPane.showMessageDialog(null,"Insuffcient Balance");
                     return ;
                }
               
                        Date date =new Date();
                        String query="insert into bank values('"+pinnumber+"','"+date+"','"+withdrawl+"','"+ammount+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rs "+ammount+"Debited Successful..");
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    
              }
            catch(Exception e)
            {
                System.out.println(e);
                
            }
        }
    }
    
    
    
    public static void main(String args[]) {
       new Fastcash("");
    }
}
