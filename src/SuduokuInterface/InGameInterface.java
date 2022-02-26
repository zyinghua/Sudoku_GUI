/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

import SudokuGameProcess.GameLevel;
import SudokuGameProcess.SudokuList;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 */
public class InGameInterface extends JPanel{
    private Image background;
    public JButton check;
    public JButton quit;
    public JButton clear;
    public JButton fill;
    public JButton remove;
    private ArrayList<JLabel> data;
    public JLabel A;
    public JLabel B;
    public JLabel C;
    public JLabel D;
    public JLabel E;
    public JLabel F;
    public JLabel G;
    public JLabel H;
    public JLabel I;
    public JLabel a;
    public JLabel b;
    public JLabel c;
    public JLabel d;
    public JLabel e;
    public JLabel f;
    public JLabel g;
    public JLabel h;
    public JLabel i;
    
    public InGameInterface()
    {
        data = new ArrayList<>();
        this.setLayout(null);
        this.setVisible(true);
        this.background = new ImageIcon("InGameInterface/BackGround.jpg").getImage();
        
        this.quit = new JButton("Quit");
        this.quit.setActionCommand("Quit");
        //If designing to make it left, -Hori, right: +Hori
        //If designing to make it up, -V, down: +V
        //If designing to make its width bigger, +W
        //If designing to make its height bigger, +Hei
        this.quit.setBounds(900,580,170,60); //Hori, V, W, Hei
        quit.setFont(new Font("Calibri", Font.ITALIC, 35));
        quit.setBackground(Color.WHITE);
        quit.setContentAreaFilled(false);
        quit.setOpaque(true);
        this.add(quit);
        
        JLabel aLabel = new JLabel("Sorry, No data entered");
        aLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        aLabel.setBounds(400,250,500,200);
        this.add(aLabel);

        setSize(1200, 800); // manually computed sizes
    }

