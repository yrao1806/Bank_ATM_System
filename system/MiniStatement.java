
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class MiniStatement extends JFrame{

    String pinnumber;
    MiniStatement(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("MINI STATEMENT..");
        setLayout(null);
        
        JLabel text=new JLabel();
        add(text);
        
        JLabel bank=new JLabel("bank Of Broda");
        bank.setBounds(150,20,100,20);
        add(bank);
              
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
               
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from login where pin='1746'");
            while(rs.next())
            {
                card.setText("Card Number: XXXXXXXXXXX"+rs.getString("cardnumber").substring(11,15));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
          try{
              int bal=0;
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next())
            {
                text.setText(text.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("ammount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit"))
                    {
                    bal+=Integer.parseInt(rs.getString("ammount"));
                     }
                    else
                    {
                      bal-=Integer.parseInt(rs.getString("ammount"));
                      
                    }
            }
            balance.setText("Your Current Account Balance is : "+bal);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
          
          text.setBounds(20,140,400,200);
       
        
        
     setSize(400,600);
     setLocation(20,40);
     getContentPane().setBackground(Color.WHITE);
     setVisible(true);
    }
    public static void main(String args[]) 
    {
        new MiniStatement("");
    }
}
