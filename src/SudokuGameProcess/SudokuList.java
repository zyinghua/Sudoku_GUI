package SudokuGameProcess;

import java.util.ArrayList;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 * 
 * This class stores the entire data of a Sudoku table.
 */
public class SudokuList {
    //Use a 2D array to store the numbers in the sudoku table.
    //sudokuTable comes from the original question table data
    //sudokuTable data can be modified by the user while in game
    private SingleGrid[][] sudokuGameData;
    private SingleGrid[][] sudokuGameAnswer;
    //Sudoku table id will be set to 0 if it's undefined
    private int sudokuTableId;
    private GameLevel level;
    
    //Constructor 1
    public SudokuList(int sudokuTableId, String gameDataInString, String gameAnswerInString)
    {
        this.sudokuGameData = new SingleGrid[9][9];
        this.sudokuGameAnswer = new SingleGrid[9][9];
        this.sudokuTableId = sudokuTableId;
        this.level = GameLevel.UNDEFINED;
        int n = 0;
        
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                sudokuGameData[k][i] = new SingleGrid();
                //Here Character.getNumericValue(char) is being used to convert the specified char in the string to an integer.
                sudokuGameData[k][i].setValue(Character.getNumericValue(gameDataInString.charAt(n))); 
                if(Character.getNumericValue(gameDataInString.charAt(n)) != 0)
                {
                    sudokuGameData[k][i].setModifiable(false);
                }
                else
                {
                    sudokuGameData[k][i].setModifiable(true);
                }
                
                sudokuGameAnswer[k][i] = new SingleGrid();
                sudokuGameAnswer[k][i].setValue(Character.getNumericValue(gameAnswerInString.charAt(n)));
                sudokuGameAnswer[k][i].setModifiable(false);
                n++;
            }
        }
    }
    
    //Constructor 2
    public SudokuList(int sudokuTableId, GameLevel level, String gameDataInString, String gameAnswerInString)
    {
        this.sudokuGameData = new SingleGrid[9][9];
        this.sudokuGameAnswer = new SingleGrid[9][9];
        this.sudokuTableId = sudokuTableId;
        this.level = level;
        int n = 0;
        
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                sudokuGameData[k][i] = new SingleGrid();
                //Here Character.getNumericValue(char) is being used to convert the specified char in the string to an integer.
                sudokuGameData[k][i].setValue(Character.getNumericValue(gameDataInString.charAt(n)));
                if(Character.getNumericValue(gameDataInString.charAt(n)) != 0)
                {
                    sudokuGameData[k][i].setModifiable(false);
                }
                else
                {
                    sudokuGameData[k][i].setModifiable(true);
                }
                
                sudokuGameAnswer[k][i] = new SingleGrid();
                sudokuGameAnswer[k][i].setValue(Character.getNumericValue(gameAnswerInString.charAt(n)));
                sudokuGameAnswer[k][i].setModifiable(false);
                n++;
            }
        }
    }
    
    //Constructor 3, designed for continue button
    public SudokuList(int sudokuTableId, GameLevel level, String originalGameData, String gameDataInString, String gameAnswerInString)
    {
        this.sudokuGameData = new SingleGrid[9][9];
        this.sudokuGameAnswer = new SingleGrid[9][9];
        this.sudokuTableId = sudokuTableId;
        this.level = level;
        int n = 0;
        
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                sudokuGameData[k][i] = new SingleGrid();
                //Here Character.getNumericValue(char) is being used to convert the specified char in the string to an integer.
                sudokuGameData[k][i].setValue(Character.getNumericValue(gameDataInString.charAt(n)));
                if(Character.getNumericValue(originalGameData.charAt(n)) != 0)
                {
                    sudokuGameData[k][i].setModifiable(false);
                }
                else
                {
                    sudokuGameData[k][i].setModifiable(true);
                }
                
                sudokuGameAnswer[k][i] = new SingleGrid();
                sudokuGameAnswer[k][i].setValue(Character.getNumericValue(gameAnswerInString.charAt(n)));
                sudokuGameAnswer[k][i].setModifiable(false);
                n++;
            }
        }
    }
    
    //Constructor 4, uninitilized data
    public SudokuList()
    {
        this.sudokuGameData = new SingleGrid[9][9];
        this.sudokuGameAnswer = new SingleGrid[9][9];
        this.sudokuTableId = 0;
        this.level = GameLevel.UNDEFINED;
        
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                sudokuGameData[k][i] = new SingleGrid();
                //Here Character.getNumericValue(char) is being used to convert the specified char in the string to an integer.
                sudokuGameData[k][i].setValue(0); 
                
                sudokuGameAnswer[k][i] = new SingleGrid();
                sudokuGameAnswer[k][i].setValue(0);
                sudokuGameAnswer[k][i].setModifiable(false);
            }
        }
    }
    
    //Used to return the 2Darray
    public SingleGrid[][] getSudokuGameData()
    {
        return this.sudokuGameData;
    }
    
    public SingleGrid[][] getSudokuGameAnswer()
    {
        return this.sudokuGameAnswer;
    }
    
    //Used to set for sudoku table data
    public void setSudokuGameData(SingleGrid[][] sudokuGameData)
    {
        this.sudokuGameData = sudokuGameData;
    }
    
    //Used to set for the answer of the sudoku table
    public void setSudokuGameAnswer(SingleGrid[][] sudokuGameAnswer)
    {
        this.sudokuGameAnswer = sudokuGameAnswer;
    }
    
    //This method is designed to convert a 2D array, which stores the data of the table to a string
    //Used to better interact with the database
    public String convertTableToString(SingleGrid[][] sudokuGameData)
    {
        String gameDataInString = "";
        
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                gameDataInString+=sudokuGameData[k][i].getValue();
            }
        }
        
        return gameDataInString;
    }
    
    //This method is designed to convert the string, which stores the data of the table to a 2DArray
    public SingleGrid[][] convertStringToTable(String gameDataInString)
    {
        SingleGrid[][] aSudokuTable = new SingleGrid[9][9];
        
        int n = 0;
        for(int k = 0; k < 9; k++)
        {
            for(int i = 0; i < 9; i++)
            {
                aSudokuTable[k][i] = new SingleGrid();
                //Here Character.getNumericValue(char) is being used to convert the specified char in the string to an integer.
                aSudokuTable[k][i].setValue(Character.getNumericValue(gameDataInString.charAt(n))); 
                if(Character.getNumericValue(gameDataInString.charAt(n)) != 0)
                {
                    aSudokuTable[k][i].setModifiable(false);
                }
                else
                {
                    aSudokuTable[k][i].setModifiable(true);
                }
                n++;
            }
        }
        
        return aSudokuTable;
    }
    
    //Clear all the modifiable numbers in the 2Darray
    //It is supposed to be used when the user wants to clear all the entered inputs in the sudoku game    
    public void clear()
    {
        for(int k = 0; k < this.sudokuGameData.length; k++)
        {
            for(int i = 0; i < this.sudokuGameData[k].length; i++)
            {
                if(sudokuGameData[k][i].getIsModifiable() == true)
                {
                    sudokuGameData[k][i].RemoveData();
                }
            }
        }
    }   
}
