package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, fastCash, miniStatement, balance, pinChange, exit;
    String pinNumber;
    
    public Transaction(String pinNumber) {
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
    
    JLabel text = new JLabel("Please select your Transaction");
   image.add(text);
    text.setBounds(213,270,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD, 16));
    
    deposit = new JButton("Deposit");
    image.add(deposit);
    deposit.setBounds(170,386,100,20);
    deposit.addActionListener(this);

    
    withdrawl = new JButton("Cash Withdrawl");
    image.add(withdrawl);
    withdrawl.setBounds(355,386,140,20);
    withdrawl.addActionListener(this);

    
    fastCash = new JButton("Fast cash");
    image.add(fastCash);
    fastCash.setBounds(170,426,100,20);
    fastCash.addActionListener(this);

    miniStatement = new JButton("Mini statement");
    image.add(miniStatement);
    miniStatement.setBounds(355,426,140,20);
    miniStatement.addActionListener(this);

    pinChange = new JButton("Pin Change");
    image.add(pinChange);
    pinChange.setBounds(170,466,100,20);
    pinChange.addActionListener(this);

    balance = new JButton("Balance Enquiry");
    image.add(balance);
    balance.setBounds(355,466,140,20);
    balance.addActionListener(this);

    exit = new JButton("Exit");
    image.add(exit);
    exit.setBounds(355,500,140,20);
    exit.addActionListener(this);
    
   }
    
    @ Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == exit) {
    System.exit(0);
    
    } else if(ae.getSource() == deposit) {
       setVisible(false);
       new Deposit(pinNumber);
    
    } else if(ae.getSource() == withdrawl) {
        setVisible(false);
        new WithDrawl(pinNumber);
    
    } else if(ae.getSource() == fastCash) {
        setVisible(false);
        new FastCash(pinNumber);
    
    } else if(ae.getSource() == pinChange) {
        setVisible(false);
        new PinChange(pinNumber);
    
    }else if(ae.getSource() == balance) {
        setVisible(false);
        new BalanceEnquiry(pinNumber);
    
    }else if(ae.getSource() == miniStatement) {
        setVisible(false);
          new MiniStatement(pinNumber);
    }
    
    }
    
    public static void main(String args[]) {
        new Transaction("");
    }
}
