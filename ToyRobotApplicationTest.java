

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ToyRobotApplicationTest.
 *
 * @author  (Shreesh Karthikeyan)
 * @version (03/07/2022)
 */
public class ToyRobotApplicationTest
{
    ToyRobot toyRobot;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        toyRobot = new ToyRobot();
    }

    /** 
     * Test case 1
     * 
     * PLACE 0,0,NORTH
     * MOVE
     * REPORT
     * Output: 0,1,NORTH 
     */
    @Test
    public void testCase1()
    {
        toyRobot.placeCommand("place 0,0,north");
        toyRobot.moveCommand();
        assertEquals("0, 1, NORTH", toyRobot.reportCommand());
    }
    
    /** 
     * Test case 2
     * 
     * PLACE 0,0,NORTH
     * LEFT
     * REPORT
     * Output: 0,0,WEST 
     */
    @Test
    public void testCase2()
    {
        toyRobot.placeCommand("place 0,0,north");
        toyRobot.turnCommand("left");
        assertEquals("0, 0, WEST", toyRobot.reportCommand());
    }
    
    /** 
     * Test case 3
     * 
     * PLACE 1,2,EAST
     * MOVE
     * MOVE
     * LEFT
     * MOVE
     * REPORT
     * Output: 3,3,NORTH 
     * 
     */
    @Test
    public void testCase3()
    {
        toyRobot.placeCommand("place 1,2,east");
        toyRobot.moveCommand();
        toyRobot.moveCommand();
        toyRobot.turnCommand("left");
        toyRobot.moveCommand();
        assertEquals("3, 3, NORTH", toyRobot.reportCommand());
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
