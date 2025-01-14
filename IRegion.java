public interface IRegion {
    /**
     * Enters a room.
     * @param game Game in progress.
     * @return Room number [1,4] when continuing play, -1 when exiting. 
     */
    int enter(Game game);
}