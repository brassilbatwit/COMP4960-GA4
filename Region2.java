import java.util.HashMap ;
import java.util.Scanner ;

/**
 * 
 * 
 * @author Dalton JS Crawford
 * @version 1.0.0 2025-01-13 Initial implementation salad
 *
 */
public class Region2
    {

    /**
     * Room2 runs the user through room two
     * items records the items the user collects along the way. 
     * 
     */
    public static void Room2(HashMap<String, Integer> items)
        {
        Scanner input = new Scanner( System.in ) ;
        

        // Welcome Prompt for Entering room Three
        System.out.println( "Welcome to Room Two of the Garden!" ) ;
        System.out.println("It appears you have entered the lettuce room.");
        System.out.println("The earthy aroma of loam mingles with the crisp air,");
        System.out.println("filling you with vitality. You are ready to build your salad.");

        // Loop to allow user to make multiple choices
        boolean continueInRoom = true ; // Control loop for the player's actions in
                                        

        while ( continueInRoom )
            {
            // Prompt player with choices
            System.out.println( "Now that you have entered the room, what would you like to do?" ) ;
            System.out.println( "1. Aquire the lettuce." ) ;
            System.out.println( "2. Search nearby shed." ) ;
            System.out.println( "3. Explore room 1" ) ;
            System.out.println( "4. Explore room 3" ) ;
            System.out.println( "Enter the number of your choice (1/2/3/4): " ) ;

            int FirstChoice = input.nextInt() ;

            switch ( FirstChoice )
                {
                case 1:
                    System.out.println( "As you inspect the lettuce, you notice robust Romaine hearts growing tall and proud as well as joyful Arugula, sprouting amidst the verdant growth. " ) ;
                    System.out.println( "1. robust Romaine" ) ;
                    System.out.println( "2. joyful arugula" ) ;
                    System.out.println( "Enter your choice (1/2): " ) ;
                    int choiceTomatoes = input.nextInt() ;
                    if ( choiceTomatoes == 1 )
                        {
                        items.put( "Romaine", items.getOrDefault( "Romaine", 0 ) + 1 ) ; 
                        System.out.println( "Congratulations! You have received: robust Romaine" ) ;

                        }
                    else if ( choiceTomatoes == 2 )
                        {
                        items.put( "Arugla", items.getOrDefault( "Arugula", 0 ) + 1 ) ;  
                        System.out.println( "Congratulations! You have received: joyful Arugula" ) ;

                        }
                    else
                        {
                        System.out.println( "You have chosen no lettuce. We wont tell anyone, but your mother may scold you." ) ;

                        }
                    break ;

                case 2:
                    System.out.println( "What item would you like to grab from the shed?" ) ;
                    System.out.println( "1. Cutting Board & Knife" ) ;
                    System.out.println( "2. Olives" ) ;
                    System.out.println( "Enter your choice (1/2): " ) ;
                    int choiceShed = input.nextInt() ;
                    if ( choiceShed == 1 )
                        {
                        items.put( "Cutting Board & Knife", items.getOrDefault( "Knife", 0 ) + 1 ) ;  
                        System.out.println( "Congratulations! You have received: Cutting Board & Knife" ) ;

                        }
                    else if ( choiceShed == 2 )
                        {
                        items.put( "Olives",
                                   items.getOrDefault( "Olives", 0 ) + 1 ) ;  
                        System.out.println( "Congratulations! You have received: Olives" ) ;

                        }
                    else
                        {
                        System.out.println( "Nothing in the shed looks all that intresting. You chose nothing." ) ;

                        }
                    break ;

                case 3:
                    // Call Region 1 method
                    //Region1() ;
                    continueInRoom = false ; // Exit loop after leaving Room 3
                    break ;

                case 4:
                    // Call Region 3 method
                    Region3.Room3();
                    continueInRoom = false ; // Exit loop after leaving Room 3
                    break ;

                default:
                    System.out.println( "Invalid input. Please select an option 1-4" ) ;
                    break ;

                }

            }

        }

    }
