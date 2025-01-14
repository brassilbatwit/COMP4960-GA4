
import java.util.HashMap;
import java.util.Random;
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
                //unsure if this woeks currently, need to test
                game.getState().getItems().put("key", 1);
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
                        diceGame(game);
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
        Scanner scan = new Scanner(System.in);

        System.out.println("You are now faced with four options");
        System.out.println("1. Return to starting room");
        System.out.println("2. Enter the door on your left connected to the left room");
        System.out.println("3. Enter the door on your right connected to the right room");
        System.out.println("4. Explore this room further");
        System.out.println("Enter the number of your choice (1/2/3/4): ");

        int inputChoice = scan.nextInt();

        switch (inputChoice) {
            case 1:
            //enter the initial room
            initialRoom(game);
            break;
            case 2:
            //enter the left room
            leftRoom(game);
            break;
            case 3:
            //enter the right room
            rightRoom(game);
            break;
            case 4:
            //explore room and find a hidden door
            System.out.println("Upon further exploration of the room you have found a hidden door!");
            if (!game.getState().getItems().containsKey("key")) {
                System.out.println("You need a key to enter the hidden door.");
                middleRoom(game);
                return;
            }
            System.out.println("Enter the hidden room with the key you found?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Enter the number of your choice (1/2): ");
            int hiddenRoomChoice = scan.nextInt();
            switch (inputChoice) {
                case 1:
                //enter the hidden room
                hiddenRoom(game);
                break;
                case 2:
                //return to the middle room
                middleRoom(game);
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

    @Override
    public int enter(Game game) {
        HashMap<String, Integer> items = game.getState().getItems();
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
    private static void diceGame(Game game) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("You have chosen to play a game of dice against the wanderer.");
        System.out.println("Rolling dice...");

        int playerRoll = rand.nextInt(6) + 1;
        int wandererRoll = rand.nextInt(6) + 1;

        System.out.println("You rolled a " + playerRoll);
        System.out.println("The wanderer rolled a " + wandererRoll);

        if (playerRoll > wandererRoll) {
            System.out.println("Congratulations! You won the game and received (new ingredient).");
            game.getState().getItems().put("Carrots", game.getState().getItems().getOrDefault("Carrots", 0) + 1);
            //unsure if this will work currently, need to test
            // Add logic to give the player a new ingredient
        } else if (playerRoll < wandererRoll) {
            System.out.println("Sorry, you lost the game. Better luck next time.");
        } else {
            System.out.println("It's a tie! No one wins.");
        }
        scan.close();
    }
    

    // method for hidden room logic
    private static void hiddenRoom(Game game) {
        System.out.println("You have entered a hidden room!");
        System.out.println("You have found a new ingredient");
        //items.put("Carrots", items.getOrDefault("Carrots", 0)); //not sure how to change this
        System.out.println("1. Return to the middle room");
        System.out.println("Enter the number of your choice (1): ");
        Scanner scan = new Scanner(System.in);
        int inputChoice = scan.nextInt();
        switch (inputChoice) {
            case 1:
                middleRoom(game);
                break;
            default:
                System.out.print("Invalid input. Please select an option 1");
                break;
        }  
        // add logic for hidden room here
    }

}
