
import java.util.EnumSet;
import java.util.Random;

/**
 * Room 1
 * @author Brendan Brassil
 */
public class Region1 implements IRegion {
    private final Random random = new Random();

    private int gnomeHealth = 10;

    private boolean isGnomeHostile = false;

    private boolean isReturning = false;

    public int enter(Game game) {
        if (isReturning) {
            if (game.getState().completed) {
                talkReenterPlus(game);
            }
            else if (isGnomeHostile) {
                talkReenterFight(game);
                fight(game);
            }
            else {
                talkReenter(game);
            }
        }
        else {
            if (game.getState().completed) {
                talkEnterPlus(game);
                giveAllCucumbers(game);
            }
            else {
                talkEnter(game);
                fight(game);
            }
        }
        if (gnomeHealth == 0) {
            talkWinFight(game);
            giveAllCucumbers(game);
        }

        return leave(game);
    }

    private void fight(Game game) {
        while (gnomeHealth > 0) {
            game.getOutput().printf("1) %s%n", game.getAssets().getDialogue("attack"));
            game.getOutput().printf("2) %s%n", game.getAssets().getDialogue("flee"));
            game.getOutput().printf("%s ", game.getAssets().getDialogue("choose"));
            int choice = getChoice(game, 2);
            game.clearOutput();
            switch (choice) {
                case 1:
                    int attack = rollAttack();
                    if (attack > 0) {
                        int damage = rollDamage();
                        game.getOutput().printf(game.getAssets().getDialogue("hit") + "%n", damage);
                        gnomeHealth = Math.max(gnomeHealth - damage, 0);
                    }
                    else {
                        game.getOutput().println(game.getAssets().getDialogue("miss"));
                    }
                    break;
                case 2:
                    return;
            }
        }
    }

    int getChoice(Game game, int count) {
        int choice = game.getInput().nextLine().charAt(0) - '0';
        while (choice < 1 || choice > count) {
            game.getOutput().printf("%s ", game.getAssets().getDialogue("tryAgain"));
            choice = game.getInput().nextLine().charAt(0) - '0';
        }
        return choice;
    }

    private void giveAllCucumbers(Game game) {
        game.getState().giveItem("cucumber", random.nextInt(3) + 4);
    }

    private void giveCucumber(Game game) {
        game.getState().giveItem("cucumber", 1);
    }
    
    private int leave(Game game) {
        EnumSet<CardinalDirection> options = EnumSet.of(CardinalDirection.East, CardinalDirection.South);
        CardinalDirection choice = game.chooseDirection(options);
        switch (choice) {
            case East: return 2;
            case South: return 4;
            default: return -1;
        }
    }

    private int rollAttack() {
        return random.nextInt(10);
    }

    private int rollDamage() {
        return random.nextInt(5) + 3;
    }

    private void talkEnter(Game game) {
        talkGreeting(game);
        int choice = getChoice(game, 3);
        switch (choice) {
        case 1:
            game.getOutput().println(game.getAssets().getDialogue("gnomeCucumbers1"));
            talkCucumbers(game);
            break;
        case 2:
            game.getOutput().println(game.getAssets().getDialogue("gnomeCucumbers2"));
            talkCucumbers(game);
            break;
        case 3:
            game.getOutput().println(game.getAssets().getDialogue("gnomeHostile1"));
            break;
        }
        game.getInput().nextLine();
        game.clearOutput();
        game.getOutput().println(game.getAssets().getAsciiArt("gnome-angry"));
        game.getInput().nextLine();
        game.clearOutput();
    }

    private void talkCucumbers(Game game) {
        game.getOutput().printf("1) %s%n", game.getAssets().getDialogue("gnomeCucumbersR1"));
        game.getOutput().printf("2) %s%n", game.getAssets().getDialogue("gnomeCucumbersR2"));
        game.getOutput().printf("3) %s%n", game.getAssets().getDialogue("gnomeCucumbersR3"));
        int choice = getChoice(game, 3);
        switch (choice) {
        case 1:
        case 2:
            game.getOutput().println(game.getAssets().getDialogue("gnomeHostile1"));
            break;
        case 3:
            giveCucumber(game);
            game.getOutput().println(game.getAssets().getDialogue("gnomeHostile2"));
            break;
        }
    }

    private void talkEnterPlus(Game game) {
        game.getOutput().println(game.getAssets().getDialogue("cucumberEnter+1"));
        game.getOutput().println(game.getAssets().getDialogue("cucumberEnter+2"));
        game.getOutput().println(game.getAssets().getAsciiArt("gnome-angry"));
        game.getInput().nextLine();
        game.clearOutput();
    }

    private void talkGreeting(Game game) {
        game.getOutput().println(game.getAssets().getDialogue("cucumberEnter1"));
        game.getOutput().println(game.getAssets().getDialogue("cucumberEnter2"));
        game.getInput().nextLine();
        game.clearOutput();
        game.getOutput().println(game.getAssets().getAsciiArt("gnome-default"));
        game.getInput().nextLine();
        game.clearOutput();
        game.getOutput().println(game.getAssets().getDialogue("gnomeGreeting"));
        game.getOutput().printf("1) %s%n", game.getAssets().getDialogue("gnomeGreetingR1"));
        game.getOutput().printf("2) %s%n", game.getAssets().getDialogue("gnomeGreetingR2"));
        game.getOutput().printf("3) %s%n", game.getAssets().getDialogue("gnomeGreetingR3"));
    }

    private void talkReenter(Game game) {
        game.getOutput().println(game.getAssets().getDialogue("gnomeReenter2"));
        game.getInput().nextLine();
        game.clearOutput();
    }

    private void talkReenterFight(Game game) {
        game.getOutput().println(game.getAssets().getDialogue("gnomeReenter1"));
        game.getInput().nextLine();
        game.clearOutput();
        game.getOutput().println(game.getAssets().getAsciiArt("gnome-angry"));
        game.getInput().nextLine();
        game.clearOutput();
    }

    private void talkReenterPlus(Game game) {
        game.getOutput().println(game.getAssets().getDialogue("cucumberReenter+"));
        game.getOutput().println(game.getAssets().getAsciiArt("gnome-angry"));
        game.getInput().nextLine();
        game.clearOutput();
    }

    private void talkWinFight(Game game) {
        game.clearOutput();
        game.getOutput().println(game.getAssets().getDialogue("gnomeDefeated"));
        game.getOutput().println(game.getAssets().getDialogue("pickCucumbers"));
        game.getInput().nextLine();
        game.clearOutput();
    }
}