package SudokuGameProcess;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID 26
 * This class is used to identify the game level
 */
public enum GameLevel {
    UNDEFINED(0), EASY(1),MEDIUM(2),HARD(3);
    
    private int levelIndicator;
    
    private GameLevel(int levelIndicator)
    {
        this.levelIndicator = levelIndicator;
    }
    
    public int getLevelIndicator()
    {
        return this.levelIndicator;
    }
}
