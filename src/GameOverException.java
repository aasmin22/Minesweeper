public class GameOverException extends Exception {
    public static final String WIN = "Congrats! You WON";
    public static final String LOSE = "You hit a bomb! Game Over!";

    public GameOverException(String message) {
        super(message);
    }
}
