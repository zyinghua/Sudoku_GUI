package SudokuGameProcess;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 * 
 * This class is to store the user profile(Initialize an user).
 */
public class UserInfo {
    private String name;
    private String password;
    private int score;
    private boolean hasUnfinishedGame;
    private int unfinishedGameID;
    private String unfinishedGame;
   
    //Constructor 1, with password & username parameters only, used to record new user
    public UserInfo(String name, String password)
    {
        this.name = name;
        this.password = password;
        this.score = 0;
        this.hasUnfinishedGame = false;
        //If this.unfinishedGameID = 0, it means this user does not have any unfinishedGame recorded.
        this.unfinishedGameID = 0;
        //If this.unfinishedGame = "0", this means no unfinishedGame recorded.
        this.unfinishedGame = "0";
    }
    
    //Constructor 2, has 2 parameters taken.
    public UserInfo(String name, String password, int score)
    {
        this.name = name;
        this.password = password;
        this.score = score;
        this.hasUnfinishedGame = false;
        this.unfinishedGameID = 0;
        this.unfinishedGame = "0";
    }
    
    //Constructor 3, has 5 parameters taken.
    public UserInfo(String name, String password, int score, boolean hasUnfinishedGame,int unfinishedGameID, String unfinishedGame)
    {
        this.name = name;
        this.password = password;
        this.score = score;
        this.hasUnfinishedGame = hasUnfinishedGame;
        this.unfinishedGameID = unfinishedGameID;
        this.unfinishedGame = unfinishedGame;
    }
    
    public boolean getHasUnfinishedGame()
    {
        return this.hasUnfinishedGame;
    }
    
    public void setHasUnfinishedGame(boolean hasUnfinishedGame)
    {
        this.hasUnfinishedGame = hasUnfinishedGame;
    }
    
    public int getUnfinishedGameID()
    {
        return this.unfinishedGameID;
    }
    
    public void setUnfinishedGameID(int unfinishedGameID)
    {
        this.unfinishedGameID = unfinishedGameID;
    }
    
    public String getUnfinishedGame()
    {
        return this.unfinishedGame;
    }
    
    public void setUnfinishedGame(String unfinishedGame)
    {
        this.unfinishedGame = unfinishedGame;
    }
    
    //Returning the name of the user
    public String getName()
    {
        return this.name;
    }
    
    //Set the user name
    public void setName(String name)
    {
        this.name = name;
    }
    
    //Get the password
    public String getPassword()
    {
        return this.password;
    }
    
    //Set the password 
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    //Returning how many puzzles the user solved
    public int getScore()
    {
        return this.score;
    }
    
    //Set puzzle solved
    public void setScore(int score)
    {
        this.score= score;
    }
    
    //If the user solves an easy level puzzle, add 2 to the user's score.
    //If the user solves a medium level puzzle, add 3 to the user's score.
    //If the user solves a hard level puzzle, add 4 to the user's score.
    public void addScore(GameLevel level)
    {
        if(level == GameLevel.EASY)
        {
            this.score += 2;
        }
        else if(level == GameLevel.MEDIUM)
        {
            this.score += 3;
        }
        else if(level == GameLevel.HARD)
        {
            this.score += 4;
        }
    }
    
    //This method is used to get how many points added to the user score
    public int getScoreAdded(GameLevel level)
    {
        int scoreAdded = 0;
        
        if(level == GameLevel.EASY)
        {
            scoreAdded = 2;
        }
        else if(level == GameLevel.MEDIUM)
        {
            scoreAdded = 3;
        }
        else if(level == GameLevel.HARD)
        {
            scoreAdded = 4;
        }
        
        return scoreAdded;
    }
    
    //This method is to clear all the data of an unfinished game from the user
    public void clearUnfinishedGameData()
    {
        this.hasUnfinishedGame = false;
        this.unfinishedGameID = 0;
        this.unfinishedGame = "0";
    }
}
