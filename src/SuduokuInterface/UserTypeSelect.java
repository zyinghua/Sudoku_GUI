/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Yinghua Zhou 17981371
 */
public class UserTypeSelect extends JPanel{
    private JButton newUserButton;
    private JButton existingUserButton;
    
    //This is designed to be the main panel of the USER_TYPE_SELECT interface
    public UserTypeSelect()
    {
        //Set borderLayout as the layout of the interface
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        
        northBG backG = new northBG();
        this.add(backG,BorderLayout.CENTER);
        
        //Set up a sub panel, then add this sub panel as the main panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.setVisible(true);
        
        this.newUserButton = new JButton(new ImageIcon("UserTypeSelect/newUserBG.jpg"));
        this.newUserButton.setActionCommand("New User");
        this.newUserButton.setPreferredSize(new Dimension(600, 300));
        southPanel.add(newUserButton, BorderLayout.WEST);
        
        this.existingUserButton = new JButton(new ImageIcon("UserTypeSelect/existingUserBG.jpg"));
        this.existingUserButton.setActionCommand("Existing User");
        this.existingUserButton.setPreferredSize(new Dimension(600, 300));
        southPanel.add(existingUserButton, BorderLayout.EAST);
        
        this.add(southPanel, BorderLayout.SOUTH);
        setSize(1200, 800); // manually computed sizes
    }
    
    public class northBG extends JPanel
    {
        public Image image;
        
        public northBG(){
            this.image = new ImageIcon("UserTypeSelect/northBackGround.jpg").getImage();
            this.setLayout(null);
        }
    
    //This method will be automatically called
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(this.image, 0, 0, null);
        }
    }
    
    public JButton getNewUserButton()
    {
        return this.newUserButton;
    }
    
    public JButton getExistingUserButton()
    {
        return this.existingUserButton;
    }
}
