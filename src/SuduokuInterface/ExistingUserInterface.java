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
public class ExistingUserInterface extends JPanel{
    private Image background;
    public JLabel euiText;
    public JLabel hint;
    private JLabel username;
    private JLabel password;
    public JButton login;
    public JButton cancel;
    public JTextField usernameTf;
    public JTextField passwordTf;

    //This is designed to be the main panel of the EXISTING_USER_INTERFACE
    public ExistingUserInterface()
    {
        this.setLayout(null);
        this.setVisible(true);
        this.background = new ImageIcon("ExistingUserInterface/BackGround.jpg").getImage();
        
        euiText = new JLabel("Sudoku Game Login");
        euiText.setFont(new Font("Calibri", Font.ITALIC, 50));
        //If designing to make it left, -Hori, right: +Hori
        //If designing to make it up, -V, down: +V
        //If designing to make its width bigger, +W
        //If designing to make its height bigger, +Hei
        euiText.setBounds(370, 70, 450, 200); //Hori, V, W, Hei
        this.add(euiText);
        username = new JLabel("Username: ");
        username.setFont(new Font("Calibri", Font.PLAIN, 25));
        username.setBounds(320, 250, 200, 100);
        this.add(username);
        password = new JLabel("Password: ");
        password.setFont(new Font("Calibri", Font.PLAIN, 25));
        password.setBounds(328, 350, 200, 100);
        this.add(password);
        
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
        
        this.hint = new JLabel("");
        this.hint.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.hint.setBounds(470,415, 500, 100);
        this.add(hint);
        
        this.cancel = new JButton("Cancel");
        this.cancel.setActionCommand("euiCancel");
        this.cancel.setBounds(290, 550, 150, 65);
        cancel.setFont(new Font("Calibri", Font.PLAIN, 25));
        cancel.setBackground(Color.PINK);
        cancel.setContentAreaFilled(false);
        cancel.setOpaque(true);
        this.add(cancel);
        
        this.login = new JButton("Log in");
        this.login.setActionCommand("Log in");
        this.login.setBounds(730, 550, 150, 65);
        login.setFont(new Font("Calibri", Font.PLAIN, 25));
        login.setBackground(Color.PINK);
        login.setContentAreaFilled(false);
        login.setOpaque(true);
        this.add(login);
 
        setSize(1200, 800); // manually computed sizes
    }
    
    public void resetJTextFields()
    {
        usernameTf.setText("Please input your username here");
        passwordTf.setText("Please input your password here");
    }
    
    //This method will be automatically called
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, null);
    }
}
