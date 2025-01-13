
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Loads and provides access to assets.
 */
public class AssetManager {
    private static final String ASCII_ART_PATH = "assets/ascii-art";
    private static final String DIALOGUE_PATH = "assets/dialogue";

    private final HashMap<String, String> asciiArt = new HashMap<>();
    private final HashMap<String, String> dialogue = new HashMap<>();
    
    /**
     * Gets ASCII art with the specified key.
     * @param key Unique identifier.
     */
    public String getAsciiArt(String key) {
        return asciiArt.getOrDefault(key, "");
    }

    /**
     * Gets a line of dialogue with the specified key.
     * @param key Unique identifier.
     */
    public String getDialogue(String key) {
        return dialogue.getOrDefault(key, "");
    }

    /**
     * Loads all assets from the specified directory.
     * @param path Path to directory containing assets folder.
     * @throws IOException if {@code path} does not contain {@code assets/ascii-art} and {@code assets/dialogue}.
     */
    public void load(Path path) throws IOException {
        loadAsciiArt(path);
        loadDialogue(path);
    }

    private void loadAsciiArt(Path path) throws IOException {
        Files.walk(path.resolve(Paths.get(ASCII_ART_PATH))).forEach((Path p) -> {
            try {
                if( Files.isDirectory(p) ) {
                    return;
                }
                String key = removeFileExtension(p.getFileName().toString());
                String value = Files.readString(p);
                asciiArt.put(key, value);
            }
            catch (IOException ex) {}
        });
    }
    
    private void loadDialogue(Path path) throws IOException {
        Files.walk(path.resolve(Paths.get(DIALOGUE_PATH))).forEach((Path p) -> {
            if( Files.isDirectory(p) ) {
                return;
            }
            try {
                for (String line : Files.readAllLines(p)) {
                    int index = line.indexOf('|');
                    String key = line.substring(0, index).trim();
                    String value = line.substring(index + 1).trim();
                    dialogue.put(key, value);
                }
            }
            catch (IOException ex) {}
        });
    }

    private static String removeFileExtension(String filename) {
        return filename.replaceFirst("[.][^.]+$", "");
    }
}