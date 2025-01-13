/**
 * Represents a cardinal direction (NSEW).
 */
public enum CardinalDirection {
    None(-1), North(0), West(1), South(2), East(3);

    /**
     * Backing enum value.
     */
    public final int value;

    private CardinalDirection(int value) {
        this.value = value;
    }

    /**
     * Converts a character (NSEW) to a strongly typed cardinal direction.
     * @param value Any character (not case sensitive)
     * @return Cardinal direction corresponding to {@code value} if valid, or {@code None}
     */
    public static CardinalDirection fromChar(char value) {
        switch (value) {
        case 'N': case 'n': return CardinalDirection.North;
        case 'W': case 'w': return CardinalDirection.West;
        case 'S': case 's': return CardinalDirection.South;
        case 'E': case 'e': return CardinalDirection.East;
        default: return CardinalDirection.None;
        }
    }

    /**
     * Converts a strongly typed cardinal direction to a character (NSEW).
     * @return Character corresponding to {@code value}.
     */
    public char toChar() {
        switch (value) {
        case 0: return 'N';
        case 1: return 'W';
        case 2: return 'S';
        case 3: return 'E';
        default: return '-';
        }
    }
}