import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //Runs room system starting at room two.
        HashMap<String, Integer> items = new HashMap<>(); // Dictionary to store items and their quantities
        Region2.Room2(items);
        
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
