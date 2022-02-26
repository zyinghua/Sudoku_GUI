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
 *  This is a unit testing class for UserInfo class
 * @author Yinghua Zhou 17981371
 */
public class UserInfoTest {
    
    public UserInfo aUser;
    
    public UserInfoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.aUser = new UserInfo("Yinghua", "17981371", 666, false, 0, "0");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHasUnfinishedGame method, of class UserInfo.
     */
    @Test
    public void testGetHasUnfinishedGame() {
        assertSame(false, this.aUser.getHasUnfinishedGame());
    }

    /**
     * Test of setHasUnfinishedGame method, of class UserInfo.
     */
    @Test
    public void testSetHasUnfinishedGame() {
        assertSame(false, this.aUser.getHasUnfinishedGame());
        this.aUser.setHasUnfinishedGame(true);
        assertSame(true, this.aUser.getHasUnfinishedGame());
    }

    /**
     * Test of getUnfinishedGameID method, of class UserInfo.
     */
    @Test
    public void testGetUnfinishedGameID() {
        assertSame(0, this.aUser.getUnfinishedGameID());
    }

    /**
     * Test of setUnfinishedGameID method, of class UserInfo.
     */
    @Test
    public void testSetUnfinishedGameID() {
        assertSame(0, this.aUser.getUnfinishedGameID());
        aUser.setUnfinishedGameID(1);
        assertSame(1, this.aUser.getUnfinishedGameID());
    }

    /**
     * Test of getUnfinishedGame method, of class UserInfo.
     */
    @Test
    public void testGetUnfinishedGame() {
        assertSame("0", this.aUser.getUnfinishedGame());
    }

    /**
     * Test of setUnfinishedGame method, of class UserInfo.
     */
    @Test
    public void testSetUnfinishedGame() {
        assertSame("0", this.aUser.getUnfinishedGame());
        aUser.setUnfinishedGame("814070695002160300000005010105930004008620003903400086300209560000000800786003249");
        assertSame("814070695002160300000005010105930004008620003903400086300209560000000800786003249", this.aUser.getUnfinishedGame());
    }

    /**
     * Test of getName method, of class UserInfo.
     */
    @Test
    public void testGetName() {
        assertSame("Yinghua", this.aUser.getName());
    }

    /**
     * Test of setName method, of class UserInfo.
     */
    @Test
    public void testSetName() {
        assertSame("Yinghua", this.aUser.getName());
        aUser.setName("Yinghua Zhou");
        assertSame("Yinghua Zhou", this.aUser.getName());
    }

    /**
     * Test of getPassword method, of class UserInfo.
     */
    @Test
    public void testGetPassword() {
        assertSame("17981371", this.aUser.getPassword());
    }

    /**
     * Test of setPassword method, of class UserInfo.
     */
    @Test
    public void testSetPassword() {
        assertSame("17981371", this.aUser.getPassword());
        aUser.setPassword("rnt1571");
        assertSame("rnt1571", this.aUser.getPassword());
    }

    /**
     * Test of getScore method, of class UserInfo.
     */
    @Test
    public void testGetScore() {
        assertEquals(666, this.aUser.getScore());
    }

    /**
     * Test of setScore method, of class UserInfo.
     */
    @Test
    public void testSetScore() {
        assertEquals(666, this.aUser.getScore());
        aUser.setScore(999);
        assertEquals(999, this.aUser.getScore());
    }  
}
