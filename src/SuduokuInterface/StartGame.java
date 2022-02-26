/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuduokuInterface;

/**
 *
 * @author Yinghua Zhou 17981371
 * Group ID: 26
 */

//This class is designed to start the program
public class StartGame {
    public static void main(String[] args) {
        SudokuModel model = new SudokuModel();
        SudokuView view = new SudokuView("Sudoku Game",model);
        SudokuController controller = new SudokuController(view, model);
        model.addObserver(view); // Build connection between the view and the model.
    }
}
