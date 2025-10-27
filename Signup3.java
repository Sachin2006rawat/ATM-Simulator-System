package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JRadioButton savingAc, currentAc, fdAc, rdAc;
    JCheckBox atm, mobile, cheque, net, al, e, de;
    JButton sub;
    String formno;
    
    public Signup3(String formno){
      this.formno = formno;
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setLayout(null);
        
        JLabel text = new JLabel("Page 3: Account Details");
        add(text);
        text.setBounds(270,30,300,30);
        text.setFont(new Font("Raleway", Font.BOLD, 24));
        
        JLabel form = new JLabel("FORM NO:"+" "+formno);
        add(form);
        form.setBounds(630,20,200,30);
        form.setFont(new Font("Raleway", Font.BOLD, 18));
        
        JLabel type = new JLabel("Account Type");
        add(type);
        type.setBounds(70,90,200,30);
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        
        savingAc = new JRadioButton("Saving Account");
        add(savingAc);
        savingAc.setBounds(72,125,200,20);
        
        currentAc = new JRadioButton("Current Account");
        add(currentAc);
        currentAc.setBounds(72,155,200,20);
        
        fdAc = new JRadioButton("Fixed Deposit Account");
        add(fdAc);
        fdAc.setBounds(272,125,200,20);
        
        rdAc = new JRadioButton("Recurring Deposit Account");
        add(rdAc);
        rdAc.setBounds(272,155,200,20);
        
        ButtonGroup account = new ButtonGroup();
        account.add(currentAc);
        account.add(fdAc);
        account.add(rdAc);
        account.add(savingAc);
        
        JLabel card = new JLabel("Card Number");
        add(card);
        card.setBounds(70,220,200,30);
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel r= new JLabel("XXXX-XXXX-XXXX-" + random);
        add(r);
        r.setBounds(280,220,400,30);
        r.setFont(new Font("Raleway", Font.BOLD, 16));
        
        JLabel digit = new JLabel("Your 16 Digit Card Number");
        add(digit);
        digit.setBounds(70,250,400,15);
        digit.setFont(new Font("Raleway", Font.ROMAN_BASELINE, 12));
        
        JLabel pin = new JLabel("PIN:");
        add(pin);
        pin.setBounds(70,300,50,30);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        
        JLabel x = new JLabel("XXXX");
        add(x);
        x.setBounds(280,300,50,30);
        x.setFont(new Font("Raleway", Font.BOLD, 16));
        
        JLabel pwd = new JLabel("Your 4 Digit Password");
        add(pwd);
        pwd.setBounds(70,325,300,20);
        pwd.setFont(new Font("Raleway", Font.ROMAN_BASELINE, 12));
        
        JLabel service = new JLabel("Services Required:");
        add(service);
        service.setBounds(70,370,300,30);
        service.setFont(new Font("Raleway", Font.BOLD, 20));
        
        atm = new JCheckBox("ATM CARD");
        add(atm);
        atm.setBounds(72,420,100,30);
        atm.setFont(new Font("Raleway", Font.BOLD, 13));
        
        mobile = new JCheckBox("Mobile Banking");
        add(mobile);
        mobile.setBounds(72,470,200,30);
        mobile.setFont(new Font("Raleway", Font.BOLD, 14));
        
        cheque = new JCheckBox("Cheque Book");
        add(cheque);
        cheque.setBounds(72,520,200,30);
        cheque.setFont(new Font("Raleway", Font.BOLD, 14));
        
        net = new JCheckBox("Internet Banking");
        add(net);
        net.setBounds(380,420,200,30);
        net.setFont(new Font("Raleway", Font.BOLD, 14));
        
        al = new JCheckBox("EMAIL & SMS Alerts");
        add(al);
        al.setBounds(380,470,300,30);
        al.setFont(new Font("Raleway", Font.BOLD, 13));
        
        e = new JCheckBox("E-Statement");
        add(e);
        e.setBounds(380,520,200,30);
        e.setFont(new Font("Raleway", Font.BOLD, 14));
        
        de = new JCheckBox("I hereby declaeres that the above entered details are correct to the best of my knowledge");
        add(de);
        de.setBounds(72,620,800,40);
        
        sub = new JButton("Submit");
        add(sub);
        sub.setBounds(230,680,100,30);
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this);
        
    }
    
    @ Override
    public void actionPerformed(ActionEvent ae) {
        
       String accountType= "";
       if(savingAc.isSelected()) {
        accountType = "Saving Account";
    } else if(currentAc.isSelected()){
        accountType = "Current Account";
    } else if (fdAc.isSelected()) {
        accountType = "Fixed Deposit Account";
    } else if (rdAc.isSelected()) {
        accountType = "Recurring Deposit Account";
    }
       
       Random r = new Random();
       String cardNo = "" + Math.abs((r.nextLong() % 90L) + 10L);
       String pinNo = "" + Math.abs((r.nextLong() % 9000L) + 1000L);
       
       String facility = "";
       if(atm.isSelected()) {
         facility = facility + "ATM Card";
       } else if(mobile.isSelected()) {
           facility = facility + "Mobile Banking";
       } else if (cheque.isSelected()) {
           facility = facility + "Cheque Book";
       } else if (net.isSelected()) {
            facility = facility + "Internet Banking";
       } else if (al.isSelected()) {
           facility = facility + "EMAIL & SMS Alerts";
       } else if (e.isSelected()) {
           facility = facility + "E-Statement";
       }
       
       String verify = "";
       if(de.isSelected()) {
         verify = "veification Done";
       }
       try {
           if(accountType.equals("")) {
               JOptionPane.showMessageDialog(null, "Please Choose before Submit");
           } else if(facility.equals("")) {
               JOptionPane.showMessageDialog(null, "Please choose any Service");
           } else if(verify.equals("")) {
               JOptionPane.showMessageDialog(null,"Verification Needed");
               
           } else{
               Conn c = new Conn();
               String query = "insert into signup3 values('"+formno+"', '"+accountType+"', '"+cardNo+"', '"+pinNo+"', '"+facility+"')"; 
               String query2 = "insert into login values('"+formno+"', '"+cardNo+"', '"+pinNo+"')";         
               c.s.executeUpdate(query);
               c.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(null, "Card Number:" + " " + cardNo + "\n Pin:" + " " + pinNo);
                       
               setVisible(false);
               new Deposit(pinNo);
              
           }
       
       } catch(Exception e) {
       System.out.println(e);
       }
    }
    
    public static void main(String[] args) {
    new Signup3("");
    }
}
