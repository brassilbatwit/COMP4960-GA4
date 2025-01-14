import java.nio.file.Path;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        final int ROOM_COUNT = 4;
        Random random = new Random();
        try {
            Game game = new Game(Path.of(System.getProperty("user.dir")), System.in, System.out);
            IRegion[] rooms = new IRegion[] {
                new Region1(),
                new Region2(),
                new Region3(),
                new Region4()
            };
            int roomIndex = random.nextInt(ROOM_COUNT);
            while( roomIndex >= 0) {
                roomIndex = rooms[roomIndex].enter(game) - 1;
            }
            game.getState().completed = true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
