/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 */
public class NewUserInterface extends JPanel{
    private Image background;
    private JLabel nuiText;
    private JLabel username;
    private JLabel password;
    private JLabel confirmPw;
    public JTextField usernameTf;
    public JTextField passwordTf;
    public JTextField confirmPwTf;
    public JButton cancel;
    public JButton register;
    public JLabel hint;

    //This is designed to be the main panel of the NEW_USER_INTERFACE
    public NewUserInterface()
    {
        this.setLayout(null);
        this.setVisible(true);
        this.background = new ImageIcon("NewUserInterface/BackGround.jpg").getImage();
        
        nuiText = new JLabel("Creating Your Account");
        nuiText.setFont(new Font("Calibri", Font.ITALIC, 50));
        //If designing to make it left, -Hori, right: +Hori
        //If designing to make it up, -V, down: +V
        //If designing to make its width bigger, +W
        //If designing to make its height bigger, +Hei
        nuiText.setBounds(350, 40, 500, 200); //Hori, V, W, Hei
        this.add(nuiText);
        username = new JLabel("Username: ");
        username.setFont(new Font("Calibri", Font.PLAIN, 25));
        username.setBounds(320, 250, 200, 100);
        this.add(username);
        password = new JLabel("Password: ");
        password.setFont(new Font("Calibri", Font.PLAIN, 25));
        password.setBounds(328, 350, 200, 100);
        this.add(password);
        confirmPw = new JLabel("Confirm Password: ");
        confirmPw.setFont(new Font("Calibri", Font.PLAIN, 25));
        confirmPw.setBounds(240, 450, 200, 100);
        this.add(confirmPw);
        
        usernameTf = new JTextField("Please input your username here");
        usernameTf.setBounds(470, 282, 300, 35);
        usernameTf.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e){
                usernameTf.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });    
        this.add(usernameTf);
        
        passwordTf = new JTextField("Please input your password here");
        passwordTf.setBounds(470, 382, 300, 35);
        passwordTf.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e){
                passwordTf.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });  
        this.add(passwordTf);
        
        confirmPwTf = new JTextField("Please confirm your password here");
        confirmPwTf.setBounds(470, 482, 300, 35);
        confirmPwTf.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e){
                confirmPwTf.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });  
        this.add(confirmPwTf);
        
        this.hint = new JLabel("");
        this.hint.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.hint.setBounds(350,500, 500, 100);
        this.add(hint);
        
        this.cancel = new JButton("Cancel");
        this.cancel.setActionCommand("nuiCancel");
        this.cancel.setBounds(290, 630, 150, 65);
        cancel.setFont(new Font("Calibri", Font.PLAIN, 25));
        cancel.setBackground(Color.PINK);
        cancel.setContentAreaFilled(false);
        cancel.setOpaque(true);
        this.add(cancel);
        
        this.register = new JButton("Register");
        this.register.setActionCommand("Register");
        this.register.setBounds(730, 630, 150, 65);
        register.setFont(new Font("Calibri", Font.PLAIN, 25));
        register.setBackground(Color.PINK);
        register.setContentAreaFilled(false);
        register.setOpaque(true);
        this.add(register);
        
        setSize(1200, 800); // manually computed sizes
    }
    
    public void resetJTextFields()
    {
        usernameTf.setText("Please input your username here");
        passwordTf.setText("Please input your password here");
        confirmPwTf.setText("Please confirm your password here");
    }
    
    //This method will be automatically called
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, null);
    }
}
