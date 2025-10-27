package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WithDrawl extends JFrame implements ActionListener{
    
    JButton withdrawl, back;
    JTextField amount;
    String pinNumber;
    
    public WithDrawl(String pinNumber) {
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
    
    JLabel text = new JLabel("Enter the amount you want to withdraw");
    image.add(text);
    text.setBounds(170,280,400,20);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD, 16));
    
    amount = new JTextField();
    image.add(amount);
    amount.setBounds(170,330,320,30);
    amount.setFont(new Font("Raleway", Font.BOLD, 22));
    
    withdrawl = new JButton("Withdrawl");
   image.add(withdrawl);
    withdrawl.setBounds(355,450,150,30);
    withdrawl.addActionListener(this);
    
    back = new JButton("Back");
    image.add(back);
    back.setBounds(355,485,150,30);
    back.addActionListener(this);

    
    
    }
    
    @ Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdrawl) {
            String withdrawlText = amount.getText();
            Date date = new Date();
            
            try {
                if(withdrawlText.equals("")) {
                JOptionPane.showMessageDialog(null, "Amount is Required") ;
                
              } else { 
                Conn c = new Conn() ;
               String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'withdrawl', '"+withdrawlText+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs" +" "+ withdrawlText +" "+ "Withdraw Successfully") ;
               setVisible(false);
               new Transaction(pinNumber);
                }
            } catch(Exception e) {
              System.out.println(e);
            }
                
                
        
        } else if(ae.getSource() == back) {
        setVisible(false);
        new Transaction(pinNumber);
        }
    
    }
    
    public static void main(String args[]) {
        new WithDrawl("");
    }
    
}