    //This is designed to be the main panel of the EXISTING_USER_INTERFACE
    public InGameInterface(SudokuList sudokuTable)
    {
        data = new ArrayList<>();
        this.setLayout(null);
        this.setVisible(true);
        this.background = new ImageIcon("InGameInterface/BackGround.jpg").getImage();
        
        this.quit = new JButton("Quit");
        this.quit.setActionCommand("Quit");
        //If designing to make it left, -Hori, right: +Hori
        //If designing to make it up, -V, down: +V
        //If designing to make its width bigger, +W
        //If designing to make its height bigger, +Hei
        this.quit.setBounds(900,620,170,60); //Hori, V, W, Hei
        quit.setFont(new Font("Calibri", Font.ITALIC, 35));
        quit.setBackground(Color.WHITE);
        quit.setContentAreaFilled(false);
        quit.setOpaque(true);
        this.add(quit);
        
        this.clear = new JButton("Clear");
        this.clear.setActionCommand("Clear");
        this.clear.setBounds(900,486,170,60); //Hori, V, W, Hei
        clear.setFont(new Font("Calibri", Font.ITALIC, 35));
        clear.setBackground(Color.WHITE);
        clear.setContentAreaFilled(false);
        clear.setOpaque(true);
        this.add(clear);
        
        this.check = new JButton("Check");
        this.check.setActionCommand("Check");
        this.check.setBounds(900,352,170,60); //Hori, V, W, Hei
        check.setFont(new Font("Calibri", Font.ITALIC, 35));
        check.setBackground(Color.WHITE);
        check.setContentAreaFilled(false);
        check.setOpaque(true);
        this.add(check);
        
        this.remove = new JButton("Remove");
        this.remove.setActionCommand("Remove");
        this.remove.setBounds(900,218,170,60); //Hori, V, W, Hei
        remove.setFont(new Font("Calibri", Font.ITALIC, 35));
        remove.setBackground(Color.WHITE);
        remove.setContentAreaFilled(false);
        remove.setOpaque(true);
        this.add(remove);
        
        this.fill = new JButton("Fill");
        this.fill.setActionCommand("Fill");
        this.fill.setBounds(900,84,170,60); //Hori, V, W, Hei
        fill.setFont(new Font("Calibri", Font.ITALIC, 35));
        fill.setBackground(Color.WHITE);
        fill.setContentAreaFilled(false);
        fill.setOpaque(true);
        this.add(fill);
        
        this.A = new JLabel("<html><font color='green'>A</font></html>");
        this.A.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.A.setBounds(85, 71, 50, 50);
        this.add(this.A);
        
        this.B = new JLabel("<html><font color='green'>B</font></html>");
        this.B.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.B.setBounds(85, 142, 50, 50);
        this.add(this.B);
        
        this.C = new JLabel("<html><font color='green'>C</font></html>");
        this.C.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.C.setBounds(85, 213, 50, 50);
        this.add(this.C);
        
        this.D = new JLabel("<html><font color='green'>D</font></html>");
        this.D.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.D.setBounds(85, 284, 50, 50);
        this.add(this.D);
        
        this.E = new JLabel("<html><font color='green'>E</font></html>");
        this.E.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.E.setBounds(86, 355, 50, 50);
        this.add(this.E);
        
        this.F = new JLabel("<html><font color='green'>F</font></html>");
        this.F.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.F.setBounds(86, 426, 50, 50);
        this.add(this.F);
        
        this.G = new JLabel("<html><font color='green'>G</font></html>");
        this.G.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.G.setBounds(84, 497, 50, 50);
        this.add(this.G);
        
        this.H = new JLabel("<html><font color='green'>H</font></html>");
        this.H.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.H.setBounds(84, 568, 50, 50);
        this.add(this.H);
        
        this.I = new JLabel("<html><font color='green'>I</font></html>");
        this.I.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.I.setBounds(88, 639, 50, 50);
        this.add(this.I);
        
        this.a = new JLabel("<html><font color='green'>a</font></html>");
        this.a.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.a.setBounds(152, 3, 50, 50);
        this.add(this.a);
        
        this.b = new JLabel("<html><font color='green'>b</font></html>");
        this.b.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.b.setBounds(223, 3, 50, 50);
        this.add(this.b);
        
        this.c = new JLabel("<html><font color='green'>c</font></html>");
        this.c.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.c.setBounds(294, 3, 50, 50);
        this.add(this.c);
        
        this.d = new JLabel("<html><font color='green'>d</font></html>");
        this.d.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.d.setBounds(365, 3, 50, 50);
        this.add(this.d);
        
        this.e = new JLabel("<html><font color='green'>e</font></html>");
        this.e.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.e.setBounds(436, 3, 50, 50);
        this.add(this.e);
        
        this.f = new JLabel("<html><font color='green'>f</font></html>");
        this.f.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.f.setBounds(508, 3, 50, 50);
        this.add(this.f);
        
        this.g = new JLabel("<html><font color='green'>g</font></html>");
        this.g.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.g.setBounds(578, 1, 50, 50);
        this.add(this.g);
        
        this.h = new JLabel("<html><font color='green'>h</font></html>");
        this.h.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.h.setBounds(649, 3, 50, 50);
        this.add(this.h);
        
        this.i = new JLabel("<html><font color='green'>i</font></html>");
        this.i.setFont(new Font("Calibri", Font.PLAIN, 35));
        this.i.setBounds(722, 3, 50, 50);
        this.add(this.i);
        
        int n = 0;
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                if(sudokuTable.getSudokuGameData()[k][i].getValue() == 0)
                {
                    JLabel aNumber = new JLabel(" ");
                    aNumber.setFont(new Font("Calibri", Font.PLAIN, 40));
                    aNumber.setBounds(150+i*71, 65+k*71, 67, 67);
                    data.add(aNumber);
                    this.add((JLabel)data.get(n));
                }
                else
                {
                    JLabel aNumber = new JLabel(Integer.toString(sudokuTable.getSudokuGameData()[k][i].getValue()));
                    aNumber.setFont(new Font("Calibri", Font.PLAIN, 40));
                    aNumber.setBounds(150+i*71, 65+k*71, 67, 67);
                    data.add(aNumber);
                    this.add((JLabel)data.get(n));
                }
                
                n++;
            } 
        }
                   
        GridPanel gp = new GridPanel();
        gp.setBounds(120, 55, 650, 650);
        this.add(gp);

        setSize(1200, 800); // manually computed sizes
    }

    //This method will be automatically called
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, null);
    }
    
    public class GridPanel extends JPanel
    {
        public Image image;
        
        public GridPanel(){
            this.image = new ImageIcon("InGameInterface/Grids.jpg").getImage();
            this.setLayout(null);
        }
    
    //This method will be automatically called
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(this.image, 0, 0, null);
        }
    }
    
//    class JTextFieldLimit extends PlainDocument {
//        private int limit;
//        JTextFieldLimit(int limit) {
//          super();
//          this.limit = limit;
//        }
//
//        JTextFieldLimit(int limit, boolean upper) {
//          super();
//          this.limit = limit;
//        }
//
//        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
//          if (str == null)
//            return;
//
//          if ((getLength() + str.length()) <= limit) {
//            super.insertString(offset, str, attr);
//          }
//        }
//    }
    
    public ArrayList<JLabel> getData()
    {
        return this.data;
    }
}
