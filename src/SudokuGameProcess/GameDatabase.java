/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SudokuGameProcess;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Yinghua Zhou 17981371
 */

//This class is used to interact with the "SudokuGameDB" database
//This class contains several methods that can be used to retrieve converted data type so that makes better to interect with the data in the database
public class GameDatabase {
    Connection conn = null;
    private static final String url = "jdbc:derby:SudokuGameDB;create=true"; 
    private static final String username = "sudokuGameData";
    private static final String password = "sudokuGameData";
    
    //This method is to connect to the "sudokuGameDB" database
    public void connectSudokuGameDB()
    {
        try{
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(url+" connected...");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //This method is to get all the tables by a level parameter passes into the method
    //It will return an array list of "SudokuList" class, which stores the data of all the tables from the database
    public ArrayList<SudokuList> getSudokuTables(GameLevel level)
    {
        ArrayList<SudokuList> sudokuTables = new ArrayList<>();
        ResultSet rs = null;
        
        try{
            sudokuTables.clear();
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String command = "SELECT * FROM GAME_INFO WHERE GAME_LEVEL = "+level.getLevelIndicator()+"";
            rs = st.executeQuery(command);
            
            while(rs.next())
            {
                int levelIndicator = rs.getInt("GAME_LEVEL");
                int sudokuTableId = rs.getInt("TABLE_ID");
                String gameDataInString = rs.getString("GAME_DATA");
                String gameAnswerInString = rs.getString("GAME_ANSWER");
                
                sudokuTables.add(new SudokuList(sudokuTableId, GameLevel.values()[levelIndicator], gameDataInString,gameAnswerInString)); 
            }
            rs.close();
            st.close();            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return sudokuTables;
    }
    
    //This method is to get one single specified sudoku table by using the table id passes into the method
    //This method will return a sudokuList type data
    public SudokuList getSpecifiedSudokuTable(int sudokuTableId)
    {
        SudokuList aSudokuTable = null;
        ResultSet rs = null;
        try{
            Statement st = conn.createStatement();
            String command = "SELECT * FROM GAME_INFO WHERE TABLE_ID = "+sudokuTableId+"";
            rs = st.executeQuery(command);
            
            while(rs.next())
            {
                int levelIndicator = rs.getInt("GAME_LEVEL");
                String gameDataInString = rs.getString("GAME_DATA");
                String gameAnswerInString = rs.getString("GAME_ANSWER");
                
                aSudokuTable = new SudokuList(sudokuTableId, GameLevel.values()[levelIndicator], gameDataInString,gameAnswerInString);
            }
            
            rs.close();
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return aSudokuTable;
    }
    
    //This method is used to get the specified sudoku table data in string 
    public String getSpecifiedSudokuTableData(int sudokuTableId)
    {
        String gameData = "";
        ResultSet rs = null;
        try{
            Statement st = conn.createStatement();
            String command = "SELECT GAME_DATA FROM GAME_INFO WHERE TABLE_ID = "+sudokuTableId+"";
            rs = st.executeQuery(command);
            
            while(rs.next())
            {
                gameData = rs.getString("GAME_DATA");
            }
            
            rs.close();
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return gameData;
    }
    
    //This method is used to get the specified sudoku table answer in string 
    public String getSpecifiedSudokuTableAnswer(int sudokuTableId)
    {
        String gameAnswer = "";
        ResultSet rs = null;
        try{
            Statement st = conn.createStatement();
            String command = "SELECT GAME_ANSWER FROM GAME_INFO WHERE TABLE_ID = "+sudokuTableId+"";
            rs = st.executeQuery(command);
            
            while(rs.next())
            {
                gameAnswer = rs.getString("GAME_ANSWER");
            }
            
            rs.close();
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return gameAnswer;
    }
    
    //This method is used to get the game level by searching the sudoku table ID
    //This method will automatically convert the level indicator(which is an integer) to a GameLevel type data
    //This method will return a GameLevel type data
    public GameLevel getGameLevel(int sudokuTableId)
    {
        GameLevel level = GameLevel.UNDEFINED;
        ResultSet rs = null;
        
        try{
            Statement st = conn.createStatement();
            String command = "SELECT GAME_LEVEL FROM GAME_INFO WHERE TABLE_ID = "+ sudokuTableId+"";
            rs = st.executeQuery(command);
            
            int levelIndicator = 0;
            
            while(rs.next())
            {
                levelIndicator = rs.getInt("GAME_LEVEL");
            }
            
            switch(levelIndicator)
            {
                case 1:
                    level = GameLevel.EASY;
                    break;
                case 2:
                    level = GameLevel.MEDIUM;
                    break;
                case 3:
                    level = GameLevel.HARD;
                    break;
            }
            
            rs.close();
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return level;
    }
    
    //This method is designed to be used to get all the table ids based on the level
    //This method will return an arraylist of integers.
    public ArrayList<Integer> getTableIDByLevel(GameLevel level)
    {
        ArrayList<Integer> tableIds = new ArrayList<>();
        ResultSet rs = null;
        
        try{
            Statement st = conn.createStatement();
            String command = "SELECT TABLE_ID FROM GAME_INFO WHERE GAME_LEVEL = "+level.getLevelIndicator();
            rs = st.executeQuery(command);
            
            while(rs.next())
            {
                int tableId = rs.getInt("TABLE_ID");
                
                tableIds.add(tableId);
            }
            
            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return tableIds;
    }
    
    //This method is designed to get the user infomation by searching the user name in the database
    //A user info contains the score, whether the user has a previous unfinished game, and the game data and game id if so.
    //This method will return a UserInfo class type data underlying the username
    public UserInfo getUserInfo(String username)
    {
        UserInfo aUser = null;
        ResultSet rs = null;
        
        try{
            Statement st = conn.createStatement();
            String command = "SELECT * FROM USER_INFO WHERE USER_NAME = '"+username+"'";
            rs = st.executeQuery(command);
            
            while(rs.next())
            {
                String password = rs.getString("PASSWORD");
                int score = rs.getInt("SCORE");
                boolean hasUnfinishedGame = rs.getBoolean("HAS_UNFINISHED_GAME");
                int unfinishedGameID = rs.getInt("UNFINISHED_GAME_ID");
                String unfinishedGameData = rs.getString("UNFINISHED_GAME_DATA");
                
                aUser = new UserInfo(username, password, score, hasUnfinishedGame, unfinishedGameID,unfinishedGameData);
            }
            
            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return aUser;
    }
    
    public SudokuList getUnfinishedGame(String username)
    {
        SudokuList anUnfinishedGame = null;                                    
        ResultSet rs = null;
        
        try{
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String command = "SELECT UNFINISHED_GAME_DATA, UNFINISHED_GAME_ID FROM USER_INFO WHERE USER_NAME = '"+username+"'";
            rs = st.executeQuery(command);
            
            while(rs.next())
            {
                String unfinishedGameDataString = rs.getString("UNFINISHED_GAME_DATA");
                int unfinishedGameId = rs.getInt("UNFINISHED_GAME_ID");
                
                anUnfinishedGame = new SudokuList(unfinishedGameId, this.getGameLevel(unfinishedGameId),
                        unfinishedGameDataString, this.getSpecifiedSudokuTableAnswer(unfinishedGameId));
            }
            
            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return anUnfinishedGame;
    }
    
    public ArrayList<String> getAllUserName()
    {
        ArrayList<String> userNames = new ArrayList<>();
        ResultSet rs = null;
        try{
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String command = "SELECT USER_NAME FROM USER_INFO";
            rs = st.executeQuery(command);
            
            while(rs.next())
            {
                String aUserName = rs.getString("USER_NAME");
                
                userNames.add(aUserName);
            }
            
            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return userNames;
    }
    
    //This method is to get all the user information sorted by ranking
    public ArrayList<UserInfo> getUsersByRanking()
    {
        ArrayList<UserInfo> userArrayList = new ArrayList<>();
        ArrayList<UserInfo> sortedUsersAL = new ArrayList<>();
        UserInfo[] sortedUsers = null;
        
        ResultSet rs = null;
        
        try{
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                String command = "SELECT * FROM USER_INFO";
                rs = st.executeQuery(command);
            
                while(rs.next())
                {
                    String username = rs.getString("USER_NAME");
                    String password = rs.getString("PASSWORD");
                    int score = rs.getInt("SCORE");
                    boolean hasUnfinishedGame = rs.getBoolean("HAS_UNFINISHED_GAME");
                    int unfinishedGameID = rs.getInt("UNFINISHED_GAME_ID");
                    String unfinishedGameData = rs.getString("UNFINISHED_GAME_DATA");
 
                    userArrayList.add(new UserInfo(username,password,score,hasUnfinishedGame,unfinishedGameID,unfinishedGameData));
                }

                sortedUsers = new UserInfo[userArrayList.size()];
                for(int n = 0; n < userArrayList.size(); n++)
                {
                    sortedUsers[n] = userArrayList.get(n);
                }

                //Bubble Sort
                //Sort the users based on their score
                //Thus, when the database is read, it will be sorted and stored in the arrayList.
                boolean sorted = false;
                UserInfo tempUser = null;    
                while(!sorted)
                {
                    sorted = true;
                    for(int i = 0; i < sortedUsers.length - 1; i++)
                    {
                        if(sortedUsers[i].getScore() < sortedUsers[i+1].getScore())
                        {
                            tempUser = sortedUsers[i];
                            sortedUsers[i] = sortedUsers[i+1];
                            sortedUsers[i+1] = tempUser;
                            sorted = false;
                        }
                    }
                }
                
            for(int k = 0; k < sortedUsers.length; k++)
            {
                sortedUsersAL.add(sortedUsers[k]);
            }
                
                rs.close();
                st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return sortedUsersAL;
    }
    
    //This method is to check if the user has already existed by searching the username 
    public boolean checkIfUserExists(String username)
    {
        boolean userExists = false;
        ResultSet rs = null;
        
        try{
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);           
            String command = "SELECT USER_NAME FROM USER_INFO";
            rs = st.executeQuery(command);
            
            while(rs.next())
            {
                if(rs.getString("USER_NAME").equals(username))
                {
                    //Set the userExists to true if the username parameter appears in the database already
                    userExists = true;
                    //If username already in the loop, stop looping and quit the while loop
                    break;
                }
            }
            
            //Close both ResultSet and Statement instances
            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        //Return the boolean instance 
        return userExists;
    }
    
    public boolean checkPasswordCorrect(String username, String password)
    {
        boolean ifCorrect = false;
        ResultSet rs = null;
        try{
            Statement st = conn.createStatement();
            String command = "SELECT PASSWORD FROM USER_INFO WHERE USER_NAME = '"+username+"'";
            rs = st.executeQuery(command);
            
            while(rs.next())
            {
                if(password.equals(rs.getString("PASSWORD")))
                {
                    ifCorrect = true;
                }
            }
            
            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return ifCorrect;
    }
    
    public void changePassword(String username, String newPassword)
    {
        try{
            Statement st = conn.createStatement();
            String command = "UPDATE USER_INFO SET PASSWORD = '"+newPassword+"' WHERE USER_NAME = '"+username+"'";
            st.executeUpdate(command);
            
            System.out.println("Sucessfully changed password.");
            
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    //This method is to update infomation to a specified user(a UserInfo as the parameter)
    public void updateUser(UserInfo aUser)
    {
        try{
            Statement st = conn.createStatement();
            String command = "UPDATE USER_INFO SET PASSWORD = '"+aUser.getPassword()+"', SCORE = "+aUser.getScore()+", HAS_UNFINISHED_GAME = "+aUser.getHasUnfinishedGame()
                    +", UNFINISHED_GAME_ID = "+aUser.getUnfinishedGameID()+", UNFINISHED_GAME_DATA = '"
                    +aUser.getUnfinishedGame()+"' WHERE USER_NAME = '"+aUser.getName()+"'";
            st.executeUpdate(command);
            
            System.out.println("Sucessfully updated user.");
            
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    //This method is to create a new userInfo to the database
    public void createUser(UserInfo aUser)
    {
        try{
            
            //Make sure the user is a new user
            if(!this.checkIfUserExists(aUser.getName()))
            {
                Statement st = conn.createStatement();
                String command = "INSERT INTO USER_INFO VALUES('"+aUser.getName()+"','"
                        +aUser.getPassword()+"',"+aUser.getScore()+","+aUser.getHasUnfinishedGame()+","+aUser.getUnfinishedGameID()
                        +",'"+aUser.getUnfinishedGame()+"')";
                st.executeUpdate(command);
                
                System.out.println("Sucessfully created user.");
                
                st.close();
            }
            //Else if the user has already existed in the database, update the info to the userInfo
            else
            {
                this.updateUser(aUser);
            }    
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
     public void deleteUser(String username)
    {
        try{
            Statement st = conn.createStatement();
            String command = "DELETE FROM USER_INFO WHERE USER_NAME = '"+username+"'";
            st.executeUpdate(command);
            
            System.out.println("Sucessfully deleted user.");
            
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //This method is to close the connection of the database
    public void closeConnection()
    {
        if(conn != null)
        {
            try
            {
                conn.close();   
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
