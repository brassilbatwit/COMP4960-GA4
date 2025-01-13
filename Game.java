
import java.io.IOException;
import java.io.PrintStream;
import java.util.EnumSet;
import java.util.Scanner;

public class Game {
    /**
     * Text input stream.
     */
    public static final Scanner input = new Scanner(System.in);

    /**
     * Text output stream.
     */
    public static final PrintStream output = System.out;

    private static final AssetManager assetManager = new AssetManager();

    /**
     * Provides access to game assets.
     * @return {@code AssetManager} for this game.
     */
    public static AssetManager getAssets() {
        return assetManager;
    }

    /**
     * Prompts the user to choose a cardinal direction from a list of options.
     * @param options Set of available directions
     * @param input Text input stream
     * @param output Text output stream
     * @return One of the values in {@code options}
     */
    public static CardinalDirection chooseDirection(EnumSet<CardinalDirection> options) {
        String s = assetManager.getDialogue("directionPrompt");
        output.println(s);
        for (CardinalDirection option : options) {
            output.printf("  %s) %s%n", option.toChar(), option.toString());
        }
        s = assetManager.getDialogue("choose");
        output.printf("%s ", s);

        CardinalDirection choice = CardinalDirection.fromChar(input.next().charAt(0));

        s = assetManager.getDialogue("directionError");
        while (!options.contains(choice)) {
            output.printf("%s ", s);
            choice = CardinalDirection.fromChar(input.next().charAt(0));
        }

        return choice;
    }

    /**
     * Clears the standard output for this process.
     */
    public static void clearOutput() {
        try {
            ProcessBuilder process = isWindows()
                ? new ProcessBuilder("cmd", "/c", "cls")
                : new ProcessBuilder("clear");
            process.inheritIO().start().waitFor();
        }
        catch (IOException | InterruptedException ex) {}
    }

    /**
     * Checks if this process is running on a Windows operating system.
     * @return True if running on Windows, otherwise false.
     */
    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}