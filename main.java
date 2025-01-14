import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //Runs room system starting at room two.
        HashMap<String, Integer> items = new HashMap<>(); // Dictionary to store items and their quantities
        Region2.Room2(items);
    }
}
