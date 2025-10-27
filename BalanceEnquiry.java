package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinNumber;
    
    public BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        
    setSize(900,850);
    setVisible(true);
    setLocation(300,0);
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    add(image);
    image.setBounds(0,0,900,840);
    
     back = new JButton("BACK");
    image.add(back);
    back.setBounds(355,500,140,20);
    back.addActionListener(this);
    
    int balance = 0;
    
    try {

          Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
              while(rs.next()) {
              if(rs.getString("type").equals("Deposit")) {
                 balance += Integer.parseInt(rs.getString("amount"));
                 } else {
              balance -= Integer.parseInt(rs.getString("amount"));
              }
         }  
    } catch(Exception e) {
           System.out.println(e);
          }
    
    JLabel text = new JLabel("Your Current Amount Balance is Rs : " +" " + balance);
   image.add(text);
    text.setBounds(200,270,400,60);
    text.setForeground(Color.WHITE);
   
    }
    
    @ Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == back) {
    setVisible(false);
    new Transaction(pinNumber);
    
    } 
                       
}
    
   public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}

