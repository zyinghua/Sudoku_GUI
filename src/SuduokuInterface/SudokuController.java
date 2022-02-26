/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

import SudokuGameProcess.CheckUserAnswer;
import SudokuGameProcess.CurrentInterface;
import SudokuGameProcess.GameLevel;
import SudokuGameProcess.SudokuList;
import SudokuGameProcess.UserInfo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

/**
 *
 * @author Yinghua Zhou 17981371
 */
public class SudokuController implements ActionListener{
    public SudokuView view;
    public SudokuModel model;
    public JFrame quitFr;
    public JFrame fillFr;
    public JTextField tf;
    public JTextField tf2;
    public JLabel hint;
    public JFrame removeFr;
    public JTextField rmTf;
    public JLabel rmHint;
    public JFrame congraFr;
    public JFrame clearFr;
    public SudokuController(SudokuView view, SudokuModel model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this); // Add Actionlistener (the instance of this class) to View.
    }
    
    //This method is to get the action command from the interfaces and interact with the process data
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Obtain the text displayed on the component.

        if(command.equals("New User"))
        {
            this.model.changeInterface(CurrentInterface.NEW_USER_INTERFACE);
        }
        else if(command.equals("Existing User"))
        {
            this.model.changeInterface(CurrentInterface.EXISTING_USER_INTERFACE);
        }
        else if(command.equals("nuiCancel"))
        {
            this.model.changeInterface(CurrentInterface.USER_TYPE_SELECT);
            this.view.nuiPanel.hint.setText("");
            this.view.nuiPanel.resetJTextFields();
        }
        else if(command.equals("Register"))
        {
            String username = this.view.nuiPanel.usernameTf.getText();
            String password = this.view.nuiPanel.passwordTf.getText();
            String confirmPw = this.view.nuiPanel.confirmPwTf.getText();
            
            if(!(password.equals(confirmPw)))
            {
                this.view.nuiPanel.hint.setText("<html><font color='red'>The confirmation of your password does not match! Please try again~</font></html>");
            }
            else if(this.model.getDatabase().checkIfUserExists(username))
            {
                this.view.nuiPanel.hint.setText("<html><font color='red'>This name already exists! Please input another one~</font></html>");
            }
            else
            {
                this.view.nuiPanel.hint.setText("");
                UserInfo newUser = new UserInfo(username, password);
                this.model.getDatabase().createUser(newUser);
                this.model.getGPDC().setCurrentUserInfo(newUser);
                this.view.mainPanel.continueGame.setBackground(Color.lightGray);
                this.view.mainPanel.continueGame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                this.model.changeInterface(CurrentInterface.MAIN_INTERFACE);
            }
        }
        else if(command.equals("euiCancel"))
        {
            this.model.changeInterface(CurrentInterface.USER_TYPE_SELECT);
            this.view.euiPanel.hint.setText("");
            this.view.euiPanel.resetJTextFields();
        }
        else if(command.equals("Log in"))
        {
            String username = this.view.euiPanel.usernameTf.getText();
            String password = this.view.euiPanel.passwordTf.getText();
            
            if(!(this.model.getDatabase().checkIfUserExists(username)))
            {
                this.view.euiPanel.hint.setText("<html><font color='red'>This user does not exist!</font></html>");
            }
            else if(!(this.model.getDatabase().checkPasswordCorrect(username, password)))
            {
                this.view.euiPanel.hint.setText("<html><font color='red'>Your password is incorrect! Please try again~</font></html>");
            }
            else
            {
                this.view.euiPanel.hint.setText("");
                UserInfo currentUser = this.model.getDatabase().getUserInfo(username);
                this.model.getGPDC().setCurrentUserInfo(currentUser);
                this.model.changeInterface(CurrentInterface.MAIN_INTERFACE);
                System.out.println("Login successful.");   
                
                if(!(this.model.checkIfHasUnfinishedGame(this.model.getGPDC().getCurrentUserInfo())))
                {
                    this.view.mainPanel.continueGame.setBackground(Color.lightGray);
                    this.view.mainPanel.continueGame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            }   
        }
        else if(command.equals("New Game"))
        {
            this.model.changeInterface(CurrentInterface.LEVEL_SELECT);
            this.view.mainPanel.hint.setText("");
        }
        else if(command.equals("Continue Game"))
        {
            this.view.mainPanel.hint.setText("");
            
            if(!(this.model.checkIfHasUnfinishedGame(this.model.getGPDC().getCurrentUserInfo())))
            {
                this.view.mainPanel.hint.setText("<html><font color='red'>You have no games to continue!</font></html>");
            }
            else
            {
                this.model.getGPDC().setInGameLevel(this.model.getDatabase().getGameLevel(this.model.getGPDC().getCurrentUserInfo().getUnfinishedGameID()));
                this.model.getGPDC().setInGameTableID(this.model.getGPDC().getCurrentUserInfo().getUnfinishedGameID());
//                this.model.getGPDC().setInGameTableData(new SudokuList(this.model.getGPDC().getInGameTableID(),this.model.getGPDC().getInGameLevel(),
//                this.model.getDatabase().getSpecifiedSudokuTableData(this.model.getGPDC().getCurrentUserInfo().getUnfinishedGameID()),
//                this.model.getGPDC().getCurrentUserInfo().getUnfinishedGame(),this.model.getDatabase().getSpecifiedSudokuTableAnswer(this.model.getGPDC().getCurrentUserInfo().getUnfinishedGameID())));
//                
//                this.view.inGamePanel = new InGameInterface(this.model.getGPDC().getInGameTableData());
                this.model.getGPDC().setInGameTableData(new SudokuList(this.model.getGPDC().getInGameTableID(),this.model.getGPDC().getInGameLevel(), this.model.getDatabase().getSpecifiedSudokuTableData(this.model.getGPDC().getCurrentUserInfo().getUnfinishedGameID()),
                this.model.getGPDC().getCurrentUserInfo().getUnfinishedGame(),this.model.getDatabase().getSpecifiedSudokuTableAnswer(this.model.getGPDC().getCurrentUserInfo().getUnfinishedGameID())));
                
                this.view.inGamePanel = new InGameInterface(new SudokuList(this.model.getGPDC().getInGameTableID(),this.model.getGPDC().getInGameLevel(), this.model.getDatabase().getSpecifiedSudokuTableData(this.model.getGPDC().getCurrentUserInfo().getUnfinishedGameID()),
                this.model.getGPDC().getCurrentUserInfo().getUnfinishedGame(),this.model.getDatabase().getSpecifiedSudokuTableAnswer(this.model.getGPDC().getCurrentUserInfo().getUnfinishedGameID())));
                this.view.inGamePanel.quit.addActionListener(this);
                this.view.inGamePanel.clear.addActionListener(this);
                this.view.inGamePanel.fill.addActionListener(this);
                this.view.inGamePanel.remove.addActionListener(this);
                this.view.inGamePanel.check.addActionListener(this);
                
                this.model.changeInterface(CurrentInterface.IN_GAME);
            }
        }
        else if(command.equals("LeaderBoard"))
        {
            this.view.lbiPanel.no1Username.setText(this.model.getDatabase().getUsersByRanking().get(0).getName());
            this.view.lbiPanel.no1Score.setText(Integer.toString(this.model.getDatabase().getUsersByRanking().get(0).getScore()));
            this.view.lbiPanel.no2Username.setText(this.model.getDatabase().getUsersByRanking().get(1).getName());
            this.view.lbiPanel.no2Score.setText(Integer.toString(this.model.getDatabase().getUsersByRanking().get(1).getScore()));
            this.view.lbiPanel.no3Username.setText(this.model.getDatabase().getUsersByRanking().get(2).getName());
            this.view.lbiPanel.no3Score.setText(Integer.toString(this.model.getDatabase().getUsersByRanking().get(2).getScore()));

            this.model.changeInterface(CurrentInterface.LEADERBOARD_INTERFACE);
            this.view.mainPanel.hint.setText("");
        }
        else if(command.equals("Sudoku Intro"))
        {
            this.model.changeInterface(CurrentInterface.SUDOKU_INTRO_INTERFACE);
            this.view.mainPanel.hint.setText("");
        }
        else if(command.equals("siiReturn"))
        {
            this.model.changeInterface(CurrentInterface.MAIN_INTERFACE);
        }
        else if(command.equals("Easy"))
        {
            this.model.getGPDC().setInGameLevel(GameLevel.EASY);
            this.model.createRandomGame();
            this.view.inGamePanel = new InGameInterface(this.model.getGPDC().getInGameTableData());
            this.view.inGamePanel.quit.addActionListener(this);
            this.view.inGamePanel.clear.addActionListener(this);
            this.view.inGamePanel.fill.addActionListener(this);
            this.view.inGamePanel.remove.addActionListener(this);
            this.view.inGamePanel.check.addActionListener(this);
            this.model.getGPDC().getCurrentUserInfo().setHasUnfinishedGame(true);
            this.model.changeInterface(CurrentInterface.IN_GAME);
        }
        else if(command.equals("Medium"))
        {
            this.model.getGPDC().setInGameLevel(GameLevel.MEDIUM);
            this.model.createRandomGame();
            this.view.inGamePanel = new InGameInterface(this.model.getGPDC().getInGameTableData());
            this.view.inGamePanel.quit.addActionListener(this);
            this.view.inGamePanel.clear.addActionListener(this);
            this.view.inGamePanel.fill.addActionListener(this);
            this.view.inGamePanel.remove.addActionListener(this);
            this.view.inGamePanel.check.addActionListener(this);
            this.model.getGPDC().getCurrentUserInfo().setHasUnfinishedGame(true);
            this.model.changeInterface(CurrentInterface.IN_GAME);
        }
        else if(command.equals("Hard"))
        {
            this.model.getGPDC().setInGameLevel(GameLevel.HARD);
            this.model.createRandomGame();
            this.view.inGamePanel = new InGameInterface(this.model.getGPDC().getInGameTableData());
            this.view.inGamePanel.quit.addActionListener(this);
            this.view.inGamePanel.clear.addActionListener(this);
            this.view.inGamePanel.fill.addActionListener(this);
            this.view.inGamePanel.remove.addActionListener(this);
            this.view.inGamePanel.check.addActionListener(this);
            this.model.getGPDC().getCurrentUserInfo().setHasUnfinishedGame(true);
            this.model.changeInterface(CurrentInterface.IN_GAME);
        }
        else if(command.equals("lsiReturn"))
        {
            this.model.changeInterface(CurrentInterface.MAIN_INTERFACE);
        }
        else if(command.equals("lbiReturn"))
        {
            this.model.changeInterface(CurrentInterface.MAIN_INTERFACE);
        }
        else if(command.equals("Quit"))
        {
            this.quitFr = new JFrame("Quit");
            this.quitFr.setLocation(650,280);
            this.quitFr.setSize(600,300);
            this.quitFr.setVisible(true);
            this.quitFr.setResizable(false);
            
            JPanel quitPa = new JPanel();
            quitPa.setLayout(null);
            quitPa.setSize(600,300);
            
            JLabel text = new JLabel("Are you sure to quit? ");
            text.setFont(new Font("Calibri", Font.PLAIN, 22));
            text.setBounds(17,10,550, 50);
            text.setHorizontalAlignment(JLabel.CENTER);
            quitPa.add(text);
            
            JLabel text2 = new JLabel("(Your game will be stored)");
            text2.setFont(new Font("Calibri", Font.PLAIN, 22));
            text2.setBounds(17,50,550, 50);
            text2.setHorizontalAlignment(JLabel.CENTER);
            quitPa.add(text2);
            
            JLabel text3 = new JLabel("[You need to log in again to continue once you quit]");
            text3.setFont(new Font("Calibri", Font.PLAIN, 22));
            text3.setBounds(17,90,550, 50);
            text3.setHorizontalAlignment(JLabel.CENTER);
            quitPa.add(text3);
            
            JButton quitBt = new JButton("Quit");
            quitBt.setActionCommand("QuitBt");
            quitBt.setBounds(100,160,120,50);
            quitBt.setFont(new Font("Calibri", Font.PLAIN, 25));
            quitBt.setBackground(Color.WHITE);
            quitBt.setContentAreaFilled(false);
            quitBt.setOpaque(true);
            quitBt.addActionListener(this);
            quitPa.add(quitBt);
            
            JButton cancel = new JButton("Cancel");
            cancel.setActionCommand("CancelqtFr");
            cancel.setBounds(350,160,120,50);
            cancel.setFont(new Font("Calibri", Font.PLAIN, 25));
            cancel.setBackground(Color.WHITE);
            cancel.setContentAreaFilled(false);
            cancel.setOpaque(true);
            cancel.addActionListener(this);
            quitPa.add(cancel);
            
            this.quitFr.add(quitPa);
        }
        else if(command.equals("Fill"))
        { 
            this.fillFr = new JFrame("Fill");
            this.fillFr.setLocation(650,280);
            this.fillFr.setSize(600,410);
            this.fillFr.setVisible(true);
            this.fillFr.setResizable(false);
            
            JPanel fillPa = new JPanel();
            fillPa.setLayout(null);
            fillPa.setSize(600,450);
            
            JLabel text = new JLabel("Please input the grid you want to fill in(eg: Aa): ");
            text.setFont(new Font("Calibri", Font.PLAIN, 22));
            text.setBounds(40,10,500, 50);
            text.setHorizontalAlignment(JLabel.CENTER);
            fillPa.add(text);
            
            this.tf = new JTextField();
            tf.setBounds(40,60,500, 50);
            tf.setFont(new Font("Calibri", Font.PLAIN, 20));
            tf.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e){
                tf.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
            });    
            fillPa.add(tf);
            
            JLabel text2 = new JLabel("Please input the value you want to fill in(eg: 6): ");
            text2.setFont(new Font("Calibri", Font.PLAIN, 22));
            text2.setBounds(40,120,500, 50);
            text2.setHorizontalAlignment(JLabel.CENTER);
            fillPa.add(text2);
            
            this.tf2 = new JTextField();
            tf2.setBounds(40,170,500, 50);
            tf2.setFont(new Font("Calibri", Font.PLAIN, 20));
            tf2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e){
                tf2.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
            });
            fillPa.add(tf2);
            
            JButton fill = new JButton("Fill");
            fill.setActionCommand("Fill2");
            fill.setBounds(100,260,120,50);
            fill.setFont(new Font("Calibri", Font.PLAIN, 25));
            fill.setBackground(Color.WHITE);
            fill.setContentAreaFilled(false);
            fill.setOpaque(true);
            fill.addActionListener(this);
            fillPa.add(fill);
            
            JButton cancel = new JButton("Cancel");
            cancel.setActionCommand("CancelfillFr");
            cancel.setBounds(350,260,120,50);
            cancel.setFont(new Font("Calibri", Font.PLAIN, 25));
            cancel.setBackground(Color.WHITE);
            cancel.setContentAreaFilled(false);
            cancel.setOpaque(true);
            cancel.addActionListener(this);
            fillPa.add(cancel);
            
            this.hint = new JLabel("");
            hint.setFont(new Font("Calibri", Font.PLAIN, 22));
            hint.setBounds(30,320,500, 50);
            hint.setHorizontalAlignment(JLabel.CENTER);
            fillPa.add(hint);
            
            this.fillFr.add(fillPa);
        }
        else if(command.equals("Remove"))
        {
            this.removeFr = new JFrame("Remove");
            this.removeFr.setLocation(650,280);
            this.removeFr.setSize(600,300);
            this.removeFr.setVisible(true);
            this.removeFr.setResizable(false);
            
            JPanel removePa = new JPanel();
            removePa.setLayout(null);
            removePa.setSize(600,300);
            
            JLabel text = new JLabel("Please input the grid you want to remove from(eg: Aa): ");
            text.setFont(new Font("Calibri", Font.PLAIN, 22));
            text.setBounds(17,10,550, 50);
            text.setHorizontalAlignment(JLabel.CENTER);
            removePa.add(text);
            
            this.rmTf = new JTextField();
            this.rmTf.setBounds(40,60,500, 50);
            this.rmTf.setFont(new Font("Calibri", Font.PLAIN, 20));
            this.rmTf.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e){
                rmTf.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
            });    
            removePa.add(rmTf);
            
            JButton remove = new JButton("Remove");
            remove.setActionCommand("RemoveBt");
            remove.setBounds(100,160,120,50);
            remove.setFont(new Font("Calibri", Font.PLAIN, 25));
            remove.setBackground(Color.WHITE);
            remove.setContentAreaFilled(false);
            remove.setOpaque(true);
            remove.addActionListener(this);
            removePa.add(remove);
            
            JButton cancel = new JButton("Cancel");
            cancel.setActionCommand("CancelrmFr");
            cancel.setBounds(350,160,120,50);
            cancel.setFont(new Font("Calibri", Font.PLAIN, 25));
            cancel.setBackground(Color.WHITE);
            cancel.setContentAreaFilled(false);
            cancel.setOpaque(true);
            cancel.addActionListener(this);
            removePa.add(cancel);
            
            this.hint = new JLabel("");
            hint.setFont(new Font("Calibri", Font.PLAIN, 22));
            hint.setBounds(40,300,500, 50);
            hint.setHorizontalAlignment(JLabel.CENTER);
            removePa.add(hint);
            
            this.removeFr.add(removePa);
        }
        else if(command.equals("Fill2"))
        {
            int number = 0;
            int column = 0;
            int row = 0;
            if(this.tf.getText().isEmpty() || this.tf2.getText().isEmpty())
            {
                if(this.tf.getText().isEmpty())
                {
                    this.hint.setText("<html><font color='red'>Please input the grid you want to fill in!</font></html>");
                }
                else 
                {
                    this.hint.setText("<html><font color='red'>Please input the value you want to fill in!</font></html>");
                }  
            }
            else
            {
                char columnChar = this.tf.getText().charAt(0);
                char rowChar = this.tf.getText().charAt(1);
                if((!(columnChar >= 'A'))||(!(columnChar <= 'I'))||(!(rowChar >= 'a'))||(!(rowChar <= 'i')))
                {
                    this.hint.setText("<html><font color='red'>The grid number you entered does not exist!</font></html>");
                }
                else
                {
                    switch(columnChar)
                    {
                        case 'A':
                            column = 0;
                            break;
                        case 'B':
                            column = 1;
                            break;
                        case 'C':
                            column = 2;
                            break;
                        case 'D':
                            column = 3;
                            break;
                        case 'E':
                            column = 4;
                            break;
                        case 'F':
                            column = 5;
                            break;
                        case 'G':
                            column = 6;
                            break;
                        case 'H':
                            column = 7;
                            break;
                        case 'I':
                            column = 8;
                            break;
                    }

                    switch(rowChar)
                    {
                        case 'a':
                            row = 0;
                            break;
                        case 'b':
                            row = 1;
                            break;
                        case 'c':
                            row = 2;
                            break;
                        case 'd':
                            row = 3;
                            break;
                        case 'e':
                            row = 4;
                            break;
                        case 'f':
                            row = 5;
                            break;
                        case 'g':
                            row = 6;
                            break;
                        case 'h':
                            row = 7;
                            break;
                        case 'i':
                            row = 8;
                            break;
                    }
                }

                number = Character.getNumericValue(this.tf2.getText().charAt(0));
                if(this.model.getGPDC().getInGameTableData().getSudokuGameData()[column][row].getIsModifiable())
                {
                    if(number > 0 && number < 10)
                    {

                        this.model.getGPDC().getInGameTableData().getSudokuGameData()[column][row].setValue(number);
                        this.model.getGPDC().getInGameTableData().getSudokuGameData()[column][row].setIsIncorrect(false);
                        //Here, this algorithm was calculated by myself:
                        //The start number of every new column is k*8+k
                        //And every first number of the column has row value = 0
                        //And every time it moves to the next grid, row++(if it still in the same column)
                        //And every time if it moves to the next column, row will go back to 0
                        //Makes k*8+k+i establishable
                        this.view.inGamePanel.getData().get(column*8+column+row).setText(Integer.toString(number));
                        
                        if(this.model.getGPDC().getTotalNumOfCorrectAnswer() == 81)
                        {
                            this.model.getGPDC().getCurrentUserInfo().addScore(this.model.getGPDC().getInGameLevel());
                            int scoreAdded = this.model.getGPDC().getCurrentUserInfo().getScoreAdded(this.model.getGPDC().getInGameLevel());
                            
                            this.congraFr = new JFrame("Congratulation");
                            this.congraFr.setLocation(650,280);
                            this.congraFr.setSize(600,300);
                            this.congraFr.setVisible(true);
                            this.congraFr.setResizable(false);
                            this.congraFr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                            JPanel congraPa = new JPanel();
                            congraPa.setLayout(null);
                            congraPa.setSize(600,300);

                            JLabel conTx = new JLabel("Congratulations!");
                            conTx.setFont(new Font("Calibri", Font.PLAIN, 22));
                            conTx.setBounds(17, 10, 550, 50);
                            conTx.setHorizontalAlignment(JLabel.CENTER);
                            congraPa.add(conTx);
                            
                            JLabel conTx2 = new JLabel("You have solved this puzzle!");
                            conTx2.setFont(new Font("Calibri", Font.PLAIN, 22));
                            conTx2.setBounds(17,50,550, 50);
                            conTx2.setHorizontalAlignment(JLabel.CENTER);
                            congraPa.add(conTx2);
                            
                            JLabel conTx3 = new JLabel("You have got "+scoreAdded+" points! Your current score is "+this.model.getGPDC().getCurrentUserInfo().getScore()+".");
                            conTx3.setFont(new Font("Calibri", Font.PLAIN, 22));
                            conTx3.setBounds(17,90,550, 50);
                            conTx3.setHorizontalAlignment(JLabel.CENTER);
                            congraPa.add(conTx3);

                            JButton ok = new JButton("Ok");
                            ok.setActionCommand("CongraOk");
                            ok.setBounds(80,160,120,50);
                            ok.setFont(new Font("Calibri", Font.PLAIN, 25));
                            ok.setBackground(Color.WHITE);
                            ok.setContentAreaFilled(false);
                            ok.setOpaque(true);
                            ok.addActionListener(this);
                            congraPa.add(ok);

                            JButton playAgain = new JButton("Play another game");
                            playAgain.setActionCommand("PAG");
                            playAgain.setBounds(270,160,250,50);
                            playAgain.setFont(new Font("Calibri", Font.PLAIN, 25));
                            playAgain.setBackground(Color.WHITE);
                            playAgain.setContentAreaFilled(false);
                            playAgain.setOpaque(true);
                            playAgain.addActionListener(this);
                            congraPa.add(playAgain);
                            
                            this.congraFr.add(congraPa);
                            
                            this.model.getGPDC().getCurrentUserInfo().clearUnfinishedGameData();
                            this.model.updateUser();
                        }
                    }
                    else
                    {
                        this.hint.setText("<html><font color='red'>The value you entered is not eligible!</font></html>");
                    }     
                }
                else
                {
                    this.hint.setText("<html><font color='red'>The grid can not be modified!</font></html>");
                }  
            }    
            fillFr.dispose();   
        }
        else if(command.equals("CancelfillFr"))
        {
            fillFr.dispose();   
        }
        else if(command.equals("CancelrmFr"))
        {
            removeFr.dispose();   
        }
        else if(command.equals("RemoveBt"))
        {
            int column = 0;
            int row = 0;
            if(this.rmTf.getText().isEmpty())
            {
                this.rmHint.setText("<html><font color='red'>Please input the grid you want to remove from!</font></html>");
            }
            else
            {
                char columnChar = this.rmTf.getText().charAt(0);
                char rowChar = this.rmTf.getText().charAt(1);
                if((!(columnChar >= 'A'))||(!(columnChar <= 'I'))||(!(rowChar >= 'a'))||(!(rowChar <= 'i')))
                {
                    this.rmHint.setText("<html><font color='red'>The grid number you entered does not exist!</font></html>");
                }
                else
                {
                    switch(columnChar)
                    {
                        case 'A':
                            column = 0;
                            break;
                        case 'B':
                            column = 1;
                            break;
                        case 'C':
                            column = 2;
                            break;
                        case 'D':
                            column = 3;
                            break;
                        case 'E':
                            column = 4;
                            break;
                        case 'F':
                            column = 5;
                            break;
                        case 'G':
                            column = 6;
                            break;
                        case 'H':
                            column = 7;
                            break;
                        case 'I':
                            column = 8;
                            break;
                    }

                    switch(rowChar)
                    {
                        case 'a':
                            row = 0;
                            break;
                        case 'b':
                            row = 1;
                            break;
                        case 'c':
                            row = 2;
                            break;
                        case 'd':
                            row = 3;
                            break;
                        case 'e':
                            row = 4;
                            break;
                        case 'f':
                            row = 5;
                            break;
                        case 'g':
                            row = 6;
                            break;
                        case 'h':
                            row = 7;
                            break;
                        case 'i':
                            row = 8;
                            break;
                    }
                }
            }
            
            if(this.model.getGPDC().getInGameTableData().getSudokuGameData()[column][row].getIsModifiable() == true)
            {
                this.model.getGPDC().getInGameTableData().getSudokuGameData()[column][row].RemoveData();
                this.model.getGPDC().getInGameTableData().getSudokuGameData()[column][row].setIsIncorrect(false);
                this.view.inGamePanel.getData().get(column*8+column+row).setText(" ");
            }
            else
            {
                this.rmHint.setText("<html><font color='red'>This grid can not be modified!</font></html>");
            }
            
            removeFr.dispose();
        }
        else if(command.equals("Clear"))
        {   
            this.clearFr = new JFrame("Clear");
            this.clearFr.setLocation(650,280);
            this.clearFr.setSize(600,250);
            this.clearFr.setVisible(true);
            this.clearFr.setResizable(false);
            
            JPanel clearPa = new JPanel();
            clearPa.setLayout(null);
            clearPa.setSize(600,300);
            
            JLabel text = new JLabel("Are you sure to clear? ");
            text.setFont(new Font("Calibri", Font.PLAIN, 22));
            text.setBounds(17,10,550, 50);
            text.setHorizontalAlignment(JLabel.CENTER);
            clearPa.add(text);
            
            JLabel text2 = new JLabel("It will clear all the numbers you entered");
            text2.setFont(new Font("Calibri", Font.PLAIN, 22));
            text2.setBounds(17,50,550, 50);
            text2.setHorizontalAlignment(JLabel.CENTER);
            clearPa.add(text2);
            
            JButton clearYes = new JButton("Yes");
            clearYes.setActionCommand("ClearYes");
            clearYes.setBounds(110,140,120,50);
            clearYes.setFont(new Font("Calibri", Font.PLAIN, 25));
            clearYes.setBackground(Color.WHITE);
            clearYes.setContentAreaFilled(false);
            clearYes.setOpaque(true);
            clearYes.addActionListener(this);
            clearPa.add(clearYes);
            
            JButton cancel = new JButton("No");
            cancel.setActionCommand("ClearNo");
            cancel.setBounds(350,140,120,50);
            cancel.setFont(new Font("Calibri", Font.PLAIN, 25));
            cancel.setBackground(Color.WHITE);
            cancel.setContentAreaFilled(false);
            cancel.setOpaque(true);
            cancel.addActionListener(this);
            clearPa.add(cancel);
            
            this.clearFr.add(clearPa);
        }
        else if(command.equals("Check"))
        {
            CheckUserAnswer cua = new CheckUserAnswer();
            cua.checkAnswer(this.model.getGPDC().getInGameTableData());
            
            for(int k = 0; k < 9; k++)
            {
                for(int i = 0; i < 9; i++)
                {
                    if(this.model.getGPDC().getInGameTableData().getSudokuGameData()[k][i].getIsIncorrect())
                    {
                        this.view.inGamePanel.getData().get(k*8+k+i).setText("<html><font color='red'>"+this.model.getGPDC().getInGameTableData().getSudokuGameData()[k][i].getValue()+"</font></html>");
                    }
                }
            }
        }
        else if(command.equals("CancelqtFr"))
        {
            quitFr.dispose();
        }
        else if(command.equals("QuitBt"))
        {
            this.model.updateUser();
            this.model.changeInterface(CurrentInterface.MAIN_INTERFACE);
            this.quitFr.dispose();
        }
        else if(command.equals("CongraOk"))
        {
            this.model.changeInterface(CurrentInterface.MAIN_INTERFACE);
            this.congraFr.dispose();
        }
        else if(command.equals("PAG"))
        {
            this.model.changeInterface(CurrentInterface.LEVEL_SELECT);
            this.congraFr.dispose();
        }
        else if(command.equals("ClearYes"))
        {
            for(int k = 0; k < 9; k++)
            {
                for(int i = 0; i < 9; i++)
                {
                    if(this.model.getGPDC().getInGameTableData().getSudokuGameData()[k][i].getIsModifiable())
                    {
                        this.model.getGPDC().getInGameTableData().getSudokuGameData()[k][i].RemoveData();
                        this.model.getGPDC().getInGameTableData().getSudokuGameData()[k][i].setIsIncorrect(false);
                        
                        this.view.inGamePanel.getData().get(k*8+k+i).setText(" ");
                    }
                }
            }
            
            this.clearFr.dispose();
        }
        else if(command.equals("ClearNo"))
        {
            this.clearFr.dispose();
        }
    }  
}
