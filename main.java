import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try {
            AssetManager assets = Game.getAssets();
            assets.load(Paths.get(System.getProperty("user.dir")));
            System.out.println(assets.getDialogue("hi"));
            System.out.println(assets.getAsciiArt("floppy"));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}