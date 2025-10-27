package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener{
    
    JComboBox religion1, category1, income1, qualification1, occupation1;
    JTextField panNoTextField, aadharNoTextField;
    JRadioButton srYes, srNo, accountYes, accountNo;
    JButton next, clear;
    String formno;
    
    public Signup2(String formno) {
        this.formno = formno;
        
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel text = new JLabel("Page 2: Additional Details");
        add(text);
        text.setBounds(270,50,400,40);
        text.setFont(new Font("Raleway", Font.BOLD, 28));
        
        JLabel fNo = new JLabel("Form No:"+" "+formno);
        add(fNo);
        fNo.setBounds(680,30,300,30);
        fNo.setFont(new Font("Ralewy", Font.BOLD, 16));
        
        JLabel religion = new JLabel("Religion:");
        add(religion);
        religion.setBounds(80,120,100,30);
        religion.setFont(new Font("Osward", Font.CENTER_BASELINE, 20));
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion1 = new JComboBox(valReligion);
        add(religion1);
        religion1.setBounds(280,120,400,30);
        religion1.setBackground(Color.WHITE);
        
        JLabel category = new JLabel("Category:");
        add(category);
        category.setBounds(80,170,100,30);
        category.setFont(new Font("Osward", Font.CENTER_BASELINE, 20));
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category1 = new JComboBox(valCategory);
        add(category1);
        category1.setBounds(280,170,400,30);
        category1.setBackground(Color.WHITE);
        
        JLabel income = new JLabel("Income:");
        add(income);
        income.setBounds(80,220,400,30);
        income.setFont(new Font("Osward", Font.CENTER_BASELINE, 20));
        
        String valIncome[] = {"Null", "Less than 1 lakh", "Between 1 lakh to 5 lakh", "Above 5 Lakh"};
        income1 = new JComboBox(valIncome);
        add(income1);
        income1.setBounds(280,220,400,30);
        income1.setBackground(Color.WHITE);
        JLabel education = new JLabel("Educational");
        add(education);
        education.setBounds(80,270,200,30);
        education.setFont(new Font("Osward", Font.CENTER_BASELINE, 20));
        
        JLabel qualification = new JLabel("Qualification:");
        add(qualification);
        qualification.setBounds(80,300,200,30);
        qualification.setFont(new Font("Osward", Font.CENTER_BASELINE, 20));
        
         String valQualification[] = {"10th", "12th", "Graduate", "Post Graduate"};
         qualification1 = new JComboBox(valQualification);
        add(qualification1);
        qualification1.setBounds(280,285,400,30);
        qualification1.setBackground(Color.WHITE);

        JLabel occupation = new JLabel("Occupation:");
        add(occupation);
        occupation.setBounds(80,370,200,30);
        occupation.setFont(new Font("Osward", Font.CENTER_BASELINE, 20));
        
        String valoccupation[] = {"Student", "Employee" ,"Business", "Self-Employed", "Other"};
        occupation1 = new JComboBox(valoccupation);
        add(occupation1);
        occupation1.setBounds(280,370,400,30);
        occupation1.setBackground(Color.WHITE);

        JLabel panNo = new JLabel("PAN Number:");
        add(panNo);
        panNo.setBounds(80,420,200,30);
        panNo.setFont(new Font("Osward", Font.CENTER_BASELINE, 20));
        
        panNoTextField = new JTextField();
        add(panNoTextField);
        panNoTextField.setBounds(280,420,400,30);
        panNoTextField.setFont(new Font("Raleway", Font.BOLD, 12));

        JLabel aadharNo = new JLabel("Aadhar Number:");
        add(aadharNo);
        aadharNo.setBounds(80,470,200,30);
        aadharNo.setFont(new Font("Osward", Font.CENTER_BASELINE, 20));
        
        aadharNoTextField = new JTextField();
        add(aadharNoTextField);
        aadharNoTextField.setBounds(280,470,400,30);
        aadharNoTextField.setFont(new Font("Raleway", Font.BOLD, 12));


        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        add(seniorCitizen);
        seniorCitizen.setBounds(80,520,200,30);
        seniorCitizen.setFont(new Font("Osward", Font.CENTER_BASELINE, 20));
        
        srYes = new JRadioButton("Yes");
        add(srYes);
        srYes.setBounds(280,520,80,30);
        
        srNo = new JRadioButton("No");
        add(srNo);
        srNo.setBounds(430,520,80,30);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(srYes);
        bg.add(srNo);
        
        
        JLabel existingAccount = new JLabel("Existing Account:");
        add(existingAccount);
        existingAccount.setBounds(80,570,200,30);
        existingAccount.setFont(new Font("Osward",Font.CENTER_BASELINE, 20));
        
        accountYes = new JRadioButton("Yes");
        add(accountYes);
        accountYes.setBounds(280,570,80,30);
        
        accountNo = new JRadioButton("N0");
        add(accountNo);
        accountNo.setBounds(430,570,80,30);
        
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(accountYes);
        bg1.add(accountNo);
        
        next = new JButton("NEXT");
        add(next);
        next.setBounds(580,650,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        
        clear = new JButton("CLEAR");
        add(clear);
        clear.setBounds(460,650,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
   
    }
    
    @ Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear) {
          panNoTextField.setText(""); 
          aadharNoTextField.setText("");
          
        } else if (ae.getSource() == next) {
          String religion = (String) religion1.getSelectedItem();
          String category = (String) category1.getSelectedItem();                        
          String income = (String) income1.getSelectedItem();                         
          String qualification = (String) qualification1.getSelectedItem();                               
          String occupation = (String) occupation1.getSelectedItem();                              
          String panNo = panNoTextField.getText();
          String aadharNo = aadharNoTextField.getText();
          
          String seniorCitizen = "";
          if(srYes.isSelected()) {
          seniorCitizen = "Yes";
          } else if(srNo.isSelected()) {
          seniorCitizen = "No"; }
          
          String  existingAccount = "";
          if(accountYes.isSelected()) {
              existingAccount = "Yes";
          } else if(accountNo.isSelected()) { 
            existingAccount = "No";  }                              
                                         
      try {
          if(panNo.equals("")) {
          JOptionPane.showMessageDialog(null, "ALL is Mandatory");
          } else if(aadharNo.equals("")) {
          JOptionPane.showMessageDialog(null, "ALL is Mandatory"); 
          } else if(seniorCitizen.equals("")) {
          JOptionPane.showMessageDialog(null, "ALL is Mandatory"); 
          } else if(existingAccount.equals("")) {
          JOptionPane.showMessageDialog(null, "ALL is Mandatory");
          
          } else{
          Conn c = new Conn();
          String query = "insert into signup2 values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+qualification+"', '"+occupation+"', '"+panNo+"', '"+aadharNo+"', '"+seniorCitizen+"', '"+existingAccount+"')";
          c.s.executeUpdate(query);
          
          setVisible(false);
          new Signup3(formno);
          
          }
          
        } catch (Exception e) {
            System.out.println(e);
        }
      }  
    }
    
    public static void main(String args []) {
        new Signup2("");
    }
    
}
