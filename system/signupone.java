package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class signupone extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fatherNameTextField,emailText,addressText,cityText,pinText,stateText;
    JButton next;
    JRadioButton male,female,married,unmarried,others;
    JDateChooser datechooser;
    signupone()
    {
     
        setLayout(null);
        Random ran = new Random();
        random = Math.abs ((ran.nextLong() % 9000L ) + 1000L);
        JLabel formno=new JLabel("Application Form. "+random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personal=new JLabel("Page 1. Personal details ");
        personal.setFont(new Font("Raleway", Font.BOLD, 22));
        personal.setBounds(290,80,400,30);
        add(personal);
        
        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100,140,100,30);
        add(name);
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,22));
        nameTextField.setBounds(300,140,500,30);
        add(nameTextField);
        
        
        JLabel fathername=new JLabel("Father's Name: ");
        fathername.setFont(new Font("Raleway", Font.BOLD, 22));
        fathername.setBounds(100,190,200,30);
        add(fathername);
        fatherNameTextField=new JTextField();
        fatherNameTextField.setFont(new Font("Raleway",Font.BOLD,22));
        fatherNameTextField.setBounds(300,190,500,30);
        add(fatherNameTextField);
        
        JLabel dob=new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100,240,200,30);
        add(dob); 
        datechooser=new JDateChooser();
        datechooser.setBounds(300,240,200,30);
        add(datechooser);
        
        JLabel gender=new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100,290,200,30);
        add(gender);
        male=new JRadioButton(" Male ");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        female=new JRadioButton(" Female ");
        female.setBounds(400,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        others=new JRadioButton(" Others");
        others.setBounds(600,290,100,30);
        others.setBackground(Color.WHITE);
        add(others);
        ButtonGroup fem=new ButtonGroup();
        fem.add(male);
        fem.add(female);
        fem.add(others);
        
        
        
        JLabel email=new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100,340,200,30);
        add(email);
        emailText=new JTextField();
        emailText.setFont(new Font("Raleway",Font.BOLD,22));
        emailText.setBounds(300,340,500,30);
        add(emailText);
        
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100,390,200,30);
        add(marital);
        married=new JRadioButton(" Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried=new JRadioButton(" Unmarried");
        unmarried.setBounds(400,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add( unmarried);
        others=new JRadioButton(" Others");
        others.setBounds(600,390,100,30);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);
        
        
        
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100,440,200,30);
        add(address);
        addressText=new JTextField();
        addressText.setFont(new Font("Raleway",Font.BOLD,22));
        addressText.setBounds(300,440,500,30);
        add(addressText);
        
        
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100,490,200,30);
        add(city);
        cityText=new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD,22));
        cityText.setBounds(300,490,500,30);
        add(cityText);
        
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100,540,200,30);
        add(state);
        stateText=new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,22));
        stateText.setBounds(300,540,500,30);
        add(stateText);
        
        JLabel pin=new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,590,200,30);
        add(pin);
        pinText=new JTextField();
        pinText.setFont(new Font("Raleway",Font.BOLD,22));
        pinText.setBounds(300,590,500,30);
        add(pinText);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(700,630,100,30);
        next.addActionListener(this);
        add(next);
        
        
        
        setSize(830,720);
        setLocation(100,10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
    }
      public void actionPerformed(ActionEvent ae)
        {
            String formno=" "+ random;
            String name=nameTextField.getText();
            String fname=fatherNameTextField.getText();
            String email=emailText.getText();
            String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
            String address=addressText.getText();                          
            String city=cityText.getText();
            String pin=pinText.getText();
            String state=stateText.getText();
            
            String gender=null;
            if(male.isSelected())
                gender="Male";
            else if(female.isSelected())
                gender="Female";
            else
                gender="Others";
            
            String marital="null";
             if(married.isSelected())
                marital="Married";
            else if(unmarried.isSelected())
                marital="Unmarried";
            else
                marital="Others";
             
            try
            {
                if(name.equals(""))
                    JOptionPane.showMessageDialog(null,"Name is required");
                else
                {
                    Conn c=new Conn();
                   // String query = "INSERT INTO signup (formno, name, fname, marital, gender, email, address, city, pin, state, dob) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, STR_TO_DATE(?, '%M %d, %Y'))";
                 String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                 
                 c.s.executeUpdate(query);
                 
                 setVisible(false);
                 new signuptwo(formno).setVisible(true);
                }
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
           
 }
    
    public static void main(String args[]) {
       
        new signupone();
    }
}
