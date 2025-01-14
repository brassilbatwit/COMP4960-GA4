
import java.util.HashMap;

public class GameState {
    /**
     * Whether the game has been completed before.
     */
    public boolean completed = false;

    private final HashMap<String, Integer> items = new HashMap<>();

    /**
     * Counts how many of the specified item have been collected.
     * @param name Item name.
     * @return Number of items 
     */
    public int countItem(String name) {
        return items.getOrDefault(name, 0);
    }

    
    /**
     * Accesses game items.
     * @return Map of [item name: item count].
     */
    public HashMap<String, Integer> getItems() {
        return items;
    }

    /**
     * Adds items.
     * @param name Item name.
     * @param count Number of items to add.
     * @return New count.
     */
    public int giveItem(String name, int count) {
        int newCount = items.getOrDefault(name, 0) + count;
        items.put(name, newCount);
        return newCount;
    }

    /**
     * Removes items.
     * @param name Item name.
     * @param count Number of items to take remove.
     * @return New count.
     */
    public int takeItem(String name, int count) {
        int newCount = Math.max(items.getOrDefault(name, 0) - count, 0);
        items.put(name, newCount);
        return newCount;
    }
}