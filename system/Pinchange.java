package bank.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Pinchange extends JFrame implements ActionListener{
    JButton change,back;
    String pinnumber;
    JPasswordField pin ,reenter;
    Pinchange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        
        setLayout(null);       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(10,0,850,730);
        add(image);
        
        JLabel text=new JLabel("Enter New Pin ");
        text.setForeground(Color.WHITE);
        text.setBounds(150,235,300,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        pin=new  JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(300,235,200,30);
        add( pin);
        
        
        
        JLabel text2=new JLabel("Re-Enter New Pin ");
        text2.setForeground(Color.WHITE);
        text2.setBounds(150,275,300,35);
        text2.setFont(new Font("System",Font.BOLD,16));
        image.add(text2);
        reenter=new JPasswordField();
        reenter.setFont(new Font("Raleway",Font.BOLD,22));
        reenter.setBounds(300,275,200,30);
        add( reenter);
        
          
        change=new JButton("Change");
        change.setBounds(360,405,130,20);
        change.addActionListener(this);
        image.add(change);
        
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
              
         if(ae.getSource()==change)
        {
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
           try
           {
             String npin=pin.getText();
             String rpin=reenter.getText();
             if(!npin.equals(rpin))
             {
                 JOptionPane.showMessageDialog(null,"Entered Pin does not match");
                 return;
             }
             if(npin.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"Pease Enter Pin..");
                 return;
             }
             if(rpin.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"Re-Enter Pin");
                 return;
             }
             Conn conn=new Conn();
             String query1="UPDATE bank SET pin='"+rpin+"'WHERE pin='"+pinnumber+"'";
             String query2="UPDATE login SET pin='"+rpin+"'WHERE pin='"+pinnumber+"'";
             String query3="UPDATE signupthree SET pin='"+rpin+"'WHERE pin='"+pinnumber+"'";
             
             conn.s.execute(query1);
             conn.s.execute(query2);
             conn.s.execute(query3);
             
             JOptionPane.showMessageDialog(null,"Changed Password Succsessfull");
             setVisible(false);
             new Transaction(rpin).setVisible(true);
            }   
          catch(Exception e)
          {
              System.out.println(e);
          }
        }
         else if(ae.getSource()==back)
         {
             setVisible(false);
             new Transaction(pinnumber).setVisible(true);
         }
             
         
         
         
         
         
         
         
       }

    
    
    
    
    
    public static void main(String args[]) {
        new Pinchange("");
       
    }
}
