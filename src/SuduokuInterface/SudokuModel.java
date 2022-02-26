/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

import SudokuGameProcess.CurrentInterface;
import SudokuGameProcess.GameDatabase;
import SudokuGameProcess.SudokuList;
import SudokuGameProcess.UserInfo;
import java.util.Observable;
import java.util.Random;

/**
 *
 * @author Yinghua Zhou 17981371
 */

//This class is the model of the program
public class SudokuModel extends Observable{
    private GameDatabase db;
    private GamePDControl gpdc;   

    //Constructor of the class
    public SudokuModel()
    {
        this.db = new GameDatabase();
        this.db.connectSudokuGameDB();
        this.gpdc = new GamePDControl();
    }
    
    //This method is to check if the login details are correct
    public boolean checkLoginDetails(String username, String password)
    {   
        return this.db.checkPasswordCorrect(username, password);
    }
    
    //This method is to create a new user into the database
    public void createUser(UserInfo newUser)
    {
        this.db.createUser(newUser);
        this.changeInterface(CurrentInterface.MAIN_INTERFACE);
    }
    
    //This method is to check if the specified user has an unifinished game
    public boolean checkIfHasUnfinishedGame(UserInfo aUser)
    {
        return this.gpdc.getCurrentUserInfo().getHasUnfinishedGame();
    }
    
    //This method is to change the status of the CurrentInterface instance and also the CurrentInterface instance inside the gpdc instance
    //Also to call setChange() and notifyObservers()
    public void changeInterface(CurrentInterface ci)
    {
        this.gpdc.setCurrentInterface(ci);
        
        this.setChanged();
        this.notifyObservers(this.gpdc); //To call the update() method inside the SudokuView class
    }
    
    //This method is to get a random game based on a game level chosen by user
    public void createRandomGame()
    {
        Random random = new Random();
        this.gpdc.setInGameTableID(this.db.getTableIDByLevel(this.gpdc.getInGameLevel())
                .get(random.nextInt(this.db.getTableIDByLevel(this.gpdc.getInGameLevel()).size())));
        this.gpdc.setInGameTableData(this.getDatabase().getSpecifiedSudokuTable(this.getGPDC().getInGameTableID()));
        
        this.setChanged();
        this.notifyObservers(this.gpdc);
    }

    public void updateUser()
    {
        UserInfo aUser = new UserInfo(this.gpdc.getCurrentUserInfo().getName(),this.gpdc.getCurrentUserInfo().getPassword(),
            this.gpdc.getCurrentUserInfo().getScore(),this.gpdc.getCurrentUserInfo().getHasUnfinishedGame(),this.gpdc.getInGameTableID(),
            this.gpdc.getInGameTableData().convertTableToString(this.gpdc.getInGameTableData().getSudokuGameData()));
        
        this.db.updateUser(aUser);
        
        this.setChanged();
        this.notifyObservers(this.gpdc);
    }
    
    public GameDatabase getDatabase()
    {
        return this.db;
    }
    
    public GamePDControl getGPDC()
    {
        return this.gpdc;
    }
}
