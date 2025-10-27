package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, back;
    String pinNumber;
    
    public FastCash(String pinNumber) {
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
    
    JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
   image.add(text);
    text.setBounds(213,270,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD, 16));
    
    rs100 = new JButton("Rs 100");
    image.add(rs100);
    rs100.setBounds(170,386,100,20);
    rs100.addActionListener(this);

    
    rs500 = new JButton("Rs 500");
    image.add(rs500);
    rs500.setBounds(355,386,140,20);
    rs500.addActionListener(this);

    
    rs1000 = new JButton("Rs 1000");
    image.add(rs1000);
    rs1000.setBounds(170,426,100,20);
    rs1000.addActionListener(this);

    rs2000 = new JButton("Rs 2000");
    image.add(rs2000);
    rs2000.setBounds(355,426,140,20);
    rs2000.addActionListener(this);

    rs5000 = new JButton("Rs 5000");
    image.add(rs5000);
    rs5000.setBounds(170,466,100,20);
    rs5000.addActionListener(this);

    rs10000 = new JButton("Rs 10000");
    image.add(rs10000);
    rs10000.setBounds(355,466,140,20);
    rs10000.addActionListener(this);

    back = new JButton("BACK");
    image.add(back);
    back.setBounds(355,500,140,20);
    back.addActionListener(this);
    
   }
    
    @ Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == back) {
    setVisible(false);
    new Transaction(pinNumber);
    
    } else {
          String amount = ((JButton)ae.getSource()).getText().substring(3);
                    try {

          Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
              int balance = 0;
              while(rs.next()) {
              if(rs.getString("type").equals("Deposit")) {
                 balance += Integer.parseInt(rs.getString("amount"));
                  } else {
              balance -= Integer.parseInt(rs.getString("amount"));
            }
              }
              
       if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
               return;
       }
          Date date = new Date();
          String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'withdrawl', '"+amount+"')";
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null, "Rs"+" "+ amount + " "+ "Debited Successfully");
          
          setVisible(false);
          new Transaction(pinNumber);

       
       
       
       
       
          }catch(Exception e) {
           System.out.println(e);
          }


}
    
    }
    
    public static void main(String args[]) {
        new FastCash("");
    }
}

