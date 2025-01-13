
import java.io.PrintStream;
import java.util.EnumSet;
import java.util.Scanner;

public class Game {
    private static final AssetManager assetManager = new AssetManager();

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
    public static CardinalDirection chooseDirection(EnumSet<CardinalDirection> options, Scanner input, PrintStream output) {
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
}