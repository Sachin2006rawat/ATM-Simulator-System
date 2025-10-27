package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
    
    JButton back;
    String pinNumber;
    
    public MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;
        
    setSize(900, 850);
    setVisible(true);
    setLocation(300, 0);
    setLayout(null);
    setTitle("Mini Statement");
    
    ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    add(image);
    image.setBounds(0,0,900,840);
    
    JLabel bank = new JLabel("BANK OF INDIA");
    image.add(bank);
    bank.setBounds(295,215,400,20);
    bank.setForeground(Color.WHITE);
    bank.setFont(new Font("System", Font.BOLD, 16));
    
    JLabel card = new JLabel();
    card.setBounds(100,170,300,20);
    image.add(card);
    card.setForeground(Color.WHITE);
    card.setFont(new Font("System", Font.BOLD, 17));

    JLabel mini = new JLabel();
    mini.setBounds(160,270,500,40);
    image.add(mini);
    mini.setForeground(Color.WHITE);
    mini.setFont(new Font("System", Font.BOLD, 14));
    
    
            
   
    try {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from login where pinNo = '"+pinNumber+"'");
        while(rs.next()) {
            card.setText("Card Number: " + rs.getString("cardNo"));
        }
        
     } catch(Exception e) {
    System.out.println(e);
    }
    
    try {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
        while(rs.next()) {
        mini.setText("<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
         }
        
    } catch(Exception e) {
       System.out.println(e);
    }
 
     back = new JButton("Back");
    image.add(back);
    back.setBounds(355,485,150,30);
    back.addActionListener(this);

    }
    
    @ Override
    public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
        new Transaction(pinNumber);
    
    }
    
    public static void main(String args[]) {
        new MiniStatement("");
    }
    
}
