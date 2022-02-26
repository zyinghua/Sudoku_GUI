/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SudokuGameProcess;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is a unit testing class for SudokuList class
 * @author Yinghua Zhou 17981371
 */
public class SudokuListTest {
    public SudokuList aSudokuTable;
    
    public SudokuListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.aSudokuTable = new SudokuList(1, GameLevel.EASY, "814070695002160300000005010105930004008620003903400086300209560000000800786003249", "814372695592164378637895412165938724478621953923457186341289567259746831786513249");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSudokuGameData method, of class SudokuList.
     */
    @Test
    public void testGetSudokuGameData() {
        assertEquals("814070695002160300000005010105930004008620003903400086300209560000000800786003249", this.aSudokuTable.convertTableToString(this.aSudokuTable.getSudokuGameData()));
    }

    /**
     * Test of getSudokuGameAnswer method, of class SudokuList.
     */
    @Test
    public void testGetSudokuGameAnswer() {
        assertEquals("814372695592164378637895412165938724478621953923457186341289567259746831786513249", this.aSudokuTable.convertTableToString(this.aSudokuTable.getSudokuGameAnswer()));
        
    }

    /**
     * Test of setSudokuGameData method, of class SudokuList.
     */
    @Test
    public void testSetSudokuGameData() {
        assertEquals("814070695002160300000005010105930004008620003903400086300209560000000800786003249", this.aSudokuTable.convertTableToString(this.aSudokuTable.getSudokuGameData()));
        this.aSudokuTable.setSudokuGameData(this.aSudokuTable.convertStringToTable("659010280100050030200800010000135070800900002003078640302009004000001800008760000"));
        assertEquals("659010280100050030200800010000135070800900002003078640302009004000001800008760000", this.aSudokuTable.convertTableToString(this.aSudokuTable.getSudokuGameData()));
    }

    /**
     * Test of setSudokuGameAnswer method, of class SudokuList.
     */
    @Test
    public void testSetSudokuGameAnswer() {
        assertEquals("814372695592164378637895412165938724478621953923457186341289567259746831786513249", this.aSudokuTable.convertTableToString(this.aSudokuTable.getSudokuGameAnswer()));
        this.aSudokuTable.setSudokuGameAnswer(this.aSudokuTable.convertStringToTable("659314287187652439234897516426135978871946352593278641312589764765421893948763125"));
        assertEquals("659314287187652439234897516426135978871946352593278641312589764765421893948763125", this.aSudokuTable.convertTableToString(this.aSudokuTable.getSudokuGameAnswer()));
    }
    
}
