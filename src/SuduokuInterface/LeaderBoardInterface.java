/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

import SudokuGameProcess.GameDatabase;
import SudokuGameProcess.UserInfo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 */
public class LeaderBoardInterface extends JPanel{
    private Image background;
    public JLabel no1;
    public JLabel no2;
    public JLabel no3;
    public JLabel score1;
    public JLabel score2;
    public JLabel score3;
    public JLabel no1Score;
    public JLabel no2Score;
    public JLabel no3Score;
    public JLabel no1Username;
    public JLabel no2Username;
    public JLabel no3Username;
    public JTable leaderBoard;
    public ArrayList<UserInfo> users;
    public JButton returnBack;
    public Object[][] userInfo;
    
    public LeaderBoardInterface(ArrayList<UserInfo> users)
    {
        this.setLayout(null);
        this.setVisible(true);
        this.users = users;
        this.background = new ImageIcon("LeaderBoardInterface/BackGround.jpg").getImage();
       
        this.no1 = new JLabel("NO.1:");
        this.no1.setFont(new Font("Calibri", Font.ITALIC, 50));
        //If designing to make it left, -Hori, right: +Hori
        //If designing to make it up, -V, down: +V
        //If designing to make its width bigger, +W
        //If designing to make its height bigger, +Hei
        this.no1.setBounds(85, 70, 150, 70); //Hori, V, W, Hei
        this.add(no1);
        
        this.no2 = new JLabel("NO.2:");
        this.no2.setFont(new Font("Calibri", Font.ITALIC, 50));
        this.no2.setBounds(85, 220, 150, 70); //Hori, V, W, Hei
        this.add(no2);
        
        this.no3 = new JLabel("NO.3:");
        this.no3.setFont(new Font("Calibri", Font.ITALIC, 50));
        this.no3.setBounds(85, 370, 150, 70); //Hori, V, W, Hei
        this.add(no3);
        
        this.score1 = new JLabel("SCORE:");
        this.score1.setFont(new Font("Calibri", Font.ITALIC, 35));
        this.score1.setBounds(85, 130, 150, 70); //Hori, V, W, Hei
        this.add(score1);
        
        this.score2 = new JLabel("SCORE:");
        this.score2.setFont(new Font("Calibri", Font.ITALIC, 35));
        this.score2.setBounds(85, 280, 150, 70); //Hori, V, W, Hei
        this.add(score2);
        
        this.score3 = new JLabel("SCORE:");
        this.score3.setFont(new Font("Calibri", Font.ITALIC, 35));
        this.score3.setBounds(85, 430, 150, 70); //Hori, V, W, Hei
        this.add(score3);
        
        this.no1Score = new JLabel();
        this.no1Score.setFont(new Font("Calibri", Font.ITALIC, 35));
        this.no1Score.setBounds(230, 130, 150, 70); //Hori, V, W, Hei
        this.add(no1Score);
        
        this.no2Score = new JLabel();
        this.no2Score.setFont(new Font("Calibri", Font.ITALIC, 35));
        this.no2Score.setBounds(230, 280, 150, 70); //Hori, V, W, Hei
        this.add(no2Score);
        
        this.no3Score = new JLabel();
        this.no3Score.setFont(new Font("Calibri", Font.ITALIC, 35));
        this.no3Score.setBounds(230, 430, 150, 70); //Hori, V, W, Hei
        this.add(no3Score);
        
        this.no1Username = new JLabel();
        this.no1Username.setFont(new Font("Calibri", Font.ITALIC, 50));
        this.no1Username.setBounds(230, 70, 250, 70); //Hori, V, W, Hei
        this.add(no1Username);
        
        this.no2Username = new JLabel();
        this.no2Username.setFont(new Font("Calibri", Font.ITALIC, 50));
        this.no2Username.setBounds(230, 220, 250, 70); //Hori, V, W, Hei
        this.add(no2Username);
        
        this.no3Username = new JLabel();
        this.no3Username.setFont(new Font("Calibri", Font.ITALIC, 50));
        this.no3Username.setBounds(230, 370, 250, 70); //Hori, V, W, Hei
        this.add(no3Username);
        
        String[] titles = {"Ranking NO.","User Name","Score"};
        Object[][] userInfo = new Object[users.size()][titles.length];
        for(int k = 0; k < users.size(); k++)
        {
           String username = users.get(k).getName();
           int score = users.get(k).getScore();

           userInfo[k][0] = k+1;
           userInfo[k][1] = username;
           userInfo[k][2] = score;
        }
        this.leaderBoard = new JTable(userInfo,titles);
        this.leaderBoard.setFont(new Font("Calibri light", Font.PLAIN, 15));
        this.leaderBoard.setRowHeight(30);
        JScrollPane scrollPane= new JScrollPane(leaderBoard);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        scrollPane.setBounds(570, 50, 500, 600);
        this.add(scrollPane);       
        
        this.returnBack = new JButton("Return");
        this.returnBack.setActionCommand("lbiReturn");
        this.returnBack.setBounds(40, 685, 125, 40);
        this.returnBack.setFont(new Font("Calibri", Font.PLAIN, 25));
        this.returnBack.setBackground(new Color(210, 233, 208)); 
        this.returnBack.setContentAreaFilled(false);
        this.returnBack.setOpaque(true);
        this.add(returnBack);    

        setSize(1200, 800); // manually computed sizes
    }

    //This method will be automatically called
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, null);
    }
}
