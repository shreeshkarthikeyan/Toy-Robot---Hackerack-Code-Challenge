/**
 * Description
 * ===========
 * DirectionSetup class will help to add the possible direction for the toy robot
 * to move and also helps to track the previous Direction and the next Direction
 * 
 * Concepts involved
 * =================
 * Doubly Circular LinkedList - Add, Search
 *
 * @author - Shreesh Karthikeyan
 * @version - 03/07/2022
 */
public class DirectionSetup {
    
    /**
     * Inner class
     * 
     */
    class DirectionList 
    {
        String directionName;
        DirectionList nextDirection;
        DirectionList previousDirection;
    };

    //instance variable
    DirectionList head;

    /**
     * Default constructor
     * 
     */
    DirectionSetup(){
        head = null;
    }

    /**
     * Adds the direction(NORTH, EAST, SOUTH, WEST)
     * 
     */
    public void addDirection(String[] directions) {
        for(String direction : directions) {
            DirectionList newDirectionNode = new DirectionList();
            newDirectionNode.directionName = direction;
            newDirectionNode.nextDirection = null;
            newDirectionNode.previousDirection = null;
            if(head == null) { // No elements exists in the LinkedList
              head = newDirectionNode;
              newDirectionNode.nextDirection = head;
              newDirectionNode.previousDirection = head;
            } else {
              DirectionList temp = new DirectionList();
              temp = head;
              while(temp.nextDirection != head) // Loops till the last node
                temp = temp.nextDirection; // temp node holds the last element in the linkedList
              
              temp.nextDirection = newDirectionNode; // Setting the nextNode of the last node to the newly added node
              newDirectionNode.nextDirection = head; // Setting the nextNode of the newly added node to the head node
              newDirectionNode.previousDirection = temp; // Setting the previousNode of the newly added node to the last node
              head.previousDirection = newDirectionNode; // Setting the previousNode of the head node to the newly added node
            }
        }
    }

    /**
     * Searches the direction of the toy robot and
     * helps to track the LEFT and RIGHT side of the robot facing direction
     * 
     */
    public String turnDirection(String searchDirection, String turnDirection) {
        String result = "";
        DirectionList temp = new DirectionList();
        temp = this.head;
    
        while(true) {
            if(temp.directionName.equals(searchDirection)) {
                break;
            }
            temp = temp.nextDirection;
            if(temp == this.head) {
                break;
            }
        }
        
        if(turnDirection.equals("left")){
            result = temp.previousDirection.directionName;
        }
        else if(turnDirection.equals("right")) {
            result = temp.nextDirection.directionName;
        }
        
        return result;
    }
}