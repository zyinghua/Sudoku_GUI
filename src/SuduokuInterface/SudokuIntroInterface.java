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
import javax.swing.JTextPane;

/**
 *
 * @author Yinghua Zhou 17981371
 */
public class SudokuIntroInterface extends JPanel{
    private Image background;
    private JTextPane sudokuIntro;
    public JButton back;
    
    public SudokuIntroInterface()
    {
        this.setLayout(null);
        this.setVisible(true);
        this.background = new ImageIcon("SudokuIntroInterface/BackGround.jpg").getImage();
        
        this.sudokuIntro = new JTextPane();
        this.sudokuIntro.setFont(new Font("Calibri", Font.PLAIN, 25));
        this.sudokuIntro.setText("                                                                          Sudoku puzzle Introduction\n"
                +"\nThe Sudoku puzzle consists of a series of grids."
                + " The grids include one large 9 x 9 grid that houses, nice 3 x 3 smaller grids."
                + "The purpose of the game is to place a number from 1-9 in each of the grid cells.\n"
                + "\nYou don't have to worry about finding the sum of the numbers of the rows, columns, like in Magic Squares."
                + "No addition is involved; however there are three conditions that rely on each other and must be followed.\n"
                + "\nEach number 1-9 can appear only in each column, once in each row, "
                + "and once in each small 3x3 grid. Mathmatically, Sudoku puzzles are a "
                + "derivative of Latin Squares. The famous mathematician Leonard Euler created Latin Squares. "
                + "They are a prevalent part of discrete math. Basically, a Latin Square consists "
                + "of an n x n table filled with numbers, letters, or symbols.\n \nEach symbol can only "
                + "appear exactly once in each row and exactly once in each column. Sudoku puzzles "
                + "take the Latin Square one step further with the 3 x 3 smaller grid constraints. "
                + "The fact that you have to make sure that each small 3 x 3 grid contains "
                + "each number 1-9 once significantly increases the complexity of the puzzle.\n"
                + "\nSudoku puzzles come in varying levels of difficulty. "
                + "The amount of numbers given initially in the 9 x 9 matrix varies. "
                + "One would think that the more numbers you are given initially, "
                + "the easier the puzzle would be to solve. This is not always the case because "
                + "the 'placement' of the numbers has a profound effect on the complexity of the puzzle.");
        //If designing to make it left, -Hori, right: +Hori
        //If designing to make it up, -V, down: +V
        //If designing to make its width bigger, +W
        //If designing to make its height bigger, +Hei
        this.sudokuIntro.setBounds(7,10, 1180, 650); //Hori, V, W, Hei
        this.sudokuIntro.setEditable(false);
        this.add(sudokuIntro);

        this.back = new JButton("Return");
        this.back.setActionCommand("siiReturn");
        this.back.setBounds(40, 685, 125, 40);
        this.back.setFont(new Font("Calibri", Font.PLAIN, 25));
        this.back.setBackground(new Color(210, 233, 208)); 
        this.back.setContentAreaFilled(false);
        this.back.setOpaque(true);
        this.add(back);    

        setSize(1200, 800); // manually computed sizes
    }

    //This method will be automatically called
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, null);
    }    
}
