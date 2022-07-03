import java.util.*;
/**
 * Description
 * ===========
 * ToyRobotApplication class includes main method and acts like a user interface class. It provides menu type options for the
 * user to proceed.
 *
 *
 * @author - Shreesh Karthikeyan
 * @version - 03/07/2022
 */

public class ToyRobotApplication
{
    /**
     * This main method starts the execution
     * 
     */
    public static void main(String []args) {
         Scanner sc = new Scanner(System.in);
      
         String command;
         System.out.println("Toy Robot Code Challenge");
         System.out.println("Press 'exit' to stop the execution");
         ToyRobot toy = new ToyRobot();
         do {
               System.out.println("Please enter a new command: ");  
               command = sc.nextLine(); // A string variable used to get input from user
                                      // i.e the command for the Toy Robot.
               command = command.toLowerCase();
               if(command.contains("place")) {
                   if(validPlaceCommand(command)){
                       toy.placeCommand(command);
                   }
                   else {
                       System.out.println("Please enter a valid 'Place' command which should have three Arguments -> X-Axis Location," +
                                            "Y-Axis Location, Facing Direction");
                   }
               }
               else if(command.equals("move"))
                   toy.moveCommand();
               else if(command.equals("left") || command.equals("right"))
                   toy.turnCommand(command);
               else if(command.equals("report"))
                   toy.reportCommand();
               else if(command.equals("exit"))
                   System.exit(0);    
               else
                    System.out.println("Please enter a valid option");
         } while(!command.equals("exit"));
    }
    
    public static boolean validPlaceCommand(String command) {
        boolean result = false;
        String[] placeArgs = (command.split(" ")[1]).split(",");
        if(placeArgs.length == 3) {
            try {
                int xAxis = Integer.parseInt(placeArgs[0]);
                int yAxis = Integer.parseInt(placeArgs[1]);
                if(placeArgs[2].equals("north") || placeArgs[2].equals("east") ||
                    placeArgs[2].equals("south") || placeArgs[2].equals("west")) {
                        result = true;
                    }
                    else { result = false; }
            }
            catch(Exception e){ // Catch block for any exception in the above try block
                result = false;
            }
        }
        return result;
    }
}
