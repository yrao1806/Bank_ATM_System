package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{

    JButton login,signup,clear;  
    JTextField cardtextfield;
    JPasswordField pintext;
   // String pinnumber;
    Login()
    {
         // this.pinnumber=pinnumber;
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text=new JLabel("Welcome to Atm");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 38));
        cardno.setBounds(120,150,250,40);
        add(cardno);
        
        cardtextfield=new JTextField();
        cardtextfield.setBounds(300,150,230,30);
        add(cardtextfield);
        
        pintext=new JPasswordField();
        pintext.setBounds(300,220,230,30);
        add(pintext);
        
        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        JLabel pin=new JLabel("Pin");
        pin.setFont(new Font("Raleway", Font.BOLD, 38));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        
    }
    
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==clear)
            {
              cardtextfield.setText(" ");
              pintext.setText(" ");
            }
            else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardnumber=cardtextfield.getText();
            String pinnumber=pintext.getText();
            String query="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
            try{
              ResultSet rs=  conn.s.executeQuery(query);
              if(rs.next())
              {
                  setVisible(false);
                  new Transaction(pinnumber).setVisible(true);
              }
              else
              {
                 JOptionPane.showMessageDialog(null,"Incorerect Card Number or Pin..");
              }
            }
            catch(Exception e)
             {
                 System.out.println(e);
                
            }
            
            }
            else if(ae.getSource()==signup){
                setVisible(false);
                new signupone().setVisible(true);
            }
        }
   
    public static void main(String args[]) {
        new Login();
    }
}
