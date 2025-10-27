package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    JButton change, back;
    JPasswordField newPinText, rePinText;
    String pinNumber;
    
    public PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        
    setSize(900, 850);
    setVisible(true);
    setLocation(300, 0);
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    add(image);
    image.setBounds(0,0,900,840);
    
    JLabel text = new JLabel("CHANGE YOUR PIN");
    image.add(text);
    text.setBounds(255,268,400,20);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD, 16));
    
    JLabel newPin = new JLabel("New PIN:");
    image.add(newPin);
    newPin.setBounds(170,320,200,30);
    newPin.setForeground(Color.WHITE);
    newPin.setFont(new Font("System", Font.BOLD, 16));
    
    JLabel rePin = new JLabel("Re-Enter New PIN:");
    image.add(rePin);
    rePin.setBounds(170,360,200,30);
    rePin.setForeground(Color.WHITE);
    rePin.setFont(new Font("System", Font.BOLD, 16));

    newPinText = new JPasswordField();
    image.add(newPinText);
    newPinText.setBounds(350,320,160,30);
    newPinText.setFont(new Font("Raleway", Font.TYPE1_FONT, 22));
    
    rePinText = new JPasswordField();
    image.add(rePinText);
    rePinText.setBounds(350,360,160,30);
    rePinText.setFont(new Font("Raleway", Font.TYPE1_FONT, 22));
    
    change = new JButton("CHANGE");
   image.add(change);
    change.setBounds(355,450,150,30);
    change.addActionListener(this);
    
    back = new JButton("Back");
    image.add(back);
    back.setBounds(355,485,150,30);
    back.addActionListener(this);

     }
    
    @ Override
    public void actionPerformed(ActionEvent ae) {
        
         if(ae.getSource() == back) {
        setVisible(false);
        new Transaction(pinNumber);
        
     } else {
         String nPin = newPinText.getText();
         String rPin = rePinText.getText();
                 
             if(nPin.equals(""))  {
             JOptionPane.showMessageDialog(null, "please enter PIn");

             } else if(rPin.equals(""))  {
             JOptionPane.showMessageDialog(null, "please re-enter new PIn");

             } else if(!nPin.equals(rPin)) {
             JOptionPane.showMessageDialog(null, "Entered PIN does not match");
         
             } else{
                 
              try {
                  Conn c = new Conn();
                  String query1 = "update bank set pin = '"+rPin+"' where pin = '"+pinNumber+"'";
                  String query2 = "update login set pinNo = '"+rPin+"' where pinNo = '"+pinNumber+"'";
                  String query3 = "update signup3 set pinNo = '"+rPin+"' where pinNo = '"+pinNumber+"'";
                  
                  c.s.executeUpdate(query1);
                  c.s.executeUpdate(query2);
                  c.s.executeUpdate(query3);
                  
                  JOptionPane.showMessageDialog(null, "PIN changed successfully");
                  
                  setVisible(false);
                  new Transaction(rPin);

              } catch(Exception e) {
                System.out.println(e);
              }
             
             
             }
         }
         
         
         
         }



    
    public static void main(String args[]) {
        new PinChange("");
    }
    
}
