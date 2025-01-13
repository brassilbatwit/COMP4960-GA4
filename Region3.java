import java.util.Scanner;
//Author Tyler Cornell
public class Region3 {

    public static void Room3() {
        Scanner scanner = new Scanner(System.in);
        // Welcome Prompt for Entering room Three
        System.out.println("Welcome to Room Three of the Garden!");
        
        // Prompt player with choices
        System.out.println("Now that you have entered the room what would you like to do");
        System.out.println("1. Acquire fresh tomatoes.");
        System.out.println("2. Search nearby shed.");
        System.out.println("3. Explore room 2");
        System.out.println("4. Explore room 4");
        System.out.println("Enter the number of your choice (1/2/3/4): "); 
        
        int FirstChoice = scanner.nextInt();
        
        String item = "";
        //Based on the choice of the user display further options
        switch (FirstChoice) {
            case 1:
                System.out.println("How many tomatoes would you like to pick?");
                System.out.println("1. 3 tomatoes");
                System.out.println("2. 6 tomatoes");
                System.out.println("Enter your choice (1/2): ");
                int choiceTomatoes = scanner.nextInt();
                item = (choiceTomatoes == 1) ? "3 tomatoes" : "6 tomatoes";
                break;
            case 2:
                System.out.println("What item would you like to grab from the shed?");
                System.out.println("1. Bowl");
                System.out.println("2. Bucker of ranch");
                System.out.println("Enter your choice (1/2): ");
                int choiceShed = scanner.nextInt();
                item = (choiceShed == 1) ? "Bowl" : "Bucket of ranch";
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid input.Please select an option 1-4");
                break;
        }
        
        // Show player the item they have received
        if (!item.isEmpty()) {
            System.out.println("Congratulations! You have recieved: " + item);
        }
    }
}
