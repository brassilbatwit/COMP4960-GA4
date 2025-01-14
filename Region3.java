
import java.util.HashMap;
import java.util.Scanner;
//Author Tyler Cornell

public class Region3 implements IRegion {

    @Override
    public int enter(Game game) {
        HashMap<String, Integer> items = game.getState().getItems();
        Scanner scanner = game.getInput();
        //HashMap<String, Integer> items = new HashMap<>(); // Dictionary to store items and their quantities

        // Welcome Prompt for Entering room Three
        System.out.println("Welcome to Room Three of the Garden!");

        // Loop to allow user to make multiple choices
        boolean continueInRoom = true; // Control loop for the player's actions in Room 3

        while (continueInRoom) {
            // Prompt player with choices
            System.out.println("Now that you have entered the room, what would you like to do?");
            System.out.println("1. Acquire fresh tomatoes.");
            System.out.println("2. Search nearby shed.");
            System.out.println("3. Explore room 2");
            System.out.println("4. Explore room 4");
            System.out.println("Enter the number of your choice (1/2/3/4): ");

            int FirstChoice = scanner.nextInt();

            switch (FirstChoice) {
                case 1:
                    System.out.println("How many tomatoes would you like to pick?");
                    System.out.println("1. 3 tomatoes");
                    System.out.println("2. 6 tomatoes");
                    System.out.println("Enter your choice (1/2): ");
                    int choiceTomatoes = scanner.nextInt();
                    if (choiceTomatoes == 1) {
                        items.put("Tomatoes", items.getOrDefault("Tomatoes", 0) + 3);  // Add 3 tomatoes if already exists
                        System.out.println("Congratulations! You have received: 3 tomatoes");
                    } else if (choiceTomatoes == 2) {
                        items.put("Tomatoes", items.getOrDefault("Tomatoes", 0) + 6);  // Add 6 tomatoes if already exists
                        System.out.println("Congratulations! You have received: 6 tomatoes");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 2:
                    System.out.println("What item would you like to grab from the shed?");
                    System.out.println("1. Bowl");
                    System.out.println("2. Bucket of ranch");
                    System.out.println("Enter your choice (1/2): ");
                    int choiceShed = scanner.nextInt();
                    if (choiceShed == 1) {
                        items.put("Bowl", items.getOrDefault("Bowl", 0) + 1);  // Add 1 bowl if already exists
                        System.out.println("Congratulations! You have received: 1 Bowl");
                    } else if (choiceShed == 2) {
                        items.put("Bucket of ranch", items.getOrDefault("Bucket of ranch", 0) + 1);  // Add 1 bucket of ranch
                        System.out.println("Congratulations! You have received: 1 Bucket of ranch");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 3:
                    return 2;
                case 4:
                    return 4;
                default:
                    System.out.println("Invalid input. Please select an option 1-4");
                    break;
            }
        }
        return -1;
    }
}
