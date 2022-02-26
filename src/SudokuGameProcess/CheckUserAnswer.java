package SudokuGameProcess;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID 26
 */

//This class is used to check if the number entered by the user is correct
public class CheckUserAnswer {
    
    //The status of (isIncorrect) in the SingleSpace Class will change only if the user excutes this method,
    //and the number entered by the user in the grid is different from the answer.
    public void checkAnswer(SudokuList aSudokuGame)
    {        
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                if(aSudokuGame.getSudokuGameData()[k][i].getValue() != 0)
                {
                    //Check if the user entered numbers are same as the correct answer
                    if(aSudokuGame.getSudokuGameData()[k][i].getValue() != aSudokuGame.getSudokuGameAnswer()[k][i].getValue())
                    {
                        aSudokuGame.getSudokuGameData()[k][i].setIsIncorrect(true);
                    }
                } 
            }
        }
    }
}
