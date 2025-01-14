
import java.util.Scanner;

//Coles' Region
public class Region4 implements IRegion {
    //creating region initially without any theme, will change later

    private static void leftRoom(Game game) {
        Scanner scan = new Scanner(System.in);

        System.out.println("You have entered the left room");
        System.out.println("You are now faced with three options");
        System.out.println("1. Return to starting room");
        System.out.println("2. Enter the door on your left connected to the middle room");
        System.out.println("3. Explore this room further");
        System.out.println("Enter the number of your choice (1/2/3): ");

        int inputChoice = scan.nextInt();

        switch (inputChoice) {
            case 1:
                //enter the initial room
                initialRoom(game);
                break;
            case 2:
                //enter the middle room
                middleRoom(game);
                break;
            case 3:
                //explore room and find a key needed for treasure room
                //maybe add ASCII art for some sort of congratulations for finding a key
                System.out.println("Upon further exploration of the room you have found a key!");
                //add some more logic to give the two choices again to the player about how to move
                break;
            default:
                //check for invalid input
                System.out.print("Invalid input. Please select an option 1-4");
                break;
        }
    }

    public static void rightRoom(Game game) {

        Scanner scan = new Scanner(System.in);

        System.out.println("You have entered the right room");
        System.out.println("You are now faced with three options");
        System.out.println("1. Return to starting room");
        System.out.println("2. Enter the door on your right connected to the middle room");
        System.out.println("3. Explore this room further");
        System.out.println("Enter the number of your choice (1/2/3): ");

        int inputChoice = scan.nextInt();

        switch (inputChoice) {
            case 1:
                //enter the initial room
                initialRoom(game);
                break;
            case 2:
                //enter the middle room
                middleRoom(game);
                break;
            case 3:
                //explore room and find a key needed for treasure room
                //maybe add ASCII art for some sort of congratulations for finding a key
                System.out.println("You find a wanderer in the corner of the room");
                System.out.println("Speak to the peddlar?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println("Enter the number of your choice (1/2): ");

                switch (inputChoice) {
                    case 1:
                        //you speak with the wanderer
                        System.out.println("Would you like to play a game of dice for an item?");
                        diceGame();
                        break;
                    case 2:
                        //you return to the room and don't speak with the wanderer
                        rightRoom(game);
                        break;
                }

                //add some more logic to give the two choices again to the player about how to move
                break;
            default:
                //check for invalid input
                System.out.print("Invalid input. Please select an option 1-4");
                break;
        }
    }

    public static void middleRoom(Game game) {
        System.out.println("You have entered the middle room");

    }

    @Override
    public int enter(Game game) {
        initialRoom(game);
        return 1;
    }

    private static void initialRoom(Game game) {
        Scanner scan = game.getInput();

        //giving user choice for initial room selection
        System.out.println("You have entered the 4th Region");
        System.out.println("You are now faced with 3 doors, middle, left, and right");
        System.out.println("1. Enter the left room");
        System.out.println("2. Enter the right room");
        System.out.println("3. Enter the middle room");
        System.out.println("4. Return to the beginning");
        System.out.println("Enter the number of your choice (1/2/3/4): ");

        int inputChoice = scan.nextInt();

        //currently using switch cases to traverse among rooms
        switch (inputChoice) {
            case 1:
                //enter the left room
                leftRoom(game);
                break;
            case 2:
                //enter the right room
                rightRoom(game);
                break;
            case 3:
                //enter the middle room
                middleRoom(game);
                break;
            case 4:
                //send to beginning, need to create logic for this
                System.out.print("Returning to beginning");
                break;
            default:
                //check for invalid input
                System.out.print("Invalid input. Please select an option 1-4");
                break;
        }
    }

    //need to add logic for a dice game where whoever rolls higher wins, in which the winner gets the key needed for the treasure room
    private static void diceGame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
