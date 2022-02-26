/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 */
public class MainInterface extends JPanel{
    private Image background;
    public JLabel hint;
    public JButton newGame;
    public JButton continueGame;
    public JButton leaderBoard;
    public JButton howToPlay;
    
    //This is designed to be the main panel of the MAIN_INTERFACE
    public MainInterface()
    {
        this.setLayout(null);
        this.setVisible(true);
        this.background = new ImageIcon("MainInterface/BackGround.jpg").getImage();
        
        this.hint = new JLabel("");
        this.hint.setFont(new Font("Calibri", Font.PLAIN, 25));
        //If designing to make it left, -Hori, right: +Hori
        //If designing to make it up, -V, down: +V
        //If designing to make its width bigger, +W
        //If designing to make its height bigger, +Hei
        this.hint.setBounds(445,635, 350, 100); //Hori, V, W, Hei
        this.add(hint);
        
        this.newGame = new JButton("New Game");
        this.newGame.setActionCommand("New Game");
        this.newGame.setBounds(475, 80, 250, 90);
        newGame.setFont(new Font("Calibri", Font.PLAIN, 25));
        newGame.setBackground(new Color(155, 219, 237)); 
        newGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newGame.setContentAreaFilled(false);
        newGame.setOpaque(true);
        this.add(newGame);
        
        this.continueGame = new JButton("Continue Game");
        this.continueGame.setActionCommand("Continue Game");
        this.continueGame.setBounds(475, 230, 250, 90);
        continueGame.setFont(new Font("Calibri", Font.PLAIN, 25));
        continueGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        continueGame.setBackground(new Color(155, 219, 237));
        continueGame.setContentAreaFilled(false);
        continueGame.setOpaque(true);
        this.add(continueGame);
        
        this.leaderBoard = new JButton("LeaderBoard");
        this.leaderBoard.setActionCommand("LeaderBoard");
        this.leaderBoard.setBounds(475, 380, 250, 90);
        leaderBoard.setFont(new Font("Calibri", Font.PLAIN, 25));
        leaderBoard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        leaderBoard.setBackground(new Color(155, 219, 237));
        leaderBoard.setContentAreaFilled(false);
        leaderBoard.setOpaque(true);
        this.add(leaderBoard);
        
        this.howToPlay = new JButton("Sudoku Intro");
        this.howToPlay.setActionCommand("Sudoku Intro");
        this.howToPlay.setBounds(475, 530, 250, 90);
        howToPlay.setFont(new Font("Calibri", Font.PLAIN, 25));
        howToPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        howToPlay.setBackground(new Color(155, 219, 237));
        howToPlay.setContentAreaFilled(false);
        howToPlay.setOpaque(true);
        this.add(howToPlay);

        setSize(1200, 800); // manually computed sizes
    }

    //This method will be automatically called
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, null);
    }  
}
