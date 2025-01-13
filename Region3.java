import java.util.Scanner;
//Author Tyler Cornell
public class Region3 {

    public static void Room3() {
    Scanner scanner = new Scanner(System.in);
    String item = ""; // To store the item player picks

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
                item = (choiceTomatoes == 1) ? "3 tomatoes" : "6 tomatoes";
                System.out.println("Congratulations! You have received: " + item);
                break;

            case 2:
                System.out.println("What item would you like to grab from the shed?");
                System.out.println("1. Bowl");
                System.out.println("2. Bucket of ranch");
                System.out.println("Enter your choice (1/2): ");
                int choiceShed = scanner.nextInt();
                item = (choiceShed == 1) ? "Bowl" : "Bucket of ranch";
                System.out.println("Congratulations! You have received: " + item);
                break;

            case 3:
                // Call Region 2 method
                Region2();
                continueInRoom = false; // Exit loop after leaving Room 3
                break;

            case 4:
                // Call Region 4 method
                Region4();
                continueInRoom = false; // Exit loop after leaving Room 3
                break;

            default:
                System.out.println("Invalid input. Please select an option 1-4");
                break;
            }
        }
    }
}
