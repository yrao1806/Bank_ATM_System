package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class signuptwo extends JFrame implements ActionListener{
    long random;
    JTextField panText,adhaarText;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
   
    JComboBox religion,category,education,ocupation,income;
    String formno;
    signuptwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW APPLICATION FORM PAGE 2");
        
        JLabel additionaldetails=new JLabel("Page 2:  Additional Details ");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
        JLabel reli=new JLabel("Religion :");
        reli.setFont(new Font("Raleway", Font.BOLD, 22));
        reli.setBounds(100,140,100,30);
        add(reli);
        String valReligion[]={"Hindu","Muslim","Sikh","Cristian","Others"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,500,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel cate=new JLabel("Category : ");
        cate.setFont(new Font("Raleway", Font.BOLD, 22));
        cate.setBounds(100,190,200,30);
        add(cate);
        String valCategory[]={"General","OBC","SC","ST","Others"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,500,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel inco=new JLabel("Income : ");
        inco.setFont(new Font("Raleway", Font.BOLD, 22));
        inco.setBounds(100,240,200,30);
        add(inco); 
        String valIncome[]={"Null","<1,50000",">1,50000"};
        income=new JComboBox(valIncome);
        income.setBounds(300,240,200,30);
        add(income);
        
        JLabel educ=new JLabel("Educational ");
        educ.setFont(new Font("Raleway", Font.BOLD, 22));
        educ.setBounds(100,290,200,30);
        add(educ);
        JLabel qual=new JLabel("Qualification : ");
        qual.setFont(new Font("Raleway", Font.BOLD, 22));
        qual.setBounds(100,310,200,30);
        add(qual);
        String valeducational[]={"Non Graaduation","Graduate","Post Graduation","Others"};
        education=new JComboBox(valeducational);
        education.setBounds(300,310,200,30);
        add(education);
        
        JLabel occu=new JLabel("Occupation :");
        occu.setFont(new Font("Raleway", Font.BOLD, 22));
        occu.setBounds(100,390,200,30);
        add(occu);
        String valocupation[]={"Self Employee","Salaried","Businessman","Student","Others"};
        ocupation=new JComboBox(valocupation);
        ocupation.setBounds(300,390,200,30);
        add(ocupation);
        
        
        
        JLabel panno=new JLabel("Pan Number :");
        panno.setFont(new Font("Raleway", Font.BOLD, 22));
        panno.setBounds(100,440,200,30);
        add(panno);
        panText=new JTextField();
        panText.setFont(new Font("Raleway",Font.BOLD,22));
        panText.setBounds(300,440,500,30);
        add(panText);
        
        
        
        JLabel adhaarno=new JLabel("Adhar Number :");
        adhaarno.setFont(new Font("Raleway", Font.BOLD, 22));
        adhaarno.setBounds(100,490,200,30);
        add(adhaarno);
        adhaarText=new JTextField();
        adhaarText.setFont(new Font("Raleway",Font.BOLD,22));
        adhaarText.setBounds(300,490,500,30);
        add(adhaarText);
        
        
        JLabel state=new JLabel("Senior Citizen");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100,540,200,30);
        add(state);
        syes=new JRadioButton(" Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno=new JRadioButton(" No");
        sno.setBounds(400,540,100,30);
        sno.setBackground(Color.WHITE);
        add( sno);
        ButtonGroup fem=new ButtonGroup();
        fem.add(syes);
        fem.add(sno);
        
        
        JLabel pin=new JLabel("Existing Account :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,590,200,30);
        add(pin);
        eyes=new JRadioButton(" Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno=new JRadioButton(" No");
        eno.setBounds(400,590,100,30);
        eno.setBackground(Color.WHITE);
        add( eno);
        ButtonGroup male=new ButtonGroup();
        male.add(eyes);
        male.add(eno);
       
        
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
            String sreligion=(String) religion.getSelectedItem();
            String seducation=(String) education.getSelectedItem();
            String socupation=(String) ocupation.getSelectedItem();
            String sincome=(String) income.getSelectedItem();
            String scategory=(String) category.getSelectedItem();
             
            String span=panText.getText();
            String sadhaar=adhaarText.getText();
            String sinior=null;
            if(syes.isSelected())
                sinior="Yes";
            else if(sno.isSelected())
                sinior="No";
            
            String existing="null";
             if(eyes.isSelected())
                existing="Yes";
            else if(eno.isSelected())
                existing="No";
             
            try
            {
    
               Conn c=new Conn();   
               String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+socupation+"','"+sadhaar+"','"+span+"','"+sinior+"','"+existing+"')";
                 
               c.s.executeUpdate(query);
                  setVisible(false);
                 new signupthree(formno).setVisible(true);
                }
                
            catch(Exception e)
            {
                System.out.println(e);
            }
            
           
 }
    
    public static void main(String args[]) {
       
        new signuptwo("");
    }
}
