package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton signIn, clear, newUser;
    JTextField cardTextField;
    JPasswordField pinNo;
          
    Login() {
        setSize(800,480);
        setVisible(true);
        setTitle("AUTOMATED TELLER MACHINE");
        setLocation(350,200);
        setLayout(null);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        add(label);
        setVisible(true);
        label.setBounds(70,10,100,100);
        
        JLabel text = new JLabel("Welcome to ATM");
        add(text);
        text.setBounds(250,40,400,40);
       text.setFont(new Font("Osward", Font.PLAIN, 38));
        
       JLabel cardno = new JLabel("Card No:");
       add(cardno);
       cardno.setBounds(120,150,150,30);
       cardno.setFont(new Font("Raleway", Font.BOLD, 20));
       
       JLabel pin = new JLabel("PIN:");
       add(pin);
       pin.setBounds(120,220,150,30);
       pin.setFont(new Font("Raleway", Font.BOLD,20));
       
       cardTextField = new JTextField();
       add(cardTextField);
       cardTextField.setBounds(300,150,250,30);
       cardTextField.setFont(new Font("Raleway", Font.CENTER_BASELINE,  14));
       
       pinNo = new JPasswordField();
       add(pinNo);
       pinNo.setBounds(300,220,250,30);
       pinNo.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
       
       signIn = new JButton("SIGN IN");
       add(signIn);
       signIn.setBounds(300,300,100,30);
       signIn.setBackground(Color.BLACK);
       signIn.setForeground(Color.WHITE);
       signIn.addActionListener(this);
       
       clear = new JButton("CLEAR");
       add(clear);
       clear.setBounds(450,300,100,30);
       clear.setBackground(Color.BLACK);
       clear.setForeground(Color.WHITE);
       clear.addActionListener(this);
       
      newUser = new JButton("NEW USER");
       add(newUser);
       newUser.setBounds(300,360,250,30);
       newUser.setBackground(Color.BLACK);
       newUser.setForeground(Color.WHITE);
       newUser.addActionListener(this);
  }
    
    @ Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinNo.setText("");
           
        } else if(ae.getSource() == signIn) {
            Conn c = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinNo.getText();
            String query = "select * from login where cardNo = '"+cardNumber+"' and pinNo = '"+pinNumber+"'";
            try {
              ResultSet rs = c.s.executeQuery(query);
              if(rs.next()) {
                  JOptionPane.showMessageDialog(null, "successfully Login");
              setVisible(false);
              new Transaction(pinNumber);
              } else {
              JOptionPane.showMessageDialog(null, "Incorrect details");
              }
            } catch(Exception e) {
            System.out.println(e);
            }
            
        } else if(ae.getSource() == newUser) {
           setVisible(false);
           new Signup1();
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }    
}
