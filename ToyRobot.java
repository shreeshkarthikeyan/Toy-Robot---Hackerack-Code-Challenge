import java.util.*;
/**
 * Description
 * ===========
 * ToyRobot class holds the information of the position and the direction
 * of the Toy Robot in the 5*5 dimension
 * 
 * @author - Shreesh Karthikeyan
 * @version - 03/07/2022
 */
public class ToyRobot
{
    // instance variables
    private int xAxis;
    private int yAxis;
    private String robotFaceDirection;
    private String[][] toyRobotTable;
    private final int tableDimension = 5;  
    private DirectionSetup directionSetup;
    
    /**
     * Default constructor
     * 
     */
    public ToyRobot() {
        
        robotFaceDirection = ""; // Initializing empty string
        toyRobotTable = new String[tableDimension][tableDimension]; //Initializing table dimensions for the visual representation
        directionSetup = new DirectionSetup();
        String[] directionArray = {"north","east","south","west"}; // Direction list in clockwise direction
        directionSetup.addDirection(directionArray); // Adding the direction list into Doubly Circular LinkedList
        for (int i = 0; i < toyRobotTable.length; i++) { // Initialing empty table
            for (int j = 0; j < toyRobotTable[i].length; j++) {
               toyRobotTable[i][j] = "-";
            }
        }
    }
    
    /**
     * This method is used to place the Toy Robot in the table and
     * set xAxis, yAxis and its facing direction
     *
     * @param  placeCommand - Place command for Toy Robot
     * @return    the sum of x and y
     */
    public void placeCommand(String placeCommand)
    {
        //Validation to remove any existing xAxis and yAxis value
        if(!robotFaceDirection.equals("")){
            toyRobotTable[tableDimension - 1 - yAxis][xAxis] = "-";
        }
        String coordinates = placeCommand.split(" ")[1];
        xAxis = Integer.parseInt(coordinates.split(",")[0]);
        yAxis = Integer.parseInt(coordinates.split(",")[1]);
        robotFaceDirection = coordinates.split(",")[2];
        
        toyRobotTable[tableDimension - 1 - yAxis][xAxis] = "X";
    }
    
    /**
     * This method is used to move the Toy Robot in the table and
     * update the xAxis, yAxis and its facing direction
     *
     */
    public void moveCommand()
    {
        try {
            switch(robotFaceDirection){
                case "north":
                {
                    if(validationOnBoundaryCheck("yAxis", tableDimension)){
                        toyRobotTable[tableDimension - 1 - yAxis][xAxis] = "-";
                        yAxis += 1;
                        toyRobotTable[tableDimension - 1 - yAxis][xAxis] = "X";
                    }
                    else {
                        System.out.println("Robot about to fall from the table");
                    }
                    break;
                }
                case "south":
                {
                    if(validationOnBoundaryCheck("yAxis", 0)){
                        toyRobotTable[tableDimension - 1 - yAxis][xAxis] = "-";
                        yAxis -= 1;
                        toyRobotTable[tableDimension - 1 - yAxis][xAxis] = "X";
                    }
                    else {
                        System.out.println("Robot about to fall from the table");
                    }
                    break;
                }
                case "east" :
                {
                    if(validationOnBoundaryCheck("xAxis", tableDimension)){
                        toyRobotTable[tableDimension - 1 - yAxis][xAxis] = "-";
                        xAxis += 1;
                        toyRobotTable[tableDimension - 1 - yAxis][xAxis] = "X";
                    }
                    else {
                        System.out.println("Robot about to fall from the table");
                    }
                    break;
                }
                case "west" :
                {
                    if(validationOnBoundaryCheck("xAxis", 0)){
                        toyRobotTable[tableDimension - 1 - yAxis][xAxis] = "-";
                        xAxis -= 1;
                        toyRobotTable[tableDimension - 1 - yAxis][xAxis] = "X";
                    }
                    else {
                        System.out.println("Robot about to fall from the table");
                    }
                    break;
                }
            }
        }
        catch(NullPointerException ex){
            System.out.println("Please place the Robot");
        }
    }
    
    /**
     * This method is used to validate whether the toy robot is about
     * to fall from the table or good to move.
     *
     * @param axis - String - Whether x-Axis or y-Axis 
     * @param number - int - validation number
     * @return - boolean
     */
    public boolean validationOnBoundaryCheck(String axis, int number){
        if(axis.equals("yAxis")) {
            if(yAxis == number){
                return false;
            }
        }
        else {
            if(xAxis == number){
                return false;
            }
        }
        return true;
    }
    
    /**
     * This method is used to turn the toy robot either LEFT or RIGHT
     *
     * @param axis - String - Turn Command - Either LEFT or RIGHT
     * @return - String - Updates the robot facing direction
     */
    public String turnCommand(String turnCommand) {
        
        robotFaceDirection = directionSetup.turnDirection(robotFaceDirection, turnCommand);
        return robotFaceDirection;
    }
    
    /**
     * This method is used to report the toy robot with its co-ordinates
     *
     * @return - String - Updates the user about the toy robot's X-Axis, Y-Axis and its facing direction
     */
    public String reportCommand(){
        
        String result = xAxis +", " + yAxis +", " + robotFaceDirection.toUpperCase();
        System.out.println(result);
        System.out.println();
        System.out.println("Table Representation");
        for (int i = 0; i < toyRobotTable.length; i++) {
                for (int j = 0; j < toyRobotTable[i].length; j++) {
                   System.out.print(toyRobotTable[i][j]+ " ");
                }
                System.out.println();
        }
        return result;
    }
}
