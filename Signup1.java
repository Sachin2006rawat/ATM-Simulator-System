package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup1 extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried, other;
    JButton next, clear;
    
    
   public Signup1() {
        
        setSize(850 , 800);
        setVisible(true);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        setLocation(350 , 10);
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO :" + " " + random);
        add(formno);
        formno.setBounds(140,20,600,40);
        formno.setFont(new Font("Raleway", Font.ITALIC, 35));
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        add(personalDetails);
        personalDetails.setBounds(290,80,400,30);
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        
        JLabel name = new JLabel("Name:");
        add(name);
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        
        nameTextField = new JTextField();
        add(nameTextField);
        nameTextField.setBounds(300,140,400,30);
        nameTextField.setFont(new Font("Raleway", Font.CENTER_BASELINE, 14));
        
        JLabel fname = new JLabel("Father's Name:");
        add(fname);
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        
        fnameTextField = new JTextField();
        add(fnameTextField);
        fnameTextField.setBounds(300,190,400,30);
        fnameTextField.setFont(new Font("Raleway", Font.CENTER_BASELINE, 14));
        
        JLabel dob = new JLabel("Date Of Birth:");
        add(dob);
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        
        dateChooser = new JDateChooser();
        add(dateChooser);
        dateChooser.setBounds(300,240,400,30);
        
        JLabel gender = new JLabel("Gender:");
        add(gender);
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        
        male = new JRadioButton("Male");
        add(male);
        male.setBounds(300,290,100,30);
        
        female = new JRadioButton("Female");
        add(female);
        female.setBounds(450,290,100,30);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email:");
        add(email);
        email.setBounds(100,340,100,30);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        
        emailTextField = new JTextField();
        add(emailTextField);
        emailTextField.setBounds(300,340,400,30);
        emailTextField.setFont(new Font("Raleway", Font.CENTER_BASELINE, 14));
        
        JLabel matial = new JLabel("Martial:");
        add(matial);
        matial.setBounds(100,390,200,30);
        matial.setFont(new Font("Raleway", Font.BOLD, 20));
        
        married = new JRadioButton("Married");
        add(married);
        married.setBounds(300,390,100,30);
        
        unmarried = new JRadioButton("Unmarried");
        add(unmarried);
        unmarried.setBounds(450,390,100,30);
        
        other = new JRadioButton("Other");
        add(other);
        other.setBounds(630,390,150,30);
        
        ButtonGroup matialgroup = new ButtonGroup();
        matialgroup.add(married);
        matialgroup.add(unmarried);
        matialgroup.add(other);
        
        JLabel address = new JLabel("Address:");
        add(address);
        address.setBounds(100,440,100,30);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        
        addressTextField = new JTextField();
        add(addressTextField);
        addressTextField.setBounds(300,440,400,30);
        addressTextField.setFont(new Font("Raleway", Font.CENTER_BASELINE, 14));
        
        JLabel city = new JLabel("City:");
        add(city);
        city.setBounds(100,490,100,30);
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        
        cityTextField = new JTextField();
        add(cityTextField);
        cityTextField.setBounds(300,490,400,30);
        cityTextField.setFont(new Font("Raleway", Font.CENTER_BASELINE, 14));
        
        JLabel state = new JLabel("State:");
        add(state);
        state.setBounds(100,540,100,30);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        
        stateTextField = new JTextField();
        add(stateTextField);
        stateTextField.setBounds(300,540,400,30);
        stateTextField.setFont(new Font("Raleway", Font.CENTER_BASELINE, 14));
        
        JLabel pincode = new JLabel("Pincode:");
        add(pincode);
        pincode.setBounds(100,590,100,30);
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        
        pincodeTextField = new JTextField();
        add(pincodeTextField);
        pincodeTextField.setBounds(300,590,400,30);
        pincodeTextField.setFont(new Font("Raleway", Font.CENTER_BASELINE, 14));
        
        next = new JButton("NEXT");
        add(next);
        next.setBounds(620,660,80,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        
        clear = new JButton("CLEAR");
        add(clear);
        clear.setBounds(520,660,80,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        
        
        }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == clear) {
            nameTextField.setText("");
            fnameTextField.setText("");
            emailTextField.setText("");
            addressTextField.setText("");
            cityTextField.setText("");
            stateTextField.setText(""); 
            pincodeTextField.setText("");
            
        } else if(ae.getSource() == next) {
        
        String formno = "" + random;
        String name = nameTextField.getText ();
        String fname  = fnameTextField.getText ();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText ();
        
        String gender = "";
        if(male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        
        String martial = "";
        if(married.isSelected()) {
            martial = "Married";
        } else if (unmarried.isSelected()) {
            martial = "Unmarried";
        } else if (other.isSelected()) {
            martial = "other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        try {
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "All is Mandatory" );
            } else if(fname.equals("")) {
                JOptionPane.showMessageDialog(null, "All is Mandatory");
            } else if(dob.equals("")) {
                JOptionPane.showMessageDialog(null, "All is Mandatory" );
            } else if(gender.equals("")) {
                JOptionPane.showMessageDialog(null, "All is Mandatory" ); 
            } else  if(email.equals("")) {
                JOptionPane.showMessageDialog(null, "All is Mandatory" );
            } else if(martial.equals("")) {
                JOptionPane.showMessageDialog(null, "All is Mandatory" ); 
            } else if(address.equals("")) {
                JOptionPane.showMessageDialog(null, "All is Mandatory" );
            } else if(city.equals("")) {
                JOptionPane.showMessageDialog(null, "All is Mandatory");
            } else if(state.equals("")) {
                JOptionPane.showMessageDialog(null, "All is Mandatory" );
            } else if(pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "All is Mandatory");
            } else {
                Conn c = new Conn();
               String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+martial+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup2(formno);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        }
    }
    
    public static void main(String args[]) {
        new Signup1();
        
    }
}