/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

import SudokuGameProcess.CurrentInterface;
import SudokuGameProcess.GameLevel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Yinghua Zhou 17981371
 */

//This class is supposed to handle the view of the GUI
//This class contains multiple JPanels that display different view
public class SudokuView extends JFrame implements Observer{
    public SudokuModel model;
    public UserTypeSelect utsPanel = new UserTypeSelect();
    public NewUserInterface nuiPanel = new NewUserInterface();
    public ExistingUserInterface euiPanel = new ExistingUserInterface();
    public MainInterface mainPanel = new MainInterface();
    public SudokuIntroInterface siPanel = new SudokuIntroInterface();
    public LevelSelectInterface lsiPanel = new LevelSelectInterface();
    public LeaderBoardInterface lbiPanel;
    public InGameInterface inGamePanel;
    //This is the constructor
    public SudokuView(String name, SudokuModel model){
        //Set the frame name at the left-top corner
        super(name);
        this.model = new SudokuModel();
        this.model = model;
        this.lbiPanel = new LeaderBoardInterface(this.model.getDatabase().getUsersByRanking());
        this.inGamePanel = new InGameInterface();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        
        //Add the first panel of the program
        this.add(utsPanel);
        this.setVisible(true);
    }
    
    //This method is to add action listener to the components
    public void addActionListener(ActionListener listener) {
        this.utsPanel.getNewUserButton().addActionListener(listener);
        this.utsPanel.getExistingUserButton().addActionListener(listener);
        this.nuiPanel.cancel.addActionListener(listener);
        this.nuiPanel.register.addActionListener(listener);
        this.euiPanel.login.addActionListener(listener);
        this.euiPanel.cancel.addActionListener(listener);
        this.mainPanel.newGame.addActionListener(listener);
        this.mainPanel.continueGame.addActionListener(listener);
        this.mainPanel.leaderBoard.addActionListener(listener);  
        this.mainPanel.howToPlay.addActionListener(listener);
        this.siPanel.back.addActionListener(listener);
        this.lsiPanel.returnBack.addActionListener(listener);
        this.lsiPanel.easy.addActionListener(listener);
        this.lsiPanel.medium.addActionListener(listener);
        this.lsiPanel.hard.addActionListener(listener);
        this.lbiPanel.returnBack.addActionListener(listener);
        this.inGamePanel.quit.addActionListener(listener);
    }
    
    //This method is designed to change interface of the program to the JPanel parameter
    public void changePanel(JPanel aPanel)
    {
        this.getContentPane().removeAll();
        aPanel.setVisible(true);
        this.add(aPanel);
        this.revalidate();
        this.repaint();
    }
    
    //This method is to update the view of the program(Changing panel)
    //This method will be called by notifyObservers() in the SudokuModel class
    public void update(Observable o, Object obj){
        GamePDControl gpdc = (GamePDControl) obj;
        
        if(gpdc.getCurrentInterface() == CurrentInterface.NEW_USER_INTERFACE)
        {
            this.changePanel(nuiPanel);
        }
        else if(gpdc.getCurrentInterface() == CurrentInterface.EXISTING_USER_INTERFACE)
        {
            this.changePanel(euiPanel);
        }
        else if(gpdc.getCurrentInterface() == CurrentInterface.USER_TYPE_SELECT)
        {
            this.changePanel(utsPanel);
        }
        else if(gpdc.getCurrentInterface() == CurrentInterface.MAIN_INTERFACE)
        {
            this.changePanel(mainPanel);
        }
        else if(gpdc.getCurrentInterface() == CurrentInterface.SUDOKU_INTRO_INTERFACE)
        {
            this.changePanel(siPanel);
        }
        else if(gpdc.getCurrentInterface() == CurrentInterface.LEVEL_SELECT)
        {
            this.changePanel(lsiPanel);
        }
        else if(gpdc.getCurrentInterface() == CurrentInterface.LEADERBOARD_INTERFACE)
        {
            this.changePanel(lbiPanel);
        }
        else if(gpdc.getCurrentInterface() == CurrentInterface.IN_GAME)
        {
            this.changePanel(inGamePanel);
        }
        
        this.nuiPanel.register.setEnabled(!(this.nuiPanel.usernameTf.getText().isEmpty() && this.nuiPanel.passwordTf.getText().isEmpty() 
                && this.nuiPanel.confirmPwTf.getText().isEmpty()));
        this.euiPanel.login.setEnabled(!(this.euiPanel.usernameTf.getText().isEmpty() && this.euiPanel.passwordTf.getText().isEmpty()));
    }
}
