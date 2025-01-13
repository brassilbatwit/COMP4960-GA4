
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.Scanner;

public class Game {
    private static final String SETUP_PATH = "data/setup.txt";

    private final AssetManager assetManager = new AssetManager();
    private final Scanner input;
    private final PrintStream output;
    private final GameState state;
    private final Path root;

    /**
     * Game constructor.
     * @param path Path of game's root directory.
     * @param inputStream Stream to use when reading input.
     * @param outputStream Stream to use when printing output.
     */
    public Game(Path path, InputStream inputStream, PrintStream outputStream) {
        input = new Scanner(inputStream);
        output = outputStream;
        state = new GameState();
        root = path;
    }

    /**
     * Checks if this process is running on a Windows operating system.
     * @return True if running on Windows, otherwise false.
     */
    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    /**
     * Prompts the user to choose a cardinal direction from a list of options.
     * @param options Set of available directions
     * @param input Text input stream
     * @param output Text output stream
     * @return One of the values in {@code options}
     */
    public CardinalDirection chooseDirection(EnumSet<CardinalDirection> options) {
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
    public void clearOutput() {
        try {
            ProcessBuilder process = isWindows()
                ? new ProcessBuilder("cmd", "/c", "cls")
                : new ProcessBuilder("clear");
            process.inheritIO().start().waitFor();
        }
        catch (IOException | InterruptedException ex) {}
    }

    /**
     * Provides access to game assets.
     * @return {@code AssetManager} for this game.
     */
    public AssetManager getAssets() {
        return assetManager;
    }

    /**
     * Provides access to the game's input stream.
     * @return {@code Scanner} for this game.
     */
    public Scanner getInput() {
        return input;
    }

    /**
     * Provides access to the game's output stream.
     * @return {@code PrintStream} for this game.
     */
    public PrintStream getOutput() {
        return output;
    }

    /**
     * Provides access to game state.
     * @return {@code GameState} for this game.
     */
    public GameState getState() {
        return state;
    }


    /**
     * Starts up the game and its dependencies.
     * @throws IOException if {@code path} is missing one of the dependencies.
     */
    public void start() throws IOException {
        assetManager.load(root);
        loadSetup();
    }

    /**
     * Shuts down the game.
     * @throws IOException if {@code path} is missing one of the dependencies.
     */
    public void stop() throws IOException {
        saveSetup();
    }

    private void loadSetup() throws IOException {
        File setupFile = root.resolve(SETUP_PATH).toFile();
        // Save setup file with default values if one doesn't exist.
        if (!setupFile.exists()) {
            saveSetup();
        }
        Scanner setup = new Scanner(root.resolve(SETUP_PATH).toFile());
        while (setup.hasNext()) {
            String line = setup.next();
            int index = line.indexOf('=');
            try {
                String fieldName = line.substring(0, index).trim();
                String fieldValue = line.substring(index + 1).trim();
                if (fieldName.equalsIgnoreCase("completed")) {
                    state.completed = Integer.parseInt(fieldValue) != 0;
                }
            }
            catch (Exception ex) {} // Ignore lines with invalid formatting
        }
    }

    private void saveSetup() throws IOException {
        PrintWriter setup = new PrintWriter(root.resolve(SETUP_PATH).toFile());
        setup.printf("Completed=%d%n", (state.completed ? 1 : 0));
        setup.close();
    }
}