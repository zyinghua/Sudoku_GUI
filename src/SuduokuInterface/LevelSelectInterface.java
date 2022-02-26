/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Yinghua Zhou 17981371
 * @author Junkun Chen 1798595 * Group ID: 26
 */
public class LevelSelectInterface extends JPanel{
    private Image background;
    public JButton easy;
    public JButton medium;
    public JButton hard;
    public JButton returnBack;

    //This is designed to be the main panel of the EXISTING_USER_INTERFACE
    public LevelSelectInterface()
    {
        this.setLayout(null);
        this.setVisible(true);
        this.background = new ImageIcon("LevelSelectInterface/BackGround.jpg").getImage();
        
        this.easy = new JButton("Easy");
        this.easy.setActionCommand("Easy");
        //If designing to make it left, -Hori, right: +Hori
        //If designing to make it up, -V, down: +V
        //If designing to make its width bigger, +W
        //If designing to make its height bigger, +Hei
        this.easy.setBounds(425, 100, 350, 120); //Hori, V, W, Hei
        easy.setFont(new Font("Calibri", Font.ITALIC, 35));
        easy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        easy.setBackground(Color.WHITE);
        easy.setContentAreaFilled(false);
        easy.setOpaque(true);
        this.add(easy);
        
        this.medium = new JButton("Medium");
        this.medium.setActionCommand("Medium");
        this.medium.setBounds(425, 300, 350, 120);
        medium.setFont(new Font("Calibri", Font.ITALIC, 35));
        medium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        medium.setBackground(Color.WHITE);
        medium.setContentAreaFilled(false);
        medium.setOpaque(true);
        this.add(medium);
        
        this.hard = new JButton("Hard");
        this.hard.setActionCommand("Hard");
        this.hard.setBounds(425, 500, 350, 120);
        hard.setFont(new Font("Calibri", Font.ITALIC, 35));
        hard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hard.setBackground(Color.WHITE);
        hard.setContentAreaFilled(false);
        hard.setOpaque(true);
        this.add(hard);
        
        this.returnBack = new JButton("Return");
        this.returnBack.setActionCommand("lsiReturn");
        this.returnBack.setBounds(40, 685, 125, 40);
        returnBack.setFont(new Font("Calibri", Font.PLAIN, 25));
        returnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        returnBack.setBackground(Color.PINK);
        returnBack.setContentAreaFilled(false);
        returnBack.setOpaque(true);
        this.add(returnBack);
 
        setSize(1200, 800); // manually computed sizes
    }

    //This method will be automatically called
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, null);
    }
}
