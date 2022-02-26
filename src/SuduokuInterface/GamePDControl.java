/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

import SudokuGameProcess.CurrentInterface;
import SudokuGameProcess.GameLevel;
import SudokuGameProcess.SudokuList;
import SudokuGameProcess.UserInfo;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 */

//This class is for controlling game process and data
public class GamePDControl {
    private UserInfo currentUser;
    private int inGameTableID;
    private CurrentInterface ci;
    private GameLevel inGameLevel;
    private SudokuList inGameTableData;
    
    //Constructor, default, used to initialize data
    public GamePDControl()
    {
        this.ci = CurrentInterface.USER_TYPE_SELECT;
        this.inGameLevel = GameLevel.UNDEFINED;
        this.inGameTableID = 0;
    }
    
    //Get method
    public UserInfo getCurrentUserInfo()
    {
        return this.currentUser;
    }
    
    //Set method 
    public void setCurrentUserInfo(UserInfo currentUser)
    {
        this.currentUser = currentUser;
    }
    
    //Get method
    public int getInGameTableID()
    {
        return this.inGameTableID;
    }
    
    //Set method 
    public void setInGameTableID(int inGameTableID)
    {
        this.inGameTableID = inGameTableID;
    }
    
    //Get method
    public SudokuList getInGameTableData()
    {
        return this.inGameTableData;
    }
    
    //Set method 
    public void setInGameTableData(SudokuList inGameTableData)
    {
        this.inGameTableData = inGameTableData;
    }
    
    //Get method
    public CurrentInterface getCurrentInterface()
    {
        return this.ci;
    }
    
    //Set method 
    public void setCurrentInterface(CurrentInterface ci)
    {
        this.ci = ci;
    }
    
    //Get method
    public GameLevel getInGameLevel()
    {
        return this.inGameLevel;
    }
    
    //Set method 
    public void setInGameLevel(GameLevel level)
    {
        this.inGameLevel = level;
    }
    
    //This method is used to get the how many same numbers are in the data list and answer list
    //If the return value is 81, then it means this puzzle has been solved
    public int getTotalNumOfCorrectAnswer()
    {
        int totalNumOfCorrectAnswer = 0;
                
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                if(this.inGameTableData.getSudokuGameData()[k][i].getValue() == this.inGameTableData.getSudokuGameAnswer()[k][i].getValue())
                {
                    totalNumOfCorrectAnswer++;
                }
            }
        }
        
        return totalNumOfCorrectAnswer;
    }
}
